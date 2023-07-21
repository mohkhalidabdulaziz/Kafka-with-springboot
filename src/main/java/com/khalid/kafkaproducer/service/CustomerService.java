package com.khalid.kafkaproducer.service;

import com.khalid.kafkaproducer.model.Customer;
import com.khalid.kafkaproducer.util.KafkaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    KafkaTemplate<String, Customer> kafkaTemplate;

    public String add(List<Customer> customerList) {

        if (!customerList.isEmpty()) {
            for (Customer customer: customerList) {
                kafkaTemplate.send(KafkaConstant.TOPIC, customer);
                System.out.println("*********Message Published to customer Topic********");
            }
        }
        return "message published successfully";
    }
}
