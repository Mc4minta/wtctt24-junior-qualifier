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

/* compiled from: GetSpotRatesRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/GetSpotRatesRequest;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", ApiConstants.CURRENCY, "date", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/unauthed/GetSpotRatesRequest;", "Ljava/lang/String;", "getCurrency", "getDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetSpotRatesRequest extends a {
    public static final ProtoAdapter<GetSpotRatesRequest> ADAPTER;
    public static final Parcelable.Creator<GetSpotRatesRequest> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    private final String currency;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String date;

    /* compiled from: GetSpotRatesRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/GetSpotRatesRequest$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/unauthed/GetSpotRatesRequest;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetSpotRatesRequest> protoAdapter = new ProtoAdapter<GetSpotRatesRequest>(c.LENGTH_DELIMITED, e0.b(GetSpotRatesRequest.class), "type.googleapis.com/coinbase.public_api.unauthed.GetSpotRatesRequest") { // from class: com.coinbase.android.apiv3.generated.unauthed.GetSpotRatesRequest$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetSpotRatesRequest decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                String str = "";
                String str2 = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetSpotRatesRequest(str, str2, reader.e(d2));
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
            public void encode(l writer, GetSpotRatesRequest value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getCurrency(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getCurrency());
                }
                if (!m.c(value.getDate(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getDate());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetSpotRatesRequest value) {
                m.h(value, "value");
                if (m.c(value.getCurrency(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                return (m.c(value.getDate(), "") ? 0 : protoAdapter2.encodedSizeWithTag(2, value.getDate()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(1, value.getCurrency());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetSpotRatesRequest redact(GetSpotRatesRequest value) {
                m.h(value, "value");
                return GetSpotRatesRequest.copy$default(value, null, null, i.a, 3, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetSpotRatesRequest() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetSpotRatesRequest(String str, String str2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetSpotRatesRequest copy$default(GetSpotRatesRequest getSpotRatesRequest, String str, String str2, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getSpotRatesRequest.currency;
        }
        if ((i2 & 2) != 0) {
            str2 = getSpotRatesRequest.date;
        }
        if ((i2 & 4) != 0) {
            iVar = getSpotRatesRequest.unknownFields();
        }
        return getSpotRatesRequest.copy(str, str2, iVar);
    }

    public final GetSpotRatesRequest copy(String currency, String date, i unknownFields) {
        m.h(currency, "currency");
        m.h(date, "date");
        m.h(unknownFields, "unknownFields");
        return new GetSpotRatesRequest(currency, date, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetSpotRatesRequest) {
            GetSpotRatesRequest getSpotRatesRequest = (GetSpotRatesRequest) obj;
            return m.c(unknownFields(), getSpotRatesRequest.unknownFields()) && m.c(this.currency, getSpotRatesRequest.currency) && m.c(this.date, getSpotRatesRequest.date);
        }
        return false;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDate() {
        return this.date;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.currency.hashCode()) * 37) + this.date.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m543newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("currency=" + b.c(this.currency));
        arrayList.add("date=" + b.c(this.date));
        h0 = z.h0(arrayList, ", ", "GetSpotRatesRequest{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetSpotRatesRequest(String currency, String date, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(currency, "currency");
        m.h(date, "date");
        m.h(unknownFields, "unknownFields");
        this.currency = currency;
        this.date = date;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m543newBuilder() {
        throw new AssertionError();
    }
}