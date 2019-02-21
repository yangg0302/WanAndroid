package com.yg.module_system.source;

import com.yg.component_base.base.BaseRepository;
import com.yg.component_base.event.Constants;
import com.yg.component_base.rx.RxSubscriber;
import com.yg.component_base.stateview.StateConstants;
import com.yg.module_system.ApiService;
import com.yg.module_system.bean.SystemBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2019-02-15.
 */

public class SystemRepository extends BaseRepository<ApiService>{

     public void getSystemList(){
         addDisposable(apiService.getSystemList()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeWith(new RxSubscriber<SystemBean>() {
                     @Override
                     protected void onNoNetWork() {
                         showPageState(Constants.EVENT_KEY_SYSTETM_STATE, StateConstants.NET_WORK_STATE);
                     }
                     @Override
                     public void onSuccess(SystemBean bean) {
                         sendData(Constants.EVENT_KEY_SYSTETM,bean);
                         showPageState(Constants.EVENT_KEY_SYSTETM_STATE, StateConstants.SUCCESS_STATE);
                     }
                     @Override
                     public void onFailure(String msg) {
                         showPageState(Constants.EVENT_KEY_SYSTETM_STATE, StateConstants.ERROR_STATE);
                     }
                 }));
     }

}
