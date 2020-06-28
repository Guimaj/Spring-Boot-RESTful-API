package io.github.Guimaj.VendasApplication.Responses;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ApiErrorResponses {

    private LocalDateTime timeStamp;
    private Integer status;
    private HttpStatus error;
    private String message;
    private String path;
    private List<Errors> listErrors;

    public ApiErrorResponses(Integer status, HttpStatus error, String message, String path, StackTraceElement[] stackTrace) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        setErrors(stackTrace);
    }

    public ApiErrorResponses(Integer status, HttpStatus error, String message, String path, BindingResult result) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        setErrors(result);
    }


    public List<Errors> getListErrors() {
        return listErrors;
    }

    public void setListErrors(List<Errors> listErrors) {
        this.listErrors = listErrors;
    }

    public ApiErrorResponses(Integer status){
        this.status = status;
    }

    private void setErrors(StackTraceElement[] stackTrace){

        this.listErrors = new ArrayList<>();

        StringBuilder desc = new StringBuilder();

        for(StackTraceElement e : stackTrace){
            desc.append(e.getFileName())
                    .append(e.getClassName())
                    .append(e.getMethodName())
                    .append(e.getLineNumber());
        }

        listErrors.add(new Errors(desc.toString()));

    }

    private void setErrors(BindingResult result){

        this.listErrors = new ArrayList<>();

        for(ObjectError err : result.getAllErrors()){
            listErrors.add(new Errors(err.getDefaultMessage()));
        }
    }

}
