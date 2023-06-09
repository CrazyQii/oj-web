package org.example.oj.response;

import java.util.Date;

public class BlogVO {

    private Integer id;

    private String avatar;

    private Integer userId;

    private String name;

    private String title;

    private String tags;

    private Integer bcId;

    private String bcName;

    private Date createTime;

    private Date replyTime;

    private Integer viewCount;

    private Integer replyCount;

    private Integer upCount;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getBcId() {
        return bcId;
    }

    public void setBcId(Integer bcId) {
        this.bcId = bcId;
    }

    public String getBcName() {
        return bcName;
    }

    public void setBcName(String bcName) {
        this.bcName = bcName == null ? null : bcName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getUpCount() {
        return upCount;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null :tags.trim();
    }

    @Override
    public String toString() {
        return "BlogVO{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", tags='" + tags + '\'' +
                ", bcId=" + bcId +
                ", bcName='" + bcName + '\'' +
                ", createTime=" + createTime +
                ", replyTime=" + replyTime +
                ", viewCount=" + viewCount +
                ", replyCount=" + replyCount +
                ", upCount=" + upCount +
                '}';
    }
}
