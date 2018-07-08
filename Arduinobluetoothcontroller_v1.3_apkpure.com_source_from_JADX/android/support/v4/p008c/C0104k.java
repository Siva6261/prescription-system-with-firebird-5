package android.support.v4.p008c;

import android.support.v4.p015h.C0170d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0104k {
    int f799a;
    C0074m f800b;
    C0073l f801c;
    boolean f802d;
    boolean f803e;
    boolean f804f;
    boolean f805g;
    boolean f806h;

    public String m1318a(Object obj) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0170d.m1540a(obj, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m1319a() {
        this.f802d = true;
        this.f804f = false;
        this.f803e = false;
        m1324b();
    }

    public void m1320a(int i, C0074m c0074m) {
        if (this.f800b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f800b = c0074m;
        this.f799a = i;
    }

    public void m1321a(C0073l c0073l) {
        if (this.f801c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f801c = c0073l;
    }

    public void m1322a(C0074m c0074m) {
        if (this.f800b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f800b != c0074m) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f800b = null;
        }
    }

    public void m1323a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f799a);
        printWriter.print(" mListener=");
        printWriter.println(this.f800b);
        if (this.f802d || this.f805g || this.f806h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f802d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f805g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f806h);
        }
        if (this.f803e || this.f804f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f803e);
            printWriter.print(" mReset=");
            printWriter.println(this.f804f);
        }
    }

    protected void m1324b() {
    }

    public void m1325b(C0073l c0073l) {
        if (this.f801c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f801c != c0073l) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f801c = null;
        }
    }

    public void m1326c() {
        this.f802d = false;
        m1327d();
    }

    protected void m1327d() {
    }

    public void m1328e() {
        m1329f();
        this.f804f = true;
        this.f802d = false;
        this.f803e = false;
        this.f805g = false;
        this.f806h = false;
    }

    protected void m1329f() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0170d.m1540a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f799a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
