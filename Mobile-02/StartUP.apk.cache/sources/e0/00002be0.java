package com.coinbase.walletlink.models;

import com.coinbase.wallet.core.extensions.ByteArray_CoreKt;
import com.coinbase.wallet.crypto.extensions.String_CryptoKt;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.d;
import kotlin.u;

/* compiled from: Credentials.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR!\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/coinbase/walletlink/models/Credentials;", "", "", "", "getBasicAuthHeaders", "()Ljava/util/Map;", "basicAuthHeaders", "password", "Ljava/lang/String;", "getPassword", "()Ljava/lang/String;", "username", WalletLinkPushNotification.sessionIdKey, "secret", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Credentials {
    public static final Companion Companion = new Companion(null);
    private final String password;
    private final String username;

    /* compiled from: Credentials.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletlink/models/Credentials$Companion;", "", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Credentials(String sessionId, String secret) {
        m.g(sessionId, "sessionId");
        m.g(secret, "secret");
        this.username = sessionId;
        this.password = String_CryptoKt.sha256(sessionId + ", " + secret + " WalletLink");
    }

    public final Map<String, String> getBasicAuthHeaders() {
        Map<String, String> e2;
        String str = this.username + ':' + this.password;
        Charset charset = d.a;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        e2 = l0.e(u.a("Authorization", m.o("Basic ", ByteArray_CoreKt.base64EncodedString(bytes))));
        return e2;
    }

    public final String getPassword() {
        return this.password;
    }
}