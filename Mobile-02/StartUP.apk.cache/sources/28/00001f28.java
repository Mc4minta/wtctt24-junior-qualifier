package com.coinbase.wallet.features.ofac.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GeoAvailabilityDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/features/ofac/dtos/GeoAvailabilityDTO;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "country", "permitted", "copy", "(Ljava/lang/String;Z)Lcom/coinbase/wallet/features/ofac/dtos/GeoAvailabilityDTO;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPermitted", "Ljava/lang/String;", "getCountry", "<init>", "(Ljava/lang/String;Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GeoAvailabilityDTO {
    private final String country;
    private final boolean permitted;

    public GeoAvailabilityDTO(String country, boolean z) {
        m.g(country, "country");
        this.country = country;
        this.permitted = z;
    }

    public static /* synthetic */ GeoAvailabilityDTO copy$default(GeoAvailabilityDTO geoAvailabilityDTO, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = geoAvailabilityDTO.country;
        }
        if ((i2 & 2) != 0) {
            z = geoAvailabilityDTO.permitted;
        }
        return geoAvailabilityDTO.copy(str, z);
    }

    public final String component1() {
        return this.country;
    }

    public final boolean component2() {
        return this.permitted;
    }

    public final GeoAvailabilityDTO copy(String country, boolean z) {
        m.g(country, "country");
        return new GeoAvailabilityDTO(country, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GeoAvailabilityDTO) {
            GeoAvailabilityDTO geoAvailabilityDTO = (GeoAvailabilityDTO) obj;
            return m.c(this.country, geoAvailabilityDTO.country) && this.permitted == geoAvailabilityDTO.permitted;
        }
        return false;
    }

    public final String getCountry() {
        return this.country;
    }

    public final boolean getPermitted() {
        return this.permitted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.country.hashCode() * 31;
        boolean z = this.permitted;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public String toString() {
        return "GeoAvailabilityDTO(country=" + this.country + ", permitted=" + this.permitted + ')';
    }
}