package com.coinbase.wallet.application;

import com.coinbase.wallet.application.model.Notification;
import java.util.List;
import kotlin.Metadata;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/application/model/Notification;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MainActivity$checkForUnreadNotifications$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends Notification>, x> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$checkForUnreadNotifications$1(MainActivity mainActivity) {
        super(1);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(List<? extends Notification> list) {
        invoke2((List<Notification>) list);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<Notification> it) {
        MainActivity mainActivity = this.this$0;
        kotlin.jvm.internal.m.f(it, "it");
        mainActivity.showUnreadNotifications(it);
    }
}