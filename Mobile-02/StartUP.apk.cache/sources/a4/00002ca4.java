package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: PoolParams.java */
/* loaded from: classes2.dex */
public class e0 {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4601b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseIntArray f4602c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4603d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4604e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4605f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4606g;

    public e0(int i2, int i3, SparseIntArray sparseIntArray) {
        this(i2, i3, sparseIntArray, 0, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, -1);
    }

    public e0(int i2, int i3, SparseIntArray sparseIntArray, int i4, int i5, int i6) {
        e.f.d.c.i.i(i2 >= 0 && i3 >= i2);
        this.f4601b = i2;
        this.a = i3;
        this.f4602c = sparseIntArray;
        this.f4603d = i4;
        this.f4604e = i5;
        this.f4606g = i6;
    }
}