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

/* compiled from: KeyAttributes.java */
/* loaded from: classes.dex */
public class d extends c {

    /* renamed from: g  reason: collision with root package name */
    private String f1087g;

    /* renamed from: h  reason: collision with root package name */
    private int f1088h = -1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1089i = false;

    /* renamed from: j  reason: collision with root package name */
    private float f1090j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    private float f1091k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    private float f1092l = Float.NaN;
    private float m = Float.NaN;
    private float n = Float.NaN;
    private float o = Float.NaN;
    private float p = Float.NaN;
    private float q = Float.NaN;
    private float r = Float.NaN;
    private float s = Float.NaN;
    private float t = Float.NaN;
    private float u = Float.NaN;
    private float v = Float.NaN;
    private float w = Float.NaN;

    /* compiled from: KeyAttributes.java */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.i.r3, 1);
            a.append(androidx.constraintlayout.widget.i.C3, 2);
            a.append(androidx.constraintlayout.widget.i.y3, 4);
            a.append(androidx.constraintlayout.widget.i.z3, 5);
            a.append(androidx.constraintlayout.widget.i.A3, 6);
            a.append(androidx.constraintlayout.widget.i.s3, 19);
            a.append(androidx.constraintlayout.widget.i.t3, 20);
            a.append(androidx.constraintlayout.widget.i.w3, 7);
            a.append(androidx.constraintlayout.widget.i.I3, 8);
            a.append(androidx.constraintlayout.widget.i.H3, 9);
            a.append(androidx.constraintlayout.widget.i.G3, 10);
            a.append(androidx.constraintlayout.widget.i.E3, 12);
            a.append(androidx.constraintlayout.widget.i.D3, 13);
            a.append(androidx.constraintlayout.widget.i.x3, 14);
            a.append(androidx.constraintlayout.widget.i.u3, 15);
            a.append(androidx.constraintlayout.widget.i.v3, 16);
            a.append(androidx.constraintlayout.widget.i.B3, 17);
            a.append(androidx.constraintlayout.widget.i.F3, 18);
        }

        public static void a(d dVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        dVar.f1090j = typedArray.getFloat(index, dVar.f1090j);
                        break;
                    case 2:
                        dVar.f1091k = typedArray.getDimension(index, dVar.f1091k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                    case 4:
                        dVar.f1092l = typedArray.getFloat(index, dVar.f1092l);
                        break;
                    case 5:
                        dVar.m = typedArray.getFloat(index, dVar.m);
                        break;
                    case 6:
                        dVar.n = typedArray.getFloat(index, dVar.n);
                        break;
                    case 7:
                        dVar.r = typedArray.getFloat(index, dVar.r);
                        break;
                    case 8:
                        dVar.q = typedArray.getFloat(index, dVar.q);
                        break;
                    case 9:
                        dVar.f1087g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, dVar.f1083c);
                            dVar.f1083c = resourceId;
                            if (resourceId == -1) {
                                dVar.f1084d = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            dVar.f1084d = typedArray.getString(index);
                            break;
                        } else {
                            dVar.f1083c = typedArray.getResourceId(index, dVar.f1083c);
                            break;
                        }
                    case 12:
                        dVar.f1082b = typedArray.getInt(index, dVar.f1082b);
                        break;
                    case 13:
                        dVar.f1088h = typedArray.getInteger(index, dVar.f1088h);
                        break;
                    case 14:
                        dVar.s = typedArray.getFloat(index, dVar.s);
                        break;
                    case 15:
                        dVar.t = typedArray.getDimension(index, dVar.t);
                        break;
                    case 16:
                        dVar.u = typedArray.getDimension(index, dVar.u);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            dVar.v = typedArray.getDimension(index, dVar.v);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        dVar.w = typedArray.getFloat(index, dVar.w);
                        break;
                    case 19:
                        dVar.o = typedArray.getDimension(index, dVar.o);
                        break;
                    case 20:
                        dVar.p = typedArray.getDimension(index, dVar.p);
                        break;
                }
            }
        }
    }

    public d() {
        this.f1085e = 1;
        this.f1086f = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
        if (r1.equals("scaleY") == false) goto L9;
     */
    @Override // androidx.constraintlayout.motion.widget.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r7) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.d.a(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void b(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1090j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1091k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1092l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.w)) {
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
        a.a(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.q3));
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void e(HashMap<String, Integer> hashMap) {
        if (this.f1088h == -1) {
            return;
        }
        if (!Float.isNaN(this.f1090j)) {
            hashMap.put("alpha", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.f1091k)) {
            hashMap.put("elevation", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.f1092l)) {
            hashMap.put("rotation", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.m)) {
            hashMap.put("rotationX", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put("rotationY", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("transformPivotX", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.p)) {
            hashMap.put("transformPivotY", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.t)) {
            hashMap.put("translationX", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.u)) {
            hashMap.put("translationY", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.v)) {
            hashMap.put("translationZ", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.q)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("scaleX", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.s)) {
            hashMap.put("scaleY", Integer.valueOf(this.f1088h));
        }
        if (!Float.isNaN(this.w)) {
            hashMap.put("progress", Integer.valueOf(this.f1088h));
        }
        if (this.f1086f.size() > 0) {
            Iterator<String> it = this.f1086f.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.f1088h));
            }
        }
    }
}