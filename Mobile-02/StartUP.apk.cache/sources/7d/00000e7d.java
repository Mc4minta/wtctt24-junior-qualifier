package com.coinbase.android.apiv3.generated.authed.waitlist_service;

import android.os.Parcelable;
import com.google.protobuf.u;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: Status.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B3\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0013\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/waitlist_service/Status;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/google/protobuf/u;", "created_at", "admitted_at", "rank", "Lj/i;", "unknownFields", "copy", "(Lcom/google/protobuf/u;Lcom/google/protobuf/u;ILj/i;)Lcom/coinbase/android/apiv3/generated/authed/waitlist_service/Status;", "Lcom/google/protobuf/u;", "getCreated_at", "()Lcom/google/protobuf/u;", "I", "getRank", "getAdmitted_at", "<init>", "(Lcom/google/protobuf/u;Lcom/google/protobuf/u;ILj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Status extends a {
    public static final ProtoAdapter<Status> ADAPTER;
    public static final Parcelable.Creator<Status> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "admittedAt", tag = 2)
    private final u admitted_at;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "createdAt", tag = 1)
    private final u created_at;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    private final int rank;

    /* compiled from: Status.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/waitlist_service/Status$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/waitlist_service/Status;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(Status.class);
        ProtoAdapter<Status> protoAdapter = new ProtoAdapter<Status>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.waitlist_service.Status") { // from class: com.coinbase.android.apiv3.generated.authed.waitlist_service.Status$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Status decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                u uVar = null;
                int i2 = 0;
                u uVar2 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Status(uVar, uVar2, i2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        uVar = u.a.decode(reader);
                    } else if (g2 == 2) {
                        uVar2 = u.a.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        i2 = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Status value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getCreated_at() != null) {
                    u.a.encodeWithTag(writer, 1, value.getCreated_at());
                }
                if (value.getAdmitted_at() != null) {
                    u.a.encodeWithTag(writer, 2, value.getAdmitted_at());
                }
                if (value.getRank() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 3, Integer.valueOf(value.getRank()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Status value) {
                m.h(value, "value");
                if (value.getCreated_at() == null) {
                    return 0;
                }
                ProtoAdapter<u> protoAdapter2 = u.a;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getCreated_at());
                if (value.getAdmitted_at() != null) {
                    r1 = (value.getRank() != 0 ? ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(value.getRank())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(2, value.getAdmitted_at());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Status redact(Status value) {
                m.h(value, "value");
                u created_at = value.getCreated_at();
                u redact = created_at != null ? u.a.redact(created_at) : null;
                u admitted_at = value.getAdmitted_at();
                return Status.copy$default(value, redact, admitted_at != null ? u.a.redact(admitted_at) : null, 0, i.a, 4, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Status() {
        this(null, null, 0, null, 15, null);
    }

    public /* synthetic */ Status(u uVar, u uVar2, int i2, i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : uVar, (i3 & 2) != 0 ? null : uVar2, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Status copy$default(Status status, u uVar, u uVar2, int i2, i iVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            uVar = status.created_at;
        }
        if ((i3 & 2) != 0) {
            uVar2 = status.admitted_at;
        }
        if ((i3 & 4) != 0) {
            i2 = status.rank;
        }
        if ((i3 & 8) != 0) {
            iVar = status.unknownFields();
        }
        return status.copy(uVar, uVar2, i2, iVar);
    }

    public final Status copy(u uVar, u uVar2, int i2, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new Status(uVar, uVar2, i2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return m.c(unknownFields(), status.unknownFields()) && m.c(this.created_at, status.created_at) && m.c(this.admitted_at, status.admitted_at) && this.rank == status.rank;
        }
        return false;
    }

    public final u getAdmitted_at() {
        return this.admitted_at;
    }

    public final u getCreated_at() {
        return this.created_at;
    }

    public final int getRank() {
        return this.rank;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            u uVar = this.created_at;
            int hashCode2 = (hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37;
            u uVar2 = this.admitted_at;
            int hashCode3 = ((hashCode2 + (uVar2 != null ? uVar2.hashCode() : 0)) * 37) + this.rank;
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m500newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.created_at != null) {
            arrayList.add("created_at=" + this.created_at);
        }
        if (this.admitted_at != null) {
            arrayList.add("admitted_at=" + this.admitted_at);
        }
        arrayList.add("rank=" + this.rank);
        h0 = z.h0(arrayList, ", ", "Status{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Status(u uVar, u uVar2, int i2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.created_at = uVar;
        this.admitted_at = uVar2;
        this.rank = i2;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m500newBuilder() {
        throw new AssertionError();
    }
}