package io.github.Guimaj.VendasApplication.Controller;

import io.github.Guimaj.VendasApplication.Responses.ApiErrorResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AdviceController{

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrorResponses> handleStatusException(ResponseStatusException e, HttpServletRequest req){
        ApiErrorResponses response = new ApiErrorResponses(e.getStatus().value(),
                                                           e.getStatus(),
                                                           e.getMostSpecificCause().getLocalizedMessage(),
                                                           req.getServletPath(),
                                                           e.getStackTrace());

        return new ResponseEntity<>(response, e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> HandleValidException(MethodArgumentNotValidException e, HttpServletRequest req){
        ApiErrorResponses response = new ApiErrorResponses(400,
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                req.getServletPath(),
                e.getBindingResult());


        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponses> HandleGenericError(Exception e, HttpServletRequest req){
        ApiErrorResponses response = new ApiErrorResponses(500,
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                req.getServletPath(),
                e.getStackTrace());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
