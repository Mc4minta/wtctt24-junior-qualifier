package com.coinbase.android.apiv3.generated.authed.user_eligibility;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.resources.Asset;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: AssetEligibility.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B-\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/AssetEligibility;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/resources/Asset;", "asset", "", "supported_contexts", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/resources/Asset;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/AssetEligibility;", "Ljava/util/List;", "getSupported_contexts", "()Ljava/util/List;", "Lcom/coinbase/android/apiv3/generated/resources/Asset;", "getAsset", "()Lcom/coinbase/android/apiv3/generated/resources/Asset;", "<init>", "(Lcom/coinbase/android/apiv3/generated/resources/Asset;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AssetEligibility extends a {
    public static final ProtoAdapter<AssetEligibility> ADAPTER;
    public static final Parcelable.Creator<AssetEligibility> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Asset#ADAPTER", tag = 1)
    private final Asset asset;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "supportedContexts", label = p.a.REPEATED, tag = 2)
    private final List<String> supported_contexts;

    /* compiled from: AssetEligibility.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/AssetEligibility$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/AssetEligibility;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<AssetEligibility> protoAdapter = new ProtoAdapter<AssetEligibility>(c.LENGTH_DELIMITED, e0.b(AssetEligibility.class), "type.googleapis.com/coinbase.public_api.authed.user_eligibility.AssetEligibility") { // from class: com.coinbase.android.apiv3.generated.authed.user_eligibility.AssetEligibility$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AssetEligibility decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                long d2 = reader.d();
                Asset asset = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AssetEligibility(asset, arrayList, reader.e(d2));
                    }
                    if (g2 == 1) {
                        asset = Asset.ADAPTER.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        arrayList.add(ProtoAdapter.STRING.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AssetEligibility value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAsset() != null) {
                    Asset.ADAPTER.encodeWithTag(writer, 1, value.getAsset());
                }
                ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 2, value.getSupported_contexts());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AssetEligibility value) {
                m.h(value, "value");
                if (value.getAsset() == null) {
                    return 0;
                }
                return value.unknownFields().Q() + Asset.ADAPTER.encodedSizeWithTag(1, value.getAsset()) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, value.getSupported_contexts());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AssetEligibility redact(AssetEligibility value) {
                m.h(value, "value");
                Asset asset = value.getAsset();
                return AssetEligibility.copy$default(value, asset != null ? Asset.ADAPTER.redact(asset) : null, null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AssetEligibility() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ AssetEligibility(Asset asset, List list, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : asset, (i2 & 2) != 0 ? r.g() : list, (i2 & 4) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AssetEligibility copy$default(AssetEligibility assetEligibility, Asset asset, List list, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            asset = assetEligibility.asset;
        }
        if ((i2 & 2) != 0) {
            list = assetEligibility.supported_contexts;
        }
        if ((i2 & 4) != 0) {
            iVar = assetEligibility.unknownFields();
        }
        return assetEligibility.copy(asset, list, iVar);
    }

    public final AssetEligibility copy(Asset asset, List<String> supported_contexts, i unknownFields) {
        m.h(supported_contexts, "supported_contexts");
        m.h(unknownFields, "unknownFields");
        return new AssetEligibility(asset, supported_contexts, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetEligibility) {
            AssetEligibility assetEligibility = (AssetEligibility) obj;
            return m.c(unknownFields(), assetEligibility.unknownFields()) && m.c(this.asset, assetEligibility.asset) && m.c(this.supported_contexts, assetEligibility.supported_contexts);
        }
        return false;
    }

    public final Asset getAsset() {
        return this.asset;
    }

    public final List<String> getSupported_contexts() {
        return this.supported_contexts;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Asset asset = this.asset;
            int hashCode2 = ((hashCode + (asset != null ? asset.hashCode() : 0)) * 37) + this.supported_contexts.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m483newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.asset != null) {
            arrayList.add("asset=" + this.asset);
        }
        if (!this.supported_contexts.isEmpty()) {
            arrayList.add("supported_contexts=" + b.d(this.supported_contexts));
        }
        h0 = z.h0(arrayList, ", ", "AssetEligibility{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m483newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetEligibility(Asset asset, List<String> supported_contexts, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(supported_contexts, "supported_contexts");
        m.h(unknownFields, "unknownFields");
        this.asset = asset;
        this.supported_contexts = supported_contexts;
    }
}