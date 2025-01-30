package com.coinbase.wallet.features.lend.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import java.net.URL;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: LendProviderItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\u00020\u00128F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0014R\u0019\u0010$\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u0019\u0010&\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0014R\u001d\u0010+\u001a\u00020\u00128F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010\u0014R\u0019\u0010,\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b,\u0010\nR\u0019\u0010.\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010\u0014R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u00100\u001a\u0004\b1\u0010\u0007R\u001d\u00104\u001a\u00020\u00128F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010!\u001a\u0004\b3\u0010\u0014R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u00105\u001a\u0004\b6\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b7\u0010\nR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010-\u001a\u0004\b8\u0010\nR\u001d\u0010;\u001a\u00020\u00128F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010!\u001a\u0004\b:\u0010\u0014¨\u0006>"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendProviderItem;", "", "Lcom/coinbase/wallet/lending/models/LendToken;", "component1", "()Lcom/coinbase/wallet/lending/models/LendToken;", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "component2", "()Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "", "component3", "()Z", "component4", ApiConstants.TOKEN, "currencyFormatter", "enabled", "expanded", "copy", "(Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;ZZ)Lcom/coinbase/wallet/features/lend/models/LendProviderItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/net/URL;", "websiteURL", "Ljava/net/URL;", "getWebsiteURL", "()Ljava/net/URL;", "collateralRate$delegate", "Lkotlin/h;", "getCollateralRate", "collateralRate", "imageURL", "getImageURL", MessageBundle.TITLE_ENTRY, "Ljava/lang/String;", "getTitle", "supplyRateText$delegate", "getSupplyRateText", "supplyRateText", "isCollateralApplicable", "Z", "websiteHostname", "getWebsiteHostname", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "getCurrencyFormatter", "totalSupply$delegate", "getTotalSupply", "totalSupply", "Lcom/coinbase/wallet/lending/models/LendToken;", "getToken", "getEnabled", "getExpanded", "utilization$delegate", "getUtilization", "utilization", "<init>", "(Lcom/coinbase/wallet/lending/models/LendToken;Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;ZZ)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProviderItem {
    private final h collateralRate$delegate;
    private final CurrencyFormatter currencyFormatter;
    private final boolean enabled;
    private final boolean expanded;
    private final URL imageURL;
    private final boolean isCollateralApplicable;
    private final h supplyRateText$delegate;
    private final String title;
    private final LendToken token;
    private final h totalSupply$delegate;
    private final h utilization$delegate;
    private final String websiteHostname;
    private final URL websiteURL;

    public LendProviderItem(LendToken token, CurrencyFormatter currencyFormatter, boolean z, boolean z2) {
        h b2;
        h b3;
        h b4;
        h b5;
        m.g(token, "token");
        m.g(currencyFormatter, "currencyFormatter");
        this.token = token;
        this.currencyFormatter = currencyFormatter;
        this.enabled = z;
        this.expanded = z2;
        b2 = k.b(new LendProviderItem$supplyRateText$2(this));
        this.supplyRateText$delegate = b2;
        b3 = k.b(new LendProviderItem$totalSupply$2(this));
        this.totalSupply$delegate = b3;
        b4 = k.b(new LendProviderItem$utilization$2(this));
        this.utilization$delegate = b4;
        this.isCollateralApplicable = token.isCollateralRateApplicable();
        b5 = k.b(new LendProviderItem$collateralRate$2(this));
        this.collateralRate$delegate = b5;
        this.imageURL = token.getProvider().getImageURL();
        this.websiteURL = token.getProvider().getWebsiteURL();
        String websiteHost = token.getProvider().getWebsiteHost();
        this.websiteHostname = websiteHost == null ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : websiteHost;
        this.title = token.getProvider().getName();
    }

    public static /* synthetic */ LendProviderItem copy$default(LendProviderItem lendProviderItem, LendToken lendToken, CurrencyFormatter currencyFormatter, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lendToken = lendProviderItem.token;
        }
        if ((i2 & 2) != 0) {
            currencyFormatter = lendProviderItem.currencyFormatter;
        }
        if ((i2 & 4) != 0) {
            z = lendProviderItem.enabled;
        }
        if ((i2 & 8) != 0) {
            z2 = lendProviderItem.expanded;
        }
        return lendProviderItem.copy(lendToken, currencyFormatter, z, z2);
    }

    public final LendToken component1() {
        return this.token;
    }

    public final CurrencyFormatter component2() {
        return this.currencyFormatter;
    }

    public final boolean component3() {
        return this.enabled;
    }

    public final boolean component4() {
        return this.expanded;
    }

    public final LendProviderItem copy(LendToken token, CurrencyFormatter currencyFormatter, boolean z, boolean z2) {
        m.g(token, "token");
        m.g(currencyFormatter, "currencyFormatter");
        return new LendProviderItem(token, currencyFormatter, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LendProviderItem) {
            LendProviderItem lendProviderItem = (LendProviderItem) obj;
            return m.c(this.token, lendProviderItem.token) && m.c(this.currencyFormatter, lendProviderItem.currencyFormatter) && this.enabled == lendProviderItem.enabled && this.expanded == lendProviderItem.expanded;
        }
        return false;
    }

    public final String getCollateralRate() {
        return (String) this.collateralRate$delegate.getValue();
    }

    public final CurrencyFormatter getCurrencyFormatter() {
        return this.currencyFormatter;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    public final URL getImageURL() {
        return this.imageURL;
    }

    public final String getSupplyRateText() {
        return (String) this.supplyRateText$delegate.getValue();
    }

    public final String getTitle() {
        return this.title;
    }

    public final LendToken getToken() {
        return this.token;
    }

    public final String getTotalSupply() {
        return (String) this.totalSupply$delegate.getValue();
    }

    public final String getUtilization() {
        return (String) this.utilization$delegate.getValue();
    }

    public final String getWebsiteHostname() {
        return this.websiteHostname;
    }

    public final URL getWebsiteURL() {
        return this.websiteURL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.token.hashCode() * 31) + this.currencyFormatter.hashCode()) * 31;
        boolean z = this.enabled;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.expanded;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final boolean isCollateralApplicable() {
        return this.isCollateralApplicable;
    }

    public String toString() {
        return "LendProviderItem(token=" + this.token + ", currencyFormatter=" + this.currencyFormatter + ", enabled=" + this.enabled + ", expanded=" + this.expanded + ')';
    }

    public /* synthetic */ LendProviderItem(LendToken lendToken, CurrencyFormatter currencyFormatter, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(lendToken, currencyFormatter, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? false : z2);
    }
}