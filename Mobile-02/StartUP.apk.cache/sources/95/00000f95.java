package com.coinbase.android.apiv3.generated.unauthed.push;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.o;

/* compiled from: PriceSubscriber.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ+\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/push/PriceSubscriber;", "", "Lcom/coinbase/android/apiv3/generated/unauthed/push/PricePercentChange;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "receiveLatest", "(Lcom/coinbase/android/apiv3/generated/unauthed/push/PricePercentChange;)Lh/c/b0;", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface PriceSubscriber {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: PriceSubscriber.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/android/apiv3/generated/unauthed/push/PriceSubscriber$Companion;", "", "", "RECEIVE_LATEST_EVENT", "Ljava/lang/String;", "getRECEIVE_LATEST_EVENT", "()Ljava/lang/String;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String RECEIVE_LATEST_EVENT = RECEIVE_LATEST_EVENT;
        private static final String RECEIVE_LATEST_EVENT = RECEIVE_LATEST_EVENT;

        private Companion() {
        }

        public final String getRECEIVE_LATEST_EVENT() {
            return RECEIVE_LATEST_EVENT;
        }
    }

    @o("coinbase.public_api.unauthed.push.PriceSubscriber/ReceiveLatest")
    b0<NetworkResponse<?, V3Error>> receiveLatest(@a PricePercentChange pricePercentChange);
}