package com.coinbase.android.apiv3.generated.common;

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

/* compiled from: AssetPair.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/AssetPair;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "base", ApiConstants.CURRENCY, "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/common/AssetPair;", "Ljava/lang/String;", "getCurrency", "getBase", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AssetPair extends a {
    public static final ProtoAdapter<AssetPair> ADAPTER;
    public static final Parcelable.Creator<AssetPair> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String base;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String currency;

    /* compiled from: AssetPair.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/common/AssetPair$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/common/AssetPair;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<AssetPair> protoAdapter = new ProtoAdapter<AssetPair>(c.LENGTH_DELIMITED, e0.b(AssetPair.class), "type.googleapis.com/coinbase.public_api.common.AssetPair") { // from class: com.coinbase.android.apiv3.generated.common.AssetPair$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AssetPair decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new AssetPair(str, str2, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, AssetPair value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getBase(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getBase());
                }
                if (!m.c(value.getCurrency(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getCurrency());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(AssetPair value) {
                m.h(value, "value");
                if (m.c(value.getBase(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return (m.c(value.getCurrency(), "") ? 0 : protoAdapter2.encodedSizeWithTag(2, value.getCurrency()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(1, value.getBase());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public AssetPair redact(AssetPair value) {
                m.h(value, "value");
                return AssetPair.copy$default(value, null, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public AssetPair() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ AssetPair(String str, String str2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ AssetPair copy$default(AssetPair assetPair, String str, String str2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = assetPair.base;
        }
        if ((i2 & 2) != 0) {
            str2 = assetPair.currency;
        }
        if ((i2 & 4) != 0) {
            iVar = assetPair.unknownFields();
        }
        return assetPair.copy(str, str2, iVar);
    }

    public final AssetPair copy(String base, String currency, i unknownFields) {
        m.h(base, "base");
        m.h(currency, "currency");
        m.h(unknownFields, "unknownFields");
        return new AssetPair(base, currency, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPair) {
            AssetPair assetPair = (AssetPair) obj;
            return m.c(unknownFields(), assetPair.unknownFields()) && m.c(this.base, assetPair.base) && m.c(this.currency, assetPair.currency);
        }
        return false;
    }

    public final String getBase() {
        return this.base;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.base.hashCode()) * 37) + this.currency.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m504newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("base=" + b.c(this.base));
        arrayList.add("currency=" + b.c(this.currency));
        h0 = z.h0(arrayList, ", ", "AssetPair{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetPair(String base, String currency, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(base, "base");
        m.h(currency, "currency");
        m.h(unknownFields, "unknownFields");
        this.base = base;
        this.currency = currency;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m504newBuilder() {
        throw new AssertionError();
    }
}