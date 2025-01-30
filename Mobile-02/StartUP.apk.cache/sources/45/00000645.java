package c.s;

import android.animation.TypeEvaluator;

/* compiled from: FloatArrayEvaluator.java */
/* loaded from: classes.dex */
class g implements TypeEvaluator<float[]> {
    private float[] a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(float[] fArr) {
        this.a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public float[] evaluate(float f2, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i2 = 0; i2 < fArr3.length; i2++) {
            float f3 = fArr[i2];
            fArr3[i2] = f3 + ((fArr2[i2] - f3) * f2);
        }
        return fArr3;
    }
}