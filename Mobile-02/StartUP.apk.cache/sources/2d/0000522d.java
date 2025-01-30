package kotlin.j0;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
/* loaded from: classes3.dex */
public final class x implements TypeVariable<GenericDeclaration>, Type {
    private final r a;

    public x(r typeParameter) {
        kotlin.jvm.internal.m.g(typeParameter, "typeParameter");
        this.a = typeParameter;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (kotlin.jvm.internal.m.c(getName(), typeVariable.getName()) && kotlin.jvm.internal.m.c(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        int r;
        Type c2;
        List<q> upperBounds = this.a.getUpperBounds();
        r = kotlin.a0.s.r(upperBounds, 10);
        ArrayList arrayList = new ArrayList(r);
        for (q qVar : upperBounds) {
            c2 = z.c(qVar, true);
            arrayList.add(c2);
        }
        Object[] array = arrayList.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Type[]) array;
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        throw new kotlin.n("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.a));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.a.getName();
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}