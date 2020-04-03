package com.example.petsocial.entity;

import java.io.Serializable;

public class LoginEntity implements Serializable {


    /**
     * message : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMzk3MDM0NDkxNyIsInBhc3N3b3JkIjoiMTIzNDU2IiwicGhvbmUiOiIxMzk3MDM0NDkxNyIsImlkIjoyLCJpYXQiOjE1ODUzOTExMTEsImp0aSI6IjM2NDgzNzk2LTAxZmEtNDczNi05OWEyLWYyYTEzYTAzY2RlNyJ9.gc7XIGMV4JTc3VuOCCex3tIuwG3USMmfVoQdLlBu6eY
     * success : true
     * data : {"head_img_src":"","address":"","ps_note":"","uid":"2","regist_time":"Sat Mar 28 11:54:44 CST 2020","phone":"13970344917","interest":"","privacy_status":"","integral":"","wechat_num":"","username":"","status":"","qq_num":""}
     */

    private String message;
    private boolean success;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * head_img_src :
         * address :
         * ps_note :
         * uid : 2
         * regist_time : Sat Mar 28 11:54:44 CST 2020
         * phone : 13970344917
         * interest :
         * privacy_status :
         * integral :
         * wechat_num :
         * username :
         * status :
         * qq_num :
         */

        private String head_img_src;
        private String address;
        private String ps_note;
        private String uid;
        private String regist_time;
        private String phone;
        private String interest;
        private String privacy_status;
        private String integral;
        private String wechat_num;
        private String username;
        private String status;
        private String qq_num;

        public String getHead_img_src() {
            return head_img_src;
        }

        public void setHead_img_src(String head_img_src) {
            this.head_img_src = head_img_src;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPs_note() {
            return ps_note;
        }

        public void setPs_note(String ps_note) {
            this.ps_note = ps_note;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getRegist_time() {
            return regist_time;
        }

        public void setRegist_time(String regist_time) {
            this.regist_time = regist_time;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getInterest() {
            return interest;
        }

        public void setInterest(String interest) {
            this.interest = interest;
        }

        public String getPrivacy_status() {
            return privacy_status;
        }

        public void setPrivacy_status(String privacy_status) {
            this.privacy_status = privacy_status;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getWechat_num() {
            return wechat_num;
        }

        public void setWechat_num(String wechat_num) {
            this.wechat_num = wechat_num;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getQq_num() {
            return qq_num;
        }

        public void setQq_num(String qq_num) {
            this.qq_num = qq_num;
        }
    }
}
