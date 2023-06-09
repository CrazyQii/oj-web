package org.example.oj.dao;

import org.example.oj.entity.User;
import org.example.oj.response.RankVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int addSignCount(Integer userId);


    int countByEmail(String email);

    int resetPasswordByEmail(@Param("email") String email, @Param("password") String password);

    List<RankVO> listRankUser(@Param("keyword") String keyword);

    int countByUsername(String username);

    List<User> listUser2Page(@Param("keyword")String keyword);

    int updateUserFlagById(@Param("id")Integer id,@Param("flag") Integer flag);

    int countByUserName(String username);

    int countByPhone(String phone);

    int countByName(String name);

    User getByPhone(String phone);

    User getByName(String name);

    User getEmail(String name);

    User getById(Integer userId);

    User getByUserNameOrEmail(String keyword);

    User getByUserName(String username);

}