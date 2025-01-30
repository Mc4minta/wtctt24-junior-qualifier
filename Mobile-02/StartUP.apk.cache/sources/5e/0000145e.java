package com.coinbase.wallet.common.extensions;

import com.coinbase.wallet.common.exceptions.RPCException;
import com.coinbase.wallet.common.models.RPCError;
import com.coinbase.wallet.common.models.RPCErrorResponse;
import com.coinbase.wallet.core.util.AssertionException;
import com.coinbase.wallet.core.util.JSON;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.s;

/* compiled from: Throwable+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "Lcom/coinbase/wallet/common/exceptions/RPCException;", "asRPCException", "(Ljava/lang/Throwable;)Lcom/coinbase/wallet/common/exceptions/RPCException;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Throwable_CommonKt {
    public static final RPCException asRPCException(Throwable th) {
        s<?> b2;
        ResponseBody d2;
        RPCError error;
        m.g(th, "<this>");
        HttpException httpException = th instanceof HttpException ? (HttpException) th : null;
        String string = (httpException == null || (b2 = httpException.b()) == null || (d2 = b2.d()) == null) ? null : d2.string();
        if (string == null) {
            return null;
        }
        JSON json = JSON.INSTANCE;
        ReentrantReadWriteLock.ReadLock readLock = json.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            if (!(e0.b(RPCErrorResponse.class).getTypeParameters().isEmpty() ^ true ? false : true)) {
                l.a.a.e(new AssertionException("Since " + ((Object) e0.b(RPCErrorResponse.class).getSimpleName()) + " is parameterized please pass an adapter to `parameterizedAdapter`"));
            }
            Object fromJson = json.getMoshi().adapter(RPCErrorResponse.class).fromJson(string);
            readLock.unlock();
            RPCErrorResponse rPCErrorResponse = (RPCErrorResponse) fromJson;
            if (rPCErrorResponse == null || (error = rPCErrorResponse.getError()) == null) {
                return null;
            }
            return error.asException();
        } catch (Throwable th2) {
            readLock.unlock();
            throw th2;
        }
    }
}