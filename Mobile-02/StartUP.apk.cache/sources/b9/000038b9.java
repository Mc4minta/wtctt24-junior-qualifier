package com.google.common.base;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Splitter.java */
/* loaded from: classes2.dex */
public final class o {
    private final com.google.common.base.c a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8446b;

    /* renamed from: c  reason: collision with root package name */
    private final c f8447c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8448d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Splitter.java */
    /* loaded from: classes2.dex */
    public static class a implements c {
        final /* synthetic */ com.google.common.base.c a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Splitter.java */
        /* renamed from: com.google.common.base.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0157a extends b {
            C0157a(o oVar, CharSequence charSequence) {
                super(oVar, charSequence);
            }

            @Override // com.google.common.base.o.b
            int f(int i2) {
                return i2 + 1;
            }

            @Override // com.google.common.base.o.b
            int g(int i2) {
                return a.this.a.g(this.f8450c, i2);
            }
        }

        a(com.google.common.base.c cVar) {
            this.a = cVar;
        }

        @Override // com.google.common.base.o.c
        /* renamed from: b */
        public b a(o oVar, CharSequence charSequence) {
            return new C0157a(oVar, charSequence);
        }
    }

    /* compiled from: Splitter.java */
    /* loaded from: classes2.dex */
    private static abstract class b extends com.google.common.base.a<String> {

        /* renamed from: c  reason: collision with root package name */
        final CharSequence f8450c;

        /* renamed from: d  reason: collision with root package name */
        final com.google.common.base.c f8451d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f8452e;

        /* renamed from: f  reason: collision with root package name */
        int f8453f = 0;

        /* renamed from: g  reason: collision with root package name */
        int f8454g;

        protected b(o oVar, CharSequence charSequence) {
            this.f8451d = oVar.a;
            this.f8452e = oVar.f8446b;
            this.f8454g = oVar.f8448d;
            this.f8450c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.a
        /* renamed from: e */
        public String b() {
            int g2;
            int i2 = this.f8453f;
            while (true) {
                int i3 = this.f8453f;
                if (i3 != -1) {
                    g2 = g(i3);
                    if (g2 == -1) {
                        g2 = this.f8450c.length();
                        this.f8453f = -1;
                    } else {
                        this.f8453f = f(g2);
                    }
                    int i4 = this.f8453f;
                    if (i4 == i2) {
                        int i5 = i4 + 1;
                        this.f8453f = i5;
                        if (i5 >= this.f8450c.length()) {
                            this.f8453f = -1;
                        }
                    } else {
                        while (i2 < g2 && this.f8451d.p(this.f8450c.charAt(i2))) {
                            i2++;
                        }
                        while (g2 > i2 && this.f8451d.p(this.f8450c.charAt(g2 - 1))) {
                            g2--;
                        }
                        if (!this.f8452e || i2 != g2) {
                            break;
                        }
                        i2 = this.f8453f;
                    }
                } else {
                    return c();
                }
            }
            int i6 = this.f8454g;
            if (i6 == 1) {
                g2 = this.f8450c.length();
                this.f8453f = -1;
                while (g2 > i2 && this.f8451d.p(this.f8450c.charAt(g2 - 1))) {
                    g2--;
                }
            } else {
                this.f8454g = i6 - 1;
            }
            return this.f8450c.subSequence(i2, g2).toString();
        }

        abstract int f(int i2);

        abstract int g(int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Splitter.java */
    /* loaded from: classes2.dex */
    public interface c {
        Iterator<String> a(o oVar, CharSequence charSequence);
    }

    private o(c cVar) {
        this(cVar, false, com.google.common.base.c.q(), RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
    }

    public static o d(char c2) {
        return e(com.google.common.base.c.i(c2));
    }

    public static o e(com.google.common.base.c cVar) {
        l.i(cVar);
        return new o(new a(cVar));
    }

    private Iterator<String> g(CharSequence charSequence) {
        return this.f8447c.a(this, charSequence);
    }

    public List<String> f(CharSequence charSequence) {
        l.i(charSequence);
        Iterator<String> g2 = g(charSequence);
        ArrayList arrayList = new ArrayList();
        while (g2.hasNext()) {
            arrayList.add(g2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private o(c cVar, boolean z, com.google.common.base.c cVar2, int i2) {
        this.f8447c = cVar;
        this.f8446b = z;
        this.a = cVar2;
        this.f8448d = i2;
    }
}