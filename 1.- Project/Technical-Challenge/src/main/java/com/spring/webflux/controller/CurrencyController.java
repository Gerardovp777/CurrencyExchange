package com.spring.webflux.controller;

import com.spring.webflux.model.CurrencyConversion;
import com.spring.webflux.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;
        
    @PostMapping("/convert")
    public Mono<CurrencyConversion> convertCurrency(@RequestBody CurrencyConversion conversion) {
        return currencyService.performCurrencyConversion(conversion);
    }
}
