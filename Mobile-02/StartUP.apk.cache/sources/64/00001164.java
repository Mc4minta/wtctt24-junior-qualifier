package com.coinbase.wallet.application;

import android.content.Intent;
import com.toshi.view.activity.BannedLocationActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isBanned", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MainActivity$setupObservers$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, x> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$setupObservers$3(MainActivity mainActivity) {
        super(1);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
        invoke2(bool);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean isBanned) {
        List<Number> j2;
        kotlin.jvm.internal.m.f(isBanned, "isBanned");
        if (isBanned.booleanValue()) {
            j2 = r.j(32768, 268435456);
            MainActivity mainActivity = this.this$0;
            Intent intent = new Intent(mainActivity, BannedLocationActivity.class);
            for (Number number : j2) {
                intent.addFlags(number.intValue());
            }
            mainActivity.startActivity(intent);
            mainActivity.finish();
        }
    }
}