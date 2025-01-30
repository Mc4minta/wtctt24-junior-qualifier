package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import j.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: ReorderWatchedAssetsRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB!\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ReorderWatchedAssetsRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "asset_ids", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/ReorderWatchedAssetsRequest;", "Ljava/util/List;", "getAsset_ids", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ReorderWatchedAssetsRequest extends com.squareup.wire.a {
    public static final ProtoAdapter<ReorderWatchedAssetsRequest> ADAPTER;
    public static final Parcelable.Creator<ReorderWatchedAssetsRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "assetIds", label = p.a.REPEATED, tag = 1)
    private final List<String> asset_ids;

    /* compiled from: ReorderWatchedAssetsRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ReorderWatchedAssetsRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/ReorderWatchedAssetsRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ReorderWatchedAssetsRequest> protoAdapter = new ProtoAdapter<ReorderWatchedAssetsRequest>(c.LENGTH_DELIMITED, e0.b(ReorderWatchedAssetsRequest.class), "type.googleapis.com/coinbase.public_api.authed.ReorderWatchedAssetsRequest") { // from class: com.coinbase.android.apiv3.generated.authed.ReorderWatchedAssetsRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ReorderWatchedAssetsRequest decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ReorderWatchedAssetsRequest(arrayList, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        arrayList.add(ProtoAdapter.STRING.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ReorderWatchedAssetsRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 1, value.getAsset_ids());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ReorderWatchedAssetsRequest value) {
                m.h(value, "value");
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, value.getAsset_ids()) + value.unknownFields().Q();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ReorderWatchedAssetsRequest redact(ReorderWatchedAssetsRequest value) {
                m.h(value, "value");
                return ReorderWatchedAssetsRequest.copy$default(value, null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public ReorderWatchedAssetsRequest() {
        this(null, null, 3, null);
    }

    public /* synthetic */ ReorderWatchedAssetsRequest(List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReorderWatchedAssetsRequest copy$default(ReorderWatchedAssetsRequest reorderWatchedAssetsRequest, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = reorderWatchedAssetsRequest.asset_ids;
        }
        if ((i2 & 2) != 0) {
            iVar = reorderWatchedAssetsRequest.unknownFields();
        }
        return reorderWatchedAssetsRequest.copy(list, iVar);
    }

    public final ReorderWatchedAssetsRequest copy(List<String> asset_ids, i unknownFields) {
        m.h(asset_ids, "asset_ids");
        m.h(unknownFields, "unknownFields");
        return new ReorderWatchedAssetsRequest(asset_ids, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReorderWatchedAssetsRequest) {
            ReorderWatchedAssetsRequest reorderWatchedAssetsRequest = (ReorderWatchedAssetsRequest) obj;
            return m.c(unknownFields(), reorderWatchedAssetsRequest.unknownFields()) && m.c(this.asset_ids, reorderWatchedAssetsRequest.asset_ids);
        }
        return false;
    }

    public final List<String> getAsset_ids() {
        return this.asset_ids;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.asset_ids.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m251newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.asset_ids.isEmpty()) {
            arrayList.add("asset_ids=" + com.squareup.wire.q.b.d(this.asset_ids));
        }
        h0 = z.h0(arrayList, ", ", "ReorderWatchedAssetsRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m251newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReorderWatchedAssetsRequest(List<String> asset_ids, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(asset_ids, "asset_ids");
        m.h(unknownFields, "unknownFields");
        this.asset_ids = asset_ids;
    }
}