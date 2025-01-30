package com.coinbase.network.adapter;

import com.coinbase.network.adapter.NetworkResponse;
import h.c.b;
import h.c.m0.n;
import h.c.o;
import h.c.s;
import h.c.x;
import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.d;
import retrofit2.e;
import retrofit2.h;

/* compiled from: KotlinRxJava2CallAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0004BU\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0004\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00028\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0007\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00028\u00010\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/coinbase/network/adapter/KotlinRxJava2CallAdapter;", "", "T", "U", "Lretrofit2/e;", "Lretrofit2/d;", "call", "adapt", "(Lretrofit2/d;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "responseType", "()Ljava/lang/reflect/Type;", "Lh/c/s;", "delegateAdapter", "Lretrofit2/e;", "", "isMaybe", "Z", "successBodyType", "Ljava/lang/reflect/Type;", "Lretrofit2/h;", "Lokhttp3/ResponseBody;", "errorConverter", "Lretrofit2/h;", "isFlowable", "isSingle", "<init>", "(Ljava/lang/reflect/Type;Lretrofit2/e;Lretrofit2/h;ZZZ)V", "kotlin-rxjava"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class KotlinRxJava2CallAdapter<T, U> implements e<T, Object> {
    private final e<T, s<T>> delegateAdapter;
    private final h<ResponseBody, U> errorConverter;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isSingle;
    private final Type successBodyType;

    public KotlinRxJava2CallAdapter(Type successBodyType, e<T, s<T>> delegateAdapter, h<ResponseBody, U> errorConverter, boolean z, boolean z2, boolean z3) {
        m.h(successBodyType, "successBodyType");
        m.h(delegateAdapter, "delegateAdapter");
        m.h(errorConverter, "errorConverter");
        this.successBodyType = successBodyType;
        this.delegateAdapter = delegateAdapter;
        this.errorConverter = errorConverter;
        this.isFlowable = z;
        this.isSingle = z2;
        this.isMaybe = z3;
    }

    public static final /* synthetic */ h access$getErrorConverter$p(KotlinRxJava2CallAdapter kotlinRxJava2CallAdapter) {
        return kotlinRxJava2CallAdapter.errorConverter;
    }

    @Override // retrofit2.e
    public Object adapt(d<T> call) {
        o<T> oVar;
        m.h(call, "call");
        s onErrorResumeNext = this.delegateAdapter.adapt(call).flatMap(new n<T, x<? extends R>>() { // from class: com.coinbase.network.adapter.KotlinRxJava2CallAdapter$adapt$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((KotlinRxJava2CallAdapter$adapt$1<T, R>) obj);
            }

            @Override // h.c.m0.n
            public final s<NetworkResponse<T, U>> apply(T it) {
                m.h(it, "it");
                return s.just(new NetworkResponse.Success(it));
            }
        }).onErrorResumeNext(new n<Throwable, s<NetworkResponse<? extends T, ? extends U>>>() { // from class: com.coinbase.network.adapter.KotlinRxJava2CallAdapter$adapt$2
            @Override // h.c.m0.n
            public final s<NetworkResponse<T, U>> apply(Throwable throwable) {
                m.h(throwable, "throwable");
                if (throwable instanceof HttpException) {
                    HttpException httpException = (HttpException) throwable;
                    ResponseBody d2 = httpException.b().d();
                    Object obj = null;
                    if (d2 != null && d2.contentLength() != 0) {
                        try {
                            obj = KotlinRxJava2CallAdapter.access$getErrorConverter$p(KotlinRxJava2CallAdapter.this).convert(d2);
                        } catch (Exception e2) {
                            return s.just(new NetworkResponse.NetworkError(new IOException("Couldn't deserialize error body: " + d2.string(), e2)));
                        }
                    }
                    return s.just(new NetworkResponse.ServerError(obj, httpException.b().b()));
                } else if (throwable instanceof IOException) {
                    return s.just(new NetworkResponse.NetworkError((IOException) throwable));
                } else {
                    throw throwable;
                }
            }
        });
        if (this.isFlowable) {
            oVar = onErrorResumeNext.toFlowable(b.LATEST);
        } else if (this.isSingle) {
            oVar = onErrorResumeNext.singleOrError();
        } else {
            oVar = onErrorResumeNext;
            if (this.isMaybe) {
                oVar = onErrorResumeNext.singleElement();
            }
        }
        m.d(oVar, "when {\n                 …-> this\n                }");
        m.d(oVar, "delegateAdapter.adapt(ca…          }\n            }");
        return oVar;
    }

    @Override // retrofit2.e
    public Type responseType() {
        return this.successBodyType;
    }
}