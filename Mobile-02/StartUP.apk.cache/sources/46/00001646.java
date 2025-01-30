package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerTransferMethodItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJf\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b#\u0010\u001eJ \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b(\u0010)R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010.\u001a\u0004\b/\u0010\fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b0\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b1\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b\u0019\u0010\u000fR\u0019\u0010\u0018\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b3\u0010\u000fR\u0019\u0010\u0017\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00102\u001a\u0004\b4\u0010\u000f¨\u00067"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AvailableTransferItem;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "component1", "()Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "", "component6", "()Z", "component7", "component8", "availableTransfer", ApiConstants.NAME, "subtext", "iconUrl", "iconRes", "hasWarning", "clickable", "isLoading", "copy", "(Lcom/coinbase/wallet/consumer/models/AvailableTransfer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZZ)Lcom/coinbase/wallet/consumer/models/AvailableTransferItem;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSubtext", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "getAvailableTransfer", "Ljava/lang/Integer;", "getIconRes", "getIconUrl", "getName", "Z", "getClickable", "getHasWarning", "<init>", "(Lcom/coinbase/wallet/consumer/models/AvailableTransfer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZZ)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AvailableTransferItem extends ConsumerTransferMethodItem {
    public static final Parcelable.Creator<AvailableTransferItem> CREATOR = new Creator();
    private final AvailableTransfer availableTransfer;
    private final boolean clickable;
    private final boolean hasWarning;
    private final Integer iconRes;
    private final String iconUrl;
    private final boolean isLoading;
    private final String name;
    private final String subtext;

    /* compiled from: ConsumerTransferMethodItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<AvailableTransferItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableTransferItem createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new AvailableTransferItem((AvailableTransfer) parcel.readParcelable(AvailableTransferItem.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableTransferItem[] newArray(int i2) {
            return new AvailableTransferItem[i2];
        }
    }

    public /* synthetic */ AvailableTransferItem(AvailableTransfer availableTransfer, String str, String str2, String str3, Integer num, boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(availableTransfer, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : num, z, z2, (i2 & 128) != 0 ? false : z3);
    }

    public final AvailableTransfer component1() {
        return this.availableTransfer;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.subtext;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final Integer component5() {
        return this.iconRes;
    }

    public final boolean component6() {
        return this.hasWarning;
    }

    public final boolean component7() {
        return this.clickable;
    }

    public final boolean component8() {
        return this.isLoading;
    }

    public final AvailableTransferItem copy(AvailableTransfer availableTransfer, String name, String str, String str2, Integer num, boolean z, boolean z2, boolean z3) {
        m.g(availableTransfer, "availableTransfer");
        m.g(name, "name");
        return new AvailableTransferItem(availableTransfer, name, str, str2, num, z, z2, z3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvailableTransferItem) {
            AvailableTransferItem availableTransferItem = (AvailableTransferItem) obj;
            return m.c(this.availableTransfer, availableTransferItem.availableTransfer) && m.c(this.name, availableTransferItem.name) && m.c(this.subtext, availableTransferItem.subtext) && m.c(this.iconUrl, availableTransferItem.iconUrl) && m.c(this.iconRes, availableTransferItem.iconRes) && this.hasWarning == availableTransferItem.hasWarning && this.clickable == availableTransferItem.clickable && this.isLoading == availableTransferItem.isLoading;
        }
        return false;
    }

    public final AvailableTransfer getAvailableTransfer() {
        return this.availableTransfer;
    }

    public final boolean getClickable() {
        return this.clickable;
    }

    public final boolean getHasWarning() {
        return this.hasWarning;
    }

    public final Integer getIconRes() {
        return this.iconRes;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSubtext() {
        return this.subtext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.availableTransfer.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.subtext;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.iconUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.iconRes;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z = this.hasWarning;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode4 + i2) * 31;
        boolean z2 = this.clickable;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.isLoading;
        return i5 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "AvailableTransferItem(availableTransfer=" + this.availableTransfer + ", name=" + this.name + ", subtext=" + ((Object) this.subtext) + ", iconUrl=" + ((Object) this.iconUrl) + ", iconRes=" + this.iconRes + ", hasWarning=" + this.hasWarning + ", clickable=" + this.clickable + ", isLoading=" + this.isLoading + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        int intValue;
        m.g(out, "out");
        out.writeParcelable(this.availableTransfer, i2);
        out.writeString(this.name);
        out.writeString(this.subtext);
        out.writeString(this.iconUrl);
        Integer num = this.iconRes;
        if (num == null) {
            intValue = 0;
        } else {
            out.writeInt(1);
            intValue = num.intValue();
        }
        out.writeInt(intValue);
        out.writeInt(this.hasWarning ? 1 : 0);
        out.writeInt(this.clickable ? 1 : 0);
        out.writeInt(this.isLoading ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvailableTransferItem(AvailableTransfer availableTransfer, String name, String str, String str2, Integer num, boolean z, boolean z2, boolean z3) {
        super(null);
        m.g(availableTransfer, "availableTransfer");
        m.g(name, "name");
        this.availableTransfer = availableTransfer;
        this.name = name;
        this.subtext = str;
        this.iconUrl = str2;
        this.iconRes = num;
        this.hasWarning = z;
        this.clickable = z2;
        this.isLoading = z3;
    }
}