package e.j.l.s;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.util.Comparator;
import java.util.List;

/* compiled from: FiatCurrencyComparator.java */
/* loaded from: classes2.dex */
public class a implements Comparator<FiatCurrency> {
    private static final List<CurrencyCode> a = CurrencyCode.Companion.getTopFiatCurrencies();

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(FiatCurrency fiatCurrency, FiatCurrency fiatCurrency2) {
        List<CurrencyCode> list = a;
        if (list.contains(fiatCurrency.getCode())) {
            return -1;
        }
        if (list.contains(fiatCurrency2.getCode())) {
            return 1;
        }
        return fiatCurrency.getName().compareTo(fiatCurrency2.getName());
    }
}