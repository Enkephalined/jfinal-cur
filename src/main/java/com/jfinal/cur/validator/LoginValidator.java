package com.jfinal.cur.validator;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.validate.Validator;

import javax.servlet.http.HttpSession;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 23:47
 */
public class LoginValidator extends Validator {
    @Override
    protected void validate(Controller controller) {
        validateRequiredString("username", "usernameMsg", "用户名不能为空");
        validateRequiredString("password", "passwordMsg", "密码不能为空");
    }

    @Override
    protected void handleError(Controller controller) {
        controller.keepPara("username");
        controller.keepPara("password");
        controller.render("/front/index/index.html");
    }
}
