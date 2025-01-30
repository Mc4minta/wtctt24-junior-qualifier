package com.google.firebase.perf.internal;

import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.p2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class l extends s {
    private p2 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(p2 p2Var) {
        this.a = p2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0052 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean d(com.google.android.gms.internal.p000firebaseperf.p2 r8, int r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "FirebasePerformance"
            r2 = 1
            if (r9 <= r2) goto Lf
            java.lang.String r8 = "Exceed MAX_SUBTRACE_DEEP:1"
            android.util.Log.w(r1, r8)
            return r0
        Lf:
            java.util.Map r3 = r8.Q()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L1b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto La3
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L31
        L2f:
            r5 = r0
            goto L50
        L31:
            java.lang.String r5 = r5.trim()
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L41
            java.lang.String r5 = "counterId is empty"
            android.util.Log.w(r1, r5)
            goto L2f
        L41:
            int r5 = r5.length()
            r6 = 100
            if (r5 <= r6) goto L4f
            java.lang.String r5 = "counterId exceeded max length 100"
            android.util.Log.w(r1, r5)
            goto L2f
        L4f:
            r5 = r2
        L50:
            if (r5 != 0) goto L73
            java.lang.String r8 = "invalid CounterId:"
            java.lang.Object r9 = r4.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r2 = r9.length()
            if (r2 == 0) goto L69
            java.lang.String r8 = r8.concat(r9)
            goto L6f
        L69:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r8)
            r8 = r9
        L6f:
            android.util.Log.w(r1, r8)
            return r0
        L73:
            java.lang.Object r5 = r4.getValue()
            java.lang.Long r5 = (java.lang.Long) r5
            if (r5 == 0) goto L7d
            r5 = r2
            goto L7e
        L7d:
            r5 = r0
        L7e:
            if (r5 != 0) goto L1b
            java.lang.Object r8 = r4.getValue()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r9 = r8.length()
            int r9 = r9 + 21
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            java.lang.String r9 = "invalid CounterValue:"
            r2.append(r9)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            android.util.Log.w(r1, r8)
            return r0
        La3:
            java.util.List r8 = r8.S()
            java.util.Iterator r8 = r8.iterator()
        Lab:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto Lc0
            java.lang.Object r1 = r8.next()
            com.google.android.gms.internal.firebase-perf.p2 r1 = (com.google.android.gms.internal.p000firebaseperf.p2) r1
            int r3 = r9 + 1
            boolean r1 = r7.d(r1, r3)
            if (r1 != 0) goto Lab
            return r0
        Lc0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.l.d(com.google.android.gms.internal.firebase-perf.p2, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean e(com.google.android.gms.internal.p000firebaseperf.p2 r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "FirebasePerformance"
            r1 = 0
            if (r8 != 0) goto Lb
            java.lang.String r8 = "TraceMetric is null"
            android.util.Log.w(r0, r8)
            return r1
        Lb:
            r2 = 1
            if (r9 <= r2) goto L14
            java.lang.String r8 = "Exceed MAX_SUBTRACE_DEEP:1"
            android.util.Log.w(r0, r8)
            return r1
        L14:
            java.lang.String r3 = r8.u()
            if (r3 == 0) goto L2e
            java.lang.String r3 = r3.trim()
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L2e
            int r3 = r3.length()
            r4 = 100
            if (r3 > r4) goto L2e
            r3 = r2
            goto L2f
        L2e:
            r3 = r1
        L2f:
            if (r3 != 0) goto L4f
            java.lang.String r9 = "invalid TraceId:"
            java.lang.String r8 = r8.u()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r2 = r8.length()
            if (r2 == 0) goto L46
            java.lang.String r8 = r9.concat(r8)
            goto L4b
        L46:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r9)
        L4b:
            android.util.Log.w(r0, r8)
            return r1
        L4f:
            long r3 = r8.t()
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L5b
            r3 = r2
            goto L5c
        L5b:
            r3 = r1
        L5c:
            if (r3 != 0) goto L79
            long r8 = r8.t()
            r2 = 42
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "invalid TraceDuration:"
            r3.append(r2)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            android.util.Log.w(r0, r8)
            return r1
        L79:
            boolean r3 = r8.M()
            if (r3 != 0) goto L85
            java.lang.String r8 = "clientStartTimeUs is null."
            android.util.Log.w(r0, r8)
            return r1
        L85:
            java.util.List r3 = r8.S()
            java.util.Iterator r3 = r3.iterator()
        L8d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto La2
            java.lang.Object r4 = r3.next()
            com.google.android.gms.internal.firebase-perf.p2 r4 = (com.google.android.gms.internal.p000firebaseperf.p2) r4
            int r5 = r9 + 1
            boolean r4 = r7.e(r4, r5)
            if (r4 != 0) goto L8d
            return r1
        La2:
            java.util.Map r8 = r8.U()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        Lae:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto Lc5
            java.lang.Object r9 = r8.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.String r9 = com.google.firebase.perf.internal.s.a(r9)
            if (r9 == 0) goto Lae
            android.util.Log.w(r0, r9)
            r8 = r1
            goto Lc6
        Lc5:
            r8 = r2
        Lc6:
            if (r8 != 0) goto Lc9
            return r1
        Lc9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.l.e(com.google.android.gms.internal.firebase-perf.p2, int):boolean");
    }

    @Override // com.google.firebase.perf.internal.s
    public final boolean b() {
        boolean z;
        boolean z2;
        if (!e(this.a, 0)) {
            String valueOf = String.valueOf(this.a.u());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Invalid Trace:".concat(valueOf) : new String("Invalid Trace:"));
            return false;
        }
        p2 p2Var = this.a;
        if (p2Var.P() > 0) {
            z = true;
            break;
        }
        for (p2 p2Var2 : p2Var.S()) {
            if (p2Var2.P() > 0) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                z = true;
                break;
            }
        }
        z = false;
        if (!z || d(this.a, 0)) {
            return true;
        }
        String valueOf2 = String.valueOf(this.a.u());
        Log.w("FirebasePerformance", valueOf2.length() != 0 ? "Invalid Counters for Trace:".concat(valueOf2) : new String("Invalid Counters for Trace:"));
        return false;
    }
}