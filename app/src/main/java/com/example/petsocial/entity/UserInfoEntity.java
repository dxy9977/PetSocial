package com.example.petsocial.entity;

public class UserInfoEntity {

    /**
     * success : true
     * code : 0
     * data : {"id":1,"name":"傅豪杰","avatar":"","mobile":"123456","wechat":"","gender":1,"flag":3,"add":3,"updateAt":"2019-12-09T14:49:15+08:00","createAt":"2019-12-06T16:03:43+08:00"}
     */

    private boolean success;
    private int code;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 傅豪杰
         * avatar :
         * mobile : 123456
         * wechat :
         * gender : 1
         * flag : 3
         * add : 3
         * updateAt : 2019-12-09T14:49:15+08:00
         * createAt : 2019-12-06T16:03:43+08:00
         */

        private int id;
        private String name;
        private String avatar;
        private String mobile;
        private String wechat;
        private int gender;
        private int flag;
        private int add;
        private String updateAt;
        private String createAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public int getAdd() {
            return add;
        }

        public void setAdd(int add) {
            this.add = add;
        }

        public String getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(String updateAt) {
            this.updateAt = updateAt;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }
    }
}
