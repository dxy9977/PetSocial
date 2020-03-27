package com.example.petsocial.entity;

import java.util.List;

public class ArticleEntity {

    /**
     * success : false
     * code : 0
     * data : [{"id":1,"name":"\n#  撒旦撒旦阿斯顿 \n-  111111111\n-  121132313\n-  412343423\n\n \n###    我很6\n\n----\n我是傅豪杰","video":0,"createId":0,"createAt":"2019-12-14T13:38:06+08:00"},{"id":2,"name":"表格还是无法优雅显示（单元格无边框，以|分割），但是可以换行了。\n其实此处直接使用WebView来加载转换后的html格式的字符串就可以了。\n\n2.使用js库<把markdown格式转换成html标签格式>  传送门\n\n重要的文件是 marked.js，下载下来放在assets文件夹中，再在assets中新建一个html文件\n\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\n版权声明：本文为CSDN博主「发条兔子_zq」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\n原文链接：https://blog.csdn.net/fatiaotuzi_zq/article/details/42971609","video":1,"createId":0,"createAt":"2019-12-14T16:48:56+08:00"},{"id":3,"name":"```java\nMarkdownView markdownView = (MarkdownView) findViewById(R.id.markdownView);\nmarkdownView.loadMarkdown(\"## Hello Markdown\"); \n```\n**Note**:\nYou could also create the view by code. Below an example of how to set the whole activity to be a MarkdownView by Adding the following to your onCreate method:\n\n```java\n  MarkdownView markdownView = new MarkdownView(this);\n  setContentView(markdownView);\n  markdownView.loadMarkdown(\"## Hello Markdown\"); \n```","video":2,"createId":0,"createAt":"2019-12-14T16:49:22+08:00"},{"id":4,"name":"44444444444444444444444","video":3,"createId":0,"createAt":"2019-12-14T16:49:29+08:00"}]
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
         * name :
         #  撒旦撒旦阿斯顿
         -  111111111
         -  121132313
         -  412343423


         ###    我很6

         ----
         我是傅豪杰
         * video : 0
         * createId : 0
         * createAt : 2019-12-14T13:38:06+08:00
         */

        private int id;
        private String name;
        private int video;
        private int createId;
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

        public int getVideo() {
            return video;
        }

        public void setVideo(int video) {
            this.video = video;
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
    }
}
