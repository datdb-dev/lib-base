package com.js.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseAdapter<T extends ViewDataBinding> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {

    @NonNull
    @Override
    public BaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        T binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayout(), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return itemCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        T binding;

        public ViewHolder(@NonNull T binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bindData(int position) {
            BaseAdapter.this.bindData(binding, position, this);
            binding.executePendingBindings();
        }
    }

    protected abstract int getLayout();

    protected abstract int itemCount();

    protected abstract void bindData(T binding, int position, ViewHolder holder);
}
