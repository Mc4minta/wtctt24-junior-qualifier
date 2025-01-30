package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
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

/* compiled from: NotificationPreference.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+BK\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJQ\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b%\u0010\u000fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/NotificationPreference;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;", "type", ApiConstants.NAME, ApiConstants.DESCRIPTION, "", "Lcom/coinbase/android/apiv3/generated/authed/ChannelPreference;", "channel_preferences", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreview;", "notification_preview", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/NotificationPreview;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/NotificationPreference;", "Ljava/lang/String;", "getName", "Ljava/util/List;", "getChannel_preferences", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;", "getDescription", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreview;", "getNotification_preview", "()Lcom/coinbase/android/apiv3/generated/authed/NotificationPreview;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/NotificationPreview;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class NotificationPreference extends com.squareup.wire.a {
    public static final ProtoAdapter<NotificationPreference> ADAPTER;
    public static final Parcelable.Creator<NotificationPreference> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.ChannelPreference#ADAPTER", jsonName = "channelPreferences", label = p.a.REPEATED, tag = 4)
    private final List<ChannelPreference> channel_preferences;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String description;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String name;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.NotificationPreview#ADAPTER", jsonName = "notificationPreview", tag = 5)
    private final NotificationPreview notification_preview;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.NotificationPreferenceType#ADAPTER", tag = 1)
    private final NotificationPreferenceType type;

    /* compiled from: NotificationPreference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/NotificationPreference$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreference;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(NotificationPreference.class);
        ProtoAdapter<NotificationPreference> protoAdapter = new ProtoAdapter<NotificationPreference>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.NotificationPreference") { // from class: com.coinbase.android.apiv3.generated.authed.NotificationPreference$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public NotificationPreference decode(k reader) {
                NotificationPreferenceType notificationPreferenceType;
                ProtoAdapter.EnumConstantNotFoundException e2;
                m.h(reader, "reader");
                NotificationPreferenceType notificationPreferenceType2 = NotificationPreferenceType.SECURITY_ALERTS_TYPE;
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                String str = "";
                NotificationPreview notificationPreview = null;
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new NotificationPreference(notificationPreferenceType2, str, str2, arrayList, notificationPreview, reader.e(d2));
                    } else if (g2 == 1) {
                        try {
                            notificationPreferenceType = NotificationPreferenceType.ADAPTER.decode(reader);
                            try {
                                x xVar = x.a;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                e2 = e3;
                                reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                                x xVar2 = x.a;
                                notificationPreferenceType2 = notificationPreferenceType;
                            }
                        } catch (ProtoAdapter.EnumConstantNotFoundException e4) {
                            notificationPreferenceType = notificationPreferenceType2;
                            e2 = e4;
                        }
                        notificationPreferenceType2 = notificationPreferenceType;
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 4) {
                        arrayList.add(ChannelPreference.ADAPTER.decode(reader));
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        notificationPreview = NotificationPreview.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, NotificationPreference value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != NotificationPreferenceType.SECURITY_ALERTS_TYPE) {
                    NotificationPreferenceType.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getName());
                }
                if (!m.c(value.getDescription(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getDescription());
                }
                ChannelPreference.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.getChannel_preferences());
                if (value.getNotification_preview() != null) {
                    NotificationPreview.ADAPTER.encodeWithTag(writer, 5, value.getNotification_preview());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(NotificationPreference value) {
                m.h(value, "value");
                if (value.getType() == NotificationPreferenceType.SECURITY_ALERTS_TYPE) {
                    return 0;
                }
                int encodedSizeWithTag = NotificationPreferenceType.ADAPTER.encodedSizeWithTag(1, value.getType());
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getName());
                    if (!m.c(value.getDescription(), "")) {
                        r2 = (value.getNotification_preview() != null ? NotificationPreview.ADAPTER.encodedSizeWithTag(5, value.getNotification_preview()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(3, value.getDescription()) + ChannelPreference.ADAPTER.asRepeated().encodedSizeWithTag(4, value.getChannel_preferences());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public NotificationPreference redact(NotificationPreference value) {
                m.h(value, "value");
                List a = com.squareup.wire.q.b.a(value.getChannel_preferences(), ChannelPreference.ADAPTER);
                NotificationPreview notification_preview = value.getNotification_preview();
                return NotificationPreference.copy$default(value, null, null, null, a, notification_preview != null ? NotificationPreview.ADAPTER.redact(notification_preview) : null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public NotificationPreference() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ NotificationPreference(NotificationPreferenceType notificationPreferenceType, String str, String str2, List list, NotificationPreview notificationPreview, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? NotificationPreferenceType.SECURITY_ALERTS_TYPE : notificationPreferenceType, (i2 & 2) != 0 ? "" : str, (i2 & 4) == 0 ? str2 : "", (i2 & 8) != 0 ? r.g() : list, (i2 & 16) != 0 ? null : notificationPreview, (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ NotificationPreference copy$default(NotificationPreference notificationPreference, NotificationPreferenceType notificationPreferenceType, String str, String str2, List list, NotificationPreview notificationPreview, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            notificationPreferenceType = notificationPreference.type;
        }
        if ((i2 & 2) != 0) {
            str = notificationPreference.name;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = notificationPreference.description;
        }
        String str4 = str2;
        List<ChannelPreference> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = notificationPreference.channel_preferences;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            notificationPreview = notificationPreference.notification_preview;
        }
        NotificationPreview notificationPreview2 = notificationPreview;
        if ((i2 & 32) != 0) {
            iVar = notificationPreference.unknownFields();
        }
        return notificationPreference.copy(notificationPreferenceType, str3, str4, list3, notificationPreview2, iVar);
    }

    public final NotificationPreference copy(NotificationPreferenceType type, String name, String description, List<ChannelPreference> channel_preferences, NotificationPreview notificationPreview, i unknownFields) {
        m.h(type, "type");
        m.h(name, "name");
        m.h(description, "description");
        m.h(channel_preferences, "channel_preferences");
        m.h(unknownFields, "unknownFields");
        return new NotificationPreference(type, name, description, channel_preferences, notificationPreview, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NotificationPreference) {
            NotificationPreference notificationPreference = (NotificationPreference) obj;
            return m.c(unknownFields(), notificationPreference.unknownFields()) && this.type == notificationPreference.type && m.c(this.name, notificationPreference.name) && m.c(this.description, notificationPreference.description) && m.c(this.channel_preferences, notificationPreference.channel_preferences) && m.c(this.notification_preview, notificationPreference.notification_preview);
        }
        return false;
    }

    public final List<ChannelPreference> getChannel_preferences() {
        return this.channel_preferences;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final NotificationPreview getNotification_preview() {
        return this.notification_preview;
    }

    public final NotificationPreferenceType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37) + this.name.hashCode()) * 37) + this.description.hashCode()) * 37) + this.channel_preferences.hashCode()) * 37;
            NotificationPreview notificationPreview = this.notification_preview;
            int hashCode2 = hashCode + (notificationPreview != null ? notificationPreview.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m240newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        arrayList.add("name=" + com.squareup.wire.q.b.c(this.name));
        arrayList.add("description=" + com.squareup.wire.q.b.c(this.description));
        if (!this.channel_preferences.isEmpty()) {
            arrayList.add("channel_preferences=" + this.channel_preferences);
        }
        if (this.notification_preview != null) {
            arrayList.add("notification_preview=" + this.notification_preview);
        }
        h0 = z.h0(arrayList, ", ", "NotificationPreference{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m240newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationPreference(NotificationPreferenceType type, String name, String description, List<ChannelPreference> channel_preferences, NotificationPreview notificationPreview, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(name, "name");
        m.h(description, "description");
        m.h(channel_preferences, "channel_preferences");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.name = name;
        this.description = description;
        this.channel_preferences = channel_preferences;
        this.notification_preview = notificationPreview;
    }
}