package com.currency.converter.service;

import com.currency.converter.client.ExchangeRateClient;
import com.currency.converter.dto.CurrencyRequest;
import com.currency.converter.dto.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    private final ExchangeRateClient exchangeRateClient;

    @Autowired
    public CurrencyService(ExchangeRateClient exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }

    /**
     * Converts an amount from one currency to another by retrieving the exchange rate from an external API.
     *
     * @param request the conversion request containing source currency, target currency, and amount
     * @return a response object containing the original amount and the converted result
     */
    public CurrencyResponse convert(CurrencyRequest request) {
        double rate = exchangeRateClient.getExchangeRate(request.getFrom(), request.getTo());
        double convertedAmount = request.getAmount() * rate;

        return new CurrencyResponse(
                request.getFrom(),
                request.getTo(),
                request.getAmount(),
                convertedAmount
        );
    }
}

