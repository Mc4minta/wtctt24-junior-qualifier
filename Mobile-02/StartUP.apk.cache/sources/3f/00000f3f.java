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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: AssetStatsFullRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetStatsFullRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "base", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetStatsFullRequest;", "Ljava/lang/String;", "getBase", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AssetStatsFullRequest extends com.squareup.wire.a {
    public static final ProtoAdapter<AssetStatsFullRequest> ADAPTER;
    public static final Parcelable.Creator<AssetStatsFullRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String base;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;

    /* compiled from: AssetStatsFullRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetStatsFullRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/hydrated_view_service_unauthed/AssetStatsFullRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<AssetStatsFullRequest> protoAdapter = new ProtoAdapter<AssetStatsFullRequest>(c.LENGTH_DELIMITED, e0.b(AssetStatsFullRequest.class), "type.googleapis.com/coinbase.public_api.unauthed.hydrated_view_service_unauthed.AssetStatsFullRequest") { // from class: com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.AssetStatsFullRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AssetStatsFullRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AssetStatsFullRequest(str, str2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AssetStatsFullRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (!m.c(value.getBase(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getBase());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AssetStatsFullRequest value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return (m.c(value.getBase(), "") ? 0 : protoAdapter2.encodedSizeWithTag(2, value.getBase()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(1, value.getId());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AssetStatsFullRequest redact(AssetStatsFullRequest value) {
                m.h(value, "value");
                return AssetStatsFullRequest.copy$default(value, null, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public AssetStatsFullRequest() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ AssetStatsFullRequest(String str, String str2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AssetStatsFullRequest copy$default(AssetStatsFullRequest assetStatsFullRequest, String str, String str2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = assetStatsFullRequest.id;
        }
        if ((i2 & 2) != 0) {
            str2 = assetStatsFullRequest.base;
        }
        if ((i2 & 4) != 0) {
            iVar = assetStatsFullRequest.unknownFields();
        }
        return assetStatsFullRequest.copy(str, str2, iVar);
    }

    public final AssetStatsFullRequest copy(String id, String base, i unknownFields) {
        m.h(id, "id");
        m.h(base, "base");
        m.h(unknownFields, "unknownFields");
        return new AssetStatsFullRequest(id, base, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetStatsFullRequest) {
            AssetStatsFullRequest assetStatsFullRequest = (AssetStatsFullRequest) obj;
            return m.c(unknownFields(), assetStatsFullRequest.unknownFields()) && m.c(this.id, assetStatsFullRequest.id) && m.c(this.base, assetStatsFullRequest.base);
        }
        return false;
    }

    public final String getBase() {
        return this.base;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.base.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m552newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("base=" + b.c(this.base));
        h0 = z.h0(arrayList, ", ", "AssetStatsFullRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetStatsFullRequest(String id, String base, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(base, "base");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.base = base;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m552newBuilder() {
        throw new AssertionError();
    }
}