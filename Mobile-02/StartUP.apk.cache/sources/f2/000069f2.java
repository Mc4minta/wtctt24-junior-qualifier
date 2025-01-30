package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.e;
import retrofit2.h;

/* compiled from: Platform.java */
/* loaded from: classes3.dex */
class p {
    private static final p a = f();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17957b;

    /* renamed from: c  reason: collision with root package name */
    private final Constructor<MethodHandles.Lookup> f17958c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    /* loaded from: classes3.dex */
    public static final class a extends p {

        /* compiled from: Platform.java */
        /* renamed from: retrofit2.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class ExecutorC0435a implements Executor {
            private final Handler a = new Handler(Looper.getMainLooper());

            ExecutorC0435a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.a.post(runnable);
            }
        }

        a() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // retrofit2.p
        public Executor c() {
            return new ExecutorC0435a();
        }

        @Override // retrofit2.p
        Object h(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.h(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    p(boolean z) {
        this.f17957b = z;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z) {
            try {
                constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.f17958c = constructor;
    }

    private static p f() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        return new p(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p g() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends e.a> a(Executor executor) {
        i iVar = new i(executor);
        return this.f17957b ? Arrays.asList(g.a, iVar) : Collections.singletonList(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f17957b ? 2 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor c() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends h.a> d() {
        if (this.f17957b) {
            return Collections.singletonList(n.a);
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f17957b ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object h(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.f17958c;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(Method method) {
        return this.f17957b && method.isDefault();
    }
}