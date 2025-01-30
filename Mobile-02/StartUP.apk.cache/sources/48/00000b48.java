package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.squareup.wire.ProtoAdapter;
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

/* compiled from: UpdateNotificationPreferenceRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B/\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0014\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/UpdateNotificationPreferenceRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;", "type", "Lcom/coinbase/android/apiv3/generated/authed/Channel;", AppsFlyerProperties.CHANNEL, "enabled", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;Lcom/coinbase/android/apiv3/generated/authed/Channel;ZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/UpdateNotificationPreferenceRequest;", "Lcom/coinbase/android/apiv3/generated/authed/Channel;", "getChannel", "()Lcom/coinbase/android/apiv3/generated/authed/Channel;", "Z", "getEnabled", "()Z", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/NotificationPreferenceType;Lcom/coinbase/android/apiv3/generated/authed/Channel;ZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UpdateNotificationPreferenceRequest extends com.squareup.wire.a {
    public static final ProtoAdapter<UpdateNotificationPreferenceRequest> ADAPTER;
    public static final Parcelable.Creator<UpdateNotificationPreferenceRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.Channel#ADAPTER", tag = 2)
    private final Channel channel;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    private final boolean enabled;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.NotificationPreferenceType#ADAPTER", tag = 1)
    private final NotificationPreferenceType type;

    /* compiled from: UpdateNotificationPreferenceRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/UpdateNotificationPreferenceRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/UpdateNotificationPreferenceRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<UpdateNotificationPreferenceRequest> protoAdapter = new ProtoAdapter<UpdateNotificationPreferenceRequest>(c.LENGTH_DELIMITED, e0.b(UpdateNotificationPreferenceRequest.class), "type.googleapis.com/coinbase.public_api.authed.UpdateNotificationPreferenceRequest") { // from class: com.coinbase.android.apiv3.generated.authed.UpdateNotificationPreferenceRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UpdateNotificationPreferenceRequest decode(k reader) {
                m.h(reader, "reader");
                NotificationPreferenceType notificationPreferenceType = NotificationPreferenceType.SECURITY_ALERTS_TYPE;
                Channel channel = Channel.EMAIL;
                long d2 = reader.d();
                boolean z = false;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new UpdateNotificationPreferenceRequest(notificationPreferenceType, channel, z, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            notificationPreferenceType = NotificationPreferenceType.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        try {
                            channel = Channel.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                            reader.a(g2, c.VARINT, Long.valueOf(e3.a));
                        }
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, UpdateNotificationPreferenceRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != NotificationPreferenceType.SECURITY_ALERTS_TYPE) {
                    NotificationPreferenceType.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (value.getChannel() != Channel.EMAIL) {
                    Channel.ADAPTER.encodeWithTag(writer, 2, value.getChannel());
                }
                if (value.getEnabled()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 3, Boolean.valueOf(value.getEnabled()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(UpdateNotificationPreferenceRequest value) {
                m.h(value, "value");
                if (value.getType() == NotificationPreferenceType.SECURITY_ALERTS_TYPE) {
                    return 0;
                }
                int encodedSizeWithTag = NotificationPreferenceType.ADAPTER.encodedSizeWithTag(1, value.getType());
                if (value.getChannel() != Channel.EMAIL) {
                    r2 = (value.getEnabled() ? ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(value.getEnabled())) + value.unknownFields().Q() : 0) + Channel.ADAPTER.encodedSizeWithTag(2, value.getChannel());
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public UpdateNotificationPreferenceRequest redact(UpdateNotificationPreferenceRequest value) {
                m.h(value, "value");
                return UpdateNotificationPreferenceRequest.copy$default(value, null, null, false, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public UpdateNotificationPreferenceRequest() {
        this(null, null, false, null, 15, null);
    }

    public /* synthetic */ UpdateNotificationPreferenceRequest(NotificationPreferenceType notificationPreferenceType, Channel channel, boolean z, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? NotificationPreferenceType.SECURITY_ALERTS_TYPE : notificationPreferenceType, (i2 & 2) != 0 ? Channel.EMAIL : channel, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ UpdateNotificationPreferenceRequest copy$default(UpdateNotificationPreferenceRequest updateNotificationPreferenceRequest, NotificationPreferenceType notificationPreferenceType, Channel channel, boolean z, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            notificationPreferenceType = updateNotificationPreferenceRequest.type;
        }
        if ((i2 & 2) != 0) {
            channel = updateNotificationPreferenceRequest.channel;
        }
        if ((i2 & 4) != 0) {
            z = updateNotificationPreferenceRequest.enabled;
        }
        if ((i2 & 8) != 0) {
            iVar = updateNotificationPreferenceRequest.unknownFields();
        }
        return updateNotificationPreferenceRequest.copy(notificationPreferenceType, channel, z, iVar);
    }

    public final UpdateNotificationPreferenceRequest copy(NotificationPreferenceType type, Channel channel, boolean z, i unknownFields) {
        m.h(type, "type");
        m.h(channel, "channel");
        m.h(unknownFields, "unknownFields");
        return new UpdateNotificationPreferenceRequest(type, channel, z, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UpdateNotificationPreferenceRequest) {
            UpdateNotificationPreferenceRequest updateNotificationPreferenceRequest = (UpdateNotificationPreferenceRequest) obj;
            return m.c(unknownFields(), updateNotificationPreferenceRequest.unknownFields()) && this.type == updateNotificationPreferenceRequest.type && this.channel == updateNotificationPreferenceRequest.channel && this.enabled == updateNotificationPreferenceRequest.enabled;
        }
        return false;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final NotificationPreferenceType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37) + this.channel.hashCode()) * 37) + a.a(this.enabled);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m260newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        arrayList.add("channel=" + this.channel);
        arrayList.add("enabled=" + this.enabled);
        h0 = z.h0(arrayList, ", ", "UpdateNotificationPreferenceRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m260newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateNotificationPreferenceRequest(NotificationPreferenceType type, Channel channel, boolean z, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(channel, "channel");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.channel = channel;
        this.enabled = z;
    }
}