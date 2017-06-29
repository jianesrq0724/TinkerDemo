package com.ruiqin.tinkerdemo.module;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.ruiqin.tinkerdemo.R;
import com.ruiqin.tinkerdemo.base.BaseActivity;
import com.ruiqin.tinkerdemo.util.ToastUtils;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends BaseActivity {

    String[] permissions = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    @Override
    protected int getFragmentId() {
        return R.id.fragment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        addFragment(new BlankFragment());
        ToastUtils.show("tinker success");
        tinkerInstall();
    }

    private static final int REQUESTCODE_TINKER = 1;

    /**
     * 加载热修复
     */
    private void tinkerInstall() {
        if (ContextCompat.checkSelfPermission(mContext, permissions[0]) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permissions[0]}, REQUESTCODE_TINKER);
        } else {
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUESTCODE_TINKER:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    boolean showRequestPermission = ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permissions[0]);//是否显示权限弹窗
                    if (!showRequestPermission) {
                        ToastUtils.show("权限已禁用，请手动打开");
                        return;
                    }
                }
                tinkerInstall();
                break;
            default:
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
