package org.example.oj.dao;

import org.example.oj.entity.TestcaseResult;

import java.util.List;

public interface TestcaseResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestcaseResult record);

    int insertSelective(TestcaseResult record);

    TestcaseResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestcaseResult record);

    int updateByPrimaryKey(TestcaseResult record);

    List<TestcaseResult> listByProblemResultId(Integer problemResultId);

    int deleteByProblemId(Integer problemId);
}