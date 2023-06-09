package org.example.oj.response;

import java.io.Serializable;
import java.util.Date;

public class CompetitionDetailVO implements Serializable {

    private static final long serialVersionUID = -2164415105630576696L;

    private Integer id;

    private Integer userId;

    private String avatar;

    private String name;

    private String competitionName;

    private String title;

    private String content;

    private String htmlContent;

    private Boolean secret = false;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;

    private Integer registerCount;

    private Integer competitionStatus;

    private Boolean userRegistered = false;

    private Integer problemCount;

    public CompetitionDetailVO(Integer id, Integer userId, String avatar, String name, String competitionName, String title, String content, String htmlContent,Boolean secret, Date startTime, Date endTime, Date createTime, Date updateTime, Integer registerCount, Integer competitionStatus, Boolean userRegistered, Integer problemCount) {
        this.id = id;
        this.userId = userId;
        this.avatar = avatar;
        this.name = name;
        this.competitionName = competitionName;
        this.title = title;
        this.content = content;
        this.htmlContent = htmlContent;
        this.secret = secret;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.registerCount = registerCount;
        this.competitionStatus = competitionStatus;
        this.userRegistered = userRegistered;
        this.problemCount = problemCount;
    }

    public CompetitionDetailVO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName == null ? null : competitionName.trim();
    }

    public Integer getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(Integer registerCount) {
        this.registerCount = registerCount;
    }

    public Integer getCompetitionStatus() {
        return competitionStatus;
    }

    public void setCompetitionStatus(Integer competitionStatus) {
        this.competitionStatus = competitionStatus;
    }

    public Boolean getSecret() {
        return secret;
    }

    public void setSecret(Boolean secret) {
        this.secret = secret;
    }

    public Boolean isUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(Boolean userRegistered) {
        this.userRegistered = userRegistered;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getProblemCount() {
        return problemCount;
    }

    public void setProblemCount(Integer problemCount) {
        this.problemCount = problemCount;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
    @Override
    public String toString() {
        return "CompetitionDetailVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", secret=" + secret +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", registerCount=" + registerCount +
                ", competitionStatus=" + competitionStatus +
                ", userRegistered=" + userRegistered +
                ", problemCount=" + problemCount +
                '}';
    }
}
