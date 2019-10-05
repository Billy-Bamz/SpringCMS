package com.codebamz.startcms.StartCMS.model.common;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RepBase {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timestamp = new Date();

    private Object response;

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
