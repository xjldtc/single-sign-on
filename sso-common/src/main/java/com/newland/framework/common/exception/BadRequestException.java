package com.newland.framework.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 错误请求异常抛出类
 * @author xjldtc
 *
 */
public class BadRequestException extends AbstractHttpException {

  public BadRequestException(String str) {
    super(str);
    setHttpStatus(HttpStatus.BAD_REQUEST);
  }
}
