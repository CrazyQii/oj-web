package org.example.oj.dao;

import org.example.oj.entity.ProblemTag;

public interface ProblemTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProblemTag record);

    int insertSelective(ProblemTag record);

    ProblemTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemTag record);

    int updateByPrimaryKey(ProblemTag record);

    int deleteByProblemId(Integer problemId);

}