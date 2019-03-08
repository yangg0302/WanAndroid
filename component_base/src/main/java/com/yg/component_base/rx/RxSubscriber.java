package com.yg.component_base.rx;


import com.google.gson.JsonParseException;
import com.yg.component_base.base.BaseApp;
import com.yg.component_base.http.ServerException;
import com.yg.component_base.utils.NetworkUtils;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * @author tqzhang
 */
public abstract class RxSubscriber<T> extends DisposableObserver<T> {


    public RxSubscriber() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLoading();
        if (!NetworkUtils.isNetworkAvailable(BaseApp.getIns())) {
            onNoNetWork();
        }
    }

    @Override
    public void onComplete() {

    }



    protected void onNoNetWork() {

    }

    @Override
    public void onError(Throwable e) {
        String message = null;
        if (e instanceof UnknownHostException) {
            message = "没有网络";
        } else if (e instanceof HttpException) {
            message = "网络错误";
        } else if (e instanceof SocketTimeoutException) {
            message = "网络连接超时";
        } else if (e instanceof JsonParseException
                || e instanceof JSONException) {
            message = "解析错误";
        } else if (e instanceof ConnectException) {
            message = "连接失败";
        } else if (e instanceof ServerException) {
            message = ((ServerException) e).errorMsg;
        }
        onFailure(message);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    /**
     * success
     *
     * @param t
     */
    public abstract void onSuccess(T t);

    /**
     * failure
     *
     * @param msg
     */
    public abstract void onFailure(String msg);

    protected abstract void showLoading();
}
