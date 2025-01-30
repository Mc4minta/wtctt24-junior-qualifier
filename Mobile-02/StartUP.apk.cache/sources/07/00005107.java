package io.reactivex.exceptions;

import h.c.n0.j.j;

/* compiled from: Exceptions.java */
/* loaded from: classes2.dex */
public final class a {
    public static RuntimeException a(Throwable th) {
        throw j.e(th);
    }

    public static void b(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (th instanceof LinkageError) {
                    throw ((LinkageError) th);
                }
                return;
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}