package com.nightfarmer.rhino.sample;

import android.view.ViewGroup;

/**
 * Created by zhangfan on 2016/12/14 0014.
 */

public interface RvAdapterIntf {

    RvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    void onBindViewHolder(RvAdapter.ViewHolder holder, int position);

    int getItemCount();

}
