package com.coinbase.wallet.wallets.models;

import com.coinbase.resources.transactions.Transaction;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: WalletRefreshState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/wallets/models/WalletRefreshState;", "", "", "canRefresh", "()Z", "", "start", "()Ljava/lang/String;", "refreshID", "Lkotlin/x;", "completed", "(Ljava/lang/String;)V", Transaction.STATUS_FAILED, "cancel", "()V", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "epoch", "J", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "getDisposeBag", "()Lh/c/k0/a;", "Ljava/lang/String;", "refreshInterval", "isRefreshing", "Z", "<init>", "(J)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletRefreshState {
    private long epoch;
    private boolean isRefreshing;
    private String refreshID;
    private final long refreshInterval;
    private final ReentrantLock lock = new ReentrantLock();
    private final h.c.k0.a disposeBag = new h.c.k0.a();

    public WalletRefreshState(long j2) {
        this.refreshInterval = j2;
    }

    public final boolean canRefresh() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.isRefreshing) {
                return false;
            }
            return System.currentTimeMillis() >= this.epoch + (this.refreshInterval * 1000);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.refreshID = null;
            this.epoch = 0L;
            this.isRefreshing = false;
            getDisposeBag().d();
            x xVar = x.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void completed(String str) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        if (str != null) {
            try {
                if (!m.c(str, this.refreshID)) {
                    x xVar = x.a;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        this.refreshID = null;
        this.isRefreshing = false;
        this.epoch = System.currentTimeMillis();
        x xVar2 = x.a;
    }

    public final void failed(String str) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        if (str != null) {
            try {
                if (!m.c(str, this.refreshID)) {
                    x xVar = x.a;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        this.refreshID = null;
        this.isRefreshing = false;
        this.epoch = 0L;
        x xVar2 = x.a;
    }

    public final h.c.k0.a getDisposeBag() {
        return this.disposeBag;
    }

    public final String start() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            String uuid = UUID.randomUUID().toString();
            m.f(uuid, "randomUUID().toString()");
            this.refreshID = uuid;
            this.isRefreshing = true;
            return uuid;
        } finally {
            reentrantLock.unlock();
        }
    }
}