package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
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

/* compiled from: EarnQuizProgressBar.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0010\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0011\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0018\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizProgressBar;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "total_segments", "segments_filled", "Lj/i;", "unknownFields", "copy", "(IILj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizProgressBar;", "I", "getTotal_segments", "getSegments_filled", "<init>", "(IILj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class EarnQuizProgressBar extends a {
    public static final ProtoAdapter<EarnQuizProgressBar> ADAPTER;
    public static final Parcelable.Creator<EarnQuizProgressBar> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "segmentsFilled", tag = 2)
    private final int segments_filled;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "totalSegments", tag = 1)
    private final int total_segments;

    /* compiled from: EarnQuizProgressBar.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizProgressBar$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnQuizProgressBar;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<EarnQuizProgressBar> protoAdapter = new ProtoAdapter<EarnQuizProgressBar>(c.LENGTH_DELIMITED, e0.b(EarnQuizProgressBar.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.EarnQuizProgressBar") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.EarnQuizProgressBar$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EarnQuizProgressBar decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new EarnQuizProgressBar(i2, i3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        i2 = ProtoAdapter.INT32.decode(reader).intValue();
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        i3 = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, EarnQuizProgressBar value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getTotal_segments() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 1, Integer.valueOf(value.getTotal_segments()));
                }
                if (value.getSegments_filled() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(value.getSegments_filled()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(EarnQuizProgressBar value) {
                m.h(value, "value");
                if (value.getTotal_segments() == 0) {
                    return 0;
                }
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                return (value.getSegments_filled() != 0 ? protoAdapter2.encodedSizeWithTag(2, Integer.valueOf(value.getSegments_filled())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(1, Integer.valueOf(value.getTotal_segments()));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public EarnQuizProgressBar redact(EarnQuizProgressBar value) {
                m.h(value, "value");
                return EarnQuizProgressBar.copy$default(value, 0, 0, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public EarnQuizProgressBar() {
        this(0, 0, null, 7, null);
    }

    public /* synthetic */ EarnQuizProgressBar(int i2, int i3, i iVar, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3, (i4 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ EarnQuizProgressBar copy$default(EarnQuizProgressBar earnQuizProgressBar, int i2, int i3, i iVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = earnQuizProgressBar.total_segments;
        }
        if ((i4 & 2) != 0) {
            i3 = earnQuizProgressBar.segments_filled;
        }
        if ((i4 & 4) != 0) {
            iVar = earnQuizProgressBar.unknownFields();
        }
        return earnQuizProgressBar.copy(i2, i3, iVar);
    }

    public final EarnQuizProgressBar copy(int i2, int i3, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new EarnQuizProgressBar(i2, i3, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EarnQuizProgressBar) {
            EarnQuizProgressBar earnQuizProgressBar = (EarnQuizProgressBar) obj;
            return m.c(unknownFields(), earnQuizProgressBar.unknownFields()) && this.total_segments == earnQuizProgressBar.total_segments && this.segments_filled == earnQuizProgressBar.segments_filled;
        }
        return false;
    }

    public final int getSegments_filled() {
        return this.segments_filled;
    }

    public final int getTotal_segments() {
        return this.total_segments;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.total_segments) * 37) + this.segments_filled;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m394newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("total_segments=" + this.total_segments);
        arrayList.add("segments_filled=" + this.segments_filled);
        h0 = z.h0(arrayList, ", ", "EarnQuizProgressBar{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarnQuizProgressBar(int i2, int i3, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.total_segments = i2;
        this.segments_filled = i3;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m394newBuilder() {
        throw new AssertionError();
    }
}