package com.coinbase.android.apiv3.generated.common;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.lwansbrough.RCTCamera.RCTCameraModule;
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

/* compiled from: AdditionalInformation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&BO\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJU\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b \u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/AdditionalInformation;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_PREVIEW, "prompt", MessageBundle.TITLE_ENTRY, "image_url", ApiConstants.DESCRIPTION, "Lcom/coinbase/android/apiv3/generated/common/Link;", "link", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/AdditionalInformation;", "Ljava/lang/String;", "getImage_url", "getPreview", "getTitle", "getDescription", "getPrompt", "Lcom/coinbase/android/apiv3/generated/common/Link;", "getLink", "()Lcom/coinbase/android/apiv3/generated/common/Link;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Link;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AdditionalInformation extends a {
    public static final ProtoAdapter<AdditionalInformation> ADAPTER;
    public static final Parcelable.Creator<AdditionalInformation> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 4)
    private final String image_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Link#ADAPTER", tag = 6)
    private final Link link;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String preview;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String prompt;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String title;

    /* compiled from: AdditionalInformation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/AdditionalInformation$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/AdditionalInformation;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<AdditionalInformation> protoAdapter = new ProtoAdapter<AdditionalInformation>(c.LENGTH_DELIMITED, e0.b(AdditionalInformation.class), "type.googleapis.com/coinbase.public_api.common.AdditionalInformation") { // from class: com.coinbase.android.apiv3.generated.common.AdditionalInformation$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AdditionalInformation decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                Link link = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AdditionalInformation(str, str2, str3, str4, str5, link, reader.e(d2));
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
                            link = Link.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AdditionalInformation value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getPreview(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getPreview());
                }
                if (!m.c(value.getPrompt(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getPrompt());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getTitle());
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getImage_url());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getDescription());
                }
                if (value.getLink() != null) {
                    Link.ADAPTER.encodeWithTag(writer, 6, value.getLink());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AdditionalInformation value) {
                m.h(value, "value");
                if (m.c(value.getPreview(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getPreview());
                if (!m.c(value.getPrompt(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getPrompt());
                    if (!m.c(value.getTitle(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getTitle());
                        if (!m.c(value.getImage_url(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getImage_url());
                            if (!m.c(value.getDescription(), "")) {
                                r2 = (value.getLink() != null ? Link.ADAPTER.encodedSizeWithTag(6, value.getLink()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(5, value.getDescription());
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
            public AdditionalInformation redact(AdditionalInformation value) {
                m.h(value, "value");
                Link link = value.getLink();
                return AdditionalInformation.copy$default(value, null, null, null, null, null, link != null ? Link.ADAPTER.redact(link) : null, i.a, 31, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AdditionalInformation() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ AdditionalInformation(String str, String str2, String str3, String str4, String str5, Link link, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? null : link, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AdditionalInformation copy$default(AdditionalInformation additionalInformation, String str, String str2, String str3, String str4, String str5, Link link, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = additionalInformation.preview;
        }
        if ((i2 & 2) != 0) {
            str2 = additionalInformation.prompt;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = additionalInformation.title;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = additionalInformation.image_url;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = additionalInformation.description;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            link = additionalInformation.link;
        }
        Link link2 = link;
        if ((i2 & 64) != 0) {
            iVar = additionalInformation.unknownFields();
        }
        return additionalInformation.copy(str, str6, str7, str8, str9, link2, iVar);
    }

    public final AdditionalInformation copy(String preview, String prompt, String title, String image_url, String description, Link link, i unknownFields) {
        m.h(preview, "preview");
        m.h(prompt, "prompt");
        m.h(title, "title");
        m.h(image_url, "image_url");
        m.h(description, "description");
        m.h(unknownFields, "unknownFields");
        return new AdditionalInformation(preview, prompt, title, image_url, description, link, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdditionalInformation) {
            AdditionalInformation additionalInformation = (AdditionalInformation) obj;
            return m.c(unknownFields(), additionalInformation.unknownFields()) && m.c(this.preview, additionalInformation.preview) && m.c(this.prompt, additionalInformation.prompt) && m.c(this.title, additionalInformation.title) && m.c(this.image_url, additionalInformation.image_url) && m.c(this.description, additionalInformation.description) && m.c(this.link, additionalInformation.link);
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final Link getLink() {
        return this.link;
    }

    public final String getPreview() {
        return this.preview;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((unknownFields().hashCode() * 37) + this.preview.hashCode()) * 37) + this.prompt.hashCode()) * 37) + this.title.hashCode()) * 37) + this.image_url.hashCode()) * 37) + this.description.hashCode()) * 37;
            Link link = this.link;
            int hashCode2 = hashCode + (link != null ? link.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m501newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("preview=" + b.c(this.preview));
        arrayList.add("prompt=" + b.c(this.prompt));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("description=" + b.c(this.description));
        if (this.link != null) {
            arrayList.add("link=" + this.link);
        }
        h0 = z.h0(arrayList, ", ", "AdditionalInformation{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdditionalInformation(String preview, String prompt, String title, String image_url, String description, Link link, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(preview, "preview");
        m.h(prompt, "prompt");
        m.h(title, "title");
        m.h(image_url, "image_url");
        m.h(description, "description");
        m.h(unknownFields, "unknownFields");
        this.preview = preview;
        this.prompt = prompt;
        this.title = title;
        this.image_url = image_url;
        this.description = description;
        this.link = link;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m501newBuilder() {
        throw new AssertionError();
    }
}