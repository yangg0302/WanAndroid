package com.yg.component_base.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.yg.component_base.utils.TUtil;


/**
 * @author：tqzhang on 18/7/26 16:15
 */
public class AbsViewModel<T extends BaseRepository> extends AndroidViewModel {


    public T mRepository;

    public AbsViewModel(@NonNull Application application) {
        super(application);
        mRepository = TUtil.getNewInstance(this, 0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mRepository != null) {
            mRepository.unDisposable();
        }
    }

}
