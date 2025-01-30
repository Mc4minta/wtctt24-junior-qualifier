package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
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

/* compiled from: GetLoanDocumentsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB1\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanDocumentsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanAgreement;", "loan_agreements", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatement;", "loan_statements", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanDocumentsResponse;", "Ljava/util/List;", "getLoan_statements", "()Ljava/util/List;", "getLoan_agreements", "<init>", "(Ljava/util/List;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetLoanDocumentsResponse extends a {
    public static final ProtoAdapter<GetLoanDocumentsResponse> ADAPTER;
    public static final Parcelable.Creator<GetLoanDocumentsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanAgreement#ADAPTER", jsonName = "loanAgreements", label = p.a.REPEATED, tag = 1)
    private final List<LoanAgreement> loan_agreements;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanStatement#ADAPTER", jsonName = "loanStatements", label = p.a.REPEATED, tag = 2)
    private final List<LoanStatement> loan_statements;

    /* compiled from: GetLoanDocumentsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanDocumentsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanDocumentsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetLoanDocumentsResponse> protoAdapter = new ProtoAdapter<GetLoanDocumentsResponse>(c.LENGTH_DELIMITED, e0.b(GetLoanDocumentsResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.GetLoanDocumentsResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.GetLoanDocumentsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetLoanDocumentsResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                long d2 = reader.d();
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetLoanDocumentsResponse(arrayList, arrayList2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        arrayList.add(LoanAgreement.ADAPTER.decode(reader));
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        arrayList2.add(LoanStatement.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetLoanDocumentsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                LoanAgreement.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getLoan_agreements());
                LoanStatement.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getLoan_statements());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetLoanDocumentsResponse value) {
                m.h(value, "value");
                return LoanAgreement.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getLoan_agreements()) + LoanStatement.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getLoan_statements()) + value.unknownFields().Q();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetLoanDocumentsResponse redact(GetLoanDocumentsResponse value) {
                m.h(value, "value");
                return value.copy(b.a(value.getLoan_agreements(), LoanAgreement.ADAPTER), b.a(value.getLoan_statements(), LoanStatement.ADAPTER), i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetLoanDocumentsResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetLoanDocumentsResponse(List list, List list2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? r.g() : list2, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetLoanDocumentsResponse copy$default(GetLoanDocumentsResponse getLoanDocumentsResponse, List list, List list2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = getLoanDocumentsResponse.loan_agreements;
        }
        if ((i2 & 2) != 0) {
            list2 = getLoanDocumentsResponse.loan_statements;
        }
        if ((i2 & 4) != 0) {
            iVar = getLoanDocumentsResponse.unknownFields();
        }
        return getLoanDocumentsResponse.copy(list, list2, iVar);
    }

    public final GetLoanDocumentsResponse copy(List<LoanAgreement> loan_agreements, List<LoanStatement> loan_statements, i unknownFields) {
        m.h(loan_agreements, "loan_agreements");
        m.h(loan_statements, "loan_statements");
        m.h(unknownFields, "unknownFields");
        return new GetLoanDocumentsResponse(loan_agreements, loan_statements, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetLoanDocumentsResponse) {
            GetLoanDocumentsResponse getLoanDocumentsResponse = (GetLoanDocumentsResponse) obj;
            return m.c(unknownFields(), getLoanDocumentsResponse.unknownFields()) && m.c(this.loan_agreements, getLoanDocumentsResponse.loan_agreements) && m.c(this.loan_statements, getLoanDocumentsResponse.loan_statements);
        }
        return false;
    }

    public final List<LoanAgreement> getLoan_agreements() {
        return this.loan_agreements;
    }

    public final List<LoanStatement> getLoan_statements() {
        return this.loan_statements;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.loan_agreements.hashCode()) * 37) + this.loan_statements.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m359newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.loan_agreements.isEmpty()) {
            arrayList.add("loan_agreements=" + this.loan_agreements);
        }
        if (!this.loan_statements.isEmpty()) {
            arrayList.add("loan_statements=" + this.loan_statements);
        }
        h0 = z.h0(arrayList, ", ", "GetLoanDocumentsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m359newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLoanDocumentsResponse(List<LoanAgreement> loan_agreements, List<LoanStatement> loan_statements, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(loan_agreements, "loan_agreements");
        m.h(loan_statements, "loan_statements");
        m.h(unknownFields, "unknownFields");
        this.loan_agreements = loan_agreements;
        this.loan_statements = loan_statements;
    }
}