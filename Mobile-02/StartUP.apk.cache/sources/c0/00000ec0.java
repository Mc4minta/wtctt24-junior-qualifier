package com.coinbase.android.apiv3.generated.common;

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

/* compiled from: TimestampedScaledAmount.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B3\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0014\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "Lcom/google/protobuf/u;", "timestamp", "scale", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;ILj/i;)Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "I", "getScale", "Lcom/google/protobuf/u;", "getTimestamp", "()Lcom/google/protobuf/u;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;ILj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class TimestampedScaledAmount extends a {
    public static final ProtoAdapter<TimestampedScaledAmount> ADAPTER;
    public static final Parcelable.Creator<TimestampedScaledAmount> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 1)
    private final Amount amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    private final int scale;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", tag = 2)
    private final u timestamp;

    /* compiled from: TimestampedScaledAmount.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(TimestampedScaledAmount.class);
        ProtoAdapter<TimestampedScaledAmount> protoAdapter = new ProtoAdapter<TimestampedScaledAmount>(cVar, b2, "type.googleapis.com/coinbase.public_api.common.TimestampedScaledAmount") { // from class: com.coinbase.android.apiv3.generated.common.TimestampedScaledAmount$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TimestampedScaledAmount decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Amount amount = null;
                int i2 = 0;
                u uVar = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new TimestampedScaledAmount(amount, uVar, i2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        uVar = u.a.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        i2 = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, TimestampedScaledAmount value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 1, value.getAmount());
                }
                if (value.getTimestamp() != null) {
                    u.a.encodeWithTag(writer, 2, value.getTimestamp());
                }
                if (value.getScale() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 3, Integer.valueOf(value.getScale()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(TimestampedScaledAmount value) {
                m.h(value, "value");
                if (value.getAmount() == null) {
                    return 0;
                }
                int encodedSizeWithTag = Amount.ADAPTER.encodedSizeWithTag(1, value.getAmount());
                if (value.getTimestamp() != null) {
                    r1 = (value.getScale() != 0 ? ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(value.getScale())) + value.unknownFields().Q() : 0) + u.a.encodedSizeWithTag(2, value.getTimestamp());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public TimestampedScaledAmount redact(TimestampedScaledAmount value) {
                m.h(value, "value");
                Amount amount = value.getAmount();
                Amount redact = amount != null ? Amount.ADAPTER.redact(amount) : null;
                u timestamp = value.getTimestamp();
                return TimestampedScaledAmount.copy$default(value, redact, timestamp != null ? u.a.redact(timestamp) : null, 0, i.a, 4, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public TimestampedScaledAmount() {
        this(null, null, 0, null, 15, null);
    }

    public /* synthetic */ TimestampedScaledAmount(Amount amount, u uVar, int i2, i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : amount, (i3 & 2) != 0 ? null : uVar, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ TimestampedScaledAmount copy$default(TimestampedScaledAmount timestampedScaledAmount, Amount amount, u uVar, int i2, i iVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            amount = timestampedScaledAmount.amount;
        }
        if ((i3 & 2) != 0) {
            uVar = timestampedScaledAmount.timestamp;
        }
        if ((i3 & 4) != 0) {
            i2 = timestampedScaledAmount.scale;
        }
        if ((i3 & 8) != 0) {
            iVar = timestampedScaledAmount.unknownFields();
        }
        return timestampedScaledAmount.copy(amount, uVar, i2, iVar);
    }

    public final TimestampedScaledAmount copy(Amount amount, u uVar, int i2, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new TimestampedScaledAmount(amount, uVar, i2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TimestampedScaledAmount) {
            TimestampedScaledAmount timestampedScaledAmount = (TimestampedScaledAmount) obj;
            return m.c(unknownFields(), timestampedScaledAmount.unknownFields()) && m.c(this.amount, timestampedScaledAmount.amount) && m.c(this.timestamp, timestampedScaledAmount.timestamp) && this.scale == timestampedScaledAmount.scale;
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final int getScale() {
        return this.scale;
    }

    public final u getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Amount amount = this.amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            u uVar = this.timestamp;
            int hashCode3 = ((hashCode2 + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.scale;
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m517newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        if (this.timestamp != null) {
            arrayList.add("timestamp=" + this.timestamp);
        }
        arrayList.add("scale=" + this.scale);
        h0 = z.h0(arrayList, ", ", "TimestampedScaledAmount{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimestampedScaledAmount(Amount amount, u uVar, int i2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.amount = amount;
        this.timestamp = uVar;
        this.scale = i2;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m517newBuilder() {
        throw new AssertionError();
    }
}