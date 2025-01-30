package com.toshi.model.local.room;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CollectibleType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJN\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\tJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\tJ \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b \u0010!R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\tR\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b)\u0010\t¨\u0006,"}, d2 = {"Lcom/toshi/model/local/room/CollectibleType;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "component5", "component6", ApiConstants.NAME, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "address", "count", "image", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)Lcom/toshi/model/local/room/CollectibleType;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getName", "getContractAddress", "getImage", "getAddress", "I", "getChainId", "getCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CollectibleType implements Parcelable {
    public static final Parcelable.Creator<CollectibleType> CREATOR = new Creator();
    private final String address;
    private final int chainId;
    private final String contractAddress;
    private final int count;
    private final String image;
    private final String name;

    /* compiled from: CollectibleType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CollectibleType> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CollectibleType createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new CollectibleType(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CollectibleType[] newArray(int i2) {
            return new CollectibleType[i2];
        }
    }

    public CollectibleType(String name, String contractAddress, String address, int i2, String str, int i3) {
        m.g(name, "name");
        m.g(contractAddress, "contractAddress");
        m.g(address, "address");
        this.name = name;
        this.contractAddress = contractAddress;
        this.address = address;
        this.count = i2;
        this.image = str;
        this.chainId = i3;
    }

    public static /* synthetic */ CollectibleType copy$default(CollectibleType collectibleType, String str, String str2, String str3, int i2, String str4, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = collectibleType.name;
        }
        if ((i4 & 2) != 0) {
            str2 = collectibleType.contractAddress;
        }
        String str5 = str2;
        if ((i4 & 4) != 0) {
            str3 = collectibleType.address;
        }
        String str6 = str3;
        if ((i4 & 8) != 0) {
            i2 = collectibleType.count;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            str4 = collectibleType.image;
        }
        String str7 = str4;
        if ((i4 & 32) != 0) {
            i3 = collectibleType.chainId;
        }
        return collectibleType.copy(str, str5, str6, i5, str7, i3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.contractAddress;
    }

    public final String component3() {
        return this.address;
    }

    public final int component4() {
        return this.count;
    }

    public final String component5() {
        return this.image;
    }

    public final int component6() {
        return this.chainId;
    }

    public final CollectibleType copy(String name, String contractAddress, String address, int i2, String str, int i3) {
        m.g(name, "name");
        m.g(contractAddress, "contractAddress");
        m.g(address, "address");
        return new CollectibleType(name, contractAddress, address, i2, str, i3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CollectibleType) {
            CollectibleType collectibleType = (CollectibleType) obj;
            return m.c(this.name, collectibleType.name) && m.c(this.contractAddress, collectibleType.contractAddress) && m.c(this.address, collectibleType.address) && this.count == collectibleType.count && m.c(this.image, collectibleType.image) && this.chainId == collectibleType.chainId;
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = ((((((this.name.hashCode() * 31) + this.contractAddress.hashCode()) * 31) + this.address.hashCode()) * 31) + this.count) * 31;
        String str = this.image;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.chainId;
    }

    public String toString() {
        return "CollectibleType(name=" + this.name + ", contractAddress=" + this.contractAddress + ", address=" + this.address + ", count=" + this.count + ", image=" + ((Object) this.image) + ", chainId=" + this.chainId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.name);
        out.writeString(this.contractAddress);
        out.writeString(this.address);
        out.writeInt(this.count);
        out.writeString(this.image);
        out.writeInt(this.chainId);
    }
}