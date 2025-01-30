package com.google.android.gms.internal.clearcut;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public interface n5 extends IInterface {
    void C(DataHolder dataHolder) throws RemoteException;

    void D0(Status status) throws RemoteException;

    void Q0(Status status) throws RemoteException;

    void R0(Status status, e.g.a.e.c.d dVar) throws RemoteException;

    void T0(Status status, long j2) throws RemoteException;

    void k0(Status status, e.g.a.e.c.f[] fVarArr) throws RemoteException;

    void o(Status status) throws RemoteException;

    void o0(Status status, e.g.a.e.c.d dVar) throws RemoteException;

    void v(Status status, long j2) throws RemoteException;
}