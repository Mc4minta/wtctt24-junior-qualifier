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

/* compiled from: GetCardIntroductionMessagesResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B?\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001f\u0010\u000f¨\u0006#"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIntroductionMessagesResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "image_url", MessageBundle.TITLE_ENTRY, "", "bullet_points", "action_text", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIntroductionMessagesResponse;", "Ljava/util/List;", "getBullet_points", "()Ljava/util/List;", "Ljava/lang/String;", "getImage_url", "getAction_text", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetCardIntroductionMessagesResponse extends a {
    public static final ProtoAdapter<GetCardIntroductionMessagesResponse> ADAPTER;
    public static final Parcelable.Creator<GetCardIntroductionMessagesResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "actionText", tag = 4)
    private final String action_text;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "bulletPoints", label = p.a.REPEATED, tag = 3)
    private final List<String> bullet_points;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 1)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String title;

    /* compiled from: GetCardIntroductionMessagesResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIntroductionMessagesResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetCardIntroductionMessagesResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetCardIntroductionMessagesResponse> protoAdapter = new ProtoAdapter<GetCardIntroductionMessagesResponse>(c.LENGTH_DELIMITED, e0.b(GetCardIntroductionMessagesResponse.class), "type.googleapis.com/coinbase.public_api.authed.card.GetCardIntroductionMessagesResponse") { // from class: com.coinbase.android.apiv3.generated.authed.card.GetCardIntroductionMessagesResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetCardIntroductionMessagesResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                String str3 = str2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetCardIntroductionMessagesResponse(str, str2, arrayList, str3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        arrayList.add(ProtoAdapter.STRING.decode(reader));
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetCardIntroductionMessagesResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getImage_url());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getTitle());
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.asRepeated().encodeWithTag(writer, 3, value.getBullet_points());
                if (!m.c(value.getAction_text(), "")) {
                    protoAdapter2.encodeWithTag(writer, 4, value.getAction_text());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetCardIntroductionMessagesResponse value) {
                m.h(value, "value");
                if (m.c(value.getImage_url(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getImage_url());
                if (!m.c(value.getTitle(), "")) {
                    r2 = (m.c(value.getAction_text(), "") ? 0 : protoAdapter2.encodedSizeWithTag(4, value.getAction_text()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(2, value.getTitle()) + protoAdapter2.asRepeated().encodedSizeWithTag(3, value.getBullet_points());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetCardIntroductionMessagesResponse redact(GetCardIntroductionMessagesResponse value) {
                m.h(value, "value");
                return GetCardIntroductionMessagesResponse.copy$default(value, null, null, null, null, i.a, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetCardIntroductionMessagesResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ GetCardIntroductionMessagesResponse(String str, String str2, List list, String str3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? r.g() : list, (i2 & 8) == 0 ? str3 : "", (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetCardIntroductionMessagesResponse copy$default(GetCardIntroductionMessagesResponse getCardIntroductionMessagesResponse, String str, String str2, List list, String str3, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getCardIntroductionMessagesResponse.image_url;
        }
        if ((i2 & 2) != 0) {
            str2 = getCardIntroductionMessagesResponse.title;
        }
        String str4 = str2;
        List<String> list2 = list;
        if ((i2 & 4) != 0) {
            list2 = getCardIntroductionMessagesResponse.bullet_points;
        }
        List list3 = list2;
        if ((i2 & 8) != 0) {
            str3 = getCardIntroductionMessagesResponse.action_text;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            iVar = getCardIntroductionMessagesResponse.unknownFields();
        }
        return getCardIntroductionMessagesResponse.copy(str, str4, list3, str5, iVar);
    }

    public final GetCardIntroductionMessagesResponse copy(String image_url, String title, List<String> bullet_points, String action_text, i unknownFields) {
        m.h(image_url, "image_url");
        m.h(title, "title");
        m.h(bullet_points, "bullet_points");
        m.h(action_text, "action_text");
        m.h(unknownFields, "unknownFields");
        return new GetCardIntroductionMessagesResponse(image_url, title, bullet_points, action_text, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetCardIntroductionMessagesResponse) {
            GetCardIntroductionMessagesResponse getCardIntroductionMessagesResponse = (GetCardIntroductionMessagesResponse) obj;
            return m.c(unknownFields(), getCardIntroductionMessagesResponse.unknownFields()) && m.c(this.image_url, getCardIntroductionMessagesResponse.image_url) && m.c(this.title, getCardIntroductionMessagesResponse.title) && m.c(this.bullet_points, getCardIntroductionMessagesResponse.bullet_points) && m.c(this.action_text, getCardIntroductionMessagesResponse.action_text);
        }
        return false;
    }

    public final String getAction_text() {
        return this.action_text;
    }

    public final List<String> getBullet_points() {
        return this.bullet_points;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.image_url.hashCode()) * 37) + this.title.hashCode()) * 37) + this.bullet_points.hashCode()) * 37) + this.action_text.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m303newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("title=" + b.c(this.title));
        if (!this.bullet_points.isEmpty()) {
            arrayList.add("bullet_points=" + b.d(this.bullet_points));
        }
        arrayList.add("action_text=" + b.c(this.action_text));
        h0 = z.h0(arrayList, ", ", "GetCardIntroductionMessagesResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m303newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCardIntroductionMessagesResponse(String image_url, String title, List<String> bullet_points, String action_text, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(image_url, "image_url");
        m.h(title, "title");
        m.h(bullet_points, "bullet_points");
        m.h(action_text, "action_text");
        m.h(unknownFields, "unknownFields");
        this.image_url = image_url;
        this.title = title;
        this.bullet_points = bullet_points;
        this.action_text = action_text;
    }
}