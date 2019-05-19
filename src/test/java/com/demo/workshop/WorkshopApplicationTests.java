package com.demo.workshop;

import com.demo.workshop.controller.WebController;
import com.demo.workshop.model.Country;
import com.demo.workshop.repositry.CountryNotFoundException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class WorkshopApplicationTests {

	@Test
	public void contextLoads() {
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
            System.out.println("++++++++++++++++ "+e.getMessage());
            throw new CountryNotFoundException("INVALID_COUNTRY_CODE");
        }
	}

}
