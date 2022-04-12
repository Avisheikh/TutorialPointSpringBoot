package com.example.pagination.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumeWebService
{
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/template/products")
    public String getProductList()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        System.out.println(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8081/api/posts/get_post", HttpMethod.GET, entity, String.class).getBody();
    }

}
