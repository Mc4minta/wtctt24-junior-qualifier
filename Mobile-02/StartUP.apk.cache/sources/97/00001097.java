package com.coinbase.network.adapter;

import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;

/* compiled from: NetworkResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001al\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00050\u00042\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001a~\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00050\u00042&\b\u0004\u0010\u0007\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\u00040\u0006H\u0086\b¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"", "T", "U", "E", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lkotlin/Function1;", "mapper", "mapSuccess", "(Lh/c/b0;Lkotlin/e0/c/l;)Lh/c/b0;", "flatMapSuccess", "kotlin-rxjava"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class NetworkResponseKt {
    public static final <T, U, E> b0<NetworkResponse<U, E>> flatMapSuccess(b0<NetworkResponse<T, E>> flatMapSuccess, final l<? super T, ? extends b0<NetworkResponse<U, E>>> mapper) {
        m.h(flatMapSuccess, "$this$flatMapSuccess");
        m.h(mapper, "mapper");
        b0<NetworkResponse<U, E>> b0Var = (b0<NetworkResponse<U, E>>) flatMapSuccess.flatMap(new n<T, h0<? extends R>>() { // from class: com.coinbase.network.adapter.NetworkResponseKt$flatMapSuccess$1
            public final h0<? extends NetworkResponse<U, E>> apply(NetworkResponse<? extends T, ? extends E> it) {
                m.h(it, "it");
                if (it instanceof NetworkResponse.Success) {
                    return (h0) l.this.invoke(((NetworkResponse.Success) it).getBody());
                }
                if (it instanceof NetworkResponse.ServerError) {
                    NetworkResponse.ServerError serverError = (NetworkResponse.ServerError) it;
                    return b0.just(new NetworkResponse.ServerError(serverError.getBody(), serverError.getCode()));
                } else if (it instanceof NetworkResponse.NetworkError) {
                    return b0.just(new NetworkResponse.NetworkError(((NetworkResponse.NetworkError) it).getError()));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((NetworkResponse) ((NetworkResponse) obj));
            }
        });
        m.d(b0Var, "flatMap<NetworkResponse<…t.error))\n        }\n    }");
        return b0Var;
    }

    public static final <T, U, E> b0<NetworkResponse<U, E>> mapSuccess(b0<NetworkResponse<T, E>> mapSuccess, final l<? super T, ? extends U> mapper) {
        m.h(mapSuccess, "$this$mapSuccess");
        m.h(mapper, "mapper");
        b0<NetworkResponse<U, E>> b0Var = (b0<NetworkResponse<U, E>>) mapSuccess.map(new n<T, R>() { // from class: com.coinbase.network.adapter.NetworkResponseKt$mapSuccess$1
            public final NetworkResponse<U, E> apply(NetworkResponse<? extends T, ? extends E> it) {
                m.h(it, "it");
                if (it instanceof NetworkResponse.Success) {
                    return new NetworkResponse.Success(l.this.invoke(((NetworkResponse.Success) it).getBody()));
                }
                if (it instanceof NetworkResponse.ServerError) {
                    NetworkResponse.ServerError serverError = (NetworkResponse.ServerError) it;
                    return new NetworkResponse.ServerError(serverError.getBody(), serverError.getCode());
                } else if (it instanceof NetworkResponse.NetworkError) {
                    return new NetworkResponse.NetworkError(((NetworkResponse.NetworkError) it).getError());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((NetworkResponse) ((NetworkResponse) obj));
            }
        });
        m.d(b0Var, "this.map { it.map(mapper) }");
        return b0Var;
    }
}