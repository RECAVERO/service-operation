package com.nttdata.btask.interfaces;

import com.nttdata.domain.models.AccountDto;
import com.nttdata.infraestructure.entity.Account;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/account")
public interface AccountApi {
  @POST
  @Path("/deposit")
  Account updateAccountAmountDeposit(AccountDto accountDto);

  @POST
  @Path("/withdrawal")
  Account updateAccountAmountWithdrawal(AccountDto accountDto);
}
