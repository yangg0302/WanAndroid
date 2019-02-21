package com.yg.module_home;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yg.component_base.base.AbsLifecycleFragment;
import com.yg.component_base.event.Constants;
import com.yg.component_base.utils.GlideImageLoader;
import com.yg.module_home.adapter.HomePageAdapter;
import com.yg.module_home.bean.BannerBean;
import com.yg.module_home.bean.HomePageArticleBean;
import com.yg.module_home.vm.HomeViewModel;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019-02-12.
 */

public class HomeFragment extends AbsLifecycleFragment<HomeViewModel> implements HomePageAdapter.OnItemClickListener,
        HomePageAdapter.OnItemChildClickListener {



    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
  //  @BindView(R2.id.rv)
    RecyclerView rv;
   // @BindView(R2.id.normal_view)
    SmartRefreshLayout normalView;

    private HomePageAdapter mAdapter;
    private Banner banner;
    private LinearLayout bannerView;


    private List<String> linkList;
    private List<String> imageList;
    private List<String> titleList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(Bundle state) {
        super.initView(state);

        linkList = new ArrayList<>();
        imageList = new ArrayList<>();
        titleList = new ArrayList<>();
        rv = getViewById(R.id.rv);
        normalView = getViewById(R.id.normal_view);

       rv.setLayoutManager(new LinearLayoutManager(activity));
        bannerView = (LinearLayout) getLayoutInflater().inflate(R.layout.view_banner, null);
        banner = bannerView.findViewById(R.id.banner);
        bannerView.removeView(banner);
        bannerView.addView(banner);

        mAdapter = new HomePageAdapter(R.layout.item_homepage);
        mAdapter.addHeaderView(bannerView);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        rv.setAdapter(mAdapter);

        setRefresh();

        mViewModel.getBanner();
        mViewModel.getHomepageList(0);

    }

    @Override
    protected Object getStateEventKey() {
        return Constants.EVENT_KEY_HOME_STATE;
    }

    @Override
    protected void dataObserver() {
        registerObserver(Constants.EVENT_KEY_HOME, Constants.BANNER_TAG, BannerBean.class).observe(this, new Observer<BannerBean>() {
            @Override
            public void onChanged(BannerBean bannerBean) {
                imageList.clear();
                titleList.clear();
                linkList.clear();
                for (BannerBean.DataBean benarBean : bannerBean.data) {
                    imageList.add(benarBean.imagePath);
                    titleList.add(benarBean.title);
                    linkList.add(benarBean.url);
                }

                banner.setImageLoader(new GlideImageLoader())
                        .setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
                        .setImages(imageList)
                        .setBannerAnimation(Transformer.Accordion)
                        .setBannerTitles(titleList)
                        .isAutoPlay(true)
                        .setDelayTime(5000)
                        .setIndicatorGravity(BannerConfig.RIGHT)
                        .start();

             /*   banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        if(!TextUtils.isEmpty(linkList.get(position))){
                            Bundle bundle = new Bundle();
                            bundle.putString(ConstantUtil.HOME_DETAIL_TITLE,titleList.get(position));
                            bundle.putString(ConstantUtil.HOME_DETAIL_PATH,linkList.get(position));
                            JumpUtil.overlay(context, HomeDetailActivity.class,bundle);
                        }
                    }
                });*/
            }
        });


        registerObserver(Constants.EVENT_KEY_HOME, Constants.HOME_TAG, HomePageArticleBean.class).observe(this, new Observer<HomePageArticleBean>() {
            @Override
            public void onChanged(HomePageArticleBean dataBean) {
                if (mViewModel.isRefresh()) {
                    mAdapter.replaceData(dataBean.data.datas);
                } else {

                    mAdapter.addData(dataBean.data.datas);
                }
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
                mViewModel.autoRefresh();

                refreshLayout.finishRefresh(1000);
            }
        });
        normalView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mViewModel.loadMore();
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }




}
