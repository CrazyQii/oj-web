package org.example.oj.controller.portal;

import com.github.pagehelper.PageInfo;
import org.example.oj.common.ExceptionStatusConst;
import org.example.oj.entity.User;
import org.example.oj.exception.ProblemNotFoundException;
import org.example.oj.response.ProblemDetailVO;
import org.example.oj.response.RestResponseVO;
import org.example.oj.response.TagVO;
import org.example.oj.service.TagService;
import org.example.oj.service.ProblemService;
import javax.annotation.Resource;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/problem")
public class ProblemController {

    @Resource
    private ProblemService problemService;

    @Resource
    private TagService tagService;

    private final Integer SUGGEST_PROBLEM_ROW = 5;

    /**
     * 跳转到题目List页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/problemListPage")
    public String problemListPage(HttpServletRequest request,
                                  @RequestParam(defaultValue = "") String keyword) {
        //题目标签
        List<TagVO> tagList = tagService.listParentVOAll().getData();

        //set data
        request.setAttribute("tagList", tagList);
        request.setAttribute("keyword", keyword);
        request.setAttribute("active2", true);
        return "portal/problem/problem-list";
    }


    /**
     * 题目列表
     *
     * @param userDetails
     * @param pageNum
     * @param pageSize
     * @param sort
     * @param keyword
     * @param level
     * @param tagIds
     * @return
     */
    @RequestMapping("/listProblem2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listProblem2Page(@AuthenticationPrincipal UserDetails userDetails,
                                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                                     @RequestParam(defaultValue = "20") Integer pageSize,
                                                     @RequestParam(defaultValue = "-1", required = false) Integer sort,
                                                     @RequestParam(defaultValue = "", required = false) String keyword,
                                                     @RequestParam(defaultValue = "-1", required = false) Integer level,
                                                     @RequestParam(defaultValue = "",required = false) String tagIds) {
        Integer userId = null;
        if (userDetails != null) {
            userId = ((User) userDetails).getId();
        }
        //公开的题目
        Integer flag = 0;
        return problemService.listProblemVOToPage(userId,flag, sort, keyword, level, tagIds, pageNum, pageSize);
    }


    /**
     * 题目详情页面
     *
     * @param request
     * @param problemId
     * @return
     */
    @RequestMapping("/problemDetailPage")
    public String problemDetailPage(HttpServletRequest request, Integer problemId,Integer compId) {
        ProblemDetailVO detailVO = problemService.getDetailVOById(problemId).getData();
        if (detailVO == null) {
            throw new ProblemNotFoundException(ExceptionStatusConst.PROBLEM_NOT_FOUND_EXP, "未找到该题号的题目");
        }
        //set data
        request.setAttribute("problem", detailVO);
        request.setAttribute("compId", compId);
        request.setAttribute("active2", true);
        return "portal/problem/problem-detail";
    }

    /**
     * 随机返回5道推荐题目
     *
     * @param problemId
     * @return
     */
    @RequestMapping("/suggestProblemList")
    @ResponseBody
    public RestResponseVO<List<ProblemDetailVO>> suggestProblemList(Integer problemId) {
        return problemService.listSuggestProblem(problemId, SUGGEST_PROBLEM_ROW);
    }

    /**
     * 随机选择一道题目
     *
     * @return
     */
    @RequestMapping("/randomProblem")
    public String randomProblem(HttpServletRequest request) {
        RestResponseVO<Integer> serverResponse = problemService.randomProblemId();
        if (serverResponse.isSuccess()) {
            return "redirect:/problem/problemDetailPage?problemId=" + serverResponse.getData();
        } else {
            //fixme
            return "500";
        }
    }


}
