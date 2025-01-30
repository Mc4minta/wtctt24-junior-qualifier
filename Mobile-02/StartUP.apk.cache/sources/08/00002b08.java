package com.coinbase.walletengine.services.test;

import com.coinbase.ApiConstants;
import com.coinbase.walletengine.WalletEngine;
import com.squareup.moshi.Moshi;
import h.c.b0;
import h.c.m0.n;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.l0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: TestService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/coinbase/walletengine/services/test/TestService;", "", "", "method", "", "params", "Lh/c/b0;", "call", "(Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "T", "Ljava/lang/reflect/Type;", "type", "json", "decodeJson", "(Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object;", ApiConstants.MESSAGE, "echo", "(Ljava/lang/String;)Lh/c/b0;", "throwError", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lcom/coinbase/walletengine/WalletEngine;", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi$annotations", "()V", "<init>", "(Lcom/coinbase/walletengine/WalletEngine;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class TestService {
    public static final Companion Companion = new Companion(null);
    private final Moshi moshi;
    private final WalletEngine walletEngine;

    /* compiled from: TestService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletengine/services/test/TestService$Companion;", "", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TestService(WalletEngine walletEngine) {
        m.g(walletEngine, "walletEngine");
        this.walletEngine = walletEngine;
        this.moshi = new Moshi.Builder().add(new BigIntegerJsonAdapter()).add(new ByteArrayJsonAdapter()).add(UInt.class, new UIntJsonAdapter()).build();
    }

    public static /* synthetic */ String a(TestService testService, String str) {
        return m2091throwError$lambda1(testService, str);
    }

    public static /* synthetic */ String b(TestService testService, String str) {
        return m2090echo$lambda0(testService, str);
    }

    private final b0<String> call(String str, Map<String, ? extends Object> map) {
        String encodedParams = this.moshi.adapter((Type) Map.class).serializeNulls().toJson(map);
        WalletEngine walletEngine = this.walletEngine;
        m.f(encodedParams, "encodedParams");
        return walletEngine.call("test", str, encodedParams);
    }

    private final <T> T decodeJson(Type type, String str) {
        return this.moshi.adapter(type).serializeNulls().fromJson(str);
    }

    /* renamed from: echo$lambda-0 */
    public static final String m2090echo$lambda0(TestService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (String) this$0.decodeJson(String.class, it);
    }

    private static /* synthetic */ void getMoshi$annotations() {
    }

    /* renamed from: throwError$lambda-1 */
    public static final String m2091throwError$lambda1(TestService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return (String) this$0.decodeJson(String.class, it);
    }

    public b0<String> echo(String message) {
        Map<String, ? extends Object> e2;
        m.g(message, "message");
        e2 = l0.e(u.a(ApiConstants.MESSAGE, message));
        b0 map = call("echo", e2).map(new n() { // from class: com.coinbase.walletengine.services.test.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TestService.b(TestService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"echo\",\n                mapOf(\n                        \"message\" to message\n                )\n        )\n                .map { decodeJson<String>(String::class.java, it) }");
        return map;
    }

    public b0<String> throwError(String message) {
        Map<String, ? extends Object> e2;
        m.g(message, "message");
        e2 = l0.e(u.a(ApiConstants.MESSAGE, message));
        b0 map = call("throwError", e2).map(new n() { // from class: com.coinbase.walletengine.services.test.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TestService.a(TestService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"throwError\",\n                mapOf(\n                        \"message\" to message\n                )\n        )\n                .map { decodeJson<String>(String::class.java, it) }");
        return map;
    }
}