package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompletableFutureCallAdapterFactory.java */
@IgnoreJRERequirement
/* loaded from: classes3.dex */
public final class g extends e.a {
    static final e.a a = new g();

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    /* loaded from: classes3.dex */
    private static final class a<R> implements e<R, CompletableFuture<R>> {
        private final Type a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CompletableFutureCallAdapterFactory.java */
        /* renamed from: retrofit2.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0433a implements f<R> {
            final /* synthetic */ CompletableFuture a;

            C0433a(CompletableFuture completableFuture) {
                this.a = completableFuture;
            }

            @Override // retrofit2.f
            public void onFailure(d<R> dVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // retrofit2.f
            public void onResponse(d<R> dVar, s<R> sVar) {
                if (sVar.e()) {
                    this.a.complete(sVar.a());
                } else {
                    this.a.completeExceptionally(new HttpException(sVar));
                }
            }
        }

        a(Type type) {
            this.a = type;
        }

        @Override // retrofit2.e
        /* renamed from: a */
        public CompletableFuture<R> adapt(d<R> dVar) {
            b bVar = new b(dVar);
            dVar.d0(new C0433a(bVar));
            return bVar;
        }

        @Override // retrofit2.e
        public Type responseType() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CompletableFutureCallAdapterFactory.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends CompletableFuture<T> {
        private final d<?> a;

        b(d<?> dVar) {
            this.a = dVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (z) {
                this.a.cancel();
            }
            return super.cancel(z);
        }
    }

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    /* loaded from: classes3.dex */
    private static final class c<R> implements e<R, CompletableFuture<s<R>>> {
        private final Type a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CompletableFutureCallAdapterFactory.java */
        /* loaded from: classes3.dex */
        public class a implements f<R> {
            final /* synthetic */ CompletableFuture a;

            a(CompletableFuture completableFuture) {
                this.a = completableFuture;
            }

            @Override // retrofit2.f
            public void onFailure(d<R> dVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // retrofit2.f
            public void onResponse(d<R> dVar, s<R> sVar) {
                this.a.complete(sVar);
            }
        }

        c(Type type) {
            this.a = type;
        }

        @Override // retrofit2.e
        /* renamed from: a */
        public CompletableFuture<s<R>> adapt(d<R> dVar) {
            b bVar = new b(dVar);
            dVar.d0(new a(bVar));
            return bVar;
        }

        @Override // retrofit2.e
        public Type responseType() {
            return this.a;
        }
    }

    g() {
    }

    @Override // retrofit2.e.a
    public e<?, ?> get(Type type, Annotation[] annotationArr, t tVar) {
        if (e.a.getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = e.a.getParameterUpperBound(0, (ParameterizedType) type);
            if (e.a.getRawType(parameterUpperBound) != s.class) {
                return new a(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new c(e.a.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}