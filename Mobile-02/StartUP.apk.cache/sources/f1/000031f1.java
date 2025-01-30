package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public interface l extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public static abstract class a extends e.g.a.e.d.e.a implements l {

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        /* renamed from: com.google.android.gms.common.internal.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0142a extends e.g.a.e.d.e.b implements l {
            C0142a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.l
            public final Account m() throws RemoteException {
                Parcel p = p(2, n());
                Account account = (Account) e.g.a.e.d.e.c.b(p, Account.CREATOR);
                p.recycle();
                return account;
            }
        }

        public static l p(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof l) {
                return (l) queryLocalInterface;
            }
            return new C0142a(iBinder);
        }
    }

    Account m() throws RemoteException;
}