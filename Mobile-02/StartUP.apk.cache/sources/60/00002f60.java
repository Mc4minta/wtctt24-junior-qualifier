package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: ViewGroupDrawingOrderHelper.java */
/* loaded from: classes2.dex */
public class v0 {
    private final ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    private int f5268b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int[] f5269c;

    /* compiled from: ViewGroupDrawingOrderHelper.java */
    /* loaded from: classes2.dex */
    class a implements Comparator<View> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            Integer viewZIndex = ViewGroupManager.getViewZIndex(view);
            if (viewZIndex == null) {
                viewZIndex = r0;
            }
            Integer viewZIndex2 = ViewGroupManager.getViewZIndex(view2);
            return viewZIndex.intValue() - (viewZIndex2 != null ? viewZIndex2 : 0).intValue();
        }
    }

    public v0(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public int a(int i2, int i3) {
        if (this.f5269c == null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i2; i4++) {
                arrayList.add(this.a.getChildAt(i4));
            }
            Collections.sort(arrayList, new a());
            this.f5269c = new int[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                this.f5269c[i5] = this.a.indexOfChild((View) arrayList.get(i5));
            }
        }
        return this.f5269c[i3];
    }

    public void b(View view) {
        if (ViewGroupManager.getViewZIndex(view) != null) {
            this.f5268b++;
        }
        this.f5269c = null;
    }

    public void c(View view) {
        if (ViewGroupManager.getViewZIndex(view) != null) {
            this.f5268b--;
        }
        this.f5269c = null;
    }

    public boolean d() {
        return this.f5268b > 0;
    }

    public void e() {
        this.f5268b = 0;
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            if (ViewGroupManager.getViewZIndex(this.a.getChildAt(i2)) != null) {
                this.f5268b++;
            }
        }
        this.f5269c = null;
    }
}