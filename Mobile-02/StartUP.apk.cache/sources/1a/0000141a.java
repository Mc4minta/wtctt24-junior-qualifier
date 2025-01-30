package com.coinbase.wallet.blockchains.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TxMetadataKey.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "component1", "component2", "rawValue", "className", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getRawValue", "getClassName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxMetadataKey implements Parcelable {
    private final String className;
    private final String rawValue;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<TxMetadataKey> CREATOR = new Creator();

    /* compiled from: TxMetadataKey.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadataKey$Companion;", "", "", "rawValue", "Ljava/lang/Class;", "clazz", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "create", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TxMetadataKey create(String rawValue, Class<?> clazz) {
            m.g(rawValue, "rawValue");
            m.g(clazz, "clazz");
            String name = clazz.getName();
            m.f(name, "clazz.name");
            return new TxMetadataKey(rawValue, name);
        }
    }

    /* compiled from: TxMetadataKey.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<TxMetadataKey> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TxMetadataKey createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new TxMetadataKey(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TxMetadataKey[] newArray(int i2) {
            return new TxMetadataKey[i2];
        }
    }

    public TxMetadataKey(String rawValue, String className) {
        m.g(rawValue, "rawValue");
        m.g(className, "className");
        this.rawValue = rawValue;
        this.className = className;
    }

    public static /* synthetic */ TxMetadataKey copy$default(TxMetadataKey txMetadataKey, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = txMetadataKey.rawValue;
        }
        if ((i2 & 2) != 0) {
            str2 = txMetadataKey.className;
        }
        return txMetadataKey.copy(str, str2);
    }

    public final String component1() {
        return this.rawValue;
    }

    public final String component2() {
        return this.className;
    }

    public final TxMetadataKey copy(String rawValue, String className) {
        m.g(rawValue, "rawValue");
        m.g(className, "className");
        return new TxMetadataKey(rawValue, className);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TxMetadataKey) {
            TxMetadataKey txMetadataKey = (TxMetadataKey) obj;
            return m.c(this.rawValue, txMetadataKey.rawValue) && m.c(this.className, txMetadataKey.className);
        }
        return false;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public int hashCode() {
        return (this.rawValue.hashCode() * 31) + this.className.hashCode();
    }

    public String toString() {
        return this.rawValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.rawValue);
        out.writeString(this.className);
    }
}