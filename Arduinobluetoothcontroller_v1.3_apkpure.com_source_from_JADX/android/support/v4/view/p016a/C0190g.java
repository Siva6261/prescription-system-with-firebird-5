package android.support.v4.view.p016a;

import android.graphics.Rect;
import android.os.Build.VERSION;

public class C0190g {
    private static final C0191k f952a;
    private final Object f953b;

    static {
        if (VERSION.SDK_INT >= 22) {
            f952a = new C0199i();
        } else if (VERSION.SDK_INT >= 21) {
            f952a = new C0198h();
        } else if (VERSION.SDK_INT >= 19) {
            f952a = new C0197o();
        } else if (VERSION.SDK_INT >= 18) {
            f952a = new C0196n();
        } else if (VERSION.SDK_INT >= 17) {
            f952a = new C0195m();
        } else if (VERSION.SDK_INT >= 16) {
            f952a = new C0194l();
        } else if (VERSION.SDK_INT >= 14) {
            f952a = new C0193j();
        } else {
            f952a = new C0192p();
        }
    }

    public C0190g(Object obj) {
        this.f953b = obj;
    }

    private static String m1691b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public Object m1693a() {
        return this.f953b;
    }

    public void m1694a(int i) {
        f952a.mo269a(this.f953b, i);
    }

    public void m1695a(Rect rect) {
        f952a.mo270a(this.f953b, rect);
    }

    public void m1696a(CharSequence charSequence) {
        f952a.mo271a(this.f953b, charSequence);
    }

    public void m1697a(Object obj) {
        f952a.mo272a(this.f953b, ((C0200q) obj).f954a);
    }

    public void m1698a(boolean z) {
        f952a.mo273a(this.f953b, z);
    }

    public int m1699b() {
        return f952a.mo266a(this.f953b);
    }

    public void m1700b(Rect rect) {
        f952a.mo275b(this.f953b, rect);
    }

    public void m1701b(Object obj) {
        f952a.mo276b(this.f953b, ((C0201r) obj).f955a);
    }

    public boolean m1702c() {
        return f952a.mo280f(this.f953b);
    }

    public boolean m1703d() {
        return f952a.mo281g(this.f953b);
    }

    public boolean m1704e() {
        return f952a.mo284j(this.f953b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0190g c0190g = (C0190g) obj;
        return this.f953b == null ? c0190g.f953b == null : this.f953b.equals(c0190g.f953b);
    }

    public boolean m1705f() {
        return f952a.mo285k(this.f953b);
    }

    public boolean m1706g() {
        return f952a.mo289o(this.f953b);
    }

    public boolean m1707h() {
        return f952a.mo282h(this.f953b);
    }

    public int hashCode() {
        return this.f953b == null ? 0 : this.f953b.hashCode();
    }

    public boolean m1708i() {
        return f952a.mo286l(this.f953b);
    }

    public boolean m1709j() {
        return f952a.mo283i(this.f953b);
    }

    public boolean m1710k() {
        return f952a.mo287m(this.f953b);
    }

    public boolean m1711l() {
        return f952a.mo288n(this.f953b);
    }

    public CharSequence m1712m() {
        return f952a.mo278d(this.f953b);
    }

    public CharSequence m1713n() {
        return f952a.mo274b(this.f953b);
    }

    public CharSequence m1714o() {
        return f952a.mo279e(this.f953b);
    }

    public CharSequence m1715p() {
        return f952a.mo277c(this.f953b);
    }

    public String m1716q() {
        return f952a.mo290p(this.f953b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        m1695a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        m1700b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m1712m());
        stringBuilder.append("; className: ").append(m1713n());
        stringBuilder.append("; text: ").append(m1714o());
        stringBuilder.append("; contentDescription: ").append(m1715p());
        stringBuilder.append("; viewId: ").append(m1716q());
        stringBuilder.append("; checkable: ").append(m1702c());
        stringBuilder.append("; checked: ").append(m1703d());
        stringBuilder.append("; focusable: ").append(m1704e());
        stringBuilder.append("; focused: ").append(m1705f());
        stringBuilder.append("; selected: ").append(m1706g());
        stringBuilder.append("; clickable: ").append(m1707h());
        stringBuilder.append("; longClickable: ").append(m1708i());
        stringBuilder.append("; enabled: ").append(m1709j());
        stringBuilder.append("; password: ").append(m1710k());
        stringBuilder.append("; scrollable: " + m1711l());
        stringBuilder.append("; [");
        int b = m1699b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0190g.m1691b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
