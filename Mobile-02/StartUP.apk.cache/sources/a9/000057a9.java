package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* compiled from: ResolutionAnchorProvider.kt */
/* loaded from: classes3.dex */
public interface ResolutionAnchorProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: ResolutionAnchorProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ResolutionAnchorProvider Default = new ResolutionAnchorProvider() { // from class: kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider$Companion$Default$1
            @Override // kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider
            public ModuleDescriptor getResolutionAnchor(ModuleDescriptor moduleDescriptor) {
                m.g(moduleDescriptor, "moduleDescriptor");
                return null;
            }
        };

        private Companion() {
        }
    }

    ModuleDescriptor getResolutionAnchor(ModuleDescriptor moduleDescriptor);
}