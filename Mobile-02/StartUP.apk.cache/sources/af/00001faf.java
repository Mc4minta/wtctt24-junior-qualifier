package com.coinbase.wallet.features.send.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeSelection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJF\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0005R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b(\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b)\u0010\u0005R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b*\u0010\u0005¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/features/send/models/MinerFee1559Data;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;", "Landroid/os/Parcelable;", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "maxFeePerGas", "baseFeePerGas", "maxPriorityFee", "gasLimit", AdjustableMinerFeeArgs.NONCE, "copy", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lcom/coinbase/wallet/features/send/models/MinerFee1559Data;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/math/BigInteger;", "getMaxFeePerGas", "Ljava/lang/Integer;", "getNonce", "getBaseFeePerGas", "getMaxPriorityFee", "getGasLimit", "<init>", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MinerFee1559Data extends AdjustableMinerFeeSelection implements Parcelable {
    public static final Parcelable.Creator<MinerFee1559Data> CREATOR = new Creator();
    private final BigInteger baseFeePerGas;
    private final BigInteger gasLimit;
    private final BigInteger maxFeePerGas;
    private final BigInteger maxPriorityFee;
    private final Integer nonce;

    /* compiled from: AdjustableMinerFeeSelection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<MinerFee1559Data> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MinerFee1559Data createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new MinerFee1559Data((BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MinerFee1559Data[] newArray(int i2) {
            return new MinerFee1559Data[i2];
        }
    }

    public /* synthetic */ MinerFee1559Data(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bigInteger, bigInteger2, bigInteger3, (i2 & 8) != 0 ? null : bigInteger4, (i2 & 16) != 0 ? null : num);
    }

    public static /* synthetic */ MinerFee1559Data copy$default(MinerFee1559Data minerFee1559Data, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = minerFee1559Data.maxFeePerGas;
        }
        if ((i2 & 2) != 0) {
            bigInteger2 = minerFee1559Data.baseFeePerGas;
        }
        BigInteger bigInteger5 = bigInteger2;
        if ((i2 & 4) != 0) {
            bigInteger3 = minerFee1559Data.maxPriorityFee;
        }
        BigInteger bigInteger6 = bigInteger3;
        if ((i2 & 8) != 0) {
            bigInteger4 = minerFee1559Data.gasLimit;
        }
        BigInteger bigInteger7 = bigInteger4;
        if ((i2 & 16) != 0) {
            num = minerFee1559Data.nonce;
        }
        return minerFee1559Data.copy(bigInteger, bigInteger5, bigInteger6, bigInteger7, num);
    }

    public final BigInteger component1() {
        return this.maxFeePerGas;
    }

    public final BigInteger component2() {
        return this.baseFeePerGas;
    }

    public final BigInteger component3() {
        return this.maxPriorityFee;
    }

    public final BigInteger component4() {
        return this.gasLimit;
    }

    public final Integer component5() {
        return this.nonce;
    }

    public final MinerFee1559Data copy(BigInteger maxFeePerGas, BigInteger baseFeePerGas, BigInteger maxPriorityFee, BigInteger bigInteger, Integer num) {
        m.g(maxFeePerGas, "maxFeePerGas");
        m.g(baseFeePerGas, "baseFeePerGas");
        m.g(maxPriorityFee, "maxPriorityFee");
        return new MinerFee1559Data(maxFeePerGas, baseFeePerGas, maxPriorityFee, bigInteger, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MinerFee1559Data) {
            MinerFee1559Data minerFee1559Data = (MinerFee1559Data) obj;
            return m.c(this.maxFeePerGas, minerFee1559Data.maxFeePerGas) && m.c(this.baseFeePerGas, minerFee1559Data.baseFeePerGas) && m.c(this.maxPriorityFee, minerFee1559Data.maxPriorityFee) && m.c(this.gasLimit, minerFee1559Data.gasLimit) && m.c(this.nonce, minerFee1559Data.nonce);
        }
        return false;
    }

    public final BigInteger getBaseFeePerGas() {
        return this.baseFeePerGas;
    }

    public final BigInteger getGasLimit() {
        return this.gasLimit;
    }

    public final BigInteger getMaxFeePerGas() {
        return this.maxFeePerGas;
    }

    public final BigInteger getMaxPriorityFee() {
        return this.maxPriorityFee;
    }

    public final Integer getNonce() {
        return this.nonce;
    }

    public int hashCode() {
        int hashCode = ((((this.maxFeePerGas.hashCode() * 31) + this.baseFeePerGas.hashCode()) * 31) + this.maxPriorityFee.hashCode()) * 31;
        BigInteger bigInteger = this.gasLimit;
        int hashCode2 = (hashCode + (bigInteger == null ? 0 : bigInteger.hashCode())) * 31;
        Integer num = this.nonce;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "MinerFee1559Data(maxFeePerGas=" + this.maxFeePerGas + ", baseFeePerGas=" + this.baseFeePerGas + ", maxPriorityFee=" + this.maxPriorityFee + ", gasLimit=" + this.gasLimit + ", nonce=" + this.nonce + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        int intValue;
        m.g(out, "out");
        out.writeSerializable(this.maxFeePerGas);
        out.writeSerializable(this.baseFeePerGas);
        out.writeSerializable(this.maxPriorityFee);
        out.writeSerializable(this.gasLimit);
        Integer num = this.nonce;
        if (num == null) {
            intValue = 0;
        } else {
            out.writeInt(1);
            intValue = num.intValue();
        }
        out.writeInt(intValue);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MinerFee1559Data(BigInteger maxFeePerGas, BigInteger baseFeePerGas, BigInteger maxPriorityFee, BigInteger bigInteger, Integer num) {
        super(null);
        m.g(maxFeePerGas, "maxFeePerGas");
        m.g(baseFeePerGas, "baseFeePerGas");
        m.g(maxPriorityFee, "maxPriorityFee");
        this.maxFeePerGas = maxFeePerGas;
        this.baseFeePerGas = baseFeePerGas;
        this.maxPriorityFee = maxPriorityFee;
        this.gasLimit = bigInteger;
        this.nonce = num;
    }
}