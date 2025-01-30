package com.coinbase.walletengine.services.example;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ExampleService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B^\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0014\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u0017ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\t\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJz\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\r2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00142\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u0004J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010\bJ\u001a\u0010*\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u001f\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u0010\u000fR\u001c\u0010\u001b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b0\u0010\u0004R(\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b2\u0010\u001aR\u001e\u0010!\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b4\u0010\u0016R\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b6\u0010\u0013R%\u0010\u001d\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u0010\bR\u001c\u0010\u001e\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010\f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"Lcom/coinbase/walletengine/services/example/Person;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lkotlin/UInt;", "component3-pVg5ArA", "()I", "component3", "", "component4", "()Z", "Ljava/math/BigInteger;", "component5", "()Ljava/math/BigInteger;", "", "Lcom/coinbase/walletengine/services/example/Skill;", "component6", "()Ljava/util/List;", "Lcom/coinbase/walletengine/services/example/Religion;", "component7", "()Lcom/coinbase/walletengine/services/example/Religion;", "", "Lcom/coinbase/walletengine/services/example/MetaData;", "component8", "()Ljava/util/Map;", "firstName", "lastName", "age", "married", "netWorth", "skills", "religion", "meta", "copy-eUTeH5E", "(Ljava/lang/String;Ljava/lang/String;IZLjava/math/BigInteger;Ljava/util/List;Lcom/coinbase/walletengine/services/example/Religion;Ljava/util/Map;)Lcom/coinbase/walletengine/services/example/Person;", "copy", "toString", "", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getLastName", "Ljava/math/BigInteger;", "getNetWorth", "getFirstName", "Ljava/util/Map;", "getMeta", "Lcom/coinbase/walletengine/services/example/Religion;", "getReligion", "Ljava/util/List;", "getSkills", "I", "getAge-pVg5ArA", "Z", "getMarried", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZLjava/math/BigInteger;Ljava/util/List;Lcom/coinbase/walletengine/services/example/Religion;Ljava/util/Map;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Person {
    @Json(name = "age")
    private final int age;
    @Json(name = "firstName")
    private final String firstName;
    @Json(name = "lastName")
    private final String lastName;
    @Json(name = "married")
    private final boolean married;
    @Json(name = "meta")
    private final Map<String, MetaData> meta;
    @Json(name = "netWorth")
    private final BigInteger netWorth;
    @Json(name = "religion")
    private final Religion religion;
    @Json(name = "skills")
    private final List<Skill> skills;

    private Person(String str, String str2, int i2, boolean z, BigInteger bigInteger, List<Skill> list, Religion religion, Map<String, MetaData> map) {
        this.firstName = str;
        this.lastName = str2;
        this.age = i2;
        this.married = z;
        this.netWorth = bigInteger;
        this.skills = list;
        this.religion = religion;
        this.meta = map;
    }

    public /* synthetic */ Person(String str, String str2, int i2, boolean z, BigInteger bigInteger, List list, Religion religion, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i2, z, bigInteger, list, religion, map);
    }

    public final String component1() {
        return this.firstName;
    }

    public final String component2() {
        return this.lastName;
    }

    /* renamed from: component3-pVg5ArA  reason: not valid java name */
    public final int m2041component3pVg5ArA() {
        return this.age;
    }

    public final boolean component4() {
        return this.married;
    }

    public final BigInteger component5() {
        return this.netWorth;
    }

    public final List<Skill> component6() {
        return this.skills;
    }

    public final Religion component7() {
        return this.religion;
    }

    public final Map<String, MetaData> component8() {
        return this.meta;
    }

    /* renamed from: copy-eUTeH5E  reason: not valid java name */
    public final Person m2042copyeUTeH5E(String firstName, String lastName, int i2, boolean z, BigInteger netWorth, List<Skill> skills, Religion religion, Map<String, MetaData> meta) {
        kotlin.jvm.internal.m.g(firstName, "firstName");
        kotlin.jvm.internal.m.g(lastName, "lastName");
        kotlin.jvm.internal.m.g(netWorth, "netWorth");
        kotlin.jvm.internal.m.g(skills, "skills");
        kotlin.jvm.internal.m.g(meta, "meta");
        return new Person(firstName, lastName, i2, z, netWorth, skills, religion, meta, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return kotlin.jvm.internal.m.c(this.firstName, person.firstName) && kotlin.jvm.internal.m.c(this.lastName, person.lastName) && this.age == person.age && this.married == person.married && kotlin.jvm.internal.m.c(this.netWorth, person.netWorth) && kotlin.jvm.internal.m.c(this.skills, person.skills) && kotlin.jvm.internal.m.c(this.religion, person.religion) && kotlin.jvm.internal.m.c(this.meta, person.meta);
        }
        return false;
    }

    /* renamed from: getAge-pVg5ArA  reason: not valid java name */
    public final int m2043getAgepVg5ArA() {
        return this.age;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final boolean getMarried() {
        return this.married;
    }

    public final Map<String, MetaData> getMeta() {
        return this.meta;
    }

    public final BigInteger getNetWorth() {
        return this.netWorth;
    }

    public final Religion getReligion() {
        return this.religion;
    }

    public final List<Skill> getSkills() {
        return this.skills;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + UInt.z(this.age)) * 31;
        boolean z = this.married;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int hashCode2 = (((((hashCode + i2) * 31) + this.netWorth.hashCode()) * 31) + this.skills.hashCode()) * 31;
        Religion religion = this.religion;
        return ((hashCode2 + (religion == null ? 0 : religion.hashCode())) * 31) + this.meta.hashCode();
    }

    public String toString() {
        return "Person(firstName=" + this.firstName + ", lastName=" + this.lastName + ", age=" + ((Object) UInt.A(this.age)) + ", married=" + this.married + ", netWorth=" + this.netWorth + ", skills=" + this.skills + ", religion=" + this.religion + ", meta=" + this.meta + ')';
    }
}