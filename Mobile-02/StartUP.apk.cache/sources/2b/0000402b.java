package com.swmansion.rnscreens;

import android.graphics.Paint;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;

/* compiled from: Screen.java */
/* loaded from: classes2.dex */
public class b extends ViewGroup {
    private static View.OnAttachStateChangeListener a = new a();

    /* renamed from: b  reason: collision with root package name */
    private g f10998b;

    /* renamed from: c  reason: collision with root package name */
    private com.swmansion.rnscreens.d f10999c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11000d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11001e;

    /* renamed from: f  reason: collision with root package name */
    private e f11002f;

    /* renamed from: g  reason: collision with root package name */
    private c f11003g;

    /* renamed from: h  reason: collision with root package name */
    private d f11004h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11005j;

    /* compiled from: Screen.java */
    /* loaded from: classes2.dex */
    static class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
            view.removeOnAttachStateChangeListener(b.a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: Screen.java */
    /* renamed from: com.swmansion.rnscreens.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0237b extends GuardedRunnable {
        final /* synthetic */ ReactContext a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f11006b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f11007c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0237b(ReactContext reactContext, ReactContext reactContext2, int i2, int i3) {
            super(reactContext);
            this.a = reactContext2;
            this.f11006b = i2;
            this.f11007c = i3;
        }

        @Override // com.facebook.react.bridge.GuardedRunnable
        public void runGuarded() {
            ((UIManagerModule) this.a.getNativeModule(UIManagerModule.class)).updateNodeSize(b.this.getId(), this.f11006b, this.f11007c);
        }
    }

    /* compiled from: Screen.java */
    /* loaded from: classes2.dex */
    public enum c {
        PUSH,
        POP
    }

    /* compiled from: Screen.java */
    /* loaded from: classes2.dex */
    public enum d {
        DEFAULT,
        NONE,
        FADE
    }

    /* compiled from: Screen.java */
    /* loaded from: classes2.dex */
    public enum e {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL
    }

    public b(ReactContext reactContext) {
        super(reactContext);
        this.f11002f = e.PUSH;
        this.f11003g = c.POP;
        this.f11004h = d.DEFAULT;
        this.f11005j = true;
        setLayoutParams(new WindowManager.LayoutParams(2));
    }

    public boolean b() {
        return this.f11000d;
    }

    public boolean c() {
        return this.f11005j;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.swmansion.rnscreens.d getContainer() {
        return this.f10999c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g getFragment() {
        return this.f10998b;
    }

    public c getReplaceAnimation() {
        return this.f11003g;
    }

    public d getStackAnimation() {
        return this.f11004h;
    }

    public e getStackPresentation() {
        return this.f11002f;
    }

    @Override // android.view.View
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        g gVar = this.f10998b;
        if (gVar != null) {
            gVar.i();
        }
    }

    @Override // android.view.View
    protected void onAnimationStart() {
        super.onAnimationStart();
        g gVar = this.f10998b;
        if (gVar != null) {
            gVar.j();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            while (focusedChild instanceof ViewGroup) {
                focusedChild = ((ViewGroup) focusedChild).getFocusedChild();
            }
            if (focusedChild instanceof TextView) {
                TextView textView = (TextView) focusedChild;
                if (textView.getShowSoftInputOnFocus()) {
                    textView.addOnAttachStateChangeListener(a);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            ReactContext reactContext = (ReactContext) getContext();
            reactContext.runOnNativeModulesQueueThread(new C0237b(reactContext, reactContext, i4 - i2, i5 - i3));
        }
    }

    public void setActive(boolean z) {
        if (z == this.f11000d) {
            return;
        }
        this.f11000d = z;
        com.swmansion.rnscreens.d dVar = this.f10999c;
        if (dVar != null) {
            dVar.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContainer(com.swmansion.rnscreens.d dVar) {
        this.f10999c = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFragment(g gVar) {
        this.f10998b = gVar;
    }

    public void setGestureEnabled(boolean z) {
        this.f11005j = z;
    }

    @Override // android.view.View
    public void setLayerType(int i2, Paint paint) {
    }

    public void setReplaceAnimation(c cVar) {
        this.f11003g = cVar;
    }

    public void setStackAnimation(d dVar) {
        this.f11004h = dVar;
    }

    public void setStackPresentation(e eVar) {
        this.f11002f = eVar;
    }

    public void setTransitioning(boolean z) {
        if (this.f11001e == z) {
            return;
        }
        this.f11001e = z;
        super.setLayerType(z ? 2 : 0, null);
    }
}