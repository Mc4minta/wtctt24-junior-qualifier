package com.google.zxing.t.r.g;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandedRow.java */
/* loaded from: classes2.dex */
final class c {
    private final List<b> a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10042b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10043c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<b> list, int i2, boolean z) {
        this.a = new ArrayList(list);
        this.f10042b = i2;
        this.f10043c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f10042b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(List<b> list) {
        return this.a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.a.equals(cVar.a()) && this.f10043c == cVar.f10043c;
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.f10043c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }
}