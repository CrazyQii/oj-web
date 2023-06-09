package org.example.oj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.oj.common.ResponseEnum;
import org.example.oj.common.StringConst;
import org.example.oj.dao.BlogCategoryMapper;
import org.example.oj.entity.BlogCategory;
import org.example.oj.response.RestResponseVO;
import org.example.oj.service.BlogCategoryService;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCategoryImpl implements BlogCategoryService {
    @Resource
    private BlogCategoryMapper blogCategoryMapper;



    @Override
    public RestResponseVO getById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(ResponseEnum.INVALID_REQUEST);
        }
        BlogCategory blogCategory = blogCategoryMapper.selectByPrimaryKey(id);
        return RestResponseVO.createBySuccess(blogCategory);
    }

    @Override
    public RestResponseVO insert(BlogCategory blogCategory) {
        if (blogCategory == null) {
            return RestResponseVO.createByErrorEnum(ResponseEnum.INVALID_REQUEST);
        }
        int effect = blogCategoryMapper.insertSelective(blogCategory);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.ADD_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.ADD_FAIL);
    }

    @Override
    public RestResponseVO delById(Integer id) {
        if (id == null) {
            return RestResponseVO.createByErrorEnum(ResponseEnum.INVALID_REQUEST);
        }
        int effect = blogCategoryMapper.deleteByPrimaryKey(id);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.DEL_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.DEL_FAIL);
    }

    @Override
    public RestResponseVO updateById(BlogCategory blogCategory) {
        if (blogCategory == null) {
            return RestResponseVO.createByErrorEnum(ResponseEnum.INVALID_REQUEST);
        }
        int effect = blogCategoryMapper.updateByPrimaryKeySelective(blogCategory);
        return effect > 0 ? RestResponseVO.createBySuccessMessage(StringConst.UPDATE_SUCCESS)
                : RestResponseVO.createByErrorMessage(StringConst.UPDATE_FAIL);
    }

    @Override
    public RestResponseVO<List<BlogCategory>> listAll() {
        List<BlogCategory> blogCategoryList = blogCategoryMapper.listAll();
        return RestResponseVO.createBySuccess(blogCategoryList);
    }

    @Override
    public RestResponseVO<PageInfo> listBlogCategory2Page(Integer pageNum, Integer pageSize, String keyword) {
        if(pageNum == null || pageSize == null){
            return RestResponseVO.createByErrorEnum(ResponseEnum.INVALID_REQUEST);
        }
        PageHelper.startPage(pageNum,pageSize,true);
        List<BlogCategory> blogCategoryList = blogCategoryMapper.listByKeyWord(keyword);
        PageInfo<BlogCategory> pageInfo = new PageInfo<>(blogCategoryList);
        return RestResponseVO.createBySuccess(pageInfo);

    }
}
