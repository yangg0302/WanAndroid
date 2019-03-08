package com.yg.module_wx.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.yg.component_base.base.AbsViewModel;
import com.yg.module_wx.source.WxRepository;

/**
 * Created by Administrator on 2019-03-07.
 */

public class WxViewModel extends AbsViewModel<WxRepository>{
    public WxViewModel(@NonNull Application application) {
        super(application);
    }

    public void getWxList(){
        mRepository.getWxList();
    }
}
