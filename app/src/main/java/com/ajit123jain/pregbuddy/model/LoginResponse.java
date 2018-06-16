package com.ajit123jain.pregbuddy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
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

    }
 class Apivalue {

    @SerializedName("usergroup")
    @Expose
    private Integer usergroup;
    @SerializedName("session_expires_at")
    @Expose
    private Integer sessionExpiresAt;
    @SerializedName("sessionid")
    @Expose
    private String sessionid;
    @SerializedName("userid")
    @Expose
    private Integer userid;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Integer getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(Integer usergroup) {
        this.usergroup = usergroup;
    }

    public Integer getSessionExpiresAt() {
        return sessionExpiresAt;
    }

    public void setSessionExpiresAt(Integer sessionExpiresAt) {
        this.sessionExpiresAt = sessionExpiresAt;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

