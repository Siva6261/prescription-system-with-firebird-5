package android.support.v4.p006b;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p015h.C0165q;
import android.support.v4.p015h.C0170d;
import android.support.v4.view.ab;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0051y implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final C0165q f472a = new C0165q();
    static final Object f473j = new Object();
    int f474A;
    am f475B;
    aj f476C;
    am f477D;
    C0051y f478E;
    int f479F;
    int f480G;
    String f481H;
    boolean f482I;
    boolean f483J;
    boolean f484K;
    boolean f485L;
    boolean f486M;
    boolean f487N = true;
    boolean f488O;
    int f489P;
    ViewGroup f490Q;
    View f491R;
    View f492S;
    boolean f493T;
    boolean f494U = true;
    bj f495V;
    boolean f496W;
    boolean f497X;
    Object f498Y = null;
    Object f499Z = f473j;
    Object aa = null;
    Object ab = f473j;
    Object ac = null;
    Object ad = f473j;
    Boolean ae;
    Boolean af;
    br ag = null;
    br ah = null;
    int f500k = 0;
    View f501l;
    int f502m;
    Bundle f503n;
    SparseArray f504o;
    int f505p = -1;
    String f506q;
    Bundle f507r;
    C0051y f508s;
    int f509t = -1;
    int f510u;
    boolean f511v;
    boolean f512w;
    boolean f513x;
    boolean f514y;
    boolean f515z;

    public static C0051y m809a(Context context, String str) {
        return C0051y.m810a(context, str, null);
    }

    public static C0051y m810a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f472a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f472a.put(str, cls);
            }
            C0051y c0051y = (C0051y) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(c0051y.getClass().getClassLoader());
                c0051y.f507r = bundle;
            }
            return c0051y;
        } catch (Exception e) {
            throw new aa("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new aa("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new aa("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m811b(Context context, String str) {
        try {
            Class cls = (Class) f472a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f472a.put(str, cls);
            }
            return C0051y.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public Object m812A() {
        return this.ac;
    }

    public Object m813B() {
        return this.ad == f473j ? m812A() : this.ad;
    }

    public boolean m814C() {
        return this.af == null ? true : this.af.booleanValue();
    }

    public boolean m815D() {
        return this.ae == null ? true : this.ae.booleanValue();
    }

    void m816E() {
        this.f477D = new am();
        this.f477D.m1086a(this.f476C, new C0092z(this), this);
    }

    void m817F() {
        if (this.f477D != null) {
            this.f477D.m1118i();
            this.f477D.m1112e();
        }
        this.f500k = 4;
        this.f488O = false;
        mo152d();
        if (this.f488O) {
            if (this.f477D != null) {
                this.f477D.m1121l();
            }
            if (this.f495V != null) {
                this.f495V.m1204g();
                return;
            }
            return;
        }
        throw new bs("Fragment " + this + " did not call through to super.onStart()");
    }

    void m818G() {
        if (this.f477D != null) {
            this.f477D.m1118i();
            this.f477D.m1112e();
        }
        this.f500k = 5;
        this.f488O = false;
        m881r();
        if (!this.f488O) {
            throw new bs("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f477D != null) {
            this.f477D.m1122m();
            this.f477D.m1112e();
        }
    }

    void m819H() {
        onLowMemory();
        if (this.f477D != null) {
            this.f477D.m1128s();
        }
    }

    void m820I() {
        if (this.f477D != null) {
            this.f477D.m1123n();
        }
        this.f500k = 4;
        this.f488O = false;
        m882s();
        if (!this.f488O) {
            throw new bs("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m821J() {
        if (this.f477D != null) {
            this.f477D.m1124o();
        }
        this.f500k = 3;
        this.f488O = false;
        mo154e();
        if (!this.f488O) {
            throw new bs("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m822K() {
        if (this.f477D != null) {
            this.f477D.m1125p();
        }
        this.f500k = 2;
        if (this.f496W) {
            this.f496W = false;
            if (!this.f497X) {
                this.f497X = true;
                this.f495V = this.f476C.m984a(this.f506q, this.f496W, false);
            }
            if (this.f495V == null) {
                return;
            }
            if (this.f476C.m1003j()) {
                this.f495V.m1201d();
            } else {
                this.f495V.m1200c();
            }
        }
    }

    void m823L() {
        if (this.f477D != null) {
            this.f477D.m1126q();
        }
        this.f500k = 1;
        this.f488O = false;
        mo156f();
        if (!this.f488O) {
            throw new bs("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f495V != null) {
            this.f495V.m1203f();
        }
    }

    void m824M() {
        if (this.f477D != null) {
            this.f477D.m1127r();
        }
        this.f500k = 0;
        this.f488O = false;
        m883t();
        if (!this.f488O) {
            throw new bs("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    C0051y m825a(String str) {
        return str.equals(this.f506q) ? this : this.f477D != null ? this.f477D.m1096b(str) : null;
    }

    public View mo832a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation m827a(int i, boolean z, int i2) {
        return null;
    }

    public final String m828a(int i) {
        return m875l().getString(i);
    }

    public void m829a(int i, int i2, Intent intent) {
    }

    final void m830a(int i, C0051y c0051y) {
        this.f505p = i;
        if (c0051y != null) {
            this.f506q = c0051y.f506q + ":" + this.f505p;
        } else {
            this.f506q = "android:fragment:" + this.f505p;
        }
    }

    public void m831a(int i, String[] strArr, int[] iArr) {
    }

    @Deprecated
    public void mo148a(Activity activity) {
        this.f488O = true;
    }

    @Deprecated
    public void m833a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f488O = true;
    }

    public void m834a(Context context) {
        this.f488O = true;
        Activity f = this.f476C == null ? null : this.f476C.m999f();
        if (f != null) {
            this.f488O = false;
            mo148a(f);
        }
    }

    public void m835a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f488O = true;
        Activity f = this.f476C == null ? null : this.f476C.m999f();
        if (f != null) {
            this.f488O = false;
            m833a(f, attributeSet, bundle);
        }
    }

    public void m836a(Intent intent) {
        m837a(intent, null);
    }

    public void m837a(Intent intent, Bundle bundle) {
        if (this.f476C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f476C.mo169a(this, intent, -1, bundle);
    }

    void m838a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f477D != null) {
            this.f477D.m1083a(configuration);
        }
    }

    public void m839a(ab abVar) {
        if (this.f505p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (abVar == null || abVar.f590a == null) ? null : abVar.f590a;
        this.f503n = bundle;
    }

    public void m840a(Menu menu) {
    }

    public void m841a(Menu menu, MenuInflater menuInflater) {
    }

    public void m842a(View view, Bundle bundle) {
    }

    public void m843a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f479F));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f480G));
        printWriter.print(" mTag=");
        printWriter.println(this.f481H);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f500k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f505p);
        printWriter.print(" mWho=");
        printWriter.print(this.f506q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f474A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f511v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f512w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f513x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f514y);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f482I);
        printWriter.print(" mDetached=");
        printWriter.print(this.f483J);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f487N);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f486M);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f484K);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f485L);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f494U);
        if (this.f475B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f475B);
        }
        if (this.f476C != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f476C);
        }
        if (this.f478E != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f478E);
        }
        if (this.f507r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f507r);
        }
        if (this.f503n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f503n);
        }
        if (this.f504o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f504o);
        }
        if (this.f508s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f508s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f510u);
        }
        if (this.f489P != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f489P);
        }
        if (this.f490Q != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f490Q);
        }
        if (this.f491R != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f491R);
        }
        if (this.f492S != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f491R);
        }
        if (this.f501l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f501l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f502m);
        }
        if (this.f495V != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f495V.m1197a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f477D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f477D + ":");
            this.f477D.mo183a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public boolean m844a(MenuItem menuItem) {
        return false;
    }

    View m845b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f477D != null) {
            this.f477D.m1118i();
        }
        return mo832a(layoutInflater, viewGroup, bundle);
    }

    public void mo149b(Bundle bundle) {
        this.f488O = true;
    }

    public void m847b(Menu menu) {
    }

    public void m848b(boolean z) {
    }

    boolean m849b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f482I) {
            return false;
        }
        if (this.f486M && this.f487N) {
            z = true;
            m841a(menu, menuInflater);
        }
        return this.f477D != null ? z | this.f477D.m1094a(menu, menuInflater) : z;
    }

    public boolean m850b(MenuItem menuItem) {
        return false;
    }

    public LayoutInflater mo150c(Bundle bundle) {
        LayoutInflater b = this.f476C.mo172b();
        m877n();
        ab.m1847a(b, this.f477D.m1129t());
        return b;
    }

    public void mo151c() {
        this.f488O = true;
    }

    public void m853c(boolean z) {
        if (this.f487N != z) {
            this.f487N = z;
            if (this.f486M && m878o() && !m879p()) {
                this.f476C.mo174c();
            }
        }
    }

    boolean m854c(Menu menu) {
        boolean z = false;
        if (this.f482I) {
            return false;
        }
        if (this.f486M && this.f487N) {
            z = true;
            m840a(menu);
        }
        return this.f477D != null ? z | this.f477D.m1093a(menu) : z;
    }

    boolean m855c(MenuItem menuItem) {
        if (!this.f482I) {
            if (this.f486M && this.f487N && m844a(menuItem)) {
                return true;
            }
            if (this.f477D != null && this.f477D.m1095a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void mo152d() {
        this.f488O = true;
        if (!this.f496W) {
            this.f496W = true;
            if (!this.f497X) {
                this.f497X = true;
                this.f495V = this.f476C.m984a(this.f506q, this.f496W, false);
            }
            if (this.f495V != null) {
                this.f495V.m1199b();
            }
        }
    }

    public void mo153d(Bundle bundle) {
        this.f488O = true;
    }

    void m858d(Menu menu) {
        if (!this.f482I) {
            if (this.f486M && this.f487N) {
                m847b(menu);
            }
            if (this.f477D != null) {
                this.f477D.m1101b(menu);
            }
        }
    }

    public void m859d(boolean z) {
        if (!this.f494U && z && this.f500k < 4) {
            this.f475B.m1099b(this);
        }
        this.f494U = z;
        this.f493T = !z;
    }

    boolean m860d(MenuItem menuItem) {
        if (!this.f482I) {
            if (m850b(menuItem)) {
                return true;
            }
            if (this.f477D != null && this.f477D.m1103b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void mo154e() {
        this.f488O = true;
    }

    public void mo155e(Bundle bundle) {
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void mo156f() {
        this.f488O = true;
    }

    final void m864f(Bundle bundle) {
        if (this.f504o != null) {
            this.f492S.restoreHierarchyState(this.f504o);
            this.f504o = null;
        }
        this.f488O = false;
        m868h(bundle);
        if (!this.f488O) {
            throw new bs("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void m865g(Bundle bundle) {
        if (this.f505p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f507r = bundle;
    }

    final boolean m866g() {
        return this.f474A > 0;
    }

    public final String m867h() {
        return this.f481H;
    }

    public void m868h(Bundle bundle) {
        this.f488O = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final Bundle m869i() {
        return this.f507r;
    }

    void m870i(Bundle bundle) {
        if (this.f477D != null) {
            this.f477D.m1118i();
        }
        this.f500k = 1;
        this.f488O = false;
        mo149b(bundle);
        if (!this.f488O) {
            throw new bs("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f477D == null) {
                    m816E();
                }
                this.f477D.m1085a(parcelable, null);
                this.f477D.m1119j();
            }
        }
    }

    public Context m871j() {
        return this.f476C == null ? null : this.f476C.m1000g();
    }

    void m872j(Bundle bundle) {
        if (this.f477D != null) {
            this.f477D.m1118i();
        }
        this.f500k = 2;
        this.f488O = false;
        mo153d(bundle);
        if (!this.f488O) {
            throw new bs("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f477D != null) {
            this.f477D.m1120k();
        }
    }

    public final ad m873k() {
        return this.f476C == null ? null : (ad) this.f476C.m999f();
    }

    void m874k(Bundle bundle) {
        mo155e(bundle);
        if (this.f477D != null) {
            Parcelable h = this.f477D.m1117h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    public final Resources m875l() {
        if (this.f476C != null) {
            return this.f476C.m1000g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final ak m876m() {
        return this.f475B;
    }

    public final ak m877n() {
        if (this.f477D == null) {
            m816E();
            if (this.f500k >= 5) {
                this.f477D.m1122m();
            } else if (this.f500k >= 4) {
                this.f477D.m1121l();
            } else if (this.f500k >= 2) {
                this.f477D.m1120k();
            } else if (this.f500k >= 1) {
                this.f477D.m1119j();
            }
        }
        return this.f477D;
    }

    public final boolean m878o() {
        return this.f476C != null && this.f511v;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f488O = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m873k().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.f488O = true;
    }

    public final boolean m879p() {
        return this.f482I;
    }

    public View m880q() {
        return this.f491R;
    }

    public void m881r() {
        this.f488O = true;
    }

    public void m882s() {
        this.f488O = true;
    }

    public void m883t() {
        this.f488O = true;
        if (!this.f497X) {
            this.f497X = true;
            this.f495V = this.f476C.m984a(this.f506q, this.f496W, false);
        }
        if (this.f495V != null) {
            this.f495V.m1205h();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0170d.m1540a(this, stringBuilder);
        if (this.f505p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f505p);
        }
        if (this.f479F != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f479F));
        }
        if (this.f481H != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f481H);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    void m884u() {
        this.f505p = -1;
        this.f506q = null;
        this.f511v = false;
        this.f512w = false;
        this.f513x = false;
        this.f514y = false;
        this.f515z = false;
        this.f474A = 0;
        this.f475B = null;
        this.f477D = null;
        this.f476C = null;
        this.f479F = 0;
        this.f480G = 0;
        this.f481H = null;
        this.f482I = false;
        this.f483J = false;
        this.f485L = false;
        this.f495V = null;
        this.f496W = false;
        this.f497X = false;
    }

    public void m885v() {
    }

    public Object m886w() {
        return this.f498Y;
    }

    public Object m887x() {
        return this.f499Z == f473j ? m886w() : this.f499Z;
    }

    public Object m888y() {
        return this.aa;
    }

    public Object m889z() {
        return this.ab == f473j ? m888y() : this.ab;
    }
}
