package e.j.l.w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import kotlin.l0.y;

/* compiled from: Search.kt */
/* loaded from: classes2.dex */
public final class a {
    public final <T extends Comparable<? super T>> T a(List<? extends T> searchList, T itemToFind) {
        m.g(searchList, "searchList");
        m.g(itemToFind, "itemToFind");
        int binarySearch = Collections.binarySearch(searchList, itemToFind);
        if (Math.abs(binarySearch) >= searchList.size() || binarySearch < 0) {
            return null;
        }
        return searchList.get(binarySearch);
    }

    public final List<String> b(List<String> searchList, String itemToFind, int i2) {
        boolean Q;
        boolean Q2;
        m.g(searchList, "searchList");
        m.g(itemToFind, "itemToFind");
        if (searchList.isEmpty()) {
            return null;
        }
        int binarySearch = Collections.binarySearch(searchList, itemToFind);
        int abs = Math.abs(binarySearch);
        ArrayList arrayList = new ArrayList();
        if (abs >= searchList.size()) {
            String str = searchList.get(searchList.size() - 1);
            Q2 = x.Q(str, itemToFind, false, 2, null);
            if (Q2) {
                arrayList.add(str);
            }
            return arrayList;
        }
        if (binarySearch < 0) {
            binarySearch = abs - 1;
        }
        int i3 = (i2 + binarySearch) - 1;
        if (binarySearch <= i3) {
            while (true) {
                int i4 = binarySearch + 1;
                if (binarySearch >= searchList.size()) {
                    break;
                }
                String str2 = searchList.get(binarySearch);
                if (str2 != null) {
                    Q = x.Q(str2, itemToFind, false, 2, null);
                    if (Q) {
                        arrayList.add(str2);
                    }
                }
                if (binarySearch == i3) {
                    break;
                }
                binarySearch = i4;
            }
        }
        return arrayList;
    }

    public final String c(String text, int i2) {
        m.g(text, "text");
        Matcher matcher = Pattern.compile("\\w+").matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            boolean z = false;
            if (start <= i2 && i2 <= end) {
                z = true;
                continue;
            }
            if (z) {
                return text.subSequence(start, end).toString();
            }
        }
        return "";
    }

    public final String d(String text, int i2) {
        int n0;
        m.g(text, "text");
        if (i2 < 0 || i2 > text.length()) {
            return "";
        }
        String substring = text.substring(0, i2);
        m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        n0 = y.n0(substring, " ", 0, false, 6, null);
        int i3 = n0 + 1;
        if (i3 < 0 || i3 > substring.length()) {
            return "";
        }
        String substring2 = substring.substring(i3, i2);
        m.f(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring2;
    }
}