package org.example.oj.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ProblemResultSubmitVO {

    private static final long serialVersionUID = 1198749854563595000L;

    private Integer id;

    private String runNum;

    private Integer problemId;

    private Integer compId;

    private Integer status;

    private Long time;

    private Long memory;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getRunNum() {
        return runNum;
    }

    public void setRunNum(String runNum) {
        this.runNum = runNum;
    }

    @Override
    public String toString() {
        return "ProblemResultSubmitVO{" +
                "id=" + id +
                ", runNum='" + runNum + '\'' +
                ", problemId=" + problemId +
                ", compId=" + compId +
                ", status=" + status +
                ", time=" + time +
                ", memory=" + memory +
                '}';
    }
}
