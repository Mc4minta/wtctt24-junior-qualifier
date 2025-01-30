package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a0.e0;
import kotlin.a0.l0;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.s0;
import kotlin.a0.z;
import kotlin.i0.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.x;

/* compiled from: JvmNameResolver.kt */
/* loaded from: classes3.dex */
public final class JvmNameResolver implements NameResolver {
    public static final Companion Companion;
    private static final List<String> PREDEFINED_STRINGS;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f17403kotlin;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;
    private final JvmProtoBuf.StringTableTypes types;

    /* compiled from: JvmNameResolver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<String> getPREDEFINED_STRINGS() {
            return JvmNameResolver.PREDEFINED_STRINGS;
        }
    }

    /* compiled from: JvmNameResolver.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        List j2;
        String h0;
        List<String> j3;
        Iterable<e0> P0;
        int r;
        int d2;
        int b2;
        Companion companion = new Companion(null);
        Companion = companion;
        j2 = r.j('k', 'o', 't', 'l', 'i', 'n');
        h0 = z.h0(j2, "", null, null, 0, null, null, 62, null);
        f17403kotlin = h0;
        j3 = r.j(m.o(h0, "/Any"), m.o(h0, "/Nothing"), m.o(h0, "/Unit"), m.o(h0, "/Throwable"), m.o(h0, "/Number"), m.o(h0, "/Byte"), m.o(h0, "/Double"), m.o(h0, "/Float"), m.o(h0, "/Int"), m.o(h0, "/Long"), m.o(h0, "/Short"), m.o(h0, "/Boolean"), m.o(h0, "/Char"), m.o(h0, "/CharSequence"), m.o(h0, "/String"), m.o(h0, "/Comparable"), m.o(h0, "/Enum"), m.o(h0, "/Array"), m.o(h0, "/ByteArray"), m.o(h0, "/DoubleArray"), m.o(h0, "/FloatArray"), m.o(h0, "/IntArray"), m.o(h0, "/LongArray"), m.o(h0, "/ShortArray"), m.o(h0, "/BooleanArray"), m.o(h0, "/CharArray"), m.o(h0, "/Cloneable"), m.o(h0, "/Annotation"), m.o(h0, "/collections/Iterable"), m.o(h0, "/collections/MutableIterable"), m.o(h0, "/collections/Collection"), m.o(h0, "/collections/MutableCollection"), m.o(h0, "/collections/List"), m.o(h0, "/collections/MutableList"), m.o(h0, "/collections/Set"), m.o(h0, "/collections/MutableSet"), m.o(h0, "/collections/Map"), m.o(h0, "/collections/MutableMap"), m.o(h0, "/collections/Map.Entry"), m.o(h0, "/collections/MutableMap.MutableEntry"), m.o(h0, "/collections/Iterator"), m.o(h0, "/collections/MutableIterator"), m.o(h0, "/collections/ListIterator"), m.o(h0, "/collections/MutableListIterator"));
        PREDEFINED_STRINGS = j3;
        P0 = z.P0(companion.getPREDEFINED_STRINGS());
        r = s.r(P0, 10);
        d2 = l0.d(r);
        b2 = f.b(d2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (e0 e0Var : P0) {
            linkedHashMap.put((String) e0Var.d(), Integer.valueOf(e0Var.c()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }

    public JvmNameResolver(JvmProtoBuf.StringTableTypes types, String[] strings) {
        Set<Integer> M0;
        m.g(types, "types");
        m.g(strings, "strings");
        this.types = types;
        this.strings = strings;
        List<Integer> localNameList = types.getLocalNameList();
        if (localNameList.isEmpty()) {
            M0 = s0.b();
        } else {
            m.f(localNameList, "");
            M0 = z.M0(localNameList);
        }
        this.localNameIndices = M0;
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = getTypes().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record record : recordList) {
            int range = record.getRange();
            for (int i2 = 0; i2 < range; i2++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        x xVar = x.a;
        this.records = arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i2) {
        return getString(i2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int i2) {
        String string;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i2);
        if (record.hasString()) {
            string = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                Companion companion = Companion;
                int size = companion.getPREDEFINED_STRINGS().size() - 1;
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex <= size) {
                    string = companion.getPREDEFINED_STRINGS().get(record.getPredefinedIndex());
                }
            }
            string = this.strings[i2];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            m.f(substringIndexList, "substringIndexList");
            Integer begin = substringIndexList.get(0);
            Integer end = substringIndexList.get(1);
            m.f(begin, "begin");
            if (begin.intValue() >= 0) {
                int intValue = begin.intValue();
                m.f(end, "end");
                if (intValue <= end.intValue() && end.intValue() <= string.length()) {
                    m.f(string, "string");
                    string = string.substring(begin.intValue(), end.intValue());
                    m.f(string, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String string2 = string;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            m.f(replaceCharList, "replaceCharList");
            m.f(string2, "string");
            string2 = kotlin.l0.x.J(string2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, null);
        }
        String string3 = string2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i3 == 2) {
            m.f(string3, "string");
            string3 = kotlin.l0.x.J(string3, '$', '.', false, 4, null);
        } else if (i3 == 3) {
            if (string3.length() >= 2) {
                m.f(string3, "string");
                string3 = string3.substring(1, string3.length() - 1);
                m.f(string3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            String string4 = string3;
            m.f(string4, "string");
            string3 = kotlin.l0.x.J(string4, '$', '.', false, 4, null);
        }
        m.f(string3, "string");
        return string3;
    }

    public final JvmProtoBuf.StringTableTypes getTypes() {
        return this.types;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i2) {
        return this.localNameIndices.contains(Integer.valueOf(i2));
    }
}