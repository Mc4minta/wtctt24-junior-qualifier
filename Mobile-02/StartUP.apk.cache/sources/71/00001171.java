package com.coinbase.wallet.application;

import android.content.DialogInterface;
import com.coinbase.wallet.application.model.Notification;
import e.j.n.o2;
import java.util.List;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MainActivity$showUnreadNotifications$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {
    final /* synthetic */ Notification $notification;
    final /* synthetic */ List<Notification> $notifications;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$showUnreadNotifications$2(Notification notification, MainActivity mainActivity, List<Notification> list) {
        super(1);
        this.$notification = notification;
        this.this$0 = mainActivity;
        this.$notifications = list;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface it) {
        o2 o2Var;
        kotlin.jvm.internal.m.g(it, "it");
        it.dismiss();
        kotlin.e0.c.a<x> onCloseClickHook = this.$notification.getOnCloseClickHook();
        if (onCloseClickHook != null) {
            onCloseClickHook.invoke();
        }
        l.a.a.g("Notification dismissed", new Object[0]);
        o2Var = this.this$0.viewModel;
        if (o2Var != null) {
            Notification notification = this.$notification;
            o2Var.d(notification, notification.getDismissDestination());
            MainActivity mainActivity = this.this$0;
            List<Notification> list = this.$notifications;
            mainActivity.showUnreadNotifications(list.subList(1, list.size()));
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}