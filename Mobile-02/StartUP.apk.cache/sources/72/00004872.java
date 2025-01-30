package e.g.a.f.l;

import android.util.Property;
import android.view.ViewGroup;

/* compiled from: ChildrenAlphaProperty.java */
/* loaded from: classes2.dex */
public class d extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> a = new d("childrenAlpha");

    private d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(ViewGroup viewGroup) {
        Float f2 = (Float) viewGroup.getTag(e.g.a.f.f.f13260h);
        return f2 != null ? f2 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(ViewGroup viewGroup, Float f2) {
        float floatValue = f2.floatValue();
        viewGroup.setTag(e.g.a.f.f.f13260h, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setAlpha(floatValue);
        }
    }
}