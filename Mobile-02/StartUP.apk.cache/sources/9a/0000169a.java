package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerTransferMethodResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult;", "Landroid/os/Parcelable;", "<init>", "()V", "AddingPaymentMethod", "SelectedTransfer", "VerifyingPaymentMethod", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult$SelectedTransfer;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult$AddingPaymentMethod;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult$VerifyingPaymentMethod;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerTransferMethodResult implements Parcelable {

    /* compiled from: ConsumerTransferMethodResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult$AddingPaymentMethod;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AddingPaymentMethod extends ConsumerTransferMethodResult {
        public static final AddingPaymentMethod INSTANCE = new AddingPaymentMethod();
        public static final Parcelable.Creator<AddingPaymentMethod> CREATOR = new Creator();

        /* compiled from: ConsumerTransferMethodResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<AddingPaymentMethod> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AddingPaymentMethod createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                parcel.readInt();
                return AddingPaymentMethod.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AddingPaymentMethod[] newArray(int i2) {
                return new AddingPaymentMethod[i2];
            }
        }

        private AddingPaymentMethod() {
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

    /* compiled from: ConsumerTransferMethodResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult$SelectedTransfer;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult;", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "component1", "()Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "transfer", "copy", "(Lcom/coinbase/wallet/consumer/models/AvailableTransfer;)Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult$SelectedTransfer;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "getTransfer", "<init>", "(Lcom/coinbase/wallet/consumer/models/AvailableTransfer;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SelectedTransfer extends ConsumerTransferMethodResult {
        public static final Parcelable.Creator<SelectedTransfer> CREATOR = new Creator();
        private final AvailableTransfer transfer;

        /* compiled from: ConsumerTransferMethodResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<SelectedTransfer> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SelectedTransfer createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new SelectedTransfer((AvailableTransfer) parcel.readParcelable(SelectedTransfer.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SelectedTransfer[] newArray(int i2) {
                return new SelectedTransfer[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectedTransfer(AvailableTransfer transfer) {
            super(null);
            m.g(transfer, "transfer");
            this.transfer = transfer;
        }

        public static /* synthetic */ SelectedTransfer copy$default(SelectedTransfer selectedTransfer, AvailableTransfer availableTransfer, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                availableTransfer = selectedTransfer.transfer;
            }
            return selectedTransfer.copy(availableTransfer);
        }

        public final AvailableTransfer component1() {
            return this.transfer;
        }

        public final SelectedTransfer copy(AvailableTransfer transfer) {
            m.g(transfer, "transfer");
            return new SelectedTransfer(transfer);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectedTransfer) && m.c(this.transfer, ((SelectedTransfer) obj).transfer);
        }

        public final AvailableTransfer getTransfer() {
            return this.transfer;
        }

        public int hashCode() {
            return this.transfer.hashCode();
        }

        public String toString() {
            return "SelectedTransfer(transfer=" + this.transfer + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            out.writeParcelable(this.transfer, i2);
        }
    }

    /* compiled from: ConsumerTransferMethodResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult$VerifyingPaymentMethod;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult;", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "component1", "()Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "paymentMethod", "copy", "(Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;)Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodResult$VerifyingPaymentMethod;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "getPaymentMethod", "<init>", "(Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class VerifyingPaymentMethod extends ConsumerTransferMethodResult {
        public static final Parcelable.Creator<VerifyingPaymentMethod> CREATOR = new Creator();
        private final ConsumerPaymentMethod paymentMethod;

        /* compiled from: ConsumerTransferMethodResult.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<VerifyingPaymentMethod> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final VerifyingPaymentMethod createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                return new VerifyingPaymentMethod(ConsumerPaymentMethod.CREATOR.createFromParcel(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final VerifyingPaymentMethod[] newArray(int i2) {
                return new VerifyingPaymentMethod[i2];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerifyingPaymentMethod(ConsumerPaymentMethod paymentMethod) {
            super(null);
            m.g(paymentMethod, "paymentMethod");
            this.paymentMethod = paymentMethod;
        }

        public static /* synthetic */ VerifyingPaymentMethod copy$default(VerifyingPaymentMethod verifyingPaymentMethod, ConsumerPaymentMethod consumerPaymentMethod, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                consumerPaymentMethod = verifyingPaymentMethod.paymentMethod;
            }
            return verifyingPaymentMethod.copy(consumerPaymentMethod);
        }

        public final ConsumerPaymentMethod component1() {
            return this.paymentMethod;
        }

        public final VerifyingPaymentMethod copy(ConsumerPaymentMethod paymentMethod) {
            m.g(paymentMethod, "paymentMethod");
            return new VerifyingPaymentMethod(paymentMethod);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VerifyingPaymentMethod) && m.c(this.paymentMethod, ((VerifyingPaymentMethod) obj).paymentMethod);
        }

        public final ConsumerPaymentMethod getPaymentMethod() {
            return this.paymentMethod;
        }

        public int hashCode() {
            return this.paymentMethod.hashCode();
        }

        public String toString() {
            return "VerifyingPaymentMethod(paymentMethod=" + this.paymentMethod + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            this.paymentMethod.writeToParcel(out, i2);
        }
    }

    private ConsumerTransferMethodResult() {
    }

    public /* synthetic */ ConsumerTransferMethodResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}