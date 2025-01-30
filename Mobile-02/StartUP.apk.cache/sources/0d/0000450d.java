package e.a.a.z;

import android.util.Log;
import e.a.a.j;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LogcatLogger.java */
/* loaded from: classes.dex */
public class c implements j {
    private static final Set<String> a = new HashSet();

    @Override // e.a.a.j
    public void a(String str, Throwable th) {
        if (e.a.a.c.a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // e.a.a.j
    public void b(String str) {
        e(str, null);
    }

    @Override // e.a.a.j
    public void c(String str, Throwable th) {
        Set<String> set = a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    @Override // e.a.a.j
    public void d(String str) {
        c(str, null);
    }

    public void e(String str, Throwable th) {
        if (e.a.a.c.a) {
            Log.d("LOTTIE", str, th);
        }
    }
}