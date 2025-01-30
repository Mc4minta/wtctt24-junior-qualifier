package com.coinbase.wallet.lending.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: LendTokenListDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B\u0090\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\n\u001a\u00020\u0007HÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0019\u0010\u0017\u001a\u00020\u0007HÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\tJ¼\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010\u0004J\u0010\u0010-\u001a\u00020,HÖ\u0001¢\u0006\u0004\b-\u0010\tJ\u001a\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b3\u0010\u0004R\u0019\u0010#\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u00102\u001a\u0004\b4\u0010\u0004R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b5\u0010\u0004R\u0019\u0010&\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u00102\u001a\u0004\b6\u0010\u0004R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u001b\u00107\u001a\u0004\b8\u0010\tR\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b9\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00102\u001a\u0004\b:\u0010\u0004R\u0019\u0010%\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u00102\u001a\u0004\b;\u0010\u0004R\"\u0010'\u001a\u00020\u00078\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b'\u00107\u001a\u0004\b<\u0010\tR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\b=\u0010\u0004R\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u00102\u001a\u0004\b>\u0010\u0004R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00102\u001a\u0004\b?\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b@\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\bA\u0010\u0004R\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u00102\u001a\u0004\bB\u0010\u0004R\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u00102\u001a\u0004\bC\u0010\u0004\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"Lcom/coinbase/wallet/lending/dtos/LendTokenDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lkotlin/UInt;", "component4-pVg5ArA", "()I", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16-pVg5ArA", "component16", "id", ApiConstants.NAME, "code", "decimals", "imageUrl", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "supplyBalance", "supplyInterestRate", "globalSuppliedAmount", "utilizationRate", "collateralRate", "providerId", "providerName", "providerWebsiteUrl", "providerImageUrl", "rateDecimals", "copy-IeGGREM", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/coinbase/wallet/lending/dtos/LendTokenDTO;", "copy", "toString", "", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSupplyInterestRate", "getProviderId", "getImageUrl", "getProviderImageUrl", "I", "getDecimals-pVg5ArA", "getId", "getName", "getProviderWebsiteUrl", "getRateDecimals-pVg5ArA", "getContractAddress", "getProviderName", "getCollateralRate", "getSupplyBalance", "getCode", "getGlobalSuppliedAmount", "getUtilizationRate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendTokenDTO {
    private final String code;
    private final String collateralRate;
    private final String contractAddress;
    private final int decimals;
    private final String globalSuppliedAmount;
    private final String id;
    private final String imageUrl;
    private final String name;
    private final String providerId;
    private final String providerImageUrl;
    private final String providerName;
    private final String providerWebsiteUrl;
    private final int rateDecimals;
    private final String supplyBalance;
    private final String supplyInterestRate;
    private final String utilizationRate;

    private LendTokenDTO(String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i3) {
        this.id = str;
        this.name = str2;
        this.code = str3;
        this.decimals = i2;
        this.imageUrl = str4;
        this.contractAddress = str5;
        this.supplyBalance = str6;
        this.supplyInterestRate = str7;
        this.globalSuppliedAmount = str8;
        this.utilizationRate = str9;
        this.collateralRate = str10;
        this.providerId = str11;
        this.providerName = str12;
        this.providerWebsiteUrl = str13;
        this.providerImageUrl = str14;
        this.rateDecimals = i3;
    }

    public /* synthetic */ LendTokenDTO(String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i2, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, i3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.utilizationRate;
    }

    public final String component11() {
        return this.collateralRate;
    }

    public final String component12() {
        return this.providerId;
    }

    public final String component13() {
        return this.providerName;
    }

    public final String component14() {
        return this.providerWebsiteUrl;
    }

    public final String component15() {
        return this.providerImageUrl;
    }

    /* renamed from: component16-pVg5ArA  reason: not valid java name */
    public final int m1582component16pVg5ArA() {
        return this.rateDecimals;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.code;
    }

    /* renamed from: component4-pVg5ArA  reason: not valid java name */
    public final int m1583component4pVg5ArA() {
        return this.decimals;
    }

    public final String component5() {
        return this.imageUrl;
    }

    public final String component6() {
        return this.contractAddress;
    }

    public final String component7() {
        return this.supplyBalance;
    }

    public final String component8() {
        return this.supplyInterestRate;
    }

    public final String component9() {
        return this.globalSuppliedAmount;
    }

    /* renamed from: copy-IeGGREM  reason: not valid java name */
    public final LendTokenDTO m1584copyIeGGREM(String id, String name, String code, int i2, String str, String str2, String supplyBalance, String supplyInterestRate, String globalSuppliedAmount, String utilizationRate, String str3, String providerId, String providerName, String providerWebsiteUrl, String providerImageUrl, int i3) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(code, "code");
        m.g(supplyBalance, "supplyBalance");
        m.g(supplyInterestRate, "supplyInterestRate");
        m.g(globalSuppliedAmount, "globalSuppliedAmount");
        m.g(utilizationRate, "utilizationRate");
        m.g(providerId, "providerId");
        m.g(providerName, "providerName");
        m.g(providerWebsiteUrl, "providerWebsiteUrl");
        m.g(providerImageUrl, "providerImageUrl");
        return new LendTokenDTO(id, name, code, i2, str, str2, supplyBalance, supplyInterestRate, globalSuppliedAmount, utilizationRate, str3, providerId, providerName, providerWebsiteUrl, providerImageUrl, i3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LendTokenDTO) {
            LendTokenDTO lendTokenDTO = (LendTokenDTO) obj;
            return m.c(this.id, lendTokenDTO.id) && m.c(this.name, lendTokenDTO.name) && m.c(this.code, lendTokenDTO.code) && this.decimals == lendTokenDTO.decimals && m.c(this.imageUrl, lendTokenDTO.imageUrl) && m.c(this.contractAddress, lendTokenDTO.contractAddress) && m.c(this.supplyBalance, lendTokenDTO.supplyBalance) && m.c(this.supplyInterestRate, lendTokenDTO.supplyInterestRate) && m.c(this.globalSuppliedAmount, lendTokenDTO.globalSuppliedAmount) && m.c(this.utilizationRate, lendTokenDTO.utilizationRate) && m.c(this.collateralRate, lendTokenDTO.collateralRate) && m.c(this.providerId, lendTokenDTO.providerId) && m.c(this.providerName, lendTokenDTO.providerName) && m.c(this.providerWebsiteUrl, lendTokenDTO.providerWebsiteUrl) && m.c(this.providerImageUrl, lendTokenDTO.providerImageUrl) && this.rateDecimals == lendTokenDTO.rateDecimals;
        }
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCollateralRate() {
        return this.collateralRate;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    /* renamed from: getDecimals-pVg5ArA  reason: not valid java name */
    public final int m1585getDecimalspVg5ArA() {
        return this.decimals;
    }

    public final String getGlobalSuppliedAmount() {
        return this.globalSuppliedAmount;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProviderId() {
        return this.providerId;
    }

    public final String getProviderImageUrl() {
        return this.providerImageUrl;
    }

    public final String getProviderName() {
        return this.providerName;
    }

    public final String getProviderWebsiteUrl() {
        return this.providerWebsiteUrl;
    }

    /* renamed from: getRateDecimals-pVg5ArA  reason: not valid java name */
    public final int m1586getRateDecimalspVg5ArA() {
        return this.rateDecimals;
    }

    public final String getSupplyBalance() {
        return this.supplyBalance;
    }

    public final String getSupplyInterestRate() {
        return this.supplyInterestRate;
    }

    public final String getUtilizationRate() {
        return this.utilizationRate;
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.code.hashCode()) * 31) + UInt.z(this.decimals)) * 31;
        String str = this.imageUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.contractAddress;
        int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.supplyBalance.hashCode()) * 31) + this.supplyInterestRate.hashCode()) * 31) + this.globalSuppliedAmount.hashCode()) * 31) + this.utilizationRate.hashCode()) * 31;
        String str3 = this.collateralRate;
        return ((((((((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.providerId.hashCode()) * 31) + this.providerName.hashCode()) * 31) + this.providerWebsiteUrl.hashCode()) * 31) + this.providerImageUrl.hashCode()) * 31) + UInt.z(this.rateDecimals);
    }

    public String toString() {
        return "LendTokenDTO(id=" + this.id + ", name=" + this.name + ", code=" + this.code + ", decimals=" + ((Object) UInt.A(this.decimals)) + ", imageUrl=" + ((Object) this.imageUrl) + ", contractAddress=" + ((Object) this.contractAddress) + ", supplyBalance=" + this.supplyBalance + ", supplyInterestRate=" + this.supplyInterestRate + ", globalSuppliedAmount=" + this.globalSuppliedAmount + ", utilizationRate=" + this.utilizationRate + ", collateralRate=" + ((Object) this.collateralRate) + ", providerId=" + this.providerId + ", providerName=" + this.providerName + ", providerWebsiteUrl=" + this.providerWebsiteUrl + ", providerImageUrl=" + this.providerImageUrl + ", rateDecimals=" + ((Object) UInt.A(this.rateDecimals)) + ')';
    }
}