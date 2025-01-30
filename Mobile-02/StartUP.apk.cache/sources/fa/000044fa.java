package e.a.a.y;

import android.graphics.Color;
import e.a.a.y.k0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GradientColorParser.java */
/* loaded from: classes.dex */
public class l implements j0<e.a.a.w.k.c> {
    private int a;

    public l(int i2) {
        this.a = i2;
    }

    private void b(e.a.a.w.k.c cVar, List<Float> list) {
        int i2 = this.a * 4;
        if (list.size() <= i2) {
            return;
        }
        int size = (list.size() - i2) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i3 = 0;
        while (i2 < list.size()) {
            if (i2 % 2 == 0) {
                dArr[i3] = list.get(i2).floatValue();
            } else {
                dArr2[i3] = list.get(i2).floatValue();
                i3++;
            }
            i2++;
        }
        for (int i4 = 0; i4 < cVar.c(); i4++) {
            int i5 = cVar.a()[i4];
            cVar.a()[i4] = Color.argb(c(cVar.b()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
        }
    }

    private int c(double d2, double[] dArr, double[] dArr2) {
        double d3;
        int i2 = 1;
        while (true) {
            if (i2 < dArr.length) {
                int i3 = i2 - 1;
                double d4 = dArr[i3];
                double d5 = dArr[i2];
                if (dArr[i2] >= d2) {
                    d3 = e.a.a.z.g.j(dArr2[i3], dArr2[i2], e.a.a.z.g.b((d2 - d4) / (d5 - d4), 0.0d, 1.0d));
                    break;
                }
                i2++;
            } else {
                d3 = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (d3 * 255.0d);
    }

    @Override // e.a.a.y.j0
    /* renamed from: d */
    public e.a.a.w.k.c a(e.a.a.y.k0.c cVar, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = cVar.A() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.b();
        }
        while (cVar.f()) {
            arrayList.add(Float.valueOf((float) cVar.j()));
        }
        if (z) {
            cVar.d();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i2 = this.a;
        float[] fArr = new float[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < this.a * 4; i5++) {
            int i6 = i5 / 4;
            double floatValue = arrayList.get(i5).floatValue();
            int i7 = i5 % 4;
            if (i7 == 0) {
                fArr[i6] = (float) floatValue;
            } else if (i7 == 1) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i7 == 2) {
                i4 = (int) (floatValue * 255.0d);
            } else if (i7 == 3) {
                iArr[i6] = Color.argb(255, i3, i4, (int) (floatValue * 255.0d));
            }
        }
        e.a.a.w.k.c cVar2 = new e.a.a.w.k.c(fArr, iArr);
        b(cVar2, arrayList);
        return cVar2;
    }
}