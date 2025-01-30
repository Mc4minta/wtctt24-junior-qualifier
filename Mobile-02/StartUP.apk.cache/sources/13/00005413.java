package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.e0.c.l;
import kotlin.j0.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ScopesHolderForClass.kt */
/* loaded from: classes3.dex */
public final class ScopesHolderForClass<T extends MemberScope> {
    private final ClassDescriptor classDescriptor;
    private final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
    private final l<KotlinTypeRefiner, T> scopeFactory;
    private final NotNullLazyValue scopeForOwnerModule$delegate;
    public static final Companion Companion = new Companion(null);
    static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* compiled from: ScopesHolderForClass.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor classDescriptor, StorageManager storageManager, KotlinTypeRefiner kotlinTypeRefinerForOwnerModule, l<? super KotlinTypeRefiner, ? extends T> scopeFactory) {
            kotlin.jvm.internal.m.g(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.m.g(storageManager, "storageManager");
            kotlin.jvm.internal.m.g(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            kotlin.jvm.internal.m.g(scopeFactory, "scopeFactory");
            return new ScopesHolderForClass<>(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, l<? super KotlinTypeRefiner, ? extends T> lVar, KotlinTypeRefiner kotlinTypeRefiner) {
        this.classDescriptor = classDescriptor;
        this.scopeFactory = lVar;
        this.kotlinTypeRefinerForOwnerModule = kotlinTypeRefiner;
        this.scopeForOwnerModule$delegate = storageManager.createLazyValue(new ScopesHolderForClass$scopeForOwnerModule$2(this));
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, l lVar, KotlinTypeRefiner kotlinTypeRefiner, DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor, storageManager, lVar, kotlinTypeRefiner);
    }

    private final T getScopeForOwnerModule() {
        return (T) StorageKt.getValue(this.scopeForOwnerModule$delegate, this, $$delegatedProperties[0]);
    }

    public final T getScope(KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor))) {
            TypeConstructor typeConstructor = this.classDescriptor.getTypeConstructor();
            kotlin.jvm.internal.m.f(typeConstructor, "classDescriptor.typeConstructor");
            return !kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor) ? getScopeForOwnerModule() : (T) kotlinTypeRefiner.getOrPutScopeForClass(this.classDescriptor, new ScopesHolderForClass$getScope$1(this, kotlinTypeRefiner));
        }
        return getScopeForOwnerModule();
    }
}