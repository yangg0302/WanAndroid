package com.yg.module_wx.source;

import android.arch.lifecycle.MutableLiveData;

import com.yg.component_base.base.BaseRepository;
import com.yg.component_base.base.Resource;
import com.yg.component_base.rx.RxSubscriber;
import com.yg.module_wx.ApiService;
import com.yg.module_wx.bean.WxListBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2019-02-12.
 */

public class WxRepository extends BaseRepository<ApiService> {


    @SuppressWarnings("unchecked")
    public MutableLiveData<Resource<WxListBean>> getWxList(){
        final MutableLiveData liveData = new MutableLiveData<Resource<WxListBean>>();
        addDisposable(apiService.getWXList()
              .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new RxSubscriber<WxListBean>() {

                    @Override
                    public void onSuccess(WxListBean listBaseResp) {

                        liveData.postValue(Resource.success(listBaseResp));
                    }
                    @Override
                    public void onFailure(String msg) {
                        liveData.postValue(Resource.error(msg));
                    }

                    @Override
                    protected void showLoading() {
                        liveData.setValue(Resource.loading());
                    }
                }));

        return liveData;
    }



}
