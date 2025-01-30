package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerSecure3DVerificationResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult;", "Landroid/os/Parcelable;", "<init>", "()V", "Canceled", "Failed", "Success", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult$Success;", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult$Failed;", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult$Canceled;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerSecure3DVerificationResult implements Parcelable {

    /* compiled from: ConsumerSecure3DVerificationResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult$Canceled;", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Canceled extends ConsumerSecure3DVerificationResult {
        public static final Canceled INSTANCE = new Canceled();
        public static final Parcelable.Creator<Canceled> CREATOR = new Creator();

        /* compiled from: ConsumerSecure3DVerificationResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<Canceled> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Canceled createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                parcel.readInt();
                return Canceled.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Canceled[] newArray(int i2) {
                return new Canceled[i2];
            }
        }

        private Canceled() {
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

    /* compiled from: ConsumerSecure3DVerificationResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult$Failed;", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Failed extends ConsumerSecure3DVerificationResult {
        public static final Failed INSTANCE = new Failed();
        public static final Parcelable.Creator<Failed> CREATOR = new Creator();

        /* compiled from: ConsumerSecure3DVerificationResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<Failed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Failed createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                parcel.readInt();
                return Failed.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Failed[] newArray(int i2) {
                return new Failed[i2];
            }
        }

        private Failed() {
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

    /* compiled from: ConsumerSecure3DVerificationResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010\nR\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\rR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b+\u0010\u0007¨\u0006."}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult$Success;", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult;", "Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "component1", "()Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "component2", "()Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "Ljava/util/UUID;", "component3", "()Ljava/util/UUID;", "", "component4", "()Ljava/lang/String;", "selectedTransferMethod", "buyOrder", "uuid", "paymentResult", "copy", "(Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;Ljava/util/UUID;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationResult$Success;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/UUID;", "getUuid", "Ljava/lang/String;", "getPaymentResult", "Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "getSelectedTransferMethod", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "getBuyOrder", "<init>", "(Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;Ljava/util/UUID;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Success extends ConsumerSecure3DVerificationResult {
        public static final Parcelable.Creator<Success> CREATOR = new Creator();
        private final ConsumerBuyOrder buyOrder;
        private final String paymentResult;
        private final AvailableBuyAndSendTransfer selectedTransferMethod;
        private final UUID uuid;

        /* compiled from: ConsumerSecure3DVerificationResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<Success> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Success createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new Success(AvailableBuyAndSendTransfer.CREATOR.createFromParcel(parcel), ConsumerBuyOrder.CREATOR.createFromParcel(parcel), (UUID) parcel.readSerializable(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Success[] newArray(int i2) {
                return new Success[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(AvailableBuyAndSendTransfer selectedTransferMethod, ConsumerBuyOrder buyOrder, UUID uuid, String paymentResult) {
            super(null);
            m.g(selectedTransferMethod, "selectedTransferMethod");
            m.g(buyOrder, "buyOrder");
            m.g(uuid, "uuid");
            m.g(paymentResult, "paymentResult");
            this.selectedTransferMethod = selectedTransferMethod;
            this.buyOrder = buyOrder;
            this.uuid = uuid;
            this.paymentResult = paymentResult;
        }

        public static /* synthetic */ Success copy$default(Success success, AvailableBuyAndSendTransfer availableBuyAndSendTransfer, ConsumerBuyOrder consumerBuyOrder, UUID uuid, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                availableBuyAndSendTransfer = success.selectedTransferMethod;
            }
            if ((i2 & 2) != 0) {
                consumerBuyOrder = success.buyOrder;
            }
            if ((i2 & 4) != 0) {
                uuid = success.uuid;
            }
            if ((i2 & 8) != 0) {
                str = success.paymentResult;
            }
            return success.copy(availableBuyAndSendTransfer, consumerBuyOrder, uuid, str);
        }

        public final AvailableBuyAndSendTransfer component1() {
            return this.selectedTransferMethod;
        }

        public final ConsumerBuyOrder component2() {
            return this.buyOrder;
        }

        public final UUID component3() {
            return this.uuid;
        }

        public final String component4() {
            return this.paymentResult;
        }

        public final Success copy(AvailableBuyAndSendTransfer selectedTransferMethod, ConsumerBuyOrder buyOrder, UUID uuid, String paymentResult) {
            m.g(selectedTransferMethod, "selectedTransferMethod");
            m.g(buyOrder, "buyOrder");
            m.g(uuid, "uuid");
            m.g(paymentResult, "paymentResult");
            return new Success(selectedTransferMethod, buyOrder, uuid, paymentResult);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return m.c(this.selectedTransferMethod, success.selectedTransferMethod) && m.c(this.buyOrder, success.buyOrder) && m.c(this.uuid, success.uuid) && m.c(this.paymentResult, success.paymentResult);
            }
            return false;
        }

        public final ConsumerBuyOrder getBuyOrder() {
            return this.buyOrder;
        }

        public final String getPaymentResult() {
            return this.paymentResult;
        }

        public final AvailableBuyAndSendTransfer getSelectedTransferMethod() {
            return this.selectedTransferMethod;
        }

        public final UUID getUuid() {
            return this.uuid;
        }

        public int hashCode() {
            return (((((this.selectedTransferMethod.hashCode() * 31) + this.buyOrder.hashCode()) * 31) + this.uuid.hashCode()) * 31) + this.paymentResult.hashCode();
        }

        public String toString() {
            return "Success(selectedTransferMethod=" + this.selectedTransferMethod + ", buyOrder=" + this.buyOrder + ", uuid=" + this.uuid + ", paymentResult=" + this.paymentResult + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            this.selectedTransferMethod.writeToParcel(out, i2);
            this.buyOrder.writeToParcel(out, i2);
            out.writeSerializable(this.uuid);
            out.writeString(this.paymentResult);
        }
    }

    private ConsumerSecure3DVerificationResult() {
    }

    public /* synthetic */ ConsumerSecure3DVerificationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}