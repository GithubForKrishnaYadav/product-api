package com.krishna.controllers;

import com.krishna.entity.Product;
import com.krishna.entity.ProductDetail;
import com.krishna.service.ProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/{orderId}")
    public ProductDetail getProductDetail(@PathVariable int orderId){
        ProductDetail pd = new ProductDetail();
        Product p = productService.getProduct(orderId);
        pd.setProduct(p);
        pd.setOrderId(orderId);
        String paymentStatus =productService.getPaymentStatus(orderId);
        pd.setPaymentStatus(paymentStatus);
        return pd;
    }
}
