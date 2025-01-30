package com.coinbase.android.apiv3.generated.common;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.authed.b;
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

/* compiled from: PricePoint.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PricePoint;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", ApiConstants.TIME, ApiConstants.PRICE, "Lj/i;", "unknownFields", "copy", "(JLjava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/PricePoint;", "J", "getTime", "()J", "Ljava/lang/String;", "getPrice", "<init>", "(JLjava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PricePoint extends a {
    public static final ProtoAdapter<PricePoint> ADAPTER;
    public static final Parcelable.Creator<PricePoint> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String price;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    private final long time;

    /* compiled from: PricePoint.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/PricePoint$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/PricePoint;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<PricePoint> protoAdapter = new ProtoAdapter<PricePoint>(c.LENGTH_DELIMITED, e0.b(PricePoint.class), "type.googleapis.com/coinbase.public_api.common.PricePoint") { // from class: com.coinbase.android.apiv3.generated.common.PricePoint$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PricePoint decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                long j2 = 0;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PricePoint(j2, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        j2 = ProtoAdapter.INT64.decode(reader).longValue();
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PricePoint value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getTime() != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, Long.valueOf(value.getTime()));
                }
                if (!m.c(value.getPrice(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getPrice());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PricePoint value) {
                m.h(value, "value");
                if (value.getTime() == 0) {
                    return 0;
                }
                return (m.c(value.getPrice(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(2, value.getPrice()) + value.unknownFields().Q()) + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(value.getTime()));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PricePoint redact(PricePoint value) {
                m.h(value, "value");
                return PricePoint.copy$default(value, 0L, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PricePoint() {
        this(0L, null, null, 7, null);
    }

    public /* synthetic */ PricePoint(long j2, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PricePoint copy$default(PricePoint pricePoint, long j2, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = pricePoint.time;
        }
        if ((i2 & 2) != 0) {
            str = pricePoint.price;
        }
        if ((i2 & 4) != 0) {
            iVar = pricePoint.unknownFields();
        }
        return pricePoint.copy(j2, str, iVar);
    }

    public final PricePoint copy(long j2, String price, i unknownFields) {
        m.h(price, "price");
        m.h(unknownFields, "unknownFields");
        return new PricePoint(j2, price, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PricePoint) {
            PricePoint pricePoint = (PricePoint) obj;
            return m.c(unknownFields(), pricePoint.unknownFields()) && this.time == pricePoint.time && m.c(this.price, pricePoint.price);
        }
        return false;
    }

    public final String getPrice() {
        return this.price;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + b.a(this.time)) * 37) + this.price.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m515newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("time=" + this.time);
        arrayList.add("price=" + com.squareup.wire.q.b.c(this.price));
        h0 = z.h0(arrayList, ", ", "PricePoint{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PricePoint(long j2, String price, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(price, "price");
        m.h(unknownFields, "unknownFields");
        this.time = j2;
        this.price = price;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m515newBuilder() {
        throw new AssertionError();
    }
}