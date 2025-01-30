package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Button;
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
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: EarnInviteLesson.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*Be\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJk\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b \u0010\u000fR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b$\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b%\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b&\u0010\u000fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b'\u0010\u000f¨\u0006+"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnInviteLesson;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "image_url", MessageBundle.TITLE_ENTRY, "body", "display_url", "url", "terms_url", "Lcom/coinbase/android/apiv3/generated/common/Button;", "button", "label", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Button;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnInviteLesson;", "Ljava/lang/String;", "getUrl", "getImage_url", "getDisplay_url", "Lcom/coinbase/android/apiv3/generated/common/Button;", "getButton", "()Lcom/coinbase/android/apiv3/generated/common/Button;", "getTitle", "getBody", "getTerms_url", "getLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Button;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class EarnInviteLesson extends a {
    public static final ProtoAdapter<EarnInviteLesson> ADAPTER;
    public static final Parcelable.Creator<EarnInviteLesson> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String body;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Button#ADAPTER", tag = 6)
    private final Button button;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "displayUrl", tag = 4)
    private final String display_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 1)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    private final String label;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "termsUrl", tag = 8)
    private final String terms_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String url;

    /* compiled from: EarnInviteLesson.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnInviteLesson$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnInviteLesson;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<EarnInviteLesson> protoAdapter = new ProtoAdapter<EarnInviteLesson>(c.LENGTH_DELIMITED, e0.b(EarnInviteLesson.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.EarnInviteLesson") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.EarnInviteLesson$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EarnInviteLesson decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Button button = null;
                String str = null;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new EarnInviteLesson(str2, str3, str4, str5, str6, str7, button, str, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            button = Button.ADAPTER.decode(reader);
                            break;
                        case 7:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, EarnInviteLesson value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getImage_url());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getTitle());
                }
                if (!m.c(value.getBody(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getBody());
                }
                if (!m.c(value.getDisplay_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getDisplay_url());
                }
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getUrl());
                }
                if (!m.c(value.getTerms_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.getTerms_url());
                }
                if (value.getButton() != null) {
                    Button.ADAPTER.encodeWithTag(writer, 6, value.getButton());
                }
                if (value.getLabel() != null) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getLabel());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(EarnInviteLesson value) {
                m.h(value, "value");
                if (m.c(value.getImage_url(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getImage_url());
                if (!m.c(value.getTitle(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getTitle());
                    if (!m.c(value.getBody(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getBody());
                        if (!m.c(value.getDisplay_url(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getDisplay_url());
                            if (!m.c(value.getUrl(), "")) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getUrl());
                                if (!m.c(value.getTerms_url(), "")) {
                                    int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(8, value.getTerms_url());
                                    if (value.getButton() != null) {
                                        r2 = (value.getLabel() != null ? protoAdapter2.encodedSizeWithTag(7, value.getLabel()) + value.unknownFields().Q() : 0) + Button.ADAPTER.encodedSizeWithTag(6, value.getButton());
                                    }
                                    r2 += encodedSizeWithTag6;
                                }
                                r2 += encodedSizeWithTag5;
                            }
                            r2 += encodedSizeWithTag4;
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public EarnInviteLesson redact(EarnInviteLesson value) {
                m.h(value, "value");
                Button button = value.getButton();
                return EarnInviteLesson.copy$default(value, null, null, null, null, null, null, button != null ? Button.ADAPTER.redact(button) : null, null, i.a, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public EarnInviteLesson() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public /* synthetic */ EarnInviteLesson(String str, String str2, String str3, String str4, String str5, String str6, Button button, String str7, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) == 0 ? str6 : "", (i2 & 64) != 0 ? null : button, (i2 & 128) == 0 ? str7 : null, (i2 & 256) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ EarnInviteLesson copy$default(EarnInviteLesson earnInviteLesson, String str, String str2, String str3, String str4, String str5, String str6, Button button, String str7, i iVar, int i2, Object obj) {
        return earnInviteLesson.copy((i2 & 1) != 0 ? earnInviteLesson.image_url : str, (i2 & 2) != 0 ? earnInviteLesson.title : str2, (i2 & 4) != 0 ? earnInviteLesson.body : str3, (i2 & 8) != 0 ? earnInviteLesson.display_url : str4, (i2 & 16) != 0 ? earnInviteLesson.url : str5, (i2 & 32) != 0 ? earnInviteLesson.terms_url : str6, (i2 & 64) != 0 ? earnInviteLesson.button : button, (i2 & 128) != 0 ? earnInviteLesson.label : str7, (i2 & 256) != 0 ? earnInviteLesson.unknownFields() : iVar);
    }

    public final EarnInviteLesson copy(String image_url, String title, String body, String display_url, String url, String terms_url, Button button, String str, i unknownFields) {
        m.h(image_url, "image_url");
        m.h(title, "title");
        m.h(body, "body");
        m.h(display_url, "display_url");
        m.h(url, "url");
        m.h(terms_url, "terms_url");
        m.h(unknownFields, "unknownFields");
        return new EarnInviteLesson(image_url, title, body, display_url, url, terms_url, button, str, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EarnInviteLesson) {
            EarnInviteLesson earnInviteLesson = (EarnInviteLesson) obj;
            return m.c(unknownFields(), earnInviteLesson.unknownFields()) && m.c(this.image_url, earnInviteLesson.image_url) && m.c(this.title, earnInviteLesson.title) && m.c(this.body, earnInviteLesson.body) && m.c(this.display_url, earnInviteLesson.display_url) && m.c(this.url, earnInviteLesson.url) && m.c(this.terms_url, earnInviteLesson.terms_url) && m.c(this.button, earnInviteLesson.button) && m.c(this.label, earnInviteLesson.label);
        }
        return false;
    }

    public final String getBody() {
        return this.body;
    }

    public final Button getButton() {
        return this.button;
    }

    public final String getDisplay_url() {
        return this.display_url;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getTerms_url() {
        return this.terms_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((((unknownFields().hashCode() * 37) + this.image_url.hashCode()) * 37) + this.title.hashCode()) * 37) + this.body.hashCode()) * 37) + this.display_url.hashCode()) * 37) + this.url.hashCode()) * 37) + this.terms_url.hashCode()) * 37;
            Button button = this.button;
            int hashCode2 = (hashCode + (button != null ? button.hashCode() : 0)) * 37;
            String str = this.label;
            int hashCode3 = hashCode2 + (str != null ? str.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m392newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("body=" + b.c(this.body));
        arrayList.add("display_url=" + b.c(this.display_url));
        arrayList.add("url=" + b.c(this.url));
        arrayList.add("terms_url=" + b.c(this.terms_url));
        if (this.button != null) {
            arrayList.add("button=" + this.button);
        }
        if (this.label != null) {
            arrayList.add("label=" + b.c(this.label));
        }
        h0 = z.h0(arrayList, ", ", "EarnInviteLesson{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarnInviteLesson(String image_url, String title, String body, String display_url, String url, String terms_url, Button button, String str, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(image_url, "image_url");
        m.h(title, "title");
        m.h(body, "body");
        m.h(display_url, "display_url");
        m.h(url, "url");
        m.h(terms_url, "terms_url");
        m.h(unknownFields, "unknownFields");
        this.image_url = image_url;
        this.title = title;
        this.body = body;
        this.display_url = display_url;
        this.url = url;
        this.terms_url = terms_url;
        this.button = button;
        this.label = str;
        if (!(b.b(button, str) <= 1)) {
            throw new IllegalArgumentException("At most one of button, label may be non-null".toString());
        }
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m392newBuilder() {
        throw new AssertionError();
    }
}