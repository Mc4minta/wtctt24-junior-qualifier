package com.toshi.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;

/* loaded from: classes2.dex */
public class NoScrollGridLayoutManager extends GridLayoutManager {
    public NoScrollGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        return false;
    }
}