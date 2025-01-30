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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: MutePushNotificationOption.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationOption;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationType;", "type", ApiConstants.NAME, "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationType;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationOption;", "Ljava/lang/String;", "getName", "Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationType;", "getType", "()Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationType;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationType;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class MutePushNotificationOption extends com.squareup.wire.a {
    public static final ProtoAdapter<MutePushNotificationOption> ADAPTER;
    public static final Parcelable.Creator<MutePushNotificationOption> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String name;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.MutePushNotificationType#ADAPTER", tag = 1)
    private final MutePushNotificationType type;

    /* compiled from: MutePushNotificationOption.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationOption$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationOption;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<MutePushNotificationOption> protoAdapter = new ProtoAdapter<MutePushNotificationOption>(c.LENGTH_DELIMITED, e0.b(MutePushNotificationOption.class), "type.googleapis.com/coinbase.public_api.authed.MutePushNotificationOption") { // from class: com.coinbase.android.apiv3.generated.authed.MutePushNotificationOption$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MutePushNotificationOption decode(k reader) {
                m.h(reader, "reader");
                MutePushNotificationType mutePushNotificationType = MutePushNotificationType.UNMUTED;
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new MutePushNotificationOption(mutePushNotificationType, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            mutePushNotificationType = MutePushNotificationType.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, MutePushNotificationOption value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getType() != MutePushNotificationType.UNMUTED) {
                    MutePushNotificationType.ADAPTER.encodeWithTag(writer, 1, value.getType());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getName());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(MutePushNotificationOption value) {
                m.h(value, "value");
                if (value.getType() == MutePushNotificationType.UNMUTED) {
                    return 0;
                }
                return (m.c(value.getName(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(2, value.getName()) + value.unknownFields().Q()) + MutePushNotificationType.ADAPTER.encodedSizeWithTag(1, value.getType());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public MutePushNotificationOption redact(MutePushNotificationOption value) {
                m.h(value, "value");
                return MutePushNotificationOption.copy$default(value, null, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public MutePushNotificationOption() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ MutePushNotificationOption(MutePushNotificationType mutePushNotificationType, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? MutePushNotificationType.UNMUTED : mutePushNotificationType, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ MutePushNotificationOption copy$default(MutePushNotificationOption mutePushNotificationOption, MutePushNotificationType mutePushNotificationType, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutePushNotificationType = mutePushNotificationOption.type;
        }
        if ((i2 & 2) != 0) {
            str = mutePushNotificationOption.name;
        }
        if ((i2 & 4) != 0) {
            iVar = mutePushNotificationOption.unknownFields();
        }
        return mutePushNotificationOption.copy(mutePushNotificationType, str, iVar);
    }

    public final MutePushNotificationOption copy(MutePushNotificationType type, String name, i unknownFields) {
        m.h(type, "type");
        m.h(name, "name");
        m.h(unknownFields, "unknownFields");
        return new MutePushNotificationOption(type, name, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MutePushNotificationOption) {
            MutePushNotificationOption mutePushNotificationOption = (MutePushNotificationOption) obj;
            return m.c(unknownFields(), mutePushNotificationOption.unknownFields()) && this.type == mutePushNotificationOption.type && m.c(this.name, mutePushNotificationOption.name);
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final MutePushNotificationType getType() {
        return this.type;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.type.hashCode()) * 37) + this.name.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m238newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("type=" + this.type);
        arrayList.add("name=" + com.squareup.wire.q.b.c(this.name));
        h0 = z.h0(arrayList, ", ", "MutePushNotificationOption{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m238newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutePushNotificationOption(MutePushNotificationType type, String name, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(type, "type");
        m.h(name, "name");
        m.h(unknownFields, "unknownFields");
        this.type = type;
        this.name = name;
    }
}