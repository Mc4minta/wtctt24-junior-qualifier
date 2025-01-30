package com.coinbase.walletengine.services.example;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: ExampleService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/coinbase/walletengine/services/example/Skill;", "", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/walletengine/services/example/SkillLevel;", "component2", "()Lcom/coinbase/walletengine/services/example/SkillLevel;", ApiConstants.NAME, "skillLevel", "copy", "(Ljava/lang/String;Lcom/coinbase/walletengine/services/example/SkillLevel;)Lcom/coinbase/walletengine/services/example/Skill;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Lcom/coinbase/walletengine/services/example/SkillLevel;", "getSkillLevel", "<init>", "(Ljava/lang/String;Lcom/coinbase/walletengine/services/example/SkillLevel;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Skill {
    @Json(name = ApiConstants.NAME)
    private final String name;
    @Json(name = "skillLevel")
    private final SkillLevel skillLevel;

    public Skill(String name, SkillLevel skillLevel) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(skillLevel, "skillLevel");
        this.name = name;
        this.skillLevel = skillLevel;
    }

    public static /* synthetic */ Skill copy$default(Skill skill, String str, SkillLevel skillLevel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = skill.name;
        }
        if ((i2 & 2) != 0) {
            skillLevel = skill.skillLevel;
        }
        return skill.copy(str, skillLevel);
    }

    public final String component1() {
        return this.name;
    }

    public final SkillLevel component2() {
        return this.skillLevel;
    }

    public final Skill copy(String name, SkillLevel skillLevel) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(skillLevel, "skillLevel");
        return new Skill(name, skillLevel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Skill) {
            Skill skill = (Skill) obj;
            return kotlin.jvm.internal.m.c(this.name, skill.name) && this.skillLevel == skill.skillLevel;
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final SkillLevel getSkillLevel() {
        return this.skillLevel;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.skillLevel.hashCode();
    }

    public String toString() {
        return "Skill(name=" + this.name + ", skillLevel=" + this.skillLevel + ')';
    }
}