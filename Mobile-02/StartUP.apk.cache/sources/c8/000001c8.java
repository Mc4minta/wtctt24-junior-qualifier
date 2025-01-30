package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: KeyTrigger.java */
/* loaded from: classes.dex */
public class l extends c {

    /* renamed from: g  reason: collision with root package name */
    private int f1134g = -1;

    /* renamed from: h  reason: collision with root package name */
    private String f1135h = null;

    /* renamed from: i  reason: collision with root package name */
    private int f1136i;

    /* renamed from: j  reason: collision with root package name */
    private String f1137j;

    /* renamed from: k  reason: collision with root package name */
    private String f1138k;

    /* renamed from: l  reason: collision with root package name */
    private int f1139l;
    private int m;
    private View n;
    float o;
    private boolean p;
    private boolean q;
    private boolean r;
    private float s;
    private Method t;
    private Method u;
    private Method v;
    private float w;
    private boolean x;
    RectF y;
    RectF z;

    /* compiled from: KeyTrigger.java */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.i.M4, 8);
            a.append(androidx.constraintlayout.widget.i.Q4, 4);
            a.append(androidx.constraintlayout.widget.i.R4, 1);
            a.append(androidx.constraintlayout.widget.i.S4, 2);
            a.append(androidx.constraintlayout.widget.i.N4, 7);
            a.append(androidx.constraintlayout.widget.i.T4, 6);
            a.append(androidx.constraintlayout.widget.i.V4, 5);
            a.append(androidx.constraintlayout.widget.i.P4, 9);
            a.append(androidx.constraintlayout.widget.i.O4, 10);
            a.append(androidx.constraintlayout.widget.i.U4, 11);
        }

        public static void a(l lVar, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        lVar.f1137j = typedArray.getString(index);
                        continue;
                    case 2:
                        lVar.f1138k = typedArray.getString(index);
                        continue;
                    case 4:
                        lVar.f1135h = typedArray.getString(index);
                        continue;
                    case 5:
                        lVar.o = typedArray.getFloat(index, lVar.o);
                        continue;
                    case 6:
                        lVar.f1139l = typedArray.getResourceId(index, lVar.f1139l);
                        continue;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, lVar.f1083c);
                            lVar.f1083c = resourceId;
                            if (resourceId == -1) {
                                lVar.f1084d = typedArray.getString(index);
                            } else {
                                continue;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            lVar.f1084d = typedArray.getString(index);
                        } else {
                            lVar.f1083c = typedArray.getResourceId(index, lVar.f1083c);
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, lVar.f1082b);
                        lVar.f1082b = integer;
                        lVar.s = (integer + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        lVar.m = typedArray.getResourceId(index, lVar.m);
                        continue;
                    case 10:
                        lVar.x = typedArray.getBoolean(index, lVar.x);
                        continue;
                    case 11:
                        lVar.f1136i = typedArray.getResourceId(index, lVar.f1136i);
                        break;
                }
                Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
            }
        }
    }

    public l() {
        int i2 = c.a;
        this.f1136i = i2;
        this.f1137j = null;
        this.f1138k = null;
        this.f1139l = i2;
        this.m = i2;
        this.n = null;
        this.o = 0.1f;
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = Float.NaN;
        this.x = false;
        this.y = new RectF();
        this.z = new RectF();
        this.f1085e = 5;
        this.f1086f = new HashMap<>();
    }

    private void s(RectF rectF, View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void a(HashMap<String, s> hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void b(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void c(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.L4), context);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r(float r11, android.view.View r12) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.l.r(float, android.view.View):void");
    }
}