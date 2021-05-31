package com.js.base;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements View.OnClickListener {
    protected T binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayout());
        init();
        initBinding();
        initListener();
        binding.setLifecycleOwner(this);
    }

    @Override
    public void onClick(View view) {
        onClick(view.getId());
    }

    protected abstract int getLayout();

    protected abstract void init();

    protected abstract void initBinding();

    protected abstract void initListener();

    protected abstract void onClick(int id);
}
