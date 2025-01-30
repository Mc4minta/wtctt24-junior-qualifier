package com.google.zxing.t;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatUPCEANReader.java */
/* loaded from: classes2.dex */
public final class j extends k {
    private final p[] a;

    public j(Map<com.google.zxing.d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(com.google.zxing.d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(com.google.zxing.a.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(com.google.zxing.a.UPC_A)) {
                arrayList.add(new l());
            }
            if (collection.contains(com.google.zxing.a.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(com.google.zxing.a.UPC_E)) {
                arrayList.add(new q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new q());
        }
        this.a = (p[]) arrayList.toArray(new p[arrayList.size()]);
    }

    @Override // com.google.zxing.t.k
    public com.google.zxing.k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException {
        boolean z;
        int[] p = p.p(aVar);
        for (p pVar : this.a) {
            try {
                com.google.zxing.k m = pVar.m(i2, aVar, p, map);
                boolean z2 = m.b() == com.google.zxing.a.EAN_13 && m.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(com.google.zxing.d.POSSIBLE_FORMATS);
                if (collection != null && !collection.contains(com.google.zxing.a.UPC_A)) {
                    z = false;
                    if (z2 || !z) {
                        return m;
                    }
                    com.google.zxing.k kVar = new com.google.zxing.k(m.f().substring(1), m.c(), m.e(), com.google.zxing.a.UPC_A);
                    kVar.g(m.d());
                    return kVar;
                }
                z = true;
                if (z2) {
                }
                return m;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.t.k, com.google.zxing.j
    public void reset() {
        for (p pVar : this.a) {
            pVar.reset();
        }
    }
}