package com.example.petsocial.entity;

import java.util.List;

public class CommentEntity {


    /**
     * success : true
     * data : [{"id":1,"moments_id":5,"uid":6,"note":"啊啊啊可口可乐了了","comment_time":"2020-04-02T07:44:20.000+0000","user":{"uid":null,"username":"我是傅豪杰！！！","password":null,"phone":null,"interest":null,"regist_time":null,"ps_note":null,"privacy_status":null,"head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","integral":null,"status":null,"qq_num":null,"wechat_num":null,"address":null}},{"id":2,"moments_id":5,"uid":6,"note":"5555","comment_time":"2020-04-02T08:19:35.000+0000","user":{"uid":null,"username":"我是傅豪杰！！！","password":null,"phone":null,"interest":null,"regist_time":null,"ps_note":null,"privacy_status":null,"head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","integral":null,"status":null,"qq_num":null,"wechat_num":null,"address":null}}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * moments_id : 5
         * uid : 6
         * note : 啊啊啊可口可乐了了
         * comment_time : 2020-04-02T07:44:20.000+0000
         * user : {"uid":null,"username":"我是傅豪杰！！！","password":null,"phone":null,"interest":null,"regist_time":null,"ps_note":null,"privacy_status":null,"head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","integral":null,"status":null,"qq_num":null,"wechat_num":null,"address":null}
         */

        private int id;
        private int moments_id;
        private int uid;
        private String note;
        private String comment_time;
        private UserBean user;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMoments_id() {
            return moments_id;
        }

        public void setMoments_id(int moments_id) {
            this.moments_id = moments_id;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getComment_time() {
            return comment_time;
        }

        public void setComment_time(String comment_time) {
            this.comment_time = comment_time;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * uid : null
             * username : 我是傅豪杰！！！
             * password : null
             * phone : null
             * interest : null
             * regist_time : null
             * ps_note : null
             * privacy_status : null
             * head_img_src : img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg
             * integral : null
             * status : null
             * qq_num : null
             * wechat_num : null
             * address : null
             */

            private String uid;
            private String username;
            private String password;
            private String phone;
            private String interest;
            private String regist_time;
            private String ps_note;
            private String privacy_status;
            private String head_img_src;
            private String integral;
            private String status;
            private String qq_num;
            private String wechat_num;
            private String address;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
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

            public String getRegist_time() {
                return regist_time;
            }

            public void setRegist_time(String regist_time) {
                this.regist_time = regist_time;
            }

            public String getPs_note() {
                return ps_note;
            }

            public void setPs_note(String ps_note) {
                this.ps_note = ps_note;
            }

            public String getPrivacy_status() {
                return privacy_status;
            }

            public void setPrivacy_status(String privacy_status) {
                this.privacy_status = privacy_status;
            }

            public String getHead_img_src() {
                return head_img_src;
            }

            public void setHead_img_src(String head_img_src) {
                this.head_img_src = head_img_src;
            }

            public String getIntegral() {
                return integral;
            }

            public void setIntegral(String integral) {
                this.integral = integral;
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

            public String getWechat_num() {
                return wechat_num;
            }

            public void setWechat_num(String wechat_num) {
                this.wechat_num = wechat_num;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }
        }
    }
}
