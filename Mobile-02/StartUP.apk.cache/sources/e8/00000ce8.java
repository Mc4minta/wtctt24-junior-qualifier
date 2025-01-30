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
import org.spongycastle.i18n.MessageBundle;
import org.spongycastle.i18n.TextBundle;

/* compiled from: SampleLegalAgreement.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/SampleLegalAgreement;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "subtitle", TextBundle.TEXT_ENTRY, "cta", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/SampleLegalAgreement;", "Ljava/lang/String;", "getTitle", "getText", "getCta", "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class SampleLegalAgreement extends a {
    public static final ProtoAdapter<SampleLegalAgreement> ADAPTER;
    public static final Parcelable.Creator<SampleLegalAgreement> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String cta;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String subtitle;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String text;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;

    /* compiled from: SampleLegalAgreement.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/SampleLegalAgreement$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/SampleLegalAgreement;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<SampleLegalAgreement> protoAdapter = new ProtoAdapter<SampleLegalAgreement>(c.LENGTH_DELIMITED, e0.b(SampleLegalAgreement.class), "type.googleapis.com/coinbase.public_api.authed.loans.SampleLegalAgreement") { // from class: com.coinbase.android.apiv3.generated.authed.loans.SampleLegalAgreement$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SampleLegalAgreement decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new SampleLegalAgreement(str, str2, str3, str4, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        str4 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, SampleLegalAgreement value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                if (!m.c(value.getSubtitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getSubtitle());
                }
                if (!m.c(value.getText(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getText());
                }
                if (!m.c(value.getCta(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getCta());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(SampleLegalAgreement value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle());
                if (!m.c(value.getSubtitle(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getSubtitle());
                    if (!m.c(value.getText(), "")) {
                        r2 = (m.c(value.getCta(), "") ? 0 : protoAdapter2.encodedSizeWithTag(4, value.getCta()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(3, value.getText());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public SampleLegalAgreement redact(SampleLegalAgreement value) {
                m.h(value, "value");
                return SampleLegalAgreement.copy$default(value, null, null, null, null, i.a, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public SampleLegalAgreement() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ SampleLegalAgreement(String str, String str2, String str3, String str4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ SampleLegalAgreement copy$default(SampleLegalAgreement sampleLegalAgreement, String str, String str2, String str3, String str4, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sampleLegalAgreement.title;
        }
        if ((i2 & 2) != 0) {
            str2 = sampleLegalAgreement.subtitle;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = sampleLegalAgreement.text;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = sampleLegalAgreement.cta;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            iVar = sampleLegalAgreement.unknownFields();
        }
        return sampleLegalAgreement.copy(str, str5, str6, str7, iVar);
    }

    public final SampleLegalAgreement copy(String title, String subtitle, String text, String cta, i unknownFields) {
        m.h(title, "title");
        m.h(subtitle, "subtitle");
        m.h(text, "text");
        m.h(cta, "cta");
        m.h(unknownFields, "unknownFields");
        return new SampleLegalAgreement(title, subtitle, text, cta, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SampleLegalAgreement) {
            SampleLegalAgreement sampleLegalAgreement = (SampleLegalAgreement) obj;
            return m.c(unknownFields(), sampleLegalAgreement.unknownFields()) && m.c(this.title, sampleLegalAgreement.title) && m.c(this.subtitle, sampleLegalAgreement.subtitle) && m.c(this.text, sampleLegalAgreement.text) && m.c(this.cta, sampleLegalAgreement.cta);
        }
        return false;
    }

    public final String getCta() {
        return this.cta;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.subtitle.hashCode()) * 37) + this.text.hashCode()) * 37) + this.cta.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m387newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("subtitle=" + b.c(this.subtitle));
        arrayList.add("text=" + b.c(this.text));
        arrayList.add("cta=" + b.c(this.cta));
        h0 = z.h0(arrayList, ", ", "SampleLegalAgreement{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SampleLegalAgreement(String title, String subtitle, String text, String cta, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(subtitle, "subtitle");
        m.h(text, "text");
        m.h(cta, "cta");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.subtitle = subtitle;
        this.text = text;
        this.cta = cta;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m387newBuilder() {
        throw new AssertionError();
    }
}