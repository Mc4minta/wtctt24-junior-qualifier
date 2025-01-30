package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
final class u {

    /* loaded from: classes.dex */
    static final class b {

        /* renamed from: ǃ  reason: contains not printable characters */
        private final boolean f297;

        /* renamed from: ɩ  reason: contains not printable characters */
        final String f298;

        b(String str, boolean z) {
            this.f298 = str;
            this.f297 = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ɩ  reason: contains not printable characters */
        public final boolean m195() {
            return this.f297;
        }
    }

    /* loaded from: classes.dex */
    static final class e implements IInterface {

        /* renamed from: ǃ  reason: contains not printable characters */
        private IBinder f301;

        e(IBinder iBinder) {
            this.f301 = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f301;
        }

        /* renamed from: ı  reason: contains not printable characters */
        final boolean m196() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f301.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: ǃ  reason: contains not printable characters */
        public final String m197() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f301.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    u() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ι  reason: contains not printable characters */
    public static b m194(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                d dVar = new d((byte) 0);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    try {
                        if (context.bindService(intent, dVar, 1)) {
                            if (!dVar.f299) {
                                dVar.f299 = true;
                                e eVar = new e(dVar.f300.take());
                                return new b(eVar.m197(), eVar.m196());
                            }
                            throw new IllegalStateException();
                        }
                        context.unbindService(dVar);
                        throw new IOException("Google Play connection failed");
                    } catch (Exception e2) {
                        throw e2;
                    }
                } finally {
                    context.unbindService(dVar);
                }
            } catch (Exception e3) {
                throw e3;
            }
        }
        throw new IllegalStateException("Cannot be called from the main thread");
    }

    /* loaded from: classes.dex */
    static final class d implements ServiceConnection {

        /* renamed from: ı  reason: contains not printable characters */
        boolean f299;

        /* renamed from: Ι  reason: contains not printable characters */
        final LinkedBlockingQueue<IBinder> f300;

        private d() {
            this.f300 = new LinkedBlockingQueue<>(1);
            this.f299 = false;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f300.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }
}