package com.facebook.react.views.modal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: ModalHostHelper.java */
/* loaded from: classes2.dex */
class a {
    private static final Point a = new Point();

    /* renamed from: b  reason: collision with root package name */
    private static final Point f5322b = new Point();

    /* renamed from: c  reason: collision with root package name */
    private static final Point f5323c = new Point();

    public static Point a(Context context) {
        Display defaultDisplay = ((WindowManager) e.f.k.a.a.c((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        Point point = a;
        Point point2 = f5322b;
        defaultDisplay.getCurrentSizeRange(point, point2);
        Point point3 = f5323c;
        defaultDisplay.getSize(point3);
        int i2 = 0;
        boolean z = context.getTheme().obtainStyledAttributes(new int[]{16843277}).getBoolean(0, false);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (z && identifier > 0) {
            i2 = (int) resources.getDimension(identifier);
        }
        if (point3.x < point3.y) {
            return new Point(point.x, point2.y + i2);
        }
        return new Point(point2.x, point.y + i2);
    }
}