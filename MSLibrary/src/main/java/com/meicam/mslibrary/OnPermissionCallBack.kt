package com.meicam.mslibrary

import java.util.*

/**
 * All rights Reserved, Designed By www.meishesdk.com
 *
 * @Author : LiuPanFeng
 * @CreateDate : 2022/1/15 16:54
 * @Description :
 * @Copyright : www.meishesdk.com Inc. All rights reserved.
 */
interface OnPermissionCallBack {
    fun callBack(allGranted:Boolean,deniedList:ArrayList<String>)
}