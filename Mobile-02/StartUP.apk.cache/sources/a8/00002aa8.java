package com.coinbase.walletengine.services.example;

import android.util.Base64;
import com.coinbase.ApiConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.l0;
import kotlin.a0.m0;
import kotlin.u;

/* compiled from: ExampleService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0005H\u0002¢\u0006\u0004\b\u0003\u0010\u0006\u001a'\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0003\u0010\t\u001a!\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001*\u00020\nH\u0002¢\u0006\u0004\b\u0003\u0010\f\u001a\u001f\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\rH\u0002¢\u0006\u0004\b\u0003\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/coinbase/walletengine/services/example/Skill;", "", "", "asJSONMap", "(Lcom/coinbase/walletengine/services/example/Skill;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/example/Religion;", "(Lcom/coinbase/walletengine/services/example/Religion;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/example/MetaData;", "kotlin.jvm.PlatformType", "(Lcom/coinbase/walletengine/services/example/MetaData;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/example/Person;", "", "(Lcom/coinbase/walletengine/services/example/Person;)Ljava/util/Map;", "Lcom/coinbase/walletengine/services/example/Relationship;", "(Lcom/coinbase/walletengine/services/example/Relationship;)Ljava/util/Map;", "wallet-engine_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ExampleServiceKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, String> asJSONMap(Skill skill) {
        Map<String, String> l2;
        l2 = m0.l(u.a(ApiConstants.NAME, skill.getName()), u.a("skillLevel", skill.getSkillLevel().getRawValue()));
        return l2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, String> asJSONMap(Religion religion) {
        Map<String, String> e2;
        e2 = l0.e(u.a(ApiConstants.NAME, religion.getName()));
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, String> asJSONMap(MetaData metaData) {
        Map<String, String> l2;
        l2 = m0.l(u.a("type", metaData.getType()), u.a("data", Base64.encodeToString(metaData.getData(), 2)));
        return l2;
    }

    private static final Map<String, Object> asJSONMap(Person person) {
        int d2;
        Map<String, Object> l2;
        kotlin.o[] oVarArr = new kotlin.o[8];
        oVarArr[0] = u.a("firstName", person.getFirstName());
        oVarArr[1] = u.a("lastName", person.getLastName());
        oVarArr[2] = u.a("age", UInt.h(person.m2043getAgepVg5ArA()));
        oVarArr[3] = u.a("married", Boolean.valueOf(person.getMarried()));
        oVarArr[4] = u.a("netWorth", person.getNetWorth().toString());
        List<Skill> skills = person.getSkills();
        ArrayList arrayList = new ArrayList();
        for (Skill skill : skills) {
            Map<String, String> asJSONMap = asJSONMap(skill);
            if (asJSONMap != null) {
                arrayList.add(asJSONMap);
            }
        }
        oVarArr[5] = u.a("skills", arrayList);
        Religion religion = person.getReligion();
        oVarArr[6] = u.a("religion", religion == null ? null : asJSONMap(religion));
        Map<String, MetaData> meta = person.getMeta();
        d2 = l0.d(meta.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(d2);
        Iterator<T> it = meta.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), asJSONMap((MetaData) entry.getValue()));
        }
        oVarArr[7] = u.a("meta", linkedHashMap);
        l2 = m0.l(oVarArr);
        return l2;
    }

    private static final Map<String, Object> asJSONMap(Relationship relationship) {
        Map<String, Object> l2;
        l2 = m0.l(u.a("relation", relationship.getRelation()), u.a("person", asJSONMap(relationship.getPerson())), u.a("toPerson", asJSONMap(relationship.getToPerson())));
        return l2;
    }
}