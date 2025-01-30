package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.caverock.androidsvg.SVGParser;
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

/* compiled from: MobileVideo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB+\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/VideoMedia;", SVGParser.XML_STYLESHEET_ATTR_MEDIA, "subtitles_srt", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;", "Ljava/util/List;", "getMedia", "()Ljava/util/List;", "Ljava/lang/String;", "getSubtitles_srt", "<init>", "(Ljava/util/List;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class MobileVideo extends a {
    public static final ProtoAdapter<MobileVideo> ADAPTER;
    public static final Parcelable.Creator<MobileVideo> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.VideoMedia#ADAPTER", label = p.a.REPEATED, tag = 1)
    private final List<VideoMedia> media;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "subtitlesSrt", tag = 2)
    private final String subtitles_srt;

    /* compiled from: MobileVideo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<MobileVideo> protoAdapter = new ProtoAdapter<MobileVideo>(c.LENGTH_DELIMITED, e0.b(MobileVideo.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.MobileVideo") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.MobileVideo$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MobileVideo decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new MobileVideo(arrayList, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        arrayList.add(VideoMedia.ADAPTER.decode(reader));
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, MobileVideo value) {
                m.h(writer, "writer");
                m.h(value, "value");
                VideoMedia.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getMedia());
                if (!m.c(value.getSubtitles_srt(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getSubtitles_srt());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(MobileVideo value) {
                int Q;
                m.h(value, "value");
                int encodedSizeWithTag = VideoMedia.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getMedia());
                if (m.c(value.getSubtitles_srt(), "")) {
                    Q = 0;
                } else {
                    Q = value.unknownFields().Q() + ProtoAdapter.STRING.encodedSizeWithTag(2, value.getSubtitles_srt());
                }
                return encodedSizeWithTag + Q;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public MobileVideo redact(MobileVideo value) {
                m.h(value, "value");
                return MobileVideo.copy$default(value, b.a(value.getMedia(), VideoMedia.ADAPTER), null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public MobileVideo() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ MobileVideo(List list, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MobileVideo copy$default(MobileVideo mobileVideo, List list, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = mobileVideo.media;
        }
        if ((i2 & 2) != 0) {
            str = mobileVideo.subtitles_srt;
        }
        if ((i2 & 4) != 0) {
            iVar = mobileVideo.unknownFields();
        }
        return mobileVideo.copy(list, str, iVar);
    }

    public final MobileVideo copy(List<VideoMedia> media, String subtitles_srt, i unknownFields) {
        m.h(media, "media");
        m.h(subtitles_srt, "subtitles_srt");
        m.h(unknownFields, "unknownFields");
        return new MobileVideo(media, subtitles_srt, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MobileVideo) {
            MobileVideo mobileVideo = (MobileVideo) obj;
            return m.c(unknownFields(), mobileVideo.unknownFields()) && m.c(this.media, mobileVideo.media) && m.c(this.subtitles_srt, mobileVideo.subtitles_srt);
        }
        return false;
    }

    public final List<VideoMedia> getMedia() {
        return this.media;
    }

    public final String getSubtitles_srt() {
        return this.subtitles_srt;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.media.hashCode()) * 37) + this.subtitles_srt.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m420newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.media.isEmpty()) {
            arrayList.add("media=" + this.media);
        }
        arrayList.add("subtitles_srt=" + b.c(this.subtitles_srt));
        h0 = z.h0(arrayList, ", ", "MobileVideo{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m420newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileVideo(List<VideoMedia> media, String subtitles_srt, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(media, "media");
        m.h(subtitles_srt, "subtitles_srt");
        m.h(unknownFields, "unknownFields");
        this.media = media;
        this.subtitles_srt = subtitles_srt;
    }
}