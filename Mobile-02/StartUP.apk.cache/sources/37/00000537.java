package c.h.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.d.c;
import c.h.i.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi21Impl.java */
/* loaded from: classes.dex */
class e extends j {

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f2932b;

    /* renamed from: c  reason: collision with root package name */
    private static Constructor<?> f2933c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f2934d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f2935e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f2936f;

    private static boolean k(Object obj, String str, int i2, boolean z) {
        n();
        try {
            return ((Boolean) f2934d.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface l(Object obj) {
        n();
        try {
            Object newInstance = Array.newInstance(f2932b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2935e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void n() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f2936f) {
            return;
        }
        f2936f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f2933c = constructor;
        f2932b = cls;
        f2934d = method2;
        f2935e = method;
    }

    private static Object o() {
        n();
        try {
            return f2933c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // c.h.e.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i2) {
        c.C0027c[] a;
        Object o = o();
        for (c.C0027c c0027c : bVar.a()) {
            File e2 = k.e(context);
            if (e2 == null) {
                return null;
            }
            try {
                if (!k.c(e2, resources, c0027c.b())) {
                    return null;
                }
                if (!k(o, e2.getPath(), c0027c.e(), c0027c.f())) {
                    return null;
                }
                e2.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e2.delete();
            }
        }
        return l(o);
    }

    @Override // c.h.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        if (bVarArr.length < 1) {
            return null;
        }
        f.b h2 = h(bVarArr, i2);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(h2.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            File m = m(openFileDescriptor);
            if (m != null && m.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(m);
                openFileDescriptor.close();
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface d2 = super.d(context, fileInputStream);
            fileInputStream.close();
            openFileDescriptor.close();
            return d2;
        } catch (IOException unused) {
            return null;
        }
    }
}