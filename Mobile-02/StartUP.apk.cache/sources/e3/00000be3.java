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

/* compiled from: GetCardSummaryResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJI\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0011\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b \u0010\u001b¨\u0006$"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetCardSummaryResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "last_four_digits", "locked", "activated", "card_details_webview_url", "support_url", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/card/GetCardSummaryResponse;", "Z", "getLocked", "()Z", "Ljava/lang/String;", "getSupport_url", "getCard_details_webview_url", "getLast_four_digits", "getActivated", "<init>", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetCardSummaryResponse extends a {
    public static final ProtoAdapter<GetCardSummaryResponse> ADAPTER;
    public static final Parcelable.Creator<GetCardSummaryResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    private final boolean activated;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "cardDetailsWebviewUrl", tag = 4)
    private final String card_details_webview_url;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "lastFourDigits", tag = 1)
    private final String last_four_digits;
    @p(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    private final boolean locked;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "supportUrl", tag = 5)
    private final String support_url;

    /* compiled from: GetCardSummaryResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/card/GetCardSummaryResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/card/GetCardSummaryResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetCardSummaryResponse> protoAdapter = new ProtoAdapter<GetCardSummaryResponse>(c.LENGTH_DELIMITED, e0.b(GetCardSummaryResponse.class), "type.googleapis.com/coinbase.public_api.authed.card.GetCardSummaryResponse") { // from class: com.coinbase.android.apiv3.generated.authed.card.GetCardSummaryResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetCardSummaryResponse decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                boolean z = false;
                boolean z2 = false;
                String str = "";
                String str2 = str;
                String str3 = str2;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetCardSummaryResponse(str, z, z2, str2, str3, reader.e(d2));
                    }
                    if (g2 == 1) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 2) {
                        z = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    } else if (g2 == 3) {
                        z2 = ProtoAdapter.BOOL.decode(reader).booleanValue();
                    } else if (g2 == 4) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 5) {
                        reader.m(g2);
                    } else {
                        str3 = ProtoAdapter.STRING.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetCardSummaryResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getLast_four_digits(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getLast_four_digits());
                }
                if (value.getLocked()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 2, Boolean.valueOf(value.getLocked()));
                }
                if (value.getActivated()) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 3, Boolean.valueOf(value.getActivated()));
                }
                if (!m.c(value.getCard_details_webview_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getCard_details_webview_url());
                }
                if (!m.c(value.getSupport_url(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getSupport_url());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetCardSummaryResponse value) {
                m.h(value, "value");
                if (m.c(value.getLast_four_digits(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getLast_four_digits());
                if (value.getLocked()) {
                    ProtoAdapter<Boolean> protoAdapter3 = ProtoAdapter.BOOL;
                    int encodedSizeWithTag2 = protoAdapter3.encodedSizeWithTag(2, Boolean.valueOf(value.getLocked()));
                    if (value.getActivated()) {
                        int encodedSizeWithTag3 = protoAdapter3.encodedSizeWithTag(3, Boolean.valueOf(value.getActivated()));
                        if (!m.c(value.getCard_details_webview_url(), "")) {
                            r2 = (m.c(value.getSupport_url(), "") ? 0 : protoAdapter2.encodedSizeWithTag(5, value.getSupport_url()) + value.unknownFields().Q()) + protoAdapter2.encodedSizeWithTag(4, value.getCard_details_webview_url());
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetCardSummaryResponse redact(GetCardSummaryResponse value) {
                m.h(value, "value");
                return GetCardSummaryResponse.copy$default(value, null, false, false, null, null, i.a, 31, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetCardSummaryResponse() {
        this(null, false, false, null, null, null, 63, null);
    }

    public /* synthetic */ GetCardSummaryResponse(String str, boolean z, boolean z2, String str2, String str3, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? false : z, (i2 & 4) == 0 ? z2 : false, (i2 & 8) != 0 ? "" : str2, (i2 & 16) == 0 ? str3 : "", (i2 & 32) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ GetCardSummaryResponse copy$default(GetCardSummaryResponse getCardSummaryResponse, String str, boolean z, boolean z2, String str2, String str3, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getCardSummaryResponse.last_four_digits;
        }
        if ((i2 & 2) != 0) {
            z = getCardSummaryResponse.locked;
        }
        boolean z3 = z;
        if ((i2 & 4) != 0) {
            z2 = getCardSummaryResponse.activated;
        }
        boolean z4 = z2;
        if ((i2 & 8) != 0) {
            str2 = getCardSummaryResponse.card_details_webview_url;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            str3 = getCardSummaryResponse.support_url;
        }
        String str5 = str3;
        if ((i2 & 32) != 0) {
            iVar = getCardSummaryResponse.unknownFields();
        }
        return getCardSummaryResponse.copy(str, z3, z4, str4, str5, iVar);
    }

    public final GetCardSummaryResponse copy(String last_four_digits, boolean z, boolean z2, String card_details_webview_url, String support_url, i unknownFields) {
        m.h(last_four_digits, "last_four_digits");
        m.h(card_details_webview_url, "card_details_webview_url");
        m.h(support_url, "support_url");
        m.h(unknownFields, "unknownFields");
        return new GetCardSummaryResponse(last_four_digits, z, z2, card_details_webview_url, support_url, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetCardSummaryResponse) {
            GetCardSummaryResponse getCardSummaryResponse = (GetCardSummaryResponse) obj;
            return m.c(unknownFields(), getCardSummaryResponse.unknownFields()) && m.c(this.last_four_digits, getCardSummaryResponse.last_four_digits) && this.locked == getCardSummaryResponse.locked && this.activated == getCardSummaryResponse.activated && m.c(this.card_details_webview_url, getCardSummaryResponse.card_details_webview_url) && m.c(this.support_url, getCardSummaryResponse.support_url);
        }
        return false;
    }

    public final boolean getActivated() {
        return this.activated;
    }

    public final String getCard_details_webview_url() {
        return this.card_details_webview_url;
    }

    public final String getLast_four_digits() {
        return this.last_four_digits;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final String getSupport_url() {
        return this.support_url;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = (((((((((unknownFields().hashCode() * 37) + this.last_four_digits.hashCode()) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.locked)) * 37) + com.coinbase.android.apiv3.generated.authed.a.a(this.activated)) * 37) + this.card_details_webview_url.hashCode()) * 37) + this.support_url.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m307newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("last_four_digits=" + b.c(this.last_four_digits));
        arrayList.add("locked=" + this.locked);
        arrayList.add("activated=" + this.activated);
        arrayList.add("card_details_webview_url=" + b.c(this.card_details_webview_url));
        arrayList.add("support_url=" + b.c(this.support_url));
        h0 = z.h0(arrayList, ", ", "GetCardSummaryResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetCardSummaryResponse(String last_four_digits, boolean z, boolean z2, String card_details_webview_url, String support_url, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(last_four_digits, "last_four_digits");
        m.h(card_details_webview_url, "card_details_webview_url");
        m.h(support_url, "support_url");
        m.h(unknownFields, "unknownFields");
        this.last_four_digits = last_four_digits;
        this.locked = z;
        this.activated = z2;
        this.card_details_webview_url = card_details_webview_url;
        this.support_url = support_url;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m307newBuilder() {
        throw new AssertionError();
    }
}