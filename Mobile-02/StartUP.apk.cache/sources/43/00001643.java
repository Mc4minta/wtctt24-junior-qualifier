package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: AvailableTransfer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJV\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\fJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\"\u0010\u001dJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b'\u0010(R\u001c\u0010\u0012\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\fR\u0019\u0010\u0017\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b-\u0010\fR\u0019\u0010\u0016\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010.\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010/\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010/\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010/\u001a\u0004\b2\u0010\u0004¨\u00065"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AvailableSendTransfer;", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "component2", "()Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "component3", "component4", "", "component5", "()Ljava/lang/String;", "", "component6", "()Z", "component7", "sendFee", "account", "transferAmount", "maxAmountCrypto", "maxAmountCryptoFormatted", "isWblLimited", "email", "copy", "(Ljava/math/BigInteger;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/String;ZLjava/lang/String;)Lcom/coinbase/wallet/consumer/models/AvailableSendTransfer;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "getAccount", "Ljava/lang/String;", "getMaxAmountCryptoFormatted", "getEmail", "Z", "Ljava/math/BigInteger;", "getTransferAmount", "getSendFee", "getMaxAmountCrypto", "<init>", "(Ljava/math/BigInteger;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/String;ZLjava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AvailableSendTransfer extends AvailableTransfer {
    public static final Parcelable.Creator<AvailableSendTransfer> CREATOR = new Creator();
    private final ConsumerAccount account;
    private final String email;
    private final boolean isWblLimited;
    private final BigInteger maxAmountCrypto;
    private final String maxAmountCryptoFormatted;
    private final BigInteger sendFee;
    private final BigInteger transferAmount;

    /* compiled from: AvailableTransfer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<AvailableSendTransfer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableSendTransfer createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new AvailableSendTransfer((BigInteger) parcel.readSerializable(), ConsumerAccount.CREATOR.createFromParcel(parcel), (BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableSendTransfer[] newArray(int i2) {
            return new AvailableSendTransfer[i2];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvailableSendTransfer(BigInteger sendFee, ConsumerAccount account, BigInteger transferAmount, BigInteger maxAmountCrypto, String maxAmountCryptoFormatted, boolean z, String email) {
        super(sendFee, account, transferAmount, null, 8, null);
        m.g(sendFee, "sendFee");
        m.g(account, "account");
        m.g(transferAmount, "transferAmount");
        m.g(maxAmountCrypto, "maxAmountCrypto");
        m.g(maxAmountCryptoFormatted, "maxAmountCryptoFormatted");
        m.g(email, "email");
        this.sendFee = sendFee;
        this.account = account;
        this.transferAmount = transferAmount;
        this.maxAmountCrypto = maxAmountCrypto;
        this.maxAmountCryptoFormatted = maxAmountCryptoFormatted;
        this.isWblLimited = z;
        this.email = email;
    }

    public static /* synthetic */ AvailableSendTransfer copy$default(AvailableSendTransfer availableSendTransfer, BigInteger bigInteger, ConsumerAccount consumerAccount, BigInteger bigInteger2, BigInteger bigInteger3, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = availableSendTransfer.getSendFee();
        }
        if ((i2 & 2) != 0) {
            consumerAccount = availableSendTransfer.getAccount();
        }
        ConsumerAccount consumerAccount2 = consumerAccount;
        if ((i2 & 4) != 0) {
            bigInteger2 = availableSendTransfer.getTransferAmount();
        }
        BigInteger bigInteger4 = bigInteger2;
        if ((i2 & 8) != 0) {
            bigInteger3 = availableSendTransfer.maxAmountCrypto;
        }
        BigInteger bigInteger5 = bigInteger3;
        if ((i2 & 16) != 0) {
            str = availableSendTransfer.maxAmountCryptoFormatted;
        }
        String str3 = str;
        if ((i2 & 32) != 0) {
            z = availableSendTransfer.isWblLimited;
        }
        boolean z2 = z;
        if ((i2 & 64) != 0) {
            str2 = availableSendTransfer.email;
        }
        return availableSendTransfer.copy(bigInteger, consumerAccount2, bigInteger4, bigInteger5, str3, z2, str2);
    }

    public final BigInteger component1() {
        return getSendFee();
    }

    public final ConsumerAccount component2() {
        return getAccount();
    }

    public final BigInteger component3() {
        return getTransferAmount();
    }

    public final BigInteger component4() {
        return this.maxAmountCrypto;
    }

    public final String component5() {
        return this.maxAmountCryptoFormatted;
    }

    public final boolean component6() {
        return this.isWblLimited;
    }

    public final String component7() {
        return this.email;
    }

    public final AvailableSendTransfer copy(BigInteger sendFee, ConsumerAccount account, BigInteger transferAmount, BigInteger maxAmountCrypto, String maxAmountCryptoFormatted, boolean z, String email) {
        m.g(sendFee, "sendFee");
        m.g(account, "account");
        m.g(transferAmount, "transferAmount");
        m.g(maxAmountCrypto, "maxAmountCrypto");
        m.g(maxAmountCryptoFormatted, "maxAmountCryptoFormatted");
        m.g(email, "email");
        return new AvailableSendTransfer(sendFee, account, transferAmount, maxAmountCrypto, maxAmountCryptoFormatted, z, email);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvailableSendTransfer) {
            AvailableSendTransfer availableSendTransfer = (AvailableSendTransfer) obj;
            return m.c(getSendFee(), availableSendTransfer.getSendFee()) && m.c(getAccount(), availableSendTransfer.getAccount()) && m.c(getTransferAmount(), availableSendTransfer.getTransferAmount()) && m.c(this.maxAmountCrypto, availableSendTransfer.maxAmountCrypto) && m.c(this.maxAmountCryptoFormatted, availableSendTransfer.maxAmountCryptoFormatted) && this.isWblLimited == availableSendTransfer.isWblLimited && m.c(this.email, availableSendTransfer.email);
        }
        return false;
    }

    @Override // com.coinbase.wallet.consumer.models.AvailableTransfer
    public ConsumerAccount getAccount() {
        return this.account;
    }

    public final String getEmail() {
        return this.email;
    }

    public final BigInteger getMaxAmountCrypto() {
        return this.maxAmountCrypto;
    }

    public final String getMaxAmountCryptoFormatted() {
        return this.maxAmountCryptoFormatted;
    }

    @Override // com.coinbase.wallet.consumer.models.AvailableTransfer
    public BigInteger getSendFee() {
        return this.sendFee;
    }

    @Override // com.coinbase.wallet.consumer.models.AvailableTransfer
    public BigInteger getTransferAmount() {
        return this.transferAmount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((getSendFee().hashCode() * 31) + getAccount().hashCode()) * 31) + getTransferAmount().hashCode()) * 31) + this.maxAmountCrypto.hashCode()) * 31) + this.maxAmountCryptoFormatted.hashCode()) * 31;
        boolean z = this.isWblLimited;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return ((hashCode + i2) * 31) + this.email.hashCode();
    }

    public final boolean isWblLimited() {
        return this.isWblLimited;
    }

    public String toString() {
        return "AvailableSendTransfer(sendFee=" + getSendFee() + ", account=" + getAccount() + ", transferAmount=" + getTransferAmount() + ", maxAmountCrypto=" + this.maxAmountCrypto + ", maxAmountCryptoFormatted=" + this.maxAmountCryptoFormatted + ", isWblLimited=" + this.isWblLimited + ", email=" + this.email + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeSerializable(this.sendFee);
        this.account.writeToParcel(out, i2);
        out.writeSerializable(this.transferAmount);
        out.writeSerializable(this.maxAmountCrypto);
        out.writeString(this.maxAmountCryptoFormatted);
        out.writeInt(this.isWblLimited ? 1 : 0);
        out.writeString(this.email);
    }
}