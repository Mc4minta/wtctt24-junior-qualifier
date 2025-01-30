package com.coinbase.wallet.consumer.viewmodels;

import com.coinbase.wallet.common.extensions.SavedStateHandle_CommonKt;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerAccountsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAccountsViewModel$onrampEnabled$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Boolean> {
    final /* synthetic */ ConsumerAccountsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerAccountsViewModel$onrampEnabled$2(ConsumerAccountsViewModel consumerAccountsViewModel) {
        super(0);
        this.this$0 = consumerAccountsViewModel;
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        androidx.lifecycle.z zVar;
        zVar = this.this$0.savedStateHandle;
        return ((Boolean) SavedStateHandle_CommonKt.require(zVar, "ONRAMP_USA")).booleanValue();
    }
}