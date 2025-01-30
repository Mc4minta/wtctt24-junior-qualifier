package com.google.zxing.u;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.d;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.m;
import com.google.zxing.q.e;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: PDF417Reader.java */
/* loaded from: classes2.dex */
public final class b implements j {
    private static k[] c(com.google.zxing.c cVar, Map<d, ?> map, boolean z) throws NotFoundException, FormatException, ChecksumException {
        ArrayList arrayList = new ArrayList();
        com.google.zxing.u.e.b b2 = com.google.zxing.u.e.a.b(cVar, map, z);
        for (m[] mVarArr : b2.b()) {
            e i2 = com.google.zxing.u.d.j.i(b2.a(), mVarArr[4], mVarArr[5], mVarArr[6], mVarArr[7], f(mVarArr), d(mVarArr));
            k kVar = new k(i2.h(), i2.e(), mVarArr, com.google.zxing.a.PDF_417);
            kVar.h(l.ERROR_CORRECTION_LEVEL, i2.b());
            c cVar2 = (c) i2.d();
            if (cVar2 != null) {
                kVar.h(l.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(kVar);
        }
        return (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    private static int d(m[] mVarArr) {
        return Math.max(Math.max(e(mVarArr[0], mVarArr[4]), (e(mVarArr[6], mVarArr[2]) * 17) / 18), Math.max(e(mVarArr[1], mVarArr[5]), (e(mVarArr[7], mVarArr[3]) * 17) / 18));
    }

    private static int e(m mVar, m mVar2) {
        if (mVar == null || mVar2 == null) {
            return 0;
        }
        return (int) Math.abs(mVar.c() - mVar2.c());
    }

    private static int f(m[] mVarArr) {
        return Math.min(Math.min(g(mVarArr[0], mVarArr[4]), (g(mVarArr[6], mVarArr[2]) * 17) / 18), Math.min(g(mVarArr[1], mVarArr[5]), (g(mVarArr[7], mVarArr[3]) * 17) / 18));
    }

    private static int g(m mVar, m mVar2) {
        return (mVar == null || mVar2 == null) ? RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO : (int) Math.abs(mVar.c() - mVar2.c());
    }

    @Override // com.google.zxing.j
    public k a(com.google.zxing.c cVar, Map<d, ?> map) throws NotFoundException, FormatException, ChecksumException {
        k[] c2 = c(cVar, map, false);
        if (c2 != null && c2.length != 0 && c2[0] != null) {
            return c2[0];
        }
        throw NotFoundException.a();
    }

    @Override // com.google.zxing.j
    public k b(com.google.zxing.c cVar) throws NotFoundException, FormatException, ChecksumException {
        return a(cVar, null);
    }

    @Override // com.google.zxing.j
    public void reset() {
    }
}