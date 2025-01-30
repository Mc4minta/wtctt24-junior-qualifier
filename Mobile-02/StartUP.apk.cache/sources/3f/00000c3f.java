package com.coinbase.android.apiv3.generated.authed.hydrated_view_service_authed;

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

/* compiled from: WatchListRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/hydrated_view_service_authed/WatchListRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "base", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/hydrated_view_service_authed/WatchListRequest;", "Ljava/lang/String;", "getBase", "<init>", "(Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class WatchListRequest extends a {
    public static final ProtoAdapter<WatchListRequest> ADAPTER;
    public static final Parcelable.Creator<WatchListRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String base;

    /* compiled from: WatchListRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/hydrated_view_service_authed/WatchListRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/hydrated_view_service_authed/WatchListRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<WatchListRequest> protoAdapter = new ProtoAdapter<WatchListRequest>(c.LENGTH_DELIMITED, e0.b(WatchListRequest.class), "type.googleapis.com/coinbase.public_api.authed.hydrated_view_service_authed.WatchListRequest") { // from class: com.coinbase.android.apiv3.generated.authed.hydrated_view_service_authed.WatchListRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WatchListRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new WatchListRequest(str, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, WatchListRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getBase(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getBase());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(WatchListRequest value) {
                m.h(value, "value");
                if (m.c(value.getBase(), "")) {
                    return 0;
                }
                return value.unknownFields().Q() + ProtoAdapter.STRING.encodedSizeWithTag(1, value.getBase());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public WatchListRequest redact(WatchListRequest value) {
                m.h(value, "value");
                return WatchListRequest.copy$default(value, null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public WatchListRequest() {
        this(null, null, 3, null);
    }

    public /* synthetic */ WatchListRequest(String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ WatchListRequest copy$default(WatchListRequest watchListRequest, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = watchListRequest.base;
        }
        if ((i2 & 2) != 0) {
            iVar = watchListRequest.unknownFields();
        }
        return watchListRequest.copy(str, iVar);
    }

    public final WatchListRequest copy(String base, i unknownFields) {
        m.h(base, "base");
        m.h(unknownFields, "unknownFields");
        return new WatchListRequest(base, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof WatchListRequest) {
            WatchListRequest watchListRequest = (WatchListRequest) obj;
            return m.c(unknownFields(), watchListRequest.unknownFields()) && m.c(this.base, watchListRequest.base);
        }
        return false;
    }

    public final String getBase() {
        return this.base;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.base.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m335newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("base=" + b.c(this.base));
        h0 = z.h0(arrayList, ", ", "WatchListRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchListRequest(String base, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(base, "base");
        m.h(unknownFields, "unknownFields");
        this.base = base;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m335newBuilder() {
        throw new AssertionError();
    }
}