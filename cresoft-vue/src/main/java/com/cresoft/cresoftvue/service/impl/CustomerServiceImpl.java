package com.cresoft.cresoftvue.service.impl;

import com.cresoft.cresoftvue.dto.CustomerDto;
import com.cresoft.cresoftvue.model.Customer;
import com.cresoft.cresoftvue.repository.CustomerRepository;
import com.cresoft.cresoftvue.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CustomerDto> read() {
        List<Customer> customers = customerRepository.findAll();

        return StreamSupport.stream(customers.spliterator(), false)
                .map(this::getCustomerDto)
                .collect(Collectors.toList());
    }

    private CustomerDto getCustomerDto(Customer customer){
        return mapper.map(customer, CustomerDto.class);
    }
}
