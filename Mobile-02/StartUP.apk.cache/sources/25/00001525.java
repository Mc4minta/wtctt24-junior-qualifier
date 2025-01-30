package com.coinbase.wallet.compoundfinance.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CompoundToken.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0001/BK\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b,\u0010-BE\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJb\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0017\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u000bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0012\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\bR\u001c\u0010\u0015\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b#\u0010\bR\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\t8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b*\u0010\u000bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b+\u0010\u0004¨\u00060"}, d2 = {"Lcom/coinbase/wallet/compoundfinance/models/CompoundToken;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component3", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "", "component4", "()I", "component5", "component6", "component7", "component8", "id", ApiConstants.NAME, "code", "decimals", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "underlyingCode", "underlyingContractAddress", "underlyingDecimals", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)Lcom/coinbase/wallet/compoundfinance/models/CompoundToken;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCode", "getUnderlyingCode", "Ljava/lang/String;", "getName", "getContractAddress", "I", "getUnderlyingDecimals", "getId", "getDecimals", "getUnderlyingContractAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)V", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;ILjava/lang/String;)V", "Companion", "compoundfinance_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CompoundToken implements DatabaseModelObject {
    public static final Companion Companion = new Companion(null);
    private final CurrencyCode code;
    private final String contractAddress;
    private final int decimals;
    private final String id;
    private final String name;
    private final CurrencyCode underlyingCode;
    private final String underlyingContractAddress;
    private final int underlyingDecimals;

    /* compiled from: CompoundToken.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/compoundfinance/models/CompoundToken$Companion;", "", "<init>", "()V", "compoundfinance_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CompoundToken(String id, String name, CurrencyCode code, int i2, String contractAddress, CurrencyCode underlyingCode, String str, int i3) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(code, "code");
        m.g(contractAddress, "contractAddress");
        m.g(underlyingCode, "underlyingCode");
        this.id = id;
        this.name = name;
        this.code = code;
        this.decimals = i2;
        this.contractAddress = contractAddress;
        this.underlyingCode = underlyingCode;
        this.underlyingContractAddress = str;
        this.underlyingDecimals = i3;
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return this.name;
    }

    public final CurrencyCode component3() {
        return this.code;
    }

    public final int component4() {
        return this.decimals;
    }

    public final String component5() {
        return this.contractAddress;
    }

    public final CurrencyCode component6() {
        return this.underlyingCode;
    }

    public final String component7() {
        return this.underlyingContractAddress;
    }

    public final int component8() {
        return this.underlyingDecimals;
    }

    public final CompoundToken copy(String id, String name, CurrencyCode code, int i2, String contractAddress, CurrencyCode underlyingCode, String str, int i3) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(code, "code");
        m.g(contractAddress, "contractAddress");
        m.g(underlyingCode, "underlyingCode");
        return new CompoundToken(id, name, code, i2, contractAddress, underlyingCode, str, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompoundToken) {
            CompoundToken compoundToken = (CompoundToken) obj;
            return m.c(getId(), compoundToken.getId()) && m.c(this.name, compoundToken.name) && m.c(this.code, compoundToken.code) && this.decimals == compoundToken.decimals && m.c(this.contractAddress, compoundToken.contractAddress) && m.c(this.underlyingCode, compoundToken.underlyingCode) && m.c(this.underlyingContractAddress, compoundToken.underlyingContractAddress) && this.underlyingDecimals == compoundToken.underlyingDecimals;
        }
        return false;
    }

    public final CurrencyCode getCode() {
        return this.code;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final CurrencyCode getUnderlyingCode() {
        return this.underlyingCode;
    }

    public final String getUnderlyingContractAddress() {
        return this.underlyingContractAddress;
    }

    public final int getUnderlyingDecimals() {
        return this.underlyingDecimals;
    }

    public int hashCode() {
        int hashCode = ((((((((((getId().hashCode() * 31) + this.name.hashCode()) * 31) + this.code.hashCode()) * 31) + this.decimals) * 31) + this.contractAddress.hashCode()) * 31) + this.underlyingCode.hashCode()) * 31;
        String str = this.underlyingContractAddress;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.underlyingDecimals;
    }

    public String toString() {
        return "CompoundToken(id=" + getId() + ", name=" + this.name + ", code=" + this.code + ", decimals=" + this.decimals + ", contractAddress=" + this.contractAddress + ", underlyingCode=" + this.underlyingCode + ", underlyingContractAddress=" + ((Object) this.underlyingContractAddress) + ", underlyingDecimals=" + this.underlyingDecimals + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ CompoundToken(java.lang.String r12, java.lang.String r13, com.coinbase.wallet.blockchains.models.CurrencyCode r14, int r15, java.lang.String r16, com.coinbase.wallet.blockchains.models.CurrencyCode r17, java.lang.String r18, int r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L13
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "randomUUID().toString()"
            kotlin.jvm.internal.m.f(r0, r1)
            r3 = r0
            goto L14
        L13:
            r3 = r12
        L14:
            r2 = r11
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.compoundfinance.models.CompoundToken.<init>(java.lang.String, java.lang.String, com.coinbase.wallet.blockchains.models.CurrencyCode, int, java.lang.String, com.coinbase.wallet.blockchains.models.CurrencyCode, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public /* synthetic */ CompoundToken(String str, CurrencyCode currencyCode, int i2, String str2, CurrencyCode currencyCode2, int i3, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, currencyCode, (i4 & 4) != 0 ? 8 : i2, str2, currencyCode2, i3, str3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CompoundToken(java.lang.String r10, com.coinbase.wallet.blockchains.models.CurrencyCode r11, int r12, java.lang.String r13, com.coinbase.wallet.blockchains.models.CurrencyCode r14, int r15, java.lang.String r16) {
        /*
            r9 = this;
            r5 = r13
            java.lang.String r0 = "name"
            r2 = r10
            kotlin.jvm.internal.m.g(r10, r0)
            java.lang.String r0 = "code"
            r3 = r11
            kotlin.jvm.internal.m.g(r11, r0)
            java.lang.String r0 = "contractAddress"
            kotlin.jvm.internal.m.g(r13, r0)
            java.lang.String r0 = "underlyingCode"
            r6 = r14
            kotlin.jvm.internal.m.g(r14, r0)
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = "US"
            kotlin.jvm.internal.m.f(r0, r1)
            java.lang.String r1 = r13.toUpperCase(r0)
            java.lang.String r0 = "(this as java.lang.String).toUpperCase(locale)"
            kotlin.jvm.internal.m.f(r1, r0)
            r0 = r9
            r4 = r12
            r7 = r16
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.compoundfinance.models.CompoundToken.<init>(java.lang.String, com.coinbase.wallet.blockchains.models.CurrencyCode, int, java.lang.String, com.coinbase.wallet.blockchains.models.CurrencyCode, int, java.lang.String):void");
    }
}