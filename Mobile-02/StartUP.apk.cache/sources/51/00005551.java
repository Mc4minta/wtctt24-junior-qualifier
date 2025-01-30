package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeclaredMemberIndex.kt */
/* loaded from: classes3.dex */
public final class ClassDeclaredMemberIndex$methodFilter$1 extends o implements l<JavaMethod, Boolean> {
    final /* synthetic */ ClassDeclaredMemberIndex this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        super(1);
        this.this$0 = classDeclaredMemberIndex;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(JavaMethod javaMethod) {
        return Boolean.valueOf(invoke2(javaMethod));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(JavaMethod m) {
        l lVar;
        m.g(m, "m");
        lVar = this.this$0.memberFilter;
        return ((Boolean) lVar.invoke(m)).booleanValue() && !JavaLoadingKt.isObjectMethodInInterface(m);
    }
}