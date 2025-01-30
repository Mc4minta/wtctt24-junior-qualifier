package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerSendFee.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSendFee;", "Landroid/os/Parcelable;", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "amount", "copy", "(Ljava/math/BigInteger;)Lcom/coinbase/wallet/consumer/models/ConsumerSendFee;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/math/BigInteger;", "getAmount", "<init>", "(Ljava/math/BigInteger;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSendFee implements Parcelable {
    public static final Parcelable.Creator<ConsumerSendFee> CREATOR = new Creator();
    private final BigInteger amount;

    /* compiled from: ConsumerSendFee.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ConsumerSendFee> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerSendFee createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new ConsumerSendFee((BigInteger) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerSendFee[] newArray(int i2) {
            return new ConsumerSendFee[i2];
        }
    }

    public ConsumerSendFee(BigInteger amount) {
        m.g(amount, "amount");
        this.amount = amount;
    }

    public static /* synthetic */ ConsumerSendFee copy$default(ConsumerSendFee consumerSendFee, BigInteger bigInteger, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = consumerSendFee.amount;
        }
        return consumerSendFee.copy(bigInteger);
    }

    public final BigInteger component1() {
        return this.amount;
    }

    public final ConsumerSendFee copy(BigInteger amount) {
        m.g(amount, "amount");
        return new ConsumerSendFee(amount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsumerSendFee) && m.c(this.amount, ((ConsumerSendFee) obj).amount);
    }

    public final BigInteger getAmount() {
        return this.amount;
    }

    public int hashCode() {
        return this.amount.hashCode();
    }

    public String toString() {
        return "ConsumerSendFee(amount=" + this.amount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeSerializable(this.amount);
    }
}