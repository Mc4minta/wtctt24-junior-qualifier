package com.facebook.react.devsupport;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;

/* compiled from: ViewHierarchyUtil.java */
/* loaded from: classes2.dex */
public class f {
    public static Pair<View, Integer> a(View view) {
        LinkedList linkedList = new LinkedList();
        Pair<View, Integer> pair = new Pair<>(view, 1);
        linkedList.add(pair);
        while (!linkedList.isEmpty()) {
            Pair<View, Integer> pair2 = (Pair) linkedList.poll();
            if (((Integer) pair2.second).intValue() > ((Integer) pair.second).intValue()) {
                pair = pair2;
            }
            Object obj = pair2.first;
            if (obj instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) obj;
                Integer valueOf = Integer.valueOf(((Integer) pair2.second).intValue() + 1);
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    linkedList.add(new Pair(viewGroup.getChildAt(i2), valueOf));
                }
            }
        }
        return pair;
    }
}