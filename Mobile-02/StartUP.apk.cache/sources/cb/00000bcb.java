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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetApplicationPrefillInfoResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB'\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationPrefillInfoResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationInfo;", "application_info", "cardholder_agreement_url", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationInfo;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationPrefillInfoResponse;", "Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationInfo;", "getApplication_info", "()Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationInfo;", "Ljava/lang/String;", "getCardholder_agreement_url", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/card/ApplicationInfo;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetApplicationPrefillInfoResponse extends a {
    public static final ProtoAdapter<GetApplicationPrefillInfoResponse> ADAPTER;
    public static final Parcelable.Creator<GetApplicationPrefillInfoResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.card.ApplicationInfo#ADAPTER", jsonName = "applicationInfo", tag = 1)
    private final ApplicationInfo application_info;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardholderAgreementUrl", tag = 2)
    private final String cardholder_agreement_url;

    /* compiled from: GetApplicationPrefillInfoResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationPrefillInfoResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetApplicationPrefillInfoResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetApplicationPrefillInfoResponse> protoAdapter = new ProtoAdapter<GetApplicationPrefillInfoResponse>(c.LENGTH_DELIMITED, e0.b(GetApplicationPrefillInfoResponse.class), "type.googleapis.com/coinbase.public_api.authed.card.GetApplicationPrefillInfoResponse") { // from class: com.coinbase.android.apiv3.generated.authed.card.GetApplicationPrefillInfoResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetApplicationPrefillInfoResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                ApplicationInfo applicationInfo = null;
                String str = "";
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetApplicationPrefillInfoResponse(applicationInfo, str, reader.e(d2));
                    }
                    if (g2 == 1) {
                        applicationInfo = ApplicationInfo.ADAPTER.decode(reader);
                    } else if (g2 != 2) {
                        reader.m(g2);
                    } else {
                        str = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetApplicationPrefillInfoResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getApplication_info() != null) {
                    ApplicationInfo.ADAPTER.encodeWithTag(writer, 1, value.getApplication_info());
                }
                if (!m.c(value.getCardholder_agreement_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getCardholder_agreement_url());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetApplicationPrefillInfoResponse value) {
                m.h(value, "value");
                if (value.getApplication_info() == null) {
                    return 0;
                }
                return (m.c(value.getCardholder_agreement_url(), "") ? 0 : ProtoAdapter.STRING.encodedSizeWithTag(2, value.getCardholder_agreement_url()) + value.unknownFields().Q()) + ApplicationInfo.ADAPTER.encodedSizeWithTag(1, value.getApplication_info());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetApplicationPrefillInfoResponse redact(GetApplicationPrefillInfoResponse value) {
                m.h(value, "value");
                ApplicationInfo application_info = value.getApplication_info();
                return GetApplicationPrefillInfoResponse.copy$default(value, application_info != null ? ApplicationInfo.ADAPTER.redact(application_info) : null, null, i.a, 2, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetApplicationPrefillInfoResponse() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ GetApplicationPrefillInfoResponse(ApplicationInfo applicationInfo, String str, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : applicationInfo, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetApplicationPrefillInfoResponse copy$default(GetApplicationPrefillInfoResponse getApplicationPrefillInfoResponse, ApplicationInfo applicationInfo, String str, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            applicationInfo = getApplicationPrefillInfoResponse.application_info;
        }
        if ((i2 & 2) != 0) {
            str = getApplicationPrefillInfoResponse.cardholder_agreement_url;
        }
        if ((i2 & 4) != 0) {
            iVar = getApplicationPrefillInfoResponse.unknownFields();
        }
        return getApplicationPrefillInfoResponse.copy(applicationInfo, str, iVar);
    }

    public final GetApplicationPrefillInfoResponse copy(ApplicationInfo applicationInfo, String cardholder_agreement_url, i unknownFields) {
        m.h(cardholder_agreement_url, "cardholder_agreement_url");
        m.h(unknownFields, "unknownFields");
        return new GetApplicationPrefillInfoResponse(applicationInfo, cardholder_agreement_url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetApplicationPrefillInfoResponse) {
            GetApplicationPrefillInfoResponse getApplicationPrefillInfoResponse = (GetApplicationPrefillInfoResponse) obj;
            return m.c(unknownFields(), getApplicationPrefillInfoResponse.unknownFields()) && m.c(this.application_info, getApplicationPrefillInfoResponse.application_info) && m.c(this.cardholder_agreement_url, getApplicationPrefillInfoResponse.cardholder_agreement_url);
        }
        return false;
    }

    public final ApplicationInfo getApplication_info() {
        return this.application_info;
    }

    public final String getCardholder_agreement_url() {
        return this.cardholder_agreement_url;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            ApplicationInfo applicationInfo = this.application_info;
            int hashCode2 = ((hashCode + (applicationInfo != null ? applicationInfo.hashCode() : 0)) * 37) + this.cardholder_agreement_url.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m299newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (this.application_info != null) {
            arrayList.add("application_info=" + this.application_info);
        }
        arrayList.add("cardholder_agreement_url=" + b.c(this.cardholder_agreement_url));
        h0 = z.h0(arrayList, ", ", "GetApplicationPrefillInfoResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetApplicationPrefillInfoResponse(ApplicationInfo applicationInfo, String cardholder_agreement_url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(cardholder_agreement_url, "cardholder_agreement_url");
        m.h(unknownFields, "unknownFields");
        this.application_info = applicationInfo;
        this.cardholder_agreement_url = cardholder_agreement_url;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m299newBuilder() {
        throw new AssertionError();
    }
}