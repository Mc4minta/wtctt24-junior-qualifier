package com.google.zxing.t;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatOneDReader.java */
/* loaded from: classes2.dex */
public final class i extends k {
    private final k[] a;

    public i(Map<com.google.zxing.d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(com.google.zxing.d.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(com.google.zxing.d.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(com.google.zxing.a.EAN_13) || collection.contains(com.google.zxing.a.UPC_A) || collection.contains(com.google.zxing.a.EAN_8) || collection.contains(com.google.zxing.a.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(com.google.zxing.a.CODE_39)) {
                arrayList.add(new c(z));
            }
            if (collection.contains(com.google.zxing.a.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(com.google.zxing.a.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(com.google.zxing.a.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(com.google.zxing.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(com.google.zxing.a.RSS_14)) {
                arrayList.add(new com.google.zxing.t.r.e());
            }
            if (collection.contains(com.google.zxing.a.RSS_EXPANDED)) {
                arrayList.add(new com.google.zxing.t.r.g.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new com.google.zxing.t.r.e());
            arrayList.add(new com.google.zxing.t.r.g.d());
        }
        this.a = (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    @Override // com.google.zxing.t.k
    public com.google.zxing.k c(int i2, com.google.zxing.q.a aVar, Map<com.google.zxing.d, ?> map) throws NotFoundException {
        for (k kVar : this.a) {
            try {
                return kVar.c(i2, aVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.t.k, com.google.zxing.j
    public void reset() {
        for (k kVar : this.a) {
            kVar.reset();
        }
    }
}