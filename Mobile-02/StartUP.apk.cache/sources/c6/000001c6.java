package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: KeyTimeCycle.java */
/* loaded from: classes.dex */
public class k extends c {

    /* renamed from: g  reason: collision with root package name */
    private String f1128g;

    /* renamed from: h  reason: collision with root package name */
    private int f1129h = -1;

    /* renamed from: i  reason: collision with root package name */
    private float f1130i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    private float f1131j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    private float f1132k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    private float f1133l = Float.NaN;
    private float m = Float.NaN;
    private float n = Float.NaN;
    private float o = Float.NaN;
    private float p = Float.NaN;
    private float q = Float.NaN;
    private float r = Float.NaN;
    private float s = Float.NaN;
    private float t = Float.NaN;
    private int u = 0;
    private float v = Float.NaN;
    private float w = 0.0f;

    /* compiled from: KeyTimeCycle.java */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.i.s4, 1);
            a.append(androidx.constraintlayout.widget.i.B4, 2);
            a.append(androidx.constraintlayout.widget.i.x4, 4);
            a.append(androidx.constraintlayout.widget.i.y4, 5);
            a.append(androidx.constraintlayout.widget.i.z4, 6);
            a.append(androidx.constraintlayout.widget.i.v4, 7);
            a.append(androidx.constraintlayout.widget.i.H4, 8);
            a.append(androidx.constraintlayout.widget.i.G4, 9);
            a.append(androidx.constraintlayout.widget.i.F4, 10);
            a.append(androidx.constraintlayout.widget.i.D4, 12);
            a.append(androidx.constraintlayout.widget.i.C4, 13);
            a.append(androidx.constraintlayout.widget.i.w4, 14);
            a.append(androidx.constraintlayout.widget.i.t4, 15);
            a.append(androidx.constraintlayout.widget.i.u4, 16);
            a.append(androidx.constraintlayout.widget.i.A4, 17);
            a.append(androidx.constraintlayout.widget.i.E4, 18);
            a.append(androidx.constraintlayout.widget.i.J4, 20);
            a.append(androidx.constraintlayout.widget.i.I4, 21);
            a.append(androidx.constraintlayout.widget.i.K4, 19);
        }

        public static void a(k kVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        kVar.f1130i = typedArray.getFloat(index, kVar.f1130i);
                        break;
                    case 2:
                        kVar.f1131j = typedArray.getDimension(index, kVar.f1131j);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                    case 4:
                        kVar.f1132k = typedArray.getFloat(index, kVar.f1132k);
                        break;
                    case 5:
                        kVar.f1133l = typedArray.getFloat(index, kVar.f1133l);
                        break;
                    case 6:
                        kVar.m = typedArray.getFloat(index, kVar.m);
                        break;
                    case 7:
                        kVar.o = typedArray.getFloat(index, kVar.o);
                        break;
                    case 8:
                        kVar.n = typedArray.getFloat(index, kVar.n);
                        break;
                    case 9:
                        kVar.f1128g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, kVar.f1083c);
                            kVar.f1083c = resourceId;
                            if (resourceId == -1) {
                                kVar.f1084d = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            kVar.f1084d = typedArray.getString(index);
                            break;
                        } else {
                            kVar.f1083c = typedArray.getResourceId(index, kVar.f1083c);
                            break;
                        }
                    case 12:
                        kVar.f1082b = typedArray.getInt(index, kVar.f1082b);
                        break;
                    case 13:
                        kVar.f1129h = typedArray.getInteger(index, kVar.f1129h);
                        break;
                    case 14:
                        kVar.p = typedArray.getFloat(index, kVar.p);
                        break;
                    case 15:
                        kVar.q = typedArray.getDimension(index, kVar.q);
                        break;
                    case 16:
                        kVar.r = typedArray.getDimension(index, kVar.r);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            kVar.s = typedArray.getDimension(index, kVar.s);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        kVar.t = typedArray.getFloat(index, kVar.t);
                        break;
                    case 19:
                        kVar.u = typedArray.getInt(index, kVar.u);
                        break;
                    case 20:
                        kVar.v = typedArray.getFloat(index, kVar.v);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            kVar.w = typedArray.getDimension(index, kVar.w);
                            break;
                        } else {
                            kVar.w = typedArray.getFloat(index, kVar.w);
                            break;
                        }
                }
            }
        }
    }

    public k() {
        this.f1085e = 3;
        this.f1086f = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
        if (r1.equals("scaleY") == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void M(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.t> r11) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.k.M(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void a(HashMap<String, s> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void b(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1130i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1131j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1132k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1133l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("progress");
        }
        if (this.f1086f.size() > 0) {
            Iterator<String> it = this.f1086f.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void c(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.r4));
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void e(HashMap<String, Integer> hashMap) {
        if (this.f1129h == -1) {
            return;
        }
        if (!Float.isNaN(this.f1130i)) {
            hashMap.put("alpha", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.f1131j)) {
            hashMap.put("elevation", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.f1132k)) {
            hashMap.put("rotation", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.f1133l)) {
            hashMap.put("rotationX", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.m)) {
            hashMap.put("rotationY", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.q)) {
            hashMap.put("translationX", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("translationY", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.s)) {
            hashMap.put("translationZ", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("scaleX", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("scaleY", Integer.valueOf(this.f1129h));
        }
        if (!Float.isNaN(this.t)) {
            hashMap.put("progress", Integer.valueOf(this.f1129h));
        }
        if (this.f1086f.size() > 0) {
            Iterator<String> it = this.f1086f.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.f1129h));
            }
        }
    }
}