package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class p0 extends ContextWrapper {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<WeakReference<p0>> f871b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f872c;

    /* renamed from: d  reason: collision with root package name */
    private final Resources.Theme f873d;

    private p0(Context context) {
        super(context);
        if (x0.b()) {
            x0 x0Var = new x0(this, context.getResources());
            this.f872c = x0Var;
            Resources.Theme newTheme = x0Var.newTheme();
            this.f873d = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f872c = new r0(this, context.getResources());
        this.f873d = null;
    }

    private static boolean a(Context context) {
        if ((context instanceof p0) || (context.getResources() instanceof r0) || (context.getResources() instanceof x0)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || x0.b();
    }

    public static Context b(Context context) {
        if (a(context)) {
            synchronized (a) {
                ArrayList<WeakReference<p0>> arrayList = f871b;
                if (arrayList == null) {
                    f871b = new ArrayList<>();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference<p0> weakReference = f871b.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f871b.remove(size);
                        }
                    }
                    for (int size2 = f871b.size() - 1; size2 >= 0; size2--) {
                        WeakReference<p0> weakReference2 = f871b.get(size2);
                        p0 p0Var = weakReference2 != null ? weakReference2.get() : null;
                        if (p0Var != null && p0Var.getBaseContext() == context) {
                            return p0Var;
                        }
                    }
                }
                p0 p0Var2 = new p0(context);
                f871b.add(new WeakReference<>(p0Var2));
                return p0Var2;
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f872c.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f872c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f873d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Resources.Theme theme = this.f873d;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}