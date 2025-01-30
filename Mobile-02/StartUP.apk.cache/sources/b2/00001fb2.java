package com.coinbase.wallet.features.send.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.models.RecipientType;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Recipient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B]\b\u0000\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020\u0013\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010&\u001a\u00020\u001a¢\u0006\u0004\bI\u0010JBE\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\u0006\u0010&\u001a\u00020\u001a\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bI\u0010KJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJx\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u00132\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010&\u001a\u00020\u001aHÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b)\u0010\u0005J\u0010\u0010*\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b*\u0010\fJ\u001a\u0010.\u001a\u00020-2\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b0\u0010\fJ \u00105\u001a\u0002042\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b5\u00106R\u001c\u0010\u001e\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b8\u0010\u0005R\u001c\u0010 \u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00109\u001a\u0004\b:\u0010\fR\u001e\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010;\u001a\u0004\b<\u0010\u0018R\u001c\u0010\u001d\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b=\u0010\u0005R\u001e\u0010%\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00107\u001a\u0004\b>\u0010\u0005R\u001c\u0010\u001f\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010?\u001a\u0004\b@\u0010\tR\u001c\u0010!\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010A\u001a\u0004\bB\u0010\u000fR\u001c\u0010&\u001a\u00020\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010C\u001a\u0004\bD\u0010\u001cR\u001c\u0010\"\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010E\u001a\u0004\bF\u0010\u0012R\u001c\u0010#\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010G\u001a\u0004\bH\u0010\u0015¨\u0006L"}, d2 = {"Lcom/coinbase/wallet/features/send/models/Recipient;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component3", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "", "component4", "()I", "Ljava/util/Date;", "component5", "()Ljava/util/Date;", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "component6", "()Lcom/coinbase/wallet/txhistory/models/RecipientType;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component7", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component8", "()Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "component9", "Lcom/coinbase/wallet/blockchains/models/Network;", "component10", "()Lcom/coinbase/wallet/blockchains/models/Network;", "id", "destination", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "sendCount", "lastUsed", "recipientType", AppsFlyerProperties.CURRENCY_CODE, "metadataKey", SendConfirmationArgs.metadataKey, "network", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;ILjava/util/Date;Lcom/coinbase/wallet/txhistory/models/RecipientType;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/features/send/models/Recipient;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDestination", "I", "getSendCount", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "getMetadataKey", "getId", "getMetadata", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "Ljava/util/Date;", "getLastUsed", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "getRecipientType", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Blockchain;ILjava/util/Date;Lcom/coinbase/wallet/txhistory/models/RecipientType;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)V", "(Ljava/lang/String;Lcom/coinbase/wallet/txhistory/models/RecipientType;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Recipient implements DatabaseModelObject, Parcelable {
    public static final Parcelable.Creator<Recipient> CREATOR = new Creator();
    private final Blockchain blockchain;
    private final CurrencyCode currencyCode;
    private final String destination;
    private final String id;
    private final Date lastUsed;
    private final String metadata;
    private final TxMetadataKey metadataKey;
    private final Network network;
    private final RecipientType recipientType;
    private final int sendCount;

    /* compiled from: Recipient.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Recipient> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Recipient createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new Recipient(parcel.readString(), parcel.readString(), (Blockchain) parcel.readParcelable(Recipient.class.getClassLoader()), parcel.readInt(), (Date) parcel.readSerializable(), (RecipientType) parcel.readParcelable(Recipient.class.getClassLoader()), (CurrencyCode) parcel.readParcelable(Recipient.class.getClassLoader()), (TxMetadataKey) parcel.readParcelable(Recipient.class.getClassLoader()), parcel.readString(), (Network) parcel.readParcelable(Recipient.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Recipient[] newArray(int i2) {
            return new Recipient[i2];
        }
    }

    public Recipient(String id, String destination, Blockchain blockchain, int i2, Date lastUsed, RecipientType recipientType, CurrencyCode currencyCode, TxMetadataKey txMetadataKey, String str, Network network) {
        m.g(id, "id");
        m.g(destination, "destination");
        m.g(blockchain, "blockchain");
        m.g(lastUsed, "lastUsed");
        m.g(recipientType, "recipientType");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        this.id = id;
        this.destination = destination;
        this.blockchain = blockchain;
        this.sendCount = i2;
        this.lastUsed = lastUsed;
        this.recipientType = recipientType;
        this.currencyCode = currencyCode;
        this.metadataKey = txMetadataKey;
        this.metadata = str;
        this.network = network;
    }

    public final String component1() {
        return getId();
    }

    public final Network component10() {
        return this.network;
    }

    public final String component2() {
        return this.destination;
    }

    public final Blockchain component3() {
        return this.blockchain;
    }

    public final int component4() {
        return this.sendCount;
    }

    public final Date component5() {
        return this.lastUsed;
    }

    public final RecipientType component6() {
        return this.recipientType;
    }

    public final CurrencyCode component7() {
        return this.currencyCode;
    }

    public final TxMetadataKey component8() {
        return this.metadataKey;
    }

    public final String component9() {
        return this.metadata;
    }

    public final Recipient copy(String id, String destination, Blockchain blockchain, int i2, Date lastUsed, RecipientType recipientType, CurrencyCode currencyCode, TxMetadataKey txMetadataKey, String str, Network network) {
        m.g(id, "id");
        m.g(destination, "destination");
        m.g(blockchain, "blockchain");
        m.g(lastUsed, "lastUsed");
        m.g(recipientType, "recipientType");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        return new Recipient(id, destination, blockchain, i2, lastUsed, recipientType, currencyCode, txMetadataKey, str, network);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Recipient) {
            Recipient recipient = (Recipient) obj;
            return m.c(getId(), recipient.getId()) && m.c(this.destination, recipient.destination) && m.c(this.blockchain, recipient.blockchain) && this.sendCount == recipient.sendCount && m.c(this.lastUsed, recipient.lastUsed) && this.recipientType == recipient.recipientType && m.c(this.currencyCode, recipient.currencyCode) && m.c(this.metadataKey, recipient.metadataKey) && m.c(this.metadata, recipient.metadata) && m.c(this.network, recipient.network);
        }
        return false;
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getDestination() {
        return this.destination;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final Date getLastUsed() {
        return this.lastUsed;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final TxMetadataKey getMetadataKey() {
        return this.metadataKey;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final RecipientType getRecipientType() {
        return this.recipientType;
    }

    public final int getSendCount() {
        return this.sendCount;
    }

    public int hashCode() {
        int hashCode = ((((((((((((getId().hashCode() * 31) + this.destination.hashCode()) * 31) + this.blockchain.hashCode()) * 31) + this.sendCount) * 31) + this.lastUsed.hashCode()) * 31) + this.recipientType.hashCode()) * 31) + this.currencyCode.hashCode()) * 31;
        TxMetadataKey txMetadataKey = this.metadataKey;
        int hashCode2 = (hashCode + (txMetadataKey == null ? 0 : txMetadataKey.hashCode())) * 31;
        String str = this.metadata;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.network.hashCode();
    }

    public String toString() {
        return "Recipient(id=" + getId() + ", destination=" + this.destination + ", blockchain=" + this.blockchain + ", sendCount=" + this.sendCount + ", lastUsed=" + this.lastUsed + ", recipientType=" + this.recipientType + ", currencyCode=" + this.currencyCode + ", metadataKey=" + this.metadataKey + ", metadata=" + ((Object) this.metadata) + ", network=" + this.network + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.id);
        out.writeString(this.destination);
        out.writeParcelable(this.blockchain, i2);
        out.writeInt(this.sendCount);
        out.writeSerializable(this.lastUsed);
        out.writeParcelable(this.recipientType, i2);
        out.writeParcelable(this.currencyCode, i2);
        out.writeParcelable(this.metadataKey, i2);
        out.writeString(this.metadata);
        out.writeParcelable(this.network, i2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Recipient(java.lang.String r21, com.coinbase.wallet.txhistory.models.RecipientType r22, com.coinbase.wallet.blockchains.models.CurrencyCode r23, com.coinbase.wallet.blockchains.models.Blockchain r24, com.coinbase.wallet.blockchains.models.Network r25, com.coinbase.wallet.blockchains.models.TxMetadataKey r26, java.lang.String r27) {
        /*
            r20 = this;
            r2 = r21
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.m.g(r2, r0)
            java.lang.String r0 = "recipientType"
            r6 = r22
            kotlin.jvm.internal.m.g(r6, r0)
            java.lang.String r0 = "currencyCode"
            r7 = r23
            kotlin.jvm.internal.m.g(r7, r0)
            java.lang.String r0 = "blockchain"
            r3 = r24
            kotlin.jvm.internal.m.g(r3, r0)
            java.lang.String r0 = "network"
            r10 = r25
            kotlin.jvm.internal.m.g(r10, r0)
            r0 = 7
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = r24.getRawValue()
            r4 = 0
            r0[r4] = r1
            java.lang.String r1 = r23.getCode()
            r4 = 1
            r0[r4] = r1
            java.lang.String r1 = r25.getRawValue()
            r4 = 2
            r0[r4] = r1
            int r1 = r22.getRawValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4 = 3
            r0[r4] = r1
            r1 = 4
            r0[r1] = r2
            if (r26 != 0) goto L4d
            r1 = 0
            goto L51
        L4d:
            java.lang.String r1 = r26.getRawValue()
        L51:
            if (r1 != 0) goto L59
            com.coinbase.wallet.core.extensions.Strings r1 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r1 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r1)
        L59:
            r4 = 5
            r0[r4] = r1
            r1 = 6
            if (r27 != 0) goto L66
            com.coinbase.wallet.core.extensions.Strings r4 = com.coinbase.wallet.core.extensions.Strings.INSTANCE
            java.lang.String r4 = com.coinbase.wallet.core.extensions.Strings_CoreKt.getEmpty(r4)
            goto L68
        L66:
            r4 = r27
        L68:
            r0[r1] = r4
            java.util.List r11 = kotlin.a0.p.j(r0)
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 62
            r19 = 0
            java.lang.String r12 = "/"
            java.lang.String r0 = kotlin.a0.p.h0(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r4 = "US"
            kotlin.jvm.internal.m.f(r1, r4)
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r0, r4)
            java.lang.String r1 = r0.toLowerCase(r1)
            java.lang.String r0 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.m.f(r1, r0)
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            r4 = 0
            r0 = r20
            r2 = r21
            r3 = r24
            r6 = r22
            r7 = r23
            r8 = r26
            r9 = r27
            r10 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.models.Recipient.<init>(java.lang.String, com.coinbase.wallet.txhistory.models.RecipientType, com.coinbase.wallet.blockchains.models.CurrencyCode, com.coinbase.wallet.blockchains.models.Blockchain, com.coinbase.wallet.blockchains.models.Network, com.coinbase.wallet.blockchains.models.TxMetadataKey, java.lang.String):void");
    }
}