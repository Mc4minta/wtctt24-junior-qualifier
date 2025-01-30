package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
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

/* compiled from: ChannelPreference.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B9\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0013\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ChannelPreference;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/Channel;", AppsFlyerProperties.CHANNEL, ApiConstants.NAME, "enabled", "user_editable", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/Channel;Ljava/lang/String;ZZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/ChannelPreference;", "Z", "getEnabled", "()Z", "Ljava/lang/String;", "getName", "getUser_editable", "Lcom/coinbase/android/apiv3/generated/authed/Channel;", "getChannel", "()Lcom/coinbase/android/apiv3/generated/authed/Channel;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/Channel;Ljava/lang/String;ZZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ChannelPreference extends com.squareup.wire.a {
    public static final ProtoAdapter<ChannelPreference> ADAPTER;
    public static final Parcelable.Creator<ChannelPreference> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.Channel#ADAPTER", tag = 1)
    private final Channel channel;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    private final boolean enabled;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String name;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "userEditable", tag = 4)
    private final boolean user_editable;

    /* compiled from: ChannelPreference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ChannelPreference$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/ChannelPreference;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ChannelPreference> protoAdapter = new ProtoAdapter<ChannelPreference>(c.LENGTH_DELIMITED, e0.b(ChannelPreference.class), "type.googleapis.com/coinbase.public_api.authed.ChannelPreference") { // from class: com.coinbase.android.apiv3.generated.authed.ChannelPreference$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ChannelPreference decode(k reader) {
                m.h(reader, "reader");
                Channel channel = Channel.EMAIL;
                long d2 = reader.d();
                Channel channel2 = channel;
                boolean z = false;
                boolean z2 = false;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ChannelPreference(channel2, str, z, z2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            channel2 = Channel.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        z2 = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ChannelPreference value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getChannel() != Channel.EMAIL) {
                    Channel.ADAPTER.encodeWithTag(writer, 1, value.getChannel());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getName());
                }
                if (value.getEnabled()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 3, Boolean.valueOf(value.getEnabled()));
                }
                if (value.getUser_editable()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 4, Boolean.valueOf(value.getUser_editable()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ChannelPreference value) {
                m.h(value, "value");
                if (value.getChannel() == Channel.EMAIL) {
                    return 0;
                }
                int encodedSizeWithTag = Channel.ADAPTER.encodedSizeWithTag(1, value.getChannel());
                if (!m.c(value.getName(), "")) {
                    int encodedSizeWithTag2 = ProtoAdapter.STRING.encodedSizeWithTag(2, value.getName());
                    if (value.getEnabled()) {
                        ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
                        r2 = (value.getUser_editable() ? protoAdapter2.encodedSizeWithTag(4, Boolean.valueOf(value.getUser_editable())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(3, Boolean.valueOf(value.getEnabled()));
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ChannelPreference redact(ChannelPreference value) {
                m.h(value, "value");
                return ChannelPreference.copy$default(value, null, null, false, false, i.a, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public ChannelPreference() {
        this(null, null, false, false, null, 31, null);
    }

    public /* synthetic */ ChannelPreference(Channel channel, String str, boolean z, boolean z2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Channel.EMAIL : channel, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? false : z, (i2 & 8) == 0 ? z2 : false, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ChannelPreference copy$default(ChannelPreference channelPreference, Channel channel, String str, boolean z, boolean z2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelPreference.channel;
        }
        if ((i2 & 2) != 0) {
            str = channelPreference.name;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            z = channelPreference.enabled;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            z2 = channelPreference.user_editable;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            iVar = channelPreference.unknownFields();
        }
        return channelPreference.copy(channel, str2, z3, z4, iVar);
    }

    public final ChannelPreference copy(Channel channel, String name, boolean z, boolean z2, i unknownFields) {
        m.h(channel, "channel");
        m.h(name, "name");
        m.h(unknownFields, "unknownFields");
        return new ChannelPreference(channel, name, z, z2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChannelPreference) {
            ChannelPreference channelPreference = (ChannelPreference) obj;
            return m.c(unknownFields(), channelPreference.unknownFields()) && this.channel == channelPreference.channel && m.c(this.name, channelPreference.name) && this.enabled == channelPreference.enabled && this.user_editable == channelPreference.user_editable;
        }
        return false;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getUser_editable() {
        return this.user_editable;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.channel.hashCode()) * 37) + this.name.hashCode()) * 37) + a.a(this.enabled)) * 37) + a.a(this.user_editable);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m221newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("channel=" + this.channel);
        arrayList.add("name=" + com.squareup.wire.q.b.c(this.name));
        arrayList.add("enabled=" + this.enabled);
        arrayList.add("user_editable=" + this.user_editable);
        h0 = z.h0(arrayList, ", ", "ChannelPreference{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m221newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelPreference(Channel channel, String name, boolean z, boolean z2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(channel, "channel");
        m.h(name, "name");
        m.h(unknownFields, "unknownFields");
        this.channel = channel;
        this.name = name;
        this.enabled = z;
        this.user_editable = z2;
    }
}