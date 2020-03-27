package com.example.petsocial.entity;

import java.io.Serializable;
import java.util.List;

public class NewsEntity implements Serializable {

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
    private List<String> stars;
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

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
