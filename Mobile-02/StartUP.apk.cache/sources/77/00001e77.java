package com.coinbase.wallet.features.lend.models;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: LendProviderItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendProviderItem$totalSupply$2 extends o implements a<String> {
    final /* synthetic */ LendProviderItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendProviderItem$totalSupply$2(LendProviderItem lendProviderItem) {
        super(0);
        this.this$0 = lendProviderItem;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        String formatToFiat;
        CurrencyFormatter currencyFormatter = this.this$0.getCurrencyFormatter();
        CurrencyCode currencyCode = this.this$0.getToken().getCurrencyCode();
        ContractAddress contractAddress = this.this$0.getToken().getContractAddress();
        formatToFiat = currencyFormatter.formatToFiat(currencyCode, contractAddress == null ? null : contractAddress.getRawValue(), this.this$0.getToken().getDecimals(), this.this$0.getToken().getGlobalSuppliedAmount(), (r17 & 16) != 0 ? false : true, (r17 & 32) != 0 ? null : null, (r17 & 64) != 0 ? null : null);
        return formatToFiat == null ? Strings_CoreKt.getEllipsis(Strings.INSTANCE) : formatToFiat;
    }
}