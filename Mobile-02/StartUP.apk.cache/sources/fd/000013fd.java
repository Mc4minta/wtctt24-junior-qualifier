package com.coinbase.wallet.blockchains.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CurrencyCode.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\fR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "code", "Ljava/lang/String;", "getCode", "rawValue", "getRawValue", "<init>", "(Ljava/lang/String;)V", "Companion", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CurrencyCode implements Parcelable {
    private static final CurrencyCode CAD;
    private static final CurrencyCode CNY;
    public static final Parcelable.Creator<CurrencyCode> CREATOR;
    public static final Companion Companion = new Companion(null);
    private static final CurrencyCode EUR;
    private static final CurrencyCode GBP;
    private static final CurrencyCode RUB;
    private static final CurrencyCode USD;
    private static final CurrencyCode USDC;
    private static final List<CurrencyCode> topFiatCurrencies;
    private final String code;
    private final String rawValue;

    /* compiled from: CurrencyCode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u0019\u0010\u0014\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00188\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/CurrencyCode$Companion;", "", "", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "topFiatCurrencies", "Ljava/util/List;", "getTopFiatCurrencies", "()Ljava/util/List;", "CAD", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCAD", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "USD", "getUSD", "GBP", "getGBP", "EUR", "getEUR", "CNY", "getCNY", "USDC", "getUSDC", "RUB", "getRUB", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CurrencyCode getCAD() {
            return CurrencyCode.CAD;
        }

        public final CurrencyCode getCNY() {
            return CurrencyCode.CNY;
        }

        public final CurrencyCode getEUR() {
            return CurrencyCode.EUR;
        }

        public final CurrencyCode getGBP() {
            return CurrencyCode.GBP;
        }

        public final CurrencyCode getRUB() {
            return CurrencyCode.RUB;
        }

        public final List<CurrencyCode> getTopFiatCurrencies() {
            return CurrencyCode.topFiatCurrencies;
        }

        public final CurrencyCode getUSD() {
            return CurrencyCode.USD;
        }

        public final CurrencyCode getUSDC() {
            return CurrencyCode.USDC;
        }
    }

    static {
        CurrencyCode currencyCode = new CurrencyCode("USD");
        USD = currencyCode;
        CurrencyCode currencyCode2 = new CurrencyCode("EUR");
        EUR = currencyCode2;
        CurrencyCode currencyCode3 = new CurrencyCode("CNY");
        CNY = currencyCode3;
        CurrencyCode currencyCode4 = new CurrencyCode("GBP");
        GBP = currencyCode4;
        CurrencyCode currencyCode5 = new CurrencyCode("CAD");
        CAD = currencyCode5;
        USDC = new CurrencyCode("USDC");
        RUB = new CurrencyCode("RUB");
        topFiatCurrencies = p.j(currencyCode, currencyCode2, currencyCode3, currencyCode4, currencyCode5);
        CREATOR = new Parcelable.Creator<CurrencyCode>() { // from class: com.coinbase.wallet.blockchains.models.CurrencyCode$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CurrencyCode createFromParcel(Parcel parcel) {
                m.g(parcel, "parcel");
                String readString = parcel.readString();
                if (readString == null) {
                    return null;
                }
                return new CurrencyCode(readString);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CurrencyCode[] newArray(int i2) {
                return new CurrencyCode[i2];
            }
        };
    }

    public CurrencyCode(String code) {
        m.g(code, "code");
        Locale US = Locale.US;
        m.f(US, "US");
        String upperCase = code.toUpperCase(US);
        m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        this.code = upperCase;
        this.rawValue = upperCase;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CurrencyCode) {
            return m.c(((CurrencyCode) obj).rawValue, this.rawValue);
        }
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public int hashCode() {
        return this.rawValue.hashCode();
    }

    public String toString() {
        return this.rawValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.rawValue);
    }
}