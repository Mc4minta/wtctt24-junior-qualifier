package com.google.zxing.t.r.g;

/* compiled from: ExpandedPair.java */
/* loaded from: classes2.dex */
final class b {
    private final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.zxing.t.r.b f10039b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.zxing.t.r.b f10040c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.zxing.t.r.c f10041d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.google.zxing.t.r.b bVar, com.google.zxing.t.r.b bVar2, com.google.zxing.t.r.c cVar, boolean z) {
        this.f10039b = bVar;
        this.f10040c = bVar2;
        this.f10041d = cVar;
        this.a = z;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.t.r.c b() {
        return this.f10041d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.t.r.b c() {
        return this.f10039b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.t.r.b d() {
        return this.f10040c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return a(this.f10039b, bVar.f10039b) && a(this.f10040c, bVar.f10040c) && a(this.f10041d, bVar.f10041d);
        }
        return false;
    }

    public boolean f() {
        return this.f10040c == null;
    }

    public int hashCode() {
        return (e(this.f10039b) ^ e(this.f10040c)) ^ e(this.f10041d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f10039b);
        sb.append(" , ");
        sb.append(this.f10040c);
        sb.append(" : ");
        com.google.zxing.t.r.c cVar = this.f10041d;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }
}