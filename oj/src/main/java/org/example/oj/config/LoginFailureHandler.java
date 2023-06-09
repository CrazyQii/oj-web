package org.example.oj.config;

import org.example.oj.response.RestResponseVO;
import org.example.oj.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录异常处理
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(LoginFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("登录失败,exception:{}",e.getMessage());
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        RestResponseVO<Object> response = RestResponseVO.createByErrorMessage(e.getLocalizedMessage());
        String responseStr = JsonUtil.obj2String(response);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(responseStr);
        writer.flush();
        writer.close();
    }
}
