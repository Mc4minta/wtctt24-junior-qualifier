package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.m4;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.b4  reason: invalid package */
/* loaded from: classes2.dex */
final class b4 extends c4<m4.e> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.c4
    public final void a(y7 y7Var, Map.Entry<?, ?> entry) throws IOException {
        m4.e eVar = (m4.e) entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.c4
    public final int b(Map.Entry<?, ?> entry) {
        m4.e eVar = (m4.e) entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.c4
    public final e4<m4.e> c(Object obj) {
        return ((m4.b) obj).zzqy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.c4
    public final e4<m4.e> d(Object obj) {
        m4.b bVar = (m4.b) obj;
        if (bVar.zzqy.b()) {
            bVar.zzqy = (e4) bVar.zzqy.clone();
        }
        return bVar.zzqy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.c4
    public final boolean e(v5 v5Var) {
        return v5Var instanceof m4.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.c4
    public final void f(Object obj) {
        c(obj).q();
    }
}