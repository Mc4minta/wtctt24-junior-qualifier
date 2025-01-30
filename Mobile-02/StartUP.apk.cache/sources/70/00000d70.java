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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: VideoMedia.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001d\u0010\f¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/VideoMedia;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "height", "width", "image_url", "video_url", "Lj/i;", "unknownFields", "copy", "(IILjava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/VideoMedia;", "Ljava/lang/String;", "getVideo_url", "I", "getHeight", "getImage_url", "getWidth", "<init>", "(IILjava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class VideoMedia extends a {
    public static final ProtoAdapter<VideoMedia> ADAPTER;
    public static final Parcelable.Creator<VideoMedia> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    private final int height;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 3)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "videoUrl", tag = 4)
    private final String video_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    private final int width;

    /* compiled from: VideoMedia.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/VideoMedia$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/VideoMedia;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<VideoMedia> protoAdapter = new ProtoAdapter<VideoMedia>(c.LENGTH_DELIMITED, e0.b(VideoMedia.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.VideoMedia") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.VideoMedia$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public VideoMedia decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new VideoMedia(i2, i3, str, str2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        i2 = ProtoAdapter.INT32.decode(reader).intValue();
                    } else if (g2 == 2) {
                        i3 = ProtoAdapter.INT32.decode(reader).intValue();
                    } else if (g2 == 3) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, VideoMedia value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getHeight() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 1, Integer.valueOf(value.getHeight()));
                }
                if (value.getWidth() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(value.getWidth()));
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getImage_url());
                }
                if (!m.c(value.getVideo_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getVideo_url());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(VideoMedia value) {
                m.h(value, "value");
                if (value.getHeight() == 0) {
                    return 0;
                }
                ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, Integer.valueOf(value.getHeight()));
                if (value.getWidth() != 0) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, Integer.valueOf(value.getWidth()));
                    if (!m.c(value.getImage_url(), "")) {
                        ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                        r1 = (m.c(value.getVideo_url(), "") ? 0 : protoAdapter3.encodedSizeWithTag(4, value.getVideo_url()) + value.unknownFields().Q()) + protoAdapter3.encodedSizeWithTag(3, value.getImage_url());
                    }
                    r1 += encodedSizeWithTag2;
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public VideoMedia redact(VideoMedia value) {
                m.h(value, "value");
                return VideoMedia.copy$default(value, 0, 0, null, null, i.a, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public VideoMedia() {
        this(0, 0, null, null, null, 31, null);
    }

    public /* synthetic */ VideoMedia(int i2, int i3, String str, String str2, i iVar, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) == 0 ? i3 : 0, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ VideoMedia copy$default(VideoMedia videoMedia, int i2, int i3, String str, String str2, i iVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = videoMedia.height;
        }
        if ((i4 & 2) != 0) {
            i3 = videoMedia.width;
        }
        int i5 = i3;
        if ((i4 & 4) != 0) {
            str = videoMedia.image_url;
        }
        String str3 = str;
        if ((i4 & 8) != 0) {
            str2 = videoMedia.video_url;
        }
        String str4 = str2;
        if ((i4 & 16) != 0) {
            iVar = videoMedia.unknownFields();
        }
        return videoMedia.copy(i2, i5, str3, str4, iVar);
    }

    public final VideoMedia copy(int i2, int i3, String image_url, String video_url, i unknownFields) {
        m.h(image_url, "image_url");
        m.h(video_url, "video_url");
        m.h(unknownFields, "unknownFields");
        return new VideoMedia(i2, i3, image_url, video_url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoMedia) {
            VideoMedia videoMedia = (VideoMedia) obj;
            return m.c(unknownFields(), videoMedia.unknownFields()) && this.height == videoMedia.height && this.width == videoMedia.width && m.c(this.image_url, videoMedia.image_url) && m.c(this.video_url, videoMedia.video_url);
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getVideo_url() {
        return this.video_url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.height) * 37) + this.width) * 37) + this.image_url.hashCode()) * 37) + this.video_url.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m423newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("height=" + this.height);
        arrayList.add("width=" + this.width);
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("video_url=" + b.c(this.video_url));
        h0 = z.h0(arrayList, ", ", "VideoMedia{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMedia(int i2, int i3, String image_url, String video_url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(image_url, "image_url");
        m.h(video_url, "video_url");
        m.h(unknownFields, "unknownFields");
        this.height = i2;
        this.width = i3;
        this.image_url = image_url;
        this.video_url = video_url;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m423newBuilder() {
        throw new AssertionError();
    }
}