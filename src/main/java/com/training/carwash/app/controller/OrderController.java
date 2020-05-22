package com.training.carwash.app.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.carwash.app.model.OrderPlace;
import com.training.carwash.app.service.OrderService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {


  private Logger log = LoggerFactory.getLogger(this.getClass().getName());

  private OrderService orderService;

  @Autowired
  public OrderController(OrderService OrderService) {
    this.orderService = OrderService;
  }


  @GetMapping("order/")
  public ResponseEntity<List<OrderPlace>> getOrderDetails() {

    List<OrderPlace> list = orderService.getOrderDetails();
    // Order list = bookingService.getOrderDetails();

    log.info("inside method " + list);
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @PostMapping("order/")
  public ResponseEntity<HttpStatus> receiveEvent(@RequestBody OrderPlace Order) {
    boolean processed = true;
    orderService.saveOrderDetails(Order);
    return new ResponseEntity<>(processed ? HttpStatus.OK : HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("order/{id}")
  public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id) {
    boolean processed = true;
    orderService.deleteOrderById(id);
    return new ResponseEntity<>(processed ? HttpStatus.OK : HttpStatus.NO_CONTENT);
  }

  @PutMapping("/order/{id}")
  public ResponseEntity<OrderPlace> updateOrder(@PathVariable("id") long id,
      @RequestBody OrderPlace order) {
    Optional<OrderPlace> orderData = orderService.findById(id);

    if (orderData.isPresent()) {
      OrderPlace _order = orderData.get();

      _order.setAddress(order.getAddress());
      _order.setCarPlateNumber(order.getCarPlateNumber());
      _order.setContactNumber(order.getContactNumber());
      _order.setDescription(order.getDescription());
      _order.setName(order.getName());
      _order.setScheduleDate(order.getScheduleDate());
      _order.setStatus(order.getStatus());

      return new ResponseEntity<>(orderService.updateOrder(_order), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
