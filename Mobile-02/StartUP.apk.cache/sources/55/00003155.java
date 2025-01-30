package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class a implements ServiceConnection {
    private boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<IBinder> f6031b = new LinkedBlockingQueue();

    public IBinder a() throws InterruptedException {
        com.google.android.gms.common.internal.t.j("BlockingServiceConnection.getService() called on main thread");
        if (!this.a) {
            this.a = true;
            return this.f6031b.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public IBinder b(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        com.google.android.gms.common.internal.t.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.a) {
            this.a = true;
            IBinder poll = this.f6031b.poll(j2, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f6031b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}