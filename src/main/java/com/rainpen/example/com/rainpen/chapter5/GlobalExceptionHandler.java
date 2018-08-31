package com.rainpen.example.com.rainpen.chapter5;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 * 通过@ControllerAdvice注解定义统一的异常处理类，而不是在每个Controller中逐个定义
 * @ExceptionHandler 用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
 * 然后在@ControllerAdvice类中，根据抛出的具体Exception类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理。
 * @author laiyup-S9644
 * @date 2018年05月31日
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * 而当我们要实现RESTful API时，返回的错误是JSON格式的数据，而不是HTML页面
     * 本质上，只需在@ExceptionHandler之后加入@ResponseBody，就能让处理函数return的内容转换为JSON格式。
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = JsonException.class)
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, Exception e){
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(request.getRequestURL().toString());
        return r;
    }

}
