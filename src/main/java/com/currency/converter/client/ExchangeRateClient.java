package com.currency.converter.client;

import com.currency.converter.exception.CurrencyConversionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
                .toUriString();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("apiKey", apiKey);
            HttpEntity<Void> entity = new HttpEntity<>(headers);
            ResponseEntity<Map> response = restTemplate.exchange(uri, HttpMethod.GET, entity, Map.class);
            System.out.println(">>> Raw API response: " + response.getBody());

            Map<String, Object> body = response.getBody();

            if (body == null || body.get("result") == null) {
                throw new CurrencyConversionException("Invalid response from exchange rate API");
            }
            return ((Number) body.get("result")).doubleValue();
        } catch (Exception e) {
            throw new CurrencyConversionException("Failed to fetch exchange rate: " + e.getMessage());
        }
    }
}
