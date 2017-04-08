package com.example.abhay.applayout;

import android.app.Application;

/**
 * Created by abhay on 07/04/17.
 */

public class cus_msg_elements extends Application {
    private String msg;
    private int id;

    public cus_msg_elements(){}

    public cus_msg_elements(String msg)
    {
        this.id=1;
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
