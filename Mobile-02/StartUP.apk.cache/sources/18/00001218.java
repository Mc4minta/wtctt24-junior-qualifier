package com.coinbase.wallet.application.repository.interfaces;

import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.application.model.NotificationDestination;
import com.coinbase.wallet.core.interfaces.Startable;
import h.c.s;
import java.util.List;
import kotlin.Metadata;

/* compiled from: NotificationRepositoryInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006R\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/application/repository/interfaces/NotificationRepositoryInterface;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/application/model/Notification;", "notification", "Lkotlin/x;", "notificationSeen", "(Lcom/coinbase/wallet/application/model/Notification;)V", "Lcom/coinbase/wallet/application/model/NotificationDestination;", "action", "actionPerformed", "(Lcom/coinbase/wallet/application/model/Notification;Lcom/coinbase/wallet/application/model/NotificationDestination;)V", "showNotification", "Lh/c/s;", "", "getUnreadNotificationsObservable", "()Lh/c/s;", "unreadNotificationsObservable", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface NotificationRepositoryInterface extends Startable {
    void actionPerformed(Notification notification, NotificationDestination notificationDestination);

    s<List<Notification>> getUnreadNotificationsObservable();

    void notificationSeen(Notification notification);

    void showNotification(Notification notification);
}