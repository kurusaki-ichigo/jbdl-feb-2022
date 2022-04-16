package com.example.L13.L13.repository;

import com.example.L13.L13.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Integer> {


    /**
     * JPQL  -- java persistence query language -- this format executes query considering java objects
     * native SQL -- this is same as old sql
     * and
     * Modern way -- this is prety easy
     */

    Optional<Orders> findByOrderReference(String orderRef);



//    @Query(value = "select * from order where order_reference = orderRef", nativeQuery = true)
//    Optional<Order> findOrdersbyOrderRefence(@Param("orderRef") String orderReference);
//
//    @Query(value = "select o from Order o where o.orderReference = :orderRef")
//    Optional<Order> fuindByOrderRef(@Param("orderRef") String orderRef);
}
