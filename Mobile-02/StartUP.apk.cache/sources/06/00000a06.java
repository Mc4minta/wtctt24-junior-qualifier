package com.caverock.androidsvg;

import android.util.Log;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.message.TokenParser;

/* loaded from: classes.dex */
class CSSParser {
    private static final String CLASS = "class";
    static final String CSS_MIME_TYPE = "text/css";
    private static final String ID = "id";
    private static final int SPECIFICITY_ATTRIBUTE_OR_PSEUDOCLASS = 1000;
    private static final int SPECIFICITY_ELEMENT_OR_PSEUDOELEMENT = 1;
    private static final int SPECIFICITY_ID_ATTRIBUTE = 1000000;
    private static final String TAG = "CSSParser";
    private MediaType deviceMediaType;
    private boolean inMediaRule;
    private Source source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.caverock.androidsvg.CSSParser$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents;

        static {
            int[] iArr = new int[PseudoClassIdents.values().length];
            $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents = iArr;
            try {
                iArr[PseudoClassIdents.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[AttribOp.values().length];
            $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp = iArr2;
            try {
                iArr2[AttribOp.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[AttribOp.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Attrib {
        public final String name;
        final AttribOp operation;
        public final String value;

        Attrib(String str, AttribOp attribOp, String str2) {
            this.name = str;
            this.operation = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CSSTextScanner extends SVGParser.TextScanner {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class AnPlusB {
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public int f3749b;

            AnPlusB(int i2, int i3) {
                this.a = i2;
                this.f3749b = i3;
            }
        }

        CSSTextScanner(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        private int hexChar(int i2) {
            if (i2 < 48 || i2 > 57) {
                int i3 = 65;
                if (i2 < 65 || i2 > 70) {
                    i3 = 97;
                    if (i2 < 97 || i2 > 102) {
                        return -1;
                    }
                }
                return (i2 - i3) + 10;
            }
            return i2 - 48;
        }

        private AnPlusB nextAnPlusB() throws CSSParseException {
            IntegerParser integerParser;
            AnPlusB anPlusB;
            if (empty()) {
                return null;
            }
            int i2 = this.position;
            if (consume('(')) {
                skipWhitespace();
                int i3 = 1;
                if (consume("odd")) {
                    anPlusB = new AnPlusB(2, 1);
                } else {
                    if (consume("even")) {
                        anPlusB = new AnPlusB(2, 0);
                    } else {
                        int i4 = (!consume('+') && consume('-')) ? -1 : 1;
                        IntegerParser parseInt = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                        if (parseInt != null) {
                            this.position = parseInt.getEndPos();
                        }
                        if (consume('n') || consume('N')) {
                            if (parseInt == null) {
                                parseInt = new IntegerParser(1L, this.position);
                            }
                            skipWhitespace();
                            boolean consume = consume('+');
                            if (!consume && (consume = consume('-'))) {
                                i3 = -1;
                            }
                            if (consume) {
                                skipWhitespace();
                                integerParser = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                                if (integerParser != null) {
                                    this.position = integerParser.getEndPos();
                                } else {
                                    this.position = i2;
                                    return null;
                                }
                            } else {
                                integerParser = null;
                            }
                            int i5 = i3;
                            i3 = i4;
                            i4 = i5;
                        } else {
                            integerParser = parseInt;
                            parseInt = null;
                        }
                        anPlusB = new AnPlusB(parseInt == null ? 0 : i3 * parseInt.value(), integerParser != null ? i4 * integerParser.value() : 0);
                    }
                }
                skipWhitespace();
                if (consume(')')) {
                    return anPlusB;
                }
                this.position = i2;
                return null;
            }
            return null;
        }

        private String nextAttribValue() {
            if (empty()) {
                return null;
            }
            String nextQuotedString = nextQuotedString();
            return nextQuotedString != null ? nextQuotedString : nextIdentifier();
        }

        private List<String> nextIdentListParam() throws CSSParseException {
            if (empty()) {
                return null;
            }
            int i2 = this.position;
            if (consume('(')) {
                skipWhitespace();
                ArrayList arrayList = null;
                do {
                    String nextIdentifier = nextIdentifier();
                    if (nextIdentifier == null) {
                        this.position = i2;
                        return null;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(nextIdentifier);
                    skipWhitespace();
                } while (skipCommaWhitespace());
                if (consume(')')) {
                    return arrayList;
                }
                this.position = i2;
                return null;
            }
            return null;
        }

        private List<Selector> nextPseudoNotParam() throws CSSParseException {
            List<SimpleSelector> list;
            List<PseudoClass> list2;
            if (empty()) {
                return null;
            }
            int i2 = this.position;
            if (consume('(')) {
                skipWhitespace();
                List<Selector> nextSelectorGroup = nextSelectorGroup();
                if (nextSelectorGroup == null) {
                    this.position = i2;
                    return null;
                } else if (!consume(')')) {
                    this.position = i2;
                    return null;
                } else {
                    Iterator<Selector> it = nextSelectorGroup.iterator();
                    while (it.hasNext() && (list = it.next().simpleSelectors) != null) {
                        Iterator<SimpleSelector> it2 = list.iterator();
                        while (it2.hasNext() && (list2 = it2.next().pseudos) != null) {
                            for (PseudoClass pseudoClass : list2) {
                                if (pseudoClass instanceof PseudoClassNot) {
                                    return null;
                                }
                            }
                        }
                    }
                    return nextSelectorGroup;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Selector> nextSelectorGroup() throws CSSParseException {
            if (empty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            Selector selector = new Selector(null);
            while (!empty() && nextSimpleSelector(selector)) {
                if (skipCommaWhitespace()) {
                    arrayList.add(selector);
                    selector = new Selector(null);
                }
            }
            if (!selector.isEmpty()) {
                arrayList.add(selector);
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void parsePseudoClass(Selector selector, SimpleSelector simpleSelector) throws CSSParseException {
            PseudoClass pseudoClassAnPlusB;
            PseudoClassAnPlusB pseudoClassAnPlusB2;
            String nextIdentifier = nextIdentifier();
            if (nextIdentifier != null) {
                PseudoClassIdents fromString = PseudoClassIdents.fromString(nextIdentifier);
                switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[fromString.ordinal()]) {
                    case 1:
                        pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, true, false, null);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 2:
                        pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, false, false, null);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 3:
                        pseudoClassAnPlusB = new PseudoClassOnlyChild(false, null);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 4:
                        pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, true, true, simpleSelector.tag);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 5:
                        pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, false, true, simpleSelector.tag);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 6:
                        pseudoClassAnPlusB = new PseudoClassOnlyChild(true, simpleSelector.tag);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 7:
                        pseudoClassAnPlusB = new PseudoClassRoot(null);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 8:
                        pseudoClassAnPlusB = new PseudoClassEmpty(null);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        boolean z = fromString == PseudoClassIdents.nth_child || fromString == PseudoClassIdents.nth_of_type;
                        boolean z2 = fromString == PseudoClassIdents.nth_of_type || fromString == PseudoClassIdents.nth_last_of_type;
                        AnPlusB nextAnPlusB = nextAnPlusB();
                        if (nextAnPlusB != null) {
                            PseudoClassAnPlusB pseudoClassAnPlusB3 = new PseudoClassAnPlusB(nextAnPlusB.a, nextAnPlusB.f3749b, z, z2, simpleSelector.tag);
                            selector.addedAttributeOrPseudo();
                            pseudoClassAnPlusB2 = pseudoClassAnPlusB3;
                            pseudoClassAnPlusB = pseudoClassAnPlusB2;
                            break;
                        } else {
                            throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + nextIdentifier);
                        }
                        break;
                    case 13:
                        List<Selector> nextPseudoNotParam = nextPseudoNotParam();
                        if (nextPseudoNotParam != null) {
                            PseudoClassNot pseudoClassNot = new PseudoClassNot(nextPseudoNotParam);
                            selector.specificity = pseudoClassNot.getSpecificity();
                            pseudoClassAnPlusB2 = pseudoClassNot;
                            pseudoClassAnPlusB = pseudoClassAnPlusB2;
                            break;
                        } else {
                            throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + nextIdentifier);
                        }
                    case 14:
                        pseudoClassAnPlusB = new PseudoClassTarget(null);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 15:
                        nextIdentListParam();
                        pseudoClassAnPlusB = new PseudoClassNotSupported(nextIdentifier);
                        selector.addedAttributeOrPseudo();
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        pseudoClassAnPlusB = new PseudoClassNotSupported(nextIdentifier);
                        selector.addedAttributeOrPseudo();
                        break;
                    default:
                        throw new CSSParseException("Unsupported pseudo class: " + nextIdentifier);
                }
                simpleSelector.addPseudo(pseudoClassAnPlusB);
                return;
            }
            throw new CSSParseException("Invalid pseudo class");
        }

        private int scanForIdentifier() {
            int i2;
            if (empty()) {
                return this.position;
            }
            int i3 = this.position;
            int charAt = this.input.charAt(i3);
            if (charAt == 45) {
                charAt = advanceChar();
            }
            if ((charAt < 65 || charAt > 90) && ((charAt < 97 || charAt > 122) && charAt != 95)) {
                i2 = i3;
            } else {
                int advanceChar = advanceChar();
                while (true) {
                    if ((advanceChar < 65 || advanceChar > 90) && ((advanceChar < 97 || advanceChar > 122) && !((advanceChar >= 48 && advanceChar <= 57) || advanceChar == 45 || advanceChar == 95))) {
                        break;
                    }
                    advanceChar = advanceChar();
                }
                i2 = this.position;
            }
            this.position = i3;
            return i2;
        }

        String nextCSSString() {
            int hexChar;
            if (empty()) {
                return null;
            }
            char charAt = this.input.charAt(this.position);
            if (charAt == '\'' || charAt == '\"') {
                StringBuilder sb = new StringBuilder();
                this.position++;
                int intValue = nextChar().intValue();
                while (intValue != -1 && intValue != charAt) {
                    if (intValue == 92) {
                        intValue = nextChar().intValue();
                        if (intValue != -1) {
                            if (intValue != 10 && intValue != 13 && intValue != 12) {
                                int hexChar2 = hexChar(intValue);
                                if (hexChar2 != -1) {
                                    for (int i2 = 1; i2 <= 5 && (hexChar = hexChar((intValue = nextChar().intValue()))) != -1; i2++) {
                                        hexChar2 = (hexChar2 * 16) + hexChar;
                                    }
                                    sb.append((char) hexChar2);
                                }
                            } else {
                                intValue = nextChar().intValue();
                            }
                        }
                    }
                    sb.append((char) intValue);
                    intValue = nextChar().intValue();
                }
                return sb.toString();
            }
            return null;
        }

        String nextIdentifier() {
            int scanForIdentifier = scanForIdentifier();
            int i2 = this.position;
            if (scanForIdentifier == i2) {
                return null;
            }
            String substring = this.input.substring(i2, scanForIdentifier);
            this.position = scanForIdentifier;
            return substring;
        }

        String nextLegacyURL() {
            char charAt;
            int hexChar;
            StringBuilder sb = new StringBuilder();
            while (!empty() && (charAt = this.input.charAt(this.position)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !isWhitespace(charAt) && !Character.isISOControl((int) charAt)) {
                this.position++;
                if (charAt == '\\') {
                    if (!empty()) {
                        String str = this.input;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        charAt = str.charAt(i2);
                        if (charAt != '\n' && charAt != '\r' && charAt != '\f') {
                            int hexChar2 = hexChar(charAt);
                            if (hexChar2 != -1) {
                                for (int i3 = 1; i3 <= 5 && !empty() && (hexChar = hexChar(this.input.charAt(this.position))) != -1; i3++) {
                                    this.position++;
                                    hexChar2 = (hexChar2 * 16) + hexChar;
                                }
                                sb.append((char) hexChar2);
                            }
                        }
                    }
                }
                sb.append(charAt);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }

        String nextPropertyValue() {
            if (empty()) {
                return null;
            }
            int i2 = this.position;
            int charAt = this.input.charAt(i2);
            int i3 = i2;
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !isEOL(charAt)) {
                if (!isWhitespace(charAt)) {
                    i3 = this.position + 1;
                }
                charAt = advanceChar();
            }
            if (this.position > i2) {
                return this.input.substring(i2, i3);
            }
            this.position = i2;
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0133  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean nextSimpleSelector(com.caverock.androidsvg.CSSParser.Selector r11) throws com.caverock.androidsvg.CSSParseException {
            /*
                Method dump skipped, instructions count: 310
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.CSSTextScanner.nextSimpleSelector(com.caverock.androidsvg.CSSParser$Selector):boolean");
        }

        String nextURL() {
            if (empty()) {
                return null;
            }
            int i2 = this.position;
            if (consume("url(")) {
                skipWhitespace();
                String nextCSSString = nextCSSString();
                if (nextCSSString == null) {
                    nextCSSString = nextLegacyURL();
                }
                if (nextCSSString == null) {
                    this.position = i2;
                    return null;
                }
                skipWhitespace();
                if (empty() || consume(")")) {
                    return nextCSSString;
                }
                this.position = i2;
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface PseudoClass {
        boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassAnPlusB implements PseudoClass {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f3750b;
        private boolean isFromStart;
        private boolean isOfType;
        private String nodeName;

        PseudoClassAnPlusB(int i2, int i3, boolean z, boolean z2, String str) {
            this.a = i2;
            this.f3750b = i3;
            this.isFromStart = z;
            this.isOfType = z2;
            this.nodeName = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i2;
            int i3;
            String nodeName = (this.isOfType && this.nodeName == null) ? svgElementBase.getNodeName() : this.nodeName;
            SVG.SvgContainer svgContainer = svgElementBase.parent;
            if (svgContainer != null) {
                Iterator<SVG.SvgObject> it = svgContainer.getChildren().iterator();
                i2 = 0;
                i3 = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) it.next();
                    if (svgElementBase2 == svgElementBase) {
                        i2 = i3;
                    }
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i3++;
                    }
                }
            } else {
                i2 = 0;
                i3 = 1;
            }
            int i4 = this.isFromStart ? i2 + 1 : i3 - i2;
            int i5 = this.a;
            if (i5 == 0) {
                return i4 == this.f3750b;
            }
            int i6 = this.f3750b;
            if ((i4 - i6) % i5 == 0) {
                return Integer.signum(i4 - i6) == 0 || Integer.signum(i4 - this.f3750b) == Integer.signum(this.a);
            }
            return false;
        }

        public String toString() {
            String str = this.isFromStart ? "" : "last-";
            return this.isOfType ? String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.a), Integer.valueOf(this.f3750b), this.nodeName) : String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.a), Integer.valueOf(this.f3750b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassEmpty implements PseudoClass {
        private PseudoClassEmpty() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return !(svgElementBase instanceof SVG.SvgContainer) || ((SVG.SvgContainer) svgElementBase).getChildren().size() == 0;
        }

        public String toString() {
            return "empty";
        }

        /* synthetic */ PseudoClassEmpty(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;
        
        private static final Map<String, PseudoClassIdents> cache = new HashMap();

        static {
            PseudoClassIdents[] values;
            for (PseudoClassIdents pseudoClassIdents : values()) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    cache.put(pseudoClassIdents.name().replace('_', '-'), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            PseudoClassIdents pseudoClassIdents = cache.get(str);
            return pseudoClassIdents != null ? pseudoClassIdents : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassNot implements PseudoClass {
        private List<Selector> selectorGroup;

        PseudoClassNot(List<Selector> list) {
            this.selectorGroup = list;
        }

        int getSpecificity() {
            int i2 = Integer.MIN_VALUE;
            for (Selector selector : this.selectorGroup) {
                int i3 = selector.specificity;
                if (i3 > i2) {
                    i2 = i3;
                }
            }
            return i2;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            for (Selector selector : this.selectorGroup) {
                if (CSSParser.ruleMatch(ruleMatchContext, selector, svgElementBase)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return "not(" + this.selectorGroup + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassNotSupported implements PseudoClass {
        private String clazz;

        PseudoClassNotSupported(String str) {
            this.clazz = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return false;
        }

        public String toString() {
            return this.clazz;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassOnlyChild implements PseudoClass {
        private boolean isOfType;
        private String nodeName;

        public PseudoClassOnlyChild(boolean z, String str) {
            this.isOfType = z;
            this.nodeName = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i2;
            String nodeName = (this.isOfType && this.nodeName == null) ? svgElementBase.getNodeName() : this.nodeName;
            SVG.SvgContainer svgContainer = svgElementBase.parent;
            if (svgContainer != null) {
                Iterator<SVG.SvgObject> it = svgContainer.getChildren().iterator();
                i2 = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) it.next();
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i2++;
                    }
                }
            } else {
                i2 = 1;
            }
            return i2 == 1;
        }

        public String toString() {
            return this.isOfType ? String.format("only-of-type <%s>", this.nodeName) : String.format("only-child", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassRoot implements PseudoClass {
        private PseudoClassRoot() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return svgElementBase.parent == null;
        }

        public String toString() {
            return "root";
        }

        /* synthetic */ PseudoClassRoot(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PseudoClassTarget implements PseudoClass {
        private PseudoClassTarget() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return ruleMatchContext != null && svgElementBase == ruleMatchContext.targetElement;
        }

        public String toString() {
            return "target";
        }

        /* synthetic */ PseudoClassTarget(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Rule {
        Selector selector;
        Source source;
        SVG.Style style;

        Rule(Selector selector, SVG.Style style, Source source) {
            this.selector = null;
            this.style = null;
            this.selector = selector;
            this.style = style;
            this.source = source;
        }

        public String toString() {
            return String.valueOf(this.selector) + " {...} (src=" + this.source + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RuleMatchContext {
        SVG.SvgElementBase targetElement;

        public String toString() {
            SVG.SvgElementBase svgElementBase = this.targetElement;
            return svgElementBase != null ? String.format("<%s id=\"%s\">", svgElementBase.getNodeName(), this.targetElement.id) : "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Ruleset {
        private List<Rule> rules = null;

        void add(Rule rule) {
            if (this.rules == null) {
                this.rules = new ArrayList();
            }
            for (int i2 = 0; i2 < this.rules.size(); i2++) {
                if (this.rules.get(i2).selector.specificity > rule.selector.specificity) {
                    this.rules.add(i2, rule);
                    return;
                }
            }
            this.rules.add(rule);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addAll(Ruleset ruleset) {
            if (ruleset.rules == null) {
                return;
            }
            if (this.rules == null) {
                this.rules = new ArrayList(ruleset.rules.size());
            }
            for (Rule rule : ruleset.rules) {
                add(rule);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Rule> getRules() {
            return this.rules;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEmpty() {
            List<Rule> list = this.rules;
            return list == null || list.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void removeFromSource(Source source) {
            List<Rule> list = this.rules;
            if (list == null) {
                return;
            }
            Iterator<Rule> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().source == source) {
                    it.remove();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int ruleCount() {
            List<Rule> list = this.rules;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.rules == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (Rule rule : this.rules) {
                sb.append(rule.toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SimpleSelector {
        Combinator combinator;
        String tag;
        List<Attrib> attribs = null;
        List<PseudoClass> pseudos = null;

        SimpleSelector(Combinator combinator, String str) {
            this.combinator = null;
            this.tag = null;
            this.combinator = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        void addAttrib(String str, AttribOp attribOp, String str2) {
            if (this.attribs == null) {
                this.attribs = new ArrayList();
            }
            this.attribs.add(new Attrib(str, attribOp, str2));
        }

        void addPseudo(PseudoClass pseudoClass) {
            if (this.pseudos == null) {
                this.pseudos = new ArrayList();
            }
            this.pseudos.add(pseudoClass);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Combinator combinator = this.combinator;
            if (combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.tag;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<Attrib> list = this.attribs;
            if (list != null) {
                for (Attrib attrib : list) {
                    sb.append('[');
                    sb.append(attrib.name);
                    int i2 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[attrib.operation.ordinal()];
                    if (i2 == 1) {
                        sb.append('=');
                        sb.append(attrib.value);
                    } else if (i2 == 2) {
                        sb.append("~=");
                        sb.append(attrib.value);
                    } else if (i2 == 3) {
                        sb.append("|=");
                        sb.append(attrib.value);
                    }
                    sb.append(']');
                }
            }
            List<PseudoClass> list2 = this.pseudos;
            if (list2 != null) {
                for (PseudoClass pseudoClass : list2) {
                    sb.append(':');
                    sb.append(pseudoClass);
                }
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum Source {
        Document,
        RenderOptions
    }

    CSSParser() {
        this(MediaType.screen, Source.Document);
    }

    private static int getChildPosition(List<SVG.SvgContainer> list, int i2, SVG.SvgElementBase svgElementBase) {
        int i3 = 0;
        if (i2 < 0) {
            return 0;
        }
        SVG.SvgContainer svgContainer = list.get(i2);
        SVG.SvgContainer svgContainer2 = svgElementBase.parent;
        if (svgContainer != svgContainer2) {
            return -1;
        }
        for (SVG.SvgObject svgObject : svgContainer2.getChildren()) {
            if (svgObject == svgElementBase) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean mediaMatches(String str, MediaType mediaType) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return mediaMatches(parseMediaList(cSSTextScanner), mediaType);
    }

    private void parseAtRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        String nextIdentifier = cSSTextScanner.nextIdentifier();
        cSSTextScanner.skipWhitespace();
        if (nextIdentifier != null) {
            if (!this.inMediaRule && nextIdentifier.equals(SVGParser.XML_STYLESHEET_ATTR_MEDIA)) {
                List<MediaType> parseMediaList = parseMediaList(cSSTextScanner);
                if (cSSTextScanner.consume('{')) {
                    cSSTextScanner.skipWhitespace();
                    if (mediaMatches(parseMediaList, this.deviceMediaType)) {
                        this.inMediaRule = true;
                        ruleset.addAll(parseRuleset(cSSTextScanner));
                        this.inMediaRule = false;
                    } else {
                        parseRuleset(cSSTextScanner);
                    }
                    if (!cSSTextScanner.empty() && !cSSTextScanner.consume('}')) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                } else {
                    throw new CSSParseException("Invalid @media rule: missing rule set");
                }
            } else if (!this.inMediaRule && nextIdentifier.equals("import")) {
                String nextURL = cSSTextScanner.nextURL();
                if (nextURL == null) {
                    nextURL = cSSTextScanner.nextCSSString();
                }
                if (nextURL != null) {
                    cSSTextScanner.skipWhitespace();
                    List<MediaType> parseMediaList2 = parseMediaList(cSSTextScanner);
                    if (!cSSTextScanner.empty() && !cSSTextScanner.consume(';')) {
                        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
                    }
                    if (SVG.getFileResolver() != null && mediaMatches(parseMediaList2, this.deviceMediaType)) {
                        String resolveCSSStyleSheet = SVG.getFileResolver().resolveCSSStyleSheet(nextURL);
                        if (resolveCSSStyleSheet == null) {
                            return;
                        }
                        ruleset.addAll(parse(resolveCSSStyleSheet));
                    }
                } else {
                    throw new CSSParseException("Invalid @import rule: expected string or url()");
                }
            } else {
                warn("Ignoring @%s rule", nextIdentifier);
                skipAtRule(cSSTextScanner);
            }
            cSSTextScanner.skipWhitespace();
            return;
        }
        throw new CSSParseException("Invalid '@' rule");
    }

    public static List<String> parseClassAttribute(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        ArrayList arrayList = null;
        while (!cSSTextScanner.empty()) {
            String nextToken = cSSTextScanner.nextToken();
            if (nextToken != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(nextToken);
                cSSTextScanner.skipWhitespace();
            }
        }
        return arrayList;
    }

    private SVG.Style parseDeclarations(CSSTextScanner cSSTextScanner) throws CSSParseException {
        SVG.Style style = new SVG.Style();
        do {
            String nextIdentifier = cSSTextScanner.nextIdentifier();
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.consume(':')) {
                cSSTextScanner.skipWhitespace();
                String nextPropertyValue = cSSTextScanner.nextPropertyValue();
                if (nextPropertyValue != null) {
                    cSSTextScanner.skipWhitespace();
                    if (cSSTextScanner.consume('!')) {
                        cSSTextScanner.skipWhitespace();
                        if (cSSTextScanner.consume("important")) {
                            cSSTextScanner.skipWhitespace();
                        } else {
                            throw new CSSParseException("Malformed rule set: found unexpected '!'");
                        }
                    }
                    cSSTextScanner.consume(';');
                    SVGParser.processStyleProperty(style, nextIdentifier, nextPropertyValue);
                    cSSTextScanner.skipWhitespace();
                    if (cSSTextScanner.empty()) {
                        break;
                    }
                } else {
                    throw new CSSParseException("Expected property value");
                }
            } else {
                throw new CSSParseException("Expected ':'");
            }
        } while (!cSSTextScanner.consume('}'));
        return style;
    }

    private static List<MediaType> parseMediaList(CSSTextScanner cSSTextScanner) {
        String nextWord;
        ArrayList arrayList = new ArrayList();
        while (!cSSTextScanner.empty() && (nextWord = cSSTextScanner.nextWord()) != null) {
            try {
                arrayList.add(MediaType.valueOf(nextWord));
            } catch (IllegalArgumentException unused) {
            }
            if (!cSSTextScanner.skipCommaWhitespace()) {
                break;
            }
        }
        return arrayList;
    }

    private boolean parseRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        List<Selector> nextSelectorGroup = cSSTextScanner.nextSelectorGroup();
        if (nextSelectorGroup == null || nextSelectorGroup.isEmpty()) {
            return false;
        }
        if (cSSTextScanner.consume('{')) {
            cSSTextScanner.skipWhitespace();
            SVG.Style parseDeclarations = parseDeclarations(cSSTextScanner);
            cSSTextScanner.skipWhitespace();
            for (Selector selector : nextSelectorGroup) {
                ruleset.add(new Rule(selector, parseDeclarations, this.source));
            }
            return true;
        }
        throw new CSSParseException("Malformed rule block: expected '{'");
    }

    private Ruleset parseRuleset(CSSTextScanner cSSTextScanner) {
        Ruleset ruleset = new Ruleset();
        while (!cSSTextScanner.empty()) {
            try {
                if (!cSSTextScanner.consume("<!--") && !cSSTextScanner.consume("-->")) {
                    if (cSSTextScanner.consume('@')) {
                        parseAtRule(ruleset, cSSTextScanner);
                    } else if (!parseRule(ruleset, cSSTextScanner)) {
                        break;
                    }
                }
            } catch (CSSParseException e2) {
                Log.e(TAG, "CSS parser terminated early due to error: " + e2.getMessage());
            }
        }
        return ruleset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, SVG.SvgElementBase svgElementBase) {
        ArrayList arrayList = new ArrayList();
        for (SVG.SvgContainer svgContainer = svgElementBase.parent; svgContainer != null; svgContainer = ((SVG.SvgObject) svgContainer).parent) {
            arrayList.add(0, svgContainer);
        }
        int size = arrayList.size() - 1;
        if (selector.size() == 1) {
            return selectorMatch(ruleMatchContext, selector.get(0), arrayList, size, svgElementBase);
        }
        return ruleMatch(ruleMatchContext, selector, selector.size() - 1, arrayList, size, svgElementBase);
    }

    private static boolean ruleMatchOnAncestors(RuleMatchContext ruleMatchContext, Selector selector, int i2, List<SVG.SvgContainer> list, int i3) {
        SimpleSelector simpleSelector = selector.get(i2);
        SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) list.get(i3);
        if (selectorMatch(ruleMatchContext, simpleSelector, list, i3, svgElementBase)) {
            Combinator combinator = simpleSelector.combinator;
            if (combinator == Combinator.DESCENDANT) {
                if (i2 == 0) {
                    return true;
                }
                while (i3 > 0) {
                    i3--;
                    if (ruleMatchOnAncestors(ruleMatchContext, selector, i2 - 1, list, i3)) {
                        return true;
                    }
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return ruleMatchOnAncestors(ruleMatchContext, selector, i2 - 1, list, i3 - 1);
            } else {
                int childPosition = getChildPosition(list, i3, svgElementBase);
                if (childPosition <= 0) {
                    return false;
                }
                return ruleMatch(ruleMatchContext, selector, i2 - 1, list, i3, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
            }
        }
        return false;
    }

    private static boolean selectorMatch(RuleMatchContext ruleMatchContext, SimpleSelector simpleSelector, List<SVG.SvgContainer> list, int i2, SVG.SvgElementBase svgElementBase) {
        List<String> list2;
        String str = simpleSelector.tag;
        if (str == null || str.equals(svgElementBase.getNodeName().toLowerCase(Locale.US))) {
            List<Attrib> list3 = simpleSelector.attribs;
            if (list3 != null) {
                for (Attrib attrib : list3) {
                    String str2 = attrib.name;
                    str2.hashCode();
                    if (!str2.equals(ID)) {
                        if (!str2.equals(CLASS) || (list2 = svgElementBase.classNames) == null || !list2.contains(attrib.value)) {
                            return false;
                        }
                    } else if (!attrib.value.equals(svgElementBase.id)) {
                        return false;
                    }
                }
            }
            List<PseudoClass> list4 = simpleSelector.pseudos;
            if (list4 != null) {
                for (PseudoClass pseudoClass : list4) {
                    if (!pseudoClass.matches(ruleMatchContext, svgElementBase)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private void skipAtRule(CSSTextScanner cSSTextScanner) {
        int i2 = 0;
        while (!cSSTextScanner.empty()) {
            int intValue = cSSTextScanner.nextChar().intValue();
            if (intValue == 59 && i2 == 0) {
                return;
            }
            if (intValue == 123) {
                i2++;
            } else if (intValue == 125 && i2 > 0 && i2 - 1 == 0) {
                return;
            }
        }
    }

    private static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ruleset parse(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return parseRuleset(cSSTextScanner);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSSParser(Source source) {
        this(MediaType.screen, source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Selector {
        List<SimpleSelector> simpleSelectors;
        int specificity;

        private Selector() {
            this.simpleSelectors = null;
            this.specificity = 0;
        }

        void add(SimpleSelector simpleSelector) {
            if (this.simpleSelectors == null) {
                this.simpleSelectors = new ArrayList();
            }
            this.simpleSelectors.add(simpleSelector);
        }

        void addedAttributeOrPseudo() {
            this.specificity += 1000;
        }

        void addedElement() {
            this.specificity++;
        }

        void addedIdAttribute() {
            this.specificity += CSSParser.SPECIFICITY_ID_ATTRIBUTE;
        }

        SimpleSelector get(int i2) {
            return this.simpleSelectors.get(i2);
        }

        boolean isEmpty() {
            List<SimpleSelector> list = this.simpleSelectors;
            return list == null || list.isEmpty();
        }

        int size() {
            List<SimpleSelector> list = this.simpleSelectors;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (SimpleSelector simpleSelector : this.simpleSelectors) {
                sb.append(simpleSelector);
                sb.append(TokenParser.SP);
            }
            sb.append('[');
            sb.append(this.specificity);
            sb.append(']');
            return sb.toString();
        }

        /* synthetic */ Selector(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSSParser(MediaType mediaType, Source source) {
        this.deviceMediaType = null;
        this.source = null;
        this.inMediaRule = false;
        this.deviceMediaType = mediaType;
        this.source = source;
    }

    private static boolean mediaMatches(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all) {
                return true;
            }
            if (mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, int i2, List<SVG.SvgContainer> list, int i3, SVG.SvgElementBase svgElementBase) {
        SimpleSelector simpleSelector = selector.get(i2);
        if (selectorMatch(ruleMatchContext, simpleSelector, list, i3, svgElementBase)) {
            Combinator combinator = simpleSelector.combinator;
            if (combinator == Combinator.DESCENDANT) {
                if (i2 == 0) {
                    return true;
                }
                while (i3 >= 0) {
                    if (ruleMatchOnAncestors(ruleMatchContext, selector, i2 - 1, list, i3)) {
                        return true;
                    }
                    i3--;
                }
                return false;
            } else if (combinator == Combinator.CHILD) {
                return ruleMatchOnAncestors(ruleMatchContext, selector, i2 - 1, list, i3);
            } else {
                int childPosition = getChildPosition(list, i3, svgElementBase);
                if (childPosition <= 0) {
                    return false;
                }
                return ruleMatch(ruleMatchContext, selector, i2 - 1, list, i3, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
            }
        }
        return false;
    }
}