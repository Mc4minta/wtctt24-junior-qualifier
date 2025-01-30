package com.coinbase.walletengine.services.example;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: ExampleService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/walletengine/services/example/MetaData;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()[B", "type", "data", "copy", "(Ljava/lang/String;[B)Lcom/coinbase/walletengine/services/example/MetaData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "[B", "getData", "Ljava/lang/String;", "getType", "<init>", "(Ljava/lang/String;[B)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class MetaData {
    @Json(name = "data")
    private final byte[] data;
    @Json(name = "type")
    private final String type;

    public MetaData(String type, byte[] data) {
        kotlin.jvm.internal.m.g(type, "type");
        kotlin.jvm.internal.m.g(data, "data");
        this.type = type;
        this.data = data;
    }

    public static /* synthetic */ MetaData copy$default(MetaData metaData, String str, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = metaData.type;
        }
        if ((i2 & 2) != 0) {
            bArr = metaData.data;
        }
        return metaData.copy(str, bArr);
    }

    public final String component1() {
        return this.type;
    }

    public final byte[] component2() {
        return this.data;
    }

    public final MetaData copy(String type, byte[] data) {
        kotlin.jvm.internal.m.g(type, "type");
        kotlin.jvm.internal.m.g(data, "data");
        return new MetaData(type, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MetaData) {
            MetaData metaData = (MetaData) obj;
            return kotlin.jvm.internal.m.c(this.type, metaData.type) && kotlin.jvm.internal.m.c(this.data, metaData.data);
        }
        return false;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + Arrays.hashCode(this.data);
    }

    public String toString() {
        return "MetaData(type=" + this.type + ", data=" + Arrays.toString(this.data) + ')';
    }
}