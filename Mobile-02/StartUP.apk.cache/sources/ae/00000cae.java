package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: LoanAgreement.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB'\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanAgreement;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/google/protobuf/u;", "date", "link", "Lj/i;", "unknownFields", "copy", "(Lcom/google/protobuf/u;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/LoanAgreement;", "Lcom/google/protobuf/u;", "getDate", "()Lcom/google/protobuf/u;", "Ljava/lang/String;", "getLink", "<init>", "(Lcom/google/protobuf/u;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoanAgreement extends a {
    public static final ProtoAdapter<LoanAgreement> ADAPTER;
    public static final Parcelable.Creator<LoanAgreement> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", tag = 1)
    private final u date;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String link;

    /* compiled from: LoanAgreement.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanAgreement$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanAgreement;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LoanAgreement> protoAdapter = new ProtoAdapter<LoanAgreement>(c.LENGTH_DELIMITED, e0.b(LoanAgreement.class), "type.googleapis.com/coinbase.public_api.authed.loans.LoanAgreement") { // from class: com.coinbase.android.apiv3.generated.authed.loans.LoanAgreement$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoanAgreement decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                u uVar = null;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoanAgreement(uVar, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        uVar = u.a.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoanAgreement value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getDate() != null) {
                    u.a.encodeWithTag(writer, 1, value.getDate());
                }
                if (!m.c(value.getLink(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getLink());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoanAgreement value) {
                m.h(value, "value");
                if (value.getDate() == null) {
                    return 0;
                }
                return (m.c(value.getLink(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(2, value.getLink()) + value.unknownFields().Q()) + u.a.encodedSizeWithTag(1, value.getDate());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoanAgreement redact(LoanAgreement value) {
                m.h(value, "value");
                u date = value.getDate();
                return LoanAgreement.copy$default(value, date != null ? u.a.redact(date) : null, null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoanAgreement() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ LoanAgreement(u uVar, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : uVar, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoanAgreement copy$default(LoanAgreement loanAgreement, u uVar, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uVar = loanAgreement.date;
        }
        if ((i2 & 2) != 0) {
            str = loanAgreement.link;
        }
        if ((i2 & 4) != 0) {
            iVar = loanAgreement.unknownFields();
        }
        return loanAgreement.copy(uVar, str, iVar);
    }

    public final LoanAgreement copy(u uVar, String link, i unknownFields) {
        m.h(link, "link");
        m.h(unknownFields, "unknownFields");
        return new LoanAgreement(uVar, link, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoanAgreement) {
            LoanAgreement loanAgreement = (LoanAgreement) obj;
            return m.c(unknownFields(), loanAgreement.unknownFields()) && m.c(this.date, loanAgreement.date) && m.c(this.link, loanAgreement.link);
        }
        return false;
    }

    public final u getDate() {
        return this.date;
    }

    public final String getLink() {
        return this.link;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            u uVar = this.date;
            int hashCode2 = ((hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.link.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m371newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.date != null) {
            arrayList.add("date=" + this.date);
        }
        arrayList.add("link=" + b.c(this.link));
        h0 = z.h0(arrayList, ", ", "LoanAgreement{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoanAgreement(u uVar, String link, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(link, "link");
        m.h(unknownFields, "unknownFields");
        this.date = uVar;
        this.link = link;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m371newBuilder() {
        throw new AssertionError();
    }
}