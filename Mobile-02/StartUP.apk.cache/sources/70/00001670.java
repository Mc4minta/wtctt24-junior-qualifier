package com.coinbase.wallet.consumer.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerCoinCellViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\b\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\u0017\u0012\b\u0010$\u001a\u0004\u0018\u00010\b\u0012\b\u0010%\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010&\u001a\u00020\f\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010(\u001a\u00020\u000f\u0012\u0006\u0010)\u001a\u00020\u000f\u0012\u0006\u0010*\u001a\u00020\u000f\u0012\b\u0010+\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bD\u0010EBW\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u0012\u0006\u0010\"\u001a\u00020\b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010(\u001a\u00020\u000f\u0012\b\b\u0002\u0010)\u001a\u00020\u000f\u0012\b\b\u0002\u0010*\u001a\u00020\u000f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bD\u0010FJ\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÂ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÂ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÂ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÂ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fHÂ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0011J\u0010\u0010\u001c\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0011J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\nJ¢\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\u00172\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010&\u001a\u00020\f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u000f2\b\b\u0002\u0010)\u001a\u00020\u000f2\b\b\u0002\u0010*\u001a\u00020\u000f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b.\u0010\nJ\u0010\u0010/\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b/\u0010\u0007J\u001a\u00102\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u000100HÖ\u0003¢\u0006\u0004\b2\u00103R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00104R\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00105R\u0019\u0010*\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b*\u00106\u001a\u0004\b*\u0010\u0011R\u001b\u0010+\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u00107\u001a\u0004\b8\u0010\nR\u0013\u0010:\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b9\u0010\nR\u0019\u0010#\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b<\u0010\u0019R\u0019\u0010\"\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\b=\u0010\nR\u0018\u0010%\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u00107R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010>R\u0019\u0010(\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u00106\u001a\u0004\b(\u0010\u0011R\u001b\u0010$\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00107\u001a\u0004\b?\u0010\nR\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u00106R\u0013\u0010A\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010\nR\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u00106R\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u00107R\u0019\u0010\u001e\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010B\u001a\u0004\bC\u0010\u0015¨\u0006G"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellViewState;", "Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellSectionViewState;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "component2", "()Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "", "component3", "()I", "", "component4", "()Ljava/lang/String;", "component8", "Ljava/math/BigInteger;", "component9", "()Ljava/math/BigInteger;", "", "component10", "()Z", "component12", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "component1", "()Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "component5", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component6", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component7", "component11", "component13", "component14", "account", "currencyFormatter", "decimals", "accountId", ApiConstants.NAME, "code", "imageURL", "fiatBalance", "cryptoBalance", "noDestinationTag", "isTappable", "isAvailableForSend", "isSupported", "placeholderText", "copy", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;ILjava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;ZZZZLjava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerCoinCellViewState;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "I", "Z", "Ljava/lang/String;", "getPlaceholderText", "getFiatBalanceText", "fiatBalanceText", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCode", "getName", "Ljava/math/BigInteger;", "getImageURL", "getCryptoBalanceText", "cryptoBalanceText", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "getAccount", "<init>", "(Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;ILjava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigInteger;ZZZZLjava/lang/String;)V", "(Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerCoinCellViewState extends ConsumerCoinCellSectionViewState {
    private final ConsumerAccount account;
    private final String accountId;
    private final CurrencyCode code;
    private final BigInteger cryptoBalance;
    private final CurrencyFormatter currencyFormatter;
    private final int decimals;
    private final String fiatBalance;
    private final String imageURL;
    private final boolean isAvailableForSend;
    private final boolean isSupported;
    private final boolean isTappable;
    private final String name;
    private final boolean noDestinationTag;
    private final String placeholderText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerCoinCellViewState(ConsumerAccount account, CurrencyFormatter currencyFormatter, int i2, String accountId, String name, CurrencyCode code, String str, String str2, BigInteger cryptoBalance, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        super(null);
        m.g(account, "account");
        m.g(currencyFormatter, "currencyFormatter");
        m.g(accountId, "accountId");
        m.g(name, "name");
        m.g(code, "code");
        m.g(cryptoBalance, "cryptoBalance");
        this.account = account;
        this.currencyFormatter = currencyFormatter;
        this.decimals = i2;
        this.accountId = accountId;
        this.name = name;
        this.code = code;
        this.imageURL = str;
        this.fiatBalance = str2;
        this.cryptoBalance = cryptoBalance;
        this.noDestinationTag = z;
        this.isTappable = z2;
        this.isAvailableForSend = z3;
        this.isSupported = z4;
        this.placeholderText = str3;
    }

    private final boolean component10() {
        return this.noDestinationTag;
    }

    private final boolean component12() {
        return this.isAvailableForSend;
    }

    private final CurrencyFormatter component2() {
        return this.currencyFormatter;
    }

    private final int component3() {
        return this.decimals;
    }

    private final String component4() {
        return this.accountId;
    }

    private final String component8() {
        return this.fiatBalance;
    }

    private final BigInteger component9() {
        return this.cryptoBalance;
    }

    public final ConsumerAccount component1() {
        return this.account;
    }

    public final boolean component11() {
        return this.isTappable;
    }

    public final boolean component13() {
        return this.isSupported;
    }

    public final String component14() {
        return this.placeholderText;
    }

    public final String component5() {
        return this.name;
    }

    public final CurrencyCode component6() {
        return this.code;
    }

    public final String component7() {
        return this.imageURL;
    }

    public final ConsumerCoinCellViewState copy(ConsumerAccount account, CurrencyFormatter currencyFormatter, int i2, String accountId, String name, CurrencyCode code, String str, String str2, BigInteger cryptoBalance, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        m.g(account, "account");
        m.g(currencyFormatter, "currencyFormatter");
        m.g(accountId, "accountId");
        m.g(name, "name");
        m.g(code, "code");
        m.g(cryptoBalance, "cryptoBalance");
        return new ConsumerCoinCellViewState(account, currencyFormatter, i2, accountId, name, code, str, str2, cryptoBalance, z, z2, z3, z4, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerCoinCellViewState) {
            ConsumerCoinCellViewState consumerCoinCellViewState = (ConsumerCoinCellViewState) obj;
            return m.c(this.account, consumerCoinCellViewState.account) && m.c(this.currencyFormatter, consumerCoinCellViewState.currencyFormatter) && this.decimals == consumerCoinCellViewState.decimals && m.c(this.accountId, consumerCoinCellViewState.accountId) && m.c(this.name, consumerCoinCellViewState.name) && m.c(this.code, consumerCoinCellViewState.code) && m.c(this.imageURL, consumerCoinCellViewState.imageURL) && m.c(this.fiatBalance, consumerCoinCellViewState.fiatBalance) && m.c(this.cryptoBalance, consumerCoinCellViewState.cryptoBalance) && this.noDestinationTag == consumerCoinCellViewState.noDestinationTag && this.isTappable == consumerCoinCellViewState.isTappable && this.isAvailableForSend == consumerCoinCellViewState.isAvailableForSend && this.isSupported == consumerCoinCellViewState.isSupported && m.c(this.placeholderText, consumerCoinCellViewState.placeholderText);
        }
        return false;
    }

    public final ConsumerAccount getAccount() {
        return this.account;
    }

    public final CurrencyCode getCode() {
        return this.code;
    }

    public final String getCryptoBalanceText() {
        return !this.isSupported ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : CurrencyFormatter.formatToCrypto$default(this.currencyFormatter, this.code, this.decimals, this.cryptoBalance, false, 0, 0, 56, (Object) null);
    }

    public final String getFiatBalanceText() {
        String str;
        return (!this.isSupported || (str = this.fiatBalance) == null) ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str;
    }

    public final String getImageURL() {
        return this.imageURL;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlaceholderText() {
        return this.placeholderText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.account.hashCode() * 31) + this.currencyFormatter.hashCode()) * 31) + this.decimals) * 31) + this.accountId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.code.hashCode()) * 31;
        String str = this.imageURL;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fiatBalance;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.cryptoBalance.hashCode()) * 31;
        boolean z = this.noDestinationTag;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z2 = this.isTappable;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.isAvailableForSend;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z4 = this.isSupported;
        int i8 = (i7 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        String str3 = this.placeholderText;
        return i8 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isSupported() {
        return this.isSupported;
    }

    public final boolean isTappable() {
        return this.isTappable;
    }

    public String toString() {
        return "ConsumerCoinCellViewState(account=" + this.account + ", currencyFormatter=" + this.currencyFormatter + ", decimals=" + this.decimals + ", accountId=" + this.accountId + ", name=" + this.name + ", code=" + this.code + ", imageURL=" + ((Object) this.imageURL) + ", fiatBalance=" + ((Object) this.fiatBalance) + ", cryptoBalance=" + this.cryptoBalance + ", noDestinationTag=" + this.noDestinationTag + ", isTappable=" + this.isTappable + ", isAvailableForSend=" + this.isAvailableForSend + ", isSupported=" + this.isSupported + ", placeholderText=" + ((Object) this.placeholderText) + ')';
    }

    public /* synthetic */ ConsumerCoinCellViewState(CurrencyFormatter currencyFormatter, ConsumerAccount consumerAccount, String str, String str2, boolean z, boolean z2, boolean z3, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(currencyFormatter, consumerAccount, str, (i2 & 8) != 0 ? Strings_CoreKt.getEllipsis(Strings.INSTANCE) : str2, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? true : z2, (i2 & 64) != 0 ? true : z3, (i2 & 128) != 0 ? null : str3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConsumerCoinCellViewState(CurrencyFormatter currencyFormatter, ConsumerAccount account, String name, String str, boolean z, boolean z2, boolean z3, String str2) {
        this(account, currencyFormatter, account.getDecimals(), account.getId(), name, account.getCurrencyCode(), account.getImageUrl(), str, account.getBalance(), account.getDestinationTagName() == null, z, z2, z3, str2);
        m.g(currencyFormatter, "currencyFormatter");
        m.g(account, "account");
        m.g(name, "name");
    }
}