package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import java.util.HashMap;

/* compiled from: KeyPosition.java */
/* loaded from: classes.dex */
public class i extends j {

    /* renamed from: h  reason: collision with root package name */
    String f1122h = null;

    /* renamed from: i  reason: collision with root package name */
    int f1123i = c.a;

    /* renamed from: j  reason: collision with root package name */
    int f1124j = 0;

    /* renamed from: k  reason: collision with root package name */
    float f1125k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    float f1126l = Float.NaN;
    float m = Float.NaN;
    float n = Float.NaN;
    float o = Float.NaN;
    float p = Float.NaN;
    int q = 0;
    private float r = Float.NaN;
    private float s = Float.NaN;

    /* compiled from: KeyPosition.java */
    /* loaded from: classes.dex */
    private static class a {
        private static SparseIntArray a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.i.j4, 1);
            a.append(androidx.constraintlayout.widget.i.h4, 2);
            a.append(androidx.constraintlayout.widget.i.q4, 3);
            a.append(androidx.constraintlayout.widget.i.f4, 4);
            a.append(androidx.constraintlayout.widget.i.g4, 5);
            a.append(androidx.constraintlayout.widget.i.n4, 6);
            a.append(androidx.constraintlayout.widget.i.o4, 7);
            a.append(androidx.constraintlayout.widget.i.i4, 9);
            a.append(androidx.constraintlayout.widget.i.p4, 8);
            a.append(androidx.constraintlayout.widget.i.m4, 11);
            a.append(androidx.constraintlayout.widget.i.l4, 12);
            a.append(androidx.constraintlayout.widget.i.k4, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(i iVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, iVar.f1083c);
                            iVar.f1083c = resourceId;
                            if (resourceId == -1) {
                                iVar.f1084d = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            iVar.f1084d = typedArray.getString(index);
                            break;
                        } else {
                            iVar.f1083c = typedArray.getResourceId(index, iVar.f1083c);
                            break;
                        }
                    case 2:
                        iVar.f1082b = typedArray.getInt(index, iVar.f1082b);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            iVar.f1122h = typedArray.getString(index);
                            break;
                        } else {
                            iVar.f1122h = c.f.a.a.c.f2675b[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        iVar.f1127g = typedArray.getInteger(index, iVar.f1127g);
                        break;
                    case 5:
                        iVar.f1124j = typedArray.getInt(index, iVar.f1124j);
                        break;
                    case 6:
                        iVar.m = typedArray.getFloat(index, iVar.m);
                        break;
                    case 7:
                        iVar.n = typedArray.getFloat(index, iVar.n);
                        break;
                    case 8:
                        float f2 = typedArray.getFloat(index, iVar.f1126l);
                        iVar.f1125k = f2;
                        iVar.f1126l = f2;
                        break;
                    case 9:
                        iVar.q = typedArray.getInt(index, iVar.q);
                        break;
                    case 10:
                        iVar.f1123i = typedArray.getInt(index, iVar.f1123i);
                        break;
                    case 11:
                        iVar.f1125k = typedArray.getFloat(index, iVar.f1125k);
                        break;
                    case 12:
                        iVar.f1126l = typedArray.getFloat(index, iVar.f1126l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                        break;
                }
            }
            if (iVar.f1082b == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public i() {
        this.f1085e = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void a(HashMap<String, s> hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.c
    public void c(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.i.e4));
    }
}