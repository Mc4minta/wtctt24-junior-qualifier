package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
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

/* compiled from: LoyaltyCardRow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&BM\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJS\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardRow;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "icon_url", "action_icon_url", "url", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;", "action_type", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardRow;", "Ljava/lang/String;", "getTitle", "getAction_icon_url", "getUrl", "getIcon_url", "getDescription", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;", "getAction_type", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoyaltyCardRow extends a {
    public static final ProtoAdapter<LoyaltyCardRow> ADAPTER;
    public static final Parcelable.Creator<LoyaltyCardRow> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "actionIconUrl", tag = 4)
    private final String action_icon_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyActionType#ADAPTER", jsonName = "actionType", tag = 6)
    private final LoyaltyActionType action_type;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", tag = 3)
    private final String icon_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String url;

    /* compiled from: LoyaltyCardRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardRow$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardRow;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LoyaltyCardRow> protoAdapter = new ProtoAdapter<LoyaltyCardRow>(c.LENGTH_DELIMITED, e0.b(LoyaltyCardRow.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.LoyaltyCardRow") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardRow$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCardRow decode(k reader) {
                m.h(reader, "reader");
                LoyaltyActionType loyaltyActionType = LoyaltyActionType.UNIVERSAL_LINK;
                long d2 = reader.d();
                LoyaltyActionType loyaltyActionType2 = loyaltyActionType;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoyaltyCardRow(str, str2, str3, str4, str5, loyaltyActionType2, reader.e(d2));
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
                            try {
                                loyaltyActionType2 = LoyaltyActionType.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoyaltyCardRow value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getTitle());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getDescription());
                }
                if (!m.c(value.getIcon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getIcon_url());
                }
                if (!m.c(value.getAction_icon_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getAction_icon_url());
                }
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getUrl());
                }
                if (value.getAction_type() != LoyaltyActionType.UNIVERSAL_LINK) {
                    LoyaltyActionType.ADAPTER.encodeWithTag(writer, 6, value.getAction_type());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoyaltyCardRow value) {
                m.h(value, "value");
                if (m.c(value.getTitle(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getTitle());
                if (!m.c(value.getDescription(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getDescription());
                    if (!m.c(value.getIcon_url(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getIcon_url());
                        if (!m.c(value.getAction_icon_url(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getAction_icon_url());
                            if (!m.c(value.getUrl(), "")) {
                                r2 = (value.getAction_type() != LoyaltyActionType.UNIVERSAL_LINK ? LoyaltyActionType.ADAPTER.encodedSizeWithTag(6, value.getAction_type()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(5, value.getUrl());
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
            public LoyaltyCardRow redact(LoyaltyCardRow value) {
                m.h(value, "value");
                return LoyaltyCardRow.copy$default(value, null, null, null, null, null, null, i.a, 63, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoyaltyCardRow() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ LoyaltyCardRow(String str, String str2, String str3, String str4, String str5, LoyaltyActionType loyaltyActionType, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? LoyaltyActionType.UNIVERSAL_LINK : loyaltyActionType, (i2 & 64) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoyaltyCardRow copy$default(LoyaltyCardRow loyaltyCardRow, String str, String str2, String str3, String str4, String str5, LoyaltyActionType loyaltyActionType, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loyaltyCardRow.title;
        }
        if ((i2 & 2) != 0) {
            str2 = loyaltyCardRow.description;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = loyaltyCardRow.icon_url;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = loyaltyCardRow.action_icon_url;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = loyaltyCardRow.url;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            loyaltyActionType = loyaltyCardRow.action_type;
        }
        LoyaltyActionType loyaltyActionType2 = loyaltyActionType;
        if ((i2 & 64) != 0) {
            iVar = loyaltyCardRow.unknownFields();
        }
        return loyaltyCardRow.copy(str, str6, str7, str8, str9, loyaltyActionType2, iVar);
    }

    public final LoyaltyCardRow copy(String title, String description, String icon_url, String action_icon_url, String url, LoyaltyActionType action_type, i unknownFields) {
        m.h(title, "title");
        m.h(description, "description");
        m.h(icon_url, "icon_url");
        m.h(action_icon_url, "action_icon_url");
        m.h(url, "url");
        m.h(action_type, "action_type");
        m.h(unknownFields, "unknownFields");
        return new LoyaltyCardRow(title, description, icon_url, action_icon_url, url, action_type, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoyaltyCardRow) {
            LoyaltyCardRow loyaltyCardRow = (LoyaltyCardRow) obj;
            return m.c(unknownFields(), loyaltyCardRow.unknownFields()) && m.c(this.title, loyaltyCardRow.title) && m.c(this.description, loyaltyCardRow.description) && m.c(this.icon_url, loyaltyCardRow.icon_url) && m.c(this.action_icon_url, loyaltyCardRow.action_icon_url) && m.c(this.url, loyaltyCardRow.url) && this.action_type == loyaltyCardRow.action_type;
        }
        return false;
    }

    public final String getAction_icon_url() {
        return this.action_icon_url;
    }

    public final LoyaltyActionType getAction_type() {
        return this.action_type;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((((unknownFields().hashCode() * 37) + this.title.hashCode()) * 37) + this.description.hashCode()) * 37) + this.icon_url.hashCode()) * 37) + this.action_icon_url.hashCode()) * 37) + this.url.hashCode()) * 37) + this.action_type.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m414newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("description=" + b.c(this.description));
        arrayList.add("icon_url=" + b.c(this.icon_url));
        arrayList.add("action_icon_url=" + b.c(this.action_icon_url));
        arrayList.add("url=" + b.c(this.url));
        arrayList.add("action_type=" + this.action_type);
        h0 = z.h0(arrayList, ", ", "LoyaltyCardRow{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m414newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoyaltyCardRow(String title, String description, String icon_url, String action_icon_url, String url, LoyaltyActionType action_type, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(title, "title");
        m.h(description, "description");
        m.h(icon_url, "icon_url");
        m.h(action_icon_url, "action_icon_url");
        m.h(url, "url");
        m.h(action_type, "action_type");
        m.h(unknownFields, "unknownFields");
        this.title = title;
        this.description = description;
        this.icon_url = icon_url;
        this.action_icon_url = action_icon_url;
        this.url = url;
        this.action_type = action_type;
    }
}