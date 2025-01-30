package e.g.b.a.b.d.a.a;

import android.accounts.AccountManager;
import android.content.Context;
import e.g.b.a.d.y;

/* compiled from: GoogleAccountManager.java */
/* loaded from: classes2.dex */
public final class a {
    private final AccountManager a;

    public a(AccountManager accountManager) {
        this.a = (AccountManager) y.d(accountManager);
    }

    public a(Context context) {
        this(AccountManager.get(context));
    }
}