package com.squareup.moshi.kotlin.reflect;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import com.squareup.moshi._MoshiKotlinTypesExtensionsKt;
import com.squareup.moshi.internal.Util;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.a0.s;
import kotlin.a0.w;
import kotlin.a0.z;
import kotlin.e0.a;
import kotlin.i0.f;
import kotlin.j0.b0.c;
import kotlin.j0.d;
import kotlin.j0.g;
import kotlin.j0.j;
import kotlin.j0.l;
import kotlin.j0.o;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.m;

/* compiled from: KotlinJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "Ljava/lang/reflect/Type;", "type", "", "", "annotations", "Lcom/squareup/moshi/Moshi;", "moshi", "Lcom/squareup/moshi/JsonAdapter;", "create", "(Ljava/lang/reflect/Type;Ljava/util/Set;Lcom/squareup/moshi/Moshi;)Lcom/squareup/moshi/JsonAdapter;", "<init>", "()V", "reflect"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class KotlinJsonAdapterFactory implements JsonAdapter.Factory {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.lang.Object] */
    @Override // com.squareup.moshi.JsonAdapter.Factory
    public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
        Class<? extends Annotation> cls;
        int r;
        int d2;
        int b2;
        List<KotlinJsonAdapter.Binding> V;
        int r2;
        List K0;
        Object obj;
        String name;
        String name2;
        ?? r14;
        m.g(type, "type");
        m.g(annotations, "annotations");
        m.g(moshi, "moshi");
        boolean z = true;
        Object obj2 = null;
        if (!annotations.isEmpty()) {
            return null;
        }
        Class<?> rawType = _MoshiKotlinTypesExtensionsKt.getRawType(type);
        if (rawType.isInterface() || rawType.isEnum()) {
            return null;
        }
        cls = KotlinJsonAdapterKt.KOTLIN_METADATA;
        if (rawType.isAnnotationPresent(cls) && !Util.isPlatformType(rawType)) {
            try {
                JsonAdapter<?> generatedAdapter = Util.generatedAdapter(moshi, type, rawType);
                if (generatedAdapter != null) {
                    return generatedAdapter;
                }
            } catch (RuntimeException e2) {
                if (!(e2.getCause() instanceof ClassNotFoundException)) {
                    throw e2;
                }
            }
            if (!rawType.isLocalClass()) {
                d e3 = a.e(rawType);
                if (!e3.isAbstract()) {
                    if (!e3.isInner()) {
                        if (e3.getObjectInstance() == null) {
                            if (!e3.isSealed()) {
                                g b3 = kotlin.reflect.full.a.b(e3);
                                if (b3 != null) {
                                    List<l> parameters = b3.getParameters();
                                    r = s.r(parameters, 10);
                                    d2 = l0.d(r);
                                    b2 = f.b(d2, 16);
                                    LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
                                    for (Object obj3 : parameters) {
                                        linkedHashMap.put(((l) obj3).getName(), obj3);
                                    }
                                    kotlin.j0.b0.a.a(b3, true);
                                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                    for (o oVar : kotlin.reflect.full.a.a(e3)) {
                                        l lVar = (l) linkedHashMap.get(oVar.getName());
                                        Field b4 = c.b(oVar);
                                        if (Modifier.isTransient(b4 != null ? b4.getModifiers() : 0)) {
                                            if (!((lVar == null || lVar.isOptional()) ? z : false)) {
                                                throw new IllegalArgumentException(("No default value for transient constructor " + lVar).toString());
                                            }
                                        } else if ((lVar == null || m.c(lVar.getType(), oVar.getReturnType())) ? z : false) {
                                            if ((oVar instanceof j) || lVar != null) {
                                                kotlin.j0.b0.a.a(oVar, z);
                                                K0 = z.K0(oVar.getAnnotations());
                                                Iterator it = oVar.getAnnotations().iterator();
                                                while (true) {
                                                    if (!it.hasNext()) {
                                                        obj = obj2;
                                                        break;
                                                    }
                                                    obj = it.next();
                                                    if (((Annotation) obj) instanceof Json) {
                                                        break;
                                                    }
                                                }
                                                Json json = (Json) obj;
                                                if (lVar != null) {
                                                    w.y(K0, lVar.getAnnotations());
                                                    if (json == null) {
                                                        Iterator it2 = lVar.getAnnotations().iterator();
                                                        while (true) {
                                                            if (!it2.hasNext()) {
                                                                r14 = 0;
                                                                break;
                                                            }
                                                            r14 = it2.next();
                                                            if (((Annotation) r14) instanceof Json) {
                                                                break;
                                                            }
                                                        }
                                                        json = r14;
                                                    }
                                                }
                                                if (json == null || (name = json.name()) == null) {
                                                    name = oVar.getName();
                                                }
                                                String str = name;
                                                Type resolve = Util.resolve(type, rawType, c.f(oVar.getReturnType()));
                                                Object[] array = K0.toArray(new Annotation[0]);
                                                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                                                JsonAdapter adapter = moshi.adapter(resolve, Util.jsonAnnotations((Annotation[]) array), oVar.getName());
                                                String name3 = oVar.getName();
                                                String str2 = (json == null || (name2 = json.name()) == null) ? str : name2;
                                                m.f(adapter, "adapter");
                                                linkedHashMap2.put(name3, new KotlinJsonAdapter.Binding(str, str2, adapter, oVar, lVar, lVar != null ? lVar.getIndex() : -1));
                                            }
                                        } else {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append('\'');
                                            sb.append(oVar.getName());
                                            sb.append("' has a constructor parameter of type ");
                                            m.e(lVar);
                                            sb.append(lVar.getType());
                                            sb.append(" but a property of type ");
                                            sb.append(oVar.getReturnType());
                                            sb.append('.');
                                            throw new IllegalArgumentException(sb.toString().toString());
                                        }
                                        z = true;
                                        obj2 = null;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    for (l lVar2 : b3.getParameters()) {
                                        KotlinJsonAdapter.Binding binding = (KotlinJsonAdapter.Binding) i0.d(linkedHashMap2).remove(lVar2.getName());
                                        if (binding != null || lVar2.isOptional()) {
                                            arrayList.add(binding);
                                        } else {
                                            throw new IllegalArgumentException(("No property for required constructor " + lVar2).toString());
                                        }
                                    }
                                    int size = arrayList.size();
                                    Iterator it3 = linkedHashMap2.entrySet().iterator();
                                    while (true) {
                                        int i2 = size;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        size = i2 + 1;
                                        arrayList.add(KotlinJsonAdapter.Binding.copy$default((KotlinJsonAdapter.Binding) ((Map.Entry) it3.next()).getValue(), null, null, null, null, null, i2, 31, null));
                                    }
                                    V = z.V(arrayList);
                                    r2 = s.r(V, 10);
                                    ArrayList arrayList2 = new ArrayList(r2);
                                    for (KotlinJsonAdapter.Binding binding2 : V) {
                                        arrayList2.add(binding2.getName());
                                    }
                                    Object[] array2 = arrayList2.toArray(new String[0]);
                                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                                    String[] strArr = (String[]) array2;
                                    JsonReader.Options options = JsonReader.Options.of((String[]) Arrays.copyOf(strArr, strArr.length));
                                    m.f(options, "options");
                                    return new KotlinJsonAdapter(b3, arrayList, V, options).nullSafe();
                                }
                                return null;
                            }
                            throw new IllegalArgumentException(("Cannot reflectively serialize sealed class " + rawType.getName() + ". Please register an adapter.").toString());
                        }
                        throw new IllegalArgumentException(("Cannot serialize object declaration " + rawType.getName()).toString());
                    }
                    throw new IllegalArgumentException(("Cannot serialize inner class " + rawType.getName()).toString());
                }
                throw new IllegalArgumentException(("Cannot serialize abstract class " + rawType.getName()).toString());
            }
            throw new IllegalArgumentException(("Cannot serialize local class or object expression " + rawType.getName()).toString());
        }
        return null;
    }
}