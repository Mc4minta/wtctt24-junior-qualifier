package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PageDescription;
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

/* compiled from: GetLoanEventsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B-\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanEventsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanEvent;", "loan_events", "Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "page_description", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/PageDescription;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanEventsResponse;", "Ljava/util/List;", "getLoan_events", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "getPage_description", "()Lcom/coinbase/android/apiv3/generated/common/PageDescription;", "<init>", "(Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/PageDescription;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetLoanEventsResponse extends a {
    public static final ProtoAdapter<GetLoanEventsResponse> ADAPTER;
    public static final Parcelable.Creator<GetLoanEventsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.LoanEvent#ADAPTER", jsonName = "loanEvents", label = p.a.REPEATED, tag = 1)
    private final List<LoanEvent> loan_events;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PageDescription#ADAPTER", jsonName = "pageDescription", tag = 2)
    private final PageDescription page_description;

    /* compiled from: GetLoanEventsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanEventsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetLoanEventsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetLoanEventsResponse> protoAdapter = new ProtoAdapter<GetLoanEventsResponse>(c.LENGTH_DELIMITED, e0.b(GetLoanEventsResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.GetLoanEventsResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.GetLoanEventsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetLoanEventsResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                PageDescription pageDescription = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetLoanEventsResponse(arrayList, pageDescription, reader.e(d2));
                    }
                    if (g2 == 1) {
                        arrayList.add(LoanEvent.ADAPTER.decode(reader));
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        pageDescription = PageDescription.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetLoanEventsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                LoanEvent.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getLoan_events());
                if (value.getPage_description() != null) {
                    PageDescription.ADAPTER.encodeWithTag(writer, 2, value.getPage_description());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetLoanEventsResponse value) {
                int Q;
                m.h(value, "value");
                int encodedSizeWithTag = LoanEvent.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getLoan_events());
                if (value.getPage_description() == null) {
                    Q = 0;
                } else {
                    Q = value.unknownFields().Q() + PageDescription.ADAPTER.encodedSizeWithTag(2, value.getPage_description());
                }
                return encodedSizeWithTag + Q;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetLoanEventsResponse redact(GetLoanEventsResponse value) {
                m.h(value, "value");
                List<LoanEvent> a = b.a(value.getLoan_events(), LoanEvent.ADAPTER);
                PageDescription page_description = value.getPage_description();
                return value.copy(a, page_description != null ? PageDescription.ADAPTER.redact(page_description) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetLoanEventsResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetLoanEventsResponse(List list, PageDescription pageDescription, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? null : pageDescription, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetLoanEventsResponse copy$default(GetLoanEventsResponse getLoanEventsResponse, List list, PageDescription pageDescription, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = getLoanEventsResponse.loan_events;
        }
        if ((i2 & 2) != 0) {
            pageDescription = getLoanEventsResponse.page_description;
        }
        if ((i2 & 4) != 0) {
            iVar = getLoanEventsResponse.unknownFields();
        }
        return getLoanEventsResponse.copy(list, pageDescription, iVar);
    }

    public final GetLoanEventsResponse copy(List<LoanEvent> loan_events, PageDescription pageDescription, i unknownFields) {
        m.h(loan_events, "loan_events");
        m.h(unknownFields, "unknownFields");
        return new GetLoanEventsResponse(loan_events, pageDescription, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetLoanEventsResponse) {
            GetLoanEventsResponse getLoanEventsResponse = (GetLoanEventsResponse) obj;
            return m.c(unknownFields(), getLoanEventsResponse.unknownFields()) && m.c(this.loan_events, getLoanEventsResponse.loan_events) && m.c(this.page_description, getLoanEventsResponse.page_description);
        }
        return false;
    }

    public final List<LoanEvent> getLoan_events() {
        return this.loan_events;
    }

    public final PageDescription getPage_description() {
        return this.page_description;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.loan_events.hashCode()) * 37;
            PageDescription pageDescription = this.page_description;
            int hashCode2 = hashCode + (pageDescription != null ? pageDescription.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m361newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.loan_events.isEmpty()) {
            arrayList.add("loan_events=" + this.loan_events);
        }
        if (this.page_description != null) {
            arrayList.add("page_description=" + this.page_description);
        }
        h0 = z.h0(arrayList, ", ", "GetLoanEventsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m361newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLoanEventsResponse(List<LoanEvent> loan_events, PageDescription pageDescription, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(loan_events, "loan_events");
        m.h(unknownFields, "unknownFields");
        this.loan_events = loan_events;
        this.page_description = pageDescription;
    }
}