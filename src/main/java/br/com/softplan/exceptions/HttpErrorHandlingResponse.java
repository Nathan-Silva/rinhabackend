package br.com.softplan.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
public class HttpErrorHandlingResponse implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        log.error("Some error occurs {}", e.getMessage());

        if (e instanceof CustomerNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }

        if (e instanceof InsufficientBalanceException) {
            return Response.status(422).entity(e.getMessage()).build();
        }

        if (e instanceof PayloadValidateException) {
            return Response.status(422).entity(e.getMessage()).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal Server Error").build();
    }
}
