package android.support.v7.p005a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p006b.bl;
import android.support.v4.view.ab;
import android.support.v4.view.al;
import android.support.v4.view.cu;
import android.support.v4.view.dy;
import android.support.v4.widget.ah;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0300d;
import android.support.v7.p018b.C0303g;
import android.support.v7.p018b.C0305i;
import android.support.v7.p018b.C0308l;
import android.support.v7.view.C0274c;
import android.support.v7.view.C0277b;
import android.support.v7.view.C0315e;
import android.support.v7.view.C0316f;
import android.support.v7.view.menu.C0269j;
import android.support.v7.view.menu.C0329i;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.bv;
import android.support.v7.widget.ck;
import android.support.v7.widget.gv;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class ae extends C0268x implements al, C0269j {
    private boolean f1167A;
    private aq[] f1168B;
    private aq f1169C;
    private boolean f1170D;
    private boolean f1171E;
    private int f1172F;
    private final Runnable f1173G = new af(this);
    private boolean f1174H;
    private Rect f1175I;
    private Rect f1176J;
    private au f1177K;
    C0277b f1178m;
    ActionBarContextView f1179n;
    PopupWindow f1180o;
    Runnable f1181p;
    dy f1182q = null;
    private bv f1183r;
    private am f1184s;
    private ar f1185t;
    private boolean f1186u;
    private ViewGroup f1187v;
    private TextView f1188w;
    private View f1189x;
    private boolean f1190y;
    private boolean f1191z;

    ae(Context context, Window window, C0047v c0047v) {
        super(context, window, c0047v);
    }

    private aq m2899a(int i, boolean z) {
        Object obj = this.f1168B;
        if (obj == null || obj.length <= i) {
            Object obj2 = new aq[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f1168B = obj2;
            obj = obj2;
        }
        aq aqVar = obj[i];
        if (aqVar != null) {
            return aqVar;
        }
        aqVar = new aq(i);
        obj[i] = aqVar;
        return aqVar;
    }

    private aq m2901a(Menu menu) {
        aq[] aqVarArr = this.f1168B;
        int length = aqVarArr != null ? aqVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            aq aqVar = aqVarArr[i];
            if (aqVar != null && aqVar.f1229j == menu) {
                return aqVar;
            }
        }
        return null;
    }

    private void m2902a(int i, aq aqVar, Menu menu) {
        if (menu == null) {
            if (aqVar == null && i >= 0 && i < this.f1168B.length) {
                aqVar = this.f1168B[i];
            }
            if (aqVar != null) {
                menu = aqVar.f1229j;
            }
        }
        if ((aqVar == null || aqVar.f1234o) && !m2893n()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2907a(android.support.v7.p005a.aq r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f1234o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m2893n();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f1220a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m2894o();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f1220a;
        r5 = r11.f1229j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m2908a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m2918b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f1226g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f1236q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f1226g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m2911a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f1226g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m2921c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m3010a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f1227h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f1221b;
        r4 = r11.f1226g;
        r4.setBackgroundResource(r0);
        r0 = r11.f1227h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f1227h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f1226g;
        r4 = r11.f1227h;
        r0.addView(r4, r1);
        r0 = r11.f1227h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f1227h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f1233n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f1223d;
        r4 = r11.f1224e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f1222c;
        r0.gravity = r1;
        r1 = r11.f1225f;
        r0.windowAnimations = r1;
        r1 = r11.f1226g;
        r8.addView(r1, r0);
        r11.f1234o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f1236q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f1226g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f1226g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f1228i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f1228i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.ae.a(android.support.v7.a.aq, android.view.KeyEvent):void");
    }

    private void m2908a(aq aqVar, boolean z) {
        if (z && aqVar.f1220a == 0 && this.f1183r != null && this.f1183r.mo640e()) {
            m2916b(aqVar.f1229j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !aqVar.f1234o || aqVar.f1226g == null)) {
            windowManager.removeView(aqVar.f1226g);
            if (z) {
                m2902a(aqVar.f1220a, aqVar, null);
            }
        }
        aqVar.f1232m = false;
        aqVar.f1233n = false;
        aqVar.f1234o = false;
        aqVar.f1227h = null;
        aqVar.f1236q = true;
        if (this.f1169C == aqVar) {
            this.f1169C = null;
        }
    }

    private void m2909a(C0329i c0329i, boolean z) {
        if (this.f1183r == null || !this.f1183r.mo639d() || (cu.m2316b(ViewConfiguration.get(this.a)) && !this.f1183r.mo641f())) {
            aq a = m2899a(0, true);
            a.f1236q = true;
            m2908a(a, false);
            m2907a(a, null);
            return;
        }
        Callback o = m2894o();
        if (this.f1183r.mo640e() && z) {
            this.f1183r.mo643h();
            if (!m2893n()) {
                o.onPanelClosed(108, m2899a(0, true).f1229j);
            }
        } else if (o != null && !m2893n()) {
            if (this.f1171E && (this.f1172F & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.f1173G);
                this.f1173G.run();
            }
            aq a2 = m2899a(0, true);
            if (a2.f1229j != null && !a2.f1237r && o.onPreparePanel(0, a2.f1228i, a2.f1229j)) {
                o.onMenuOpened(108, a2.f1229j);
                this.f1183r.mo642g();
            }
        }
    }

    private boolean m2911a(aq aqVar) {
        aqVar.m3008a(m2891l());
        aqVar.f1226g = new ap(this, aqVar.f1231l);
        aqVar.f1222c = 81;
        return true;
    }

    private boolean m2912a(aq aqVar, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((aqVar.f1232m || m2918b(aqVar, keyEvent)) && aqVar.f1229j != null) {
                z = aqVar.f1229j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f1183r == null) {
                m2908a(aqVar, true);
            }
        }
        return z;
    }

    private boolean m2913a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || android.support.v4.view.bv.m1996C((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    private void m2916b(C0329i c0329i) {
        if (!this.f1167A) {
            this.f1167A = true;
            this.f1183r.mo645j();
            Callback o = m2894o();
            if (!(o == null || m2893n())) {
                o.onPanelClosed(108, c0329i);
            }
            this.f1167A = false;
        }
    }

    private boolean m2917b(aq aqVar) {
        Context c0315e;
        C0329i c0329i;
        Context context = this.a;
        if ((aqVar.f1220a == 0 || aqVar.f1220a == 108) && this.f1183r != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0298b.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0298b.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0298b.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0315e = new C0315e(context, 0);
                c0315e.getTheme().setTo(theme3);
                c0329i = new C0329i(c0315e);
                c0329i.mo598a((C0269j) this);
                aqVar.m3009a(c0329i);
                return true;
            }
        }
        c0315e = context;
        c0329i = new C0329i(c0315e);
        c0329i.mo598a((C0269j) this);
        aqVar.m3009a(c0329i);
        return true;
    }

    private boolean m2918b(aq aqVar, KeyEvent keyEvent) {
        if (m2893n()) {
            return false;
        }
        if (aqVar.f1232m) {
            return true;
        }
        if (!(this.f1169C == null || this.f1169C == aqVar)) {
            m2908a(this.f1169C, false);
        }
        Callback o = m2894o();
        if (o != null) {
            aqVar.f1228i = o.onCreatePanelView(aqVar.f1220a);
        }
        boolean z = aqVar.f1220a == 0 || aqVar.f1220a == 108;
        if (z && this.f1183r != null) {
            this.f1183r.mo644i();
        }
        if (aqVar.f1228i == null && !(z && (m2890k() instanceof aw))) {
            if (aqVar.f1229j == null || aqVar.f1237r) {
                if (aqVar.f1229j == null && (!m2917b(aqVar) || aqVar.f1229j == null)) {
                    return false;
                }
                if (z && this.f1183r != null) {
                    if (this.f1184s == null) {
                        this.f1184s = new am();
                    }
                    this.f1183r.mo638a(aqVar.f1229j, this.f1184s);
                }
                aqVar.f1229j.m3373g();
                if (o.onCreatePanelMenu(aqVar.f1220a, aqVar.f1229j)) {
                    aqVar.f1237r = false;
                } else {
                    aqVar.m3009a(null);
                    if (!z || this.f1183r == null) {
                        return false;
                    }
                    this.f1183r.mo638a(null, this.f1184s);
                    return false;
                }
            }
            aqVar.f1229j.m3373g();
            if (aqVar.f1238s != null) {
                aqVar.f1229j.m3360b(aqVar.f1238s);
                aqVar.f1238s = null;
            }
            if (o.onPreparePanel(0, aqVar.f1228i, aqVar.f1229j)) {
                aqVar.f1235p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                aqVar.f1229j.setQwertyMode(aqVar.f1235p);
                aqVar.f1229j.m3374h();
            } else {
                if (z && this.f1183r != null) {
                    this.f1183r.mo638a(null, this.f1184s);
                }
                aqVar.f1229j.m3374h();
                return false;
            }
        }
        aqVar.f1232m = true;
        aqVar.f1233n = false;
        this.f1169C = aqVar;
        return true;
    }

    private boolean m2921c(aq aqVar) {
        if (aqVar.f1228i != null) {
            aqVar.f1227h = aqVar.f1228i;
            return true;
        } else if (aqVar.f1229j == null) {
            return false;
        } else {
            if (this.f1185t == null) {
                this.f1185t = new ar();
            }
            aqVar.f1227h = (View) aqVar.m3007a(this.f1185t);
            return aqVar.f1227h != null;
        }
    }

    private void m2922d(int i) {
        m2908a(m2899a(i, true), true);
    }

    private boolean m2924d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            aq a = m2899a(i, true);
            if (!a.f1234o) {
                return m2918b(a, keyEvent);
            }
        }
        return false;
    }

    private void m2925e(int i) {
        this.f1172F |= 1 << i;
        if (!this.f1171E) {
            android.support.v4.view.bv.m2010a(this.b.getDecorView(), this.f1173G);
            this.f1171E = true;
        }
    }

    private boolean m2926e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f1178m != null) {
            return false;
        }
        aq a = m2899a(i, true);
        if (i != 0 || this.f1183r == null || !this.f1183r.mo639d() || cu.m2316b(ViewConfiguration.get(this.a))) {
            boolean z2;
            if (a.f1234o || a.f1233n) {
                z2 = a.f1234o;
                m2908a(a, true);
                z = z2;
            } else {
                if (a.f1232m) {
                    if (a.f1237r) {
                        a.f1232m = false;
                        z2 = m2918b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m2907a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f1183r.mo640e()) {
            z = this.f1183r.mo643h();
        } else {
            if (!m2893n() && m2918b(a, keyEvent)) {
                z = this.f1183r.mo642g();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private void m2927f(int i) {
        aq a = m2899a(i, true);
        if (a.f1229j != null) {
            Bundle bundle = new Bundle();
            a.f1229j.m3348a(bundle);
            if (bundle.size() > 0) {
                a.f1238s = bundle;
            }
            a.f1229j.m3373g();
            a.f1229j.clear();
        }
        a.f1237r = true;
        a.f1236q = true;
        if ((i == 108 || i == 0) && this.f1183r != null) {
            a = m2899a(0, false);
            if (a != null) {
                a.f1232m = false;
                m2918b(a, null);
            }
        }
    }

    private int m2928g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f1179n == null || !(this.f1179n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1179n.getLayoutParams();
            if (this.f1179n.isShown()) {
                if (this.f1175I == null) {
                    this.f1175I = new Rect();
                    this.f1176J = new Rect();
                }
                Rect rect = this.f1175I;
                Rect rect2 = this.f1176J;
                rect.set(0, i, 0, 0);
                gv.m4890a(this.f1187v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f1189x == null) {
                        this.f1189x = new View(this.a);
                        this.f1189x.setBackgroundColor(this.a.getResources().getColor(C0300d.abc_input_method_navigation_guard));
                        this.f1187v.addView(this.f1189x, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f1189x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1189x.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f1189x == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f1179n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f1189x != null) {
            View view = this.f1189x;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private int m2929h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private void m2930r() {
        if (!this.f1186u) {
            this.f1187v = m2931s();
            CharSequence p = m2895p();
            if (!TextUtils.isEmpty(p)) {
                mo495b(p);
            }
            m2932t();
            m2946a(this.f1187v);
            this.f1186u = true;
            aq a = m2899a(0, false);
            if (!m2893n()) {
                if (a == null || a.f1229j == null) {
                    m2925e(108);
                }
            }
        }
    }

    private ViewGroup m2931s() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0308l.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0308l.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0308l.AppCompatTheme_windowNoTitle, false)) {
                mo498c(1);
            } else if (obtainStyledAttributes.getBoolean(C0308l.AppCompatTheme_windowActionBar, false)) {
                mo498c(108);
            }
            if (obtainStyledAttributes.getBoolean(C0308l.AppCompatTheme_windowActionBarOverlay, false)) {
                mo498c(109);
            }
            if (obtainStyledAttributes.getBoolean(C0308l.AppCompatTheme_windowActionModeOverlay, false)) {
                mo498c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0308l.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2 = this.j ? (ViewGroup) from.inflate(C0305i.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(C0305i.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    android.support.v4.view.bv.m2009a(view2, new ag(this));
                    view = view2;
                } else {
                    ((ck) view2).setOnFitSystemWindowsListener(new ah(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(C0305i.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0298b.actionBarTheme, typedValue, true);
                r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0315e(this.a, typedValue.resourceId) : this.a).inflate(C0305i.abc_screen_toolbar, null);
                this.f1183r = (bv) r0.findViewById(C0303g.decor_content_parent);
                this.f1183r.setWindowCallback(m2894o());
                if (this.i) {
                    this.f1183r.mo637a(109);
                }
                if (this.f1190y) {
                    this.f1183r.mo637a(2);
                }
                if (this.f1191z) {
                    this.f1183r.mo637a(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f1183r == null) {
                this.f1188w = (TextView) view.findViewById(C0303g.title);
            }
            gv.m4892b(view);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0303g.action_bar_activity_content);
            while (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            this.b.setContentView(view);
            viewGroup.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout) viewGroup).setForeground(null);
            }
            contentFrameLayout.setAttachListener(new ai(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void m2932t() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1187v.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m3004a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0308l.AppCompatTheme);
        obtainStyledAttributes.getValue(C0308l.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0308l.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0308l.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0308l.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0308l.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0308l.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0308l.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0308l.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0308l.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0308l.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void m2933u() {
        if (this.f1182q != null) {
            this.f1182q.m2391b();
        }
    }

    private void m2934v() {
        if (this.f1186u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void m2935w() {
        if (this.f1183r != null) {
            this.f1183r.mo645j();
        }
        if (this.f1180o != null) {
            this.b.getDecorView().removeCallbacks(this.f1181p);
            if (this.f1180o.isShowing()) {
                try {
                    this.f1180o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f1180o = null;
        }
        m2933u();
        aq a = m2899a(0, false);
        if (a != null && a.f1229j != null) {
            a.f1229j.close();
        }
    }

    C0277b mo480a(C0274c c0274c) {
        C0277b c0277b;
        m2933u();
        if (this.f1178m != null) {
            this.f1178m.mo562c();
        }
        C0274c anVar = new an(this, c0274c);
        if (this.e == null || m2893n()) {
            c0277b = null;
        } else {
            try {
                c0277b = this.e.mo139a(anVar);
            } catch (AbstractMethodError e) {
                c0277b = null;
            }
        }
        if (c0277b != null) {
            this.f1178m = c0277b;
        } else {
            if (this.f1179n == null) {
                if (this.k) {
                    Context c0315e;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0298b.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0315e = new C0315e(this.a, 0);
                        c0315e.getTheme().setTo(newTheme);
                    } else {
                        c0315e = this.a;
                    }
                    this.f1179n = new ActionBarContextView(c0315e);
                    this.f1180o = new PopupWindow(c0315e, null, C0298b.actionModePopupWindowStyle);
                    ah.m2603a(this.f1180o, 2);
                    this.f1180o.setContentView(this.f1179n);
                    this.f1180o.setWidth(-1);
                    c0315e.getTheme().resolveAttribute(C0298b.actionBarSize, typedValue, true);
                    this.f1179n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0315e.getResources().getDisplayMetrics()));
                    this.f1180o.setHeight(-2);
                    this.f1181p = new aj(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1187v.findViewById(C0303g.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m2891l()));
                        this.f1179n = (ActionBarContextView) viewStubCompat.m4006a();
                    }
                }
            }
            if (this.f1179n != null) {
                m2933u();
                this.f1179n.m3533c();
                C0277b c0316f = new C0316f(this.f1179n.getContext(), this.f1179n, anVar, this.f1180o == null);
                if (c0274c.mo521a(c0316f, c0316f.mo559b())) {
                    c0316f.mo563d();
                    this.f1179n.m3530a(c0316f);
                    this.f1178m = c0316f;
                    android.support.v4.view.bv.m2019c(this.f1179n, 0.0f);
                    this.f1182q = android.support.v4.view.bv.m2040q(this.f1179n).m2384a(1.0f);
                    this.f1182q.m2386a(new al(this));
                    if (this.f1180o != null) {
                        this.b.getDecorView().post(this.f1181p);
                    }
                } else {
                    this.f1178m = null;
                }
            }
        }
        if (!(this.f1178m == null || this.e == null)) {
            this.e.mo140a(this.f1178m);
        }
        return this.f1178m;
    }

    public View mo481a(int i) {
        m2930r();
        return this.b.findViewById(i);
    }

    public final View mo180a(View view, String str, Context context, AttributeSet attributeSet) {
        View b = mo503b(view, str, context, attributeSet);
        return b != null ? b : m2958c(view, str, context, attributeSet);
    }

    void mo482a(int i, Menu menu) {
        if (i == 108) {
            C0266a a = mo474a();
            if (a != null) {
                a.mo538f(false);
            }
        } else if (i == 0) {
            aq a2 = m2899a(i, true);
            if (a2.f1234o) {
                m2908a(a2, false);
            }
        }
    }

    public void mo483a(Configuration configuration) {
        if (this.h && this.f1186u) {
            C0266a a = mo474a();
            if (a != null) {
                a.mo527a(configuration);
            }
        }
    }

    public void mo484a(Bundle bundle) {
        if ((this.c instanceof Activity) && bl.m1217b((Activity) this.c) != null) {
            C0266a k = m2890k();
            if (k == null) {
                this.f1174H = true;
            } else {
                k.mo535d(true);
            }
        }
    }

    public void mo485a(C0329i c0329i) {
        m2909a(c0329i, true);
    }

    public void mo486a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            C0266a a = mo474a();
            if (a instanceof bh) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.g = null;
            if (a != null) {
                a.mo541h();
            }
            if (toolbar != null) {
                C0266a awVar = new aw(toolbar, ((Activity) this.a).getTitle(), this.d);
                this.f = awVar;
                this.b.setCallback(awVar.m3046i());
            } else {
                this.f = null;
                this.b.setCallback(this.d);
            }
            mo500e();
        }
    }

    public void mo487a(View view) {
        m2930r();
        ViewGroup viewGroup = (ViewGroup) this.f1187v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void mo488a(View view, LayoutParams layoutParams) {
        m2930r();
        ViewGroup viewGroup = (ViewGroup) this.f1187v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m2946a(ViewGroup viewGroup) {
    }

    boolean mo489a(int i, KeyEvent keyEvent) {
        C0266a a = mo474a();
        if (a != null && a.mo530a(i, keyEvent)) {
            return true;
        }
        if (this.f1169C == null || !m2912a(this.f1169C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f1169C == null) {
                aq a2 = m2899a(0, true);
                m2918b(a2, keyEvent);
                boolean a3 = m2912a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f1232m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f1169C == null) {
            return true;
        } else {
            this.f1169C.f1233n = true;
            return true;
        }
    }

    public boolean mo490a(C0329i c0329i, MenuItem menuItem) {
        Callback o = m2894o();
        if (!(o == null || m2893n())) {
            aq a = m2901a(c0329i.mo604p());
            if (a != null) {
                return o.onMenuItemSelected(a.f1220a, menuItem);
            }
        }
        return false;
    }

    boolean mo491a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m2961c(keyCode, keyEvent) : m2956b(keyCode, keyEvent);
    }

    public C0277b m2950b(C0274c c0274c) {
        if (c0274c == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f1178m != null) {
            this.f1178m.mo562c();
        }
        C0274c anVar = new an(this, c0274c);
        C0266a a = mo474a();
        if (a != null) {
            this.f1178m = a.mo544a(anVar);
            if (!(this.f1178m == null || this.e == null)) {
                this.e.mo140a(this.f1178m);
            }
        }
        if (this.f1178m == null) {
            this.f1178m = mo480a(anVar);
        }
        return this.f1178m;
    }

    View mo503b(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    public void mo492b(int i) {
        m2930r();
        ViewGroup viewGroup = (ViewGroup) this.f1187v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void mo493b(Bundle bundle) {
        m2930r();
    }

    public void mo494b(View view, LayoutParams layoutParams) {
        m2930r();
        ((ViewGroup) this.f1187v.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void mo495b(CharSequence charSequence) {
        if (this.f1183r != null) {
            this.f1183r.setWindowTitle(charSequence);
        } else if (m2890k() != null) {
            m2890k().mo531b(charSequence);
        } else if (this.f1188w != null) {
            this.f1188w.setText(charSequence);
        }
    }

    boolean m2956b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.f1170D;
                this.f1170D = false;
                aq a = m2899a(0, false);
                if (a == null || !a.f1234o) {
                    if (m2967q()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m2908a(a, true);
                    return true;
                }
                break;
            case 82:
                m2926e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean mo496b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        C0266a a = mo474a();
        if (a == null) {
            return true;
        }
        a.mo538f(true);
        return true;
    }

    public View m2958c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = VERSION.SDK_INT < 21;
        if (this.f1177K == null) {
            this.f1177K = new au();
        }
        boolean z2 = z && m2913a((ViewParent) view);
        return this.f1177K.m3017a(view, str, context, attributeSet, z2, z, true, z);
    }

    public void mo497c() {
        C0266a a = mo474a();
        if (a != null) {
            a.mo536e(false);
        }
    }

    public boolean mo498c(int i) {
        int h = m2929h(i);
        if (this.l && h == 108) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                m2934v();
                this.l = true;
                return true;
            case 2:
                m2934v();
                this.f1190y = true;
                return true;
            case 5:
                m2934v();
                this.f1191z = true;
                return true;
            case 10:
                m2934v();
                this.j = true;
                return true;
            case 108:
                m2934v();
                this.h = true;
                return true;
            case 109:
                m2934v();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    boolean m2961c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f1170D = z;
                break;
            case 82:
                m2924d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            mo489a(i, keyEvent);
        }
        return false;
    }

    public void mo499d() {
        C0266a a = mo474a();
        if (a != null) {
            a.mo536e(true);
        }
    }

    public void mo500e() {
        C0266a a = mo474a();
        if (a == null || !a.mo537e()) {
            m2925e(0);
        }
    }

    public void mo478f() {
        super.mo478f();
        if (this.f != null) {
            this.f.mo541h();
            this.f = null;
        }
    }

    public void mo501g() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            ab.m1847a(from, this);
        } else if (!(ab.m1846a(from) instanceof ae)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void mo502j() {
        m2930r();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new bh((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new bh((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.mo535d(this.f1174H);
            }
        }
    }

    boolean m2967q() {
        if (this.f1178m != null) {
            this.f1178m.mo562c();
            return true;
        }
        C0266a a = mo474a();
        return a != null && a.mo539f();
    }
}
