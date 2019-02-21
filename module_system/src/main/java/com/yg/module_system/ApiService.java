package com.yg.module_system;


import com.yg.module_system.bean.SystemBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author tqzhang
 */
public interface ApiService {

    /**
     *  体系数据
     */
    @GET("tree/json")
    Observable<SystemBean> getSystemList();


}
