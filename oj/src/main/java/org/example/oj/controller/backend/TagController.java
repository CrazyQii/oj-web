package org.example.oj.controller.backend;

import org.example.oj.entity.Tag;
import org.example.oj.response.RestResponseVO;
import org.example.oj.service.TagService;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller("backendTagController")
@RequestMapping("/backend/tag")
public class TagController {

    @Resource
    private TagService tagService;


    @RequestMapping("/tagListPage")
    public String tagList2Page(HttpServletRequest request) {

        //set data
        request.setAttribute("questionActive", true);
        request.setAttribute("tagActive", true);
        return "backend/problem/problem-tag-list";
    }


    /**
     * 获取标签到页面
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/list2Page")
    @ResponseBody
    public RestResponseVO list2Page(@RequestParam(defaultValue = "") String keyword,
                                    @RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        return tagService.list2Page(pageNum, pageSize, keyword);
    }



    /**
     * 获取所有标签到页面
     *
     * @return
     */
    @RequestMapping("/listAll")
    @ResponseBody
    public RestResponseVO listAll() {
        return tagService.listAll();
    }



    /**
     * 添加-更新tag
     *
     * @param tag
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public RestResponseVO add(Tag tag) {
        if (tag.getId() != null) {
            return tagService.updateById(tag);
        } else {
            return tagService.insert(tag);
        }

    }

    /**
     * 删除tag
     *
     * @param tagId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public RestResponseVO delete(Integer tagId) {
        return tagService.delById(tagId);
    }



    /**
     * getproblem
     *
     * @param tagId
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public RestResponseVO get(Integer tagId) {
        return tagService.getById(tagId);
    }


}
