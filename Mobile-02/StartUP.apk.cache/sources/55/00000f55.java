package com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import com.squareup.wire.q.b;
import j.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: PriceCorrelations.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB+\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PriceCorrelations;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/CorrelatedAsset;", "assets", "updated_at", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PriceCorrelations;", "Ljava/lang/String;", "getUpdated_at", "Ljava/util/List;", "getAssets", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PriceCorrelations extends com.squareup.wire.a {
    public static final ProtoAdapter<PriceCorrelations> ADAPTER;
    public static final Parcelable.Creator<PriceCorrelations> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.CorrelatedAsset#ADAPTER", label = p.a.REPEATED, tag = 1)
    private final List<CorrelatedAsset> assets;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "updatedAt", tag = 2)
    private final String updated_at;

    /* compiled from: PriceCorrelations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PriceCorrelations$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/PriceCorrelations;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        final c cVar = c.LENGTH_DELIMITED;
        final d b2 = e0.b(PriceCorrelations.class);
        ProtoAdapter<PriceCorrelations> protoAdapter = new ProtoAdapter<PriceCorrelations>(cVar, b2, "type.googleapis.com/coinbase.public_api.unauthed.hydrated_view_service_unauthed.PriceCorrelations") { // from class: com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.PriceCorrelations$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PriceCorrelations decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PriceCorrelations(arrayList, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        arrayList.add(CorrelatedAsset.ADAPTER.decode(reader));
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PriceCorrelations value) {
                m.h(writer, "writer");
                m.h(value, "value");
                CorrelatedAsset.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getAssets());
                if (!m.c(value.getUpdated_at(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getUpdated_at());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PriceCorrelations value) {
                int Q;
                m.h(value, "value");
                int encodedSizeWithTag = CorrelatedAsset.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getAssets());
                if (m.c(value.getUpdated_at(), "")) {
                    Q = 0;
                } else {
                    Q = value.unknownFields().Q() + ProtoAdapter.STRING.encodedSizeWithTag(2, value.getUpdated_at());
                }
                return encodedSizeWithTag + Q;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PriceCorrelations redact(PriceCorrelations value) {
                m.h(value, "value");
                return PriceCorrelations.copy$default(value, b.a(value.getAssets(), CorrelatedAsset.ADAPTER), null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public PriceCorrelations() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ PriceCorrelations(List list, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PriceCorrelations copy$default(PriceCorrelations priceCorrelations, List list, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = priceCorrelations.assets;
        }
        if ((i2 & 2) != 0) {
            str = priceCorrelations.updated_at;
        }
        if ((i2 & 4) != 0) {
            iVar = priceCorrelations.unknownFields();
        }
        return priceCorrelations.copy(list, str, iVar);
    }

    public final PriceCorrelations copy(List<CorrelatedAsset> assets, String updated_at, i unknownFields) {
        m.h(assets, "assets");
        m.h(updated_at, "updated_at");
        m.h(unknownFields, "unknownFields");
        return new PriceCorrelations(assets, updated_at, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PriceCorrelations) {
            PriceCorrelations priceCorrelations = (PriceCorrelations) obj;
            return m.c(unknownFields(), priceCorrelations.unknownFields()) && m.c(this.assets, priceCorrelations.assets) && m.c(this.updated_at, priceCorrelations.updated_at);
        }
        return false;
    }

    public final List<CorrelatedAsset> getAssets() {
        return this.assets;
    }

    public final String getUpdated_at() {
        return this.updated_at;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.assets.hashCode()) * 37) + this.updated_at.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m559newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.assets.isEmpty()) {
            arrayList.add("assets=" + this.assets);
        }
        arrayList.add("updated_at=" + b.c(this.updated_at));
        h0 = z.h0(arrayList, ", ", "PriceCorrelations{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m559newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceCorrelations(List<CorrelatedAsset> assets, String updated_at, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(assets, "assets");
        m.h(updated_at, "updated_at");
        m.h(unknownFields, "unknownFields");
        this.assets = assets;
        this.updated_at = updated_at;
    }
}