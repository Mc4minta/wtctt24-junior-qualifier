package c.s;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PathProperty.java */
/* loaded from: classes.dex */
class q<T> extends Property<T, Float> {
    private final Property<T, PointF> a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f3341b;

    /* renamed from: c  reason: collision with root package name */
    private final float f3342c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f3343d;

    /* renamed from: e  reason: collision with root package name */
    private final PointF f3344e;

    /* renamed from: f  reason: collision with root package name */
    private float f3345f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f3343d = new float[2];
        this.f3344e = new PointF();
        this.a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f3341b = pathMeasure;
        this.f3342c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f3345f);
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(T t, Float f2) {
        this.f3345f = f2.floatValue();
        this.f3341b.getPosTan(this.f3342c * f2.floatValue(), this.f3343d, null);
        PointF pointF = this.f3344e;
        float[] fArr = this.f3343d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.a.set(t, pointF);
    }
}