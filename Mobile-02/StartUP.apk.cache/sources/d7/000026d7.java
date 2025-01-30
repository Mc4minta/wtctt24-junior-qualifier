package com.coinbase.wallet.swap.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SwapAsset.kt */
@JsonClass(generateAdapter = false)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u000e\b\u0001\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018¢\u0006\u0004\b;\u0010<J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ`\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\n2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001e\u001a\u00020\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010 \u001a\u00020\u00042\u000e\b\u0003\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b$\u0010\tJ\u0010\u0010%\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b%\u0010\u0012J\u0010\u0010&\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b&\u0010\u0012J \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b+\u0010,R\u0019\u0010\u001b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010\tR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b0\u0010\u000fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b2\u0010\u0015R\u0019\u0010 \u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b4\u0010\u0017R\u0019\u0010\u001e\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b6\u0010\u0012R\u0019\u0010\u001c\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b8\u0010\fR\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188\u0006@\u0006¢\u0006\f\n\u0004\b!\u00109\u001a\u0004\b:\u0010\u001a¨\u0006="}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapAsset;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component2", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "component3", "()Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "", "component4", "()I", "Ljava/net/URL;", "component5", "()Ljava/net/URL;", "component6", "()Z", "", "component7", "()Ljava/util/List;", ApiConstants.NAME, AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "decimals", "imageURL", "swappable", "aggregatorIDs", "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;ILjava/net/URL;ZLjava/util/List;)Lcom/coinbase/wallet/swap/models/SwapAsset;", "toString", "hashCode", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getName", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "getContractAddress", "Ljava/net/URL;", "getImageURL", "Z", "getSwappable", "I", "getDecimals", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Ljava/util/List;", "getAggregatorIDs", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/ethereum/models/ContractAddress;ILjava/net/URL;ZLjava/util/List;)V", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SwapAsset implements Parcelable {
    public static final Parcelable.Creator<SwapAsset> CREATOR = new Creator();
    private final List<String> aggregatorIDs;
    private final ContractAddress contractAddress;
    private final CurrencyCode currencyCode;
    private final int decimals;
    private final URL imageURL;
    private final String name;
    private final boolean swappable;

    /* compiled from: SwapAsset.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<SwapAsset> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapAsset createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new SwapAsset(parcel.readString(), (CurrencyCode) parcel.readParcelable(SwapAsset.class.getClassLoader()), (ContractAddress) parcel.readParcelable(SwapAsset.class.getClassLoader()), parcel.readInt(), (URL) parcel.readSerializable(), parcel.readInt() != 0, parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SwapAsset[] newArray(int i2) {
            return new SwapAsset[i2];
        }
    }

    public SwapAsset(String name, CurrencyCode currencyCode, @Json(name = "address") ContractAddress contractAddress, int i2, URL url, boolean z, @Json(name = "aggregators") List<String> aggregatorIDs) {
        m.g(name, "name");
        m.g(currencyCode, "currencyCode");
        m.g(aggregatorIDs, "aggregatorIDs");
        this.name = name;
        this.currencyCode = currencyCode;
        this.contractAddress = contractAddress;
        this.decimals = i2;
        this.imageURL = url;
        this.swappable = z;
        this.aggregatorIDs = aggregatorIDs;
    }

    public static /* synthetic */ SwapAsset copy$default(SwapAsset swapAsset, String str, CurrencyCode currencyCode, ContractAddress contractAddress, int i2, URL url, boolean z, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = swapAsset.name;
        }
        if ((i3 & 2) != 0) {
            currencyCode = swapAsset.currencyCode;
        }
        CurrencyCode currencyCode2 = currencyCode;
        if ((i3 & 4) != 0) {
            contractAddress = swapAsset.contractAddress;
        }
        ContractAddress contractAddress2 = contractAddress;
        if ((i3 & 8) != 0) {
            i2 = swapAsset.decimals;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            url = swapAsset.imageURL;
        }
        URL url2 = url;
        if ((i3 & 32) != 0) {
            z = swapAsset.swappable;
        }
        boolean z2 = z;
        List<String> list2 = list;
        if ((i3 & 64) != 0) {
            list2 = swapAsset.aggregatorIDs;
        }
        return swapAsset.copy(str, currencyCode2, contractAddress2, i4, url2, z2, list2);
    }

    public final String component1() {
        return this.name;
    }

    public final CurrencyCode component2() {
        return this.currencyCode;
    }

    public final ContractAddress component3() {
        return this.contractAddress;
    }

    public final int component4() {
        return this.decimals;
    }

    public final URL component5() {
        return this.imageURL;
    }

    public final boolean component6() {
        return this.swappable;
    }

    public final List<String> component7() {
        return this.aggregatorIDs;
    }

    public final SwapAsset copy(String name, CurrencyCode currencyCode, @Json(name = "address") ContractAddress contractAddress, int i2, URL url, boolean z, @Json(name = "aggregators") List<String> aggregatorIDs) {
        m.g(name, "name");
        m.g(currencyCode, "currencyCode");
        m.g(aggregatorIDs, "aggregatorIDs");
        return new SwapAsset(name, currencyCode, contractAddress, i2, url, z, aggregatorIDs);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        ContractAddress contractAddress;
        SwapAsset swapAsset = obj instanceof SwapAsset ? (SwapAsset) obj : null;
        if (swapAsset == null) {
            return false;
        }
        ContractAddress contractAddress2 = this.contractAddress;
        if (contractAddress2 == null || (contractAddress = swapAsset.contractAddress) == null) {
            return !((contractAddress2 == null) ^ (swapAsset.contractAddress == null)) && m.c(this.name, swapAsset.name) && m.c(this.currencyCode, swapAsset.currencyCode) && this.decimals == swapAsset.decimals;
        }
        return m.c(contractAddress2, contractAddress);
    }

    public final List<String> getAggregatorIDs() {
        return this.aggregatorIDs;
    }

    public final ContractAddress getContractAddress() {
        return this.contractAddress;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final URL getImageURL() {
        return this.imageURL;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getSwappable() {
        return this.swappable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.currencyCode.hashCode()) * 31;
        ContractAddress contractAddress = this.contractAddress;
        int hashCode2 = (((hashCode + (contractAddress == null ? 0 : contractAddress.hashCode())) * 31) + this.decimals) * 31;
        URL url = this.imageURL;
        int hashCode3 = (hashCode2 + (url != null ? url.hashCode() : 0)) * 31;
        boolean z = this.swappable;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return ((hashCode3 + i2) * 31) + this.aggregatorIDs.hashCode();
    }

    public String toString() {
        return "SwapAsset(name=" + this.name + ", currencyCode=" + this.currencyCode + ", contractAddress=" + this.contractAddress + ", decimals=" + this.decimals + ", imageURL=" + this.imageURL + ", swappable=" + this.swappable + ", aggregatorIDs=" + this.aggregatorIDs + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.name);
        out.writeParcelable(this.currencyCode, i2);
        out.writeParcelable(this.contractAddress, i2);
        out.writeInt(this.decimals);
        out.writeSerializable(this.imageURL);
        out.writeInt(this.swappable ? 1 : 0);
        out.writeStringList(this.aggregatorIDs);
    }
}