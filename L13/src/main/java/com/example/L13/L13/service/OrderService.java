package com.example.L13.L13.service;

import com.example.L13.L13.config.UserInfoConfig;
import com.example.L13.L13.exceptions.BookException;
import com.example.L13.L13.exceptions.OrderNotFoundException;
import com.example.L13.L13.exceptions.UserException;
import com.example.L13.L13.models.*;
import com.example.L13.L13.repository.OrderRepository;
import com.example.L13.L13.requests.CreateOrderRequestDto;
import com.example.L13.L13.requests.UpdateOrderRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    UserInfoConfig userInfoConfig;

    public Orders createOrder(CreateOrderRequestDto orderRequestDto){
        return saveOrUpdate(orderRequestDto.toOrder());
    }


    public Orders saveOrUpdate(Orders order){
        return repository.save(order);
    }

    public Orders updateOrder(UpdateOrderRequestDto order){
        Optional<Orders> byOrderReference = repository.findByOrderReference(order.getOrderReferenceId());
        if(byOrderReference.isEmpty()){
            throw new OrderNotFoundException(StatusCode.CHEGG_0N);
        }

        Orders existingOrder = byOrderReference.get();
        existingOrder.setOrderStatus(OrderStatus.valueOf(order.getOrderStatus()));
        existingOrder.setAmount(order.getAmount());

       return saveOrUpdate(existingOrder);
    }

    /**
     *
     * {@link  javax.transaction.Transaction}
     *
     * @param userId
     * @param bookId
     * @return
     */

    public Orders placeOrder(Integer userId , Integer bookId){
        /**
         * issue a book to a user
         * 1) Validate the user - check if user exists
         * 2) validate the book - check if book exists and book is not issued
         * 3) check if student has reached a quota for books (restrict b2b sellers - meesho)
         * 4) Order with a pending state;
         * 5) mark the book unavailable and issue that to the user
         * 6) update the order with success status
         */
        /**
         * 1
         */
        Optional<UserInfo> userInfo = userService.fetchOneById(userId);
        if(userInfo.isEmpty()){
            throw new UserException(StatusCode.CHEGG_02);
        }
        /**
         * 2
         */
        Optional<Book> book =    bookService.findById(bookId);
        if(book.isEmpty()){
            throw new BookException(StatusCode.CHEGG_01);
        }
        Book catalogueBook= book.get();
        if(catalogueBook.getBookStatus() == BookStatus.UNAVAILABLE){
            throw new BookException(StatusCode.CHEGG_03);
        }
        /**
         * 3
         */
        UserInfo transactingUser = userInfo.get();
        if(transactingUser.getOrdersList().size() >= userInfoConfig.getBookQuota()){
            throw new UserException(StatusCode.CHEGG_04);
        }
        /**
         * 4) Order with a pending state;
         * 5) mark the book unavailable and issue that to the user
         * 6) update the order with success status
         * */
        Orders orders = Orders.builder()
                .amount(catalogueBook.getCost())
                .associatedBook(catalogueBook)
                .orderStatus(OrderStatus.PENDING)
                .orderReference(UUID.randomUUID().toString())
                .user(transactingUser)
                .build();
        try {


            saveOrUpdate(orders);

            catalogueBook.setBookStatus(BookStatus.UNAVAILABLE);
            catalogueBook.setUser(transactingUser);
            bookService.saveOrUpdate(catalogueBook);


            orders.setOrderStatus(OrderStatus.SUCCESS);
            saveOrUpdate(orders);

        } catch (Exception exception){
            // rollback
            catalogueBook.setBookStatus(BookStatus.AVAILABLE);
            catalogueBook.setUser(null);
            bookService.saveOrUpdate(catalogueBook);
            // order has been persisted
            if(Objects.nonNull(orders.getId())){
                orders.setOrderStatus(OrderStatus.FAILED);
                saveOrUpdate(orders);
            }
        }
        return  orders;
    }




    public Optional<Orders> fetchById(String orderReference){
        return repository.findByOrderReference(orderReference);
    }



}
