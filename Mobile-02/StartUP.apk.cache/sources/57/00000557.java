package c.h.i;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import androidx.core.util.h;

/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class f {

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f2969b;

        @Deprecated
        public a(int i2, b[] bVarArr) {
            this.a = i2;
            this.f2969b = bVarArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(int i2, b[] bVarArr) {
            return new a(i2, bVarArr);
        }

        public b[] b() {
            return this.f2969b;
        }

        public int c() {
            return this.a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        private final Uri a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2970b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2971c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f2972d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2973e;

        @Deprecated
        public b(Uri uri, int i2, int i3, boolean z, int i4) {
            this.a = (Uri) h.b(uri);
            this.f2970b = i2;
            this.f2971c = i3;
            this.f2972d = z;
            this.f2973e = i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Uri uri, int i2, int i3, boolean z, int i4) {
            return new b(uri, i2, i3, z, i4);
        }

        public int b() {
            return this.f2973e;
        }

        public int c() {
            return this.f2970b;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.f2971c;
        }

        public boolean f() {
            return this.f2972d;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public void a(int i2) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, d dVar, int i2, boolean z, int i3, Handler handler, c cVar) {
        c.h.i.a aVar = new c.h.i.a(cVar, handler);
        if (z) {
            return e.e(context, dVar, aVar, i2, i3);
        }
        return e.d(context, dVar, i2, null, aVar);
    }
}