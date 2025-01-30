package com.coinbase.android.apiv3.generated.unauthed;

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

/* compiled from: GetAssetSummaryRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/GetAssetSummaryRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "asset_slug_or_id", "base_currency", "country", ApiConstants.LOCALE, "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/GetAssetSummaryRequest;", "Ljava/lang/String;", "getAsset_slug_or_id", "getBase_currency", "getCountry", "getLocale", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetAssetSummaryRequest extends a {
    public static final ProtoAdapter<GetAssetSummaryRequest> ADAPTER;
    public static final Parcelable.Creator<GetAssetSummaryRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "assetSlugOrId", tag = 1)
    private final String asset_slug_or_id;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "baseCurrency", tag = 2)
    private final String base_currency;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String country;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    private final String locale;

    /* compiled from: GetAssetSummaryRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/GetAssetSummaryRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/GetAssetSummaryRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetAssetSummaryRequest> protoAdapter = new ProtoAdapter<GetAssetSummaryRequest>(c.LENGTH_DELIMITED, e0.b(GetAssetSummaryRequest.class), "type.googleapis.com/coinbase.public_api.unauthed.GetAssetSummaryRequest") { // from class: com.coinbase.android.apiv3.generated.unauthed.GetAssetSummaryRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetAssetSummaryRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetAssetSummaryRequest(str, str2, str3, str4, reader.e(d2));
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
                        str4 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetAssetSummaryRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getAsset_slug_or_id(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getAsset_slug_or_id());
                }
                if (!m.c(value.getBase_currency(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getBase_currency());
                }
                if (!m.c(value.getCountry(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getCountry());
                }
                if (!m.c(value.getLocale(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getLocale());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetAssetSummaryRequest value) {
                m.h(value, "value");
                if (m.c(value.getAsset_slug_or_id(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getAsset_slug_or_id());
                if (!m.c(value.getBase_currency(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getBase_currency());
                    if (!m.c(value.getCountry(), "")) {
                        r2 = (m.c(value.getLocale(), "") ? 0 : protoAdapter2.encodedSizeWithTag(4, value.getLocale()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(3, value.getCountry());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetAssetSummaryRequest redact(GetAssetSummaryRequest value) {
                m.h(value, "value");
                return GetAssetSummaryRequest.copy$default(value, null, null, null, null, i.a, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetAssetSummaryRequest() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ GetAssetSummaryRequest(String str, String str2, String str3, String str4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetAssetSummaryRequest copy$default(GetAssetSummaryRequest getAssetSummaryRequest, String str, String str2, String str3, String str4, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getAssetSummaryRequest.asset_slug_or_id;
        }
        if ((i2 & 2) != 0) {
            str2 = getAssetSummaryRequest.base_currency;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = getAssetSummaryRequest.country;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = getAssetSummaryRequest.locale;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            iVar = getAssetSummaryRequest.unknownFields();
        }
        return getAssetSummaryRequest.copy(str, str5, str6, str7, iVar);
    }

    public final GetAssetSummaryRequest copy(String asset_slug_or_id, String base_currency, String country, String locale, i unknownFields) {
        m.h(asset_slug_or_id, "asset_slug_or_id");
        m.h(base_currency, "base_currency");
        m.h(country, "country");
        m.h(locale, "locale");
        m.h(unknownFields, "unknownFields");
        return new GetAssetSummaryRequest(asset_slug_or_id, base_currency, country, locale, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetAssetSummaryRequest) {
            GetAssetSummaryRequest getAssetSummaryRequest = (GetAssetSummaryRequest) obj;
            return m.c(unknownFields(), getAssetSummaryRequest.unknownFields()) && m.c(this.asset_slug_or_id, getAssetSummaryRequest.asset_slug_or_id) && m.c(this.base_currency, getAssetSummaryRequest.base_currency) && m.c(this.country, getAssetSummaryRequest.country) && m.c(this.locale, getAssetSummaryRequest.locale);
        }
        return false;
    }

    public final String getAsset_slug_or_id() {
        return this.asset_slug_or_id;
    }

    public final String getBase_currency() {
        return this.base_currency;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getLocale() {
        return this.locale;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.asset_slug_or_id.hashCode()) * 37) + this.base_currency.hashCode()) * 37) + this.country.hashCode()) * 37) + this.locale.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m538newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("asset_slug_or_id=" + b.c(this.asset_slug_or_id));
        arrayList.add("base_currency=" + b.c(this.base_currency));
        arrayList.add("country=" + b.c(this.country));
        arrayList.add("locale=" + b.c(this.locale));
        h0 = z.h0(arrayList, ", ", "GetAssetSummaryRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAssetSummaryRequest(String asset_slug_or_id, String base_currency, String country, String locale, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(asset_slug_or_id, "asset_slug_or_id");
        m.h(base_currency, "base_currency");
        m.h(country, "country");
        m.h(locale, "locale");
        m.h(unknownFields, "unknownFields");
        this.asset_slug_or_id = asset_slug_or_id;
        this.base_currency = base_currency;
        this.country = country;
        this.locale = locale;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m538newBuilder() {
        throw new AssertionError();
    }
}