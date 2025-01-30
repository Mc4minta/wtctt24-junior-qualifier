package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: TraceCompat.java */
@Deprecated
/* loaded from: classes.dex */
public final class f {
    private static long a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f1535b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f1536c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f1537d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f1538e;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 18 || i2 >= 29) {
            return;
        }
        try {
            a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            Class cls = Long.TYPE;
            f1535b = Trace.class.getMethod("isTagEnabled", cls);
            Class cls2 = Integer.TYPE;
            f1536c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
            f1537d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
            f1538e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
        } catch (Exception e2) {
            Log.i("TraceCompat", "Unable to initialize via reflection.", e2);
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}