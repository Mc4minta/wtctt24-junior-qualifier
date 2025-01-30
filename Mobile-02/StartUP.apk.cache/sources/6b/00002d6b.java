package com.facebook.react.bridge;

import e.f.l.a.a;

@a
/* loaded from: classes2.dex */
public interface JavaJSExecutor {

    /* loaded from: classes2.dex */
    public interface Factory {
        JavaJSExecutor create() throws Exception;
    }

    /* loaded from: classes2.dex */
    public static class ProxyExecutorException extends Exception {
        public ProxyExecutorException(Throwable th) {
            super(th);
        }
    }

    void close();

    @a
    String executeJSCall(String str, String str2) throws ProxyExecutorException;

    @a
    void loadBundle(String str) throws ProxyExecutorException;

    @a
    void setGlobalVariable(String str, String str2);
}