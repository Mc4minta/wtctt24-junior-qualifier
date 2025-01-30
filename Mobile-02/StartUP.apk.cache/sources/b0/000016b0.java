package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerTransferMethodItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/consumer/models/PlaceholderTransferItem;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PlaceholderTransferItem extends ConsumerTransferMethodItem {
    public static final PlaceholderTransferItem INSTANCE = new PlaceholderTransferItem();
    public static final Parcelable.Creator<PlaceholderTransferItem> CREATOR = new Creator();

    /* compiled from: ConsumerTransferMethodItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<PlaceholderTransferItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlaceholderTransferItem createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            parcel.readInt();
            return PlaceholderTransferItem.INSTANCE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PlaceholderTransferItem[] newArray(int i2) {
            return new PlaceholderTransferItem[i2];
        }
    }

    private PlaceholderTransferItem() {
        super(null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeInt(1);
    }
}