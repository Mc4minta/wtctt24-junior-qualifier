package com.coinbase.android.apiv3.generated.authed.announcement_cards;

import android.os.Parcelable;
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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: DismissAnnouncementCardRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/DismissAnnouncementCardRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "card_name", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/DismissAnnouncementCardRequest;", "Ljava/lang/String;", "getCard_name", "<init>", "(Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class DismissAnnouncementCardRequest extends a {
    public static final ProtoAdapter<DismissAnnouncementCardRequest> ADAPTER;
    public static final Parcelable.Creator<DismissAnnouncementCardRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardName", tag = 1)
    private final String card_name;

    /* compiled from: DismissAnnouncementCardRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/DismissAnnouncementCardRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/announcement_cards/DismissAnnouncementCardRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<DismissAnnouncementCardRequest> protoAdapter = new ProtoAdapter<DismissAnnouncementCardRequest>(c.LENGTH_DELIMITED, e0.b(DismissAnnouncementCardRequest.class), "type.googleapis.com/coinbase.public_api.authed.announcement_cards.DismissAnnouncementCardRequest") { // from class: com.coinbase.android.apiv3.generated.authed.announcement_cards.DismissAnnouncementCardRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DismissAnnouncementCardRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new DismissAnnouncementCardRequest(str, reader.e(d2));
                    }
                    if (g2 != 1) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, DismissAnnouncementCardRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getCard_name(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getCard_name());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(DismissAnnouncementCardRequest value) {
                m.h(value, "value");
                if (m.c(value.getCard_name(), "")) {
                    return 0;
                }
                return value.unknownFields().Q() + ProtoAdapter.STRING.encodedSizeWithTag(1, value.getCard_name());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public DismissAnnouncementCardRequest redact(DismissAnnouncementCardRequest value) {
                m.h(value, "value");
                return DismissAnnouncementCardRequest.copy$default(value, null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public DismissAnnouncementCardRequest() {
        this(null, null, 3, null);
    }

    public /* synthetic */ DismissAnnouncementCardRequest(String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ DismissAnnouncementCardRequest copy$default(DismissAnnouncementCardRequest dismissAnnouncementCardRequest, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dismissAnnouncementCardRequest.card_name;
        }
        if ((i2 & 2) != 0) {
            iVar = dismissAnnouncementCardRequest.unknownFields();
        }
        return dismissAnnouncementCardRequest.copy(str, iVar);
    }

    public final DismissAnnouncementCardRequest copy(String card_name, i unknownFields) {
        m.h(card_name, "card_name");
        m.h(unknownFields, "unknownFields");
        return new DismissAnnouncementCardRequest(card_name, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DismissAnnouncementCardRequest) {
            DismissAnnouncementCardRequest dismissAnnouncementCardRequest = (DismissAnnouncementCardRequest) obj;
            return m.c(unknownFields(), dismissAnnouncementCardRequest.unknownFields()) && m.c(this.card_name, dismissAnnouncementCardRequest.card_name);
        }
        return false;
    }

    public final String getCard_name() {
        return this.card_name;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.card_name.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m280newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("card_name=" + b.c(this.card_name));
        h0 = z.h0(arrayList, ", ", "DismissAnnouncementCardRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DismissAnnouncementCardRequest(String card_name, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(card_name, "card_name");
        m.h(unknownFields, "unknownFields");
        this.card_name = card_name;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m280newBuilder() {
        throw new AssertionError();
    }
}