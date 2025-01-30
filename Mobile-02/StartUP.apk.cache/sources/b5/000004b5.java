package c.a.o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f2547b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f2548c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f2549d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f2550e;

    public d() {
        super(null);
    }

    private Resources b() {
        if (this.f2550e == null) {
            Configuration configuration = this.f2549d;
            if (configuration == null) {
                this.f2550e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f2550e = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration2 = new Configuration(resources.getConfiguration());
                configuration2.updateFrom(this.f2549d);
                this.f2550e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration2);
            }
        }
        return this.f2550e;
    }

    private void d() {
        boolean z = this.f2547b == null;
        if (z) {
            this.f2547b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2547b.setTo(theme);
            }
        }
        e(this.f2547b, this.a, z);
    }

    public void a(Configuration configuration) {
        if (this.f2550e == null) {
            if (this.f2549d == null) {
                this.f2549d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.a;
    }

    protected void e(Resources.Theme theme, int i2, boolean z) {
        theme.applyStyle(i2, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f2548c == null) {
                this.f2548c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f2548c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f2547b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = c.a.i.f2496e;
        }
        d();
        return this.f2547b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        if (this.a != i2) {
            this.a = i2;
            d();
        }
    }

    public d(Context context, int i2) {
        super(context);
        this.a = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f2547b = theme;
    }
}