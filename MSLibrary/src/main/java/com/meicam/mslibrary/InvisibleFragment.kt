package com.meicam.mslibrary

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 * All rights Reserved, Designed By www.meishesdk.com
 *
 * @Author : LiuPanFeng
 * @CreateDate : 2022/1/15 15:14
 * @Description :
 * @Copyright : www.meishesdk.com Inc. All rights reserved.
 */

//typealias OnPermissionCallBack=((Boolean, List<String>)->Unit)  //定义一个别名

class InvisibleFragment :Fragment() {

    private var callback:OnPermissionCallBack?=null

    fun requestNow (cb:OnPermissionCallBack, vararg permissions:String){
        callback=cb;
        requestPermissions(permissions,1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode==1){
            val deniedList=ArrayList<String>()
            for ((index,result) in grantResults.withIndex()){
                if (result!=PackageManager.PERMISSION_GRANTED){  //granted
                    deniedList.add(permissions[index])
                }
            }
            val allGranted=deniedList.isEmpty()
            callback?.let { it.callBack(allGranted,deniedList) }
        }
    }


}