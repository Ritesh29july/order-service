package com.training.carwash.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class OrderPlace {

  @Id
  @Column(name = "order_id")
  @GeneratedValue
  private Long orderId;

  private String name;
  private String address;
  private String carPlateNumber;
  private String contactNumber;
  private String scheduleDate;
  private String description;
  private String status;

}
