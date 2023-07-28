package com.krishna.service;

import com.krishna.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${paymentapi.url}")
    private String paymentApiUrl;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProduct(int orderId){
        Map<Integer, Product> hm = new HashMap<>();
        hm.put(1, new Product(1, "Laptop", 50000));
        hm.put(2, new Product(2, "Mobile", 40000));
        hm.put(3, new Product(3, "tablet", 30000));
        hm.put(4, new Product(4, "TV", 60000));
        hm.put(5, new Product(5, "Fridge", 150000));
        return hm.get(orderId);
    }

    public String getPaymentStatus(int orderId){
        String url = paymentApiUrl+"paymentStatus/"+orderId;
        return restTemplate.getForObject(url,String.class);
    }
}
