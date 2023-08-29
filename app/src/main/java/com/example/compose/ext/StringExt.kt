package com.example.compose.ext

import android.util.Log
import com.example.compose.common.defaultTag

/**
 * ClassName StringExt
 * Author LiuHuiJie
 * Date 2023/8/29 15:23
 * Description 字符串扩展
 */
fun String.logE(tag:String?= defaultTag){
    Log.e(tag,this)
}