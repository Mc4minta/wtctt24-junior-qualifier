package e.j.j;

import com.toshi.model.local.authentication.AuthenticationMethod;

/* compiled from: LockPrefsInterface.kt */
/* loaded from: classes2.dex */
public interface e {
    public static final a a = a.a;

    /* compiled from: LockPrefsInterface.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    void a(boolean z);

    boolean b();

    AuthenticationMethod getAuthenticationMethod();

    boolean isTxAuthRequired();

    void setAuthenticationMethod(AuthenticationMethod authenticationMethod);

    void setTxAuthRequired(boolean z);
}