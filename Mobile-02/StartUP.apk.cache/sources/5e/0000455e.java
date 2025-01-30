package e.f.d.c;

import java.util.ArrayList;
import java.util.Collections;

/* compiled from: ImmutableList.java */
/* loaded from: classes2.dex */
public class e<E> extends ArrayList<E> {
    private e(int i2) {
        super(i2);
    }

    public static <E> e<E> h(E... eArr) {
        e<E> eVar = new e<>(eArr.length);
        Collections.addAll(eVar, eArr);
        return eVar;
    }
}