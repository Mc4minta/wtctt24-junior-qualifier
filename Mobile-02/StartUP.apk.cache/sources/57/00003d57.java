package com.google.zxing.u.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BarcodeValue.java */
/* loaded from: classes2.dex */
final class b {
    private final Map<Integer, Integer> a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (Map.Entry<Integer, Integer> entry : this.a.entrySet()) {
            if (entry.getValue().intValue() > i2) {
                i2 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i2) {
                arrayList.add(entry.getKey());
            }
        }
        return com.google.zxing.u.a.b(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2) {
        Integer num = this.a.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.a.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }
}