package com.coinbase.wallet.features.lend.models;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: UserAgreementPageItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0003\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\bJ\u001a\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000b¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/features/lend/models/UserAgreementPageItem;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "", "component4", "()Z", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "imageId", "showAgreementCheckbox", "copy", "(Ljava/lang/String;Ljava/lang/String;IZ)Lcom/coinbase/wallet/features/lend/models/UserAgreementPageItem;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getDescription", "I", "getImageId", "Z", "getShowAgreementCheckbox", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZ)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UserAgreementPageItem {
    private final String description;
    private final int imageId;
    private final boolean showAgreementCheckbox;
    private final String title;

    public UserAgreementPageItem(String title, String description, int i2, boolean z) {
        m.g(title, "title");
        m.g(description, "description");
        this.title = title;
        this.description = description;
        this.imageId = i2;
        this.showAgreementCheckbox = z;
    }

    public static /* synthetic */ UserAgreementPageItem copy$default(UserAgreementPageItem userAgreementPageItem, String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = userAgreementPageItem.title;
        }
        if ((i3 & 2) != 0) {
            str2 = userAgreementPageItem.description;
        }
        if ((i3 & 4) != 0) {
            i2 = userAgreementPageItem.imageId;
        }
        if ((i3 & 8) != 0) {
            z = userAgreementPageItem.showAgreementCheckbox;
        }
        return userAgreementPageItem.copy(str, str2, i2, z);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final int component3() {
        return this.imageId;
    }

    public final boolean component4() {
        return this.showAgreementCheckbox;
    }

    public final UserAgreementPageItem copy(String title, String description, int i2, boolean z) {
        m.g(title, "title");
        m.g(description, "description");
        return new UserAgreementPageItem(title, description, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserAgreementPageItem) {
            UserAgreementPageItem userAgreementPageItem = (UserAgreementPageItem) obj;
            return m.c(this.title, userAgreementPageItem.title) && m.c(this.description, userAgreementPageItem.description) && this.imageId == userAgreementPageItem.imageId && this.showAgreementCheckbox == userAgreementPageItem.showAgreementCheckbox;
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getImageId() {
        return this.imageId;
    }

    public final boolean getShowAgreementCheckbox() {
        return this.showAgreementCheckbox;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.imageId) * 31;
        boolean z = this.showAgreementCheckbox;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "UserAgreementPageItem(title=" + this.title + ", description=" + this.description + ", imageId=" + this.imageId + ", showAgreementCheckbox=" + this.showAgreementCheckbox + ')';
    }
}