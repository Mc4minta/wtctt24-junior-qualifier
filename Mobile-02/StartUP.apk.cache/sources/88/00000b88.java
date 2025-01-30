package com.coinbase.android.apiv3.generated.authed.announcement_cards;

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

/* compiled from: AnnouncementCard.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+Bu\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ{\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0019\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001e\u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b#\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b$\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b%\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b&\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b'\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b(\u0010\u000f¨\u0006,"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCard;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "card_name", MessageBundle.TITLE_ENTRY, "subtitle", "card_color", "text_color", "url", "image_url", "background_color", "title_color", "subtitle_color", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCard;", "Ljava/lang/String;", "getTitle_color", "getSubtitle_color", "getBackground_color", "getTitle", "getText_color", "getSubtitle", "getImage_url", "getUrl", "getCard_color", "getCard_name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AnnouncementCard extends a {
    public static final ProtoAdapter<AnnouncementCard> ADAPTER;
    public static final Parcelable.Creator<AnnouncementCard> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "backgroundColor", tag = 8)
    private final String background_color;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardColor", tag = 4)
    private final String card_color;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardName", tag = 1)
    private final String card_name;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 7)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String subtitle;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "subtitleColor", tag = 10)
    private final String subtitle_color;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "textColor", tag = 5)
    private final String text_color;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "titleColor", tag = 9)
    private final String title_color;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String url;

    /* compiled from: AnnouncementCard.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCard$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCard;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<AnnouncementCard> protoAdapter = new ProtoAdapter<AnnouncementCard>(c.LENGTH_DELIMITED, e0.b(AnnouncementCard.class), "type.googleapis.com/coinbase.public_api.authed.announcement_cards.AnnouncementCard") { // from class: com.coinbase.android.apiv3.generated.authed.announcement_cards.AnnouncementCard$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AnnouncementCard decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                String str9 = str8;
                String str10 = str9;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AnnouncementCard(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, reader.e(d2));
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
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            str8 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            str9 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 10:
                            str10 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AnnouncementCard value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getCard_name(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getCard_name());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getTitle());
                }
                if (!m.c(value.getSubtitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getSubtitle());
                }
                if (!m.c(value.getCard_color(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getCard_color());
                }
                if (!m.c(value.getText_color(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getText_color());
                }
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getUrl());
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getImage_url());
                }
                if (!m.c(value.getBackground_color(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.getBackground_color());
                }
                if (!m.c(value.getTitle_color(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 9, value.getTitle_color());
                }
                if (!m.c(value.getSubtitle_color(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 10, value.getSubtitle_color());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AnnouncementCard value) {
                m.h(value, "value");
                if (m.c(value.getCard_name(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getCard_name());
                if (!m.c(value.getTitle(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getTitle());
                    if (!m.c(value.getSubtitle(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getSubtitle());
                        if (!m.c(value.getCard_color(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getCard_color());
                            if (!m.c(value.getText_color(), "")) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getText_color());
                                if (!m.c(value.getUrl(), "")) {
                                    int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(6, value.getUrl());
                                    if (!m.c(value.getImage_url(), "")) {
                                        int encodedSizeWithTag7 = protoAdapter2.encodedSizeWithTag(7, value.getImage_url());
                                        if (!m.c(value.getBackground_color(), "")) {
                                            int encodedSizeWithTag8 = protoAdapter2.encodedSizeWithTag(8, value.getBackground_color());
                                            if (!m.c(value.getTitle_color(), "")) {
                                                r2 = (m.c(value.getSubtitle_color(), "") ? 0 : protoAdapter2.encodedSizeWithTag(10, value.getSubtitle_color()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(9, value.getTitle_color());
                                            }
                                            r2 += encodedSizeWithTag8;
                                        }
                                        r2 += encodedSizeWithTag7;
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
            public AnnouncementCard redact(AnnouncementCard value) {
                m.h(value, "value");
                return AnnouncementCard.copy$default(value, null, null, null, null, null, null, null, null, null, null, i.a, 1023, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AnnouncementCard() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public /* synthetic */ AnnouncementCard(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? "" : str8, (i2 & 256) != 0 ? "" : str9, (i2 & 512) == 0 ? str10 : "", (i2 & 1024) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AnnouncementCard copy$default(AnnouncementCard announcementCard, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, i iVar, int i2, Object obj) {
        return announcementCard.copy((i2 & 1) != 0 ? announcementCard.card_name : str, (i2 & 2) != 0 ? announcementCard.title : str2, (i2 & 4) != 0 ? announcementCard.subtitle : str3, (i2 & 8) != 0 ? announcementCard.card_color : str4, (i2 & 16) != 0 ? announcementCard.text_color : str5, (i2 & 32) != 0 ? announcementCard.url : str6, (i2 & 64) != 0 ? announcementCard.image_url : str7, (i2 & 128) != 0 ? announcementCard.background_color : str8, (i2 & 256) != 0 ? announcementCard.title_color : str9, (i2 & 512) != 0 ? announcementCard.subtitle_color : str10, (i2 & 1024) != 0 ? announcementCard.unknownFields() : iVar);
    }

    public final AnnouncementCard copy(String card_name, String title, String subtitle, String card_color, String text_color, String url, String image_url, String background_color, String title_color, String subtitle_color, i unknownFields) {
        m.h(card_name, "card_name");
        m.h(title, "title");
        m.h(subtitle, "subtitle");
        m.h(card_color, "card_color");
        m.h(text_color, "text_color");
        m.h(url, "url");
        m.h(image_url, "image_url");
        m.h(background_color, "background_color");
        m.h(title_color, "title_color");
        m.h(subtitle_color, "subtitle_color");
        m.h(unknownFields, "unknownFields");
        return new AnnouncementCard(card_name, title, subtitle, card_color, text_color, url, image_url, background_color, title_color, subtitle_color, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AnnouncementCard) {
            AnnouncementCard announcementCard = (AnnouncementCard) obj;
            return m.c(unknownFields(), announcementCard.unknownFields()) && m.c(this.card_name, announcementCard.card_name) && m.c(this.title, announcementCard.title) && m.c(this.subtitle, announcementCard.subtitle) && m.c(this.card_color, announcementCard.card_color) && m.c(this.text_color, announcementCard.text_color) && m.c(this.url, announcementCard.url) && m.c(this.image_url, announcementCard.image_url) && m.c(this.background_color, announcementCard.background_color) && m.c(this.title_color, announcementCard.title_color) && m.c(this.subtitle_color, announcementCard.subtitle_color);
        }
        return false;
    }

    public final String getBackground_color() {
        return this.background_color;
    }

    public final String getCard_color() {
        return this.card_color;
    }

    public final String getCard_name() {
        return this.card_name;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getSubtitle_color() {
        return this.subtitle_color;
    }

    public final String getText_color() {
        return this.text_color;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitle_color() {
        return this.title_color;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((((((((((unknownFields().hashCode() * 37) + this.card_name.hashCode()) * 37) + this.title.hashCode()) * 37) + this.subtitle.hashCode()) * 37) + this.card_color.hashCode()) * 37) + this.text_color.hashCode()) * 37) + this.url.hashCode()) * 37) + this.image_url.hashCode()) * 37) + this.background_color.hashCode()) * 37) + this.title_color.hashCode()) * 37) + this.subtitle_color.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m279newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("card_name=" + b.c(this.card_name));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("subtitle=" + b.c(this.subtitle));
        arrayList.add("card_color=" + b.c(this.card_color));
        arrayList.add("text_color=" + b.c(this.text_color));
        arrayList.add("url=" + b.c(this.url));
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("background_color=" + b.c(this.background_color));
        arrayList.add("title_color=" + b.c(this.title_color));
        arrayList.add("subtitle_color=" + b.c(this.subtitle_color));
        h0 = z.h0(arrayList, ", ", "AnnouncementCard{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnouncementCard(String card_name, String title, String subtitle, String card_color, String text_color, String url, String image_url, String background_color, String title_color, String subtitle_color, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(card_name, "card_name");
        m.h(title, "title");
        m.h(subtitle, "subtitle");
        m.h(card_color, "card_color");
        m.h(text_color, "text_color");
        m.h(url, "url");
        m.h(image_url, "image_url");
        m.h(background_color, "background_color");
        m.h(title_color, "title_color");
        m.h(subtitle_color, "subtitle_color");
        m.h(unknownFields, "unknownFields");
        this.card_name = card_name;
        this.title = title;
        this.subtitle = subtitle;
        this.card_color = card_color;
        this.text_color = text_color;
        this.url = url;
        this.image_url = image_url;
        this.background_color = background_color;
        this.title_color = title_color;
        this.subtitle_color = subtitle_color;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m279newBuilder() {
        throw new AssertionError();
    }
}