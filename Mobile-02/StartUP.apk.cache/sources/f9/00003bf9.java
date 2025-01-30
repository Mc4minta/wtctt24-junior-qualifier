package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray.java */
/* loaded from: classes2.dex */
public final class i extends l implements Iterable<l> {
    private final List<l> a = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.a.iterator();
    }

    @Override // com.google.gson.l
    public String l() {
        if (this.a.size() == 1) {
            return this.a.get(0).l();
        }
        throw new IllegalStateException();
    }

    public void r(l lVar) {
        if (lVar == null) {
            lVar = m.a;
        }
        this.a.add(lVar);
    }
}