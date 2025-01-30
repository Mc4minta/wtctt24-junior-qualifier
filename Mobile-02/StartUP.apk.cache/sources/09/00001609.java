package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Secure3DVerificationDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/Secure3DPayloadDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", ApiConstants.NAME, "value", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/Secure3DPayloadDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValue", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Secure3DPayloadDTO {
    private final String name;
    private final String value;

    public Secure3DPayloadDTO(String name, String value) {
        m.g(name, "name");
        m.g(value, "value");
        this.name = name;
        this.value = value;
    }

    public static /* synthetic */ Secure3DPayloadDTO copy$default(Secure3DPayloadDTO secure3DPayloadDTO, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = secure3DPayloadDTO.name;
        }
        if ((i2 & 2) != 0) {
            str2 = secure3DPayloadDTO.value;
        }
        return secure3DPayloadDTO.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.value;
    }

    public final Secure3DPayloadDTO copy(String name, String value) {
        m.g(name, "name");
        m.g(value, "value");
        return new Secure3DPayloadDTO(name, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Secure3DPayloadDTO) {
            Secure3DPayloadDTO secure3DPayloadDTO = (Secure3DPayloadDTO) obj;
            return m.c(this.name, secure3DPayloadDTO.name) && m.c(this.value, secure3DPayloadDTO.value);
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "Secure3DPayloadDTO(name=" + this.name + ", value=" + this.value + ')';
    }
}