package com.example.observermode;

import android.util.Log;

public class WeixinUser implements MyObserver {

    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        Log.e("buder", message);
    }
}
