package com.nightfarmer.rhino.sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhangfan on 2016/12/14 0014.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    public RvAdapterIntf intf;

    public RvAdapter(RvAdapterIntf intf) {
        this.intf = intf;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return intf.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        intf.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return intf.getItemCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
