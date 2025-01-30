package e.g.b.a.c;

import e.g.b.a.d.e0;
import e.g.b.a.d.n;
import java.io.IOException;

/* compiled from: GenericJson.java */
/* loaded from: classes2.dex */
public class b extends n implements Cloneable {
    private c jsonFactory;

    public final c getFactory() {
        return this.jsonFactory;
    }

    public final void setFactory(c cVar) {
        this.jsonFactory = cVar;
    }

    public String toPrettyString() throws IOException {
        c cVar = this.jsonFactory;
        if (cVar != null) {
            return cVar.i(this);
        }
        return super.toString();
    }

    @Override // java.util.AbstractMap
    public String toString() {
        c cVar = this.jsonFactory;
        if (cVar != null) {
            try {
                return cVar.j(this);
            } catch (IOException e2) {
                throw e0.a(e2);
            }
        }
        return super.toString();
    }

    @Override // e.g.b.a.d.n
    public b set(String str, Object obj) {
        return (b) super.set(str, obj);
    }

    @Override // e.g.b.a.d.n, java.util.AbstractMap
    public b clone() {
        return (b) super.clone();
    }
}