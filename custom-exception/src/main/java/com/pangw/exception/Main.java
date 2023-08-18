package com.pangw.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * <p>
 * <p> Created by wendell on 2023/8/17.
 *
 * @author wendell
 * @version 0.1
 */
public class Main {

    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            m1();
        } catch (Exception e) {
            log.error("exception occurred", e);
        }
    }

    static void m1() {
        try {
            m2();
        } catch (Exception e) {
            throw new TestException("m1", e);
        }
    }

    static void m2() {
        try {
            m3();
        } catch (Exception e) {
            throw new TestException("m2", e);
        }
    }

    static void m3() {
        try {
            m4();
        } catch (Exception e) {
            throw new TestException("m3", e);
        }
    }

    static void m4() {
        try {
            m5();
        } catch (Exception e) {
            throw new TestException("m4", e);
        }
    }

    static void m5() {
        throw new IllegalStateException("m5");
    }

    static void m6() {
        try {

        } catch (Exception e) {
            throw new IllegalStateException("m1");
        }
    }

}
