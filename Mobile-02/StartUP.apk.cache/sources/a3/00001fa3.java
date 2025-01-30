package com.coinbase.wallet.features.send.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AdjustableMinerFeeSelection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\tR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b$\u0010\u0005¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeLegacySelection;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;", "Landroid/os/Parcelable;", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "component2", "", "component3", "()Ljava/lang/Integer;", "gasPrice", "gasLimit", AdjustableMinerFeeArgs.NONCE, "copy", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeLegacySelection;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getNonce", "Ljava/math/BigInteger;", "getGasLimit", "getGasPrice", "<init>", "(Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeLegacySelection extends AdjustableMinerFeeSelection implements Parcelable {
    public static final Parcelable.Creator<AdjustableMinerFeeLegacySelection> CREATOR = new Creator();
    private final BigInteger gasLimit;
    private final BigInteger gasPrice;
    private final Integer nonce;

    /* compiled from: AdjustableMinerFeeSelection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<AdjustableMinerFeeLegacySelection> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AdjustableMinerFeeLegacySelection createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new AdjustableMinerFeeLegacySelection((BigInteger) parcel.readSerializable(), (BigInteger) parcel.readSerializable(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AdjustableMinerFeeLegacySelection[] newArray(int i2) {
            return new AdjustableMinerFeeLegacySelection[i2];
        }
    }

    public /* synthetic */ AdjustableMinerFeeLegacySelection(BigInteger bigInteger, BigInteger bigInteger2, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bigInteger, (i2 & 2) != 0 ? null : bigInteger2, (i2 & 4) != 0 ? null : num);
    }

    public static /* synthetic */ AdjustableMinerFeeLegacySelection copy$default(AdjustableMinerFeeLegacySelection adjustableMinerFeeLegacySelection, BigInteger bigInteger, BigInteger bigInteger2, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = adjustableMinerFeeLegacySelection.gasPrice;
        }
        if ((i2 & 2) != 0) {
            bigInteger2 = adjustableMinerFeeLegacySelection.gasLimit;
        }
        if ((i2 & 4) != 0) {
            num = adjustableMinerFeeLegacySelection.nonce;
        }
        return adjustableMinerFeeLegacySelection.copy(bigInteger, bigInteger2, num);
    }

    public final BigInteger component1() {
        return this.gasPrice;
    }

    public final BigInteger component2() {
        return this.gasLimit;
    }

    public final Integer component3() {
        return this.nonce;
    }

    public final AdjustableMinerFeeLegacySelection copy(BigInteger gasPrice, BigInteger bigInteger, Integer num) {
        m.g(gasPrice, "gasPrice");
        return new AdjustableMinerFeeLegacySelection(gasPrice, bigInteger, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdjustableMinerFeeLegacySelection) {
            AdjustableMinerFeeLegacySelection adjustableMinerFeeLegacySelection = (AdjustableMinerFeeLegacySelection) obj;
            return m.c(this.gasPrice, adjustableMinerFeeLegacySelection.gasPrice) && m.c(this.gasLimit, adjustableMinerFeeLegacySelection.gasLimit) && m.c(this.nonce, adjustableMinerFeeLegacySelection.nonce);
        }
        return false;
    }

    public final BigInteger getGasLimit() {
        return this.gasLimit;
    }

    public final BigInteger getGasPrice() {
        return this.gasPrice;
    }

    public final Integer getNonce() {
        return this.nonce;
    }

    public int hashCode() {
        int hashCode = this.gasPrice.hashCode() * 31;
        BigInteger bigInteger = this.gasLimit;
        int hashCode2 = (hashCode + (bigInteger == null ? 0 : bigInteger.hashCode())) * 31;
        Integer num = this.nonce;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "AdjustableMinerFeeLegacySelection(gasPrice=" + this.gasPrice + ", gasLimit=" + this.gasLimit + ", nonce=" + this.nonce + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        int intValue;
        m.g(out, "out");
        out.writeSerializable(this.gasPrice);
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
    public AdjustableMinerFeeLegacySelection(BigInteger gasPrice, BigInteger bigInteger, Integer num) {
        super(null);
        m.g(gasPrice, "gasPrice");
        this.gasPrice = gasPrice;
        this.gasLimit = bigInteger;
        this.nonce = num;
    }
}