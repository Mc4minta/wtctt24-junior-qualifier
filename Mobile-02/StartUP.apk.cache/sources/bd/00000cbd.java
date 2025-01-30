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

/* compiled from: LoanStatement.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&BG\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJM\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatement;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "year_month", "Lcom/google/protobuf/u;", "start_date", "end_date", "currently_generating", "link", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/google/protobuf/u;Lcom/google/protobuf/u;ZLjava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatement;", "Lcom/google/protobuf/u;", "getStart_date", "()Lcom/google/protobuf/u;", "Ljava/lang/String;", "getYear_month", "getEnd_date", "getLink", "Z", "getCurrently_generating", "()Z", "<init>", "(Ljava/lang/String;Lcom/google/protobuf/u;Lcom/google/protobuf/u;ZLjava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoanStatement extends a {
    public static final ProtoAdapter<LoanStatement> ADAPTER;
    public static final Parcelable.Creator<LoanStatement> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "currentlyGenerating", tag = 4)
    private final boolean currently_generating;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "endDate", tag = 3)
    private final u end_date;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String link;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "startDate", tag = 2)
    private final u start_date;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "yearMonth", tag = 1)
    private final String year_month;

    /* compiled from: LoanStatement.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatement$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanStatement;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LoanStatement> protoAdapter = new ProtoAdapter<LoanStatement>(c.LENGTH_DELIMITED, e0.b(LoanStatement.class), "type.googleapis.com/coinbase.public_api.authed.loans.LoanStatement") { // from class: com.coinbase.android.apiv3.generated.authed.loans.LoanStatement$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoanStatement decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                u uVar = null;
                u uVar2 = null;
                String str = "";
                String str2 = str;
                boolean z = false;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoanStatement(str, uVar, uVar2, z, str2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        uVar = u.a.decode(reader);
                    } else if (g2 == 3) {
                        uVar2 = u.a.decode(reader);
                    } else if (g2 == 4) {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoanStatement value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getYear_month(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getYear_month());
                }
                if (value.getStart_date() != null) {
                    u.a.encodeWithTag(writer, 2, value.getStart_date());
                }
                if (value.getEnd_date() != null) {
                    u.a.encodeWithTag(writer, 3, value.getEnd_date());
                }
                if (value.getCurrently_generating()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 4, Boolean.valueOf(value.getCurrently_generating()));
                }
                if (!m.c(value.getLink(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getLink());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoanStatement value) {
                m.h(value, "value");
                if (m.c(value.getYear_month(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getYear_month());
                if (value.getStart_date() != null) {
                    ProtoAdapter<u> protoAdapter3 = u.a;
                    int encodedSizeWithTag2 = protoAdapter3.encodedSizeWithTag(2, value.getStart_date());
                    if (value.getEnd_date() != null) {
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, value.getEnd_date());
                        if (value.getCurrently_generating()) {
                            r2 = (m.c(value.getLink(), "") ? 0 : protoAdapter2.encodedSizeWithTag(5, value.getLink()) + value.unknownFields().Q()) + ProtoAdapter.BOOL.encodedSizeWithTag(4, Boolean.valueOf(value.getCurrently_generating()));
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoanStatement redact(LoanStatement value) {
                m.h(value, "value");
                u start_date = value.getStart_date();
                u redact = start_date != null ? u.a.redact(start_date) : null;
                u end_date = value.getEnd_date();
                return LoanStatement.copy$default(value, null, redact, end_date != null ? u.a.redact(end_date) : null, false, null, i.a, 25, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoanStatement() {
        this(null, null, null, false, null, null, 63, null);
    }

    public /* synthetic */ LoanStatement(String str, u uVar, u uVar2, boolean z, String str2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : uVar, (i2 & 4) == 0 ? uVar2 : null, (i2 & 8) != 0 ? false : z, (i2 & 16) == 0 ? str2 : "", (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoanStatement copy$default(LoanStatement loanStatement, String str, u uVar, u uVar2, boolean z, String str2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loanStatement.year_month;
        }
        if ((i2 & 2) != 0) {
            uVar = loanStatement.start_date;
        }
        u uVar3 = uVar;
        if ((i2 & 4) != 0) {
            uVar2 = loanStatement.end_date;
        }
        u uVar4 = uVar2;
        if ((i2 & 8) != 0) {
            z = loanStatement.currently_generating;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            str2 = loanStatement.link;
        }
        String str3 = str2;
        if ((i2 & 32) != 0) {
            iVar = loanStatement.unknownFields();
        }
        return loanStatement.copy(str, uVar3, uVar4, z2, str3, iVar);
    }

    public final LoanStatement copy(String year_month, u uVar, u uVar2, boolean z, String link, i unknownFields) {
        m.h(year_month, "year_month");
        m.h(link, "link");
        m.h(unknownFields, "unknownFields");
        return new LoanStatement(year_month, uVar, uVar2, z, link, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoanStatement) {
            LoanStatement loanStatement = (LoanStatement) obj;
            return m.c(unknownFields(), loanStatement.unknownFields()) && m.c(this.year_month, loanStatement.year_month) && m.c(this.start_date, loanStatement.start_date) && m.c(this.end_date, loanStatement.end_date) && this.currently_generating == loanStatement.currently_generating && m.c(this.link, loanStatement.link);
        }
        return false;
    }

    public final boolean getCurrently_generating() {
        return this.currently_generating;
    }

    public final u getEnd_date() {
        return this.end_date;
    }

    public final String getLink() {
        return this.link;
    }

    public final u getStart_date() {
        return this.start_date;
    }

    public final String getYear_month() {
        return this.year_month;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.year_month.hashCode()) * 37;
            u uVar = this.start_date;
            int hashCode2 = (hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37;
            u uVar2 = this.end_date;
            int hashCode3 = ((((hashCode2 + (uVar2 != null ? uVar2.hashCode() : 0)) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.currently_generating)) * 37) + this.link.hashCode();
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m374newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("year_month=" + b.c(this.year_month));
        if (this.start_date != null) {
            arrayList.add("start_date=" + this.start_date);
        }
        if (this.end_date != null) {
            arrayList.add("end_date=" + this.end_date);
        }
        arrayList.add("currently_generating=" + this.currently_generating);
        arrayList.add("link=" + b.c(this.link));
        h0 = z.h0(arrayList, ", ", "LoanStatement{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoanStatement(String year_month, u uVar, u uVar2, boolean z, String link, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(year_month, "year_month");
        m.h(link, "link");
        m.h(unknownFields, "unknownFields");
        this.year_month = year_month;
        this.start_date = uVar;
        this.end_date = uVar2;
        this.currently_generating = z;
        this.link = link;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m374newBuilder() {
        throw new AssertionError();
    }
}