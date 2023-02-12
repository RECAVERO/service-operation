package com.nttdata.domain.contract;

import com.nttdata.domain.models.OperationDto;
import com.nttdata.infraestructure.entity.Operation;

public interface OperationRepository {
  Operation registerDeposit(OperationDto operationDto);
}
