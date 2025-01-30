package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
import com.google.protobuf.u;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: MutePushNotificationPreference.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B-\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationPreference;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/google/protobuf/u;", "mute_ends_at_time", "", "Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationOption;", "mute_push_notification_preference_options", "Lj/i;", "unknownFields", "copy", "(Lcom/google/protobuf/u;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationPreference;", "Lcom/google/protobuf/u;", "getMute_ends_at_time", "()Lcom/google/protobuf/u;", "Ljava/util/List;", "getMute_push_notification_preference_options", "()Ljava/util/List;", "<init>", "(Lcom/google/protobuf/u;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class MutePushNotificationPreference extends com.squareup.wire.a {
    public static final ProtoAdapter<MutePushNotificationPreference> ADAPTER;
    public static final Parcelable.Creator<MutePushNotificationPreference> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.google.protobuf.Timestamp#ADAPTER", jsonName = "muteEndsAtTime", tag = 1)
    private final u mute_ends_at_time;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.MutePushNotificationOption#ADAPTER", jsonName = "mutePushNotificationPreferenceOptions", label = p.a.REPEATED, tag = 2)
    private final List<MutePushNotificationOption> mute_push_notification_preference_options;

    /* compiled from: MutePushNotificationPreference.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationPreference$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationPreference;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<MutePushNotificationPreference> protoAdapter = new ProtoAdapter<MutePushNotificationPreference>(c.LENGTH_DELIMITED, e0.b(MutePushNotificationPreference.class), "type.googleapis.com/coinbase.public_api.authed.MutePushNotificationPreference") { // from class: com.coinbase.android.apiv3.generated.authed.MutePushNotificationPreference$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public MutePushNotificationPreference decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                u uVar = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new MutePushNotificationPreference(uVar, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        uVar = u.a.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        arrayList.add(MutePushNotificationOption.ADAPTER.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, MutePushNotificationPreference value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getMute_ends_at_time() != null) {
                    u.a.encodeWithTag(writer, 1, value.getMute_ends_at_time());
                }
                MutePushNotificationOption.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getMute_push_notification_preference_options());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(MutePushNotificationPreference value) {
                m.h(value, "value");
                if (value.getMute_ends_at_time() == null) {
                    return 0;
                }
                return value.unknownFields().Q() + u.a.encodedSizeWithTag(1, value.getMute_ends_at_time()) + MutePushNotificationOption.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getMute_push_notification_preference_options());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public MutePushNotificationPreference redact(MutePushNotificationPreference value) {
                m.h(value, "value");
                u mute_ends_at_time = value.getMute_ends_at_time();
                return value.copy(mute_ends_at_time != null ? u.a.redact(mute_ends_at_time) : null, com.squareup.wire.q.b.a(value.getMute_push_notification_preference_options(), MutePushNotificationOption.ADAPTER), i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public MutePushNotificationPreference() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ MutePushNotificationPreference(u uVar, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : uVar, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutePushNotificationPreference copy$default(MutePushNotificationPreference mutePushNotificationPreference, u uVar, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uVar = mutePushNotificationPreference.mute_ends_at_time;
        }
        if ((i2 & 2) != 0) {
            list = mutePushNotificationPreference.mute_push_notification_preference_options;
        }
        if ((i2 & 4) != 0) {
            iVar = mutePushNotificationPreference.unknownFields();
        }
        return mutePushNotificationPreference.copy(uVar, list, iVar);
    }

    public final MutePushNotificationPreference copy(u uVar, List<MutePushNotificationOption> mute_push_notification_preference_options, i unknownFields) {
        m.h(mute_push_notification_preference_options, "mute_push_notification_preference_options");
        m.h(unknownFields, "unknownFields");
        return new MutePushNotificationPreference(uVar, mute_push_notification_preference_options, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MutePushNotificationPreference) {
            MutePushNotificationPreference mutePushNotificationPreference = (MutePushNotificationPreference) obj;
            return m.c(unknownFields(), mutePushNotificationPreference.unknownFields()) && m.c(this.mute_ends_at_time, mutePushNotificationPreference.mute_ends_at_time) && m.c(this.mute_push_notification_preference_options, mutePushNotificationPreference.mute_push_notification_preference_options);
        }
        return false;
    }

    public final u getMute_ends_at_time() {
        return this.mute_ends_at_time;
    }

    public final List<MutePushNotificationOption> getMute_push_notification_preference_options() {
        return this.mute_push_notification_preference_options;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            u uVar = this.mute_ends_at_time;
            int hashCode2 = ((hashCode + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.mute_push_notification_preference_options.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m239newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.mute_ends_at_time != null) {
            arrayList.add("mute_ends_at_time=" + this.mute_ends_at_time);
        }
        if (!this.mute_push_notification_preference_options.isEmpty()) {
            arrayList.add("mute_push_notification_preference_options=" + this.mute_push_notification_preference_options);
        }
        h0 = z.h0(arrayList, ", ", "MutePushNotificationPreference{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m239newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutePushNotificationPreference(u uVar, List<MutePushNotificationOption> mute_push_notification_preference_options, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(mute_push_notification_preference_options, "mute_push_notification_preference_options");
        m.h(unknownFields, "unknownFields");
        this.mute_ends_at_time = uVar;
        this.mute_push_notification_preference_options = mute_push_notification_preference_options;
    }
}