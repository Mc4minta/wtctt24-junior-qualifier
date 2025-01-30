package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: NavDeepLink.java */
/* loaded from: classes.dex */
public final class h {
    private static final Pattern a = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<String> f1881b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, c> f1882c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Pattern f1883d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1884e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1885f;

    /* renamed from: g  reason: collision with root package name */
    private final String f1886g;

    /* renamed from: h  reason: collision with root package name */
    private final String f1887h;

    /* renamed from: i  reason: collision with root package name */
    private Pattern f1888i;

    /* renamed from: j  reason: collision with root package name */
    private final String f1889j;

    /* compiled from: NavDeepLink.java */
    /* loaded from: classes.dex */
    public static final class a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f1890b;

        /* renamed from: c  reason: collision with root package name */
        private String f1891c;

        public h a() {
            return new h(this.a, this.f1890b, this.f1891c);
        }

        public a b(String str) {
            if (!str.isEmpty()) {
                this.f1890b = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        public a c(String str) {
            this.f1891c = str;
            return this;
        }

        public a d(String str) {
            this.a = str;
            return this;
        }
    }

    /* compiled from: NavDeepLink.java */
    /* loaded from: classes.dex */
    private static class b implements Comparable<b> {
        String a;

        /* renamed from: b  reason: collision with root package name */
        String f1892b;

        b(String str) {
            String[] split = str.split("/", -1);
            this.a = split[0];
            this.f1892b = split[1];
        }

        @Override // java.lang.Comparable
        /* renamed from: h */
        public int compareTo(b bVar) {
            int i2 = this.a.equals(bVar.a) ? 2 : 0;
            return this.f1892b.equals(bVar.f1892b) ? i2 + 1 : i2;
        }
    }

    /* compiled from: NavDeepLink.java */
    /* loaded from: classes.dex */
    private static class c {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<String> f1893b = new ArrayList<>();

        c() {
        }

        void a(String str) {
            this.f1893b.add(str);
        }

        String b(int i2) {
            return this.f1893b.get(i2);
        }

        String c() {
            return this.a;
        }

        void d(String str) {
            this.a = str;
        }

        public int e() {
            return this.f1893b.size();
        }
    }

    h(String str, String str2, String str3) {
        this.f1883d = null;
        int i2 = 0;
        this.f1884e = false;
        this.f1885f = false;
        this.f1888i = null;
        this.f1886g = str;
        this.f1887h = str2;
        this.f1889j = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.f1885f = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!a.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.f1885f) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    a(str.substring(0, matcher.start()), sb, compile);
                }
                this.f1884e = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    c cVar = new c();
                    int i3 = i2;
                    while (matcher2.find()) {
                        cVar.a(matcher2.group(1));
                        sb2.append(Pattern.quote(queryParameter.substring(i3, matcher2.start())));
                        sb2.append("(.+?)?");
                        i3 = matcher2.end();
                    }
                    if (i3 < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i3)));
                    }
                    cVar.d(sb2.toString().replace(".*", "\\E.*\\Q"));
                    this.f1882c.put(str4, cVar);
                    i2 = 0;
                }
            } else {
                this.f1884e = a(str, sb, compile);
            }
            this.f1883d = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"));
        }
        if (str3 != null) {
            if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                b bVar = new b(str3);
                this.f1888i = Pattern.compile(("^(" + bVar.a + "|[*]+)/(" + bVar.f1892b + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
                return;
            }
            throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
        }
    }

    private boolean a(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i2 = 0;
        while (matcher.find()) {
            this.f1881b.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i2, matcher.start())));
            sb.append("(.+?)");
            i2 = matcher.end();
            z = false;
        }
        if (i2 < str.length()) {
            sb.append(Pattern.quote(str.substring(i2)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }

    private boolean f(Bundle bundle, String str, String str2, d dVar) {
        if (dVar != null) {
            try {
                dVar.b().g(bundle, str, str2);
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        }
        bundle.putString(str, str2);
        return false;
    }

    public String b() {
        return this.f1887h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle c(Uri uri, Map<String, d> map) {
        Matcher matcher;
        Matcher matcher2 = this.f1883d.matcher(uri.toString());
        if (matcher2.matches()) {
            Bundle bundle = new Bundle();
            int size = this.f1881b.size();
            int i2 = 0;
            while (i2 < size) {
                String str = this.f1881b.get(i2);
                i2++;
                if (f(bundle, str, Uri.decode(matcher2.group(i2)), map.get(str))) {
                    return null;
                }
            }
            if (this.f1885f) {
                for (String str2 : this.f1882c.keySet()) {
                    c cVar = this.f1882c.get(str2);
                    String queryParameter = uri.getQueryParameter(str2);
                    if (queryParameter != null) {
                        matcher = Pattern.compile(cVar.c()).matcher(queryParameter);
                        if (!matcher.matches()) {
                            return null;
                        }
                    } else {
                        matcher = null;
                    }
                    for (int i3 = 0; i3 < cVar.e(); i3++) {
                        String decode = matcher != null ? Uri.decode(matcher.group(i3 + 1)) : null;
                        String b2 = cVar.b(i3);
                        d dVar = map.get(b2);
                        if (dVar != null && (decode == null || decode.replaceAll("[{}]", "").equals(b2))) {
                            if (dVar.a() != null) {
                                decode = dVar.a().toString();
                            } else if (dVar.d()) {
                                decode = null;
                            }
                        }
                        if (f(bundle, b2, decode, dVar)) {
                            return null;
                        }
                    }
                }
            }
            return bundle;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(String str) {
        if (this.f1889j == null || !this.f1888i.matcher(str).matches()) {
            return -1;
        }
        return new b(this.f1889j).compareTo(new b(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f1884e;
    }
}