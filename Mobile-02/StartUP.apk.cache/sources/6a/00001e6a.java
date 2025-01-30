package com.coinbase.wallet.features.lend.models;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.lending.models.LendToken;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: LendCoinPickerItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendCoinPickerItem$title$2 extends o implements a<String> {
    final /* synthetic */ LendCoinPickerItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendCoinPickerItem$title$2(LendCoinPickerItem lendCoinPickerItem) {
        super(0);
        this.this$0 = lendCoinPickerItem;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        LendToken lendToken = (LendToken) p.a0(this.this$0.getTokens());
        String name = lendToken == null ? null : lendToken.getName();
        return name == null ? Strings_CoreKt.getEllipsis(Strings.INSTANCE) : m.c(name, CurrencyCode_EthereumKt.getWETH(CurrencyCode.Companion).getCode()) ? "Ethereum" : name;
    }
}