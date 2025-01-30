package com.coinbase.wallet.consumer.dtos;

import com.coinbase.wallet.consumer.exceptions.ConsumerException;
import com.coinbase.wallet.consumer.models.Secure3DVerification;
import com.squareup.moshi.JsonClass;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Secure3DVerificationDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "", "Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "toSecure3DVerification", "()Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "", "component1", "()Ljava/lang/String;", "", "Lcom/coinbase/wallet/consumer/dtos/Secure3DPayloadDTO;", "component2", "()Ljava/util/List;", "url", "payload", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/coinbase/wallet/consumer/dtos/Secure3DVerificationDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPayload", "Ljava/lang/String;", "getUrl", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Secure3DVerificationDTO {
    private final List<Secure3DPayloadDTO> payload;
    private final String url;

    public Secure3DVerificationDTO(String url, List<Secure3DPayloadDTO> payload) {
        m.g(url, "url");
        m.g(payload, "payload");
        this.url = url;
        this.payload = payload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Secure3DVerificationDTO copy$default(Secure3DVerificationDTO secure3DVerificationDTO, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = secure3DVerificationDTO.url;
        }
        if ((i2 & 2) != 0) {
            list = secure3DVerificationDTO.payload;
        }
        return secure3DVerificationDTO.copy(str, list);
    }

    public final String component1() {
        return this.url;
    }

    public final List<Secure3DPayloadDTO> component2() {
        return this.payload;
    }

    public final Secure3DVerificationDTO copy(String url, List<Secure3DPayloadDTO> payload) {
        m.g(url, "url");
        m.g(payload, "payload");
        return new Secure3DVerificationDTO(url, payload);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Secure3DVerificationDTO) {
            Secure3DVerificationDTO secure3DVerificationDTO = (Secure3DVerificationDTO) obj;
            return m.c(this.url, secure3DVerificationDTO.url) && m.c(this.payload, secure3DVerificationDTO.payload);
        }
        return false;
    }

    public final List<Secure3DPayloadDTO> getPayload() {
        return this.payload;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.payload.hashCode();
    }

    public final Secure3DVerification toSecure3DVerification() {
        Object obj;
        Object obj2;
        Iterator<T> it = this.payload.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (m.c(((Secure3DPayloadDTO) obj2).getName(), "PaReq")) {
                break;
            }
        }
        Secure3DPayloadDTO secure3DPayloadDTO = (Secure3DPayloadDTO) obj2;
        if (secure3DPayloadDTO != null) {
            String value = secure3DPayloadDTO.getValue();
            Iterator<T> it2 = this.payload.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (m.c(((Secure3DPayloadDTO) next).getName(), "TermUrl")) {
                    obj = next;
                    break;
                }
            }
            Secure3DPayloadDTO secure3DPayloadDTO2 = (Secure3DPayloadDTO) obj;
            if (secure3DPayloadDTO2 != null) {
                return new Secure3DVerification(this.url, value, secure3DPayloadDTO2.getValue());
            }
            throw new ConsumerException.ApiParseException("Couldn't find TermUrl");
        }
        throw new ConsumerException.ApiParseException("Couldn't find PaReq");
    }

    public String toString() {
        return "Secure3DVerificationDTO(url=" + this.url + ", payload=" + this.payload + ')';
    }
}