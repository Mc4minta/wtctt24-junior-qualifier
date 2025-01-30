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

/* compiled from: LoanInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanInfo;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, TextBundle.TEXT_ENTRY, "icon_url", "cta", "secondary_cta", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/LoanInfo;", "Ljava/lang/String;", "getSecondary_cta", "getText", "getTitle", "getCta", "getIcon_url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoanInfo extends a {
    public static final ProtoAdapter<LoanInfo> ADAPTER;
    public static final Parcelable.Creator<LoanInfo> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String cta;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", tag = 3)
    private final String icon_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "secondaryCta", tag = 5)
    private final String secondary_cta;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String text;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;

    /* compiled from: LoanInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/LoanInfo$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/LoanInfo;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LoanInfo> protoAdapter = new ProtoAdapter<LoanInfo>(c.LENGTH_DELIMITED, e0.b(LoanInfo.class), "type.googleapis.com/coinbase.public_api.authed.loans.LoanInfo") { // from class: com.coinbase.android.apiv3.generated.authed.loans.LoanInfo$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoanInfo decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoanInfo(str, str2, str3, str4, str5, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 4) {
                        str4 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        str5 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoanInfo value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                if (!m.c(value.getText(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getText());
                }
                if (!m.c(value.getIcon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getIcon_url());
                }
                if (!m.c(value.getCta(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getCta());
                }
                if (!m.c(value.getSecondary_cta(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getSecondary_cta());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoanInfo value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle());
                if (!m.c(value.getText(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getText());
                    if (!m.c(value.getIcon_url(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getIcon_url());
                        if (!m.c(value.getCta(), "")) {
                            r2 = (m.c(value.getSecondary_cta(), "") ? 0 : protoAdapter2.encodedSizeWithTag(5, value.getSecondary_cta()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(4, value.getCta());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoanInfo redact(LoanInfo value) {
                m.h(value, "value");
                return LoanInfo.copy$default(value, null, null, null, null, null, i.a, 31, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoanInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ LoanInfo(String str, String str2, String str3, String str4, String str5, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoanInfo copy$default(LoanInfo loanInfo, String str, String str2, String str3, String str4, String str5, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loanInfo.title;
        }
        if ((i2 & 2) != 0) {
            str2 = loanInfo.text;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = loanInfo.icon_url;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = loanInfo.cta;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = loanInfo.secondary_cta;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            iVar = loanInfo.unknownFields();
        }
        return loanInfo.copy(str, str6, str7, str8, str9, iVar);
    }

    public final LoanInfo copy(String title, String text, String icon_url, String cta, String secondary_cta, i unknownFields) {
        m.h(title, "title");
        m.h(text, "text");
        m.h(icon_url, "icon_url");
        m.h(cta, "cta");
        m.h(secondary_cta, "secondary_cta");
        m.h(unknownFields, "unknownFields");
        return new LoanInfo(title, text, icon_url, cta, secondary_cta, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoanInfo) {
            LoanInfo loanInfo = (LoanInfo) obj;
            return m.c(unknownFields(), loanInfo.unknownFields()) && m.c(this.title, loanInfo.title) && m.c(this.text, loanInfo.text) && m.c(this.icon_url, loanInfo.icon_url) && m.c(this.cta, loanInfo.cta) && m.c(this.secondary_cta, loanInfo.secondary_cta);
        }
        return false;
    }

    public final String getCta() {
        return this.cta;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getSecondary_cta() {
        return this.secondary_cta;
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
            int hashCode = (((((((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.text.hashCode()) * 37) + this.icon_url.hashCode()) * 37) + this.cta.hashCode()) * 37) + this.secondary_cta.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m373newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("text=" + b.c(this.text));
        arrayList.add("icon_url=" + b.c(this.icon_url));
        arrayList.add("cta=" + b.c(this.cta));
        arrayList.add("secondary_cta=" + b.c(this.secondary_cta));
        h0 = z.h0(arrayList, ", ", "LoanInfo{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoanInfo(String title, String text, String icon_url, String cta, String secondary_cta, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(text, "text");
        m.h(icon_url, "icon_url");
        m.h(cta, "cta");
        m.h(secondary_cta, "secondary_cta");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.text = text;
        this.icon_url = icon_url;
        this.cta = cta;
        this.secondary_cta = secondary_cta;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m373newBuilder() {
        throw new AssertionError();
    }
}