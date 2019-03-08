package com.yg.component_base.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author：tqzhang on 18/3/12 19:22
 */

public abstract class BaseActivity extends AppCompatActivity {

    public final  String TAG =getClass().getName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        initViews(savedInstanceState);
    }



    /**
     * 设置布局layout
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    public abstract void initViews(Bundle savedInstanceState);





    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}

