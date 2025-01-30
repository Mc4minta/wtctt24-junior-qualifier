package retrofit2;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import j.e0;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OkHttpCall.java */
/* loaded from: classes3.dex */
public final class m<T> implements d<T> {
    private final r a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f17918b;

    /* renamed from: c  reason: collision with root package name */
    private final Call.Factory f17919c;

    /* renamed from: d  reason: collision with root package name */
    private final h<ResponseBody, T> f17920d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f17921e;

    /* renamed from: f  reason: collision with root package name */
    private Call f17922f;

    /* renamed from: g  reason: collision with root package name */
    private Throwable f17923g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f17924h;

    /* compiled from: OkHttpCall.java */
    /* loaded from: classes3.dex */
    class a implements Callback {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        private void a(Throwable th) {
            try {
                this.a.onFailure(m.this, th);
            } catch (Throwable th2) {
                x.s(th2);
                th2.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.a.onResponse(m.this, m.this.e(response));
                } catch (Throwable th) {
                    x.s(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                x.s(th2);
                a(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpCall.java */
    /* loaded from: classes3.dex */
    public static final class b extends ResponseBody {
        private final ResponseBody a;

        /* renamed from: b  reason: collision with root package name */
        private final j.h f17926b;

        /* renamed from: c  reason: collision with root package name */
        IOException f17927c;

        /* compiled from: OkHttpCall.java */
        /* loaded from: classes3.dex */
        class a extends j.l {
            a(e0 e0Var) {
                super(e0Var);
            }

            @Override // j.l, j.e0
            public long read(j.f fVar, long j2) throws IOException {
                try {
                    return super.read(fVar, j2);
                } catch (IOException e2) {
                    b.this.f17927c = e2;
                    throw e2;
                }
            }
        }

        b(ResponseBody responseBody) {
            this.a = responseBody;
            this.f17926b = j.q.d(new a(responseBody.source()));
        }

        void a() throws IOException {
            IOException iOException = this.f17927c;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public j.h source() {
            return this.f17926b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OkHttpCall.java */
    /* loaded from: classes3.dex */
    public static final class c extends ResponseBody {
        private final MediaType a;

        /* renamed from: b  reason: collision with root package name */
        private final long f17928b;

        c(MediaType mediaType, long j2) {
            this.a = mediaType;
            this.f17928b = j2;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f17928b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.a;
        }

        @Override // okhttp3.ResponseBody
        public j.h source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(r rVar, Object[] objArr, Call.Factory factory, h<ResponseBody, T> hVar) {
        this.a = rVar;
        this.f17918b = objArr;
        this.f17919c = factory;
        this.f17920d = hVar;
    }

    private Call c() throws IOException {
        Call newCall = this.f17919c.newCall(this.a.a(this.f17918b));
        Objects.requireNonNull(newCall, "Call.Factory returned null.");
        return newCall;
    }

    private Call d() throws IOException {
        Call call = this.f17922f;
        if (call != null) {
            return call;
        }
        Throwable th = this.f17923g;
        if (th != null) {
            if (!(th instanceof IOException)) {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw ((Error) th);
            }
            throw ((IOException) th);
        }
        try {
            Call c2 = c();
            this.f17922f = c2;
            return c2;
        } catch (IOException | Error | RuntimeException e2) {
            x.s(e2);
            this.f17923g = e2;
            throw e2;
        }
    }

    @Override // retrofit2.d
    /* renamed from: b */
    public m<T> mo2365clone() {
        return new m<>(this.a, this.f17918b, this.f17919c, this.f17920d);
    }

    @Override // retrofit2.d
    public void cancel() {
        Call call;
        this.f17921e = true;
        synchronized (this) {
            call = this.f17922f;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // retrofit2.d
    public void d0(f<T> fVar) {
        Call call;
        Throwable th;
        Objects.requireNonNull(fVar, "callback == null");
        synchronized (this) {
            if (!this.f17924h) {
                this.f17924h = true;
                call = this.f17922f;
                th = this.f17923g;
                if (call == null && th == null) {
                    Call c2 = c();
                    this.f17922f = c2;
                    call = c2;
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            fVar.onFailure(this, th);
            return;
        }
        if (this.f17921e) {
            call.cancel();
        }
        FirebasePerfOkHttpClient.enqueue(call, new a(fVar));
    }

    s<T> e(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new c(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return s.c(x.a(body), build);
            } finally {
                body.close();
            }
        } else if (code != 204 && code != 205) {
            b bVar = new b(body);
            try {
                return s.g(this.f17920d.convert(bVar), build);
            } catch (RuntimeException e2) {
                bVar.a();
                throw e2;
            }
        } else {
            body.close();
            return s.g(null, build);
        }
    }

    @Override // retrofit2.d
    public s<T> execute() throws IOException {
        Call d2;
        synchronized (this) {
            if (!this.f17924h) {
                this.f17924h = true;
                d2 = d();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f17921e) {
            d2.cancel();
        }
        return e(FirebasePerfOkHttpClient.execute(d2));
    }

    @Override // retrofit2.d
    public boolean isCanceled() {
        boolean z = true;
        if (this.f17921e) {
            return true;
        }
        synchronized (this) {
            Call call = this.f17922f;
            if (call == null || !call.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // retrofit2.d
    public synchronized boolean isExecuted() {
        return this.f17924h;
    }

    @Override // retrofit2.d
    public synchronized Request request() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create request.", e2);
        }
        return d().request();
    }
}