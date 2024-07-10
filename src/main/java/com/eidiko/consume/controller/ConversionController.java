package com.eidiko.consume.controller;

import com.eidiko.consume.client.SoapClient;
import com.eidiko.consume.numberconversion.NumberToDollars;
import com.eidiko.consume.numberconversion.NumberToDollarsResponse;
import com.eidiko.consume.numberconversion.NumberToWords;
import com.eidiko.consume.numberconversion.NumberToWordsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    @Autowired
    private SoapClient client;

    @GetMapping("/numberToWords")
    public NumberToWordsResponse numberToWords(@RequestBody NumberToWords words) {
        return client.numberToWords(words.getUbiNum());
    }

    @GetMapping("/numberToDollars")
    public NumberToDollarsResponse numberToDollars(@RequestBody NumberToDollars dollars) {
        return client.numberToDollars(dollars.getDNum());
    }
}
