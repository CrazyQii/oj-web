package org.example.oj.dao;

import org.example.oj.entity.Register;
import org.example.oj.response.RegisterVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);

    Register getByUserIdAndCompId(@Param("userId") Integer userId,@Param("compId") Integer compId);

    int countByUserIdAndCompId(@Param("userId") Integer userId,@Param("compId") Integer compId);

    List<RegisterVO> listRegisterByCompId2Page(Integer compId);

    List<Register> listNoScoreRegisterByCompId(@Param("compId")Integer compId);

    int countByUserId(Integer userId);
}