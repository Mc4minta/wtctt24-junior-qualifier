package com.coinbase.wallet.application;

import kotlin.Metadata;

/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Le/j/m/a/g;", "<anonymous>", "()Le/j/m/a/g;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class MainActivity$viewPagerAdapter$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<e.j.m.a.g> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$viewPagerAdapter$2(MainActivity mainActivity) {
        super(0);
        this.this$0 = mainActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final e.j.m.a.g invoke() {
        androidx.fragment.app.m supportFragmentManager = this.this$0.getSupportFragmentManager();
        kotlin.jvm.internal.m.f(supportFragmentManager, "supportFragmentManager");
        return new e.j.m.a.g(supportFragmentManager);
    }
}