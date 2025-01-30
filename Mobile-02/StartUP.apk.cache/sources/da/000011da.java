package com.coinbase.wallet.application.migrations;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: AppVersion304Migration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "<anonymous>", "()Landroid/content/SharedPreferences;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AppVersion304Migration$prefs$2 extends o implements kotlin.e0.c.a<SharedPreferences> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVersion304Migration$prefs$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final SharedPreferences invoke() {
        return this.$context.getSharedPreferences("usm", 0);
    }
}