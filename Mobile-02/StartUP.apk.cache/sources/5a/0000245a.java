package com.coinbase.wallet.lending.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LendToken.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u009d\u0001\b\u0000\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\b\u0012\u0006\u0010)\u001a\u00020\u000b\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010,\u001a\u00020\u0014\u0012\u0006\u0010-\u001a\u00020\u0014\u0012\u0006\u0010.\u001a\u00020\u0014\u0012\u0006\u0010/\u001a\u00020\u0014\u0012\u0006\u00100\u001a\u00020\u0014\u0012\u0006\u00101\u001a\u00020\u001b\u0012\u0006\u00102\u001a\u00020\u001e\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u000e\u0012\u0006\u00105\u001a\u00020\u000e\u0012\u0006\u00106\u001a\u00020\u000b¢\u0006\u0004\bf\u0010gB\u009d\u0001\b\u0016\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010h\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u000b\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010,\u001a\u00020\u0014\u0012\u0006\u0010-\u001a\u00020\u0014\u0012\u0006\u0010.\u001a\u00020\u0014\u0012\u0006\u0010/\u001a\u00020\u0014\u0012\u0006\u00100\u001a\u00020\u0014\u0012\u0006\u00101\u001a\u00020\u001b\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u000e\u0012\u0006\u00105\u001a\u00020\u000e\u0012\u0006\u00106\u001a\u00020\u000b¢\u0006\u0004\bf\u0010iJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b!\u0010\u0005J\u0010\u0010\"\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\"\u0010\u0010J\u0010\u0010#\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b#\u0010\u0010J\u0010\u0010$\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b$\u0010\rJÈ\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\u000b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010,\u001a\u00020\u00142\b\b\u0002\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u00142\b\b\u0002\u0010/\u001a\u00020\u00142\b\b\u0002\u00100\u001a\u00020\u00142\b\b\u0002\u00101\u001a\u00020\u001b2\b\b\u0002\u00102\u001a\u00020\u001e2\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b9\u0010\u0005J\u0010\u0010:\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b:\u0010\rJ\u001a\u0010=\u001a\u00020\u001b2\b\u0010<\u001a\u0004\u0018\u00010;HÖ\u0003¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b?\u0010\rJ \u0010D\u001a\u00020C2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\bD\u0010ER\u001c\u00104\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010F\u001a\u0004\bG\u0010\u0010R\u001c\u0010%\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b%\u0010H\u001a\u0004\bI\u0010\u0005R\u001c\u0010&\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010H\u001a\u0004\bJ\u0010\u0005R\u001c\u0010,\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010K\u001a\u0004\bL\u0010\u0016R\u001c\u0010(\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010M\u001a\u0004\bN\u0010\nR\u001c\u00103\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010H\u001a\u0004\bO\u0010\u0005R\u001e\u0010+\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010P\u001a\u0004\bQ\u0010\u0013R\u001c\u00100\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010K\u001a\u0004\bR\u0010\u0016R\u001c\u0010.\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010K\u001a\u0004\bS\u0010\u0016R\u001c\u00105\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010F\u001a\u0004\bT\u0010\u0010R\u001c\u0010)\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010U\u001a\u0004\bV\u0010\rR\u001e\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010F\u001a\u0004\bW\u0010\u0010R\"\u0010Y\u001a\u00020X8\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\bY\u0010Z\u0012\u0004\b]\u0010^\u001a\u0004\b[\u0010\\R\u001c\u00102\u001a\u00020\u001e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010_\u001a\u0004\b`\u0010 R\u001c\u00106\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010U\u001a\u0004\ba\u0010\rR\u001c\u0010/\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010K\u001a\u0004\bb\u0010\u0016R\u001c\u0010'\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010H\u001a\u0004\bc\u0010\u0005R\u001c\u0010-\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010K\u001a\u0004\bd\u0010\u0016R\u001c\u00101\u001a\u00020\u001b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010e\u001a\u0004\b1\u0010\u001d¨\u0006j"}, d2 = {"Lcom/coinbase/wallet/lending/models/LendToken;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component4", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "component5", "()I", "Ljava/net/URL;", "component6", "()Ljava/net/URL;", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "component7", "()Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "Ljava/math/BigInteger;", "component8", "()Ljava/math/BigInteger;", "component9", "component10", "component11", "component12", "", "component13", "()Z", "Lcom/coinbase/wallet/lending/models/LendProviderID;", "component14", "()Lcom/coinbase/wallet/lending/models/LendProviderID;", "component15", "component16", "component17", "component18", "id", "walletAddress", ApiConstants.NAME, AppsFlyerProperties.CURRENCY_CODE, "decimals", "imageURL", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "supplyBalance", "supplyInterestRate", "globalSuppliedAmount", "utilizationRate", "collateralRate", "isCollateralRateApplicable", "providerID", "providerName", "providerWebsiteURL", "providerImageURL", "rateDecimals", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/net/URL;Lcom/coinbase/wallet/ethereum/models/ContractAddress;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;ZLcom/coinbase/wallet/lending/models/LendProviderID;Ljava/lang/String;Ljava/net/URL;Ljava/net/URL;I)Lcom/coinbase/wallet/lending/models/LendToken;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/net/URL;", "getProviderWebsiteURL", "Ljava/lang/String;", "getId", "getWalletAddress", "Ljava/math/BigInteger;", "getSupplyBalance", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "getProviderName", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "getContractAddress", "getCollateralRate", "getGlobalSuppliedAmount", "getProviderImageURL", "I", "getDecimals", "getImageURL", "Lcom/coinbase/wallet/lending/models/LendProvider;", "provider", "Lcom/coinbase/wallet/lending/models/LendProvider;", "getProvider", "()Lcom/coinbase/wallet/lending/models/LendProvider;", "getProvider$annotations", "()V", "Lcom/coinbase/wallet/lending/models/LendProviderID;", "getProviderID", "getRateDecimals", "getUtilizationRate", "getName", "getSupplyInterestRate", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/net/URL;Lcom/coinbase/wallet/ethereum/models/ContractAddress;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;ZLcom/coinbase/wallet/lending/models/LendProviderID;Ljava/lang/String;Ljava/net/URL;Ljava/net/URL;I)V", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/net/URL;Ljava/lang/String;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;ZLjava/lang/String;Ljava/lang/String;Ljava/net/URL;Ljava/net/URL;I)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendToken implements DatabaseModelObject, Parcelable {
    public static final Parcelable.Creator<LendToken> CREATOR = new Creator();
    private final BigInteger collateralRate;
    private final ContractAddress contractAddress;
    private final CurrencyCode currencyCode;
    private final int decimals;
    private final BigInteger globalSuppliedAmount;
    private final String id;
    private final URL imageURL;
    private final boolean isCollateralRateApplicable;
    private final String name;
    private final LendProvider provider;
    private final LendProviderID providerID;
    private final URL providerImageURL;
    private final String providerName;
    private final URL providerWebsiteURL;
    private final int rateDecimals;
    private final BigInteger supplyBalance;
    private final BigInteger supplyInterestRate;
    private final BigInteger utilizationRate;
    private final String walletAddress;

    /* compiled from: LendToken.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<LendToken> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LendToken createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new LendToken(parcel.readString(), parcel.readString(), parcel.readString(), (CurrencyCode) parcel.readParcelable(LendToken.class.getClassLoader()), parcel.readInt(), (URL) parcel.readSerializable(), (ContractAddress) parcel.readParcelable(LendToken.class.getClassLoader()), (BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), parcel.readInt() != 0, LendProviderID.CREATOR.createFromParcel(parcel), parcel.readString(), (URL) parcel.readSerializable(), (URL) parcel.readSerializable(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LendToken[] newArray(int i2) {
            return new LendToken[i2];
        }
    }

    public LendToken(String id, String walletAddress, String name, CurrencyCode currencyCode, int i2, URL url, ContractAddress contractAddress, BigInteger supplyBalance, BigInteger supplyInterestRate, BigInteger globalSuppliedAmount, BigInteger utilizationRate, BigInteger collateralRate, boolean z, LendProviderID providerID, String providerName, URL providerWebsiteURL, URL providerImageURL, int i3) {
        m.g(id, "id");
        m.g(walletAddress, "walletAddress");
        m.g(name, "name");
        m.g(currencyCode, "currencyCode");
        m.g(supplyBalance, "supplyBalance");
        m.g(supplyInterestRate, "supplyInterestRate");
        m.g(globalSuppliedAmount, "globalSuppliedAmount");
        m.g(utilizationRate, "utilizationRate");
        m.g(collateralRate, "collateralRate");
        m.g(providerID, "providerID");
        m.g(providerName, "providerName");
        m.g(providerWebsiteURL, "providerWebsiteURL");
        m.g(providerImageURL, "providerImageURL");
        this.id = id;
        this.walletAddress = walletAddress;
        this.name = name;
        this.currencyCode = currencyCode;
        this.decimals = i2;
        this.imageURL = url;
        this.contractAddress = contractAddress;
        this.supplyBalance = supplyBalance;
        this.supplyInterestRate = supplyInterestRate;
        this.globalSuppliedAmount = globalSuppliedAmount;
        this.utilizationRate = utilizationRate;
        this.collateralRate = collateralRate;
        this.isCollateralRateApplicable = z;
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerWebsiteURL = providerWebsiteURL;
        this.providerImageURL = providerImageURL;
        this.rateDecimals = i3;
        this.provider = new LendProvider(providerID, providerName, providerWebsiteURL, providerImageURL);
    }

    public static /* synthetic */ void getProvider$annotations() {
    }

    public final String component1() {
        return getId();
    }

    public final BigInteger component10() {
        return this.globalSuppliedAmount;
    }

    public final BigInteger component11() {
        return this.utilizationRate;
    }

    public final BigInteger component12() {
        return this.collateralRate;
    }

    public final boolean component13() {
        return this.isCollateralRateApplicable;
    }

    public final LendProviderID component14() {
        return this.providerID;
    }

    public final String component15() {
        return this.providerName;
    }

    public final URL component16() {
        return this.providerWebsiteURL;
    }

    public final URL component17() {
        return this.providerImageURL;
    }

    public final int component18() {
        return this.rateDecimals;
    }

    public final String component2() {
        return this.walletAddress;
    }

    public final String component3() {
        return this.name;
    }

    public final CurrencyCode component4() {
        return this.currencyCode;
    }

    public final int component5() {
        return this.decimals;
    }

    public final URL component6() {
        return this.imageURL;
    }

    public final ContractAddress component7() {
        return this.contractAddress;
    }

    public final BigInteger component8() {
        return this.supplyBalance;
    }

    public final BigInteger component9() {
        return this.supplyInterestRate;
    }

    public final LendToken copy(String id, String walletAddress, String name, CurrencyCode currencyCode, int i2, URL url, ContractAddress contractAddress, BigInteger supplyBalance, BigInteger supplyInterestRate, BigInteger globalSuppliedAmount, BigInteger utilizationRate, BigInteger collateralRate, boolean z, LendProviderID providerID, String providerName, URL providerWebsiteURL, URL providerImageURL, int i3) {
        m.g(id, "id");
        m.g(walletAddress, "walletAddress");
        m.g(name, "name");
        m.g(currencyCode, "currencyCode");
        m.g(supplyBalance, "supplyBalance");
        m.g(supplyInterestRate, "supplyInterestRate");
        m.g(globalSuppliedAmount, "globalSuppliedAmount");
        m.g(utilizationRate, "utilizationRate");
        m.g(collateralRate, "collateralRate");
        m.g(providerID, "providerID");
        m.g(providerName, "providerName");
        m.g(providerWebsiteURL, "providerWebsiteURL");
        m.g(providerImageURL, "providerImageURL");
        return new LendToken(id, walletAddress, name, currencyCode, i2, url, contractAddress, supplyBalance, supplyInterestRate, globalSuppliedAmount, utilizationRate, collateralRate, z, providerID, providerName, providerWebsiteURL, providerImageURL, i3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LendToken) {
            LendToken lendToken = (LendToken) obj;
            return m.c(getId(), lendToken.getId()) && m.c(this.walletAddress, lendToken.walletAddress) && m.c(this.name, lendToken.name) && m.c(this.currencyCode, lendToken.currencyCode) && this.decimals == lendToken.decimals && m.c(this.imageURL, lendToken.imageURL) && m.c(this.contractAddress, lendToken.contractAddress) && m.c(this.supplyBalance, lendToken.supplyBalance) && m.c(this.supplyInterestRate, lendToken.supplyInterestRate) && m.c(this.globalSuppliedAmount, lendToken.globalSuppliedAmount) && m.c(this.utilizationRate, lendToken.utilizationRate) && m.c(this.collateralRate, lendToken.collateralRate) && this.isCollateralRateApplicable == lendToken.isCollateralRateApplicable && m.c(this.providerID, lendToken.providerID) && m.c(this.providerName, lendToken.providerName) && m.c(this.providerWebsiteURL, lendToken.providerWebsiteURL) && m.c(this.providerImageURL, lendToken.providerImageURL) && this.rateDecimals == lendToken.rateDecimals;
        }
        return false;
    }

    public final BigInteger getCollateralRate() {
        return this.collateralRate;
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

    public final BigInteger getGlobalSuppliedAmount() {
        return this.globalSuppliedAmount;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final URL getImageURL() {
        return this.imageURL;
    }

    public final String getName() {
        return this.name;
    }

    public final LendProvider getProvider() {
        return this.provider;
    }

    public final LendProviderID getProviderID() {
        return this.providerID;
    }

    public final URL getProviderImageURL() {
        return this.providerImageURL;
    }

    public final String getProviderName() {
        return this.providerName;
    }

    public final URL getProviderWebsiteURL() {
        return this.providerWebsiteURL;
    }

    public final int getRateDecimals() {
        return this.rateDecimals;
    }

    public final BigInteger getSupplyBalance() {
        return this.supplyBalance;
    }

    public final BigInteger getSupplyInterestRate() {
        return this.supplyInterestRate;
    }

    public final BigInteger getUtilizationRate() {
        return this.utilizationRate;
    }

    public final String getWalletAddress() {
        return this.walletAddress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((getId().hashCode() * 31) + this.walletAddress.hashCode()) * 31) + this.name.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.decimals) * 31;
        URL url = this.imageURL;
        int hashCode2 = (hashCode + (url == null ? 0 : url.hashCode())) * 31;
        ContractAddress contractAddress = this.contractAddress;
        int hashCode3 = (((((((((((hashCode2 + (contractAddress != null ? contractAddress.hashCode() : 0)) * 31) + this.supplyBalance.hashCode()) * 31) + this.supplyInterestRate.hashCode()) * 31) + this.globalSuppliedAmount.hashCode()) * 31) + this.utilizationRate.hashCode()) * 31) + this.collateralRate.hashCode()) * 31;
        boolean z = this.isCollateralRateApplicable;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return ((((((((((hashCode3 + i2) * 31) + this.providerID.hashCode()) * 31) + this.providerName.hashCode()) * 31) + this.providerWebsiteURL.hashCode()) * 31) + this.providerImageURL.hashCode()) * 31) + this.rateDecimals;
    }

    public final boolean isCollateralRateApplicable() {
        return this.isCollateralRateApplicable;
    }

    public String toString() {
        return "LendToken(id=" + getId() + ", walletAddress=" + this.walletAddress + ", name=" + this.name + ", currencyCode=" + this.currencyCode + ", decimals=" + this.decimals + ", imageURL=" + this.imageURL + ", contractAddress=" + this.contractAddress + ", supplyBalance=" + this.supplyBalance + ", supplyInterestRate=" + this.supplyInterestRate + ", globalSuppliedAmount=" + this.globalSuppliedAmount + ", utilizationRate=" + this.utilizationRate + ", collateralRate=" + this.collateralRate + ", isCollateralRateApplicable=" + this.isCollateralRateApplicable + ", providerID=" + this.providerID + ", providerName=" + this.providerName + ", providerWebsiteURL=" + this.providerWebsiteURL + ", providerImageURL=" + this.providerImageURL + ", rateDecimals=" + this.rateDecimals + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.id);
        out.writeString(this.walletAddress);
        out.writeString(this.name);
        out.writeParcelable(this.currencyCode, i2);
        out.writeInt(this.decimals);
        out.writeSerializable(this.imageURL);
        out.writeParcelable(this.contractAddress, i2);
        out.writeSerializable(this.supplyBalance);
        out.writeSerializable(this.supplyInterestRate);
        out.writeSerializable(this.globalSuppliedAmount);
        out.writeSerializable(this.utilizationRate);
        out.writeSerializable(this.collateralRate);
        out.writeInt(this.isCollateralRateApplicable ? 1 : 0);
        this.providerID.writeToParcel(out, i2);
        out.writeString(this.providerName);
        out.writeSerializable(this.providerWebsiteURL);
        out.writeSerializable(this.providerImageURL);
        out.writeInt(this.rateDecimals);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LendToken(String id, String walletAddress, String name, String code, int i2, URL url, String str, BigInteger supplyBalance, BigInteger supplyInterestRate, BigInteger globalSuppliedAmount, BigInteger utilizationRate, BigInteger collateralRate, boolean z, String providerID, String providerName, URL providerWebsiteURL, URL providerImageURL, int i3) {
        this(id, walletAddress, name, new CurrencyCode(code), i2, url, str == null ? null : new ContractAddress(str), supplyBalance, supplyInterestRate, globalSuppliedAmount, utilizationRate, collateralRate, z, new LendProviderID(providerID), providerName, providerWebsiteURL, providerImageURL, i3);
        m.g(id, "id");
        m.g(walletAddress, "walletAddress");
        m.g(name, "name");
        m.g(code, "code");
        m.g(supplyBalance, "supplyBalance");
        m.g(supplyInterestRate, "supplyInterestRate");
        m.g(globalSuppliedAmount, "globalSuppliedAmount");
        m.g(utilizationRate, "utilizationRate");
        m.g(collateralRate, "collateralRate");
        m.g(providerID, "providerID");
        m.g(providerName, "providerName");
        m.g(providerWebsiteURL, "providerWebsiteURL");
        m.g(providerImageURL, "providerImageURL");
    }
}