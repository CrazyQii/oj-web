package org.example.oj.controller.portal;

import org.example.oj.common.ExceptionStatusConst;
import org.example.oj.entity.Blog;
import org.example.oj.entity.Problem;
import org.example.oj.entity.User;
import org.example.oj.exception.UserUnAuthorizedException;
import org.example.oj.request.UserRequest;
import org.example.oj.response.ProblemResultRecentVO;
import org.example.oj.response.RestResponseVO;
import org.example.oj.exception.UserNotFoundException;
import org.example.oj.response.UserDetailVO;
import org.example.oj.service.FileService;
import org.example.oj.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Resource
    private FileService fileService;

    @Resource
    private UserService userService;

    private static final Integer RECENT_BLOG_SIZE = 5;

    private static final Integer RECENT_PROBLEM_RESULT_SIZE = 5;

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage() {
        return "portal/login";
    }

    /**
     * 用户注册页面
     *
     * @return
     */
    @RequestMapping("/registerPage")
    public String registerPage() {
        return "portal/registerSubmit";
    }

    /**
     * 忘记密码页面
     *
     * @return
     */
    @RequestMapping("/forgetPage")
    public String forgetPage() {
        return "portal/forget";
    }


    /**
     * 注册提交页面
     *
     * @return
     */
    @RequestMapping("/registerSubmitPage")
    public String registerSubmitPage(String token, String email, HttpServletRequest request) {
//        request.setAttribute("token", token);
//        request.setAttribute("email", email);
        return "portal/registerSubmit";
    }

    /**
     * 忘记密码提交修改页面
     *
     * @return
     */
    @RequestMapping("/forgetSubmitPage")
    public String forgetSubmitPage(String token, String email, HttpServletRequest request) {
//        request.setAttribute("token", token);
//        request.setAttribute("email", email);
        return "portal/forgetSubmit";
    }


//    /**
//     * 发送注册邮件
//     *
//     * @param email
//     * @return
//     */
//    @RequestMapping("/sendRegisterEmail")
//    @ResponseBody
//    public RestResponseVO sendRegisterEmail(String email) {
//        return userService.sendRegisterEmail(email);
//    }

//    /**
//     * 发送忘记密码验证邮件
//     *
//     * @param email
//     * @return
//     */
//    @RequestMapping("/sendForgetEmail")
//    @ResponseBody
//    public RestResponseVO sendForgetEmail(String email) {
//        return userService.sendForgetEmail(email);
//    }


    /**
     * 忘记密码提交修改
     *
     * @param token
     * @param password
     * @param email
     * @return
     */
    @RequestMapping("/forgetSubmitProcess")
    @ResponseBody
    public RestResponseVO forgetSubmitProcess(String token, String email, String password) {
        return userService.forgetRestPassword(token, email, password);
    }


    /**
     * 提交注册
     *
     * @param token
     * @param request
     * @return
     */
    @RequestMapping("/registerSubmitProcess")
    @ResponseBody
    public RestResponseVO registerSubmitProcess(UserRequest request) {
        return userService.register(request);
    }


    /**
     * 用户主页
     *
     * @return
     */
    @RequestMapping("/mainPage")
    public String mainPage(Integer userId, HttpServletRequest request) {
        RestResponseVO<UserDetailVO> response = userService.getById(userId);
        if (response.isSuccess() && response.getData() != null) {
            List<Problem> problemList = userService.listAllSolveProblemByUserId(userId).getData();
            List<Blog> blogList = userService.listRecentBlog(userId,RECENT_BLOG_SIZE).getData();
            List<ProblemResultRecentVO> problemResultList = userService.listRecentProblem(userId, RECENT_PROBLEM_RESULT_SIZE).getData();

            request.setAttribute("user", response.getData());
            request.setAttribute("solveProblemList", problemList);
            request.setAttribute("blogList", blogList);
            request.setAttribute("problemResultList", problemResultList);
        } else {
            throw new UserNotFoundException(ExceptionStatusConst.USER_NOT_FOUND_EXP, "用户未找到");
        }
        return "portal/user/main";
    }

    /**
     * 个人信息修改页面
     *
     * @return
     */
    @RequestMapping("/profilePage")
    @PreAuthorize("authentication.name.equals(#username)")//只能操作自己
    public String profilePage(HttpServletRequest request,@AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails == null) {
            throw new UserUnAuthorizedException(ExceptionStatusConst.USER_UN_AUTHORIZE_EXP, "请先登录");
        }
        Integer userId = ((User) userDetails).getId();
        RestResponseVO<UserDetailVO> responseVO = userService.getById(userId);

        //setData
        request.setAttribute("user",responseVO.getData());
        return "portal/user/profile";
    }


    /**
     * 获取用户的做题记录
     * @param userId
     * @param request
     * @param flag 0一年 1这个月
     * @return
     */
    @RequestMapping("/listProblemRecord")
    @ResponseBody
    public RestResponseVO listProblemRecord(Integer userId, HttpServletRequest request,@RequestParam(defaultValue = "0") Integer flag) {
        //todo
        userService.listProblemRecord (userId,flag);
        return null;
    }



    @RequestMapping("/updateBase")
    @ResponseBody
    public RestResponseVO saveBase(@RequestParam(required = false,name = "file") MultipartFile file,UserRequest userRequest) {
        if(file != null && !file.isEmpty()){
            RestResponseVO<String> uploadImage = fileService.uploadImage(file,userRequest.getUsername());
            if(uploadImage.isSuccess()){
                userRequest.setAvatar(uploadImage.getData());
            }
        }
        return userService.updateById(userRequest);
    }

    @RequestMapping("/updateSecurity")
    @ResponseBody
    public RestResponseVO updateSecurity(Integer id,String email,String oldPassword,String password) {
        return userService.updateSecurity(id,email,oldPassword,password);
    }



}
