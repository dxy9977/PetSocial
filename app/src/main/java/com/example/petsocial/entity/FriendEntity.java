package com.example.petsocial.entity;

import java.util.List;

public class FriendEntity {

    /**
     * success : true
     * data : {"currentPage":1,"pageSize":10,"totalNum":1,"totalPage":0,"items":[{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"234324324","username":"我是傅豪杰！！！","status":"1"}]}
     */

    private boolean success;
    private DataBean data;

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
         * currentPage : 1
         * pageSize : 10
         * totalNum : 1
         * totalPage : 0
         * items : [{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"234324324","username":"我是傅豪杰！！！","status":"1"}]
         */

        private int currentPage;
        private int pageSize;
        private int totalNum;
        private int totalPage;
        private List<ItemsBean> items;

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(int totalNum) {
            this.totalNum = totalNum;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * uid : 6
             * head_img_src : img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg
             * phone : 18368404984
             * ps_note : 234324324
             * username : 我是傅豪杰！！！
             * status : 1
             */

            private String uid;
            private String head_img_src;
            private String phone;
            private String ps_note;
            private String username;
            private String status;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getHead_img_src() {
                return head_img_src;
            }

            public void setHead_img_src(String head_img_src) {
                this.head_img_src = head_img_src;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPs_note() {
                return ps_note;
            }

            public void setPs_note(String ps_note) {
                this.ps_note = ps_note;
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
        }
    }
}
