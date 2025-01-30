package com.coinbase.wallet.consumer.models;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerOnboardingViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\bR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\"\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b#\u0010\bR\u0019\u0010\u0012\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b$\u0010\bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewState;", "", "", "component1", "()Z", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "showLoading", "showPrivacyNotice", "privacyTitle", "privacyBody", "loginButtonText", "secondaryButtonText", "secondaryButtonProgressVisible", "copy", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSecondaryButtonProgressVisible", "getShowPrivacyNotice", "Ljava/lang/String;", "getPrivacyTitle", "getLoginButtonText", "getPrivacyBody", "getSecondaryButtonText", "getShowLoading", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerOnboardingViewState {
    private final String loginButtonText;
    private final String privacyBody;
    private final String privacyTitle;
    private final boolean secondaryButtonProgressVisible;
    private final String secondaryButtonText;
    private final boolean showLoading;
    private final boolean showPrivacyNotice;

    public ConsumerOnboardingViewState() {
        this(false, false, null, null, null, null, false, 127, null);
    }

    public ConsumerOnboardingViewState(boolean z, boolean z2, String privacyTitle, String privacyBody, String loginButtonText, String secondaryButtonText, boolean z3) {
        m.g(privacyTitle, "privacyTitle");
        m.g(privacyBody, "privacyBody");
        m.g(loginButtonText, "loginButtonText");
        m.g(secondaryButtonText, "secondaryButtonText");
        this.showLoading = z;
        this.showPrivacyNotice = z2;
        this.privacyTitle = privacyTitle;
        this.privacyBody = privacyBody;
        this.loginButtonText = loginButtonText;
        this.secondaryButtonText = secondaryButtonText;
        this.secondaryButtonProgressVisible = z3;
    }

    public static /* synthetic */ ConsumerOnboardingViewState copy$default(ConsumerOnboardingViewState consumerOnboardingViewState, boolean z, boolean z2, String str, String str2, String str3, String str4, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = consumerOnboardingViewState.showLoading;
        }
        if ((i2 & 2) != 0) {
            z2 = consumerOnboardingViewState.showPrivacyNotice;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            str = consumerOnboardingViewState.privacyTitle;
        }
        String str5 = str;
        if ((i2 & 8) != 0) {
            str2 = consumerOnboardingViewState.privacyBody;
        }
        String str6 = str2;
        if ((i2 & 16) != 0) {
            str3 = consumerOnboardingViewState.loginButtonText;
        }
        String str7 = str3;
        if ((i2 & 32) != 0) {
            str4 = consumerOnboardingViewState.secondaryButtonText;
        }
        String str8 = str4;
        if ((i2 & 64) != 0) {
            z3 = consumerOnboardingViewState.secondaryButtonProgressVisible;
        }
        return consumerOnboardingViewState.copy(z, z4, str5, str6, str7, str8, z3);
    }

    public final boolean component1() {
        return this.showLoading;
    }

    public final boolean component2() {
        return this.showPrivacyNotice;
    }

    public final String component3() {
        return this.privacyTitle;
    }

    public final String component4() {
        return this.privacyBody;
    }

    public final String component5() {
        return this.loginButtonText;
    }

    public final String component6() {
        return this.secondaryButtonText;
    }

    public final boolean component7() {
        return this.secondaryButtonProgressVisible;
    }

    public final ConsumerOnboardingViewState copy(boolean z, boolean z2, String privacyTitle, String privacyBody, String loginButtonText, String secondaryButtonText, boolean z3) {
        m.g(privacyTitle, "privacyTitle");
        m.g(privacyBody, "privacyBody");
        m.g(loginButtonText, "loginButtonText");
        m.g(secondaryButtonText, "secondaryButtonText");
        return new ConsumerOnboardingViewState(z, z2, privacyTitle, privacyBody, loginButtonText, secondaryButtonText, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerOnboardingViewState) {
            ConsumerOnboardingViewState consumerOnboardingViewState = (ConsumerOnboardingViewState) obj;
            return this.showLoading == consumerOnboardingViewState.showLoading && this.showPrivacyNotice == consumerOnboardingViewState.showPrivacyNotice && m.c(this.privacyTitle, consumerOnboardingViewState.privacyTitle) && m.c(this.privacyBody, consumerOnboardingViewState.privacyBody) && m.c(this.loginButtonText, consumerOnboardingViewState.loginButtonText) && m.c(this.secondaryButtonText, consumerOnboardingViewState.secondaryButtonText) && this.secondaryButtonProgressVisible == consumerOnboardingViewState.secondaryButtonProgressVisible;
        }
        return false;
    }

    public final String getLoginButtonText() {
        return this.loginButtonText;
    }

    public final String getPrivacyBody() {
        return this.privacyBody;
    }

    public final String getPrivacyTitle() {
        return this.privacyTitle;
    }

    public final boolean getSecondaryButtonProgressVisible() {
        return this.secondaryButtonProgressVisible;
    }

    public final String getSecondaryButtonText() {
        return this.secondaryButtonText;
    }

    public final boolean getShowLoading() {
        return this.showLoading;
    }

    public final boolean getShowPrivacyNotice() {
        return this.showPrivacyNotice;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.showLoading;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        ?? r2 = this.showPrivacyNotice;
        int i3 = r2;
        if (r2 != 0) {
            i3 = 1;
        }
        int hashCode = (((((((((i2 + i3) * 31) + this.privacyTitle.hashCode()) * 31) + this.privacyBody.hashCode()) * 31) + this.loginButtonText.hashCode()) * 31) + this.secondaryButtonText.hashCode()) * 31;
        boolean z2 = this.secondaryButtonProgressVisible;
        return hashCode + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "ConsumerOnboardingViewState(showLoading=" + this.showLoading + ", showPrivacyNotice=" + this.showPrivacyNotice + ", privacyTitle=" + this.privacyTitle + ", privacyBody=" + this.privacyBody + ", loginButtonText=" + this.loginButtonText + ", secondaryButtonText=" + this.secondaryButtonText + ", secondaryButtonProgressVisible=" + this.secondaryButtonProgressVisible + ')';
    }

    public /* synthetic */ ConsumerOnboardingViewState(boolean z, boolean z2, String str, String str2, String str3, String str4, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, (i2 & 8) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str2, (i2 & 16) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str3, (i2 & 32) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str4, (i2 & 64) == 0 ? z3 : false);
    }
}