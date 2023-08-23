package com.spring.webflux.service;

import com.spring.webflux.model.CurrencyConversion;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CurrencyService {

    private double getExchangeRate(String sourceCurrency, String targetCurrency) {

        if ("USD".equals(sourceCurrency) && "PEN".equals(targetCurrency)) {
            return 3.75; 
        }
        else if ("PEN".equals(sourceCurrency) && "USD".equals(targetCurrency)){
            return 0.26; 
        }
        else {
            return 1.0; 
        }
    }

    public Mono<CurrencyConversion> performCurrencyConversion(CurrencyConversion conversion) {
        
        double amount;
        String SourceCurrency;
        String TargetCurrency;
        
        amount = conversion.getAmount();
        SourceCurrency = conversion.getSourceCurrency();
        TargetCurrency = conversion.getTargetCurrency();
        
        double exchangeRate = getExchangeRate(SourceCurrency, TargetCurrency);
        double convertedAmount = conversion.getAmount() * exchangeRate;

        //monto, moneda origen, moneda destino
        //monto, monto tipo de cambio, moneda origen, moneda destino, tipo de cambio

        conversion.setConvertedAmount(convertedAmount);
        conversion.setExchangeRate(exchangeRate);

        return Mono.just(conversion);
    }
}