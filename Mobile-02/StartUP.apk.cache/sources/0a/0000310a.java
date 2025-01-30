package com.google.android.flexbox;

import android.view.View;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FlexLine.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    int f5919e;

    /* renamed from: f  reason: collision with root package name */
    int f5920f;

    /* renamed from: g  reason: collision with root package name */
    int f5921g;

    /* renamed from: h  reason: collision with root package name */
    int f5922h;

    /* renamed from: i  reason: collision with root package name */
    int f5923i;

    /* renamed from: j  reason: collision with root package name */
    float f5924j;

    /* renamed from: k  reason: collision with root package name */
    float f5925k;

    /* renamed from: l  reason: collision with root package name */
    int f5926l;
    int m;
    int o;
    int p;
    boolean q;
    boolean r;
    int a = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;

    /* renamed from: b  reason: collision with root package name */
    int f5916b = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;

    /* renamed from: c  reason: collision with root package name */
    int f5917c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    int f5918d = Integer.MIN_VALUE;
    List<Integer> n = new ArrayList();

    public int a() {
        return this.f5921g;
    }

    public int b() {
        return this.f5922h;
    }

    public int c() {
        return this.f5922h - this.f5923i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view, int i2, int i3, int i4, int i5) {
        b bVar = (b) view.getLayoutParams();
        this.a = Math.min(this.a, (view.getLeft() - bVar.g0()) - i2);
        this.f5916b = Math.min(this.f5916b, (view.getTop() - bVar.o0()) - i3);
        this.f5917c = Math.max(this.f5917c, view.getRight() + bVar.I0() + i4);
        this.f5918d = Math.max(this.f5918d, view.getBottom() + bVar.d0() + i5);
    }
}