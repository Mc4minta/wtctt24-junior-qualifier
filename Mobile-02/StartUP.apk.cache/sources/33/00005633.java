package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SignatureBuildingComponents.kt */
/* loaded from: classes3.dex */
public final class SignatureBuildingComponents$jvmDescriptor$1 extends o implements l<String, CharSequence> {
    final /* synthetic */ SignatureBuildingComponents this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignatureBuildingComponents$jvmDescriptor$1(SignatureBuildingComponents signatureBuildingComponents) {
        super(1);
        this.this$0 = signatureBuildingComponents;
    }

    @Override // kotlin.e0.c.l
    public final CharSequence invoke(String it) {
        String escapeClassName;
        m.g(it, "it");
        escapeClassName = this.this$0.escapeClassName(it);
        return escapeClassName;
    }
}