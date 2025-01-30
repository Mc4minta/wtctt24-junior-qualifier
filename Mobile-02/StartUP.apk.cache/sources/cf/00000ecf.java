package com.coinbase.android.apiv3.generated.common;

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

/* compiled from: Video.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0011\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\u0012\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/Video;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "url", "height", "width", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;IILj/i;)Lcom/coinbase/android/apiv3/generated/common/Video;", "I", "getHeight", "getWidth", "Ljava/lang/String;", "getUrl", "<init>", "(Ljava/lang/String;IILj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Video extends a {
    public static final ProtoAdapter<Video> ADAPTER;
    public static final Parcelable.Creator<Video> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    private final int height;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    private final int width;

    /* compiled from: Video.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/Video$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/Video;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Video> protoAdapter = new ProtoAdapter<Video>(c.LENGTH_DELIMITED, e0.b(Video.class), "type.googleapis.com/coinbase.public_api.common.Video") { // from class: com.coinbase.android.apiv3.generated.common.Video$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Video decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                int i2 = 0;
                String str = "";
                int i3 = 0;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Video(str, i2, i3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        i2 = ProtoAdapter.INT32.decode(reader).intValue();
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        i3 = ProtoAdapter.INT32.decode(reader).intValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Video value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getUrl());
                }
                if (value.getHeight() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 2, Integer.valueOf(value.getHeight()));
                }
                if (value.getWidth() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 3, Integer.valueOf(value.getWidth()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Video value) {
                m.h(value, "value");
                if (m.c(value.getUrl(), "")) {
                    return 0;
                }
                int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, value.getUrl());
                if (value.getHeight() != 0) {
                    ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
                    r1 = (value.getWidth() != 0 ? protoAdapter2.encodedSizeWithTag(3, Integer.valueOf(value.getWidth())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(2, Integer.valueOf(value.getHeight()));
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Video redact(Video value) {
                m.h(value, "value");
                return Video.copy$default(value, null, 0, 0, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Video() {
        this(null, 0, 0, null, 15, null);
    }

    public /* synthetic */ Video(String str, int i2, int i3, i iVar, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ Video copy$default(Video video, String str, int i2, int i3, i iVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = video.url;
        }
        if ((i4 & 2) != 0) {
            i2 = video.height;
        }
        if ((i4 & 4) != 0) {
            i3 = video.width;
        }
        if ((i4 & 8) != 0) {
            iVar = video.unknownFields();
        }
        return video.copy(str, i2, i3, iVar);
    }

    public final Video copy(String url, int i2, int i3, i unknownFields) {
        m.h(url, "url");
        m.h(unknownFields, "unknownFields");
        return new Video(url, i2, i3, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Video) {
            Video video = (Video) obj;
            return m.c(unknownFields(), video.unknownFields()) && m.c(this.url, video.url) && this.height == video.height && this.width == video.width;
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.url.hashCode()) * 37) + this.height) * 37) + this.width;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m520newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("url=" + b.c(this.url));
        arrayList.add("height=" + this.height);
        arrayList.add("width=" + this.width);
        h0 = z.h0(arrayList, ", ", "Video{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Video(String url, int i2, int i3, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(url, "url");
        m.h(unknownFields, "unknownFields");
        this.url = url;
        this.height = i2;
        this.width = i3;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m520newBuilder() {
        throw new AssertionError();
    }
}