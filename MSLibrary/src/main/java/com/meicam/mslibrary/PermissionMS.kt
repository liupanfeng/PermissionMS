package com.meicam.mslibrary

import androidx.fragment.app.FragmentActivity

/**
 * All rights Reserved, Designed By www.meishesdk.com
 *
 * @Author : LiuPanFeng
 * @CreateDate : 2022/1/15 15:34
 * @Description :
 * @Copyright : www.meishesdk.com Inc. All rights reserved.
 */
object PermissionMS {

    private const val TAG = "InvisibleFragment"

    /**
     *
     * @param activity FragmentActivity 上下文
     * @param permissions Array<out String> 不限制个数的参数
     * @param callBack Function2<Boolean, List<String>, Unit> 回调
     */
    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callBack: OnPermissionCallBack
    ) {
        val supportFragmentManager = activity.supportFragmentManager
        var existedFragment = supportFragmentManager.findFragmentByTag(TAG)
        val fragment=if (existedFragment!=null){
            existedFragment as InvisibleFragment
        }else{
            existedFragment=InvisibleFragment()
            supportFragmentManager.beginTransaction().add(existedFragment, TAG).commitNow()
            existedFragment
        }
        fragment.requestNow(callBack,*permissions)
    }

}