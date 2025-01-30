package com.coinbase.wallet.application;

import android.content.DialogInterface;
import com.coinbase.wallet.application.model.Notification;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class MainActivity$showUnreadNotifications$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<DialogInterface, x> {
    final /* synthetic */ Notification $notification;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$showUnreadNotifications$3(Notification notification) {
        super(1);
        this.$notification = notification;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface it) {
        kotlin.jvm.internal.m.g(it, "it");
        kotlin.e0.c.a<x> onDismissHook = this.$notification.getOnDismissHook();
        if (onDismissHook == null) {
            return;
        }
        onDismissHook.invoke();
    }
}