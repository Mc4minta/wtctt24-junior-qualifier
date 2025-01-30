package com.coinbase.walletengine.services.resolver;

import com.coinbase.walletengine.WalletEngine;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import h.c.b0;
import h.c.m0.n;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: ResolverService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/coinbase/walletengine/services/resolver/ResolverService;", "", "", "method", "", "params", "Lh/c/b0;", "call", "(Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "T", "Ljava/lang/reflect/Type;", "type", "json", "decodeJson", "(Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object;", "domainName", "assetSymbol", "", "Lcom/coinbase/walletengine/services/resolver/ResolutionResult;", "resolveDomain", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi$annotations", "()V", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lcom/coinbase/walletengine/WalletEngine;", "<init>", "(Lcom/coinbase/walletengine/WalletEngine;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class ResolverService {
    public static final Companion Companion = new Companion(null);
    private final Moshi moshi;
    private final WalletEngine walletEngine;

    /* compiled from: ResolverService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletengine/services/resolver/ResolverService$Companion;", "", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ResolverService(WalletEngine walletEngine) {
        m.g(walletEngine, "walletEngine");
        this.walletEngine = walletEngine;
        this.moshi = new Moshi.Builder().add(new BigIntegerJsonAdapter()).add(new ByteArrayJsonAdapter()).add(UInt.class, new UIntJsonAdapter()).build();
    }

    public static /* synthetic */ List a(ResolverService resolverService, String str) {
        return m2071resolveDomain$lambda0(resolverService, str);
    }

    private final b0<String> call(String str, Map<String, ? extends Object> map) {
        String encodedParams = this.moshi.adapter((Type) Map.class).serializeNulls().toJson(map);
        WalletEngine walletEngine = this.walletEngine;
        m.f(encodedParams, "encodedParams");
        return walletEngine.call("resolver", str, encodedParams);
    }

    private final <T> T decodeJson(Type type, String str) {
        return this.moshi.adapter(type).serializeNulls().fromJson(str);
    }

    private static /* synthetic */ void getMoshi$annotations() {
    }

    /* renamed from: resolveDomain$lambda-0 */
    public static final List m2071resolveDomain$lambda0(ResolverService this$0, String it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, ResolutionResult.class);
        m.f(newParameterizedType, "newParameterizedType(List::class.java, ResolutionResult::class.java)");
        return (List) this$0.decodeJson(newParameterizedType, it);
    }

    public b0<List<ResolutionResult>> resolveDomain(String domainName, String assetSymbol) {
        Map<String, ? extends Object> l2;
        m.g(domainName, "domainName");
        m.g(assetSymbol, "assetSymbol");
        l2 = m0.l(u.a("domainName", domainName), u.a("assetSymbol", assetSymbol));
        b0 map = call("resolveDomain", l2).map(new n() { // from class: com.coinbase.walletengine.services.resolver.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ResolverService.a(ResolverService.this, (String) obj);
            }
        });
        m.f(map, "call(\n                \"resolveDomain\",\n                mapOf(\n                        \"domainName\" to domainName,\n                        \"assetSymbol\" to assetSymbol\n                )\n        )\n                .map { decodeJson<List<ResolutionResult>>(Types.newParameterizedType(List::class.java, ResolutionResult::class.java), it) }");
        return map;
    }
}