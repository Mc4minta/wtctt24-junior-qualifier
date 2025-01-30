package e.f.j.l;

import android.net.Uri;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* compiled from: DataFetchProducer.java */
/* loaded from: classes2.dex */
public class l extends z {
    public l(com.facebook.common.memory.g gVar) {
        super(e.f.d.b.a.a(), gVar);
    }

    static byte[] g(String str) {
        e.f.d.c.i.b(str.substring(0, 5).equals("data:"));
        int indexOf = str.indexOf(44);
        String substring = str.substring(indexOf + 1, str.length());
        if (h(str.substring(0, indexOf))) {
            return Base64.decode(substring, 0);
        }
        return Uri.decode(substring).getBytes();
    }

    static boolean h(String str) {
        if (str.contains(";")) {
            String[] split = str.split(";");
            return split[split.length - 1].equals("base64");
        }
        return false;
    }

    @Override // e.f.j.l.z
    protected e.f.j.i.d d(com.facebook.imagepipeline.request.b bVar) throws IOException {
        byte[] g2 = g(bVar.q().toString());
        return c(new ByteArrayInputStream(g2), g2.length);
    }

    @Override // e.f.j.l.z
    protected String f() {
        return "DataFetchProducer";
    }
}