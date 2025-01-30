package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.resources.Loan;
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

/* compiled from: CommitLoanResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/BU\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ[\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b&\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CommitLoanResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/resources/Loan;", "loan", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "withdrawal_total", "withdrawal_description", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "autopay_setting", "first_payment_description", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "withdrawal_method", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/resources/Loan;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/CommitLoanResponse;", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getWithdrawal_total", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "getAutopay_setting", "()Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;", "Ljava/lang/String;", "getFirst_payment_description", "getWithdrawal_description", "Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "getWithdrawal_method", "()Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;", "Lcom/coinbase/android/apiv3/generated/resources/Loan;", "getLoan", "()Lcom/coinbase/android/apiv3/generated/resources/Loan;", "<init>", "(Lcom/coinbase/android/apiv3/generated/resources/Loan;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loans/AutopaySetting;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/PaymentMethod;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CommitLoanResponse extends a {
    public static final ProtoAdapter<CommitLoanResponse> ADAPTER;
    public static final Parcelable.Creator<CommitLoanResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.AutopaySetting#ADAPTER", jsonName = "autopaySetting", tag = 4)
    private final AutopaySetting autopay_setting;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "firstPaymentDescription", tag = 5)
    private final String first_payment_description;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Loan#ADAPTER", tag = 1)
    private final Loan loan;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "withdrawalDescription", tag = 3)
    private final String withdrawal_description;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.PaymentMethod#ADAPTER", jsonName = "withdrawalMethod", tag = 6)
    private final PaymentMethod withdrawal_method;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "withdrawalTotal", tag = 2)
    private final Amount withdrawal_total;

    /* compiled from: CommitLoanResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CommitLoanResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CommitLoanResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<CommitLoanResponse> protoAdapter = new ProtoAdapter<CommitLoanResponse>(c.LENGTH_DELIMITED, e0.b(CommitLoanResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.CommitLoanResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.CommitLoanResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CommitLoanResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                Loan loan = null;
                Amount amount = null;
                AutopaySetting autopaySetting = null;
                PaymentMethod paymentMethod = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new CommitLoanResponse(loan, amount, str, autopaySetting, str2, paymentMethod, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            loan = Loan.ADAPTER.decode(reader);
                            break;
                        case 2:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 3:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            autopaySetting = AutopaySetting.ADAPTER.decode(reader);
                            break;
                        case 5:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            paymentMethod = PaymentMethod.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CommitLoanResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getLoan() != null) {
                    Loan.ADAPTER.encodeWithTag(writer, 1, value.getLoan());
                }
                if (value.getWithdrawal_total() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 2, value.getWithdrawal_total());
                }
                if (!m.c(value.getWithdrawal_description(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getWithdrawal_description());
                }
                if (value.getAutopay_setting() != null) {
                    AutopaySetting.ADAPTER.encodeWithTag(writer, 4, value.getAutopay_setting());
                }
                if (!m.c(value.getFirst_payment_description(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getFirst_payment_description());
                }
                if (value.getWithdrawal_method() != null) {
                    PaymentMethod.ADAPTER.encodeWithTag(writer, 6, value.getWithdrawal_method());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CommitLoanResponse value) {
                m.h(value, "value");
                if (value.getLoan() == null) {
                    return 0;
                }
                int encodedSizeWithTag = Loan.ADAPTER.encodedSizeWithTag(1, value.getLoan());
                if (value.getWithdrawal_total() != null) {
                    int encodedSizeWithTag2 = Amount.ADAPTER.encodedSizeWithTag(2, value.getWithdrawal_total());
                    if (!m.c(value.getWithdrawal_description(), "")) {
                        ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getWithdrawal_description());
                        if (value.getAutopay_setting() != null) {
                            int encodedSizeWithTag4 = AutopaySetting.ADAPTER.encodedSizeWithTag(4, value.getAutopay_setting());
                            if (!m.c(value.getFirst_payment_description(), "")) {
                                r1 = (value.getWithdrawal_method() != null ? PaymentMethod.ADAPTER.encodedSizeWithTag(6, value.getWithdrawal_method()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(5, value.getFirst_payment_description());
                            }
                            r1 += encodedSizeWithTag4;
                        }
                        r1 += encodedSizeWithTag3;
                    }
                    r1 += encodedSizeWithTag2;
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CommitLoanResponse redact(CommitLoanResponse value) {
                m.h(value, "value");
                Loan loan = value.getLoan();
                Loan redact = loan != null ? Loan.ADAPTER.redact(loan) : null;
                Amount withdrawal_total = value.getWithdrawal_total();
                Amount redact2 = withdrawal_total != null ? Amount.ADAPTER.redact(withdrawal_total) : null;
                AutopaySetting autopay_setting = value.getAutopay_setting();
                AutopaySetting redact3 = autopay_setting != null ? AutopaySetting.ADAPTER.redact(autopay_setting) : null;
                PaymentMethod withdrawal_method = value.getWithdrawal_method();
                return CommitLoanResponse.copy$default(value, redact, redact2, null, redact3, null, withdrawal_method != null ? PaymentMethod.ADAPTER.redact(withdrawal_method) : null, i.a, 20, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CommitLoanResponse() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ CommitLoanResponse(Loan loan, Amount amount, String str, AutopaySetting autopaySetting, String str2, PaymentMethod paymentMethod, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : loan, (i2 & 2) != 0 ? null : amount, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? null : autopaySetting, (i2 & 16) != 0 ? "" : str2, (i2 & 32) == 0 ? paymentMethod : null, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ CommitLoanResponse copy$default(CommitLoanResponse commitLoanResponse, Loan loan, Amount amount, String str, AutopaySetting autopaySetting, String str2, PaymentMethod paymentMethod, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            loan = commitLoanResponse.loan;
        }
        if ((i2 & 2) != 0) {
            amount = commitLoanResponse.withdrawal_total;
        }
        Amount amount2 = amount;
        if ((i2 & 4) != 0) {
            str = commitLoanResponse.withdrawal_description;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            autopaySetting = commitLoanResponse.autopay_setting;
        }
        AutopaySetting autopaySetting2 = autopaySetting;
        if ((i2 & 16) != 0) {
            str2 = commitLoanResponse.first_payment_description;
        }
        String str4 = str2;
        if ((i2 & 32) != 0) {
            paymentMethod = commitLoanResponse.withdrawal_method;
        }
        PaymentMethod paymentMethod2 = paymentMethod;
        if ((i2 & 64) != 0) {
            iVar = commitLoanResponse.unknownFields();
        }
        return commitLoanResponse.copy(loan, amount2, str3, autopaySetting2, str4, paymentMethod2, iVar);
    }

    public final CommitLoanResponse copy(Loan loan, Amount amount, String withdrawal_description, AutopaySetting autopaySetting, String first_payment_description, PaymentMethod paymentMethod, i unknownFields) {
        m.h(withdrawal_description, "withdrawal_description");
        m.h(first_payment_description, "first_payment_description");
        m.h(unknownFields, "unknownFields");
        return new CommitLoanResponse(loan, amount, withdrawal_description, autopaySetting, first_payment_description, paymentMethod, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CommitLoanResponse) {
            CommitLoanResponse commitLoanResponse = (CommitLoanResponse) obj;
            return m.c(unknownFields(), commitLoanResponse.unknownFields()) && m.c(this.loan, commitLoanResponse.loan) && m.c(this.withdrawal_total, commitLoanResponse.withdrawal_total) && m.c(this.withdrawal_description, commitLoanResponse.withdrawal_description) && m.c(this.autopay_setting, commitLoanResponse.autopay_setting) && m.c(this.first_payment_description, commitLoanResponse.first_payment_description) && m.c(this.withdrawal_method, commitLoanResponse.withdrawal_method);
        }
        return false;
    }

    public final AutopaySetting getAutopay_setting() {
        return this.autopay_setting;
    }

    public final String getFirst_payment_description() {
        return this.first_payment_description;
    }

    public final Loan getLoan() {
        return this.loan;
    }

    public final String getWithdrawal_description() {
        return this.withdrawal_description;
    }

    public final PaymentMethod getWithdrawal_method() {
        return this.withdrawal_method;
    }

    public final Amount getWithdrawal_total() {
        return this.withdrawal_total;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Loan loan = this.loan;
            int hashCode2 = (hashCode + (loan != null ? loan.hashCode() : 0)) * 37;
            Amount amount = this.withdrawal_total;
            int hashCode3 = (((hashCode2 + (amount != null ? amount.hashCode() : 0)) * 37) + this.withdrawal_description.hashCode()) * 37;
            AutopaySetting autopaySetting = this.autopay_setting;
            int hashCode4 = (((hashCode3 + (autopaySetting != null ? autopaySetting.hashCode() : 0)) * 37) + this.first_payment_description.hashCode()) * 37;
            PaymentMethod paymentMethod = this.withdrawal_method;
            int hashCode5 = hashCode4 + (paymentMethod != null ? paymentMethod.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m345newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.loan != null) {
            arrayList.add("loan=" + this.loan);
        }
        if (this.withdrawal_total != null) {
            arrayList.add("withdrawal_total=" + this.withdrawal_total);
        }
        arrayList.add("withdrawal_description=" + b.c(this.withdrawal_description));
        if (this.autopay_setting != null) {
            arrayList.add("autopay_setting=" + this.autopay_setting);
        }
        arrayList.add("first_payment_description=" + b.c(this.first_payment_description));
        if (this.withdrawal_method != null) {
            arrayList.add("withdrawal_method=" + this.withdrawal_method);
        }
        h0 = z.h0(arrayList, ", ", "CommitLoanResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitLoanResponse(Loan loan, Amount amount, String withdrawal_description, AutopaySetting autopaySetting, String first_payment_description, PaymentMethod paymentMethod, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(withdrawal_description, "withdrawal_description");
        m.h(first_payment_description, "first_payment_description");
        m.h(unknownFields, "unknownFields");
        this.loan = loan;
        this.withdrawal_total = amount;
        this.withdrawal_description = withdrawal_description;
        this.autopay_setting = autopaySetting;
        this.first_payment_description = first_payment_description;
        this.withdrawal_method = paymentMethod;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m345newBuilder() {
        throw new AssertionError();
    }
}