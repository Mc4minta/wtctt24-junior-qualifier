package c.h.j;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class b implements Spannable {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Spannable f2980b;

    /* renamed from: c  reason: collision with root package name */
    private final a f2981c;

    /* renamed from: d  reason: collision with root package name */
    private final PrecomputedText f2982d;

    public a a() {
        return this.f2981c;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f2980b;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.f2980b.charAt(i2);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f2980b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f2980b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f2980b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return (T[]) this.f2982d.getSpans(i2, i3, cls);
        }
        return (T[]) this.f2980b.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f2980b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f2980b.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2982d.removeSpan(obj);
                return;
            } else {
                this.f2980b.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2982d.setSpan(obj, i2, i3, i4);
                return;
            } else {
                this.f2980b.setSpan(obj, i2, i3, i4);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.f2980b.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f2980b.toString();
    }

    /* compiled from: PrecomputedTextCompat.java */
    /* loaded from: classes.dex */
    public static final class a {
        private final TextPaint a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f2983b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2984c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2985d;

        /* renamed from: e  reason: collision with root package name */
        final PrecomputedText.Params f2986e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: c.h.j.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0065a {
            private final TextPaint a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f2987b;

            /* renamed from: c  reason: collision with root package name */
            private int f2988c;

            /* renamed from: d  reason: collision with root package name */
            private int f2989d;

            public C0065a(TextPaint textPaint) {
                this.a = textPaint;
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 23) {
                    this.f2988c = 1;
                    this.f2989d = 1;
                } else {
                    this.f2989d = 0;
                    this.f2988c = 0;
                }
                if (i2 >= 18) {
                    this.f2987b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f2987b = null;
                }
            }

            public a a() {
                return new a(this.a, this.f2987b, this.f2988c, this.f2989d);
            }

            public C0065a b(int i2) {
                this.f2988c = i2;
                return this;
            }

            public C0065a c(int i2) {
                this.f2989d = i2;
                return this;
            }

            public C0065a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2987b = textDirectionHeuristic;
                return this;
            }
        }

        @SuppressLint({"NewApi"})
        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2986e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f2986e = null;
            }
            this.a = textPaint;
            this.f2983b = textDirectionHeuristic;
            this.f2984c = i2;
            this.f2985d = i3;
        }

        public boolean a(a aVar) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 < 23 || (this.f2984c == aVar.b() && this.f2985d == aVar.c())) && this.a.getTextSize() == aVar.e().getTextSize() && this.a.getTextScaleX() == aVar.e().getTextScaleX() && this.a.getTextSkewX() == aVar.e().getTextSkewX()) {
                if ((i2 < 21 || (this.a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) && this.a.getFlags() == aVar.e().getFlags()) {
                    if (i2 >= 24) {
                        if (!this.a.getTextLocales().equals(aVar.e().getTextLocales())) {
                            return false;
                        }
                    } else if (i2 >= 17 && !this.a.getTextLocale().equals(aVar.e().getTextLocale())) {
                        return false;
                    }
                    return this.a.getTypeface() == null ? aVar.e().getTypeface() == null : this.a.getTypeface().equals(aVar.e().getTypeface());
                }
                return false;
            }
            return false;
        }

        public int b() {
            return this.f2984c;
        }

        public int c() {
            return this.f2985d;
        }

        public TextDirectionHeuristic d() {
            return this.f2983b;
        }

        public TextPaint e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (a(aVar)) {
                    return Build.VERSION.SDK_INT < 18 || this.f2983b == aVar.d();
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                return androidx.core.util.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.f2983b, Integer.valueOf(this.f2984c), Integer.valueOf(this.f2985d));
            }
            if (i2 >= 21) {
                return androidx.core.util.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.f2983b, Integer.valueOf(this.f2984c), Integer.valueOf(this.f2985d));
            }
            if (i2 >= 18) {
                return androidx.core.util.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.f2983b, Integer.valueOf(this.f2984c), Integer.valueOf(this.f2985d));
            }
            if (i2 >= 17) {
                return androidx.core.util.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.f2983b, Integer.valueOf(this.f2984c), Integer.valueOf(this.f2985d));
            }
            return androidx.core.util.d.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTypeface(), this.f2983b, Integer.valueOf(this.f2984c), Integer.valueOf(this.f2985d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.a.getTextSize());
            sb.append(", textScaleX=" + this.a.getTextScaleX());
            sb.append(", textSkewX=" + this.a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                sb.append(", letterSpacing=" + this.a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            }
            if (i2 >= 24) {
                sb.append(", textLocale=" + this.a.getTextLocales());
            } else if (i2 >= 17) {
                sb.append(", textLocale=" + this.a.getTextLocale());
            }
            sb.append(", typeface=" + this.a.getTypeface());
            if (i2 >= 26) {
                sb.append(", variationSettings=" + this.a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2983b);
            sb.append(", breakStrategy=" + this.f2984c);
            sb.append(", hyphenationFrequency=" + this.f2985d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.f2983b = params.getTextDirection();
            this.f2984c = params.getBreakStrategy();
            this.f2985d = params.getHyphenationFrequency();
            this.f2986e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}