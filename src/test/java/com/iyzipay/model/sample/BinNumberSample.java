package com.iyzipay.model.sample;

import com.iyzipay.model.BinNumber;
import com.iyzipay.request.RetrieveBinNumberRequest;
import org.junit.Test;

public class BinNumberSample extends Sample {

    @Test
    public void should_retrieve_bin_number(){
        RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
        request.setBinNumber("454671");
        BinNumber binNumber = BinNumber.retrieve(request, options);
        System.out.println(binNumber);
    }

}
