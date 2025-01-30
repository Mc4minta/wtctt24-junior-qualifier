package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.HashMap;
import java.util.Map;
import kotlin.e0.c.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJavaPackageFragment.kt */
/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment$partToFacade$2 extends o implements a<HashMap<JvmClassName, JvmClassName>> {
    final /* synthetic */ LazyJavaPackageFragment this$0;

    /* compiled from: LazyJavaPackageFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.valuesCustom().length];
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$partToFacade$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    @Override // kotlin.e0.c.a
    public final HashMap<JvmClassName, JvmClassName> invoke() {
        HashMap<JvmClassName, JvmClassName> hashMap = new HashMap<>();
        for (Map.Entry<String, KotlinJvmBinaryClass> entry : this.this$0.getBinaryClasses$descriptors_jvm().entrySet()) {
            JvmClassName byInternalName = JvmClassName.byInternalName(entry.getKey());
            m.f(byInternalName, "byInternalName(partInternalName)");
            KotlinClassHeader classHeader = entry.getValue().getClassHeader();
            int i2 = WhenMappings.$EnumSwitchMapping$0[classHeader.getKind().ordinal()];
            if (i2 == 1) {
                String multifileClassName = classHeader.getMultifileClassName();
                if (multifileClassName != null) {
                    JvmClassName byInternalName2 = JvmClassName.byInternalName(multifileClassName);
                    m.f(byInternalName2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                    hashMap.put(byInternalName, byInternalName2);
                }
            } else if (i2 == 2) {
                hashMap.put(byInternalName, byInternalName);
            }
        }
        return hashMap;
    }
}