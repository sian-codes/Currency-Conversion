package com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicecurrencyconversion;

import org.springframework.stereotype.Service;

@Service
public class ConversionService {
    float convert (String currencyName, float amount) {
        return amount;
    }
}
