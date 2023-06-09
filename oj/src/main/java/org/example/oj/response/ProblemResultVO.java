package org.example.oj.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ProblemResultVO {

    private Integer id;

    private Integer userId;

    private String name;

    private Integer problemId;

    private Integer compId;

    private Integer status;

    private String type;

    private Long time;

    private Long memory;

    private Date createTime;

    private Integer score = 0;

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

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "ProblemResultVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", problemId=" + problemId +
                ", compId=" + compId +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", memory=" + memory +
                ", createTime=" + createTime +
                ", score=" + score +
                '}';
    }
}
