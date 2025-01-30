package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.v;
import kotlin.a0.w;
import kotlin.e0.c.a;
import kotlin.e0.c.l;
import kotlin.j0.m;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.x;
import kotlin.k0.h;
import kotlin.k0.n;
import kotlin.k0.p;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: DeserializedMemberScope.kt */
/* loaded from: classes3.dex */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), e0.h(new x(e0.b(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};

    /* renamed from: c  reason: collision with root package name */
    private final DeserializationContext f17407c;
    private final NotNullLazyValue classNames$delegate;
    private final NullableLazyValue classifierNamesLazy$delegate;
    private final Implementation impl;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: classes3.dex */
    public interface Implementation {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, l<? super Name, Boolean> lVar, LookupLocation lookupLocation);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation);

        Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name name);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: classes3.dex */
    public final class NoReorderImplementation implements Implementation {
        static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(NoReorderImplementation.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), e0.h(new x(e0.b(NoReorderImplementation.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), e0.h(new x(e0.b(NoReorderImplementation.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), e0.h(new x(e0.b(NoReorderImplementation.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), e0.h(new x(e0.b(NoReorderImplementation.class), "allProperties", "getAllProperties()Ljava/util/List;")), e0.h(new x(e0.b(NoReorderImplementation.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), e0.h(new x(e0.b(NoReorderImplementation.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), e0.h(new x(e0.b(NoReorderImplementation.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), e0.h(new x(e0.b(NoReorderImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), e0.h(new x(e0.b(NoReorderImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        private final NotNullLazyValue allFunctions$delegate;
        private final NotNullLazyValue allProperties$delegate;
        private final NotNullLazyValue allTypeAliases$delegate;
        private final NotNullLazyValue declaredFunctions$delegate;
        private final NotNullLazyValue declaredProperties$delegate;
        private final List<ProtoBuf.Function> functionList;
        private final NotNullLazyValue functionNames$delegate;
        private final NotNullLazyValue functionsByName$delegate;
        private final NotNullLazyValue propertiesByName$delegate;
        private final List<ProtoBuf.Property> propertyList;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final List<ProtoBuf.TypeAlias> typeAliasList;
        private final NotNullLazyValue typeAliasesByName$delegate;
        private final NotNullLazyValue variableNames$delegate;

        public NoReorderImplementation(DeserializedMemberScope this$0, List<ProtoBuf.Function> functionList, List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(functionList, "functionList");
            kotlin.jvm.internal.m.g(propertyList, "propertyList");
            kotlin.jvm.internal.m.g(typeAliasList, "typeAliasList");
            this.this$0 = this$0;
            this.functionList = functionList;
            this.propertyList = propertyList;
            this.typeAliasList = this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed() ? typeAliasList : r.g();
            this.declaredFunctions$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2(this));
            this.declaredProperties$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$declaredProperties$2(this));
            this.allTypeAliases$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2(this));
            this.allFunctions$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allFunctions$2(this));
            this.allProperties$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$allProperties$2(this));
            this.typeAliasesByName$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2(this));
            this.functionsByName$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionsByName$2(this));
            this.propertiesByName$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$propertiesByName$2(this));
            this.functionNames$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$functionNames$2(this, this$0));
            this.variableNames$delegate = this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$NoReorderImplementation$variableNames$2(this, this$0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> computeAllNonDeclaredFunctions() {
            Set<Name> nonDeclaredFunctionNames = this.this$0.getNonDeclaredFunctionNames();
            ArrayList arrayList = new ArrayList();
            for (Name name : nonDeclaredFunctionNames) {
                w.y(arrayList, computeNonDeclaredFunctionsForName(name));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PropertyDescriptor> computeAllNonDeclaredProperties() {
            Set<Name> nonDeclaredVariableNames = this.this$0.getNonDeclaredVariableNames();
            ArrayList arrayList = new ArrayList();
            for (Name name : nonDeclaredVariableNames) {
                w.y(arrayList, computeNonDeclaredPropertiesForName(name));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> computeFunctions() {
            List<ProtoBuf.Function> list = this.functionList;
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            ArrayList arrayList = new ArrayList();
            for (MessageLite messageLite : list) {
                SimpleFunctionDescriptor loadFunction = deserializedMemberScope.f17407c.getMemberDeserializer().loadFunction((ProtoBuf.Function) messageLite);
                if (!deserializedMemberScope.isDeclaredFunctionAvailable(loadFunction)) {
                    loadFunction = null;
                }
                if (loadFunction != null) {
                    arrayList.add(loadFunction);
                }
            }
            return arrayList;
        }

        private final List<SimpleFunctionDescriptor> computeNonDeclaredFunctionsForName(Name name) {
            List<SimpleFunctionDescriptor> declaredFunctions = getDeclaredFunctions();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            ArrayList arrayList = new ArrayList();
            for (Object obj : declaredFunctions) {
                if (kotlin.jvm.internal.m.c(((DeclarationDescriptor) obj).getName(), name)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.computeNonDeclaredFunctions(name, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<PropertyDescriptor> computeNonDeclaredPropertiesForName(Name name) {
            List<PropertyDescriptor> declaredProperties = getDeclaredProperties();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            ArrayList arrayList = new ArrayList();
            for (Object obj : declaredProperties) {
                if (kotlin.jvm.internal.m.c(((DeclarationDescriptor) obj).getName(), name)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.computeNonDeclaredProperties(name, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PropertyDescriptor> computeProperties() {
            List<ProtoBuf.Property> list = this.propertyList;
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            ArrayList arrayList = new ArrayList();
            for (MessageLite messageLite : list) {
                PropertyDescriptor loadProperty = deserializedMemberScope.f17407c.getMemberDeserializer().loadProperty((ProtoBuf.Property) messageLite);
                if (loadProperty != null) {
                    arrayList.add(loadProperty);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<TypeAliasDescriptor> computeTypeAliases() {
            List<ProtoBuf.TypeAlias> list = this.typeAliasList;
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            ArrayList arrayList = new ArrayList();
            for (MessageLite messageLite : list) {
                TypeAliasDescriptor loadTypeAlias = deserializedMemberScope.f17407c.getMemberDeserializer().loadTypeAlias((ProtoBuf.TypeAlias) messageLite);
                if (loadTypeAlias != null) {
                    arrayList.add(loadTypeAlias);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> getAllFunctions() {
            return (List) StorageKt.getValue(this.allFunctions$delegate, this, $$delegatedProperties[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PropertyDescriptor> getAllProperties() {
            return (List) StorageKt.getValue(this.allProperties$delegate, this, $$delegatedProperties[4]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<TypeAliasDescriptor> getAllTypeAliases() {
            return (List) StorageKt.getValue(this.allTypeAliases$delegate, this, $$delegatedProperties[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> getDeclaredFunctions() {
            return (List) StorageKt.getValue(this.declaredFunctions$delegate, this, $$delegatedProperties[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PropertyDescriptor> getDeclaredProperties() {
            return (List) StorageKt.getValue(this.declaredProperties$delegate, this, $$delegatedProperties[1]);
        }

        private final Map<Name, Collection<SimpleFunctionDescriptor>> getFunctionsByName() {
            return (Map) StorageKt.getValue(this.functionsByName$delegate, this, $$delegatedProperties[6]);
        }

        private final Map<Name, Collection<PropertyDescriptor>> getPropertiesByName() {
            return (Map) StorageKt.getValue(this.propertiesByName$delegate, this, $$delegatedProperties[7]);
        }

        private final Map<Name, TypeAliasDescriptor> getTypeAliasesByName() {
            return (Map) StorageKt.getValue(this.typeAliasesByName$delegate, this, $$delegatedProperties[5]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> result, DescriptorKindFilter kindFilter, l<? super Name, Boolean> nameFilter, LookupLocation location) {
            kotlin.jvm.internal.m.g(result, "result");
            kotlin.jvm.internal.m.g(kindFilter, "kindFilter");
            kotlin.jvm.internal.m.g(nameFilter, "nameFilter");
            kotlin.jvm.internal.m.g(location, "location");
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                for (Object obj : getAllProperties()) {
                    Name name = ((PropertyDescriptor) obj).getName();
                    kotlin.jvm.internal.m.f(name, "it.name");
                    if (nameFilter.invoke(name).booleanValue()) {
                        result.add(obj);
                    }
                }
            }
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                for (Object obj2 : getAllFunctions()) {
                    Name name2 = ((SimpleFunctionDescriptor) obj2).getName();
                    kotlin.jvm.internal.m.f(name2, "it.name");
                    if (nameFilter.invoke(name2).booleanValue()) {
                        result.add(obj2);
                    }
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
            List g2;
            List g3;
            kotlin.jvm.internal.m.g(name, "name");
            kotlin.jvm.internal.m.g(location, "location");
            if (!getFunctionNames().contains(name)) {
                g3 = r.g();
                return g3;
            }
            Collection<SimpleFunctionDescriptor> collection = getFunctionsByName().get(name);
            if (collection != null) {
                return collection;
            }
            g2 = r.g();
            return g2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
            List g2;
            List g3;
            kotlin.jvm.internal.m.g(name, "name");
            kotlin.jvm.internal.m.g(location, "location");
            if (!getVariableNames().contains(name)) {
                g3 = r.g();
                return g3;
            }
            Collection<PropertyDescriptor> collection = getPropertiesByName().get(name);
            if (collection != null) {
                return collection;
            }
            g2 = r.g();
            return g2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            kotlin.jvm.internal.m.g(name, "name");
            return getTypeAliasesByName().get(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            List<ProtoBuf.TypeAlias> list = this.typeAliasList;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            for (MessageLite messageLite : list) {
                linkedHashSet.add(NameResolverUtilKt.getName(deserializedMemberScope.f17407c.getNameResolver(), ((ProtoBuf.TypeAlias) messageLite).getName()));
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[9]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: classes3.dex */
    public final class OptimizedImplementation implements Implementation {
        static final /* synthetic */ m<Object>[] $$delegatedProperties = {e0.h(new x(e0.b(OptimizedImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), e0.h(new x(e0.b(OptimizedImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        private final NotNullLazyValue functionNames$delegate;
        private final Map<Name, byte[]> functionProtosBytes;
        private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
        private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
        private final Map<Name, byte[]> propertyProtosBytes;
        final /* synthetic */ DeserializedMemberScope this$0;
        private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
        private final Map<Name, byte[]> typeAliasBytes;
        private final NotNullLazyValue variableNames$delegate;

        public OptimizedImplementation(DeserializedMemberScope this$0, List<ProtoBuf.Function> functionList, List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            Map<Name, byte[]> i2;
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(functionList, "functionList");
            kotlin.jvm.internal.m.g(propertyList, "propertyList");
            kotlin.jvm.internal.m.g(typeAliasList, "typeAliasList");
            this.this$0 = this$0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : functionList) {
                Name name = NameResolverUtilKt.getName(this$0.f17407c.getNameResolver(), ((ProtoBuf.Function) ((MessageLite) obj)).getName());
                Object obj2 = linkedHashMap.get(name);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(name, obj2);
                }
                ((List) obj2).add(obj);
            }
            this.functionProtosBytes = packToByteArray(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : propertyList) {
                Name name2 = NameResolverUtilKt.getName(deserializedMemberScope.f17407c.getNameResolver(), ((ProtoBuf.Property) ((MessageLite) obj3)).getName());
                Object obj4 = linkedHashMap2.get(name2);
                if (obj4 == null) {
                    obj4 = new ArrayList();
                    linkedHashMap2.put(name2, obj4);
                }
                ((List) obj4).add(obj3);
            }
            this.propertyProtosBytes = packToByteArray(linkedHashMap2);
            if (this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed()) {
                DeserializedMemberScope deserializedMemberScope2 = this.this$0;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj5 : typeAliasList) {
                    Name name3 = NameResolverUtilKt.getName(deserializedMemberScope2.f17407c.getNameResolver(), ((ProtoBuf.TypeAlias) ((MessageLite) obj5)).getName());
                    Object obj6 = linkedHashMap3.get(name3);
                    if (obj6 == null) {
                        obj6 = new ArrayList();
                        linkedHashMap3.put(name3, obj6);
                    }
                    ((List) obj6).add(obj5);
                }
                i2 = packToByteArray(linkedHashMap3);
            } else {
                i2 = m0.i();
            }
            this.typeAliasBytes = i2;
            this.functions = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$functions$1(this));
            this.properties = this.this$0.getC().getStorageManager().createMemoizedFunction(new DeserializedMemberScope$OptimizedImplementation$properties$1(this));
            this.typeAliasByName = this.this$0.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1(this));
            this.functionNames$delegate = this.this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$functionNames$2(this, this.this$0));
            this.variableNames$delegate = this.this$0.getC().getStorageManager().createLazyValue(new DeserializedMemberScope$OptimizedImplementation$variableNames$2(this, this.this$0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<SimpleFunctionDescriptor> computeFunctions(Name name) {
            h h2;
            List<ProtoBuf.Function> B;
            Map<Name, byte[]> map = this.functionProtosBytes;
            Parser<ProtoBuf.Function> PARSER = ProtoBuf.Function.PARSER;
            kotlin.jvm.internal.m.f(PARSER, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            byte[] bArr = map.get(name);
            if (bArr == null) {
                B = null;
            } else {
                h2 = n.h(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(PARSER, new ByteArrayInputStream(bArr), this.this$0));
                B = p.B(h2);
            }
            if (B == null) {
                B = r.g();
            }
            ArrayList arrayList = new ArrayList(B.size());
            for (ProtoBuf.Function it : B) {
                MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                kotlin.jvm.internal.m.f(it, "it");
                SimpleFunctionDescriptor loadFunction = memberDeserializer.loadFunction(it);
                if (!deserializedMemberScope.isDeclaredFunctionAvailable(loadFunction)) {
                    loadFunction = null;
                }
                if (loadFunction != null) {
                    arrayList.add(loadFunction);
                }
            }
            deserializedMemberScope.computeNonDeclaredFunctions(name, arrayList);
            return CollectionsKt.compact(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<PropertyDescriptor> computeProperties(Name name) {
            h h2;
            List<ProtoBuf.Property> B;
            Map<Name, byte[]> map = this.propertyProtosBytes;
            Parser<ProtoBuf.Property> PARSER = ProtoBuf.Property.PARSER;
            kotlin.jvm.internal.m.f(PARSER, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.this$0;
            byte[] bArr = map.get(name);
            if (bArr == null) {
                B = null;
            } else {
                h2 = n.h(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(PARSER, new ByteArrayInputStream(bArr), this.this$0));
                B = p.B(h2);
            }
            if (B == null) {
                B = r.g();
            }
            ArrayList arrayList = new ArrayList(B.size());
            for (ProtoBuf.Property it : B) {
                MemberDeserializer memberDeserializer = deserializedMemberScope.getC().getMemberDeserializer();
                kotlin.jvm.internal.m.f(it, "it");
                PropertyDescriptor loadProperty = memberDeserializer.loadProperty(it);
                if (loadProperty != null) {
                    arrayList.add(loadProperty);
                }
            }
            deserializedMemberScope.computeNonDeclaredProperties(name, arrayList);
            return CollectionsKt.compact(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TypeAliasDescriptor createTypeAlias(Name name) {
            ProtoBuf.TypeAlias parseDelimitedFrom;
            byte[] bArr = this.typeAliasBytes.get(name);
            if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.this$0.getC().getComponents().getExtensionRegistryLite())) == null) {
                return null;
            }
            return this.this$0.getC().getMemberDeserializer().loadTypeAlias(parseDelimitedFrom);
        }

        private final Map<Name, byte[]> packToByteArray(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) {
            int d2;
            int r;
            d2 = l0.d(map.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(d2);
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<AbstractMessageLite> iterable = (Iterable) entry.getValue();
                r = s.r(iterable, 10);
                ArrayList arrayList = new ArrayList(r);
                for (AbstractMessageLite abstractMessageLite : iterable) {
                    abstractMessageLite.writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(kotlin.x.a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> result, DescriptorKindFilter kindFilter, l<? super Name, Boolean> nameFilter, LookupLocation location) {
            kotlin.jvm.internal.m.g(result, "result");
            kotlin.jvm.internal.m.g(kindFilter, "kindFilter");
            kotlin.jvm.internal.m.g(nameFilter, "nameFilter");
            kotlin.jvm.internal.m.g(location, "location");
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
                Set<Name> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (Name name : variableNames) {
                    if (nameFilter.invoke(name).booleanValue()) {
                        arrayList.addAll(getContributedVariables(name, location));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator INSTANCE = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                kotlin.jvm.internal.m.f(INSTANCE, "INSTANCE");
                v.x(arrayList, INSTANCE);
                result.addAll(arrayList);
            }
            if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
                Set<Name> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (Name name2 : functionNames) {
                    if (nameFilter.invoke(name2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(name2, location));
                    }
                }
                MemberComparator.NameAndTypeMemberComparator INSTANCE2 = MemberComparator.NameAndTypeMemberComparator.INSTANCE;
                kotlin.jvm.internal.m.f(INSTANCE2, "INSTANCE");
                v.x(arrayList2, INSTANCE2);
                result.addAll(arrayList2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
            List g2;
            kotlin.jvm.internal.m.g(name, "name");
            kotlin.jvm.internal.m.g(location, "location");
            if (getFunctionNames().contains(name)) {
                return this.functions.invoke(name);
            }
            g2 = r.g();
            return g2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
            List g2;
            kotlin.jvm.internal.m.g(name, "name");
            kotlin.jvm.internal.m.g(location, "location");
            if (getVariableNames().contains(name)) {
                return this.properties.invoke(name);
            }
            g2 = r.g();
            return g2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getFunctionNames() {
            return (Set) StorageKt.getValue(this.functionNames$delegate, this, $$delegatedProperties[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            kotlin.jvm.internal.m.g(name, "name");
            return this.typeAliasByName.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getTypeAliasNames() {
            return this.typeAliasBytes.keySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public Set<Name> getVariableNames() {
            return (Set) StorageKt.getValue(this.variableNames$delegate, this, $$delegatedProperties[1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DeserializedMemberScope(DeserializationContext c2, List<ProtoBuf.Function> functionList, List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList, a<? extends Collection<Name>> classNames) {
        kotlin.jvm.internal.m.g(c2, "c");
        kotlin.jvm.internal.m.g(functionList, "functionList");
        kotlin.jvm.internal.m.g(propertyList, "propertyList");
        kotlin.jvm.internal.m.g(typeAliasList, "typeAliasList");
        kotlin.jvm.internal.m.g(classNames, "classNames");
        this.f17407c = c2;
        this.impl = createImplementation(functionList, propertyList, typeAliasList);
        this.classNames$delegate = c2.getStorageManager().createLazyValue(new DeserializedMemberScope$classNames$2(classNames));
        this.classifierNamesLazy$delegate = c2.getStorageManager().createNullableLazyValue(new DeserializedMemberScope$classifierNamesLazy$2(this));
    }

    private final Implementation createImplementation(List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
        if (this.f17407c.getComponents().getConfiguration().getPreserveDeclarationsOrdering()) {
            return new NoReorderImplementation(this, list, list2, list3);
        }
        return new OptimizedImplementation(this, list, list2, list3);
    }

    private final ClassDescriptor deserializeClass(Name name) {
        return this.f17407c.getComponents().deserializeClass(createClassId(name));
    }

    private final Set<Name> getClassifierNamesLazy() {
        return (Set) StorageKt.getValue(this.classifierNamesLazy$delegate, this, $$delegatedProperties[1]);
    }

    private final TypeAliasDescriptor getTypeAliasByName(Name name) {
        return this.impl.getTypeAliasByName(name);
    }

    protected abstract void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, l<? super Name, Boolean> lVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<DeclarationDescriptor> computeDescriptors(DescriptorKindFilter kindFilter, l<? super Name, Boolean> nameFilter, LookupLocation location) {
        kotlin.jvm.internal.m.g(kindFilter, "kindFilter");
        kotlin.jvm.internal.m.g(nameFilter, "nameFilter");
        kotlin.jvm.internal.m.g(location, "location");
        ArrayList arrayList = new ArrayList(0);
        DescriptorKindFilter.Companion companion = DescriptorKindFilter.Companion;
        if (kindFilter.acceptsKinds(companion.getSINGLETON_CLASSIFIERS_MASK())) {
            addEnumEntryDescriptors(arrayList, nameFilter);
        }
        this.impl.addFunctionsAndPropertiesTo(arrayList, kindFilter, nameFilter, location);
        if (kindFilter.acceptsKinds(companion.getCLASSIFIERS_MASK())) {
            for (Name name : getClassNames$deserialization()) {
                if (nameFilter.invoke(name).booleanValue()) {
                    CollectionsKt.addIfNotNull(arrayList, deserializeClass(name));
                }
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name name2 : this.impl.getTypeAliasNames()) {
                if (nameFilter.invoke(name2).booleanValue()) {
                    CollectionsKt.addIfNotNull(arrayList, this.impl.getTypeAliasByName(name2));
                }
            }
        }
        return CollectionsKt.compact(arrayList);
    }

    protected void computeNonDeclaredFunctions(Name name, List<SimpleFunctionDescriptor> functions) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(functions, "functions");
    }

    protected void computeNonDeclaredProperties(Name name, List<PropertyDescriptor> descriptors) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(descriptors, "descriptors");
    }

    protected abstract ClassId createClassId(Name name);

    /* JADX INFO: Access modifiers changed from: protected */
    public final DeserializationContext getC() {
        return this.f17407c;
    }

    public final Set<Name> getClassNames$deserialization() {
        return (Set) StorageKt.getValue(this.classNames$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return getClassifierNamesLazy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo2216getContributedClassifier(Name name, LookupLocation location) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(location, "location");
        if (hasClass(name)) {
            return deserializeClass(name);
        }
        if (this.impl.getTypeAliasNames().contains(name)) {
            return getTypeAliasByName(name);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(location, "location");
        return this.impl.getContributedFunctions(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(location, "location");
        return this.impl.getContributedVariables(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.impl.getFunctionNames();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Set<Name> getNonDeclaredClassifierNames();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Set<Name> getNonDeclaredFunctionNames();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Set<Name> getNonDeclaredVariableNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.impl.getVariableNames();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasClass(Name name) {
        kotlin.jvm.internal.m.g(name, "name");
        return getClassNames$deserialization().contains(name);
    }

    protected boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor function) {
        kotlin.jvm.internal.m.g(function, "function");
        return true;
    }
}