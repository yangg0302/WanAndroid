package com.yg.module_home.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.yg.module_home.R2;

import butterknife.BindView;

/**
 * @packageName: cn.white.ymc.wanandroidmaster.ui.home.adapter
 * @fileName: HomePageAdaper
 * @date: 2018/8/8  14:31
 * @author: ymc
 * @QQ:745612618
 */

public class HomePageHolder extends BaseViewHolder {

    @BindView(R2.id.tv_author)
    TextView mTvAuthor;
    @BindView(R2.id.tv_type)
    TextView mTvType;
    @BindView(R2.id.tv_content)
    TextView mTvContent;
    @BindView(R2.id.image_collect)
    ImageView mImageCollect;
    @BindView(R2.id.tv_time)
    TextView mTvTime;
    @BindView(R2.id.tv_tag)
    TextView mTvTag;

    public HomePageHolder(View view) {
        super(view);
    }

}
