package com.coinbase.wallet.features.swap.models;

import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: SwapAssetPickerViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\r\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerViewState;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Z", MessageBundle.TITLE_ENTRY, "emptyStateTitle", "emptyStateDescription", "isLoading", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/coinbase/wallet/features/swap/models/SwapAssetPickerViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getTitle", "getEmptyStateDescription", "getEmptyStateTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAssetPickerViewState {
    private final String emptyStateDescription;
    private final String emptyStateTitle;
    private final boolean isLoading;
    private final String title;

    public SwapAssetPickerViewState() {
        this(null, null, null, false, 15, null);
    }

    public SwapAssetPickerViewState(String title, String emptyStateTitle, String emptyStateDescription, boolean z) {
        m.g(title, "title");
        m.g(emptyStateTitle, "emptyStateTitle");
        m.g(emptyStateDescription, "emptyStateDescription");
        this.title = title;
        this.emptyStateTitle = emptyStateTitle;
        this.emptyStateDescription = emptyStateDescription;
        this.isLoading = z;
    }

    public static /* synthetic */ SwapAssetPickerViewState copy$default(SwapAssetPickerViewState swapAssetPickerViewState, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = swapAssetPickerViewState.title;
        }
        if ((i2 & 2) != 0) {
            str2 = swapAssetPickerViewState.emptyStateTitle;
        }
        if ((i2 & 4) != 0) {
            str3 = swapAssetPickerViewState.emptyStateDescription;
        }
        if ((i2 & 8) != 0) {
            z = swapAssetPickerViewState.isLoading;
        }
        return swapAssetPickerViewState.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.emptyStateTitle;
    }

    public final String component3() {
        return this.emptyStateDescription;
    }

    public final boolean component4() {
        return this.isLoading;
    }

    public final SwapAssetPickerViewState copy(String title, String emptyStateTitle, String emptyStateDescription, boolean z) {
        m.g(title, "title");
        m.g(emptyStateTitle, "emptyStateTitle");
        m.g(emptyStateDescription, "emptyStateDescription");
        return new SwapAssetPickerViewState(title, emptyStateTitle, emptyStateDescription, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SwapAssetPickerViewState) {
            SwapAssetPickerViewState swapAssetPickerViewState = (SwapAssetPickerViewState) obj;
            return m.c(this.title, swapAssetPickerViewState.title) && m.c(this.emptyStateTitle, swapAssetPickerViewState.emptyStateTitle) && m.c(this.emptyStateDescription, swapAssetPickerViewState.emptyStateDescription) && this.isLoading == swapAssetPickerViewState.isLoading;
        }
        return false;
    }

    public final String getEmptyStateDescription() {
        return this.emptyStateDescription;
    }

    public final String getEmptyStateTitle() {
        return this.emptyStateTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.emptyStateTitle.hashCode()) * 31) + this.emptyStateDescription.hashCode()) * 31;
        boolean z = this.isLoading;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "SwapAssetPickerViewState(title=" + this.title + ", emptyStateTitle=" + this.emptyStateTitle + ", emptyStateDescription=" + this.emptyStateDescription + ", isLoading=" + this.isLoading + ')';
    }

    public /* synthetic */ SwapAssetPickerViewState(String str, String str2, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, (i2 & 2) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str2, (i2 & 4) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str3, (i2 & 8) != 0 ? false : z);
    }
}