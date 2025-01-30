package com.coinbase.wallet.blockchains.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.wallet.blockchains.dbconverters.TxMetadataConverter;
import i.a.a.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TxMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\b\u0010\u0006J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadata;", "Landroid/os/Parcelable;", "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", "toMap", "()Ljava/util/Map;", "", "toMutableMap", "key", "get", "(Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;)Ljava/lang/Object;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "metadataMap", "Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "Companion", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxMetadata implements Parcelable {
    private final Map<TxMetadataKey, Object> metadataMap;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<TxMetadata> CREATOR = new Creator();
    private static final TxMetadataConverter txMetadataMapConverter = new TxMetadataConverter();

    /* compiled from: TxMetadata.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TxMetadata$Companion;", "Li/a/a/a;", "Lcom/coinbase/wallet/blockchains/models/TxMetadata;", "Landroid/os/Parcel;", "parcel", "", "flags", "Lkotlin/x;", "write", "(Lcom/coinbase/wallet/blockchains/models/TxMetadata;Landroid/os/Parcel;I)V", "create", "(Landroid/os/Parcel;)Lcom/coinbase/wallet/blockchains/models/TxMetadata;", "Lcom/coinbase/wallet/blockchains/dbconverters/TxMetadataConverter;", "txMetadataMapConverter", "Lcom/coinbase/wallet/blockchains/dbconverters/TxMetadataConverter;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion implements a<TxMetadata> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: newArray */
        public TxMetadata[] m785newArray(int i2) {
            return (TxMetadata[]) a.C0405a.a(this, i2);
        }

        /* renamed from: create */
        public TxMetadata m784create(Parcel parcel) {
            m.g(parcel, "parcel");
            String readString = parcel.readString();
            return readString == null ? new TxMetadata(null, 1, null) : TxMetadata.txMetadataMapConverter.fromString(readString);
        }

        public void write(TxMetadata txMetadata, Parcel parcel, int i2) {
            m.g(txMetadata, "<this>");
            m.g(parcel, "parcel");
            parcel.writeString(TxMetadata.txMetadataMapConverter.toString(txMetadata));
        }
    }

    /* compiled from: TxMetadata.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<TxMetadata> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TxMetadata createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return TxMetadata.Companion.m784create(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TxMetadata[] newArray(int i2) {
            return new TxMetadata[i2];
        }
    }

    public TxMetadata() {
        this(null, 1, null);
    }

    public TxMetadata(Map<TxMetadataKey, ? extends Object> metadataMap) {
        m.g(metadataMap, "metadataMap");
        this.metadataMap = metadataMap;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Object get(TxMetadataKey key) {
        m.g(key, "key");
        return this.metadataMap.get(key);
    }

    public final Map<TxMetadataKey, Object> toMap() {
        Map<TxMetadataKey, Object> t;
        t = m0.t(this.metadataMap);
        return t;
    }

    public final Map<TxMetadataKey, Object> toMutableMap() {
        Map<TxMetadataKey, Object> v;
        v = m0.v(this.metadataMap);
        return v;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        Companion.write(this, out, i2);
    }

    public /* synthetic */ TxMetadata(Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? m0.i() : map);
    }
}