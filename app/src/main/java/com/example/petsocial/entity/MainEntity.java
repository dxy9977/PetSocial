package com.example.petsocial.entity;

import java.util.List;

public class MainEntity {


    /**
     * success : true
     * code : 0
     * data : {"id":1,"images":null,"horns":null,"updateAt":"2019-12-09T09:50:48+08:00","createAt":"2019-12-09T09:50:48+08:00","news":[{"id":1,"context":"test1111111111111","images":["https://api.atatakai.cn/api/v1/public/file/1575879458749865860.jpeg","https://api.atatakai.cn/api/v1/public/file/1575877163988446602.jpg","https://api.atatakai.cn/api/v1/public/file/1575879458749865860.jpeg"],"mobile":"18368404984","qq":"626369340","wechat":"dxy9977","video":"","star":10,"flag":1,"location":"string","createId":1,"createAt":"2019-12-09T14:22:23+08:00","stars":null},{"id":2,"context":"test1111111111111","images":null,"mobile":"18368404984","qq":"626369340","wechat":"dxy9977","video":"","star":0,"flag":1,"location":"string","createId":1,"createAt":"2019-12-09T14:22:52+08:00","stars":null},{"id":3,"context":"测试111111111","images":null,"mobile":"10086","qq":"123321","wechat":"dxy9977","video":"","star":0,"flag":1,"location":"string","createId":1,"createAt":"2019-12-09T17:56:59+08:00","stars":null}]}
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
         * images : null
         * horns : null
         * updateAt : 2019-12-09T09:50:48+08:00
         * createAt : 2019-12-09T09:50:48+08:00
         * news : [{"id":1,"context":"test1111111111111","images":["https://api.atatakai.cn/api/v1/public/file/1575879458749865860.jpeg","https://api.atatakai.cn/api/v1/public/file/1575877163988446602.jpg","https://api.atatakai.cn/api/v1/public/file/1575879458749865860.jpeg"],"mobile":"18368404984","qq":"626369340","wechat":"dxy9977","video":"","star":10,"flag":1,"location":"string","createId":1,"createAt":"2019-12-09T14:22:23+08:00","stars":null},{"id":2,"context":"test1111111111111","images":null,"mobile":"18368404984","qq":"626369340","wechat":"dxy9977","video":"","star":0,"flag":1,"location":"string","createId":1,"createAt":"2019-12-09T14:22:52+08:00","stars":null},{"id":3,"context":"测试111111111","images":null,"mobile":"10086","qq":"123321","wechat":"dxy9977","video":"","star":0,"flag":1,"location":"string","createId":1,"createAt":"2019-12-09T17:56:59+08:00","stars":null}]
         */

        private int id;
        private List<String> images;
        private List<String> horns;
        private String updateAt;
        private String createAt;
        private List<NewsBean> news;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<String> getHorns() {
            return horns;
        }

        public void setHorns(List<String> horns) {
            this.horns = horns;
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

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public static class NewsBean {
            /**
             * id : 1
             * context : test1111111111111
             * images : ["https://api.atatakai.cn/api/v1/public/file/1575879458749865860.jpeg","https://api.atatakai.cn/api/v1/public/file/1575877163988446602.jpg","https://api.atatakai.cn/api/v1/public/file/1575879458749865860.jpeg"]
             * mobile : 18368404984
             * qq : 626369340
             * wechat : dxy9977
             * video :
             * star : 10
             * flag : 1
             * location : string
             * createId : 1
             * createAt : 2019-12-09T14:22:23+08:00
             * stars : null
             */

            private int id;
            private String context;
            private String mobile;
            private String qq;
            private String wechat;
            private String video;
            private int star;
            private int flag;
            private String location;
            private int createId;
            private String createAt;
            private Object stars;
            private List<String> images;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getContext() {
                return context;
            }

            public void setContext(String context) {
                this.context = context;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }

            public String getWechat() {
                return wechat;
            }

            public void setWechat(String wechat) {
                this.wechat = wechat;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public int getStar() {
                return star;
            }

            public void setStar(int star) {
                this.star = star;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public int getCreateId() {
                return createId;
            }

            public void setCreateId(int createId) {
                this.createId = createId;
            }

            public String getCreateAt() {
                return createAt;
            }

            public void setCreateAt(String createAt) {
                this.createAt = createAt;
            }

            public Object getStars() {
                return stars;
            }

            public void setStars(Object stars) {
                this.stars = stars;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }
    }
}
