package e.g.a.e.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.n;
import com.google.android.gms.common.util.p;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class a {
    private static ScheduledExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile InterfaceC0303a f13213b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Object f13214c;

    /* renamed from: d  reason: collision with root package name */
    private final PowerManager.WakeLock f13215d;

    /* renamed from: e  reason: collision with root package name */
    private WorkSource f13216e;

    /* renamed from: f  reason: collision with root package name */
    private final int f13217f;

    /* renamed from: g  reason: collision with root package name */
    private final String f13218g;

    /* renamed from: h  reason: collision with root package name */
    private final String f13219h;

    /* renamed from: i  reason: collision with root package name */
    private final String f13220i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f13221j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13222k;

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, Integer[]> f13223l;
    private final Set<Future<?>> m;
    private int n;
    private AtomicInteger o;

    /* renamed from: e.g.a.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0303a {
    }

    public a(Context context, int i2, String str) {
        this(context, i2, str, null, context == null ? null : context.getPackageName());
    }

    private final String d(String str) {
        return (!this.f13222k || TextUtils.isEmpty(str)) ? this.f13219h : str;
    }

    private final List<String> e() {
        return p.b(this.f13216e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int i2) {
        if (this.f13215d.isHeld()) {
            try {
                this.f13215d.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f13218g).concat(" was already released!"), e2);
                } else {
                    throw e2;
                }
            }
            this.f13215d.isHeld();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r2 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (r13.n == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        com.google.android.gms.common.stats.d.a().c(r13.f13221j, com.google.android.gms.common.stats.c.a(r13.f13215d, r6), 7, r13.f13218g, r6, null, r13.f13217f, e(), r14);
        r13.n++;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.o
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.d(r0)
            java.lang.Object r0 = r13.f13214c
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f13223l     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L96
            r2 = 0
            if (r1 == 0) goto L1a
            int r1 = r13.n     // Catch: java.lang.Throwable -> L96
            if (r1 <= 0) goto L29
        L1a:
            android.os.PowerManager$WakeLock r1 = r13.f13215d     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L29
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f13223l     // Catch: java.lang.Throwable -> L96
            r1.clear()     // Catch: java.lang.Throwable -> L96
            r13.n = r2     // Catch: java.lang.Throwable -> L96
        L29:
            boolean r1 = r13.f13222k     // Catch: java.lang.Throwable -> L96
            r12 = 1
            if (r1 == 0) goto L56
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f13223l     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L47
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.f13223l     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch: java.lang.Throwable -> L96
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L96
            r3[r2] = r4     // Catch: java.lang.Throwable -> L96
            r1.put(r6, r3)     // Catch: java.lang.Throwable -> L96
            r2 = r12
            goto L54
        L47:
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L96
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L96
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L96
            r1[r2] = r3     // Catch: java.lang.Throwable -> L96
        L54:
            if (r2 != 0) goto L5e
        L56:
            boolean r1 = r13.f13222k     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
            int r1 = r13.n     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
        L5e:
            com.google.android.gms.common.stats.d r1 = com.google.android.gms.common.stats.d.a()     // Catch: java.lang.Throwable -> L96
            android.content.Context r2 = r13.f13221j     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r3 = r13.f13215d     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = com.google.android.gms.common.stats.c.a(r3, r6)     // Catch: java.lang.Throwable -> L96
            r4 = 7
            java.lang.String r5 = r13.f13218g     // Catch: java.lang.Throwable -> L96
            r7 = 0
            int r8 = r13.f13217f     // Catch: java.lang.Throwable -> L96
            java.util.List r9 = r13.e()     // Catch: java.lang.Throwable -> L96
            r10 = r14
            r1.c(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96
            int r1 = r13.n     // Catch: java.lang.Throwable -> L96
            int r1 = r1 + r12
            r13.n = r1     // Catch: java.lang.Throwable -> L96
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r0 = r13.f13215d
            r0.acquire()
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 <= 0) goto L95
            java.util.concurrent.ScheduledExecutorService r0 = e.g.a.e.i.a.a
            e.g.a.e.i.c r1 = new e.g.a.e.i.c
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L95:
            return
        L96:
            r14 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.a.e.i.a.a(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r1 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (r12.n == 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        com.google.android.gms.common.stats.d.a().b(r12.f13221j, com.google.android.gms.common.stats.c.a(r12.f13215d, r6), 8, r12.f13218g, r6, null, r12.f13217f, e());
        r12.n--;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.o
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L19
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r12.f13218g
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " release without a matched acquire!"
            java.lang.String r1 = r1.concat(r2)
            android.util.Log.e(r0, r1)
        L19:
            r0 = 0
            java.lang.String r6 = r12.d(r0)
            java.lang.Object r0 = r12.f13214c
            monitor-enter(r0)
            boolean r1 = r12.f13222k     // Catch: java.lang.Throwable -> L7e
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L52
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f13223l     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L33
        L31:
            r1 = r11
            goto L50
        L33:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            if (r2 != r10) goto L42
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f13223l     // Catch: java.lang.Throwable -> L7e
            r1.remove(r6)     // Catch: java.lang.Throwable -> L7e
            r1 = r10
            goto L50
        L42:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L7e
            r1[r11] = r2     // Catch: java.lang.Throwable -> L7e
            goto L31
        L50:
            if (r1 != 0) goto L5a
        L52:
            boolean r1 = r12.f13222k     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L79
            int r1 = r12.n     // Catch: java.lang.Throwable -> L7e
            if (r1 != r10) goto L79
        L5a:
            com.google.android.gms.common.stats.d r1 = com.google.android.gms.common.stats.d.a()     // Catch: java.lang.Throwable -> L7e
            android.content.Context r2 = r12.f13221j     // Catch: java.lang.Throwable -> L7e
            android.os.PowerManager$WakeLock r3 = r12.f13215d     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = com.google.android.gms.common.stats.c.a(r3, r6)     // Catch: java.lang.Throwable -> L7e
            r4 = 8
            java.lang.String r5 = r12.f13218g     // Catch: java.lang.Throwable -> L7e
            r7 = 0
            int r8 = r12.f13217f     // Catch: java.lang.Throwable -> L7e
            java.util.List r9 = r12.e()     // Catch: java.lang.Throwable -> L7e
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7e
            int r1 = r12.n     // Catch: java.lang.Throwable -> L7e
            int r1 = r1 - r10
            r12.n = r1     // Catch: java.lang.Throwable -> L7e
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r12.f(r11)
            return
        L7e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.g.a.e.i.a.b():void");
    }

    public void c(boolean z) {
        this.f13215d.setReferenceCounted(z);
        this.f13222k = z;
    }

    private a(Context context, int i2, String str, String str2, String str3) {
        this(context, i2, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private a(Context context, int i2, String str, String str2, String str3, String str4) {
        this.f13214c = this;
        this.f13222k = true;
        this.f13223l = new HashMap();
        this.m = Collections.synchronizedSet(new HashSet());
        this.o = new AtomicInteger(0);
        t.l(context, "WakeLock: context must not be null");
        t.h(str, "WakeLock: wakeLockName must not be empty");
        this.f13217f = i2;
        this.f13219h = null;
        this.f13220i = null;
        Context applicationContext = context.getApplicationContext();
        this.f13221j = applicationContext;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.f13218g = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.f13218g = str;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        this.f13215d = newWakeLock;
        if (p.c(context)) {
            WorkSource a2 = p.a(context, n.a(str3) ? context.getPackageName() : str3);
            this.f13216e = a2;
            if (a2 != null && p.c(applicationContext)) {
                WorkSource workSource = this.f13216e;
                if (workSource != null) {
                    workSource.add(a2);
                } else {
                    this.f13216e = a2;
                }
                try {
                    newWakeLock.setWorkSource(this.f13216e);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (a == null) {
            a = com.google.android.gms.common.m.a.a().a();
        }
    }
}