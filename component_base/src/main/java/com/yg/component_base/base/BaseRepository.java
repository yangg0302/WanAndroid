package com.yg.component_base.base;


import com.yg.component_base.event.LiveBus;
import com.yg.component_base.http.HttpHelper;
import com.yg.component_base.utils.TUtil;

/**
 * @author：tqzhang on 18/7/26 16:15
 */
public abstract class BaseRepository<T> extends AbsRepository{



    protected T apiService;     //T ：所在module的ApiService
    private Class<T> entityClass;

    public BaseRepository() {
        if (null == apiService) {
            entityClass = TUtil.getInstance(this,0);//生成 T的class
            apiService = HttpHelper.getInstance().create( entityClass);
        }
    }

    protected void sendData(Object eventKey, Object t) {
        sendData(eventKey, null, t);
    }

    protected void sendData(Object eventKey, String tag, Object t) {
        LiveBus.getDefault().postEvent(eventKey, tag, t);
    }

    protected void showPageState(Object eventKey, String state) {
        sendData(eventKey, state);
    }

    protected void showPageState(Object eventKey, String tag, String state) {
        sendData(eventKey, tag, state);
    }





}
