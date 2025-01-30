package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
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

/* compiled from: CommitPaymentRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB'\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CommitPaymentRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "amount", "payment_method_id", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/CommitPaymentRequest;", "Ljava/lang/String;", "getPayment_method_id", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAmount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "<init>", "(Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CommitPaymentRequest extends a {
    public static final ProtoAdapter<CommitPaymentRequest> ADAPTER;
    public static final Parcelable.Creator<CommitPaymentRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", tag = 1)
    private final Amount amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "paymentMethodId", tag = 2)
    private final String payment_method_id;

    /* compiled from: CommitPaymentRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CommitPaymentRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitPaymentRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<CommitPaymentRequest> protoAdapter = new ProtoAdapter<CommitPaymentRequest>(c.LENGTH_DELIMITED, e0.b(CommitPaymentRequest.class), "type.googleapis.com/coinbase.public_api.authed.loans.CommitPaymentRequest") { // from class: com.coinbase.android.apiv3.generated.authed.loans.CommitPaymentRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CommitPaymentRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Amount amount = null;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new CommitPaymentRequest(amount, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        amount = Amount.ADAPTER.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CommitPaymentRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAmount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 1, value.getAmount());
                }
                if (!m.c(value.getPayment_method_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getPayment_method_id());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CommitPaymentRequest value) {
                m.h(value, "value");
                if (value.getAmount() == null) {
                    return 0;
                }
                return (m.c(value.getPayment_method_id(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(2, value.getPayment_method_id()) + value.unknownFields().Q()) + Amount.ADAPTER.encodedSizeWithTag(1, value.getAmount());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CommitPaymentRequest redact(CommitPaymentRequest value) {
                m.h(value, "value");
                Amount amount = value.getAmount();
                return CommitPaymentRequest.copy$default(value, amount != null ? Amount.ADAPTER.redact(amount) : null, null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CommitPaymentRequest() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ CommitPaymentRequest(Amount amount, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : amount, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ CommitPaymentRequest copy$default(CommitPaymentRequest commitPaymentRequest, Amount amount, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            amount = commitPaymentRequest.amount;
        }
        if ((i2 & 2) != 0) {
            str = commitPaymentRequest.payment_method_id;
        }
        if ((i2 & 4) != 0) {
            iVar = commitPaymentRequest.unknownFields();
        }
        return commitPaymentRequest.copy(amount, str, iVar);
    }

    public final CommitPaymentRequest copy(Amount amount, String payment_method_id, i unknownFields) {
        m.h(payment_method_id, "payment_method_id");
        m.h(unknownFields, "unknownFields");
        return new CommitPaymentRequest(amount, payment_method_id, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CommitPaymentRequest) {
            CommitPaymentRequest commitPaymentRequest = (CommitPaymentRequest) obj;
            return m.c(unknownFields(), commitPaymentRequest.unknownFields()) && m.c(this.amount, commitPaymentRequest.amount) && m.c(this.payment_method_id, commitPaymentRequest.payment_method_id);
        }
        return false;
    }

    public final Amount getAmount() {
        return this.amount;
    }

    public final String getPayment_method_id() {
        return this.payment_method_id;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Amount amount = this.amount;
            int hashCode2 = ((hashCode + (amount != null ? amount.hashCode() : 0)) * 37) + this.payment_method_id.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m346newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.amount != null) {
            arrayList.add("amount=" + this.amount);
        }
        arrayList.add("payment_method_id=" + b.c(this.payment_method_id));
        h0 = z.h0(arrayList, ", ", "CommitPaymentRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitPaymentRequest(Amount amount, String payment_method_id, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(payment_method_id, "payment_method_id");
        m.h(unknownFields, "unknownFields");
        this.amount = amount;
        this.payment_method_id = payment_method_id;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m346newBuilder() {
        throw new AssertionError();
    }
}