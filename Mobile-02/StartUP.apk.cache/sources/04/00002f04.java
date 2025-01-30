package com.facebook.react.uimanager.f1;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.Map;

/* compiled from: AbstractLayoutAnimation.java */
/* loaded from: classes2.dex */
abstract class a {
    private static final Map<d, BaseInterpolator> a = com.facebook.react.common.c.g(d.LINEAR, new LinearInterpolator(), d.EASE_IN, new AccelerateInterpolator(), d.EASE_OUT, new DecelerateInterpolator(), d.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator());

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f5081b;

    /* renamed from: c  reason: collision with root package name */
    private int f5082c;

    /* renamed from: d  reason: collision with root package name */
    protected b f5083d;

    /* renamed from: e  reason: collision with root package name */
    protected int f5084e;

    private static Interpolator c(d dVar, ReadableMap readableMap) {
        BaseInterpolator baseInterpolator;
        if (dVar.equals(d.SPRING)) {
            baseInterpolator = new n(n.a(readableMap));
        } else {
            baseInterpolator = a.get(dVar);
        }
        if (baseInterpolator != null) {
            return baseInterpolator;
        }
        throw new IllegalArgumentException("Missing interpolator for type : " + dVar);
    }

    public final Animation a(View view, int i2, int i3, int i4, int i5) {
        if (e()) {
            Animation b2 = b(view, i2, i3, i4, i5);
            if (b2 != null) {
                b2.setDuration(this.f5084e * 1);
                b2.setStartOffset(this.f5082c * 1);
                b2.setInterpolator(this.f5081b);
            }
            return b2;
        }
        return null;
    }

    abstract Animation b(View view, int i2, int i3, int i4, int i5);

    public void d(ReadableMap readableMap, int i2) {
        this.f5083d = readableMap.hasKey("property") ? b.h(readableMap.getString("property")) : null;
        if (readableMap.hasKey("duration")) {
            i2 = readableMap.getInt("duration");
        }
        this.f5084e = i2;
        this.f5082c = readableMap.hasKey("delay") ? readableMap.getInt("delay") : 0;
        if (readableMap.hasKey("type")) {
            this.f5081b = c(d.h(readableMap.getString("type")), readableMap);
            if (e()) {
                return;
            }
            throw new IllegalViewOperationException("Invalid layout animation : " + readableMap);
        }
        throw new IllegalArgumentException("Missing interpolation type.");
    }

    abstract boolean e();

    public void f() {
        this.f5083d = null;
        this.f5084e = 0;
        this.f5082c = 0;
        this.f5081b = null;
    }
}