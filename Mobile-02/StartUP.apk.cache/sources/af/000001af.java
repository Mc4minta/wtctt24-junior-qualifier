package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: KeyCycle.java */
/* loaded from: classes.dex */
public class f extends c {

    /* renamed from: g  reason: collision with root package name */
    private String f1093g = null;

    /* renamed from: h  reason: collision with root package name */
    private int f1094h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f1095i = -1;

    /* renamed from: j  reason: collision with root package name */
    private float f1096j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    private float f1097k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f1098l = Float.NaN;
    private int m = -1;
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
    private float x = Float.NaN;

    /* compiled from: KeyCycle.java */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.i.X3, 1);
            a.append(androidx.constraintlayout.widget.i.V3, 2);
            a.append(androidx.constraintlayout.widget.i.Y3, 3);
            a.append(androidx.constraintlayout.widget.i.U3, 4);
            a.append(androidx.constraintlayout.widget.i.c4, 5);
            a.append(androidx.constraintlayout.widget.i.b4, 6);
            a.append(androidx.constraintlayout.widget.i.a4, 7);
            a.append(androidx.constraintlayout.widget.i.d4, 8);
            a.append(androidx.constraintlayout.widget.i.K3, 9);
            a.append(androidx.constraintlayout.widget.i.T3, 10);
            a.append(androidx.constraintlayout.widget.i.P3, 11);
            a.append(androidx.constraintlayout.widget.i.Q3, 12);
            a.append(androidx.constraintlayout.widget.i.R3, 13);
            a.append(androidx.constraintlayout.widget.i.Z3, 14);
            a.append(androidx.constraintlayout.widget.i.N3, 15);
            a.append(androidx.constraintlayout.widget.i.O3, 16);
            a.append(androidx.constraintlayout.widget.i.L3, 17);
            a.append(androidx.constraintlayout.widget.i.M3, 18);
            a.append(androidx.constraintlayout.widget.i.S3, 19);
            a.append(androidx.constraintlayout.widget.i.W3, 20);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(f fVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, fVar.f1083c);
                            fVar.f1083c = resourceId;
                            if (resourceId == -1) {
                                fVar.f1084d = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            fVar.f1084d = typedArray.getString(index);
                            break;
                        } else {
                            fVar.f1083c = typedArray.getResourceId(index, fVar.f1083c);
                            break;
                        }
                    case 2:
                        fVar.f1082b = typedArray.getInt(index, fVar.f1082b);
                        break;
                    case 3:
                        fVar.f1093g = typedArray.getString(index);
                        break;
                    case 4:
                        fVar.f1094h = typedArray.getInteger(index, fVar.f1094h);
                        break;
                    case 5:
                        fVar.f1095i = typedArray.getInt(index, fVar.f1095i);
                        break;
                    case 6:
                        fVar.f1096j = typedArray.getFloat(index, fVar.f1096j);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            fVar.f1097k = typedArray.getDimension(index, fVar.f1097k);
                            break;
                        } else {
                            fVar.f1097k = typedArray.getFloat(index, fVar.f1097k);
                            break;
                        }
                    case 8:
                        fVar.m = typedArray.getInt(index, fVar.m);
                        break;
                    case 9:
                        fVar.n = typedArray.getFloat(index, fVar.n);
                        break;
                    case 10:
                        fVar.o = typedArray.getDimension(index, fVar.o);
                        break;
                    case 11:
                        fVar.p = typedArray.getFloat(index, fVar.p);
                        break;
                    case 12:
                        fVar.r = typedArray.getFloat(index, fVar.r);
                        break;
                    case 13:
                        fVar.s = typedArray.getFloat(index, fVar.s);
                        break;
                    case 14:
                        fVar.q = typedArray.getFloat(index, fVar.q);
                        break;
                    case 15:
                        fVar.t = typedArray.getFloat(index, fVar.t);
                        break;
                    case 16:
                        fVar.u = typedArray.getFloat(index, fVar.u);
                        break;
                    case 17:
                        fVar.v = typedArray.getDimension(index, fVar.v);
                        break;
                    case 18:
                        fVar.w = typedArray.getDimension(index, fVar.w);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT >= 21) {
                            fVar.x = typedArray.getDimension(index, fVar.x);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        fVar.f1098l = typedArray.getFloat(index, fVar.f1098l);
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                }
            }
        }
    }

    public f() {
        this.f1085e = 4;
        this.f1086f = new HashMap<>();
    }

    public void O(HashMap<String, g> hashMap) {
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                androidx.constraintlayout.widget.a aVar = this.f1086f.get(str.substring(7));
                if (aVar != null && aVar.c() == a.b.FLOAT_TYPE) {
                    hashMap.get(str).e(this.f1082b, this.f1095i, this.m, this.f1096j, this.f1097k, aVar.d(), aVar);
                }
            }
            float P = P(str);
            if (!Float.isNaN(P)) {
                hashMap.get(str).d(this.f1082b, this.f1095i, this.m, this.f1096j, this.f1097k, P);
            }
        }
    }

    public float P(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 11;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = '\f';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return this.r;
            case 1:
                return this.s;
            case 2:
                return this.v;
            case 3:
                return this.w;
            case 4:
                return this.x;
            case 5:
                return this.f1098l;
            case 6:
                return this.t;
            case 7:
                return this.u;
            case '\b':
                return this.p;
            case '\t':
                return this.o;
            case '\n':
                return this.q;
            case 11:
                return this.n;
            case '\f':
                return this.f1097k;
            default:
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void a(HashMap<String, s> hashMap) {
        androidx.constraintlayout.motion.widget.a.e("KeyCycle", "add " + hashMap.size() + " values", 2);
        for (String str : hashMap.keySet()) {
            s sVar = hashMap.get(str);
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 156108012:
                    if (str.equals("waveOffset")) {
                        c2 = '\f';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    sVar.e(this.f1082b, this.r);
                    break;
                case 1:
                    sVar.e(this.f1082b, this.s);
                    break;
                case 2:
                    sVar.e(this.f1082b, this.v);
                    break;
                case 3:
                    sVar.e(this.f1082b, this.w);
                    break;
                case 4:
                    sVar.e(this.f1082b, this.x);
                    break;
                case 5:
                    sVar.e(this.f1082b, this.f1098l);
                    break;
                case 6:
                    sVar.e(this.f1082b, this.t);
                    break;
                case 7:
                    sVar.e(this.f1082b, this.u);
                    break;
                case '\b':
                    sVar.e(this.f1082b, this.p);
                    break;
                case '\t':
                    sVar.e(this.f1082b, this.o);
                    break;
                case '\n':
                    sVar.e(this.f1082b, this.q);
                    break;
                case 11:
                    sVar.e(this.f1082b, this.n);
                    break;
                case '\f':
                    sVar.e(this.f1082b, this.f1097k);
                    break;
                default:
                    Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                    break;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void b(HashSet<String> hashSet) {
        if (!Float.isNaN(this.n)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.x)) {
            hashSet.add("translationZ");
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
        a.b(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.J3));
    }
}