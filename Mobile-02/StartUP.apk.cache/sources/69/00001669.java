package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerCardCDVResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult;", "Landroid/os/Parcelable;", "<init>", "()V", "Unverified", "Verified", "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult$Verified;", "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult$Unverified;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerCardCDVResult implements Parcelable {

    /* compiled from: ConsumerCardCDVResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult$Unverified;", "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Unverified extends ConsumerCardCDVResult {
        public static final Unverified INSTANCE = new Unverified();
        public static final Parcelable.Creator<Unverified> CREATOR = new Creator();

        /* compiled from: ConsumerCardCDVResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<Unverified> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unverified createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                parcel.readInt();
                return Unverified.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unverified[] newArray(int i2) {
                return new Unverified[i2];
            }
        }

        private Unverified() {
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

    /* compiled from: ConsumerCardCDVResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult$Verified;", "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult;", "", "component1", "()Ljava/lang/String;", "paymentMethodId", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult$Verified;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getPaymentMethodId", "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Verified extends ConsumerCardCDVResult {
        public static final Parcelable.Creator<Verified> CREATOR = new Creator();
        private final String paymentMethodId;

        /* compiled from: ConsumerCardCDVResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<Verified> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Verified createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new Verified(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Verified[] newArray(int i2) {
                return new Verified[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Verified(String paymentMethodId) {
            super(null);
            m.g(paymentMethodId, "paymentMethodId");
            this.paymentMethodId = paymentMethodId;
        }

        public static /* synthetic */ Verified copy$default(Verified verified, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = verified.paymentMethodId;
            }
            return verified.copy(str);
        }

        public final String component1() {
            return this.paymentMethodId;
        }

        public final Verified copy(String paymentMethodId) {
            m.g(paymentMethodId, "paymentMethodId");
            return new Verified(paymentMethodId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Verified) && m.c(this.paymentMethodId, ((Verified) obj).paymentMethodId);
        }

        public final String getPaymentMethodId() {
            return this.paymentMethodId;
        }

        public int hashCode() {
            return this.paymentMethodId.hashCode();
        }

        public String toString() {
            return "Verified(paymentMethodId=" + this.paymentMethodId + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeString(this.paymentMethodId);
        }
    }

    private ConsumerCardCDVResult() {
    }

    public /* synthetic */ ConsumerCardCDVResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}