package com.qcby.controller;

import java.util.UUID;

/**
 * @author zte
 * @date 2020年5月13日 22:10:04
 */
public class BaseController {

    public static String getId(){
        return UUID.randomUUID().toString();
    }

}
