package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.l;
import com.facebook.react.uimanager.l0;
import com.facebook.react.uimanager.o;
import e.f.m.s;
import e.i.a.k;
import e.i.a.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@e.f.m.x.a.a(name = RNGestureHandlerModule.MODULE_NAME)
/* loaded from: classes2.dex */
public class RNGestureHandlerModule extends ReactContextBaseJavaModule {
    private static final String KEY_DIRECTION = "direction";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_HIT_SLOP = "hitSlop";
    private static final String KEY_HIT_SLOP_BOTTOM = "bottom";
    private static final String KEY_HIT_SLOP_HEIGHT = "height";
    private static final String KEY_HIT_SLOP_HORIZONTAL = "horizontal";
    private static final String KEY_HIT_SLOP_LEFT = "left";
    private static final String KEY_HIT_SLOP_RIGHT = "right";
    private static final String KEY_HIT_SLOP_TOP = "top";
    private static final String KEY_HIT_SLOP_VERTICAL = "vertical";
    private static final String KEY_HIT_SLOP_WIDTH = "width";
    private static final String KEY_LONG_PRESS_MAX_DIST = "maxDist";
    private static final String KEY_LONG_PRESS_MIN_DURATION_MS = "minDurationMs";
    private static final String KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION = "disallowInterruption";
    private static final String KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";
    private static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_END = "activeOffsetXEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_START = "activeOffsetXStart";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_END = "activeOffsetYEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_START = "activeOffsetYStart";
    private static final String KEY_PAN_AVG_TOUCHES = "avgTouches";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_END = "failOffsetXEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_START = "failOffsetXStart";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_END = "failOffsetYEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_START = "failOffsetYStart";
    private static final String KEY_PAN_MAX_POINTERS = "maxPointers";
    private static final String KEY_PAN_MIN_DIST = "minDist";
    private static final String KEY_PAN_MIN_POINTERS = "minPointers";
    private static final String KEY_PAN_MIN_VELOCITY = "minVelocity";
    private static final String KEY_PAN_MIN_VELOCITY_X = "minVelocityX";
    private static final String KEY_PAN_MIN_VELOCITY_Y = "minVelocityY";
    private static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";
    private static final String KEY_TAP_MAX_DELAY_MS = "maxDelayMs";
    private static final String KEY_TAP_MAX_DELTA_X = "maxDeltaX";
    private static final String KEY_TAP_MAX_DELTA_Y = "maxDeltaY";
    private static final String KEY_TAP_MAX_DIST = "maxDist";
    private static final String KEY_TAP_MAX_DURATION_MS = "maxDurationMs";
    private static final String KEY_TAP_MIN_POINTERS = "minPointers";
    private static final String KEY_TAP_NUMBER_OF_TAPS = "numberOfTaps";
    public static final String MODULE_NAME = "RNGestureHandlerModule";
    private List<Integer> mEnqueuedRootViewInit;
    private e.i.a.i mEventListener;
    private d[] mHandlerFactories;
    private com.swmansion.gesturehandler.react.d mInteractionManager;
    private final com.swmansion.gesturehandler.react.f mRegistry;
    private List<com.swmansion.gesturehandler.react.g> mRoots;

    /* loaded from: classes2.dex */
    class a implements e.i.a.i {
        a() {
        }

        @Override // e.i.a.i
        public void a(e.i.a.b bVar, int i2, int i3) {
            RNGestureHandlerModule.this.onStateChange(bVar, i2, i3);
        }

        @Override // e.i.a.i
        public void b(e.i.a.b bVar, MotionEvent motionEvent) {
            RNGestureHandlerModule.this.onTouchEvent(bVar, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements l0 {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(l lVar) {
            View w = lVar.w(this.a);
            if (w instanceof com.swmansion.gesturehandler.react.a) {
                ((com.swmansion.gesturehandler.react.a) w).a();
            }
            synchronized (RNGestureHandlerModule.this.mEnqueuedRootViewInit) {
                RNGestureHandlerModule.this.mEnqueuedRootViewInit.remove(new Integer(this.a));
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends d<e.i.a.a> {
        private c() {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public String d() {
            return "FlingGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public Class<e.i.a.a> e() {
            return e.i.a.a.class;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: f */
        public void b(e.i.a.a aVar, ReadableMap readableMap) {
            super.b(aVar, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                aVar.W(readableMap.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_DIRECTION)) {
                aVar.V(readableMap.getInt(RNGestureHandlerModule.KEY_DIRECTION));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: g */
        public e.i.a.a c(Context context) {
            return new e.i.a.a();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d, com.swmansion.gesturehandler.react.c
        /* renamed from: h */
        public void a(e.i.a.a aVar, WritableMap writableMap) {
            super.a(aVar, writableMap);
            writableMap.putDouble("x", o.a(aVar.m()));
            writableMap.putDouble("y", o.a(aVar.n()));
            writableMap.putDouble("absoluteX", o.a(aVar.k()));
            writableMap.putDouble("absoluteY", o.a(aVar.l()));
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class d<T extends e.i.a.b> implements com.swmansion.gesturehandler.react.c<T> {
        private d() {
        }

        @Override // com.swmansion.gesturehandler.react.c
        public void a(T t, WritableMap writableMap) {
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, t.o());
        }

        public void b(T t, ReadableMap readableMap) {
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                t.L(readableMap.getBoolean(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_ENABLED)) {
                t.H(readableMap.getBoolean(RNGestureHandlerModule.KEY_ENABLED));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP)) {
                RNGestureHandlerModule.handleHitSlopProperty(t, readableMap);
            }
        }

        public abstract T c(Context context);

        public abstract String d();

        public abstract Class<T> e();

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private static class e extends d<e.i.a.g> {
        private e() {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public String d() {
            return "LongPressGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public Class<e.i.a.g> e() {
            return e.i.a.g.class;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: f */
        public void b(e.i.a.g gVar, ReadableMap readableMap) {
            super.b(gVar, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS)) {
                gVar.V(readableMap.getInt(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS));
            }
            if (readableMap.hasKey("maxDist")) {
                gVar.U(o.b(readableMap.getDouble("maxDist")));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: g */
        public e.i.a.g c(Context context) {
            return new e.i.a.g(context);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d, com.swmansion.gesturehandler.react.c
        /* renamed from: h */
        public void a(e.i.a.g gVar, WritableMap writableMap) {
            super.a(gVar, writableMap);
            writableMap.putDouble("x", o.a(gVar.m()));
            writableMap.putDouble("y", o.a(gVar.n()));
            writableMap.putDouble("absoluteX", o.a(gVar.k()));
            writableMap.putDouble("absoluteY", o.a(gVar.l()));
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private static class f extends d<e.i.a.h> {
        private f() {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public String d() {
            return "NativeViewGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public Class<e.i.a.h> e() {
            return e.i.a.h.class;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: f */
        public void b(e.i.a.h hVar, ReadableMap readableMap) {
            super.b(hVar, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START)) {
                hVar.V(readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION)) {
                hVar.U(readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: g */
        public e.i.a.h c(Context context) {
            return new e.i.a.h();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d, com.swmansion.gesturehandler.react.c
        /* renamed from: h */
        public void a(e.i.a.h hVar, WritableMap writableMap) {
            super.a(hVar, writableMap);
            writableMap.putBoolean("pointerInside", hVar.x());
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private static class g extends d<e.i.a.j> {
        private g() {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public String d() {
            return "PanGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public Class<e.i.a.j> e() {
            return e.i.a.j.class;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: f */
        public void b(e.i.a.j jVar, ReadableMap readableMap) {
            boolean z;
            super.b(jVar, readableMap);
            boolean z2 = true;
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)) {
                jVar.a0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)));
                z = true;
            } else {
                z = false;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)) {
                jVar.Z(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)) {
                jVar.f0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)) {
                jVar.e0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)) {
                jVar.c0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)) {
                jVar.b0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)) {
                jVar.h0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)) {
                jVar.g0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)) {
                jVar.l0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)) {
                jVar.m0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)));
                z = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)) {
                jVar.n0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)));
            } else {
                z2 = z;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_DIST)) {
                jVar.j0(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_DIST)));
            } else if (z2) {
                jVar.j0(Float.MAX_VALUE);
            }
            if (readableMap.hasKey("minPointers")) {
                jVar.k0(readableMap.getInt("minPointers"));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS)) {
                jVar.i0(readableMap.getInt(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES)) {
                jVar.d0(readableMap.getBoolean(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: g */
        public e.i.a.j c(Context context) {
            return new e.i.a.j(context);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d, com.swmansion.gesturehandler.react.c
        /* renamed from: h */
        public void a(e.i.a.j jVar, WritableMap writableMap) {
            super.a(jVar, writableMap);
            writableMap.putDouble("x", o.a(jVar.m()));
            writableMap.putDouble("y", o.a(jVar.n()));
            writableMap.putDouble("absoluteX", o.a(jVar.k()));
            writableMap.putDouble("absoluteY", o.a(jVar.l()));
            writableMap.putDouble("translationX", o.a(jVar.V()));
            writableMap.putDouble("translationY", o.a(jVar.W()));
            writableMap.putDouble("velocityX", o.a(jVar.X()));
            writableMap.putDouble("velocityY", o.a(jVar.Y()));
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private static class h extends d<k> {
        private h() {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public String d() {
            return "PinchGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public Class<k> e() {
            return k.class;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: f */
        public k c(Context context) {
            return new k();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d, com.swmansion.gesturehandler.react.c
        /* renamed from: g */
        public void a(k kVar, WritableMap writableMap) {
            super.a(kVar, writableMap);
            writableMap.putDouble("scale", kVar.c0());
            writableMap.putDouble("focalX", o.a(kVar.a0()));
            writableMap.putDouble("focalY", o.a(kVar.b0()));
            writableMap.putDouble("velocity", kVar.d0());
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private static class i extends d<n> {
        private i() {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public String d() {
            return "RotationGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public Class<n> e() {
            return n.class;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: f */
        public n c(Context context) {
            return new n();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d, com.swmansion.gesturehandler.react.c
        /* renamed from: g */
        public void a(n nVar, WritableMap writableMap) {
            super.a(nVar, writableMap);
            writableMap.putDouble("rotation", nVar.Z());
            writableMap.putDouble("anchorX", o.a(nVar.X()));
            writableMap.putDouble("anchorY", o.a(nVar.Y()));
            writableMap.putDouble("velocity", nVar.a0());
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    private static class j extends d<e.i.a.o> {
        private j() {
            super(null);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public String d() {
            return "TapGestureHandler";
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        public Class<e.i.a.o> e() {
            return e.i.a.o.class;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: f */
        public void b(e.i.a.o oVar, ReadableMap readableMap) {
            super.b(oVar, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS)) {
                oVar.b0(readableMap.getInt(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS)) {
                oVar.X(readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS)) {
                oVar.V(readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)) {
                oVar.Y(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)) {
                oVar.Z(o.b(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)));
            }
            if (readableMap.hasKey("maxDist")) {
                oVar.W(o.b(readableMap.getDouble("maxDist")));
            }
            if (readableMap.hasKey("minPointers")) {
                oVar.a0(readableMap.getInt("minPointers"));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d
        /* renamed from: g */
        public e.i.a.o c(Context context) {
            return new e.i.a.o();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.d, com.swmansion.gesturehandler.react.c
        /* renamed from: h */
        public void a(e.i.a.o oVar, WritableMap writableMap) {
            super.a(oVar, writableMap);
            writableMap.putDouble("x", o.a(oVar.m()));
            writableMap.putDouble("y", o.a(oVar.n()));
            writableMap.putDouble("absoluteX", o.a(oVar.k()));
            writableMap.putDouble("absoluteY", o.a(oVar.l()));
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    public RNGestureHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mEventListener = new a();
        this.mHandlerFactories = new d[]{new f(null), new j(null), new e(null), new g(null), new h(null), new i(null), new c(null)};
        this.mRegistry = new com.swmansion.gesturehandler.react.f();
        this.mInteractionManager = new com.swmansion.gesturehandler.react.d();
        this.mRoots = new ArrayList();
        this.mEnqueuedRootViewInit = new ArrayList();
    }

    private d findFactoryForHandler(e.i.a.b bVar) {
        int i2 = 0;
        while (true) {
            d[] dVarArr = this.mHandlerFactories;
            if (i2 >= dVarArr.length) {
                return null;
            }
            d dVar = dVarArr[i2];
            if (dVar.e().equals(bVar.getClass())) {
                return dVar;
            }
            i2++;
        }
    }

    private com.swmansion.gesturehandler.react.g findRootHelperForViewAncestor(int i2) {
        int resolveRootTagFromReactTag = ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).resolveRootTagFromReactTag(i2);
        if (resolveRootTagFromReactTag < 1) {
            return null;
        }
        synchronized (this.mRoots) {
            for (int i3 = 0; i3 < this.mRoots.size(); i3++) {
                com.swmansion.gesturehandler.react.g gVar = this.mRoots.get(i3);
                ViewGroup f2 = gVar.f();
                if ((f2 instanceof s) && ((s) f2).getRootViewTag() == resolveRootTagFromReactTag) {
                    return gVar;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleHitSlopProperty(e.i.a.b bVar, ReadableMap readableMap) {
        if (readableMap.getType(KEY_HIT_SLOP) == ReadableType.Number) {
            float b2 = o.b(readableMap.getDouble(KEY_HIT_SLOP));
            bVar.I(b2, b2, b2, b2, Float.NaN, Float.NaN);
            return;
        }
        ReadableMap map = readableMap.getMap(KEY_HIT_SLOP);
        float b3 = map.hasKey(KEY_HIT_SLOP_HORIZONTAL) ? o.b(map.getDouble(KEY_HIT_SLOP_HORIZONTAL)) : Float.NaN;
        float f2 = b3;
        float b4 = map.hasKey(KEY_HIT_SLOP_VERTICAL) ? o.b(map.getDouble(KEY_HIT_SLOP_VERTICAL)) : Float.NaN;
        float f3 = b4;
        if (map.hasKey(KEY_HIT_SLOP_LEFT)) {
            b3 = o.b(map.getDouble(KEY_HIT_SLOP_LEFT));
        }
        float f4 = b3;
        if (map.hasKey(KEY_HIT_SLOP_TOP)) {
            b4 = o.b(map.getDouble(KEY_HIT_SLOP_TOP));
        }
        float f5 = b4;
        if (map.hasKey(KEY_HIT_SLOP_RIGHT)) {
            f2 = o.b(map.getDouble(KEY_HIT_SLOP_RIGHT));
        }
        float f6 = f2;
        if (map.hasKey(KEY_HIT_SLOP_BOTTOM)) {
            f3 = o.b(map.getDouble(KEY_HIT_SLOP_BOTTOM));
        }
        bVar.I(f4, f5, f6, f3, map.hasKey(KEY_HIT_SLOP_WIDTH) ? o.b(map.getDouble(KEY_HIT_SLOP_WIDTH)) : Float.NaN, map.hasKey(KEY_HIT_SLOP_HEIGHT) ? o.b(map.getDouble(KEY_HIT_SLOP_HEIGHT)) : Float.NaN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStateChange(e.i.a.b bVar, int i2, int i3) {
        if (bVar.q() < 0) {
            return;
        }
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().v(com.swmansion.gesturehandler.react.i.n(bVar, i2, i3, findFactoryForHandler(bVar)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouchEvent(e.i.a.b bVar, MotionEvent motionEvent) {
        if (bVar.q() >= 0 && bVar.p() == 4) {
            ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().v(com.swmansion.gesturehandler.react.b.n(bVar, findFactoryForHandler(bVar)));
        }
    }

    private void tryInitializeHandlerForReactRootView(int i2) {
        UIManagerModule uIManagerModule = (UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class);
        int resolveRootTagFromReactTag = uIManagerModule.resolveRootTagFromReactTag(i2);
        if (resolveRootTagFromReactTag >= 1) {
            synchronized (this.mRoots) {
                for (int i3 = 0; i3 < this.mRoots.size(); i3++) {
                    ViewGroup f2 = this.mRoots.get(i3).f();
                    if ((f2 instanceof s) && ((s) f2).getRootViewTag() == resolveRootTagFromReactTag) {
                        return;
                    }
                }
                synchronized (this.mEnqueuedRootViewInit) {
                    if (this.mEnqueuedRootViewInit.contains(Integer.valueOf(resolveRootTagFromReactTag))) {
                        return;
                    }
                    this.mEnqueuedRootViewInit.add(Integer.valueOf(resolveRootTagFromReactTag));
                    uIManagerModule.addUIBlock(new b(resolveRootTagFromReactTag));
                    return;
                }
            }
        }
        throw new JSApplicationIllegalArgumentException("Could find root view for a given ancestor with tag " + i2);
    }

    @ReactMethod
    public void attachGestureHandler(int i2, int i3) {
        tryInitializeHandlerForReactRootView(i3);
        if (this.mRegistry.b(i2, i3)) {
            return;
        }
        throw new JSApplicationIllegalArgumentException("Handler with tag " + i2 + " does not exists");
    }

    @ReactMethod
    public void createGestureHandler(String str, int i2, ReadableMap readableMap) {
        int i3 = 0;
        while (true) {
            d[] dVarArr = this.mHandlerFactories;
            if (i3 < dVarArr.length) {
                d dVar = dVarArr[i3];
                if (dVar.d().equals(str)) {
                    e.i.a.b c2 = dVar.c(getReactApplicationContext());
                    c2.M(i2);
                    c2.K(this.mEventListener);
                    this.mRegistry.h(c2);
                    this.mInteractionManager.e(c2, readableMap);
                    dVar.b(c2, readableMap);
                    return;
                }
                i3++;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid handler name " + str);
            }
        }
    }

    @ReactMethod
    public void dropGestureHandler(int i2) {
        this.mInteractionManager.g(i2);
        this.mRegistry.e(i2);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map getConstants() {
        return com.facebook.react.common.c.e("State", com.facebook.react.common.c.i("UNDETERMINED", 0, "BEGAN", 2, "ACTIVE", 4, "CANCELLED", 3, "FAILED", 1, "END", 5), "Direction", com.facebook.react.common.c.g("RIGHT", 1, "LEFT", 2, "UP", 4, "DOWN", 8));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    public com.swmansion.gesturehandler.react.f getRegistry() {
        return this.mRegistry;
    }

    @ReactMethod
    public void handleClearJSResponder() {
    }

    @ReactMethod
    public void handleSetJSResponder(int i2, boolean z) {
        com.swmansion.gesturehandler.react.g findRootHelperForViewAncestor;
        if (this.mRegistry == null || (findRootHelperForViewAncestor = findRootHelperForViewAncestor(i2)) == null) {
            return;
        }
        findRootHelperForViewAncestor.g(i2, z);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.mRegistry.d();
        this.mInteractionManager.h();
        synchronized (this.mRoots) {
            while (!this.mRoots.isEmpty()) {
                int size = this.mRoots.size();
                com.swmansion.gesturehandler.react.g gVar = this.mRoots.get(0);
                ViewGroup f2 = gVar.f();
                if (f2 instanceof com.swmansion.gesturehandler.react.a) {
                    ((com.swmansion.gesturehandler.react.a) f2).b();
                } else {
                    gVar.i();
                }
                if (this.mRoots.size() >= size) {
                    throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
                }
            }
        }
        super.onCatalystInstanceDestroy();
    }

    public void registerRootHelper(com.swmansion.gesturehandler.react.g gVar) {
        synchronized (this.mRoots) {
            if (!this.mRoots.contains(gVar)) {
                this.mRoots.add(gVar);
            } else {
                throw new IllegalStateException("Root helper" + gVar + " already registered");
            }
        }
    }

    public void unregisterRootHelper(com.swmansion.gesturehandler.react.g gVar) {
        synchronized (this.mRoots) {
            this.mRoots.remove(gVar);
        }
    }

    @ReactMethod
    public void updateGestureHandler(int i2, ReadableMap readableMap) {
        d findFactoryForHandler;
        e.i.a.b f2 = this.mRegistry.f(i2);
        if (f2 == null || (findFactoryForHandler = findFactoryForHandler(f2)) == null) {
            return;
        }
        this.mInteractionManager.g(i2);
        this.mInteractionManager.e(f2, readableMap);
        findFactoryForHandler.b(f2, readableMap);
    }
}