package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerConnectionStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\rJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/consumer/models/NotConnected;", "Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "", "component1", "()Z", "onrampEnabled", "copy", "(Z)Lcom/coinbase/wallet/consumer/models/NotConnected;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getOnrampEnabled", "<init>", "(Z)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NotConnected extends ConsumerConnectionStatus {
    public static final Parcelable.Creator<NotConnected> CREATOR = new Creator();
    private final boolean onrampEnabled;

    /* compiled from: ConsumerConnectionStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<NotConnected> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotConnected createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new NotConnected(parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotConnected[] newArray(int i2) {
            return new NotConnected[i2];
        }
    }

    public NotConnected(boolean z) {
        super(z, null);
        this.onrampEnabled = z;
    }

    public static /* synthetic */ NotConnected copy$default(NotConnected notConnected, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = notConnected.getOnrampEnabled();
        }
        return notConnected.copy(z);
    }

    public final boolean component1() {
        return getOnrampEnabled();
    }

    public final NotConnected copy(boolean z) {
        return new NotConnected(z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NotConnected) && getOnrampEnabled() == ((NotConnected) obj).getOnrampEnabled();
    }

    @Override // com.coinbase.wallet.consumer.models.ConsumerConnectionStatus
    public boolean getOnrampEnabled() {
        return this.onrampEnabled;
    }

    public int hashCode() {
        boolean onrampEnabled = getOnrampEnabled();
        if (onrampEnabled) {
            return 1;
        }
        return onrampEnabled ? 1 : 0;
    }

    public String toString() {
        return "NotConnected(onrampEnabled=" + getOnrampEnabled() + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeInt(this.onrampEnabled ? 1 : 0);
    }
}