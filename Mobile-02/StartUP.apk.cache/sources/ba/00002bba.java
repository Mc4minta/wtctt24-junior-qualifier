package com.coinbase.walletlink.dtos;

import android.net.Uri;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Web3RequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081\b\u0018\u0000 !*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001!B%\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006\""}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3RequestDTO;", "T", "", "", "component1", "()Ljava/lang/String;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "Lcom/coinbase/walletlink/dtos/Web3Request;", "component3", "()Lcom/coinbase/walletlink/dtos/Web3Request;", "id", "origin", "request", "copy", "(Ljava/lang/String;Landroid/net/Uri;Lcom/coinbase/walletlink/dtos/Web3Request;)Lcom/coinbase/walletlink/dtos/Web3RequestDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/walletlink/dtos/Web3Request;", "getRequest", "Ljava/lang/String;", "getId", "Landroid/net/Uri;", "getOrigin", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Lcom/coinbase/walletlink/dtos/Web3Request;)V", "Companion", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3RequestDTO<T> {
    public static final Companion Companion = new Companion(null);
    private final String id;
    private final Uri origin;
    private final Web3Request<T> request;

    /* compiled from: Web3RequestDTO.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3RequestDTO$Companion;", "", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Web3RequestDTO(String id, Uri origin, Web3Request<T> request) {
        m.g(id, "id");
        m.g(origin, "origin");
        m.g(request, "request");
        this.id = id;
        this.origin = origin;
        this.request = request;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Web3RequestDTO copy$default(Web3RequestDTO web3RequestDTO, String str, Uri uri, Web3Request web3Request, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = web3RequestDTO.id;
        }
        if ((i2 & 2) != 0) {
            uri = web3RequestDTO.origin;
        }
        if ((i2 & 4) != 0) {
            web3Request = web3RequestDTO.request;
        }
        return web3RequestDTO.copy(str, uri, web3Request);
    }

    public final String component1() {
        return this.id;
    }

    public final Uri component2() {
        return this.origin;
    }

    public final Web3Request<T> component3() {
        return this.request;
    }

    public final Web3RequestDTO<T> copy(String id, Uri origin, Web3Request<T> request) {
        m.g(id, "id");
        m.g(origin, "origin");
        m.g(request, "request");
        return new Web3RequestDTO<>(id, origin, request);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Web3RequestDTO) {
            Web3RequestDTO web3RequestDTO = (Web3RequestDTO) obj;
            return m.c(this.id, web3RequestDTO.id) && m.c(this.origin, web3RequestDTO.origin) && m.c(this.request, web3RequestDTO.request);
        }
        return false;
    }

    public final String getId() {
        return this.id;
    }

    public final Uri getOrigin() {
        return this.origin;
    }

    public final Web3Request<T> getRequest() {
        return this.request;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.origin.hashCode()) * 31) + this.request.hashCode();
    }

    public String toString() {
        return "Web3RequestDTO(id=" + this.id + ", origin=" + this.origin + ", request=" + this.request + ')';
    }
}