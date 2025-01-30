package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.resources.Loan;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetLoanResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B)\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/resources/Loan;", "loan", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "payment_method", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/resources/Loan;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanResponse;", "Lcom/coinbase/android/apiv3/generated/resources/Loan;", "getLoan", "()Lcom/coinbase/android/apiv3/generated/resources/Loan;", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getPayment_method", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "<init>", "(Lcom/coinbase/android/apiv3/generated/resources/Loan;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetLoanResponse extends a {
    public static final ProtoAdapter<GetLoanResponse> ADAPTER;
    public static final Parcelable.Creator<GetLoanResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Loan#ADAPTER", tag = 1)
    private final Loan loan;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentMethod#ADAPTER", jsonName = "paymentMethod", tag = 2)
    private final PaymentMethod payment_method;

    /* compiled from: GetLoanResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetLoanResponse> protoAdapter = new ProtoAdapter<GetLoanResponse>(c.LENGTH_DELIMITED, e0.b(GetLoanResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.GetLoanResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.GetLoanResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetLoanResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Loan loan = null;
                PaymentMethod paymentMethod = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetLoanResponse(loan, paymentMethod, reader.e(d2));
                    }
                    if (g2 == 1) {
                        loan = Loan.ADAPTER.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        paymentMethod = PaymentMethod.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetLoanResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getLoan() != null) {
                    Loan.ADAPTER.encodeWithTag(writer, 1, value.getLoan());
                }
                if (value.getPayment_method() != null) {
                    PaymentMethod.ADAPTER.encodeWithTag(writer, 2, value.getPayment_method());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetLoanResponse value) {
                m.h(value, "value");
                if (value.getLoan() == null) {
                    return 0;
                }
                return (value.getPayment_method() != null ? PaymentMethod.ADAPTER.encodedSizeWithTag(2, value.getPayment_method()) + value.unknownFields().Q() : 0) + Loan.ADAPTER.encodedSizeWithTag(1, value.getLoan());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetLoanResponse redact(GetLoanResponse value) {
                m.h(value, "value");
                Loan loan = value.getLoan();
                Loan redact = loan != null ? Loan.ADAPTER.redact(loan) : null;
                PaymentMethod payment_method = value.getPayment_method();
                return value.copy(redact, payment_method != null ? PaymentMethod.ADAPTER.redact(payment_method) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetLoanResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetLoanResponse(Loan loan, PaymentMethod paymentMethod, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : loan, (i2 & 2) != 0 ? null : paymentMethod, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetLoanResponse copy$default(GetLoanResponse getLoanResponse, Loan loan, PaymentMethod paymentMethod, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            loan = getLoanResponse.loan;
        }
        if ((i2 & 2) != 0) {
            paymentMethod = getLoanResponse.payment_method;
        }
        if ((i2 & 4) != 0) {
            iVar = getLoanResponse.unknownFields();
        }
        return getLoanResponse.copy(loan, paymentMethod, iVar);
    }

    public final GetLoanResponse copy(Loan loan, PaymentMethod paymentMethod, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new GetLoanResponse(loan, paymentMethod, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetLoanResponse) {
            GetLoanResponse getLoanResponse = (GetLoanResponse) obj;
            return m.c(unknownFields(), getLoanResponse.unknownFields()) && m.c(this.loan, getLoanResponse.loan) && m.c(this.payment_method, getLoanResponse.payment_method);
        }
        return false;
    }

    public final Loan getLoan() {
        return this.loan;
    }

    public final PaymentMethod getPayment_method() {
        return this.payment_method;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Loan loan = this.loan;
            int hashCode2 = (hashCode + (loan != null ? loan.hashCode() : 0)) * 37;
            PaymentMethod paymentMethod = this.payment_method;
            int hashCode3 = hashCode2 + (paymentMethod != null ? paymentMethod.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m365newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.loan != null) {
            arrayList.add("loan=" + this.loan);
        }
        if (this.payment_method != null) {
            arrayList.add("payment_method=" + this.payment_method);
        }
        h0 = z.h0(arrayList, ", ", "GetLoanResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLoanResponse(Loan loan, PaymentMethod paymentMethod, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.loan = loan;
        this.payment_method = paymentMethod;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m365newBuilder() {
        throw new AssertionError();
    }
}