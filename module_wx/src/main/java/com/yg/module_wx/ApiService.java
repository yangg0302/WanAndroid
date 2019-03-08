package com.yg.module_wx;

import com.yg.module_wx.bean.WxListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author tqzhang
 */
public interface ApiService {


    /**
     * 获取 微信公众号列表
     * @return
     */
    @GET("/wxarticle/chapters/json")
    Observable<WxListBean> getWXList();

}
