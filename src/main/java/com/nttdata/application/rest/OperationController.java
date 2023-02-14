package com.nttdata.application.rest;

import com.nttdata.application.exception.OperationException;
import com.nttdata.btask.interfaces.AccountApi;
import com.nttdata.btask.interfaces.CardApi;
import com.nttdata.btask.interfaces.OperationService;
import com.nttdata.domain.models.*;
import com.nttdata.infraestructure.entity.Account;
import com.nttdata.infraestructure.entity.Card;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/operation")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperationController {
  private final OperationService operationService;

  @RestClient
  AccountApi accountApi;
  @RestClient
  CardApi cardApi;

  public OperationController(OperationService operationService) {
    this.operationService = operationService;
  }



  @POST
  @Path("/deposit")
  @Fallback(fallbackMethod = "fallbackRegisterDeposit")
  public Response registerDeposit(AccountDto accountDto) {
    ResponseDto res = accountApi.updateAccountAmountDeposit(accountDto);

    return Response.ok(res).status(200).build();
  }

  public Response fallbackRegisterDeposit(AccountDto accountDto) {
    return Response.ok(this.getMenssage("204", "Servicio no disponile intente en una horas nuevamente, porfavor ...")).build();
  }

  @POST
  @Path("/withdrawal")
  @Fallback(fallbackMethod = "fallbackRegisterWithdrawal")
  public Response registerWithdrawal(AccountDto accountDto) {
    ResponseDto res = accountApi.updateAccountAmountWithdrawal(accountDto);
    return Response.ok(res).status(200).build();
  }
  public Response fallbackRegisterWithdrawal(AccountDto accountDto) {
    return Response.ok(this.getMenssage("204", "Servicio no disponile intente en una horas nuevamente, porfavor ...")).build();
  }
  @POST
  @Path("/transfer")
  @Fallback(fallbackMethod = "fallbackRegisterTransfer")
  public Response registerTransfer(TransferDto transferDto) {
    if(transferDto.getNumberAccountOrigin() == null){
      return Response.ok(this.getMenssage("204", "Tiene que agregar una cuenta origen")).build();
    }
    if(transferDto.getNumberAccountOrigin().equals("")){
      return Response.ok(this.getMenssage("204", "Tiene que agregar una cuenta origen")).build();
    }

    if(transferDto.getNumberAccountDestination() == null){
      return Response.ok(this.getMenssage("204", "Tiene que agregar una cuenta Destino")).build();
    }

    if(transferDto.getNumberAccountDestination().equals("") ){
      return Response.ok(this.getMenssage("204", "Tiene que agregar una cuenta Destino")).build();
    }

    ResponseTransferDto res = accountApi.registrarTransfer(transferDto);

    return Response.ok(res).status(200).build();
  }

  public Response fallbackRegisterTransfer(TransferDto transferDto) {
    ResponseTransferDto res = new ResponseTransferDto();
    res.setStatus("204");
    res.setMessage("Servicio no disponile intente en una horas nuevamente, porfavor ...");
    return Response.ok(res).build();
  }

  @POST
  @Path("/search/balance")
  public Response searchBalanceByAccount(CardDto cardDto) {
    ResponseListCard listCard = cardApi.searchBalanceCard(cardDto);

        if(listCard.getStatus().equals("200")){
          List<Account> res = accountApi.searchBalanceCard(cardDto);
          return Response.ok(res).status(200).build();
        }else{
          return Response.status(204).build();
        }

  }

  @POST
  @Path("/withdrawal/principal")
  public Response withdrawalAccountPrincipal(CardDto cardDto) {
    ResponseListCard listCard = cardApi.searchBalanceCard(cardDto);
    AccountDto accountDto = new AccountDto();
    accountDto.setNumberAccount(cardDto.getNumberAccountAssociated());
    accountDto.setAmount(cardDto.getAmount());

    if(listCard.getStatus().equals("200")){
      ResponseDto res = accountApi.updateAccountAmountWithdrawal(accountDto);
      return Response.ok(res).status(200).build();
    }else{
      return Response.status(204).build();
    }

  }








  private ResponseDto getMenssage(String status, String msg){
    ResponseDto responseDto = new ResponseDto();
    responseDto.setStatus(status);
    responseDto.setMessage(msg);
    return responseDto;
  }
}
