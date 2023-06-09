package org.example.oj.dao;

import org.example.oj.entity.ProblemResult;
import org.example.oj.response.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProblemResult record);

    int insertSelective(ProblemResult record);

    ProblemResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProblemResult record);

    int updateByPrimaryKey(ProblemResult record);

    List<ProblemResultVO> listProblemResult(@Param("problemId") Integer problemId, @Param("name")String name,
                                            @Param("type") String type, @Param("status") Integer status);

    int countUserIdProblemIdByStatus(@Param("userId")Integer userId,@Param("problemId")Integer problemId,@Param("status")Integer status);

    int countUserIdProblemId(@Param("userId")Integer userId,@Param("problemId")Integer problemId);

    ProblemResultSubmitVO getByRunNum2SubmitVO(String runNum);

    ProblemResultDetailVO getById2DetailVO(Integer problemResultId);

    List<ProblemResultCompetitionVO> listProblemResultCompetitionVO2Page(@Param("compId") Integer compId,@Param("userId") Integer userId);

    Integer getTotalScoreById(@Param("userId") Integer userId,@Param("compId") Integer compId);

    List<ProblemResultRecentVO> listRecentByUserId(@Param("userId") Integer userId, @Param("recentSize")Integer recentSize);

    List<UserProblemRecordVO> listProblemRecord(@Param("userId") Integer userId, @Param("flag") Integer flag);

    int deleteByProblemId(Integer problemId);
}