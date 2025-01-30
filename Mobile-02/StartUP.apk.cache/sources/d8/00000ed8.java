package com.coinbase.android.apiv3.generated.resources;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.resources.Asset;
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
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: Asset.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 =2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002=>B¥\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b;\u0010<J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ«\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u00072\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b'\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b*\u0010\fR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b.\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b/\u0010\u000fR\u001c\u0010\u001d\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u001c\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010%\u001a\u0004\b3\u0010\u000fR\u001c\u0010\u0019\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b4\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b5\u0010\u000fR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00106\u001a\u0004\b7\u00108R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b9\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b:\u0010\u000f¨\u0006?"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Asset;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "id", ApiConstants.NAME, "symbol", "slug", "image_url", "address_regex", "name_service_regex", "uri_scheme", "exponent", "color", "Lcom/coinbase/android/apiv3/generated/resources/DestinationTag;", "destination_tag", ApiConstants.DESCRIPTION, "listed", "", "Lcom/coinbase/android/apiv3/generated/resources/Asset$ResourceUrl;", "resource_urls", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/DestinationTag;Ljava/lang/String;ZLjava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/resources/Asset;", "Ljava/lang/String;", "getName", "getSlug", "getAddress_regex", "I", "getExponent", "Lcom/coinbase/android/apiv3/generated/resources/DestinationTag;", "getDestination_tag", "()Lcom/coinbase/android/apiv3/generated/resources/DestinationTag;", "getSymbol", "getUri_scheme", "Z", "getListed", "()Z", "getDescription", "getColor", "getId", "Ljava/util/List;", "getResource_urls", "()Ljava/util/List;", "getName_service_regex", "getImage_url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/DestinationTag;Ljava/lang/String;ZLjava/util/List;Lj/i;)V", "Companion", "ResourceUrl", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Asset extends a {
    public static final ProtoAdapter<Asset> ADAPTER;
    public static final Parcelable.Creator<Asset> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "addressRegex", tag = 6)
    private final String address_regex;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    private final String color;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    private final String description;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.DestinationTag#ADAPTER", jsonName = "destinationTag", tag = 11)
    private final DestinationTag destination_tag;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    private final int exponent;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 5)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 13)
    private final boolean listed;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String name;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "nameServiceRegex", tag = 7)
    private final String name_service_regex;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Asset$ResourceUrl#ADAPTER", jsonName = "resourceUrls", label = p.a.REPEATED, tag = 14)
    private final List<ResourceUrl> resource_urls;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String slug;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String symbol;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "uriScheme", tag = 8)
    private final String uri_scheme;

    /* compiled from: Asset.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Asset$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/Asset;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Asset.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Asset$ResourceUrl;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "type", "link", MessageBundle.TITLE_ENTRY, "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/resources/Asset$ResourceUrl;", "Ljava/lang/String;", "getTitle", "getType", "getLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class ResourceUrl extends a {
        public static final ProtoAdapter<ResourceUrl> ADAPTER;
        public static final Parcelable.Creator<ResourceUrl> CREATOR;
        public static final Companion Companion = new Companion(null);
        @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
        private final String link;
        @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
        private final String title;
        @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        private final String type;

        /* compiled from: Asset.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Asset$ResourceUrl$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/Asset$ResourceUrl;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            ProtoAdapter<ResourceUrl> protoAdapter = new ProtoAdapter<ResourceUrl>(c.LENGTH_DELIMITED, e0.b(ResourceUrl.class), "type.googleapis.com/coinbase.public_api.resources.Asset.ResourceUrl") { // from class: com.coinbase.android.apiv3.generated.resources.Asset$ResourceUrl$Companion$ADAPTER$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Asset.ResourceUrl decode(k reader) {
                    m.h(reader, "reader");
                    long d2 = reader.d();
                    String str = "";
                    String str2 = "";
                    String str3 = str2;
                    while (true) {
                        int g2 = reader.g();
                        if (g2 == -1) {
                            return new Asset.ResourceUrl(str, str2, str3, reader.e(d2));
                        }
                        if (g2 == 1) {
                            str = ProtoAdapter.STRING.decode(reader);
                        } else if (g2 == 2) {
                            str2 = ProtoAdapter.STRING.decode(reader);
                        } else if (g2 != 3) {
                            reader.m(g2);
                        } else {
                            str3 = ProtoAdapter.STRING.decode(reader);
                        }
                    }
                }

                @Override // com.squareup.wire.ProtoAdapter
                public void encode(l writer, Asset.ResourceUrl value) {
                    m.h(writer, "writer");
                    m.h(value, "value");
                    if (!m.c(value.getType(), "")) {
                        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getType());
                    }
                    if (!m.c(value.getLink(), "")) {
                        ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getLink());
                    }
                    if (!m.c(value.getTitle(), "")) {
                        ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getTitle());
                    }
                    writer.a(value.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public int encodedSize(Asset.ResourceUrl value) {
                    m.h(value, "value");
                    if (m.c(value.getType(), "")) {
                        return 0;
                    }
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getType());
                    if (!m.c(value.getLink(), "")) {
                        r2 = (m.c(value.getTitle(), "") ? 0 : protoAdapter2.encodedSizeWithTag(3, value.getTitle()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(2, value.getLink());
                    }
                    return r2 + encodedSizeWithTag;
                }

                @Override // com.squareup.wire.ProtoAdapter
                public Asset.ResourceUrl redact(Asset.ResourceUrl value) {
                    m.h(value, "value");
                    return Asset.ResourceUrl.copy$default(value, null, null, null, i.a, 7, null);
                }
            };
            ADAPTER = protoAdapter;
            CREATOR = a.Companion.a(protoAdapter);
        }

        public ResourceUrl() {
            this(null, null, null, null, 15, null);
        }

        public /* synthetic */ ResourceUrl(String str, String str2, String str3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? i.a : iVar);
        }

        public static /* synthetic */ ResourceUrl copy$default(ResourceUrl resourceUrl, String str, String str2, String str3, i iVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = resourceUrl.type;
            }
            if ((i2 & 2) != 0) {
                str2 = resourceUrl.link;
            }
            if ((i2 & 4) != 0) {
                str3 = resourceUrl.title;
            }
            if ((i2 & 8) != 0) {
                iVar = resourceUrl.unknownFields();
            }
            return resourceUrl.copy(str, str2, str3, iVar);
        }

        public final ResourceUrl copy(String type, String link, String title, i unknownFields) {
            m.h(type, "type");
            m.h(link, "link");
            m.h(title, "title");
            m.h(unknownFields, "unknownFields");
            return new ResourceUrl(type, link, title, unknownFields);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ResourceUrl) {
                ResourceUrl resourceUrl = (ResourceUrl) obj;
                return m.c(unknownFields(), resourceUrl.unknownFields()) && m.c(this.type, resourceUrl.type) && m.c(this.link, resourceUrl.link) && m.c(this.title, resourceUrl.title);
            }
            return false;
        }

        public final String getLink() {
            return this.link;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = (((((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37) + this.link.hashCode()) * 37) + this.title.hashCode();
                this.hashCode = hashCode;
                return hashCode;
            }
            return i2;
        }

        @Override // com.squareup.wire.g
        public /* bridge */ /* synthetic */ g.a newBuilder() {
            return (g.a) m524newBuilder();
        }

        @Override // com.squareup.wire.g
        public String toString() {
            String h0;
            ArrayList arrayList = new ArrayList();
            arrayList.add("type=" + b.c(this.type));
            arrayList.add("link=" + b.c(this.link));
            arrayList.add("title=" + b.c(this.title));
            h0 = z.h0(arrayList, ", ", "ResourceUrl{", "}", 0, null, null, 56, null);
            return h0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceUrl(String type, String link, String title, i unknownFields) {
            super(ADAPTER, unknownFields);
            m.h(type, "type");
            m.h(link, "link");
            m.h(title, "title");
            m.h(unknownFields, "unknownFields");
            this.type = type;
            this.link = link;
            this.title = title;
        }

        /* renamed from: newBuilder */
        public /* synthetic */ Void m524newBuilder() {
            throw new AssertionError();
        }
    }

    static {
        ProtoAdapter<Asset> protoAdapter = new ProtoAdapter<Asset>(c.LENGTH_DELIMITED, e0.b(Asset.class), "type.googleapis.com/coinbase.public_api.resources.Asset") { // from class: com.coinbase.android.apiv3.generated.resources.Asset$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Asset decode(k reader) {
                ArrayList arrayList;
                m.h(reader, "reader");
                ArrayList arrayList2 = new ArrayList();
                long d2 = reader.d();
                String str = "";
                ArrayList arrayList3 = arrayList2;
                int i2 = 0;
                boolean z = false;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                String str9 = str8;
                DestinationTag destinationTag = null;
                String str10 = str9;
                while (true) {
                    int g2 = reader.g();
                    String str11 = str9;
                    if (g2 == -1) {
                        return new Asset(str, str2, str10, str3, str4, str5, str6, str7, i2, str8, destinationTag, str11, z, arrayList3, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            arrayList = arrayList3;
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            arrayList = arrayList3;
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            arrayList = arrayList3;
                            str10 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            arrayList = arrayList3;
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            arrayList = arrayList3;
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            arrayList = arrayList3;
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            arrayList = arrayList3;
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            arrayList = arrayList3;
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            arrayList = arrayList3;
                            i2 = ProtoAdapter.INT32.decode(reader).intValue();
                            break;
                        case 10:
                            arrayList = arrayList3;
                            str8 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 11:
                            arrayList = arrayList3;
                            destinationTag = DestinationTag.ADAPTER.decode(reader);
                            break;
                        case 12:
                            arrayList = arrayList3;
                            str11 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 13:
                            arrayList = arrayList3;
                            z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            break;
                        case 14:
                            arrayList = arrayList3;
                            arrayList.add(Asset.ResourceUrl.ADAPTER.decode(reader));
                            break;
                        default:
                            arrayList = arrayList3;
                            reader.m(g2);
                            break;
                    }
                    arrayList3 = arrayList;
                    str9 = str11;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Asset value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getId(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getId());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getName());
                }
                if (!m.c(value.getSymbol(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getSymbol());
                }
                if (!m.c(value.getSlug(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getSlug());
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getImage_url());
                }
                if (!m.c(value.getAddress_regex(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getAddress_regex());
                }
                if (!m.c(value.getName_service_regex(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getName_service_regex());
                }
                if (!m.c(value.getUri_scheme(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.getUri_scheme());
                }
                if (value.getExponent() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 9, Integer.valueOf(value.getExponent()));
                }
                if (!m.c(value.getColor(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 10, value.getColor());
                }
                if (value.getDestination_tag() != null) {
                    DestinationTag.ADAPTER.encodeWithTag(writer, 11, value.getDestination_tag());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 12, value.getDescription());
                }
                if (value.getListed()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 13, Boolean.valueOf(value.getListed()));
                }
                Asset.ResourceUrl.ADAPTER.asRepeated().encodeWithTag(writer, 14, value.getResource_urls());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Asset value) {
                int Q;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                m.h(value, "value");
                if (m.c(value.getId(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getId());
                if (m.c(value.getName(), "")) {
                    i12 = 0;
                } else {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getName());
                    if (m.c(value.getSymbol(), "")) {
                        i11 = 0;
                    } else {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getSymbol());
                        if (m.c(value.getSlug(), "")) {
                            i10 = 0;
                        } else {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getSlug());
                            if (m.c(value.getImage_url(), "")) {
                                i9 = 0;
                            } else {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getImage_url());
                                if (m.c(value.getAddress_regex(), "")) {
                                    i8 = 0;
                                } else {
                                    int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(6, value.getAddress_regex());
                                    if (m.c(value.getName_service_regex(), "")) {
                                        i7 = 0;
                                    } else {
                                        int encodedSizeWithTag7 = protoAdapter2.encodedSizeWithTag(7, value.getName_service_regex());
                                        if (m.c(value.getUri_scheme(), "")) {
                                            i6 = 0;
                                        } else {
                                            int encodedSizeWithTag8 = protoAdapter2.encodedSizeWithTag(8, value.getUri_scheme());
                                            if (value.getExponent() == 0) {
                                                i5 = 0;
                                            } else {
                                                int encodedSizeWithTag9 = ProtoAdapter.INT32.encodedSizeWithTag(9, Integer.valueOf(value.getExponent()));
                                                if (m.c(value.getColor(), "")) {
                                                    i4 = 0;
                                                } else {
                                                    int encodedSizeWithTag10 = protoAdapter2.encodedSizeWithTag(10, value.getColor());
                                                    if (value.getDestination_tag() == null) {
                                                        i3 = 0;
                                                    } else {
                                                        int encodedSizeWithTag11 = DestinationTag.ADAPTER.encodedSizeWithTag(11, value.getDestination_tag());
                                                        if (m.c(value.getDescription(), "")) {
                                                            i2 = 0;
                                                        } else {
                                                            int encodedSizeWithTag12 = protoAdapter2.encodedSizeWithTag(12, value.getDescription());
                                                            if (value.getListed()) {
                                                                Q = value.unknownFields().Q() + ProtoAdapter.BOOL.encodedSizeWithTag(13, Boolean.valueOf(value.getListed())) + Asset.ResourceUrl.ADAPTER.asRepeated().encodedSizeWithTag(14, value.getResource_urls());
                                                            } else {
                                                                Q = 0;
                                                            }
                                                            i2 = encodedSizeWithTag12 + Q;
                                                        }
                                                        i3 = encodedSizeWithTag11 + i2;
                                                    }
                                                    i4 = i3 + encodedSizeWithTag10;
                                                }
                                                i5 = i4 + encodedSizeWithTag9;
                                            }
                                            i6 = i5 + encodedSizeWithTag8;
                                        }
                                        i7 = i6 + encodedSizeWithTag7;
                                    }
                                    i8 = i7 + encodedSizeWithTag6;
                                }
                                i9 = i8 + encodedSizeWithTag5;
                            }
                            i10 = i9 + encodedSizeWithTag4;
                        }
                        i11 = i10 + encodedSizeWithTag3;
                    }
                    i12 = i11 + encodedSizeWithTag2;
                }
                return i12 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Asset redact(Asset value) {
                Asset copy;
                m.h(value, "value");
                DestinationTag destination_tag = value.getDestination_tag();
                copy = value.copy((r32 & 1) != 0 ? value.id : null, (r32 & 2) != 0 ? value.name : null, (r32 & 4) != 0 ? value.symbol : null, (r32 & 8) != 0 ? value.slug : null, (r32 & 16) != 0 ? value.image_url : null, (r32 & 32) != 0 ? value.address_regex : null, (r32 & 64) != 0 ? value.name_service_regex : null, (r32 & 128) != 0 ? value.uri_scheme : null, (r32 & 256) != 0 ? value.exponent : 0, (r32 & 512) != 0 ? value.color : null, (r32 & 1024) != 0 ? value.destination_tag : destination_tag != null ? DestinationTag.ADAPTER.redact(destination_tag) : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? value.description : null, (r32 & 4096) != 0 ? value.listed : false, (r32 & PKIFailureInfo.certRevoked) != 0 ? value.resource_urls : b.a(value.getResource_urls(), Asset.ResourceUrl.ADAPTER), (r32 & 16384) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Asset() {
        this(null, null, null, null, null, null, null, null, 0, null, null, null, false, null, null, 32767, null);
    }

    public /* synthetic */ Asset(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, DestinationTag destinationTag, String str10, boolean z, List list, i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? 0 : i2, (i3 & 512) != 0 ? "" : str9, (i3 & 1024) != 0 ? null : destinationTag, (i3 & PKIFailureInfo.wrongIntegrity) == 0 ? str10 : "", (i3 & 4096) == 0 ? z : false, (i3 & PKIFailureInfo.certRevoked) != 0 ? r.g() : list, (i3 & 16384) != 0 ? i.a : iVar);
    }

    public final Asset copy(String id, String name, String symbol, String slug, String image_url, String address_regex, String name_service_regex, String uri_scheme, int i2, String color, DestinationTag destinationTag, String description, boolean z, List<ResourceUrl> resource_urls, i unknownFields) {
        m.h(id, "id");
        m.h(name, "name");
        m.h(symbol, "symbol");
        m.h(slug, "slug");
        m.h(image_url, "image_url");
        m.h(address_regex, "address_regex");
        m.h(name_service_regex, "name_service_regex");
        m.h(uri_scheme, "uri_scheme");
        m.h(color, "color");
        m.h(description, "description");
        m.h(resource_urls, "resource_urls");
        m.h(unknownFields, "unknownFields");
        return new Asset(id, name, symbol, slug, image_url, address_regex, name_service_regex, uri_scheme, i2, color, destinationTag, description, z, resource_urls, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Asset) {
            Asset asset = (Asset) obj;
            return m.c(unknownFields(), asset.unknownFields()) && m.c(this.id, asset.id) && m.c(this.name, asset.name) && m.c(this.symbol, asset.symbol) && m.c(this.slug, asset.slug) && m.c(this.image_url, asset.image_url) && m.c(this.address_regex, asset.address_regex) && m.c(this.name_service_regex, asset.name_service_regex) && m.c(this.uri_scheme, asset.uri_scheme) && this.exponent == asset.exponent && m.c(this.color, asset.color) && m.c(this.destination_tag, asset.destination_tag) && m.c(this.description, asset.description) && this.listed == asset.listed && m.c(this.resource_urls, asset.resource_urls);
        }
        return false;
    }

    public final String getAddress_regex() {
        return this.address_regex;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getDescription() {
        return this.description;
    }

    public final DestinationTag getDestination_tag() {
        return this.destination_tag;
    }

    public final int getExponent() {
        return this.exponent;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final boolean getListed() {
        return this.listed;
    }

    public final String getName() {
        return this.name;
    }

    public final String getName_service_regex() {
        return this.name_service_regex;
    }

    public final List<ResourceUrl> getResource_urls() {
        return this.resource_urls;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public final String getUri_scheme() {
        return this.uri_scheme;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((((((((((((unknownFields().hashCode() * 37) + this.id.hashCode()) * 37) + this.name.hashCode()) * 37) + this.symbol.hashCode()) * 37) + this.slug.hashCode()) * 37) + this.image_url.hashCode()) * 37) + this.address_regex.hashCode()) * 37) + this.name_service_regex.hashCode()) * 37) + this.uri_scheme.hashCode()) * 37) + this.exponent) * 37) + this.color.hashCode()) * 37;
            DestinationTag destinationTag = this.destination_tag;
            int hashCode2 = ((((((hashCode + (destinationTag != null ? destinationTag.hashCode() : 0)) * 37) + this.description.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.listed)) * 37) + this.resource_urls.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m523newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + b.c(this.id));
        arrayList.add("name=" + b.c(this.name));
        arrayList.add("symbol=" + b.c(this.symbol));
        arrayList.add("slug=" + b.c(this.slug));
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("address_regex=" + b.c(this.address_regex));
        arrayList.add("name_service_regex=" + b.c(this.name_service_regex));
        arrayList.add("uri_scheme=" + b.c(this.uri_scheme));
        arrayList.add("exponent=" + this.exponent);
        arrayList.add("color=" + b.c(this.color));
        if (this.destination_tag != null) {
            arrayList.add("destination_tag=" + this.destination_tag);
        }
        arrayList.add("description=" + b.c(this.description));
        arrayList.add("listed=" + this.listed);
        if (!this.resource_urls.isEmpty()) {
            arrayList.add("resource_urls=" + this.resource_urls);
        }
        h0 = z.h0(arrayList, ", ", "Asset{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m523newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Asset(String id, String name, String symbol, String slug, String image_url, String address_regex, String name_service_regex, String uri_scheme, int i2, String color, DestinationTag destinationTag, String description, boolean z, List<ResourceUrl> resource_urls, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(id, "id");
        m.h(name, "name");
        m.h(symbol, "symbol");
        m.h(slug, "slug");
        m.h(image_url, "image_url");
        m.h(address_regex, "address_regex");
        m.h(name_service_regex, "name_service_regex");
        m.h(uri_scheme, "uri_scheme");
        m.h(color, "color");
        m.h(description, "description");
        m.h(resource_urls, "resource_urls");
        m.h(unknownFields, "unknownFields");
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.image_url = image_url;
        this.address_regex = address_regex;
        this.name_service_regex = name_service_regex;
        this.uri_scheme = uri_scheme;
        this.exponent = i2;
        this.color = color;
        this.destination_tag = destinationTag;
        this.description = description;
        this.listed = z;
        this.resource_urls = resource_urls;
    }
}