package com.z;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhengqiang on 2017/11/7 21:02.
 * desc:
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = MyException.class)
//    @ResponseBody
//    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
//        ErrorInfo<String> msg = new ErrorInfo<>();
//        msg.setMessage(e.getMessage());
//        msg.setCode(ErrorInfo.ERROR);
//        msg.setData("Some Data");
//        msg.setUrl(req.getRequestURL().toString());
//        return msg;
//    }

    @ExceptionHandler(value = MyException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("/my_error");
        return mav;
    }


}
