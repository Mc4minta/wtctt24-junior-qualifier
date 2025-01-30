package com.google.firebase.crashlytics.c.n;

import com.google.firebase.crashlytics.c.g.r;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class b {
    private static final short[] a = {10, 20, 30, 60, 120, 300};

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.n.d.b f9003b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9004c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9005d;

    /* renamed from: e  reason: collision with root package name */
    private final r f9006e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.n.a f9007f;

    /* renamed from: g  reason: collision with root package name */
    private final a f9008g;

    /* renamed from: h  reason: collision with root package name */
    private Thread f9009h;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public interface a {
        boolean a();
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.c.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0186b {
        b a(com.google.firebase.crashlytics.c.p.i.b bVar);
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public interface c {
        File[] a();

        File[] b();
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private class d extends com.google.firebase.crashlytics.c.g.d {
        private final List<com.google.firebase.crashlytics.c.n.c.c> a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f9010b;

        /* renamed from: c  reason: collision with root package name */
        private final float f9011c;

        d(List<com.google.firebase.crashlytics.c.n.c.c> list, boolean z, float f2) {
            this.a = list;
            this.f9010b = z;
            this.f9011c = f2;
        }

        private void b(List<com.google.firebase.crashlytics.c.n.c.c> list, boolean z) {
            float f2;
            com.google.firebase.crashlytics.c.b.f().b("Starting report processing in " + this.f9011c + " second(s)...");
            if (this.f9011c > 0.0f) {
                try {
                    Thread.sleep(f2 * 1000.0f);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (b.this.f9008g.a()) {
                return;
            }
            int i2 = 0;
            while (list.size() > 0 && !b.this.f9008g.a()) {
                com.google.firebase.crashlytics.c.b.f().b("Attempting to send " + list.size() + " report(s)");
                ArrayList arrayList = new ArrayList();
                for (com.google.firebase.crashlytics.c.n.c.c cVar : list) {
                    if (!b.this.d(cVar, z)) {
                        arrayList.add(cVar);
                    }
                }
                if (arrayList.size() > 0) {
                    int i3 = i2 + 1;
                    long j2 = b.a[Math.min(i2, b.a.length - 1)];
                    com.google.firebase.crashlytics.c.b.f().b("Report submission: scheduling delayed retry in " + j2 + " seconds");
                    try {
                        Thread.sleep(j2 * 1000);
                        i2 = i3;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                list = arrayList;
            }
        }

        @Override // com.google.firebase.crashlytics.c.g.d
        public void a() {
            try {
                b(this.a, this.f9010b);
            } catch (Exception e2) {
                com.google.firebase.crashlytics.c.b.f().e("An unexpected error occurred while attempting to upload crash reports.", e2);
            }
            b.this.f9009h = null;
        }
    }

    public b(String str, String str2, r rVar, com.google.firebase.crashlytics.c.n.a aVar, com.google.firebase.crashlytics.c.n.d.b bVar, a aVar2) {
        if (bVar != null) {
            this.f9003b = bVar;
            this.f9004c = str;
            this.f9005d = str2;
            this.f9006e = rVar;
            this.f9007f = aVar;
            this.f9008g = aVar2;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: Exception -> 0x0067, TRY_LEAVE, TryCatch #0 {Exception -> 0x0067, blocks: (B:3:0x0001, B:5:0x0011, B:18:0x0060, B:6:0x001b, B:8:0x001f, B:10:0x0027, B:12:0x0032, B:16:0x004d), top: B:23:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(com.google.firebase.crashlytics.c.n.c.c r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            com.google.firebase.crashlytics.c.n.c.a r1 = new com.google.firebase.crashlytics.c.n.c.a     // Catch: java.lang.Exception -> L67
            java.lang.String r2 = r5.f9004c     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = r5.f9005d     // Catch: java.lang.Exception -> L67
            r1.<init>(r2, r3, r6)     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.c.g.r r2 = r5.f9006e     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.c.g.r r3 = com.google.firebase.crashlytics.c.g.r.ALL     // Catch: java.lang.Exception -> L67
            r4 = 1
            if (r2 != r3) goto L1b
            com.google.firebase.crashlytics.c.b r7 = com.google.firebase.crashlytics.c.b.f()     // Catch: java.lang.Exception -> L67
            java.lang.String r1 = "Send to Reports Endpoint disabled. Removing Reports Endpoint report."
            r7.b(r1)     // Catch: java.lang.Exception -> L67
            goto L30
        L1b:
            com.google.firebase.crashlytics.c.g.r r3 = com.google.firebase.crashlytics.c.g.r.JAVA_ONLY     // Catch: java.lang.Exception -> L67
            if (r2 != r3) goto L32
            com.google.firebase.crashlytics.c.n.c.c$a r2 = r6.getType()     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.c.n.c.c$a r3 = com.google.firebase.crashlytics.c.n.c.c.a.JAVA     // Catch: java.lang.Exception -> L67
            if (r2 != r3) goto L32
            com.google.firebase.crashlytics.c.b r7 = com.google.firebase.crashlytics.c.b.f()     // Catch: java.lang.Exception -> L67
            java.lang.String r1 = "Send to Reports Endpoint for non-native reports disabled. Removing Reports Uploader report."
            r7.b(r1)     // Catch: java.lang.Exception -> L67
        L30:
            r7 = r4
            goto L5e
        L32:
            com.google.firebase.crashlytics.c.n.d.b r2 = r5.f9003b     // Catch: java.lang.Exception -> L67
            boolean r7 = r2.b(r1, r7)     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.c.b r1 = com.google.firebase.crashlytics.c.b.f()     // Catch: java.lang.Exception -> L67
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L67
            r2.<init>()     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = "Crashlytics Reports Endpoint upload "
            r2.append(r3)     // Catch: java.lang.Exception -> L67
            if (r7 == 0) goto L4b
            java.lang.String r3 = "complete: "
            goto L4d
        L4b:
            java.lang.String r3 = "FAILED: "
        L4d:
            r2.append(r3)     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = r6.a()     // Catch: java.lang.Exception -> L67
            r2.append(r3)     // Catch: java.lang.Exception -> L67
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L67
            r1.g(r2)     // Catch: java.lang.Exception -> L67
        L5e:
            if (r7 == 0) goto L80
            com.google.firebase.crashlytics.c.n.a r7 = r5.f9007f     // Catch: java.lang.Exception -> L67
            r7.b(r6)     // Catch: java.lang.Exception -> L67
            r0 = r4
            goto L80
        L67:
            r7 = move-exception
            com.google.firebase.crashlytics.c.b r1 = com.google.firebase.crashlytics.c.b.f()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error occurred sending report "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r1.e(r6, r7)
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.c.n.b.d(com.google.firebase.crashlytics.c.n.c.c, boolean):boolean");
    }

    public synchronized void e(List<com.google.firebase.crashlytics.c.n.c.c> list, boolean z, float f2) {
        if (this.f9009h != null) {
            com.google.firebase.crashlytics.c.b.f().b("Report upload has already been started.");
            return;
        }
        Thread thread = new Thread(new d(list, z, f2), "Crashlytics Report Uploader");
        this.f9009h = thread;
        thread.start();
    }
}