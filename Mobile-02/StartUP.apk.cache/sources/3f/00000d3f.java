package com.coinbase.android.apiv3.generated.authed.loyalty;

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

/* compiled from: LoyaltyCardDetail.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B;\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\"\u0010\u000f¨\u0006&"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetail;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetailStyle;", "style", "label", "value", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTicker;", "ticker_value", "Lj/i;", "unknownFields", "copy", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetailStyle;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTicker;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetail;", "Ljava/lang/String;", "getLabel", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTicker;", "getTicker_value", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTicker;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetailStyle;", "getStyle", "()Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetailStyle;", "getValue", "<init>", "(Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetailStyle;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyTicker;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class LoyaltyCardDetail extends a {
    public static final ProtoAdapter<LoyaltyCardDetail> ADAPTER;
    public static final Parcelable.Creator<LoyaltyCardDetail> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    private final String label;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardDetailStyle#ADAPTER", tag = 1)
    private final LoyaltyCardDetailStyle style;
    @p(adapter = "com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyTicker#ADAPTER", jsonName = "tickerValue", tag = 4)
    private final LoyaltyTicker ticker_value;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    private final String value;

    /* compiled from: LoyaltyCardDetail.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetail$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loyalty/LoyaltyCardDetail;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<LoyaltyCardDetail> protoAdapter = new ProtoAdapter<LoyaltyCardDetail>(c.LENGTH_DELIMITED, e0.b(LoyaltyCardDetail.class), "type.googleapis.com/coinbase.public_api.authed.loyalty.LoyaltyCardDetail") { // from class: com.coinbase.android.apiv3.generated.authed.loyalty.LoyaltyCardDetail$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCardDetail decode(k reader) {
                m.h(reader, "reader");
                LoyaltyCardDetailStyle loyaltyCardDetailStyle = LoyaltyCardDetailStyle.STATISTIC;
                long d2 = reader.d();
                LoyaltyCardDetailStyle loyaltyCardDetailStyle2 = loyaltyCardDetailStyle;
                String str = "";
                String str2 = str;
                LoyaltyTicker loyaltyTicker = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new LoyaltyCardDetail(loyaltyCardDetailStyle2, str, str2, loyaltyTicker, reader.e(d2));
                    }
                    if (g2 == 1) {
                        try {
                            loyaltyCardDetailStyle2 = LoyaltyCardDetailStyle.ADAPTER.decode(reader);
                        } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                            reader.a(g2, c.VARINT, Long.valueOf(e2.a));
                        }
                    } else if (g2 == 2) {
                        str = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 == 3) {
                        str2 = ProtoAdapter.STRING.decode(reader);
                    } else if (g2 != 4) {
                        reader.m(g2);
                    } else {
                        loyaltyTicker = LoyaltyTicker.ADAPTER.decode(reader);
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, LoyaltyCardDetail value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (value.getStyle() != LoyaltyCardDetailStyle.STATISTIC) {
                    LoyaltyCardDetailStyle.ADAPTER.encodeWithTag(writer, 1, value.getStyle());
                }
                if (!m.c(value.getLabel(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getLabel());
                }
                if (!m.c(value.getValue(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getValue());
                }
                if (value.getTicker_value() != null) {
                    LoyaltyTicker.ADAPTER.encodeWithTag(writer, 4, value.getTicker_value());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(LoyaltyCardDetail value) {
                m.h(value, "value");
                if (value.getStyle() == LoyaltyCardDetailStyle.STATISTIC) {
                    return 0;
                }
                int encodedSizeWithTag = LoyaltyCardDetailStyle.ADAPTER.encodedSizeWithTag(1, value.getStyle());
                if (!m.c(value.getLabel(), "")) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getLabel());
                    if (!m.c(value.getValue(), "")) {
                        r2 = (value.getTicker_value() != null ? LoyaltyTicker.ADAPTER.encodedSizeWithTag(4, value.getTicker_value()) + value.unknownFields().Q() : 0) + protoAdapter2.encodedSizeWithTag(3, value.getValue());
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public LoyaltyCardDetail redact(LoyaltyCardDetail value) {
                m.h(value, "value");
                LoyaltyTicker ticker_value = value.getTicker_value();
                return LoyaltyCardDetail.copy$default(value, null, null, null, ticker_value != null ? LoyaltyTicker.ADAPTER.redact(ticker_value) : null, i.a, 7, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public LoyaltyCardDetail() {
        this(null, null, null, null, null, 31, null);
    }

    public /* synthetic */ LoyaltyCardDetail(LoyaltyCardDetailStyle loyaltyCardDetailStyle, String str, String str2, LoyaltyTicker loyaltyTicker, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? LoyaltyCardDetailStyle.STATISTIC : loyaltyCardDetailStyle, (i2 & 2) != 0 ? "" : str, (i2 & 4) == 0 ? str2 : "", (i2 & 8) != 0 ? null : loyaltyTicker, (i2 & 16) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ LoyaltyCardDetail copy$default(LoyaltyCardDetail loyaltyCardDetail, LoyaltyCardDetailStyle loyaltyCardDetailStyle, String str, String str2, LoyaltyTicker loyaltyTicker, i iVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            loyaltyCardDetailStyle = loyaltyCardDetail.style;
        }
        if ((i2 & 2) != 0) {
            str = loyaltyCardDetail.label;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = loyaltyCardDetail.value;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            loyaltyTicker = loyaltyCardDetail.ticker_value;
        }
        LoyaltyTicker loyaltyTicker2 = loyaltyTicker;
        if ((i2 & 16) != 0) {
            iVar = loyaltyCardDetail.unknownFields();
        }
        return loyaltyCardDetail.copy(loyaltyCardDetailStyle, str3, str4, loyaltyTicker2, iVar);
    }

    public final LoyaltyCardDetail copy(LoyaltyCardDetailStyle style, String label, String value, LoyaltyTicker loyaltyTicker, i unknownFields) {
        m.h(style, "style");
        m.h(label, "label");
        m.h(value, "value");
        m.h(unknownFields, "unknownFields");
        return new LoyaltyCardDetail(style, label, value, loyaltyTicker, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoyaltyCardDetail) {
            LoyaltyCardDetail loyaltyCardDetail = (LoyaltyCardDetail) obj;
            return m.c(unknownFields(), loyaltyCardDetail.unknownFields()) && this.style == loyaltyCardDetail.style && m.c(this.label, loyaltyCardDetail.label) && m.c(this.value, loyaltyCardDetail.value) && m.c(this.ticker_value, loyaltyCardDetail.ticker_value);
        }
        return false;
    }

    public final String getLabel() {
        return this.label;
    }

    public final LoyaltyCardDetailStyle getStyle() {
        return this.style;
    }

    public final LoyaltyTicker getTicker_value() {
        return this.ticker_value;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + this.style.hashCode()) * 37) + this.label.hashCode()) * 37) + this.value.hashCode()) * 37;
            LoyaltyTicker loyaltyTicker = this.ticker_value;
            int hashCode2 = hashCode + (loyaltyTicker != null ? loyaltyTicker.hashCode() : 0);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m411newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("style=" + this.style);
        arrayList.add("label=" + b.c(this.label));
        arrayList.add("value=" + b.c(this.value));
        if (this.ticker_value != null) {
            arrayList.add("ticker_value=" + this.ticker_value);
        }
        h0 = z.h0(arrayList, ", ", "LoyaltyCardDetail{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m411newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoyaltyCardDetail(LoyaltyCardDetailStyle style, String label, String value, LoyaltyTicker loyaltyTicker, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(style, "style");
        m.h(label, "label");
        m.h(value, "value");
        m.h(unknownFields, "unknownFields");
        this.style = style;
        this.label = label;
        this.value = value;
        this.ticker_value = loyaltyTicker;
    }
}