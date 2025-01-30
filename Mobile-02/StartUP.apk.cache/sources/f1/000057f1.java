package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: MemberScope.kt */
/* loaded from: classes3.dex */
public final class DescriptorKindFilter {
    public static final DescriptorKindFilter ALL;
    private static final int ALL_KINDS_MASK;
    public static final DescriptorKindFilter CALLABLES;
    private static final int CALLABLES_MASK;
    public static final DescriptorKindFilter CLASSIFIERS;
    private static final int CLASSIFIERS_MASK;
    public static final Companion Companion;
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES;
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
    public static final DescriptorKindFilter FUNCTIONS;
    private static final int FUNCTIONS_MASK;
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK;
    public static final DescriptorKindFilter PACKAGES;
    private static final int PACKAGES_MASK;
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
    private static final int SINGLETON_CLASSIFIERS_MASK;
    public static final DescriptorKindFilter TYPE_ALIASES;
    private static final int TYPE_ALIASES_MASK;
    public static final DescriptorKindFilter VALUES;
    private static final int VALUES_MASK;
    public static final DescriptorKindFilter VARIABLES;
    private static final int VARIABLES_MASK;
    private static int nextMaskValue;
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;

    /* compiled from: MemberScope.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: MemberScope.kt */
        /* loaded from: classes3.dex */
        private static final class MaskToName {
            private final int mask;
            private final String name;

            public MaskToName(int i2, String name) {
                m.g(name, "name");
                this.mask = i2;
                this.name = name;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int nextMask() {
            int i2 = DescriptorKindFilter.nextMaskValue;
            DescriptorKindFilter.nextMaskValue <<= 1;
            return i2;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.ALL_KINDS_MASK;
        }

        public final int getCALLABLES_MASK() {
            return DescriptorKindFilter.CALLABLES_MASK;
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.CLASSIFIERS_MASK;
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.FUNCTIONS_MASK;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.NON_SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.PACKAGES_MASK;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.TYPE_ALIASES_MASK;
        }

        public final int getVALUES_MASK() {
            return DescriptorKindFilter.VALUES_MASK;
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.VARIABLES_MASK;
        }
    }

    static {
        Companion.MaskToName maskToName;
        Companion.MaskToName maskToName2;
        Companion companion = new Companion(null);
        Companion = companion;
        nextMaskValue = 1;
        NON_SINGLETON_CLASSIFIERS_MASK = companion.nextMask();
        SINGLETON_CLASSIFIERS_MASK = companion.nextMask();
        TYPE_ALIASES_MASK = companion.nextMask();
        PACKAGES_MASK = companion.nextMask();
        FUNCTIONS_MASK = companion.nextMask();
        VARIABLES_MASK = companion.nextMask();
        ALL_KINDS_MASK = companion.nextMask() - 1;
        CLASSIFIERS_MASK = companion.getNON_SINGLETON_CLASSIFIERS_MASK() | companion.getSINGLETON_CLASSIFIERS_MASK() | companion.getTYPE_ALIASES_MASK();
        VALUES_MASK = companion.getSINGLETON_CLASSIFIERS_MASK() | companion.getFUNCTIONS_MASK() | companion.getVARIABLES_MASK();
        CALLABLES_MASK = companion.getFUNCTIONS_MASK() | companion.getVARIABLES_MASK();
        ALL = new DescriptorKindFilter(companion.getALL_KINDS_MASK(), null, 2, null);
        CALLABLES = new DescriptorKindFilter(companion.getCALLABLES_MASK(), null, 2, null);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(companion.getNON_SINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(companion.getSINGLETON_CLASSIFIERS_MASK(), null, 2, null);
        TYPE_ALIASES = new DescriptorKindFilter(companion.getTYPE_ALIASES_MASK(), null, 2, null);
        CLASSIFIERS = new DescriptorKindFilter(companion.getCLASSIFIERS_MASK(), null, 2, null);
        PACKAGES = new DescriptorKindFilter(companion.getPACKAGES_MASK(), null, 2, null);
        FUNCTIONS = new DescriptorKindFilter(companion.getFUNCTIONS_MASK(), null, 2, null);
        VARIABLES = new DescriptorKindFilter(companion.getVARIABLES_MASK(), null, 2, null);
        VALUES = new DescriptorKindFilter(companion.getVALUES_MASK(), null, 2, null);
        Field[] fields = DescriptorKindFilter.class.getFields();
        m.f(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            DescriptorKindFilter descriptorKindFilter = obj instanceof DescriptorKindFilter ? (DescriptorKindFilter) obj : null;
            if (descriptorKindFilter != null) {
                int kindMask = descriptorKindFilter.getKindMask();
                String name = field2.getName();
                m.f(name, "field.name");
                maskToName2 = new Companion.MaskToName(kindMask, name);
            } else {
                maskToName2 = null;
            }
            if (maskToName2 != null) {
                arrayList2.add(maskToName2);
            }
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = arrayList2;
        Field[] fields2 = DescriptorKindFilter.class.getFields();
        m.f(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (m.c(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                m.f(name2, "field.name");
                maskToName = new Companion.MaskToName(intValue, name2);
            } else {
                maskToName = null;
            }
            if (maskToName != null) {
                arrayList5.add(maskToName);
            }
        }
        DEBUG_MASK_BIT_NAMES = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int i2, List<? extends DescriptorKindExclude> excludes) {
        m.g(excludes, "excludes");
        this.excludes = excludes;
        for (DescriptorKindExclude descriptorKindExclude : excludes) {
            i2 &= ~descriptorKindExclude.getFullyExcludedDescriptorKinds();
        }
        this.kindMask = i2;
    }

    public final boolean acceptsKinds(int i2) {
        return (i2 & this.kindMask) != 0;
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int i2) {
        int i3 = i2 & this.kindMask;
        if (i3 == 0) {
            return null;
        }
        return new DescriptorKindFilter(i3, this.excludes);
    }

    public String toString() {
        Object obj;
        boolean z;
        Iterator<T> it = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Companion.MaskToName) obj).getMask() == getKindMask()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Companion.MaskToName maskToName = (Companion.MaskToName) obj;
        String name = maskToName == null ? null : maskToName.getName();
        if (name == null) {
            List<Companion.MaskToName> list = DEBUG_MASK_BIT_NAMES;
            ArrayList arrayList = new ArrayList();
            for (Companion.MaskToName maskToName2 : list) {
                String name2 = acceptsKinds(maskToName2.getMask()) ? maskToName2.getName() : null;
                if (name2 != null) {
                    arrayList.add(name2);
                }
            }
            name = z.h0(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + name + ", " + this.excludes + ')';
    }

    public /* synthetic */ DescriptorKindFilter(int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? r.g() : list);
    }
}