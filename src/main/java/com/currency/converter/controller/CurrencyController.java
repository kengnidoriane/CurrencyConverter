package com.currency.converter.controller;

import com.currency.converter.dto.CurrencyRequest;
import com.currency.converter.dto.CurrencyResponse;
import com.currency.converter.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Operation(
            summary = "Convert currencies",
            description = "Converts a given amount from a source currency to a target currency using real-time exchange rates.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Conversion successful",
                            content = @Content(schema = @Schema(implementation = CurrencyResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error or external API failure", content = @Content)
            }
    )
    @PostMapping("/convert")
    public CurrencyResponse convertCurrency(@Valid @RequestBody CurrencyRequest request) {
        return currencyService.convert(request);
    }
}
