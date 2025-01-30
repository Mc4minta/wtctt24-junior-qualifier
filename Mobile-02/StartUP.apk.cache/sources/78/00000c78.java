package com.coinbase.android.apiv3.generated.authed.loans;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: DisbursementPaymentMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B[\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJa\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b)\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b*\u0010'¨\u0006."}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/DisbursementPaymentMethod;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "enabled", "id", "supplemental_info", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "payment_method", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "withdrawal_fee", "withdrawal_estimate", "instant_withdraw", "Lj/i;", "unknownFields", "copy", "(ZLjava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;ZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/DisbursementPaymentMethod;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getWithdrawal_fee", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getPayment_method", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "Ljava/lang/String;", "getSupplemental_info", "Z", "getEnabled", "()Z", "getId", "getWithdrawal_estimate", "getInstant_withdraw", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DisbursementPaymentMethod extends a {
    public static final ProtoAdapter<DisbursementPaymentMethod> ADAPTER;
    public static final Parcelable.Creator<DisbursementPaymentMethod> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    private final boolean enabled;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "instantWithdraw", tag = 7)
    private final boolean instant_withdraw;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentMethod#ADAPTER", jsonName = "paymentMethod", tag = 4)
    private final PaymentMethod payment_method;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "supplementalInfo", tag = 3)
    private final String supplemental_info;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "withdrawalEstimate", tag = 6)
    private final String withdrawal_estimate;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "withdrawalFee", tag = 5)
    private final Amount withdrawal_fee;

    /* compiled from: DisbursementPaymentMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/DisbursementPaymentMethod$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/DisbursementPaymentMethod;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<DisbursementPaymentMethod> protoAdapter = new ProtoAdapter<DisbursementPaymentMethod>(c.LENGTH_DELIMITED, e0.b(DisbursementPaymentMethod.class), "type.googleapis.com/coinbase.public_api.authed.loans.DisbursementPaymentMethod") { // from class: com.coinbase.android.apiv3.generated.authed.loans.DisbursementPaymentMethod$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DisbursementPaymentMethod decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                PaymentMethod paymentMethod = null;
                Amount amount = null;
                boolean z = false;
                boolean z2 = false;
                String str = "";
                String str2 = str;
                String str3 = str2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new DisbursementPaymentMethod(z, str, str2, paymentMethod, amount, str3, z2, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            break;
                        case 2:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            paymentMethod = PaymentMethod.ADAPTER.decode(reader);
                            break;
                        case 5:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 6:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            z2 = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, DisbursementPaymentMethod value) {
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
                if (value.getWithdrawal_fee() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getWithdrawal_fee());
                }
                if (!m.c(value.getWithdrawal_estimate(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getWithdrawal_estimate());
                }
                if (value.getInstant_withdraw()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 7, Boolean.valueOf(value.getInstant_withdraw()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(DisbursementPaymentMethod value) {
                m.h(value, "value");
                if (value.getEnabled()) {
                    ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
                    int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, Boolean.valueOf(value.getEnabled()));
                    if (!m.c(value.getId(), "")) {
                        ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                        int encodedSizeWithTag2 = protoAdapter3.encodedSizeWithTag(2, value.getId());
                        if (!m.c(value.getSupplemental_info(), "")) {
                            int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getSupplemental_info());
                            if (value.getPayment_method() != null) {
                                int encodedSizeWithTag4 = PaymentMethod.ADAPTER.encodedSizeWithTag(4, value.getPayment_method());
                                if (value.getWithdrawal_fee() != null) {
                                    int encodedSizeWithTag5 = Amount.ADAPTER.encodedSizeWithTag(5, value.getWithdrawal_fee());
                                    if (!m.c(value.getWithdrawal_estimate(), "")) {
                                        r1 = (value.getInstant_withdraw() ? protoAdapter2.encodedSizeWithTag(7, Boolean.valueOf(value.getInstant_withdraw())) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(6, value.getWithdrawal_estimate());
                                    }
                                    r1 += encodedSizeWithTag5;
                                }
                                r1 += encodedSizeWithTag4;
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
            public DisbursementPaymentMethod redact(DisbursementPaymentMethod value) {
                m.h(value, "value");
                PaymentMethod payment_method = value.getPayment_method();
                PaymentMethod redact = payment_method != null ? PaymentMethod.ADAPTER.redact(payment_method) : null;
                Amount withdrawal_fee = value.getWithdrawal_fee();
                return DisbursementPaymentMethod.copy$default(value, false, null, null, redact, withdrawal_fee != null ? Amount.ADAPTER.redact(withdrawal_fee) : null, null, false, i.a, 103, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public DisbursementPaymentMethod() {
        this(false, null, null, null, null, null, false, null, 255, null);
    }

    public /* synthetic */ DisbursementPaymentMethod(boolean z, String str, String str2, PaymentMethod paymentMethod, Amount amount, String str3, boolean z2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? null : paymentMethod, (i2 & 16) == 0 ? amount : null, (i2 & 32) == 0 ? str3 : "", (i2 & 64) == 0 ? z2 : false, (i2 & 128) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ DisbursementPaymentMethod copy$default(DisbursementPaymentMethod disbursementPaymentMethod, boolean z, String str, String str2, PaymentMethod paymentMethod, Amount amount, String str3, boolean z2, i iVar, int i2, Object obj) {
        return disbursementPaymentMethod.copy((i2 & 1) != 0 ? disbursementPaymentMethod.enabled : z, (i2 & 2) != 0 ? disbursementPaymentMethod.id : str, (i2 & 4) != 0 ? disbursementPaymentMethod.supplemental_info : str2, (i2 & 8) != 0 ? disbursementPaymentMethod.payment_method : paymentMethod, (i2 & 16) != 0 ? disbursementPaymentMethod.withdrawal_fee : amount, (i2 & 32) != 0 ? disbursementPaymentMethod.withdrawal_estimate : str3, (i2 & 64) != 0 ? disbursementPaymentMethod.instant_withdraw : z2, (i2 & 128) != 0 ? disbursementPaymentMethod.unknownFields() : iVar);
    }

    public final DisbursementPaymentMethod copy(boolean z, String id, String supplemental_info, PaymentMethod paymentMethod, Amount amount, String withdrawal_estimate, boolean z2, i unknownFields) {
        m.h(id, "id");
        m.h(supplemental_info, "supplemental_info");
        m.h(withdrawal_estimate, "withdrawal_estimate");
        m.h(unknownFields, "unknownFields");
        return new DisbursementPaymentMethod(z, id, supplemental_info, paymentMethod, amount, withdrawal_estimate, z2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DisbursementPaymentMethod) {
            DisbursementPaymentMethod disbursementPaymentMethod = (DisbursementPaymentMethod) obj;
            return m.c(unknownFields(), disbursementPaymentMethod.unknownFields()) && this.enabled == disbursementPaymentMethod.enabled && m.c(this.id, disbursementPaymentMethod.id) && m.c(this.supplemental_info, disbursementPaymentMethod.supplemental_info) && m.c(this.payment_method, disbursementPaymentMethod.payment_method) && m.c(this.withdrawal_fee, disbursementPaymentMethod.withdrawal_fee) && m.c(this.withdrawal_estimate, disbursementPaymentMethod.withdrawal_estimate) && this.instant_withdraw == disbursementPaymentMethod.instant_withdraw;
        }
        return false;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getInstant_withdraw() {
        return this.instant_withdraw;
    }

    public final PaymentMethod getPayment_method() {
        return this.payment_method;
    }

    public final String getSupplemental_info() {
        return this.supplemental_info;
    }

    public final String getWithdrawal_estimate() {
        return this.withdrawal_estimate;
    }

    public final Amount getWithdrawal_fee() {
        return this.withdrawal_fee;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.enabled)) * 37) + this.id.hashCode()) * 37) + this.supplemental_info.hashCode()) * 37;
            PaymentMethod paymentMethod = this.payment_method;
            int hashCode2 = (hashCode + (paymentMethod != null ? paymentMethod.hashCode() : 0)) * 37;
            Amount amount = this.withdrawal_fee;
            int hashCode3 = ((((hashCode2 + (amount != null ? amount.hashCode() : 0)) * 37) + this.withdrawal_estimate.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.instant_withdraw);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m353newBuilder();
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
        if (this.withdrawal_fee != null) {
            arrayList.add("withdrawal_fee=" + this.withdrawal_fee);
        }
        arrayList.add("withdrawal_estimate=" + b.c(this.withdrawal_estimate));
        arrayList.add("instant_withdraw=" + this.instant_withdraw);
        h0 = z.h0(arrayList, ", ", "DisbursementPaymentMethod{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisbursementPaymentMethod(boolean z, String id, String supplemental_info, PaymentMethod paymentMethod, Amount amount, String withdrawal_estimate, boolean z2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(supplemental_info, "supplemental_info");
        m.h(withdrawal_estimate, "withdrawal_estimate");
        m.h(unknownFields, "unknownFields");
        this.enabled = z;
        this.id = id;
        this.supplemental_info = supplemental_info;
        this.payment_method = paymentMethod;
        this.withdrawal_fee = amount;
        this.withdrawal_estimate = withdrawal_estimate;
        this.instant_withdraw = z2;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m353newBuilder() {
        throw new AssertionError();
    }
}