package e.g.a.f.l;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: MatrixEvaluator.java */
/* loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {
    private final float[] a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f13297b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f13298c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.a);
        matrix2.getValues(this.f13297b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f13297b;
            float f3 = fArr[i2];
            float[] fArr2 = this.a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f13298c.setValues(this.f13297b);
        return this.f13298c;
    }
}