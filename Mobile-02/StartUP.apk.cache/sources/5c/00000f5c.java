package com.coinbase.android.apiv3.generated.unauthed.loyalty;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.authed.b;
import com.coinbase.android.apiv3.generated.common.Amount;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: Campaign.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 @2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B³\u0001\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\b\b\u0002\u0010\u001d\u001a\u00020\r\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010 \u001a\u00020\r\u0012\b\b\u0002\u0010!\u001a\u00020\r\u0012\b\b\u0002\u0010\"\u001a\u00020\r\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ¹\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&R\u001c\u0010\u001e\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010'\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\u0019\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b,\u0010\u000fR\u001c\u0010\u001d\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b-\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b.\u0010\u000fR\u001c\u0010\u001c\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b/\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b0\u0010\u000fR\u001c\u0010 \u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010'\u001a\u0004\b1\u0010\u000fR\u001c\u0010\u001b\u001a\u00020\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b3\u00104R\u001c\u0010!\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010'\u001a\u0004\b5\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b6\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b7\u0010\u000fR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00108\u001a\u0004\b9\u0010:R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b;\u0010\u000fR\u001c\u0010\u001f\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010'\u001a\u0004\b<\u0010\u000fR\u001c\u0010\"\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010'\u001a\u0004\b=\u0010\u000f¨\u0006A"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/Campaign;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "id", "asset_slug", ApiConstants.NAME, "symbol", ApiConstants.DESCRIPTION, "Lcom/coinbase/android/apiv3/generated/common/Amount;", "total_reward_amount", "one_liner", "intro_text", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/CampaignStatus;", "status", "hero_web_url", "hero_mobile_url", "logo_url", "logo_white_url", "open_graph_title", "open_graph_description", "open_graph_image_url", "Lj/i;", "unknownFields", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/CampaignStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/Campaign;", "Ljava/lang/String;", "getLogo_url", "J", "getId", "()J", "getIntro_text", "getHero_mobile_url", "getSymbol", "getHero_web_url", "getDescription", "getOpen_graph_title", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/CampaignStatus;", "getStatus", "()Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/CampaignStatus;", "getOpen_graph_description", "getName", "getOne_liner", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getTotal_reward_amount", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getAsset_slug", "getLogo_white_url", "getOpen_graph_image_url", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/CampaignStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Campaign extends a {
    public static final ProtoAdapter<Campaign> ADAPTER;
    public static final Parcelable.Creator<Campaign> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "assetSlug", tag = 2)
    private final String asset_slug;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "heroMobileUrl", tag = 11)
    private final String hero_mobile_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "heroWebUrl", tag = 10)
    private final String hero_web_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    private final long id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "introText", tag = 8)
    private final String intro_text;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "logoUrl", tag = 12)
    private final String logo_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "logoWhiteUrl", tag = 13)
    private final String logo_white_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String name;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "oneLiner", tag = 7)
    private final String one_liner;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "openGraphDescription", tag = 15)
    private final String open_graph_description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "openGraphImageUrl", tag = 16)
    private final String open_graph_image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "openGraphTitle", tag = 14)
    private final String open_graph_title;
    @p(adapter = "com.coinbase.android.apiv3.generated.unauthed.loyalty.CampaignStatus#ADAPTER", tag = 9)
    private final CampaignStatus status;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String symbol;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "totalRewardAmount", tag = 6)
    private final Amount total_reward_amount;

    /* compiled from: Campaign.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/Campaign$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/loyalty/Campaign;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(Campaign.class);
        ProtoAdapter<Campaign> protoAdapter = new ProtoAdapter<Campaign>(cVar, b2, "type.googleapis.com/coinbase.public_api.unauthed.loyalty.Campaign") { // from class: com.coinbase.android.apiv3.generated.unauthed.loyalty.Campaign$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Campaign decode(k reader) {
                m.h(reader, "reader");
                CampaignStatus campaignStatus = CampaignStatus.UNKNOWN;
                long d2 = reader.d();
                CampaignStatus campaignStatus2 = campaignStatus;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                String str9 = str8;
                String str10 = str9;
                String str11 = str10;
                String str12 = str11;
                String str13 = str12;
                long j2 = 0;
                Amount amount = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Campaign(j2, str, str2, str3, str4, amount, str5, str6, campaignStatus2, str7, str8, str9, str10, str11, str12, str13, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            j2 = ProtoAdapter.INT64.decode(reader).longValue();
                            break;
                        case 2:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 7:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 9:
                            try {
                                campaignStatus2 = CampaignStatus.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 10:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 11:
                            str8 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 12:
                            str9 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 13:
                            str10 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 14:
                            str11 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 15:
                            str12 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 16:
                            str13 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Campaign value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getId() != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 1, Long.valueOf(value.getId()));
                }
                if (!m.c(value.getAsset_slug(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getAsset_slug());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getName());
                }
                if (!m.c(value.getSymbol(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getSymbol());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getDescription());
                }
                if (value.getTotal_reward_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 6, value.getTotal_reward_amount());
                }
                if (!m.c(value.getOne_liner(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getOne_liner());
                }
                if (!m.c(value.getIntro_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.getIntro_text());
                }
                if (value.getStatus() != CampaignStatus.UNKNOWN) {
                    CampaignStatus.ADAPTER.encodeWithTag(writer, 9, value.getStatus());
                }
                if (!m.c(value.getHero_web_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 10, value.getHero_web_url());
                }
                if (!m.c(value.getHero_mobile_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 11, value.getHero_mobile_url());
                }
                if (!m.c(value.getLogo_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 12, value.getLogo_url());
                }
                if (!m.c(value.getLogo_white_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 13, value.getLogo_white_url());
                }
                if (!m.c(value.getOpen_graph_title(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 14, value.getOpen_graph_title());
                }
                if (!m.c(value.getOpen_graph_description(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 15, value.getOpen_graph_description());
                }
                if (!m.c(value.getOpen_graph_image_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 16, value.getOpen_graph_image_url());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Campaign value) {
                int i2;
                int i3;
                int encodedSizeWithTag;
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                int i13;
                int i14;
                int i15;
                int i16;
                m.h(value, "value");
                if (value.getId() == 0) {
                    return 0;
                }
                int encodedSizeWithTag2 = ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(value.getId()));
                if (m.c(value.getAsset_slug(), "")) {
                    i2 = encodedSizeWithTag2;
                    i16 = 0;
                } else {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(2, value.getAsset_slug());
                    if (m.c(value.getName(), "")) {
                        i2 = encodedSizeWithTag2;
                        i3 = encodedSizeWithTag3;
                        i15 = 0;
                    } else {
                        int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(3, value.getName());
                        if (m.c(value.getSymbol(), "")) {
                            i2 = encodedSizeWithTag2;
                            i3 = encodedSizeWithTag3;
                            i14 = 0;
                        } else {
                            int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(4, value.getSymbol());
                            if (m.c(value.getDescription(), "")) {
                                i2 = encodedSizeWithTag2;
                                i3 = encodedSizeWithTag3;
                                i13 = 0;
                            } else {
                                int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(5, value.getDescription());
                                if (value.getTotal_reward_amount() == null) {
                                    i2 = encodedSizeWithTag2;
                                    i3 = encodedSizeWithTag3;
                                    i12 = 0;
                                } else {
                                    int encodedSizeWithTag7 = Amount.ADAPTER.encodedSizeWithTag(6, value.getTotal_reward_amount());
                                    if (m.c(value.getOne_liner(), "")) {
                                        i2 = encodedSizeWithTag2;
                                        i3 = encodedSizeWithTag3;
                                        i11 = 0;
                                    } else {
                                        int encodedSizeWithTag8 = protoAdapter2.encodedSizeWithTag(7, value.getOne_liner());
                                        if (m.c(value.getIntro_text(), "")) {
                                            i2 = encodedSizeWithTag2;
                                            i3 = encodedSizeWithTag3;
                                            i10 = 0;
                                        } else {
                                            int encodedSizeWithTag9 = protoAdapter2.encodedSizeWithTag(8, value.getIntro_text());
                                            if (value.getStatus() == CampaignStatus.UNKNOWN) {
                                                i2 = encodedSizeWithTag2;
                                                i3 = encodedSizeWithTag3;
                                                i9 = 0;
                                            } else {
                                                int encodedSizeWithTag10 = CampaignStatus.ADAPTER.encodedSizeWithTag(9, value.getStatus());
                                                if (m.c(value.getHero_web_url(), "")) {
                                                    i2 = encodedSizeWithTag2;
                                                    i3 = encodedSizeWithTag3;
                                                    i8 = 0;
                                                } else {
                                                    int encodedSizeWithTag11 = protoAdapter2.encodedSizeWithTag(10, value.getHero_web_url());
                                                    if (m.c(value.getHero_mobile_url(), "")) {
                                                        i2 = encodedSizeWithTag2;
                                                        i3 = encodedSizeWithTag3;
                                                        i7 = 0;
                                                    } else {
                                                        int encodedSizeWithTag12 = protoAdapter2.encodedSizeWithTag(11, value.getHero_mobile_url());
                                                        if (m.c(value.getLogo_url(), "")) {
                                                            i2 = encodedSizeWithTag2;
                                                            i3 = encodedSizeWithTag3;
                                                            i6 = 0;
                                                        } else {
                                                            int encodedSizeWithTag13 = protoAdapter2.encodedSizeWithTag(12, value.getLogo_url());
                                                            if (m.c(value.getLogo_white_url(), "")) {
                                                                i2 = encodedSizeWithTag2;
                                                                i3 = encodedSizeWithTag3;
                                                                i5 = 0;
                                                            } else {
                                                                int encodedSizeWithTag14 = protoAdapter2.encodedSizeWithTag(13, value.getLogo_white_url());
                                                                if (m.c(value.getOpen_graph_title(), "")) {
                                                                    i2 = encodedSizeWithTag2;
                                                                    i3 = encodedSizeWithTag3;
                                                                    i4 = 0;
                                                                } else {
                                                                    i2 = encodedSizeWithTag2;
                                                                    int encodedSizeWithTag15 = protoAdapter2.encodedSizeWithTag(14, value.getOpen_graph_title());
                                                                    if (m.c(value.getOpen_graph_description(), "")) {
                                                                        i3 = encodedSizeWithTag3;
                                                                        encodedSizeWithTag = 0;
                                                                    } else {
                                                                        i3 = encodedSizeWithTag3;
                                                                        encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(15, value.getOpen_graph_description()) + (m.c(value.getOpen_graph_image_url(), "") ? 0 : protoAdapter2.encodedSizeWithTag(16, value.getOpen_graph_image_url()) + value.unknownFields().Q());
                                                                    }
                                                                    i4 = encodedSizeWithTag15 + encodedSizeWithTag;
                                                                }
                                                                i5 = encodedSizeWithTag14 + i4;
                                                            }
                                                            i6 = encodedSizeWithTag13 + i5;
                                                        }
                                                        i7 = i6 + encodedSizeWithTag12;
                                                    }
                                                    i8 = i7 + encodedSizeWithTag11;
                                                }
                                                i9 = i8 + encodedSizeWithTag10;
                                            }
                                            i10 = i9 + encodedSizeWithTag9;
                                        }
                                        i11 = i10 + encodedSizeWithTag8;
                                    }
                                    i12 = i11 + encodedSizeWithTag7;
                                }
                                i13 = i12 + encodedSizeWithTag6;
                            }
                            i14 = i13 + encodedSizeWithTag5;
                        }
                        i15 = i14 + encodedSizeWithTag4;
                    }
                    i16 = i3 + i15;
                }
                return i2 + i16;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Campaign redact(Campaign value) {
                Campaign copy;
                m.h(value, "value");
                Amount total_reward_amount = value.getTotal_reward_amount();
                copy = value.copy((r36 & 1) != 0 ? value.id : 0L, (r36 & 2) != 0 ? value.asset_slug : null, (r36 & 4) != 0 ? value.name : null, (r36 & 8) != 0 ? value.symbol : null, (r36 & 16) != 0 ? value.description : null, (r36 & 32) != 0 ? value.total_reward_amount : total_reward_amount != null ? Amount.ADAPTER.redact(total_reward_amount) : null, (r36 & 64) != 0 ? value.one_liner : null, (r36 & 128) != 0 ? value.intro_text : null, (r36 & 256) != 0 ? value.status : null, (r36 & 512) != 0 ? value.hero_web_url : null, (r36 & 1024) != 0 ? value.hero_mobile_url : null, (r36 & PKIFailureInfo.wrongIntegrity) != 0 ? value.logo_url : null, (r36 & 4096) != 0 ? value.logo_white_url : null, (r36 & PKIFailureInfo.certRevoked) != 0 ? value.open_graph_title : null, (r36 & 16384) != 0 ? value.open_graph_description : null, (r36 & 32768) != 0 ? value.open_graph_image_url : null, (r36 & 65536) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Campaign() {
        this(0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public /* synthetic */ Campaign(long j2, String str, String str2, String str3, String str4, Amount amount, String str5, String str6, CampaignStatus campaignStatus, String str7, String str8, String str9, String str10, String str11, String str12, String str13, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? null : amount, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? CampaignStatus.UNKNOWN : campaignStatus, (i2 & 512) != 0 ? "" : str7, (i2 & 1024) != 0 ? "" : str8, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? "" : str9, (i2 & 4096) != 0 ? "" : str10, (i2 & PKIFailureInfo.certRevoked) != 0 ? "" : str11, (i2 & 16384) != 0 ? "" : str12, (i2 & 32768) != 0 ? "" : str13, (i2 & 65536) != 0 ? i.a : iVar);
    }

    public final Campaign copy(long j2, String asset_slug, String name, String symbol, String description, Amount amount, String one_liner, String intro_text, CampaignStatus status, String hero_web_url, String hero_mobile_url, String logo_url, String logo_white_url, String open_graph_title, String open_graph_description, String open_graph_image_url, i unknownFields) {
        m.h(asset_slug, "asset_slug");
        m.h(name, "name");
        m.h(symbol, "symbol");
        m.h(description, "description");
        m.h(one_liner, "one_liner");
        m.h(intro_text, "intro_text");
        m.h(status, "status");
        m.h(hero_web_url, "hero_web_url");
        m.h(hero_mobile_url, "hero_mobile_url");
        m.h(logo_url, "logo_url");
        m.h(logo_white_url, "logo_white_url");
        m.h(open_graph_title, "open_graph_title");
        m.h(open_graph_description, "open_graph_description");
        m.h(open_graph_image_url, "open_graph_image_url");
        m.h(unknownFields, "unknownFields");
        return new Campaign(j2, asset_slug, name, symbol, description, amount, one_liner, intro_text, status, hero_web_url, hero_mobile_url, logo_url, logo_white_url, open_graph_title, open_graph_description, open_graph_image_url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Campaign) {
            Campaign campaign = (Campaign) obj;
            return m.c(unknownFields(), campaign.unknownFields()) && this.id == campaign.id && m.c(this.asset_slug, campaign.asset_slug) && m.c(this.name, campaign.name) && m.c(this.symbol, campaign.symbol) && m.c(this.description, campaign.description) && m.c(this.total_reward_amount, campaign.total_reward_amount) && m.c(this.one_liner, campaign.one_liner) && m.c(this.intro_text, campaign.intro_text) && this.status == campaign.status && m.c(this.hero_web_url, campaign.hero_web_url) && m.c(this.hero_mobile_url, campaign.hero_mobile_url) && m.c(this.logo_url, campaign.logo_url) && m.c(this.logo_white_url, campaign.logo_white_url) && m.c(this.open_graph_title, campaign.open_graph_title) && m.c(this.open_graph_description, campaign.open_graph_description) && m.c(this.open_graph_image_url, campaign.open_graph_image_url);
        }
        return false;
    }

    public final String getAsset_slug() {
        return this.asset_slug;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getHero_mobile_url() {
        return this.hero_mobile_url;
    }

    public final String getHero_web_url() {
        return this.hero_web_url;
    }

    public final long getId() {
        return this.id;
    }

    public final String getIntro_text() {
        return this.intro_text;
    }

    public final String getLogo_url() {
        return this.logo_url;
    }

    public final String getLogo_white_url() {
        return this.logo_white_url;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOne_liner() {
        return this.one_liner;
    }

    public final String getOpen_graph_description() {
        return this.open_graph_description;
    }

    public final String getOpen_graph_image_url() {
        return this.open_graph_image_url;
    }

    public final String getOpen_graph_title() {
        return this.open_graph_title;
    }

    public final CampaignStatus getStatus() {
        return this.status;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public final Amount getTotal_reward_amount() {
        return this.total_reward_amount;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((unknownFields().hashCode() * 37) + b.a(this.id)) * 37) + this.asset_slug.hashCode()) * 37) + this.name.hashCode()) * 37) + this.symbol.hashCode()) * 37) + this.description.hashCode()) * 37;
            Amount amount = this.total_reward_amount;
            int hashCode2 = ((((((((((((((((((((hashCode + (amount != null ? amount.hashCode() : 0)) * 37) + this.one_liner.hashCode()) * 37) + this.intro_text.hashCode()) * 37) + this.status.hashCode()) * 37) + this.hero_web_url.hashCode()) * 37) + this.hero_mobile_url.hashCode()) * 37) + this.logo_url.hashCode()) * 37) + this.logo_white_url.hashCode()) * 37) + this.open_graph_title.hashCode()) * 37) + this.open_graph_description.hashCode()) * 37) + this.open_graph_image_url.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m561newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("id=" + this.id);
        arrayList.add("asset_slug=" + com.squareup.wire.q.b.c(this.asset_slug));
        arrayList.add("name=" + com.squareup.wire.q.b.c(this.name));
        arrayList.add("symbol=" + com.squareup.wire.q.b.c(this.symbol));
        arrayList.add("description=" + com.squareup.wire.q.b.c(this.description));
        if (this.total_reward_amount != null) {
            arrayList.add("total_reward_amount=" + this.total_reward_amount);
        }
        arrayList.add("one_liner=" + com.squareup.wire.q.b.c(this.one_liner));
        arrayList.add("intro_text=" + com.squareup.wire.q.b.c(this.intro_text));
        arrayList.add("status=" + this.status);
        arrayList.add("hero_web_url=" + com.squareup.wire.q.b.c(this.hero_web_url));
        arrayList.add("hero_mobile_url=" + com.squareup.wire.q.b.c(this.hero_mobile_url));
        arrayList.add("logo_url=" + com.squareup.wire.q.b.c(this.logo_url));
        arrayList.add("logo_white_url=" + com.squareup.wire.q.b.c(this.logo_white_url));
        arrayList.add("open_graph_title=" + com.squareup.wire.q.b.c(this.open_graph_title));
        arrayList.add("open_graph_description=" + com.squareup.wire.q.b.c(this.open_graph_description));
        arrayList.add("open_graph_image_url=" + com.squareup.wire.q.b.c(this.open_graph_image_url));
        h0 = z.h0(arrayList, ", ", "Campaign{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m561newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Campaign(long j2, String asset_slug, String name, String symbol, String description, Amount amount, String one_liner, String intro_text, CampaignStatus status, String hero_web_url, String hero_mobile_url, String logo_url, String logo_white_url, String open_graph_title, String open_graph_description, String open_graph_image_url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(asset_slug, "asset_slug");
        m.h(name, "name");
        m.h(symbol, "symbol");
        m.h(description, "description");
        m.h(one_liner, "one_liner");
        m.h(intro_text, "intro_text");
        m.h(status, "status");
        m.h(hero_web_url, "hero_web_url");
        m.h(hero_mobile_url, "hero_mobile_url");
        m.h(logo_url, "logo_url");
        m.h(logo_white_url, "logo_white_url");
        m.h(open_graph_title, "open_graph_title");
        m.h(open_graph_description, "open_graph_description");
        m.h(open_graph_image_url, "open_graph_image_url");
        m.h(unknownFields, "unknownFields");
        this.id = j2;
        this.asset_slug = asset_slug;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
        this.total_reward_amount = amount;
        this.one_liner = one_liner;
        this.intro_text = intro_text;
        this.status = status;
        this.hero_web_url = hero_web_url;
        this.hero_mobile_url = hero_mobile_url;
        this.logo_url = logo_url;
        this.logo_white_url = logo_white_url;
        this.open_graph_title = open_graph_title;
        this.open_graph_description = open_graph_description;
        this.open_graph_image_url = open_graph_image_url;
    }
}