package com.codebamz.startcms.StartCMS.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//Repbse es para devolver respuestas
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepBase {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timestamp = new Date();

    private Object response;

    public RepBase() {
    }

    public RepBase(Object response) {
        this.response = response;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
