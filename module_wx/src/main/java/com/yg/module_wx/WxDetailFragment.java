package com.yg.module_wx;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yg.component_base.base.BaseFragment;
import com.yg.module_find.R;
import com.yg.module_wx.vm.WxViewModel;

/**
 * Created by Administrator on 2019-03-07.
 */

public class WxDetailFragment extends BaseFragment{


    private WxViewModel mViewModel;

    RecyclerView rv;
    SmartRefreshLayout normalView;

    public WxDetailFragment(WxViewModel mViewModel){
        this.mViewModel = mViewModel;

    }

    public WxDetailFragment(){

    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_wx_detail;
    }

    @Override
    public void initView(Bundle state) {
        rv = getViewById(R.id.rv);
        normalView = getViewById(R.id.normal_view);
    }
}
