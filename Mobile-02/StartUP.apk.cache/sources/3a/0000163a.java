package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerTransferMethodItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AddPaymentTransferItem;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "", "component1", "()Ljava/lang/String;", ApiConstants.DESCRIPTION, "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/AddPaymentTransferItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AddPaymentTransferItem extends ConsumerTransferMethodItem {
    public static final Parcelable.Creator<AddPaymentTransferItem> CREATOR = new Creator();
    private final String description;

    /* compiled from: ConsumerTransferMethodItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<AddPaymentTransferItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddPaymentTransferItem createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new AddPaymentTransferItem(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AddPaymentTransferItem[] newArray(int i2) {
            return new AddPaymentTransferItem[i2];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPaymentTransferItem(String description) {
        super(null);
        m.g(description, "description");
        this.description = description;
    }

    public static /* synthetic */ AddPaymentTransferItem copy$default(AddPaymentTransferItem addPaymentTransferItem, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = addPaymentTransferItem.description;
        }
        return addPaymentTransferItem.copy(str);
    }

    public final String component1() {
        return this.description;
    }

    public final AddPaymentTransferItem copy(String description) {
        m.g(description, "description");
        return new AddPaymentTransferItem(description);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AddPaymentTransferItem) && m.c(this.description, ((AddPaymentTransferItem) obj).description);
    }

    public final String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return this.description.hashCode();
    }

    public String toString() {
        return "AddPaymentTransferItem(description=" + this.description + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.description);
    }
}