package com.nttdata.application.mapper;

import com.nttdata.application.exception.OperationException;
import com.nttdata.domain.models.ResponseDto;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class OperationExceptionMapper implements ExceptionMapper<OperationException> {
  @Override
  public Response toResponse(OperationException e) {
    ResponseDto msgException = new ResponseDto();
    msgException.setStatus(String.valueOf(e.getStatus()));
    msgException.setMessage(e.getMessage());
    return Response
        .status(Response.Status.NOT_FOUND)
        .entity(msgException).type(MediaType.APPLICATION_JSON).build();
  }
}
