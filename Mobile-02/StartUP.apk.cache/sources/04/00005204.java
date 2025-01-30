package kotlin.j0;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
/* loaded from: classes3.dex */
public final class a0 implements WildcardType, Type {

    /* renamed from: c  reason: collision with root package name */
    private final Type f17289c;

    /* renamed from: d  reason: collision with root package name */
    private final Type f17290d;

    /* renamed from: b  reason: collision with root package name */
    public static final a f17288b = new a(null);
    private static final a0 a = new a0(null, null);

    /* compiled from: TypesJVM.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final a0 a() {
            return a0.a;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a0(Type type, Type type2) {
        this.f17289c = type;
        this.f17290d = type2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.f17290d;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String h2;
        String h3;
        if (this.f17290d != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("? super ");
            h3 = z.h(this.f17290d);
            sb.append(h3);
            return sb.toString();
        }
        Type type = this.f17289c;
        if (type == null || !(!kotlin.jvm.internal.m.c(type, Object.class))) {
            return "?";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("? extends ");
        h2 = z.h(this.f17289c);
        sb2.append(h2);
        return sb2.toString();
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.f17289c;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public String toString() {
        return getTypeName();
    }
}