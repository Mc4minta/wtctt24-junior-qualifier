package kotlin.k0;

import java.util.Iterator;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequenceBuilder.kt */
/* loaded from: classes3.dex */
public class l {
    public static <T> Iterator<T> a(kotlin.e0.c.p<? super j<? super T>, ? super kotlin.c0.d<? super x>, ? extends Object> block) {
        kotlin.c0.d<x> a;
        kotlin.jvm.internal.m.g(block, "block");
        i iVar = new i();
        a = kotlin.c0.h.c.a(block, iVar, iVar);
        iVar.i(a);
        return iVar;
    }
}