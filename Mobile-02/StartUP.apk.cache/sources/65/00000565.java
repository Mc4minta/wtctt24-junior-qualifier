package c.h.j;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class d {
    public static final c.h.j.c a = new e(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final c.h.j.c f2990b = new e(null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final c.h.j.c f2991c;

    /* renamed from: d  reason: collision with root package name */
    public static final c.h.j.c f2992d;

    /* renamed from: e  reason: collision with root package name */
    public static final c.h.j.c f2993e;

    /* renamed from: f  reason: collision with root package name */
    public static final c.h.j.c f2994f;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class a implements c {
        static final a a = new a(true);

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2995b;

        private a(boolean z) {
            this.f2995b = z;
        }

        @Override // c.h.j.d.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z = false;
            while (i2 < i4) {
                int a2 = d.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i2++;
                        z = z;
                    } else if (!this.f2995b) {
                        return 1;
                    }
                } else if (this.f2995b) {
                    return 0;
                }
                z = true;
                i2++;
                z = z;
            }
            if (z) {
                return this.f2995b ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class b implements c {
        static final b a = new b();

        private b() {
        }

        @Override // c.h.j.d.c
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                i5 = d.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i2, int i3);
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: c.h.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static abstract class AbstractC0066d implements c.h.j.c {
        private final c a;

        AbstractC0066d(c cVar) {
            this.a = cVar;
        }

        private boolean c(CharSequence charSequence, int i2, int i3) {
            int a = this.a.a(charSequence, i2, i3);
            if (a != 0) {
                if (a != 1) {
                    return b();
                }
                return false;
            }
            return true;
        }

        @Override // c.h.j.c
        public boolean a(CharSequence charSequence, int i2, int i3) {
            if (charSequence != null && i2 >= 0 && i3 >= 0 && charSequence.length() - i3 >= i2) {
                if (this.a == null) {
                    return b();
                }
                return c(charSequence, i2, i3);
            }
            throw new IllegalArgumentException();
        }

        protected abstract boolean b();
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class e extends AbstractC0066d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2996b;

        e(c cVar, boolean z) {
            super(cVar);
            this.f2996b = z;
        }

        @Override // c.h.j.d.AbstractC0066d
        protected boolean b() {
            return this.f2996b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    private static class f extends AbstractC0066d {

        /* renamed from: b  reason: collision with root package name */
        static final f f2997b = new f();

        f() {
            super(null);
        }

        @Override // c.h.j.d.AbstractC0066d
        protected boolean b() {
            return c.h.j.e.b(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.a;
        f2991c = new e(bVar, false);
        f2992d = new e(bVar, true);
        f2993e = new e(a.a, false);
        f2994f = f.f2997b;
    }

    static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return 0;
            }
            switch (i2) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}