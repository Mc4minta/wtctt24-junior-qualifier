package com.facebook.react.bridge;

import com.coinbase.ApiConstants;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.systrace.b;
import e.f.f.b.c;
import e.f.l.a.a;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Provider;

@a
/* loaded from: classes2.dex */
public class ModuleHolder {
    private static final AtomicInteger sInstanceKeyCounter = new AtomicInteger(1);
    private boolean mInitializable;
    private final int mInstanceKey = sInstanceKeyCounter.getAndIncrement();
    private boolean mIsCreating;
    private boolean mIsInitializing;
    private NativeModule mModule;
    private final String mName;
    private Provider<? extends NativeModule> mProvider;
    private final ReactModuleInfo mReactModuleInfo;

    public ModuleHolder(ReactModuleInfo reactModuleInfo, Provider<? extends NativeModule> provider) {
        this.mName = reactModuleInfo.f();
        this.mProvider = provider;
        this.mReactModuleInfo = reactModuleInfo;
        if (reactModuleInfo.g()) {
            this.mModule = create();
        }
    }

    private NativeModule create() {
        boolean z = true;
        SoftAssertions.assertCondition(this.mModule == null, "Creating an already created module.");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, this.mName, this.mInstanceKey);
        b.a(0L, "ModuleHolder.createModule").b(ApiConstants.NAME, this.mName).c();
        c.a().b(e.f.f.c.a.f12129e, "NativeModule init: %s", this.mName);
        try {
            NativeModule nativeModule = (NativeModule) ((Provider) e.f.k.a.a.c(this.mProvider)).get();
            this.mProvider = null;
            synchronized (this) {
                this.mModule = nativeModule;
                if (!this.mInitializable || this.mIsInitializing) {
                    z = false;
                }
            }
            if (z) {
                doInitialize(nativeModule);
            }
            return nativeModule;
        } finally {
        }
    }

    private void doInitialize(NativeModule nativeModule) {
        boolean z;
        b.a(0L, "ModuleHolder.initialize").b(ApiConstants.NAME, this.mName).c();
        ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_START, this.mName, this.mInstanceKey);
        try {
            synchronized (this) {
                z = true;
                if (!this.mInitializable || this.mIsInitializing) {
                    z = false;
                } else {
                    this.mIsInitializing = true;
                }
            }
            if (z) {
                nativeModule.initialize();
                synchronized (this) {
                    this.mIsInitializing = false;
                }
            }
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.INITIALIZE_MODULE_END, this.mName, this.mInstanceKey);
            b.b(0L).c();
        }
    }

    public synchronized void destroy() {
        NativeModule nativeModule = this.mModule;
        if (nativeModule != null) {
            nativeModule.onCatalystInstanceDestroy();
        }
    }

    public boolean getCanOverrideExistingModule() {
        return this.mReactModuleInfo.a();
    }

    public String getClassName() {
        return this.mReactModuleInfo.b();
    }

    public boolean getHasConstants() {
        return this.mReactModuleInfo.c();
    }

    @a
    public NativeModule getModule() {
        NativeModule nativeModule;
        NativeModule nativeModule2;
        synchronized (this) {
            NativeModule nativeModule3 = this.mModule;
            if (nativeModule3 != null) {
                return nativeModule3;
            }
            boolean z = true;
            if (this.mIsCreating) {
                z = false;
            } else {
                this.mIsCreating = true;
            }
            if (z) {
                NativeModule create = create();
                synchronized (this) {
                    this.mIsCreating = false;
                    notifyAll();
                }
                return create;
            }
            synchronized (this) {
                while (true) {
                    nativeModule = this.mModule;
                    if (nativeModule != null || !this.mIsCreating) {
                        break;
                    }
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                nativeModule2 = (NativeModule) e.f.k.a.a.c(nativeModule);
            }
            return nativeModule2;
        }
    }

    @a
    public String getName() {
        return this.mName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean hasInstance() {
        return this.mModule != null;
    }

    public boolean isCxxModule() {
        return this.mReactModuleInfo.d();
    }

    public boolean isTurboModule() {
        return this.mReactModuleInfo.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markInitializable() {
        boolean z;
        NativeModule nativeModule;
        synchronized (this) {
            z = true;
            this.mInitializable = true;
            if (this.mModule != null) {
                e.f.k.a.a.a(this.mIsInitializing ? false : true);
                nativeModule = this.mModule;
            } else {
                nativeModule = null;
                z = false;
            }
        }
        if (z) {
            doInitialize(nativeModule);
        }
    }

    public ModuleHolder(NativeModule nativeModule) {
        String name = nativeModule.getName();
        this.mName = name;
        this.mReactModuleInfo = new ReactModuleInfo(nativeModule.getName(), nativeModule.getClass().getSimpleName(), nativeModule.canOverrideExistingModule(), true, true, CxxModuleWrapper.class.isAssignableFrom(nativeModule.getClass()), com.facebook.react.turbomodule.core.interfaces.a.class.isAssignableFrom(nativeModule.getClass()));
        this.mModule = nativeModule;
        c.a().b(e.f.f.c.a.f12129e, "NativeModule init: %s", name);
    }
}