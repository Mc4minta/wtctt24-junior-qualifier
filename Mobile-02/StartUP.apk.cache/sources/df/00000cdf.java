package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.common.Link;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: QuoteLoanResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B«\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b<\u0010=J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ±\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b)\u0010(R\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b,\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b-\u0010(R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b.\u0010(R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b/\u0010(R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b1\u00102R\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b4\u00105R\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b6\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b7\u0010(R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010&\u001a\u0004\b8\u0010(R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteLoanResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "loan_amount", "max_loan_amount", "max_loan_eligibility", "collateral_available", "collateral_required", "loan_ratio", "apr", "", "Lcom/coinbase/android/apiv3/generated/authed/loans/DisbursementPaymentMethod;", "available_payment_methods", "first_interest_payment", "Lcom/google/protobuf/u;", "first_interest_payment_due", "interest_payment_per_day", "Lcom/coinbase/android/apiv3/generated/common/Link;", "support_info", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteLoanResponse;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getInterest_payment_per_day", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getCollateral_available", "Ljava/lang/String;", "getApr", "getId", "getMax_loan_eligibility", "getLoan_amount", "getMax_loan_amount", "Ljava/util/List;", "getAvailable_payment_methods", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/common/Link;", "getSupport_info", "()Lcom/coinbase/android/apiv3/generated/common/Link;", "getLoan_ratio", "getCollateral_required", "getFirst_interest_payment", "Lcom/google/protobuf/u;", "getFirst_interest_payment_due", "()Lcom/google/protobuf/u;", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/google/protobuf/u;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class QuoteLoanResponse extends a {
    public static final ProtoAdapter<QuoteLoanResponse> ADAPTER;
    public static final Parcelable.Creator<QuoteLoanResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    private final String apr;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.DisbursementPaymentMethod#ADAPTER", jsonName = "availablePaymentMethods", label = p.a.REPEATED, tag = 9)
    private final List<DisbursementPaymentMethod> available_payment_methods;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "collateralAvailable", tag = 5)
    private final Amount collateral_available;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "collateralRequired", tag = 6)
    private final Amount collateral_required;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "firstInterestPayment", tag = 10)
    private final Amount first_interest_payment;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "firstInterestPaymentDue", tag = 11)
    private final u first_interest_payment_due;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "interestPaymentPerDay", tag = 12)
    private final Amount interest_payment_per_day;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "loanAmount", tag = 2)
    private final Amount loan_amount;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "loanRatio", tag = 7)
    private final String loan_ratio;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "maxLoanAmount", tag = 3)
    private final Amount max_loan_amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "maxLoanEligibility", tag = 4)
    private final Amount max_loan_eligibility;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Link#ADAPTER", jsonName = "supportInfo", tag = 13)
    private final Link support_info;

    /* compiled from: QuoteLoanResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteLoanResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/QuoteLoanResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<QuoteLoanResponse> protoAdapter = new ProtoAdapter<QuoteLoanResponse>(c.LENGTH_DELIMITED, e0.b(QuoteLoanResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.QuoteLoanResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.QuoteLoanResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public QuoteLoanResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                Amount amount = null;
                String str2 = "";
                String str3 = str2;
                Amount amount2 = null;
                Amount amount3 = null;
                Amount amount4 = null;
                Amount amount5 = null;
                Amount amount6 = null;
                u uVar = null;
                Amount amount7 = null;
                Link link = null;
                while (true) {
                    int g2 = reader.g();
                    Amount amount8 = amount7;
                    if (g2 == -1) {
                        return new QuoteLoanResponse(str, amount, amount2, amount3, amount4, amount5, str2, str3, arrayList, amount6, uVar, amount8, link, reader.e(d2));
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
                            amount4 = Amount.ADAPTER.decode(reader);
                            break;
                        case 6:
                            amount5 = Amount.ADAPTER.decode(reader);
                            break;
                        case 7:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            arrayList.add(DisbursementPaymentMethod.ADAPTER.decode(reader));
                            break;
                        case 10:
                            amount6 = Amount.ADAPTER.decode(reader);
                            break;
                        case 11:
                            uVar = u.a.decode(reader);
                            break;
                        case 12:
                            amount7 = Amount.ADAPTER.decode(reader);
                            continue;
                        case 13:
                            link = Link.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                    amount7 = amount8;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, QuoteLoanResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (value.getLoan_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getLoan_amount());
                }
                if (value.getMax_loan_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getMax_loan_amount());
                }
                if (value.getMax_loan_eligibility() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getMax_loan_eligibility());
                }
                if (value.getCollateral_available() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 5, value.getCollateral_available());
                }
                if (value.getCollateral_required() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 6, value.getCollateral_required());
                }
                if (!m.c(value.getLoan_ratio(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getLoan_ratio());
                }
                if (!m.c(value.getApr(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.getApr());
                }
                DisbursementPaymentMethod.ADAPTER.asRepeated().encodeWithTag(writer, 9, value.getAvailable_payment_methods());
                if (value.getFirst_interest_payment() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 10, value.getFirst_interest_payment());
                }
                if (value.getFirst_interest_payment_due() != null) {
                    u.a.encodeWithTag(writer, 11, value.getFirst_interest_payment_due());
                }
                if (value.getInterest_payment_per_day() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 12, value.getInterest_payment_per_day());
                }
                if (value.getSupport_info() != null) {
                    Link.ADAPTER.encodeWithTag(writer, 13, value.getSupport_info());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(QuoteLoanResponse value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (value.getLoan_amount() != null) {
                    ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                    int encodedSizeWithTag2 = protoAdapter3.encodedSizeWithTag(2, value.getLoan_amount());
                    if (value.getMax_loan_amount() != null) {
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getMax_loan_amount());
                        if (value.getMax_loan_eligibility() != null) {
                            int encodedSizeWithTag4 = protoAdapter3.encodedSizeWithTag(4, value.getMax_loan_eligibility());
                            if (value.getCollateral_available() != null) {
                                int encodedSizeWithTag5 = protoAdapter3.encodedSizeWithTag(5, value.getCollateral_available());
                                if (value.getCollateral_required() != null) {
                                    int encodedSizeWithTag6 = protoAdapter3.encodedSizeWithTag(6, value.getCollateral_required());
                                    if (!m.c(value.getLoan_ratio(), "")) {
                                        int encodedSizeWithTag7 = protoAdapter2.encodedSizeWithTag(7, value.getLoan_ratio());
                                        if (!m.c(value.getApr(), "")) {
                                            int encodedSizeWithTag8 = protoAdapter2.encodedSizeWithTag(8, value.getApr()) + DisbursementPaymentMethod.ADAPTER.asRepeated().encodedSizeWithTag(9, value.getAvailable_payment_methods());
                                            if (value.getFirst_interest_payment() != null) {
                                                int encodedSizeWithTag9 = protoAdapter3.encodedSizeWithTag(10, value.getFirst_interest_payment());
                                                if (value.getFirst_interest_payment_due() != null) {
                                                    int encodedSizeWithTag10 = u.a.encodedSizeWithTag(11, value.getFirst_interest_payment_due());
                                                    if (value.getInterest_payment_per_day() != null) {
                                                        r2 = (value.getSupport_info() != null ? Link.ADAPTER.encodedSizeWithTag(13, value.getSupport_info()) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(12, value.getInterest_payment_per_day());
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
            public QuoteLoanResponse redact(QuoteLoanResponse value) {
                m.h(value, "value");
                Amount loan_amount = value.getLoan_amount();
                Amount redact = loan_amount != null ? Amount.ADAPTER.redact(loan_amount) : null;
                Amount max_loan_amount = value.getMax_loan_amount();
                Amount redact2 = max_loan_amount != null ? Amount.ADAPTER.redact(max_loan_amount) : null;
                Amount max_loan_eligibility = value.getMax_loan_eligibility();
                Amount redact3 = max_loan_eligibility != null ? Amount.ADAPTER.redact(max_loan_eligibility) : null;
                Amount collateral_available = value.getCollateral_available();
                Amount redact4 = collateral_available != null ? Amount.ADAPTER.redact(collateral_available) : null;
                Amount collateral_required = value.getCollateral_required();
                Amount redact5 = collateral_required != null ? Amount.ADAPTER.redact(collateral_required) : null;
                List a = b.a(value.getAvailable_payment_methods(), DisbursementPaymentMethod.ADAPTER);
                Amount first_interest_payment = value.getFirst_interest_payment();
                Amount redact6 = first_interest_payment != null ? Amount.ADAPTER.redact(first_interest_payment) : null;
                u first_interest_payment_due = value.getFirst_interest_payment_due();
                u redact7 = first_interest_payment_due != null ? u.a.redact(first_interest_payment_due) : null;
                Amount interest_payment_per_day = value.getInterest_payment_per_day();
                Amount redact8 = interest_payment_per_day != null ? Amount.ADAPTER.redact(interest_payment_per_day) : null;
                Link support_info = value.getSupport_info();
                return QuoteLoanResponse.copy$default(value, null, redact, redact2, redact3, redact4, redact5, null, null, a, redact6, redact7, redact8, support_info != null ? Link.ADAPTER.redact(support_info) : null, i.a, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public QuoteLoanResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public /* synthetic */ QuoteLoanResponse(String str, Amount amount, Amount amount2, Amount amount3, Amount amount4, Amount amount5, String str2, String str3, List list, Amount amount6, u uVar, Amount amount7, Link link, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? null : amount2, (i2 & 8) != 0 ? null : amount3, (i2 & 16) != 0 ? null : amount4, (i2 & 32) != 0 ? null : amount5, (i2 & 64) != 0 ? "" : str2, (i2 & 128) == 0 ? str3 : "", (i2 & 256) != 0 ? r.g() : list, (i2 & 512) != 0 ? null : amount6, (i2 & 1024) != 0 ? null : uVar, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? null : amount7, (i2 & 4096) == 0 ? link : null, (i2 & PKIFailureInfo.certRevoked) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuoteLoanResponse copy$default(QuoteLoanResponse quoteLoanResponse, String str, Amount amount, Amount amount2, Amount amount3, Amount amount4, Amount amount5, String str2, String str3, List list, Amount amount6, u uVar, Amount amount7, Link link, i iVar, int i2, Object obj) {
        return quoteLoanResponse.copy((i2 & 1) != 0 ? quoteLoanResponse.id : str, (i2 & 2) != 0 ? quoteLoanResponse.loan_amount : amount, (i2 & 4) != 0 ? quoteLoanResponse.max_loan_amount : amount2, (i2 & 8) != 0 ? quoteLoanResponse.max_loan_eligibility : amount3, (i2 & 16) != 0 ? quoteLoanResponse.collateral_available : amount4, (i2 & 32) != 0 ? quoteLoanResponse.collateral_required : amount5, (i2 & 64) != 0 ? quoteLoanResponse.loan_ratio : str2, (i2 & 128) != 0 ? quoteLoanResponse.apr : str3, (i2 & 256) != 0 ? quoteLoanResponse.available_payment_methods : list, (i2 & 512) != 0 ? quoteLoanResponse.first_interest_payment : amount6, (i2 & 1024) != 0 ? quoteLoanResponse.first_interest_payment_due : uVar, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? quoteLoanResponse.interest_payment_per_day : amount7, (i2 & 4096) != 0 ? quoteLoanResponse.support_info : link, (i2 & PKIFailureInfo.certRevoked) != 0 ? quoteLoanResponse.unknownFields() : iVar);
    }

    public final QuoteLoanResponse copy(String id, Amount amount, Amount amount2, Amount amount3, Amount amount4, Amount amount5, String loan_ratio, String apr, List<DisbursementPaymentMethod> available_payment_methods, Amount amount6, u uVar, Amount amount7, Link link, i unknownFields) {
        m.h(id, "id");
        m.h(loan_ratio, "loan_ratio");
        m.h(apr, "apr");
        m.h(available_payment_methods, "available_payment_methods");
        m.h(unknownFields, "unknownFields");
        return new QuoteLoanResponse(id, amount, amount2, amount3, amount4, amount5, loan_ratio, apr, available_payment_methods, amount6, uVar, amount7, link, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof QuoteLoanResponse) {
            QuoteLoanResponse quoteLoanResponse = (QuoteLoanResponse) obj;
            return m.c(unknownFields(), quoteLoanResponse.unknownFields()) && m.c(this.id, quoteLoanResponse.id) && m.c(this.loan_amount, quoteLoanResponse.loan_amount) && m.c(this.max_loan_amount, quoteLoanResponse.max_loan_amount) && m.c(this.max_loan_eligibility, quoteLoanResponse.max_loan_eligibility) && m.c(this.collateral_available, quoteLoanResponse.collateral_available) && m.c(this.collateral_required, quoteLoanResponse.collateral_required) && m.c(this.loan_ratio, quoteLoanResponse.loan_ratio) && m.c(this.apr, quoteLoanResponse.apr) && m.c(this.available_payment_methods, quoteLoanResponse.available_payment_methods) && m.c(this.first_interest_payment, quoteLoanResponse.first_interest_payment) && m.c(this.first_interest_payment_due, quoteLoanResponse.first_interest_payment_due) && m.c(this.interest_payment_per_day, quoteLoanResponse.interest_payment_per_day) && m.c(this.support_info, quoteLoanResponse.support_info);
        }
        return false;
    }

    public final String getApr() {
        return this.apr;
    }

    public final List<DisbursementPaymentMethod> getAvailable_payment_methods() {
        return this.available_payment_methods;
    }

    public final Amount getCollateral_available() {
        return this.collateral_available;
    }

    public final Amount getCollateral_required() {
        return this.collateral_required;
    }

    public final Amount getFirst_interest_payment() {
        return this.first_interest_payment;
    }

    public final u getFirst_interest_payment_due() {
        return this.first_interest_payment_due;
    }

    public final String getId() {
        return this.id;
    }

    public final Amount getInterest_payment_per_day() {
        return this.interest_payment_per_day;
    }

    public final Amount getLoan_amount() {
        return this.loan_amount;
    }

    public final String getLoan_ratio() {
        return this.loan_ratio;
    }

    public final Amount getMax_loan_amount() {
        return this.max_loan_amount;
    }

    public final Amount getMax_loan_eligibility() {
        return this.max_loan_eligibility;
    }

    public final Link getSupport_info() {
        return this.support_info;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37;
            Amount amount = this.loan_amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.max_loan_amount;
            int hashCode3 = (hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37;
            Amount amount3 = this.max_loan_eligibility;
            int hashCode4 = (hashCode3 + (amount3 != null ? amount3.hashCode() : 0)) * 37;
            Amount amount4 = this.collateral_available;
            int hashCode5 = (hashCode4 + (amount4 != null ? amount4.hashCode() : 0)) * 37;
            Amount amount5 = this.collateral_required;
            int hashCode6 = (((((((hashCode5 + (amount5 != null ? amount5.hashCode() : 0)) * 37) + this.loan_ratio.hashCode()) * 37) + this.apr.hashCode()) * 37) + this.available_payment_methods.hashCode()) * 37;
            Amount amount6 = this.first_interest_payment;
            int hashCode7 = (hashCode6 + (amount6 != null ? amount6.hashCode() : 0)) * 37;
            u uVar = this.first_interest_payment_due;
            int hashCode8 = (hashCode7 + (uVar != null ? uVar.hashCode() : 0)) * 37;
            Amount amount7 = this.interest_payment_per_day;
            int hashCode9 = (hashCode8 + (amount7 != null ? amount7.hashCode() : 0)) * 37;
            Link link = this.support_info;
            int hashCode10 = hashCode9 + (link != null ? link.hashCode() : 0);
            this.hashCode = hashCode10;
            return hashCode10;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m384newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        if (this.loan_amount != null) {
            arrayList.add("loan_amount=" + this.loan_amount);
        }
        if (this.max_loan_amount != null) {
            arrayList.add("max_loan_amount=" + this.max_loan_amount);
        }
        if (this.max_loan_eligibility != null) {
            arrayList.add("max_loan_eligibility=" + this.max_loan_eligibility);
        }
        if (this.collateral_available != null) {
            arrayList.add("collateral_available=" + this.collateral_available);
        }
        if (this.collateral_required != null) {
            arrayList.add("collateral_required=" + this.collateral_required);
        }
        arrayList.add("loan_ratio=" + b.c(this.loan_ratio));
        arrayList.add("apr=" + b.c(this.apr));
        if (!this.available_payment_methods.isEmpty()) {
            arrayList.add("available_payment_methods=" + this.available_payment_methods);
        }
        if (this.first_interest_payment != null) {
            arrayList.add("first_interest_payment=" + this.first_interest_payment);
        }
        if (this.first_interest_payment_due != null) {
            arrayList.add("first_interest_payment_due=" + this.first_interest_payment_due);
        }
        if (this.interest_payment_per_day != null) {
            arrayList.add("interest_payment_per_day=" + this.interest_payment_per_day);
        }
        if (this.support_info != null) {
            arrayList.add("support_info=" + this.support_info);
        }
        h0 = z.h0(arrayList, ", ", "QuoteLoanResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m384newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuoteLoanResponse(String id, Amount amount, Amount amount2, Amount amount3, Amount amount4, Amount amount5, String loan_ratio, String apr, List<DisbursementPaymentMethod> available_payment_methods, Amount amount6, u uVar, Amount amount7, Link link, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(loan_ratio, "loan_ratio");
        m.h(apr, "apr");
        m.h(available_payment_methods, "available_payment_methods");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.loan_amount = amount;
        this.max_loan_amount = amount2;
        this.max_loan_eligibility = amount3;
        this.collateral_available = amount4;
        this.collateral_required = amount5;
        this.loan_ratio = loan_ratio;
        this.apr = apr;
        this.available_payment_methods = available_payment_methods;
        this.first_interest_payment = amount6;
        this.first_interest_payment_due = uVar;
        this.interest_payment_per_day = amount7;
        this.support_info = link;
    }
}