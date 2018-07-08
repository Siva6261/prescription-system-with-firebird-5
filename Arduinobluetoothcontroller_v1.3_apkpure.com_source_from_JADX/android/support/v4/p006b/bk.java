package android.support.v4.p006b;

import android.os.Bundle;
import android.support.v4.p008c.C0073l;
import android.support.v4.p008c.C0074m;
import android.support.v4.p008c.C0104k;
import android.support.v4.p015h.C0170d;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class bk implements C0073l, C0074m {
    final int f714a;
    final Bundle f715b;
    bi f716c;
    C0104k f717d;
    boolean f718e;
    boolean f719f;
    Object f720g;
    boolean f721h;
    boolean f722i;
    boolean f723j;
    boolean f724k;
    boolean f725l;
    boolean f726m;
    bk f727n;
    final /* synthetic */ bj f728o;

    void m1206a() {
        if (this.f722i && this.f723j) {
            this.f721h = true;
        } else if (!this.f721h) {
            this.f721h = true;
            if (bj.f707a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f717d == null && this.f716c != null) {
                this.f717d = this.f716c.m1192a(this.f714a, this.f715b);
            }
            if (this.f717d == null) {
                return;
            }
            if (!this.f717d.getClass().isMemberClass() || Modifier.isStatic(this.f717d.getClass().getModifiers())) {
                if (!this.f726m) {
                    this.f717d.m1320a(this.f714a, this);
                    this.f717d.m1321a((C0073l) this);
                    this.f726m = true;
                }
                this.f717d.m1319a();
                return;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f717d);
        }
    }

    void m1207a(C0104k c0104k, Object obj) {
        String str;
        if (this.f716c != null) {
            if (this.f728o.f713g != null) {
                String str2 = this.f728o.f713g.f607d.f644v;
                this.f728o.f713g.f607d.f644v = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (bj.f707a) {
                    Log.v("LoaderManager", "  onLoadFinished in " + c0104k + ": " + c0104k.m1318a(obj));
                }
                this.f716c.m1194a(c0104k, obj);
                this.f719f = true;
            } finally {
                if (this.f728o.f713g != null) {
                    this.f728o.f713g.f607d.f644v = str;
                }
            }
        }
    }

    public void m1208a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f714a);
        printWriter.print(" mArgs=");
        printWriter.println(this.f715b);
        printWriter.print(str);
        printWriter.print("mCallbacks=");
        printWriter.println(this.f716c);
        printWriter.print(str);
        printWriter.print("mLoader=");
        printWriter.println(this.f717d);
        if (this.f717d != null) {
            this.f717d.m1323a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f718e || this.f719f) {
            printWriter.print(str);
            printWriter.print("mHaveData=");
            printWriter.print(this.f718e);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.f719f);
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(this.f720g);
        }
        printWriter.print(str);
        printWriter.print("mStarted=");
        printWriter.print(this.f721h);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.f724k);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f725l);
        printWriter.print(str);
        printWriter.print("mRetaining=");
        printWriter.print(this.f722i);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.f723j);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.f726m);
        if (this.f727n != null) {
            printWriter.print(str);
            printWriter.println("Pending Loader ");
            printWriter.print(this.f727n);
            printWriter.println(":");
            this.f727n.m1208a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    void m1209b() {
        if (bj.f707a) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.f722i = true;
        this.f723j = this.f721h;
        this.f721h = false;
        this.f716c = null;
    }

    void m1210c() {
        if (this.f722i) {
            if (bj.f707a) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.f722i = false;
            if (!(this.f721h == this.f723j || this.f721h)) {
                m1212e();
            }
        }
        if (this.f721h && this.f718e && !this.f724k) {
            m1207a(this.f717d, this.f720g);
        }
    }

    void m1211d() {
        if (this.f721h && this.f724k) {
            this.f724k = false;
            if (this.f718e) {
                m1207a(this.f717d, this.f720g);
            }
        }
    }

    void m1212e() {
        if (bj.f707a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f721h = false;
        if (!this.f722i && this.f717d != null && this.f726m) {
            this.f726m = false;
            this.f717d.m1322a((C0074m) this);
            this.f717d.m1325b(this);
            this.f717d.m1326c();
        }
    }

    void m1213f() {
        String str;
        bi biVar = null;
        if (bj.f707a) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.f725l = true;
        boolean z = this.f719f;
        this.f719f = false;
        if (this.f716c != null && this.f717d != null && this.f718e && z) {
            if (bj.f707a) {
                Log.v("LoaderManager", "  Reseting: " + this);
            }
            if (this.f728o.f713g != null) {
                String str2 = this.f728o.f713g.f607d.f644v;
                this.f728o.f713g.f607d.f644v = "onLoaderReset";
                str = str2;
            } else {
                str = null;
            }
            try {
                this.f716c.m1193a(this.f717d);
            } finally {
                biVar = this.f728o.f713g;
                if (biVar != null) {
                    biVar = this.f728o.f713g.f607d;
                    biVar.f644v = str;
                }
            }
        }
        this.f716c = biVar;
        this.f720g = biVar;
        this.f718e = false;
        if (this.f717d != null) {
            if (this.f726m) {
                this.f726m = false;
                this.f717d.m1322a((C0074m) this);
                this.f717d.m1325b(this);
            }
            this.f717d.m1328e();
        }
        if (this.f727n != null) {
            this.f727n.m1213f();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.f714a);
        stringBuilder.append(" : ");
        C0170d.m1540a(this.f717d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
