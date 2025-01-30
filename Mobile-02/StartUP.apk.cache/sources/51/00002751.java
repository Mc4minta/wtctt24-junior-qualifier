package com.coinbase.wallet.txhistory.extensions;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.models.CurrencyComponents;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.math.BigDecimal;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;

/* compiled from: CurrencyFormatter+TxHistory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aA\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\b*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "", "Lcom/coinbase/wallet/txhistory/models/CurrencyComponents;", "amounts", "", "showAmountPrefix", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lkotlin/o;", "", "formatFiatTotal", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Ljava/util/List;ZLjava/lang/Integer;)Lkotlin/o;", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CurrencyFormatter_TxHistoryKt {
    public static final o<String, Boolean> formatFiatTotal(CurrencyFormatter currencyFormatter, List<CurrencyComponents> amounts, boolean z, Integer num) {
        o a;
        m.g(currencyFormatter, "<this>");
        m.g(amounts, "amounts");
        BigDecimal fiatValue = BigDecimal.ZERO;
        for (CurrencyComponents currencyComponents : amounts) {
            BigDecimal value = CurrencyFormatter.fiatValue$default(currencyFormatter, currencyComponents.getCurrencyCode(), null, currencyComponents.getDecimals(), currencyComponents.getValue(), null, num, 16, null);
            if (value == null) {
                value = BigDecimal.ZERO;
            }
            m.f(fiatValue, "total");
            m.f(value, "value");
            fiatValue = fiatValue.add(value);
            m.f(fiatValue, "this.add(other)");
        }
        if (m.c(fiatValue, BigDecimal.ZERO)) {
            return u.a(null, Boolean.FALSE);
        }
        if (fiatValue.compareTo(BigDecimal.ZERO) < 0) {
            m.f(fiatValue, "fiatValue");
            BigDecimal negate = fiatValue.negate();
            m.f(negate, "this.negate()");
            a = u.a(negate, Boolean.FALSE);
        } else {
            a = u.a(fiatValue, Boolean.TRUE);
        }
        boolean booleanValue = ((Boolean) a.b()).booleanValue();
        String fiatValueString$default = CurrencyFormatter.fiatValueString$default(currencyFormatter, (BigDecimal) a.a(), false, 2, null);
        if (z) {
            return u.a(m.o(fiatValue.compareTo(BigDecimal.ZERO) < 0 ? "- " : "+ ", fiatValueString$default), Boolean.valueOf(booleanValue));
        }
        return u.a(fiatValueString$default, Boolean.valueOf(booleanValue));
    }
}