package com.coinbase.android.apiv3.generated.authed.payment_methods;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PaymentMethodLimit;
import com.coinbase.android.apiv3.generated.common.Ref;
import com.coinbase.android.apiv3.generated.resources.PaymentMethod;
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

/* compiled from: PaymentMethodBuyLimit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B5\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/payment_methods/PaymentMethodBuyLimit;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "id", "Lcom/coinbase/android/apiv3/generated/common/PaymentMethodLimit;", "payment_method_limit", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "payment_method", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/PaymentMethodLimit;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/payment_methods/PaymentMethodBuyLimit;", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getPayment_method", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getId", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "Lcom/coinbase/android/apiv3/generated/common/PaymentMethodLimit;", "getPayment_method_limit", "()Lcom/coinbase/android/apiv3/generated/common/PaymentMethodLimit;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Ref;Lcom/coinbase/android/apiv3/generated/common/PaymentMethodLimit;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PaymentMethodBuyLimit extends a {
    public static final ProtoAdapter<PaymentMethodBuyLimit> ADAPTER;
    public static final Parcelable.Creator<PaymentMethodBuyLimit> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", tag = 1)
    private final Ref id;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentMethod#ADAPTER", jsonName = "paymentMethod", tag = 3)
    private final PaymentMethod payment_method;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PaymentMethodLimit#ADAPTER", jsonName = "paymentMethodLimit", tag = 2)
    private final PaymentMethodLimit payment_method_limit;

    /* compiled from: PaymentMethodBuyLimit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/payment_methods/PaymentMethodBuyLimit$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/payment_methods/PaymentMethodBuyLimit;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(PaymentMethodBuyLimit.class);
        ProtoAdapter<PaymentMethodBuyLimit> protoAdapter = new ProtoAdapter<PaymentMethodBuyLimit>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.payment_methods.PaymentMethodBuyLimit") { // from class: com.coinbase.android.apiv3.generated.authed.payment_methods.PaymentMethodBuyLimit$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PaymentMethodBuyLimit decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Ref ref = null;
                PaymentMethodLimit paymentMethodLimit = null;
                PaymentMethod paymentMethod = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PaymentMethodBuyLimit(ref, paymentMethodLimit, paymentMethod, reader.e(d2));
                    }
                    if (g2 == 1) {
                        ref = Ref.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        paymentMethodLimit = PaymentMethodLimit.ADAPTER.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        paymentMethod = PaymentMethod.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PaymentMethodBuyLimit value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getId() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 1, value.getId());
                }
                if (value.getPayment_method_limit() != null) {
                    PaymentMethodLimit.ADAPTER.encodeWithTag(writer, 2, value.getPayment_method_limit());
                }
                if (value.getPayment_method() != null) {
                    PaymentMethod.ADAPTER.encodeWithTag(writer, 3, value.getPayment_method());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PaymentMethodBuyLimit value) {
                m.h(value, "value");
                if (value.getId() == null) {
                    return 0;
                }
                int encodedSizeWithTag = Ref.ADAPTER.encodedSizeWithTag(1, value.getId());
                if (value.getPayment_method_limit() != null) {
                    r1 = (value.getPayment_method() != null ? PaymentMethod.ADAPTER.encodedSizeWithTag(3, value.getPayment_method()) + value.unknownFields().Q() : 0) + PaymentMethodLimit.ADAPTER.encodedSizeWithTag(2, value.getPayment_method_limit());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PaymentMethodBuyLimit redact(PaymentMethodBuyLimit value) {
                m.h(value, "value");
                Ref id = value.getId();
                Ref redact = id != null ? Ref.ADAPTER.redact(id) : null;
                PaymentMethodLimit payment_method_limit = value.getPayment_method_limit();
                PaymentMethodLimit redact2 = payment_method_limit != null ? PaymentMethodLimit.ADAPTER.redact(payment_method_limit) : null;
                PaymentMethod payment_method = value.getPayment_method();
                return value.copy(redact, redact2, payment_method != null ? PaymentMethod.ADAPTER.redact(payment_method) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PaymentMethodBuyLimit() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ PaymentMethodBuyLimit(Ref ref, PaymentMethodLimit paymentMethodLimit, PaymentMethod paymentMethod, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : ref, (i2 & 2) != 0 ? null : paymentMethodLimit, (i2 & 4) != 0 ? null : paymentMethod, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PaymentMethodBuyLimit copy$default(PaymentMethodBuyLimit paymentMethodBuyLimit, Ref ref, PaymentMethodLimit paymentMethodLimit, PaymentMethod paymentMethod, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ref = paymentMethodBuyLimit.id;
        }
        if ((i2 & 2) != 0) {
            paymentMethodLimit = paymentMethodBuyLimit.payment_method_limit;
        }
        if ((i2 & 4) != 0) {
            paymentMethod = paymentMethodBuyLimit.payment_method;
        }
        if ((i2 & 8) != 0) {
            iVar = paymentMethodBuyLimit.unknownFields();
        }
        return paymentMethodBuyLimit.copy(ref, paymentMethodLimit, paymentMethod, iVar);
    }

    public final PaymentMethodBuyLimit copy(Ref ref, PaymentMethodLimit paymentMethodLimit, PaymentMethod paymentMethod, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new PaymentMethodBuyLimit(ref, paymentMethodLimit, paymentMethod, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PaymentMethodBuyLimit) {
            PaymentMethodBuyLimit paymentMethodBuyLimit = (PaymentMethodBuyLimit) obj;
            return m.c(unknownFields(), paymentMethodBuyLimit.unknownFields()) && m.c(this.id, paymentMethodBuyLimit.id) && m.c(this.payment_method_limit, paymentMethodBuyLimit.payment_method_limit) && m.c(this.payment_method, paymentMethodBuyLimit.payment_method);
        }
        return false;
    }

    public final Ref getId() {
        return this.id;
    }

    public final PaymentMethod getPayment_method() {
        return this.payment_method;
    }

    public final PaymentMethodLimit getPayment_method_limit() {
        return this.payment_method_limit;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Ref ref = this.id;
            int hashCode2 = (hashCode + (ref != null ? ref.hashCode() : 0)) * 37;
            PaymentMethodLimit paymentMethodLimit = this.payment_method_limit;
            int hashCode3 = (hashCode2 + (paymentMethodLimit != null ? paymentMethodLimit.hashCode() : 0)) * 37;
            PaymentMethod paymentMethod = this.payment_method;
            int hashCode4 = hashCode3 + (paymentMethod != null ? paymentMethod.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m439newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.id != null) {
            arrayList.add("id=" + this.id);
        }
        if (this.payment_method_limit != null) {
            arrayList.add("payment_method_limit=" + this.payment_method_limit);
        }
        if (this.payment_method != null) {
            arrayList.add("payment_method=" + this.payment_method);
        }
        h0 = z.h0(arrayList, ", ", "PaymentMethodBuyLimit{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentMethodBuyLimit(Ref ref, PaymentMethodLimit paymentMethodLimit, PaymentMethod paymentMethod, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.id = ref;
        this.payment_method_limit = paymentMethodLimit;
        this.payment_method = paymentMethod;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m439newBuilder() {
        throw new AssertionError();
    }
}