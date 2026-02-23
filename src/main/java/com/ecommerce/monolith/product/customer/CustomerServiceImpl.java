package com.ecommerce.monolith.customer.service;

import com.ecommerce.monolith.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements com.ecommerce.monolith.customer.service.CustomerService {

    private final CustomerRepository customerRepository; //

    @Override
    public boolean existsById(Long id) {

        return customerRepository.existsById(id);
    }
}