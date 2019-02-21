package com.yg.module_system.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.yg.component_base.base.AbsViewModel;
import com.yg.module_system.source.SystemRepository;

/**
 * Created by Administrator on 2019-02-15.
 */

public class SystemViewModel extends AbsViewModel<SystemRepository>{
    public SystemViewModel(@NonNull Application application) {
        super(application);
    }

    public void getSystemList(){
        mRepository.getSystemList();
    }
}
