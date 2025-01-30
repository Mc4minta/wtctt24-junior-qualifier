package com.coinbase.android.apiv3.generated.unauthed;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.resources.NewsArticle;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
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

/* compiled from: GetNewsArticleResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001d\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/GetNewsArticleResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/resources/NewsArticle;", "article", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/resources/NewsArticle;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/GetNewsArticleResponse;", "Lcom/coinbase/android/apiv3/generated/resources/NewsArticle;", "getArticle", "()Lcom/coinbase/android/apiv3/generated/resources/NewsArticle;", "<init>", "(Lcom/coinbase/android/apiv3/generated/resources/NewsArticle;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetNewsArticleResponse extends a {
    public static final ProtoAdapter<GetNewsArticleResponse> ADAPTER;
    public static final Parcelable.Creator<GetNewsArticleResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.NewsArticle#ADAPTER", tag = 1)
    private final NewsArticle article;

    /* compiled from: GetNewsArticleResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/GetNewsArticleResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/GetNewsArticleResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetNewsArticleResponse> protoAdapter = new ProtoAdapter<GetNewsArticleResponse>(c.LENGTH_DELIMITED, e0.b(GetNewsArticleResponse.class), "type.googleapis.com/coinbase.public_api.unauthed.GetNewsArticleResponse") { // from class: com.coinbase.android.apiv3.generated.unauthed.GetNewsArticleResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetNewsArticleResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                NewsArticle newsArticle = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetNewsArticleResponse(newsArticle, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        newsArticle = NewsArticle.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetNewsArticleResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getArticle() != null) {
                    NewsArticle.ADAPTER.encodeWithTag(writer, 1, value.getArticle());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetNewsArticleResponse value) {
                m.h(value, "value");
                if (value.getArticle() == null) {
                    return 0;
                }
                return value.unknownFields().Q() + NewsArticle.ADAPTER.encodedSizeWithTag(1, value.getArticle());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetNewsArticleResponse redact(GetNewsArticleResponse value) {
                m.h(value, "value");
                NewsArticle article = value.getArticle();
                return value.copy(article != null ? NewsArticle.ADAPTER.redact(article) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetNewsArticleResponse() {
        this(null, null, 3, null);
    }

    public /* synthetic */ GetNewsArticleResponse(NewsArticle newsArticle, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : newsArticle, (i2 & 2) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetNewsArticleResponse copy$default(GetNewsArticleResponse getNewsArticleResponse, NewsArticle newsArticle, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            newsArticle = getNewsArticleResponse.article;
        }
        if ((i2 & 2) != 0) {
            iVar = getNewsArticleResponse.unknownFields();
        }
        return getNewsArticleResponse.copy(newsArticle, iVar);
    }

    public final GetNewsArticleResponse copy(NewsArticle newsArticle, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new GetNewsArticleResponse(newsArticle, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetNewsArticleResponse) {
            GetNewsArticleResponse getNewsArticleResponse = (GetNewsArticleResponse) obj;
            return m.c(unknownFields(), getNewsArticleResponse.unknownFields()) && m.c(this.article, getNewsArticleResponse.article);
        }
        return false;
    }

    public final NewsArticle getArticle() {
        return this.article;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            NewsArticle newsArticle = this.article;
            int hashCode2 = hashCode + (newsArticle != null ? newsArticle.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m541newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.article != null) {
            arrayList.add("article=" + this.article);
        }
        h0 = z.h0(arrayList, ", ", "GetNewsArticleResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetNewsArticleResponse(NewsArticle newsArticle, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.article = newsArticle;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m541newBuilder() {
        throw new AssertionError();
    }
}