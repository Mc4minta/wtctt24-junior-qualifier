package com.coinbase.android.apiv3.generated.authed.card;

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

/* compiled from: GetPendingApplicationMoreInfoResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B?\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b \u0010\u000f¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetPendingApplicationMoreInfoResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "image_url", MessageBundle.TITLE_ENTRY, "paragraph", "", "Lcom/coinbase/android/apiv3/generated/authed/card/InfoItem;", "info_items", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/GetPendingApplicationMoreInfoResponse;", "Ljava/util/List;", "getInfo_items", "()Ljava/util/List;", "Ljava/lang/String;", "getParagraph", "getTitle", "getImage_url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetPendingApplicationMoreInfoResponse extends a {
    public static final ProtoAdapter<GetPendingApplicationMoreInfoResponse> ADAPTER;
    public static final Parcelable.Creator<GetPendingApplicationMoreInfoResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 1)
    private final String image_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.card.InfoItem#ADAPTER", jsonName = "infoItems", label = p.a.REPEATED, tag = 4)
    private final List<InfoItem> info_items;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String paragraph;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String title;

    /* compiled from: GetPendingApplicationMoreInfoResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetPendingApplicationMoreInfoResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetPendingApplicationMoreInfoResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetPendingApplicationMoreInfoResponse> protoAdapter = new ProtoAdapter<GetPendingApplicationMoreInfoResponse>(c.LENGTH_DELIMITED, e0.b(GetPendingApplicationMoreInfoResponse.class), "type.googleapis.com/coinbase.public_api.authed.card.GetPendingApplicationMoreInfoResponse") { // from class: com.coinbase.android.apiv3.generated.authed.card.GetPendingApplicationMoreInfoResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetPendingApplicationMoreInfoResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                String str3 = str2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetPendingApplicationMoreInfoResponse(str, str2, str3, arrayList, reader.e(d2));
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
                        arrayList.add(InfoItem.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetPendingApplicationMoreInfoResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getImage_url());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getTitle());
                }
                if (!m.c(value.getParagraph(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getParagraph());
                }
                InfoItem.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.getInfo_items());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetPendingApplicationMoreInfoResponse value) {
                m.h(value, "value");
                if (m.c(value.getImage_url(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getImage_url());
                if (!m.c(value.getTitle(), "")) {
                    r2 = (m.c(value.getParagraph(), "") ? 0 : protoAdapter2.encodedSizeWithTag(3, value.getParagraph()) + InfoItem.ADAPTER.asRepeated().encodedSizeWithTag(4, value.getInfo_items()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(2, value.getTitle());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetPendingApplicationMoreInfoResponse redact(GetPendingApplicationMoreInfoResponse value) {
                m.h(value, "value");
                return GetPendingApplicationMoreInfoResponse.copy$default(value, null, null, null, b.a(value.getInfo_items(), InfoItem.ADAPTER), i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetPendingApplicationMoreInfoResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ GetPendingApplicationMoreInfoResponse(String str, String str2, String str3, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) == 0 ? str3 : "", (i2 & 8) != 0 ? r.g() : list, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetPendingApplicationMoreInfoResponse copy$default(GetPendingApplicationMoreInfoResponse getPendingApplicationMoreInfoResponse, String str, String str2, String str3, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getPendingApplicationMoreInfoResponse.image_url;
        }
        if ((i2 & 2) != 0) {
            str2 = getPendingApplicationMoreInfoResponse.title;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = getPendingApplicationMoreInfoResponse.paragraph;
        }
        String str5 = str3;
        List<InfoItem> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = getPendingApplicationMoreInfoResponse.info_items;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            iVar = getPendingApplicationMoreInfoResponse.unknownFields();
        }
        return getPendingApplicationMoreInfoResponse.copy(str, str4, str5, list3, iVar);
    }

    public final GetPendingApplicationMoreInfoResponse copy(String image_url, String title, String paragraph, List<InfoItem> info_items, i unknownFields) {
        m.h(image_url, "image_url");
        m.h(title, "title");
        m.h(paragraph, "paragraph");
        m.h(info_items, "info_items");
        m.h(unknownFields, "unknownFields");
        return new GetPendingApplicationMoreInfoResponse(image_url, title, paragraph, info_items, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetPendingApplicationMoreInfoResponse) {
            GetPendingApplicationMoreInfoResponse getPendingApplicationMoreInfoResponse = (GetPendingApplicationMoreInfoResponse) obj;
            return m.c(unknownFields(), getPendingApplicationMoreInfoResponse.unknownFields()) && m.c(this.image_url, getPendingApplicationMoreInfoResponse.image_url) && m.c(this.title, getPendingApplicationMoreInfoResponse.title) && m.c(this.paragraph, getPendingApplicationMoreInfoResponse.paragraph) && m.c(this.info_items, getPendingApplicationMoreInfoResponse.info_items);
        }
        return false;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final List<InfoItem> getInfo_items() {
        return this.info_items;
    }

    public final String getParagraph() {
        return this.paragraph;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.image_url.hashCode()) * 37) + this.title.hashCode()) * 37) + this.paragraph.hashCode()) * 37) + this.info_items.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m309newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("paragraph=" + b.c(this.paragraph));
        if (!this.info_items.isEmpty()) {
            arrayList.add("info_items=" + this.info_items);
        }
        h0 = z.h0(arrayList, ", ", "GetPendingApplicationMoreInfoResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m309newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPendingApplicationMoreInfoResponse(String image_url, String title, String paragraph, List<InfoItem> info_items, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(image_url, "image_url");
        m.h(title, "title");
        m.h(paragraph, "paragraph");
        m.h(info_items, "info_items");
        m.h(unknownFields, "unknownFields");
        this.image_url = image_url;
        this.title = title;
        this.paragraph = paragraph;
        this.info_items = info_items;
    }
}