package com.coinbase.android.apiv3.generated.authed.loyalty;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Button;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: LoyaltyCard.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\u0018\u0000 T2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001TBÝ\u0001\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\r\u0012\b\b\u0002\u0010\"\u001a\u00020\r\u0012\b\b\u0002\u0010#\u001a\u00020\r\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0016\u0012\b\b\u0002\u0010&\u001a\u00020\n\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010+\u001a\u00020\r\u0012\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\bR\u0010SJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJã\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\r2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00162\b\b\u0002\u0010&\u001a\u00020\n2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020\r2\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/R\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00100\u001a\u0004\b1\u0010\u000fR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b3\u00104R\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00100\u001a\u0004\b5\u0010\u000fR\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00106\u001a\u0004\b7\u00108R\"\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00106\u001a\u0004\b9\u00108R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010:\u001a\u0004\b;\u0010<R\u001c\u0010*\u001a\u00020)8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010!\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b@\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\bA\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010B\u001a\u0004\bC\u0010DR\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00168\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\bE\u00108R\u001c\u0010+\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u00100\u001a\u0004\bF\u0010\u000fR\u001c\u0010&\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010G\u001a\u0004\bH\u0010\fR\u001c\u0010\"\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00100\u001a\u0004\bI\u0010\u000fR\u001e\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010J\u001a\u0004\bK\u0010LR\u001c\u0010 \u001a\u00020\u001f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010M\u001a\u0004\bN\u0010OR\u001c\u0010#\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00100\u001a\u0004\bP\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u00100\u001a\u0004\bQ\u0010\u000f¨\u0006U"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardStyle;", "style", "card_name", "image_url", MessageBundle.TITLE_ENTRY, "body", "", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetail;", ErrorBundle.DETAIL_ENTRY, "Lcom/coinbase/android/apiv3/generated/common/Button;", "button", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardRow;", "rows", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTable;", "table", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;", "action_type", "url", "url_text", "subtitle", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardTask;", "tasks", "focus_task_index", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;", "modal", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;", "subtitle_style", "body_image_url", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Button;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTable;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard;", "Ljava/lang/String;", "getTitle", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTable;", "getTable", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTable;", "getBody", "Ljava/util/List;", "getDetails", "()Ljava/util/List;", "getTasks", "Lcom/coinbase/android/apiv3/generated/common/Button;", "getButton", "()Lcom/coinbase/android/apiv3/generated/common/Button;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;", "getSubtitle_style", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;", "getUrl", "getImage_url", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardStyle;", "getStyle", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardStyle;", "getRows", "getBody_image_url", "I", "getFocus_task_index", "getUrl_text", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;", "getModal", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;", "getAction_type", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;", "getSubtitle", "getCard_name", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Button;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTable;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyActionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardModal;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTextStyle;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoyaltyCard extends a {
    public static final ProtoAdapter<LoyaltyCard> ADAPTER;
    public static final Parcelable.Creator<LoyaltyCard> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyActionType#ADAPTER", jsonName = "actionType", tag = 10)
    private final LoyaltyActionType action_type;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String body;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "bodyImageUrl", tag = 18)
    private final String body_image_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Button#ADAPTER", tag = 7)
    private final Button button;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardName", tag = 2)
    private final String card_name;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardDetail#ADAPTER", label = p.a.REPEATED, tag = 6)
    private final List<LoyaltyCardDetail> details;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "focusTaskIndex", tag = 15)
    private final int focus_task_index;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 3)
    private final String image_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardModal#ADAPTER", tag = 16)
    private final LoyaltyCardModal modal;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardRow#ADAPTER", label = p.a.REPEATED, tag = 8)
    private final List<LoyaltyCardRow> rows;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardStyle#ADAPTER", tag = 1)
    private final LoyaltyCardStyle style;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    private final String subtitle;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyTextStyle#ADAPTER", jsonName = "subtitleStyle", tag = 17)
    private final LoyaltyTextStyle subtitle_style;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyTable#ADAPTER", tag = 9)
    private final LoyaltyTable table;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardTask#ADAPTER", label = p.a.REPEATED, tag = 14)
    private final List<LoyaltyCardTask> tasks;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    private final String url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "urlText", tag = 12)
    private final String url_text;

    /* compiled from: LoyaltyCard.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCard;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(LoyaltyCard.class);
        ProtoAdapter<LoyaltyCard> protoAdapter = new ProtoAdapter<LoyaltyCard>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.loyalty.LoyaltyCard") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCard$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCard decode(k reader) {
                LoyaltyCardStyle loyaltyCardStyle;
                String str;
                long j2;
                ArrayList arrayList;
                LoyaltyTextStyle decode;
                LoyaltyCardStyle loyaltyCardStyle2;
                LoyaltyActionType decode2;
                m.h(reader, "reader");
                LoyaltyCardStyle loyaltyCardStyle3 = LoyaltyCardStyle.STANDARD;
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                LoyaltyActionType loyaltyActionType = LoyaltyActionType.UNIVERSAL_LINK;
                ArrayList arrayList4 = new ArrayList();
                LoyaltyTextStyle loyaltyTextStyle = LoyaltyTextStyle.TEXT_STANDARD;
                long d2 = reader.d();
                String str2 = "";
                LoyaltyActionType loyaltyActionType2 = loyaltyActionType;
                LoyaltyTextStyle loyaltyTextStyle2 = loyaltyTextStyle;
                Button button = null;
                LoyaltyTable loyaltyTable = null;
                LoyaltyCardModal loyaltyCardModal = null;
                String str3 = "";
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                int i2 = 0;
                ArrayList arrayList5 = arrayList4;
                LoyaltyCardStyle loyaltyCardStyle4 = loyaltyCardStyle3;
                String str9 = str8;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoyaltyCard(loyaltyCardStyle4, str3, str2, str4, str9, arrayList2, button, arrayList3, loyaltyTable, loyaltyActionType2, str5, str6, str7, arrayList5, i2, loyaltyCardModal, loyaltyTextStyle2, str8, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            LoyaltyCardStyle loyaltyCardStyle5 = loyaltyCardStyle4;
                            str = str3;
                            j2 = d2;
                            arrayList = arrayList5;
                            try {
                                loyaltyCardStyle2 = LoyaltyCardStyle.ADAPTER.decode(reader);
                                try {
                                    x xVar = x.a;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                    e = e2;
                                    loyaltyCardStyle5 = loyaltyCardStyle2;
                                    reader.a(g2, c.VARINT, Long.valueOf(e.a));
                                    x xVar2 = x.a;
                                    loyaltyCardStyle2 = loyaltyCardStyle5;
                                    loyaltyCardStyle = loyaltyCardStyle2;
                                    str3 = str;
                                    arrayList5 = arrayList;
                                    loyaltyCardStyle4 = loyaltyCardStyle;
                                    d2 = j2;
                                }
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                e = e3;
                            }
                            loyaltyCardStyle = loyaltyCardStyle2;
                            str3 = str;
                        case 2:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            str9 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            str = str3;
                            j2 = d2;
                            arrayList = arrayList5;
                            arrayList2.add(LoyaltyCardDetail.ADAPTER.decode(reader));
                            str3 = str;
                            break;
                        case 7:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            button = Button.ADAPTER.decode(reader);
                            break;
                        case 8:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            str = str3;
                            j2 = d2;
                            arrayList = arrayList5;
                            arrayList3.add(LoyaltyCardRow.ADAPTER.decode(reader));
                            str3 = str;
                            break;
                        case 9:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            loyaltyTable = LoyaltyTable.ADAPTER.decode(reader);
                            break;
                        case 10:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            str = str3;
                            j2 = d2;
                            arrayList = arrayList5;
                            try {
                                decode2 = LoyaltyActionType.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                                e = e4;
                            }
                            try {
                                x xVar3 = x.a;
                                loyaltyActionType2 = decode2;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e5) {
                                e = e5;
                                loyaltyActionType2 = decode2;
                                reader.a(g2, c.VARINT, Long.valueOf(e.a));
                                x xVar4 = x.a;
                                str3 = str;
                                arrayList5 = arrayList;
                                loyaltyCardStyle4 = loyaltyCardStyle;
                                d2 = j2;
                            }
                            str3 = str;
                        case 11:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 12:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 13:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 14:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            str = str3;
                            j2 = d2;
                            arrayList = arrayList5;
                            arrayList.add(LoyaltyCardTask.ADAPTER.decode(reader));
                            str3 = str;
                            break;
                        case 15:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            i2 = ProtoAdapter.INT32.decode(reader).intValue();
                            arrayList = arrayList5;
                            break;
                        case 16:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            loyaltyCardModal = LoyaltyCardModal.ADAPTER.decode(reader);
                            arrayList = arrayList5;
                            break;
                        case 17:
                            try {
                                decode = LoyaltyTextStyle.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e6) {
                                e = e6;
                            }
                            try {
                                x xVar5 = x.a;
                                str = str3;
                                j2 = d2;
                                loyaltyTextStyle2 = decode;
                                loyaltyCardStyle = loyaltyCardStyle4;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e7) {
                                e = e7;
                                loyaltyTextStyle2 = decode;
                                loyaltyCardStyle = loyaltyCardStyle4;
                                str = str3;
                                j2 = d2;
                                reader.a(g2, c.VARINT, Long.valueOf(e.a));
                                x xVar6 = x.a;
                                arrayList = arrayList5;
                                str3 = str;
                                arrayList5 = arrayList;
                                loyaltyCardStyle4 = loyaltyCardStyle;
                                d2 = j2;
                            }
                            arrayList = arrayList5;
                            str3 = str;
                        case 18:
                            str8 = ProtoAdapter.STRING.decode(reader);
                            loyaltyCardStyle = loyaltyCardStyle4;
                            j2 = d2;
                            arrayList = arrayList5;
                            break;
                        default:
                            loyaltyCardStyle = loyaltyCardStyle4;
                            str = str3;
                            j2 = d2;
                            arrayList = arrayList5;
                            reader.m(g2);
                            str3 = str;
                            break;
                    }
                    arrayList5 = arrayList;
                    loyaltyCardStyle4 = loyaltyCardStyle;
                    d2 = j2;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoyaltyCard value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getStyle() != LoyaltyCardStyle.STANDARD) {
                    LoyaltyCardStyle.ADAPTER.encodeWithTag(writer, 1, value.getStyle());
                }
                if (!m.c(value.getCard_name(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getCard_name());
                }
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getImage_url());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getTitle());
                }
                if (!m.c(value.getBody(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getBody());
                }
                LoyaltyCardDetail.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.getDetails());
                if (value.getButton() != null) {
                    Button.ADAPTER.encodeWithTag(writer, 7, value.getButton());
                }
                LoyaltyCardRow.ADAPTER.asRepeated().encodeWithTag(writer, 8, value.getRows());
                if (value.getTable() != null) {
                    LoyaltyTable.ADAPTER.encodeWithTag(writer, 9, value.getTable());
                }
                if (value.getAction_type() != LoyaltyActionType.UNIVERSAL_LINK) {
                    LoyaltyActionType.ADAPTER.encodeWithTag(writer, 10, value.getAction_type());
                }
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 11, value.getUrl());
                }
                if (!m.c(value.getUrl_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 12, value.getUrl_text());
                }
                if (!m.c(value.getSubtitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 13, value.getSubtitle());
                }
                LoyaltyCardTask.ADAPTER.asRepeated().encodeWithTag(writer, 14, value.getTasks());
                if (value.getFocus_task_index() != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 15, Integer.valueOf(value.getFocus_task_index()));
                }
                if (value.getModal() != null) {
                    LoyaltyCardModal.ADAPTER.encodeWithTag(writer, 16, value.getModal());
                }
                if (value.getSubtitle_style() != LoyaltyTextStyle.TEXT_STANDARD) {
                    LoyaltyTextStyle.ADAPTER.encodeWithTag(writer, 17, value.getSubtitle_style());
                }
                if (!m.c(value.getBody_image_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 18, value.getBody_image_url());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoyaltyCard value) {
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
                m.h(value, "value");
                if (value.getStyle() == LoyaltyCardStyle.STANDARD) {
                    return 0;
                }
                int encodedSizeWithTag2 = LoyaltyCardStyle.ADAPTER.encodedSizeWithTag(1, value.getStyle());
                if (m.c(value.getCard_name(), "")) {
                    i2 = encodedSizeWithTag2;
                    i15 = 0;
                } else {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(2, value.getCard_name());
                    if (m.c(value.getImage_url(), "")) {
                        i2 = encodedSizeWithTag2;
                        i3 = encodedSizeWithTag3;
                        i14 = 0;
                    } else {
                        int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(3, value.getImage_url());
                        if (m.c(value.getTitle(), "")) {
                            i2 = encodedSizeWithTag2;
                            i3 = encodedSizeWithTag3;
                            i13 = 0;
                        } else {
                            int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(4, value.getTitle());
                            if (m.c(value.getBody(), "")) {
                                i2 = encodedSizeWithTag2;
                                i3 = encodedSizeWithTag3;
                                i12 = 0;
                            } else {
                                int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(5, value.getBody()) + LoyaltyCardDetail.ADAPTER.asRepeated().encodedSizeWithTag(6, value.getDetails());
                                if (value.getButton() == null) {
                                    i2 = encodedSizeWithTag2;
                                    i3 = encodedSizeWithTag3;
                                    i11 = 0;
                                } else {
                                    int encodedSizeWithTag7 = Button.ADAPTER.encodedSizeWithTag(7, value.getButton()) + LoyaltyCardRow.ADAPTER.asRepeated().encodedSizeWithTag(8, value.getRows());
                                    if (value.getTable() == null) {
                                        i2 = encodedSizeWithTag2;
                                        i3 = encodedSizeWithTag3;
                                        i10 = 0;
                                    } else {
                                        int encodedSizeWithTag8 = LoyaltyTable.ADAPTER.encodedSizeWithTag(9, value.getTable());
                                        if (value.getAction_type() == LoyaltyActionType.UNIVERSAL_LINK) {
                                            i2 = encodedSizeWithTag2;
                                            i3 = encodedSizeWithTag3;
                                            i9 = 0;
                                        } else {
                                            int encodedSizeWithTag9 = LoyaltyActionType.ADAPTER.encodedSizeWithTag(10, value.getAction_type());
                                            if (m.c(value.getUrl(), "")) {
                                                i2 = encodedSizeWithTag2;
                                                i3 = encodedSizeWithTag3;
                                                i8 = 0;
                                            } else {
                                                int encodedSizeWithTag10 = protoAdapter2.encodedSizeWithTag(11, value.getUrl());
                                                if (m.c(value.getUrl_text(), "")) {
                                                    i2 = encodedSizeWithTag2;
                                                    i3 = encodedSizeWithTag3;
                                                    i7 = 0;
                                                } else {
                                                    int encodedSizeWithTag11 = protoAdapter2.encodedSizeWithTag(12, value.getUrl_text());
                                                    if (m.c(value.getSubtitle(), "")) {
                                                        i2 = encodedSizeWithTag2;
                                                        i3 = encodedSizeWithTag3;
                                                        i6 = 0;
                                                    } else {
                                                        int encodedSizeWithTag12 = protoAdapter2.encodedSizeWithTag(13, value.getSubtitle()) + LoyaltyCardTask.ADAPTER.asRepeated().encodedSizeWithTag(14, value.getTasks());
                                                        if (value.getFocus_task_index() == 0) {
                                                            i2 = encodedSizeWithTag2;
                                                            i3 = encodedSizeWithTag3;
                                                            i5 = 0;
                                                        } else {
                                                            int encodedSizeWithTag13 = ProtoAdapter.INT32.encodedSizeWithTag(15, Integer.valueOf(value.getFocus_task_index()));
                                                            if (value.getModal() == null) {
                                                                i2 = encodedSizeWithTag2;
                                                                i3 = encodedSizeWithTag3;
                                                                i4 = 0;
                                                            } else {
                                                                i2 = encodedSizeWithTag2;
                                                                int encodedSizeWithTag14 = LoyaltyCardModal.ADAPTER.encodedSizeWithTag(16, value.getModal());
                                                                if (value.getSubtitle_style() == LoyaltyTextStyle.TEXT_STANDARD) {
                                                                    i3 = encodedSizeWithTag3;
                                                                    encodedSizeWithTag = 0;
                                                                } else {
                                                                    i3 = encodedSizeWithTag3;
                                                                    encodedSizeWithTag = LoyaltyTextStyle.ADAPTER.encodedSizeWithTag(17, value.getSubtitle_style()) + (m.c(value.getBody_image_url(), "") ? 0 : protoAdapter2.encodedSizeWithTag(18, value.getBody_image_url()) + value.unknownFields().Q());
                                                                }
                                                                i4 = encodedSizeWithTag + encodedSizeWithTag14;
                                                            }
                                                            i5 = i4 + encodedSizeWithTag13;
                                                        }
                                                        i6 = i5 + encodedSizeWithTag12;
                                                    }
                                                    i7 = i6 + encodedSizeWithTag11;
                                                }
                                                i8 = i7 + encodedSizeWithTag10;
                                            }
                                            i9 = i8 + encodedSizeWithTag9;
                                        }
                                        i10 = i9 + encodedSizeWithTag8;
                                    }
                                    i11 = i10 + encodedSizeWithTag7;
                                }
                                i12 = i11 + encodedSizeWithTag6;
                            }
                            i13 = i12 + encodedSizeWithTag5;
                        }
                        i14 = i13 + encodedSizeWithTag4;
                    }
                    i15 = i3 + i14;
                }
                return i2 + i15;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCard redact(LoyaltyCard value) {
                LoyaltyCard copy;
                m.h(value, "value");
                List a = b.a(value.getDetails(), LoyaltyCardDetail.ADAPTER);
                Button button = value.getButton();
                Button redact = button != null ? Button.ADAPTER.redact(button) : null;
                List a2 = b.a(value.getRows(), LoyaltyCardRow.ADAPTER);
                LoyaltyTable table = value.getTable();
                LoyaltyTable redact2 = table != null ? LoyaltyTable.ADAPTER.redact(table) : null;
                List a3 = b.a(value.getTasks(), LoyaltyCardTask.ADAPTER);
                LoyaltyCardModal modal = value.getModal();
                copy = value.copy((r37 & 1) != 0 ? value.style : null, (r37 & 2) != 0 ? value.card_name : null, (r37 & 4) != 0 ? value.image_url : null, (r37 & 8) != 0 ? value.title : null, (r37 & 16) != 0 ? value.body : null, (r37 & 32) != 0 ? value.details : a, (r37 & 64) != 0 ? value.button : redact, (r37 & 128) != 0 ? value.rows : a2, (r37 & 256) != 0 ? value.table : redact2, (r37 & 512) != 0 ? value.action_type : null, (r37 & 1024) != 0 ? value.url : null, (r37 & PKIFailureInfo.wrongIntegrity) != 0 ? value.url_text : null, (r37 & 4096) != 0 ? value.subtitle : null, (r37 & PKIFailureInfo.certRevoked) != 0 ? value.tasks : a3, (r37 & 16384) != 0 ? value.focus_task_index : 0, (r37 & 32768) != 0 ? value.modal : modal != null ? LoyaltyCardModal.ADAPTER.redact(modal) : null, (r37 & 65536) != 0 ? value.subtitle_style : null, (r37 & PKIFailureInfo.unsupportedVersion) != 0 ? value.body_image_url : null, (r37 & PKIFailureInfo.transactionIdInUse) != 0 ? value.unknownFields() : i.a);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoyaltyCard() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, 524287, null);
    }

    public /* synthetic */ LoyaltyCard(LoyaltyCardStyle loyaltyCardStyle, String str, String str2, String str3, String str4, List list, Button button, List list2, LoyaltyTable loyaltyTable, LoyaltyActionType loyaltyActionType, String str5, String str6, String str7, List list3, int i2, LoyaltyCardModal loyaltyCardModal, LoyaltyTextStyle loyaltyTextStyle, String str8, i iVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? LoyaltyCardStyle.STANDARD : loyaltyCardStyle, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? r.g() : list, (i3 & 64) != 0 ? null : button, (i3 & 128) != 0 ? r.g() : list2, (i3 & 256) != 0 ? null : loyaltyTable, (i3 & 512) != 0 ? LoyaltyActionType.UNIVERSAL_LINK : loyaltyActionType, (i3 & 1024) != 0 ? "" : str5, (i3 & PKIFailureInfo.wrongIntegrity) != 0 ? "" : str6, (i3 & 4096) != 0 ? "" : str7, (i3 & PKIFailureInfo.certRevoked) != 0 ? r.g() : list3, (i3 & 16384) != 0 ? 0 : i2, (i3 & 32768) != 0 ? null : loyaltyCardModal, (i3 & 65536) != 0 ? LoyaltyTextStyle.TEXT_STANDARD : loyaltyTextStyle, (i3 & PKIFailureInfo.unsupportedVersion) != 0 ? "" : str8, (i3 & PKIFailureInfo.transactionIdInUse) != 0 ? i.a : iVar);
    }

    public final LoyaltyCard copy(LoyaltyCardStyle style, String card_name, String image_url, String title, String body, List<LoyaltyCardDetail> details, Button button, List<LoyaltyCardRow> rows, LoyaltyTable loyaltyTable, LoyaltyActionType action_type, String url, String url_text, String subtitle, List<LoyaltyCardTask> tasks, int i2, LoyaltyCardModal loyaltyCardModal, LoyaltyTextStyle subtitle_style, String body_image_url, i unknownFields) {
        m.h(style, "style");
        m.h(card_name, "card_name");
        m.h(image_url, "image_url");
        m.h(title, "title");
        m.h(body, "body");
        m.h(details, "details");
        m.h(rows, "rows");
        m.h(action_type, "action_type");
        m.h(url, "url");
        m.h(url_text, "url_text");
        m.h(subtitle, "subtitle");
        m.h(tasks, "tasks");
        m.h(subtitle_style, "subtitle_style");
        m.h(body_image_url, "body_image_url");
        m.h(unknownFields, "unknownFields");
        return new LoyaltyCard(style, card_name, image_url, title, body, details, button, rows, loyaltyTable, action_type, url, url_text, subtitle, tasks, i2, loyaltyCardModal, subtitle_style, body_image_url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoyaltyCard) {
            LoyaltyCard loyaltyCard = (LoyaltyCard) obj;
            return m.c(unknownFields(), loyaltyCard.unknownFields()) && this.style == loyaltyCard.style && m.c(this.card_name, loyaltyCard.card_name) && m.c(this.image_url, loyaltyCard.image_url) && m.c(this.title, loyaltyCard.title) && m.c(this.body, loyaltyCard.body) && m.c(this.details, loyaltyCard.details) && m.c(this.button, loyaltyCard.button) && m.c(this.rows, loyaltyCard.rows) && m.c(this.table, loyaltyCard.table) && this.action_type == loyaltyCard.action_type && m.c(this.url, loyaltyCard.url) && m.c(this.url_text, loyaltyCard.url_text) && m.c(this.subtitle, loyaltyCard.subtitle) && m.c(this.tasks, loyaltyCard.tasks) && this.focus_task_index == loyaltyCard.focus_task_index && m.c(this.modal, loyaltyCard.modal) && this.subtitle_style == loyaltyCard.subtitle_style && m.c(this.body_image_url, loyaltyCard.body_image_url);
        }
        return false;
    }

    public final LoyaltyActionType getAction_type() {
        return this.action_type;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getBody_image_url() {
        return this.body_image_url;
    }

    public final Button getButton() {
        return this.button;
    }

    public final String getCard_name() {
        return this.card_name;
    }

    public final List<LoyaltyCardDetail> getDetails() {
        return this.details;
    }

    public final int getFocus_task_index() {
        return this.focus_task_index;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final LoyaltyCardModal getModal() {
        return this.modal;
    }

    public final List<LoyaltyCardRow> getRows() {
        return this.rows;
    }

    public final LoyaltyCardStyle getStyle() {
        return this.style;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final LoyaltyTextStyle getSubtitle_style() {
        return this.subtitle_style;
    }

    public final LoyaltyTable getTable() {
        return this.table;
    }

    public final List<LoyaltyCardTask> getTasks() {
        return this.tasks;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrl_text() {
        return this.url_text;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((((unknownFields().hashCode() * 37) + this.style.hashCode()) * 37) + this.card_name.hashCode()) * 37) + this.image_url.hashCode()) * 37) + this.title.hashCode()) * 37) + this.body.hashCode()) * 37) + this.details.hashCode()) * 37;
            Button button = this.button;
            int hashCode2 = (((hashCode + (button != null ? button.hashCode() : 0)) * 37) + this.rows.hashCode()) * 37;
            LoyaltyTable loyaltyTable = this.table;
            int hashCode3 = (((((((((((((hashCode2 + (loyaltyTable != null ? loyaltyTable.hashCode() : 0)) * 37) + this.action_type.hashCode()) * 37) + this.url.hashCode()) * 37) + this.url_text.hashCode()) * 37) + this.subtitle.hashCode()) * 37) + this.tasks.hashCode()) * 37) + this.focus_task_index) * 37;
            LoyaltyCardModal loyaltyCardModal = this.modal;
            int hashCode4 = ((((hashCode3 + (loyaltyCardModal != null ? loyaltyCardModal.hashCode() : 0)) * 37) + this.subtitle_style.hashCode()) * 37) + this.body_image_url.hashCode();
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m410newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("style=" + this.style);
        arrayList.add("card_name=" + b.c(this.card_name));
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("body=" + b.c(this.body));
        if (!this.details.isEmpty()) {
            arrayList.add("details=" + this.details);
        }
        if (this.button != null) {
            arrayList.add("button=" + this.button);
        }
        if (!this.rows.isEmpty()) {
            arrayList.add("rows=" + this.rows);
        }
        if (this.table != null) {
            arrayList.add("table=" + this.table);
        }
        arrayList.add("action_type=" + this.action_type);
        arrayList.add("url=" + b.c(this.url));
        arrayList.add("url_text=" + b.c(this.url_text));
        arrayList.add("subtitle=" + b.c(this.subtitle));
        if (!this.tasks.isEmpty()) {
            arrayList.add("tasks=" + this.tasks);
        }
        arrayList.add("focus_task_index=" + this.focus_task_index);
        if (this.modal != null) {
            arrayList.add("modal=" + this.modal);
        }
        arrayList.add("subtitle_style=" + this.subtitle_style);
        arrayList.add("body_image_url=" + b.c(this.body_image_url));
        h0 = z.h0(arrayList, ", ", "LoyaltyCard{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m410newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoyaltyCard(LoyaltyCardStyle style, String card_name, String image_url, String title, String body, List<LoyaltyCardDetail> details, Button button, List<LoyaltyCardRow> rows, LoyaltyTable loyaltyTable, LoyaltyActionType action_type, String url, String url_text, String subtitle, List<LoyaltyCardTask> tasks, int i2, LoyaltyCardModal loyaltyCardModal, LoyaltyTextStyle subtitle_style, String body_image_url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(style, "style");
        m.h(card_name, "card_name");
        m.h(image_url, "image_url");
        m.h(title, "title");
        m.h(body, "body");
        m.h(details, "details");
        m.h(rows, "rows");
        m.h(action_type, "action_type");
        m.h(url, "url");
        m.h(url_text, "url_text");
        m.h(subtitle, "subtitle");
        m.h(tasks, "tasks");
        m.h(subtitle_style, "subtitle_style");
        m.h(body_image_url, "body_image_url");
        m.h(unknownFields, "unknownFields");
        this.style = style;
        this.card_name = card_name;
        this.image_url = image_url;
        this.title = title;
        this.body = body;
        this.details = details;
        this.button = button;
        this.rows = rows;
        this.table = loyaltyTable;
        this.action_type = action_type;
        this.url = url;
        this.url_text = url_text;
        this.subtitle = subtitle;
        this.tasks = tasks;
        this.focus_task_index = i2;
        this.modal = loyaltyCardModal;
        this.subtitle_style = subtitle_style;
        this.body_image_url = body_image_url;
    }
}