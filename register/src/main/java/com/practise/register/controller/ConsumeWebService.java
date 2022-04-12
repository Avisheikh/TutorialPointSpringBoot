package com.practise.register.controller;

import com.practise.register.dto.TempUserRequest;
import com.practise.register.model.TempUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@RestController
public class ConsumeWebService
{
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/template/get_temp_user", method = RequestMethod.GET)
    public String getTempUserList()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); //Arrays.asList(MediaType.APPLICATION_JSON)
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8080/get_temp_user", HttpMethod.GET, entity, String.class ).getBody();
    }

    @RequestMapping(value = "/template/create_user", method = RequestMethod.POST)
    public String createProducts(@RequestBody TempUser tempUser)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<TempUser> entity = new HttpEntity<TempUser>(tempUser,headers);
        return restTemplate.exchange("http://localhost:8080/create_user",HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/update_user/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") int id, @RequestBody TempUserRequest tempUserRequest)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<TempUserRequest> entity = new HttpEntity<TempUserRequest>(tempUserRequest, headers);
        return restTemplate.exchange("http://localhost:8080/update_user/" + id, HttpMethod.POST,entity, String.class).getBody();
    }

}
