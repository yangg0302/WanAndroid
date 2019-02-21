package com.yg.module_home.adapter;

import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yg.module_home.R;
import com.yg.module_home.adapter.HomePageHolder;
import com.yg.module_home.bean.HomePageArticleBean;



/**
 * rv 适配器
 *

 * @fileName: HomePageAdapter
 * @date: 2018/8/6  16:45
 * @author: ymc
 * @QQ:745612618
 */

public class HomePageAdapter extends BaseQuickAdapter<HomePageArticleBean.DataBean.DatasBean,HomePageHolder> {

    public HomePageAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(HomePageHolder helper, HomePageArticleBean.DataBean.DatasBean item) {
        helper.getView(R.id.tv_tag).setVisibility(View.GONE);
        if (!TextUtils.isEmpty(item.title)) {
            helper.setText(R.id.tv_content, item.title);
        }
        if (!TextUtils.isEmpty(item.author)) {
            helper.setText(R.id.tv_author, item.author);
        }
        if (!TextUtils.isEmpty(item.niceDate)) {
            helper.setText(R.id.tv_time, item.niceDate);
        }
        if (!TextUtils.isEmpty(item.chapterName)) {
            String classifyName = item.superChapterName + " / " + item.chapterName;
            helper.setText(R.id.tv_type, classifyName);
        }
        if (item.superChapterName.contains(mContext.getString(R.string.project))) {
            helper.getView(R.id.tv_tag).setVisibility(View.VISIBLE);
            helper.setText(R.id.tv_tag, mContext.getString(R.string.project));
            helper.setTextColor(R.id.tv_tag,mContext.getResources().getColor(R.color.green));
            helper.setBackgroundRes(R.id.tv_tag,R.drawable.drawable_shape_green);
        } else if (item.superChapterName.contains(mContext.getString(R.string.hot))) {
            helper.getView(R.id.tv_tag).setVisibility(View.VISIBLE);
            helper.setText(R.id.tv_tag, mContext.getString(R.string.hot));
            helper.setTextColor(R.id.tv_tag,mContext.getResources().getColor(R.color.red));
            helper.setBackgroundRes(R.id.tv_tag,R.drawable.drawable_shape_red);
        }
        helper.addOnClickListener(R.id.tv_type);
        helper.addOnClickListener(R.id.image_collect);
        helper.setImageResource(R.id.image_collect, item.collect ? R.drawable.icon_collect : R.drawable.icon_no_collect);
    }
}
