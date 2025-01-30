package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Set;
import kotlin.a0.w;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: MemberScope.kt */
/* loaded from: classes3.dex */
public final class MemberScopeKt {
    public static final Set<Name> flatMapClassifierNamesOrNull(Iterable<? extends MemberScope> iterable) {
        m.g(iterable, "<this>");
        HashSet hashSet = new HashSet();
        for (MemberScope memberScope : iterable) {
            Set<Name> classifierNames = memberScope.getClassifierNames();
            if (classifierNames == null) {
                return null;
            }
            w.y(hashSet, classifierNames);
        }
        return hashSet;
    }
}