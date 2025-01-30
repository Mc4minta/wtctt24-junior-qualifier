package com.coinbase.wallet.txhistory.operations;

import com.coinbase.wallet.txhistory.dtos.GetHdWalletTxsInputOutput;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: SyncHdWalletTxHistoryOperation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsInputOutput;", "input", "", "<anonymous>", "(Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsInputOutput;)Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$fromAddressFilter$1 extends o implements kotlin.e0.c.l<GetHdWalletTxsInputOutput, Boolean> {
    final /* synthetic */ HashSet<String> $addressSet;
    final /* synthetic */ boolean $isSent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$fromAddressFilter$1(boolean z, HashSet<String> hashSet) {
        super(1);
        this.$isSent = z;
        this.$addressSet = hashSet;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(GetHdWalletTxsInputOutput getHdWalletTxsInputOutput) {
        return Boolean.valueOf(invoke2(getHdWalletTxsInputOutput));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(GetHdWalletTxsInputOutput input) {
        m.g(input, "input");
        if (this.$isSent) {
            return this.$addressSet.contains(input.getAddress());
        }
        return !this.$addressSet.contains(input.getAddress());
    }
}