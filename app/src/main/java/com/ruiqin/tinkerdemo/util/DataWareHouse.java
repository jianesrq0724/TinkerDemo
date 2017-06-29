package com.ruiqin.tinkerdemo.util;

import com.blankj.utilcode.util.StringUtils;
import com.ruiqin.tinkerdemo.SampleApplicationLike;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public class DataWareHouse {
    /**
     * 保存手机号mobileNum
     */
    public static void setMobileNum(String mobileNum) {
        SampleApplicationLike.mobileNum = mobileNum;
    }

    /**
     * 获取手机号码
     */
    public static String getMobileNum() {
        if (!StringUtils.isEmpty(SampleApplicationLike.mobileNum)) {
            return SampleApplicationLike.mobileNum;
        } else {
            return "";
        }
    }
}
