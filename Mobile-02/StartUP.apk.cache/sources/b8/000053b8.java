package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmBuiltIns.kt */
/* loaded from: classes3.dex */
public final class JvmBuiltIns$customizer$2 extends o implements a<JvmBuiltInsCustomizer> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltIns this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltIns.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$customizer$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends o implements a<JvmBuiltIns.Settings> {
        final /* synthetic */ JvmBuiltIns this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(JvmBuiltIns jvmBuiltIns) {
            super(0);
            this.this$0 = jvmBuiltIns;
        }

        @Override // kotlin.e0.c.a
        public final JvmBuiltIns.Settings invoke() {
            a aVar;
            aVar = this.this$0.settingsComputation;
            if (aVar != null) {
                JvmBuiltIns.Settings settings = (JvmBuiltIns.Settings) aVar.invoke();
                this.this$0.settingsComputation = null;
                return settings;
            }
            throw new AssertionError("JvmBuiltins instance has not been initialized properly");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns$customizer$2(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltIns;
        this.$storageManager = storageManager;
    }

    @Override // kotlin.e0.c.a
    public final JvmBuiltInsCustomizer invoke() {
        ModuleDescriptorImpl builtInsModule = this.this$0.getBuiltInsModule();
        m.f(builtInsModule, "builtInsModule");
        return new JvmBuiltInsCustomizer(builtInsModule, this.$storageManager, new AnonymousClass1(this.this$0));
    }
}