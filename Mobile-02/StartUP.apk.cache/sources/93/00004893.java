package e.g.b.a.b;

import com.google.api.client.http.b0;
import com.google.api.client.http.e;
import com.google.api.client.http.k;
import com.google.api.client.http.o;
import com.google.api.client.http.q;
import java.io.IOException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

/* compiled from: MethodOverride.java */
/* loaded from: classes2.dex */
public final class b implements k, q {
    private final boolean a;

    public b() {
        this(false);
    }

    private boolean c(o oVar) throws IOException {
        String i2 = oVar.i();
        if (i2.equals(HttpPost.METHOD_NAME)) {
            return false;
        }
        if (!i2.equals(HttpGet.METHOD_NAME) ? this.a : oVar.o().e().length() > 2048) {
            return !oVar.m().e(i2);
        }
        return true;
    }

    @Override // com.google.api.client.http.k
    public void a(o oVar) throws IOException {
        if (c(oVar)) {
            String i2 = oVar.i();
            oVar.w(HttpPost.METHOD_NAME);
            oVar.e().set("X-HTTP-Method-Override", i2);
            if (i2.equals(HttpGet.METHOD_NAME)) {
                oVar.r(new b0(oVar.o().clone()));
                oVar.o().clear();
            } else if (oVar.b() == null) {
                oVar.r(new e());
            }
        }
    }

    @Override // com.google.api.client.http.q
    public void b(o oVar) {
        oVar.u(this);
    }

    b(boolean z) {
        this.a = z;
    }
}