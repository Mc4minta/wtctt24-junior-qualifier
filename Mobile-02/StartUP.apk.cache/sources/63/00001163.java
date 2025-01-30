package com.coinbase.wallet.application;

import com.coinbase.wallet.application.model.Notification;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/application/model/Notification;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/application/model/Notification;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MainActivity$setupLockoutNotifications$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Notification, x> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$setupLockoutNotifications$1(MainActivity mainActivity) {
        super(1);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Notification notification) {
        invoke2(notification);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Notification notification) {
        List b2;
        MainActivity mainActivity = this.this$0;
        b2 = q.b(notification);
        mainActivity.showUnreadNotifications(b2);
    }
}