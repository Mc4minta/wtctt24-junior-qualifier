package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ModuleAwareClassDescriptor.kt */
/* loaded from: classes3.dex */
public abstract class ModuleAwareClassDescriptor implements ClassDescriptor {
    public static final Companion Companion = new Companion(null);

    /* compiled from: ModuleAwareClassDescriptor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberScope getRefinedMemberScopeIfPossible$descriptors(ClassDescriptor classDescriptor, TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
            m.g(classDescriptor, "<this>");
            m.g(typeSubstitution, "typeSubstitution");
            m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
            ModuleAwareClassDescriptor moduleAwareClassDescriptor = classDescriptor instanceof ModuleAwareClassDescriptor ? (ModuleAwareClassDescriptor) classDescriptor : null;
            if (moduleAwareClassDescriptor == null) {
                MemberScope memberScope = classDescriptor.getMemberScope(typeSubstitution);
                m.f(memberScope, "this.getMemberScope(\n                typeSubstitution\n            )");
                return memberScope;
            }
            return moduleAwareClassDescriptor.getMemberScope(typeSubstitution, kotlinTypeRefiner);
        }

        public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(ClassDescriptor classDescriptor, KotlinTypeRefiner kotlinTypeRefiner) {
            m.g(classDescriptor, "<this>");
            m.g(kotlinTypeRefiner, "kotlinTypeRefiner");
            ModuleAwareClassDescriptor moduleAwareClassDescriptor = classDescriptor instanceof ModuleAwareClassDescriptor ? (ModuleAwareClassDescriptor) classDescriptor : null;
            if (moduleAwareClassDescriptor == null) {
                MemberScope unsubstitutedMemberScope = classDescriptor.getUnsubstitutedMemberScope();
                m.f(unsubstitutedMemberScope, "this.unsubstitutedMemberScope");
                return unsubstitutedMemberScope;
            }
            return moduleAwareClassDescriptor.getUnsubstitutedMemberScope(kotlinTypeRefiner);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner);
}