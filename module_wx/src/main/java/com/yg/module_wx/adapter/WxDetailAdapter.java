package com.yg.module_wx.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yg.module_find.R;
import com.yg.module_wx.bean.WxPublicListBean;

import java.util.List;



/**
 *  微信公众号文章 adapter
 *
 * @packageName: cn.white.ymc.wanandroidmaster.ui.mine.minelist.wx.wxpublic
 * @fileName: WxDetailAdapter
 * @date: 2018/10/25  11:23
 * @author: ymc
 * @QQ:745612618
 */

public class WxDetailAdapter extends BaseQuickAdapter<WxPublicListBean.DataBean.DatasBean,BaseViewHolder> {

    public WxDetailAdapter(int layoutResId, @Nullable List<WxPublicListBean.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WxPublicListBean.DataBean.DatasBean item) {
        helper.getView(R.id.tv_tag).setVisibility(View.GONE);
        if (!TextUtils.isEmpty(item.getTitle())) {
            helper.setText(R.id.tv_content, item.title);
        }
        if (!TextUtils.isEmpty(item.getAuthor())) {
            helper.setText(R.id.tv_author, item.author);
        }
        if (!TextUtils.isEmpty(item.niceDate)) {
            helper.setText(R.id.tv_time, item.niceDate);
        }
        if (!TextUtils.isEmpty(item.chapterName)) {
            helper.setText(R.id.tv_type, item.chapterName);
        }
        helper.setImageResource(R.id.image_collect, item.collect ? R.drawable.icon_collect : R.drawable.icon_no_collect);

    }
}
