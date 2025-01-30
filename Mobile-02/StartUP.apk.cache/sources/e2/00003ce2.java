package com.google.zxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatReader.java */
/* loaded from: classes2.dex */
public final class h implements j {
    private Map<d, ?> a;

    /* renamed from: b  reason: collision with root package name */
    private j[] f9834b;

    private k c(c cVar) throws NotFoundException {
        j[] jVarArr = this.f9834b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                try {
                    return jVar.a(cVar, this.a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.j
    public k a(c cVar, Map<d, ?> map) throws NotFoundException {
        e(map);
        return c(cVar);
    }

    @Override // com.google.zxing.j
    public k b(c cVar) throws NotFoundException {
        e(null);
        return c(cVar);
    }

    public k d(c cVar) throws NotFoundException {
        if (this.f9834b == null) {
            e(null);
        }
        return c(cVar);
    }

    public void e(Map<d, ?> map) {
        this.a = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(d.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(a.UPC_A) && !collection.contains(a.UPC_E) && !collection.contains(a.EAN_13) && !collection.contains(a.EAN_8) && !collection.contains(a.CODABAR) && !collection.contains(a.CODE_39) && !collection.contains(a.CODE_93) && !collection.contains(a.CODE_128) && !collection.contains(a.ITF) && !collection.contains(a.RSS_14) && !collection.contains(a.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new com.google.zxing.t.i(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new com.google.zxing.v.a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new com.google.zxing.r.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new com.google.zxing.o.b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new com.google.zxing.u.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new com.google.zxing.s.a());
            }
            if (z && z2) {
                arrayList.add(new com.google.zxing.t.i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new com.google.zxing.t.i(map));
            }
            arrayList.add(new com.google.zxing.v.a());
            arrayList.add(new com.google.zxing.r.a());
            arrayList.add(new com.google.zxing.o.b());
            arrayList.add(new com.google.zxing.u.b());
            arrayList.add(new com.google.zxing.s.a());
            if (z2) {
                arrayList.add(new com.google.zxing.t.i(map));
            }
        }
        this.f9834b = (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    @Override // com.google.zxing.j
    public void reset() {
        j[] jVarArr = this.f9834b;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                jVar.reset();
            }
        }
    }
}