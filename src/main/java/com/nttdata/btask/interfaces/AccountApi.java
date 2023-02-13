package com.nttdata.btask.interfaces;

import com.nttdata.domain.models.AccountDto;
import com.nttdata.domain.models.ResponseDto;
import com.nttdata.domain.models.ResponseTransferDto;
import com.nttdata.domain.models.TransferDto;
import com.nttdata.infraestructure.entity.Account;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

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
}
