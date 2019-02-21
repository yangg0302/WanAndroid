package com.yg.module_main;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R2.id.toolbar_common)
    Toolbar toolbarCommon;
    @BindView(R2.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R2.id.float_button)
    FloatingActionButton floatButton;
    @BindView(R2.id.navigation)
    BottomNavigationView navigation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // 将item 设置为不移动
        BottomNavigationViewHelper.disableShiftMode(navigation);

        // 设置为蓝色背景
        floatButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.theme)));

    }


}
