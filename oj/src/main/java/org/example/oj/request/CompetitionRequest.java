package org.example.oj.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 比赛请求
 */
@Data
public class CompetitionRequest {

    private Integer id;

    private Integer userId;

    private String name;

    private String title;

    private String content;

    private String htmlContent;

    private String password;

    @DateTimeFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy年MM月dd日 HH:mm")
    private Date endTime;

}
