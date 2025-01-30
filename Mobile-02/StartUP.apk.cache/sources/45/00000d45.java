package com.coinbase.android.apiv3.generated.authed.loyalty;

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

/* compiled from: LoyaltyCardFeatures.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0011\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0010\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "in_app_idv", "home_carousel_fullwidth_summary_card", "Lj/i;", "unknownFields", "copy", "(ZZLj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;", "Z", "getHome_carousel_fullwidth_summary_card", "()Z", "getIn_app_idv", "<init>", "(ZZLj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoyaltyCardFeatures extends a {
    public static final ProtoAdapter<LoyaltyCardFeatures> ADAPTER;
    public static final Parcelable.Creator<LoyaltyCardFeatures> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "homeCarouselFullwidthSummaryCard", tag = 2)
    private final boolean home_carousel_fullwidth_summary_card;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "inAppIdv", tag = 1)
    private final boolean in_app_idv;

    /* compiled from: LoyaltyCardFeatures.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardFeatures;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LoyaltyCardFeatures> protoAdapter = new ProtoAdapter<LoyaltyCardFeatures>(c.LENGTH_DELIMITED, e0.b(LoyaltyCardFeatures.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.LoyaltyCardFeatures") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardFeatures$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCardFeatures decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoyaltyCardFeatures(z, z2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        z2 = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoyaltyCardFeatures value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getIn_app_idv()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 1, Boolean.valueOf(value.getIn_app_idv()));
                }
                if (value.getHome_carousel_fullwidth_summary_card()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 2, Boolean.valueOf(value.getHome_carousel_fullwidth_summary_card()));
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoyaltyCardFeatures value) {
                m.h(value, "value");
                if (value.getIn_app_idv()) {
                    ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
                    return (value.getHome_carousel_fullwidth_summary_card() ? protoAdapter2.encodedSizeWithTag(2, Boolean.valueOf(value.getHome_carousel_fullwidth_summary_card())) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(1, Boolean.valueOf(value.getIn_app_idv()));
                }
                return 0;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCardFeatures redact(LoyaltyCardFeatures value) {
                m.h(value, "value");
                return LoyaltyCardFeatures.copy$default(value, false, false, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoyaltyCardFeatures() {
        this(false, false, null, 7, null);
    }

    public /* synthetic */ LoyaltyCardFeatures(boolean z, boolean z2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoyaltyCardFeatures copy$default(LoyaltyCardFeatures loyaltyCardFeatures, boolean z, boolean z2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = loyaltyCardFeatures.in_app_idv;
        }
        if ((i2 & 2) != 0) {
            z2 = loyaltyCardFeatures.home_carousel_fullwidth_summary_card;
        }
        if ((i2 & 4) != 0) {
            iVar = loyaltyCardFeatures.unknownFields();
        }
        return loyaltyCardFeatures.copy(z, z2, iVar);
    }

    public final LoyaltyCardFeatures copy(boolean z, boolean z2, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new LoyaltyCardFeatures(z, z2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoyaltyCardFeatures) {
            LoyaltyCardFeatures loyaltyCardFeatures = (LoyaltyCardFeatures) obj;
            return m.c(unknownFields(), loyaltyCardFeatures.unknownFields()) && this.in_app_idv == loyaltyCardFeatures.in_app_idv && this.home_carousel_fullwidth_summary_card == loyaltyCardFeatures.home_carousel_fullwidth_summary_card;
        }
        return false;
    }

    public final boolean getHome_carousel_fullwidth_summary_card() {
        return this.home_carousel_fullwidth_summary_card;
    }

    public final boolean getIn_app_idv() {
        return this.in_app_idv;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.in_app_idv)) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.home_carousel_fullwidth_summary_card);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m412newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("in_app_idv=" + this.in_app_idv);
        arrayList.add("home_carousel_fullwidth_summary_card=" + this.home_carousel_fullwidth_summary_card);
        h0 = z.h0(arrayList, ", ", "LoyaltyCardFeatures{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoyaltyCardFeatures(boolean z, boolean z2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.in_app_idv = z;
        this.home_carousel_fullwidth_summary_card = z2;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m412newBuilder() {
        throw new AssertionError();
    }
}