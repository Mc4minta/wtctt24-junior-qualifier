package com.coinbase.wallet.features.lend.models;

import com.coinbase.wallet.features.lend.models.LendDashboardItem;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendDashboardItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendDashboardItem$Token$totalFiatText$2 extends o implements a<String> {
    final /* synthetic */ LendDashboardItem.Token this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendDashboardItem$Token$totalFiatText$2(LendDashboardItem.Token token) {
        super(0);
        this.this$0 = token;
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        CurrencyFormatter currencyFormatter;
        currencyFormatter = this.this$0.currencyFormatter;
        return CurrencyFormatter.fiatValueString$default(currencyFormatter, this.this$0.getTotalFiatValue(), false, 2, null);
    }
}