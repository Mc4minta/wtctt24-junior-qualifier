package com.coinbase.android.apiv3.generated.authed.speedrun;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: Speedrun.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0006H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/speedrun/Speedrun;", "", "Lcom/coinbase/android/apiv3/generated/authed/speedrun/SpeedrunEmpty;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/speedrun/SpeedrunValue;", "Lcom/coinbase/android/apiv3/V3Error;", "get", "(Lcom/coinbase/android/apiv3/generated/authed/speedrun/SpeedrunEmpty;)Lh/c/b0;", "set", "(Lcom/coinbase/android/apiv3/generated/authed/speedrun/SpeedrunValue;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface Speedrun {
    @f("coinbase.public_api.authed.speedrun.Speedrun/Get")
    b0<NetworkResponse<SpeedrunValue, V3Error>> get(@t("q") SpeedrunEmpty speedrunEmpty);

    @o("coinbase.public_api.authed.speedrun.Speedrun/Set")
    b0<NetworkResponse<SpeedrunEmpty, V3Error>> set(@a SpeedrunValue speedrunValue);
}