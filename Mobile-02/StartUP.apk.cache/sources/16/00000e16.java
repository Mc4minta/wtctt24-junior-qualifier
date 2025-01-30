package com.coinbase.android.apiv3.generated.authed.sends;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: SendPaymentMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)BG\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001d\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/SendPaymentMethod;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "enabled", "id", "supplemental_info", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "payment_method", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "fiat_limit", "Lj/i;", "unknownFields", "copy", "(ZLjava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/sends/SendPaymentMethod;", "Ljava/lang/String;", "getSupplemental_info", "getId", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getPayment_method", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getFiat_limit", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Z", "getEnabled", "()Z", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class SendPaymentMethod extends a {
    public static final ProtoAdapter<SendPaymentMethod> ADAPTER;
    public static final Parcelable.Creator<SendPaymentMethod> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    private final boolean enabled;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "fiatLimit", tag = 5)
    private final Amount fiat_limit;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String id;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentMethod#ADAPTER", jsonName = "paymentMethod", tag = 4)
    private final PaymentMethod payment_method;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "supplementalInfo", tag = 3)
    private final String supplemental_info;

    /* compiled from: SendPaymentMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/SendPaymentMethod$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/sends/SendPaymentMethod;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(SendPaymentMethod.class);
        ProtoAdapter<SendPaymentMethod> protoAdapter = new ProtoAdapter<SendPaymentMethod>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.sends.SendPaymentMethod") { // from class: com.coinbase.android.apiv3.generated.authed.sends.SendPaymentMethod$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SendPaymentMethod decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                PaymentMethod paymentMethod = null;
                Amount amount = null;
                String str = "";
                String str2 = str;
                boolean z = false;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new SendPaymentMethod(z, str, str2, paymentMethod, amount, reader.e(d2));
                    }
                    if (g2 == 1) {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 4) {
                        paymentMethod = PaymentMethod.ADAPTER.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        amount = Amount.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, SendPaymentMethod value) {
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
                if (value.getFiat_limit() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getFiat_limit());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(SendPaymentMethod value) {
                m.h(value, "value");
                if (value.getEnabled()) {
                    int encodedSizeWithTag = ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(value.getEnabled()));
                    if (!m.c(value.getId(), "")) {
                        ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                        int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getId());
                        if (!m.c(value.getSupplemental_info(), "")) {
                            int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getSupplemental_info());
                            if (value.getPayment_method() != null) {
                                r1 = (value.getFiat_limit() != null ? Amount.ADAPTER.encodedSizeWithTag(5, value.getFiat_limit()) + value.unknownFields().Q() : 0) + PaymentMethod.ADAPTER.encodedSizeWithTag(4, value.getPayment_method());
                            }
                            r1 += encodedSizeWithTag3;
                        }
                        r1 += encodedSizeWithTag2;
                    }
                    return r1 + encodedSizeWithTag;
                }
                return 0;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public SendPaymentMethod redact(SendPaymentMethod value) {
                m.h(value, "value");
                PaymentMethod payment_method = value.getPayment_method();
                PaymentMethod redact = payment_method != null ? PaymentMethod.ADAPTER.redact(payment_method) : null;
                Amount fiat_limit = value.getFiat_limit();
                return SendPaymentMethod.copy$default(value, false, null, null, redact, fiat_limit != null ? Amount.ADAPTER.redact(fiat_limit) : null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public SendPaymentMethod() {
        this(false, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ SendPaymentMethod(boolean z, String str, String str2, PaymentMethod paymentMethod, Amount amount, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "" : str, (i2 & 4) == 0 ? str2 : "", (i2 & 8) != 0 ? null : paymentMethod, (i2 & 16) != 0 ? null : amount, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ SendPaymentMethod copy$default(SendPaymentMethod sendPaymentMethod, boolean z, String str, String str2, PaymentMethod paymentMethod, Amount amount, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = sendPaymentMethod.enabled;
        }
        if ((i2 & 2) != 0) {
            str = sendPaymentMethod.id;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = sendPaymentMethod.supplemental_info;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            paymentMethod = sendPaymentMethod.payment_method;
        }
        PaymentMethod paymentMethod2 = paymentMethod;
        if ((i2 & 16) != 0) {
            amount = sendPaymentMethod.fiat_limit;
        }
        Amount amount2 = amount;
        if ((i2 & 32) != 0) {
            iVar = sendPaymentMethod.unknownFields();
        }
        return sendPaymentMethod.copy(z, str3, str4, paymentMethod2, amount2, iVar);
    }

    public final SendPaymentMethod copy(boolean z, String id, String supplemental_info, PaymentMethod paymentMethod, Amount amount, i unknownFields) {
        m.h(id, "id");
        m.h(supplemental_info, "supplemental_info");
        m.h(unknownFields, "unknownFields");
        return new SendPaymentMethod(z, id, supplemental_info, paymentMethod, amount, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SendPaymentMethod) {
            SendPaymentMethod sendPaymentMethod = (SendPaymentMethod) obj;
            return m.c(unknownFields(), sendPaymentMethod.unknownFields()) && this.enabled == sendPaymentMethod.enabled && m.c(this.id, sendPaymentMethod.id) && m.c(this.supplemental_info, sendPaymentMethod.supplemental_info) && m.c(this.payment_method, sendPaymentMethod.payment_method) && m.c(this.fiat_limit, sendPaymentMethod.fiat_limit);
        }
        return false;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Amount getFiat_limit() {
        return this.fiat_limit;
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
            int hashCode2 = (hashCode + (paymentMethod != null ? paymentMethod.hashCode() : 0)) * 37;
            Amount amount = this.fiat_limit;
            int hashCode3 = hashCode2 + (amount != null ? amount.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m469newBuilder();
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
        if (this.fiat_limit != null) {
            arrayList.add("fiat_limit=" + this.fiat_limit);
        }
        h0 = z.h0(arrayList, ", ", "SendPaymentMethod{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendPaymentMethod(boolean z, String id, String supplemental_info, PaymentMethod paymentMethod, Amount amount, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(supplemental_info, "supplemental_info");
        m.h(unknownFields, "unknownFields");
        this.enabled = z;
        this.id = id;
        this.supplemental_info = supplemental_info;
        this.payment_method = paymentMethod;
        this.fiat_limit = amount;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m469newBuilder() {
        throw new AssertionError();
    }
}