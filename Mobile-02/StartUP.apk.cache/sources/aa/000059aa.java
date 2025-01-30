package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: JavaTypeEnhancementState.kt */
/* loaded from: classes3.dex */
final class JavaTypeEnhancementState$description$2 extends o implements a<String[]> {
    final /* synthetic */ JavaTypeEnhancementState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTypeEnhancementState$description$2(JavaTypeEnhancementState javaTypeEnhancementState) {
        super(0);
        this.this$0 = javaTypeEnhancementState;
    }

    @Override // kotlin.e0.c.a
    public final String[] invoke() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.this$0.getGlobalJsr305Level().getDescription());
        ReportLevel migrationLevelForJsr305 = this.this$0.getMigrationLevelForJsr305();
        if (migrationLevelForJsr305 != null) {
            arrayList.add(m.o("under-migration:", migrationLevelForJsr305.getDescription()));
        }
        for (Map.Entry<String, ReportLevel> entry : this.this$0.getUserDefinedLevelForSpecificJsr305Annotation().entrySet()) {
            arrayList.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }
}