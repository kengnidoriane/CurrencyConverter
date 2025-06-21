package com.currency.converter.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Requête de conversion de devises")
public class CurrencyRequest {

    @Schema(description = "Devise source (ex: USD)", example = "USD", required = true)
    private String from;

    @Schema(description = "Devise cible (ex: EUR)", example = "EUR", required = true)
    private String to;

    @Schema(description = "Montant à convertir", example = "100.0", required = true)
    private double amount;

    // Getters & Setters
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from.toUpperCase();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to.toUpperCase();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
