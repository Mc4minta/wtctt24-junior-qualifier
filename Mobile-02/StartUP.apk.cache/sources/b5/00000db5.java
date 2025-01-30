package com.coinbase.android.apiv3.generated.authed.personalized_assets;

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

/* compiled from: GetPersonalizedAssetsRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/GetPersonalizedAssetsRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "base", "resolution", "limit", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/GetPersonalizedAssetsRequest;", "Ljava/lang/String;", "getBase", "getLimit", "getResolution", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetPersonalizedAssetsRequest extends a {
    public static final ProtoAdapter<GetPersonalizedAssetsRequest> ADAPTER;
    public static final Parcelable.Creator<GetPersonalizedAssetsRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String base;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String limit;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String resolution;

    /* compiled from: GetPersonalizedAssetsRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/GetPersonalizedAssetsRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/GetPersonalizedAssetsRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetPersonalizedAssetsRequest> protoAdapter = new ProtoAdapter<GetPersonalizedAssetsRequest>(c.LENGTH_DELIMITED, e0.b(GetPersonalizedAssetsRequest.class), "type.googleapis.com/coinbase.public_api.authed.personalized_assets.GetPersonalizedAssetsRequest") { // from class: com.coinbase.android.apiv3.generated.authed.personalized_assets.GetPersonalizedAssetsRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetPersonalizedAssetsRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                String str3 = str2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetPersonalizedAssetsRequest(str, str2, str3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetPersonalizedAssetsRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getBase(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getBase());
                }
                if (!m.c(value.getResolution(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getResolution());
                }
                if (!m.c(value.getLimit(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getLimit());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetPersonalizedAssetsRequest value) {
                m.h(value, "value");
                if (m.c(value.getBase(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getBase());
                if (!m.c(value.getResolution(), "")) {
                    r2 = (m.c(value.getLimit(), "") ? 0 : protoAdapter2.encodedSizeWithTag(3, value.getLimit()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(2, value.getResolution());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetPersonalizedAssetsRequest redact(GetPersonalizedAssetsRequest value) {
                m.h(value, "value");
                return GetPersonalizedAssetsRequest.copy$default(value, null, null, null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetPersonalizedAssetsRequest() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ GetPersonalizedAssetsRequest(String str, String str2, String str3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetPersonalizedAssetsRequest copy$default(GetPersonalizedAssetsRequest getPersonalizedAssetsRequest, String str, String str2, String str3, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getPersonalizedAssetsRequest.base;
        }
        if ((i2 & 2) != 0) {
            str2 = getPersonalizedAssetsRequest.resolution;
        }
        if ((i2 & 4) != 0) {
            str3 = getPersonalizedAssetsRequest.limit;
        }
        if ((i2 & 8) != 0) {
            iVar = getPersonalizedAssetsRequest.unknownFields();
        }
        return getPersonalizedAssetsRequest.copy(str, str2, str3, iVar);
    }

    public final GetPersonalizedAssetsRequest copy(String base, String resolution, String limit, i unknownFields) {
        m.h(base, "base");
        m.h(resolution, "resolution");
        m.h(limit, "limit");
        m.h(unknownFields, "unknownFields");
        return new GetPersonalizedAssetsRequest(base, resolution, limit, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetPersonalizedAssetsRequest) {
            GetPersonalizedAssetsRequest getPersonalizedAssetsRequest = (GetPersonalizedAssetsRequest) obj;
            return m.c(unknownFields(), getPersonalizedAssetsRequest.unknownFields()) && m.c(this.base, getPersonalizedAssetsRequest.base) && m.c(this.resolution, getPersonalizedAssetsRequest.resolution) && m.c(this.limit, getPersonalizedAssetsRequest.limit);
        }
        return false;
    }

    public final String getBase() {
        return this.base;
    }

    public final String getLimit() {
        return this.limit;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.base.hashCode()) * 37) + this.resolution.hashCode()) * 37) + this.limit.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m440newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("base=" + b.c(this.base));
        arrayList.add("resolution=" + b.c(this.resolution));
        arrayList.add("limit=" + b.c(this.limit));
        h0 = z.h0(arrayList, ", ", "GetPersonalizedAssetsRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPersonalizedAssetsRequest(String base, String resolution, String limit, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(base, "base");
        m.h(resolution, "resolution");
        m.h(limit, "limit");
        m.h(unknownFields, "unknownFields");
        this.base = base;
        this.resolution = resolution;
        this.limit = limit;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m440newBuilder() {
        throw new AssertionError();
    }
}