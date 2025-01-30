package com.coinbase.walletengine.services.example;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: ExampleService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/coinbase/walletengine/services/example/Relationship;", "", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/walletengine/services/example/Person;", "component2", "()Lcom/coinbase/walletengine/services/example/Person;", "component3", "relation", "person", "toPerson", "copy", "(Ljava/lang/String;Lcom/coinbase/walletengine/services/example/Person;Lcom/coinbase/walletengine/services/example/Person;)Lcom/coinbase/walletengine/services/example/Relationship;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/walletengine/services/example/Person;", "getPerson", "getToPerson", "Ljava/lang/String;", "getRelation", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletengine/services/example/Person;Lcom/coinbase/walletengine/services/example/Person;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Relationship {
    @Json(name = "person")
    private final Person person;
    @Json(name = "relation")
    private final String relation;
    @Json(name = "toPerson")
    private final Person toPerson;

    public Relationship(String relation, Person person, Person toPerson) {
        kotlin.jvm.internal.m.g(relation, "relation");
        kotlin.jvm.internal.m.g(person, "person");
        kotlin.jvm.internal.m.g(toPerson, "toPerson");
        this.relation = relation;
        this.person = person;
        this.toPerson = toPerson;
    }

    public static /* synthetic */ Relationship copy$default(Relationship relationship, String str, Person person, Person person2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = relationship.relation;
        }
        if ((i2 & 2) != 0) {
            person = relationship.person;
        }
        if ((i2 & 4) != 0) {
            person2 = relationship.toPerson;
        }
        return relationship.copy(str, person, person2);
    }

    public final String component1() {
        return this.relation;
    }

    public final Person component2() {
        return this.person;
    }

    public final Person component3() {
        return this.toPerson;
    }

    public final Relationship copy(String relation, Person person, Person toPerson) {
        kotlin.jvm.internal.m.g(relation, "relation");
        kotlin.jvm.internal.m.g(person, "person");
        kotlin.jvm.internal.m.g(toPerson, "toPerson");
        return new Relationship(relation, person, toPerson);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Relationship) {
            Relationship relationship = (Relationship) obj;
            return kotlin.jvm.internal.m.c(this.relation, relationship.relation) && kotlin.jvm.internal.m.c(this.person, relationship.person) && kotlin.jvm.internal.m.c(this.toPerson, relationship.toPerson);
        }
        return false;
    }

    public final Person getPerson() {
        return this.person;
    }

    public final String getRelation() {
        return this.relation;
    }

    public final Person getToPerson() {
        return this.toPerson;
    }

    public int hashCode() {
        return (((this.relation.hashCode() * 31) + this.person.hashCode()) * 31) + this.toPerson.hashCode();
    }

    public String toString() {
        return "Relationship(relation=" + this.relation + ", person=" + this.person + ", toPerson=" + this.toPerson + ')';
    }
}