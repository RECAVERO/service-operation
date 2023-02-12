package com.nttdata.domain.models;

import com.nttdata.infraestructure.entity.Account;
import com.nttdata.infraestructure.entity.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
  private String status;
  private String message;
  private List<AccountDto> account;
  private List<OperationDto> operation;
}
