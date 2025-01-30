package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ReceivableWallet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004Jb\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\rJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b%\u0010\rJ \u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b*\u0010+R\u0019\u0010\u001a\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\u0012R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\rR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b1\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b3\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b4\u0010\rR\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00105\u001a\u0004\b6\u0010\nR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u00102\u001a\u0004\b7\u0010\u0004R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b8\u0010\u0004¨\u0006;"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/Network;", "component2", "()Lcom/coinbase/wallet/blockchains/models/Network;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component3", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "component4", "()I", "component5", "component6", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component7", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component8", ApiConstants.NAME, "network", "code", "decimals", "address", "index", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "imageURL", "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/lang/String;ILcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ReceivableWallet;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "I", "getDecimals", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "Ljava/lang/String;", "getAddress", "getIndex", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCode", "getName", "getImageURL", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/lang/String;ILcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ReceivableWallet implements Parcelable {
    public static final Parcelable.Creator<ReceivableWallet> CREATOR = new Creator();
    private final String address;
    private final Blockchain blockchain;
    private final CurrencyCode code;
    private final int decimals;
    private final String imageURL;
    private final int index;
    private final String name;
    private final Network network;

    /* compiled from: ReceivableWallet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ReceivableWallet> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReceivableWallet createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new ReceivableWallet(parcel.readString(), (Network) parcel.readParcelable(ReceivableWallet.class.getClassLoader()), (CurrencyCode) parcel.readParcelable(ReceivableWallet.class.getClassLoader()), parcel.readInt(), parcel.readString(), parcel.readInt(), (Blockchain) parcel.readParcelable(ReceivableWallet.class.getClassLoader()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReceivableWallet[] newArray(int i2) {
            return new ReceivableWallet[i2];
        }
    }

    public ReceivableWallet(String name, Network network, CurrencyCode code, int i2, String address, int i3, Blockchain blockchain, String str) {
        m.g(name, "name");
        m.g(network, "network");
        m.g(code, "code");
        m.g(address, "address");
        m.g(blockchain, "blockchain");
        this.name = name;
        this.network = network;
        this.code = code;
        this.decimals = i2;
        this.address = address;
        this.index = i3;
        this.blockchain = blockchain;
        this.imageURL = str;
    }

    public final String component1() {
        return this.name;
    }

    public final Network component2() {
        return this.network;
    }

    public final CurrencyCode component3() {
        return this.code;
    }

    public final int component4() {
        return this.decimals;
    }

    public final String component5() {
        return this.address;
    }

    public final int component6() {
        return this.index;
    }

    public final Blockchain component7() {
        return this.blockchain;
    }

    public final String component8() {
        return this.imageURL;
    }

    public final ReceivableWallet copy(String name, Network network, CurrencyCode code, int i2, String address, int i3, Blockchain blockchain, String str) {
        m.g(name, "name");
        m.g(network, "network");
        m.g(code, "code");
        m.g(address, "address");
        m.g(blockchain, "blockchain");
        return new ReceivableWallet(name, network, code, i2, address, i3, blockchain, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReceivableWallet) {
            ReceivableWallet receivableWallet = (ReceivableWallet) obj;
            return m.c(this.name, receivableWallet.name) && m.c(this.network, receivableWallet.network) && m.c(this.code, receivableWallet.code) && this.decimals == receivableWallet.decimals && m.c(this.address, receivableWallet.address) && this.index == receivableWallet.index && m.c(this.blockchain, receivableWallet.blockchain) && m.c(this.imageURL, receivableWallet.imageURL);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final CurrencyCode getCode() {
        return this.code;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final String getImageURL() {
        return this.imageURL;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.name.hashCode() * 31) + this.network.hashCode()) * 31) + this.code.hashCode()) * 31) + this.decimals) * 31) + this.address.hashCode()) * 31) + this.index) * 31) + this.blockchain.hashCode()) * 31;
        String str = this.imageURL;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ReceivableWallet(name=" + this.name + ", network=" + this.network + ", code=" + this.code + ", decimals=" + this.decimals + ", address=" + this.address + ", index=" + this.index + ", blockchain=" + this.blockchain + ", imageURL=" + ((Object) this.imageURL) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.name);
        out.writeParcelable(this.network, i2);
        out.writeParcelable(this.code, i2);
        out.writeInt(this.decimals);
        out.writeString(this.address);
        out.writeInt(this.index);
        out.writeParcelable(this.blockchain, i2);
        out.writeString(this.imageURL);
    }
}