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
import org.spongycastle.i18n.MessageBundle;

/* compiled from: LegalAgreementSummary.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B;\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LegalAgreementSummary;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "", "bullets", "Lcom/coinbase/android/apiv3/generated/authed/loans/SummaryBullet;", "bullet_details", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/LegalAgreementSummary;", "Ljava/util/List;", "getBullet_details", "()Ljava/util/List;", "getBullets", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LegalAgreementSummary extends a {
    public static final ProtoAdapter<LegalAgreementSummary> ADAPTER;
    public static final Parcelable.Creator<LegalAgreementSummary> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loans.SummaryBullet#ADAPTER", jsonName = "bulletDetails", label = p.a.REPEATED, tag = 3)
    private final List<SummaryBullet> bullet_details;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = p.a.REPEATED, tag = 2)
    private final List<String> bullets;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;

    /* compiled from: LegalAgreementSummary.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LegalAgreementSummary$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LegalAgreementSummary;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LegalAgreementSummary> protoAdapter = new ProtoAdapter<LegalAgreementSummary>(c.LENGTH_DELIMITED, e0.b(LegalAgreementSummary.class), "type.googleapis.com/coinbase.public_api.authed.loans.LegalAgreementSummary") { // from class: com.coinbase.android.apiv3.generated.authed.loans.LegalAgreementSummary$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LegalAgreementSummary decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LegalAgreementSummary(str, arrayList, arrayList2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        arrayList.add(ProtoAdapter.STRING.decode(reader));
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        arrayList2.add(SummaryBullet.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LegalAgreementSummary value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 2, value.getBullets());
                SummaryBullet.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.getBullet_details());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LegalAgreementSummary value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return value.unknownFields().Q() + protoAdapter2.encodedSizeWithTag(1, value.getTitle()) + protoAdapter2.asRepeated().encodedSizeWithTag(2, value.getBullets()) + SummaryBullet.ADAPTER.asRepeated().encodedSizeWithTag(3, value.getBullet_details());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LegalAgreementSummary redact(LegalAgreementSummary value) {
                m.h(value, "value");
                return LegalAgreementSummary.copy$default(value, null, null, b.a(value.getBullet_details(), SummaryBullet.ADAPTER), i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LegalAgreementSummary() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ LegalAgreementSummary(String str, List list, List list2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? r.g() : list2, (i2 & 8) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LegalAgreementSummary copy$default(LegalAgreementSummary legalAgreementSummary, String str, List list, List list2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = legalAgreementSummary.title;
        }
        if ((i2 & 2) != 0) {
            list = legalAgreementSummary.bullets;
        }
        if ((i2 & 4) != 0) {
            list2 = legalAgreementSummary.bullet_details;
        }
        if ((i2 & 8) != 0) {
            iVar = legalAgreementSummary.unknownFields();
        }
        return legalAgreementSummary.copy(str, list, list2, iVar);
    }

    public final LegalAgreementSummary copy(String title, List<String> bullets, List<SummaryBullet> bullet_details, i unknownFields) {
        m.h(title, "title");
        m.h(bullets, "bullets");
        m.h(bullet_details, "bullet_details");
        m.h(unknownFields, "unknownFields");
        return new LegalAgreementSummary(title, bullets, bullet_details, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LegalAgreementSummary) {
            LegalAgreementSummary legalAgreementSummary = (LegalAgreementSummary) obj;
            return m.c(unknownFields(), legalAgreementSummary.unknownFields()) && m.c(this.title, legalAgreementSummary.title) && m.c(this.bullets, legalAgreementSummary.bullets) && m.c(this.bullet_details, legalAgreementSummary.bullet_details);
        }
        return false;
    }

    public final List<SummaryBullet> getBullet_details() {
        return this.bullet_details;
    }

    public final List<String> getBullets() {
        return this.bullets;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.bullets.hashCode()) * 37) + this.bullet_details.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m370newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        if (!this.bullets.isEmpty()) {
            arrayList.add("bullets=" + b.d(this.bullets));
        }
        if (!this.bullet_details.isEmpty()) {
            arrayList.add("bullet_details=" + this.bullet_details);
        }
        h0 = z.h0(arrayList, ", ", "LegalAgreementSummary{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m370newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegalAgreementSummary(String title, List<String> bullets, List<SummaryBullet> bullet_details, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(bullets, "bullets");
        m.h(bullet_details, "bullet_details");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.bullets = bullets;
        this.bullet_details = bullet_details;
    }
}