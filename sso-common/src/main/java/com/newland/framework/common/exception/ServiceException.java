package com.newland.framework.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 服务错误异常
 * @author xjldtc
 *
 */
public class ServiceException extends AbstractHttpException {

  public ServiceException(String str) {
    super(str);
    setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  public ServiceException(String str, Exception e) {
    super(str, e);
    setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
