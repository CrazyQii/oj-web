package org.example.oj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.oj.common.ResponseEnum;
import org.example.oj.dao.TagMapper;
import org.example.oj.entity.Tag;
import org.example.oj.response.RestResponseVO;
import org.example.oj.common.StringConst;
import org.example.oj.response.TagVO;
import org.example.oj.service.TagService;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 
 * @date 18-12-23 下午3:43
 */
@Service
public class TagImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public RestResponseVO<List<TagVO>> listParentVOAll() {
        List<TagVO> problemCategoryList = tagMapper.listParentVOAll();
        return RestResponseVO.createBySuccess(problemCategoryList);
    }

    @Override
    public RestResponseVO insert(Tag tag) {
        if (tag == null) {
            return RestResponseVO.createByErrorEnum(ResponseEnum.INVALID_REQUEST);
        }
        int effect = tagMapper.insertSelective(tag);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(ResponseEnum.INVALID_REQUEST);
        }
        int effect = tagMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO updateById(Tag tag) {
        if (tag == null) {
            return RestResponseVO.createByErrorEnum(ResponseEnum.INVALID_REQUEST);
        }
        int effect = tagMapper.updateByPrimaryKeySelective(tag);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO getById(Integer tagId) {
        if (tagId == null) {
            return RestResponseVO.createByErrorEnum(ResponseEnum.INVALID_REQUEST);
        }
        return RestResponseVO.createBySuccess(tagMapper.selectByPrimaryKey(tagId));
    }

    @Override
    public RestResponseVO list2Page(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<TagVO> tagList = tagMapper.list2Page(keyword);
        PageInfo<TagVO> pageInfo = new PageInfo<>(tagList);
        pageInfo.getList().stream().forEach( tagVO -> {
            if (tagVO.getId() != null) {
                Tag parentTag = tagMapper.selectByPrimaryKey(tagVO.getParentId());
                tagVO.setParentTag(parentTag);
            }
        });
        return RestResponseVO.createBySuccess(pageInfo);
    }

    @Override
    public RestResponseVO<List<Tag>> listAll() {
        return RestResponseVO.createBySuccess(tagMapper.listAll());
    }
}
