package io.branch.referral;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BranchStrongMatchHelper.java */
/* loaded from: classes2.dex */
public class g {
    private static g a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f16946b = 750;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f16948d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16949e;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f16951g;

    /* renamed from: h  reason: collision with root package name */
    private Class<?> f16952h;

    /* renamed from: i  reason: collision with root package name */
    private Class<?> f16953i;

    /* renamed from: j  reason: collision with root package name */
    private Class<?> f16954j;

    /* renamed from: c  reason: collision with root package name */
    private Object f16947c = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16950f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BranchStrongMatchHelper.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.k(this.a, gVar.f16950f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BranchStrongMatchHelper.java */
    /* loaded from: classes2.dex */
    public class b extends d {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f16956b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Method f16957c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Uri f16958d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Method f16959e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ q f16960f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ e f16961g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Method method, Method method2, Uri uri, Method method3, q qVar, e eVar) {
            super();
            this.f16956b = method;
            this.f16957c = method2;
            this.f16958d = uri;
            this.f16959e = method3;
            this.f16960f = qVar;
            this.f16961g = eVar;
        }

        @Override // io.branch.referral.g.d
        public void a(ComponentName componentName, Object obj) {
            g gVar = g.this;
            gVar.f16947c = gVar.f16951g.cast(obj);
            if (g.this.f16947c != null) {
                try {
                    this.f16956b.invoke(g.this.f16947c, 0);
                    Object invoke = this.f16957c.invoke(g.this.f16947c, null);
                    if (invoke != null) {
                        q.a("Strong match request " + this.f16958d);
                        this.f16959e.invoke(invoke, this.f16958d, null, null);
                        this.f16960f.W(System.currentTimeMillis());
                        g.this.f16950f = true;
                    }
                } catch (Throwable unused) {
                    g.this.f16947c = null;
                    g gVar2 = g.this;
                    gVar2.k(this.f16961g, gVar2.f16950f);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            g.this.f16947c = null;
            g gVar = g.this;
            gVar.k(this.f16961g, gVar.f16950f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BranchStrongMatchHelper.java */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        final /* synthetic */ e a;

        c(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
        }
    }

    /* compiled from: BranchStrongMatchHelper.java */
    /* loaded from: classes2.dex */
    private abstract class d implements ServiceConnection {
        d() {
        }

        public abstract void a(ComponentName componentName, Object obj);

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Constructor declaredConstructor = g.this.f16951g.getDeclaredConstructor(g.this.f16954j, ComponentName.class);
                declaredConstructor.setAccessible(true);
                a(componentName, declaredConstructor.newInstance(Class.forName("b.a.a.b$a").getMethod("asInterface", IBinder.class).invoke(null, iBinder), componentName));
            } catch (Throwable unused) {
                a(null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BranchStrongMatchHelper.java */
    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    private g() {
        this.f16949e = true;
        try {
            this.f16951g = Class.forName("c.c.b.b");
            this.f16952h = Class.forName("c.c.b.a");
            this.f16953i = Class.forName("c.c.b.d");
            this.f16954j = Class.forName("b.a.a.b");
        } catch (Throwable unused) {
            this.f16949e = false;
        }
        this.f16948d = new Handler();
    }

    private Uri h(String str, o oVar, q qVar, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = ("https://" + str + "/_strong_match?os=" + oVar.g()) + "&" + l.HardwareID.h() + "=" + oVar.d();
        String str3 = str2 + "&" + l.HardwareIDType.h() + "=" + (oVar.d().b() ? l.HardwareIDTypeVendor : l.HardwareIDTypeRandom).h();
        String e2 = oVar.h().e();
        if (e2 != null && !i.b(context)) {
            str3 = str3 + "&" + l.GoogleAdvertisingID.h() + "=" + e2;
        }
        if (!qVar.s().equals("bnc_no_value")) {
            str3 = str3 + "&" + l.DeviceFingerprintID.h() + "=" + qVar.s();
        }
        if (!oVar.a().equals("bnc_no_value")) {
            str3 = str3 + "&" + l.AppVersion.h() + "=" + oVar.a();
        }
        if (!qVar.o().equals("bnc_no_value")) {
            str3 = str3 + "&" + l.BranchKey.h() + "=" + qVar.o();
        }
        return Uri.parse(str3 + "&sdk=android3.2.0");
    }

    public static g j() {
        if (a == null) {
            a = new g();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(e eVar, boolean z) {
        if (eVar != null) {
            if (z) {
                new Handler().postDelayed(new c(eVar), f16946b);
            } else {
                eVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Context context, String str, o oVar, q qVar, e eVar) {
        this.f16950f = false;
        if (System.currentTimeMillis() - qVar.G() < 2592000000L) {
            k(eVar, this.f16950f);
        } else if (!this.f16949e) {
            k(eVar, this.f16950f);
        } else {
            try {
                if (oVar.d() != null) {
                    Uri h2 = h(str, oVar, qVar, context);
                    if (h2 != null) {
                        this.f16948d.postDelayed(new a(eVar), 500L);
                        Method method = this.f16951g.getMethod("warmup", Long.TYPE);
                        Method method2 = this.f16951g.getMethod("newSession", this.f16952h);
                        Method method3 = this.f16953i.getMethod("mayLaunchUrl", Uri.class, Bundle.class, List.class);
                        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
                        intent.setPackage("com.android.chrome");
                        context.bindService(intent, new b(method, method2, h2, method3, qVar, eVar), 33);
                    } else {
                        k(eVar, this.f16950f);
                    }
                } else {
                    k(eVar, this.f16950f);
                    q.a("Cannot use cookie-based matching since device id is not available");
                }
            } catch (Throwable unused) {
                k(eVar, this.f16950f);
            }
        }
    }
}