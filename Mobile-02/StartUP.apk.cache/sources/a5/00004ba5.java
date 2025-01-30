package h.c.j0.c;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import h.c.a0;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: AndroidSchedulers.java */
/* loaded from: classes2.dex */
public final class a {
    private static final a0 a = h.c.j0.b.a.d(new CallableC0340a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: h.c.j0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class CallableC0340a implements Callable<a0> {
        CallableC0340a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public a0 call() throws Exception {
            return b.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidSchedulers.java */
    /* loaded from: classes2.dex */
    public static final class b {
        static final a0 a = new h.c.j0.c.b(new Handler(Looper.getMainLooper()), false);
    }

    @SuppressLint({"NewApi"})
    public static a0 a(Looper looper, boolean z) {
        Objects.requireNonNull(looper, "looper == null");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            z = false;
        } else if (z && i2 < 22) {
            Message obtain = Message.obtain();
            try {
                obtain.setAsynchronous(true);
            } catch (NoSuchMethodError unused) {
                z = false;
            }
            obtain.recycle();
        }
        return new h.c.j0.c.b(new Handler(looper), z);
    }

    public static a0 b() {
        return h.c.j0.b.a.e(a);
    }
}