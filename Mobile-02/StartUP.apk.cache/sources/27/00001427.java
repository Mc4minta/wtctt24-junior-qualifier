package com.coinbase.wallet.blockchains.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Wallet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u007f\b\u0000\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\f\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010)\u001a\u00020\u0013\u0012\u0006\u0010*\u001a\u00020\u0016\u0012\u0006\u0010+\u001a\u00020\u0019\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010-\u001a\u00020\u001d\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bU\u0010VBy\b\u0016\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\f\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010)\u001a\u00020\u0013\u0012\u0006\u0010*\u001a\u00020\u0016\u0012\u0006\u0010+\u001a\u00020\u0019\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010-\u001a\u00020\u001d\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bU\u0010WJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0015J\u0010\u0010\u001e\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b \u0010!J \u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u00192\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010-\u001a\u00020\u001d2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b1\u0010\u0005J\u0010\u00102\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b2\u0010\u0018J\u001a\u00106\u001a\u0002052\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b8\u0010\u0018J \u0010=\u001a\u00020<2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b=\u0010>R\u001c\u0010+\u001a\u00020\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010?\u001a\u0004\b@\u0010\u001bR\u001c\u0010*\u001a\u00020\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010A\u001a\u0004\bB\u0010\u0018R\u001c\u0010)\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010C\u001a\u0004\bD\u0010\u0015R\u001e\u0010(\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010E\u001a\u0004\bF\u0010\u0012R\u001e\u0010'\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010G\u001a\u0004\bH\u0010\u0005R\u001e\u0010.\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010I\u001a\u0004\bJ\u0010!R\u001c\u0010%\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010G\u001a\u0004\bK\u0010\u0005R\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010L\u001a\u0004\bM\u0010\nR\u001c\u0010-\u001a\u00020\u001d8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010N\u001a\u0004\bO\u0010\u001fR\u001c\u0010\"\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\"\u0010G\u001a\u0004\bP\u0010\u0005R\u001c\u0010#\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010G\u001a\u0004\bQ\u0010\u0005R\u001c\u0010&\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010R\u001a\u0004\bS\u0010\u000eR\u001e\u0010,\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010C\u001a\u0004\bT\u0010\u0015¨\u0006Y"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "component3", "()Ljava/util/List;", "component4", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component5", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component6", "Ljava/net/URL;", "component7", "()Ljava/net/URL;", "Ljava/math/BigInteger;", "component8", "()Ljava/math/BigInteger;", "", "component9", "()I", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component10", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component11", "Lcom/coinbase/wallet/blockchains/models/Network;", "component12", "()Lcom/coinbase/wallet/blockchains/models/Network;", "component13", "()Ljava/lang/Integer;", "id", "primaryAddress", ApiConstants.ADDRESSES, "displayName", AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "imageURL", "balance", "decimals", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "minimumBalance", "network", "selectedIndex", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/net/URL;Ljava/math/BigInteger;ILcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/Integer;)Lcom/coinbase/wallet/blockchains/models/Wallet;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "I", "getDecimals", "Ljava/math/BigInteger;", "getBalance", "Ljava/net/URL;", "getImageURL", "Ljava/lang/String;", "getContractAddress", "Ljava/lang/Integer;", "getSelectedIndex", "getDisplayName", "Ljava/util/List;", "getAddresses", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "getId", "getPrimaryAddress", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "getMinimumBalance", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Ljava/net/URL;Ljava/math/BigInteger;ILcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/Integer;)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/net/URL;Ljava/math/BigInteger;ILcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;Ljava/lang/Integer;)V", "Companion", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Wallet implements DatabaseModelObject, Parcelable {
    private final List<WalletAddress> addresses;
    private final BigInteger balance;
    private final Blockchain blockchain;
    private final String contractAddress;
    private final CurrencyCode currencyCode;
    private final int decimals;
    private final String displayName;
    private final String id;
    private final URL imageURL;
    private final BigInteger minimumBalance;
    private final Network network;
    private final String primaryAddress;
    private final Integer selectedIndex;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Wallet> CREATOR = new Creator();

    /* compiled from: Wallet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet$Companion;", "", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "", "selectedIndex", "generateID", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String generateID(Blockchain blockchain, CurrencyCode currencyCode, Network network, String str, Integer num) {
            List l2;
            String h0;
            String[] strArr = new String[5];
            strArr[0] = blockchain.getRawValue();
            strArr[1] = currencyCode.getRawValue();
            strArr[2] = network.getRawValue();
            strArr[3] = str;
            strArr[4] = num == null ? null : num.toString();
            l2 = r.l(strArr);
            h0 = z.h0(l2, "/", null, null, 0, null, null, 62, null);
            return h0;
        }
    }

    /* compiled from: Wallet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Wallet> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Wallet createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 != readInt; i2++) {
                arrayList.add(WalletAddress.CREATOR.createFromParcel(parcel));
            }
            return new Wallet(readString, readString2, arrayList, parcel.readString(), CurrencyCode.CREATOR.createFromParcel(parcel), parcel.readString(), (URL) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), parcel.readInt(), Blockchain.CREATOR.createFromParcel(parcel), (BigInteger) parcel.readSerializable(), Network.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Wallet[] newArray(int i2) {
            return new Wallet[i2];
        }
    }

    public Wallet(String id, String primaryAddress, List<WalletAddress> addresses, String displayName, CurrencyCode currencyCode, String str, URL url, BigInteger balance, int i2, Blockchain blockchain, BigInteger bigInteger, Network network, Integer num) {
        m.g(id, "id");
        m.g(primaryAddress, "primaryAddress");
        m.g(addresses, "addresses");
        m.g(displayName, "displayName");
        m.g(currencyCode, "currencyCode");
        m.g(balance, "balance");
        m.g(blockchain, "blockchain");
        m.g(network, "network");
        this.id = id;
        this.primaryAddress = primaryAddress;
        this.addresses = addresses;
        this.displayName = displayName;
        this.currencyCode = currencyCode;
        this.contractAddress = str;
        this.imageURL = url;
        this.balance = balance;
        this.decimals = i2;
        this.blockchain = blockchain;
        this.minimumBalance = bigInteger;
        this.network = network;
        this.selectedIndex = num;
    }

    public final String component1() {
        return getId();
    }

    public final Blockchain component10() {
        return this.blockchain;
    }

    public final BigInteger component11() {
        return this.minimumBalance;
    }

    public final Network component12() {
        return this.network;
    }

    public final Integer component13() {
        return this.selectedIndex;
    }

    public final String component2() {
        return this.primaryAddress;
    }

    public final List<WalletAddress> component3() {
        return this.addresses;
    }

    public final String component4() {
        return this.displayName;
    }

    public final CurrencyCode component5() {
        return this.currencyCode;
    }

    public final String component6() {
        return this.contractAddress;
    }

    public final URL component7() {
        return this.imageURL;
    }

    public final BigInteger component8() {
        return this.balance;
    }

    public final int component9() {
        return this.decimals;
    }

    public final Wallet copy(String id, String primaryAddress, List<WalletAddress> addresses, String displayName, CurrencyCode currencyCode, String str, URL url, BigInteger balance, int i2, Blockchain blockchain, BigInteger bigInteger, Network network, Integer num) {
        m.g(id, "id");
        m.g(primaryAddress, "primaryAddress");
        m.g(addresses, "addresses");
        m.g(displayName, "displayName");
        m.g(currencyCode, "currencyCode");
        m.g(balance, "balance");
        m.g(blockchain, "blockchain");
        m.g(network, "network");
        return new Wallet(id, primaryAddress, addresses, displayName, currencyCode, str, url, balance, i2, blockchain, bigInteger, network, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Wallet) {
            Wallet wallet = (Wallet) obj;
            return m.c(getId(), wallet.getId()) && m.c(this.primaryAddress, wallet.primaryAddress) && m.c(this.addresses, wallet.addresses) && m.c(this.displayName, wallet.displayName) && m.c(this.currencyCode, wallet.currencyCode) && m.c(this.contractAddress, wallet.contractAddress) && m.c(this.imageURL, wallet.imageURL) && m.c(this.balance, wallet.balance) && this.decimals == wallet.decimals && m.c(this.blockchain, wallet.blockchain) && m.c(this.minimumBalance, wallet.minimumBalance) && m.c(this.network, wallet.network) && m.c(this.selectedIndex, wallet.selectedIndex);
        }
        return false;
    }

    public final List<WalletAddress> getAddresses() {
        return this.addresses;
    }

    public final BigInteger getBalance() {
        return this.balance;
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final URL getImageURL() {
        return this.imageURL;
    }

    public final BigInteger getMinimumBalance() {
        return this.minimumBalance;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final String getPrimaryAddress() {
        return this.primaryAddress;
    }

    public final Integer getSelectedIndex() {
        return this.selectedIndex;
    }

    public int hashCode() {
        int hashCode = ((((((((getId().hashCode() * 31) + this.primaryAddress.hashCode()) * 31) + this.addresses.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.currencyCode.hashCode()) * 31;
        String str = this.contractAddress;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        URL url = this.imageURL;
        int hashCode3 = (((((((hashCode2 + (url == null ? 0 : url.hashCode())) * 31) + this.balance.hashCode()) * 31) + this.decimals) * 31) + this.blockchain.hashCode()) * 31;
        BigInteger bigInteger = this.minimumBalance;
        int hashCode4 = (((hashCode3 + (bigInteger == null ? 0 : bigInteger.hashCode())) * 31) + this.network.hashCode()) * 31;
        Integer num = this.selectedIndex;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "Wallet(id=" + getId() + ", primaryAddress=" + this.primaryAddress + ", addresses=" + this.addresses + ", displayName=" + this.displayName + ", currencyCode=" + this.currencyCode + ", contractAddress=" + ((Object) this.contractAddress) + ", imageURL=" + this.imageURL + ", balance=" + this.balance + ", decimals=" + this.decimals + ", blockchain=" + this.blockchain + ", minimumBalance=" + this.minimumBalance + ", network=" + this.network + ", selectedIndex=" + this.selectedIndex + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        int intValue;
        m.g(out, "out");
        out.writeString(this.id);
        out.writeString(this.primaryAddress);
        List<WalletAddress> list = this.addresses;
        out.writeInt(list.size());
        for (WalletAddress walletAddress : list) {
            walletAddress.writeToParcel(out, i2);
        }
        out.writeString(this.displayName);
        this.currencyCode.writeToParcel(out, i2);
        out.writeString(this.contractAddress);
        out.writeSerializable(this.imageURL);
        out.writeSerializable(this.balance);
        out.writeInt(this.decimals);
        this.blockchain.writeToParcel(out, i2);
        out.writeSerializable(this.minimumBalance);
        this.network.writeToParcel(out, i2);
        Integer num = this.selectedIndex;
        if (num == null) {
            intValue = 0;
        } else {
            out.writeInt(1);
            intValue = num.intValue();
        }
        out.writeInt(intValue);
    }

    public /* synthetic */ Wallet(String str, List list, String str2, CurrencyCode currencyCode, URL url, BigInteger bigInteger, int i2, Blockchain blockchain, BigInteger bigInteger2, Network network, String str3, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2, currencyCode, url, bigInteger, i2, blockchain, bigInteger2, network, (i3 & 1024) != 0 ? null : str3, num);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Wallet(String primaryAddress, List<WalletAddress> addresses, String displayName, CurrencyCode currencyCode, URL url, BigInteger balance, int i2, Blockchain blockchain, BigInteger bigInteger, Network network, String str, Integer num) {
        this(Companion.generateID(blockchain, currencyCode, network, str, num), primaryAddress, addresses, displayName, currencyCode, str, url, balance, i2, blockchain, bigInteger, network, num);
        m.g(primaryAddress, "primaryAddress");
        m.g(addresses, "addresses");
        m.g(displayName, "displayName");
        m.g(currencyCode, "currencyCode");
        m.g(balance, "balance");
        m.g(blockchain, "blockchain");
        m.g(network, "network");
    }
}