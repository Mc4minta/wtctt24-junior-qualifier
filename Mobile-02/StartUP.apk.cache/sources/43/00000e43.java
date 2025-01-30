package com.coinbase.android.apiv3.generated.authed.tutorials;

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

/* compiled from: TutorialCard.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B;\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001c\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCard;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "content_url", "asset_icon_url", "Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCTA;", "cta", "background_color", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCTA;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCard;", "Ljava/lang/String;", "getBackground_color", "getAsset_icon_url", "getContent_url", "Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCTA;", "getCta", "()Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCTA;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCTA;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class TutorialCard extends a {
    public static final ProtoAdapter<TutorialCard> ADAPTER;
    public static final Parcelable.Creator<TutorialCard> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "assetIconUrl", tag = 2)
    private final String asset_icon_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "backgroundColor", tag = 4)
    private final String background_color;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "contentUrl", tag = 1)
    private final String content_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.tutorials.TutorialCTA#ADAPTER", tag = 3)
    private final TutorialCTA cta;

    /* compiled from: TutorialCard.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCard$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/tutorials/TutorialCard;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<TutorialCard> protoAdapter = new ProtoAdapter<TutorialCard>(c.LENGTH_DELIMITED, e0.b(TutorialCard.class), "type.googleapis.com/coinbase.public_api.authed.tutorials.TutorialCard") { // from class: com.coinbase.android.apiv3.generated.authed.tutorials.TutorialCard$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TutorialCard decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                TutorialCTA tutorialCTA = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new TutorialCard(str, str2, tutorialCTA, str3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        tutorialCTA = TutorialCTA.ADAPTER.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, TutorialCard value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getContent_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getContent_url());
                }
                if (!m.c(value.getAsset_icon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getAsset_icon_url());
                }
                if (value.getCta() != null) {
                    TutorialCTA.ADAPTER.encodeWithTag(writer, 3, value.getCta());
                }
                if (!m.c(value.getBackground_color(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getBackground_color());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(TutorialCard value) {
                m.h(value, "value");
                if (m.c(value.getContent_url(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getContent_url());
                if (!m.c(value.getAsset_icon_url(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getAsset_icon_url());
                    if (value.getCta() != null) {
                        r2 = (m.c(value.getBackground_color(), "") ? 0 : protoAdapter2.encodedSizeWithTag(4, value.getBackground_color()) + value.unknownFields().Q()) + TutorialCTA.ADAPTER.encodedSizeWithTag(3, value.getCta());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public TutorialCard redact(TutorialCard value) {
                m.h(value, "value");
                TutorialCTA cta = value.getCta();
                return TutorialCard.copy$default(value, null, null, cta != null ? TutorialCTA.ADAPTER.redact(cta) : null, null, i.a, 11, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public TutorialCard() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ TutorialCard(String str, String str2, TutorialCTA tutorialCTA, String str3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : tutorialCTA, (i2 & 8) == 0 ? str3 : "", (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ TutorialCard copy$default(TutorialCard tutorialCard, String str, String str2, TutorialCTA tutorialCTA, String str3, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tutorialCard.content_url;
        }
        if ((i2 & 2) != 0) {
            str2 = tutorialCard.asset_icon_url;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            tutorialCTA = tutorialCard.cta;
        }
        TutorialCTA tutorialCTA2 = tutorialCTA;
        if ((i2 & 8) != 0) {
            str3 = tutorialCard.background_color;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            iVar = tutorialCard.unknownFields();
        }
        return tutorialCard.copy(str, str4, tutorialCTA2, str5, iVar);
    }

    public final TutorialCard copy(String content_url, String asset_icon_url, TutorialCTA tutorialCTA, String background_color, i unknownFields) {
        m.h(content_url, "content_url");
        m.h(asset_icon_url, "asset_icon_url");
        m.h(background_color, "background_color");
        m.h(unknownFields, "unknownFields");
        return new TutorialCard(content_url, asset_icon_url, tutorialCTA, background_color, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TutorialCard) {
            TutorialCard tutorialCard = (TutorialCard) obj;
            return m.c(unknownFields(), tutorialCard.unknownFields()) && m.c(this.content_url, tutorialCard.content_url) && m.c(this.asset_icon_url, tutorialCard.asset_icon_url) && m.c(this.cta, tutorialCard.cta) && m.c(this.background_color, tutorialCard.background_color);
        }
        return false;
    }

    public final String getAsset_icon_url() {
        return this.asset_icon_url;
    }

    public final String getBackground_color() {
        return this.background_color;
    }

    public final String getContent_url() {
        return this.content_url;
    }

    public final TutorialCTA getCta() {
        return this.cta;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.content_url.hashCode()) * 37) + this.asset_icon_url.hashCode()) * 37;
            TutorialCTA tutorialCTA = this.cta;
            int hashCode2 = ((hashCode + (tutorialCTA != null ? tutorialCTA.hashCode() : 0)) * 37) + this.background_color.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m482newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("content_url=" + b.c(this.content_url));
        arrayList.add("asset_icon_url=" + b.c(this.asset_icon_url));
        if (this.cta != null) {
            arrayList.add("cta=" + this.cta);
        }
        arrayList.add("background_color=" + b.c(this.background_color));
        h0 = z.h0(arrayList, ", ", "TutorialCard{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TutorialCard(String content_url, String asset_icon_url, TutorialCTA tutorialCTA, String background_color, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(content_url, "content_url");
        m.h(asset_icon_url, "asset_icon_url");
        m.h(background_color, "background_color");
        m.h(unknownFields, "unknownFields");
        this.content_url = content_url;
        this.asset_icon_url = asset_icon_url;
        this.cta = tutorialCTA;
        this.background_color = background_color;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m482newBuilder() {
        throw new AssertionError();
    }
}