package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.message.TokenParser;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SVGParser {
    private static final String CURRENTCOLOR = "currentColor";
    public static final int ENTITY_WATCH_BUFFER_SIZE = 4096;
    private static final String FEATURE_STRING_PREFIX = "http://www.w3.org/TR/SVG11/feature#";
    private static final String NONE = "none";
    private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
    private static final String TAG = "SVGParser";
    private static final String VALID_DISPLAY_VALUES = "|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|";
    private static final String VALID_VISIBILITY_VALUES = "|visible|hidden|collapse|";
    private static final String XLINK_NAMESPACE = "http://www.w3.org/1999/xlink";
    public static final String XML_STYLESHEET_ATTR_ALTERNATE = "alternate";
    public static final String XML_STYLESHEET_ATTR_ALTERNATE_NO = "no";
    public static final String XML_STYLESHEET_ATTR_HREF = "href";
    public static final String XML_STYLESHEET_ATTR_MEDIA = "media";
    public static final String XML_STYLESHEET_ATTR_MEDIA_ALL = "all";
    public static final String XML_STYLESHEET_ATTR_TYPE = "type";
    private static final String XML_STYLESHEET_PROCESSING_INSTRUCTION = "xml-stylesheet";
    private int ignoreDepth;
    private SVG svgDocument = null;
    private SVG.SvgContainer currentElement = null;
    private boolean ignoring = false;
    private boolean inMetadataElement = false;
    private SVGElem metadataTag = null;
    private StringBuilder metadataElementContents = null;
    private boolean inStyleElement = false;
    private StringBuilder styleElementContents = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.caverock.androidsvg.SVGParser$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem;

        static {
            int[] iArr = new int[SVGAttr.values().length];
            $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr = iArr;
            try {
                iArr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.image_rendering.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewBox.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.type.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.media.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            int[] iArr2 = new int[SVGElem.values().length];
            $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem = iArr2;
            try {
                iArr2[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.defs.ordinal()] = 4;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused120) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AspectRatioKeywords {
        private static final Map<String, PreserveAspectRatio.Alignment> aspectRatioKeywords;

        static {
            HashMap hashMap = new HashMap(10);
            aspectRatioKeywords = hashMap;
            hashMap.put(SVGParser.NONE, PreserveAspectRatio.Alignment.none);
            hashMap.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            hashMap.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            hashMap.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            hashMap.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            hashMap.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            hashMap.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            hashMap.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            hashMap.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            hashMap.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }

        private AspectRatioKeywords() {
        }

        static PreserveAspectRatio.Alignment get(String str) {
            return aspectRatioKeywords.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ColourKeywords {
        private static final Map<String, Integer> colourKeywords;

        static {
            HashMap hashMap = new HashMap(47);
            colourKeywords = hashMap;
            hashMap.put("aliceblue", -984833);
            hashMap.put("antiquewhite", -332841);
            hashMap.put("aqua", -16711681);
            hashMap.put("aquamarine", -8388652);
            hashMap.put("azure", -983041);
            hashMap.put("beige", -657956);
            hashMap.put("bisque", -6972);
            hashMap.put("black", -16777216);
            hashMap.put("blanchedalmond", -5171);
            hashMap.put("blue", -16776961);
            hashMap.put("blueviolet", -7722014);
            hashMap.put("brown", -5952982);
            hashMap.put("burlywood", -2180985);
            hashMap.put("cadetblue", -10510688);
            hashMap.put("chartreuse", -8388864);
            hashMap.put("chocolate", -2987746);
            hashMap.put("coral", -32944);
            hashMap.put("cornflowerblue", -10185235);
            hashMap.put("cornsilk", -1828);
            hashMap.put("crimson", -2354116);
            hashMap.put("cyan", -16711681);
            hashMap.put("darkblue", -16777077);
            hashMap.put("darkcyan", -16741493);
            hashMap.put("darkgoldenrod", -4684277);
            hashMap.put("darkgray", -5658199);
            hashMap.put("darkgreen", -16751616);
            hashMap.put("darkgrey", -5658199);
            hashMap.put("darkkhaki", -4343957);
            hashMap.put("darkmagenta", -7667573);
            hashMap.put("darkolivegreen", -11179217);
            hashMap.put("darkorange", -29696);
            hashMap.put("darkorchid", -6737204);
            hashMap.put("darkred", -7667712);
            hashMap.put("darksalmon", -1468806);
            hashMap.put("darkseagreen", -7357297);
            hashMap.put("darkslateblue", -12042869);
            hashMap.put("darkslategray", -13676721);
            hashMap.put("darkslategrey", -13676721);
            hashMap.put("darkturquoise", -16724271);
            hashMap.put("darkviolet", -7077677);
            hashMap.put("deeppink", -60269);
            hashMap.put("deepskyblue", -16728065);
            hashMap.put("dimgray", -9868951);
            hashMap.put("dimgrey", -9868951);
            hashMap.put("dodgerblue", -14774017);
            hashMap.put("firebrick", -5103070);
            hashMap.put("floralwhite", -1296);
            hashMap.put("forestgreen", -14513374);
            hashMap.put("fuchsia", -65281);
            hashMap.put("gainsboro", -2302756);
            hashMap.put("ghostwhite", -460545);
            hashMap.put("gold", -10496);
            hashMap.put("goldenrod", -2448096);
            hashMap.put("gray", -8355712);
            hashMap.put("green", -16744448);
            hashMap.put("greenyellow", -5374161);
            hashMap.put("grey", -8355712);
            hashMap.put("honeydew", -983056);
            hashMap.put("hotpink", -38476);
            hashMap.put("indianred", -3318692);
            hashMap.put("indigo", -11861886);
            hashMap.put("ivory", -16);
            hashMap.put("khaki", -989556);
            hashMap.put("lavender", -1644806);
            hashMap.put("lavenderblush", -3851);
            hashMap.put("lawngreen", -8586240);
            hashMap.put("lemonchiffon", -1331);
            hashMap.put("lightblue", -5383962);
            hashMap.put("lightcoral", -1015680);
            hashMap.put("lightcyan", -2031617);
            hashMap.put("lightgoldenrodyellow", -329006);
            hashMap.put("lightgray", -2894893);
            hashMap.put("lightgreen", -7278960);
            hashMap.put("lightgrey", -2894893);
            hashMap.put("lightpink", -18751);
            hashMap.put("lightsalmon", -24454);
            hashMap.put("lightseagreen", -14634326);
            hashMap.put("lightskyblue", -7876870);
            hashMap.put("lightslategray", -8943463);
            hashMap.put("lightslategrey", -8943463);
            hashMap.put("lightsteelblue", -5192482);
            hashMap.put("lightyellow", -32);
            hashMap.put("lime", -16711936);
            hashMap.put("limegreen", -13447886);
            hashMap.put("linen", -331546);
            hashMap.put("magenta", -65281);
            hashMap.put("maroon", -8388608);
            hashMap.put("mediumaquamarine", -10039894);
            hashMap.put("mediumblue", -16777011);
            hashMap.put("mediumorchid", -4565549);
            hashMap.put("mediumpurple", -7114533);
            hashMap.put("mediumseagreen", -12799119);
            hashMap.put("mediumslateblue", -8689426);
            hashMap.put("mediumspringgreen", -16713062);
            hashMap.put("mediumturquoise", -12004916);
            hashMap.put("mediumvioletred", -3730043);
            hashMap.put("midnightblue", -15132304);
            hashMap.put("mintcream", -655366);
            hashMap.put("mistyrose", -6943);
            hashMap.put("moccasin", -6987);
            hashMap.put("navajowhite", -8531);
            hashMap.put("navy", -16777088);
            hashMap.put("oldlace", -133658);
            hashMap.put("olive", -8355840);
            hashMap.put("olivedrab", -9728477);
            hashMap.put("orange", -23296);
            hashMap.put("orangered", -47872);
            hashMap.put("orchid", -2461482);
            hashMap.put("palegoldenrod", -1120086);
            hashMap.put("palegreen", -6751336);
            hashMap.put("paleturquoise", -5247250);
            hashMap.put("palevioletred", -2396013);
            hashMap.put("papayawhip", -4139);
            hashMap.put("peachpuff", -9543);
            hashMap.put("peru", -3308225);
            hashMap.put("pink", -16181);
            hashMap.put("plum", -2252579);
            hashMap.put("powderblue", -5185306);
            hashMap.put("purple", -8388480);
            hashMap.put("rebeccapurple", -10079335);
            hashMap.put("red", -65536);
            hashMap.put("rosybrown", -4419697);
            hashMap.put("royalblue", -12490271);
            hashMap.put("saddlebrown", -7650029);
            hashMap.put("salmon", -360334);
            hashMap.put("sandybrown", -744352);
            hashMap.put("seagreen", -13726889);
            hashMap.put("seashell", -2578);
            hashMap.put("sienna", -6270419);
            hashMap.put("silver", -4144960);
            hashMap.put("skyblue", -7876885);
            hashMap.put("slateblue", -9807155);
            hashMap.put("slategray", -9404272);
            hashMap.put("slategrey", -9404272);
            hashMap.put("snow", -1286);
            hashMap.put("springgreen", -16711809);
            hashMap.put("steelblue", -12156236);
            hashMap.put("tan", -2968436);
            hashMap.put("teal", -16744320);
            hashMap.put("thistle", -2572328);
            hashMap.put("tomato", -40121);
            hashMap.put("turquoise", -12525360);
            hashMap.put("violet", -1146130);
            hashMap.put("wheat", -663885);
            hashMap.put("white", -1);
            hashMap.put("whitesmoke", -657931);
            hashMap.put("yellow", -256);
            hashMap.put("yellowgreen", -6632142);
            hashMap.put("transparent", 0);
        }

        private ColourKeywords() {
        }

        static Integer get(String str) {
            return colourKeywords.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FontSizeKeywords {
        private static final Map<String, SVG.Length> fontSizeKeywords;

        static {
            HashMap hashMap = new HashMap(9);
            fontSizeKeywords = hashMap;
            SVG.Unit unit = SVG.Unit.pt;
            hashMap.put("xx-small", new SVG.Length(0.694f, unit));
            hashMap.put("x-small", new SVG.Length(0.833f, unit));
            hashMap.put("small", new SVG.Length(10.0f, unit));
            hashMap.put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_MEDIUM, new SVG.Length(12.0f, unit));
            hashMap.put("large", new SVG.Length(14.4f, unit));
            hashMap.put("x-large", new SVG.Length(17.3f, unit));
            hashMap.put("xx-large", new SVG.Length(20.7f, unit));
            SVG.Unit unit2 = SVG.Unit.percent;
            hashMap.put("smaller", new SVG.Length(83.33f, unit2));
            hashMap.put("larger", new SVG.Length(120.0f, unit2));
        }

        private FontSizeKeywords() {
        }

        static SVG.Length get(String str) {
            return fontSizeKeywords.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FontWeightKeywords {
        private static final Map<String, Integer> fontWeightKeywords;

        static {
            HashMap hashMap = new HashMap(13);
            fontWeightKeywords = hashMap;
            Integer valueOf = Integer.valueOf((int) HttpStatus.SC_BAD_REQUEST);
            hashMap.put("normal", valueOf);
            hashMap.put("bold", 700);
            hashMap.put("bolder", 1);
            hashMap.put("lighter", -1);
            hashMap.put("100", 100);
            hashMap.put("200", 200);
            hashMap.put("300", Integer.valueOf((int) HttpStatus.SC_MULTIPLE_CHOICES));
            hashMap.put("400", valueOf);
            hashMap.put("500", Integer.valueOf((int) HttpStatus.SC_INTERNAL_SERVER_ERROR));
            hashMap.put("600", 600);
            hashMap.put("700", 700);
            hashMap.put("800", 800);
            hashMap.put("900", 900);
        }

        private FontWeightKeywords() {
        }

        static Integer get(String str) {
            return fontWeightKeywords.get(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SAXHandler extends DefaultHandler2 {
        private SAXHandler() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i2, int i3) throws SAXException {
            SVGParser.this.text(new String(cArr, i2, i3));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            SVGParser.this.endDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            SVGParser.this.endElement(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            SVGParser.this.handleProcessingInstruction(str, SVGParser.this.parseProcessingInstructionAttributes(new TextScanner(str2)));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            SVGParser.this.startDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            SVGParser.this.startElement(str, str2, str3, attributes);
        }

        /* synthetic */ SAXHandler(SVGParser sVGParser, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;
        
        private static final Map<String, SVGAttr> cache = new HashMap();

        static {
            SVGAttr[] values;
            for (SVGAttr sVGAttr : values()) {
                if (sVGAttr == CLASS) {
                    cache.put("class", sVGAttr);
                } else if (sVGAttr != UNSUPPORTED) {
                    cache.put(sVGAttr.name().replace('_', '-'), sVGAttr);
                }
            }
        }

        public static SVGAttr fromString(String str) {
            SVGAttr sVGAttr = cache.get(str);
            return sVGAttr != null ? sVGAttr : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum SVGElem {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;
        
        private static final Map<String, SVGElem> cache = new HashMap();

        static {
            SVGElem[] values;
            for (SVGElem sVGElem : values()) {
                if (sVGElem == SWITCH) {
                    cache.put("switch", sVGElem);
                } else if (sVGElem != UNSUPPORTED) {
                    cache.put(sVGElem.name(), sVGElem);
                }
            }
        }

        public static SVGElem fromString(String str) {
            SVGElem sVGElem = cache.get(str);
            return sVGElem != null ? sVGElem : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TextScanner {
        String input;
        int inputLength;
        int position = 0;
        private NumberParser numberParser = new NumberParser();

        /* JADX INFO: Access modifiers changed from: package-private */
        public TextScanner(String str) {
            this.inputLength = 0;
            String trim = str.trim();
            this.input = trim;
            this.inputLength = trim.length();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int advanceChar() {
            int i2 = this.position;
            int i3 = this.inputLength;
            if (i2 == i3) {
                return -1;
            }
            int i4 = i2 + 1;
            this.position = i4;
            if (i4 < i3) {
                return this.input.charAt(i4);
            }
            return -1;
        }

        String ahead() {
            int i2 = this.position;
            while (!empty() && !isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
            String substring = this.input.substring(i2, this.position);
            this.position = i2;
            return substring;
        }

        Boolean checkedNextFlag(Object obj) {
            if (obj == null) {
                return null;
            }
            skipCommaWhitespace();
            return nextFlag();
        }

        float checkedNextFloat(float f2) {
            if (Float.isNaN(f2)) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean consume(char c2) {
            int i2 = this.position;
            boolean z = i2 < this.inputLength && this.input.charAt(i2) == c2;
            if (z) {
                this.position++;
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean empty() {
            return this.position == this.inputLength;
        }

        boolean hasLetter() {
            int i2 = this.position;
            if (i2 == this.inputLength) {
                return false;
            }
            char charAt = this.input.charAt(i2);
            return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEOL(int i2) {
            return i2 == 10 || i2 == 13;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isWhitespace(int i2) {
            return i2 == 32 || i2 == 10 || i2 == 13 || i2 == 9;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Integer nextChar() {
            int i2 = this.position;
            if (i2 == this.inputLength) {
                return null;
            }
            String str = this.input;
            this.position = i2 + 1;
            return Integer.valueOf(str.charAt(i2));
        }

        Boolean nextFlag() {
            int i2 = this.position;
            if (i2 == this.inputLength) {
                return null;
            }
            char charAt = this.input.charAt(i2);
            if (charAt == '0' || charAt == '1') {
                this.position++;
                return Boolean.valueOf(charAt == '1');
            }
            return null;
        }

        float nextFloat() {
            float parseNumber = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(parseNumber)) {
                this.position = this.numberParser.getEndPos();
            }
            return parseNumber;
        }

        String nextFunction() {
            if (empty()) {
                return null;
            }
            int i2 = this.position;
            int charAt = this.input.charAt(i2);
            while (true) {
                if ((charAt < 97 || charAt > 122) && (charAt < 65 || charAt > 90)) {
                    break;
                }
                charAt = advanceChar();
            }
            int i3 = this.position;
            while (isWhitespace(charAt)) {
                charAt = advanceChar();
            }
            if (charAt == 40) {
                this.position++;
                return this.input.substring(i2, i3);
            }
            this.position = i2;
            return null;
        }

        SVG.Length nextLength() {
            float nextFloat = nextFloat();
            if (Float.isNaN(nextFloat)) {
                return null;
            }
            SVG.Unit nextUnit = nextUnit();
            if (nextUnit == null) {
                return new SVG.Length(nextFloat, SVG.Unit.px);
            }
            return new SVG.Length(nextFloat, nextUnit);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String nextQuotedString() {
            if (empty()) {
                return null;
            }
            int i2 = this.position;
            char charAt = this.input.charAt(i2);
            if (charAt == '\'' || charAt == '\"') {
                int advanceChar = advanceChar();
                while (advanceChar != -1 && advanceChar != charAt) {
                    advanceChar = advanceChar();
                }
                if (advanceChar == -1) {
                    this.position = i2;
                    return null;
                }
                int i3 = this.position + 1;
                this.position = i3;
                return this.input.substring(i2 + 1, i3 - 1);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String nextToken() {
            return nextToken(TokenParser.SP, false);
        }

        String nextTokenWithWhitespace(char c2) {
            return nextToken(c2, true);
        }

        SVG.Unit nextUnit() {
            if (empty()) {
                return null;
            }
            if (this.input.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            }
            int i2 = this.position;
            if (i2 > this.inputLength - 2) {
                return null;
            }
            try {
                SVG.Unit valueOf = SVG.Unit.valueOf(this.input.substring(i2, i2 + 2).toLowerCase(Locale.US));
                this.position += 2;
                return valueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String nextWord() {
            if (empty()) {
                return null;
            }
            int i2 = this.position;
            char charAt = this.input.charAt(i2);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int advanceChar = advanceChar();
                while (true) {
                    if ((advanceChar < 65 || advanceChar > 90) && (advanceChar < 97 || advanceChar > 122)) {
                        break;
                    }
                    advanceChar = advanceChar();
                }
                return this.input.substring(i2, this.position);
            }
            this.position = i2;
            return null;
        }

        float possibleNextFloat() {
            skipCommaWhitespace();
            float parseNumber = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(parseNumber)) {
                this.position = this.numberParser.getEndPos();
            }
            return parseNumber;
        }

        String restOfText() {
            if (empty()) {
                return null;
            }
            int i2 = this.position;
            this.position = this.inputLength;
            return this.input.substring(i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean skipCommaWhitespace() {
            skipWhitespace();
            int i2 = this.position;
            if (i2 != this.inputLength && this.input.charAt(i2) == ',') {
                this.position++;
                skipWhitespace();
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void skipWhitespace() {
            while (true) {
                int i2 = this.position;
                if (i2 >= this.inputLength || !isWhitespace(this.input.charAt(i2))) {
                    return;
                }
                this.position++;
            }
        }

        String nextToken(char c2) {
            return nextToken(c2, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean consume(String str) {
            int length = str.length();
            int i2 = this.position;
            boolean z = i2 <= this.inputLength - length && this.input.substring(i2, i2 + length).equals(str);
            if (z) {
                this.position += length;
            }
            return z;
        }

        String nextToken(char c2, boolean z) {
            if (empty()) {
                return null;
            }
            char charAt = this.input.charAt(this.position);
            if ((z || !isWhitespace(charAt)) && charAt != c2) {
                int i2 = this.position;
                int advanceChar = advanceChar();
                while (advanceChar != -1 && advanceChar != c2 && (z || !isWhitespace(advanceChar))) {
                    advanceChar = advanceChar();
                }
                return this.input.substring(i2, this.position);
            }
            return null;
        }

        float checkedNextFloat(Boolean bool) {
            if (bool == null) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class XPPAttributesWrapper implements Attributes {
        private XmlPullParser parser;

        public XPPAttributesWrapper(XmlPullParser xmlPullParser) {
            this.parser = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.parser.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i2) {
            return this.parser.getAttributeName(i2);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i2) {
            String attributeName = this.parser.getAttributeName(i2);
            if (this.parser.getAttributePrefix(i2) != null) {
                return this.parser.getAttributePrefix(i2) + ':' + attributeName;
            }
            return attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i2) {
            return this.parser.getAttributeNamespace(i2);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i2) {
            return this.parser.getAttributeValue(i2);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }
    }

    private void appendToTextContainer(String str) throws SVGParseException {
        SVG.SvgConditionalContainer svgConditionalContainer = (SVG.SvgConditionalContainer) this.currentElement;
        int size = svgConditionalContainer.children.size();
        SVG.SvgObject svgObject = size == 0 ? null : svgConditionalContainer.children.get(size - 1);
        if (svgObject instanceof SVG.TextSequence) {
            StringBuilder sb = new StringBuilder();
            SVG.TextSequence textSequence = (SVG.TextSequence) svgObject;
            sb.append(textSequence.text);
            sb.append(str);
            textSequence.text = sb.toString();
            return;
        }
        this.currentElement.addChild(new SVG.TextSequence(str));
    }

    private void circle(Attributes attributes) throws SVGParseException {
        debug("<circle>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Circle circle = new SVG.Circle();
            circle.document = this.svgDocument;
            circle.parent = this.currentElement;
            parseAttributesCore(circle, attributes);
            parseAttributesStyle(circle, attributes);
            parseAttributesTransform(circle, attributes);
            parseAttributesConditional(circle, attributes);
            parseAttributesCircle(circle, attributes);
            this.currentElement.addChild(circle);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private static int clamp255(float f2) {
        if (f2 < 0.0f) {
            return 0;
        }
        if (f2 > 255.0f) {
            return 255;
        }
        return Math.round(f2);
    }

    private void clipPath(Attributes attributes) throws SVGParseException {
        debug("<clipPath>", new Object[0]);
        if (this.currentElement != null) {
            SVG.ClipPath clipPath = new SVG.ClipPath();
            clipPath.document = this.svgDocument;
            clipPath.parent = this.currentElement;
            parseAttributesCore(clipPath, attributes);
            parseAttributesStyle(clipPath, attributes);
            parseAttributesTransform(clipPath, attributes);
            parseAttributesConditional(clipPath, attributes);
            parseAttributesClipPath(clipPath, attributes);
            this.currentElement.addChild(clipPath);
            this.currentElement = clipPath;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void debug(String str, Object... objArr) {
    }

    private void defs(Attributes attributes) throws SVGParseException {
        debug("<defs>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Defs defs = new SVG.Defs();
            defs.document = this.svgDocument;
            defs.parent = this.currentElement;
            parseAttributesCore(defs, attributes);
            parseAttributesStyle(defs, attributes);
            parseAttributesTransform(defs, attributes);
            this.currentElement.addChild(defs);
            this.currentElement = defs;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void dumpNode(SVG.SvgObject svgObject, String str) {
        Log.d(TAG, str + svgObject);
        if (svgObject instanceof SVG.SvgConditionalContainer) {
            String str2 = str + "  ";
            for (SVG.SvgObject svgObject2 : ((SVG.SvgConditionalContainer) svgObject).children) {
                dumpNode(svgObject2, str2);
            }
        }
    }

    private void ellipse(Attributes attributes) throws SVGParseException {
        debug("<ellipse>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Ellipse ellipse = new SVG.Ellipse();
            ellipse.document = this.svgDocument;
            ellipse.parent = this.currentElement;
            parseAttributesCore(ellipse, attributes);
            parseAttributesStyle(ellipse, attributes);
            parseAttributesTransform(ellipse, attributes);
            parseAttributesConditional(ellipse, attributes);
            parseAttributesEllipse(ellipse, attributes);
            this.currentElement.addChild(ellipse);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endDocument() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endElement(String str, String str2, String str3) throws SVGParseException {
        if (this.ignoring) {
            int i2 = this.ignoreDepth - 1;
            this.ignoreDepth = i2;
            if (i2 == 0) {
                this.ignoring = false;
                return;
            }
        }
        if (SVG_NAMESPACE.equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.fromString(str2).ordinal()];
            if (i3 != 1 && i3 != 2 && i3 != 4 && i3 != 5 && i3 != 13 && i3 != 14) {
                switch (i3) {
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 31:
                        break;
                    case 22:
                    case 23:
                        this.inMetadataElement = false;
                        StringBuilder sb = this.metadataElementContents;
                        if (sb != null) {
                            SVGElem sVGElem = this.metadataTag;
                            if (sVGElem == SVGElem.title) {
                                this.svgDocument.setTitle(sb.toString());
                            } else if (sVGElem == SVGElem.desc) {
                                this.svgDocument.setDesc(sb.toString());
                            }
                            this.metadataElementContents.setLength(0);
                            return;
                        }
                        return;
                    case 30:
                        StringBuilder sb2 = this.styleElementContents;
                        if (sb2 != null) {
                            this.inStyleElement = false;
                            parseCSSStyleSheet(sb2.toString());
                            this.styleElementContents.setLength(0);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            this.currentElement = ((SVG.SvgObject) this.currentElement).parent;
        }
    }

    private void g(Attributes attributes) throws SVGParseException {
        debug("<g>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Group group = new SVG.Group();
            group.document = this.svgDocument;
            group.parent = this.currentElement;
            parseAttributesCore(group, attributes);
            parseAttributesStyle(group, attributes);
            parseAttributesTransform(group, attributes);
            parseAttributesConditional(group, attributes);
            this.currentElement.addChild(group);
            this.currentElement = group;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleProcessingInstruction(String str, Map<String, String> map) {
        String str2;
        String resolveCSSStyleSheet;
        if (!str.equals(XML_STYLESHEET_PROCESSING_INSTRUCTION) || SVG.getFileResolver() == null) {
            return;
        }
        if (map.get("type") == null || "text/css".equals(map.get("type"))) {
            if ((map.get(XML_STYLESHEET_ATTR_ALTERNATE) != null && !XML_STYLESHEET_ATTR_ALTERNATE_NO.equals(map.get(XML_STYLESHEET_ATTR_ALTERNATE))) || (str2 = map.get(XML_STYLESHEET_ATTR_HREF)) == null || (resolveCSSStyleSheet = SVG.getFileResolver().resolveCSSStyleSheet(str2)) == null) {
                return;
            }
            String str3 = map.get(XML_STYLESHEET_ATTR_MEDIA);
            if (str3 != null && !"all".equals(str3.trim())) {
                resolveCSSStyleSheet = "@media " + str3 + " { " + resolveCSSStyleSheet + "}";
            }
            parseCSSStyleSheet(resolveCSSStyleSheet);
        }
    }

    private static int hslToRgb(float f2, float f3, float f4) {
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        float f5 = f2 % 360.0f;
        if (i2 < 0) {
            f5 += 360.0f;
        }
        float f6 = f5 / 60.0f;
        float f7 = f3 / 100.0f;
        float f8 = f4 / 100.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        } else if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        float f9 = f8 >= 0.0f ? f8 > 1.0f ? 1.0f : f8 : 0.0f;
        float f10 = f9 <= 0.5f ? (f7 + 1.0f) * f9 : (f9 + f7) - (f7 * f9);
        float f11 = (f9 * 2.0f) - f10;
        return clamp255(hueToRgb(f11, f10, f6 - 2.0f) * 256.0f) | (clamp255(hueToRgb(f11, f10, f6 + 2.0f) * 256.0f) << 16) | (clamp255(hueToRgb(f11, f10, f6) * 256.0f) << 8);
    }

    private static float hueToRgb(float f2, float f3, float f4) {
        float f5;
        if (f4 < 0.0f) {
            f4 += 6.0f;
        }
        if (f4 >= 6.0f) {
            f4 -= 6.0f;
        }
        if (f4 < 1.0f) {
            f5 = (f3 - f2) * f4;
        } else if (f4 < 3.0f) {
            return f3;
        } else {
            if (f4 >= 4.0f) {
                return f2;
            }
            f5 = (f3 - f2) * (4.0f - f4);
        }
        return f5 + f2;
    }

    private void image(Attributes attributes) throws SVGParseException {
        debug("<image>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Image image = new SVG.Image();
            image.document = this.svgDocument;
            image.parent = this.currentElement;
            parseAttributesCore(image, attributes);
            parseAttributesStyle(image, attributes);
            parseAttributesTransform(image, attributes);
            parseAttributesConditional(image, attributes);
            parseAttributesImage(image, attributes);
            this.currentElement.addChild(image);
            this.currentElement = image;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void line(Attributes attributes) throws SVGParseException {
        debug("<line>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Line line = new SVG.Line();
            line.document = this.svgDocument;
            line.parent = this.currentElement;
            parseAttributesCore(line, attributes);
            parseAttributesStyle(line, attributes);
            parseAttributesTransform(line, attributes);
            parseAttributesConditional(line, attributes);
            parseAttributesLine(line, attributes);
            this.currentElement.addChild(line);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void linearGradient(Attributes attributes) throws SVGParseException {
        debug("<linearGradient>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgLinearGradient svgLinearGradient = new SVG.SvgLinearGradient();
            svgLinearGradient.document = this.svgDocument;
            svgLinearGradient.parent = this.currentElement;
            parseAttributesCore(svgLinearGradient, attributes);
            parseAttributesStyle(svgLinearGradient, attributes);
            parseAttributesGradient(svgLinearGradient, attributes);
            parseAttributesLinearGradient(svgLinearGradient, attributes);
            this.currentElement.addChild(svgLinearGradient);
            this.currentElement = svgLinearGradient;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void marker(Attributes attributes) throws SVGParseException {
        debug("<marker>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Marker marker = new SVG.Marker();
            marker.document = this.svgDocument;
            marker.parent = this.currentElement;
            parseAttributesCore(marker, attributes);
            parseAttributesStyle(marker, attributes);
            parseAttributesConditional(marker, attributes);
            parseAttributesViewBox(marker, attributes);
            parseAttributesMarker(marker, attributes);
            this.currentElement.addChild(marker);
            this.currentElement = marker;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void mask(Attributes attributes) throws SVGParseException {
        debug("<mask>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Mask mask = new SVG.Mask();
            mask.document = this.svgDocument;
            mask.parent = this.currentElement;
            parseAttributesCore(mask, attributes);
            parseAttributesStyle(mask, attributes);
            parseAttributesConditional(mask, attributes);
            parseAttributesMask(mask, attributes);
            this.currentElement.addChild(mask);
            this.currentElement = mask;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void parseAttributesCircle(SVG.Circle circle, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 12:
                    circle.cx = parseLength(trim);
                    break;
                case 13:
                    circle.cy = parseLength(trim);
                    break;
                case 14:
                    SVG.Length parseLength = parseLength(trim);
                    circle.r = parseLength;
                    if (parseLength.isNegative()) {
                        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
            }
        }
    }

    private void parseAttributesClipPath(SVG.ClipPath clipPath, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(trim)) {
                    clipPath.clipPathUnitsAreUser = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    clipPath.clipPathUnitsAreUser = Boolean.TRUE;
                } else {
                    throw new SVGParseException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private void parseAttributesConditional(SVG.SvgConditional svgConditional, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 21:
                    svgConditional.setRequiredFeatures(parseRequiredFeatures(trim));
                    break;
                case 22:
                    svgConditional.setRequiredExtensions(trim);
                    break;
                case 23:
                    svgConditional.setSystemLanguage(parseSystemLanguage(trim));
                    break;
                case 24:
                    svgConditional.setRequiredFormats(parseRequiredFormats(trim));
                    break;
                case 25:
                    List<String> parseFontFamily = parseFontFamily(trim);
                    svgConditional.setRequiredFonts(parseFontFamily != null ? new HashSet(parseFontFamily) : new HashSet(0));
                    break;
            }
        }
    }

    private void parseAttributesCore(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String qName = attributes.getQName(i2);
            if (!qName.equals("id") && !qName.equals("xml:id")) {
                if (qName.equals("xml:space")) {
                    String trim = attributes.getValue(i2).trim();
                    if (CookieSpecs.DEFAULT.equals(trim)) {
                        svgElementBase.spacePreserve = Boolean.FALSE;
                        return;
                    } else if ("preserve".equals(trim)) {
                        svgElementBase.spacePreserve = Boolean.TRUE;
                        return;
                    } else {
                        throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + trim);
                    }
                }
            } else {
                svgElementBase.id = attributes.getValue(i2).trim();
                return;
            }
        }
    }

    private void parseAttributesEllipse(SVG.Ellipse ellipse, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 10:
                    SVG.Length parseLength = parseLength(trim);
                    ellipse.rx = parseLength;
                    if (parseLength.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                case 11:
                    SVG.Length parseLength2 = parseLength(trim);
                    ellipse.ry = parseLength2;
                    if (parseLength2.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                case 12:
                    ellipse.cx = parseLength(trim);
                    break;
                case 13:
                    ellipse.cy = parseLength(trim);
                    break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseAttributesGradient(com.caverock.androidsvg.SVG.GradientElement r5, org.xml.sax.Attributes r6) throws com.caverock.androidsvg.SVGParseException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L90
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 6
            if (r2 == r3) goto L72
            switch(r2) {
                case 32: goto L50;
                case 33: goto L49;
                case 34: goto L26;
                default: goto L25;
            }
        L25:
            goto L8c
        L26:
            com.caverock.androidsvg.SVG$GradientSpread r2 = com.caverock.androidsvg.SVG.GradientSpread.valueOf(r1)     // Catch: java.lang.IllegalArgumentException -> L2d
            r5.spreadMethod = r2     // Catch: java.lang.IllegalArgumentException -> L2d
            goto L8c
        L2d:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Invalid spreadMethod attribute. \""
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "\" is not a valid value."
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L49:
            android.graphics.Matrix r1 = r4.parseTransformList(r1)
            r5.gradientTransform = r1
            goto L8c
        L50:
            java.lang.String r2 = "objectBoundingBox"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L5d
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r5.gradientUnitsAreUser = r1
            goto L8c
        L5d:
            java.lang.String r2 = "userSpaceOnUse"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L6a
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r5.gradientUnitsAreUser = r1
            goto L8c
        L6a:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r6 = "Invalid value for attribute gradientUnits"
            r5.<init>(r6)
            throw r5
        L72:
            java.lang.String r2 = r6.getURI(r0)
            java.lang.String r3 = ""
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L8a
            java.lang.String r2 = r6.getURI(r0)
            java.lang.String r3 = "http://www.w3.org/1999/xlink"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L8c
        L8a:
            r5.href = r1
        L8c:
            int r0 = r0 + 1
            goto L1
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.parseAttributesGradient(com.caverock.androidsvg.SVG$GradientElement, org.xml.sax.Attributes):void");
    }

    private void parseAttributesImage(SVG.Image image, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                image.x = parseLength(trim);
            } else if (i3 == 2) {
                image.y = parseLength(trim);
            } else if (i3 == 3) {
                SVG.Length parseLength = parseLength(trim);
                image.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i3 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                image.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i3 != 6) {
                if (i3 == 7) {
                    parsePreserveAspectRatio(image, trim);
                }
            } else if ("".equals(attributes.getURI(i2)) || XLINK_NAMESPACE.equals(attributes.getURI(i2))) {
                image.href = trim;
            }
        }
    }

    private void parseAttributesLine(SVG.Line line, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 15:
                    line.x1 = parseLength(trim);
                    break;
                case 16:
                    line.y1 = parseLength(trim);
                    break;
                case 17:
                    line.x2 = parseLength(trim);
                    break;
                case 18:
                    line.y2 = parseLength(trim);
                    break;
            }
        }
    }

    private void parseAttributesLinearGradient(SVG.SvgLinearGradient svgLinearGradient, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 15:
                    svgLinearGradient.x1 = parseLength(trim);
                    break;
                case 16:
                    svgLinearGradient.y1 = parseLength(trim);
                    break;
                case 17:
                    svgLinearGradient.x2 = parseLength(trim);
                    break;
                case 18:
                    svgLinearGradient.y2 = parseLength(trim);
                    break;
            }
        }
    }

    private void parseAttributesMarker(SVG.Marker marker, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()]) {
                case 26:
                    marker.refX = parseLength(trim);
                    break;
                case 27:
                    marker.refY = parseLength(trim);
                    break;
                case 28:
                    SVG.Length parseLength = parseLength(trim);
                    marker.markerWidth = parseLength;
                    if (parseLength.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                case 29:
                    SVG.Length parseLength2 = parseLength(trim);
                    marker.markerHeight = parseLength2;
                    if (parseLength2.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                case 30:
                    if ("strokeWidth".equals(trim)) {
                        marker.markerUnitsAreUser = false;
                        break;
                    } else if ("userSpaceOnUse".equals(trim)) {
                        marker.markerUnitsAreUser = true;
                        break;
                    } else {
                        throw new SVGParseException("Invalid value for attribute markerUnits");
                    }
                case 31:
                    if ("auto".equals(trim)) {
                        marker.orient = Float.valueOf(Float.NaN);
                        break;
                    } else {
                        marker.orient = Float.valueOf(parseFloat(trim));
                        break;
                    }
            }
        }
    }

    private void parseAttributesMask(SVG.Mask mask, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                mask.x = parseLength(trim);
            } else if (i3 == 2) {
                mask.y = parseLength(trim);
            } else if (i3 == 3) {
                SVG.Length parseLength = parseLength(trim);
                mask.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i3 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                mask.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i3 != 43) {
                if (i3 != 44) {
                    continue;
                } else if ("objectBoundingBox".equals(trim)) {
                    mask.maskContentUnitsAreUser = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(trim)) {
                    mask.maskContentUnitsAreUser = Boolean.TRUE;
                } else {
                    throw new SVGParseException("Invalid value for attribute maskContentUnits");
                }
            } else if ("objectBoundingBox".equals(trim)) {
                mask.maskUnitsAreUser = Boolean.FALSE;
            } else if ("userSpaceOnUse".equals(trim)) {
                mask.maskUnitsAreUser = Boolean.TRUE;
            } else {
                throw new SVGParseException("Invalid value for attribute maskUnits");
            }
        }
    }

    private void parseAttributesPath(SVG.Path path, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 8) {
                path.f3751d = parsePath(trim);
            } else if (i3 != 9) {
                continue;
            } else {
                Float valueOf = Float.valueOf(parseFloat(trim));
                path.pathLength = valueOf;
                if (valueOf.floatValue() < 0.0f) {
                    throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cf, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseAttributesPattern(com.caverock.androidsvg.SVG.Pattern r6, org.xml.sax.Attributes r7) throws com.caverock.androidsvg.SVGParseException {
        /*
            r5 = this;
            r0 = 0
        L1:
            int r1 = r7.getLength()
            if (r0 >= r1) goto Ld3
            java.lang.String r1 = r7.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr
            java.lang.String r3 = r7.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto Lc9
            r3 = 2
            if (r2 == r3) goto Lc2
            r3 = 3
            if (r2 == r3) goto Lad
            r3 = 4
            if (r2 == r3) goto L98
            r3 = 6
            if (r2 == r3) goto L7d
            java.lang.String r3 = "userSpaceOnUse"
            java.lang.String r4 = "objectBoundingBox"
            switch(r2) {
                case 40: goto L5f;
                case 41: goto L3f;
                case 42: goto L37;
                default: goto L35;
            }
        L35:
            goto Lcf
        L37:
            android.graphics.Matrix r1 = r5.parseTransformList(r1)
            r6.patternTransform = r1
            goto Lcf
        L3f:
            boolean r2 = r4.equals(r1)
            if (r2 == 0) goto L4b
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r6.patternContentUnitsAreUser = r1
            goto Lcf
        L4b:
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L57
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r6.patternContentUnitsAreUser = r1
            goto Lcf
        L57:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r7 = "Invalid value for attribute patternContentUnits"
            r6.<init>(r7)
            throw r6
        L5f:
            boolean r2 = r4.equals(r1)
            if (r2 == 0) goto L6a
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r6.patternUnitsAreUser = r1
            goto Lcf
        L6a:
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L75
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r6.patternUnitsAreUser = r1
            goto Lcf
        L75:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r7 = "Invalid value for attribute patternUnits"
            r6.<init>(r7)
            throw r6
        L7d:
            java.lang.String r2 = r7.getURI(r0)
            java.lang.String r3 = ""
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L95
            java.lang.String r2 = r7.getURI(r0)
            java.lang.String r3 = "http://www.w3.org/1999/xlink"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto Lcf
        L95:
            r6.href = r1
            goto Lcf
        L98:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r6.height = r1
            boolean r1 = r1.isNegative()
            if (r1 != 0) goto La5
            goto Lcf
        La5:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r7 = "Invalid <pattern> element. height cannot be negative"
            r6.<init>(r7)
            throw r6
        Lad:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r6.width = r1
            boolean r1 = r1.isNegative()
            if (r1 != 0) goto Lba
            goto Lcf
        Lba:
            com.caverock.androidsvg.SVGParseException r6 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r7 = "Invalid <pattern> element. width cannot be negative"
            r6.<init>(r7)
            throw r6
        Lc2:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r6.y = r1
            goto Lcf
        Lc9:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r6.x = r1
        Lcf:
            int r0 = r0 + 1
            goto L1
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.parseAttributesPattern(com.caverock.androidsvg.SVG$Pattern, org.xml.sax.Attributes):void");
    }

    private void parseAttributesPolyLine(SVG.PolyLine polyLine, Attributes attributes, String str) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (SVGAttr.fromString(attributes.getLocalName(i2)) == SVGAttr.points) {
                TextScanner textScanner = new TextScanner(attributes.getValue(i2));
                ArrayList<Float> arrayList = new ArrayList();
                textScanner.skipWhitespace();
                while (!textScanner.empty()) {
                    float nextFloat = textScanner.nextFloat();
                    if (!Float.isNaN(nextFloat)) {
                        textScanner.skipCommaWhitespace();
                        float nextFloat2 = textScanner.nextFloat();
                        if (!Float.isNaN(nextFloat2)) {
                            textScanner.skipCommaWhitespace();
                            arrayList.add(Float.valueOf(nextFloat));
                            arrayList.add(Float.valueOf(nextFloat2));
                        } else {
                            throw new SVGParseException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                        }
                    } else {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                }
                polyLine.points = new float[arrayList.size()];
                int i3 = 0;
                for (Float f2 : arrayList) {
                    polyLine.points[i3] = f2.floatValue();
                    i3++;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseAttributesRadialGradient(com.caverock.androidsvg.SVG.SvgRadialGradient r5, org.xml.sax.Attributes r6) throws com.caverock.androidsvg.SVGParseException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L5e
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.fromString(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 35
            if (r2 == r3) goto L55
            r3 = 36
            if (r2 == r3) goto L4e
            switch(r2) {
                case 12: goto L47;
                case 13: goto L40;
                case 14: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L5b
        L2b:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.r = r1
            boolean r1 = r1.isNegative()
            if (r1 != 0) goto L38
            goto L5b
        L38:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r6 = "Invalid <radialGradient> element. r cannot be negative"
            r5.<init>(r6)
            throw r5
        L40:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.cy = r1
            goto L5b
        L47:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.cx = r1
            goto L5b
        L4e:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.fy = r1
            goto L5b
        L55:
            com.caverock.androidsvg.SVG$Length r1 = parseLength(r1)
            r5.fx = r1
        L5b:
            int r0 = r0 + 1
            goto L1
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.parseAttributesRadialGradient(com.caverock.androidsvg.SVG$SvgRadialGradient, org.xml.sax.Attributes):void");
    }

    private void parseAttributesRect(SVG.Rect rect, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                rect.x = parseLength(trim);
            } else if (i3 == 2) {
                rect.y = parseLength(trim);
            } else if (i3 == 3) {
                SVG.Length parseLength = parseLength(trim);
                rect.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i3 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                rect.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i3 == 10) {
                SVG.Length parseLength3 = parseLength(trim);
                rect.rx = parseLength3;
                if (parseLength3.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i3 != 11) {
                continue;
            } else {
                SVG.Length parseLength4 = parseLength(trim);
                rect.ry = parseLength4;
                if (parseLength4.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void parseAttributesSVG(SVG.Svg svg, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                svg.x = parseLength(trim);
            } else if (i3 == 2) {
                svg.y = parseLength(trim);
            } else if (i3 == 3) {
                SVG.Length parseLength = parseLength(trim);
                svg.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                }
            } else if (i3 == 4) {
                SVG.Length parseLength2 = parseLength(trim);
                svg.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i3 == 5) {
                svg.version = trim;
            }
        }
    }

    private void parseAttributesStop(SVG.Stop stop, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 37) {
                stop.offset = parseGradientOffset(trim);
            }
        }
    }

    private void parseAttributesStyle(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (trim.length() != 0) {
                int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                if (i3 == 45) {
                    parseStyle(svgElementBase, trim);
                } else if (i3 != 46) {
                    if (svgElementBase.baseStyle == null) {
                        svgElementBase.baseStyle = new SVG.Style();
                    }
                    processStyleProperty(svgElementBase.baseStyle, attributes.getLocalName(i2), attributes.getValue(i2).trim());
                } else {
                    svgElementBase.classNames = CSSParser.parseClassAttribute(trim);
                }
            }
        }
    }

    private void parseAttributesTRef(SVG.TRef tRef, Attributes attributes) {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()] == 6 && ("".equals(attributes.getURI(i2)) || XLINK_NAMESPACE.equals(attributes.getURI(i2)))) {
                tRef.href = trim;
            }
        }
    }

    private void parseAttributesTextPath(SVG.TextPath textPath, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 != 6) {
                if (i3 == 39) {
                    textPath.startOffset = parseLength(trim);
                }
            } else if ("".equals(attributes.getURI(i2)) || XLINK_NAMESPACE.equals(attributes.getURI(i2))) {
                textPath.href = trim;
            }
        }
    }

    private void parseAttributesTextPosition(SVG.TextPositionedContainer textPositionedContainer, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                textPositionedContainer.x = parseLengthList(trim);
            } else if (i3 == 2) {
                textPositionedContainer.y = parseLengthList(trim);
            } else if (i3 == 19) {
                textPositionedContainer.dx = parseLengthList(trim);
            } else if (i3 == 20) {
                textPositionedContainer.dy = parseLengthList(trim);
            }
        }
    }

    private void parseAttributesTransform(SVG.HasTransform hasTransform, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (SVGAttr.fromString(attributes.getLocalName(i2)) == SVGAttr.transform) {
                hasTransform.setTransform(parseTransformList(attributes.getValue(i2)));
            }
        }
    }

    private void parseAttributesUse(SVG.Use use, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 1) {
                use.x = parseLength(trim);
            } else if (i3 == 2) {
                use.y = parseLength(trim);
            } else if (i3 == 3) {
                SVG.Length parseLength = parseLength(trim);
                use.width = parseLength;
                if (parseLength.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i3 != 4) {
                if (i3 == 6 && ("".equals(attributes.getURI(i2)) || XLINK_NAMESPACE.equals(attributes.getURI(i2)))) {
                    use.href = trim;
                }
            } else {
                SVG.Length parseLength2 = parseLength(trim);
                use.height = parseLength2;
                if (parseLength2.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            }
        }
    }

    private void parseAttributesViewBox(SVG.SvgViewBoxContainer svgViewBoxContainer, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
            if (i3 == 7) {
                parsePreserveAspectRatio(svgViewBoxContainer, trim);
            } else if (i3 == 87) {
                svgViewBoxContainer.viewBox = parseViewBox(trim);
            }
        }
    }

    private void parseCSSStyleSheet(String str) {
        this.svgDocument.addCSSRules(new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document).parse(str));
    }

    private static SVG.CSSClipRect parseClip(String str) {
        if (!"auto".equals(str) && str.startsWith("rect(")) {
            TextScanner textScanner = new TextScanner(str.substring(5));
            textScanner.skipWhitespace();
            SVG.Length parseLengthOrAuto = parseLengthOrAuto(textScanner);
            textScanner.skipCommaWhitespace();
            SVG.Length parseLengthOrAuto2 = parseLengthOrAuto(textScanner);
            textScanner.skipCommaWhitespace();
            SVG.Length parseLengthOrAuto3 = parseLengthOrAuto(textScanner);
            textScanner.skipCommaWhitespace();
            SVG.Length parseLengthOrAuto4 = parseLengthOrAuto(textScanner);
            textScanner.skipWhitespace();
            if (textScanner.consume(')') || textScanner.empty()) {
                return new SVG.CSSClipRect(parseLengthOrAuto, parseLengthOrAuto2, parseLengthOrAuto3, parseLengthOrAuto4);
            }
            return null;
        }
        return null;
    }

    private static SVG.Colour parseColour(String str) throws SVGParseException {
        if (str.charAt(0) == '#') {
            IntegerParser parseHex = IntegerParser.parseHex(str, 1, str.length());
            if (parseHex != null) {
                int endPos = parseHex.getEndPos();
                if (endPos == 4) {
                    int value = parseHex.value();
                    int i2 = value & 3840;
                    int i3 = value & 240;
                    int i4 = value & 15;
                    return new SVG.Colour(i4 | (i2 << 8) | (-16777216) | (i2 << 12) | (i3 << 8) | (i3 << 4) | (i4 << 4));
                } else if (endPos == 5) {
                    int value2 = parseHex.value();
                    int i5 = 61440 & value2;
                    int i6 = value2 & 3840;
                    int i7 = value2 & 240;
                    int i8 = value2 & 15;
                    return new SVG.Colour((i8 << 24) | (i8 << 28) | (i5 << 8) | (i5 << 4) | (i6 << 4) | i6 | i7 | (i7 >> 4));
                } else if (endPos != 7) {
                    if (endPos == 9) {
                        return new SVG.Colour((parseHex.value() >>> 8) | (parseHex.value() << 24));
                    }
                    throw new SVGParseException("Bad hex colour value: " + str);
                } else {
                    return new SVG.Colour(parseHex.value() | (-16777216));
                }
            }
            throw new SVGParseException("Bad hex colour value: " + str);
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean startsWith = lowerCase.startsWith("rgba(");
        if (!startsWith && !lowerCase.startsWith("rgb(")) {
            boolean startsWith2 = lowerCase.startsWith("hsla(");
            if (!startsWith2 && !lowerCase.startsWith("hsl(")) {
                return parseColourKeyword(lowerCase);
            }
            TextScanner textScanner = new TextScanner(str.substring(startsWith2 ? 5 : 4));
            textScanner.skipWhitespace();
            float nextFloat = textScanner.nextFloat();
            float checkedNextFloat = textScanner.checkedNextFloat(nextFloat);
            if (!Float.isNaN(checkedNextFloat)) {
                textScanner.consume('%');
            }
            float checkedNextFloat2 = textScanner.checkedNextFloat(checkedNextFloat);
            if (!Float.isNaN(checkedNextFloat2)) {
                textScanner.consume('%');
            }
            if (startsWith2) {
                float checkedNextFloat3 = textScanner.checkedNextFloat(checkedNextFloat2);
                textScanner.skipWhitespace();
                if (!Float.isNaN(checkedNextFloat3) && textScanner.consume(')')) {
                    return new SVG.Colour((clamp255(checkedNextFloat3 * 256.0f) << 24) | hslToRgb(nextFloat, checkedNextFloat, checkedNextFloat2));
                }
                throw new SVGParseException("Bad hsla() colour value: " + str);
            }
            textScanner.skipWhitespace();
            if (!Float.isNaN(checkedNextFloat2) && textScanner.consume(')')) {
                return new SVG.Colour(hslToRgb(nextFloat, checkedNextFloat, checkedNextFloat2) | (-16777216));
            }
            throw new SVGParseException("Bad hsl() colour value: " + str);
        }
        TextScanner textScanner2 = new TextScanner(str.substring(startsWith ? 5 : 4));
        textScanner2.skipWhitespace();
        float nextFloat2 = textScanner2.nextFloat();
        if (!Float.isNaN(nextFloat2) && textScanner2.consume('%')) {
            nextFloat2 = (nextFloat2 * 256.0f) / 100.0f;
        }
        float checkedNextFloat4 = textScanner2.checkedNextFloat(nextFloat2);
        if (!Float.isNaN(checkedNextFloat4) && textScanner2.consume('%')) {
            checkedNextFloat4 = (checkedNextFloat4 * 256.0f) / 100.0f;
        }
        float checkedNextFloat5 = textScanner2.checkedNextFloat(checkedNextFloat4);
        if (!Float.isNaN(checkedNextFloat5) && textScanner2.consume('%')) {
            checkedNextFloat5 = (checkedNextFloat5 * 256.0f) / 100.0f;
        }
        if (startsWith) {
            float checkedNextFloat6 = textScanner2.checkedNextFloat(checkedNextFloat5);
            textScanner2.skipWhitespace();
            if (!Float.isNaN(checkedNextFloat6) && textScanner2.consume(')')) {
                return new SVG.Colour((clamp255(checkedNextFloat6 * 256.0f) << 24) | (clamp255(nextFloat2) << 16) | (clamp255(checkedNextFloat4) << 8) | clamp255(checkedNextFloat5));
            }
            throw new SVGParseException("Bad rgba() colour value: " + str);
        }
        textScanner2.skipWhitespace();
        if (!Float.isNaN(checkedNextFloat5) && textScanner2.consume(')')) {
            return new SVG.Colour((clamp255(nextFloat2) << 16) | (-16777216) | (clamp255(checkedNextFloat4) << 8) | clamp255(checkedNextFloat5));
        }
        throw new SVGParseException("Bad rgb() colour value: " + str);
    }

    private static SVG.Colour parseColourKeyword(String str) throws SVGParseException {
        Integer num = ColourKeywords.get(str);
        if (num != null) {
            return new SVG.Colour(num.intValue());
        }
        throw new SVGParseException("Invalid colour keyword: " + str);
    }

    private static SVG.SvgPaint parseColourSpecifer(String str) {
        str.hashCode();
        if (str.equals(NONE)) {
            return SVG.Colour.TRANSPARENT;
        }
        if (!str.equals(CURRENTCOLOR)) {
            try {
                return parseColour(str);
            } catch (SVGParseException unused) {
                return null;
            }
        }
        return SVG.CurrentColor.getInstance();
    }

    private static SVG.Style.FillRule parseFillRule(String str) {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        return null;
    }

    private static float parseFloat(String str) throws SVGParseException {
        int length = str.length();
        if (length != 0) {
            return parseFloat(str, 0, length);
        }
        throw new SVGParseException("Invalid float value (empty string)");
    }

    private static void parseFont(SVG.Style style, String str) {
        String nextToken;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            TextScanner textScanner = new TextScanner(str);
            Integer num = null;
            SVG.Style.FontStyle fontStyle = null;
            String str2 = null;
            while (true) {
                nextToken = textScanner.nextToken('/');
                textScanner.skipWhitespace();
                if (nextToken != null) {
                    if (num != null && fontStyle != null) {
                        break;
                    } else if (!nextToken.equals("normal") && (num != null || (num = FontWeightKeywords.get(nextToken)) == null)) {
                        if (fontStyle != null || (fontStyle = parseFontStyle(nextToken)) == null) {
                            if (str2 != null || !nextToken.equals("small-caps")) {
                                break;
                            }
                            str2 = nextToken;
                        }
                    }
                } else {
                    return;
                }
            }
            SVG.Length parseFontSize = parseFontSize(nextToken);
            if (textScanner.consume('/')) {
                textScanner.skipWhitespace();
                String nextToken2 = textScanner.nextToken();
                if (nextToken2 != null) {
                    try {
                        parseLength(nextToken2);
                    } catch (SVGParseException unused) {
                        return;
                    }
                }
                textScanner.skipWhitespace();
            }
            style.fontFamily = parseFontFamily(textScanner.restOfText());
            style.fontSize = parseFontSize;
            style.fontWeight = Integer.valueOf(num == null ? HttpStatus.SC_BAD_REQUEST : num.intValue());
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.fontStyle = fontStyle;
            style.specifiedFlags |= 122880;
        }
    }

    private static List<String> parseFontFamily(String str) {
        TextScanner textScanner = new TextScanner(str);
        ArrayList arrayList = null;
        do {
            String nextQuotedString = textScanner.nextQuotedString();
            if (nextQuotedString == null) {
                nextQuotedString = textScanner.nextTokenWithWhitespace(',');
            }
            if (nextQuotedString == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(nextQuotedString);
            textScanner.skipCommaWhitespace();
        } while (!textScanner.empty());
        return arrayList;
    }

    private static SVG.Length parseFontSize(String str) {
        try {
            SVG.Length length = FontSizeKeywords.get(str);
            return length == null ? parseLength(str) : length;
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static SVG.Style.FontStyle parseFontStyle(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals("italic")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return SVG.Style.FontStyle.Oblique;
            case 1:
                return SVG.Style.FontStyle.Italic;
            case 2:
                return SVG.Style.FontStyle.Normal;
            default:
                return null;
        }
    }

    private static Integer parseFontWeight(String str) {
        return FontWeightKeywords.get(str);
    }

    private static String parseFunctionalIRI(String str, String str2) {
        if (!str.equals(NONE) && str.startsWith("url(")) {
            if (str.endsWith(")")) {
                return str.substring(4, str.length() - 1).trim();
            }
            return str.substring(4).trim();
        }
        return null;
    }

    private Float parseGradientOffset(String str) throws SVGParseException {
        if (str.length() != 0) {
            int length = str.length();
            boolean z = true;
            if (str.charAt(str.length() - 1) == '%') {
                length--;
            } else {
                z = false;
            }
            try {
                float parseFloat = parseFloat(str, 0, length);
                float f2 = 100.0f;
                if (z) {
                    parseFloat /= 100.0f;
                }
                if (parseFloat < 0.0f) {
                    f2 = 0.0f;
                } else if (parseFloat <= 100.0f) {
                    f2 = parseFloat;
                }
                return Float.valueOf(f2);
            } catch (NumberFormatException e2) {
                throw new SVGParseException("Invalid offset value in <stop>: " + str, e2);
            }
        }
        throw new SVGParseException("Invalid offset value in <stop> (empty string)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SVG.Length parseLength(String str) throws SVGParseException {
        if (str.length() != 0) {
            int length = str.length();
            SVG.Unit unit = SVG.Unit.px;
            char charAt = str.charAt(length - 1);
            if (charAt == '%') {
                length--;
                unit = SVG.Unit.percent;
            } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
                length -= 2;
                try {
                    unit = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
                } catch (IllegalArgumentException unused) {
                    throw new SVGParseException("Invalid length unit specifier: " + str);
                }
            }
            try {
                return new SVG.Length(parseFloat(str, 0, length), unit);
            } catch (NumberFormatException e2) {
                throw new SVGParseException("Invalid length value: " + str, e2);
            }
        }
        throw new SVGParseException("Invalid length value (empty string)");
    }

    private static List<SVG.Length> parseLengthList(String str) throws SVGParseException {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            TextScanner textScanner = new TextScanner(str);
            textScanner.skipWhitespace();
            while (!textScanner.empty()) {
                float nextFloat = textScanner.nextFloat();
                if (!Float.isNaN(nextFloat)) {
                    SVG.Unit nextUnit = textScanner.nextUnit();
                    if (nextUnit == null) {
                        nextUnit = SVG.Unit.px;
                    }
                    arrayList.add(new SVG.Length(nextFloat, nextUnit));
                    textScanner.skipCommaWhitespace();
                } else {
                    throw new SVGParseException("Invalid length list value: " + textScanner.ahead());
                }
            }
            return arrayList;
        }
        throw new SVGParseException("Invalid length list (empty string)");
    }

    private static SVG.Length parseLengthOrAuto(TextScanner textScanner) {
        if (textScanner.consume("auto")) {
            return new SVG.Length(0.0f);
        }
        return textScanner.nextLength();
    }

    private static Float parseOpacity(String str) {
        try {
            float parseFloat = parseFloat(str);
            if (parseFloat < 0.0f) {
                parseFloat = 0.0f;
            } else if (parseFloat > 1.0f) {
                parseFloat = 1.0f;
            }
            return Float.valueOf(parseFloat);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static Boolean parseOverflow(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1217487446:
                if (str.equals("hidden")) {
                    c2 = 0;
                    break;
                }
                break;
            case -907680051:
                if (str.equals("scroll")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 2;
                    break;
                }
                break;
            case 466743410:
                if (str.equals("visible")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return Boolean.FALSE;
            case 2:
            case 3:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    private static SVG.SvgPaint parsePaintSpecifier(String str) {
        if (str.startsWith("url(")) {
            int indexOf = str.indexOf(")");
            if (indexOf != -1) {
                String trim = str.substring(4, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                return new SVG.PaintReference(trim, trim2.length() > 0 ? parseColourSpecifer(trim2) : null);
            }
            return new SVG.PaintReference(str.substring(4).trim(), null);
        }
        return parseColourSpecifer(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x02a4, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.caverock.androidsvg.SVG.PathDefinition parsePath(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 760
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.parsePath(java.lang.String):com.caverock.androidsvg.SVG$PathDefinition");
    }

    private static void parsePreserveAspectRatio(SVG.SvgPreserveAspectRatioContainer svgPreserveAspectRatioContainer, String str) throws SVGParseException {
        svgPreserveAspectRatioContainer.preserveAspectRatio = parsePreserveAspectRatio(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> parseProcessingInstructionAttributes(TextScanner textScanner) {
        HashMap hashMap = new HashMap();
        textScanner.skipWhitespace();
        String nextToken = textScanner.nextToken('=');
        while (nextToken != null) {
            textScanner.consume('=');
            hashMap.put(nextToken, textScanner.nextQuotedString());
            textScanner.skipWhitespace();
            nextToken = textScanner.nextToken('=');
        }
        return hashMap;
    }

    private static SVG.Style.RenderQuality parseRenderQuality(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -933002398:
                if (str.equals("optimizeQuality")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 1;
                    break;
                }
                break;
            case 362741610:
                if (str.equals("optimizeSpeed")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return SVG.Style.RenderQuality.optimizeQuality;
            case 1:
                return SVG.Style.RenderQuality.auto;
            case 2:
                return SVG.Style.RenderQuality.optimizeSpeed;
            default:
                return null;
        }
    }

    private static Set<String> parseRequiredFeatures(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String nextToken = textScanner.nextToken();
            if (nextToken.startsWith(FEATURE_STRING_PREFIX)) {
                hashSet.add(nextToken.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set<String> parseRequiredFormats(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            hashSet.add(textScanner.nextToken());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static SVG.Length[] parseStrokeDashArray(String str) {
        SVG.Length nextLength;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        if (textScanner.empty() || (nextLength = textScanner.nextLength()) == null || nextLength.isNegative()) {
            return null;
        }
        float floatValue = nextLength.floatValue();
        ArrayList arrayList = new ArrayList();
        arrayList.add(nextLength);
        while (!textScanner.empty()) {
            textScanner.skipCommaWhitespace();
            SVG.Length nextLength2 = textScanner.nextLength();
            if (nextLength2 == null || nextLength2.isNegative()) {
                return null;
            }
            arrayList.add(nextLength2);
            floatValue += nextLength2.floatValue();
        }
        if (floatValue == 0.0f) {
            return null;
        }
        return (SVG.Length[]) arrayList.toArray(new SVG.Length[arrayList.size()]);
    }

    private static SVG.Style.LineCap parseStrokeLineCap(String str) {
        if ("butt".equals(str)) {
            return SVG.Style.LineCap.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCap.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCap.Square;
        }
        return null;
    }

    private static SVG.Style.LineJoin parseStrokeLineJoin(String str) {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        return null;
    }

    private static void parseStyle(SVG.SvgElementBase svgElementBase, String str) {
        TextScanner textScanner = new TextScanner(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String nextToken = textScanner.nextToken(':');
            textScanner.skipWhitespace();
            if (!textScanner.consume(':')) {
                return;
            }
            textScanner.skipWhitespace();
            String nextTokenWithWhitespace = textScanner.nextTokenWithWhitespace(';');
            if (nextTokenWithWhitespace == null) {
                return;
            }
            textScanner.skipWhitespace();
            if (textScanner.empty() || textScanner.consume(';')) {
                if (svgElementBase.style == null) {
                    svgElementBase.style = new SVG.Style();
                }
                processStyleProperty(svgElementBase.style, nextToken, nextTokenWithWhitespace);
                textScanner.skipWhitespace();
            }
        }
    }

    private static Set<String> parseSystemLanguage(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String nextToken = textScanner.nextToken();
            int indexOf = nextToken.indexOf(45);
            if (indexOf != -1) {
                nextToken = nextToken.substring(0, indexOf);
            }
            hashSet.add(new Locale(nextToken, "", "").getLanguage());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static SVG.Style.TextAnchor parseTextAnchor(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return SVG.Style.TextAnchor.Middle;
            case 1:
                return SVG.Style.TextAnchor.End;
            case 2:
                return SVG.Style.TextAnchor.Start;
            default:
                return null;
        }
    }

    private static SVG.Style.TextDecoration parseTextDecoration(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1171789332:
                if (str.equals("line-through")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals("underline")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals(NONE)) {
                    c2 = 2;
                    break;
                }
                break;
            case 93826908:
                if (str.equals("blink")) {
                    c2 = 3;
                    break;
                }
                break;
            case 529818312:
                if (str.equals("overline")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return SVG.Style.TextDecoration.LineThrough;
            case 1:
                return SVG.Style.TextDecoration.Underline;
            case 2:
                return SVG.Style.TextDecoration.None;
            case 3:
                return SVG.Style.TextDecoration.Blink;
            case 4:
                return SVG.Style.TextDecoration.Overline;
            default:
                return null;
        }
    }

    private static SVG.Style.TextDirection parseTextDirection(String str) {
        str.hashCode();
        if (str.equals("ltr")) {
            return SVG.Style.TextDirection.LTR;
        }
        if (str.equals("rtl")) {
            return SVG.Style.TextDirection.RTL;
        }
        return null;
    }

    private Matrix parseTransformList(String str) throws SVGParseException {
        Matrix matrix = new Matrix();
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            String nextFunction = textScanner.nextFunction();
            if (nextFunction != null) {
                char c2 = 65535;
                switch (nextFunction.hashCode()) {
                    case -1081239615:
                        if (nextFunction.equals("matrix")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -925180581:
                        if (nextFunction.equals("rotate")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 109250890:
                        if (nextFunction.equals("scale")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 109493390:
                        if (nextFunction.equals("skewX")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 109493391:
                        if (nextFunction.equals("skewY")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (nextFunction.equals("translate")) {
                            c2 = 5;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        textScanner.skipWhitespace();
                        float nextFloat = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat2 = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat3 = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat4 = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat5 = textScanner.nextFloat();
                        textScanner.skipCommaWhitespace();
                        float nextFloat6 = textScanner.nextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat6) && textScanner.consume(')')) {
                            Matrix matrix2 = new Matrix();
                            matrix2.setValues(new float[]{nextFloat, nextFloat3, nextFloat5, nextFloat2, nextFloat4, nextFloat6, 0.0f, 0.0f, 1.0f});
                            matrix.preConcat(matrix2);
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    case 1:
                        textScanner.skipWhitespace();
                        float nextFloat7 = textScanner.nextFloat();
                        float possibleNextFloat = textScanner.possibleNextFloat();
                        float possibleNextFloat2 = textScanner.possibleNextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat7) && textScanner.consume(')')) {
                            if (Float.isNaN(possibleNextFloat)) {
                                matrix.preRotate(nextFloat7);
                                break;
                            } else if (!Float.isNaN(possibleNextFloat2)) {
                                matrix.preRotate(nextFloat7, possibleNextFloat, possibleNextFloat2);
                                break;
                            } else {
                                throw new SVGParseException("Invalid transform list: " + str);
                            }
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                    case 2:
                        textScanner.skipWhitespace();
                        float nextFloat8 = textScanner.nextFloat();
                        float possibleNextFloat3 = textScanner.possibleNextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat8) && textScanner.consume(')')) {
                            if (Float.isNaN(possibleNextFloat3)) {
                                matrix.preScale(nextFloat8, nextFloat8);
                                break;
                            } else {
                                matrix.preScale(nextFloat8, possibleNextFloat3);
                                break;
                            }
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    case 3:
                        textScanner.skipWhitespace();
                        float nextFloat9 = textScanner.nextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat9) && textScanner.consume(')')) {
                            matrix.preSkew((float) Math.tan(Math.toRadians(nextFloat9)), 0.0f);
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    case 4:
                        textScanner.skipWhitespace();
                        float nextFloat10 = textScanner.nextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat10) && textScanner.consume(')')) {
                            matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(nextFloat10)));
                            break;
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                    case 5:
                        textScanner.skipWhitespace();
                        float nextFloat11 = textScanner.nextFloat();
                        float possibleNextFloat4 = textScanner.possibleNextFloat();
                        textScanner.skipWhitespace();
                        if (!Float.isNaN(nextFloat11) && textScanner.consume(')')) {
                            if (Float.isNaN(possibleNextFloat4)) {
                                matrix.preTranslate(nextFloat11, 0.0f);
                                break;
                            } else {
                                matrix.preTranslate(nextFloat11, possibleNextFloat4);
                                break;
                            }
                        } else {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        break;
                    default:
                        throw new SVGParseException("Invalid transform list fn: " + nextFunction + ")");
                }
                if (textScanner.empty()) {
                    return matrix;
                }
                textScanner.skipCommaWhitespace();
            } else {
                throw new SVGParseException("Bad transform function encountered in transform list: " + str);
            }
        }
        return matrix;
    }

    private void parseUsingSAX(InputStream inputStream) throws SVGParseException {
        Log.d(TAG, "Falling back to SAX parser");
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            SAXHandler sAXHandler = new SAXHandler(this, null);
            xMLReader.setContentHandler(sAXHandler);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", sAXHandler);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e2) {
            throw new SVGParseException("Stream error", e2);
        } catch (ParserConfigurationException e3) {
            throw new SVGParseException("XML parser problem", e3);
        } catch (SAXException e4) {
            throw new SVGParseException("SVG parse error", e4);
        }
    }

    private void parseUsingXmlPullParser(InputStream inputStream, boolean z) throws SVGParseException {
        try {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                XPPAttributesWrapper xPPAttributesWrapper = new XPPAttributesWrapper(newPullParser);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                newPullParser.setInput(inputStream, null);
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                    if (eventType == 0) {
                        startDocument();
                    } else if (eventType == 8) {
                        Log.d(TAG, "PROC INSTR: " + newPullParser.getText());
                        TextScanner textScanner = new TextScanner(newPullParser.getText());
                        handleProcessingInstruction(textScanner.nextToken(), parseProcessingInstructionAttributes(textScanner));
                    } else if (eventType != 10) {
                        if (eventType == 2) {
                            String name = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name = newPullParser.getPrefix() + ':' + name;
                            }
                            startElement(newPullParser.getNamespace(), newPullParser.getName(), name, xPPAttributesWrapper);
                        } else if (eventType == 3) {
                            String name2 = newPullParser.getName();
                            if (newPullParser.getPrefix() != null) {
                                name2 = newPullParser.getPrefix() + ':' + name2;
                            }
                            endElement(newPullParser.getNamespace(), newPullParser.getName(), name2);
                        } else if (eventType == 4) {
                            int[] iArr = new int[2];
                            text(newPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                        } else if (eventType == 5) {
                            text(newPullParser.getText());
                        }
                    } else if (z && this.svgDocument.getRootElement() == null && newPullParser.getText().contains("<!ENTITY ")) {
                        try {
                            Log.d(TAG, "Switching to SAX parser to process entities");
                            inputStream.reset();
                            parseUsingSAX(inputStream);
                            return;
                        } catch (IOException unused) {
                            Log.w(TAG, "Detected internal entity definitions, but could not parse them.");
                            return;
                        }
                    }
                }
                endDocument();
            } catch (XmlPullParserException e2) {
                throw new SVGParseException("XML parser problem", e2);
            }
        } catch (IOException e3) {
            throw new SVGParseException("Stream error", e3);
        }
    }

    private static SVG.Style.VectorEffect parseVectorEffect(String str) {
        str.hashCode();
        if (str.equals(NONE)) {
            return SVG.Style.VectorEffect.None;
        }
        if (str.equals("non-scaling-stroke")) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        return null;
    }

    private static SVG.Box parseViewBox(String str) throws SVGParseException {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        float nextFloat = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float nextFloat2 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float nextFloat3 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float nextFloat4 = textScanner.nextFloat();
        if (Float.isNaN(nextFloat) || Float.isNaN(nextFloat2) || Float.isNaN(nextFloat3) || Float.isNaN(nextFloat4)) {
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        }
        if (nextFloat3 >= 0.0f) {
            if (nextFloat4 >= 0.0f) {
                return new SVG.Box(nextFloat, nextFloat2, nextFloat3, nextFloat4);
            }
            throw new SVGParseException("Invalid viewBox. height cannot be negative");
        }
        throw new SVGParseException("Invalid viewBox. width cannot be negative");
    }

    private void path(Attributes attributes) throws SVGParseException {
        debug("<path>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Path path = new SVG.Path();
            path.document = this.svgDocument;
            path.parent = this.currentElement;
            parseAttributesCore(path, attributes);
            parseAttributesStyle(path, attributes);
            parseAttributesTransform(path, attributes);
            parseAttributesConditional(path, attributes);
            parseAttributesPath(path, attributes);
            this.currentElement.addChild(path);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void pattern(Attributes attributes) throws SVGParseException {
        debug("<pattern>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Pattern pattern = new SVG.Pattern();
            pattern.document = this.svgDocument;
            pattern.parent = this.currentElement;
            parseAttributesCore(pattern, attributes);
            parseAttributesStyle(pattern, attributes);
            parseAttributesConditional(pattern, attributes);
            parseAttributesViewBox(pattern, attributes);
            parseAttributesPattern(pattern, attributes);
            this.currentElement.addChild(pattern);
            this.currentElement = pattern;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void polygon(Attributes attributes) throws SVGParseException {
        debug("<polygon>", new Object[0]);
        if (this.currentElement != null) {
            SVG.PolyLine polygon = new SVG.Polygon();
            polygon.document = this.svgDocument;
            polygon.parent = this.currentElement;
            parseAttributesCore(polygon, attributes);
            parseAttributesStyle(polygon, attributes);
            parseAttributesTransform(polygon, attributes);
            parseAttributesConditional(polygon, attributes);
            parseAttributesPolyLine(polygon, attributes, "polygon");
            this.currentElement.addChild(polygon);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void polyline(Attributes attributes) throws SVGParseException {
        debug("<polyline>", new Object[0]);
        if (this.currentElement != null) {
            SVG.PolyLine polyLine = new SVG.PolyLine();
            polyLine.document = this.svgDocument;
            polyLine.parent = this.currentElement;
            parseAttributesCore(polyLine, attributes);
            parseAttributesStyle(polyLine, attributes);
            parseAttributesTransform(polyLine, attributes);
            parseAttributesConditional(polyLine, attributes);
            parseAttributesPolyLine(polyLine, attributes, "polyline");
            this.currentElement.addChild(polyLine);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void processStyleProperty(SVG.Style style, String str, String str2) {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        try {
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(str).ordinal()]) {
                case 47:
                    SVG.SvgPaint parsePaintSpecifier = parsePaintSpecifier(str2);
                    style.fill = parsePaintSpecifier;
                    if (parsePaintSpecifier != null) {
                        style.specifiedFlags |= 1;
                        return;
                    }
                    return;
                case 48:
                    SVG.Style.FillRule parseFillRule = parseFillRule(str2);
                    style.fillRule = parseFillRule;
                    if (parseFillRule != null) {
                        style.specifiedFlags |= 2;
                        return;
                    }
                    return;
                case 49:
                    Float parseOpacity = parseOpacity(str2);
                    style.fillOpacity = parseOpacity;
                    if (parseOpacity != null) {
                        style.specifiedFlags |= 4;
                        return;
                    }
                    return;
                case 50:
                    SVG.SvgPaint parsePaintSpecifier2 = parsePaintSpecifier(str2);
                    style.stroke = parsePaintSpecifier2;
                    if (parsePaintSpecifier2 != null) {
                        style.specifiedFlags |= 8;
                        return;
                    }
                    return;
                case 51:
                    Float parseOpacity2 = parseOpacity(str2);
                    style.strokeOpacity = parseOpacity2;
                    if (parseOpacity2 != null) {
                        style.specifiedFlags |= 16;
                        return;
                    }
                    return;
                case 52:
                    style.strokeWidth = parseLength(str2);
                    style.specifiedFlags |= 32;
                    break;
                case 53:
                    SVG.Style.LineCap parseStrokeLineCap = parseStrokeLineCap(str2);
                    style.strokeLineCap = parseStrokeLineCap;
                    if (parseStrokeLineCap != null) {
                        style.specifiedFlags |= 64;
                        return;
                    }
                    return;
                case 54:
                    SVG.Style.LineJoin parseStrokeLineJoin = parseStrokeLineJoin(str2);
                    style.strokeLineJoin = parseStrokeLineJoin;
                    if (parseStrokeLineJoin != null) {
                        style.specifiedFlags |= 128;
                        return;
                    }
                    return;
                case 55:
                    style.strokeMiterLimit = Float.valueOf(parseFloat(str2));
                    style.specifiedFlags |= 256;
                    break;
                case 56:
                    if (NONE.equals(str2)) {
                        style.strokeDashArray = null;
                        style.specifiedFlags |= 512;
                        return;
                    }
                    SVG.Length[] parseStrokeDashArray = parseStrokeDashArray(str2);
                    style.strokeDashArray = parseStrokeDashArray;
                    if (parseStrokeDashArray != null) {
                        style.specifiedFlags |= 512;
                        return;
                    }
                    return;
                case 57:
                    style.strokeDashOffset = parseLength(str2);
                    style.specifiedFlags |= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
                    break;
                case 58:
                    style.opacity = parseOpacity(str2);
                    style.specifiedFlags |= 2048;
                    return;
                case 59:
                    style.color = parseColour(str2);
                    style.specifiedFlags |= 4096;
                    break;
                case 60:
                    parseFont(style, str2);
                    return;
                case 61:
                    List<String> parseFontFamily = parseFontFamily(str2);
                    style.fontFamily = parseFontFamily;
                    if (parseFontFamily != null) {
                        style.specifiedFlags |= 8192;
                        return;
                    }
                    return;
                case 62:
                    SVG.Length parseFontSize = parseFontSize(str2);
                    style.fontSize = parseFontSize;
                    if (parseFontSize != null) {
                        style.specifiedFlags |= Http2Stream.EMIT_BUFFER_SIZE;
                        return;
                    }
                    return;
                case 63:
                    Integer parseFontWeight = parseFontWeight(str2);
                    style.fontWeight = parseFontWeight;
                    if (parseFontWeight != null) {
                        style.specifiedFlags |= 32768;
                        return;
                    }
                    return;
                case 64:
                    SVG.Style.FontStyle parseFontStyle = parseFontStyle(str2);
                    style.fontStyle = parseFontStyle;
                    if (parseFontStyle != null) {
                        style.specifiedFlags |= 65536;
                        return;
                    }
                    return;
                case 65:
                    SVG.Style.TextDecoration parseTextDecoration = parseTextDecoration(str2);
                    style.textDecoration = parseTextDecoration;
                    if (parseTextDecoration != null) {
                        style.specifiedFlags |= 131072;
                        return;
                    }
                    return;
                case 66:
                    SVG.Style.TextDirection parseTextDirection = parseTextDirection(str2);
                    style.direction = parseTextDirection;
                    if (parseTextDirection != null) {
                        style.specifiedFlags |= 68719476736L;
                        return;
                    }
                    return;
                case 67:
                    SVG.Style.TextAnchor parseTextAnchor = parseTextAnchor(str2);
                    style.textAnchor = parseTextAnchor;
                    if (parseTextAnchor != null) {
                        style.specifiedFlags |= 262144;
                        return;
                    }
                    return;
                case 68:
                    Boolean parseOverflow = parseOverflow(str2);
                    style.overflow = parseOverflow;
                    if (parseOverflow != null) {
                        style.specifiedFlags |= 524288;
                        return;
                    }
                    return;
                case 69:
                    String parseFunctionalIRI = parseFunctionalIRI(str2, str);
                    style.markerStart = parseFunctionalIRI;
                    style.markerMid = parseFunctionalIRI;
                    style.markerEnd = parseFunctionalIRI;
                    style.specifiedFlags |= 14680064;
                    return;
                case 70:
                    style.markerStart = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 2097152;
                    return;
                case 71:
                    style.markerMid = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 4194304;
                    return;
                case 72:
                    style.markerEnd = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 8388608;
                    return;
                case 73:
                    if (str2.indexOf(124) < 0) {
                        if (VALID_DISPLAY_VALUES.contains('|' + str2 + '|')) {
                            style.display = Boolean.valueOf(!str2.equals(NONE));
                            style.specifiedFlags |= 16777216;
                            return;
                        }
                        return;
                    }
                    return;
                case 74:
                    if (str2.indexOf(124) < 0) {
                        if (VALID_VISIBILITY_VALUES.contains('|' + str2 + '|')) {
                            style.visibility = Boolean.valueOf(str2.equals("visible"));
                            style.specifiedFlags |= 33554432;
                            return;
                        }
                        return;
                    }
                    return;
                case 75:
                    if (str2.equals(CURRENTCOLOR)) {
                        style.stopColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.stopColor = parseColour(str2);
                        } catch (SVGParseException e2) {
                            Log.w(TAG, e2.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 67108864;
                    return;
                case 76:
                    style.stopOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 134217728;
                    return;
                case 77:
                    SVG.CSSClipRect parseClip = parseClip(str2);
                    style.clip = parseClip;
                    if (parseClip != null) {
                        style.specifiedFlags |= 1048576;
                        return;
                    }
                    return;
                case 78:
                    style.clipPath = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 268435456;
                    return;
                case 79:
                    style.clipRule = parseFillRule(str2);
                    style.specifiedFlags |= 536870912;
                    return;
                case 80:
                    style.mask = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 1073741824;
                    return;
                case 81:
                    if (str2.equals(CURRENTCOLOR)) {
                        style.solidColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.solidColor = parseColour(str2);
                        } catch (SVGParseException e3) {
                            Log.w(TAG, e3.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 2147483648L;
                    return;
                case 82:
                    style.solidOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 4294967296L;
                    return;
                case 83:
                    if (str2.equals(CURRENTCOLOR)) {
                        style.viewportFill = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.viewportFill = parseColour(str2);
                        } catch (SVGParseException e4) {
                            Log.w(TAG, e4.getMessage());
                            return;
                        }
                    }
                    style.specifiedFlags |= 8589934592L;
                    return;
                case 84:
                    style.viewportFillOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 17179869184L;
                    return;
                case 85:
                    SVG.Style.VectorEffect parseVectorEffect = parseVectorEffect(str2);
                    style.vectorEffect = parseVectorEffect;
                    if (parseVectorEffect != null) {
                        style.specifiedFlags |= 34359738368L;
                        return;
                    }
                    return;
                case 86:
                    SVG.Style.RenderQuality parseRenderQuality = parseRenderQuality(str2);
                    style.imageRendering = parseRenderQuality;
                    if (parseRenderQuality != null) {
                        style.specifiedFlags |= 137438953472L;
                        return;
                    }
                    return;
                default:
            }
        } catch (SVGParseException unused) {
        }
    }

    private void radialGradient(Attributes attributes) throws SVGParseException {
        debug("<radialGradient>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgRadialGradient svgRadialGradient = new SVG.SvgRadialGradient();
            svgRadialGradient.document = this.svgDocument;
            svgRadialGradient.parent = this.currentElement;
            parseAttributesCore(svgRadialGradient, attributes);
            parseAttributesStyle(svgRadialGradient, attributes);
            parseAttributesGradient(svgRadialGradient, attributes);
            parseAttributesRadialGradient(svgRadialGradient, attributes);
            this.currentElement.addChild(svgRadialGradient);
            this.currentElement = svgRadialGradient;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void rect(Attributes attributes) throws SVGParseException {
        debug("<rect>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Rect rect = new SVG.Rect();
            rect.document = this.svgDocument;
            rect.parent = this.currentElement;
            parseAttributesCore(rect, attributes);
            parseAttributesStyle(rect, attributes);
            parseAttributesTransform(rect, attributes);
            parseAttributesConditional(rect, attributes);
            parseAttributesRect(rect, attributes);
            this.currentElement.addChild(rect);
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void solidColor(Attributes attributes) throws SVGParseException {
        debug("<solidColor>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SolidColor solidColor = new SVG.SolidColor();
            solidColor.document = this.svgDocument;
            solidColor.parent = this.currentElement;
            parseAttributesCore(solidColor, attributes);
            parseAttributesStyle(solidColor, attributes);
            this.currentElement.addChild(solidColor);
            this.currentElement = solidColor;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDocument() {
        this.svgDocument = new SVG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
        if (this.ignoring) {
            this.ignoreDepth++;
        } else if (SVG_NAMESPACE.equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            SVGElem fromString = SVGElem.fromString(str2);
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[fromString.ordinal()]) {
                case 1:
                    svg(attributes);
                    return;
                case 2:
                case 3:
                    g(attributes);
                    return;
                case 4:
                    defs(attributes);
                    return;
                case 5:
                    use(attributes);
                    return;
                case 6:
                    path(attributes);
                    return;
                case 7:
                    rect(attributes);
                    return;
                case 8:
                    circle(attributes);
                    return;
                case 9:
                    ellipse(attributes);
                    return;
                case 10:
                    line(attributes);
                    return;
                case 11:
                    polyline(attributes);
                    return;
                case 12:
                    polygon(attributes);
                    return;
                case 13:
                    text(attributes);
                    return;
                case 14:
                    tspan(attributes);
                    return;
                case 15:
                    tref(attributes);
                    return;
                case 16:
                    zwitch(attributes);
                    return;
                case 17:
                    symbol(attributes);
                    return;
                case 18:
                    marker(attributes);
                    return;
                case 19:
                    linearGradient(attributes);
                    return;
                case 20:
                    radialGradient(attributes);
                    return;
                case 21:
                    stop(attributes);
                    return;
                case 22:
                case 23:
                    this.inMetadataElement = true;
                    this.metadataTag = fromString;
                    return;
                case 24:
                    clipPath(attributes);
                    return;
                case 25:
                    textPath(attributes);
                    return;
                case 26:
                    pattern(attributes);
                    return;
                case 27:
                    image(attributes);
                    return;
                case 28:
                    view(attributes);
                    return;
                case 29:
                    mask(attributes);
                    return;
                case 30:
                    style(attributes);
                    return;
                case 31:
                    solidColor(attributes);
                    return;
                default:
                    this.ignoring = true;
                    this.ignoreDepth = 1;
                    return;
            }
        }
    }

    private void stop(Attributes attributes) throws SVGParseException {
        debug("<stop>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.GradientElement) {
                SVG.Stop stop = new SVG.Stop();
                stop.document = this.svgDocument;
                stop.parent = this.currentElement;
                parseAttributesCore(stop, attributes);
                parseAttributesStyle(stop, attributes);
                parseAttributesStop(stop, attributes);
                this.currentElement.addChild(stop);
                this.currentElement = stop;
                return;
            }
            throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void style(Attributes attributes) throws SVGParseException {
        debug("<style>", new Object[0]);
        if (this.currentElement != null) {
            String str = "all";
            boolean z = true;
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int i3 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i2)).ordinal()];
                if (i3 == 88) {
                    z = trim.equals("text/css");
                } else if (i3 == 89) {
                    str = trim;
                }
            }
            if (z && CSSParser.mediaMatches(str, CSSParser.MediaType.screen)) {
                this.inStyleElement = true;
                return;
            }
            this.ignoring = true;
            this.ignoreDepth = 1;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void svg(Attributes attributes) throws SVGParseException {
        debug("<svg>", new Object[0]);
        SVG.Svg svg = new SVG.Svg();
        svg.document = this.svgDocument;
        svg.parent = this.currentElement;
        parseAttributesCore(svg, attributes);
        parseAttributesStyle(svg, attributes);
        parseAttributesConditional(svg, attributes);
        parseAttributesViewBox(svg, attributes);
        parseAttributesSVG(svg, attributes);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            this.svgDocument.setRootElement(svg);
        } else {
            svgContainer.addChild(svg);
        }
        this.currentElement = svg;
    }

    private void symbol(Attributes attributes) throws SVGParseException {
        debug("<symbol>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgViewBoxContainer symbol = new SVG.Symbol();
            symbol.document = this.svgDocument;
            symbol.parent = this.currentElement;
            parseAttributesCore(symbol, attributes);
            parseAttributesStyle(symbol, attributes);
            parseAttributesConditional(symbol, attributes);
            parseAttributesViewBox(symbol, attributes);
            this.currentElement.addChild(symbol);
            this.currentElement = symbol;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void text(String str) throws SVGParseException {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(str.length());
            }
            this.metadataElementContents.append(str);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(str.length());
            }
            this.styleElementContents.append(str);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(str);
        }
    }

    private void textPath(Attributes attributes) throws SVGParseException {
        debug("<textPath>", new Object[0]);
        if (this.currentElement != null) {
            SVG.TextPath textPath = new SVG.TextPath();
            textPath.document = this.svgDocument;
            textPath.parent = this.currentElement;
            parseAttributesCore(textPath, attributes);
            parseAttributesStyle(textPath, attributes);
            parseAttributesConditional(textPath, attributes);
            parseAttributesTextPath(textPath, attributes);
            this.currentElement.addChild(textPath);
            this.currentElement = textPath;
            SVG.SvgContainer svgContainer = textPath.parent;
            if (svgContainer instanceof SVG.TextRoot) {
                textPath.setTextRoot((SVG.TextRoot) svgContainer);
                return;
            } else {
                textPath.setTextRoot(((SVG.TextChild) svgContainer).getTextRoot());
                return;
            }
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void tref(Attributes attributes) throws SVGParseException {
        debug("<tref>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.TextContainer) {
                SVG.TRef tRef = new SVG.TRef();
                tRef.document = this.svgDocument;
                tRef.parent = this.currentElement;
                parseAttributesCore(tRef, attributes);
                parseAttributesStyle(tRef, attributes);
                parseAttributesConditional(tRef, attributes);
                parseAttributesTRef(tRef, attributes);
                this.currentElement.addChild(tRef);
                SVG.SvgContainer svgContainer2 = tRef.parent;
                if (svgContainer2 instanceof SVG.TextRoot) {
                    tRef.setTextRoot((SVG.TextRoot) svgContainer2);
                    return;
                } else {
                    tRef.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
                    return;
                }
            }
            throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void tspan(Attributes attributes) throws SVGParseException {
        debug("<tspan>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer != null) {
            if (svgContainer instanceof SVG.TextContainer) {
                SVG.TSpan tSpan = new SVG.TSpan();
                tSpan.document = this.svgDocument;
                tSpan.parent = this.currentElement;
                parseAttributesCore(tSpan, attributes);
                parseAttributesStyle(tSpan, attributes);
                parseAttributesConditional(tSpan, attributes);
                parseAttributesTextPosition(tSpan, attributes);
                this.currentElement.addChild(tSpan);
                this.currentElement = tSpan;
                SVG.SvgContainer svgContainer2 = tSpan.parent;
                if (svgContainer2 instanceof SVG.TextRoot) {
                    tSpan.setTextRoot((SVG.TextRoot) svgContainer2);
                    return;
                } else {
                    tSpan.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
                    return;
                }
            }
            throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void use(Attributes attributes) throws SVGParseException {
        debug("<use>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Use use = new SVG.Use();
            use.document = this.svgDocument;
            use.parent = this.currentElement;
            parseAttributesCore(use, attributes);
            parseAttributesStyle(use, attributes);
            parseAttributesTransform(use, attributes);
            parseAttributesConditional(use, attributes);
            parseAttributesUse(use, attributes);
            this.currentElement.addChild(use);
            this.currentElement = use;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void view(Attributes attributes) throws SVGParseException {
        debug("<view>", new Object[0]);
        if (this.currentElement != null) {
            SVG.SvgViewBoxContainer view = new SVG.View();
            view.document = this.svgDocument;
            view.parent = this.currentElement;
            parseAttributesCore(view, attributes);
            parseAttributesConditional(view, attributes);
            parseAttributesViewBox(view, attributes);
            this.currentElement.addChild(view);
            this.currentElement = view;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    private void zwitch(Attributes attributes) throws SVGParseException {
        debug("<switch>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Switch r0 = new SVG.Switch();
            r0.document = this.svgDocument;
            r0.parent = this.currentElement;
            parseAttributesCore(r0, attributes);
            parseAttributesStyle(r0, attributes);
            parseAttributesTransform(r0, attributes);
            parseAttributesConditional(r0, attributes);
            this.currentElement.addChild(r0);
            this.currentElement = r0;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVG parse(InputStream inputStream, boolean z) throws SVGParseException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            inputStream.mark(4096);
            parseUsingXmlPullParser(inputStream, z);
            return this.svgDocument;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Log.e(TAG, "Exception thrown closing input stream");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PreserveAspectRatio parsePreserveAspectRatio(String str) throws SVGParseException {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        String nextToken = textScanner.nextToken();
        if ("defer".equals(nextToken)) {
            textScanner.skipWhitespace();
            nextToken = textScanner.nextToken();
        }
        PreserveAspectRatio.Alignment alignment = AspectRatioKeywords.get(nextToken);
        PreserveAspectRatio.Scale scale = null;
        textScanner.skipWhitespace();
        if (!textScanner.empty()) {
            String nextToken2 = textScanner.nextToken();
            nextToken2.hashCode();
            if (nextToken2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.meet;
            } else if (!nextToken2.equals("slice")) {
                throw new SVGParseException("Invalid preserveAspectRatio definition: " + str);
            } else {
                scale = PreserveAspectRatio.Scale.slice;
            }
        }
        return new PreserveAspectRatio(alignment, scale);
    }

    private static float parseFloat(String str, int i2, int i3) throws SVGParseException {
        float parseNumber = new NumberParser().parseNumber(str, i2, i3);
        if (Float.isNaN(parseNumber)) {
            throw new SVGParseException("Invalid float value: " + str);
        }
        return parseNumber;
    }

    private void text(char[] cArr, int i2, int i3) throws SVGParseException {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(i3);
            }
            this.metadataElementContents.append(cArr, i2, i3);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(i3);
            }
            this.styleElementContents.append(cArr, i2, i3);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(new String(cArr, i2, i3));
        }
    }

    private void text(Attributes attributes) throws SVGParseException {
        debug("<text>", new Object[0]);
        if (this.currentElement != null) {
            SVG.Text text = new SVG.Text();
            text.document = this.svgDocument;
            text.parent = this.currentElement;
            parseAttributesCore(text, attributes);
            parseAttributesStyle(text, attributes);
            parseAttributesTransform(text, attributes);
            parseAttributesConditional(text, attributes);
            parseAttributesTextPosition(text, attributes);
            this.currentElement.addChild(text);
            this.currentElement = text;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }
}