package com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
    CurrencyConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    private final ConversionService conversionService;

    String [] Currency = {"GBP", "USD", "EUR"};

    @GetMapping(value="/conversion/{from}/to/{too}/{amount}")
    public ResponseEntity<ConversionResponse> conversionEndpoint(@PathVariable String from, @PathVariable String too, @PathVariable double amount) {
        Amount fromAmount = new Amount(Currency[0], 100.00);
        Amount toAmount = new Amount(Currency[1],34.00);
        ConversionResponse conversionResponse = new ConversionResponse(fromAmount, toAmount);
        return new ResponseEntity<>(conversionResponse, HttpStatusCode.valueOf(200));
    }

    public static class ConversionResponse {
         private Amount from;
         private Amount too;

        public ConversionResponse(Amount from, Amount too) {
            this.from = from;
            this.too = too;
        }

        public Amount getFrom() {
            return from;
        }

        public Amount getToo() {
            return too;
        }
    }

    public static class Amount {
        private String currency;
        private Double value;

        public Amount(String currency, Double value) {
            this.currency = currency;
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public Double getAmount() {
            return value;
        }
    }
}
