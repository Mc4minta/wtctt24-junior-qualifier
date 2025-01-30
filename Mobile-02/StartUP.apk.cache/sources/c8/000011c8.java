package com.coinbase.wallet.application.fragment;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.d;
import com.coinbase.wallet.application.util.ProcessPhoenix;
import com.toshi.view.custom.SpinnerOverlayLayout;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SignOutFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SignOutFragment$onStart$2 extends o implements l<x, x> {
    final /* synthetic */ Intent $phoenixIntent;
    final /* synthetic */ SignOutFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignOutFragment$onStart$2(SignOutFragment signOutFragment, Intent intent) {
        super(1);
        this.this$0 = signOutFragment;
        this.$phoenixIntent = intent;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(x xVar) {
        invoke2(xVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(x xVar) {
        View view = this.this$0.getView();
        ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerOverlay))).b(false);
        ProcessPhoenix.Companion companion = ProcessPhoenix.Companion;
        d requireActivity = this.this$0.requireActivity();
        m.f(requireActivity, "requireActivity()");
        companion.triggerRebirth(requireActivity, this.$phoenixIntent);
    }
}