package com.nttdata.btask.interfaces;

import com.nttdata.domain.models.CardDto;
import com.nttdata.domain.models.ResponseListCard;
import com.nttdata.infraestructure.entity.Account;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient
@Path("/card")
public interface CardApi {
  @POST
  @Path("/search/card")
  ResponseListCard searchBalanceCard(CardDto cardDto);
}
