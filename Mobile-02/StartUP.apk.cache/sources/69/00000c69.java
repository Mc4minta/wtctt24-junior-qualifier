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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: CreateLoanRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "quote_id", "withdrawal_method_id", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanRequest;", "Ljava/lang/String;", "getQuote_id", "getWithdrawal_method_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CreateLoanRequest extends a {
    public static final ProtoAdapter<CreateLoanRequest> ADAPTER;
    public static final Parcelable.Creator<CreateLoanRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "quoteId", tag = 1)
    private final String quote_id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "withdrawalMethodId", tag = 2)
    private final String withdrawal_method_id;

    /* compiled from: CreateLoanRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/CreateLoanRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<CreateLoanRequest> protoAdapter = new ProtoAdapter<CreateLoanRequest>(c.LENGTH_DELIMITED, e0.b(CreateLoanRequest.class), "type.googleapis.com/coinbase.public_api.authed.loans.CreateLoanRequest") { // from class: com.coinbase.android.apiv3.generated.authed.loans.CreateLoanRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CreateLoanRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new CreateLoanRequest(str, str2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, CreateLoanRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getQuote_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getQuote_id());
                }
                if (!m.c(value.getWithdrawal_method_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getWithdrawal_method_id());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(CreateLoanRequest value) {
                m.h(value, "value");
                if (m.c(value.getQuote_id(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return (m.c(value.getWithdrawal_method_id(), "") ? 0 : protoAdapter2.encodedSizeWithTag(2, value.getWithdrawal_method_id()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(1, value.getQuote_id());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public CreateLoanRequest redact(CreateLoanRequest value) {
                m.h(value, "value");
                return CreateLoanRequest.copy$default(value, null, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public CreateLoanRequest() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ CreateLoanRequest(String str, String str2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ CreateLoanRequest copy$default(CreateLoanRequest createLoanRequest, String str, String str2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = createLoanRequest.quote_id;
        }
        if ((i2 & 2) != 0) {
            str2 = createLoanRequest.withdrawal_method_id;
        }
        if ((i2 & 4) != 0) {
            iVar = createLoanRequest.unknownFields();
        }
        return createLoanRequest.copy(str, str2, iVar);
    }

    public final CreateLoanRequest copy(String quote_id, String withdrawal_method_id, i unknownFields) {
        m.h(quote_id, "quote_id");
        m.h(withdrawal_method_id, "withdrawal_method_id");
        m.h(unknownFields, "unknownFields");
        return new CreateLoanRequest(quote_id, withdrawal_method_id, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CreateLoanRequest) {
            CreateLoanRequest createLoanRequest = (CreateLoanRequest) obj;
            return m.c(unknownFields(), createLoanRequest.unknownFields()) && m.c(this.quote_id, createLoanRequest.quote_id) && m.c(this.withdrawal_method_id, createLoanRequest.withdrawal_method_id);
        }
        return false;
    }

    public final String getQuote_id() {
        return this.quote_id;
    }

    public final String getWithdrawal_method_id() {
        return this.withdrawal_method_id;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.quote_id.hashCode()) * 37) + this.withdrawal_method_id.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m348newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("quote_id=" + b.c(this.quote_id));
        arrayList.add("withdrawal_method_id=" + b.c(this.withdrawal_method_id));
        h0 = z.h0(arrayList, ", ", "CreateLoanRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateLoanRequest(String quote_id, String withdrawal_method_id, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(quote_id, "quote_id");
        m.h(withdrawal_method_id, "withdrawal_method_id");
        m.h(unknownFields, "unknownFields");
        this.quote_id = quote_id;
        this.withdrawal_method_id = withdrawal_method_id;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m348newBuilder() {
        throw new AssertionError();
    }
}