package com.coinbase.android.apiv3.generated.authed.new_user_experience;

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

/* compiled from: Banner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&BM\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJS\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b#\u0010\u000f¨\u0006'"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Banner;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "title_text", "body_text", "button_text", "main_image_url", "button_image_url", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/ButtonLink;", "button_link", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/ButtonLink;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Banner;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/ButtonLink;", "getButton_link", "()Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/ButtonLink;", "Ljava/lang/String;", "getButton_text", "getBody_text", "getButton_image_url", "getMain_image_url", "getTitle_text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/ButtonLink;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Banner extends a {
    public static final ProtoAdapter<Banner> ADAPTER;
    public static final Parcelable.Creator<Banner> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "bodyText", tag = 2)
    private final String body_text;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "buttonImageUrl", tag = 5)
    private final String button_image_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.new_user_experience.ButtonLink#ADAPTER", jsonName = "buttonLink", tag = 6)
    private final ButtonLink button_link;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "buttonText", tag = 3)
    private final String button_text;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "mainImageUrl", tag = 4)
    private final String main_image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "titleText", tag = 1)
    private final String title_text;

    /* compiled from: Banner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Banner$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/Banner;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Banner> protoAdapter = new ProtoAdapter<Banner>(c.LENGTH_DELIMITED, e0.b(Banner.class), "type.googleapis.com/coinbase.public_api.authed.new_user_experience.Banner") { // from class: com.coinbase.android.apiv3.generated.authed.new_user_experience.Banner$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Banner decode(k reader) {
                m.h(reader, "reader");
                ButtonLink buttonLink = ButtonLink.IDV;
                long d2 = reader.d();
                ButtonLink buttonLink2 = buttonLink;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Banner(str, str2, str3, str4, str5, buttonLink2, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            try {
                                buttonLink2 = ButtonLink.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Banner value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle_text());
                }
                if (!m.c(value.getBody_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getBody_text());
                }
                if (!m.c(value.getButton_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getButton_text());
                }
                if (!m.c(value.getMain_image_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getMain_image_url());
                }
                if (!m.c(value.getButton_image_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getButton_image_url());
                }
                if (value.getButton_link() != ButtonLink.IDV) {
                    ButtonLink.ADAPTER.encodeWithTag(writer, 6, value.getButton_link());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Banner value) {
                m.h(value, "value");
                if (m.c(value.getTitle_text(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle_text());
                if (!m.c(value.getBody_text(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getBody_text());
                    if (!m.c(value.getButton_text(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getButton_text());
                        if (!m.c(value.getMain_image_url(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getMain_image_url());
                            if (!m.c(value.getButton_image_url(), "")) {
                                r2 = (value.getButton_link() != ButtonLink.IDV ? ButtonLink.ADAPTER.encodedSizeWithTag(6, value.getButton_link()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(5, value.getButton_image_url());
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
            public Banner redact(Banner value) {
                m.h(value, "value");
                return Banner.copy$default(value, null, null, null, null, null, null, i.a, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Banner() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ Banner(String str, String str2, String str3, String str4, String str5, ButtonLink buttonLink, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? ButtonLink.IDV : buttonLink, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Banner copy$default(Banner banner, String str, String str2, String str3, String str4, String str5, ButtonLink buttonLink, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = banner.title_text;
        }
        if ((i2 & 2) != 0) {
            str2 = banner.body_text;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = banner.button_text;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = banner.main_image_url;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = banner.button_image_url;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            buttonLink = banner.button_link;
        }
        ButtonLink buttonLink2 = buttonLink;
        if ((i2 & 64) != 0) {
            iVar = banner.unknownFields();
        }
        return banner.copy(str, str6, str7, str8, str9, buttonLink2, iVar);
    }

    public final Banner copy(String title_text, String body_text, String button_text, String main_image_url, String button_image_url, ButtonLink button_link, i unknownFields) {
        m.h(title_text, "title_text");
        m.h(body_text, "body_text");
        m.h(button_text, "button_text");
        m.h(main_image_url, "main_image_url");
        m.h(button_image_url, "button_image_url");
        m.h(button_link, "button_link");
        m.h(unknownFields, "unknownFields");
        return new Banner(title_text, body_text, button_text, main_image_url, button_image_url, button_link, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Banner) {
            Banner banner = (Banner) obj;
            return m.c(unknownFields(), banner.unknownFields()) && m.c(this.title_text, banner.title_text) && m.c(this.body_text, banner.body_text) && m.c(this.button_text, banner.button_text) && m.c(this.main_image_url, banner.main_image_url) && m.c(this.button_image_url, banner.button_image_url) && this.button_link == banner.button_link;
        }
        return false;
    }

    public final String getBody_text() {
        return this.body_text;
    }

    public final String getButton_image_url() {
        return this.button_image_url;
    }

    public final ButtonLink getButton_link() {
        return this.button_link;
    }

    public final String getButton_text() {
        return this.button_text;
    }

    public final String getMain_image_url() {
        return this.main_image_url;
    }

    public final String getTitle_text() {
        return this.title_text;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((unknownFields().hashCode() * 37) + this.title_text.hashCode()) * 37) + this.body_text.hashCode()) * 37) + this.button_text.hashCode()) * 37) + this.main_image_url.hashCode()) * 37) + this.button_image_url.hashCode()) * 37) + this.button_link.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m426newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title_text=" + b.c(this.title_text));
        arrayList.add("body_text=" + b.c(this.body_text));
        arrayList.add("button_text=" + b.c(this.button_text));
        arrayList.add("main_image_url=" + b.c(this.main_image_url));
        arrayList.add("button_image_url=" + b.c(this.button_image_url));
        arrayList.add("button_link=" + this.button_link);
        h0 = z.h0(arrayList, ", ", "Banner{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m426newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Banner(String title_text, String body_text, String button_text, String main_image_url, String button_image_url, ButtonLink button_link, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title_text, "title_text");
        m.h(body_text, "body_text");
        m.h(button_text, "button_text");
        m.h(main_image_url, "main_image_url");
        m.h(button_image_url, "button_image_url");
        m.h(button_link, "button_link");
        m.h(unknownFields, "unknownFields");
        this.title_text = title_text;
        this.body_text = body_text;
        this.button_text = button_text;
        this.main_image_url = main_image_url;
        this.button_image_url = button_image_url;
        this.button_link = button_link;
    }
}