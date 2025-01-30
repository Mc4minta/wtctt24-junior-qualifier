package com.coinbase.wallet.blockchains.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: WalletAddress.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\nJ \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "Landroid/os/Parcelable;", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "component1", "()Lcom/coinbase/wallet/blockchains/models/AddressType;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "type", "address", "index", "copy", "(Lcom/coinbase/wallet/blockchains/models/AddressType;Ljava/lang/String;I)Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getIndex", "Ljava/lang/String;", "getAddress", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "getType", "<init>", "(Lcom/coinbase/wallet/blockchains/models/AddressType;Ljava/lang/String;I)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletAddress implements Parcelable {
    public static final Parcelable.Creator<WalletAddress> CREATOR = new Creator();
    private final String address;
    private final int index;
    private final AddressType type;

    /* compiled from: WalletAddress.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<WalletAddress> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WalletAddress createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new WalletAddress(AddressType.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WalletAddress[] newArray(int i2) {
            return new WalletAddress[i2];
        }
    }

    public WalletAddress(AddressType type, String address, int i2) {
        m.g(type, "type");
        m.g(address, "address");
        this.type = type;
        this.address = address;
        this.index = i2;
    }

    public static /* synthetic */ WalletAddress copy$default(WalletAddress walletAddress, AddressType addressType, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            addressType = walletAddress.type;
        }
        if ((i3 & 2) != 0) {
            str = walletAddress.address;
        }
        if ((i3 & 4) != 0) {
            i2 = walletAddress.index;
        }
        return walletAddress.copy(addressType, str, i2);
    }

    public final AddressType component1() {
        return this.type;
    }

    public final String component2() {
        return this.address;
    }

    public final int component3() {
        return this.index;
    }

    public final WalletAddress copy(AddressType type, String address, int i2) {
        m.g(type, "type");
        m.g(address, "address");
        return new WalletAddress(type, address, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WalletAddress) {
            WalletAddress walletAddress = (WalletAddress) obj;
            return m.c(this.type, walletAddress.type) && m.c(this.address, walletAddress.address) && this.index == walletAddress.index;
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getIndex() {
        return this.index;
    }

    public final AddressType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.address.hashCode()) * 31) + this.index;
    }

    public String toString() {
        return "WalletAddress(type=" + this.type + ", address=" + this.address + ", index=" + this.index + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        this.type.writeToParcel(out, i2);
        out.writeString(this.address);
        out.writeInt(this.index);
    }
}