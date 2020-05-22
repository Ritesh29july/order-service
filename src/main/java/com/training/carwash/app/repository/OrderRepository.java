package com.training.carwash.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.training.carwash.app.model.OrderPlace;

@Repository
public interface OrderRepository extends JpaRepository<OrderPlace, Long> {

}
