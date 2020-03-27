package com.example.petsocial.entity;

import java.util.List;

public class DataEntity {


    /**
     * info : {"id":1,"name":"富豪鸡","avatar":"https://api.atatakai.cn/api/v1/public/file/1575883845435316199.jpg","mobile":"123456","wechat":"","gender":1,"flag":3,"add":3,"updateAt":"2019-12-09T17:30:45+08:00","createAt":"2019-12-06T16:03:43+08:00"}
     * star : 0
     * isWatch : false
     * watch : 0
     * fans : 0
     * news : [{"id":1,"context":"test1111111111111","images":["https://api.atatakai.cn/api/v1/public/file/1575879458749865860.jpeg","https://api.atatakai.cn/api/v1/public/file/1575877163988446602.jpg","https://api.atatakai.cn/api/v1/public/file/1575879458749865860.jpeg"],"mobile":"18368404984","qq":"626369340","wechat":"dxy9977","video":"","star":10,"flag":1,"location":"string","createId":1,"createAt":"2019-12-09T14:22:23+08:00","creator":{"id":1,"name":"富豪鸡","avatar":"https://api.atatakai.cn/api/v1/public/file/1575883845435316199.jpg"},"stars":null},{"id":2,"context":"test1111111111111","images":null,"mobile":"18368404984","qq":"626369340","wechat":"dxy9977","video":"","star":0,"flag":1,"location":"string","createId":1,"createAt":"2019-12-09T14:22:52+08:00","creator":{"id":1,"name":"富豪鸡","avatar":"https://api.atatakai.cn/api/v1/public/file/1575883845435316199.jpg"},"stars":null},{"id":3,"context":"测试111111111","images":null,"mobile":"10086","qq":"123321","wechat":"dxy9977","video":"","star":0,"flag":1,"location":"string","createId":1,"createAt":"2019-12-09T17:56:59+08:00","creator":{"id":1,"name":"富豪鸡","avatar":"https://api.atatakai.cn/api/v1/public/file/1575883845435316199.jpg"},"stars":null}]
     */

    private InfoBean info;
    private int star;
    private boolean isWatch;
    private int watch;
    private int fans;
    private List<NewsBean> news;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public boolean isIsWatch() {
        return isWatch;
    }

    public void setIsWatch(boolean isWatch) {
        this.isWatch = isWatch;
    }

    public int getWatch() {
        return watch;
    }

    public void setWatch(int watch) {
        this.watch = watch;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public List<NewsBean> getNews() {
        return news;
    }

    public void setNews(List<NewsBean> news) {
        this.news = news;
    }

    public static class InfoBean {
        /**
         * id : 1
         * name : 富豪鸡
         * avatar : https://api.atatakai.cn/api/v1/public/file/1575883845435316199.jpg
         * mobile : 123456
         * wechat :
         * gender : 1
         * flag : 3
         * add : 3
         * updateAt : 2019-12-09T17:30:45+08:00
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
         * creator : {"id":1,"name":"富豪鸡","avatar":"https://api.atatakai.cn/api/v1/public/file/1575883845435316199.jpg"}
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
        private CreatorBean creator;
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

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
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

        public static class CreatorBean {
            /**
             * id : 1
             * name : 富豪鸡
             * avatar : https://api.atatakai.cn/api/v1/public/file/1575883845435316199.jpg
             */

            private int id;
            private String name;
            private String avatar;

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
        }
    }
}
