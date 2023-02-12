package com.nttdata.btask.services;

import com.nttdata.btask.interfaces.OperationService;
import com.nttdata.domain.contract.OperationRepository;
import com.nttdata.domain.models.OperationDto;
import com.nttdata.infraestructure.entity.Operation;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperationServiceImpl implements OperationService {
  private final OperationRepository operationRepository;

  public OperationServiceImpl(OperationRepository operationRepository) {
    this.operationRepository = operationRepository;
  }

  @Override
  public Operation registerDeposit(OperationDto operationDto) {
    return operationRepository.registerDeposit(operationDto);
  }
}
