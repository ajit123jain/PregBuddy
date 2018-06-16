package com.ajit123jain.pregbuddy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResgisterResponse {
    @SerializedName("totalcount")
    @Expose
    private Object totalcount;
    @SerializedName("count")
    @Expose
    private Object count;
    @SerializedName("apiresult")
    @Expose
    private Integer apiresult;
    @SerializedName("apimessage")
    @Expose
    private String apimessage;
    @SerializedName("apivalue")
    @Expose
    private Apivalue apivalue;

    public Object getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Object totalcount) {
        this.totalcount = totalcount;
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = count;
    }

    public Integer getApiresult() {
        return apiresult;
    }

    public void setApiresult(Integer apiresult) {
        this.apiresult = apiresult;
    }

    public String getApimessage() {
        return apimessage;
    }

    public void setApimessage(String apimessage) {
        this.apimessage = apimessage;
    }

    public Apivalue getApivalue() {
        return apivalue;
    }

    public void setApivalue(Apivalue apivalue) {
        this.apivalue = apivalue;
    }

    public class Apivalue {

        @SerializedName("TOKEN")
        @Expose
        private String tOKEN;

        public String getTOKEN() {
            return tOKEN;
        }

        public void setTOKEN(String tOKEN) {
            this.tOKEN = tOKEN;
        }

    }
}
