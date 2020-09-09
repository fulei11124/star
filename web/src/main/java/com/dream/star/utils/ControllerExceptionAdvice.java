package com.dream.star.utils;

import com.dream.star.model.common.RespEntity;
import com.dream.star.model.enums.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常统一处理
 * @author pro
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RespEntity defultExcepitonHandler(HttpServletRequest request, Exception e) {
        RespEntity res = new RespEntity();
        log.error("请求地址：" + request.getRequestURI() + ", 异常信息：" + e.getMessage(), e);
        if(e instanceof MethodArgumentNotValidException){
            BindingResult br = ((MethodArgumentNotValidException) e).getBindingResult();
            res.fail(StatusCode.ERROR.getCode(), br.getFieldError().getDefaultMessage());
        }else {
            res.fail(StatusCode.ERROR.getCode(), StatusCode.ERROR.getMsg());
        }
        return res;
    }
}
