package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public abstract class i {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static i f6239b;

    public static i b(Context context) {
        synchronized (a) {
            if (f6239b == null) {
                f6239b = new l0(context.getApplicationContext());
            }
        }
        return f6239b;
    }

    public boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return e(new a(componentName, 129), serviceConnection, str);
    }

    public void c(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        f(new a(componentName, 129), serviceConnection, str);
    }

    public final void d(String str, String str2, int i2, ServiceConnection serviceConnection, String str3, boolean z) {
        f(new a(str, str2, i2, z), serviceConnection, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean e(a aVar, ServiceConnection serviceConnection, String str);

    protected abstract void f(a aVar, ServiceConnection serviceConnection, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public static final class a {
        private static final Uri a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

        /* renamed from: b  reason: collision with root package name */
        private final String f6240b;

        /* renamed from: c  reason: collision with root package name */
        private final String f6241c;

        /* renamed from: d  reason: collision with root package name */
        private final ComponentName f6242d;

        /* renamed from: e  reason: collision with root package name */
        private final int f6243e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f6244f;

        public a(String str, String str2, int i2, boolean z) {
            this.f6240b = t.g(str);
            this.f6241c = t.g(str2);
            this.f6242d = null;
            this.f6243e = i2;
            this.f6244f = z;
        }

        public final ComponentName a() {
            return this.f6242d;
        }

        public final String b() {
            return this.f6241c;
        }

        public final Intent c(Context context) {
            if (this.f6240b != null) {
                if (this.f6244f) {
                    Bundle bundle = new Bundle();
                    bundle.putString("serviceActionBundleKey", this.f6240b);
                    Bundle call = context.getContentResolver().call(a, "serviceIntentCall", (String) null, bundle);
                    r1 = call != null ? (Intent) call.getParcelable("serviceResponseIntentKey") : null;
                    if (r1 == null) {
                        String valueOf = String.valueOf(this.f6240b);
                        Log.w("ConnectionStatusConfig", valueOf.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf) : new String("Dynamic lookup for intent failed for action: "));
                    }
                }
                return r1 == null ? new Intent(this.f6240b).setPackage(this.f6241c) : r1;
            }
            return new Intent().setComponent(this.f6242d);
        }

        public final int d() {
            return this.f6243e;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return r.a(this.f6240b, aVar.f6240b) && r.a(this.f6241c, aVar.f6241c) && r.a(this.f6242d, aVar.f6242d) && this.f6243e == aVar.f6243e && this.f6244f == aVar.f6244f;
            }
            return false;
        }

        public final int hashCode() {
            return r.b(this.f6240b, this.f6241c, this.f6242d, Integer.valueOf(this.f6243e), Boolean.valueOf(this.f6244f));
        }

        public final String toString() {
            String str = this.f6240b;
            return str == null ? this.f6242d.flattenToString() : str;
        }

        public a(ComponentName componentName, int i2) {
            this.f6240b = null;
            this.f6241c = null;
            this.f6242d = (ComponentName) t.k(componentName);
            this.f6243e = 129;
            this.f6244f = false;
        }
    }
}