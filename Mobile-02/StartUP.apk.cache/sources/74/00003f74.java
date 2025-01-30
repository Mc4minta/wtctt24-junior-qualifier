package com.squareup.moshi.kotlin.reflect;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.internal.Util;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.j0.g;
import kotlin.j0.j;
import kotlin.j0.l;
import kotlin.j0.o;
import kotlin.jvm.internal.m;

/* compiled from: KotlinJsonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002%&BW\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\u001c\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00160\u0015\u0012\u001a\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00160\u0015\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R-\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00160\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR/\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00160\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter;", "T", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/JsonReader;", "reader", "fromJson", "(Lcom/squareup/moshi/JsonReader;)Ljava/lang/Object;", "Lcom/squareup/moshi/JsonWriter;", "writer", "value", "Lkotlin/x;", "toJson", "(Lcom/squareup/moshi/JsonWriter;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lcom/squareup/moshi/JsonReader$Options;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "getOptions", "()Lcom/squareup/moshi/JsonReader$Options;", "", "Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "", "nonTransientBindings", "Ljava/util/List;", "getNonTransientBindings", "()Ljava/util/List;", "allBindings", "getAllBindings", "Lkotlin/j0/g;", "constructor", "Lkotlin/j0/g;", "getConstructor", "()Lkotlin/j0/g;", "<init>", "(Lkotlin/j0/g;Ljava/util/List;Ljava/util/List;Lcom/squareup/moshi/JsonReader$Options;)V", "Binding", "IndexedParameterMap", "reflect"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class KotlinJsonAdapter<T> extends JsonAdapter<T> {
    private final List<Binding<T, Object>> allBindings;
    private final g<T> constructor;
    private final List<Binding<T, Object>> nonTransientBindings;
    private final JsonReader.Options options;

    /* compiled from: KotlinJsonAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u0003BM\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010 \u001a\u00020\u0018¢\u0006\u0004\b4\u00105J\u0015\u0010\u0005\u001a\u00028\u00022\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJn\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010 \u001a\u00020\u0018HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010\rJ\u0010\u0010$\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b$\u0010\u001aJ\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b'\u0010(R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010)\u001a\u0004\b*\u0010\u0017R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b,\u0010\rR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010\u0011R\u0019\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b/\u0010\rR\u0019\u0010 \u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b1\u0010\u001aR%\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b3\u0010\u0014¨\u00066"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "K", "P", "", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "result", "Lkotlin/x;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/squareup/moshi/JsonAdapter;", "component3", "()Lcom/squareup/moshi/JsonAdapter;", "Lkotlin/j0/o;", "component4", "()Lkotlin/j0/o;", "Lkotlin/j0/l;", "component5", "()Lkotlin/j0/l;", "", "component6", "()I", ApiConstants.NAME, "jsonName", "adapter", "property", "parameter", "propertyIndex", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/squareup/moshi/JsonAdapter;Lkotlin/j0/o;Lkotlin/j0/l;I)Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$Binding;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/j0/l;", "getParameter", "Ljava/lang/String;", "getJsonName", "Lcom/squareup/moshi/JsonAdapter;", "getAdapter", "getName", "I", "getPropertyIndex", "Lkotlin/j0/o;", "getProperty", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/squareup/moshi/JsonAdapter;Lkotlin/j0/o;Lkotlin/j0/l;I)V", "reflect"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes2.dex */
    public static final class Binding<K, P> {
        private final JsonAdapter<P> adapter;
        private final String jsonName;
        private final String name;
        private final l parameter;
        private final o<K, P> property;
        private final int propertyIndex;

        /* JADX WARN: Multi-variable type inference failed */
        public Binding(String name, String str, JsonAdapter<P> adapter, o<K, ? extends P> property, l lVar, int i2) {
            m.g(name, "name");
            m.g(adapter, "adapter");
            m.g(property, "property");
            this.name = name;
            this.jsonName = str;
            this.adapter = adapter;
            this.property = property;
            this.parameter = lVar;
            this.propertyIndex = i2;
        }

        public static /* synthetic */ Binding copy$default(Binding binding, String str, String str2, JsonAdapter jsonAdapter, o oVar, l lVar, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = binding.name;
            }
            if ((i3 & 2) != 0) {
                str2 = binding.jsonName;
            }
            String str3 = str2;
            JsonAdapter<P> jsonAdapter2 = jsonAdapter;
            if ((i3 & 4) != 0) {
                jsonAdapter2 = binding.adapter;
            }
            JsonAdapter jsonAdapter3 = jsonAdapter2;
            o<K, P> oVar2 = oVar;
            if ((i3 & 8) != 0) {
                oVar2 = binding.property;
            }
            o oVar3 = oVar2;
            if ((i3 & 16) != 0) {
                lVar = binding.parameter;
            }
            l lVar2 = lVar;
            if ((i3 & 32) != 0) {
                i2 = binding.propertyIndex;
            }
            return binding.copy(str, str3, jsonAdapter3, oVar3, lVar2, i2);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.jsonName;
        }

        public final JsonAdapter<P> component3() {
            return this.adapter;
        }

        public final o<K, P> component4() {
            return this.property;
        }

        public final l component5() {
            return this.parameter;
        }

        public final int component6() {
            return this.propertyIndex;
        }

        public final Binding<K, P> copy(String name, String str, JsonAdapter<P> adapter, o<K, ? extends P> property, l lVar, int i2) {
            m.g(name, "name");
            m.g(adapter, "adapter");
            m.g(property, "property");
            return new Binding<>(name, str, adapter, property, lVar, i2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Binding) {
                    Binding binding = (Binding) obj;
                    return m.c(this.name, binding.name) && m.c(this.jsonName, binding.jsonName) && m.c(this.adapter, binding.adapter) && m.c(this.property, binding.property) && m.c(this.parameter, binding.parameter) && this.propertyIndex == binding.propertyIndex;
                }
                return false;
            }
            return true;
        }

        public final P get(K k2) {
            return this.property.get(k2);
        }

        public final JsonAdapter<P> getAdapter() {
            return this.adapter;
        }

        public final String getJsonName() {
            return this.jsonName;
        }

        public final String getName() {
            return this.name;
        }

        public final l getParameter() {
            return this.parameter;
        }

        public final o<K, P> getProperty() {
            return this.property;
        }

        public final int getPropertyIndex() {
            return this.propertyIndex;
        }

        public int hashCode() {
            String str = this.name;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.jsonName;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            JsonAdapter<P> jsonAdapter = this.adapter;
            int hashCode3 = (hashCode2 + (jsonAdapter != null ? jsonAdapter.hashCode() : 0)) * 31;
            o<K, P> oVar = this.property;
            int hashCode4 = (hashCode3 + (oVar != null ? oVar.hashCode() : 0)) * 31;
            l lVar = this.parameter;
            return ((hashCode4 + (lVar != null ? lVar.hashCode() : 0)) * 31) + this.propertyIndex;
        }

        public final void set(K k2, P p) {
            Object obj;
            obj = KotlinJsonAdapterKt.ABSENT_VALUE;
            if (p != obj) {
                o<K, P> oVar = this.property;
                Objects.requireNonNull(oVar, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty1<K, P>");
                ((j) oVar).set(k2, p);
            }
        }

        public String toString() {
            return "Binding(name=" + this.name + ", jsonName=" + this.jsonName + ", adapter=" + this.adapter + ", property=" + this.property + ", parameter=" + this.parameter + ", propertyIndex=" + this.propertyIndex + ")";
        }
    }

    /* compiled from: KotlinJsonAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0006\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R*\u0010\u0017\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00140\u00138V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapter$IndexedParameterMap;", "Lkotlin/a0/g;", "Lkotlin/j0/l;", "", "key", "value", "put", "(Lkotlin/j0/l;Ljava/lang/Object;)Ljava/lang/Object;", "", "containsKey", "(Lkotlin/j0/l;)Z", "get", "(Lkotlin/j0/l;)Ljava/lang/Object;", "", "parameterKeys", "Ljava/util/List;", "", "parameterValues", "[Ljava/lang/Object;", "", "", "getEntries", "()Ljava/util/Set;", "entries", "<init>", "(Ljava/util/List;[Ljava/lang/Object;)V", "reflect"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes2.dex */
    public static final class IndexedParameterMap extends kotlin.a0.g<l, Object> {
        private final List<l> parameterKeys;
        private final Object[] parameterValues;

        /* JADX WARN: Multi-variable type inference failed */
        public IndexedParameterMap(List<? extends l> parameterKeys, Object[] parameterValues) {
            m.g(parameterKeys, "parameterKeys");
            m.g(parameterValues, "parameterValues");
            this.parameterKeys = parameterKeys;
            this.parameterValues = parameterValues;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof l) {
                return containsKey((l) obj);
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof l) {
                return get((l) obj);
            }
            return null;
        }

        @Override // kotlin.a0.g
        public Set<Map.Entry<l, Object>> getEntries() {
            int r;
            Object obj;
            List<l> list = this.parameterKeys;
            r = s.r(list, 10);
            ArrayList arrayList = new ArrayList(r);
            int i2 = 0;
            for (T t : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    r.q();
                }
                arrayList.add(new AbstractMap.SimpleEntry((l) t, this.parameterValues[i2]));
                i2 = i3;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t2 : arrayList) {
                Object value = ((AbstractMap.SimpleEntry) t2).getValue();
                obj = KotlinJsonAdapterKt.ABSENT_VALUE;
                if (value != obj) {
                    linkedHashSet.add(t2);
                }
            }
            return linkedHashSet;
        }

        @Override // java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return obj instanceof l ? getOrDefault((l) obj, obj2) : obj2;
        }

        @Override // kotlin.a0.g, java.util.AbstractMap, java.util.Map
        public Object put(l key, Object obj) {
            m.g(key, "key");
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof l) {
                return remove((l) obj);
            }
            return null;
        }

        public boolean containsKey(l key) {
            Object obj;
            m.g(key, "key");
            Object obj2 = this.parameterValues[key.getIndex()];
            obj = KotlinJsonAdapterKt.ABSENT_VALUE;
            return obj2 != obj;
        }

        public Object get(l key) {
            Object obj;
            m.g(key, "key");
            Object obj2 = this.parameterValues[key.getIndex()];
            obj = KotlinJsonAdapterKt.ABSENT_VALUE;
            if (obj2 != obj) {
                return obj2;
            }
            return null;
        }

        public /* bridge */ Object getOrDefault(l lVar, Object obj) {
            return super.getOrDefault((Object) lVar, (l) obj);
        }

        public /* bridge */ Object remove(l lVar) {
            return super.remove((Object) lVar);
        }

        @Override // java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (obj instanceof l) {
                return remove((l) obj, obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(l lVar, Object obj) {
            return super.remove((Object) lVar, obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KotlinJsonAdapter(g<? extends T> constructor, List<Binding<T, Object>> allBindings, List<Binding<T, Object>> nonTransientBindings, JsonReader.Options options) {
        m.g(constructor, "constructor");
        m.g(allBindings, "allBindings");
        m.g(nonTransientBindings, "nonTransientBindings");
        m.g(options, "options");
        this.constructor = constructor;
        this.allBindings = allBindings;
        this.nonTransientBindings = nonTransientBindings;
        this.options = options;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public T fromJson(JsonReader reader) {
        T callBy;
        Object obj;
        Object obj2;
        Object obj3;
        m.g(reader, "reader");
        int size = this.constructor.getParameters().size();
        int size2 = this.allBindings.size();
        Object[] objArr = new Object[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            obj3 = KotlinJsonAdapterKt.ABSENT_VALUE;
            objArr[i2] = obj3;
        }
        reader.beginObject();
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else {
                Binding<T, Object> binding = this.nonTransientBindings.get(selectName);
                int propertyIndex = binding.getPropertyIndex();
                Object obj4 = objArr[propertyIndex];
                obj2 = KotlinJsonAdapterKt.ABSENT_VALUE;
                if (obj4 == obj2) {
                    objArr[propertyIndex] = binding.getAdapter().fromJson(reader);
                    if (objArr[propertyIndex] == null && !binding.getProperty().getReturnType().isMarkedNullable()) {
                        JsonDataException unexpectedNull = Util.unexpectedNull(binding.getProperty().getName(), binding.getJsonName(), reader);
                        m.f(unexpectedNull, "Util.unexpectedNull(\n   …         reader\n        )");
                        throw unexpectedNull;
                    }
                } else {
                    throw new JsonDataException("Multiple values for '" + binding.getProperty().getName() + "' at " + reader.getPath());
                }
            }
        }
        reader.endObject();
        boolean z = this.allBindings.size() == size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj5 = objArr[i3];
            obj = KotlinJsonAdapterKt.ABSENT_VALUE;
            if (obj5 == obj) {
                if (this.constructor.getParameters().get(i3).isOptional()) {
                    z = false;
                } else {
                    if (!this.constructor.getParameters().get(i3).getType().isMarkedNullable()) {
                        String name = this.constructor.getParameters().get(i3).getName();
                        Binding<T, Object> binding2 = this.allBindings.get(i3);
                        JsonDataException missingProperty = Util.missingProperty(name, binding2 != null ? binding2.getJsonName() : null, reader);
                        m.f(missingProperty, "Util.missingProperty(\n  …       reader\n          )");
                        throw missingProperty;
                    }
                    objArr[i3] = null;
                }
            }
        }
        if (z) {
            callBy = this.constructor.call(Arrays.copyOf(objArr, size2));
        } else {
            callBy = this.constructor.callBy(new IndexedParameterMap(this.constructor.getParameters(), objArr));
        }
        int size3 = this.allBindings.size();
        while (size < size3) {
            Binding<T, Object> binding3 = this.allBindings.get(size);
            m.e(binding3);
            binding3.set(callBy, objArr[size]);
            size++;
        }
        return callBy;
    }

    public final List<Binding<T, Object>> getAllBindings() {
        return this.allBindings;
    }

    public final g<T> getConstructor() {
        return this.constructor;
    }

    public final List<Binding<T, Object>> getNonTransientBindings() {
        return this.nonTransientBindings;
    }

    public final JsonReader.Options getOptions() {
        return this.options;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, T t) {
        m.g(writer, "writer");
        Objects.requireNonNull(t, "value == null");
        writer.beginObject();
        for (Binding<T, Object> binding : this.allBindings) {
            if (binding != null) {
                writer.name(binding.getName());
                binding.getAdapter().toJson(writer, (JsonWriter) binding.get(t));
            }
        }
        writer.endObject();
    }

    public String toString() {
        return "KotlinJsonAdapter(" + this.constructor.getReturnType() + ')';
    }
}