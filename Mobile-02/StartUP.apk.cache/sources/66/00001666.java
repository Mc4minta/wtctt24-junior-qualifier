package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerBuyOrder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJL\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0019J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b\u0013\u0010\rR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b,\u0010\u0007¨\u0006/"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Ljava/math/BigDecimal;", "component2", "()Ljava/math/BigDecimal;", "component3", "component4", "component5", "", "component6", "()Z", "id", "amount", ApiConstants.FEE, "paymentMethodFee", "paymentMethodId", "isInstant", "copy", "(Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Z)Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "getPaymentMethodId", "Ljava/math/BigDecimal;", "getFee", "getAmount", "Z", "getPaymentMethodFee", "<init>", "(Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerBuyOrder implements Parcelable {
    public static final Parcelable.Creator<ConsumerBuyOrder> CREATOR = new Creator();
    private final BigDecimal amount;
    private final BigDecimal fee;
    private final String id;
    private final boolean isInstant;
    private final BigDecimal paymentMethodFee;
    private final String paymentMethodId;

    /* compiled from: ConsumerBuyOrder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ConsumerBuyOrder> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerBuyOrder createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new ConsumerBuyOrder(parcel.readString(), (BigDecimal) parcel.readSerializable(), (BigDecimal) parcel.readSerializable(), (BigDecimal) parcel.readSerializable(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerBuyOrder[] newArray(int i2) {
            return new ConsumerBuyOrder[i2];
        }
    }

    public ConsumerBuyOrder(String id, BigDecimal amount, BigDecimal fee, BigDecimal paymentMethodFee, String paymentMethodId, boolean z) {
        m.g(id, "id");
        m.g(amount, "amount");
        m.g(fee, "fee");
        m.g(paymentMethodFee, "paymentMethodFee");
        m.g(paymentMethodId, "paymentMethodId");
        this.id = id;
        this.amount = amount;
        this.fee = fee;
        this.paymentMethodFee = paymentMethodFee;
        this.paymentMethodId = paymentMethodId;
        this.isInstant = z;
    }

    public static /* synthetic */ ConsumerBuyOrder copy$default(ConsumerBuyOrder consumerBuyOrder, String str, BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerBuyOrder.id;
        }
        if ((i2 & 2) != 0) {
            bigDecimal = consumerBuyOrder.amount;
        }
        BigDecimal bigDecimal4 = bigDecimal;
        if ((i2 & 4) != 0) {
            bigDecimal2 = consumerBuyOrder.fee;
        }
        BigDecimal bigDecimal5 = bigDecimal2;
        if ((i2 & 8) != 0) {
            bigDecimal3 = consumerBuyOrder.paymentMethodFee;
        }
        BigDecimal bigDecimal6 = bigDecimal3;
        if ((i2 & 16) != 0) {
            str2 = consumerBuyOrder.paymentMethodId;
        }
        String str3 = str2;
        if ((i2 & 32) != 0) {
            z = consumerBuyOrder.isInstant;
        }
        return consumerBuyOrder.copy(str, bigDecimal4, bigDecimal5, bigDecimal6, str3, z);
    }

    public final String component1() {
        return this.id;
    }

    public final BigDecimal component2() {
        return this.amount;
    }

    public final BigDecimal component3() {
        return this.fee;
    }

    public final BigDecimal component4() {
        return this.paymentMethodFee;
    }

    public final String component5() {
        return this.paymentMethodId;
    }

    public final boolean component6() {
        return this.isInstant;
    }

    public final ConsumerBuyOrder copy(String id, BigDecimal amount, BigDecimal fee, BigDecimal paymentMethodFee, String paymentMethodId, boolean z) {
        m.g(id, "id");
        m.g(amount, "amount");
        m.g(fee, "fee");
        m.g(paymentMethodFee, "paymentMethodFee");
        m.g(paymentMethodId, "paymentMethodId");
        return new ConsumerBuyOrder(id, amount, fee, paymentMethodFee, paymentMethodId, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerBuyOrder) {
            ConsumerBuyOrder consumerBuyOrder = (ConsumerBuyOrder) obj;
            return m.c(this.id, consumerBuyOrder.id) && m.c(this.amount, consumerBuyOrder.amount) && m.c(this.fee, consumerBuyOrder.fee) && m.c(this.paymentMethodFee, consumerBuyOrder.paymentMethodFee) && m.c(this.paymentMethodId, consumerBuyOrder.paymentMethodId) && this.isInstant == consumerBuyOrder.isInstant;
        }
        return false;
    }

    public final BigDecimal getAmount() {
        return this.amount;
    }

    public final BigDecimal getFee() {
        return this.fee;
    }

    public final String getId() {
        return this.id;
    }

    public final BigDecimal getPaymentMethodFee() {
        return this.paymentMethodFee;
    }

    public final String getPaymentMethodId() {
        return this.paymentMethodId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.id.hashCode() * 31) + this.amount.hashCode()) * 31) + this.fee.hashCode()) * 31) + this.paymentMethodFee.hashCode()) * 31) + this.paymentMethodId.hashCode()) * 31;
        boolean z = this.isInstant;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public final boolean isInstant() {
        return this.isInstant;
    }

    public String toString() {
        return "ConsumerBuyOrder(id=" + this.id + ", amount=" + this.amount + ", fee=" + this.fee + ", paymentMethodFee=" + this.paymentMethodFee + ", paymentMethodId=" + this.paymentMethodId + ", isInstant=" + this.isInstant + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.id);
        out.writeSerializable(this.amount);
        out.writeSerializable(this.fee);
        out.writeSerializable(this.paymentMethodFee);
        out.writeString(this.paymentMethodId);
        out.writeInt(this.isInstant ? 1 : 0);
    }
}