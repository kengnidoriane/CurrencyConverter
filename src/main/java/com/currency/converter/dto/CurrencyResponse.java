package com.currency.converter.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Réponse de conversion de devises")
public class CurrencyResponse {

    @Schema(description = "Devise source", example = "USD")
    private String from;

    @Schema(description = "Devise cible", example = "EUR")
    private String to;

    @Schema(description = "Montant initial", example = "100.0")
    private double amount;

    @Schema(description = "Montant converti", example = "92.5")
    private double convertedAmount;

    // Constructeur, Getters, Setters
    public CurrencyResponse(String from, String to, double amount, double convertedAmount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }
}

