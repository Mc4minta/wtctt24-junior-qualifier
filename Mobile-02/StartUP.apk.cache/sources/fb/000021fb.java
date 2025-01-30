package com.coinbase.wallet.features.swap.models;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;
import org.toshi.R;

/* compiled from: SwapUserAgreementViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapUserAgreementViewState;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "illustrationID", MessageBundle.TITLE_ENTRY, "body", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/swap/models/SwapUserAgreementViewState;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getBody", "I", "getIllustrationID", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapUserAgreementViewState {
    private final String body;
    private final int illustrationID;
    private final String title;

    public SwapUserAgreementViewState() {
        this(0, null, null, 7, null);
    }

    public SwapUserAgreementViewState(int i2, String title, String body) {
        m.g(title, "title");
        m.g(body, "body");
        this.illustrationID = i2;
        this.title = title;
        this.body = body;
    }

    public static /* synthetic */ SwapUserAgreementViewState copy$default(SwapUserAgreementViewState swapUserAgreementViewState, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = swapUserAgreementViewState.illustrationID;
        }
        if ((i3 & 2) != 0) {
            str = swapUserAgreementViewState.title;
        }
        if ((i3 & 4) != 0) {
            str2 = swapUserAgreementViewState.body;
        }
        return swapUserAgreementViewState.copy(i2, str, str2);
    }

    public final int component1() {
        return this.illustrationID;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.body;
    }

    public final SwapUserAgreementViewState copy(int i2, String title, String body) {
        m.g(title, "title");
        m.g(body, "body");
        return new SwapUserAgreementViewState(i2, title, body);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapUserAgreementViewState) {
            SwapUserAgreementViewState swapUserAgreementViewState = (SwapUserAgreementViewState) obj;
            return this.illustrationID == swapUserAgreementViewState.illustrationID && m.c(this.title, swapUserAgreementViewState.title) && m.c(this.body, swapUserAgreementViewState.body);
        }
        return false;
    }

    public final String getBody() {
        return this.body;
    }

    public final int getIllustrationID() {
        return this.illustrationID;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.illustrationID * 31) + this.title.hashCode()) * 31) + this.body.hashCode();
    }

    public String toString() {
        return "SwapUserAgreementViewState(illustrationID=" + this.illustrationID + ", title=" + this.title + ", body=" + this.body + ')';
    }

    public /* synthetic */ SwapUserAgreementViewState(int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? R.drawable.illustration_swap_disclosure : i2, (i3 & 2) != 0 ? LocalizedStrings.INSTANCE.get(R.string.swap_disclosure_title) : str, (i3 & 4) != 0 ? LocalizedStrings.INSTANCE.get(R.string.swap_disclosure_body) : str2);
    }
}