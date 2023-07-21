package com.github.rslbl.colornamegenerator

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class HelloWorldAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val group = NotificationGroup(
            displayId = "myActionId",
            displayType = NotificationDisplayType.BALLOON,
            isLogByDefault = true
        )

        group.createNotification(
            title = "My title",
            content = "Hello World",
            type = NotificationType.INFORMATION,
            listener = null
        ).notify(event.project)
    }

}