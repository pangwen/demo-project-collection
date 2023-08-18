package com.pangw.exception;

/**
 * Description: test exception
 *
 * <p>
 * Create by wendell on 2023/8/17.
 * <p>
 *
 * @author wendell
 * @version 0.1
 */

public class TestException extends RuntimeException{
    public TestException(String message) {
        super(message);
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
