package com.nttdata.infraestructure.repository;

import com.nttdata.domain.contract.OperationRepository;
import com.nttdata.domain.models.OperationDto;
import com.nttdata.infraestructure.entity.Account;
import com.nttdata.infraestructure.entity.Operation;
import jakarta.enterprise.context.ApplicationScoped;

import java.text.SimpleDateFormat;
import java.util.Date;
@ApplicationScoped
public class OperationRepositoryImpl implements OperationRepository {
  @Override
  public Operation registerDeposit(OperationDto operationDto) {
    Operation operation = new Operation();
    operation.setIdTypeAccount(operationDto.getIdTypeAccount());
    operation.setNumberAccount(operationDto.getNumberAccount());
    operation.setAmount(operationDto.getAmount());
    operation.setIdTypeOperation(operationDto.getIdTypeOperation());
    operation.setRegistrationOperation(this.getDateNow());
    operation.setCreated_datetime(this.getDateNow());
    operation.setUpdated_datetime(this.getDateNow());
    operation.setActive("S");
    operation.persist();
    return operation;
  }

  private static String getDateNow(){
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return formatter.format(date).toString();
  }
}
