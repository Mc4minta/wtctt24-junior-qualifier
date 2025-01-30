package com.coinbase.android.apiv3.generated.authed.card;

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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: SpendableAsset.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB'\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/SpendableAsset;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "asset_id", "Lcom/coinbase/android/apiv3/generated/authed/card/SupplementaryInfo;", "supplementary_info", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/card/SupplementaryInfo;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/SpendableAsset;", "Ljava/lang/String;", "getAsset_id", "Lcom/coinbase/android/apiv3/generated/authed/card/SupplementaryInfo;", "getSupplementary_info", "()Lcom/coinbase/android/apiv3/generated/authed/card/SupplementaryInfo;", "<init>", "(Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/card/SupplementaryInfo;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class SpendableAsset extends a {
    public static final ProtoAdapter<SpendableAsset> ADAPTER;
    public static final Parcelable.Creator<SpendableAsset> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "assetId", tag = 1)
    private final String asset_id;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.card.SupplementaryInfo#ADAPTER", jsonName = "supplementaryInfo", tag = 2)
    private final SupplementaryInfo supplementary_info;

    /* compiled from: SpendableAsset.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/SpendableAsset$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/SpendableAsset;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(SpendableAsset.class);
        ProtoAdapter<SpendableAsset> protoAdapter = new ProtoAdapter<SpendableAsset>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.card.SpendableAsset") { // from class: com.coinbase.android.apiv3.generated.authed.card.SpendableAsset$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SpendableAsset decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                SupplementaryInfo supplementaryInfo = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new SpendableAsset(str, supplementaryInfo, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        supplementaryInfo = SupplementaryInfo.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, SpendableAsset value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getAsset_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getAsset_id());
                }
                if (value.getSupplementary_info() != null) {
                    SupplementaryInfo.ADAPTER.encodeWithTag(writer, 2, value.getSupplementary_info());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(SpendableAsset value) {
                m.h(value, "value");
                if (m.c(value.getAsset_id(), "")) {
                    return 0;
                }
                return (value.getSupplementary_info() != null ? SupplementaryInfo.ADAPTER.encodedSizeWithTag(2, value.getSupplementary_info()) + value.unknownFields().Q() : 0) + ProtoAdapter.STRING.encodedSizeWithTag(1, value.getAsset_id());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public SpendableAsset redact(SpendableAsset value) {
                m.h(value, "value");
                SupplementaryInfo supplementary_info = value.getSupplementary_info();
                return SpendableAsset.copy$default(value, null, supplementary_info != null ? SupplementaryInfo.ADAPTER.redact(supplementary_info) : null, i.a, 1, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public SpendableAsset() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ SpendableAsset(String str, SupplementaryInfo supplementaryInfo, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : supplementaryInfo, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ SpendableAsset copy$default(SpendableAsset spendableAsset, String str, SupplementaryInfo supplementaryInfo, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = spendableAsset.asset_id;
        }
        if ((i2 & 2) != 0) {
            supplementaryInfo = spendableAsset.supplementary_info;
        }
        if ((i2 & 4) != 0) {
            iVar = spendableAsset.unknownFields();
        }
        return spendableAsset.copy(str, supplementaryInfo, iVar);
    }

    public final SpendableAsset copy(String asset_id, SupplementaryInfo supplementaryInfo, i unknownFields) {
        m.h(asset_id, "asset_id");
        m.h(unknownFields, "unknownFields");
        return new SpendableAsset(asset_id, supplementaryInfo, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpendableAsset) {
            SpendableAsset spendableAsset = (SpendableAsset) obj;
            return m.c(unknownFields(), spendableAsset.unknownFields()) && m.c(this.asset_id, spendableAsset.asset_id) && m.c(this.supplementary_info, spendableAsset.supplementary_info);
        }
        return false;
    }

    public final String getAsset_id() {
        return this.asset_id;
    }

    public final SupplementaryInfo getSupplementary_info() {
        return this.supplementary_info;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.asset_id.hashCode()) * 37;
            SupplementaryInfo supplementaryInfo = this.supplementary_info;
            int hashCode2 = hashCode + (supplementaryInfo != null ? supplementaryInfo.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m327newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("asset_id=" + b.c(this.asset_id));
        if (this.supplementary_info != null) {
            arrayList.add("supplementary_info=" + this.supplementary_info);
        }
        h0 = z.h0(arrayList, ", ", "SpendableAsset{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpendableAsset(String asset_id, SupplementaryInfo supplementaryInfo, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(asset_id, "asset_id");
        m.h(unknownFields, "unknownFields");
        this.asset_id = asset_id;
        this.supplementary_info = supplementaryInfo;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m327newBuilder() {
        throw new AssertionError();
    }
}