package com.coinbase.android.apiv3.generated.authed.card;

import android.os.Parcelable;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import j.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: ListSpendableAssetsRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0011\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/ListSpendableAssetsRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lj/i;", "unknownFields", "copy", "(Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/ListSpendableAssetsRequest;", "<init>", "(Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ListSpendableAssetsRequest extends a {
    public static final ProtoAdapter<ListSpendableAssetsRequest> ADAPTER;
    public static final Parcelable.Creator<ListSpendableAssetsRequest> CREATOR;
    public static final Companion Companion = new Companion(null);

    /* compiled from: ListSpendableAssetsRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/ListSpendableAssetsRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/ListSpendableAssetsRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<ListSpendableAssetsRequest> protoAdapter = new ProtoAdapter<ListSpendableAssetsRequest>(c.LENGTH_DELIMITED, e0.b(ListSpendableAssetsRequest.class), "type.googleapis.com/coinbase.public_api.authed.card.ListSpendableAssetsRequest") { // from class: com.coinbase.android.apiv3.generated.authed.card.ListSpendableAssetsRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ListSpendableAssetsRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new ListSpendableAssetsRequest(reader.e(d2));
                    }
                    reader.m(g2);
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, ListSpendableAssetsRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(ListSpendableAssetsRequest value) {
                m.h(value, "value");
                return value.unknownFields().Q();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public ListSpendableAssetsRequest redact(ListSpendableAssetsRequest value) {
                m.h(value, "value");
                return value.copy(i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public ListSpendableAssetsRequest() {
        this(null, 1, null);
    }

    public /* synthetic */ ListSpendableAssetsRequest(i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ ListSpendableAssetsRequest copy$default(ListSpendableAssetsRequest listSpendableAssetsRequest, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iVar = listSpendableAssetsRequest.unknownFields();
        }
        return listSpendableAssetsRequest.copy(iVar);
    }

    public final ListSpendableAssetsRequest copy(i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new ListSpendableAssetsRequest(unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListSpendableAssetsRequest) {
            return m.c(unknownFields(), ((ListSpendableAssetsRequest) obj).unknownFields());
        }
        return false;
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m317newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        return "ListSpendableAssetsRequest{}";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListSpendableAssetsRequest(i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m317newBuilder() {
        throw new AssertionError();
    }
}