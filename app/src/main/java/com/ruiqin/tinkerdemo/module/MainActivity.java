package com.ruiqin.tinkerdemo.module;

import android.os.Bundle;

import com.ruiqin.tinkerdemo.R;
import com.ruiqin.tinkerdemo.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected int getFragmentId() {
        return R.id.fragment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        addFragment(new BlankFragment());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
