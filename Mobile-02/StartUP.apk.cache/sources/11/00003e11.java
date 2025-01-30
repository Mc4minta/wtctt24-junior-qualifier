package com.journeyapps.barcodescanner;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* compiled from: RotationListener.java */
/* loaded from: classes2.dex */
public class m {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager f10384b;

    /* renamed from: c  reason: collision with root package name */
    private OrientationEventListener f10385c;

    /* renamed from: d  reason: collision with root package name */
    private l f10386d;

    /* compiled from: RotationListener.java */
    /* loaded from: classes2.dex */
    class a extends OrientationEventListener {
        a(Context context, int i2) {
            super(context, i2);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            int rotation;
            WindowManager windowManager = m.this.f10384b;
            l lVar = m.this.f10386d;
            if (m.this.f10384b == null || lVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == m.this.a) {
                return;
            }
            m.this.a = rotation;
            lVar.a(rotation);
        }
    }

    public void e(Context context, l lVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.f10386d = lVar;
        this.f10384b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f10385c = aVar;
        aVar.enable();
        this.a = this.f10384b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.f10385c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f10385c = null;
        this.f10384b = null;
        this.f10386d = null;
    }
}