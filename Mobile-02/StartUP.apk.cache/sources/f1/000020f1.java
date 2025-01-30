package com.coinbase.wallet.features.send.views.adapters;

import android.view.View;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SendDestinationAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isLoading", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SendDestinationAdapter$onBindViewHolder$3$2 extends o implements l<Boolean, x> {
    final /* synthetic */ View $this_apply;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationAdapter$onBindViewHolder$3$2(View view) {
        super(1);
        this.$this_apply = view;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
        invoke2(bool);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean isLoading) {
        ProgressBar activityIndicator = (ProgressBar) this.$this_apply.findViewById(e.j.a.f13509h);
        m.f(activityIndicator, "activityIndicator");
        m.f(isLoading, "isLoading");
        activityIndicator.setVisibility(isLoading.booleanValue() ? 0 : 8);
    }
}