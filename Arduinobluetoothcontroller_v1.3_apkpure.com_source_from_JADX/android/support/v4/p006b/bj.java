package android.support.v4.p006b;

import android.support.v4.p015h.C0170d;
import android.support.v4.p015h.C0182r;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class bj extends bh {
    static boolean f707a = false;
    final C0182r f708b = new C0182r();
    final C0182r f709c = new C0182r();
    final String f710d;
    boolean f711e;
    boolean f712f;
    private aj f713g;

    bj(String str, aj ajVar, boolean z) {
        this.f710d = str;
        this.f713g = ajVar;
        this.f711e = z;
    }

    void m1196a(aj ajVar) {
        this.f713g = ajVar;
    }

    public void m1197a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f708b.m1571b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f708b.m1571b(); i2++) {
                bk bkVar = (bk) this.f708b.m1577e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f708b.m1576d(i2));
                printWriter.print(": ");
                printWriter.println(bkVar.toString());
                bkVar.m1208a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f709c.m1571b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f709c.m1571b()) {
                bkVar = (bk) this.f709c.m1577e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f709c.m1576d(i));
                printWriter.print(": ");
                printWriter.println(bkVar.toString());
                bkVar.m1208a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo195a() {
        int b = this.f708b.m1571b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            bk bkVar = (bk) this.f708b.m1577e(i);
            int i2 = (!bkVar.f721h || bkVar.f719f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    void m1199b() {
        if (f707a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f711e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f711e = true;
        for (int b = this.f708b.m1571b() - 1; b >= 0; b--) {
            ((bk) this.f708b.m1577e(b)).m1206a();
        }
    }

    void m1200c() {
        if (f707a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f711e) {
            for (int b = this.f708b.m1571b() - 1; b >= 0; b--) {
                ((bk) this.f708b.m1577e(b)).m1212e();
            }
            this.f711e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m1201d() {
        if (f707a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f711e) {
            this.f712f = true;
            this.f711e = false;
            for (int b = this.f708b.m1571b() - 1; b >= 0; b--) {
                ((bk) this.f708b.m1577e(b)).m1209b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m1202e() {
        if (this.f712f) {
            if (f707a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f712f = false;
            for (int b = this.f708b.m1571b() - 1; b >= 0; b--) {
                ((bk) this.f708b.m1577e(b)).m1210c();
            }
        }
    }

    void m1203f() {
        for (int b = this.f708b.m1571b() - 1; b >= 0; b--) {
            ((bk) this.f708b.m1577e(b)).f724k = true;
        }
    }

    void m1204g() {
        for (int b = this.f708b.m1571b() - 1; b >= 0; b--) {
            ((bk) this.f708b.m1577e(b)).m1211d();
        }
    }

    void m1205h() {
        int b;
        if (!this.f712f) {
            if (f707a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f708b.m1571b() - 1; b >= 0; b--) {
                ((bk) this.f708b.m1577e(b)).m1213f();
            }
            this.f708b.m1574c();
        }
        if (f707a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f709c.m1571b() - 1; b >= 0; b--) {
            ((bk) this.f709c.m1577e(b)).m1213f();
        }
        this.f709c.m1574c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0170d.m1540a(this.f713g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
