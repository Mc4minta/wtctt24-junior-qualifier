package com.coinbase.android.apiv3.generated.authed.loyalty;

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

/* compiled from: LoyaltyTable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'BI\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b#\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b$\u0010\u000f¨\u0006("}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTable;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "url", "url_text", "", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTableSection;", "sections", "collapsible", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTable;", "Ljava/lang/String;", "getUrl", "Z", "getCollapsible", "()Z", "Ljava/util/List;", "getSections", "()Ljava/util/List;", "getUrl_text", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoyaltyTable extends a {
    public static final ProtoAdapter<LoyaltyTable> ADAPTER;
    public static final Parcelable.Creator<LoyaltyTable> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    private final boolean collapsible;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyTableSection#ADAPTER", label = p.a.REPEATED, tag = 4)
    private final List<LoyaltyTableSection> sections;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "urlText", tag = 3)
    private final String url_text;

    /* compiled from: LoyaltyTable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTable$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTable;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LoyaltyTable> protoAdapter = new ProtoAdapter<LoyaltyTable>(c.LENGTH_DELIMITED, e0.b(LoyaltyTable.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.LoyaltyTable") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyTable$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyTable decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                boolean z = false;
                String str3 = str2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoyaltyTable(str, str3, str2, arrayList, z, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 4) {
                        arrayList.add(LoyaltyTableSection.ADAPTER.decode(reader));
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoyaltyTable value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getUrl());
                }
                if (!m.c(value.getUrl_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getUrl_text());
                }
                LoyaltyTableSection.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.getSections());
                if (value.getCollapsible()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 5, Boolean.valueOf(value.getCollapsible()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoyaltyTable value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle());
                if (!m.c(value.getUrl(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getUrl());
                    if (!m.c(value.getUrl_text(), "")) {
                        r2 = (value.getCollapsible() ? ProtoAdapter.BOOL.encodedSizeWithTag(5, Boolean.valueOf(value.getCollapsible())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(3, value.getUrl_text()) + LoyaltyTableSection.ADAPTER.asRepeated().encodedSizeWithTag(4, value.getSections());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyTable redact(LoyaltyTable value) {
                m.h(value, "value");
                return LoyaltyTable.copy$default(value, null, null, null, b.a(value.getSections(), LoyaltyTableSection.ADAPTER), false, i.a, 23, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoyaltyTable() {
        this(null, null, null, null, false, null, 63, null);
    }

    public /* synthetic */ LoyaltyTable(String str, String str2, String str3, List list, boolean z, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) == 0 ? str3 : "", (i2 & 8) != 0 ? r.g() : list, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoyaltyTable copy$default(LoyaltyTable loyaltyTable, String str, String str2, String str3, List list, boolean z, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loyaltyTable.title;
        }
        if ((i2 & 2) != 0) {
            str2 = loyaltyTable.url;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = loyaltyTable.url_text;
        }
        String str5 = str3;
        List<LoyaltyTableSection> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = loyaltyTable.sections;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            z = loyaltyTable.collapsible;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            iVar = loyaltyTable.unknownFields();
        }
        return loyaltyTable.copy(str, str4, str5, list3, z2, iVar);
    }

    public final LoyaltyTable copy(String title, String url, String url_text, List<LoyaltyTableSection> sections, boolean z, i unknownFields) {
        m.h(title, "title");
        m.h(url, "url");
        m.h(url_text, "url_text");
        m.h(sections, "sections");
        m.h(unknownFields, "unknownFields");
        return new LoyaltyTable(title, url, url_text, sections, z, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoyaltyTable) {
            LoyaltyTable loyaltyTable = (LoyaltyTable) obj;
            return m.c(unknownFields(), loyaltyTable.unknownFields()) && m.c(this.title, loyaltyTable.title) && m.c(this.url, loyaltyTable.url) && m.c(this.url_text, loyaltyTable.url_text) && m.c(this.sections, loyaltyTable.sections) && this.collapsible == loyaltyTable.collapsible;
        }
        return false;
    }

    public final boolean getCollapsible() {
        return this.collapsible;
    }

    public final List<LoyaltyTableSection> getSections() {
        return this.sections;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrl_text() {
        return this.url_text;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.url.hashCode()) * 37) + this.url_text.hashCode()) * 37) + this.sections.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.collapsible);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m416newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("url=" + b.c(this.url));
        arrayList.add("url_text=" + b.c(this.url_text));
        if (!this.sections.isEmpty()) {
            arrayList.add("sections=" + this.sections);
        }
        arrayList.add("collapsible=" + this.collapsible);
        h0 = z.h0(arrayList, ", ", "LoyaltyTable{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m416newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoyaltyTable(String title, String url, String url_text, List<LoyaltyTableSection> sections, boolean z, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(url, "url");
        m.h(url_text, "url_text");
        m.h(sections, "sections");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.url = url;
        this.url_text = url_text;
        this.sections = sections;
        this.collapsible = z;
    }
}