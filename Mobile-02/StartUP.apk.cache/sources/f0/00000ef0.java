package com.coinbase.android.apiv3.generated.resources;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Ref;
import com.coinbase.android.apiv3.generated.resources.NewsArticle;
import com.google.protobuf.u;
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
import org.spongycastle.i18n.MessageBundle;

/* compiled from: NewsArticle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 22\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000223B\u007f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b0\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0085\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\r2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00172\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b'\u0010\u000fR\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\"\u001a\u0004\b(\u0010$R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b)\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b*\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b+\u0010\u000fR\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\"\u001a\u0004\b,\u0010$R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/NewsArticle;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", "link_url", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "Lcom/google/protobuf/u;", "publication_date", "attribution_source", "", "Lcom/coinbase/android/apiv3/generated/resources/NewsArticleImage;", "images", "Lcom/coinbase/android/apiv3/generated/common/Ref;", "related_assets", "Lcom/coinbase/android/apiv3/generated/resources/NewsArticle$RelatedAsset;", "hydrated_related_assets", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/protobuf/u;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/resources/NewsArticle;", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "Ljava/lang/String;", "getTitle", "getDescription", "getHydrated_related_assets", "getAttribution_source", "getId", "getLink_url", "getRelated_assets", "Lcom/google/protobuf/u;", "getPublication_date", "()Lcom/google/protobuf/u;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/protobuf/u;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lj/i;)V", "Companion", "RelatedAsset", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class NewsArticle extends a {
    public static final ProtoAdapter<NewsArticle> ADAPTER;
    public static final Parcelable.Creator<NewsArticle> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "attributionSource", tag = 6)
    private final String attribution_source;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String description;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.NewsArticle$RelatedAsset#ADAPTER", jsonName = "hydratedRelatedAssets", label = p.a.REPEATED, tag = 9)
    private final List<RelatedAsset> hydrated_related_assets;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.NewsArticleImage#ADAPTER", label = p.a.REPEATED, tag = 7)
    private final List<NewsArticleImage> images;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "linkUrl", tag = 2)
    private final String link_url;
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "publicationDate", tag = 5)
    private final u publication_date;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Ref#ADAPTER", jsonName = "relatedAssets", label = p.a.REPEATED, tag = 8)
    private final List<Ref> related_assets;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String title;

    /* compiled from: NewsArticle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/NewsArticle$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/NewsArticle;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: NewsArticle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/NewsArticle$RelatedAsset;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", ApiConstants.NAME, "slug", "color", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/resources/NewsArticle$RelatedAsset;", "Ljava/lang/String;", "getId", "getColor", "getSlug", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class RelatedAsset extends a {
        public static final ProtoAdapter<RelatedAsset> ADAPTER;
        public static final Parcelable.Creator<RelatedAsset> CREATOR;
        public static final Companion Companion = new Companion(null);
        @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
        private final String color;
        @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        private final String id;
        @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
        private final String name;
        @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
        private final String slug;

        /* compiled from: NewsArticle.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/NewsArticle$RelatedAsset$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/NewsArticle$RelatedAsset;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            ProtoAdapter<RelatedAsset> protoAdapter = new ProtoAdapter<RelatedAsset>(c.LENGTH_DELIMITED, e0.b(RelatedAsset.class), "type.googleapis.com/coinbase.public_api.resources.NewsArticle.RelatedAsset") { // from class: com.coinbase.android.apiv3.generated.resources.NewsArticle$RelatedAsset$Companion$ADAPTER$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public NewsArticle.RelatedAsset decode(k reader) {
                    m.h(reader, "reader");
                    long d2 = reader.d();
                    String str = "";
                    String str2 = str;
                    String str3 = str2;
                    String str4 = str3;
                    while (true) {
                        int g2 = reader.g();
                        if (g2 == -1) {
                            return new NewsArticle.RelatedAsset(str, str2, str3, str4, reader.e(d2));
                        }
                        if (g2 == 1) {
                            str = ProtoAdapter.STRING.decode(reader);
                        } else if (g2 == 2) {
                            str2 = ProtoAdapter.STRING.decode(reader);
                        } else if (g2 == 3) {
                            str3 = ProtoAdapter.STRING.decode(reader);
                        } else if (g2 != 4) {
                            reader.m(g2);
                        } else {
                            str4 = ProtoAdapter.STRING.decode(reader);
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(l writer, NewsArticle.RelatedAsset value) {
                    m.h(writer, "writer");
                    m.h(value, "value");
                    if (!m.c(value.getId(), "")) {
                        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                    }
                    if (!m.c(value.getName(), "")) {
                        ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getName());
                    }
                    if (!m.c(value.getSlug(), "")) {
                        ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getSlug());
                    }
                    if (!m.c(value.getColor(), "")) {
                        ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getColor());
                    }
                    writer.a(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(NewsArticle.RelatedAsset value) {
                    m.h(value, "value");
                    if (m.c(value.getId(), "")) {
                        return 0;
                    }
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                    if (!m.c(value.getName(), "")) {
                        int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getName());
                        if (!m.c(value.getSlug(), "")) {
                            r2 = (m.c(value.getColor(), "") ? 0 : protoAdapter2.encodedSizeWithTag(4, value.getColor()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(3, value.getSlug());
                        }
                        r2 += encodedSizeWithTag2;
                    }
                    return r2 + encodedSizeWithTag;
                }

                @Override // com.squareup.wire.ProtoAdapter
                public NewsArticle.RelatedAsset redact(NewsArticle.RelatedAsset value) {
                    m.h(value, "value");
                    return NewsArticle.RelatedAsset.copy$default(value, null, null, null, null, i.a, 15, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = a.Companion.a(protoAdapter);
        }

        public RelatedAsset() {
            this(null, null, null, null, null, 31, null);
        }

        public /* synthetic */ RelatedAsset(String str, String str2, String str3, String str4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? i.a : iVar);
        }

        public static /* synthetic */ RelatedAsset copy$default(RelatedAsset relatedAsset, String str, String str2, String str3, String str4, i iVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = relatedAsset.id;
            }
            if ((i2 & 2) != 0) {
                str2 = relatedAsset.name;
            }
            String str5 = str2;
            if ((i2 & 4) != 0) {
                str3 = relatedAsset.slug;
            }
            String str6 = str3;
            if ((i2 & 8) != 0) {
                str4 = relatedAsset.color;
            }
            String str7 = str4;
            if ((i2 & 16) != 0) {
                iVar = relatedAsset.unknownFields();
            }
            return relatedAsset.copy(str, str5, str6, str7, iVar);
        }

        public final RelatedAsset copy(String id, String name, String slug, String color, i unknownFields) {
            m.h(id, "id");
            m.h(name, "name");
            m.h(slug, "slug");
            m.h(color, "color");
            m.h(unknownFields, "unknownFields");
            return new RelatedAsset(id, name, slug, color, unknownFields);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof RelatedAsset) {
                RelatedAsset relatedAsset = (RelatedAsset) obj;
                return m.c(unknownFields(), relatedAsset.unknownFields()) && m.c(this.id, relatedAsset.id) && m.c(this.name, relatedAsset.name) && m.c(this.slug, relatedAsset.slug) && m.c(this.color, relatedAsset.color);
            }
            return false;
        }

        public final String getColor() {
            return this.color;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getSlug() {
            return this.slug;
        }

        public int hashCode() {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = (((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.name.hashCode()) * 37) + this.slug.hashCode()) * 37) + this.color.hashCode();
                this.hashCode = hashCode;
                return hashCode;
            }
            return i2;
        }

        @Override // com.squareup.wire.g
        public /* bridge */ /* synthetic */ g.a newBuilder() {
            return (g.a) m531newBuilder();
        }

        @Override // com.squareup.wire.g
        public String toString() {
            String h0;
            ArrayList arrayList = new ArrayList();
            arrayList.add("id=" + b.c(this.id));
            arrayList.add("name=" + b.c(this.name));
            arrayList.add("slug=" + b.c(this.slug));
            arrayList.add("color=" + b.c(this.color));
            h0 = z.h0(arrayList, ", ", "RelatedAsset{", "}", 0, null, null, 56, null);
            return h0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RelatedAsset(String id, String name, String slug, String color, i unknownFields) {
            super(ADAPTER, unknownFields);
            m.h(id, "id");
            m.h(name, "name");
            m.h(slug, "slug");
            m.h(color, "color");
            m.h(unknownFields, "unknownFields");
            this.id = id;
            this.name = name;
            this.slug = slug;
            this.color = color;
        }

        /* renamed from: newBuilder */
        public /* synthetic */ Void m531newBuilder() {
            throw new AssertionError();
        }
    }

    static {
        ProtoAdapter<NewsArticle> protoAdapter = new ProtoAdapter<NewsArticle>(c.LENGTH_DELIMITED, e0.b(NewsArticle.class), "type.googleapis.com/coinbase.public_api.resources.NewsArticle") { // from class: com.coinbase.android.apiv3.generated.resources.NewsArticle$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public NewsArticle decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                u uVar = null;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new NewsArticle(str, str5, str2, str3, uVar, str4, arrayList, arrayList2, arrayList3, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            uVar = u.a.decode(reader);
                            break;
                        case 6:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            arrayList.add(NewsArticleImage.ADAPTER.decode(reader));
                            break;
                        case 8:
                            arrayList2.add(Ref.ADAPTER.decode(reader));
                            break;
                        case 9:
                            arrayList3.add(NewsArticle.RelatedAsset.ADAPTER.decode(reader));
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, NewsArticle value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (!m.c(value.getLink_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getLink_url());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getTitle());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getDescription());
                }
                if (value.getPublication_date() != null) {
                    u.a.encodeWithTag(writer, 5, value.getPublication_date());
                }
                if (!m.c(value.getAttribution_source(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getAttribution_source());
                }
                NewsArticleImage.ADAPTER.asRepeated().encodeWithTag(writer, 7, value.getImages());
                Ref.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.getRelated_assets());
                NewsArticle.RelatedAsset.ADAPTER.asRepeated().encodeWithTag(writer, 9, value.getHydrated_related_assets());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(NewsArticle value) {
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (!m.c(value.getLink_url(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getLink_url());
                    if (!m.c(value.getTitle(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getTitle());
                        if (!m.c(value.getDescription(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getDescription());
                            if (value.getPublication_date() != null) {
                                r2 = (m.c(value.getAttribution_source(), "") ? 0 : protoAdapter2.encodedSizeWithTag(6, value.getAttribution_source()) + NewsArticleImage.ADAPTER.asRepeated().encodedSizeWithTag(7, value.getImages()) + Ref.ADAPTER.asRepeated().encodedSizeWithTag(8, value.getRelated_assets()) + NewsArticle.RelatedAsset.ADAPTER.asRepeated().encodedSizeWithTag(9, value.getHydrated_related_assets()) + value.unknownFields().Q()) + u.a.encodedSizeWithTag(5, value.getPublication_date());
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
            public NewsArticle redact(NewsArticle value) {
                NewsArticle copy;
                m.h(value, "value");
                u publication_date = value.getPublication_date();
                copy = value.copy((r22 & 1) != 0 ? value.id : null, (r22 & 2) != 0 ? value.link_url : null, (r22 & 4) != 0 ? value.title : null, (r22 & 8) != 0 ? value.description : null, (r22 & 16) != 0 ? value.publication_date : publication_date != null ? u.a.redact(publication_date) : null, (r22 & 32) != 0 ? value.attribution_source : null, (r22 & 64) != 0 ? value.images : b.a(value.getImages(), NewsArticleImage.ADAPTER), (r22 & 128) != 0 ? value.related_assets : b.a(value.getRelated_assets(), Ref.ADAPTER), (r22 & 256) != 0 ? value.hydrated_related_assets : b.a(value.getHydrated_related_assets(), NewsArticle.RelatedAsset.ADAPTER), (r22 & 512) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public NewsArticle() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public /* synthetic */ NewsArticle(String str, String str2, String str3, String str4, u uVar, String str5, List list, List list2, List list3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? null : uVar, (i2 & 32) == 0 ? str5 : "", (i2 & 64) != 0 ? r.g() : list, (i2 & 128) != 0 ? r.g() : list2, (i2 & 256) != 0 ? r.g() : list3, (i2 & 512) != 0 ? i.a : iVar);
    }

    public final NewsArticle copy(String id, String link_url, String title, String description, u uVar, String attribution_source, List<NewsArticleImage> images, List<Ref> related_assets, List<RelatedAsset> hydrated_related_assets, i unknownFields) {
        m.h(id, "id");
        m.h(link_url, "link_url");
        m.h(title, "title");
        m.h(description, "description");
        m.h(attribution_source, "attribution_source");
        m.h(images, "images");
        m.h(related_assets, "related_assets");
        m.h(hydrated_related_assets, "hydrated_related_assets");
        m.h(unknownFields, "unknownFields");
        return new NewsArticle(id, link_url, title, description, uVar, attribution_source, images, related_assets, hydrated_related_assets, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NewsArticle) {
            NewsArticle newsArticle = (NewsArticle) obj;
            return m.c(unknownFields(), newsArticle.unknownFields()) && m.c(this.id, newsArticle.id) && m.c(this.link_url, newsArticle.link_url) && m.c(this.title, newsArticle.title) && m.c(this.description, newsArticle.description) && m.c(this.publication_date, newsArticle.publication_date) && m.c(this.attribution_source, newsArticle.attribution_source) && m.c(this.images, newsArticle.images) && m.c(this.related_assets, newsArticle.related_assets) && m.c(this.hydrated_related_assets, newsArticle.hydrated_related_assets);
        }
        return false;
    }

    public final String getAttribution_source() {
        return this.attribution_source;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<RelatedAsset> getHydrated_related_assets() {
        return this.hydrated_related_assets;
    }

    public final String getId() {
        return this.id;
    }

    public final List<NewsArticleImage> getImages() {
        return this.images;
    }

    public final String getLink_url() {
        return this.link_url;
    }

    public final u getPublication_date() {
        return this.publication_date;
    }

    public final List<Ref> getRelated_assets() {
        return this.related_assets;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.link_url.hashCode()) * 37) + this.title.hashCode()) * 37) + this.description.hashCode()) * 37;
            u uVar = this.publication_date;
            int hashCode2 = ((((((((hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.attribution_source.hashCode()) * 37) + this.images.hashCode()) * 37) + this.related_assets.hashCode()) * 37) + this.hydrated_related_assets.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m530newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("link_url=" + b.c(this.link_url));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("description=" + b.c(this.description));
        if (this.publication_date != null) {
            arrayList.add("publication_date=" + this.publication_date);
        }
        arrayList.add("attribution_source=" + b.c(this.attribution_source));
        if (!this.images.isEmpty()) {
            arrayList.add("images=" + this.images);
        }
        if (!this.related_assets.isEmpty()) {
            arrayList.add("related_assets=" + this.related_assets);
        }
        if (!this.hydrated_related_assets.isEmpty()) {
            arrayList.add("hydrated_related_assets=" + this.hydrated_related_assets);
        }
        h0 = z.h0(arrayList, ", ", "NewsArticle{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m530newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsArticle(String id, String link_url, String title, String description, u uVar, String attribution_source, List<NewsArticleImage> images, List<Ref> related_assets, List<RelatedAsset> hydrated_related_assets, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(link_url, "link_url");
        m.h(title, "title");
        m.h(description, "description");
        m.h(attribution_source, "attribution_source");
        m.h(images, "images");
        m.h(related_assets, "related_assets");
        m.h(hydrated_related_assets, "hydrated_related_assets");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.link_url = link_url;
        this.title = title;
        this.description = description;
        this.publication_date = uVar;
        this.attribution_source = attribution_source;
        this.images = images;
        this.related_assets = related_assets;
        this.hydrated_related_assets = hydrated_related_assets;
    }
}