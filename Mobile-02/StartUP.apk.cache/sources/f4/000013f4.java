package com.coinbase.wallet.blockchains.models;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Address.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001Bk\b\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020\u0012\u0012\u0006\u0010%\u001a\u00020\u0015\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010(\u001a\u00020\u001a\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bD\u0010EBe\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020\u0012\u0012\u0006\u0010%\u001a\u00020\u0015\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010(\u001a\u00020\u001a\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bD\u0010FJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0011J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u008a\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00152\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u001a2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010\u0004J\u0010\u0010-\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b-\u0010\u0007J\u001a\u00100\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003¢\u0006\u0004\b0\u00101R\u001c\u0010\u001f\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00102\u001a\u0004\b3\u0010\u0007R\u001c\u0010 \u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b5\u0010\u0004R\u001c\u0010(\u001a\u00020\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u00106\u001a\u0004\b7\u0010\u001cR\u001c\u0010#\u001a\u00020\u000f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00108\u001a\u0004\b#\u0010\u0011R\u001c\u0010%\u001a\u00020\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00109\u001a\u0004\b:\u0010\u0017R\u001c\u0010&\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u00104\u001a\u0004\b;\u0010\u0004R\u001c\u0010!\u001a\u00020\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b=\u0010\u000bR\u001c\u0010'\u001a\u00020\u000f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u00108\u001a\u0004\b'\u0010\u0011R\u001c\u0010\"\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010>\u001a\u0004\b?\u0010\u000eR\u001c\u0010$\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bA\u0010\u0014R\u001c\u0010\u001e\u001a\u00020\u00028\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\bB\u0010\u0004R\u001e\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u00104\u001a\u0004\bC\u0010\u0004¨\u0006G"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Address;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "Ljava/math/BigInteger;", "component4", "()Ljava/math/BigInteger;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component5", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "component6", "()Z", "Lcom/coinbase/wallet/blockchains/models/Network;", "component7", "()Lcom/coinbase/wallet/blockchains/models/Network;", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "component8", "()Lcom/coinbase/wallet/blockchains/models/AddressType;", "component9", "component10", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component11", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component12", "id", "index", "address", "balance", AppsFlyerProperties.CURRENCY_CODE, "isChangeAddress", "network", "type", "derivationPath", "isUsed", RouteActionKey.RouteActionKeys.BLOCKCHAIN, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/AddressType;Ljava/lang/String;ZLcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;)Lcom/coinbase/wallet/blockchains/models/Address;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "Ljava/lang/String;", "getAddress", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Z", "Lcom/coinbase/wallet/blockchains/models/AddressType;", "getType", "getDerivationPath", "Ljava/math/BigInteger;", "getBalance", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "getId", "getContractAddress", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/AddressType;Ljava/lang/String;ZLcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;)V", "(ILjava/lang/String;Ljava/math/BigInteger;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ZLcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/AddressType;Ljava/lang/String;ZLcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Address implements DatabaseModelObject {
    private final String address;
    private final BigInteger balance;
    private final Blockchain blockchain;
    private final String contractAddress;
    private final CurrencyCode currencyCode;
    private final String derivationPath;
    private final String id;
    private final int index;
    private final boolean isChangeAddress;
    private final boolean isUsed;
    private final Network network;
    private final AddressType type;

    public Address(String id, int i2, String address, BigInteger balance, CurrencyCode currencyCode, boolean z, Network network, AddressType type, String derivationPath, boolean z2, Blockchain blockchain, String str) {
        m.g(id, "id");
        m.g(address, "address");
        m.g(balance, "balance");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        m.g(type, "type");
        m.g(derivationPath, "derivationPath");
        m.g(blockchain, "blockchain");
        this.id = id;
        this.index = i2;
        this.address = address;
        this.balance = balance;
        this.currencyCode = currencyCode;
        this.isChangeAddress = z;
        this.network = network;
        this.type = type;
        this.derivationPath = derivationPath;
        this.isUsed = z2;
        this.blockchain = blockchain;
        this.contractAddress = str;
    }

    public final String component1() {
        return getId();
    }

    public final boolean component10() {
        return this.isUsed;
    }

    public final Blockchain component11() {
        return this.blockchain;
    }

    public final String component12() {
        return this.contractAddress;
    }

    public final int component2() {
        return this.index;
    }

    public final String component3() {
        return this.address;
    }

    public final BigInteger component4() {
        return this.balance;
    }

    public final CurrencyCode component5() {
        return this.currencyCode;
    }

    public final boolean component6() {
        return this.isChangeAddress;
    }

    public final Network component7() {
        return this.network;
    }

    public final AddressType component8() {
        return this.type;
    }

    public final String component9() {
        return this.derivationPath;
    }

    public final Address copy(String id, int i2, String address, BigInteger balance, CurrencyCode currencyCode, boolean z, Network network, AddressType type, String derivationPath, boolean z2, Blockchain blockchain, String str) {
        m.g(id, "id");
        m.g(address, "address");
        m.g(balance, "balance");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        m.g(type, "type");
        m.g(derivationPath, "derivationPath");
        m.g(blockchain, "blockchain");
        return new Address(id, i2, address, balance, currencyCode, z, network, type, derivationPath, z2, blockchain, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return m.c(getId(), address.getId()) && this.index == address.index && m.c(this.address, address.address) && m.c(this.balance, address.balance) && m.c(this.currencyCode, address.currencyCode) && this.isChangeAddress == address.isChangeAddress && m.c(this.network, address.network) && m.c(this.type, address.type) && m.c(this.derivationPath, address.derivationPath) && this.isUsed == address.isUsed && m.c(this.blockchain, address.blockchain) && m.c(this.contractAddress, address.contractAddress);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
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

    public final String getDerivationPath() {
        return this.derivationPath;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final AddressType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((getId().hashCode() * 31) + this.index) * 31) + this.address.hashCode()) * 31) + this.balance.hashCode()) * 31) + this.currencyCode.hashCode()) * 31;
        boolean z = this.isChangeAddress;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int hashCode2 = (((((((hashCode + i2) * 31) + this.network.hashCode()) * 31) + this.type.hashCode()) * 31) + this.derivationPath.hashCode()) * 31;
        boolean z2 = this.isUsed;
        int hashCode3 = (((hashCode2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.blockchain.hashCode()) * 31;
        String str = this.contractAddress;
        return hashCode3 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isChangeAddress() {
        return this.isChangeAddress;
    }

    public final boolean isUsed() {
        return this.isUsed;
    }

    public String toString() {
        return "Address(id=" + getId() + ", index=" + this.index + ", address=" + this.address + ", balance=" + this.balance + ", currencyCode=" + this.currencyCode + ", isChangeAddress=" + this.isChangeAddress + ", network=" + this.network + ", type=" + this.type + ", derivationPath=" + this.derivationPath + ", isUsed=" + this.isUsed + ", blockchain=" + this.blockchain + ", contractAddress=" + ((Object) this.contractAddress) + ')';
    }

    public /* synthetic */ Address(int i2, String str, BigInteger bigInteger, CurrencyCode currencyCode, boolean z, Network network, AddressType addressType, String str2, boolean z2, Blockchain blockchain, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str, bigInteger, currencyCode, z, network, addressType, str2, z2, blockchain, (i3 & 1024) != 0 ? null : str3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Address(int r23, java.lang.String r24, java.math.BigInteger r25, com.coinbase.wallet.blockchains.models.CurrencyCode r26, boolean r27, com.coinbase.wallet.blockchains.models.Network r28, com.coinbase.wallet.blockchains.models.AddressType r29, java.lang.String r30, boolean r31, com.coinbase.wallet.blockchains.models.Blockchain r32, java.lang.String r33) {
        /*
            r22 = this;
            java.lang.String r0 = "address"
            r4 = r24
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = "balance"
            r5 = r25
            kotlin.jvm.internal.m.g(r5, r0)
            java.lang.String r0 = "currencyCode"
            r6 = r26
            kotlin.jvm.internal.m.g(r6, r0)
            java.lang.String r0 = "network"
            r8 = r28
            kotlin.jvm.internal.m.g(r8, r0)
            java.lang.String r0 = "type"
            r9 = r29
            kotlin.jvm.internal.m.g(r9, r0)
            java.lang.String r0 = "derivationPath"
            r10 = r30
            kotlin.jvm.internal.m.g(r10, r0)
            java.lang.String r0 = "blockchain"
            r12 = r32
            kotlin.jvm.internal.m.g(r12, r0)
            r0 = 6
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r1 = r32.getRawValue()
            r2 = 0
            r0[r2] = r1
            java.lang.String r1 = r26.getRawValue()
            r2 = 1
            r0[r2] = r1
            java.lang.String r1 = r28.getRawValue()
            r2 = 2
            r0[r2] = r1
            java.lang.String r1 = r29.getRawValue()
            r2 = 3
            r0[r2] = r1
            java.lang.String r1 = java.lang.String.valueOf(r27)
            r2 = 4
            r0[r2] = r1
            java.lang.String r1 = java.lang.String.valueOf(r23)
            r2 = 5
            r0[r2] = r1
            java.util.List r13 = kotlin.a0.p.j(r0)
            java.lang.String r14 = "/"
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 62
            r21 = 0
            java.lang.String r2 = kotlin.a0.p.h0(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r1 = r22
            r3 = r23
            r7 = r27
            r11 = r31
            r13 = r33
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.blockchains.models.Address.<init>(int, java.lang.String, java.math.BigInteger, com.coinbase.wallet.blockchains.models.CurrencyCode, boolean, com.coinbase.wallet.blockchains.models.Network, com.coinbase.wallet.blockchains.models.AddressType, java.lang.String, boolean, com.coinbase.wallet.blockchains.models.Blockchain, java.lang.String):void");
    }
}