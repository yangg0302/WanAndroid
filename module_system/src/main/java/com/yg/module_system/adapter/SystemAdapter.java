package com.yg.module_system.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yg.module_system.R;
import com.yg.module_system.bean.SystemBean;




public class SystemAdapter extends BaseQuickAdapter<SystemBean.DataBean,BaseViewHolder> {

    public SystemAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, SystemBean.DataBean item) {
        helper.setText(R.id.tv_knowledge_title, item.name);
        StringBuilder sb = new StringBuilder();
        for (SystemBean.DataBean.ChildrenBean childrenBean : item.children) {
            sb.append(childrenBean.name).append("      ");
        }
        helper.setText(R.id.tv_knowledge_content, sb.toString());
    }
}
