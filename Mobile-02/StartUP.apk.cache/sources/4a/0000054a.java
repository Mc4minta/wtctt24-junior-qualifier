package c.h.i;

import android.graphics.Typeface;
import android.os.Handler;
import c.h.i.e;
import c.h.i.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CallbackWithHandler.java */
/* loaded from: classes.dex */
public class a {
    private final f.c a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2949b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CallbackWithHandler.java */
    /* renamed from: c.h.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0062a implements Runnable {
        final /* synthetic */ f.c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Typeface f2950b;

        RunnableC0062a(f.c cVar, Typeface typeface) {
            this.a = cVar;
            this.f2950b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.f2950b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CallbackWithHandler.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ f.c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2952b;

        b(f.c cVar, int i2) {
            this.a = cVar;
            this.f2952b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.f2952b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f.c cVar, Handler handler) {
        this.a = cVar;
        this.f2949b = handler;
    }

    private void a(int i2) {
        this.f2949b.post(new b(this.a, i2));
    }

    private void c(Typeface typeface) {
        this.f2949b.post(new RunnableC0062a(this.a, typeface));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e.C0063e c0063e) {
        if (c0063e.a()) {
            c(c0063e.a);
        } else {
            a(c0063e.f2968b);
        }
    }
}