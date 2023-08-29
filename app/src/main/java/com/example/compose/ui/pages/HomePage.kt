package com.example.compose.ui.pages

import androidx.compose.runtime.Composable
import com.example.compose.entity.MessageEntity
import com.example.compose.ui.view.Conversation


/**
 * ClassName HomePage
 * Author LiuHuiJie
 * Date 2023/8/29 14:29
 * Description 首页
 */
@Composable
fun HomePage() {
    val messages = mutableListOf<MessageEntity>()
    for (i in 1..100) {
        val message = MessageEntity()
        message.name = "limei $i"
        message.message =
            "水电费速度啊索尼大法以所发生的速度第三方速度低俗低俗水电费速水电费水电费 低俗水电费 \n sdf 低俗度是发多少低俗速度低俗低俗非氨基酸的你是你说的呢为额外二 sdf sfsf sajf lajf lajalfja lsajflsajflkas jfdsajf af jsad fsad jfdsa aj s fsa fsaf slkjf lkjlo $i"
        messages.add(message)
    }
    Conversation(messages)
}

