package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.e;
import retrofit2.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultCallAdapterFactory.java */
/* loaded from: classes3.dex */
public final class i extends e.a {
    private final Executor a;

    /* compiled from: DefaultCallAdapterFactory.java */
    /* loaded from: classes3.dex */
    class a implements e<Object, d<?>> {
        final /* synthetic */ Type a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Executor f17903b;

        a(Type type, Executor executor) {
            this.a = type;
            this.f17903b = executor;
        }

        @Override // retrofit2.e
        /* renamed from: a */
        public d<Object> adapt(d<Object> dVar) {
            Executor executor = this.f17903b;
            return executor == null ? dVar : new b(executor, dVar);
        }

        @Override // retrofit2.e
        public Type responseType() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultCallAdapterFactory.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements d<T> {
        final Executor a;

        /* renamed from: b  reason: collision with root package name */
        final d<T> f17905b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DefaultCallAdapterFactory.java */
        /* loaded from: classes3.dex */
        public class a implements f<T> {
            final /* synthetic */ f a;

            a(f fVar) {
                this.a = fVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public /* synthetic */ void b(f fVar, Throwable th) {
                fVar.onFailure(b.this, th);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: c */
            public /* synthetic */ void d(f fVar, s sVar) {
                if (b.this.f17905b.isCanceled()) {
                    fVar.onFailure(b.this, new IOException("Canceled"));
                } else {
                    fVar.onResponse(b.this, sVar);
                }
            }

            @Override // retrofit2.f
            public void onFailure(d<T> dVar, final Throwable th) {
                Executor executor = b.this.a;
                final f fVar = this.a;
                executor.execute(new Runnable() { // from class: retrofit2.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.a.this.b(fVar, th);
                    }
                });
            }

            @Override // retrofit2.f
            public void onResponse(d<T> dVar, final s<T> sVar) {
                Executor executor = b.this.a;
                final f fVar = this.a;
                executor.execute(new Runnable() { // from class: retrofit2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.a.this.d(fVar, sVar);
                    }
                });
            }
        }

        b(Executor executor, d<T> dVar) {
            this.a = executor;
            this.f17905b = dVar;
        }

        @Override // retrofit2.d
        public void cancel() {
            this.f17905b.cancel();
        }

        @Override // retrofit2.d
        public void d0(f<T> fVar) {
            Objects.requireNonNull(fVar, "callback == null");
            this.f17905b.d0(new a(fVar));
        }

        @Override // retrofit2.d
        public s<T> execute() throws IOException {
            return this.f17905b.execute();
        }

        @Override // retrofit2.d
        public boolean isCanceled() {
            return this.f17905b.isCanceled();
        }

        @Override // retrofit2.d
        public boolean isExecuted() {
            return this.f17905b.isExecuted();
        }

        @Override // retrofit2.d
        public Request request() {
            return this.f17905b.request();
        }

        @Override // retrofit2.d
        public d<T> clone() {
            return new b(this.a, this.f17905b.mo2365clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Executor executor) {
        this.a = executor;
    }

    @Override // retrofit2.e.a
    public e<?, ?> get(Type type, Annotation[] annotationArr, t tVar) {
        if (e.a.getRawType(type) != d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(x.g(0, (ParameterizedType) type), x.l(annotationArr, v.class) ? null : this.a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}