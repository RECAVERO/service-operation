package com.nttdata.btask.interfaces;

import com.nttdata.domain.models.OperationDto;
import com.nttdata.infraestructure.entity.Operation;

public interface OperationService {
  Operation registerDeposit(OperationDto operationDto);
}
