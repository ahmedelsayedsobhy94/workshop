/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.workshop.controller;

import com.demo.workshop.model.Country;
import com.demo.workshop.repositry.CountryNotFoundException;
import static com.google.common.base.Predicates.equalTo;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ahmed.Elsayed
 */
public class WebControllerTest {

    public WebControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByCode method, of class WebController.
     */
    @Test
    public void testFindByCode() throws ClientProtocolException, IOException {
        try{
        String code = "bha";
       String rightCode = "BHR";
        HttpUriRequest request = new HttpGet("http://localhost:8080/workshop/" + code);
        HttpUriRequest rightRequest = new HttpGet("http://localhost:8080/workshop/" + rightCode);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        HttpResponse rightHttpResponse = HttpClientBuilder.create().build().execute(rightRequest);
        assertEquals( httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        assertEquals( rightHttpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        
        }catch(Exception e){
            throw new CountryNotFoundException("INVALID_COUNTRY_CODE");
        }
        }

}
