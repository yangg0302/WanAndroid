package com.yg.module_home.source;

import com.yg.component_base.base.BaseRepository;
import com.yg.component_base.event.Constants;
import com.yg.component_base.rx.RxSubscriber;
import com.yg.component_base.stateview.StateConstants;
import com.yg.module_home.ApiService;
import com.yg.module_home.bean.BannerBean;
import com.yg.module_home.bean.HomePageArticleBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2019-02-12.
 */

public class HomeRepository extends BaseRepository<ApiService> {



    public void getBanner(){
        addDisposable(apiService.getBannerList()
              .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RxSubscriber<BannerBean>() {

                    @Override
                    public void onSuccess(BannerBean listBaseResp) {
                        sendData(Constants.EVENT_KEY_HOME,Constants.BANNER_TAG, listBaseResp);
                    }
                    @Override
                    public void onFailure(String msg) {
                    }

                    @Override
                    protected void showLoading() {

                    }
                }));
    }

    /**
     * 获取首页 信息
     * @param page
     */

    public void getHomepageListData(int page) {
        addDisposable(apiService.getArticleList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RxSubscriber<HomePageArticleBean>() {
                    @Override
                    protected void onNoNetWork() {
                        showPageState(Constants.EVENT_KEY_HOME_STATE, StateConstants.NET_WORK_STATE);
                    }

                    @Override
                    protected void showLoading() {

                        showPageState(Constants.EVENT_KEY_HOME_STATE, StateConstants.LOADING_STATE);
                    }

                    @Override
                    public void onSuccess(HomePageArticleBean listBaseResp) {
                        sendData(Constants.EVENT_KEY_HOME, Constants.HOME_TAG,listBaseResp);
                        showPageState(Constants.EVENT_KEY_HOME_STATE, StateConstants.SUCCESS_STATE);
                    }
                    @Override
                    public void onFailure(String msg) {
                        showPageState(Constants.EVENT_KEY_HOME_STATE, StateConstants.ERROR_STATE);
                    }
                }));
    }

}
