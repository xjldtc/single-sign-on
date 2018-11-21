package com.newland.framework.common.exception;

/**
 * 远程调用异常(请继承后使用，命名根据具体调用系统命名)
 * @author xjldtc
 *
 */
public class RPCException extends RuntimeException{

  public RPCException(Throwable e){
    super(e);
  }

}
