package com.example.petsocial.entity;

import java.util.List;

public class CommentEntity {

    /**
     * success : false
     * code : 0
     * data : [{"id":1,"conetext":"哈哈哈哈","createId":1,"newsId":1,"fromId":0,"star":0,"createAt":"2019-12-17T20:40:40+08:00","Creator":{"id":1,"name":"富豪鸡","avatar":"https://api.atatakai.cn/api/v1/public/file/1576417420058988177.jpeg"},"From":{"id":0,"name":"","avatar":""}},{"id":2,"conetext":"嘻嘻嘻","createId":1,"newsId":1,"fromId":0,"star":0,"createAt":"2019-12-17T20:40:55+08:00","Creator":{"id":1,"name":"富豪鸡","avatar":"https://api.atatakai.cn/api/v1/public/file/1576417420058988177.jpeg"},"From":{"id":0,"name":"","avatar":""}}]
     */

    private boolean success;
    private int code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * conetext : 哈哈哈哈
         * createId : 1
         * newsId : 1
         * fromId : 0
         * star : 0
         * createAt : 2019-12-17T20:40:40+08:00
         * Creator : {"id":1,"name":"富豪鸡","avatar":"https://api.atatakai.cn/api/v1/public/file/1576417420058988177.jpeg"}
         * From : {"id":0,"name":"","avatar":""}
         */

        private int id;
        private String conetext;
        private int createId;
        private int newsId;
        private int fromId;
        private int star;
        private String createAt;
        private CreatorBean Creator;
        private FromBean From;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getConetext() {
            return conetext;
        }

        public void setConetext(String conetext) {
            this.conetext = conetext;
        }

        public int getCreateId() {
            return createId;
        }

        public void setCreateId(int createId) {
            this.createId = createId;
        }

        public int getNewsId() {
            return newsId;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public int getFromId() {
            return fromId;
        }

        public void setFromId(int fromId) {
            this.fromId = fromId;
        }

        public int getStar() {
            return star;
        }

        public void setStar(int star) {
            this.star = star;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public CreatorBean getCreator() {
            return Creator;
        }

        public void setCreator(CreatorBean Creator) {
            this.Creator = Creator;
        }

        public FromBean getFrom() {
            return From;
        }

        public void setFrom(FromBean From) {
            this.From = From;
        }

        public static class CreatorBean {
            /**
             * id : 1
             * name : 富豪鸡
             * avatar : https://api.atatakai.cn/api/v1/public/file/1576417420058988177.jpeg
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

        public static class FromBean {
            /**
             * id : 0
             * name :
             * avatar :
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
