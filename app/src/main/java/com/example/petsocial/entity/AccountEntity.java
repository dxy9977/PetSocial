package com.example.petsocial.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AccountEntity {
    @Id(autoincrement = true)
    private long id;
    private String name;
    private String avatar;
    private String mobile;
    private String wechat;
    private int gender;
    private int flag;
    private int add;
    private String updateAt;
    private String createAt;
    @Generated(hash = 919006303)
    public AccountEntity(long id, String name, String avatar, String mobile,
            String wechat, int gender, int flag, int add, String updateAt,
            String createAt) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.mobile = mobile;
        this.wechat = wechat;
        this.gender = gender;
        this.flag = flag;
        this.add = add;
        this.updateAt = updateAt;
        this.createAt = createAt;
    }
    @Generated(hash = 40307897)
    public AccountEntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getWechat() {
        return this.wechat;
    }
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    public int getGender() {
        return this.gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public int getFlag() {
        return this.flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public int getAdd() {
        return this.add;
    }
    public void setAdd(int add) {
        this.add = add;
    }
    public String getUpdateAt() {
        return this.updateAt;
    }
    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
    public String getCreateAt() {
        return this.createAt;
    }
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
