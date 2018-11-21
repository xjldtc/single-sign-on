package com.newland.framework.common.exception;

import org.springframework.http.HttpStatus;

/**
 * 找不到资源异常抛出类
 * @author xjldtc
 *
 */
public class NotFoundException extends AbstractHttpException {

  public NotFoundException(String str) {
    super(str);
    setHttpStatus(HttpStatus.NOT_FOUND);
  }
}
