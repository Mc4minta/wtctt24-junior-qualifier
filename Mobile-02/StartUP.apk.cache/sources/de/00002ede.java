package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.y;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class ViewManager<T extends View, C extends y> extends BaseJavaModule {
    private final T createView(i0 i0Var, e.f.m.z.a aVar) {
        return createView(i0Var, null, null, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addEventEmitters(i0 i0Var, T t) {
    }

    public C createShadowNodeInstance() {
        throw new RuntimeException("ViewManager subclasses must implement createShadowNodeInstance()");
    }

    protected abstract T createViewInstance(i0 i0Var);

    protected T createViewInstance(i0 i0Var, a0 a0Var, h0 h0Var) {
        Object updateState;
        T createViewInstance = createViewInstance(i0Var);
        addEventEmitters(i0Var, createViewInstance);
        if (a0Var != null) {
            updateProperties(createViewInstance, a0Var);
        }
        if (h0Var != null && (updateState = updateState(createViewInstance, a0Var, h0Var)) != null) {
            updateExtraData(createViewInstance, updateState);
        }
        return createViewInstance;
    }

    public Map<String, Integer> getCommandsMap() {
        return null;
    }

    protected w0<T> getDelegate() {
        return null;
    }

    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return null;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return null;
    }

    public Map<String, Object> getExportedViewConstants() {
        return null;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public abstract String getName();

    public Map<String, String> getNativeProps() {
        return x0.e(getClass(), getShadowNodeClass());
    }

    public abstract Class<? extends C> getShadowNodeClass();

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, com.facebook.yoga.n nVar, float f3, com.facebook.yoga.n nVar2, int[] iArr) {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAfterUpdateTransaction(T t) {
    }

    public void onDropViewInstance(T t) {
    }

    @Deprecated
    public void receiveCommand(T t, int i2, ReadableArray readableArray) {
    }

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
    }

    public void setPadding(T t, int i2, int i3, int i4, int i5) {
    }

    public abstract void updateExtraData(T t, Object obj);

    public Object updateLocalData(T t, a0 a0Var, a0 a0Var2) {
        return null;
    }

    public void updateProperties(T t, a0 a0Var) {
        w0<T> delegate;
        if (e.f.m.v.a.f12889c && (delegate = getDelegate()) != null) {
            x0.h(delegate, t, a0Var);
        } else {
            x0.g(this, t, a0Var);
        }
        onAfterUpdateTransaction(t);
    }

    public Object updateState(T t, a0 a0Var, h0 h0Var) {
        return null;
    }

    public C createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        return createShadowNodeInstance();
    }

    public T createView(i0 i0Var, a0 a0Var, h0 h0Var, e.f.m.z.a aVar) {
        T createViewInstance = createViewInstance(i0Var, a0Var, h0Var);
        if (createViewInstance instanceof e.f.m.z.d) {
            ((e.f.m.z.d) createViewInstance).setOnInterceptTouchEventListener(aVar);
        }
        return createViewInstance;
    }
}