package kotlin.reflect.jvm.internal;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.j0.c;
import kotlin.j0.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.t;

/* compiled from: KPackageImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u00014B\u001f\u0012\n\u0010!\u001a\u0006\u0012\u0002\b\u00030 \u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b2\u00103J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0017R,\u0010\u001e\u001a\u0018\u0012\u0014\u0012\u0012 \u001d*\b\u0018\u00010\u001cR\u00020\u00000\u001cR\u00020\u00000\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010!\u001a\u0006\u0012\u0002\b\u00030 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010*\u001a\u0006\u0012\u0002\b\u00030 8T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b)\u0010$R \u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0016\u00101\u001a\u00020.8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00065"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", ApiConstants.NAME, "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", "", "index", "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "usageModuleName", "Ljava/lang/String;", "getUsageModuleName", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "kotlin.jvm.PlatformType", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/Class;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "getMethodOwner", "methodOwner", "Lkotlin/j0/c;", "getMembers", "members", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "Data", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {
    private final ReflectProperties.LazyVal<Data> data;
    private final Class<?> jClass;
    private final String usageModuleName;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KPackageImpl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R\u001d\u0010\b\u001a\u00020\u00038F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R1\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR#\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "scope$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "members$delegate", "getMembers", "()Ljava/util/Collection;", "members", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass", "Lkotlin/t;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "metadata$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getMetadata", "()Lkotlin/t;", SendConfirmationArgs.metadataKey, "Ljava/lang/Class;", "multifileFacade$delegate", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade", "<init>", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ m[] $$delegatedProperties = {e0.h(new x(e0.b(Data.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), e0.h(new x(e0.b(Data.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), e0.h(new x(e0.b(Data.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), e0.h(new x(e0.b(Data.class), SendConfirmationArgs.metadataKey, "getMetadata()Lkotlin/Triple;")), e0.h(new x(e0.b(Data.class), "members", "getMembers()Ljava/util/Collection;"))};
        private final ReflectProperties.LazySoftVal kotlinClass$delegate;
        private final ReflectProperties.LazySoftVal members$delegate;
        private final ReflectProperties.LazyVal metadata$delegate;
        private final ReflectProperties.LazyVal multifileFacade$delegate;
        private final ReflectProperties.LazySoftVal scope$delegate;

        public Data() {
            super();
            this.kotlinClass$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$kotlinClass$2(this));
            this.scope$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$scope$2(this));
            this.multifileFacade$delegate = ReflectProperties.lazy(new KPackageImpl$Data$multifileFacade$2(this));
            this.metadata$delegate = ReflectProperties.lazy(new KPackageImpl$Data$metadata$2(this));
            this.members$delegate = ReflectProperties.lazySoft(new KPackageImpl$Data$members$2(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReflectKotlinClass getKotlinClass() {
            return (ReflectKotlinClass) this.kotlinClass$delegate.getValue(this, $$delegatedProperties[0]);
        }

        public final Collection<KCallableImpl<?>> getMembers() {
            return (Collection) this.members$delegate.getValue(this, $$delegatedProperties[4]);
        }

        public final t<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> getMetadata() {
            return (t) this.metadata$delegate.getValue(this, $$delegatedProperties[3]);
        }

        public final Class<?> getMultifileFacade() {
            return (Class) this.multifileFacade$delegate.getValue(this, $$delegatedProperties[2]);
        }

        public final MemberScope getScope() {
            return (MemberScope) this.scope$delegate.getValue(this, $$delegatedProperties[1]);
        }
    }

    public /* synthetic */ KPackageImpl(Class cls, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, (i2 & 2) != 0 ? null : str);
    }

    private final MemberScope getScope() {
        return this.data.invoke().getScope();
    }

    public boolean equals(Object obj) {
        return (obj instanceof KPackageImpl) && kotlin.jvm.internal.m.c(getJClass(), ((KPackageImpl) obj).getJClass());
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        List g2;
        g2 = r.g();
        return g2;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        kotlin.jvm.internal.m.g(name, "name");
        return getScope().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.jvm.internal.d
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i2) {
        t<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> metadata = this.data.invoke().getMetadata();
        if (metadata != null) {
            JvmNameResolver a = metadata.a();
            ProtoBuf.Package b2 = metadata.b();
            JvmMetadataVersion c2 = metadata.c();
            GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> generatedExtension = JvmProtoBuf.packageLocalVariable;
            kotlin.jvm.internal.m.f(generatedExtension, "JvmProtoBuf.packageLocalVariable");
            ProtoBuf.Property property = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(b2, generatedExtension, i2);
            if (property != null) {
                Class<?> jClass = getJClass();
                ProtoBuf.TypeTable typeTable = b2.getTypeTable();
                kotlin.jvm.internal.m.f(typeTable, "packageProto.typeTable");
                return (PropertyDescriptor) UtilKt.deserializeToDescriptor(jClass, property, a, new TypeTable(typeTable), c2, KPackageImpl$getLocalProperty$1$1$1.INSTANCE);
            }
            return null;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<c<?>> getMembers() {
        return this.data.invoke().getMembers();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    protected Class<?> getMethodOwner() {
        Class<?> multifileFacade = this.data.invoke().getMultifileFacade();
        return multifileFacade != null ? multifileFacade : getJClass();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        kotlin.jvm.internal.m.g(name, "name");
        return getScope().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION);
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return "file class " + ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName();
    }

    public KPackageImpl(Class<?> jClass, String str) {
        kotlin.jvm.internal.m.g(jClass, "jClass");
        this.jClass = jClass;
        this.usageModuleName = str;
        ReflectProperties.LazyVal<Data> lazy = ReflectProperties.lazy(new KPackageImpl$data$1(this));
        kotlin.jvm.internal.m.f(lazy, "ReflectProperties.lazy { Data() }");
        this.data = lazy;
    }
}