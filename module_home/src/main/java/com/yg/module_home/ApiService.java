package com.yg.module_home;

import com.yg.module_home.bean.BannerBean;
import com.yg.module_home.bean.HomePageArticleBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author tqzhang
 */
public interface ApiService {

   /* @POST(URL.HOME_LIST)
    @FormUrlEncoded
    Observable<HomeListVo> getHomeData(@Field("professionid") String professionId);*/

   // 主页

    @GET("article/list/{page}/json")
    Observable<HomePageArticleBean> getArticleList(@Path("page") int num);

   /* *
     * 登录

    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResp<UserInfo>> login(@Field("username") String username, @Field("password") String password);
*/

    // 注册

   /* @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResp<UserInfo>> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);*/

    /**
     * banner
     */
    @GET("banner/json")
    Observable<BannerBean> getBannerList();

  /*  *//**
     * 收藏文章
     * @param id
     *//*
    @POST("lg/collect/{id}/json")
    Observable<BaseResp> collectArticle(@Path("id") int id);

    *//**
     *  取消收藏文章
     * @param id id
     *//*
    @POST("lg/uncollect_originId/{id}/json")
    Observable<BaseResp> cancelCollectArticle(@Path("id") int id);

    *//**
     *  体系数据
     *//*
    @GET("tree/json")
    Observable<BaseResp<List<SystemBean>>>getSystemList();

    *//**
     * 单个知识体系列表
     *//*
    @GET("article/list/{page}/json")
    Observable<BaseResp<SystemDetailListBean>> getSystemDetailList(@Path("page") int page, @Query("cid") int id);

    *//**
     * 获取项目 列表
     *//*
    @GET("project/tree/json")
    Observable<BaseResp<List<DemoTitleBean>>> getDemoTitleList();

    *//**
     * 获取 项目详细信息列表数据
     *//*
    @GET("project/list/{page}/json")
    Observable<BaseResp<DemoDetailListBean>> getDemoDetailList(@Path("page") int page, @Query("cid") int id);

    *//**
     * 获取 我的收藏列表
     *//*
    @GET("lg/collect/list/{page}/json")
    Observable<BaseResp<CollectBean>> getCollectionList(@Path("page") int page);

    *//**
     * 获取 热门词
     *//*
    @GET("/friend/json")
    Observable<BaseResp<List<HotBean>>> getHotList();

    *//**
     * 获取 搜索热词
     * @return
     *//*
    @GET("/hotkey/json")
    Observable<BaseResp<List<HotKeyBean>>> getHitKeyBean();


    *//**
     *
     * 查询搜索结果
     * @param page
     * @param key
     * @return
     *//*
    @POST("/article/query/{page}/json")
    Observable<BaseResp<HomePageArticleBean>> getSearechResult(@Path("page") int page, @Query("k") String key);

    *//**
     * 获取 微信公众号列表
     * @return
     *//*
    @GET("/wxarticle/chapters/json")
    Observable<BaseResp<List<WxListBean>>> getWXList();

    *//**
     * 获取 微信公众号详细信息列表数据
     *//*
    @GET("wxarticle/list/{id}/{page}/json")
    Observable<BaseResp<WxPublicListBean>> getWXDetailList(@Path("page") int page, @Path("id") int id);*/
}
