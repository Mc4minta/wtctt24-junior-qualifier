package com.coinbase.wallet.features.lend.models;

import com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.a;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LendDashboardState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jt\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010%\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010\tR\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010\rR\u0019\u0010\u001d\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010\u0013R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b/\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b0\u0010\tR\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b3\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b4\u0010\u0004¨\u00067"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendDashboardState;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()D", "component5", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component6", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component7", "component8", "component9", "", "component10", "()Z", "balance", "interestAPR", "interestAPRTitle", "interestAPROpacity", "fiatCurrencySymbol", "fiatCurrencyCode", "contentOpacity", "lifetimeInterestEarned", "earnMore", "showLendingActionSheet", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;DLjava/lang/String;Ljava/lang/String;Z)Lcom/coinbase/wallet/features/lend/models/LendDashboardState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBalance", "D", "getContentOpacity", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getFiatCurrencyCode", "Z", "getShowLendingActionSheet", "getInterestAPRTitle", "getInterestAPROpacity", "getEarnMore", "getFiatCurrencySymbol", "getInterestAPR", "getLifetimeInterestEarned", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;DLjava/lang/String;Ljava/lang/String;Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendDashboardState {
    private final String balance;
    private final double contentOpacity;
    private final String earnMore;
    private final CurrencyCode fiatCurrencyCode;
    private final String fiatCurrencySymbol;
    private final String interestAPR;
    private final double interestAPROpacity;
    private final String interestAPRTitle;
    private final String lifetimeInterestEarned;
    private final boolean showLendingActionSheet;

    public LendDashboardState() {
        this(null, null, null, 0.0d, null, null, 0.0d, null, null, false, 1023, null);
    }

    public LendDashboardState(String balance, String interestAPR, String interestAPRTitle, double d2, String fiatCurrencySymbol, CurrencyCode fiatCurrencyCode, double d3, String lifetimeInterestEarned, String earnMore, boolean z) {
        m.g(balance, "balance");
        m.g(interestAPR, "interestAPR");
        m.g(interestAPRTitle, "interestAPRTitle");
        m.g(fiatCurrencySymbol, "fiatCurrencySymbol");
        m.g(fiatCurrencyCode, "fiatCurrencyCode");
        m.g(lifetimeInterestEarned, "lifetimeInterestEarned");
        m.g(earnMore, "earnMore");
        this.balance = balance;
        this.interestAPR = interestAPR;
        this.interestAPRTitle = interestAPRTitle;
        this.interestAPROpacity = d2;
        this.fiatCurrencySymbol = fiatCurrencySymbol;
        this.fiatCurrencyCode = fiatCurrencyCode;
        this.contentOpacity = d3;
        this.lifetimeInterestEarned = lifetimeInterestEarned;
        this.earnMore = earnMore;
        this.showLendingActionSheet = z;
    }

    public final String component1() {
        return this.balance;
    }

    public final boolean component10() {
        return this.showLendingActionSheet;
    }

    public final String component2() {
        return this.interestAPR;
    }

    public final String component3() {
        return this.interestAPRTitle;
    }

    public final double component4() {
        return this.interestAPROpacity;
    }

    public final String component5() {
        return this.fiatCurrencySymbol;
    }

    public final CurrencyCode component6() {
        return this.fiatCurrencyCode;
    }

    public final double component7() {
        return this.contentOpacity;
    }

    public final String component8() {
        return this.lifetimeInterestEarned;
    }

    public final String component9() {
        return this.earnMore;
    }

    public final LendDashboardState copy(String balance, String interestAPR, String interestAPRTitle, double d2, String fiatCurrencySymbol, CurrencyCode fiatCurrencyCode, double d3, String lifetimeInterestEarned, String earnMore, boolean z) {
        m.g(balance, "balance");
        m.g(interestAPR, "interestAPR");
        m.g(interestAPRTitle, "interestAPRTitle");
        m.g(fiatCurrencySymbol, "fiatCurrencySymbol");
        m.g(fiatCurrencyCode, "fiatCurrencyCode");
        m.g(lifetimeInterestEarned, "lifetimeInterestEarned");
        m.g(earnMore, "earnMore");
        return new LendDashboardState(balance, interestAPR, interestAPRTitle, d2, fiatCurrencySymbol, fiatCurrencyCode, d3, lifetimeInterestEarned, earnMore, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LendDashboardState) {
            LendDashboardState lendDashboardState = (LendDashboardState) obj;
            return m.c(this.balance, lendDashboardState.balance) && m.c(this.interestAPR, lendDashboardState.interestAPR) && m.c(this.interestAPRTitle, lendDashboardState.interestAPRTitle) && m.c(Double.valueOf(this.interestAPROpacity), Double.valueOf(lendDashboardState.interestAPROpacity)) && m.c(this.fiatCurrencySymbol, lendDashboardState.fiatCurrencySymbol) && m.c(this.fiatCurrencyCode, lendDashboardState.fiatCurrencyCode) && m.c(Double.valueOf(this.contentOpacity), Double.valueOf(lendDashboardState.contentOpacity)) && m.c(this.lifetimeInterestEarned, lendDashboardState.lifetimeInterestEarned) && m.c(this.earnMore, lendDashboardState.earnMore) && this.showLendingActionSheet == lendDashboardState.showLendingActionSheet;
        }
        return false;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final double getContentOpacity() {
        return this.contentOpacity;
    }

    public final String getEarnMore() {
        return this.earnMore;
    }

    public final CurrencyCode getFiatCurrencyCode() {
        return this.fiatCurrencyCode;
    }

    public final String getFiatCurrencySymbol() {
        return this.fiatCurrencySymbol;
    }

    public final String getInterestAPR() {
        return this.interestAPR;
    }

    public final double getInterestAPROpacity() {
        return this.interestAPROpacity;
    }

    public final String getInterestAPRTitle() {
        return this.interestAPRTitle;
    }

    public final String getLifetimeInterestEarned() {
        return this.lifetimeInterestEarned;
    }

    public final boolean getShowLendingActionSheet() {
        return this.showLendingActionSheet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((((this.balance.hashCode() * 31) + this.interestAPR.hashCode()) * 31) + this.interestAPRTitle.hashCode()) * 31) + a.a(this.interestAPROpacity)) * 31) + this.fiatCurrencySymbol.hashCode()) * 31) + this.fiatCurrencyCode.hashCode()) * 31) + a.a(this.contentOpacity)) * 31) + this.lifetimeInterestEarned.hashCode()) * 31) + this.earnMore.hashCode()) * 31;
        boolean z = this.showLendingActionSheet;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "LendDashboardState(balance=" + this.balance + ", interestAPR=" + this.interestAPR + ", interestAPRTitle=" + this.interestAPRTitle + ", interestAPROpacity=" + this.interestAPROpacity + ", fiatCurrencySymbol=" + this.fiatCurrencySymbol + ", fiatCurrencyCode=" + this.fiatCurrencyCode + ", contentOpacity=" + this.contentOpacity + ", lifetimeInterestEarned=" + this.lifetimeInterestEarned + ", earnMore=" + this.earnMore + ", showLendingActionSheet=" + this.showLendingActionSheet + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ LendDashboardState(java.lang.String r14, java.lang.String r15, java.lang.String r16, double r17, java.lang.String r19, com.coinbase.wallet.blockchains.models.CurrencyCode r20, double r21, java.lang.String r23, java.lang.String r24, boolean r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            if (r1 == 0) goto L9
            java.lang.String r1 = "0"
            goto La
        L9:
            r1 = r14
        La:
            r2 = r0 & 2
            if (r2 == 0) goto L18
            com.coinbase.wallet.common.utilities.LocalizedStrings r2 = com.coinbase.wallet.common.utilities.LocalizedStrings.INSTANCE
            r3 = 2131952080(0x7f1301d0, float:1.9540593E38)
            java.lang.String r2 = r2.get(r3)
            goto L19
        L18:
            r2 = r15
        L19:
            r3 = r0 & 4
            if (r3 == 0) goto L24
            com.coinbase.wallet.core.extensions.Strings r3 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r3 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r3)
            goto L26
        L24:
            r3 = r16
        L26:
            r4 = r0 & 8
            r5 = 0
            if (r4 == 0) goto L2e
            r7 = r5
            goto L30
        L2e:
            r7 = r17
        L30:
            r4 = r0 & 16
            if (r4 == 0) goto L4b
            com.coinbase.wallet.common.utilities.Locales r4 = com.coinbase.wallet.common.utilities.Locales.INSTANCE
            java.util.Locale r4 = r4.getCurrent()
            java.util.Currency r4 = com.coinbase.wallet.common.extensions.Locale_CommonKt.getCurrency(r4)
            java.lang.String r4 = r4.getSymbol()
            if (r4 != 0) goto L4d
            com.coinbase.wallet.core.extensions.Strings r4 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r4 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r4)
            goto L4d
        L4b:
            r4 = r19
        L4d:
            r9 = r0 & 32
            if (r9 == 0) goto L5c
            com.coinbase.wallet.common.utilities.Locales r9 = com.coinbase.wallet.common.utilities.Locales.INSTANCE
            java.util.Locale r9 = r9.getCurrent()
            com.coinbase.wallet.blockchains.models.CurrencyCode r9 = com.coinbase.wallet.common.extensions.Locale_CommonKt.getCurrencyCode(r9)
            goto L5e
        L5c:
            r9 = r20
        L5e:
            r10 = r0 & 64
            if (r10 == 0) goto L63
            goto L65
        L63:
            r5 = r21
        L65:
            r10 = r0 & 128(0x80, float:1.8E-43)
            if (r10 == 0) goto L73
            com.coinbase.wallet.common.utilities.LocalizedStrings r10 = com.coinbase.wallet.common.utilities.LocalizedStrings.INSTANCE
            r11 = 2131952074(0x7f1301ca, float:1.954058E38)
            java.lang.String r10 = r10.get(r11)
            goto L75
        L73:
            r10 = r23
        L75:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L83
            com.coinbase.wallet.common.utilities.LocalizedStrings r11 = com.coinbase.wallet.common.utilities.LocalizedStrings.INSTANCE
            r12 = 2131952075(0x7f1301cb, float:1.9540583E38)
            java.lang.String r11 = r11.get(r12)
            goto L85
        L83:
            r11 = r24
        L85:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L8b
            r0 = 0
            goto L8d
        L8b:
            r0 = r25
        L8d:
            r14 = r13
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r7
            r20 = r4
            r21 = r9
            r22 = r5
            r24 = r10
            r25 = r11
            r26 = r0
            r14.<init>(r15, r16, r17, r18, r20, r21, r22, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.lend.models.LendDashboardState.<init>(java.lang.String, java.lang.String, java.lang.String, double, java.lang.String, com.coinbase.wallet.blockchains.models.CurrencyCode, double, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}