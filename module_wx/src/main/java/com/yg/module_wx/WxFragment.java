package com.yg.module_wx;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.yg.component_base.base.AbsLifecycleFragment;
import com.yg.component_base.base.Resource;
import com.yg.module_find.R;
import com.yg.module_wx.bean.WxListBean;
import com.yg.module_wx.vm.WxViewModel;

/**
 * Created by Administrator on 2019-03-07.
 */

public class WxFragment extends AbsLifecycleFragment<WxViewModel>{



    SlidingTabLayout wxTabLayout;
    ViewPager wxViewPager;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_wx;
    }

    public static WxFragment getInstance() {
        return new WxFragment();
    }
    @Override
    public void initView(Bundle state) {
        super.initView(state);
        wxTabLayout =getViewById(R.id.wx_tab_layout);
        wxViewPager = getViewById(R.id.wx_view_pager);
    }

    @Override
    protected Object getStateEventKey() {
        return getClass().getName();
    }


    private void observeWxList(MutableLiveData<Resource<WxListBean>> liveData){
        liveData.observe(this, new Observer<Resource<WxListBean>>() {
            @Override
            public void onChanged(@Nullable Resource<WxListBean> wxListBeanResource) {
                if(wxListBeanResource != null)
                switch (wxListBeanResource.status){
                    case Resource.SUCCESS:
                        break;
                        case Resource.LOADING:
                      break;
                    case Resource.ERROR:
                        break;
                }
            }
        });
    }
}
