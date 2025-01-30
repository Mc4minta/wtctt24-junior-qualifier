package com.facebook.react.views.modal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.d0;
import com.facebook.react.uimanager.g;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.o;
import e.f.m.i;
import java.util.ArrayList;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: ReactModalHostView.java */
/* loaded from: classes2.dex */
public class d extends ViewGroup implements LifecycleEventListener {
    private b a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f5324b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5325c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5326d;

    /* renamed from: e  reason: collision with root package name */
    private String f5327e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5328f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5329g;

    /* renamed from: h  reason: collision with root package name */
    private DialogInterface.OnShowListener f5330h;

    /* renamed from: j  reason: collision with root package name */
    private c f5331j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactModalHostView.java */
    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnKeyListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 1) {
                if (i2 == 4) {
                    e.f.k.a.a.d(d.this.f5331j, "setOnRequestCloseListener must be called by the manager");
                    d.this.f5331j.a(dialogInterface);
                    return true;
                }
                Activity currentActivity = ((ReactContext) d.this.getContext()).getCurrentActivity();
                if (currentActivity != null) {
                    return currentActivity.onKeyUp(i2, keyEvent);
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactModalHostView.java */
    /* loaded from: classes2.dex */
    public static class b extends com.facebook.react.views.view.f implements d0 {
        private final g A;
        private boolean w;
        private int x;
        private int y;
        private h0 z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReactModalHostView.java */
        /* loaded from: classes2.dex */
        public class a extends GuardedRunnable {
            final /* synthetic */ int a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ReactContext reactContext, int i2) {
                super(reactContext);
                this.a = i2;
            }

            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                ((UIManagerModule) b.this.C().getNativeModule(UIManagerModule.class)).updateNodeSize(this.a, b.this.x, b.this.y);
            }
        }

        public b(Context context) {
            super(context);
            this.w = false;
            this.A = new g(this);
        }

        private com.facebook.react.uimanager.events.d B() {
            return ((UIManagerModule) C().getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ReactContext C() {
            return (ReactContext) getContext();
        }

        private void D() {
            if (getChildCount() > 0) {
                this.w = false;
                int id = getChildAt(0).getId();
                h0 h0Var = this.z;
                if (h0Var != null) {
                    E(h0Var, this.x, this.y);
                    return;
                }
                ReactContext C = C();
                C.runOnNativeModulesQueueThread(new a(C, id));
                return;
            }
            this.w = true;
        }

        public void E(h0 h0Var, int i2, int i3) {
            this.z = h0Var;
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("screenWidth", o.a(i2));
            writableNativeMap.putDouble("screenHeight", o.a(i3));
            h0Var.a(writableNativeMap);
        }

        @Override // com.facebook.react.views.view.f, android.view.ViewGroup
        public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
            super.addView(view, i2, layoutParams);
            if (this.w) {
                D();
            }
        }

        @Override // com.facebook.react.uimanager.d0
        public void handleException(Throwable th) {
            C().handleException(new RuntimeException(th));
        }

        @Override // com.facebook.react.uimanager.d0
        public void onChildStartedNativeGesture(MotionEvent motionEvent) {
            this.A.d(motionEvent, B());
        }

        @Override // com.facebook.react.views.view.f, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.A.c(motionEvent, B());
            return super.onInterceptTouchEvent(motionEvent);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.views.view.f, android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.x = i2;
            this.y = i3;
            D();
        }

        @Override // com.facebook.react.views.view.f, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.A.c(motionEvent, B());
            super.onTouchEvent(motionEvent);
            return true;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean z) {
        }
    }

    /* compiled from: ReactModalHostView.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(DialogInterface dialogInterface);
    }

    public d(Context context) {
        super(context);
        ((ReactContext) context).addLifecycleEventListener(this);
        this.a = new b(context);
    }

    private void b() {
        Activity activity;
        UiThreadUtil.assertOnUiThread();
        Dialog dialog = this.f5324b;
        if (dialog != null) {
            if (dialog.isShowing() && ((activity = (Activity) e.f.m.b0.a.a.a(this.f5324b.getContext(), Activity.class)) == null || !activity.isFinishing())) {
                this.f5324b.dismiss();
            }
            this.f5324b = null;
            ((ViewGroup) this.a.getParent()).removeViewAt(0);
        }
    }

    private void e() {
        e.f.k.a.a.d(this.f5324b, "mDialog must exist when we call updateProperties");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if ((currentActivity.getWindow().getAttributes().flags & 1024) != 0) {
                this.f5324b.getWindow().addFlags(1024);
            } else {
                this.f5324b.getWindow().clearFlags(1024);
            }
        }
        if (this.f5325c) {
            this.f5324b.getWindow().clearFlags(2);
            return;
        }
        this.f5324b.getWindow().setDimAmount(0.5f);
        this.f5324b.getWindow().setFlags(2, 2);
    }

    private View getContentView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.a);
        if (this.f5326d) {
            frameLayout.setSystemUiVisibility(1024);
        } else {
            frameLayout.setFitsSystemWindows(true);
        }
        return frameLayout;
    }

    private Activity getCurrentActivity() {
        return ((ReactContext) getContext()).getCurrentActivity();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        UiThreadUtil.assertOnUiThread();
        this.a.addView(view, i2);
    }

    public void c() {
        ((ReactContext) getContext()).removeLifecycleEventListener(this);
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        UiThreadUtil.assertOnUiThread();
        if (this.f5324b != null) {
            if (this.f5329g) {
                b();
            } else {
                e();
                return;
            }
        }
        this.f5329g = false;
        int i2 = i.f12841b;
        if (this.f5327e.equals("fade")) {
            i2 = i.f12842c;
        } else if (this.f5327e.equals("slide")) {
            i2 = i.f12843d;
        }
        Activity currentActivity = getCurrentActivity();
        Context context = currentActivity == null ? getContext() : currentActivity;
        Dialog dialog = new Dialog(context, i2);
        this.f5324b = dialog;
        dialog.getWindow().setFlags(8, 8);
        this.f5324b.setContentView(getContentView());
        e();
        this.f5324b.setOnShowListener(this.f5330h);
        this.f5324b.setOnKeyListener(new a());
        this.f5324b.getWindow().setSoftInputMode(16);
        if (this.f5328f) {
            this.f5324b.getWindow().addFlags(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
        }
        if (currentActivity == null || currentActivity.isFinishing()) {
            return;
        }
        this.f5324b.show();
        if (context instanceof Activity) {
            this.f5324b.getWindow().getDecorView().setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
        }
        this.f5324b.getWindow().clearFlags(8);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        this.a.dispatchProvideStructure(viewStructure);
    }

    public void f(h0 h0Var, int i2, int i3) {
        this.a.E(h0Var, i2, i3);
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int i2) {
        return this.a.getChildAt(i2);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        return this.a.getChildCount();
    }

    public Dialog getDialog() {
        return this.f5324b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        c();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        this.a.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        UiThreadUtil.assertOnUiThread();
        this.a.removeView(getChildAt(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAnimationType(String str) {
        this.f5327e = str;
        this.f5329g = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setHardwareAccelerated(boolean z) {
        this.f5328f = z;
        this.f5329g = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnRequestCloseListener(c cVar) {
        this.f5331j = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f5330h = onShowListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStatusBarTranslucent(boolean z) {
        this.f5326d = z;
        this.f5329g = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTransparent(boolean z) {
        this.f5325c = z;
    }
}