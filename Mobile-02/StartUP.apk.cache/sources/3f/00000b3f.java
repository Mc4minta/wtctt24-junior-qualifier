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

/* compiled from: UnhighlightNotificationResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/UnhighlightNotificationResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "badge_count", "Lj/i;", "unknownFields", "copy", "(JLj/i;)Lcom/coinbase/android/apiv3/generated/authed/UnhighlightNotificationResponse;", "J", "getBadge_count", "()J", "<init>", "(JLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UnhighlightNotificationResponse extends com.squareup.wire.a {
    public static final ProtoAdapter<UnhighlightNotificationResponse> ADAPTER;
    public static final Parcelable.Creator<UnhighlightNotificationResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "badgeCount", tag = 1)
    private final long badge_count;

    /* compiled from: UnhighlightNotificationResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/UnhighlightNotificationResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/UnhighlightNotificationResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<UnhighlightNotificationResponse> protoAdapter = new ProtoAdapter<UnhighlightNotificationResponse>(c.LENGTH_DELIMITED, e0.b(UnhighlightNotificationResponse.class), "type.googleapis.com/coinbase.public_api.authed.UnhighlightNotificationResponse") { // from class: com.coinbase.android.apiv3.generated.authed.UnhighlightNotificationResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UnhighlightNotificationResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                long j2 = 0;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new UnhighlightNotificationResponse(j2, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        j2 = ProtoAdapter.INT64.decode(reader).longValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, UnhighlightNotificationResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getBadge_count() != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, Long.valueOf(value.getBadge_count()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(UnhighlightNotificationResponse value) {
                m.h(value, "value");
                if (value.getBadge_count() == 0) {
                    return 0;
                }
                return value.unknownFields().Q() + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(value.getBadge_count()));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public UnhighlightNotificationResponse redact(UnhighlightNotificationResponse value) {
                m.h(value, "value");
                return UnhighlightNotificationResponse.copy$default(value, 0L, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public UnhighlightNotificationResponse() {
        this(0L, null, 3, null);
    }

    public /* synthetic */ UnhighlightNotificationResponse(long j2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ UnhighlightNotificationResponse copy$default(UnhighlightNotificationResponse unhighlightNotificationResponse, long j2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = unhighlightNotificationResponse.badge_count;
        }
        if ((i2 & 2) != 0) {
            iVar = unhighlightNotificationResponse.unknownFields();
        }
        return unhighlightNotificationResponse.copy(j2, iVar);
    }

    public final UnhighlightNotificationResponse copy(long j2, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new UnhighlightNotificationResponse(j2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UnhighlightNotificationResponse) {
            UnhighlightNotificationResponse unhighlightNotificationResponse = (UnhighlightNotificationResponse) obj;
            return m.c(unknownFields(), unhighlightNotificationResponse.unknownFields()) && this.badge_count == unhighlightNotificationResponse.badge_count;
        }
        return false;
    }

    public final long getBadge_count() {
        return this.badge_count;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + b.a(this.badge_count);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m257newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("badge_count=" + this.badge_count);
        h0 = z.h0(arrayList, ", ", "UnhighlightNotificationResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnhighlightNotificationResponse(long j2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.badge_count = j2;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m257newBuilder() {
        throw new AssertionError();
    }
}