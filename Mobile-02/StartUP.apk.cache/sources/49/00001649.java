package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerConnectionStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0015J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b'\u0010\u0004¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/consumer/models/Connected;", "Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "", "component1", "()Z", "component2", "Ljava/util/Date;", "component3", "()Ljava/util/Date;", "", "component4", "()Ljava/lang/String;", "onrampEnabled", "hasRestrictions", "lastTransactionDate", "email", "copy", "(ZZLjava/util/Date;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/Connected;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/Date;", "getLastTransactionDate", "Ljava/lang/String;", "getEmail", "Z", "getOnrampEnabled", "getHasRestrictions", "<init>", "(ZZLjava/util/Date;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Connected extends ConsumerConnectionStatus {
    public static final Parcelable.Creator<Connected> CREATOR = new Creator();
    private final String email;
    private final boolean hasRestrictions;
    private final Date lastTransactionDate;
    private final boolean onrampEnabled;

    /* compiled from: ConsumerConnectionStatus.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<Connected> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Connected createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new Connected(parcel.readInt() != 0, parcel.readInt() != 0, (Date) parcel.readSerializable(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Connected[] newArray(int i2) {
            return new Connected[i2];
        }
    }

    public /* synthetic */ Connected(boolean z, boolean z2, Date date, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, (i2 & 4) != 0 ? null : date, (i2 & 8) != 0 ? null : str);
    }

    public static /* synthetic */ Connected copy$default(Connected connected, boolean z, boolean z2, Date date, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = connected.getOnrampEnabled();
        }
        if ((i2 & 2) != 0) {
            z2 = connected.hasRestrictions;
        }
        if ((i2 & 4) != 0) {
            date = connected.lastTransactionDate;
        }
        if ((i2 & 8) != 0) {
            str = connected.email;
        }
        return connected.copy(z, z2, date, str);
    }

    public final boolean component1() {
        return getOnrampEnabled();
    }

    public final boolean component2() {
        return this.hasRestrictions;
    }

    public final Date component3() {
        return this.lastTransactionDate;
    }

    public final String component4() {
        return this.email;
    }

    public final Connected copy(boolean z, boolean z2, Date date, String str) {
        return new Connected(z, z2, date, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Connected) {
            Connected connected = (Connected) obj;
            return getOnrampEnabled() == connected.getOnrampEnabled() && this.hasRestrictions == connected.hasRestrictions && m.c(this.lastTransactionDate, connected.lastTransactionDate) && m.c(this.email, connected.email);
        }
        return false;
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean getHasRestrictions() {
        return this.hasRestrictions;
    }

    public final Date getLastTransactionDate() {
        return this.lastTransactionDate;
    }

    @Override // com.coinbase.wallet.consumer.models.ConsumerConnectionStatus
    public boolean getOnrampEnabled() {
        return this.onrampEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean onrampEnabled = getOnrampEnabled();
        ?? r0 = onrampEnabled;
        if (onrampEnabled) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        boolean z = this.hasRestrictions;
        int i3 = (i2 + (z ? 1 : z ? 1 : 0)) * 31;
        Date date = this.lastTransactionDate;
        int hashCode = (i3 + (date == null ? 0 : date.hashCode())) * 31;
        String str = this.email;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "Connected(onrampEnabled=" + getOnrampEnabled() + ", hasRestrictions=" + this.hasRestrictions + ", lastTransactionDate=" + this.lastTransactionDate + ", email=" + ((Object) this.email) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeInt(this.onrampEnabled ? 1 : 0);
        out.writeInt(this.hasRestrictions ? 1 : 0);
        out.writeSerializable(this.lastTransactionDate);
        out.writeString(this.email);
    }

    public Connected(boolean z, boolean z2, Date date, String str) {
        super(z, null);
        this.onrampEnabled = z;
        this.hasRestrictions = z2;
        this.lastTransactionDate = date;
        this.email = str;
    }
}