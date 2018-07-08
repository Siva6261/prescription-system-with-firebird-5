package android.support.v4.p006b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.p015h.C0165q;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class aj extends ah {
    private final Activity f604a;
    final Context f605b;
    final int f606c;
    final am f607d;
    private final Handler f608e;
    private C0165q f609f;
    private boolean f610g;
    private bj f611h;
    private boolean f612i;
    private boolean f613j;

    aj(Activity activity, Context context, Handler handler, int i) {
        this.f607d = new am();
        this.f604a = activity;
        this.f605b = context;
        this.f608e = handler;
        this.f606c = i;
    }

    aj(ad adVar) {
        this(adVar, adVar, adVar.f591a, 0);
    }

    bj m984a(String str, boolean z, boolean z2) {
        if (this.f609f == null) {
            this.f609f = new C0165q();
        }
        bj bjVar = (bj) this.f609f.get(str);
        if (bjVar != null) {
            bjVar.m1196a(this);
            return bjVar;
        } else if (!z2) {
            return bjVar;
        } else {
            bjVar = new bj(str, this, z);
            this.f609f.put(str, bjVar);
            return bjVar;
        }
    }

    public View mo167a(int i) {
        return null;
    }

    public void mo169a(C0051y c0051y, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f605b.startActivity(intent);
    }

    void m987a(C0165q c0165q) {
        this.f609f = c0165q;
    }

    void m988a(String str) {
        if (this.f609f != null) {
            bj bjVar = (bj) this.f609f.get(str);
            if (bjVar != null && !bjVar.f712f) {
                bjVar.m1205h();
                this.f609f.remove(str);
            }
        }
    }

    public void mo170a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    void m990a(boolean z) {
        this.f610g = z;
        if (this.f611h != null && this.f613j) {
            this.f613j = false;
            if (z) {
                this.f611h.m1201d();
            } else {
                this.f611h.m1200c();
            }
        }
    }

    public boolean mo168a() {
        return true;
    }

    public boolean mo171a(C0051y c0051y) {
        return true;
    }

    public LayoutInflater mo172b() {
        return (LayoutInflater) this.f605b.getSystemService("layout_inflater");
    }

    void mo173b(C0051y c0051y) {
    }

    void m995b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f613j);
        if (this.f611h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f611h)));
            printWriter.println(":");
            this.f611h.m1197a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void mo174c() {
    }

    public boolean mo175d() {
        return true;
    }

    public int mo176e() {
        return this.f606c;
    }

    Activity m999f() {
        return this.f604a;
    }

    Context m1000g() {
        return this.f605b;
    }

    Handler m1001h() {
        return this.f608e;
    }

    am m1002i() {
        return this.f607d;
    }

    boolean m1003j() {
        return this.f610g;
    }

    void m1004k() {
        if (!this.f613j) {
            this.f613j = true;
            if (this.f611h != null) {
                this.f611h.m1199b();
            } else if (!this.f612i) {
                this.f611h = m984a("(root)", this.f613j, false);
                if (!(this.f611h == null || this.f611h.f711e)) {
                    this.f611h.m1199b();
                }
            }
            this.f612i = true;
        }
    }

    void m1005l() {
        if (this.f611h != null) {
            this.f611h.m1205h();
        }
    }

    void m1006m() {
        if (this.f609f != null) {
            int size = this.f609f.size();
            bj[] bjVarArr = new bj[size];
            for (int i = size - 1; i >= 0; i--) {
                bjVarArr[i] = (bj) this.f609f.m1503c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                bj bjVar = bjVarArr[i2];
                bjVar.m1202e();
                bjVar.m1204g();
            }
        }
    }

    C0165q m1007n() {
        int i;
        int i2 = 0;
        if (this.f609f != null) {
            int size = this.f609f.size();
            bj[] bjVarArr = new bj[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                bjVarArr[i3] = (bj) this.f609f.m1503c(i3);
            }
            i = 0;
            while (i2 < size) {
                bj bjVar = bjVarArr[i2];
                if (bjVar.f712f) {
                    i = 1;
                } else {
                    bjVar.m1205h();
                    this.f609f.remove(bjVar.f710d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        return i != 0 ? this.f609f : null;
    }
}
