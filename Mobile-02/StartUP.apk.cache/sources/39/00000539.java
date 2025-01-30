package c.h.e;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.d.c;
import c.h.i.f;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class g extends e {

    /* renamed from: g  reason: collision with root package name */
    protected final Class<?> f2941g;

    /* renamed from: h  reason: collision with root package name */
    protected final Constructor<?> f2942h;

    /* renamed from: i  reason: collision with root package name */
    protected final Method f2943i;

    /* renamed from: j  reason: collision with root package name */
    protected final Method f2944j;

    /* renamed from: k  reason: collision with root package name */
    protected final Method f2945k;

    /* renamed from: l  reason: collision with root package name */
    protected final Method f2946l;
    protected final Method m;

    public g() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> y = y();
            constructor = z(y);
            method2 = v(y);
            method3 = w(y);
            method4 = A(y);
            method5 = u(y);
            method = x(y);
            cls = y;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f2941g = cls;
        this.f2942h = constructor;
        this.f2943i = method2;
        this.f2944j = method3;
        this.f2945k = method4;
        this.f2946l = method5;
        this.m = method;
    }

    private Object o() {
        try {
            return this.f2942h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void p(Object obj) {
        try {
            this.f2946l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean q(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2943i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean r(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.f2944j.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj) {
        try {
            return ((Boolean) this.f2945k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t() {
        if (this.f2943i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f2943i != null;
    }

    protected Method A(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    @Override // c.h.e.e, c.h.e.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i2) {
        c.C0027c[] a;
        if (!t()) {
            return super.b(context, bVar, resources, i2);
        }
        Object o = o();
        if (o == null) {
            return null;
        }
        for (c.C0027c c0027c : bVar.a()) {
            if (!q(context, o, c0027c.a(), c0027c.c(), c0027c.e(), c0027c.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0027c.d()))) {
                p(o);
                return null;
            }
        }
        if (s(o)) {
            return l(o);
        }
        return null;
    }

    @Override // c.h.e.e, c.h.e.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        Typeface l2;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!t()) {
            f.b h2 = h(bVarArr, i2);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(h2.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(h2.e()).setItalic(h2.f()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> h3 = k.h(context, bVarArr, cancellationSignal);
        Object o = o();
        if (o == null) {
            return null;
        }
        boolean z = false;
        for (f.b bVar : bVarArr) {
            ByteBuffer byteBuffer = h3.get(bVar.d());
            if (byteBuffer != null) {
                if (!r(o, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    p(o);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            p(o);
            return null;
        } else if (s(o) && (l2 = l(o)) != null) {
            return Typeface.create(l2, i2);
        } else {
            return null;
        }
    }

    @Override // c.h.e.j
    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        if (!t()) {
            return super.e(context, resources, i2, str, i3);
        }
        Object o = o();
        if (o == null) {
            return null;
        }
        if (!q(context, o, str, 0, -1, -1, null)) {
            p(o);
            return null;
        } else if (s(o)) {
            return l(o);
        } else {
            return null;
        }
    }

    protected Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2941g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method u(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method v(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method w(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class<?> y() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> z(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }
}