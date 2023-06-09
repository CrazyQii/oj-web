package com.oj.judge.service.impl;

import com.oj.judge.response.ServerResponse;
import com.oj.judge.common.JudgeStatusEnum;
import com.oj.judge.dao.UserMapper;
import com.oj.judge.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public ServerResponse addCount(Integer userId, JudgeStatusEnum statusConst) {
        int effect = 0;
        if (Objects.equals(JudgeStatusEnum.ACCEPTED, statusConst)) {
            effect = userMapper.addAcCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.TIME_LIMIT_EXCEEDED, statusConst)) {
            effect = userMapper.addTleCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.PRESENTATION_ERROR, statusConst)) {
            effect = userMapper.addPeCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.MEMORY_LIMIT_EXCEEDED, statusConst)) {
            effect = userMapper.addMeCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.COMPILE_ERROR, statusConst)) {
            effect = userMapper.addCeCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.RUNTIME_ERROR, statusConst)) {
            effect = userMapper.addReCount(userId);

        } else if (Objects.equals(JudgeStatusEnum.WRONG_ANSWER, statusConst)) {
            effect = userMapper.addWaCount(userId);
        }
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();

    }

    @Override
    public ServerResponse addSolutionCountAndGoldCountAndRating(Integer userId, Integer problemId, Integer goldCount, Integer ratingCount) {
        int effect = userMapper.addSolutionCountAndGoldCountAndRating(userId, problemId, goldCount, ratingCount);
        return effect > 0 ? ServerResponse.success() : ServerResponse.fail();
    }
}
