package com.thebylito.navigationbarcolor;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class NavigationBarColorModule extends ReactContextBaseJavaModule {
    private static final String ERROR_API_LEVEL = "API_LEVEl";
    private static final String ERROR_API_LEVEL_MESSAGE = "Only Android Oreo and above is supported";
    private static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";
    private static final String ERROR_NO_ACTIVITY_MESSAGE = "Tried to change the navigation bar while not attached to an Activity";
    public static final String REACT_CLASS = "NavigationBarColor";
    private static final int UI_FLAG_HIDE_NAV_BAR = 4866;
    private static ReactApplicationContext reactContext;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Window f11068b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Boolean f11069c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ WritableMap f11070d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Promise f11071e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Boolean f11072f;

        /* renamed from: com.thebylito.navigationbarcolor.NavigationBarColorModule$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0239a implements ValueAnimator.AnimatorUpdateListener {
            C0239a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.f11068b.setNavigationBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        a(String str, Window window, Boolean bool, WritableMap writableMap, Promise promise, Boolean bool2) {
            this.a = str;
            this.f11068b = window;
            this.f11069c = bool;
            this.f11070d = writableMap;
            this.f11071e = promise;
            this.f11072f = bool2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.equals("transparent") && !this.a.equals("translucent")) {
                this.f11068b.clearFlags(512);
                this.f11068b.clearFlags(134217728);
                if (this.f11072f.booleanValue()) {
                    ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f11068b.getNavigationBarColor()), Integer.valueOf(Color.parseColor(String.valueOf(this.a))));
                    ofObject.addUpdateListener(new C0239a());
                    ofObject.start();
                } else {
                    this.f11068b.setNavigationBarColor(Color.parseColor(String.valueOf(this.a)));
                }
                NavigationBarColorModule navigationBarColorModule = NavigationBarColorModule.this;
                navigationBarColorModule.setNavigationBarTheme(navigationBarColorModule.getCurrentActivity(), this.f11069c);
                WritableMap createMap = Arguments.createMap();
                createMap.putBoolean("success", true);
                this.f11071e.resolve(createMap);
                return;
            }
            this.f11068b.clearFlags(512);
            this.f11068b.clearFlags(134217728);
            if (this.a.equals("transparent")) {
                this.f11068b.setFlags(512, 512);
            } else {
                this.f11068b.setFlags(134217728, 134217728);
            }
            NavigationBarColorModule navigationBarColorModule2 = NavigationBarColorModule.this;
            navigationBarColorModule2.setNavigationBarTheme(navigationBarColorModule2.getCurrentActivity(), this.f11069c);
            this.f11070d.putBoolean("success", true);
            this.f11071e.resolve(this.f11070d);
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NavigationBarColorModule.this.getCurrentActivity() != null) {
                NavigationBarColorModule.this.getCurrentActivity().getWindow().getDecorView().setSystemUiVisibility(NavigationBarColorModule.UI_FLAG_HIDE_NAV_BAR);
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NavigationBarColorModule.this.getCurrentActivity() != null) {
                NavigationBarColorModule.this.getCurrentActivity().getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
    }

    public NavigationBarColorModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void changeNavigationBarColor(String str, Boolean bool, Boolean bool2, Promise promise) {
        WritableMap createMap = Arguments.createMap();
        if (Build.VERSION.SDK_INT >= 21) {
            if (getCurrentActivity() != null) {
                try {
                    UiThreadUtil.runOnUiThread(new a(str, getCurrentActivity().getWindow(), bool, createMap, promise, bool2));
                    return;
                } catch (IllegalViewOperationException e2) {
                    createMap.putBoolean("success", false);
                    promise.reject("error", e2);
                    return;
                }
            }
            promise.reject(ERROR_NO_ACTIVITY, new Throwable(ERROR_NO_ACTIVITY_MESSAGE));
            return;
        }
        promise.reject(ERROR_API_LEVEL, new Throwable(ERROR_API_LEVEL_MESSAGE));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("EXAMPLE_CONSTANT", "example");
        return hashMap;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void hideNavigationBar(Promise promise) {
        try {
            UiThreadUtil.runOnUiThread(new b());
        } catch (IllegalViewOperationException e2) {
            Arguments.createMap().putBoolean("success", false);
            promise.reject("error", e2);
        }
    }

    public void setNavigationBarTheme(Activity activity, Boolean bool) {
        if (activity == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        Window window = activity.getWindow();
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(bool.booleanValue() ? systemUiVisibility | 16 : systemUiVisibility & (-17));
    }

    @ReactMethod
    public void showNavigationBar(Promise promise) {
        try {
            UiThreadUtil.runOnUiThread(new c());
        } catch (IllegalViewOperationException e2) {
            Arguments.createMap().putBoolean("success", false);
            promise.reject("error", e2);
        }
    }
}