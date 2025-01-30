package com.coinbase.android.apiv3.generated.authed.announcement_cards;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
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

/* compiled from: GetAnnouncementCardResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001d\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetAnnouncementCardResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCard;", "announcement_card", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCard;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetAnnouncementCardResponse;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCard;", "getAnnouncement_card", "()Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCard;", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/AnnouncementCard;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetAnnouncementCardResponse extends a {
    public static final ProtoAdapter<GetAnnouncementCardResponse> ADAPTER;
    public static final Parcelable.Creator<GetAnnouncementCardResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.announcement_cards.AnnouncementCard#ADAPTER", jsonName = "announcementCard", tag = 1)
    private final AnnouncementCard announcement_card;

    /* compiled from: GetAnnouncementCardResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetAnnouncementCardResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/GetAnnouncementCardResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetAnnouncementCardResponse> protoAdapter = new ProtoAdapter<GetAnnouncementCardResponse>(c.LENGTH_DELIMITED, e0.b(GetAnnouncementCardResponse.class), "type.googleapis.com/coinbase.public_api.authed.announcement_cards.GetAnnouncementCardResponse") { // from class: com.coinbase.android.apiv3.generated.authed.announcement_cards.GetAnnouncementCardResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetAnnouncementCardResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                AnnouncementCard announcementCard = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetAnnouncementCardResponse(announcementCard, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        announcementCard = AnnouncementCard.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetAnnouncementCardResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAnnouncement_card() != null) {
                    AnnouncementCard.ADAPTER.encodeWithTag(writer, 1, value.getAnnouncement_card());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetAnnouncementCardResponse value) {
                m.h(value, "value");
                if (value.getAnnouncement_card() == null) {
                    return 0;
                }
                return value.unknownFields().Q() + AnnouncementCard.ADAPTER.encodedSizeWithTag(1, value.getAnnouncement_card());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetAnnouncementCardResponse redact(GetAnnouncementCardResponse value) {
                m.h(value, "value");
                AnnouncementCard announcement_card = value.getAnnouncement_card();
                return value.copy(announcement_card != null ? AnnouncementCard.ADAPTER.redact(announcement_card) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetAnnouncementCardResponse() {
        this(null, null, 3, null);
    }

    public /* synthetic */ GetAnnouncementCardResponse(AnnouncementCard announcementCard, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : announcementCard, (i2 & 2) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetAnnouncementCardResponse copy$default(GetAnnouncementCardResponse getAnnouncementCardResponse, AnnouncementCard announcementCard, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            announcementCard = getAnnouncementCardResponse.announcement_card;
        }
        if ((i2 & 2) != 0) {
            iVar = getAnnouncementCardResponse.unknownFields();
        }
        return getAnnouncementCardResponse.copy(announcementCard, iVar);
    }

    public final GetAnnouncementCardResponse copy(AnnouncementCard announcementCard, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new GetAnnouncementCardResponse(announcementCard, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetAnnouncementCardResponse) {
            GetAnnouncementCardResponse getAnnouncementCardResponse = (GetAnnouncementCardResponse) obj;
            return m.c(unknownFields(), getAnnouncementCardResponse.unknownFields()) && m.c(this.announcement_card, getAnnouncementCardResponse.announcement_card);
        }
        return false;
    }

    public final AnnouncementCard getAnnouncement_card() {
        return this.announcement_card;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AnnouncementCard announcementCard = this.announcement_card;
            int hashCode2 = hashCode + (announcementCard != null ? announcementCard.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m283newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.announcement_card != null) {
            arrayList.add("announcement_card=" + this.announcement_card);
        }
        h0 = z.h0(arrayList, ", ", "GetAnnouncementCardResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAnnouncementCardResponse(AnnouncementCard announcementCard, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.announcement_card = announcementCard;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m283newBuilder() {
        throw new AssertionError();
    }
}