package d.a.a.a.a;

import com.coinbase.wallet.http.models.HTTPService;
import java.net.URL;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;

/* compiled from: HTTPService+CompoundFinance.kt */
/* loaded from: classes.dex */
public final class a {
    private static final h a;

    /* compiled from: HTTPService+CompoundFinance.kt */
    /* renamed from: d.a.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0251a extends o implements kotlin.e0.c.a<HTTPService> {
        public static final C0251a a = new C0251a();

        C0251a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final HTTPService invoke() {
            return new HTTPService(new URL("https://compound.wallet.coinbase.com"));
        }
    }

    static {
        h b2;
        b2 = k.b(C0251a.a);
        a = b2;
    }

    public static final HTTPService a(HTTPService.Companion companion) {
        m.g(companion, "<this>");
        return (HTTPService) a.getValue();
    }
}