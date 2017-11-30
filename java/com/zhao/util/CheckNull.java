package com.zhao.util;

public class CheckNull {
    public static int returnHandler(Integer integer){
        if(integer==null){
            return -1;
        }
        else
            return integer;
    }
}
