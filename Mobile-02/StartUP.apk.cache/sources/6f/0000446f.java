package e.a.a.u.b;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent.java */
/* loaded from: classes.dex */
public class b {
    private List<s> a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(s sVar) {
        this.a.add(sVar);
    }

    public void b(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            e.a.a.z.h.b(path, this.a.get(size));
        }
    }
}