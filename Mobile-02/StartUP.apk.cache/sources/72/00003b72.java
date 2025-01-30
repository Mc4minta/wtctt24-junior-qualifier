package com.google.firebase.perf.internal;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.i1;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
@Keep
/* loaded from: classes2.dex */
public class SessionManager extends c {
    @SuppressLint({"StaticFieldLeak"})
    private static final SessionManager zzfh = new SessionManager();
    private final GaugeManager zzbw;
    private final a zzdh;
    private final Set<WeakReference<w>> zzfi;
    private r zzfj;

    private SessionManager() {
        this(GaugeManager.zzby(), r.c(), a.j());
    }

    public static SessionManager zzcm() {
        return zzfh;
    }

    @Override // com.google.firebase.perf.internal.c, com.google.firebase.perf.internal.a.InterfaceC0193a
    public final void zza(i1 i1Var) {
        super.zza(i1Var);
        if (this.zzdh.k()) {
            return;
        }
        if (i1Var == i1.FOREGROUND) {
            zzc(i1Var);
        } else if (zzco()) {
        } else {
            zzd(i1Var);
        }
    }

    public final void zzc(i1 i1Var) {
        synchronized (this.zzfi) {
            this.zzfj = r.c();
            Iterator<WeakReference<w>> it = this.zzfi.iterator();
            while (it.hasNext()) {
                w wVar = it.next().get();
                if (wVar != null) {
                    wVar.a(this.zzfj);
                } else {
                    it.remove();
                }
            }
        }
        if (this.zzfj.f()) {
            this.zzbw.zzb(this.zzfj.d(), i1Var);
        }
        zzd(i1Var);
    }

    public final r zzcn() {
        return this.zzfj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzco() {
        if (this.zzfj.a()) {
            zzc(this.zzdh.l());
            return true;
        }
        return false;
    }

    public final void zzd(WeakReference<w> weakReference) {
        synchronized (this.zzfi) {
            this.zzfi.remove(weakReference);
        }
    }

    private SessionManager(GaugeManager gaugeManager, r rVar, a aVar) {
        this.zzfi = new HashSet();
        this.zzbw = gaugeManager;
        this.zzfj = rVar;
        this.zzdh = aVar;
        zzbq();
    }

    private final void zzd(i1 i1Var) {
        if (this.zzfj.f()) {
            this.zzbw.zza(this.zzfj, i1Var);
        } else {
            this.zzbw.zzbz();
        }
    }

    public final void zzc(WeakReference<w> weakReference) {
        synchronized (this.zzfi) {
            this.zzfi.add(weakReference);
        }
    }
}