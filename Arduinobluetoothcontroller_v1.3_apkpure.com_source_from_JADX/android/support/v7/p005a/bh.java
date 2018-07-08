package android.support.v7.p005a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.bv;
import android.support.v4.view.dy;
import android.support.v4.view.ep;
import android.support.v4.view.er;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0303g;
import android.support.v7.p018b.C0308l;
import android.support.v7.view.C0274c;
import android.support.v7.view.C0277b;
import android.support.v7.view.C0313a;
import android.support.v7.view.C0322l;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.C0276i;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bw;
import android.support.v7.widget.fd;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public class bh extends C0266a implements C0276i {
    static final /* synthetic */ boolean f1279h = (!bh.class.desiredAssertionStatus());
    private static final Interpolator f1280i = new AccelerateInterpolator();
    private static final Interpolator f1281j = new DecelerateInterpolator();
    private static final boolean f1282k;
    private boolean f1283A;
    private int f1284B = 0;
    private boolean f1285C = true;
    private boolean f1286D;
    private boolean f1287E;
    private boolean f1288F;
    private boolean f1289G = true;
    private C0322l f1290H;
    private boolean f1291I;
    bl f1292a;
    C0277b f1293b;
    C0274c f1294c;
    boolean f1295d;
    final ep f1296e = new bi(this);
    final ep f1297f = new bj(this);
    final er f1298g = new bk(this);
    private Context f1299l;
    private Context f1300m;
    private Activity f1301n;
    private Dialog f1302o;
    private ActionBarOverlayLayout f1303p;
    private ActionBarContainer f1304q;
    private bw f1305r;
    private ActionBarContextView f1306s;
    private View f1307t;
    private fd f1308u;
    private ArrayList f1309v = new ArrayList();
    private int f1310w = -1;
    private boolean f1311x;
    private boolean f1312y;
    private ArrayList f1313z = new ArrayList();

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f1282k = z;
    }

    public bh(Activity activity, boolean z) {
        this.f1301n = activity;
        View decorView = activity.getWindow().getDecorView();
        m3070a(decorView);
        if (!z) {
            this.f1307t = decorView.findViewById(16908290);
        }
    }

    public bh(Dialog dialog) {
        this.f1302o = dialog;
        m3070a(dialog.getWindow().getDecorView());
    }

    private void m3070a(View view) {
        this.f1303p = (ActionBarOverlayLayout) view.findViewById(C0303g.decor_content_parent);
        if (this.f1303p != null) {
            this.f1303p.setActionBarVisibilityCallback(this);
        }
        this.f1305r = m3073b(view.findViewById(C0303g.action_bar));
        this.f1306s = (ActionBarContextView) view.findViewById(C0303g.action_context_bar);
        this.f1304q = (ActionBarContainer) view.findViewById(C0303g.action_bar_container);
        if (this.f1305r == null || this.f1306s == null || this.f1304q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1299l = this.f1305r.mo785b();
        boolean z = (this.f1305r.mo803o() & 4) != 0;
        if (z) {
            this.f1311x = true;
        }
        C0313a a = C0313a.m3230a(this.f1299l);
        z = a.m3236f() || z;
        mo532b(z);
        m3083k(a.m3234d());
        TypedArray obtainStyledAttributes = this.f1299l.obtainStyledAttributes(null, C0308l.ActionBar, C0298b.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0308l.ActionBar_hideOnContentScroll, false)) {
            mo546c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0308l.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo525a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private bw m3073b(View view) {
        if (view instanceof bw) {
            return (bw) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private static boolean m3075b(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private void m3083k(boolean z) {
        boolean z2 = true;
        this.f1283A = z;
        if (this.f1283A) {
            this.f1304q.setTabContainer(null);
            this.f1305r.mo780a(this.f1308u);
        } else {
            this.f1305r.mo780a(null);
            this.f1304q.setTabContainer(this.f1308u);
        }
        boolean z3 = m3111j() == 2;
        if (this.f1308u != null) {
            if (z3) {
                this.f1308u.setVisibility(0);
                if (this.f1303p != null) {
                    bv.m2042s(this.f1303p);
                }
            } else {
                this.f1308u.setVisibility(8);
            }
        }
        bw bwVar = this.f1305r;
        boolean z4 = !this.f1283A && z3;
        bwVar.mo784a(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1303p;
        if (this.f1283A || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void m3084l(boolean z) {
        if (bh.m3075b(this.f1286D, this.f1287E, this.f1288F)) {
            if (!this.f1289G) {
                this.f1289G = true;
                m3108h(z);
            }
        } else if (this.f1289G) {
            this.f1289G = false;
            m3110i(z);
        }
    }

    private void m3085p() {
        if (!this.f1288F) {
            this.f1288F = true;
            if (this.f1303p != null) {
                this.f1303p.setShowingForActionMode(true);
            }
            m3084l(false);
        }
    }

    private void m3086q() {
        if (this.f1288F) {
            this.f1288F = false;
            if (this.f1303p != null) {
                this.f1303p.setShowingForActionMode(false);
            }
            m3084l(false);
        }
    }

    public int mo524a() {
        return this.f1305r.mo803o();
    }

    public C0277b mo544a(C0274c c0274c) {
        if (this.f1292a != null) {
            this.f1292a.mo562c();
        }
        this.f1303p.setHideOnContentScrollEnabled(false);
        this.f1306s.m3533c();
        C0277b blVar = new bl(this, this.f1306s.getContext(), c0274c);
        if (!blVar.m3150e()) {
            return null;
        }
        blVar.mo563d();
        this.f1306s.m3530a(blVar);
        m3112j(true);
        this.f1306s.sendAccessibilityEvent(32);
        this.f1292a = blVar;
        return blVar;
    }

    public void mo525a(float f) {
        bv.m2024d(this.f1304q, f);
    }

    public void mo526a(int i) {
        this.f1305r.mo792d(i);
    }

    public void m3091a(int i, int i2) {
        int o = this.f1305r.mo803o();
        if ((i2 & 4) != 0) {
            this.f1311x = true;
        }
        this.f1305r.mo789c((o & (i2 ^ -1)) | (i & i2));
    }

    public void mo527a(Configuration configuration) {
        m3083k(C0313a.m3230a(this.f1299l).m3234d());
    }

    public void mo528a(CharSequence charSequence) {
        this.f1305r.mo787b(charSequence);
    }

    public void mo529a(boolean z) {
        m3091a(z ? 4 : 0, 4);
    }

    public void mo545b(int i) {
        this.f1284B = i;
    }

    public void mo531b(CharSequence charSequence) {
        this.f1305r.mo783a(charSequence);
    }

    public void mo532b(boolean z) {
        this.f1305r.mo788b(z);
    }

    public boolean mo533b() {
        int k = m3113k();
        return this.f1289G && (k == 0 || mo547d() < k);
    }

    public Context mo534c() {
        if (this.f1300m == null) {
            TypedValue typedValue = new TypedValue();
            this.f1299l.getTheme().resolveAttribute(C0298b.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1300m = new ContextThemeWrapper(this.f1299l, i);
            } else {
                this.f1300m = this.f1299l;
            }
        }
        return this.f1300m;
    }

    public void mo546c(boolean z) {
        if (!z || this.f1303p.m3561a()) {
            this.f1295d = z;
            this.f1303p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public int mo547d() {
        return this.f1303p.getActionBarHideOffset();
    }

    public void mo535d(boolean z) {
        if (!this.f1311x) {
            mo529a(z);
        }
    }

    public void mo536e(boolean z) {
        this.f1291I = z;
        if (!z && this.f1290H != null) {
            this.f1290H.m3294b();
        }
    }

    public void mo538f(boolean z) {
        if (z != this.f1312y) {
            this.f1312y = z;
            int size = this.f1313z.size();
            for (int i = 0; i < size; i++) {
                ((C0278c) this.f1313z.get(i)).m3155a(z);
            }
        }
    }

    public boolean mo539f() {
        if (this.f1305r == null || !this.f1305r.mo790c()) {
            return false;
        }
        this.f1305r.mo791d();
        return true;
    }

    public void mo548g(boolean z) {
        this.f1285C = z;
    }

    public boolean mo540g() {
        ViewGroup a = this.f1305r.mo776a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void m3108h(boolean z) {
        if (this.f1290H != null) {
            this.f1290H.m3294b();
        }
        this.f1304q.setVisibility(0);
        if (this.f1284B == 0 && f1282k && (this.f1291I || z)) {
            bv.m2015b(this.f1304q, 0.0f);
            float f = (float) (-this.f1304q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1304q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            bv.m2015b(this.f1304q, f);
            C0322l c0322l = new C0322l();
            dy c = bv.m2040q(this.f1304q).m2392c(0.0f);
            c.m2387a(this.f1298g);
            c0322l.m3289a(c);
            if (this.f1285C && this.f1307t != null) {
                bv.m2015b(this.f1307t, f);
                c0322l.m3289a(bv.m2040q(this.f1307t).m2392c(0.0f));
            }
            c0322l.m3292a(f1281j);
            c0322l.m3288a(250);
            c0322l.m3291a(this.f1297f);
            this.f1290H = c0322l;
            c0322l.m3293a();
        } else {
            bv.m2019c(this.f1304q, 1.0f);
            bv.m2015b(this.f1304q, 0.0f);
            if (this.f1285C && this.f1307t != null) {
                bv.m2015b(this.f1307t, 0.0f);
            }
            this.f1297f.mo113b(null);
        }
        if (this.f1303p != null) {
            bv.m2042s(this.f1303p);
        }
    }

    void m3109i() {
        if (this.f1294c != null) {
            this.f1294c.mo520a(this.f1293b);
            this.f1293b = null;
            this.f1294c = null;
        }
    }

    public void m3110i(boolean z) {
        if (this.f1290H != null) {
            this.f1290H.m3294b();
        }
        if (this.f1284B == 0 && f1282k && (this.f1291I || z)) {
            bv.m2019c(this.f1304q, 1.0f);
            this.f1304q.setTransitioning(true);
            C0322l c0322l = new C0322l();
            float f = (float) (-this.f1304q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1304q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            dy c = bv.m2040q(this.f1304q).m2392c(f);
            c.m2387a(this.f1298g);
            c0322l.m3289a(c);
            if (this.f1285C && this.f1307t != null) {
                c0322l.m3289a(bv.m2040q(this.f1307t).m2392c(f));
            }
            c0322l.m3292a(f1280i);
            c0322l.m3288a(250);
            c0322l.m3291a(this.f1296e);
            this.f1290H = c0322l;
            c0322l.m3293a();
            return;
        }
        this.f1296e.mo113b(null);
    }

    public int m3111j() {
        return this.f1305r.mo804p();
    }

    public void m3112j(boolean z) {
        dy a;
        dy a2;
        if (z) {
            m3085p();
        } else {
            m3086q();
        }
        if (z) {
            a = this.f1305r.mo775a(4, 100);
            a2 = this.f1306s.mo629a(0, 200);
        } else {
            a2 = this.f1305r.mo775a(0, 200);
            a = this.f1306s.mo629a(8, 100);
        }
        C0322l c0322l = new C0322l();
        c0322l.m3290a(a, a2);
        c0322l.m3293a();
    }

    public int m3113k() {
        return this.f1304q.getHeight();
    }

    public void mo549l() {
        if (this.f1287E) {
            this.f1287E = false;
            m3084l(true);
        }
    }

    public void mo550m() {
        if (!this.f1287E) {
            this.f1287E = true;
            m3084l(true);
        }
    }

    public void mo551n() {
        if (this.f1290H != null) {
            this.f1290H.m3294b();
            this.f1290H = null;
        }
    }

    public void mo552o() {
    }
}
