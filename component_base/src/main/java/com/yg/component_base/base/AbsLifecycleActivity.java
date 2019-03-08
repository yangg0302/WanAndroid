package com.yg.component_base.base;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.yg.component_base.stateview.StateConstants;
import com.yg.component_base.utils.TUtil;


public abstract class AbsLifecycleActivity<T extends AbsViewModel> extends BaseActivity {

    protected T mViewModel;

    public AbsLifecycleActivity() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mViewModel = VMProviders(this, (Class<T>) TUtil.getInstance(this, 0));
        dataObserver();


    }


    protected <T extends ViewModel> T VMProviders(AppCompatActivity fragment, @NonNull Class modelClass) {
        return (T) ViewModelProviders.of(fragment).get(modelClass);

    }

    protected void dataObserver() {

    }




    protected Observer observer = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String state) {
            if (!TextUtils.isEmpty(state)) {
                if (StateConstants.ERROR_STATE.equals(state)) {

                } else if (StateConstants.NET_WORK_STATE.equals(state)) {

                }  else if (StateConstants.SUCCESS_STATE.equals(state)) {

                }else if(StateConstants.LOADING_STATE.equals(state)){

                }
            }
        }
    };
}
