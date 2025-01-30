package kotlinx.coroutines.i1;

import java.util.concurrent.RejectedExecutionException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.z;

/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
public class d extends k0 {

    /* renamed from: c  reason: collision with root package name */
    private a f17461c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17462d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17463e;

    /* renamed from: f  reason: collision with root package name */
    private final long f17464f;

    /* renamed from: g  reason: collision with root package name */
    private final String f17465g;

    public d(int i2, int i3, long j2, String str) {
        this.f17462d = i2;
        this.f17463e = i3;
        this.f17464f = j2;
        this.f17465g = str;
        this.f17461c = K();
    }

    private final a K() {
        return new a(this.f17462d, this.f17463e, this.f17464f, this.f17465g);
    }

    @Override // kotlinx.coroutines.t
    public void A(kotlin.c0.f fVar, Runnable runnable) {
        try {
            a.g(this.f17461c, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            z.f17548h.A(fVar, runnable);
        }
    }

    public final void N(Runnable runnable, j jVar, boolean z) {
        try {
            this.f17461c.f(runnable, jVar, z);
        } catch (RejectedExecutionException unused) {
            z.f17548h.y0(this.f17461c.d(runnable, jVar));
        }
    }

    public /* synthetic */ d(int i2, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? l.f17476c : i2, (i4 & 2) != 0 ? l.f17477d : i3, (i4 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public d(int i2, int i3, String str) {
        this(i2, i3, l.f17478e, str);
    }
}