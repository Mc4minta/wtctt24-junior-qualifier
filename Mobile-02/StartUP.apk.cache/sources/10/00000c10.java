package com.coinbase.android.apiv3.generated.authed.card;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
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

/* compiled from: RewardProgram.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B;\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001b\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001f\u0010\u000f¨\u0006#"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "image_url", ApiConstants.NAME, "short_description", "Lcom/coinbase/android/apiv3/generated/authed/card/SpendableAsset;", "required_spendable_asset", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/card/SpendableAsset;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;", "Ljava/lang/String;", "getImage_url", "getName", "Lcom/coinbase/android/apiv3/generated/authed/card/SpendableAsset;", "getRequired_spendable_asset", "()Lcom/coinbase/android/apiv3/generated/authed/card/SpendableAsset;", "getShort_description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/card/SpendableAsset;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class RewardProgram extends a {
    public static final ProtoAdapter<RewardProgram> ADAPTER;
    public static final Parcelable.Creator<RewardProgram> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "imageUrl", tag = 1)
    private final String image_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String name;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.card.SpendableAsset#ADAPTER", jsonName = "requiredSpendableAsset", tag = 4)
    private final SpendableAsset required_spendable_asset;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "shortDescription", tag = 3)
    private final String short_description;

    /* compiled from: RewardProgram.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/RewardProgram;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<RewardProgram> protoAdapter = new ProtoAdapter<RewardProgram>(c.LENGTH_DELIMITED, e0.b(RewardProgram.class), "type.googleapis.com/coinbase.public_api.authed.card.RewardProgram") { // from class: com.coinbase.android.apiv3.generated.authed.card.RewardProgram$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RewardProgram decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                SpendableAsset spendableAsset = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new RewardProgram(str, str2, str3, spendableAsset, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        spendableAsset = SpendableAsset.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, RewardProgram value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getImage_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getImage_url());
                }
                if (!m.c(value.getName(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getName());
                }
                if (!m.c(value.getShort_description(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getShort_description());
                }
                if (value.getRequired_spendable_asset() != null) {
                    SpendableAsset.ADAPTER.encodeWithTag(writer, 4, value.getRequired_spendable_asset());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(RewardProgram value) {
                m.h(value, "value");
                if (m.c(value.getImage_url(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getImage_url());
                if (!m.c(value.getName(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getName());
                    if (!m.c(value.getShort_description(), "")) {
                        r2 = (value.getRequired_spendable_asset() != null ? SpendableAsset.ADAPTER.encodedSizeWithTag(4, value.getRequired_spendable_asset()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(3, value.getShort_description());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public RewardProgram redact(RewardProgram value) {
                m.h(value, "value");
                SpendableAsset required_spendable_asset = value.getRequired_spendable_asset();
                return RewardProgram.copy$default(value, null, null, null, required_spendable_asset != null ? SpendableAsset.ADAPTER.redact(required_spendable_asset) : null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public RewardProgram() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ RewardProgram(String str, String str2, String str3, SpendableAsset spendableAsset, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) == 0 ? str3 : "", (i2 & 8) != 0 ? null : spendableAsset, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ RewardProgram copy$default(RewardProgram rewardProgram, String str, String str2, String str3, SpendableAsset spendableAsset, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rewardProgram.image_url;
        }
        if ((i2 & 2) != 0) {
            str2 = rewardProgram.name;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = rewardProgram.short_description;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            spendableAsset = rewardProgram.required_spendable_asset;
        }
        SpendableAsset spendableAsset2 = spendableAsset;
        if ((i2 & 16) != 0) {
            iVar = rewardProgram.unknownFields();
        }
        return rewardProgram.copy(str, str4, str5, spendableAsset2, iVar);
    }

    public final RewardProgram copy(String image_url, String name, String short_description, SpendableAsset spendableAsset, i unknownFields) {
        m.h(image_url, "image_url");
        m.h(name, "name");
        m.h(short_description, "short_description");
        m.h(unknownFields, "unknownFields");
        return new RewardProgram(image_url, name, short_description, spendableAsset, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RewardProgram) {
            RewardProgram rewardProgram = (RewardProgram) obj;
            return m.c(unknownFields(), rewardProgram.unknownFields()) && m.c(this.image_url, rewardProgram.image_url) && m.c(this.name, rewardProgram.name) && m.c(this.short_description, rewardProgram.short_description) && m.c(this.required_spendable_asset, rewardProgram.required_spendable_asset);
        }
        return false;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getName() {
        return this.name;
    }

    public final SpendableAsset getRequired_spendable_asset() {
        return this.required_spendable_asset;
    }

    public final String getShort_description() {
        return this.short_description;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + this.image_url.hashCode()) * 37) + this.name.hashCode()) * 37) + this.short_description.hashCode()) * 37;
            SpendableAsset spendableAsset = this.required_spendable_asset;
            int hashCode2 = hashCode + (spendableAsset != null ? spendableAsset.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m322newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("image_url=" + b.c(this.image_url));
        arrayList.add("name=" + b.c(this.name));
        arrayList.add("short_description=" + b.c(this.short_description));
        if (this.required_spendable_asset != null) {
            arrayList.add("required_spendable_asset=" + this.required_spendable_asset);
        }
        h0 = z.h0(arrayList, ", ", "RewardProgram{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardProgram(String image_url, String name, String short_description, SpendableAsset spendableAsset, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(image_url, "image_url");
        m.h(name, "name");
        m.h(short_description, "short_description");
        m.h(unknownFields, "unknownFields");
        this.image_url = image_url;
        this.name = name;
        this.short_description = short_description;
        this.required_spendable_asset = spendableAsset;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m322newBuilder() {
        throw new AssertionError();
    }
}