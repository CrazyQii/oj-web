package org.example.oj.exception;

/**
 * 应用异常
 */
public class ApplicationException extends RuntimeException{

    private static final long serialVersionUID = 7138332877482642722L;

    public ApplicationException(int status, String msg) {
        super("状态码:" + status + "  内容:" + msg);
    }
}
