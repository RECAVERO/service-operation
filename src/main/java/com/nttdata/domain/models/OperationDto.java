package com.nttdata.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {
  private int id;
  private int idTypeAccount;
  private String numberAccount;
  private double amount;
  private int idTypeOperation;
  private String registrationOperation;
  private String created_datetime;
  private String updated_datetime;
  private String active;
}
