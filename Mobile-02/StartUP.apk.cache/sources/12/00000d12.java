package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Button;
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
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: EarnVideoLesson.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 E2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001EB§\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\r\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\bC\u0010DJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u00ad\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'R\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u000fR\u001c\u0010\u001a\u001a\u00020\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010/R\u001c\u0010\u001b\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b0\u0010\u000fR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\b2\u00103R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00104\u001a\u0004\b5\u00106R\u001c\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00107\u001a\u0004\b8\u00109R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010 \u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010+\u001a\u0004\b=\u0010\u000fR\u001e\u0010#\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010+\u001a\u0004\b>\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b?\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b@\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010+\u001a\u0004\bA\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\bB\u0010\u000f¨\u0006F"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnVideoLesson;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "header", MessageBundle.TITLE_ENTRY, "subtitle", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;", "subtitle_style", "subtitle_info", "body", "Lcom/coinbase/android/apiv3/generated/common/Video;", "video", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;", "action_type", "terms_url", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;", "modal", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;", "mobile_video", "url", "Lcom/coinbase/android/apiv3/generated/common/Button;", "button", "label", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Video;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Button;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnVideoLesson;", "Lcom/coinbase/android/apiv3/generated/common/Button;", "getButton", "()Lcom/coinbase/android/apiv3/generated/common/Button;", "Ljava/lang/String;", "getSubtitle_info", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;", "getAction_type", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;", "getTerms_url", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;", "getModal", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;", "Lcom/coinbase/android/apiv3/generated/common/Video;", "getVideo", "()Lcom/coinbase/android/apiv3/generated/common/Video;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;", "getSubtitle_style", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;", "getMobile_video", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;", "getUrl", "getLabel", "getSubtitle", "getBody", "getHeader", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Video;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;Lcom/coinbase/android/apiv3/generated/authed/loyalty/MobileVideo;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Button;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class EarnVideoLesson extends a {
    public static final ProtoAdapter<EarnVideoLesson> ADAPTER;
    public static final Parcelable.Creator<EarnVideoLesson> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyActionType#ADAPTER", jsonName = "actionType", tag = 10)
    private final LoyaltyActionType action_type;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String body;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Button#ADAPTER", tag = 8)
    private final Button button;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String header;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    private final String label;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.MobileVideo#ADAPTER", jsonName = "mobileVideo", tag = 13)
    private final MobileVideo mobile_video;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardModal#ADAPTER", tag = 12)
    private final LoyaltyCardModal modal;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String subtitle;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "subtitleInfo", tag = 5)
    private final String subtitle_info;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyTextStyle#ADAPTER", jsonName = "subtitleStyle", tag = 4)
    private final LoyaltyTextStyle subtitle_style;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "termsUrl", tag = 11)
    private final String terms_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    private final String url;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Video#ADAPTER", tag = 7)
    private final Video video;

    /* compiled from: EarnVideoLesson.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnVideoLesson$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/EarnVideoLesson;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(EarnVideoLesson.class);
        ProtoAdapter<EarnVideoLesson> protoAdapter = new ProtoAdapter<EarnVideoLesson>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.loyalty.EarnVideoLesson") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.EarnVideoLesson$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EarnVideoLesson decode(k reader) {
                m.h(reader, "reader");
                LoyaltyTextStyle loyaltyTextStyle = LoyaltyTextStyle.TEXT_STANDARD;
                LoyaltyActionType loyaltyActionType = LoyaltyActionType.UNIVERSAL_LINK;
                long d2 = reader.d();
                LoyaltyTextStyle loyaltyTextStyle2 = loyaltyTextStyle;
                LoyaltyActionType loyaltyActionType2 = loyaltyActionType;
                Video video = null;
                LoyaltyCardModal loyaltyCardModal = null;
                MobileVideo mobileVideo = null;
                Button button = null;
                String str = null;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new EarnVideoLesson(str2, str3, str4, loyaltyTextStyle2, str5, str6, video, loyaltyActionType2, str7, loyaltyCardModal, mobileVideo, str8, button, str, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            try {
                                loyaltyTextStyle2 = LoyaltyTextStyle.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 5:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            video = Video.ADAPTER.decode(reader);
                            break;
                        case 8:
                            button = Button.ADAPTER.decode(reader);
                            break;
                        case 9:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 10:
                            try {
                                loyaltyActionType2 = LoyaltyActionType.ADAPTER.decode(reader);
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                reader.a(g2, c.VARINT, Long.valueOf(e3.a));
                                break;
                            }
                        case 11:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 12:
                            loyaltyCardModal = LoyaltyCardModal.ADAPTER.decode(reader);
                            break;
                        case 13:
                            mobileVideo = MobileVideo.ADAPTER.decode(reader);
                            break;
                        case 14:
                            str8 = ProtoAdapter.STRING.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, EarnVideoLesson value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getHeader(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getHeader());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getTitle());
                }
                if (!m.c(value.getSubtitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getSubtitle());
                }
                if (value.getSubtitle_style() != LoyaltyTextStyle.TEXT_STANDARD) {
                    LoyaltyTextStyle.ADAPTER.encodeWithTag(writer, 4, value.getSubtitle_style());
                }
                if (!m.c(value.getSubtitle_info(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getSubtitle_info());
                }
                if (!m.c(value.getBody(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getBody());
                }
                if (value.getVideo() != null) {
                    Video.ADAPTER.encodeWithTag(writer, 7, value.getVideo());
                }
                if (value.getAction_type() != LoyaltyActionType.UNIVERSAL_LINK) {
                    LoyaltyActionType.ADAPTER.encodeWithTag(writer, 10, value.getAction_type());
                }
                if (!m.c(value.getTerms_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 11, value.getTerms_url());
                }
                if (value.getModal() != null) {
                    LoyaltyCardModal.ADAPTER.encodeWithTag(writer, 12, value.getModal());
                }
                if (value.getMobile_video() != null) {
                    MobileVideo.ADAPTER.encodeWithTag(writer, 13, value.getMobile_video());
                }
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 14, value.getUrl());
                }
                if (value.getButton() != null) {
                    Button.ADAPTER.encodeWithTag(writer, 8, value.getButton());
                }
                if (value.getLabel() != null) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 9, value.getLabel());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(EarnVideoLesson value) {
                int encodedSizeWithTag;
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
                if (m.c(value.getHeader(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(1, value.getHeader());
                if (m.c(value.getTitle(), "")) {
                    i12 = 0;
                } else {
                    int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(2, value.getTitle());
                    if (m.c(value.getSubtitle(), "")) {
                        i11 = 0;
                    } else {
                        int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(3, value.getSubtitle());
                        if (value.getSubtitle_style() == LoyaltyTextStyle.TEXT_STANDARD) {
                            i10 = 0;
                        } else {
                            int encodedSizeWithTag5 = LoyaltyTextStyle.ADAPTER.encodedSizeWithTag(4, value.getSubtitle_style());
                            if (m.c(value.getSubtitle_info(), "")) {
                                i9 = 0;
                            } else {
                                int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(5, value.getSubtitle_info());
                                if (m.c(value.getBody(), "")) {
                                    i8 = 0;
                                } else {
                                    int encodedSizeWithTag7 = protoAdapter2.encodedSizeWithTag(6, value.getBody());
                                    if (value.getVideo() == null) {
                                        i7 = 0;
                                    } else {
                                        int encodedSizeWithTag8 = Video.ADAPTER.encodedSizeWithTag(7, value.getVideo());
                                        if (value.getAction_type() == LoyaltyActionType.UNIVERSAL_LINK) {
                                            i6 = 0;
                                        } else {
                                            int encodedSizeWithTag9 = LoyaltyActionType.ADAPTER.encodedSizeWithTag(10, value.getAction_type());
                                            if (m.c(value.getTerms_url(), "")) {
                                                i5 = 0;
                                            } else {
                                                int encodedSizeWithTag10 = protoAdapter2.encodedSizeWithTag(11, value.getTerms_url());
                                                if (value.getModal() == null) {
                                                    i4 = 0;
                                                } else {
                                                    int encodedSizeWithTag11 = LoyaltyCardModal.ADAPTER.encodedSizeWithTag(12, value.getModal());
                                                    if (value.getMobile_video() == null) {
                                                        i3 = 0;
                                                    } else {
                                                        int encodedSizeWithTag12 = MobileVideo.ADAPTER.encodedSizeWithTag(13, value.getMobile_video());
                                                        if (m.c(value.getUrl(), "")) {
                                                            i2 = 0;
                                                        } else {
                                                            int encodedSizeWithTag13 = protoAdapter2.encodedSizeWithTag(14, value.getUrl());
                                                            if (value.getButton() == null) {
                                                                encodedSizeWithTag = 0;
                                                            } else {
                                                                encodedSizeWithTag = (value.getLabel() == null ? 0 : protoAdapter2.encodedSizeWithTag(9, value.getLabel()) + value.unknownFields().Q()) + Button.ADAPTER.encodedSizeWithTag(8, value.getButton());
                                                            }
                                                            i2 = encodedSizeWithTag13 + encodedSizeWithTag;
                                                        }
                                                        i3 = encodedSizeWithTag12 + i2;
                                                    }
                                                    i4 = i3 + encodedSizeWithTag11;
                                                }
                                                i5 = i4 + encodedSizeWithTag10;
                                            }
                                            i6 = i5 + encodedSizeWithTag9;
                                        }
                                        i7 = i6 + encodedSizeWithTag8;
                                    }
                                    i8 = i7 + encodedSizeWithTag7;
                                }
                                i9 = i8 + encodedSizeWithTag6;
                            }
                            i10 = i9 + encodedSizeWithTag5;
                        }
                        i11 = i10 + encodedSizeWithTag4;
                    }
                    i12 = i11 + encodedSizeWithTag3;
                }
                return i12 + encodedSizeWithTag2;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public EarnVideoLesson redact(EarnVideoLesson value) {
                EarnVideoLesson copy;
                m.h(value, "value");
                Video video = value.getVideo();
                Video redact = video != null ? Video.ADAPTER.redact(video) : null;
                LoyaltyCardModal modal = value.getModal();
                LoyaltyCardModal redact2 = modal != null ? LoyaltyCardModal.ADAPTER.redact(modal) : null;
                MobileVideo mobile_video = value.getMobile_video();
                MobileVideo redact3 = mobile_video != null ? MobileVideo.ADAPTER.redact(mobile_video) : null;
                Button button = value.getButton();
                copy = value.copy((r32 & 1) != 0 ? value.header : null, (r32 & 2) != 0 ? value.title : null, (r32 & 4) != 0 ? value.subtitle : null, (r32 & 8) != 0 ? value.subtitle_style : null, (r32 & 16) != 0 ? value.subtitle_info : null, (r32 & 32) != 0 ? value.body : null, (r32 & 64) != 0 ? value.video : redact, (r32 & 128) != 0 ? value.action_type : null, (r32 & 256) != 0 ? value.terms_url : null, (r32 & 512) != 0 ? value.modal : redact2, (r32 & 1024) != 0 ? value.mobile_video : redact3, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? value.url : null, (r32 & 4096) != 0 ? value.button : button != null ? Button.ADAPTER.redact(button) : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? value.label : null, (r32 & 16384) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public EarnVideoLesson() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public /* synthetic */ EarnVideoLesson(String str, String str2, String str3, LoyaltyTextStyle loyaltyTextStyle, String str4, String str5, Video video, LoyaltyActionType loyaltyActionType, String str6, LoyaltyCardModal loyaltyCardModal, MobileVideo mobileVideo, String str7, Button button, String str8, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? LoyaltyTextStyle.TEXT_STANDARD : loyaltyTextStyle, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? null : video, (i2 & 128) != 0 ? LoyaltyActionType.UNIVERSAL_LINK : loyaltyActionType, (i2 & 256) != 0 ? "" : str6, (i2 & 512) != 0 ? null : loyaltyCardModal, (i2 & 1024) != 0 ? null : mobileVideo, (i2 & PKIFailureInfo.wrongIntegrity) == 0 ? str7 : "", (i2 & 4096) != 0 ? null : button, (i2 & PKIFailureInfo.certRevoked) == 0 ? str8 : null, (i2 & 16384) != 0 ? i.a : iVar);
    }

    public final EarnVideoLesson copy(String header, String title, String subtitle, LoyaltyTextStyle subtitle_style, String subtitle_info, String body, Video video, LoyaltyActionType action_type, String terms_url, LoyaltyCardModal loyaltyCardModal, MobileVideo mobileVideo, String url, Button button, String str, i unknownFields) {
        m.h(header, "header");
        m.h(title, "title");
        m.h(subtitle, "subtitle");
        m.h(subtitle_style, "subtitle_style");
        m.h(subtitle_info, "subtitle_info");
        m.h(body, "body");
        m.h(action_type, "action_type");
        m.h(terms_url, "terms_url");
        m.h(url, "url");
        m.h(unknownFields, "unknownFields");
        return new EarnVideoLesson(header, title, subtitle, subtitle_style, subtitle_info, body, video, action_type, terms_url, loyaltyCardModal, mobileVideo, url, button, str, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EarnVideoLesson) {
            EarnVideoLesson earnVideoLesson = (EarnVideoLesson) obj;
            return m.c(unknownFields(), earnVideoLesson.unknownFields()) && m.c(this.header, earnVideoLesson.header) && m.c(this.title, earnVideoLesson.title) && m.c(this.subtitle, earnVideoLesson.subtitle) && this.subtitle_style == earnVideoLesson.subtitle_style && m.c(this.subtitle_info, earnVideoLesson.subtitle_info) && m.c(this.body, earnVideoLesson.body) && m.c(this.video, earnVideoLesson.video) && this.action_type == earnVideoLesson.action_type && m.c(this.terms_url, earnVideoLesson.terms_url) && m.c(this.modal, earnVideoLesson.modal) && m.c(this.mobile_video, earnVideoLesson.mobile_video) && m.c(this.url, earnVideoLesson.url) && m.c(this.button, earnVideoLesson.button) && m.c(this.label, earnVideoLesson.label);
        }
        return false;
    }

    public final LoyaltyActionType getAction_type() {
        return this.action_type;
    }

    public final String getBody() {
        return this.body;
    }

    public final Button getButton() {
        return this.button;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getLabel() {
        return this.label;
    }

    public final MobileVideo getMobile_video() {
        return this.mobile_video;
    }

    public final LoyaltyCardModal getModal() {
        return this.modal;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getSubtitle_info() {
        return this.subtitle_info;
    }

    public final LoyaltyTextStyle getSubtitle_style() {
        return this.subtitle_style;
    }

    public final String getTerms_url() {
        return this.terms_url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Video getVideo() {
        return this.video;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((((unknownFields().hashCode() * 37) + this.header.hashCode()) * 37) + this.title.hashCode()) * 37) + this.subtitle.hashCode()) * 37) + this.subtitle_style.hashCode()) * 37) + this.subtitle_info.hashCode()) * 37) + this.body.hashCode()) * 37;
            Video video = this.video;
            int hashCode2 = (((((hashCode + (video != null ? video.hashCode() : 0)) * 37) + this.action_type.hashCode()) * 37) + this.terms_url.hashCode()) * 37;
            LoyaltyCardModal loyaltyCardModal = this.modal;
            int hashCode3 = (hashCode2 + (loyaltyCardModal != null ? loyaltyCardModal.hashCode() : 0)) * 37;
            MobileVideo mobileVideo = this.mobile_video;
            int hashCode4 = (((hashCode3 + (mobileVideo != null ? mobileVideo.hashCode() : 0)) * 37) + this.url.hashCode()) * 37;
            Button button = this.button;
            int hashCode5 = (hashCode4 + (button != null ? button.hashCode() : 0)) * 37;
            String str = this.label;
            int hashCode6 = hashCode5 + (str != null ? str.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m397newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("header=" + b.c(this.header));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("subtitle=" + b.c(this.subtitle));
        arrayList.add("subtitle_style=" + this.subtitle_style);
        arrayList.add("subtitle_info=" + b.c(this.subtitle_info));
        arrayList.add("body=" + b.c(this.body));
        if (this.video != null) {
            arrayList.add("video=" + this.video);
        }
        arrayList.add("action_type=" + this.action_type);
        arrayList.add("terms_url=" + b.c(this.terms_url));
        if (this.modal != null) {
            arrayList.add("modal=" + this.modal);
        }
        if (this.mobile_video != null) {
            arrayList.add("mobile_video=" + this.mobile_video);
        }
        arrayList.add("url=" + b.c(this.url));
        if (this.button != null) {
            arrayList.add("button=" + this.button);
        }
        if (this.label != null) {
            arrayList.add("label=" + b.c(this.label));
        }
        h0 = z.h0(arrayList, ", ", "EarnVideoLesson{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m397newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarnVideoLesson(String header, String title, String subtitle, LoyaltyTextStyle subtitle_style, String subtitle_info, String body, Video video, LoyaltyActionType action_type, String terms_url, LoyaltyCardModal loyaltyCardModal, MobileVideo mobileVideo, String url, Button button, String str, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(header, "header");
        m.h(title, "title");
        m.h(subtitle, "subtitle");
        m.h(subtitle_style, "subtitle_style");
        m.h(subtitle_info, "subtitle_info");
        m.h(body, "body");
        m.h(action_type, "action_type");
        m.h(terms_url, "terms_url");
        m.h(url, "url");
        m.h(unknownFields, "unknownFields");
        this.header = header;
        this.title = title;
        this.subtitle = subtitle;
        this.subtitle_style = subtitle_style;
        this.subtitle_info = subtitle_info;
        this.body = body;
        this.video = video;
        this.action_type = action_type;
        this.terms_url = terms_url;
        this.modal = loyaltyCardModal;
        this.mobile_video = mobileVideo;
        this.url = url;
        this.button = button;
        this.label = str;
        if (!(b.b(button, str) <= 1)) {
            throw new IllegalArgumentException("At most one of button, label may be non-null".toString());
        }
    }
}