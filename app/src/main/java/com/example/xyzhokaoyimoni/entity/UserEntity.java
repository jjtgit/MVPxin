package com.example.xyzhokaoyimoni.entity;

public class UserEntity {
    private String code;
    private String msg;
    public User date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getDate() {
        return date;
    }

    public void setDate(User date) {
        this.date = date;
    }

    class User{
        private String mobile;
        private String uid;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
