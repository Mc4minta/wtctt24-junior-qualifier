package com.coinbase.wallet.features.lend.models;

import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.math.BigInteger;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: LendCoinPickerItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b5\u00106J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u000bR\u001d\u0010'\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0013R\u001d\u0010*\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010\u0013R\u001d\u0010-\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010\u0013R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010.\u001a\u0004\b/\u0010\u0004R\u0019\u00101\u001a\u0002008\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "component1", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "", "Lcom/coinbase/wallet/lending/models/LendToken;", "component2", "()Ljava/util/List;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "component3", "()Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "wallet", "tokens", "currencyFormatter", "copy", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/util/List;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)Lcom/coinbase/wallet/features/lend/models/LendCoinPickerItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/net/URL;", "imageURL", "Ljava/net/URL;", "getImageURL", "()Ljava/net/URL;", "Ljava/util/List;", "getTokens", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "getCurrencyFormatter", "fiatAmount$delegate", "Lkotlin/h;", "getFiatAmount", "fiatAmount", "title$delegate", "getTitle", MessageBundle.TITLE_ENTRY, "supplyRate$delegate", "getSupplyRate", "supplyRate", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getWallet", "Ljava/math/BigInteger;", "maxRate", "Ljava/math/BigInteger;", "getMaxRate", "()Ljava/math/BigInteger;", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/util/List;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendCoinPickerItem {
    private final CurrencyFormatter currencyFormatter;
    private final h fiatAmount$delegate;
    private final URL imageURL;
    private final BigInteger maxRate;
    private final h supplyRate$delegate;
    private final h title$delegate;
    private final List<LendToken> tokens;
    private final Wallet wallet;

    public LendCoinPickerItem(Wallet wallet, List<LendToken> tokens, CurrencyFormatter currencyFormatter) {
        Object next;
        h b2;
        h b3;
        h b4;
        m.g(tokens, "tokens");
        m.g(currencyFormatter, "currencyFormatter");
        this.wallet = wallet;
        this.tokens = tokens;
        this.currencyFormatter = currencyFormatter;
        Iterator<T> it = tokens.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                BigInteger supplyInterestRate = ((LendToken) next).getSupplyInterestRate();
                do {
                    Object next2 = it.next();
                    BigInteger supplyInterestRate2 = ((LendToken) next2).getSupplyInterestRate();
                    if (supplyInterestRate.compareTo(supplyInterestRate2) < 0) {
                        next = next2;
                        supplyInterestRate = supplyInterestRate2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        LendToken lendToken = (LendToken) next;
        BigInteger ZERO = lendToken == null ? null : lendToken.getSupplyInterestRate();
        if (ZERO == null) {
            ZERO = BigInteger.ZERO;
            m.f(ZERO, "ZERO");
        }
        this.maxRate = ZERO;
        LendToken lendToken2 = (LendToken) p.a0(this.tokens);
        this.imageURL = lendToken2 != null ? lendToken2.getImageURL() : null;
        b2 = k.b(new LendCoinPickerItem$title$2(this));
        this.title$delegate = b2;
        b3 = k.b(new LendCoinPickerItem$fiatAmount$2(this));
        this.fiatAmount$delegate = b3;
        b4 = k.b(new LendCoinPickerItem$supplyRate$2(this));
        this.supplyRate$delegate = b4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LendCoinPickerItem copy$default(LendCoinPickerItem lendCoinPickerItem, Wallet wallet, List list, CurrencyFormatter currencyFormatter, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            wallet = lendCoinPickerItem.wallet;
        }
        if ((i2 & 2) != 0) {
            list = lendCoinPickerItem.tokens;
        }
        if ((i2 & 4) != 0) {
            currencyFormatter = lendCoinPickerItem.currencyFormatter;
        }
        return lendCoinPickerItem.copy(wallet, list, currencyFormatter);
    }

    public final Wallet component1() {
        return this.wallet;
    }

    public final List<LendToken> component2() {
        return this.tokens;
    }

    public final CurrencyFormatter component3() {
        return this.currencyFormatter;
    }

    public final LendCoinPickerItem copy(Wallet wallet, List<LendToken> tokens, CurrencyFormatter currencyFormatter) {
        m.g(tokens, "tokens");
        m.g(currencyFormatter, "currencyFormatter");
        return new LendCoinPickerItem(wallet, tokens, currencyFormatter);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LendCoinPickerItem) {
            LendCoinPickerItem lendCoinPickerItem = (LendCoinPickerItem) obj;
            return m.c(this.wallet, lendCoinPickerItem.wallet) && m.c(this.tokens, lendCoinPickerItem.tokens) && m.c(this.currencyFormatter, lendCoinPickerItem.currencyFormatter);
        }
        return false;
    }

    public final CurrencyFormatter getCurrencyFormatter() {
        return this.currencyFormatter;
    }

    public final String getFiatAmount() {
        return (String) this.fiatAmount$delegate.getValue();
    }

    public final URL getImageURL() {
        return this.imageURL;
    }

    public final BigInteger getMaxRate() {
        return this.maxRate;
    }

    public final String getSupplyRate() {
        return (String) this.supplyRate$delegate.getValue();
    }

    public final String getTitle() {
        return (String) this.title$delegate.getValue();
    }

    public final List<LendToken> getTokens() {
        return this.tokens;
    }

    public final Wallet getWallet() {
        return this.wallet;
    }

    public int hashCode() {
        Wallet wallet = this.wallet;
        return ((((wallet == null ? 0 : wallet.hashCode()) * 31) + this.tokens.hashCode()) * 31) + this.currencyFormatter.hashCode();
    }

    public String toString() {
        return "LendCoinPickerItem(wallet=" + this.wallet + ", tokens=" + this.tokens + ", currencyFormatter=" + this.currencyFormatter + ')';
    }
}