package android.support.v4.p015h;

import android.util.Log;
import java.io.Writer;

public class C0171e extends Writer {
    private final String f862a;
    private StringBuilder f863b = new StringBuilder(128);

    public C0171e(String str) {
        this.f862a = str;
    }

    private void m1541a() {
        if (this.f863b.length() > 0) {
            Log.d(this.f862a, this.f863b.toString());
            this.f863b.delete(0, this.f863b.length());
        }
    }

    public void close() {
        m1541a();
    }

    public void flush() {
        m1541a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1541a();
            } else {
                this.f863b.append(c);
            }
        }
    }
}
