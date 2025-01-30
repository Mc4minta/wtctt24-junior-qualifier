package com.coinbase.android.apiv3.generated.resources;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.Ref;
import com.google.protobuf.u;
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
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: Loan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B\u0099\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b<\u0010=J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u009f\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b+\u0010'R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b,\u0010*R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b-\u0010'R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b.\u0010'R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010/\u001a\u0004\b0\u0010\u000fR\u001c\u0010\u001a\u001a\u00020\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\b2\u00103R\u001c\u0010\u001e\u001a\u00020\u001d8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b5\u00106R\u001c\u0010\u001c\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b7\u0010\u000fR\u001e\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b9\u0010:R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b;\u0010*¨\u0006?"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Loan;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "original_amount", "current_amount", "repaid_amount", "Lcom/google/protobuf/u;", "created_at", "end_at", "closed_at", "Lcom/coinbase/android/apiv3/generated/resources/PaymentFrequency;", "payment_frequency", "periodic_interest", "apr", "Lcom/coinbase/android/apiv3/generated/resources/TermLength;", "term", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "withdrawal_method", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/google/protobuf/u;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/resources/PaymentFrequency;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/TermLength;Lcom/coinbase/android/apiv3/generated/common/Ref;Lj/i;)Lcom/coinbase/android/apiv3/generated/resources/Loan;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getCurrent_amount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Lcom/google/protobuf/u;", "getEnd_at", "()Lcom/google/protobuf/u;", "getRepaid_amount", "getClosed_at", "getPeriodic_interest", "getOriginal_amount", "Ljava/lang/String;", "getId", "Lcom/coinbase/android/apiv3/generated/resources/PaymentFrequency;", "getPayment_frequency", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentFrequency;", "Lcom/coinbase/android/apiv3/generated/resources/TermLength;", "getTerm", "()Lcom/coinbase/android/apiv3/generated/resources/TermLength;", "getApr", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "getWithdrawal_method", "()Lcom/coinbase/android/apiv3/generated/common/Ref;", "getCreated_at", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/google/protobuf/u;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/resources/PaymentFrequency;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/TermLength;Lcom/coinbase/android/apiv3/generated/common/Ref;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Loan extends a {
    public static final ProtoAdapter<Loan> ADAPTER;
    public static final Parcelable.Creator<Loan> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    private final String apr;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "closedAt", tag = 7)
    private final u closed_at;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "createdAt", tag = 5)
    private final u created_at;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "currentAmount", tag = 3)
    private final Amount current_amount;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "endAt", tag = 6)
    private final u end_at;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "originalAmount", tag = 2)
    private final Amount original_amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentFrequency#ADAPTER", jsonName = "paymentFrequency", tag = 8)
    private final PaymentFrequency payment_frequency;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "periodicInterest", tag = 9)
    private final Amount periodic_interest;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "repaidAmount", tag = 4)
    private final Amount repaid_amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.TermLength#ADAPTER", tag = 11)
    private final TermLength term;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "withdrawalMethod", tag = 12)
    private final Ref withdrawal_method;

    /* compiled from: Loan.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Loan$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/Loan;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(Loan.class);
        ProtoAdapter<Loan> protoAdapter = new ProtoAdapter<Loan>(cVar, b2, "type.googleapis.com/coinbase.public_api.resources.Loan") { // from class: com.coinbase.android.apiv3.generated.resources.Loan$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Loan decode(k reader) {
                m.h(reader, "reader");
                PaymentFrequency paymentFrequency = PaymentFrequency.MONTHLY;
                TermLength termLength = TermLength.YEAR;
                long d2 = reader.d();
                PaymentFrequency paymentFrequency2 = paymentFrequency;
                TermLength termLength2 = termLength;
                String str = "";
                String str2 = str;
                Amount amount = null;
                Amount amount2 = null;
                Amount amount3 = null;
                u uVar = null;
                u uVar2 = null;
                u uVar3 = null;
                Amount amount4 = null;
                Ref ref = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Loan(str, amount, amount2, amount3, uVar, uVar2, uVar3, paymentFrequency2, amount4, str2, termLength2, ref, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 3:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            uVar = u.a.decode(reader);
                            break;
                        case 6:
                            uVar2 = u.a.decode(reader);
                            break;
                        case 7:
                            uVar3 = u.a.decode(reader);
                            break;
                        case 8:
                            try {
                                paymentFrequency2 = PaymentFrequency.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 9:
                            amount4 = Amount.ADAPTER.decode(reader);
                            break;
                        case 10:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 11:
                            try {
                                termLength2 = TermLength.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                reader.a(g2, c.VARINT, Long.valueOf(e3.a));
                                break;
                            }
                        case 12:
                            ref = Ref.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Loan value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (value.getOriginal_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getOriginal_amount());
                }
                if (value.getCurrent_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getCurrent_amount());
                }
                if (value.getRepaid_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getRepaid_amount());
                }
                if (value.getCreated_at() != null) {
                    u.a.encodeWithTag(writer, 5, value.getCreated_at());
                }
                if (value.getEnd_at() != null) {
                    u.a.encodeWithTag(writer, 6, value.getEnd_at());
                }
                if (value.getClosed_at() != null) {
                    u.a.encodeWithTag(writer, 7, value.getClosed_at());
                }
                if (value.getPayment_frequency() != PaymentFrequency.MONTHLY) {
                    PaymentFrequency.ADAPTER.encodeWithTag(writer, 8, value.getPayment_frequency());
                }
                if (value.getPeriodic_interest() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 9, value.getPeriodic_interest());
                }
                if (!m.c(value.getApr(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 10, value.getApr());
                }
                if (value.getTerm() != TermLength.YEAR) {
                    TermLength.ADAPTER.encodeWithTag(writer, 11, value.getTerm());
                }
                if (value.getWithdrawal_method() != null) {
                    Ref.ADAPTER.encodeWithTag(writer, 12, value.getWithdrawal_method());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Loan value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (value.getOriginal_amount() != null) {
                    ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                    int encodedSizeWithTag2 = protoAdapter3.encodedSizeWithTag(2, value.getOriginal_amount());
                    if (value.getCurrent_amount() != null) {
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getCurrent_amount());
                        if (value.getRepaid_amount() != null) {
                            int encodedSizeWithTag4 = protoAdapter3.encodedSizeWithTag(4, value.getRepaid_amount());
                            if (value.getCreated_at() != null) {
                                ProtoAdapter<u> protoAdapter4 = u.a;
                                int encodedSizeWithTag5 = protoAdapter4.encodedSizeWithTag(5, value.getCreated_at());
                                if (value.getEnd_at() != null) {
                                    int encodedSizeWithTag6 = protoAdapter4.encodedSizeWithTag(6, value.getEnd_at());
                                    if (value.getClosed_at() != null) {
                                        int encodedSizeWithTag7 = protoAdapter4.encodedSizeWithTag(7, value.getClosed_at());
                                        if (value.getPayment_frequency() != PaymentFrequency.MONTHLY) {
                                            int encodedSizeWithTag8 = PaymentFrequency.ADAPTER.encodedSizeWithTag(8, value.getPayment_frequency());
                                            if (value.getPeriodic_interest() != null) {
                                                int encodedSizeWithTag9 = protoAdapter3.encodedSizeWithTag(9, value.getPeriodic_interest());
                                                if (!m.c(value.getApr(), "")) {
                                                    int encodedSizeWithTag10 = protoAdapter2.encodedSizeWithTag(10, value.getApr());
                                                    if (value.getTerm() != TermLength.YEAR) {
                                                        r2 = (value.getWithdrawal_method() != null ? Ref.ADAPTER.encodedSizeWithTag(12, value.getWithdrawal_method()) + value.unknownFields().Q() : 0) + TermLength.ADAPTER.encodedSizeWithTag(11, value.getTerm());
                                                    }
                                                    r2 += encodedSizeWithTag10;
                                                }
                                                r2 += encodedSizeWithTag9;
                                            }
                                            r2 += encodedSizeWithTag8;
                                        }
                                        r2 += encodedSizeWithTag7;
                                    }
                                    r2 += encodedSizeWithTag6;
                                }
                                r2 += encodedSizeWithTag5;
                            }
                            r2 += encodedSizeWithTag4;
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Loan redact(Loan value) {
                Loan copy;
                m.h(value, "value");
                Amount original_amount = value.getOriginal_amount();
                Amount redact = original_amount != null ? Amount.ADAPTER.redact(original_amount) : null;
                Amount current_amount = value.getCurrent_amount();
                Amount redact2 = current_amount != null ? Amount.ADAPTER.redact(current_amount) : null;
                Amount repaid_amount = value.getRepaid_amount();
                Amount redact3 = repaid_amount != null ? Amount.ADAPTER.redact(repaid_amount) : null;
                u created_at = value.getCreated_at();
                u redact4 = created_at != null ? u.a.redact(created_at) : null;
                u end_at = value.getEnd_at();
                u redact5 = end_at != null ? u.a.redact(end_at) : null;
                u closed_at = value.getClosed_at();
                u redact6 = closed_at != null ? u.a.redact(closed_at) : null;
                Amount periodic_interest = value.getPeriodic_interest();
                Amount redact7 = periodic_interest != null ? Amount.ADAPTER.redact(periodic_interest) : null;
                Ref withdrawal_method = value.getWithdrawal_method();
                copy = value.copy((r28 & 1) != 0 ? value.id : null, (r28 & 2) != 0 ? value.original_amount : redact, (r28 & 4) != 0 ? value.current_amount : redact2, (r28 & 8) != 0 ? value.repaid_amount : redact3, (r28 & 16) != 0 ? value.created_at : redact4, (r28 & 32) != 0 ? value.end_at : redact5, (r28 & 64) != 0 ? value.closed_at : redact6, (r28 & 128) != 0 ? value.payment_frequency : null, (r28 & 256) != 0 ? value.periodic_interest : redact7, (r28 & 512) != 0 ? value.apr : null, (r28 & 1024) != 0 ? value.term : null, (r28 & PKIFailureInfo.wrongIntegrity) != 0 ? value.withdrawal_method : withdrawal_method != null ? Ref.ADAPTER.redact(withdrawal_method) : null, (r28 & 4096) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Loan() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public /* synthetic */ Loan(String str, Amount amount, Amount amount2, Amount amount3, u uVar, u uVar2, u uVar3, PaymentFrequency paymentFrequency, Amount amount4, String str2, TermLength termLength, Ref ref, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? null : amount2, (i2 & 8) != 0 ? null : amount3, (i2 & 16) != 0 ? null : uVar, (i2 & 32) != 0 ? null : uVar2, (i2 & 64) != 0 ? null : uVar3, (i2 & 128) != 0 ? PaymentFrequency.MONTHLY : paymentFrequency, (i2 & 256) != 0 ? null : amount4, (i2 & 512) == 0 ? str2 : "", (i2 & 1024) != 0 ? TermLength.YEAR : termLength, (i2 & PKIFailureInfo.wrongIntegrity) == 0 ? ref : null, (i2 & 4096) != 0 ? i.a : iVar);
    }

    public final Loan copy(String id, Amount amount, Amount amount2, Amount amount3, u uVar, u uVar2, u uVar3, PaymentFrequency payment_frequency, Amount amount4, String apr, TermLength term, Ref ref, i unknownFields) {
        m.h(id, "id");
        m.h(payment_frequency, "payment_frequency");
        m.h(apr, "apr");
        m.h(term, "term");
        m.h(unknownFields, "unknownFields");
        return new Loan(id, amount, amount2, amount3, uVar, uVar2, uVar3, payment_frequency, amount4, apr, term, ref, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Loan) {
            Loan loan = (Loan) obj;
            return m.c(unknownFields(), loan.unknownFields()) && m.c(this.id, loan.id) && m.c(this.original_amount, loan.original_amount) && m.c(this.current_amount, loan.current_amount) && m.c(this.repaid_amount, loan.repaid_amount) && m.c(this.created_at, loan.created_at) && m.c(this.end_at, loan.end_at) && m.c(this.closed_at, loan.closed_at) && this.payment_frequency == loan.payment_frequency && m.c(this.periodic_interest, loan.periodic_interest) && m.c(this.apr, loan.apr) && this.term == loan.term && m.c(this.withdrawal_method, loan.withdrawal_method);
        }
        return false;
    }

    public final String getApr() {
        return this.apr;
    }

    public final u getClosed_at() {
        return this.closed_at;
    }

    public final u getCreated_at() {
        return this.created_at;
    }

    public final Amount getCurrent_amount() {
        return this.current_amount;
    }

    public final u getEnd_at() {
        return this.end_at;
    }

    public final String getId() {
        return this.id;
    }

    public final Amount getOriginal_amount() {
        return this.original_amount;
    }

    public final PaymentFrequency getPayment_frequency() {
        return this.payment_frequency;
    }

    public final Amount getPeriodic_interest() {
        return this.periodic_interest;
    }

    public final Amount getRepaid_amount() {
        return this.repaid_amount;
    }

    public final TermLength getTerm() {
        return this.term;
    }

    public final Ref getWithdrawal_method() {
        return this.withdrawal_method;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37;
            Amount amount = this.original_amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.current_amount;
            int hashCode3 = (hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.repaid_amount;
            int hashCode4 = (hashCode3 + (amount3 != null ? amount3.hashCode() : 0)) * 37;
            u uVar = this.created_at;
            int hashCode5 = (hashCode4 + (uVar != null ? uVar.hashCode() : 0)) * 37;
            u uVar2 = this.end_at;
            int hashCode6 = (hashCode5 + (uVar2 != null ? uVar2.hashCode() : 0)) * 37;
            u uVar3 = this.closed_at;
            int hashCode7 = (((hashCode6 + (uVar3 != null ? uVar3.hashCode() : 0)) * 37) + this.payment_frequency.hashCode()) * 37;
            Amount amount4 = this.periodic_interest;
            int hashCode8 = (((((hashCode7 + (amount4 != null ? amount4.hashCode() : 0)) * 37) + this.apr.hashCode()) * 37) + this.term.hashCode()) * 37;
            Ref ref = this.withdrawal_method;
            int hashCode9 = hashCode8 + (ref != null ? ref.hashCode() : 0);
            this.hashCode = hashCode9;
            return hashCode9;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m529newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        if (this.original_amount != null) {
            arrayList.add("original_amount=" + this.original_amount);
        }
        if (this.current_amount != null) {
            arrayList.add("current_amount=" + this.current_amount);
        }
        if (this.repaid_amount != null) {
            arrayList.add("repaid_amount=" + this.repaid_amount);
        }
        if (this.created_at != null) {
            arrayList.add("created_at=" + this.created_at);
        }
        if (this.end_at != null) {
            arrayList.add("end_at=" + this.end_at);
        }
        if (this.closed_at != null) {
            arrayList.add("closed_at=" + this.closed_at);
        }
        arrayList.add("payment_frequency=" + this.payment_frequency);
        if (this.periodic_interest != null) {
            arrayList.add("periodic_interest=" + this.periodic_interest);
        }
        arrayList.add("apr=" + b.c(this.apr));
        arrayList.add("term=" + this.term);
        if (this.withdrawal_method != null) {
            arrayList.add("withdrawal_method=" + this.withdrawal_method);
        }
        h0 = z.h0(arrayList, ", ", "Loan{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m529newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Loan(String id, Amount amount, Amount amount2, Amount amount3, u uVar, u uVar2, u uVar3, PaymentFrequency payment_frequency, Amount amount4, String apr, TermLength term, Ref ref, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(payment_frequency, "payment_frequency");
        m.h(apr, "apr");
        m.h(term, "term");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.original_amount = amount;
        this.current_amount = amount2;
        this.repaid_amount = amount3;
        this.created_at = uVar;
        this.end_at = uVar2;
        this.closed_at = uVar3;
        this.payment_frequency = payment_frequency;
        this.periodic_interest = amount4;
        this.apr = apr;
        this.term = term;
        this.withdrawal_method = ref;
    }
}