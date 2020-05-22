package com.training.carwash.app.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.carwash.app.model.OrderPlace;
import com.training.carwash.app.repository.OrderRepository;

@Service
@Transactional
public class OrderService {


  private Logger log = LoggerFactory.getLogger(this.getClass().getName());


  private OrderRepository orderRepository;

  @Autowired
  public OrderService(OrderRepository OrderRepository) {
    this.orderRepository = OrderRepository;
  }

  public List<OrderPlace> getOrderDetails() {
    return orderRepository.findAll();
  }

  public void saveOrderDetails(OrderPlace Order) {
    orderRepository.save(Order);
  }

  public void deleteOrderById(long id) {
    orderRepository.deleteById(id);
  }

  public OrderPlace updateOrder(OrderPlace _Order) {

    return orderRepository.save(_Order);
  }

  public Optional<OrderPlace> findById(long id) {
    return orderRepository.findById(id);
  }
}
