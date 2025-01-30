package com.coinbase.wallet.application.view;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HomeFragment$initObservables$3 extends o implements l<String, x> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$initObservables$3(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(String str) {
        invoke2(str);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        if (str != null) {
            View view = this.this$0.getView();
            ((TextView) (view == null ? null : view.findViewById(e.j.a.balance))).setText(str);
        }
    }
}