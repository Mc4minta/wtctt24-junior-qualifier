package e.j.i.i2;

import com.coinbase.wallet.core.interfaces.RefreshIntervalCustomizable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.toshi.model.local.room.CollectibleType;
import h.c.s;
import java.util.List;

/* compiled from: CollectibleTypesRepositoryInterface.kt */
/* loaded from: classes2.dex */
public interface b extends Startable, Refreshable, RefreshIntervalCustomizable {
    s<List<CollectibleType>> a();
}