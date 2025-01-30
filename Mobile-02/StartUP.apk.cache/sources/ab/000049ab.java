package e.j.i;

import com.coinbase.wallet.core.interfaces.RefreshInterval;
import com.coinbase.wallet.core.interfaces.RefreshIntervalCustomizable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: RefreshService.kt */
/* loaded from: classes2.dex */
public final class d2 {

    /* compiled from: RefreshService.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshInterval.values().length];
            iArr[RefreshInterval.DEFAULT.ordinal()] = 1;
            iArr[RefreshInterval.FIVE_MIN.ordinal()] = 2;
            iArr[RefreshInterval.HOUR.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(RefreshInterval refreshInterval) {
        int i2 = a.a[refreshInterval.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return 120;
                }
                throw new NoWhenBranchMatchedException();
            }
            return 10;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Refreshable refreshable, int i2) {
        RefreshIntervalCustomizable refreshIntervalCustomizable = refreshable instanceof RefreshIntervalCustomizable ? (RefreshIntervalCustomizable) refreshable : null;
        RefreshInterval refreshInterval = refreshIntervalCustomizable != null ? refreshIntervalCustomizable.getRefreshInterval() : null;
        if (refreshInterval == null) {
            refreshInterval = RefreshInterval.DEFAULT;
        }
        return e2.a(i2, c(refreshInterval)) == 0;
    }
}