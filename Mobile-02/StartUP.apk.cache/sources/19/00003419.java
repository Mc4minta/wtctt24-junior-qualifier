package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.u8  reason: invalid package */
/* loaded from: classes2.dex */
public final class u8 {
    private static final d a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f6923b;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    /* renamed from: com.google.android.gms.internal.firebase-perf.u8$a */
    /* loaded from: classes2.dex */
    static final class a extends d {
        a() {
        }

        @Override // com.google.android.gms.internal.p000firebaseperf.d
        public final void a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    static {
        /*
            r0 = 1
            java.lang.Integer r1 = b()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L15
            int r2 = r1.intValue()     // Catch: java.lang.Throwable -> L2a
            r3 = 19
            if (r2 < r3) goto L15
            com.google.android.gms.internal.firebase-perf.g r2 = new com.google.android.gms.internal.firebase-perf.g     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L5f
        L15:
            java.lang.String r2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r2 = java.lang.Boolean.getBoolean(r2)     // Catch: java.lang.Throwable -> L2a
            r2 = r2 ^ r0
            if (r2 == 0) goto L24
            com.google.android.gms.internal.firebase-perf.e r2 = new com.google.android.gms.internal.firebase-perf.e     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L5f
        L24:
            com.google.android.gms.internal.firebase-perf.u8$a r2 = new com.google.android.gms.internal.firebase-perf.u8$a     // Catch: java.lang.Throwable -> L2a
            r2.<init>()     // Catch: java.lang.Throwable -> L2a
            goto L5f
        L2a:
            r2 = move-exception
            goto L2e
        L2c:
            r2 = move-exception
            r1 = 0
        L2e:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.firebase-perf.u8$a> r4 = com.google.android.gms.internal.p000firebaseperf.u8.a.class
            java.lang.String r4 = r4.getName()
            int r5 = r4.length()
            int r5 = r5 + 133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy "
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = "will be used. The error is: "
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            com.google.android.gms.internal.firebase-perf.u8$a r2 = new com.google.android.gms.internal.firebase-perf.u8$a
            r2.<init>()
        L5f:
            com.google.android.gms.internal.p000firebaseperf.u8.a = r2
            if (r1 != 0) goto L64
            goto L68
        L64:
            int r0 = r1.intValue()
        L68:
            com.google.android.gms.internal.p000firebaseperf.u8.f6923b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.u8.<clinit>():void");
    }

    public static void a(Throwable th, Throwable th2) {
        a.a(th, th2);
    }

    private static Integer b() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }
}