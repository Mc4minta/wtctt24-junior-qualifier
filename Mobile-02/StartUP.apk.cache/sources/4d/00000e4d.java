package com.coinbase.android.apiv3.generated.authed.user_eligibility;

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
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetUserEligibilityResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#BQ\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJW\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b \u0010\u001d¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/GetUserEligibilityResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/AssetEligibility;", "asset_eligibility", "feature_flags", "Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/SplitTest;", "split_test_groups", "product_features", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/GetUserEligibilityResponse;", "Ljava/util/List;", "getProduct_features", "()Ljava/util/List;", "getAsset_eligibility", "getFeature_flags", "getSplit_test_groups", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetUserEligibilityResponse extends a {
    public static final ProtoAdapter<GetUserEligibilityResponse> ADAPTER;
    public static final Parcelable.Creator<GetUserEligibilityResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.user_eligibility.AssetEligibility#ADAPTER", jsonName = "assetEligibility", label = p.a.REPEATED, tag = 1)
    private final List<AssetEligibility> asset_eligibility;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "featureFlags", label = p.a.REPEATED, tag = 2)
    private final List<String> feature_flags;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "productFeatures", label = p.a.REPEATED, tag = 4)
    private final List<String> product_features;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.user_eligibility.SplitTest#ADAPTER", jsonName = "splitTestGroups", label = p.a.REPEATED, tag = 3)
    private final List<SplitTest> split_test_groups;

    /* compiled from: GetUserEligibilityResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/GetUserEligibilityResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/user_eligibility/GetUserEligibilityResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetUserEligibilityResponse> protoAdapter = new ProtoAdapter<GetUserEligibilityResponse>(c.LENGTH_DELIMITED, e0.b(GetUserEligibilityResponse.class), "type.googleapis.com/coinbase.public_api.authed.user_eligibility.GetUserEligibilityResponse") { // from class: com.coinbase.android.apiv3.generated.authed.user_eligibility.GetUserEligibilityResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetUserEligibilityResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                long d2 = reader.d();
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetUserEligibilityResponse(arrayList, arrayList2, arrayList3, arrayList4, reader.e(d2));
                    }
                    if (g2 == 1) {
                        arrayList.add(AssetEligibility.ADAPTER.decode(reader));
                    } else if (g2 == 2) {
                        arrayList2.add(ProtoAdapter.STRING.decode(reader));
                    } else if (g2 == 3) {
                        arrayList3.add(SplitTest.ADAPTER.decode(reader));
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        arrayList4.add(ProtoAdapter.STRING.decode(reader));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetUserEligibilityResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                AssetEligibility.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getAsset_eligibility());
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.asRepeated().encodeWithTag(writer, 2, value.getFeature_flags());
                SplitTest.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.getSplit_test_groups());
                protoAdapter2.asRepeated().encodeWithTag(writer, 4, value.getProduct_features());
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetUserEligibilityResponse value) {
                m.h(value, "value");
                int encodedSizeWithTag = AssetEligibility.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getAsset_eligibility());
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return encodedSizeWithTag + protoAdapter2.asRepeated().encodedSizeWithTag(2, value.getFeature_flags()) + SplitTest.ADAPTER.asRepeated().encodedSizeWithTag(3, value.getSplit_test_groups()) + protoAdapter2.asRepeated().encodedSizeWithTag(4, value.getProduct_features()) + value.unknownFields().Q();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetUserEligibilityResponse redact(GetUserEligibilityResponse value) {
                m.h(value, "value");
                return GetUserEligibilityResponse.copy$default(value, b.a(value.getAsset_eligibility(), AssetEligibility.ADAPTER), null, b.a(value.getSplit_test_groups(), SplitTest.ADAPTER), null, i.a, 10, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetUserEligibilityResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ GetUserEligibilityResponse(List list, List list2, List list3, List list4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? r.g() : list2, (i2 & 4) != 0 ? r.g() : list3, (i2 & 8) != 0 ? r.g() : list4, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetUserEligibilityResponse copy$default(GetUserEligibilityResponse getUserEligibilityResponse, List list, List list2, List list3, List list4, i iVar, int i2, Object obj) {
        List<AssetEligibility> list5 = list;
        if ((i2 & 1) != 0) {
            list5 = getUserEligibilityResponse.asset_eligibility;
        }
        List<String> list6 = list2;
        if ((i2 & 2) != 0) {
            list6 = getUserEligibilityResponse.feature_flags;
        }
        List list7 = list6;
        List<SplitTest> list8 = list3;
        if ((i2 & 4) != 0) {
            list8 = getUserEligibilityResponse.split_test_groups;
        }
        List list9 = list8;
        List<String> list10 = list4;
        if ((i2 & 8) != 0) {
            list10 = getUserEligibilityResponse.product_features;
        }
        List list11 = list10;
        if ((i2 & 16) != 0) {
            iVar = getUserEligibilityResponse.unknownFields();
        }
        return getUserEligibilityResponse.copy(list5, list7, list9, list11, iVar);
    }

    public final GetUserEligibilityResponse copy(List<AssetEligibility> asset_eligibility, List<String> feature_flags, List<SplitTest> split_test_groups, List<String> product_features, i unknownFields) {
        m.h(asset_eligibility, "asset_eligibility");
        m.h(feature_flags, "feature_flags");
        m.h(split_test_groups, "split_test_groups");
        m.h(product_features, "product_features");
        m.h(unknownFields, "unknownFields");
        return new GetUserEligibilityResponse(asset_eligibility, feature_flags, split_test_groups, product_features, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetUserEligibilityResponse) {
            GetUserEligibilityResponse getUserEligibilityResponse = (GetUserEligibilityResponse) obj;
            return m.c(unknownFields(), getUserEligibilityResponse.unknownFields()) && m.c(this.asset_eligibility, getUserEligibilityResponse.asset_eligibility) && m.c(this.feature_flags, getUserEligibilityResponse.feature_flags) && m.c(this.split_test_groups, getUserEligibilityResponse.split_test_groups) && m.c(this.product_features, getUserEligibilityResponse.product_features);
        }
        return false;
    }

    public final List<AssetEligibility> getAsset_eligibility() {
        return this.asset_eligibility;
    }

    public final List<String> getFeature_flags() {
        return this.feature_flags;
    }

    public final List<String> getProduct_features() {
        return this.product_features;
    }

    public final List<SplitTest> getSplit_test_groups() {
        return this.split_test_groups;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.asset_eligibility.hashCode()) * 37) + this.feature_flags.hashCode()) * 37) + this.split_test_groups.hashCode()) * 37) + this.product_features.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m485newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.asset_eligibility.isEmpty()) {
            arrayList.add("asset_eligibility=" + this.asset_eligibility);
        }
        if (!this.feature_flags.isEmpty()) {
            arrayList.add("feature_flags=" + b.d(this.feature_flags));
        }
        if (!this.split_test_groups.isEmpty()) {
            arrayList.add("split_test_groups=" + this.split_test_groups);
        }
        if (!this.product_features.isEmpty()) {
            arrayList.add("product_features=" + b.d(this.product_features));
        }
        h0 = z.h0(arrayList, ", ", "GetUserEligibilityResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m485newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUserEligibilityResponse(List<AssetEligibility> asset_eligibility, List<String> feature_flags, List<SplitTest> split_test_groups, List<String> product_features, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(asset_eligibility, "asset_eligibility");
        m.h(feature_flags, "feature_flags");
        m.h(split_test_groups, "split_test_groups");
        m.h(product_features, "product_features");
        m.h(unknownFields, "unknownFields");
        this.asset_eligibility = asset_eligibility;
        this.feature_flags = feature_flags;
        this.split_test_groups = split_test_groups;
        this.product_features = product_features;
    }
}