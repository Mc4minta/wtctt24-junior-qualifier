package com.coinbase.android.apiv3.generated.authed.user_tracking_params_service;

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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: UpdateTrackingParamsRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB!\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UpdateTrackingParamsRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/TrackingParam;", "params", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UpdateTrackingParamsRequest;", "Ljava/util/List;", "getParams", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UpdateTrackingParamsRequest extends a {
    public static final ProtoAdapter<UpdateTrackingParamsRequest> ADAPTER;
    public static final Parcelable.Creator<UpdateTrackingParamsRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.user_tracking_params_service.TrackingParam#ADAPTER", label = p.a.REPEATED, tag = 1)
    private final List<TrackingParam> params;

    /* compiled from: UpdateTrackingParamsRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UpdateTrackingParamsRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/UpdateTrackingParamsRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<UpdateTrackingParamsRequest> protoAdapter = new ProtoAdapter<UpdateTrackingParamsRequest>(c.LENGTH_DELIMITED, e0.b(UpdateTrackingParamsRequest.class), "type.googleapis.com/coinbase.public_api.authed.user_tracking_params_service.UpdateTrackingParamsRequest") { // from class: com.coinbase.android.apiv3.generated.authed.user_tracking_params_service.UpdateTrackingParamsRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UpdateTrackingParamsRequest decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new UpdateTrackingParamsRequest(arrayList, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        arrayList.add(TrackingParam.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, UpdateTrackingParamsRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                TrackingParam.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getParams());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(UpdateTrackingParamsRequest value) {
                m.h(value, "value");
                return TrackingParam.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getParams()) + value.unknownFields().Q();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public UpdateTrackingParamsRequest redact(UpdateTrackingParamsRequest value) {
                m.h(value, "value");
                return value.copy(b.a(value.getParams(), TrackingParam.ADAPTER), i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public UpdateTrackingParamsRequest() {
        this(null, null, 3, null);
    }

    public /* synthetic */ UpdateTrackingParamsRequest(List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateTrackingParamsRequest copy$default(UpdateTrackingParamsRequest updateTrackingParamsRequest, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = updateTrackingParamsRequest.params;
        }
        if ((i2 & 2) != 0) {
            iVar = updateTrackingParamsRequest.unknownFields();
        }
        return updateTrackingParamsRequest.copy(list, iVar);
    }

    public final UpdateTrackingParamsRequest copy(List<TrackingParam> params, i unknownFields) {
        m.h(params, "params");
        m.h(unknownFields, "unknownFields");
        return new UpdateTrackingParamsRequest(params, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UpdateTrackingParamsRequest) {
            UpdateTrackingParamsRequest updateTrackingParamsRequest = (UpdateTrackingParamsRequest) obj;
            return m.c(unknownFields(), updateTrackingParamsRequest.unknownFields()) && m.c(this.params, updateTrackingParamsRequest.params);
        }
        return false;
    }

    public final List<TrackingParam> getParams() {
        return this.params;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.params.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m494newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.params.isEmpty()) {
            arrayList.add("params=" + this.params);
        }
        h0 = z.h0(arrayList, ", ", "UpdateTrackingParamsRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m494newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateTrackingParamsRequest(List<TrackingParam> params, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(params, "params");
        m.h(unknownFields, "unknownFields");
        this.params = params;
    }
}