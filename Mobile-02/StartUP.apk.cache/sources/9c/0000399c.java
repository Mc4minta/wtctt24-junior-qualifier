package com.google.firebase.crashlytics.c.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.google.firebase.crashlytics.c.f.b;
import com.google.firebase.crashlytics.c.g.o;
import com.google.firebase.crashlytics.c.h.b;
import com.google.firebase.crashlytics.c.n.b;
import com.google.firebase.crashlytics.c.n.c.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class j {
    static final FilenameFilter a = new k("BeginSession");

    /* renamed from: b  reason: collision with root package name */
    static final FilenameFilter f8702b = new p();

    /* renamed from: c  reason: collision with root package name */
    static final Comparator<File> f8703c = new q();

    /* renamed from: d  reason: collision with root package name */
    static final Comparator<File> f8704d = new r();

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f8705e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, String> f8706f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", DiskLruCache.VERSION_1);

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f8707g = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final com.google.firebase.analytics.a.a A;
    private final com.google.firebase.crashlytics.c.g.e0 B;
    private com.google.firebase.crashlytics.c.g.o C;

    /* renamed from: i  reason: collision with root package name */
    private final Context f8709i;

    /* renamed from: j  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.g.q f8710j;

    /* renamed from: k  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.g.l f8711k;

    /* renamed from: l  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.g.g0 f8712l;
    private final com.google.firebase.crashlytics.c.g.i m;
    private final com.google.firebase.crashlytics.c.k.c n;
    private final com.google.firebase.crashlytics.c.g.v o;
    private final com.google.firebase.crashlytics.c.l.h p;
    private final com.google.firebase.crashlytics.c.g.b q;
    private final b.InterfaceC0186b r;
    private final c0 s;
    private final com.google.firebase.crashlytics.c.h.b t;
    private final com.google.firebase.crashlytics.c.n.a u;
    private final b.a v;
    private final com.google.firebase.crashlytics.c.a w;
    private final com.google.firebase.crashlytics.c.q.d x;
    private final String y;
    private final com.google.firebase.crashlytics.c.f.b z;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInteger f8708h = new AtomicInteger(0);
    com.google.android.gms.tasks.h<Boolean> D = new com.google.android.gms.tasks.h<>();
    com.google.android.gms.tasks.h<Boolean> E = new com.google.android.gms.tasks.h<>();
    com.google.android.gms.tasks.h<Void> F = new com.google.android.gms.tasks.h<>();
    AtomicBoolean G = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class a implements Callable<Void> {
        final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8713b;

        a(long j2, String str) {
            this.a = j2;
            this.f8713b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            if (j.this.g0()) {
                return null;
            }
            j.this.t.i(this.a, this.f8713b);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static class a0 implements FilenameFilter {
        private final String a;

        public a0(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.a) && !str.endsWith(".cls_temp");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final /* synthetic */ Date a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f8715b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Thread f8716c;

        b(Date date, Throwable th, Thread thread) {
            this.a = date;
            this.f8715b = th;
            this.f8716c = thread;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.g0()) {
                return;
            }
            long c0 = j.c0(this.a);
            j.this.B.l(this.f8715b, this.f8716c, c0);
            j.this.M(this.f8716c, this.f8715b, c0);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    static class b0 implements FilenameFilter {
        b0() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return com.google.firebase.crashlytics.c.m.b.a.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class c implements Callable<Void> {
        final /* synthetic */ com.google.firebase.crashlytics.c.g.g0 a;

        c(com.google.firebase.crashlytics.c.g.g0 g0Var) {
            this.a = g0Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            j.this.B.m();
            new com.google.firebase.crashlytics.c.g.y(j.this.X()).i(j.this.U(), this.a);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class c0 implements b.InterfaceC0168b {
        private final com.google.firebase.crashlytics.c.l.h a;

        public c0(com.google.firebase.crashlytics.c.l.h hVar) {
            this.a = hVar;
        }

        @Override // com.google.firebase.crashlytics.c.h.b.InterfaceC0168b
        public File a() {
            File file = new File(this.a.b(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class d implements Callable<Void> {
        final /* synthetic */ Map a;

        d(Map map) {
            this.a = map;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            new com.google.firebase.crashlytics.c.g.y(j.this.X()).h(j.this.U(), this.a);
            return null;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private final class d0 implements b.c {
        private d0() {
        }

        @Override // com.google.firebase.crashlytics.c.n.b.c
        public File[] a() {
            return j.this.k0();
        }

        @Override // com.google.firebase.crashlytics.c.n.b.c
        public File[] b() {
            return j.this.h0();
        }

        /* synthetic */ d0(j jVar, k kVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class e implements Callable<Void> {
        e() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            j.this.L();
            return null;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private final class e0 implements b.a {
        private e0() {
        }

        @Override // com.google.firebase.crashlytics.c.n.b.a
        public boolean a() {
            return j.this.g0();
        }

        /* synthetic */ e0(j jVar, k kVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            jVar.I(jVar.j0(new b0()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class f0 implements Runnable {
        private final Context a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.firebase.crashlytics.c.n.c.c f8720b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.firebase.crashlytics.c.n.b f8721c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f8722d;

        public f0(Context context, com.google.firebase.crashlytics.c.n.c.c cVar, com.google.firebase.crashlytics.c.n.b bVar, boolean z) {
            this.a = context;
            this.f8720b = cVar;
            this.f8721c = bVar;
            this.f8722d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.google.firebase.crashlytics.c.g.h.c(this.a)) {
                com.google.firebase.crashlytics.c.b.f().b("Attempting to send crash report at time of crash...");
                this.f8721c.d(this.f8720b, this.f8722d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class g implements FilenameFilter {
        final /* synthetic */ Set a;

        g(Set set) {
            this.a = set;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (str.length() < 35) {
                return false;
            }
            return this.a.contains(str.substring(0, 35));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static class g0 implements FilenameFilter {
        private final String a;

        public g0(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(".cls");
            return (str.equals(sb.toString()) || !str.contains(this.a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class h implements z {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8724b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f8725c;

        h(String str, String str2, long j2) {
            this.a = str;
            this.f8724b = str2;
            this.f8725c = j2;
        }

        @Override // com.google.firebase.crashlytics.c.g.j.z
        public void a(com.google.firebase.crashlytics.c.m.c cVar) throws Exception {
            com.google.firebase.crashlytics.c.m.d.p(cVar, this.a, this.f8724b, this.f8725c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class i implements z {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8727b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f8728c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f8729d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f8730e;

        i(String str, String str2, String str3, String str4, int i2) {
            this.a = str;
            this.f8727b = str2;
            this.f8728c = str3;
            this.f8729d = str4;
            this.f8730e = i2;
        }

        @Override // com.google.firebase.crashlytics.c.g.j.z
        public void a(com.google.firebase.crashlytics.c.m.c cVar) throws Exception {
            com.google.firebase.crashlytics.c.m.d.r(cVar, this.a, this.f8727b, this.f8728c, this.f8729d, this.f8730e, j.this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.c.g.j$j  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0165j implements z {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8732b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f8733c;

        C0165j(String str, String str2, boolean z) {
            this.a = str;
            this.f8732b = str2;
            this.f8733c = z;
        }

        @Override // com.google.firebase.crashlytics.c.g.j.z
        public void a(com.google.firebase.crashlytics.c.m.c cVar) throws Exception {
            com.google.firebase.crashlytics.c.m.d.B(cVar, this.a, this.f8732b, this.f8733c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class k extends a0 {
        k(String str) {
            super(str);
        }

        @Override // com.google.firebase.crashlytics.c.g.j.a0, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class l implements z {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f8735b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f8736c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f8737d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f8738e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f8739f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f8740g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f8741h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f8742i;

        l(int i2, String str, int i3, long j2, long j3, boolean z, int i4, String str2, String str3) {
            this.a = i2;
            this.f8735b = str;
            this.f8736c = i3;
            this.f8737d = j2;
            this.f8738e = j3;
            this.f8739f = z;
            this.f8740g = i4;
            this.f8741h = str2;
            this.f8742i = str3;
        }

        @Override // com.google.firebase.crashlytics.c.g.j.z
        public void a(com.google.firebase.crashlytics.c.m.c cVar) throws Exception {
            com.google.firebase.crashlytics.c.m.d.t(cVar, this.a, this.f8735b, this.f8736c, this.f8737d, this.f8738e, this.f8739f, this.f8740g, this.f8741h, this.f8742i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class m implements z {
        final /* synthetic */ com.google.firebase.crashlytics.c.g.g0 a;

        m(com.google.firebase.crashlytics.c.g.g0 g0Var) {
            this.a = g0Var;
        }

        @Override // com.google.firebase.crashlytics.c.g.j.z
        public void a(com.google.firebase.crashlytics.c.m.c cVar) throws Exception {
            com.google.firebase.crashlytics.c.m.d.C(cVar, this.a.b(), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class n implements z {
        final /* synthetic */ String a;

        n(String str) {
            this.a = str;
        }

        @Override // com.google.firebase.crashlytics.c.g.j.z
        public void a(com.google.firebase.crashlytics.c.m.c cVar) throws Exception {
            com.google.firebase.crashlytics.c.m.d.s(cVar, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class o implements Callable<Void> {
        final /* synthetic */ long a;

        o(long j2) {
            this.a = j2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            if (!j.this.R()) {
                if (j.this.A == null) {
                    com.google.firebase.crashlytics.c.b.f().b("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
                    return null;
                }
                y yVar = new y(null);
                j.this.z.a(yVar);
                com.google.firebase.crashlytics.c.b.f().b("Logging Crashlytics event to Firebase");
                Bundle bundle = new Bundle();
                bundle.putInt("fatal", 1);
                bundle.putLong("timestamp", this.a);
                j.this.A.c("clx", "_ae", bundle);
                yVar.b();
                j.this.z.a(null);
                return null;
            }
            com.google.firebase.crashlytics.c.b.f().b("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return null;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class p implements FilenameFilter {
        p() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class q implements Comparator<File> {
        q() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class r implements Comparator<File> {
        r() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class s implements o.a {
        s() {
        }

        @Override // com.google.firebase.crashlytics.c.g.o.a
        public void a(com.google.firebase.crashlytics.c.p.e eVar, Thread thread, Throwable th) {
            j.this.f0(eVar, thread, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class t implements Callable<com.google.android.gms.tasks.g<Void>> {
        final /* synthetic */ Date a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f8746b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Thread f8747c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.crashlytics.c.p.e f8748d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.google.android.gms.tasks.g f8749e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
        /* loaded from: classes2.dex */
        public class a implements com.google.android.gms.tasks.f<com.google.firebase.crashlytics.c.p.i.b, Void> {
            final /* synthetic */ Executor a;

            a(Executor executor) {
                this.a = executor;
            }

            @Override // com.google.android.gms.tasks.f
            /* renamed from: b */
            public com.google.android.gms.tasks.g<Void> a(com.google.firebase.crashlytics.c.p.i.b bVar) throws Exception {
                if (bVar != null) {
                    j.this.t0(bVar, true);
                    j.this.B.o(this.a, com.google.firebase.crashlytics.c.g.r.h(bVar));
                    return t.this.f8749e;
                }
                com.google.firebase.crashlytics.c.b.f().i("Received null app settings, cannot send reports at crash time.");
                return com.google.android.gms.tasks.j.e(null);
            }
        }

        t(Date date, Throwable th, Thread thread, com.google.firebase.crashlytics.c.p.e eVar, com.google.android.gms.tasks.g gVar) {
            this.a = date;
            this.f8746b = th;
            this.f8747c = thread;
            this.f8748d = eVar;
            this.f8749e = gVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public com.google.android.gms.tasks.g<Void> call() throws Exception {
            j.this.f8711k.a();
            long c0 = j.c0(this.a);
            j.this.B.k(this.f8746b, this.f8747c, c0);
            j.this.D0(this.f8747c, this.f8746b, c0);
            com.google.firebase.crashlytics.c.p.i.e b2 = this.f8748d.b();
            int i2 = b2.b().a;
            int i3 = b2.b().f9056b;
            j.this.J(i2);
            j.this.L();
            j.this.A0(i3);
            if (j.this.f8710j.b()) {
                Executor c2 = j.this.m.c();
                return this.f8748d.a().s(c2, new a(c2));
            }
            return com.google.android.gms.tasks.j.e(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class u implements com.google.android.gms.tasks.f<Void, Boolean> {
        u() {
        }

        @Override // com.google.android.gms.tasks.f
        /* renamed from: b */
        public com.google.android.gms.tasks.g<Boolean> a(Void r1) throws Exception {
            return com.google.android.gms.tasks.j.e(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class v implements com.google.android.gms.tasks.f<Boolean, Void> {
        final /* synthetic */ com.google.android.gms.tasks.g a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8752b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
        /* loaded from: classes2.dex */
        public class a implements Callable<com.google.android.gms.tasks.g<Void>> {
            final /* synthetic */ Boolean a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
            /* renamed from: com.google.firebase.crashlytics.c.g.j$v$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0166a implements com.google.android.gms.tasks.f<com.google.firebase.crashlytics.c.p.i.b, Void> {
                final /* synthetic */ List a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ boolean f8755b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Executor f8756c;

                C0166a(List list, boolean z, Executor executor) {
                    this.a = list;
                    this.f8755b = z;
                    this.f8756c = executor;
                }

                @Override // com.google.android.gms.tasks.f
                /* renamed from: b */
                public com.google.android.gms.tasks.g<Void> a(com.google.firebase.crashlytics.c.p.i.b bVar) throws Exception {
                    if (bVar == null) {
                        com.google.firebase.crashlytics.c.b.f().i("Received null app settings, cannot send reports during app startup.");
                        return com.google.android.gms.tasks.j.e(null);
                    }
                    for (com.google.firebase.crashlytics.c.n.c.c cVar : this.a) {
                        if (cVar.getType() == c.a.JAVA) {
                            j.x(bVar.f9052f, cVar.c());
                        }
                    }
                    j.this.r.a(bVar).e(this.a, this.f8755b, v.this.f8752b);
                    j.this.B.o(this.f8756c, com.google.firebase.crashlytics.c.g.r.h(bVar));
                    j.this.F.e(null);
                    return com.google.android.gms.tasks.j.e(null);
                }
            }

            a(Boolean bool) {
                this.a = bool;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public com.google.android.gms.tasks.g<Void> call() throws Exception {
                List<com.google.firebase.crashlytics.c.n.c.c> d2 = j.this.u.d();
                if (!this.a.booleanValue()) {
                    com.google.firebase.crashlytics.c.b.f().b("Reports are being deleted.");
                    j.this.u.c(d2);
                    j.this.B.n();
                    j.this.F.e(null);
                    return com.google.android.gms.tasks.j.e(null);
                }
                com.google.firebase.crashlytics.c.b.f().b("Reports are being sent.");
                boolean booleanValue = this.a.booleanValue();
                j.this.f8710j.a(booleanValue);
                Executor c2 = j.this.m.c();
                return v.this.a.s(c2, new C0166a(d2, booleanValue, c2));
            }
        }

        v(com.google.android.gms.tasks.g gVar, float f2) {
            this.a = gVar;
            this.f8752b = f2;
        }

        @Override // com.google.android.gms.tasks.f
        /* renamed from: b */
        public com.google.android.gms.tasks.g<Void> a(Boolean bool) throws Exception {
            return j.this.m.i(new a(bool));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class w implements b.InterfaceC0186b {
        w() {
        }

        @Override // com.google.firebase.crashlytics.c.n.b.InterfaceC0186b
        public com.google.firebase.crashlytics.c.n.b a(com.google.firebase.crashlytics.c.p.i.b bVar) {
            String str = bVar.f9049c;
            String str2 = bVar.f9050d;
            return new com.google.firebase.crashlytics.c.n.b(bVar.f9052f, j.this.q.a, com.google.firebase.crashlytics.c.g.r.h(bVar), j.this.u, j.this.T(str, str2), j.this.v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static class x implements FilenameFilter {
        private x() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !j.f8702b.accept(file, str) && j.f8705e.matcher(str).matches();
        }

        /* synthetic */ x(k kVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public interface z {
        void a(com.google.firebase.crashlytics.c.m.c cVar) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, com.google.firebase.crashlytics.c.g.i iVar, com.google.firebase.crashlytics.c.k.c cVar, com.google.firebase.crashlytics.c.g.v vVar, com.google.firebase.crashlytics.c.g.q qVar, com.google.firebase.crashlytics.c.l.h hVar, com.google.firebase.crashlytics.c.g.l lVar, com.google.firebase.crashlytics.c.g.b bVar, com.google.firebase.crashlytics.c.n.a aVar, b.InterfaceC0186b interfaceC0186b, com.google.firebase.crashlytics.c.a aVar2, com.google.firebase.crashlytics.c.r.b bVar2, com.google.firebase.crashlytics.c.f.b bVar3, com.google.firebase.analytics.a.a aVar3, com.google.firebase.crashlytics.c.p.e eVar) {
        this.f8709i = context;
        this.m = iVar;
        this.n = cVar;
        this.o = vVar;
        this.f8710j = qVar;
        this.p = hVar;
        this.f8711k = lVar;
        this.q = bVar;
        if (interfaceC0186b != null) {
            this.r = interfaceC0186b;
        } else {
            this.r = F();
        }
        this.w = aVar2;
        this.y = bVar2.a();
        this.z = bVar3;
        this.A = aVar3;
        com.google.firebase.crashlytics.c.g.g0 g0Var = new com.google.firebase.crashlytics.c.g.g0();
        this.f8712l = g0Var;
        c0 c0Var = new c0(hVar);
        this.s = c0Var;
        com.google.firebase.crashlytics.c.h.b bVar4 = new com.google.firebase.crashlytics.c.h.b(context, c0Var);
        this.t = bVar4;
        this.u = aVar == null ? new com.google.firebase.crashlytics.c.n.a(new d0(this, null)) : aVar;
        this.v = new e0(this, null);
        com.google.firebase.crashlytics.c.q.a aVar4 = new com.google.firebase.crashlytics.c.q.a(1024, new com.google.firebase.crashlytics.c.q.c(10));
        this.x = aVar4;
        this.B = com.google.firebase.crashlytics.c.g.e0.b(context, vVar, hVar, bVar, bVar4, g0Var, aVar4, eVar);
    }

    private void A(com.google.firebase.crashlytics.c.g.g0 g0Var) {
        this.m.h(new c(g0Var));
    }

    private com.google.android.gms.tasks.g<Boolean> B0() {
        if (this.f8710j.b()) {
            com.google.firebase.crashlytics.c.b.f().b("Automatic data collection is enabled. Allowing upload.");
            this.D.e(Boolean.FALSE);
            return com.google.android.gms.tasks.j.e(Boolean.TRUE);
        }
        com.google.firebase.crashlytics.c.b.f().b("Automatic data collection is disabled.");
        com.google.firebase.crashlytics.c.b.f().b("Notifying that unsent reports are available.");
        this.D.e(Boolean.TRUE);
        com.google.android.gms.tasks.g<TContinuationResult> r2 = this.f8710j.c().r(new u());
        com.google.firebase.crashlytics.c.b.f().b("Waiting for send/deleteUnsentReports to be called.");
        return h0.g(r2, this.E.a());
    }

    private void C(File[] fileArr, int i2, int i3) {
        com.google.firebase.crashlytics.c.b.f().b("Closing open sessions.");
        while (i2 < fileArr.length) {
            File file = fileArr[i2];
            String b02 = b0(file);
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.b("Closing session: " + b02);
            M0(file, b02, i3);
            i2++;
        }
    }

    private void C0(String str, long j2) throws Exception {
        String format = String.format(Locale.US, "Crashlytics Android SDK/%s", com.google.firebase.crashlytics.c.g.k.i());
        L0(str, "BeginSession", new h(str, format, j2));
        this.w.d(str, format, j2);
    }

    private void D(com.google.firebase.crashlytics.c.m.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            bVar.a();
        } catch (IOException e2) {
            com.google.firebase.crashlytics.c.b.f().e("Error closing session file stream in the presence of an exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(Thread thread, Throwable th, long j2) {
        com.google.firebase.crashlytics.c.m.b bVar;
        String U;
        com.google.firebase.crashlytics.c.m.c cVar = null;
        try {
            U = U();
        } catch (Exception e2) {
            e = e2;
            bVar = null;
        } catch (Throwable th2) {
            th = th2;
            bVar = null;
            com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to session begin file.");
            com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close fatal exception file output stream.");
            throw th;
        }
        if (U == null) {
            com.google.firebase.crashlytics.c.b.f().d("Tried to write a fatal exception while no session was open.");
            com.google.firebase.crashlytics.c.g.h.j(null, "Failed to flush to session begin file.");
            com.google.firebase.crashlytics.c.g.h.e(null, "Failed to close fatal exception file output stream.");
            return;
        }
        bVar = new com.google.firebase.crashlytics.c.m.b(X(), U + "SessionCrash");
        try {
            try {
                cVar = com.google.firebase.crashlytics.c.m.c.u(bVar);
                J0(cVar, thread, th, j2, "crash", true);
            } catch (Throwable th3) {
                th = th3;
                com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to session begin file.");
                com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close fatal exception file output stream.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            com.google.firebase.crashlytics.c.b.f().e("An error occurred in the fatal exception logger", e);
            com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to session begin file.");
            com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close fatal exception file output stream.");
        }
        com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to session begin file.");
        com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close fatal exception file output stream.");
    }

    private static void E(InputStream inputStream, com.google.firebase.crashlytics.c.m.c cVar, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        cVar.O(bArr);
    }

    private void E0(com.google.firebase.crashlytics.c.m.c cVar, String str) throws IOException {
        String[] strArr;
        for (String str2 : f8707g) {
            File[] j0 = j0(new a0(str + str2 + ".cls"));
            if (j0.length == 0) {
                com.google.firebase.crashlytics.c.b.f().b("Can't find " + str2 + " data for session ID " + str);
            } else {
                com.google.firebase.crashlytics.c.b.f().b("Collecting " + str2 + " data for session ID " + str);
                O0(cVar, j0[0]);
            }
        }
    }

    private b.InterfaceC0186b F() {
        return new w();
    }

    private static void F0(com.google.firebase.crashlytics.c.m.c cVar, File[] fileArr, String str) {
        Arrays.sort(fileArr, com.google.firebase.crashlytics.c.g.h.f8684c);
        for (File file : fileArr) {
            try {
                com.google.firebase.crashlytics.c.b.f().b(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                O0(cVar, file);
            } catch (Exception e2) {
                com.google.firebase.crashlytics.c.b.f().e("Error writting non-fatal to session.", e2);
            }
        }
    }

    private void G(String str) {
        for (File file : m0(str)) {
            file.delete();
        }
    }

    private void H0(String str) throws Exception {
        String d2 = this.o.d();
        com.google.firebase.crashlytics.c.g.b bVar = this.q;
        String str2 = bVar.f8670e;
        String str3 = bVar.f8671f;
        String a2 = this.o.a();
        int n2 = com.google.firebase.crashlytics.c.g.s.h(this.q.f8668c).n();
        L0(str, "SessionApp", new i(d2, str2, str3, a2, n2));
        this.w.f(str, d2, str2, str3, a2, n2, this.y);
    }

    private void I0(String str) throws Exception {
        Context S = S();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int m2 = com.google.firebase.crashlytics.c.g.h.m();
        String str2 = Build.MODEL;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long v2 = com.google.firebase.crashlytics.c.g.h.v();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean C = com.google.firebase.crashlytics.c.g.h.C(S);
        int n2 = com.google.firebase.crashlytics.c.g.h.n(S);
        String str3 = Build.MANUFACTURER;
        String str4 = Build.PRODUCT;
        L0(str, "SessionDevice", new l(m2, str2, availableProcessors, v2, blockCount, C, n2, str3, str4));
        this.w.c(str, m2, str2, availableProcessors, v2, blockCount, C, n2, str3, str4);
    }

    private void J0(com.google.firebase.crashlytics.c.m.c cVar, Thread thread, Throwable th, long j2, String str, boolean z2) throws Exception {
        Thread[] threadArr;
        Map<String, String> a2;
        TreeMap treeMap;
        com.google.firebase.crashlytics.c.q.e eVar = new com.google.firebase.crashlytics.c.q.e(th, this.x);
        Context S = S();
        com.google.firebase.crashlytics.c.g.e a3 = com.google.firebase.crashlytics.c.g.e.a(S);
        Float b2 = a3.b();
        int c2 = a3.c();
        boolean q2 = com.google.firebase.crashlytics.c.g.h.q(S);
        int i2 = S.getResources().getConfiguration().orientation;
        long v2 = com.google.firebase.crashlytics.c.g.h.v() - com.google.firebase.crashlytics.c.g.h.a(S);
        long b3 = com.google.firebase.crashlytics.c.g.h.b(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo k2 = com.google.firebase.crashlytics.c.g.h.k(S.getPackageName(), S);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = eVar.f9075c;
        String str2 = this.q.f8667b;
        String d2 = this.o.d();
        int i3 = 0;
        if (z2) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i3] = entry.getKey();
                linkedList.add(this.x.a(entry.getValue()));
                i3++;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (!com.google.firebase.crashlytics.c.g.h.l(S, "com.crashlytics.CollectCustomKeys", true)) {
            a2 = new TreeMap<>();
        } else {
            a2 = this.f8712l.a();
            if (a2 != null && a2.size() > 1) {
                treeMap = new TreeMap(a2);
                com.google.firebase.crashlytics.c.m.d.u(cVar, j2, str, eVar, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.t.c(), k2, i2, d2, str2, b2, c2, q2, v2, b3);
                this.t.a();
            }
        }
        treeMap = a2;
        com.google.firebase.crashlytics.c.m.d.u(cVar, j2, str, eVar, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.t.c(), k2, i2, d2, str2, b2, c2, q2, v2, b3);
        this.t.a();
    }

    private void K(int i2, boolean z2) throws Exception {
        int i3 = !z2 ? 1 : 0;
        y0(i3 + 8);
        File[] n0 = n0();
        if (n0.length <= i3) {
            com.google.firebase.crashlytics.c.b.f().b("No open sessions to be closed.");
            return;
        }
        String b02 = b0(n0[i3]);
        N0(b02);
        if (z2) {
            this.B.h();
        } else if (this.w.e(b02)) {
            P(b02);
            if (!this.w.a(b02)) {
                com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
                f2.b("Could not finalize native session: " + b02);
            }
        }
        C(n0, i3, i2);
        this.B.d(V());
    }

    private void K0(String str) throws Exception {
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.VERSION.CODENAME;
        boolean E = com.google.firebase.crashlytics.c.g.h.E(S());
        L0(str, "SessionOS", new C0165j(str2, str3, E));
        this.w.g(str, str2, str3, E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() throws Exception {
        long V = V();
        String gVar = new com.google.firebase.crashlytics.c.g.g(this.o).toString();
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("Opening a new session with ID " + gVar);
        this.w.h(gVar);
        C0(gVar, V);
        H0(gVar);
        K0(gVar);
        I0(gVar);
        this.t.g(gVar);
        this.B.g(o0(gVar), V);
    }

    private void L0(String str, String str2, z zVar) throws Exception {
        com.google.firebase.crashlytics.c.m.b bVar;
        com.google.firebase.crashlytics.c.m.c cVar = null;
        try {
            bVar = new com.google.firebase.crashlytics.c.m.b(X(), str + str2);
        } catch (Throwable th) {
            th = th;
            bVar = null;
        }
        try {
            cVar = com.google.firebase.crashlytics.c.m.c.u(bVar);
            zVar.a(cVar);
            com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to session " + str2 + " file.");
            com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close session " + str2 + " file.");
        } catch (Throwable th2) {
            th = th2;
            com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to session " + str2 + " file.");
            com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close session " + str2 + " file.");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Thread thread, Throwable th, long j2) {
        com.google.firebase.crashlytics.c.m.b bVar;
        String U = U();
        if (U == null) {
            com.google.firebase.crashlytics.c.b.f().b("Tried to write a non-fatal exception while no session was open.");
            return;
        }
        com.google.firebase.crashlytics.c.m.c cVar = null;
        try {
            com.google.firebase.crashlytics.c.b.f().b("Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
            bVar = new com.google.firebase.crashlytics.c.m.b(X(), U + "SessionEvent" + com.google.firebase.crashlytics.c.g.h.F(this.f8708h.getAndIncrement()));
            try {
                try {
                    com.google.firebase.crashlytics.c.m.c u2 = com.google.firebase.crashlytics.c.m.c.u(bVar);
                    try {
                        J0(u2, thread, th, j2, "error", false);
                        com.google.firebase.crashlytics.c.g.h.j(u2, "Failed to flush to non-fatal file.");
                    } catch (Exception e2) {
                        e = e2;
                        cVar = u2;
                        com.google.firebase.crashlytics.c.b.f().e("An error occurred in the non-fatal exception logger", e);
                        com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to non-fatal file.");
                        com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close non-fatal file output stream.");
                        z0(U, 64);
                    } catch (Throwable th2) {
                        th = th2;
                        cVar = u2;
                        com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to non-fatal file.");
                        com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close non-fatal file output stream.");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            bVar = null;
        } catch (Throwable th4) {
            th = th4;
            bVar = null;
        }
        com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close non-fatal file output stream.");
        try {
            z0(U, 64);
        } catch (Exception e5) {
            com.google.firebase.crashlytics.c.b.f().e("An error occurred when trimming non-fatal files.", e5);
        }
    }

    private void M0(File file, String str, int i2) {
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("Collecting session parts for ID " + str);
        File[] j0 = j0(new a0(str + "SessionCrash"));
        boolean z2 = j0 != null && j0.length > 0;
        com.google.firebase.crashlytics.c.b f3 = com.google.firebase.crashlytics.c.b.f();
        Locale locale = Locale.US;
        f3.b(String.format(locale, "Session %s has fatal exception: %s", str, Boolean.valueOf(z2)));
        File[] j02 = j0(new a0(str + "SessionEvent"));
        boolean z3 = j02 != null && j02.length > 0;
        com.google.firebase.crashlytics.c.b.f().b(String.format(locale, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z3)));
        if (!z2 && !z3) {
            com.google.firebase.crashlytics.c.b f4 = com.google.firebase.crashlytics.c.b.f();
            f4.b("No events present for session ID " + str);
        } else {
            x0(file, str, d0(str, j02, i2), z2 ? j0[0] : null);
        }
        com.google.firebase.crashlytics.c.b f5 = com.google.firebase.crashlytics.c.b.f();
        f5.b("Removing session part files for ID " + str);
        G(str);
    }

    private void N0(String str) throws Exception {
        L0(str, "SessionUser", new m(e0(str)));
    }

    private File[] O(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private static void O0(com.google.firebase.crashlytics.c.m.c cVar, File file) throws IOException {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.d("Tried to include a file that doesn't exist: " + file.getName());
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            E(fileInputStream, cVar, (int) file.length());
            com.google.firebase.crashlytics.c.g.h.e(fileInputStream, "Failed to close file input stream.");
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            com.google.firebase.crashlytics.c.g.h.e(fileInputStream2, "Failed to close file input stream.");
            throw th;
        }
    }

    private void P(String str) {
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("Finalizing native report for session " + str);
        com.google.firebase.crashlytics.c.d b2 = this.w.b(str);
        File e2 = b2.e();
        if (e2 != null && e2.exists()) {
            com.google.firebase.crashlytics.c.h.b bVar = new com.google.firebase.crashlytics.c.h.b(this.f8709i, this.s, str);
            File file = new File(Z(), str);
            if (!file.mkdirs()) {
                com.google.firebase.crashlytics.c.b.f().b("Couldn't create native sessions directory");
                return;
            }
            List<com.google.firebase.crashlytics.c.g.z> Y = Y(b2, str, S(), X(), bVar.c());
            com.google.firebase.crashlytics.c.g.a0.b(file, Y);
            this.B.c(o0(str), Y);
            bVar.a();
            return;
        }
        com.google.firebase.crashlytics.c.b f3 = com.google.firebase.crashlytics.c.b.f();
        f3.i("No minidump data found for session " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private Context S() {
        return this.f8709i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.firebase.crashlytics.c.n.d.b T(String str, String str2) {
        String u2 = com.google.firebase.crashlytics.c.g.h.u(S(), "com.crashlytics.ApiEndpoint");
        return new com.google.firebase.crashlytics.c.n.d.a(new com.google.firebase.crashlytics.c.n.d.c(u2, str, this.n, com.google.firebase.crashlytics.c.g.k.i()), new com.google.firebase.crashlytics.c.n.d.d(u2, str2, this.n, com.google.firebase.crashlytics.c.g.k.i()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String U() {
        File[] n0 = n0();
        if (n0.length > 0) {
            return b0(n0[0]);
        }
        return null;
    }

    private static long V() {
        return c0(new Date());
    }

    static List<com.google.firebase.crashlytics.c.g.z> Y(com.google.firebase.crashlytics.c.d dVar, String str, Context context, File file, byte[] bArr) {
        byte[] bArr2;
        com.google.firebase.crashlytics.c.g.y yVar = new com.google.firebase.crashlytics.c.g.y(file);
        File b2 = yVar.b(str);
        File a2 = yVar.a(str);
        try {
            bArr2 = com.google.firebase.crashlytics.c.j.b.a(dVar.d(), context);
        } catch (Exception unused) {
            bArr2 = null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.google.firebase.crashlytics.c.g.f("logs_file", "logs", bArr));
        arrayList.add(new com.google.firebase.crashlytics.c.g.f("binary_images_file", "binaryImages", bArr2));
        arrayList.add(new com.google.firebase.crashlytics.c.g.u("crash_meta_file", SendConfirmationArgs.metadataKey, dVar.g()));
        arrayList.add(new com.google.firebase.crashlytics.c.g.u("session_meta_file", "session", dVar.f()));
        arrayList.add(new com.google.firebase.crashlytics.c.g.u("app_meta_file", "app", dVar.a()));
        arrayList.add(new com.google.firebase.crashlytics.c.g.u("device_meta_file", "device", dVar.c()));
        arrayList.add(new com.google.firebase.crashlytics.c.g.u("os_meta_file", "os", dVar.b()));
        arrayList.add(new com.google.firebase.crashlytics.c.g.u("minidump_file", "minidump", dVar.e()));
        arrayList.add(new com.google.firebase.crashlytics.c.g.u("user_meta_file", ApiConstants.USER, b2));
        arrayList.add(new com.google.firebase.crashlytics.c.g.u("keys_file", "keys", a2));
        return arrayList;
    }

    static String b0(File file) {
        return file.getName().substring(0, 35);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long c0(Date date) {
        return date.getTime() / 1000;
    }

    private File[] d0(String str, File[] fileArr, int i2) {
        if (fileArr.length > i2) {
            com.google.firebase.crashlytics.c.b.f().b(String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i2)));
            z0(str, i2);
            return j0(new a0(str + "SessionEvent"));
        }
        return fileArr;
    }

    private com.google.firebase.crashlytics.c.g.g0 e0(String str) {
        if (g0()) {
            return this.f8712l;
        }
        return new com.google.firebase.crashlytics.c.g.y(X()).e(str);
    }

    private File[] i0(File file, FilenameFilter filenameFilter) {
        return O(file.listFiles(filenameFilter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File[] j0(FilenameFilter filenameFilter) {
        return i0(X(), filenameFilter);
    }

    private File[] m0(String str) {
        return j0(new g0(str));
    }

    private File[] n0() {
        File[] l0 = l0();
        Arrays.sort(l0, f8703c);
        return l0;
    }

    private static String o0(String str) {
        return str.replaceAll("-", "");
    }

    private com.google.android.gms.tasks.g<Void> q0(long j2) {
        return com.google.android.gms.tasks.j.c(new ScheduledThreadPoolExecutor(1), new o(j2));
    }

    private void s0(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = f8705e.matcher(name);
            if (!matcher.matches()) {
                com.google.firebase.crashlytics.c.b.f().b("Deleting unknown file: " + name);
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                com.google.firebase.crashlytics.c.b.f().b("Trimming session file: " + name);
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(com.google.firebase.crashlytics.c.p.i.b bVar, boolean z2) throws Exception {
        File[] h0;
        Context S = S();
        com.google.firebase.crashlytics.c.n.b a2 = this.r.a(bVar);
        for (File file : h0()) {
            x(bVar.f9052f, file);
            this.m.g(new f0(S, new com.google.firebase.crashlytics.c.n.c.d(file, f8706f), a2, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(String str, File file) throws Exception {
        if (str == null) {
            return;
        }
        y(file, new n(str));
    }

    private void x0(File file, String str, File[] fileArr, File file2) {
        com.google.firebase.crashlytics.c.m.b bVar;
        boolean z2 = file2 != null;
        File W = z2 ? W() : a0();
        if (!W.exists()) {
            W.mkdirs();
        }
        com.google.firebase.crashlytics.c.m.c cVar = null;
        try {
            try {
                bVar = new com.google.firebase.crashlytics.c.m.b(W, str);
            } catch (Exception e2) {
                e = e2;
                bVar = null;
            } catch (Throwable th) {
                th = th;
                com.google.firebase.crashlytics.c.g.h.j(null, "Error flushing session file stream");
                com.google.firebase.crashlytics.c.g.h.e(null, "Failed to close CLS file");
                throw th;
            }
            try {
                cVar = com.google.firebase.crashlytics.c.m.c.u(bVar);
                com.google.firebase.crashlytics.c.b.f().b("Collecting SessionStart data for session ID " + str);
                O0(cVar, file);
                cVar.b0(4, V());
                cVar.z(5, z2);
                cVar.Z(11, 1);
                cVar.E(12, 3);
                E0(cVar, str);
                F0(cVar, fileArr, str);
                if (z2) {
                    O0(cVar, file2);
                }
                com.google.firebase.crashlytics.c.g.h.j(cVar, "Error flushing session file stream");
                com.google.firebase.crashlytics.c.g.h.e(bVar, "Failed to close CLS file");
            } catch (Exception e3) {
                e = e3;
                com.google.firebase.crashlytics.c.b.f().e("Failed to write session file for session ID: " + str, e);
                com.google.firebase.crashlytics.c.g.h.j(cVar, "Error flushing session file stream");
                D(bVar);
            }
        } catch (Throwable th2) {
            th = th2;
            com.google.firebase.crashlytics.c.g.h.j(null, "Error flushing session file stream");
            com.google.firebase.crashlytics.c.g.h.e(null, "Failed to close CLS file");
            throw th;
        }
    }

    private static void y(File file, z zVar) throws Exception {
        FileOutputStream fileOutputStream;
        com.google.firebase.crashlytics.c.m.c cVar = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                cVar = com.google.firebase.crashlytics.c.m.c.u(fileOutputStream);
                zVar.a(cVar);
                com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to append to " + file.getPath());
                com.google.firebase.crashlytics.c.g.h.e(fileOutputStream, "Failed to close " + file.getPath());
            } catch (Throwable th) {
                th = th;
                com.google.firebase.crashlytics.c.g.h.j(cVar, "Failed to flush to append to " + file.getPath());
                com.google.firebase.crashlytics.c.g.h.e(fileOutputStream, "Failed to close " + file.getPath());
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    private void y0(int i2) {
        HashSet hashSet = new HashSet();
        File[] n0 = n0();
        int min = Math.min(i2, n0.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(b0(n0[i3]));
        }
        this.t.b(hashSet);
        s0(j0(new x(null)), hashSet);
    }

    private void z(Map<String, String> map) {
        this.m.h(new d(map));
    }

    private void z0(String str, int i2) {
        File X = X();
        h0.d(X, new a0(str + "SessionEvent"), i2, f8704d);
    }

    void A0(int i2) {
        File Z = Z();
        File W = W();
        Comparator<File> comparator = f8704d;
        int f2 = i2 - h0.f(Z, W, i2, comparator);
        h0.d(X(), f8702b, f2 - h0.c(a0(), f2, comparator), comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        this.m.g(new f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G0(Thread thread, Throwable th) {
        this.m.g(new b(new Date(), th, thread));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H() {
        if (!this.f8711k.c()) {
            String U = U();
            return U != null && this.w.e(U);
        }
        com.google.firebase.crashlytics.c.b.f().b("Found previous crash marker.");
        this.f8711k.d();
        return true;
    }

    void I(File[] fileArr) {
        File[] j0;
        HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            com.google.firebase.crashlytics.c.b.f().b("Found invalid session part file: " + file);
            hashSet.add(b0(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        for (File file2 : j0(new g(hashSet))) {
            com.google.firebase.crashlytics.c.b.f().b("Deleting invalid session file: " + file2);
            file2.delete();
        }
    }

    void J(int i2) throws Exception {
        K(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, com.google.firebase.crashlytics.c.p.e eVar) {
        p0();
        com.google.firebase.crashlytics.c.g.o oVar = new com.google.firebase.crashlytics.c.g.o(new s(), eVar, uncaughtExceptionHandler);
        this.C = oVar;
        Thread.setDefaultUncaughtExceptionHandler(oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0(long j2, String str) {
        this.m.h(new a(j2, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Q(int i2) {
        this.m.b();
        if (g0()) {
            com.google.firebase.crashlytics.c.b.f().b("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        com.google.firebase.crashlytics.c.b.f().b("Finalizing previously open sessions.");
        try {
            K(i2, false);
            com.google.firebase.crashlytics.c.b.f().b("Closed all previously open sessions");
            return true;
        } catch (Exception e2) {
            com.google.firebase.crashlytics.c.b.f().e("Unable to finalize previously open sessions.", e2);
            return false;
        }
    }

    File W() {
        return new File(X(), "fatal-sessions");
    }

    File X() {
        return this.p.b();
    }

    File Z() {
        return new File(X(), "native-sessions");
    }

    File a0() {
        return new File(X(), "nonfatal-sessions");
    }

    synchronized void f0(com.google.firebase.crashlytics.c.p.e eVar, Thread thread, Throwable th) {
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        Date date = new Date();
        try {
            h0.a(this.m.i(new t(date, th, thread, eVar, q0(date.getTime()))));
        } catch (Exception unused) {
        }
    }

    boolean g0() {
        com.google.firebase.crashlytics.c.g.o oVar = this.C;
        return oVar != null && oVar.a();
    }

    File[] h0() {
        LinkedList linkedList = new LinkedList();
        File W = W();
        FilenameFilter filenameFilter = f8702b;
        Collections.addAll(linkedList, i0(W, filenameFilter));
        Collections.addAll(linkedList, i0(a0(), filenameFilter));
        Collections.addAll(linkedList, i0(X(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    File[] k0() {
        return O(Z().listFiles());
    }

    File[] l0() {
        return j0(a);
    }

    void p0() {
        this.m.h(new e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r0() {
        boolean b2 = this.z.b();
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("Registered Firebase Analytics event listener for breadcrumbs: " + b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u0(String str, String str2) {
        try {
            this.f8712l.d(str, str2);
            z(this.f8712l.a());
        } catch (IllegalArgumentException e2) {
            Context context = this.f8709i;
            if (context != null && com.google.firebase.crashlytics.c.g.h.A(context)) {
                throw e2;
            }
            com.google.firebase.crashlytics.c.b.f().d("Attempting to set custom attribute with null key, ignoring.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v0(String str) {
        this.f8712l.e(str);
        A(this.f8712l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.gms.tasks.g<Void> w0(float f2, com.google.android.gms.tasks.g<com.google.firebase.crashlytics.c.p.i.b> gVar) {
        if (!this.u.a()) {
            com.google.firebase.crashlytics.c.b.f().b("No reports are available.");
            this.D.e(Boolean.FALSE);
            return com.google.android.gms.tasks.j.e(null);
        }
        com.google.firebase.crashlytics.c.b.f().b("Unsent reports are available.");
        return B0().r(new v(gVar, f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static class y implements b.a {
        private final CountDownLatch a;

        private y() {
            this.a = new CountDownLatch(1);
        }

        @Override // com.google.firebase.crashlytics.c.f.b.a
        public void a(int i2, Bundle bundle) {
            if ("_ae".equals(bundle.getString(ApiConstants.NAME))) {
                this.a.countDown();
            }
        }

        public void b() throws InterruptedException {
            com.google.firebase.crashlytics.c.b.f().b("Background thread awaiting app exception callback from FA...");
            if (this.a.await(2000L, TimeUnit.MILLISECONDS)) {
                com.google.firebase.crashlytics.c.b.f().b("App exception callback received from FA listener.");
            } else {
                com.google.firebase.crashlytics.c.b.f().b("Timeout exceeded while awaiting app exception callback from FA listener.");
            }
        }

        /* synthetic */ y(k kVar) {
            this();
        }
    }
}