package com.yg.component_base.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.yg.component_base.event.LiveBus;
import com.yg.component_base.stateview.StateConstants;
import com.yg.component_base.utils.TUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：tqzhang on 18/7/10 16:20
 */
public abstract class AbsLifecycleFragment<T extends AbsViewModel> extends BaseFragment {

    protected T mViewModel;

    protected Object mStateEventKey;

    protected String mStateEventTag;

    private List<Object> events = new ArrayList<>();

    @Override
    public void initView(Bundle state) {
        mViewModel = VMProviders(this, (Class<T>) TUtil.getInstance(this, 0));
        if (null != mViewModel) {
            dataObserver();
            mStateEventKey = getStateEventKey();
            mStateEventTag = getStateEventTag();
            events.add(new StringBuilder((String) mStateEventKey).append(mStateEventTag).toString());
            LiveBus.getDefault().subscribe(mStateEventKey, mStateEventTag).observe(this, observer);
        }
    }

    /**
     * ViewPager +fragment tag
     *
     * @return
     */
    protected String getStateEventTag() {
        return "";
    }

    /**
     * get state page event key
     *
     * @return
     */
    protected abstract Object getStateEventKey();

    /**
     * create ViewModelProviders
     *
     * @return ViewModel
     */
    protected <T extends ViewModel> T VMProviders(BaseFragment
                                                          fragment, @NonNull Class<T> modelClass) {
        return ViewModelProviders.of(fragment).get(modelClass);

    }

    protected void dataObserver() {

    }

    protected <T> MutableLiveData<T> registerObserver(Object eventKey, Class<T> tClass) {

        return registerObserver(eventKey, null, tClass);
    }

    protected <T> MutableLiveData<T> registerObserver(Object eventKey, String tag, Class<T> tClass) {
        String event;
        if (TextUtils.isEmpty(tag)) {
            event = (String) eventKey;
        } else {
            event = eventKey + tag;
        }
        events.add(event);
        return LiveBus.getDefault().subscribe(eventKey, tag, tClass);
    }





    /**
     * 获取网络数据
     */
    protected void getRemoteData() {

    }






    protected Observer observer = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String state) {
            if (!TextUtils.isEmpty(state)) {
                if (StateConstants.ERROR_STATE.equals(state)) {

                } else if (StateConstants.NET_WORK_STATE.equals(state)) {

                } else if (StateConstants.LOADING_STATE.equals(state)) {

                } else if (StateConstants.SUCCESS_STATE.equals(state)) {

                }
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (events != null && events.size() > 0) {
            for (int i = 0; i < events.size(); i++) {
                LiveBus.getDefault().clear(events.get(i));
            }
        }
    }
}
