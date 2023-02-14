package com.nttdata.btask.interfaces;

import com.nttdata.domain.models.*;
import com.nttdata.infraestructure.entity.Account;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient
@Path("/account")
public interface AccountApi {
  @POST
  @Path("/deposit")
  ResponseDto updateAccountAmountDeposit(AccountDto accountDto);

  @POST
  @Path("/withdrawal")
  ResponseDto updateAccountAmountWithdrawal(AccountDto accountDto);

  @POST
  @Path("/transfer")
  ResponseTransferDto registrarTransfer(TransferDto transferDto);

  @POST
  @Path("/search/balance")
  List<Account> searchBalanceCard(CardDto cardDto);

}
