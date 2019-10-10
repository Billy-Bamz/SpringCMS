package com.codebamz.startcms.StartCMS.controller.error;

import com.codebamz.startcms.StartCMS.util.ApiError;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//va a devolver un json por que es un restfull, cuando sea mvc tiene que devolver vistas
@RestControllerAdvice(basePackages = {"com.codebamz.startcms.StartCMS.controller.rest;"})
public class GlobalRestErrorController{

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> getEmptyResultDataAccessException(EmptyResultDataAccessException ex,
                                                                    ServletWebRequest webRequest){
        ApiError apiError = new ApiError();
        apiError.setMessage(ex.getMessage());
        apiError.setMethod(webRequest.getHttpMethod().name());
        apiError.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

}
