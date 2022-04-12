package com.example.pagination.Controller;

import com.example.pagination.DTO.Employee;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.sound.midi.MidiChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestTemplateController {
    private final String URI_EMPLOYEE = "http://localhost:8081/employees/";
    private final String URI_EMPLOYEE_ID = "http://localhost:8081/employees/{id}";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/v1/allEmployees")
    public ResponseEntity getAllV1() {
        Employee[] EmployeesArray = restTemplate.getForObject(URI_EMPLOYEE, Employee[].class);
        return new ResponseEntity<>(Arrays.asList(EmployeesArray), HttpStatus.OK);
    }

    @GetMapping("/v1/employees/{id}")
    public ResponseEntity getByIdV1(@PathVariable final Integer id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        Employee employee = restTemplate.getForObject(URI_EMPLOYEE_ID, Employee.class, params);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/v2/allEmployees")
    public ResponseEntity getAllV2() {
        ResponseEntity<Employee[]> responseEntity = restTemplate.getForEntity(URI_EMPLOYEE, Employee[].class);
        return responseEntity;
    }

    @GetMapping("/v2/employess/{id}")
    public ResponseEntity getByIdV2(@PathVariable final Integer id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        ResponseEntity<Employee> responseEntity = restTemplate.getForEntity(URI_EMPLOYEE_ID, Employee.class, params);
        return responseEntity;
    }

    @GetMapping("/v3/allEmployees")
    public ResponseEntity getAllV3() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.GET, entity, Employee.class);
    }

    @GetMapping("/v3/employees/{id}")
    public ResponseEntity getByIdV3(@PathVariable final Integer id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.GET, entity, Employee.class);

    }

    @PostMapping("/v1/employees")
    public ResponseEntity createV1(@RequestBody final Employee newEmployee) {
        Employee createEmployee = restTemplate.postForObject(URI_EMPLOYEE, newEmployee, Employee.class);
        return new ResponseEntity(createEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/v2/employees")
    public ResponseEntity createV2(@RequestBody final Employee newEmployee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<>(newEmployee, httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.POST, entity, Employee.class);
    }

    @PutMapping("/v1/employees/{id}")
    public ResponseEntity updateEmployeeV1(@PathVariable final Integer id, @RequestBody Employee newEmplyee) {
        Map<String, String> params = new HashMap<>();
        params.put("id",String.valueOf(id));
        restTemplate.put(URI_EMPLOYEE_ID, newEmplyee, params);
        return new ResponseEntity("Employee Updaate with id" + id, HttpStatus.OK);
    }

    @PutMapping("/v2/employees/{id}")
    public ResponseEntity updateEmployeeV2(@PathVariable final Integer id, @RequestBody Employee newEmployee)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity <Employee> entity = new HttpEntity<>(newEmployee, httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE + id, HttpMethod.PUT, entity, Employee.class);
    }

    @DeleteMapping("/v2/employees/{id}")
    public ResponseEntity<Employee> deleteV2(@PathVariable final Integer id)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE + id, HttpMethod.DELETE, entity, Employee.class);
    }


}
