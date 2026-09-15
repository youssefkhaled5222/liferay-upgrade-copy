package com.ejada.telemoney.lovsApi.application;


import com.fasterxml.jackson.annotation.JsonProperty;



public class RequestBodyLovs {
    @JsonProperty("serviceListCode")
    private String codes;

    // Getter and setter for 'ids'
    public String getIds() {
        return codes;
    }

    public void setIds(String codes) {
        this.codes = codes;
    }
}