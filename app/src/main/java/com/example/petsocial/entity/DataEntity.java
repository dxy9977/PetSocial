package com.example.petsocial.entity;

import java.io.Serializable;
import java.util.List;

public class DataEntity {


    /**
     * success : true
     * data : {"currentPage":1,"pageSize":10,"totalNum":5,"totalPage":0,"items":[{"praise_points":"1","uid":"6","note":"哟哟哟哦哦哟哟啦啦啦啦咯哦摸摸大吧","repliesList":[{"uid":"6","note":"啊啊啊可口可乐了了","comment_time":"1585813460","moments_id":"5","id":"1"},{"uid":"6","note":"5555","comment_time":"1585815575","moments_id":"5","id":"2"}],"reply_num":"1","id":"5","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"img_src":"img/news/DF0BDC2B2CBB4C359E729E56475F429B_IMG_65D42C9FAF979FCE6509C800C6913A.png|img/news/EDF1DFC510E845678524BD5B008995B6_IMG_1168DA1D3256DFC6A7C8A1EFDE15E2.png|","release_time":"1585794970"},{"uid":"6","note":"傅豪杰女朋友！！！！！","repliesList":[],"id":"4","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"img_src":"img/news/61D5A99290B241B69FE2B6785C557A5D_IMG_FA97DB24AA023FEE4D85B49F6A2C7B.jpeg|img/news/916B1610829A4DA5BECC3F0B02392CC1_IMG_7FFC6B3FF0FEED1FA3B4F8CA94F4EF.jpeg|","release_time":"1585753511"},{"uid":"6","note":"哈哈哈","repliesList":[],"id":"3","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"img_src":"img/news/3D7533AC63C547419B213D5636A7321D_IMG_8CAB421CA77DE69D59A74C2F8DDE5F.jpeg|img/news/77AED51374784AA8A778555BDBDB51EA_IMG_4B2F806C593EECE8FC25D959E7DF40.jpeg|img/news/BBEC117360E54CB6BBF44E2354A2FE39_IMG_CAD7229AA629BAC0EFCA39EA14EC5B.jpeg|img/news/8A3E920D20AD4A5598CFDE0A6B63C2D2_IMG_0E236052B57677CCFD46B9BB68ADA6.jpeg|","release_time":"1585751895"},{"uid":"6","note":"测试数据哈哈哈哈","repliesList":[],"id":"2","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"release_time":"1585751539"},{"uid":"6","note":"测试数据哈哈哈哈","repliesList":[],"id":"1","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"release_time":"1585750573"}]}
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
         * totalNum : 5
         * totalPage : 0
         * items : [{"praise_points":"1","uid":"6","note":"哟哟哟哦哦哟哟啦啦啦啦咯哦摸摸大吧","repliesList":[{"uid":"6","note":"啊啊啊可口可乐了了","comment_time":"1585813460","moments_id":"5","id":"1"},{"uid":"6","note":"5555","comment_time":"1585815575","moments_id":"5","id":"2"}],"reply_num":"1","id":"5","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"img_src":"img/news/DF0BDC2B2CBB4C359E729E56475F429B_IMG_65D42C9FAF979FCE6509C800C6913A.png|img/news/EDF1DFC510E845678524BD5B008995B6_IMG_1168DA1D3256DFC6A7C8A1EFDE15E2.png|","release_time":"1585794970"},{"uid":"6","note":"傅豪杰女朋友！！！！！","repliesList":[],"id":"4","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"img_src":"img/news/61D5A99290B241B69FE2B6785C557A5D_IMG_FA97DB24AA023FEE4D85B49F6A2C7B.jpeg|img/news/916B1610829A4DA5BECC3F0B02392CC1_IMG_7FFC6B3FF0FEED1FA3B4F8CA94F4EF.jpeg|","release_time":"1585753511"},{"uid":"6","note":"哈哈哈","repliesList":[],"id":"3","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"img_src":"img/news/3D7533AC63C547419B213D5636A7321D_IMG_8CAB421CA77DE69D59A74C2F8DDE5F.jpeg|img/news/77AED51374784AA8A778555BDBDB51EA_IMG_4B2F806C593EECE8FC25D959E7DF40.jpeg|img/news/BBEC117360E54CB6BBF44E2354A2FE39_IMG_CAD7229AA629BAC0EFCA39EA14EC5B.jpeg|img/news/8A3E920D20AD4A5598CFDE0A6B63C2D2_IMG_0E236052B57677CCFD46B9BB68ADA6.jpeg|","release_time":"1585751895"},{"uid":"6","note":"测试数据哈哈哈哈","repliesList":[],"id":"2","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"release_time":"1585751539"},{"uid":"6","note":"测试数据哈哈哈哈","repliesList":[],"id":"1","user":{"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"},"release_time":"1585750573"}]
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

        public static class ItemsBean implements Serializable {
            /**
             * praise_points : 1
             * uid : 6
             * note : 哟哟哟哦哦哟哟啦啦啦啦咯哦摸摸大吧
             * repliesList : [{"uid":"6","note":"啊啊啊可口可乐了了","comment_time":"1585813460","moments_id":"5","id":"1"},{"uid":"6","note":"5555","comment_time":"1585815575","moments_id":"5","id":"2"}]
             * reply_num : 1
             * id : 5
             * user : {"uid":"6","head_img_src":"img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg","phone":"18368404984","ps_note":"1111","username":"我是傅豪杰","status":"1"}
             * img_src : img/news/DF0BDC2B2CBB4C359E729E56475F429B_IMG_65D42C9FAF979FCE6509C800C6913A.png|img/news/EDF1DFC510E845678524BD5B008995B6_IMG_1168DA1D3256DFC6A7C8A1EFDE15E2.png|
             * release_time : 1585794970
             */

            private String praise_points;
            private String uid;
            private String note;
            private String reply_num;
            private String id;
            private UserBean user;
            private String img_src;
            private String release_time;
            private List<RepliesListBean> repliesList;

            public String getPraise_points() {
                return praise_points;
            }

            public void setPraise_points(String praise_points) {
                this.praise_points = praise_points;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public String getReply_num() {
                return reply_num;
            }

            public void setReply_num(String reply_num) {
                this.reply_num = reply_num;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public String getImg_src() {
                return img_src;
            }

            public void setImg_src(String img_src) {
                this.img_src = img_src;
            }

            public String getRelease_time() {
                return release_time;
            }

            public void setRelease_time(String release_time) {
                this.release_time = release_time;
            }

            public List<RepliesListBean> getRepliesList() {
                return repliesList;
            }

            public void setRepliesList(List<RepliesListBean> repliesList) {
                this.repliesList = repliesList;
            }

            public static class UserBean implements Serializable{
                /**
                 * uid : 6
                 * head_img_src : img/head/CB6FA86FD122403A9D870331E2181D57_IMG_4E6686A706B16E4F754D4DA317E58F.jpeg
                 * phone : 18368404984
                 * ps_note : 1111
                 * username : 我是傅豪杰
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

            public static class RepliesListBean implements Serializable{
                /**
                 * uid : 6
                 * note : 啊啊啊可口可乐了了
                 * comment_time : 1585813460
                 * moments_id : 5
                 * id : 1
                 */

                private String uid;
                private String note;
                private String comment_time;
                private String moments_id;
                private String id;

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
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

                public String getMoments_id() {
                    return moments_id;
                }

                public void setMoments_id(String moments_id) {
                    this.moments_id = moments_id;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }
    }
}
