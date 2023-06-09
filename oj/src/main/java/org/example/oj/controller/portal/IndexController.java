package org.example.oj.controller.portal;

import com.github.pagehelper.PageInfo;
import org.example.oj.response.BlogVO;
import org.example.oj.response.CompetitionDetailVO;
import org.example.oj.response.RestResponseVO;
import org.example.oj.service.BlogService;
import org.example.oj.service.CompetitionService;
import org.example.oj.service.UserService;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @Resource
    private CompetitionService competitionService;

    @Resource
    private BlogService blogService;

    private static final int ROWS_LAST_COMPETITION = 6;

    private static final int ROWS_LAST_BLOG = 9;

    /**
     * 首页
     *
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request) {

        //近期比赛
        RestResponseVO<List<CompetitionDetailVO>> listLastCompetitionVO = competitionService.listLastCompetitionDetailVO(ROWS_LAST_COMPETITION);

        //本站公告
        RestResponseVO<List<BlogVO>> listNoticeBlogVO = blogService.listNoticeBlogVO(ROWS_LAST_BLOG);

        //最新讨论
        RestResponseVO<List<BlogVO>> listLastBlogVO = blogService.listLastCommentBlogVO(ROWS_LAST_BLOG);

        //set data
        request.setAttribute("nowDate", new Date());
        request.setAttribute("active1", true);
        request.setAttribute("competitionList",listLastCompetitionVO.getData());
        request.setAttribute("lastBlogList",listLastBlogVO.getData());
        request.setAttribute("noticeBlogList",listNoticeBlogVO.getData());
        return "portal/index";
    }

    /**
     * 排行榜
     *
     * @param request
     * @return
     */
    @RequestMapping("/rankPage")
    public String rankPage(HttpServletRequest request) {

        //set data
        request.setAttribute("active5", true);
        return "portal/rank";
    }

    @RequestMapping("/listRank2Page")
    @ResponseBody
    public RestResponseVO<PageInfo> listRank2Page(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "20") Integer pageSize,
                                                  @RequestParam(defaultValue = "", required = false) String keyword) {

        return userService.listRankUser2Page(pageNum, pageSize, keyword);
    }


}
