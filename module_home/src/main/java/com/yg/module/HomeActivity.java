package com.yg.module;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.yg.component_base.base.BaseActivity;
import com.yg.module_home.HomeFragment;
import com.yg.module_home.R;
import com.yg.module_home.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {



    @BindView(R2.id.container)
    FrameLayout container;


    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        ButterKnife.bind(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container,HomeFragment.newInstance());
        transaction.commit();


    }
}
