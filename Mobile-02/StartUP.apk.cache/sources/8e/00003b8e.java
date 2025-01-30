package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.internal.p000firebaseperf.e8;
import com.google.android.gms.internal.p000firebaseperf.i;
import com.google.android.gms.internal.p000firebaseperf.m0;
import com.google.android.gms.internal.p000firebaseperf.n0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.r;
import com.google.firebase.perf.internal.s;
import com.google.firebase.perf.internal.w;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public class Trace extends com.google.firebase.perf.internal.c implements Parcelable, w {

    /* renamed from: c  reason: collision with root package name */
    private final Trace f9368c;

    /* renamed from: d  reason: collision with root package name */
    private final GaugeManager f9369d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9370e;

    /* renamed from: f  reason: collision with root package name */
    private final List<r> f9371f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Trace> f9372g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, b> f9373h;

    /* renamed from: j  reason: collision with root package name */
    private final m0 f9374j;

    /* renamed from: k  reason: collision with root package name */
    private final com.google.firebase.perf.internal.d f9375k;

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, String> f9376l;
    private y0 m;
    private y0 n;
    private final WeakReference<w> p;
    private static final Map<String, Trace> a = new ConcurrentHashMap();
    @Keep
    public static final Parcelable.Creator<Trace> CREATOR = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final Parcelable.Creator<Trace> f9367b = new c();

    private Trace(String str) {
        this(str, com.google.firebase.perf.internal.d.k(), new m0(), com.google.firebase.perf.internal.a.j(), GaugeManager.zzby());
    }

    private final boolean c() {
        return this.m != null;
    }

    private final boolean d() {
        return this.n != null;
    }

    public static Trace j(String str) {
        return new Trace(str);
    }

    private final b k(String str) {
        b bVar = this.f9373h.get(str);
        if (bVar == null) {
            b bVar2 = new b(str);
            this.f9373h.put(str, bVar2);
            return bVar2;
        }
        return bVar;
    }

    @Override // com.google.firebase.perf.internal.w
    public final void a(r rVar) {
        if (rVar == null) {
            Log.i("FirebasePerformance", "Unable to add new SessionId to the Trace. Continuing without it.");
        } else if (!c() || d()) {
        } else {
            this.f9371f.add(rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return this.f9370e;
    }

    @Override // android.os.Parcelable
    @Keep
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, b> e() {
        return this.f9373h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final y0 f() {
        return this.m;
    }

    protected void finalize() throws Throwable {
        try {
            if (c() && !d()) {
                Log.w("FirebasePerformance", String.format("Trace '%s' is started but not stopped when it is destructed!", this.f9370e));
                zzc(1);
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final y0 g() {
        return this.n;
    }

    @Keep
    public String getAttribute(String str) {
        return this.f9376l.get(str);
    }

    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.f9376l);
    }

    @Keep
    public long getLongMetric(String str) {
        b bVar = str != null ? this.f9373h.get(str.trim()) : null;
        if (bVar == null) {
            return 0L;
        }
        return bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Trace> h() {
        return this.f9372g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e8<r> i() {
        return e8.r(this.f9371f);
    }

    @Keep
    public void incrementMetric(String str, long j2) {
        String c2 = s.c(str);
        if (c2 != null) {
            Log.e("FirebasePerformance", String.format("Cannot increment metric %s. Metric name is invalid.(%s)", str, c2));
        } else if (!c()) {
            Log.w("FirebasePerformance", String.format("Cannot increment metric '%s' for trace '%s' because it's not started", str, this.f9370e));
        } else if (d()) {
            Log.w("FirebasePerformance", String.format("Cannot increment metric '%s' for trace '%s' because it's been stopped", str, this.f9370e));
        } else {
            k(str.trim()).c(j2);
        }
    }

    @Keep
    public void putAttribute(String str, String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
        } catch (Exception e2) {
            Log.e("FirebasePerformance", String.format("Can not set attribute %s with value %s (%s)", str, str2, e2.getMessage()));
        }
        if (!d()) {
            if (!this.f9376l.containsKey(str) && this.f9376l.size() >= 5) {
                throw new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", 5));
            }
            String a2 = s.a(new AbstractMap.SimpleEntry(str, str2));
            if (a2 != null) {
                throw new IllegalArgumentException(a2);
            }
            z = true;
            if (z) {
                this.f9376l.put(str, str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Trace %s has been stopped", this.f9370e));
    }

    @Keep
    public void putMetric(String str, long j2) {
        String c2 = s.c(str);
        if (c2 != null) {
            Log.e("FirebasePerformance", String.format("Cannot set value for metric %s. Metric name is invalid.(%s)", str, c2));
        } else if (!c()) {
            Log.w("FirebasePerformance", String.format("Cannot set value for metric '%s' for trace '%s' because it's not started", str, this.f9370e));
        } else if (d()) {
            Log.w("FirebasePerformance", String.format("Cannot set value for metric '%s' for trace '%s' because it's been stopped", str, this.f9370e));
        } else {
            k(str.trim()).d(j2);
        }
    }

    @Keep
    public void removeAttribute(String str) {
        if (d()) {
            Log.e("FirebasePerformance", "Can't remove a attribute from a Trace that's stopped.");
        } else {
            this.f9376l.remove(str);
        }
    }

    @Keep
    public void start() {
        String str;
        if (!i.A().B()) {
            Log.i("FirebasePerformance", "Trace feature is disabled.");
            return;
        }
        String str2 = this.f9370e;
        if (str2 == null) {
            str = "Trace name must not be null";
        } else if (str2.length() > 100) {
            str = String.format(Locale.US, "Trace name must not exceed %d characters", 100);
        } else {
            if (str2.startsWith("_")) {
                n0[] values = n0.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        if (values[i2].toString().equals(str2)) {
                            break;
                        }
                        i2++;
                    } else if (!str2.startsWith("_st_")) {
                        str = "Trace name must not start with '_'";
                    }
                }
            }
            str = null;
        }
        if (str != null) {
            Log.e("FirebasePerformance", String.format("Cannot start trace %s. Trace name is invalid.(%s)", this.f9370e, str));
        } else if (this.m != null) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has already started, should not start again!", this.f9370e));
        } else {
            this.m = new y0();
            zzbq();
            r zzcn = SessionManager.zzcm().zzcn();
            SessionManager.zzcm().zzc(this.p);
            a(zzcn);
            if (zzcn.f()) {
                this.f9369d.zzj(zzcn.e());
            }
        }
    }

    @Keep
    public void stop() {
        if (!c()) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has not been started so unable to stop!", this.f9370e));
        } else if (d()) {
            Log.e("FirebasePerformance", String.format("Trace '%s' has already stopped, should not stop again!", this.f9370e));
        } else {
            SessionManager.zzcm().zzd(this.p);
            zzbr();
            y0 y0Var = new y0();
            this.n = y0Var;
            if (this.f9368c == null) {
                if (!this.f9372g.isEmpty()) {
                    Trace trace = this.f9372g.get(this.f9372g.size() - 1);
                    if (trace.n == null) {
                        trace.n = y0Var;
                    }
                }
                if (!this.f9370e.isEmpty()) {
                    com.google.firebase.perf.internal.d dVar = this.f9375k;
                    if (dVar != null) {
                        dVar.d(new e(this).a(), zzbn());
                        if (SessionManager.zzcm().zzcn().f()) {
                            this.f9369d.zzj(SessionManager.zzcm().zzcn().e());
                            return;
                        }
                        return;
                    }
                    return;
                }
                Log.e("FirebasePerformance", "Trace name is empty, no log is sent to server");
            }
        }
    }

    @Override // android.os.Parcelable
    @Keep
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f9368c, 0);
        parcel.writeString(this.f9370e);
        parcel.writeList(this.f9372g);
        parcel.writeMap(this.f9373h);
        parcel.writeParcelable(this.m, 0);
        parcel.writeParcelable(this.n, 0);
        parcel.writeList(this.f9371f);
    }

    public Trace(String str, com.google.firebase.perf.internal.d dVar, m0 m0Var, com.google.firebase.perf.internal.a aVar) {
        this(str, dVar, m0Var, aVar, GaugeManager.zzby());
    }

    private Trace(String str, com.google.firebase.perf.internal.d dVar, m0 m0Var, com.google.firebase.perf.internal.a aVar, GaugeManager gaugeManager) {
        super(aVar);
        this.p = new WeakReference<>(this);
        this.f9368c = null;
        this.f9370e = str.trim();
        this.f9372g = new ArrayList();
        this.f9373h = new ConcurrentHashMap();
        this.f9376l = new ConcurrentHashMap();
        this.f9374j = m0Var;
        this.f9375k = dVar;
        this.f9371f = new ArrayList();
        this.f9369d = gaugeManager;
    }

    private Trace(Parcel parcel, boolean z) {
        super(z ? null : com.google.firebase.perf.internal.a.j());
        this.p = new WeakReference<>(this);
        this.f9368c = (Trace) parcel.readParcelable(Trace.class.getClassLoader());
        this.f9370e = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.f9372g = arrayList;
        parcel.readList(arrayList, Trace.class.getClassLoader());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f9373h = concurrentHashMap;
        this.f9376l = new ConcurrentHashMap();
        parcel.readMap(concurrentHashMap, b.class.getClassLoader());
        this.m = (y0) parcel.readParcelable(y0.class.getClassLoader());
        this.n = (y0) parcel.readParcelable(y0.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.f9371f = arrayList2;
        parcel.readList(arrayList2, r.class.getClassLoader());
        if (z) {
            this.f9375k = null;
            this.f9374j = null;
            this.f9369d = null;
            return;
        }
        this.f9375k = com.google.firebase.perf.internal.d.k();
        this.f9374j = new m0();
        this.f9369d = GaugeManager.zzby();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ Trace(Parcel parcel, boolean z, d dVar) {
        this(parcel, z);
    }
}