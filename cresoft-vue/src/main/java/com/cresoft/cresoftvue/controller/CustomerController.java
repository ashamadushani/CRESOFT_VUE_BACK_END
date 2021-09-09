package com.cresoft.cresoftvue.controller;

import com.cresoft.cresoftvue.dto.CustomerDto;
import com.cresoft.cresoftvue.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> read() {
        List<CustomerDto> customerDtoList = customerService.read();

        if(!customerDtoList.isEmpty()){
            return ResponseEntity.ok(customerDtoList);
        }

        return ResponseEntity.noContent().build();
    }
}
