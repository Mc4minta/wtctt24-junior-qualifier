package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.e0.c.a;
import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedAnnotations.kt */
/* loaded from: classes3.dex */
public class DeserializedAnnotations implements Annotations {
    static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(DeserializedAnnotations.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final NotNullLazyValue annotations$delegate;

    public DeserializedAnnotations(StorageManager storageManager, a<? extends List<? extends AnnotationDescriptor>> compute) {
        kotlin.jvm.internal.m.g(storageManager, "storageManager");
        kotlin.jvm.internal.m.g(compute, "compute");
        this.annotations$delegate = storageManager.createLazyValue(compute);
    }

    private final List<AnnotationDescriptor> getAnnotations() {
        return (List) StorageKt.getValue(this.annotations$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* renamed from: findAnnotation */
    public AnnotationDescriptor mo2207findAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.findAnnotation(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return getAnnotations().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        return getAnnotations().iterator();
    }
}