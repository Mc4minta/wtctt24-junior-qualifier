package c.h.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.d.c;
import c.h.i.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
class f extends j {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f2937b;

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor<?> f2938c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f2939d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f2940e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f2938c = constructor;
        f2937b = cls;
        f2939d = method2;
        f2940e = method;
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f2939d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(f2937b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2940e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        Method method = f2939d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object n() {
        try {
            return f2938c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // c.h.e.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i2) {
        c.C0027c[] a;
        Object n = n();
        if (n == null) {
            return null;
        }
        for (c.C0027c c0027c : bVar.a()) {
            ByteBuffer b2 = k.b(context, resources, c0027c.b());
            if (b2 == null || !k(n, b2, c0027c.c(), c0027c.e(), c0027c.f())) {
                return null;
            }
        }
        return l(n);
    }

    @Override // c.h.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        Object n = n();
        if (n == null) {
            return null;
        }
        c.e.g gVar = new c.e.g();
        for (f.b bVar : bVarArr) {
            Uri d2 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(d2);
            if (byteBuffer == null) {
                byteBuffer = k.f(context, cancellationSignal, d2);
                gVar.put(d2, byteBuffer);
            }
            if (byteBuffer == null || !k(n, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface l2 = l(n);
        if (l2 == null) {
            return null;
        }
        return Typeface.create(l2, i2);
    }
}