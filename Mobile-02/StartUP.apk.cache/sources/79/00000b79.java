package com.coinbase.android.apiv3.generated.authed.addresses;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Ref;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
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

/* compiled from: DismissWarningRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB'\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/addresses/DismissWarningRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "type", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "asset_id", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Ref;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/addresses/DismissWarningRequest;", "Ljava/lang/String;", "getType", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getAsset_id", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Ref;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DismissWarningRequest extends a {
    public static final ProtoAdapter<DismissWarningRequest> ADAPTER;
    public static final Parcelable.Creator<DismissWarningRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "assetId", tag = 2)
    private final Ref asset_id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String type;

    /* compiled from: DismissWarningRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/addresses/DismissWarningRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/addresses/DismissWarningRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<DismissWarningRequest> protoAdapter = new ProtoAdapter<DismissWarningRequest>(c.LENGTH_DELIMITED, e0.b(DismissWarningRequest.class), "type.googleapis.com/coinbase.public_api.authed.addresses.DismissWarningRequest") { // from class: com.coinbase.android.apiv3.generated.authed.addresses.DismissWarningRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DismissWarningRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                Ref ref = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new DismissWarningRequest(str, ref, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        ref = Ref.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, DismissWarningRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getType(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getType());
                }
                if (value.getAsset_id() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 2, value.getAsset_id());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(DismissWarningRequest value) {
                m.h(value, "value");
                if (m.c(value.getType(), "")) {
                    return 0;
                }
                return (value.getAsset_id() != null ? Ref.ADAPTER.encodedSizeWithTag(2, value.getAsset_id()) + value.unknownFields().Q() : 0) + ProtoAdapter.STRING.encodedSizeWithTag(1, value.getType());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public DismissWarningRequest redact(DismissWarningRequest value) {
                m.h(value, "value");
                Ref asset_id = value.getAsset_id();
                return DismissWarningRequest.copy$default(value, null, asset_id != null ? Ref.ADAPTER.redact(asset_id) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public DismissWarningRequest() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ DismissWarningRequest(String str, Ref ref, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : ref, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ DismissWarningRequest copy$default(DismissWarningRequest dismissWarningRequest, String str, Ref ref, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dismissWarningRequest.type;
        }
        if ((i2 & 2) != 0) {
            ref = dismissWarningRequest.asset_id;
        }
        if ((i2 & 4) != 0) {
            iVar = dismissWarningRequest.unknownFields();
        }
        return dismissWarningRequest.copy(str, ref, iVar);
    }

    public final DismissWarningRequest copy(String type, Ref ref, i unknownFields) {
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        return new DismissWarningRequest(type, ref, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DismissWarningRequest) {
            DismissWarningRequest dismissWarningRequest = (DismissWarningRequest) obj;
            return m.c(unknownFields(), dismissWarningRequest.unknownFields()) && m.c(this.type, dismissWarningRequest.type) && m.c(this.asset_id, dismissWarningRequest.asset_id);
        }
        return false;
    }

    public final Ref getAsset_id() {
        return this.asset_id;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37;
            Ref ref = this.asset_id;
            int hashCode2 = hashCode + (ref != null ? ref.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m274newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + b.c(this.type));
        if (this.asset_id != null) {
            arrayList.add("asset_id=" + this.asset_id);
        }
        h0 = z.h0(arrayList, ", ", "DismissWarningRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DismissWarningRequest(String type, Ref ref, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.asset_id = ref;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m274newBuilder() {
        throw new AssertionError();
    }
}