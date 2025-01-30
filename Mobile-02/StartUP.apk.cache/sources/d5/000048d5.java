package e.g.b.a.d.h0;

/* compiled from: Platform.java */
/* loaded from: classes2.dex */
final class d {
    private static final ThreadLocal<char[]> a = new a();

    /* compiled from: Platform.java */
    /* loaded from: classes2.dex */
    static class a extends ThreadLocal<char[]> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char[] a() {
        return a.get();
    }
}