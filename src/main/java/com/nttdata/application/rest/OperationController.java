package com.nttdata.application.rest;

import com.nttdata.btask.interfaces.AccountApi;
import com.nttdata.btask.interfaces.OperationService;
import com.nttdata.domain.models.*;
import com.nttdata.infraestructure.entity.Account;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@Path("/operation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperationController {
  private final OperationService operationService;

  @RestClient
  AccountApi accountApi;

  public OperationController(OperationService operationService) {
    this.operationService = operationService;
  }



  @POST
  @Path("/deposit")
  public Response registerDeposit(AccountDto accountDto) {
    ResponseDto res = accountApi.updateAccountAmountDeposit(accountDto);

    return Response.ok(res).status(200).build();
  }

  @POST
  @Path("/withdrawal")
  public Response registerWithdrawal(AccountDto accountDto) {
    ResponseDto res = accountApi.updateAccountAmountWithdrawal(accountDto);
    return Response.ok(res).status(200).build();
  }

  @POST
  @Path("/transfer")
  @Fallback(fallbackMethod = "fallbackRegisterTransfer")
  public Response registerTransfer(TransferDto transferDto) {
    ResponseTransferDto res = accountApi.registrarTransfer(transferDto);
    return Response.ok(res).status(200).build();
  }

  public Response fallbackRegisterTransfer(TransferDto transferDto) {
    ResponseTransferDto res = new ResponseTransferDto();
    res.setStatus("204");
    res.setMessage("Servicio no disponile intente en una horas nuevamente, porfavor ...");

    return Response.ok(res).status(200).build();
  }
}
