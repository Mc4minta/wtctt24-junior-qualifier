package com.coinbase.wallet.txhistory.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.SendDestinationPickerArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: RecipientType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0005j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/txhistory/models/RecipientType;", "", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "rawValue", "I", "getRawValue", "<init>", "(Ljava/lang/String;II)V", "Companion", "Coinbase", "User", "ENS", SendDestinationPickerArgs.ADDRESS, "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum RecipientType implements Parcelable {
    Coinbase(0),
    User(1),
    ENS(2),
    Address(3);
    
    private final int rawValue;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<RecipientType> CREATOR = new Parcelable.Creator<RecipientType>() { // from class: com.coinbase.wallet.txhistory.models.RecipientType.Creator
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecipientType createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return RecipientType.valueOf(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecipientType[] newArray(int i2) {
            return new RecipientType[i2];
        }
    };

    /* compiled from: RecipientType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/txhistory/models/RecipientType$Companion;", "", "", "value", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", ApiConstants.FROM, "(I)Lcom/coinbase/wallet/txhistory/models/RecipientType;", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecipientType from(int i2) {
            RecipientType[] values;
            for (RecipientType recipientType : RecipientType.values()) {
                if (recipientType.getRawValue() == i2) {
                    return recipientType;
                }
            }
            return null;
        }
    }

    RecipientType(int i2) {
        this.rawValue = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getRawValue() {
        return this.rawValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(name());
    }
}