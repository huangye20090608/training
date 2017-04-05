package com.huangye.training.web.controller;

import com.huangye.training.common.LoginContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangye on 2017/3/30.
 */
public class BaseController {
    public ModelAndView toVm(String viewName) {
        return toVm(viewName, null);
    }

    @SuppressWarnings("unchecked")
    public ModelAndView toVm(String viewName, Object data) {
        ModelAndView mav = new ModelAndView(viewName);
        if (data != null) {
            if (data instanceof Map) {
                mav.addAllObjects((Map<String, ?>) data);
            } else {
                mav.addObject("data", data);
            }
        }
        return mav;
    }

    public Map<String, String> getLoginUser() {
        LoginContext context = LoginContext.getLoginContext();
        Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("PIN", context.getPin());
        userMap.put("NAME", context.getNick());
        return userMap;
    }
}
