package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KPackageImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/t;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke", "()Lkotlin/t;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KPackageImpl$Data$metadata$2 extends o implements a<t<? extends JvmNameResolver, ? extends ProtoBuf.Package, ? extends JvmMetadataVersion>> {
    final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$metadata$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // kotlin.e0.c.a
    public final t<? extends JvmNameResolver, ? extends ProtoBuf.Package, ? extends JvmMetadataVersion> invoke() {
        ReflectKotlinClass kotlinClass;
        KotlinClassHeader classHeader;
        kotlinClass = this.this$0.getKotlinClass();
        if (kotlinClass == null || (classHeader = kotlinClass.getClassHeader()) == null) {
            return null;
        }
        String[] data = classHeader.getData();
        String[] strings = classHeader.getStrings();
        if (data == null || strings == null) {
            return null;
        }
        kotlin.o<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom = JvmProtoBufUtil.readPackageDataFrom(data, strings);
        return new t<>(readPackageDataFrom.a(), readPackageDataFrom.b(), classHeader.getMetadataVersion());
    }
}