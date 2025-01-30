package com.facebook.react.bridge;

import e.f.l.a.a;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@a
@Deprecated
/* loaded from: classes2.dex */
public class ReactSoftException {
    private static final List<ReactSoftExceptionListener> sListeners = new CopyOnWriteArrayList();

    /* loaded from: classes2.dex */
    public interface ReactSoftExceptionListener {
        void logSoftException(String str, Throwable th);
    }

    @a
    public static void addListener(ReactSoftExceptionListener reactSoftExceptionListener) {
        List<ReactSoftExceptionListener> list = sListeners;
        if (list.contains(reactSoftExceptionListener)) {
            return;
        }
        list.add(reactSoftExceptionListener);
    }

    @a
    public static void clearListeners() {
        sListeners.clear();
    }

    @a
    public static void logSoftException(String str, Throwable th) {
        List<ReactSoftExceptionListener> list = sListeners;
        if (list.size() > 0) {
            for (ReactSoftExceptionListener reactSoftExceptionListener : list) {
                reactSoftExceptionListener.logSoftException(str, th);
            }
            return;
        }
        e.f.d.d.a.j(str, "Unhandled SoftException", th);
    }

    @a
    public static void removeListener(ReactSoftExceptionListener reactSoftExceptionListener) {
        sListeners.remove(reactSoftExceptionListener);
    }
}