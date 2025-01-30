package com.coinbase.walletlink.dtos;

import android.net.Uri;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.core.util.JSON;
import com.squareup.moshi.JsonClass;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import kotlin.l0.d;
import l.a.a;

/* compiled from: Web3RequestCanceledDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0081\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB!\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3RequestCanceledDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "Landroid/net/Uri;", "component3", "()Landroid/net/Uri;", "type", "id", "origin", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Lcom/coinbase/walletlink/dtos/Web3RequestCanceledDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Landroid/net/Uri;", "getOrigin", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "Companion", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3RequestCanceledDTO {
    public static final Companion Companion = new Companion(null);
    private final String id;
    private final Uri origin;
    private final String type;

    /* compiled from: Web3RequestCanceledDTO.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/walletlink/dtos/Web3RequestCanceledDTO$Companion;", "", "", "json", "Lcom/coinbase/walletlink/dtos/Web3RequestCanceledDTO;", "fromJson", "([B)Lcom/coinbase/walletlink/dtos/Web3RequestCanceledDTO;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Web3RequestCanceledDTO fromJson(byte[] json) {
            m.g(json, "json");
            JSON json2 = JSON.INSTANCE;
            String str = new String(json, d.a);
            ReentrantReadWriteLock.ReadLock readLock = json2.getMultiReadSingleWriteLock().readLock();
            readLock.lock();
            try {
                if (!(e0.b(Web3RequestCanceledDTO.class).getTypeParameters().isEmpty() ^ true ? false : true)) {
                    a.e(new AssertionException("Since " + ((Object) e0.b(Web3RequestCanceledDTO.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
                }
                Object fromJson = json2.getMoshi().adapter(Web3RequestCanceledDTO.class).fromJson(str);
                readLock.unlock();
                return (Web3RequestCanceledDTO) fromJson;
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        }
    }

    public Web3RequestCanceledDTO(String type, String id, Uri origin) {
        m.g(type, "type");
        m.g(id, "id");
        m.g(origin, "origin");
        this.type = type;
        this.id = id;
        this.origin = origin;
    }

    public static /* synthetic */ Web3RequestCanceledDTO copy$default(Web3RequestCanceledDTO web3RequestCanceledDTO, String str, String str2, Uri uri, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = web3RequestCanceledDTO.type;
        }
        if ((i2 & 2) != 0) {
            str2 = web3RequestCanceledDTO.id;
        }
        if ((i2 & 4) != 0) {
            uri = web3RequestCanceledDTO.origin;
        }
        return web3RequestCanceledDTO.copy(str, str2, uri);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.id;
    }

    public final Uri component3() {
        return this.origin;
    }

    public final Web3RequestCanceledDTO copy(String type, String id, Uri origin) {
        m.g(type, "type");
        m.g(id, "id");
        m.g(origin, "origin");
        return new Web3RequestCanceledDTO(type, id, origin);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Web3RequestCanceledDTO) {
            Web3RequestCanceledDTO web3RequestCanceledDTO = (Web3RequestCanceledDTO) obj;
            return m.c(this.type, web3RequestCanceledDTO.type) && m.c(this.id, web3RequestCanceledDTO.id) && m.c(this.origin, web3RequestCanceledDTO.origin);
        }
        return false;
    }

    public final String getId() {
        return this.id;
    }

    public final Uri getOrigin() {
        return this.origin;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.id.hashCode()) * 31) + this.origin.hashCode();
    }

    public String toString() {
        return "Web3RequestCanceledDTO(type=" + this.type + ", id=" + this.id + ", origin=" + this.origin + ')';
    }

    public /* synthetic */ Web3RequestCanceledDTO(String str, String str2, Uri uri, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "Web3RequestCanceled" : str, str2, uri);
    }
}