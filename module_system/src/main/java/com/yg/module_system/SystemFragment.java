package com.yg.module_system;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yg.component_base.base.AbsLifecycleFragment;
import com.yg.component_base.event.Constants;
import com.yg.module_system.adapter.SystemAdapter;
import com.yg.module_system.bean.SystemBean;
import com.yg.module_system.vm.SystemViewModel;

/**
 * Created by Administrator on 2019-02-15.
 */

public class SystemFragment extends AbsLifecycleFragment<SystemViewModel>{

    RecyclerView rvSystem;

    SmartRefreshLayout normalView;

    private SystemAdapter madapter;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_system;
    }

    @Override
    protected Object getStateEventKey() {
        return Constants.EVENT_KEY_SYSTETM_STATE;
    }

    @Override
    public void initView(Bundle state) {
        super.initView(state);
        rvSystem = getViewById(R.id.rv_system);
        normalView = getViewById(R.id.normal_view);
        rvSystem.setLayoutManager(new LinearLayoutManager(activity));
        madapter = new SystemAdapter(R.layout.item_system);
        rvSystem.setAdapter(madapter);
        setRefresh();
         mViewModel.getSystemList();

    }

    @Override
    protected void dataObserver() {
        registerObserver(Constants.EVENT_KEY_SYSTETM, SystemBean.class).observe(this, new Observer<SystemBean>() {
            @Override
            public void onChanged(@Nullable SystemBean systemBean) {
                normalView.finishRefresh();
                madapter.replaceData(systemBean.data);
            }
        });


    }

    /**
     * SmartRefreshLayout刷新加载
     */
    private void setRefresh() {
        normalView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mViewModel.getSystemList();
                refreshLayout.autoRefresh();
            }
        });
    }

    public static  SystemFragment newInstance(){
        return  new SystemFragment();
    }
}
