package com.coinbase.android.apiv3.generated.resources;

import android.os.Parcelable;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.lwansbrough.RCTCamera.RCTCameraModule;
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
import kotlin.x;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: Notification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 :2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u008f\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\r\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b8\u00109J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0095\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u001d\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010#\u001a\u0004\b$\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0019\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b)\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b*\u0010\u000fR\u001c\u0010\u001a\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010#\u001a\u0004\b+\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b,\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b.\u0010/R\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b0\u0010\u000fR\u001c\u0010\u001e\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b2\u00103R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b5\u00106R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b7\u0010\u000f¨\u0006;"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Notification;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "event_id", "Lcom/coinbase/android/apiv3/generated/resources/Medium;", RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_MEDIUM, "notification_category", "Lcom/coinbase/android/apiv3/generated/resources/StyleType;", "style", "url", MessageBundle.TITLE_ENTRY, "header", "right_label", "right_sublabel", "", "tags", "image_url", "highlighted", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/Medium;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/StyleType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLj/i;)Lcom/coinbase/android/apiv3/generated/resources/Notification;", "Ljava/lang/String;", "getImage_url", "Lcom/coinbase/android/apiv3/generated/resources/Medium;", "getMedium", "()Lcom/coinbase/android/apiv3/generated/resources/Medium;", "getRight_label", "getEvent_id", "getTitle", "getRight_sublabel", "getNotification_category", "Lcom/coinbase/android/apiv3/generated/resources/StyleType;", "getStyle", "()Lcom/coinbase/android/apiv3/generated/resources/StyleType;", "getHeader", "Z", "getHighlighted", "()Z", "Ljava/util/List;", "getTags", "()Ljava/util/List;", "getUrl", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/Medium;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/resources/StyleType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Notification extends a {
    public static final ProtoAdapter<Notification> ADAPTER;
    public static final Parcelable.Creator<Notification> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = WalletLinkPushNotification.eventIdKey, tag = 1)
    private final String event_id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    private final String header;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 12)
    private final boolean highlighted;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 11)
    private final String image_url;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Medium#ADAPTER", tag = 2)
    private final Medium medium;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "notificationCategory", tag = 3)
    private final String notification_category;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "rightLabel", tag = 8)
    private final String right_label;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "rightSublabel", tag = 9)
    private final String right_sublabel;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.StyleType#ADAPTER", tag = 4)
    private final StyleType style;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = p.a.REPEATED, tag = 10)
    private final List<String> tags;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    private final String title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    private final String url;

    /* compiled from: Notification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/resources/Notification$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/resources/Notification;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<Notification> protoAdapter = new ProtoAdapter<Notification>(c.LENGTH_DELIMITED, e0.b(Notification.class), "type.googleapis.com/coinbase.public_api.resources.Notification") { // from class: com.coinbase.android.apiv3.generated.resources.Notification$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Notification decode(k reader) {
                Medium medium;
                long j2;
                StyleType decode;
                String str;
                Medium medium2;
                m.h(reader, "reader");
                Medium medium3 = Medium.PUSH;
                StyleType styleType = StyleType.RESERVED;
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str2 = "";
                StyleType styleType2 = styleType;
                String str3 = "";
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                boolean z = false;
                Medium medium4 = medium3;
                String str9 = str8;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new Notification(str2, medium4, str9, styleType2, str3, str4, str5, str6, str7, arrayList, str8, z, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            j2 = d2;
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            Medium medium5 = medium4;
                            j2 = d2;
                            try {
                                medium4 = Medium.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                e = e2;
                                medium4 = medium5;
                            }
                            try {
                                x xVar = x.a;
                                str = str2;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                e = e3;
                                str = str2;
                                reader.a(g2, c.VARINT, Long.valueOf(e.a));
                                x xVar2 = x.a;
                                str2 = str;
                                d2 = j2;
                            }
                            str2 = str;
                        case 3:
                            j2 = d2;
                            str9 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            try {
                                decode = StyleType.ADAPTER.decode(reader);
                            } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                                e = e4;
                            }
                            try {
                                x xVar3 = x.a;
                                j2 = d2;
                                styleType2 = decode;
                                medium = medium4;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e5) {
                                e = e5;
                                styleType2 = decode;
                                medium = medium4;
                                j2 = d2;
                                reader.a(g2, c.VARINT, Long.valueOf(e.a));
                                x xVar4 = x.a;
                                medium4 = medium;
                                d2 = j2;
                            }
                            medium4 = medium;
                        case 5:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            j2 = d2;
                            break;
                        case 6:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            j2 = d2;
                            break;
                        case 7:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            j2 = d2;
                            break;
                        case 8:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            j2 = d2;
                            break;
                        case 9:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            j2 = d2;
                            break;
                        case 10:
                            arrayList.add(ProtoAdapter.STRING.decode(reader));
                            medium2 = medium4;
                            j2 = d2;
                            str = str2;
                            medium4 = medium2;
                            str2 = str;
                            break;
                        case 11:
                            str8 = ProtoAdapter.STRING.decode(reader);
                            j2 = d2;
                            break;
                        case 12:
                            j2 = d2;
                            z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                            break;
                        default:
                            medium2 = medium4;
                            j2 = d2;
                            str = str2;
                            reader.m(g2);
                            medium4 = medium2;
                            str2 = str;
                            break;
                    }
                    d2 = j2;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, Notification value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getEvent_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getEvent_id());
                }
                if (value.getMedium() != Medium.PUSH) {
                    Medium.ADAPTER.encodeWithTag(writer, 2, value.getMedium());
                }
                if (!m.c(value.getNotification_category(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getNotification_category());
                }
                if (value.getStyle() != StyleType.RESERVED) {
                    StyleType.ADAPTER.encodeWithTag(writer, 4, value.getStyle());
                }
                if (!m.c(value.getUrl(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getUrl());
                }
                if (!m.c(value.getTitle(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getTitle());
                }
                if (!m.c(value.getHeader(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getHeader());
                }
                if (!m.c(value.getRight_label(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.getRight_label());
                }
                if (!m.c(value.getRight_sublabel(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 9, value.getRight_sublabel());
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.asRepeated().encodeWithTag(writer, 10, value.getTags());
                if (!m.c(value.getImage_url(), "")) {
                    protoAdapter2.encodeWithTag(writer, 11, value.getImage_url());
                }
                if (value.getHighlighted()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 12, Boolean.valueOf(value.getHighlighted()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(Notification value) {
                m.h(value, "value");
                if (m.c(value.getEvent_id(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getEvent_id());
                if (value.getMedium() != Medium.PUSH) {
                    int encodedSizeWithTag2 = Medium.ADAPTER.encodedSizeWithTag(2, value.getMedium());
                    if (!m.c(value.getNotification_category(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getNotification_category());
                        if (value.getStyle() != StyleType.RESERVED) {
                            int encodedSizeWithTag4 = StyleType.ADAPTER.encodedSizeWithTag(4, value.getStyle());
                            if (!m.c(value.getUrl(), "")) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getUrl());
                                if (!m.c(value.getTitle(), "")) {
                                    int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(6, value.getTitle());
                                    if (!m.c(value.getHeader(), "")) {
                                        int encodedSizeWithTag7 = protoAdapter2.encodedSizeWithTag(7, value.getHeader());
                                        if (!m.c(value.getRight_label(), "")) {
                                            int encodedSizeWithTag8 = protoAdapter2.encodedSizeWithTag(8, value.getRight_label());
                                            if (!m.c(value.getRight_sublabel(), "")) {
                                                int encodedSizeWithTag9 = protoAdapter2.encodedSizeWithTag(9, value.getRight_sublabel()) + protoAdapter2.asRepeated().encodedSizeWithTag(10, value.getTags());
                                                if (!m.c(value.getImage_url(), "")) {
                                                    r3 = (value.getHighlighted() ? ProtoAdapter.BOOL.encodedSizeWithTag(12, Boolean.valueOf(value.getHighlighted())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(11, value.getImage_url());
                                                }
                                                r3 += encodedSizeWithTag9;
                                            }
                                            r3 += encodedSizeWithTag8;
                                        }
                                        r3 += encodedSizeWithTag7;
                                    }
                                    r3 += encodedSizeWithTag6;
                                }
                                r3 += encodedSizeWithTag5;
                            }
                            r3 += encodedSizeWithTag4;
                        }
                        r3 += encodedSizeWithTag3;
                    }
                    r3 += encodedSizeWithTag2;
                }
                return r3 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public Notification redact(Notification value) {
                m.h(value, "value");
                return Notification.copy$default(value, null, null, null, null, null, null, null, null, null, null, null, false, i.a, 4095, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public Notification() {
        this(null, null, null, null, null, null, null, null, null, null, null, false, null, 8191, null);
    }

    public /* synthetic */ Notification(String str, Medium medium, String str2, StyleType styleType, String str3, String str4, String str5, String str6, String str7, List list, String str8, boolean z, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? Medium.PUSH : medium, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? StyleType.RESERVED : styleType, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? r.g() : list, (i2 & 1024) == 0 ? str8 : "", (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? false : z, (i2 & 4096) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Notification copy$default(Notification notification, String str, Medium medium, String str2, StyleType styleType, String str3, String str4, String str5, String str6, String str7, List list, String str8, boolean z, i iVar, int i2, Object obj) {
        return notification.copy((i2 & 1) != 0 ? notification.event_id : str, (i2 & 2) != 0 ? notification.medium : medium, (i2 & 4) != 0 ? notification.notification_category : str2, (i2 & 8) != 0 ? notification.style : styleType, (i2 & 16) != 0 ? notification.url : str3, (i2 & 32) != 0 ? notification.title : str4, (i2 & 64) != 0 ? notification.header : str5, (i2 & 128) != 0 ? notification.right_label : str6, (i2 & 256) != 0 ? notification.right_sublabel : str7, (i2 & 512) != 0 ? notification.tags : list, (i2 & 1024) != 0 ? notification.image_url : str8, (i2 & PKIFailureInfo.wrongIntegrity) != 0 ? notification.highlighted : z, (i2 & 4096) != 0 ? notification.unknownFields() : iVar);
    }

    public final Notification copy(String event_id, Medium medium, String notification_category, StyleType style, String url, String title, String header, String right_label, String right_sublabel, List<String> tags, String image_url, boolean z, i unknownFields) {
        m.h(event_id, "event_id");
        m.h(medium, "medium");
        m.h(notification_category, "notification_category");
        m.h(style, "style");
        m.h(url, "url");
        m.h(title, "title");
        m.h(header, "header");
        m.h(right_label, "right_label");
        m.h(right_sublabel, "right_sublabel");
        m.h(tags, "tags");
        m.h(image_url, "image_url");
        m.h(unknownFields, "unknownFields");
        return new Notification(event_id, medium, notification_category, style, url, title, header, right_label, right_sublabel, tags, image_url, z, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Notification) {
            Notification notification = (Notification) obj;
            return m.c(unknownFields(), notification.unknownFields()) && m.c(this.event_id, notification.event_id) && this.medium == notification.medium && m.c(this.notification_category, notification.notification_category) && this.style == notification.style && m.c(this.url, notification.url) && m.c(this.title, notification.title) && m.c(this.header, notification.header) && m.c(this.right_label, notification.right_label) && m.c(this.right_sublabel, notification.right_sublabel) && m.c(this.tags, notification.tags) && m.c(this.image_url, notification.image_url) && this.highlighted == notification.highlighted;
        }
        return false;
    }

    public final String getEvent_id() {
        return this.event_id;
    }

    public final String getHeader() {
        return this.header;
    }

    public final boolean getHighlighted() {
        return this.highlighted;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final Medium getMedium() {
        return this.medium;
    }

    public final String getNotification_category() {
        return this.notification_category;
    }

    public final String getRight_label() {
        return this.right_label;
    }

    public final String getRight_sublabel() {
        return this.right_sublabel;
    }

    public final StyleType getStyle() {
        return this.style;
    }

    public final List<String> getTags() {
        return this.tags;
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
            int hashCode = (((((((((((((((((((((((unknownFields().hashCode() * 37) + this.event_id.hashCode()) * 37) + this.medium.hashCode()) * 37) + this.notification_category.hashCode()) * 37) + this.style.hashCode()) * 37) + this.url.hashCode()) * 37) + this.title.hashCode()) * 37) + this.header.hashCode()) * 37) + this.right_label.hashCode()) * 37) + this.right_sublabel.hashCode()) * 37) + this.tags.hashCode()) * 37) + this.image_url.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.highlighted);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m533newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("event_id=" + b.c(this.event_id));
        arrayList.add("medium=" + this.medium);
        arrayList.add("notification_category=" + b.c(this.notification_category));
        arrayList.add("style=" + this.style);
        arrayList.add("url=" + b.c(this.url));
        arrayList.add("title=" + b.c(this.title));
        arrayList.add("header=" + b.c(this.header));
        arrayList.add("right_label=" + b.c(this.right_label));
        arrayList.add("right_sublabel=" + b.c(this.right_sublabel));
        if (!this.tags.isEmpty()) {
            arrayList.add("tags=" + b.d(this.tags));
        }
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("highlighted=" + this.highlighted);
        h0 = z.h0(arrayList, ", ", "Notification{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m533newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Notification(String event_id, Medium medium, String notification_category, StyleType style, String url, String title, String header, String right_label, String right_sublabel, List<String> tags, String image_url, boolean z, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(event_id, "event_id");
        m.h(medium, "medium");
        m.h(notification_category, "notification_category");
        m.h(style, "style");
        m.h(url, "url");
        m.h(title, "title");
        m.h(header, "header");
        m.h(right_label, "right_label");
        m.h(right_sublabel, "right_sublabel");
        m.h(tags, "tags");
        m.h(image_url, "image_url");
        m.h(unknownFields, "unknownFields");
        this.event_id = event_id;
        this.medium = medium;
        this.notification_category = notification_category;
        this.style = style;
        this.url = url;
        this.title = title;
        this.header = header;
        this.right_label = right_label;
        this.right_sublabel = right_sublabel;
        this.tags = tags;
        this.image_url = image_url;
        this.highlighted = z;
    }
}