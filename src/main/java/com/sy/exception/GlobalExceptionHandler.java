package com.sy.exception;

import com.sy.model.base.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通用异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult doException(Exception e){
        //1.记录日志
        LOGGER.error(e.getMessage(), e);

        //2.响应JSON
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(BaseResult.CODE_FAILED);
        baseResult.setMsg(BaseResult.MSG_FAILED);
        return baseResult;
    }
}