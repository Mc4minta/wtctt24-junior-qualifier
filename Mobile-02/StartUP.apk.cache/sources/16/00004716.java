package e.f.m;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.d0;
import com.facebook.react.uimanager.o0;
import com.facebook.react.uimanager.w;

/* compiled from: ReactRootView.java */
/* loaded from: classes2.dex */
public class s extends FrameLayout implements d0, w {
    private static final String TAG = "ReactRootView";
    private final j mAndroidHWInputDeviceHelper;
    private Bundle mAppProperties;
    private a mCustomGlobalLayoutListener;
    private int mHeightMeasureSpec;
    private String mInitialUITemplate;
    private boolean mIsAttachedToInstance;
    private String mJSModuleName;
    private com.facebook.react.uimanager.g mJSTouchDispatcher;
    private int mLastHeight;
    private int mLastWidth;
    private l mReactInstanceManager;
    private b mRootViewEventListener;
    private int mRootViewTag;
    private boolean mShouldLogContentAppeared;
    private int mUIManagerType;
    private final boolean mUseSurface;
    private boolean mWasMeasured;
    private int mWidthMeasureSpec;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactRootView.java */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private final Rect a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12879b;

        /* renamed from: c  reason: collision with root package name */
        private int f12880c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f12881d = 0;

        a() {
            com.facebook.react.uimanager.c.h(s.this.getContext().getApplicationContext());
            this.a = new Rect();
            this.f12879b = (int) com.facebook.react.uimanager.o.c(60.0f);
        }

        private void a() {
            f();
        }

        private void b() {
            int rotation = ((WindowManager) s.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (this.f12881d == rotation) {
                return;
            }
            this.f12881d = rotation;
            e(rotation);
        }

        private void c() {
            int i2;
            s sVar;
            s.this.getRootView().getWindowVisibleDisplayFrame(this.a);
            int i3 = com.facebook.react.uimanager.c.f().heightPixels - this.a.bottom;
            int i4 = this.f12880c;
            boolean z = true;
            if (i4 != i3 && i3 > this.f12879b) {
                this.f12880c = i3;
                s.this.sendEvent("keyboardDidShow", d(com.facebook.react.uimanager.o.a(i2), com.facebook.react.uimanager.o.a(this.a.left), com.facebook.react.uimanager.o.a(this.a.width()), com.facebook.react.uimanager.o.a(this.f12880c)));
                return;
            }
            if (i4 == 0 || i3 > this.f12879b) {
                z = false;
            }
            if (z) {
                this.f12880c = 0;
                s.this.sendEvent("keyboardDidHide", d(com.facebook.react.uimanager.o.a(sVar.mLastHeight), 0.0d, com.facebook.react.uimanager.o.a(this.a.width()), 0.0d));
            }
        }

        private WritableMap d(double d2, double d3, double d4, double d5) {
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putDouble("height", d5);
            createMap2.putDouble("screenX", d3);
            createMap2.putDouble("width", d4);
            createMap2.putDouble("screenY", d2);
            createMap.putMap("endCoordinates", createMap2);
            createMap.putString("easing", "keyboard");
            createMap.putDouble("duration", 0.0d);
            return createMap;
        }

        private void e(int i2) {
            double d2;
            String str;
            double d3;
            boolean z = true;
            if (i2 != 0) {
                if (i2 == 1) {
                    d3 = -90.0d;
                    str = "landscape-primary";
                } else if (i2 == 2) {
                    d2 = 180.0d;
                    str = "portrait-secondary";
                } else if (i2 != 3) {
                    return;
                } else {
                    d3 = 90.0d;
                    str = "landscape-secondary";
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putString(ApiConstants.NAME, str);
                createMap.putDouble("rotationDegrees", d3);
                createMap.putBoolean("isLandscape", z);
                s.this.sendEvent("namedOrientationDidChange", createMap);
            }
            d2 = 0.0d;
            str = "portrait-primary";
            z = false;
            d3 = d2;
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString(ApiConstants.NAME, str);
            createMap2.putDouble("rotationDegrees", d3);
            createMap2.putBoolean("isLandscape", z);
            s.this.sendEvent("namedOrientationDidChange", createMap2);
        }

        private void f() {
            ((DeviceInfoModule) s.this.mReactInstanceManager.u().getNativeModule(DeviceInfoModule.class)).emitUpdateDimensionsEvent();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (s.this.mReactInstanceManager == null || !s.this.mIsAttachedToInstance || s.this.mReactInstanceManager.u() == null) {
                return;
            }
            c();
            b();
            a();
        }
    }

    /* compiled from: ReactRootView.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(s sVar);
    }

    public s(Context context) {
        super(context);
        this.mAndroidHWInputDeviceHelper = new j(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = false;
        init();
    }

    private void attachToReactInstanceManager() {
        com.facebook.systrace.a.c(0L, "attachToReactInstanceManager");
        if (this.mIsAttachedToInstance) {
            return;
        }
        try {
            this.mIsAttachedToInstance = true;
            ((l) e.f.k.a.a.c(this.mReactInstanceManager)).k(this);
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        } finally {
            com.facebook.systrace.a.g(0L);
        }
    }

    private void dispatchJSTouchEvent(MotionEvent motionEvent) {
        l lVar = this.mReactInstanceManager;
        if (lVar != null && this.mIsAttachedToInstance && lVar.u() != null) {
            if (this.mJSTouchDispatcher == null) {
                e.f.d.d.a.A(TAG, "Unable to dispatch touch to JS before the dispatcher is available");
                return;
            }
            this.mJSTouchDispatcher.c(motionEvent, ((UIManagerModule) this.mReactInstanceManager.u().getNativeModule(UIManagerModule.class)).getEventDispatcher());
            return;
        }
        e.f.d.d.a.A(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
    }

    private a getCustomGlobalLayoutListener() {
        if (this.mCustomGlobalLayoutListener == null) {
            this.mCustomGlobalLayoutListener = new a();
        }
        return this.mCustomGlobalLayoutListener;
    }

    private void init() {
        setClipChildren(false);
    }

    private void removeOnGlobalLayoutListener() {
        getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
    }

    private void updateRootLayoutSpecs(int i2, int i3) {
        UIManager d2;
        l lVar = this.mReactInstanceManager;
        if (lVar == null) {
            e.f.d.d.a.A(TAG, "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        ReactContext u = lVar.u();
        if (u == null || (d2 = o0.d(u, getUIManagerType())) == null) {
            return;
        }
        d2.updateRootLayoutSpecs(getRootViewTag(), i2, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError e2) {
            handleException(e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        l lVar = this.mReactInstanceManager;
        if (lVar != null && this.mIsAttachedToInstance && lVar.u() != null) {
            this.mAndroidHWInputDeviceHelper.d(keyEvent);
            return super.dispatchKeyEvent(keyEvent);
        }
        e.f.d.d.a.A(TAG, "Unable to handle key event as the catalyst instance has not been attached");
        return super.dispatchKeyEvent(keyEvent);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        e.f.k.a.a.b(!this.mIsAttachedToInstance, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    @Override // com.facebook.react.uimanager.w
    public Bundle getAppProperties() {
        return this.mAppProperties;
    }

    @Override // com.facebook.react.uimanager.w
    public int getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    @Override // com.facebook.react.uimanager.w
    public String getInitialUITemplate() {
        return this.mInitialUITemplate;
    }

    public String getJSModuleName() {
        return (String) e.f.k.a.a.c(this.mJSModuleName);
    }

    public l getReactInstanceManager() {
        return this.mReactInstanceManager;
    }

    @Override // com.facebook.react.uimanager.w
    public ViewGroup getRootViewGroup() {
        return this;
    }

    @Override // com.facebook.react.uimanager.w
    public int getRootViewTag() {
        return this.mRootViewTag;
    }

    @Override // com.facebook.react.uimanager.w
    public String getSurfaceID() {
        Bundle appProperties = getAppProperties();
        if (appProperties != null) {
            return appProperties.getString("surfaceID");
        }
        return null;
    }

    @Override // com.facebook.react.uimanager.w
    public int getUIManagerType() {
        return this.mUIManagerType;
    }

    @Override // com.facebook.react.uimanager.w
    public int getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    @Override // com.facebook.react.uimanager.d0
    public void handleException(Throwable th) {
        l lVar = this.mReactInstanceManager;
        if (lVar != null && lVar.u() != null) {
            this.mReactInstanceManager.u().handleException(new IllegalViewOperationException(th.getMessage(), this, th));
            return;
        }
        throw new RuntimeException(th);
    }

    public void onAttachedToReactInstance() {
        this.mJSTouchDispatcher = new com.facebook.react.uimanager.g(this);
        b bVar = this.mRootViewEventListener;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    @Override // com.facebook.react.uimanager.d0
    public void onChildStartedNativeGesture(MotionEvent motionEvent) {
        l lVar = this.mReactInstanceManager;
        if (lVar != null && this.mIsAttachedToInstance && lVar.u() != null) {
            if (this.mJSTouchDispatcher == null) {
                e.f.d.d.a.A(TAG, "Unable to dispatch touch to JS before the dispatcher is available");
                return;
            }
            this.mJSTouchDispatcher.d(motionEvent, ((UIManagerModule) this.mReactInstanceManager.u().getNativeModule(UIManagerModule.class)).getEventDispatcher());
            return;
        }
        e.f.d.d.a.A(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i2, Rect rect) {
        l lVar = this.mReactInstanceManager;
        if (lVar != null && this.mIsAttachedToInstance && lVar.u() != null) {
            this.mAndroidHWInputDeviceHelper.a();
            super.onFocusChanged(z, i2, rect);
            return;
        }
        e.f.d.d.a.A(TAG, "Unable to handle focus changed event as the catalyst instance has not been attached");
        super.onFocusChanged(z, i2, rect);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.mUseSurface) {
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0039 A[Catch: all -> 0x00b4, LOOP:1: B:20:0x0033->B:22:0x0039, LOOP_END, TryCatch #0 {all -> 0x00b4, blocks: (B:7:0x000f, B:9:0x0015, B:14:0x001d, B:18:0x002c, B:23:0x0057, B:27:0x0060, B:32:0x008a, B:34:0x0093, B:36:0x0097, B:43:0x00ac, B:38:0x009d, B:40:0x00a1, B:42:0x00a5, B:29:0x0066, B:31:0x006c, B:20:0x0033, B:22:0x0039), top: B:49:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c A[Catch: all -> 0x00b4, LOOP:0: B:29:0x0066->B:31:0x006c, LOOP_END, TryCatch #0 {all -> 0x00b4, blocks: (B:7:0x000f, B:9:0x0015, B:14:0x001d, B:18:0x002c, B:23:0x0057, B:27:0x0060, B:32:0x008a, B:34:0x0093, B:36:0x0097, B:43:0x00ac, B:38:0x009d, B:40:0x00a1, B:42:0x00a5, B:29:0x0066, B:31:0x006c, B:20:0x0033, B:22:0x0039), top: B:49:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093 A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:7:0x000f, B:9:0x0015, B:14:0x001d, B:18:0x002c, B:23:0x0057, B:27:0x0060, B:32:0x008a, B:34:0x0093, B:36:0x0097, B:43:0x00ac, B:38:0x009d, B:40:0x00a1, B:42:0x00a5, B:29:0x0066, B:31:0x006c, B:20:0x0033, B:22:0x0039), top: B:49:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d A[Catch: all -> 0x00b4, TryCatch #0 {all -> 0x00b4, blocks: (B:7:0x000f, B:9:0x0015, B:14:0x001d, B:18:0x002c, B:23:0x0057, B:27:0x0060, B:32:0x008a, B:34:0x0093, B:36:0x0097, B:43:0x00ac, B:38:0x009d, B:40:0x00a1, B:42:0x00a5, B:29:0x0066, B:31:0x006c, B:20:0x0033, B:22:0x0039), top: B:49:0x000f }] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            boolean r0 = r10.mUseSurface
            if (r0 == 0) goto L8
            super.onMeasure(r11, r12)
            return
        L8:
            r0 = 0
            java.lang.String r2 = "ReactRootView.onMeasure"
            com.facebook.systrace.a.c(r0, r2)
            int r2 = r10.mWidthMeasureSpec     // Catch: java.lang.Throwable -> Lb4
            r3 = 1
            r4 = 0
            if (r11 != r2) goto L1c
            int r2 = r10.mHeightMeasureSpec     // Catch: java.lang.Throwable -> Lb4
            if (r12 == r2) goto L1a
            goto L1c
        L1a:
            r2 = r4
            goto L1d
        L1c:
            r2 = r3
        L1d:
            r10.mWidthMeasureSpec = r11     // Catch: java.lang.Throwable -> Lb4
            r10.mHeightMeasureSpec = r12     // Catch: java.lang.Throwable -> Lb4
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch: java.lang.Throwable -> Lb4
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L31
            if (r5 != 0) goto L2c
            goto L31
        L2c:
            int r11 = android.view.View.MeasureSpec.getSize(r11)     // Catch: java.lang.Throwable -> Lb4
            goto L57
        L31:
            r11 = r4
            r5 = r11
        L33:
            int r7 = r10.getChildCount()     // Catch: java.lang.Throwable -> Lb4
            if (r5 >= r7) goto L57
            android.view.View r7 = r10.getChildAt(r5)     // Catch: java.lang.Throwable -> Lb4
            int r8 = r7.getLeft()     // Catch: java.lang.Throwable -> Lb4
            int r9 = r7.getMeasuredWidth()     // Catch: java.lang.Throwable -> Lb4
            int r8 = r8 + r9
            int r9 = r7.getPaddingLeft()     // Catch: java.lang.Throwable -> Lb4
            int r8 = r8 + r9
            int r7 = r7.getPaddingRight()     // Catch: java.lang.Throwable -> Lb4
            int r8 = r8 + r7
            int r11 = java.lang.Math.max(r11, r8)     // Catch: java.lang.Throwable -> Lb4
            int r5 = r5 + 1
            goto L33
        L57:
            int r5 = android.view.View.MeasureSpec.getMode(r12)     // Catch: java.lang.Throwable -> Lb4
            if (r5 == r6) goto L65
            if (r5 != 0) goto L60
            goto L65
        L60:
            int r12 = android.view.View.MeasureSpec.getSize(r12)     // Catch: java.lang.Throwable -> Lb4
            goto L8a
        L65:
            r12 = r4
        L66:
            int r5 = r10.getChildCount()     // Catch: java.lang.Throwable -> Lb4
            if (r4 >= r5) goto L8a
            android.view.View r5 = r10.getChildAt(r4)     // Catch: java.lang.Throwable -> Lb4
            int r6 = r5.getTop()     // Catch: java.lang.Throwable -> Lb4
            int r7 = r5.getMeasuredHeight()     // Catch: java.lang.Throwable -> Lb4
            int r6 = r6 + r7
            int r7 = r5.getPaddingTop()     // Catch: java.lang.Throwable -> Lb4
            int r6 = r6 + r7
            int r5 = r5.getPaddingBottom()     // Catch: java.lang.Throwable -> Lb4
            int r6 = r6 + r5
            int r12 = java.lang.Math.max(r12, r6)     // Catch: java.lang.Throwable -> Lb4
            int r4 = r4 + 1
            goto L66
        L8a:
            r10.setMeasuredDimension(r11, r12)     // Catch: java.lang.Throwable -> Lb4
            r10.mWasMeasured = r3     // Catch: java.lang.Throwable -> Lb4
            e.f.m.l r3 = r10.mReactInstanceManager     // Catch: java.lang.Throwable -> Lb4
            if (r3 == 0) goto L9b
            boolean r3 = r10.mIsAttachedToInstance     // Catch: java.lang.Throwable -> Lb4
            if (r3 != 0) goto L9b
            r10.attachToReactInstanceManager()     // Catch: java.lang.Throwable -> Lb4
            goto Lac
        L9b:
            if (r2 != 0) goto La5
            int r2 = r10.mLastWidth     // Catch: java.lang.Throwable -> Lb4
            if (r2 != r11) goto La5
            int r2 = r10.mLastHeight     // Catch: java.lang.Throwable -> Lb4
            if (r2 == r12) goto Lac
        La5:
            int r2 = r10.mWidthMeasureSpec     // Catch: java.lang.Throwable -> Lb4
            int r3 = r10.mHeightMeasureSpec     // Catch: java.lang.Throwable -> Lb4
            r10.updateRootLayoutSpecs(r2, r3)     // Catch: java.lang.Throwable -> Lb4
        Lac:
            r10.mLastWidth = r11     // Catch: java.lang.Throwable -> Lb4
            r10.mLastHeight = r12     // Catch: java.lang.Throwable -> Lb4
            com.facebook.systrace.a.g(r0)
            return
        Lb4:
            r11 = move-exception
            com.facebook.systrace.a.g(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.m.s.onMeasure(int, int):void");
    }

    @Override // com.facebook.react.uimanager.w
    public void onStage(int i2) {
        if (i2 != 101) {
            return;
        }
        onAttachedToReactInstance();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (this.mShouldLogContentAppeared) {
            this.mShouldLogContentAppeared = false;
            String str = this.mJSModuleName;
            if (str != null) {
                ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, str, this.mRootViewTag);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        l lVar = this.mReactInstanceManager;
        if (lVar != null && this.mIsAttachedToInstance && lVar.u() != null) {
            this.mAndroidHWInputDeviceHelper.e(view2);
            super.requestChildFocus(view, view2);
            return;
        }
        e.f.d.d.a.A(TAG, "Unable to handle child focus changed event as the catalyst instance has not been attached");
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.facebook.react.uimanager.w
    public void runApplication() {
        com.facebook.systrace.a.c(0L, "ReactRootView.runApplication");
        try {
            l lVar = this.mReactInstanceManager;
            if (lVar != null && this.mIsAttachedToInstance) {
                ReactContext u = lVar.u();
                if (u == null) {
                    return;
                }
                CatalystInstance catalystInstance = u.getCatalystInstance();
                String jSModuleName = getJSModuleName();
                if (!this.mUseSurface) {
                    if (this.mWasMeasured) {
                        updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                    }
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("rootTag", getRootViewTag());
                    Bundle appProperties = getAppProperties();
                    if (appProperties != null) {
                        writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                    }
                    this.mShouldLogContentAppeared = true;
                    e.f.d.d.a.i(TAG, "runApplication: call AppRegistry.runApplication");
                    ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
                }
            }
        } finally {
            com.facebook.systrace.a.g(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendEvent(String str, WritableMap writableMap) {
        l lVar = this.mReactInstanceManager;
        if (lVar != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) lVar.u().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    public void setAppProperties(Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.mAppProperties = bundle;
        if (getRootViewTag() != 0) {
            runApplication();
        }
    }

    public void setEventListener(b bVar) {
        this.mRootViewEventListener = bVar;
    }

    public void setIsFabric(boolean z) {
        this.mUIManagerType = z ? 2 : 1;
    }

    @Override // com.facebook.react.uimanager.w
    public void setRootViewTag(int i2) {
        this.mRootViewTag = i2;
    }

    @Override // com.facebook.react.uimanager.w
    public void setShouldLogContentAppeared(boolean z) {
        this.mShouldLogContentAppeared = z;
    }

    void simulateAttachForTesting() {
        this.mIsAttachedToInstance = true;
        this.mJSTouchDispatcher = new com.facebook.react.uimanager.g(this);
    }

    public void startReactApplication(l lVar, String str) {
        startReactApplication(lVar, str, null);
    }

    public void unmountReactApplication() {
        UiThreadUtil.assertOnUiThread();
        l lVar = this.mReactInstanceManager;
        if (lVar != null && this.mIsAttachedToInstance) {
            lVar.s(this);
            this.mIsAttachedToInstance = false;
        }
        this.mReactInstanceManager = null;
        this.mShouldLogContentAppeared = false;
    }

    public void startReactApplication(l lVar, String str, Bundle bundle) {
        startReactApplication(lVar, str, bundle, null);
    }

    public void startReactApplication(l lVar, String str, Bundle bundle, String str2) {
        com.facebook.systrace.a.c(0L, "startReactApplication");
        try {
            UiThreadUtil.assertOnUiThread();
            e.f.k.a.a.b(this.mReactInstanceManager == null, "This root view has already been attached to a catalyst instance manager");
            this.mReactInstanceManager = lVar;
            this.mJSModuleName = str;
            this.mAppProperties = bundle;
            this.mInitialUITemplate = str2;
            lVar.q();
            attachToReactInstanceManager();
        } finally {
            com.facebook.systrace.a.g(0L);
        }
    }

    public s(Context context, boolean z) {
        super(context);
        this.mAndroidHWInputDeviceHelper = new j(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = z;
        init();
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAndroidHWInputDeviceHelper = new j(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = false;
        init();
    }

    public s(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mAndroidHWInputDeviceHelper = new j(this);
        this.mWasMeasured = false;
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mLastWidth = 0;
        this.mLastHeight = 0;
        this.mUIManagerType = 1;
        this.mUseSurface = false;
        init();
    }
}