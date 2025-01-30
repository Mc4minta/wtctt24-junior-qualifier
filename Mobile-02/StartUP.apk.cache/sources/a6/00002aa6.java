package com.coinbase.walletengine.services.example;

import com.coinbase.walletengine.Optional;
import com.coinbase.walletengine.WalletEngine;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import h.c.b0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.u;
import kotlin.x;

/* compiled from: ExampleService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 Q2\u00020\u0001:\u0001QB\u000f\u0012\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bO\u0010PJ3\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJo\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c0\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u00040\u0006H\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J/\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0\u00040\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010&J \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010&J\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b,\u0010&J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010&J#\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010&J#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0/0\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u0010&J%\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010$\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0002H\u0016¢\u0006\u0004\b2\u00103J%\u00106\u001a\b\u0012\u0004\u0012\u0002050\u00062\u0006\u0010$\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u00103J\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002070\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b8\u0010&J-\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010$\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u00109\u001a\u000205H\u0016¢\u0006\u0004\b:\u0010;J-\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010$\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u001cH\u0016¢\u0006\u0004\b=\u0010>J-\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010?\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u0002H\u0016¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u00170\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\bD\u0010&J/\u0010E\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00170\u00040\u00062\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\bE\u0010&R\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR$\u0010K\u001a\n J*\u0004\u0018\u00010I0I8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\bK\u0010L\u0012\u0004\bM\u0010N\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006R"}, d2 = {"Lcom/coinbase/walletengine/services/example/ExampleService;", "", "", "method", "", "params", "Lh/c/b0;", "call", "(Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "T", "Ljava/lang/reflect/Type;", "type", "json", "decodeJson", "(Ljava/lang/reflect/Type;Ljava/lang/String;)Ljava/lang/Object;", "firstName", "lastName", "Lkotlin/UInt;", "age", "", "married", "Ljava/math/BigInteger;", "netWorth", "", "Lcom/coinbase/walletengine/services/example/Skill;", "skills", "Lcom/coinbase/walletengine/services/example/Religion;", "religion", "Lcom/coinbase/walletengine/services/example/MetaData;", "meta", "createPerson-eUTeH5E", "(Ljava/lang/String;Ljava/lang/String;IZLjava/math/BigInteger;Ljava/util/List;Lcom/coinbase/walletengine/services/example/Religion;Ljava/util/Map;)Lh/c/b0;", "createPerson", "Lcom/coinbase/walletengine/services/example/Person;", "listPeople", "()Lh/c/b0;", "personId", "getPerson", "(Ljava/lang/String;)Lh/c/b0;", "personIds", "getMultiplePeople", "(Ljava/util/List;)Lh/c/b0;", "getFullName", "getAge", "isMarried", "getNetWorth", "getSkills", "Lcom/coinbase/walletengine/Optional;", "getReligion", "key", "getMeta", "(Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "skillName", "Lcom/coinbase/walletengine/services/example/SkillLevel;", "getSkillLevel", "Lkotlin/x;", "deletePerson", "skillLevel", "addSkill", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/walletengine/services/example/SkillLevel;)Lh/c/b0;", "metaData", "addMetaData", "(Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/walletengine/services/example/MetaData;)Lh/c/b0;", "relation", "toPersonId", "addRelationship", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/walletengine/services/example/Relationship;", "listRelationships", "getRelatives", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lcom/coinbase/walletengine/WalletEngine;", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi$annotations", "()V", "<init>", "(Lcom/coinbase/walletengine/WalletEngine;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class ExampleService {
    public static final Companion Companion = new Companion(null);
    private final Moshi moshi;
    private final WalletEngine walletEngine;

    /* compiled from: ExampleService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletengine/services/example/ExampleService$Companion;", "", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ExampleService(WalletEngine walletEngine) {
        kotlin.jvm.internal.m.g(walletEngine, "walletEngine");
        this.walletEngine = walletEngine;
        this.moshi = new Moshi.Builder().add(new BigIntegerJsonAdapter()).add(new ByteArrayJsonAdapter()).add(UInt.class, new UIntJsonAdapter()).build();
    }

    public static /* synthetic */ Boolean a(ExampleService exampleService, String str) {
        return m2036isMarried$lambda9(exampleService, str);
    }

    /* renamed from: addMetaData$lambda-17 */
    public static final Boolean m2021addMetaData$lambda17(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (Boolean) this$0.decodeJson(Boolean.class, it);
    }

    /* renamed from: addRelationship$lambda-18 */
    public static final Boolean m2022addRelationship$lambda18(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (Boolean) this$0.decodeJson(Boolean.class, it);
    }

    /* renamed from: addSkill$lambda-16 */
    public static final Boolean m2023addSkill$lambda16(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (Boolean) this$0.decodeJson(Boolean.class, it);
    }

    public static /* synthetic */ Boolean b(ExampleService exampleService, String str) {
        return m2021addMetaData$lambda17(exampleService, str);
    }

    public static /* synthetic */ Map c(ExampleService exampleService, String str) {
        return m2032getRelatives$lambda20(exampleService, str);
    }

    private final b0<String> call(String str, Map<String, ? extends Object> map) {
        String encodedParams = this.moshi.adapter((Type) Map.class).serializeNulls().toJson(map);
        WalletEngine walletEngine = this.walletEngine;
        kotlin.jvm.internal.m.f(encodedParams, "encodedParams");
        return walletEngine.call("example", str, encodedParams);
    }

    /* renamed from: createPerson_eUTeH5E$lambda-2 */
    public static final String m2024createPerson_eUTeH5E$lambda2(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (String) this$0.decodeJson(String.class, it);
    }

    public static /* synthetic */ Map d(ExampleService exampleService, String str) {
        return m2029getMultiplePeople$lambda6(exampleService, str);
    }

    private final <T> T decodeJson(Type type, String str) {
        return this.moshi.adapter(type).serializeNulls().fromJson(str);
    }

    /* renamed from: deletePerson$lambda-15 */
    public static final x m2025deletePerson$lambda15(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    public static /* synthetic */ Person e(ExampleService exampleService, String str) {
        return m2031getPerson$lambda4(exampleService, str);
    }

    public static /* synthetic */ String f(ExampleService exampleService, String str) {
        return m2024createPerson_eUTeH5E$lambda2(exampleService, str);
    }

    public static /* synthetic */ Map g(ExampleService exampleService, String str) {
        return m2037listPeople$lambda3(exampleService, str);
    }

    /* renamed from: getAge$lambda-8 */
    public static final UInt m2026getAge$lambda8(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (UInt) this$0.decodeJson(UInt.class, it);
    }

    /* renamed from: getFullName$lambda-7 */
    public static final String m2027getFullName$lambda7(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (String) this$0.decodeJson(String.class, it);
    }

    /* renamed from: getMeta$lambda-13 */
    public static final MetaData m2028getMeta$lambda13(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (MetaData) this$0.decodeJson(MetaData.class, it);
    }

    private static /* synthetic */ void getMoshi$annotations() {
    }

    /* renamed from: getMultiplePeople$lambda-6 */
    public static final Map m2029getMultiplePeople$lambda6(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        ParameterizedType newParameterizedType = Types.newParameterizedType(Map.class, String.class, Person.class);
        kotlin.jvm.internal.m.f(newParameterizedType, "newParameterizedType(Map::class.java, String::class.java, Person::class.java)");
        return (Map) this$0.decodeJson(newParameterizedType, it);
    }

    /* renamed from: getNetWorth$lambda-10 */
    public static final BigInteger m2030getNetWorth$lambda10(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (BigInteger) this$0.decodeJson(BigInteger.class, it);
    }

    /* renamed from: getPerson$lambda-4 */
    public static final Person m2031getPerson$lambda4(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (Person) this$0.decodeJson(Person.class, it);
    }

    /* renamed from: getRelatives$lambda-20 */
    public static final Map m2032getRelatives$lambda20(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        ParameterizedType newParameterizedType = Types.newParameterizedType(Map.class, String.class, Types.newParameterizedType(List.class, Person.class));
        kotlin.jvm.internal.m.f(newParameterizedType, "newParameterizedType(Map::class.java, String::class.java, Types.newParameterizedType(List::class.java, Person::class.java))");
        return (Map) this$0.decodeJson(newParameterizedType, it);
    }

    /* renamed from: getReligion$lambda-12 */
    public static final Optional m2033getReligion$lambda12(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.jvm.internal.m.c(it, "null") ? new Optional(null) : new Optional(this$0.decodeJson(Religion.class, it));
    }

    /* renamed from: getSkillLevel$lambda-14 */
    public static final SkillLevel m2034getSkillLevel$lambda14(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (SkillLevel) this$0.decodeJson(SkillLevel.class, it);
    }

    /* renamed from: getSkills$lambda-11 */
    public static final List m2035getSkills$lambda11(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, Skill.class);
        kotlin.jvm.internal.m.f(newParameterizedType, "newParameterizedType(List::class.java, Skill::class.java)");
        return (List) this$0.decodeJson(newParameterizedType, it);
    }

    public static /* synthetic */ Optional h(ExampleService exampleService, String str) {
        return m2033getReligion$lambda12(exampleService, str);
    }

    public static /* synthetic */ x i(String str) {
        return m2025deletePerson$lambda15(str);
    }

    /* renamed from: isMarried$lambda-9 */
    public static final Boolean m2036isMarried$lambda9(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return (Boolean) this$0.decodeJson(Boolean.class, it);
    }

    public static /* synthetic */ UInt j(ExampleService exampleService, String str) {
        return m2026getAge$lambda8(exampleService, str);
    }

    public static /* synthetic */ SkillLevel k(ExampleService exampleService, String str) {
        return m2034getSkillLevel$lambda14(exampleService, str);
    }

    public static /* synthetic */ List l(ExampleService exampleService, String str) {
        return m2035getSkills$lambda11(exampleService, str);
    }

    /* renamed from: listPeople$lambda-3 */
    public static final Map m2037listPeople$lambda3(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        ParameterizedType newParameterizedType = Types.newParameterizedType(Map.class, String.class, Person.class);
        kotlin.jvm.internal.m.f(newParameterizedType, "newParameterizedType(Map::class.java, String::class.java, Person::class.java)");
        return (Map) this$0.decodeJson(newParameterizedType, it);
    }

    /* renamed from: listRelationships$lambda-19 */
    public static final List m2038listRelationships$lambda19(ExampleService this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, Relationship.class);
        kotlin.jvm.internal.m.f(newParameterizedType, "newParameterizedType(List::class.java, Relationship::class.java)");
        return (List) this$0.decodeJson(newParameterizedType, it);
    }

    public static /* synthetic */ BigInteger m(ExampleService exampleService, String str) {
        return m2030getNetWorth$lambda10(exampleService, str);
    }

    public static /* synthetic */ Boolean n(ExampleService exampleService, String str) {
        return m2023addSkill$lambda16(exampleService, str);
    }

    public static /* synthetic */ List o(ExampleService exampleService, String str) {
        return m2038listRelationships$lambda19(exampleService, str);
    }

    public static /* synthetic */ String p(ExampleService exampleService, String str) {
        return m2027getFullName$lambda7(exampleService, str);
    }

    public static /* synthetic */ Boolean q(ExampleService exampleService, String str) {
        return m2022addRelationship$lambda18(exampleService, str);
    }

    public static /* synthetic */ MetaData r(ExampleService exampleService, String str) {
        return m2028getMeta$lambda13(exampleService, str);
    }

    public b0<Boolean> addMetaData(String personId, String key, MetaData metaData) {
        Map asJSONMap;
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(personId, "personId");
        kotlin.jvm.internal.m.g(key, "key");
        kotlin.jvm.internal.m.g(metaData, "metaData");
        asJSONMap = ExampleServiceKt.asJSONMap(metaData);
        l2 = m0.l(u.a("personId", personId), u.a("key", key), u.a("metaData", asJSONMap));
        b0 map = call("addMetaData", l2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.b(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"addMetaData\",\n                mapOf(\n                        \"personId\" to personId,\n                        \"key\" to key,\n                        \"metaData\" to metaData.asJSONMap()\n                )\n        )\n                .map { decodeJson<Boolean>(Boolean::class.javaObjectType, it) }");
        return map;
    }

    public b0<Boolean> addRelationship(String relation, String personId, String toPersonId) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(relation, "relation");
        kotlin.jvm.internal.m.g(personId, "personId");
        kotlin.jvm.internal.m.g(toPersonId, "toPersonId");
        l2 = m0.l(u.a("relation", relation), u.a("personId", personId), u.a("toPersonId", toPersonId));
        b0 map = call("addRelationship", l2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.q
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.q(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"addRelationship\",\n                mapOf(\n                        \"relation\" to relation,\n                        \"personId\" to personId,\n                        \"toPersonId\" to toPersonId\n                )\n        )\n                .map { decodeJson<Boolean>(Boolean::class.javaObjectType, it) }");
        return map;
    }

    public b0<Boolean> addSkill(String personId, String skillName, SkillLevel skillLevel) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(personId, "personId");
        kotlin.jvm.internal.m.g(skillName, "skillName");
        kotlin.jvm.internal.m.g(skillLevel, "skillLevel");
        l2 = m0.l(u.a("personId", personId), u.a("skillName", skillName), u.a("skillLevel", skillLevel.getRawValue()));
        b0 map = call("addSkill", l2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.n(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"addSkill\",\n                mapOf(\n                        \"personId\" to personId,\n                        \"skillName\" to skillName,\n                        \"skillLevel\" to skillLevel.rawValue\n                )\n        )\n                .map { decodeJson<Boolean>(Boolean::class.javaObjectType, it) }");
        return map;
    }

    /* renamed from: createPerson-eUTeH5E */
    public b0<String> m2039createPersoneUTeH5E(String firstName, String lastName, int i2, boolean z, BigInteger netWorth, List<Skill> skills, Religion religion, Map<String, MetaData> meta) {
        int d2;
        Map<String, ? extends Object> l2;
        Map asJSONMap;
        Map asJSONMap2;
        kotlin.jvm.internal.m.g(firstName, "firstName");
        kotlin.jvm.internal.m.g(lastName, "lastName");
        kotlin.jvm.internal.m.g(netWorth, "netWorth");
        kotlin.jvm.internal.m.g(skills, "skills");
        kotlin.jvm.internal.m.g(meta, "meta");
        kotlin.o[] oVarArr = new kotlin.o[8];
        oVarArr[0] = u.a("firstName", firstName);
        oVarArr[1] = u.a("lastName", lastName);
        oVarArr[2] = u.a("age", UInt.h(i2));
        oVarArr[3] = u.a("married", Boolean.valueOf(z));
        oVarArr[4] = u.a("netWorth", netWorth.toString());
        ArrayList arrayList = new ArrayList();
        for (Skill skill : skills) {
            asJSONMap2 = ExampleServiceKt.asJSONMap(skill);
            if (asJSONMap2 != null) {
                arrayList.add(asJSONMap2);
            }
        }
        oVarArr[5] = u.a("skills", arrayList);
        oVarArr[6] = u.a("religion", religion == null ? null : ExampleServiceKt.asJSONMap(religion));
        d2 = l0.d(meta.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(d2);
        Iterator<T> it = meta.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            asJSONMap = ExampleServiceKt.asJSONMap((MetaData) entry.getValue());
            linkedHashMap.put(key, asJSONMap);
        }
        oVarArr[7] = u.a("meta", linkedHashMap);
        l2 = m0.l(oVarArr);
        b0 map = call("createPerson", l2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.f(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"createPerson\",\n                mapOf(\n                        \"firstName\" to firstName,\n                        \"lastName\" to lastName,\n                        \"age\" to age,\n                        \"married\" to married,\n                        \"netWorth\" to netWorth.toString(),\n                        \"skills\" to skills.mapNotNull { it.asJSONMap() },\n                        \"religion\" to religion?.asJSONMap(),\n                        \"meta\" to meta.mapValues { it.value.asJSONMap() }\n                )\n        )\n                .map { decodeJson<String>(String::class.java, it) }");
        return map;
    }

    public b0<x> deletePerson(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("deletePerson", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.i((String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"deletePerson\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { Unit }");
        return map;
    }

    public b0<UInt> getAge(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("getAge", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.j(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getAge\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { decodeJson<UInt>(UInt::class.javaObjectType, it) }");
        return map;
    }

    public b0<String> getFullName(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("getFullName", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.p(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getFullName\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { decodeJson<String>(String::class.java, it) }");
        return map;
    }

    public b0<MetaData> getMeta(String personId, String key) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(personId, "personId");
        kotlin.jvm.internal.m.g(key, "key");
        l2 = m0.l(u.a("personId", personId), u.a("key", key));
        b0 map = call("getMeta", l2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.r(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getMeta\",\n                mapOf(\n                        \"personId\" to personId,\n                        \"key\" to key\n                )\n        )\n                .map { decodeJson<MetaData>(MetaData::class.java, it) }");
        return map;
    }

    public b0<Map<String, Person>> getMultiplePeople(List<String> personIds) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personIds, "personIds");
        ArrayList arrayList = new ArrayList();
        for (String str : personIds) {
            if (str != null) {
                arrayList.add(str);
            }
        }
        e2 = l0.e(u.a("personIds", arrayList));
        b0 map = call("getMultiplePeople", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.d(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getMultiplePeople\",\n                mapOf(\n                        \"personIds\" to personIds.mapNotNull { it }\n                )\n        )\n                .map { decodeJson<Map<String, Person>>(Types.newParameterizedType(Map::class.java, String::class.java, Person::class.java), it) }");
        return map;
    }

    public b0<BigInteger> getNetWorth(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("getNetWorth", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.m(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getNetWorth\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { decodeJson<BigInteger>(BigInteger::class.java, it) }");
        return map;
    }

    public b0<Person> getPerson(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("getPerson", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.e(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getPerson\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { decodeJson<Person>(Person::class.java, it) }");
        return map;
    }

    public b0<Map<String, List<Person>>> getRelatives(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("getRelatives", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.c(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getRelatives\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { decodeJson<Map<String, List<Person>>>(Types.newParameterizedType(Map::class.java, String::class.java, Types.newParameterizedType(List::class.java, Person::class.java)), it) }");
        return map;
    }

    public b0<Optional<Religion>> getReligion(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("getReligion", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.h(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getReligion\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { if (it == \"null\") { Optional<Religion>(null) } else { Optional<Religion>(decodeJson<Religion?>(Religion::class.java, it)) } }");
        return map;
    }

    public b0<SkillLevel> getSkillLevel(String personId, String skillName) {
        Map<String, ? extends Object> l2;
        kotlin.jvm.internal.m.g(personId, "personId");
        kotlin.jvm.internal.m.g(skillName, "skillName");
        l2 = m0.l(u.a("personId", personId), u.a("skillName", skillName));
        b0 map = call("getSkillLevel", l2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.k(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getSkillLevel\",\n                mapOf(\n                        \"personId\" to personId,\n                        \"skillName\" to skillName\n                )\n        )\n                .map { decodeJson<SkillLevel>(SkillLevel::class.java, it) }");
        return map;
    }

    public b0<List<Skill>> getSkills(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("getSkills", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.l(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"getSkills\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { decodeJson<List<Skill>>(Types.newParameterizedType(List::class.java, Skill::class.java), it) }");
        return map;
    }

    public b0<Boolean> isMarried(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("isMarried", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.a(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"isMarried\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { decodeJson<Boolean>(Boolean::class.javaObjectType, it) }");
        return map;
    }

    public b0<Map<String, Person>> listPeople() {
        Map<String, ? extends Object> i2;
        i2 = m0.i();
        b0 map = call("listPeople", i2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.g(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"listPeople\",\n                mapOf(\n                )\n        )\n                .map { decodeJson<Map<String, Person>>(Types.newParameterizedType(Map::class.java, String::class.java, Person::class.java), it) }");
        return map;
    }

    public b0<List<Relationship>> listRelationships(String personId) {
        Map<String, ? extends Object> e2;
        kotlin.jvm.internal.m.g(personId, "personId");
        e2 = l0.e(u.a("personId", personId));
        b0 map = call("listRelationships", e2).map(new h.c.m0.n() { // from class: com.coinbase.walletengine.services.example.o
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ExampleService.o(ExampleService.this, (String) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "call(\n                \"listRelationships\",\n                mapOf(\n                        \"personId\" to personId\n                )\n        )\n                .map { decodeJson<List<Relationship>>(Types.newParameterizedType(List::class.java, Relationship::class.java), it) }");
        return map;
    }
}