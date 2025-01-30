package com.coinbase.wallet.swap.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AmountBase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0005\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/swap/models/AmountBase;", "Landroid/os/Parcelable;", "", "getDescription", "()Ljava/lang/String;", ApiConstants.DESCRIPTION, "<init>", "()V", "Source", "Target", "Lcom/coinbase/wallet/swap/models/AmountBase$Source;", "Lcom/coinbase/wallet/swap/models/AmountBase$Target;", "swap_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class AmountBase implements Parcelable {

    /* compiled from: AmountBase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/swap/models/AmountBase$Source;", "Lcom/coinbase/wallet/swap/models/AmountBase;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "swap_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Source extends AmountBase {
        public static final Source INSTANCE = new Source();
        public static final Parcelable.Creator<Source> CREATOR = new Creator();

        /* compiled from: AmountBase.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Source> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Source createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                parcel.readInt();
                return Source.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Source[] newArray(int i2) {
                return new Source[i2];
            }
        }

        private Source() {
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

    /* compiled from: AmountBase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/swap/models/AmountBase$Target;", "Lcom/coinbase/wallet/swap/models/AmountBase;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "swap_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Target extends AmountBase {
        public static final Target INSTANCE = new Target();
        public static final Parcelable.Creator<Target> CREATOR = new Creator();

        /* compiled from: AmountBase.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Creator implements Parcelable.Creator<Target> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Target createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                parcel.readInt();
                return Target.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Target[] newArray(int i2) {
                return new Target[i2];
            }
        }

        private Target() {
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

    private AmountBase() {
    }

    public /* synthetic */ AmountBase(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getDescription() {
        if (m.c(this, Source.INSTANCE)) {
            return ApiConstants.FROM;
        }
        if (m.c(this, Target.INSTANCE)) {
            return ApiConstants.TO;
        }
        throw new NoWhenBranchMatchedException();
    }
}