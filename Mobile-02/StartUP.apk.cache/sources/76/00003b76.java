package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.i1;
import com.google.firebase.perf.internal.a;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class c implements a.InterfaceC0193a {
    private a zzct;
    private i1 zzcu;
    private boolean zzcv;
    private WeakReference<a.InterfaceC0193a> zzcw;

    /* JADX INFO: Access modifiers changed from: protected */
    public c() {
        this(a.j());
    }

    @Override // com.google.firebase.perf.internal.a.InterfaceC0193a
    public void zza(i1 i1Var) {
        i1 i1Var2 = this.zzcu;
        i1 i1Var3 = i1.APPLICATION_PROCESS_STATE_UNKNOWN;
        if (i1Var2 == i1Var3) {
            this.zzcu = i1Var;
        } else if (i1Var2 == i1Var || i1Var == i1Var3) {
        } else {
            this.zzcu = i1.FOREGROUND_BACKGROUND;
        }
    }

    public final i1 zzbn() {
        return this.zzcu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzbq() {
        if (this.zzcv) {
            return;
        }
        this.zzcu = this.zzct.l();
        this.zzct.b(this.zzcw);
        this.zzcv = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzbr() {
        if (this.zzcv) {
            this.zzct.h(this.zzcw);
            this.zzcv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc(int i2) {
        this.zzct.o(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(a aVar) {
        this.zzcu = i1.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzcv = false;
        this.zzct = aVar;
        this.zzcw = new WeakReference<>(this);
    }
}