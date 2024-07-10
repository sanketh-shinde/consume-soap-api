package com.eidiko.consume.client;

import com.eidiko.consume.numberconversion.NumberToDollars;
import com.eidiko.consume.numberconversion.NumberToDollarsResponse;
import com.eidiko.consume.numberconversion.NumberToWords;
import com.eidiko.consume.numberconversion.NumberToWordsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    public NumberToDollarsResponse numberToDollars(BigDecimal number) {
        NumberToDollars numberToDollars = new NumberToDollars();
        numberToDollars.setDNum(number);
        
        WebServiceTemplate template = new WebServiceTemplate(marshaller);
        
        return (NumberToDollarsResponse) template.marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL", numberToDollars,
                new SoapActionCallback("http://www.dataaccess.com/webservicesserver/NumberToDollars"));
    }

    public NumberToWordsResponse numberToWords(BigInteger ubiNum) {
        NumberToWords numberToWords = new NumberToWords();
        numberToWords.setUbiNum(ubiNum);
        
        WebServiceTemplate template = new WebServiceTemplate(marshaller);
        
        return (NumberToWordsResponse) template.marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL", numberToWords,
                new SoapActionCallback("http://www.dataaccess.com/webservicesserver/NumberToWords"));
    }
}
