package com.yg.component_base.http;

/**
 * @author：tqzhang  on 18/4/19 11:08
 */
public class ServerException extends RuntimeException {
    public String errorMsg;

    public int errorCode;

    public ServerException(int code, String message) {
        this.errorCode = code;
        this.errorMsg = message;
    }
}
