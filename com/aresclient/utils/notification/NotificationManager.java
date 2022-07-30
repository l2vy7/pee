/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.notification.Notification
 *  com.aresclient.utils.notification.NotificationManager
 */
package com.aresclient.utils.notification;

import com.aresclient.utils.notification.Notification;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Exception performing whole class analysis ignored.
 */
public class NotificationManager {
    private static LinkedBlockingQueue<Notification> pendingNotifications = new LinkedBlockingQueue();
    private static Notification currentNotification = null;

    public static void show(Notification notification) {
        pendingNotifications.add(notification);
    }

    public static void update() {
        if (currentNotification != null && !currentNotification.isShown()) {
            currentNotification = null;
        }
        if (currentNotification == null && !pendingNotifications.isEmpty()) {
            currentNotification = (Notification)pendingNotifications.poll();
            currentNotification.show();
        }
    }

    public static void render() {
        NotificationManager.update();
        if (currentNotification != null) {
            currentNotification.render();
        }
    }
}

