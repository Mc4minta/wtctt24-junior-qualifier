package com.coinbase.android.apiv3.generated.unauthed.loyalty;

import android.os.Parcelable;
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

/* compiled from: GetCampaignRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/GetCampaignRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "asset_slug", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/GetCampaignRequest;", "Ljava/lang/String;", "getAsset_slug", "<init>", "(Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetCampaignRequest extends a {
    public static final ProtoAdapter<GetCampaignRequest> ADAPTER;
    public static final Parcelable.Creator<GetCampaignRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "assetSlug", tag = 1)
    private final String asset_slug;

    /* compiled from: GetCampaignRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/GetCampaignRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/GetCampaignRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetCampaignRequest> protoAdapter = new ProtoAdapter<GetCampaignRequest>(c.LENGTH_DELIMITED, e0.b(GetCampaignRequest.class), "type.googleapis.com/coinbase.public_api.unauthed.loyalty.GetCampaignRequest") { // from class: com.coinbase.android.apiv3.generated.unauthed.loyalty.GetCampaignRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetCampaignRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetCampaignRequest(str, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetCampaignRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getAsset_slug(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getAsset_slug());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetCampaignRequest value) {
                m.h(value, "value");
                if (m.c(value.getAsset_slug(), "")) {
                    return 0;
                }
                return value.unknownFields().Q() + ProtoAdapter.STRING.encodedSizeWithTag(1, value.getAsset_slug());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetCampaignRequest redact(GetCampaignRequest value) {
                m.h(value, "value");
                return GetCampaignRequest.copy$default(value, null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetCampaignRequest() {
        this(null, null, 3, null);
    }

    public /* synthetic */ GetCampaignRequest(String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetCampaignRequest copy$default(GetCampaignRequest getCampaignRequest, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getCampaignRequest.asset_slug;
        }
        if ((i2 & 2) != 0) {
            iVar = getCampaignRequest.unknownFields();
        }
        return getCampaignRequest.copy(str, iVar);
    }

    public final GetCampaignRequest copy(String asset_slug, i unknownFields) {
        m.h(asset_slug, "asset_slug");
        m.h(unknownFields, "unknownFields");
        return new GetCampaignRequest(asset_slug, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetCampaignRequest) {
            GetCampaignRequest getCampaignRequest = (GetCampaignRequest) obj;
            return m.c(unknownFields(), getCampaignRequest.unknownFields()) && m.c(this.asset_slug, getCampaignRequest.asset_slug);
        }
        return false;
    }

    public final String getAsset_slug() {
        return this.asset_slug;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.asset_slug.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m562newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("asset_slug=" + b.c(this.asset_slug));
        h0 = z.h0(arrayList, ", ", "GetCampaignRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCampaignRequest(String asset_slug, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(asset_slug, "asset_slug");
        m.h(unknownFields, "unknownFields");
        this.asset_slug = asset_slug;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m562newBuilder() {
        throw new AssertionError();
    }
}