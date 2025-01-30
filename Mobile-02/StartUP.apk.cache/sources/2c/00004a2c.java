package e.j.l;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.coinbase.wallet.application.BaseApplication;

/* compiled from: KeyboardUtil.kt */
/* loaded from: classes2.dex */
public final class i {
    public static final i a = new i();

    private i() {
    }

    private final InputMethodManager a() {
        Object systemService = BaseApplication.Companion.getInstance().getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            return (InputMethodManager) systemService;
        }
        return null;
    }

    public final void b(View view) {
        InputMethodManager a2;
        if (view == null || (a2 = a()) == null) {
            return;
        }
        a2.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public final void c(View view) {
        InputMethodManager a2;
        if (view == null || (a2 = a()) == null) {
            return;
        }
        a2.showSoftInput(view, 1);
    }
}