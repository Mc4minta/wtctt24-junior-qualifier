package com.coinbase.wallet.wallets.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: FiatCurrency.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B/\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b(\u0010)B!\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b(\u0010*J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0003\u0010\u0014\u001a\u00020\u000e2\b\b\u0003\u0010\u0015\u001a\u00020\u000b2\b\b\u0003\u0010\u0016\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\rJ\u0010\u0010\u001a\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0014\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\rR\u001c\u0010\u0016\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\nR\u001c\u0010\u0013\u001a\u00020\u000b8\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b'\u0010\r¨\u0006,"}, d2 = {"Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component2", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "component3", "component4", "id", "code", ApiConstants.NAME, "decimals", "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "toString", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCode", "Ljava/lang/String;", "getName", "I", "getDecimals", "getId", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)V", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;I)V", "Companion", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FiatCurrency implements DatabaseModelObject, Parcelable {
    private final CurrencyCode code;
    private final int decimals;
    private final String id;
    private final String name;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<FiatCurrency> CREATOR = new Creator();
    private static final FiatCurrency USD = new FiatCurrency(CurrencyCode.Companion.getUSD(), "United States Dollar", 2);

    /* compiled from: FiatCurrency.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/wallets/models/FiatCurrency$Companion;", "", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "USD", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "getUSD", "()Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FiatCurrency getUSD() {
            return FiatCurrency.USD;
        }
    }

    /* compiled from: FiatCurrency.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<FiatCurrency> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FiatCurrency createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new FiatCurrency(parcel.readString(), (CurrencyCode) parcel.readParcelable(FiatCurrency.class.getClassLoader()), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FiatCurrency[] newArray(int i2) {
            return new FiatCurrency[i2];
        }
    }

    public FiatCurrency(String id, @Json(name = "code") CurrencyCode code, @Json(name = "name") String name, @Json(name = "decimals") int i2) {
        m.g(id, "id");
        m.g(code, "code");
        m.g(name, "name");
        this.id = id;
        this.code = code;
        this.name = name;
        this.decimals = i2;
    }

    public static /* synthetic */ FiatCurrency copy$default(FiatCurrency fiatCurrency, String str, CurrencyCode currencyCode, String str2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = fiatCurrency.getId();
        }
        if ((i3 & 2) != 0) {
            currencyCode = fiatCurrency.code;
        }
        if ((i3 & 4) != 0) {
            str2 = fiatCurrency.name;
        }
        if ((i3 & 8) != 0) {
            i2 = fiatCurrency.decimals;
        }
        return fiatCurrency.copy(str, currencyCode, str2, i2);
    }

    public final String component1() {
        return getId();
    }

    public final CurrencyCode component2() {
        return this.code;
    }

    public final String component3() {
        return this.name;
    }

    public final int component4() {
        return this.decimals;
    }

    public final FiatCurrency copy(String id, @Json(name = "code") CurrencyCode code, @Json(name = "name") String name, @Json(name = "decimals") int i2) {
        m.g(id, "id");
        m.g(code, "code");
        m.g(name, "name");
        return new FiatCurrency(id, code, name, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String id = getId();
        FiatCurrency fiatCurrency = obj instanceof FiatCurrency ? (FiatCurrency) obj : null;
        return m.c(id, fiatCurrency != null ? fiatCurrency.getId() : null);
    }

    public final CurrencyCode getCode() {
        return this.code;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public String toString() {
        return "FiatCurrency(id=" + getId() + ", code=" + this.code + ", name=" + this.name + ", decimals=" + this.decimals + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.id);
        out.writeParcelable(this.code, i2);
        out.writeString(this.name);
        out.writeInt(this.decimals);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FiatCurrency(CurrencyCode code, String name, int i2) {
        this(code.getRawValue(), code, name, i2);
        m.g(code, "code");
        m.g(name, "name");
    }
}