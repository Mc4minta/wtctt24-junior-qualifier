package com.google.android.flexbox;

import android.view.View;
import java.util.List;

/* compiled from: FlexContainer.java */
/* loaded from: classes2.dex */
interface a {
    void b(View view, int i2, int i3, c cVar);

    void c(c cVar);

    View d(int i2);

    int e(int i2, int i3, int i4);

    void f(int i2, View view);

    View g(int i2);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<c> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int h(View view, int i2, int i3);

    int i(int i2, int i3, int i4);

    boolean j();

    int k(View view);

    void setFlexLines(List<c> list);
}