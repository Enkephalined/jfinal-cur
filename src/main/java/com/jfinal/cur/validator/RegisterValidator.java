package com.jfinal.cur.validator;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.validate.Validator;

import javax.servlet.http.HttpSession;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 23:27
 */
@Path("/front")
public class RegisterValidator extends Validator {
    @Override
    protected void validate(Controller controller) {
        validateRegex("username", "^[_|a-zA-Z0-9]{4,10}$", "usernameMsg", "用户名格式错误");
        validateRegex("password", "^[_|a-zA-Z0-9]{4,10}$", "passwordMsg", "密码格式错误");
        validateRequiredString("username", "usernameMsg", "用户名不可为空");
        validateRequiredString("password", "passwordMsg", "密码不可为空");
    }

    @Override
    protected void handleError(Controller controller) {
        controller.keepPara("username");
        controller.keepPara("password");
        controller.render("/front/index/register.html");
    }
}
