package com.coinbase.wallet.crypto.ciphers;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* compiled from: CipherLock.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/crypto/ciphers/CipherLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "()V", "crypto_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CipherLock extends ReentrantLock {
    public static final CipherLock INSTANCE = new CipherLock();

    private CipherLock() {
    }
}