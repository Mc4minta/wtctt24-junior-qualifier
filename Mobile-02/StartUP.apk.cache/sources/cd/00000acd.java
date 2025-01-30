package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
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

/* compiled from: GetNotificationPreferenceResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B-\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/GetNotificationPreferenceResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/authed/NotificationPreference;", "preferences", "Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationPreference;", "mute_push_preference", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationPreference;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/GetNotificationPreferenceResponse;", "Ljava/util/List;", "getPreferences", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationPreference;", "getMute_push_preference", "()Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationPreference;", "<init>", "(Ljava/util/List;Lcom/coinbase/android/apiv3/generated/authed/MutePushNotificationPreference;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetNotificationPreferenceResponse extends com.squareup.wire.a {
    public static final ProtoAdapter<GetNotificationPreferenceResponse> ADAPTER;
    public static final Parcelable.Creator<GetNotificationPreferenceResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.MutePushNotificationPreference#ADAPTER", jsonName = "mutePushPreference", tag = 2)
    private final MutePushNotificationPreference mute_push_preference;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.NotificationPreference#ADAPTER", label = p.a.REPEATED, tag = 1)
    private final List<NotificationPreference> preferences;

    /* compiled from: GetNotificationPreferenceResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/GetNotificationPreferenceResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/GetNotificationPreferenceResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetNotificationPreferenceResponse> protoAdapter = new ProtoAdapter<GetNotificationPreferenceResponse>(c.LENGTH_DELIMITED, e0.b(GetNotificationPreferenceResponse.class), "type.googleapis.com/coinbase.public_api.authed.GetNotificationPreferenceResponse") { // from class: com.coinbase.android.apiv3.generated.authed.GetNotificationPreferenceResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetNotificationPreferenceResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                MutePushNotificationPreference mutePushNotificationPreference = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetNotificationPreferenceResponse(arrayList, mutePushNotificationPreference, reader.e(d2));
                    }
                    if (g2 == 1) {
                        arrayList.add(NotificationPreference.ADAPTER.decode(reader));
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        mutePushNotificationPreference = MutePushNotificationPreference.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetNotificationPreferenceResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                NotificationPreference.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getPreferences());
                if (value.getMute_push_preference() != null) {
                    MutePushNotificationPreference.ADAPTER.encodeWithTag(writer, 2, value.getMute_push_preference());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetNotificationPreferenceResponse value) {
                int Q;
                m.h(value, "value");
                int encodedSizeWithTag = NotificationPreference.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getPreferences());
                if (value.getMute_push_preference() == null) {
                    Q = 0;
                } else {
                    Q = value.unknownFields().Q() + MutePushNotificationPreference.ADAPTER.encodedSizeWithTag(2, value.getMute_push_preference());
                }
                return encodedSizeWithTag + Q;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetNotificationPreferenceResponse redact(GetNotificationPreferenceResponse value) {
                m.h(value, "value");
                List<NotificationPreference> a = com.squareup.wire.q.b.a(value.getPreferences(), NotificationPreference.ADAPTER);
                MutePushNotificationPreference mute_push_preference = value.getMute_push_preference();
                return value.copy(a, mute_push_preference != null ? MutePushNotificationPreference.ADAPTER.redact(mute_push_preference) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public GetNotificationPreferenceResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetNotificationPreferenceResponse(List list, MutePushNotificationPreference mutePushNotificationPreference, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? null : mutePushNotificationPreference, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetNotificationPreferenceResponse copy$default(GetNotificationPreferenceResponse getNotificationPreferenceResponse, List list, MutePushNotificationPreference mutePushNotificationPreference, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = getNotificationPreferenceResponse.preferences;
        }
        if ((i2 & 2) != 0) {
            mutePushNotificationPreference = getNotificationPreferenceResponse.mute_push_preference;
        }
        if ((i2 & 4) != 0) {
            iVar = getNotificationPreferenceResponse.unknownFields();
        }
        return getNotificationPreferenceResponse.copy(list, mutePushNotificationPreference, iVar);
    }

    public final GetNotificationPreferenceResponse copy(List<NotificationPreference> preferences, MutePushNotificationPreference mutePushNotificationPreference, i unknownFields) {
        m.h(preferences, "preferences");
        m.h(unknownFields, "unknownFields");
        return new GetNotificationPreferenceResponse(preferences, mutePushNotificationPreference, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetNotificationPreferenceResponse) {
            GetNotificationPreferenceResponse getNotificationPreferenceResponse = (GetNotificationPreferenceResponse) obj;
            return m.c(unknownFields(), getNotificationPreferenceResponse.unknownFields()) && m.c(this.preferences, getNotificationPreferenceResponse.preferences) && m.c(this.mute_push_preference, getNotificationPreferenceResponse.mute_push_preference);
        }
        return false;
    }

    public final MutePushNotificationPreference getMute_push_preference() {
        return this.mute_push_preference;
    }

    public final List<NotificationPreference> getPreferences() {
        return this.preferences;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.preferences.hashCode()) * 37;
            MutePushNotificationPreference mutePushNotificationPreference = this.mute_push_preference;
            int hashCode2 = hashCode + (mutePushNotificationPreference != null ? mutePushNotificationPreference.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m226newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.preferences.isEmpty()) {
            arrayList.add("preferences=" + this.preferences);
        }
        if (this.mute_push_preference != null) {
            arrayList.add("mute_push_preference=" + this.mute_push_preference);
        }
        h0 = z.h0(arrayList, ", ", "GetNotificationPreferenceResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m226newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetNotificationPreferenceResponse(List<NotificationPreference> preferences, MutePushNotificationPreference mutePushNotificationPreference, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(preferences, "preferences");
        m.h(unknownFields, "unknownFields");
        this.preferences = preferences;
        this.mute_push_preference = mutePushNotificationPreference;
    }
}