package c.t.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import c.h.e.c;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.HttpStatus;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatorInflaterCompat.java */
/* loaded from: classes.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatorInflaterCompat.java */
    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator<c.b[]> {
        private c.b[] a;

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public c.b[] evaluate(float f2, c.b[] bVarArr, c.b[] bVarArr2) {
            if (c.h.e.c.b(bVarArr, bVarArr2)) {
                if (!c.h.e.c.b(this.a, bVarArr)) {
                    this.a = c.h.e.c.f(bVarArr);
                }
                for (int i2 = 0; i2 < bVarArr.length; i2++) {
                    this.a[i2].d(bVarArr[i2], bVarArr2[i2], f2);
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) throws XmlPullParserException, IOException {
        return b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.animation.Animator b(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.a.a.e.b(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static Keyframe c(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f2);
        }
        return Keyframe.ofObject(f2);
    }

    private static void d(Keyframe[] keyframeArr, float f2, int i2, int i3) {
        float f3 = f2 / ((i3 - i2) + 2);
        while (i2 <= i3) {
            keyframeArr[i2].setFraction(keyframeArr[i2 - 1].getFraction() + f3);
            i2++;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray, int i2, int i3, int i4, String str) {
        int i5;
        int i6;
        int i7;
        float f2;
        PropertyValuesHolder ofFloat;
        float f3;
        float f4;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i3);
        boolean z = peekValue != null;
        int i8 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i4);
        boolean z2 = peekValue2 != null;
        int i9 = z2 ? peekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((z && h(i8)) || (z2 && h(i9))) ? 3 : 0;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            c.b[] d2 = c.h.e.c.d(string);
            c.b[] d3 = c.h.e.c.d(string2);
            if (d2 == null && d3 == null) {
                return null;
            }
            if (d2 == null) {
                if (d3 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), d3);
                }
                return null;
            }
            a aVar = new a();
            if (d3 != null) {
                if (c.h.e.c.b(d2, d3)) {
                    ofObject = PropertyValuesHolder.ofObject(str, aVar, d2, d3);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
            } else {
                ofObject = PropertyValuesHolder.ofObject(str, aVar, d2);
            }
            return ofObject;
        }
        f a2 = i2 == 3 ? f.a() : null;
        if (z3) {
            if (z) {
                if (i8 == 5) {
                    f3 = typedArray.getDimension(i3, 0.0f);
                } else {
                    f3 = typedArray.getFloat(i3, 0.0f);
                }
                if (z2) {
                    if (i9 == 5) {
                        f4 = typedArray.getDimension(i4, 0.0f);
                    } else {
                        f4 = typedArray.getFloat(i4, 0.0f);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f3, f4);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f3);
                }
            } else {
                if (i9 == 5) {
                    f2 = typedArray.getDimension(i4, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i4, 0.0f);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f2);
            }
            propertyValuesHolder = ofFloat;
        } else if (z) {
            if (i8 == 5) {
                i6 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (h(i8)) {
                i6 = typedArray.getColor(i3, 0);
            } else {
                i6 = typedArray.getInt(i3, 0);
            }
            if (z2) {
                if (i9 == 5) {
                    i7 = (int) typedArray.getDimension(i4, 0.0f);
                } else if (h(i9)) {
                    i7 = typedArray.getColor(i4, 0);
                } else {
                    i7 = typedArray.getInt(i4, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6, i7);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6);
            }
        } else if (z2) {
            if (i9 == 5) {
                i5 = (int) typedArray.getDimension(i4, 0.0f);
            } else if (h(i9)) {
                i5 = typedArray.getColor(i4, 0);
            } else {
                i5 = typedArray.getInt(i4, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
        }
        if (propertyValuesHolder == null || a2 == null) {
            return propertyValuesHolder;
        }
        propertyValuesHolder.setEvaluator(a2);
        return propertyValuesHolder;
    }

    private static int f(TypedArray typedArray, int i2, int i3) {
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i4 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        return ((z && h(i4)) || (z2 && h(z2 ? peekValue2.type : 0))) ? 3 : 0;
    }

    private static int g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.t.a.a.a.f3413j);
        int i2 = 0;
        TypedValue l2 = androidx.core.content.d.h.l(k2, xmlPullParser, "value", 0);
        if ((l2 != null) && h(l2.type)) {
            i2 = 3;
        }
        k2.recycle();
        return i2;
    }

    private static boolean h(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static Animator i(Context context, int i2) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i2);
        }
        return j(context, context.getResources(), context.getTheme(), i2);
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int i2) throws Resources.NotFoundException {
        return k(context, resources, theme, i2, 1.0f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int i2, float f2) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i2);
                    return a(context, resources, theme, xmlResourceParser, f2);
                } catch (IOException e2) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException.initCause(e2);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e3) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                notFoundException2.initCause(e3);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    private static ValueAnimator l(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.t.a.a.a.f3410g);
        TypedArray k3 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.t.a.a.a.f3414k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        q(valueAnimator, k2, k3, f2, xmlPullParser);
        int h2 = androidx.core.content.d.h.h(k2, xmlPullParser, "interpolator", 0, 0);
        if (h2 > 0) {
            valueAnimator.setInterpolator(d.b(context, h2));
        }
        k2.recycle();
        if (k3 != null) {
            k3.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i2, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Keyframe ofInt;
        TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.t.a.a.a.f3413j);
        float f2 = androidx.core.content.d.h.f(k2, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue l2 = androidx.core.content.d.h.l(k2, xmlPullParser, "value", 0);
        boolean z = l2 != null;
        if (i2 == 4) {
            i2 = (z && h(l2.type)) ? 3 : 0;
        }
        if (z) {
            if (i2 != 0) {
                ofInt = (i2 == 1 || i2 == 3) ? Keyframe.ofInt(f2, androidx.core.content.d.h.g(k2, xmlPullParser, "value", 0, 0)) : null;
            } else {
                ofInt = Keyframe.ofFloat(f2, androidx.core.content.d.h.f(k2, xmlPullParser, "value", 0, 0.0f));
            }
        } else if (i2 == 0) {
            ofInt = Keyframe.ofFloat(f2);
        } else {
            ofInt = Keyframe.ofInt(f2);
        }
        int h2 = androidx.core.content.d.h.h(k2, xmlPullParser, "interpolator", 1, 0);
        if (h2 > 0) {
            ofInt.setInterpolator(d.b(context, h2));
        }
        k2.recycle();
        return ofInt;
    }

    private static ObjectAnimator n(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        l(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i2) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolder = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i2 == 4) {
                    i2 = g(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe m = m(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i2, xmlPullParser);
                if (m != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(m);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), c(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, c(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i3 = 0; i3 < size; i3++) {
                Keyframe keyframe3 = keyframeArr[i3];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i3 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i4 = size - 1;
                        if (i3 == i4) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i5 = i3;
                            for (int i6 = i3 + 1; i6 < i4 && keyframeArr[i6].getFraction() < 0.0f; i6++) {
                                i5 = i6;
                            }
                            d(keyframeArr, keyframeArr[i5 + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, i5);
                        }
                    }
                }
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i2 == 3) {
                propertyValuesHolder.setEvaluator(f.a());
            }
        }
        return propertyValuesHolder;
    }

    private static PropertyValuesHolder[] p(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i2;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray k2 = androidx.core.content.d.h.k(resources, theme, attributeSet, c.t.a.a.a.f3412i);
                    String i3 = androidx.core.content.d.h.i(k2, xmlPullParser, "propertyName", 3);
                    int g2 = androidx.core.content.d.h.g(k2, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder o = o(context, resources, theme, xmlPullParser, i3, g2);
                    if (o == null) {
                        o = e(k2, g2, 0, 1, i3);
                    }
                    if (o != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(o);
                    }
                    k2.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i2 = 0; i2 < size; i2++) {
                propertyValuesHolderArr[i2] = (PropertyValuesHolder) arrayList.get(i2);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void q(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        long g2 = androidx.core.content.d.h.g(typedArray, xmlPullParser, "duration", 1, HttpStatus.SC_MULTIPLE_CHOICES);
        long g3 = androidx.core.content.d.h.g(typedArray, xmlPullParser, "startOffset", 2, 0);
        int g4 = androidx.core.content.d.h.g(typedArray, xmlPullParser, "valueType", 7, 4);
        if (androidx.core.content.d.h.j(xmlPullParser, "valueFrom") && androidx.core.content.d.h.j(xmlPullParser, "valueTo")) {
            if (g4 == 4) {
                g4 = f(typedArray, 5, 6);
            }
            PropertyValuesHolder e2 = e(typedArray, g4, 5, 6, "");
            if (e2 != null) {
                valueAnimator.setValues(e2);
            }
        }
        valueAnimator.setDuration(g2);
        valueAnimator.setStartDelay(g3);
        valueAnimator.setRepeatCount(androidx.core.content.d.h.g(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(androidx.core.content.d.h.g(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            r(valueAnimator, typedArray2, g4, f2, xmlPullParser);
        }
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray, int i2, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String i3 = androidx.core.content.d.h.i(typedArray, xmlPullParser, "pathData", 1);
        if (i3 != null) {
            String i4 = androidx.core.content.d.h.i(typedArray, xmlPullParser, "propertyXName", 2);
            String i5 = androidx.core.content.d.h.i(typedArray, xmlPullParser, "propertyYName", 3);
            if (i2 != 2) {
            }
            if (i4 == null && i5 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            s(c.h.e.c.e(i3), objectAnimator, f2 * 0.5f, i4, i5);
            return;
        }
        objectAnimator.setPropertyName(androidx.core.content.d.h.i(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void s(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f3 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f4 = 0.0f;
        do {
            f4 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f4));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f4 / f2)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        float f5 = f4 / (min - 1);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= min) {
                break;
            }
            pathMeasure2.getPosTan(f3 - ((Float) arrayList.get(i3)).floatValue(), fArr3, null);
            fArr[i2] = fArr3[0];
            fArr2[i2] = fArr3[1];
            f3 += f5;
            int i4 = i3 + 1;
            if (i4 < arrayList.size() && f3 > ((Float) arrayList.get(i4)).floatValue()) {
                pathMeasure2.nextContour();
                i3 = i4;
            }
            i2++;
        }
        PropertyValuesHolder ofFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder ofFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (ofFloat == null) {
            objectAnimator.setValues(ofFloat2);
        } else if (ofFloat2 == null) {
            objectAnimator.setValues(ofFloat);
        } else {
            objectAnimator.setValues(ofFloat, ofFloat2);
        }
    }
}