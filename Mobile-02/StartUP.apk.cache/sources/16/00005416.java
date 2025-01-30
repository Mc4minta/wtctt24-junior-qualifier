package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.e0.c.a;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ScopesHolderForClass.kt */
/* loaded from: classes3.dex */
public final class ScopesHolderForClass$scopeForOwnerModule$2<T> extends o implements a<T> {
    final /* synthetic */ ScopesHolderForClass<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopesHolderForClass$scopeForOwnerModule$2(ScopesHolderForClass<T> scopesHolderForClass) {
        super(0);
        this.this$0 = scopesHolderForClass;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.e0.c.a
    public final MemberScope invoke() {
        l lVar;
        KotlinTypeRefiner kotlinTypeRefiner;
        lVar = ((ScopesHolderForClass) this.this$0).scopeFactory;
        kotlinTypeRefiner = ((ScopesHolderForClass) this.this$0).kotlinTypeRefinerForOwnerModule;
        return (MemberScope) lVar.invoke(kotlinTypeRefiner);
    }
}