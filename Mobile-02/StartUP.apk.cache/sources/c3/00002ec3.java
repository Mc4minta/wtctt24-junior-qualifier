package com.facebook.react.modules.toast;

import android.widget.Toast;
import com.facebook.fbreact.specs.NativeToastAndroidSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.HashMap;
import java.util.Map;

@e.f.m.x.a.a(name = ToastModule.NAME)
/* loaded from: classes2.dex */
public class ToastModule extends NativeToastAndroidSpec {
    private static final String DURATION_LONG_KEY = "LONG";
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String GRAVITY_BOTTOM_KEY = "BOTTOM";
    private static final String GRAVITY_CENTER = "CENTER";
    private static final String GRAVITY_TOP_KEY = "TOP";
    public static final String NAME = "ToastAndroid";

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5025b;

        a(String str, int i2) {
            this.a = str;
            this.f5025b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(ToastModule.this.getReactApplicationContext(), this.a, this.f5025b).show();
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5027b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5028c;

        b(String str, int i2, int i3) {
            this.a = str;
            this.f5027b = i2;
            this.f5028c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast makeText = Toast.makeText(ToastModule.this.getReactApplicationContext(), this.a, this.f5027b);
            makeText.setGravity(this.f5028c, 0, 0);
            makeText.show();
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5030b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5031c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f5032d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f5033e;

        c(String str, int i2, int i3, int i4, int i5) {
            this.a = str;
            this.f5030b = i2;
            this.f5031c = i3;
            this.f5032d = i4;
            this.f5033e = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast makeText = Toast.makeText(ToastModule.this.getReactApplicationContext(), this.a, this.f5030b);
            makeText.setGravity(this.f5031c, this.f5032d, this.f5033e);
            makeText.show();
        }
    }

    public ToastModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeToastAndroidSpec
    public Map<String, Object> getTypedExportedConstants() {
        HashMap b2 = com.facebook.react.common.c.b();
        b2.put(DURATION_SHORT_KEY, 0);
        b2.put(DURATION_LONG_KEY, 1);
        b2.put(GRAVITY_TOP_KEY, 49);
        b2.put(GRAVITY_BOTTOM_KEY, 81);
        b2.put(GRAVITY_CENTER, 17);
        return b2;
    }

    @Override // com.facebook.fbreact.specs.NativeToastAndroidSpec
    public void show(String str, double d2) {
        UiThreadUtil.runOnUiThread(new a(str, (int) d2));
    }

    @Override // com.facebook.fbreact.specs.NativeToastAndroidSpec
    public void showWithGravity(String str, double d2, double d3) {
        UiThreadUtil.runOnUiThread(new b(str, (int) d2, (int) d3));
    }

    @Override // com.facebook.fbreact.specs.NativeToastAndroidSpec
    public void showWithGravityAndOffset(String str, double d2, double d3, double d4, double d5) {
        UiThreadUtil.runOnUiThread(new c(str, (int) d2, (int) d3, (int) d4, (int) d5));
    }
}