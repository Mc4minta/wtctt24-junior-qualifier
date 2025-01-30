package com.coinbase.wallet.blockchains.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TransferValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TransferValue;", "Landroid/os/Parcelable;", "", "isMax", "()Z", "<init>", "()V", "Amount", "EntireBalance", "Lcom/coinbase/wallet/blockchains/models/TransferValue$EntireBalance;", "Lcom/coinbase/wallet/blockchains/models/TransferValue$Amount;", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class TransferValue implements Parcelable {

    /* compiled from: TransferValue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TransferValue$Amount;", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "value", "copy", "(Ljava/math/BigInteger;)Lcom/coinbase/wallet/blockchains/models/TransferValue$Amount;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/math/BigInteger;", "getValue", "<init>", "(Ljava/math/BigInteger;)V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Amount extends TransferValue {
        public static final Parcelable.Creator<Amount> CREATOR = new Creator();
        private final BigInteger value;

        /* compiled from: TransferValue.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<Amount> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Amount createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new Amount((BigInteger) parcel.readSerializable());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Amount[] newArray(int i2) {
                return new Amount[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Amount(BigInteger value) {
            super(null);
            m.g(value, "value");
            this.value = value;
        }

        public static /* synthetic */ Amount copy$default(Amount amount, BigInteger bigInteger, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bigInteger = amount.value;
            }
            return amount.copy(bigInteger);
        }

        public final BigInteger component1() {
            return this.value;
        }

        public final Amount copy(BigInteger value) {
            m.g(value, "value");
            return new Amount(value);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Amount) && m.c(this.value, ((Amount) obj).value);
        }

        public final BigInteger getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Amount(value=" + this.value + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeSerializable(this.value);
        }
    }

    /* compiled from: TransferValue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TransferValue$EntireBalance;", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class EntireBalance extends TransferValue {
        public static final EntireBalance INSTANCE = new EntireBalance();
        public static final Parcelable.Creator<EntireBalance> CREATOR = new Creator();

        /* compiled from: TransferValue.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<EntireBalance> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EntireBalance createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                parcel.readInt();
                return EntireBalance.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EntireBalance[] newArray(int i2) {
                return new EntireBalance[i2];
            }
        }

        private EntireBalance() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeInt(1);
        }
    }

    private TransferValue() {
    }

    public /* synthetic */ TransferValue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean isMax() {
        if (this instanceof EntireBalance) {
            return true;
        }
        if (this instanceof Amount) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}