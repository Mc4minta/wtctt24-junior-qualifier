package kotlin.j0;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypesJVM.kt */
/* loaded from: classes3.dex */
public final class a implements GenericArrayType, Type {
    private final Type a;

    public a(Type elementType) {
        kotlin.jvm.internal.m.g(elementType, "elementType");
        this.a = elementType;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && kotlin.jvm.internal.m.c(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.a;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String h2;
        StringBuilder sb = new StringBuilder();
        h2 = z.h(this.a);
        sb.append(h2);
        sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return sb.toString();
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}