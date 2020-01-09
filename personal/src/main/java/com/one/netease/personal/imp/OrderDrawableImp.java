package com.one.netease.personal.imp;

import com.one.netease.annotation.ARouter;
import com.one.netease.common.order.OrderDrawable;
import com.one.netease.order.R;

/**
 * @author diaokaibin@gmail.com on 2020-01-09.
 */
@ARouter(path = "/order/getDrawable")
public class OrderDrawableImp implements OrderDrawable {
    @Override
    public int getDrawable() {
        return R.drawable.ic_drive_eta_black_24dp;
    }
}
