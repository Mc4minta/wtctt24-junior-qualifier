package androidx.room;

import android.content.Context;
import androidx.room.j;
import c.r.a.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: DatabaseConfiguration.java */
/* loaded from: classes.dex */
public class a {
    public final c.InterfaceC0085c a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f2221b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2222c;

    /* renamed from: d  reason: collision with root package name */
    public final j.d f2223d;

    /* renamed from: e  reason: collision with root package name */
    public final List<j.b> f2224e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2225f;

    /* renamed from: g  reason: collision with root package name */
    public final j.c f2226g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f2227h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f2228i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f2229j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f2230k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f2231l;
    private final Set<Integer> m;
    public final String n;
    public final File o;

    public a(Context context, String str, c.InterfaceC0085c interfaceC0085c, j.d dVar, List<j.b> list, boolean z, j.c cVar, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.a = interfaceC0085c;
        this.f2221b = context;
        this.f2222c = str;
        this.f2223d = dVar;
        this.f2224e = list;
        this.f2225f = z;
        this.f2226g = cVar;
        this.f2227h = executor;
        this.f2228i = executor2;
        this.f2229j = z2;
        this.f2230k = z3;
        this.f2231l = z4;
        this.m = set;
        this.n = str2;
        this.o = file;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        if ((i2 > i3) && this.f2231l) {
            return false;
        }
        return this.f2230k && ((set = this.m) == null || !set.contains(Integer.valueOf(i2)));
    }
}