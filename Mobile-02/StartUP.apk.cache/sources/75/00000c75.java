package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.resources.PaymentMethod;
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

/* compiled from: DepositPaymentMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B;\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\u000f¨\u0006%"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/DepositPaymentMethod;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "enabled", "id", "supplemental_info", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "payment_method", "Lj/i;", "unknownFields", "copy", "(ZLjava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/DepositPaymentMethod;", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getPayment_method", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "Z", "getEnabled", "()Z", "Ljava/lang/String;", "getSupplemental_info", "getId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DepositPaymentMethod extends a {
    public static final ProtoAdapter<DepositPaymentMethod> ADAPTER;
    public static final Parcelable.Creator<DepositPaymentMethod> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    private final boolean enabled;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String id;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentMethod#ADAPTER", jsonName = "paymentMethod", tag = 4)
    private final PaymentMethod payment_method;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "supplementalInfo", tag = 3)
    private final String supplemental_info;

    /* compiled from: DepositPaymentMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/DepositPaymentMethod$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/DepositPaymentMethod;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<DepositPaymentMethod> protoAdapter = new ProtoAdapter<DepositPaymentMethod>(c.LENGTH_DELIMITED, e0.b(DepositPaymentMethod.class), "type.googleapis.com/coinbase.public_api.authed.loans.DepositPaymentMethod") { // from class: com.coinbase.android.apiv3.generated.authed.loans.DepositPaymentMethod$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DepositPaymentMethod decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                boolean z = false;
                PaymentMethod paymentMethod = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new DepositPaymentMethod(z, str, str2, paymentMethod, reader.e(d2));
                    }
                    if (g2 == 1) {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        paymentMethod = PaymentMethod.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, DepositPaymentMethod value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getEnabled()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 1, Boolean.valueOf(value.getEnabled()));
                }
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getId());
                }
                if (!m.c(value.getSupplemental_info(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getSupplemental_info());
                }
                if (value.getPayment_method() != null) {
                    PaymentMethod.ADAPTER.encodeWithTag(writer, 4, value.getPayment_method());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(DepositPaymentMethod value) {
                m.h(value, "value");
                if (value.getEnabled()) {
                    int encodedSizeWithTag = ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(value.getEnabled()));
                    if (!m.c(value.getId(), "")) {
                        ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                        int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getId());
                        if (!m.c(value.getSupplemental_info(), "")) {
                            r1 = (value.getPayment_method() != null ? PaymentMethod.ADAPTER.encodedSizeWithTag(4, value.getPayment_method()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(3, value.getSupplemental_info());
                        }
                        r1 += encodedSizeWithTag2;
                    }
                    return r1 + encodedSizeWithTag;
                }
                return 0;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public DepositPaymentMethod redact(DepositPaymentMethod value) {
                m.h(value, "value");
                PaymentMethod payment_method = value.getPayment_method();
                return DepositPaymentMethod.copy$default(value, false, null, null, payment_method != null ? PaymentMethod.ADAPTER.redact(payment_method) : null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public DepositPaymentMethod() {
        this(false, null, null, null, null, 31, null);
    }

    public /* synthetic */ DepositPaymentMethod(boolean z, String str, String str2, PaymentMethod paymentMethod, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "" : str, (i2 & 4) == 0 ? str2 : "", (i2 & 8) != 0 ? null : paymentMethod, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ DepositPaymentMethod copy$default(DepositPaymentMethod depositPaymentMethod, boolean z, String str, String str2, PaymentMethod paymentMethod, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = depositPaymentMethod.enabled;
        }
        if ((i2 & 2) != 0) {
            str = depositPaymentMethod.id;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = depositPaymentMethod.supplemental_info;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            paymentMethod = depositPaymentMethod.payment_method;
        }
        PaymentMethod paymentMethod2 = paymentMethod;
        if ((i2 & 16) != 0) {
            iVar = depositPaymentMethod.unknownFields();
        }
        return depositPaymentMethod.copy(z, str3, str4, paymentMethod2, iVar);
    }

    public final DepositPaymentMethod copy(boolean z, String id, String supplemental_info, PaymentMethod paymentMethod, i unknownFields) {
        m.h(id, "id");
        m.h(supplemental_info, "supplemental_info");
        m.h(unknownFields, "unknownFields");
        return new DepositPaymentMethod(z, id, supplemental_info, paymentMethod, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DepositPaymentMethod) {
            DepositPaymentMethod depositPaymentMethod = (DepositPaymentMethod) obj;
            return m.c(unknownFields(), depositPaymentMethod.unknownFields()) && this.enabled == depositPaymentMethod.enabled && m.c(this.id, depositPaymentMethod.id) && m.c(this.supplemental_info, depositPaymentMethod.supplemental_info) && m.c(this.payment_method, depositPaymentMethod.payment_method);
        }
        return false;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getId() {
        return this.id;
    }

    public final PaymentMethod getPayment_method() {
        return this.payment_method;
    }

    public final String getSupplemental_info() {
        return this.supplemental_info;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.enabled)) * 37) + this.id.hashCode()) * 37) + this.supplemental_info.hashCode()) * 37;
            PaymentMethod paymentMethod = this.payment_method;
            int hashCode2 = hashCode + (paymentMethod != null ? paymentMethod.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m352newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("enabled=" + this.enabled);
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("supplemental_info=" + b.c(this.supplemental_info));
        if (this.payment_method != null) {
            arrayList.add("payment_method=" + this.payment_method);
        }
        h0 = z.h0(arrayList, ", ", "DepositPaymentMethod{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DepositPaymentMethod(boolean z, String id, String supplemental_info, PaymentMethod paymentMethod, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(supplemental_info, "supplemental_info");
        m.h(unknownFields, "unknownFields");
        this.enabled = z;
        this.id = id;
        this.supplemental_info = supplemental_info;
        this.payment_method = paymentMethod;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m352newBuilder() {
        throw new AssertionError();
    }
}