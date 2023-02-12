package com.nttdata.infraestructure.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Operation")
public class Operation extends PanacheEntity {
  private int idTypeAccount;
  private String numberAccount;
  private double amount;
  private int idTypeOperation;
  private String registrationOperation;
  private String created_datetime;
  private String updated_datetime;
  private String active;
}