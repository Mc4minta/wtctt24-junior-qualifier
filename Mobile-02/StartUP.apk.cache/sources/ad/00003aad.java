package com.google.firebase.crashlytics.c.q;

import java.util.HashMap;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class c implements d {
    private final int a;

    public c(int i2) {
        this.a = i2;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, int i2, int i3) {
        int i4 = i3 - i2;
        if (i3 + i4 > stackTraceElementArr.length) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!stackTraceElementArr[i2 + i5].equals(stackTraceElementArr[i3 + i5])) {
                return false;
            }
        }
        return true;
    }

    private static StackTraceElement[] c(StackTraceElement[] stackTraceElementArr, int i2) {
        int i3;
        HashMap hashMap = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i4 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i4];
            Integer num = (Integer) hashMap.get(stackTraceElement);
            if (num != null && b(stackTraceElementArr, num.intValue(), i4)) {
                int intValue = i4 - num.intValue();
                if (i6 < i2) {
                    System.arraycopy(stackTraceElementArr, i4, stackTraceElementArr2, i5, intValue);
                    i5 += intValue;
                    i6++;
                }
                i3 = (intValue - 1) + i4;
            } else {
                stackTraceElementArr2[i5] = stackTraceElementArr[i4];
                i5++;
                i6 = 1;
                i3 = i4;
            }
            hashMap.put(stackTraceElement, Integer.valueOf(i4));
            i4 = i3 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i5];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i5);
        return stackTraceElementArr3;
    }

    @Override // com.google.firebase.crashlytics.c.q.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] c2 = c(stackTraceElementArr, this.a);
        return c2.length < stackTraceElementArr.length ? c2 : stackTraceElementArr;
    }
}