package com.coinbase.wallet.features.lend.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.toshi.R;

/* compiled from: LendDashboardItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Balance", "BlankItem", "Provider", "Token", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Balance;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Token;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$BlankItem;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class LendDashboardItem {
    private final String id;

    /* compiled from: LendDashboardItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0010\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\tR\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Balance;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Z", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component5", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "fiatSymbol", "balance", "lendAPR", "zeroBalance", "fiatCurrencyCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Balance;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getZeroBalance", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getFiatCurrencyCode", "Ljava/lang/String;", "getFiatSymbol", "getLendAPR", "getBalance", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Balance extends LendDashboardItem {
        private final String balance;
        private final CurrencyCode fiatCurrencyCode;
        private final String fiatSymbol;
        private final String lendAPR;
        private final boolean zeroBalance;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Balance(String fiatSymbol, String balance, String lendAPR, boolean z, CurrencyCode fiatCurrencyCode) {
            super("balance", null);
            m.g(fiatSymbol, "fiatSymbol");
            m.g(balance, "balance");
            m.g(lendAPR, "lendAPR");
            m.g(fiatCurrencyCode, "fiatCurrencyCode");
            this.fiatSymbol = fiatSymbol;
            this.balance = balance;
            this.lendAPR = lendAPR;
            this.zeroBalance = z;
            this.fiatCurrencyCode = fiatCurrencyCode;
        }

        public static /* synthetic */ Balance copy$default(Balance balance, String str, String str2, String str3, boolean z, CurrencyCode currencyCode, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = balance.fiatSymbol;
            }
            if ((i2 & 2) != 0) {
                str2 = balance.balance;
            }
            String str4 = str2;
            if ((i2 & 4) != 0) {
                str3 = balance.lendAPR;
            }
            String str5 = str3;
            if ((i2 & 8) != 0) {
                z = balance.zeroBalance;
            }
            boolean z2 = z;
            if ((i2 & 16) != 0) {
                currencyCode = balance.fiatCurrencyCode;
            }
            return balance.copy(str, str4, str5, z2, currencyCode);
        }

        public final String component1() {
            return this.fiatSymbol;
        }

        public final String component2() {
            return this.balance;
        }

        public final String component3() {
            return this.lendAPR;
        }

        public final boolean component4() {
            return this.zeroBalance;
        }

        public final CurrencyCode component5() {
            return this.fiatCurrencyCode;
        }

        public final Balance copy(String fiatSymbol, String balance, String lendAPR, boolean z, CurrencyCode fiatCurrencyCode) {
            m.g(fiatSymbol, "fiatSymbol");
            m.g(balance, "balance");
            m.g(lendAPR, "lendAPR");
            m.g(fiatCurrencyCode, "fiatCurrencyCode");
            return new Balance(fiatSymbol, balance, lendAPR, z, fiatCurrencyCode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Balance) {
                Balance balance = (Balance) obj;
                return m.c(this.fiatSymbol, balance.fiatSymbol) && m.c(this.balance, balance.balance) && m.c(this.lendAPR, balance.lendAPR) && this.zeroBalance == balance.zeroBalance && m.c(this.fiatCurrencyCode, balance.fiatCurrencyCode);
            }
            return false;
        }

        public final String getBalance() {
            return this.balance;
        }

        public final CurrencyCode getFiatCurrencyCode() {
            return this.fiatCurrencyCode;
        }

        public final String getFiatSymbol() {
            return this.fiatSymbol;
        }

        public final String getLendAPR() {
            return this.lendAPR;
        }

        public final boolean getZeroBalance() {
            return this.zeroBalance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.fiatSymbol.hashCode() * 31) + this.balance.hashCode()) * 31) + this.lendAPR.hashCode()) * 31;
            boolean z = this.zeroBalance;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return ((hashCode + i2) * 31) + this.fiatCurrencyCode.hashCode();
        }

        public String toString() {
            return "Balance(fiatSymbol=" + this.fiatSymbol + ", balance=" + this.balance + ", lendAPR=" + this.lendAPR + ", zeroBalance=" + this.zeroBalance + ", fiatCurrencyCode=" + this.fiatCurrencyCode + ')';
        }
    }

    /* compiled from: LendDashboardItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$BlankItem;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BlankItem extends LendDashboardItem {
        public BlankItem() {
            super("blankItem", null);
        }

        public boolean equals(Object obj) {
            return obj instanceof BlankItem;
        }

        public int hashCode() {
            return getId().hashCode();
        }
    }

    private LendDashboardItem(String str) {
        this.id = str;
    }

    public /* synthetic */ LendDashboardItem(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public String getId() {
        return this.id;
    }

    /* compiled from: LendDashboardItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BS\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b2\u00103B)\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b2\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004Jl\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0007R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b+\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b/\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b\u0019\u0010\u000eR\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b1\u0010\u0004¨\u00065"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/features/lend/models/BalanceInfo;", "component2", "()Lcom/coinbase/wallet/features/lend/models/BalanceInfo;", "component3", "component4", "component5", "component6", "", "component7", "()Z", "Ljava/net/URL;", "component8", "()Ljava/net/URL;", "component9", "id", "balanceInfo", "supplyRateText", "fiatValue", "cryptoValue", "providerName", "isPending", "imageURL", ApiConstants.DESCRIPTION, "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/features/lend/models/BalanceInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/net/URL;Ljava/lang/String;)Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSupplyRateText", "Lcom/coinbase/wallet/features/lend/models/BalanceInfo;", "getBalanceInfo", "Ljava/net/URL;", "getImageURL", "getProviderName", "getFiatValue", "getId", "getDescription", "Z", "getCryptoValue", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/features/lend/models/BalanceInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/net/URL;Ljava/lang/String;)V", "(Lcom/coinbase/wallet/features/lend/models/BalanceInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Provider extends LendDashboardItem {
        private final BalanceInfo balanceInfo;
        private final String cryptoValue;
        private final String description;
        private final String fiatValue;
        private final String id;
        private final URL imageURL;
        private final boolean isPending;
        private final String providerName;
        private final String supplyRateText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Provider(String id, BalanceInfo balanceInfo, String supplyRateText, String fiatValue, String cryptoValue, String providerName, boolean z, URL url, String description) {
            super(id, null);
            m.g(id, "id");
            m.g(balanceInfo, "balanceInfo");
            m.g(supplyRateText, "supplyRateText");
            m.g(fiatValue, "fiatValue");
            m.g(cryptoValue, "cryptoValue");
            m.g(providerName, "providerName");
            m.g(description, "description");
            this.id = id;
            this.balanceInfo = balanceInfo;
            this.supplyRateText = supplyRateText;
            this.fiatValue = fiatValue;
            this.cryptoValue = cryptoValue;
            this.providerName = providerName;
            this.isPending = z;
            this.imageURL = url;
            this.description = description;
        }

        public final String component1() {
            return getId();
        }

        public final BalanceInfo component2() {
            return this.balanceInfo;
        }

        public final String component3() {
            return this.supplyRateText;
        }

        public final String component4() {
            return this.fiatValue;
        }

        public final String component5() {
            return this.cryptoValue;
        }

        public final String component6() {
            return this.providerName;
        }

        public final boolean component7() {
            return this.isPending;
        }

        public final URL component8() {
            return this.imageURL;
        }

        public final String component9() {
            return this.description;
        }

        public final Provider copy(String id, BalanceInfo balanceInfo, String supplyRateText, String fiatValue, String cryptoValue, String providerName, boolean z, URL url, String description) {
            m.g(id, "id");
            m.g(balanceInfo, "balanceInfo");
            m.g(supplyRateText, "supplyRateText");
            m.g(fiatValue, "fiatValue");
            m.g(cryptoValue, "cryptoValue");
            m.g(providerName, "providerName");
            m.g(description, "description");
            return new Provider(id, balanceInfo, supplyRateText, fiatValue, cryptoValue, providerName, z, url, description);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Provider) {
                Provider provider = (Provider) obj;
                return m.c(getId(), provider.getId()) && m.c(this.balanceInfo, provider.balanceInfo) && m.c(this.supplyRateText, provider.supplyRateText) && m.c(this.fiatValue, provider.fiatValue) && m.c(this.cryptoValue, provider.cryptoValue) && m.c(this.providerName, provider.providerName) && this.isPending == provider.isPending && m.c(this.imageURL, provider.imageURL) && m.c(this.description, provider.description);
            }
            return false;
        }

        public final BalanceInfo getBalanceInfo() {
            return this.balanceInfo;
        }

        public final String getCryptoValue() {
            return this.cryptoValue;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getFiatValue() {
            return this.fiatValue;
        }

        @Override // com.coinbase.wallet.features.lend.models.LendDashboardItem
        public String getId() {
            return this.id;
        }

        public final URL getImageURL() {
            return this.imageURL;
        }

        public final String getProviderName() {
            return this.providerName;
        }

        public final String getSupplyRateText() {
            return this.supplyRateText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((((((getId().hashCode() * 31) + this.balanceInfo.hashCode()) * 31) + this.supplyRateText.hashCode()) * 31) + this.fiatValue.hashCode()) * 31) + this.cryptoValue.hashCode()) * 31) + this.providerName.hashCode()) * 31;
            boolean z = this.isPending;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            int i3 = (hashCode + i2) * 31;
            URL url = this.imageURL;
            return ((i3 + (url == null ? 0 : url.hashCode())) * 31) + this.description.hashCode();
        }

        public final boolean isPending() {
            return this.isPending;
        }

        public String toString() {
            return "Provider(id=" + getId() + ", balanceInfo=" + this.balanceInfo + ", supplyRateText=" + this.supplyRateText + ", fiatValue=" + this.fiatValue + ", cryptoValue=" + this.cryptoValue + ", providerName=" + this.providerName + ", isPending=" + this.isPending + ", imageURL=" + this.imageURL + ", description=" + this.description + ')';
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Provider(BalanceInfo balanceInfo, String supplyRateText, String fiatValue, String cryptoValue) {
            this(balanceInfo.getLendToken().getId(), balanceInfo, supplyRateText, fiatValue, cryptoValue, balanceInfo.getLendToken().getProvider().getName(), balanceInfo.isPending(), balanceInfo.getLendToken().getProvider().getImageURL(), LocalizedStrings.INSTANCE.get(R.string.lend_dashboard_action_title, fiatValue, supplyRateText, balanceInfo.getLendToken().getProvider().getName()));
            m.g(balanceInfo, "balanceInfo");
            m.g(supplyRateText, "supplyRateText");
            m.g(fiatValue, "fiatValue");
            m.g(cryptoValue, "cryptoValue");
        }
    }

    /* compiled from: LendDashboardItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BQ\b\u0000\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010#\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\u0014\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010&\u001a\u00020\u0014\u0012\u0006\u0010'\u001a\u00020\u001b\u0012\u0006\u0010(\u001a\u00020\u001e¢\u0006\u0004\b<\u0010=B-\b\u0016\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u0005¢\u0006\u0004\b<\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÂ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÂ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 Jh\u0010)\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00022\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\u00142\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u001b2\b\b\u0002\u0010(\u001a\u00020\u001eHÆ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b+\u0010\u0016R\u0019\u0010'\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010,\u001a\u0004\b-\u0010\u001dR\u001c\u0010$\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010.\u001a\u0004\b/\u0010\u0016R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u00100R\u001d\u00104\u001a\u00020\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0016R\u0019\u0010&\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010.\u001a\u0004\b5\u0010\u0016R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u00106R\u001b\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b%\u00107\u001a\u0004\b8\u0010\u0019R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u00109R\u0019\u0010(\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010:\u001a\u0004\b;\u0010 ¨\u0006A"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Token;", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "component1", "()Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "component2", "()Ljava/util/List;", "Lcom/coinbase/wallet/lending/models/LendToken;", "component3", "()Lcom/coinbase/wallet/lending/models/LendToken;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component4", "()Ljava/lang/String;", "Ljava/net/URL;", "component5", "()Ljava/net/URL;", "component6", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component7", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Ljava/math/BigDecimal;", "component8", "()Ljava/math/BigDecimal;", "currencyFormatter", "exchangeRates", ApiConstants.TOKEN, "id", "imageURL", "currencyName", AppsFlyerProperties.CURRENCY_CODE, "totalFiatValue", "copy", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Ljava/util/List;Lcom/coinbase/wallet/lending/models/LendToken;Ljava/lang/String;Ljava/net/URL;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/math/BigDecimal;)Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Token;", "toString", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Ljava/lang/String;", "getId", "Ljava/util/List;", "totalFiatText$delegate", "Lkotlin/h;", "getTotalFiatText", "totalFiatText", "getCurrencyName", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Ljava/net/URL;", "getImageURL", "Lcom/coinbase/wallet/lending/models/LendToken;", "Ljava/math/BigDecimal;", "getTotalFiatValue", "<init>", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Ljava/util/List;Lcom/coinbase/wallet/lending/models/LendToken;Ljava/lang/String;Ljava/net/URL;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/math/BigDecimal;)V", "Lcom/coinbase/wallet/features/lend/models/LendDashboardItem$Provider;", "items", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Ljava/util/List;Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Token extends LendDashboardItem {
        private final CurrencyCode currencyCode;
        private final CurrencyFormatter currencyFormatter;
        private final String currencyName;
        private final List<ExchangeRate> exchangeRates;
        private final String id;
        private final URL imageURL;
        private final LendToken token;
        private final h totalFiatText$delegate;
        private final BigDecimal totalFiatValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Token(CurrencyFormatter currencyFormatter, List<ExchangeRate> exchangeRates, LendToken token, String id, URL url, String currencyName, CurrencyCode currencyCode, BigDecimal totalFiatValue) {
            super(id, null);
            h b2;
            m.g(currencyFormatter, "currencyFormatter");
            m.g(exchangeRates, "exchangeRates");
            m.g(token, "token");
            m.g(id, "id");
            m.g(currencyName, "currencyName");
            m.g(currencyCode, "currencyCode");
            m.g(totalFiatValue, "totalFiatValue");
            this.currencyFormatter = currencyFormatter;
            this.exchangeRates = exchangeRates;
            this.token = token;
            this.id = id;
            this.imageURL = url;
            this.currencyName = currencyName;
            this.currencyCode = currencyCode;
            this.totalFiatValue = totalFiatValue;
            b2 = k.b(new LendDashboardItem$Token$totalFiatText$2(this));
            this.totalFiatText$delegate = b2;
        }

        private final CurrencyFormatter component1() {
            return this.currencyFormatter;
        }

        private final List<ExchangeRate> component2() {
            return this.exchangeRates;
        }

        private final LendToken component3() {
            return this.token;
        }

        public final String component4() {
            return getId();
        }

        public final URL component5() {
            return this.imageURL;
        }

        public final String component6() {
            return this.currencyName;
        }

        public final CurrencyCode component7() {
            return this.currencyCode;
        }

        public final BigDecimal component8() {
            return this.totalFiatValue;
        }

        public final Token copy(CurrencyFormatter currencyFormatter, List<ExchangeRate> exchangeRates, LendToken token, String id, URL url, String currencyName, CurrencyCode currencyCode, BigDecimal totalFiatValue) {
            m.g(currencyFormatter, "currencyFormatter");
            m.g(exchangeRates, "exchangeRates");
            m.g(token, "token");
            m.g(id, "id");
            m.g(currencyName, "currencyName");
            m.g(currencyCode, "currencyCode");
            m.g(totalFiatValue, "totalFiatValue");
            return new Token(currencyFormatter, exchangeRates, token, id, url, currencyName, currencyCode, totalFiatValue);
        }

        public boolean equals(Object obj) {
            if (obj instanceof Token) {
                Token token = (Token) obj;
                return m.c(token.currencyName, this.currencyName) && m.c(token.currencyCode, this.currencyCode);
            }
            return false;
        }

        public final CurrencyCode getCurrencyCode() {
            return this.currencyCode;
        }

        public final String getCurrencyName() {
            return this.currencyName;
        }

        @Override // com.coinbase.wallet.features.lend.models.LendDashboardItem
        public String getId() {
            return this.id;
        }

        public final URL getImageURL() {
            return this.imageURL;
        }

        public final String getTotalFiatText() {
            return (String) this.totalFiatText$delegate.getValue();
        }

        public final BigDecimal getTotalFiatValue() {
            return this.totalFiatValue;
        }

        public int hashCode() {
            return this.currencyName.hashCode() + (this.currencyCode.hashCode() * 37);
        }

        public String toString() {
            return "Token(currencyFormatter=" + this.currencyFormatter + ", exchangeRates=" + this.exchangeRates + ", token=" + this.token + ", id=" + getId() + ", imageURL=" + this.imageURL + ", currencyName=" + this.currencyName + ", currencyCode=" + this.currencyCode + ", totalFiatValue=" + this.totalFiatValue + ')';
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Token(com.coinbase.wallet.wallets.formatters.CurrencyFormatter r19, java.util.List<com.coinbase.wallet.wallets.models.ExchangeRate> r20, java.util.List<com.coinbase.wallet.features.lend.models.LendDashboardItem.Provider> r21) {
            /*
                r18 = this;
                r0 = r21
                java.lang.String r1 = "currencyFormatter"
                r3 = r19
                kotlin.jvm.internal.m.g(r3, r1)
                java.lang.String r1 = "exchangeRates"
                r11 = r20
                kotlin.jvm.internal.m.g(r11, r1)
                java.lang.String r1 = "items"
                kotlin.jvm.internal.m.g(r0, r1)
                r1 = 0
                java.lang.Object r2 = r0.get(r1)
                com.coinbase.wallet.features.lend.models.LendDashboardItem$Provider r2 = (com.coinbase.wallet.features.lend.models.LendDashboardItem.Provider) r2
                com.coinbase.wallet.features.lend.models.BalanceInfo r2 = r2.getBalanceInfo()
                com.coinbase.wallet.lending.models.LendToken r12 = r2.getLendToken()
                java.lang.Object r2 = r0.get(r1)
                com.coinbase.wallet.features.lend.models.LendDashboardItem$Provider r2 = (com.coinbase.wallet.features.lend.models.LendDashboardItem.Provider) r2
                com.coinbase.wallet.features.lend.models.BalanceInfo r2 = r2.getBalanceInfo()
                com.coinbase.wallet.lending.models.LendToken r2 = r2.getLendToken()
                com.coinbase.wallet.blockchains.models.CurrencyCode r2 = r2.getCurrencyCode()
                java.lang.String r13 = r2.getRawValue()
                java.lang.Object r2 = r0.get(r1)
                com.coinbase.wallet.features.lend.models.LendDashboardItem$Provider r2 = (com.coinbase.wallet.features.lend.models.LendDashboardItem.Provider) r2
                com.coinbase.wallet.features.lend.models.BalanceInfo r2 = r2.getBalanceInfo()
                com.coinbase.wallet.lending.models.LendToken r2 = r2.getLendToken()
                java.net.URL r14 = r2.getImageURL()
                java.lang.Object r2 = r0.get(r1)
                com.coinbase.wallet.features.lend.models.LendDashboardItem$Provider r2 = (com.coinbase.wallet.features.lend.models.LendDashboardItem.Provider) r2
                com.coinbase.wallet.features.lend.models.BalanceInfo r2 = r2.getBalanceInfo()
                com.coinbase.wallet.lending.models.LendToken r2 = r2.getLendToken()
                java.lang.String r15 = r2.getName()
                java.lang.Object r1 = r0.get(r1)
                com.coinbase.wallet.features.lend.models.LendDashboardItem$Provider r1 = (com.coinbase.wallet.features.lend.models.LendDashboardItem.Provider) r1
                com.coinbase.wallet.features.lend.models.BalanceInfo r1 = r1.getBalanceInfo()
                com.coinbase.wallet.lending.models.LendToken r1 = r1.getLendToken()
                com.coinbase.wallet.blockchains.models.CurrencyCode r1 = r1.getCurrencyCode()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r0 = r21.iterator()
            L79:
                boolean r4 = r0.hasNext()
                if (r4 == 0) goto Ld1
                java.lang.Object r4 = r0.next()
                com.coinbase.wallet.features.lend.models.LendDashboardItem$Provider r4 = (com.coinbase.wallet.features.lend.models.LendDashboardItem.Provider) r4
                com.coinbase.wallet.features.lend.models.BalanceInfo r4 = r4.getBalanceInfo()
                com.coinbase.wallet.lending.models.LendToken r16 = r4.getLendToken()
                com.coinbase.wallet.blockchains.models.CurrencyCode r5 = r16.getCurrencyCode()
                com.coinbase.wallet.ethereum.models.ContractAddress r4 = r16.getContractAddress()
                r17 = 0
                if (r4 != 0) goto L9c
                r6 = r17
                goto La1
            L9c:
                java.lang.String r4 = r4.getRawValue()
                r6 = r4
            La1:
                r7 = 0
                r8 = 0
                r9 = 12
                r10 = 0
                r4 = r20
                java.math.BigDecimal r4 = com.coinbase.wallet.common.extensions.List_WalletsKt.rateFor$default(r4, r5, r6, r7, r8, r9, r10)
                if (r4 != 0) goto Laf
                goto Lc9
            Laf:
                java.math.BigInteger r5 = r16.getSupplyBalance()
                int r6 = r16.getDecimals()
                java.math.BigDecimal r7 = new java.math.BigDecimal
                r7.<init>(r5)
                java.math.BigDecimal r4 = r4.multiply(r7)
                java.lang.String r5 = "this.multiply(other)"
                kotlin.jvm.internal.m.f(r4, r5)
                java.math.BigDecimal r17 = r4.movePointLeft(r6)
            Lc9:
                r4 = r17
                if (r4 == 0) goto L79
                r2.add(r4)
                goto L79
            Ld1:
                java.math.BigDecimal r0 = java.math.BigDecimal.ZERO
                java.util.Iterator r2 = r2.iterator()
                r10 = r0
            Ld8:
                boolean r0 = r2.hasNext()
                if (r0 == 0) goto Lf3
                java.lang.Object r0 = r2.next()
                java.math.BigDecimal r0 = (java.math.BigDecimal) r0
                java.lang.String r4 = "acc"
                kotlin.jvm.internal.m.f(r10, r4)
                java.math.BigDecimal r10 = r10.add(r0)
                java.lang.String r0 = "this.add(other)"
                kotlin.jvm.internal.m.f(r10, r0)
                goto Ld8
            Lf3:
                java.lang.String r0 = "items\n                .mapNotNull { item ->\n                    val token = item.balanceInfo.lendToken\n                    val exchangeRate = exchangeRates.rateFor(\n                        currencyCode = token.currencyCode,\n                        contractAddress = token.contractAddress?.rawValue\n                    ) ?: return@mapNotNull null\n                    val balance = token.supplyBalance\n                    val decimals = token.decimals\n\n                    return@mapNotNull (exchangeRate * BigDecimal(balance)).movePointLeft(decimals)\n                }\n                .fold(BigDecimal.ZERO) { acc, e -> acc + e }"
                kotlin.jvm.internal.m.f(r10, r0)
                r2 = r18
                r3 = r19
                r4 = r20
                r5 = r12
                r6 = r13
                r7 = r14
                r8 = r15
                r9 = r1
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.lend.models.LendDashboardItem.Token.<init>(com.coinbase.wallet.wallets.formatters.CurrencyFormatter, java.util.List, java.util.List):void");
        }
    }
}