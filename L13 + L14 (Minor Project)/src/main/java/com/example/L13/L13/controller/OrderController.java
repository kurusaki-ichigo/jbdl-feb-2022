package com.example.L13.L13.controller;

import com.example.L13.L13.commons.ResponseGenerator;
import com.example.L13.L13.models.Orders;
import com.example.L13.L13.requests.CreateBookRequestDto;
import com.example.L13.L13.requests.CreateOrderRequestDto;
import com.example.L13.L13.requests.UpdateOrderRequestDto;
import com.example.L13.L13.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ResponseGenerator responseGenerator;

    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOrder(@Valid @RequestBody CreateOrderRequestDto order){
        log.info("Request Received {} " , order);
        return responseGenerator.generateSuccessResponse(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateOrder(@Valid @RequestBody UpdateOrderRequestDto order){
        log.info("Request Received {} " , order);
        return responseGenerator.generateSuccessResponse(orderService.updateOrder(order), HttpStatus.OK);
    }

    @GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOrder(@RequestParam(value = "orderId") String orderRefence){
        return responseGenerator.generateSuccessResponse(orderService.fetchById(orderRefence), HttpStatus.OK);
    }


    @PostMapping(value = "/issue/order", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> issueBook(@RequestParam(value = "bookId") Integer bookId,
                                           @RequestParam(value = "userId") Integer userId){
        log.info("Request Received {} {} " , bookId, userId);
        return new ResponseEntity<Orders>(orderService.placeOrder(userId, bookId), HttpStatus.CREATED);
    }


}
