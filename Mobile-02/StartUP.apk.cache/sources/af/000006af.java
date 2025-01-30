package com.airbnb.android.react.lottie;

import android.graphics.Color;
import android.widget.ImageView;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import e.a.a.a0.c;
import e.a.a.d;
import e.a.a.l;
import e.a.a.r;
import e.a.a.s;
import e.a.a.w.e;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;

/* compiled from: LottieAnimationViewPropertyManager.java */
/* loaded from: classes.dex */
public class a {
    private final WeakReference<d> a;

    /* renamed from: b  reason: collision with root package name */
    private String f3497b;

    /* renamed from: c  reason: collision with root package name */
    private Float f3498c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f3499d;

    /* renamed from: e  reason: collision with root package name */
    private Float f3500e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3501f;

    /* renamed from: g  reason: collision with root package name */
    private String f3502g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView.ScaleType f3503h;

    /* renamed from: i  reason: collision with root package name */
    private String f3504i;

    /* renamed from: j  reason: collision with root package name */
    private Boolean f3505j;

    /* renamed from: k  reason: collision with root package name */
    private ReadableArray f3506k;

    /* renamed from: l  reason: collision with root package name */
    private r f3507l;

    public a(d dVar) {
        this.a = new WeakReference<>(dVar);
    }

    public void a() {
        d dVar = this.a.get();
        if (dVar == null) {
            return;
        }
        String str = this.f3497b;
        if (str != null) {
            dVar.w(str, Integer.toString(str.hashCode()));
            this.f3497b = null;
        }
        if (this.f3501f) {
            dVar.setAnimation(this.f3502g);
            this.f3501f = false;
        }
        Float f2 = this.f3498c;
        if (f2 != null) {
            dVar.setProgress(f2.floatValue());
            this.f3498c = null;
        }
        Boolean bool = this.f3499d;
        if (bool != null) {
            dVar.setRepeatCount(bool.booleanValue() ? -1 : 0);
            this.f3499d = null;
        }
        Float f3 = this.f3500e;
        if (f3 != null) {
            dVar.setSpeed(f3.floatValue());
            this.f3500e = null;
        }
        ImageView.ScaleType scaleType = this.f3503h;
        if (scaleType != null) {
            dVar.setScaleType(scaleType);
            this.f3503h = null;
        }
        r rVar = this.f3507l;
        if (rVar != null) {
            dVar.setRenderMode(rVar);
            this.f3507l = null;
        }
        String str2 = this.f3504i;
        if (str2 != null) {
            dVar.setImageAssetsFolder(str2);
            this.f3504i = null;
        }
        Boolean bool2 = this.f3505j;
        if (bool2 != null) {
            dVar.l(bool2.booleanValue());
            this.f3505j = null;
        }
        ReadableArray readableArray = this.f3506k;
        if (readableArray == null || readableArray.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f3506k.size(); i2++) {
            ReadableMap map = this.f3506k.getMap(i2);
            String string = map.getString("color");
            String string2 = map.getString("keypath");
            s sVar = new s(Color.parseColor(string));
            dVar.h(new e((string2 + ".**").split(Pattern.quote("."))), l.C, new c(sVar));
        }
    }

    public void b(String str) {
        this.f3497b = str;
    }

    public void c(String str) {
        this.f3502g = str;
        this.f3501f = true;
    }

    public void d(ReadableArray readableArray) {
        this.f3506k = readableArray;
    }

    public void e(boolean z) {
        this.f3505j = Boolean.valueOf(z);
    }

    public void f(String str) {
        this.f3504i = str;
    }

    public void g(boolean z) {
        this.f3499d = Boolean.valueOf(z);
    }

    public void h(Float f2) {
        this.f3498c = f2;
    }

    public void i(r rVar) {
        this.f3507l = rVar;
    }

    public void j(ImageView.ScaleType scaleType) {
        this.f3503h = scaleType;
    }

    public void k(float f2) {
        this.f3500e = Float.valueOf(f2);
    }
}