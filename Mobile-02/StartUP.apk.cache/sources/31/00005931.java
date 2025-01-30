package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.a0.s;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NewCapturedType.kt */
/* loaded from: classes3.dex */
public final class NewCapturedTypeConstructor$refine$1$1 extends o implements a<List<? extends UnwrappedType>> {
    final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
    final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor$refine$1$1(NewCapturedTypeConstructor newCapturedTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
        this.$kotlinTypeRefiner = kotlinTypeRefiner;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends UnwrappedType> invoke() {
        int r;
        List<UnwrappedType> mo2215getSupertypes = this.this$0.mo2215getSupertypes();
        KotlinTypeRefiner kotlinTypeRefiner = this.$kotlinTypeRefiner;
        r = s.r(mo2215getSupertypes, 10);
        ArrayList arrayList = new ArrayList(r);
        for (UnwrappedType unwrappedType : mo2215getSupertypes) {
            arrayList.add(unwrappedType.refine(kotlinTypeRefiner));
        }
        return arrayList;
    }
}