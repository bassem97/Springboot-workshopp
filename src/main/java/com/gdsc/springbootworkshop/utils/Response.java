package com.gdsc.springbootworkshop.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@lombok.Data
public class Response<T> {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private List<T> list;

    private int status;

//    timestamp
    private long timestamp;

    public Response(boolean success,int status, String message, List<T> list) {
        this.success = success;
        this.message = message;
        this.list = list;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }
}
