package com.coinbase.android.apiv3.generated.authed;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.resources.Notification;
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

/* compiled from: ListNotificationsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B5\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0015\u001a\u00020\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/resources/Notification;", "notifications", "", "next_page_token", "badge_count", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;JJLj/i;)Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsResponse;", "J", "getNext_page_token", "()J", "getBadge_count", "Ljava/util/List;", "getNotifications", "()Ljava/util/List;", "<init>", "(Ljava/util/List;JJLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListNotificationsResponse extends com.squareup.wire.a {
    public static final ProtoAdapter<ListNotificationsResponse> ADAPTER;
    public static final Parcelable.Creator<ListNotificationsResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "badgeCount", tag = 3)
    private final long badge_count;
    @p(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "nextPageToken", tag = 2)
    private final long next_page_token;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Notification#ADAPTER", label = p.a.REPEATED, tag = 1)
    private final List<Notification> notifications;

    /* compiled from: ListNotificationsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/ListNotificationsResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ListNotificationsResponse> protoAdapter = new ProtoAdapter<ListNotificationsResponse>(c.LENGTH_DELIMITED, e0.b(ListNotificationsResponse.class), "type.googleapis.com/coinbase.public_api.authed.ListNotificationsResponse") { // from class: com.coinbase.android.apiv3.generated.authed.ListNotificationsResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ListNotificationsResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                long j2 = 0;
                long j3 = 0;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ListNotificationsResponse(arrayList, j2, j3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        arrayList.add(Notification.ADAPTER.decode(reader));
                    } else if (g2 == 2) {
                        j2 = ProtoAdapter.INT64.decode(reader).longValue();
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        j3 = ProtoAdapter.INT64.decode(reader).longValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ListNotificationsResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                Notification.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getNotifications());
                if (value.getNext_page_token() != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 2, Long.valueOf(value.getNext_page_token()));
                }
                if (value.getBadge_count() != 0) {
                    ProtoAdapter.INT64.encodeWithTag(writer, 3, Long.valueOf(value.getBadge_count()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ListNotificationsResponse value) {
                m.h(value, "value");
                int encodedSizeWithTag = Notification.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getNotifications());
                if (value.getNext_page_token() != 0) {
                    ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
                    r2 = (value.getBadge_count() != 0 ? protoAdapter2.encodedSizeWithTag(3, Long.valueOf(value.getBadge_count())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(2, Long.valueOf(value.getNext_page_token()));
                }
                return encodedSizeWithTag + r2;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ListNotificationsResponse redact(ListNotificationsResponse value) {
                m.h(value, "value");
                return ListNotificationsResponse.copy$default(value, com.squareup.wire.q.b.a(value.getNotifications(), Notification.ADAPTER), 0L, 0L, i.a, 6, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = com.squareup.wire.a.Companion.a(protoAdapter);
    }

    public ListNotificationsResponse() {
        this(null, 0L, 0L, null, 15, null);
    }

    public /* synthetic */ ListNotificationsResponse(List list, long j2, long j3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) == 0 ? j3 : 0L, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ListNotificationsResponse copy$default(ListNotificationsResponse listNotificationsResponse, List list, long j2, long j3, i iVar, int i2, Object obj) {
        List<Notification> list2 = list;
        if ((i2 & 1) != 0) {
            list2 = listNotificationsResponse.notifications;
        }
        if ((i2 & 2) != 0) {
            j2 = listNotificationsResponse.next_page_token;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            j3 = listNotificationsResponse.badge_count;
        }
        long j5 = j3;
        if ((i2 & 8) != 0) {
            iVar = listNotificationsResponse.unknownFields();
        }
        return listNotificationsResponse.copy(list2, j4, j5, iVar);
    }

    public final ListNotificationsResponse copy(List<Notification> notifications, long j2, long j3, i unknownFields) {
        m.h(notifications, "notifications");
        m.h(unknownFields, "unknownFields");
        return new ListNotificationsResponse(notifications, j2, j3, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListNotificationsResponse) {
            ListNotificationsResponse listNotificationsResponse = (ListNotificationsResponse) obj;
            return m.c(unknownFields(), listNotificationsResponse.unknownFields()) && m.c(this.notifications, listNotificationsResponse.notifications) && this.next_page_token == listNotificationsResponse.next_page_token && this.badge_count == listNotificationsResponse.badge_count;
        }
        return false;
    }

    public final long getBadge_count() {
        return this.badge_count;
    }

    public final long getNext_page_token() {
        return this.next_page_token;
    }

    public final List<Notification> getNotifications() {
        return this.notifications;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.notifications.hashCode()) * 37) + b.a(this.next_page_token)) * 37) + b.a(this.badge_count);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m236newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.notifications.isEmpty()) {
            arrayList.add("notifications=" + this.notifications);
        }
        arrayList.add("next_page_token=" + this.next_page_token);
        arrayList.add("badge_count=" + this.badge_count);
        h0 = z.h0(arrayList, ", ", "ListNotificationsResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m236newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListNotificationsResponse(List<Notification> notifications, long j2, long j3, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(notifications, "notifications");
        m.h(unknownFields, "unknownFields");
        this.notifications = notifications;
        this.next_page_token = j2;
        this.badge_count = j3;
    }
}