package com.currency.converter.client;

import com.currency.converter.exception.CurrencyConversionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class ExchangeRateClient {

    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${exchange.api.base-url}")
    private String baseUrl;

    @Value("${exchange.api.key}")
    private String apiKey;

    public double getExchangeRate(String from, String to) {
        String uri = UriComponentsBuilder
                .fromHttpUrl(baseUrl + "/convert")
                .queryParam("from", from)
                .queryParam("to", to)
                .queryParam("amount", 1)
                .queryParam("access_token", apiKey)
                .build()
                .toUriString();

        try {
            Map<String, Object> response = restTemplate.getForObject(uri, Map.class);
            if (response == null || response.get("result") == null) {
                throw new CurrencyConversionException("Invalid response from exchange rate API");
            }
            return ((Number) response.get("result")).doubleValue();
        } catch (Exception e) {
            throw new CurrencyConversionException("Failed to fetch exchange rate: " + e.getMessage());
        }
    }
}
