package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import c.h.k.v;
import com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.o;
import java.util.Map;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

@e.f.m.x.a.a(name = StatusBarModule.NAME)
/* loaded from: classes2.dex */
public class StatusBarModule extends NativeStatusBarManagerAndroidSpec {
    private static final String DEFAULT_BACKGROUND_COLOR_KEY = "DEFAULT_BACKGROUND_COLOR";
    private static final String HEIGHT_KEY = "HEIGHT";
    public static final String NAME = "StatusBarManager";

    /* loaded from: classes2.dex */
    class a extends GuardedRunnable {
        final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f4992b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f4993c;

        /* renamed from: com.facebook.react.modules.statusbar.StatusBarModule$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0122a implements ValueAnimator.AnimatorUpdateListener {
            C0122a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.a.getWindow().setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ReactContext reactContext, Activity activity, boolean z, int i2) {
            super(reactContext);
            this.a = activity;
            this.f4992b = z;
            this.f4993c = i2;
        }

        @Override // com.facebook.react.bridge.GuardedRunnable
        @TargetApi(21)
        public void runGuarded() {
            this.a.getWindow().addFlags(Integer.MIN_VALUE);
            if (this.f4992b) {
                ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.a.getWindow().getStatusBarColor()), Integer.valueOf(this.f4993c));
                ofObject.addUpdateListener(new C0122a());
                ofObject.setDuration(300L).setStartDelay(0L);
                ofObject.start();
                return;
            }
            this.a.getWindow().setStatusBarColor(this.f4993c);
        }
    }

    /* loaded from: classes2.dex */
    class b extends GuardedRunnable {
        final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f4995b;

        /* loaded from: classes2.dex */
        class a implements View.OnApplyWindowInsetsListener {
            a() {
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ReactContext reactContext, Activity activity, boolean z) {
            super(reactContext);
            this.a = activity;
            this.f4995b = z;
        }

        @Override // com.facebook.react.bridge.GuardedRunnable
        @TargetApi(21)
        public void runGuarded() {
            View decorView = this.a.getWindow().getDecorView();
            if (this.f4995b) {
                decorView.setOnApplyWindowInsetsListener(new a());
            } else {
                decorView.setOnApplyWindowInsetsListener(null);
            }
            v.h0(decorView);
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {
        final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f4997b;

        c(boolean z, Activity activity) {
            this.a = z;
            this.f4997b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                this.f4997b.getWindow().addFlags(1024);
                this.f4997b.getWindow().clearFlags(PKIFailureInfo.wrongIntegrity);
                return;
            }
            this.f4997b.getWindow().addFlags(PKIFailureInfo.wrongIntegrity);
            this.f4997b.getWindow().clearFlags(1024);
        }
    }

    /* loaded from: classes2.dex */
    class d implements Runnable {
        final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4999b;

        d(Activity activity, String str) {
            this.a = activity;
            this.f4999b = str;
        }

        @Override // java.lang.Runnable
        @TargetApi(23)
        public void run() {
            View decorView = this.a.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility("dark-content".equals(this.f4999b) ? systemUiVisibility | PKIFailureInfo.certRevoked : systemUiVisibility & (-8193));
        }
    }

    public StatusBarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public Map<String, Object> getTypedExportedConstants() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Activity currentActivity = getCurrentActivity();
        int identifier = reactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return com.facebook.react.common.c.e(HEIGHT_KEY, Float.valueOf(identifier > 0 ? o.a(reactApplicationContext.getResources().getDimensionPixelSize(identifier)) : 0.0f), DEFAULT_BACKGROUND_COLOR_KEY, (currentActivity == null || Build.VERSION.SDK_INT < 21) ? "black" : String.format("#%06X", Integer.valueOf(currentActivity.getWindow().getStatusBarColor() & 16777215)));
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setColor(double d2, boolean z) {
        int i2 = (int) d2;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            e.f.d.d.a.A("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else if (Build.VERSION.SDK_INT >= 21) {
            UiThreadUtil.runOnUiThread(new a(getReactApplicationContext(), currentActivity, z, i2));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setHidden(boolean z) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            e.f.d.d.a.A("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new c(z, currentActivity));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setStyle(String str) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            e.f.d.d.a.A("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else if (Build.VERSION.SDK_INT >= 23) {
            UiThreadUtil.runOnUiThread(new d(currentActivity, str));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setTranslucent(boolean z) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            e.f.d.d.a.A("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else if (Build.VERSION.SDK_INT >= 21) {
            UiThreadUtil.runOnUiThread(new b(getReactApplicationContext(), currentActivity, z));
        }
    }
}