package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import j.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: NotificationPreview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(BW\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ]\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/NotificationPreview;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreviewStyle;", "style", MessageBundle.TITLE_ENTRY, "header", "tags", "label", "sublabel", "image_url", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/NotificationPreviewStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/NotificationPreview;", "Ljava/lang/String;", "getTitle", "getTags", "getImage_url", "getHeader", "getSublabel", "getLabel", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreviewStyle;", "getStyle", "()Lcom/coinbase/android/apiv3/generated/authed/NotificationPreviewStyle;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/NotificationPreviewStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class NotificationPreview extends com.squareup.wire.a {
    public static final ProtoAdapter<NotificationPreview> ADAPTER;
    public static final Parcelable.Creator<NotificationPreview> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String header;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 7)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String label;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.NotificationPreviewStyle#ADAPTER", tag = 1)
    private final NotificationPreviewStyle style;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String sublabel;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String tags;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String title;

    /* compiled from: NotificationPreview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/NotificationPreview$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreview;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<NotificationPreview> protoAdapter = new ProtoAdapter<NotificationPreview>(c.LENGTH_DELIMITED, e0.b(NotificationPreview.class), "type.googleapis.com/coinbase.public_api.authed.NotificationPreview") { // from class: com.coinbase.android.apiv3.generated.authed.NotificationPreview$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public NotificationPreview decode(k reader) {
                m.h(reader, "reader");
                NotificationPreviewStyle notificationPreviewStyle = NotificationPreviewStyle.TEXT;
                long d2 = reader.d();
                NotificationPreviewStyle notificationPreviewStyle2 = notificationPreviewStyle;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new NotificationPreview(notificationPreviewStyle2, str, str2, str3, str4, str5, str6, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            try {
                                notificationPreviewStyle2 = NotificationPreviewStyle.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 2:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, NotificationPreview value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getStyle() != NotificationPreviewStyle.TEXT) {
                    NotificationPreviewStyle.ADAPTER.encodeWithTag(writer, 1, value.getStyle());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getTitle());
                }
                if (!m.c(value.getHeader(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getHeader());
                }
                if (!m.c(value.getTags(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getTags());
                }
                if (!m.c(value.getLabel(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getLabel());
                }
                if (!m.c(value.getSublabel(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getSublabel());
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getImage_url());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(NotificationPreview value) {
                m.h(value, "value");
                if (value.getStyle() == NotificationPreviewStyle.TEXT) {
                    return 0;
                }
                int encodedSizeWithTag = NotificationPreviewStyle.ADAPTER.encodedSizeWithTag(1, value.getStyle());
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getTitle());
                    if (!m.c(value.getHeader(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getHeader());
                        if (!m.c(value.getTags(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getTags());
                            if (!m.c(value.getLabel(), "")) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getLabel());
                                if (!m.c(value.getSublabel(), "")) {
                                    r2 = (m.c(value.getImage_url(), "") ? 0 : protoAdapter2.encodedSizeWithTag(7, value.getImage_url()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(6, value.getSublabel());
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
            public NotificationPreview redact(NotificationPreview value) {
                m.h(value, "value");
                return NotificationPreview.copy$default(value, null, null, null, null, null, null, null, i.a, 127, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public NotificationPreview() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public /* synthetic */ NotificationPreview(NotificationPreviewStyle notificationPreviewStyle, String str, String str2, String str3, String str4, String str5, String str6, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? NotificationPreviewStyle.TEXT : notificationPreviewStyle, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) == 0 ? str6 : "", (i2 & 128) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ NotificationPreview copy$default(NotificationPreview notificationPreview, NotificationPreviewStyle notificationPreviewStyle, String str, String str2, String str3, String str4, String str5, String str6, i iVar, int i2, Object obj) {
        return notificationPreview.copy((i2 & 1) != 0 ? notificationPreview.style : notificationPreviewStyle, (i2 & 2) != 0 ? notificationPreview.title : str, (i2 & 4) != 0 ? notificationPreview.header : str2, (i2 & 8) != 0 ? notificationPreview.tags : str3, (i2 & 16) != 0 ? notificationPreview.label : str4, (i2 & 32) != 0 ? notificationPreview.sublabel : str5, (i2 & 64) != 0 ? notificationPreview.image_url : str6, (i2 & 128) != 0 ? notificationPreview.unknownFields() : iVar);
    }

    public final NotificationPreview copy(NotificationPreviewStyle style, String title, String header, String tags, String label, String sublabel, String image_url, i unknownFields) {
        m.h(style, "style");
        m.h(title, "title");
        m.h(header, "header");
        m.h(tags, "tags");
        m.h(label, "label");
        m.h(sublabel, "sublabel");
        m.h(image_url, "image_url");
        m.h(unknownFields, "unknownFields");
        return new NotificationPreview(style, title, header, tags, label, sublabel, image_url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NotificationPreview) {
            NotificationPreview notificationPreview = (NotificationPreview) obj;
            return m.c(unknownFields(), notificationPreview.unknownFields()) && this.style == notificationPreview.style && m.c(this.title, notificationPreview.title) && m.c(this.header, notificationPreview.header) && m.c(this.tags, notificationPreview.tags) && m.c(this.label, notificationPreview.label) && m.c(this.sublabel, notificationPreview.sublabel) && m.c(this.image_url, notificationPreview.image_url);
        }
        return false;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getLabel() {
        return this.label;
    }

    public final NotificationPreviewStyle getStyle() {
        return this.style;
    }

    public final String getSublabel() {
        return this.sublabel;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((((unknownFields().hashCode() * 37) + this.style.hashCode()) * 37) + this.title.hashCode()) * 37) + this.header.hashCode()) * 37) + this.tags.hashCode()) * 37) + this.label.hashCode()) * 37) + this.sublabel.hashCode()) * 37) + this.image_url.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m241newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("style=" + this.style);
        arrayList.add("title=" + com.squareup.wire.q.b.c(this.title));
        arrayList.add("header=" + com.squareup.wire.q.b.c(this.header));
        arrayList.add("tags=" + com.squareup.wire.q.b.c(this.tags));
        arrayList.add("label=" + com.squareup.wire.q.b.c(this.label));
        arrayList.add("sublabel=" + com.squareup.wire.q.b.c(this.sublabel));
        arrayList.add("image_url=" + com.squareup.wire.q.b.c(this.image_url));
        h0 = z.h0(arrayList, ", ", "NotificationPreview{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m241newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationPreview(NotificationPreviewStyle style, String title, String header, String tags, String label, String sublabel, String image_url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(style, "style");
        m.h(title, "title");
        m.h(header, "header");
        m.h(tags, "tags");
        m.h(label, "label");
        m.h(sublabel, "sublabel");
        m.h(image_url, "image_url");
        m.h(unknownFields, "unknownFields");
        this.style = style;
        this.title = title;
        this.header = header;
        this.tags = tags;
        this.label = label;
        this.sublabel = sublabel;
        this.image_url = image_url;
    }
}