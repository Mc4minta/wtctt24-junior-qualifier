package com.facebook.react.bridge;

import android.os.AsyncTask;

/* loaded from: classes2.dex */
public abstract class GuardedAsyncTask<Params, Progress> extends AsyncTask<Params, Progress, Void> {
    private final NativeModuleCallExceptionHandler mExceptionHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public GuardedAsyncTask(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    protected abstract void doInBackgroundGuarded(Params... paramsArr);

    protected GuardedAsyncTask(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mExceptionHandler = nativeModuleCallExceptionHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final Void doInBackground(Params... paramsArr) {
        try {
            doInBackgroundGuarded(paramsArr);
            return null;
        } catch (RuntimeException e2) {
            this.mExceptionHandler.handleException(e2);
            return null;
        }
    }
}