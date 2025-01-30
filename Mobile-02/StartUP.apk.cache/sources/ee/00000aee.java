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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: ListNotificationsRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0012\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "page_size", "page_token", "Lj/i;", "unknownFields", "copy", "(JJLj/i;)Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsRequest;", "J", "getPage_token", "()J", "getPage_size", "<init>", "(JJLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListNotificationsRequest extends com.squareup.wire.a {
    public static final ProtoAdapter<ListNotificationsRequest> ADAPTER;
    public static final Parcelable.Creator<ListNotificationsRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "pageSize", tag = 1)
    private final long page_size;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "pageToken", tag = 2)
    private final long page_token;

    /* compiled from: ListNotificationsRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ListNotificationsRequest> protoAdapter = new ProtoAdapter<ListNotificationsRequest>(c.LENGTH_DELIMITED, e0.b(ListNotificationsRequest.class), "type.googleapis.com/coinbase.public_api.authed.ListNotificationsRequest") { // from class: com.coinbase.android.apiv3.generated.authed.ListNotificationsRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ListNotificationsRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                long j2 = 0;
                long j3 = 0;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ListNotificationsRequest(j2, j3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        j2 = ProtoAdapter.INT64.decode(reader).longValue();
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        j3 = ProtoAdapter.INT64.decode(reader).longValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ListNotificationsRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getPage_size() != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, Long.valueOf(value.getPage_size()));
                }
                if (value.getPage_token() != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 2, Long.valueOf(value.getPage_token()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ListNotificationsRequest value) {
                m.h(value, "value");
                if (value.getPage_size() == 0) {
                    return 0;
                }
                ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                return (value.getPage_token() != 0 ? protoAdapter2.encodedSizeWithTag(2, Long.valueOf(value.getPage_token())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(1, Long.valueOf(value.getPage_size()));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ListNotificationsRequest redact(ListNotificationsRequest value) {
                m.h(value, "value");
                return ListNotificationsRequest.copy$default(value, 0L, 0L, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public ListNotificationsRequest() {
        this(0L, 0L, null, 7, null);
    }

    public /* synthetic */ ListNotificationsRequest(long j2, long j3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) == 0 ? j3 : 0L, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ListNotificationsRequest copy$default(ListNotificationsRequest listNotificationsRequest, long j2, long j3, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = listNotificationsRequest.page_size;
        }
        long j4 = j2;
        if ((i2 & 2) != 0) {
            j3 = listNotificationsRequest.page_token;
        }
        long j5 = j3;
        if ((i2 & 4) != 0) {
            iVar = listNotificationsRequest.unknownFields();
        }
        return listNotificationsRequest.copy(j4, j5, iVar);
    }

    public final ListNotificationsRequest copy(long j2, long j3, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new ListNotificationsRequest(j2, j3, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListNotificationsRequest) {
            ListNotificationsRequest listNotificationsRequest = (ListNotificationsRequest) obj;
            return m.c(unknownFields(), listNotificationsRequest.unknownFields()) && this.page_size == listNotificationsRequest.page_size && this.page_token == listNotificationsRequest.page_token;
        }
        return false;
    }

    public final long getPage_size() {
        return this.page_size;
    }

    public final long getPage_token() {
        return this.page_token;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + b.a(this.page_size)) * 37) + b.a(this.page_token);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m235newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("page_size=" + this.page_size);
        arrayList.add("page_token=" + this.page_token);
        h0 = z.h0(arrayList, ", ", "ListNotificationsRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListNotificationsRequest(long j2, long j3, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.page_size = j2;
        this.page_token = j3;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m235newBuilder() {
        throw new AssertionError();
    }
}