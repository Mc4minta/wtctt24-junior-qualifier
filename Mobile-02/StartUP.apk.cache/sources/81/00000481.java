package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes.dex */
public class AggregateException extends Exception {
    private List<Throwable> a;

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        int i2 = -1;
        for (Throwable th : this.a) {
            printStream.append("\n");
            printStream.append("  Inner throwable #");
            i2++;
            printStream.append((CharSequence) Integer.toString(i2));
            printStream.append(": ");
            th.printStackTrace(printStream);
            printStream.append("\n");
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        int i2 = -1;
        for (Throwable th : this.a) {
            printWriter.append("\n");
            printWriter.append("  Inner throwable #");
            i2++;
            printWriter.append((CharSequence) Integer.toString(i2));
            printWriter.append(": ");
            th.printStackTrace(printWriter);
            printWriter.append("\n");
        }
    }
}