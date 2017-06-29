package com.ruiqin.tinkerdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Ruiqin on 2017/6/26.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBind = ButterKnife.bind(this);
        initView(savedInstanceState);
    }

    /**
     * add Fragment
     */
    protected void addFragment(BaseFragment fragment) {
        getFragmentManager().beginTransaction().replace(getFragmentId(), fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
    }

    protected abstract int getFragmentId();

    /**
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 获取子布局的Id
     *
     * @return
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
