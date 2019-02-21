package com.yg.module_home.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.yg.component_base.base.AbsViewModel;
import com.yg.module_home.source.HomeRepository;

/**
 * Created by Administrator on 2019-02-12.
 */

public class HomeViewModel extends AbsViewModel<HomeRepository> {
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    private boolean isRefresh = true;
    private int currentPage;

    public boolean isRefresh(){
        return  isRefresh;
    }
    public void getBanner(){
        mRepository.getBanner();
    }

    public void getHomepageList(int page){
        mRepository.getHomepageListData(page);
    }

    public void autoRefresh() {
        isRefresh = true;
        currentPage = 0;
        getBanner();
        getHomepageList(currentPage);
    }


    public void loadMore() {
        isRefresh = false;
        currentPage++;
        getHomepageList(currentPage);
    }

}
