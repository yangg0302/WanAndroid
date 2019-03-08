package com.yg.component_base.base;

/**
 * Created by Administrator on 2019-03-07.
 */

public   class Resource<T> {
    public final static int SUCCESS = 0;
    public final static int ERROR = 1;
    public final static int LOADING = 2;

    public int status;
    public T data;
    public String msg;
    public   Resource(int status,T data,String msg){
        this.status = status;
        this.data = data;
        this.msg = msg;
    }




    @SuppressWarnings("unchecked")
    public    static <E>  Resource<E>  success(E data){
         return new Resource(Resource.SUCCESS,data,null);
    }
    @SuppressWarnings("unchecked")
    public   static   Resource  error(String msg){
        return new Resource(Resource.ERROR,null,msg);
    }
    @SuppressWarnings("unchecked")
    public   static   Resource  loading(){
        return new Resource(Resource.LOADING,null,null);
    }
}
