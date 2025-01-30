package com.coinbase.android.apiv3.generated.authed.personalized_assets;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.PercentChange;
import com.coinbase.android.apiv3.generated.common.TimestampedScaledAmount;
import com.coinbase.android.apiv3.generated.resources.Asset;
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
import kotlin.j0.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: PersonalizedAsset.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B5\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/PersonalizedAsset;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/resources/Asset;", "asset", "Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "latest_price", "Lcom/coinbase/android/apiv3/generated/common/PercentChange;", "percent_change", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/resources/Asset;Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;Lcom/coinbase/android/apiv3/generated/common/PercentChange;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/PersonalizedAsset;", "Lcom/coinbase/android/apiv3/generated/resources/Asset;", "getAsset", "()Lcom/coinbase/android/apiv3/generated/resources/Asset;", "Lcom/coinbase/android/apiv3/generated/common/PercentChange;", "getPercent_change", "()Lcom/coinbase/android/apiv3/generated/common/PercentChange;", "Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "getLatest_price", "()Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;", "<init>", "(Lcom/coinbase/android/apiv3/generated/resources/Asset;Lcom/coinbase/android/apiv3/generated/common/TimestampedScaledAmount;Lcom/coinbase/android/apiv3/generated/common/PercentChange;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class PersonalizedAsset extends a {
    public static final ProtoAdapter<PersonalizedAsset> ADAPTER;
    public static final Parcelable.Creator<PersonalizedAsset> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Asset#ADAPTER", tag = 1)
    private final Asset asset;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.TimestampedScaledAmount#ADAPTER", jsonName = "latestPrice", tag = 2)
    private final TimestampedScaledAmount latest_price;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.PercentChange#ADAPTER", jsonName = "percentChange", tag = 3)
    private final PercentChange percent_change;

    /* compiled from: PersonalizedAsset.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/PersonalizedAsset$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/personalized_assets/PersonalizedAsset;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
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
        final d b2 = e0.b(PersonalizedAsset.class);
        ProtoAdapter<PersonalizedAsset> protoAdapter = new ProtoAdapter<PersonalizedAsset>(cVar, b2, "type.googleapis.com/coinbase.public_api.authed.personalized_assets.PersonalizedAsset") { // from class: com.coinbase.android.apiv3.generated.authed.personalized_assets.PersonalizedAsset$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public PersonalizedAsset decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Asset asset = null;
                TimestampedScaledAmount timestampedScaledAmount = null;
                PercentChange percentChange = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new PersonalizedAsset(asset, timestampedScaledAmount, percentChange, reader.e(d2));
                    }
                    if (g2 == 1) {
                        asset = Asset.ADAPTER.decode(reader);
                    } else if (g2 == 2) {
                        timestampedScaledAmount = TimestampedScaledAmount.ADAPTER.decode(reader);
                    } else if (g2 != 3) {
                        reader.m(g2);
                    } else {
                        percentChange = PercentChange.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, PersonalizedAsset value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getAsset() != null) {
                    Asset.ADAPTER.encodeWithTag(writer, 1, value.getAsset());
                }
                if (value.getLatest_price() != null) {
                    TimestampedScaledAmount.ADAPTER.encodeWithTag(writer, 2, value.getLatest_price());
                }
                if (value.getPercent_change() != null) {
                    PercentChange.ADAPTER.encodeWithTag(writer, 3, value.getPercent_change());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(PersonalizedAsset value) {
                m.h(value, "value");
                if (value.getAsset() == null) {
                    return 0;
                }
                int encodedSizeWithTag = Asset.ADAPTER.encodedSizeWithTag(1, value.getAsset());
                if (value.getLatest_price() != null) {
                    r1 = (value.getPercent_change() != null ? PercentChange.ADAPTER.encodedSizeWithTag(3, value.getPercent_change()) + value.unknownFields().Q() : 0) + TimestampedScaledAmount.ADAPTER.encodedSizeWithTag(2, value.getLatest_price());
                }
                return r1 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public PersonalizedAsset redact(PersonalizedAsset value) {
                m.h(value, "value");
                Asset asset = value.getAsset();
                Asset redact = asset != null ? Asset.ADAPTER.redact(asset) : null;
                TimestampedScaledAmount latest_price = value.getLatest_price();
                TimestampedScaledAmount redact2 = latest_price != null ? TimestampedScaledAmount.ADAPTER.redact(latest_price) : null;
                PercentChange percent_change = value.getPercent_change();
                return value.copy(redact, redact2, percent_change != null ? PercentChange.ADAPTER.redact(percent_change) : null, i.a);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public PersonalizedAsset() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ PersonalizedAsset(Asset asset, TimestampedScaledAmount timestampedScaledAmount, PercentChange percentChange, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : asset, (i2 & 2) != 0 ? null : timestampedScaledAmount, (i2 & 4) != 0 ? null : percentChange, (i2 & 8) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ PersonalizedAsset copy$default(PersonalizedAsset personalizedAsset, Asset asset, TimestampedScaledAmount timestampedScaledAmount, PercentChange percentChange, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            asset = personalizedAsset.asset;
        }
        if ((i2 & 2) != 0) {
            timestampedScaledAmount = personalizedAsset.latest_price;
        }
        if ((i2 & 4) != 0) {
            percentChange = personalizedAsset.percent_change;
        }
        if ((i2 & 8) != 0) {
            iVar = personalizedAsset.unknownFields();
        }
        return personalizedAsset.copy(asset, timestampedScaledAmount, percentChange, iVar);
    }

    public final PersonalizedAsset copy(Asset asset, TimestampedScaledAmount timestampedScaledAmount, PercentChange percentChange, i unknownFields) {
        m.h(unknownFields, "unknownFields");
        return new PersonalizedAsset(asset, timestampedScaledAmount, percentChange, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PersonalizedAsset) {
            PersonalizedAsset personalizedAsset = (PersonalizedAsset) obj;
            return m.c(unknownFields(), personalizedAsset.unknownFields()) && m.c(this.asset, personalizedAsset.asset) && m.c(this.latest_price, personalizedAsset.latest_price) && m.c(this.percent_change, personalizedAsset.percent_change);
        }
        return false;
    }

    public final Asset getAsset() {
        return this.asset;
    }

    public final TimestampedScaledAmount getLatest_price() {
        return this.latest_price;
    }

    public final PercentChange getPercent_change() {
        return this.percent_change;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Asset asset = this.asset;
            int hashCode2 = (hashCode + (asset != null ? asset.hashCode() : 0)) * 37;
            TimestampedScaledAmount timestampedScaledAmount = this.latest_price;
            int hashCode3 = (hashCode2 + (timestampedScaledAmount != null ? timestampedScaledAmount.hashCode() : 0)) * 37;
            PercentChange percentChange = this.percent_change;
            int hashCode4 = hashCode3 + (percentChange != null ? percentChange.hashCode() : 0);
            this.hashCode = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m442newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.asset != null) {
            arrayList.add("asset=" + this.asset);
        }
        if (this.latest_price != null) {
            arrayList.add("latest_price=" + this.latest_price);
        }
        if (this.percent_change != null) {
            arrayList.add("percent_change=" + this.percent_change);
        }
        h0 = z.h0(arrayList, ", ", "PersonalizedAsset{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalizedAsset(Asset asset, TimestampedScaledAmount timestampedScaledAmount, PercentChange percentChange, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(unknownFields, "unknownFields");
        this.asset = asset;
        this.latest_price = timestampedScaledAmount;
        this.percent_change = percentChange;
    }

    /* renamed from: newBuilder  reason: collision with other method in class */
    public /* synthetic */ Void m442newBuilder() {
        throw new AssertionError();
    }
}