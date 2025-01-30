package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Video;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: LoyaltyCardTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00010Bg\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJm\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b\"\u0010\u000fR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b)\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010,R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b-\u0010\u000f¨\u00061"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardTask;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "value", "url", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;", "description_style", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;", "mobile_video", "image_url", "Lcom/coinbase/android/apiv3/generated/common/Video;", "video", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Video;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardTask;", "Ljava/lang/String;", "getValue", "getDescription", "getUrl", "Lcom/coinbase/android/apiv3/generated/common/Video;", "getVideo", "()Lcom/coinbase/android/apiv3/generated/common/Video;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;", "getMobile_video", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;", "getTitle", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;", "getDescription_style", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;", "getImage_url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Video;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoyaltyCardTask extends a {
    public static final ProtoAdapter<LoyaltyCardTask> ADAPTER;
    public static final Parcelable.Creator<LoyaltyCardTask> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String description;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyTextStyle#ADAPTER", jsonName = "descriptionStyle", tag = 7)
    private final LoyaltyTextStyle description_style;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 4)
    private final String image_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.MobileVideo#ADAPTER", jsonName = "mobileVideo", tag = 8)
    private final MobileVideo mobile_video;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String value;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Video#ADAPTER", tag = 5)
    private final Video video;

    /* compiled from: LoyaltyCardTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardTask$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardTask;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        final c cVar = c.LENGTH_DELIMITED;
        final d b2 = e0.b(LoyaltyCardTask.class);
        ProtoAdapter<LoyaltyCardTask> protoAdapter = new ProtoAdapter<LoyaltyCardTask>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.loyalty.LoyaltyCardTask") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardTask$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCardTask decode(k reader) {
                long j2;
                m.h(reader, "reader");
                LoyaltyTextStyle loyaltyTextStyle = LoyaltyTextStyle.TEXT_STANDARD;
                long d2 = reader.d();
                LoyaltyTextStyle loyaltyTextStyle2 = loyaltyTextStyle;
                MobileVideo mobileVideo = null;
                String str = null;
                Video video = null;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoyaltyCardTask(str2, str3, str4, str5, loyaltyTextStyle2, mobileVideo, str, video, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            j2 = d2;
                            str2 = ProtoAdapter.STRING.decode(reader);
                            continue;
                            d2 = j2;
                        case 2:
                            j2 = d2;
                            str3 = ProtoAdapter.STRING.decode(reader);
                            continue;
                            d2 = j2;
                        case 3:
                            j2 = d2;
                            str4 = ProtoAdapter.STRING.decode(reader);
                            continue;
                            d2 = j2;
                        case 4:
                            j2 = d2;
                            str = ProtoAdapter.STRING.decode(reader);
                            continue;
                            d2 = j2;
                        case 5:
                            j2 = d2;
                            video = Video.ADAPTER.decode(reader);
                            continue;
                            d2 = j2;
                        case 6:
                            j2 = d2;
                            str5 = ProtoAdapter.STRING.decode(reader);
                            continue;
                            d2 = j2;
                        case 7:
                            try {
                                loyaltyTextStyle2 = LoyaltyTextStyle.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                j2 = d2;
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 8:
                            mobileVideo = MobileVideo.ADAPTER.decode(reader);
                            break;
                        default:
                            j2 = d2;
                            reader.m(g2);
                            continue;
                            d2 = j2;
                    }
                    j2 = d2;
                    d2 = j2;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoyaltyCardTask value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getDescription());
                }
                if (!m.c(value.getValue(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getValue());
                }
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getUrl());
                }
                if (value.getDescription_style() != LoyaltyTextStyle.TEXT_STANDARD) {
                    LoyaltyTextStyle.ADAPTER.encodeWithTag(writer, 7, value.getDescription_style());
                }
                if (value.getMobile_video() != null) {
                    MobileVideo.ADAPTER.encodeWithTag(writer, 8, value.getMobile_video());
                }
                if (value.getImage_url() != null) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getImage_url());
                }
                if (value.getVideo() != null) {
                    Video.ADAPTER.encodeWithTag(writer, 5, value.getVideo());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoyaltyCardTask value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle());
                if (!m.c(value.getDescription(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getDescription());
                    if (!m.c(value.getValue(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getValue());
                        if (!m.c(value.getUrl(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(6, value.getUrl());
                            if (value.getDescription_style() != LoyaltyTextStyle.TEXT_STANDARD) {
                                int encodedSizeWithTag5 = LoyaltyTextStyle.ADAPTER.encodedSizeWithTag(7, value.getDescription_style());
                                if (value.getMobile_video() != null) {
                                    int encodedSizeWithTag6 = MobileVideo.ADAPTER.encodedSizeWithTag(8, value.getMobile_video());
                                    if (value.getImage_url() != null) {
                                        r2 = (value.getVideo() != null ? Video.ADAPTER.encodedSizeWithTag(5, value.getVideo()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(4, value.getImage_url());
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
            public LoyaltyCardTask redact(LoyaltyCardTask value) {
                LoyaltyCardTask copy;
                m.h(value, "value");
                MobileVideo mobile_video = value.getMobile_video();
                MobileVideo redact = mobile_video != null ? MobileVideo.ADAPTER.redact(mobile_video) : null;
                Video video = value.getVideo();
                copy = value.copy((r20 & 1) != 0 ? value.title : null, (r20 & 2) != 0 ? value.description : null, (r20 & 4) != 0 ? value.value : null, (r20 & 8) != 0 ? value.url : null, (r20 & 16) != 0 ? value.description_style : null, (r20 & 32) != 0 ? value.mobile_video : redact, (r20 & 64) != 0 ? value.image_url : null, (r20 & 128) != 0 ? value.video : video != null ? Video.ADAPTER.redact(video) : null, (r20 & 256) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoyaltyCardTask() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public /* synthetic */ LoyaltyCardTask(String str, String str2, String str3, String str4, LoyaltyTextStyle loyaltyTextStyle, MobileVideo mobileVideo, String str5, Video video, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? LoyaltyTextStyle.TEXT_STANDARD : loyaltyTextStyle, (i2 & 32) != 0 ? null : mobileVideo, (i2 & 64) != 0 ? null : str5, (i2 & 128) == 0 ? video : null, (i2 & 256) != 0 ? i.a : iVar);
    }

    public final LoyaltyCardTask copy(String title, String description, String value, String url, LoyaltyTextStyle description_style, MobileVideo mobileVideo, String str, Video video, i unknownFields) {
        m.h(title, "title");
        m.h(description, "description");
        m.h(value, "value");
        m.h(url, "url");
        m.h(description_style, "description_style");
        m.h(unknownFields, "unknownFields");
        return new LoyaltyCardTask(title, description, value, url, description_style, mobileVideo, str, video, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoyaltyCardTask) {
            LoyaltyCardTask loyaltyCardTask = (LoyaltyCardTask) obj;
            return m.c(unknownFields(), loyaltyCardTask.unknownFields()) && m.c(this.title, loyaltyCardTask.title) && m.c(this.description, loyaltyCardTask.description) && m.c(this.value, loyaltyCardTask.value) && m.c(this.url, loyaltyCardTask.url) && this.description_style == loyaltyCardTask.description_style && m.c(this.mobile_video, loyaltyCardTask.mobile_video) && m.c(this.image_url, loyaltyCardTask.image_url) && m.c(this.video, loyaltyCardTask.video);
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final LoyaltyTextStyle getDescription_style() {
        return this.description_style;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final MobileVideo getMobile_video() {
        return this.mobile_video;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getValue() {
        return this.value;
    }

    public final Video getVideo() {
        return this.video;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.description.hashCode()) * 37) + this.value.hashCode()) * 37) + this.url.hashCode()) * 37) + this.description_style.hashCode()) * 37;
            MobileVideo mobileVideo = this.mobile_video;
            int hashCode2 = (hashCode + (mobileVideo != null ? mobileVideo.hashCode() : 0)) * 37;
            String str = this.image_url;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
            Video video = this.video;
            int hashCode4 = hashCode3 + (video != null ? video.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m415newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("description=" + b.c(this.description));
        arrayList.add("value=" + b.c(this.value));
        arrayList.add("url=" + b.c(this.url));
        arrayList.add("description_style=" + this.description_style);
        if (this.mobile_video != null) {
            arrayList.add("mobile_video=" + this.mobile_video);
        }
        if (this.image_url != null) {
            arrayList.add("image_url=" + b.c(this.image_url));
        }
        if (this.video != null) {
            arrayList.add("video=" + this.video);
        }
        h0 = z.h0(arrayList, ", ", "LoyaltyCardTask{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m415newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoyaltyCardTask(String title, String description, String value, String url, LoyaltyTextStyle description_style, MobileVideo mobileVideo, String str, Video video, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(description, "description");
        m.h(value, "value");
        m.h(url, "url");
        m.h(description_style, "description_style");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.description = description;
        this.value = value;
        this.url = url;
        this.description_style = description_style;
        this.mobile_video = mobileVideo;
        this.image_url = str;
        this.video = video;
        if (!(b.b(str, video) <= 1)) {
            throw new IllegalArgumentException("At most one of image_url, video may be non-null".toString());
        }
    }
}