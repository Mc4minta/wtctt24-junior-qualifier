package com.horcrux.svg;

import android.graphics.Paint;
import android.graphics.Path;
import java.util.ArrayList;

/* compiled from: GlyphPathBag.java */
/* loaded from: classes2.dex */
class k {
    private final ArrayList<Path> a;

    /* renamed from: b  reason: collision with root package name */
    private final int[][] f10264b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f10265c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Paint paint) {
        ArrayList<Path> arrayList = new ArrayList<>();
        this.a = arrayList;
        this.f10264b = new int[256];
        this.f10265c = paint;
        arrayList.add(new Path());
    }

    private int a(char c2) {
        int[] iArr = this.f10264b[c2 >> '\b'];
        if (iArr == null) {
            return 0;
        }
        return iArr[c2 & 255];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path b(char c2, String str) {
        Path path;
        int a = a(c2);
        if (a != 0) {
            path = this.a.get(a);
        } else {
            Path path2 = new Path();
            this.f10265c.getTextPath(str, 0, 1, 0.0f, 0.0f, path2);
            int[][] iArr = this.f10264b;
            int i2 = c2 >> '\b';
            int[] iArr2 = iArr[i2];
            if (iArr2 == null) {
                iArr2 = new int[256];
                iArr[i2] = iArr2;
            }
            iArr2[c2 & 255] = this.a.size();
            this.a.add(path2);
            path = path2;
        }
        Path path3 = new Path();
        path3.addPath(path);
        return path3;
    }
}