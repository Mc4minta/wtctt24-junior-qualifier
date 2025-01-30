package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.e0.a;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaAnnotationOwner.kt */
/* loaded from: classes3.dex */
public final class ReflectJavaAnnotationOwnerKt {
    public static final ReflectJavaAnnotation findAnnotation(Annotation[] annotationArr, FqName fqName) {
        Annotation annotation;
        m.g(annotationArr, "<this>");
        m.g(fqName, "fqName");
        int length = annotationArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i2];
            if (m.c(ReflectClassUtilKt.getClassId(a.b(a.a(annotation))).asSingleFqName(), fqName)) {
                break;
            }
            i2++;
        }
        if (annotation == null) {
            return null;
        }
        return new ReflectJavaAnnotation(annotation);
    }

    public static final List<ReflectJavaAnnotation> getAnnotations(Annotation[] annotationArr) {
        m.g(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new ReflectJavaAnnotation(annotation));
        }
        return arrayList;
    }
}