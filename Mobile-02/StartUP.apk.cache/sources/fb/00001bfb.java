package com.coinbase.wallet.ethereum.dtos;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ERC20IconDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/ERC20IconDTO;", "", "", "component1", "()I", "component2", "", "component3", "()Ljava/lang/String;", "width", "height", "url", "copy", "(IILjava/lang/String;)Lcom/coinbase/wallet/ethereum/dtos/ERC20IconDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getHeight", "getWidth", "Ljava/lang/String;", "getUrl", "<init>", "(IILjava/lang/String;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ERC20IconDTO {
    private final int height;
    private final String url;
    private final int width;

    public ERC20IconDTO(@Json(name = "width") int i2, @Json(name = "height") int i3, @Json(name = "url") String url) {
        m.g(url, "url");
        this.width = i2;
        this.height = i3;
        this.url = url;
    }

    public static /* synthetic */ ERC20IconDTO copy$default(ERC20IconDTO eRC20IconDTO, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = eRC20IconDTO.width;
        }
        if ((i4 & 2) != 0) {
            i3 = eRC20IconDTO.height;
        }
        if ((i4 & 4) != 0) {
            str = eRC20IconDTO.url;
        }
        return eRC20IconDTO.copy(i2, i3, str);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final String component3() {
        return this.url;
    }

    public final ERC20IconDTO copy(@Json(name = "width") int i2, @Json(name = "height") int i3, @Json(name = "url") String url) {
        m.g(url, "url");
        return new ERC20IconDTO(i2, i3, url);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ERC20IconDTO) {
            ERC20IconDTO eRC20IconDTO = (ERC20IconDTO) obj;
            return this.width == eRC20IconDTO.width && this.height == eRC20IconDTO.height && m.c(this.url, eRC20IconDTO.url);
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((this.width * 31) + this.height) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "ERC20IconDTO(width=" + this.width + ", height=" + this.height + ", url=" + this.url + ')';
    }
}