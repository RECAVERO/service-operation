package com.nttdata.application.rest;

import com.nttdata.btask.interfaces.AccountApi;
import com.nttdata.btask.interfaces.OperationService;
import com.nttdata.domain.models.AccountDto;
import com.nttdata.domain.models.OperationDto;
import com.nttdata.domain.models.ResponseDto;
import com.nttdata.infraestructure.entity.Account;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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

    return Response.ok(accountApi.updateAccountAmountDeposit(accountDto)).status(200).build();
  }

  @POST
  @Path("/withdrawal")
  public Response registerWithdrawal(AccountDto accountDto) {

    return Response.ok(accountApi.updateAccountAmountWithdrawal(accountDto)).status(200).build();
  }

}
