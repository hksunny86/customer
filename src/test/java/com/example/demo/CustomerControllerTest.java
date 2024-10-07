package com.example.demo;

import com.example.demo.controller.CustomerController;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerServcie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {

    @Mock
    private CustomerServcie customerServcie;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCustomerById() {

        Customer customer = new Customer(1L, "Ali", "ali@gmail.com", "03005648795");
        when(customerServcie.getCustomerById(1L)).thenReturn(Optional.of(customer));

        ResponseEntity<Customer> responseEntity = customerController.getCustomerById(1L);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Ali", responseEntity.getBody().getName());

    }
}
