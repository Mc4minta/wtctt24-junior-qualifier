package com.facebook.react.devsupport;

import android.view.View;
import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;

/* compiled from: DisabledDevSupportManager.java */
/* loaded from: classes2.dex */
public class b implements com.facebook.react.devsupport.g.c {
    private final DefaultNativeModuleCallExceptionHandler a = new DefaultNativeModuleCallExceptionHandler();

    @Override // com.facebook.react.devsupport.g.c
    public View a(String str) {
        return null;
    }

    @Override // com.facebook.react.devsupport.g.c
    public boolean b() {
        return false;
    }

    @Override // com.facebook.react.devsupport.g.c
    public void c(boolean z) {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void d() {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void e(ReactContext reactContext) {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void f() {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void g(String str, ReadableArray readableArray, int i2) {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void h(boolean z) {
    }

    @Override // com.facebook.react.bridge.NativeModuleCallExceptionHandler
    public void handleException(Exception exc) {
        e.f.d.d.a.j("DisabledDevSupportManager", "Caught exception", exc);
        this.a.handleException(exc);
    }

    @Override // com.facebook.react.devsupport.g.c
    public void i(String str, com.facebook.react.devsupport.g.b bVar) {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void j(View view) {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void k(boolean z) {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void l(boolean z) {
    }

    @Override // com.facebook.react.devsupport.g.c
    public com.facebook.react.modules.debug.c.a m() {
        return null;
    }

    @Override // com.facebook.react.devsupport.g.c
    public void n() {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void o() {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void p(ReactContext reactContext) {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void q(String str, ReadableArray readableArray, int i2) {
    }

    @Override // com.facebook.react.devsupport.g.c
    public void r(com.facebook.react.devsupport.g.d dVar) {
    }
}