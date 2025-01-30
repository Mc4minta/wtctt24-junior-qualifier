package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public interface p3 extends IInterface {
    List<q9> E(String str, String str2, String str3, boolean z) throws RemoteException;

    byte[] G0(p pVar, String str) throws RemoteException;

    String M(z9 z9Var) throws RemoteException;

    void R(long j2, String str, String str2, String str3) throws RemoteException;

    void U(z9 z9Var) throws RemoteException;

    List<ia> V(String str, String str2, String str3) throws RemoteException;

    List<ia> W(String str, String str2, z9 z9Var) throws RemoteException;

    List<q9> e0(String str, String str2, boolean z, z9 z9Var) throws RemoteException;

    List<q9> f0(z9 z9Var, boolean z) throws RemoteException;

    void g0(z9 z9Var) throws RemoteException;

    void m0(ia iaVar) throws RemoteException;

    void n0(p pVar, z9 z9Var) throws RemoteException;

    void r(ia iaVar, z9 z9Var) throws RemoteException;

    void r0(p pVar, String str, String str2) throws RemoteException;

    void t0(z9 z9Var) throws RemoteException;

    void v0(q9 q9Var, z9 z9Var) throws RemoteException;
}