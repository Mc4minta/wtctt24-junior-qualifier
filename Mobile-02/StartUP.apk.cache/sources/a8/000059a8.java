package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Map;
import kotlin.a0.m0;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: JavaTypeEnhancementState.kt */
/* loaded from: classes3.dex */
public final class JavaTypeEnhancementState {
    public static final Companion Companion = new Companion(null);
    public static final JavaTypeEnhancementState DEFAULT;
    public static final ReportLevel DEFAULT_REPORT_LEVEL_FOR_JSPECIFY;
    public static final JavaTypeEnhancementState DISABLED_JSR_305;
    public static final JavaTypeEnhancementState STRICT;
    private final h description$delegate;
    private final boolean disabledDefaultAnnotations;
    private final boolean disabledJsr305;
    private final boolean enableCompatqualCheckerFrameworkAnnotations;
    private final ReportLevel globalJsr305Level;
    private final ReportLevel jspecifyReportLevel;
    private final ReportLevel migrationLevelForJsr305;
    private final Map<String, ReportLevel> userDefinedLevelForSpecificJsr305Annotation;

    /* compiled from: JavaTypeEnhancementState.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Map i2;
        Map i3;
        Map i4;
        ReportLevel reportLevel = ReportLevel.WARN;
        DEFAULT_REPORT_LEVEL_FOR_JSPECIFY = reportLevel;
        i2 = m0.i();
        DEFAULT = new JavaTypeEnhancementState(reportLevel, null, i2, false, null, 24, null);
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        i3 = m0.i();
        DISABLED_JSR_305 = new JavaTypeEnhancementState(reportLevel2, reportLevel2, i3, false, null, 24, null);
        ReportLevel reportLevel3 = ReportLevel.STRICT;
        i4 = m0.i();
        STRICT = new JavaTypeEnhancementState(reportLevel3, reportLevel3, i4, false, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(ReportLevel globalJsr305Level, ReportLevel reportLevel, Map<String, ? extends ReportLevel> userDefinedLevelForSpecificJsr305Annotation, boolean z, ReportLevel jspecifyReportLevel) {
        h b2;
        m.g(globalJsr305Level, "globalJsr305Level");
        m.g(userDefinedLevelForSpecificJsr305Annotation, "userDefinedLevelForSpecificJsr305Annotation");
        m.g(jspecifyReportLevel, "jspecifyReportLevel");
        this.globalJsr305Level = globalJsr305Level;
        this.migrationLevelForJsr305 = reportLevel;
        this.userDefinedLevelForSpecificJsr305Annotation = userDefinedLevelForSpecificJsr305Annotation;
        this.enableCompatqualCheckerFrameworkAnnotations = z;
        this.jspecifyReportLevel = jspecifyReportLevel;
        b2 = k.b(new JavaTypeEnhancementState$description$2(this));
        this.description$delegate = b2;
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        boolean z2 = true;
        boolean z3 = globalJsr305Level == reportLevel2 && reportLevel == reportLevel2 && userDefinedLevelForSpecificJsr305Annotation.isEmpty();
        this.disabledJsr305 = z3;
        if (!z3 && jspecifyReportLevel != reportLevel2) {
            z2 = false;
        }
        this.disabledDefaultAnnotations = z2;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.disabledDefaultAnnotations;
    }

    public final boolean getDisabledJsr305() {
        return this.disabledJsr305;
    }

    public final boolean getEnableCompatqualCheckerFrameworkAnnotations() {
        return this.enableCompatqualCheckerFrameworkAnnotations;
    }

    public final ReportLevel getGlobalJsr305Level() {
        return this.globalJsr305Level;
    }

    public final ReportLevel getJspecifyReportLevel() {
        return this.jspecifyReportLevel;
    }

    public final ReportLevel getMigrationLevelForJsr305() {
        return this.migrationLevelForJsr305;
    }

    public final Map<String, ReportLevel> getUserDefinedLevelForSpecificJsr305Annotation() {
        return this.userDefinedLevelForSpecificJsr305Annotation;
    }

    public /* synthetic */ JavaTypeEnhancementState(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, boolean z, ReportLevel reportLevel3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, reportLevel2, map, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? DEFAULT_REPORT_LEVEL_FOR_JSPECIFY : reportLevel3);
    }
}