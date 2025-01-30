package com.airbnb.android.react.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import c.h.k.v;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.i0;
import e.a.a.r;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class LottieAnimationViewManager extends SimpleViewManager<e.a.a.d> {
    private static final int COMMAND_PAUSE = 3;
    private static final int COMMAND_PLAY = 1;
    private static final int COMMAND_RESET = 2;
    private static final int COMMAND_RESUME = 4;
    private static final String REACT_CLASS = "LottieAnimationView";
    private static final String TAG = "LottieAnimationViewManager";
    private static final int VERSION = 1;
    private Map<e.a.a.d, com.airbnb.android.react.lottie.a> propManagersMap = new WeakHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Animator.AnimatorListener {
        final /* synthetic */ e.a.a.d a;

        a(e.a.a.d dVar) {
            this.a = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            LottieAnimationViewManager.this.sendOnAnimationFinishEvent(this.a, true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LottieAnimationViewManager.this.sendOnAnimationFinishEvent(this.a, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ ReadableArray a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e.a.a.d f3492b;

        /* loaded from: classes.dex */
        class a implements View.OnAttachStateChangeListener {
            a() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                e.a.a.d dVar = (e.a.a.d) view;
                dVar.setProgress(0.0f);
                dVar.s();
                dVar.removeOnAttachStateChangeListener(this);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                b.this.f3492b.removeOnAttachStateChangeListener(this);
            }
        }

        b(ReadableArray readableArray, e.a.a.d dVar) {
            this.a = readableArray;
            this.f3492b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = this.a.getInt(0);
            int i3 = this.a.getInt(1);
            if (i2 != -1 && i3 != -1) {
                if (i2 > i3) {
                    this.f3492b.x(i3, i2);
                    this.f3492b.u();
                } else {
                    this.f3492b.x(i2, i3);
                }
            }
            if (v.Q(this.f3492b)) {
                this.f3492b.setProgress(0.0f);
                this.f3492b.s();
                return;
            }
            this.f3492b.addOnAttachStateChangeListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        final /* synthetic */ e.a.a.d a;

        c(e.a.a.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.Q(this.a)) {
                this.a.i();
                this.a.setProgress(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        final /* synthetic */ e.a.a.d a;

        d(e.a.a.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.Q(this.a)) {
                this.a.r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        final /* synthetic */ e.a.a.d a;

        e(e.a.a.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.Q(this.a)) {
                this.a.t();
            }
        }
    }

    private com.airbnb.android.react.lottie.a getOrCreatePropertyManager(e.a.a.d dVar) {
        com.airbnb.android.react.lottie.a aVar = this.propManagersMap.get(dVar);
        if (aVar == null) {
            com.airbnb.android.react.lottie.a aVar2 = new com.airbnb.android.react.lottie.a(dVar);
            this.propManagersMap.put(dVar, aVar2);
            return aVar2;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnAnimationFinishEvent(e.a.a.d dVar, boolean z) {
        ReactContext reactContext;
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("isCancelled", z);
        Context context = dVar.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                reactContext = null;
                break;
            } else if (context instanceof ReactContext) {
                reactContext = (ReactContext) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (reactContext != null) {
            ((RCTEventEmitter) reactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(dVar.getId(), "animationFinish", createMap);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return com.facebook.react.common.c.g("play", 1, "reset", 2, "pause", 3, "resume", 4);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomBubblingEventTypeConstants() {
        return com.facebook.react.common.c.a().b("animationFinish", com.facebook.react.common.c.d("phasedRegistrationNames", com.facebook.react.common.c.d("bubbled", "onAnimationFinish"))).a();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedViewConstants() {
        return com.facebook.react.common.c.a().b("VERSION", 1).a();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(name = "colorFilters")
    public void setColorFilters(e.a.a.d dVar, ReadableArray readableArray) {
        getOrCreatePropertyManager(dVar).d(readableArray);
    }

    @com.facebook.react.uimanager.c1.a(name = "enableMergePathsAndroidForKitKatAndAbove")
    public void setEnableMergePaths(e.a.a.d dVar, boolean z) {
        getOrCreatePropertyManager(dVar).e(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "imageAssetsFolder")
    public void setImageAssetsFolder(e.a.a.d dVar, String str) {
        getOrCreatePropertyManager(dVar).f(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "loop")
    public void setLoop(e.a.a.d dVar, boolean z) {
        getOrCreatePropertyManager(dVar).g(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "progress")
    public void setProgress(e.a.a.d dVar, float f2) {
        getOrCreatePropertyManager(dVar).h(Float.valueOf(f2));
    }

    @com.facebook.react.uimanager.c1.a(name = "renderMode")
    public void setRenderMode(e.a.a.d dVar, String str) {
        r rVar;
        if ("AUTOMATIC".equals(str)) {
            rVar = r.AUTOMATIC;
        } else if ("HARDWARE".equals(str)) {
            rVar = r.HARDWARE;
        } else {
            rVar = "SOFTWARE".equals(str) ? r.SOFTWARE : null;
        }
        getOrCreatePropertyManager(dVar).i(rVar);
    }

    @com.facebook.react.uimanager.c1.a(name = "resizeMode")
    public void setResizeMode(e.a.a.d dVar, String str) {
        ImageView.ScaleType scaleType;
        if ("cover".equals(str)) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        } else if ("contain".equals(str)) {
            scaleType = ImageView.ScaleType.CENTER_INSIDE;
        } else {
            scaleType = "center".equals(str) ? ImageView.ScaleType.CENTER : null;
        }
        getOrCreatePropertyManager(dVar).j(scaleType);
    }

    @com.facebook.react.uimanager.c1.a(name = "sourceJson")
    public void setSourceJson(e.a.a.d dVar, String str) {
        getOrCreatePropertyManager(dVar).b(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "sourceName")
    public void setSourceName(e.a.a.d dVar, String str) {
        if (!str.contains(".")) {
            str = str + ".json";
        }
        getOrCreatePropertyManager(dVar).c(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "speed")
    public void setSpeed(e.a.a.d dVar, double d2) {
        getOrCreatePropertyManager(dVar).k((float) d2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public e.a.a.d createViewInstance(i0 i0Var) {
        e.a.a.d dVar = new e.a.a.d(i0Var);
        dVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        dVar.g(new a(dVar));
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(e.a.a.d dVar) {
        super.onAfterUpdateTransaction((LottieAnimationViewManager) dVar);
        getOrCreatePropertyManager(dVar).a();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(e.a.a.d dVar, int i2, ReadableArray readableArray) {
        if (i2 == 1) {
            new Handler(Looper.getMainLooper()).post(new b(readableArray, dVar));
        } else if (i2 == 2) {
            new Handler(Looper.getMainLooper()).post(new c(dVar));
        } else if (i2 == 3) {
            new Handler(Looper.getMainLooper()).post(new d(dVar));
        } else if (i2 != 4) {
        } else {
            new Handler(Looper.getMainLooper()).post(new e(dVar));
        }
    }
}