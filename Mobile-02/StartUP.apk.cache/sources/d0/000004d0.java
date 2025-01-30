package c.c.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.e;
import java.util.ArrayList;

/* compiled from: CustomTabsIntent.java */
/* loaded from: classes.dex */
public final class c {
    public final Intent a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f2605b;

    /* compiled from: CustomTabsIntent.java */
    /* loaded from: classes.dex */
    public static final class a {
        private final Intent a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<Bundle> f2606b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f2607c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<Bundle> f2608d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2609e;

        public a() {
            this(null);
        }

        public a a() {
            this.a.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
            return this;
        }

        public c b() {
            ArrayList<Bundle> arrayList = this.f2606b;
            if (arrayList != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f2608d;
            if (arrayList2 != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f2609e);
            return new c(this.a, this.f2607c);
        }

        public a c(Bitmap bitmap) {
            this.a.putExtra("android.support.customtabs.extra.CLOSE_BUTTON_ICON", bitmap);
            return this;
        }

        public a d(Context context, int i2, int i3) {
            this.a.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", androidx.core.app.b.a(context, i2, i3).b());
            return this;
        }

        public a e(int i2) {
            this.a.putExtra("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", i2);
            return this;
        }

        public a f(boolean z) {
            this.a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z ? 1 : 0);
            return this;
        }

        public a g(Context context, int i2, int i3) {
            this.f2607c = androidx.core.app.b.a(context, i2, i3).b();
            return this;
        }

        public a h(int i2) {
            this.a.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", i2);
            return this;
        }

        public a(d dVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.a = intent;
            this.f2606b = null;
            this.f2607c = null;
            this.f2608d = null;
            this.f2609e = true;
            if (dVar != null) {
                intent.setPackage(dVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            e.b(bundle, "android.support.customtabs.extra.SESSION", dVar != null ? dVar.a() : null);
            intent.putExtras(bundle);
        }
    }

    c(Intent intent, Bundle bundle) {
        this.a = intent;
        this.f2605b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.a.setData(uri);
        androidx.core.content.a.l(context, this.a, this.f2605b);
    }
}