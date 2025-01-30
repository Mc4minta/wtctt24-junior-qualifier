package com.coinbase.android.apiv3.generated.authed.user_tracking_params_service;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.TrackingParamKey;
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

/* compiled from: TrackingParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/TrackingParam;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/TrackingParamKey;", "key", "value", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/TrackingParamKey;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/TrackingParam;", "Ljava/lang/String;", "getValue", "Lcom/coinbase/android/apiv3/generated/common/TrackingParamKey;", "getKey", "()Lcom/coinbase/android/apiv3/generated/common/TrackingParamKey;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/TrackingParamKey;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class TrackingParam extends a {
    public static final ProtoAdapter<TrackingParam> ADAPTER;
    public static final Parcelable.Creator<TrackingParam> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.TrackingParamKey#ADAPTER", tag = 1)
    private final TrackingParamKey key;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String value;

    /* compiled from: TrackingParam.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/TrackingParam$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/user_tracking_params_service/TrackingParam;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<TrackingParam> protoAdapter = new ProtoAdapter<TrackingParam>(c.LENGTH_DELIMITED, e0.b(TrackingParam.class), "type.googleapis.com/coinbase.public_api.authed.user_tracking_params_service.TrackingParam") { // from class: com.coinbase.android.apiv3.generated.authed.user_tracking_params_service.TrackingParam$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TrackingParam decode(k reader) {
                m.h(reader, "reader");
                TrackingParamKey trackingParamKey = TrackingParamKey.UNKNOWN;
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new TrackingParam(trackingParamKey, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            trackingParamKey = TrackingParamKey.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, TrackingParam value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getKey() != TrackingParamKey.UNKNOWN) {
                    TrackingParamKey.ADAPTER.encodeWithTag(writer, 1, value.getKey());
                }
                if (!m.c(value.getValue(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getValue());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(TrackingParam value) {
                m.h(value, "value");
                if (value.getKey() == TrackingParamKey.UNKNOWN) {
                    return 0;
                }
                return (m.c(value.getValue(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(2, value.getValue()) + value.unknownFields().Q()) + TrackingParamKey.ADAPTER.encodedSizeWithTag(1, value.getKey());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public TrackingParam redact(TrackingParam value) {
                m.h(value, "value");
                return TrackingParam.copy$default(value, null, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public TrackingParam() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ TrackingParam(TrackingParamKey trackingParamKey, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? TrackingParamKey.UNKNOWN : trackingParamKey, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ TrackingParam copy$default(TrackingParam trackingParam, TrackingParamKey trackingParamKey, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            trackingParamKey = trackingParam.key;
        }
        if ((i2 & 2) != 0) {
            str = trackingParam.value;
        }
        if ((i2 & 4) != 0) {
            iVar = trackingParam.unknownFields();
        }
        return trackingParam.copy(trackingParamKey, str, iVar);
    }

    public final TrackingParam copy(TrackingParamKey key, String value, i unknownFields) {
        m.h(key, "key");
        m.h(value, "value");
        m.h(unknownFields, "unknownFields");
        return new TrackingParam(key, value, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TrackingParam) {
            TrackingParam trackingParam = (TrackingParam) obj;
            return m.c(unknownFields(), trackingParam.unknownFields()) && this.key == trackingParam.key && m.c(this.value, trackingParam.value);
        }
        return false;
    }

    public final TrackingParamKey getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.key.hashCode()) * 37) + this.value.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m492newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("key=" + this.key);
        arrayList.add("value=" + b.c(this.value));
        h0 = z.h0(arrayList, ", ", "TrackingParam{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m492newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrackingParam(TrackingParamKey key, String value, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(key, "key");
        m.h(value, "value");
        m.h(unknownFields, "unknownFields");
        this.key = key;
        this.value = value;
    }
}