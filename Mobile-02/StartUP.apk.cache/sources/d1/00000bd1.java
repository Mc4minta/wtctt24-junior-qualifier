package com.coinbase.android.apiv3.generated.authed.card;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetApplicationStatusResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B'\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationStatusResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/google/protobuf/u;", "status_at", "Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationStatus;", "status", "Lj/i;", "unknownFields", "copy", "(Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationStatus;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationStatusResponse;", "Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationStatus;", "getStatus", "()Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationStatus;", "Lcom/google/protobuf/u;", "getStatus_at", "()Lcom/google/protobuf/u;", "<init>", "(Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationStatus;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetApplicationStatusResponse extends a {
    public static final ProtoAdapter<GetApplicationStatusResponse> ADAPTER;
    public static final Parcelable.Creator<GetApplicationStatusResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.card.ApplicationStatus#ADAPTER", tag = 2)
    private final ApplicationStatus status;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "statusAt", tag = 1)
    private final u status_at;

    /* compiled from: GetApplicationStatusResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationStatusResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationStatusResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetApplicationStatusResponse> protoAdapter = new ProtoAdapter<GetApplicationStatusResponse>(c.LENGTH_DELIMITED, e0.b(GetApplicationStatusResponse.class), "type.googleapis.com/coinbase.public_api.authed.card.GetApplicationStatusResponse") { // from class: com.coinbase.android.apiv3.generated.authed.card.GetApplicationStatusResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetApplicationStatusResponse decode(k reader) {
                m.h(reader, "reader");
                ApplicationStatus applicationStatus = ApplicationStatus.APPLICATION_ELIGIBLE;
                long d2 = reader.d();
                u uVar = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetApplicationStatusResponse(uVar, applicationStatus, reader.e(d2));
                    }
                    if (g2 == 1) {
                        uVar = u.a.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        try {
                            applicationStatus = ApplicationStatus.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetApplicationStatusResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getStatus_at() != null) {
                    u.a.encodeWithTag(writer, 1, value.getStatus_at());
                }
                if (value.getStatus() != ApplicationStatus.APPLICATION_ELIGIBLE) {
                    ApplicationStatus.ADAPTER.encodeWithTag(writer, 2, value.getStatus());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetApplicationStatusResponse value) {
                m.h(value, "value");
                if (value.getStatus_at() == null) {
                    return 0;
                }
                return (value.getStatus() != ApplicationStatus.APPLICATION_ELIGIBLE ? ApplicationStatus.ADAPTER.encodedSizeWithTag(2, value.getStatus()) + value.unknownFields().Q() : 0) + u.a.encodedSizeWithTag(1, value.getStatus_at());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetApplicationStatusResponse redact(GetApplicationStatusResponse value) {
                m.h(value, "value");
                u status_at = value.getStatus_at();
                return GetApplicationStatusResponse.copy$default(value, status_at != null ? u.a.redact(status_at) : null, null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetApplicationStatusResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetApplicationStatusResponse(u uVar, ApplicationStatus applicationStatus, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : uVar, (i2 & 2) != 0 ? ApplicationStatus.APPLICATION_ELIGIBLE : applicationStatus, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetApplicationStatusResponse copy$default(GetApplicationStatusResponse getApplicationStatusResponse, u uVar, ApplicationStatus applicationStatus, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uVar = getApplicationStatusResponse.status_at;
        }
        if ((i2 & 2) != 0) {
            applicationStatus = getApplicationStatusResponse.status;
        }
        if ((i2 & 4) != 0) {
            iVar = getApplicationStatusResponse.unknownFields();
        }
        return getApplicationStatusResponse.copy(uVar, applicationStatus, iVar);
    }

    public final GetApplicationStatusResponse copy(u uVar, ApplicationStatus status, i unknownFields) {
        m.h(status, "status");
        m.h(unknownFields, "unknownFields");
        return new GetApplicationStatusResponse(uVar, status, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetApplicationStatusResponse) {
            GetApplicationStatusResponse getApplicationStatusResponse = (GetApplicationStatusResponse) obj;
            return m.c(unknownFields(), getApplicationStatusResponse.unknownFields()) && m.c(this.status_at, getApplicationStatusResponse.status_at) && this.status == getApplicationStatusResponse.status;
        }
        return false;
    }

    public final ApplicationStatus getStatus() {
        return this.status;
    }

    public final u getStatus_at() {
        return this.status_at;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            u uVar = this.status_at;
            int hashCode2 = ((hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.status.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m301newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.status_at != null) {
            arrayList.add("status_at=" + this.status_at);
        }
        arrayList.add("status=" + this.status);
        h0 = z.h0(arrayList, ", ", "GetApplicationStatusResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m301newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetApplicationStatusResponse(u uVar, ApplicationStatus status, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(status, "status");
        m.h(unknownFields, "unknownFields");
        this.status_at = uVar;
        this.status = status;
    }
}