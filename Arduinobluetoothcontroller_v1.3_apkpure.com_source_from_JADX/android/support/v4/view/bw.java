package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import java.util.WeakHashMap;

class bw implements ci {
    WeakHashMap f983a = null;

    bw() {
    }

    private boolean m2106a(bo boVar, int i) {
        int computeHorizontalScrollOffset = boVar.computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = boVar.computeHorizontalScrollRange() - boVar.computeHorizontalScrollExtent();
        return computeHorizontalScrollRange == 0 ? false : i < 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange + -1;
    }

    private boolean m2107b(bo boVar, int i) {
        int computeVerticalScrollOffset = boVar.computeVerticalScrollOffset();
        int computeVerticalScrollRange = boVar.computeVerticalScrollRange() - boVar.computeVerticalScrollExtent();
        return computeVerticalScrollRange == 0 ? false : i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange + -1;
    }

    public Mode mo325A(View view) {
        return cj.m2248b(view);
    }

    public void mo326B(View view) {
        if (view instanceof bi) {
            ((bi) view).stopNestedScroll();
        }
    }

    public boolean mo327C(View view) {
        return cj.m2250c(view);
    }

    public float mo328D(View view) {
        return mo390v(view) + mo389u(view);
    }

    public boolean mo329E(View view) {
        return cj.m2253f(view);
    }

    public boolean mo330F(View view) {
        return false;
    }

    public int mo331a(int i, int i2) {
        return i | i2;
    }

    public int mo332a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    public int mo333a(View view) {
        return 2;
    }

    long mo381a() {
        return 10;
    }

    public es mo334a(View view, es esVar) {
        return esVar;
    }

    public void mo335a(View view, float f) {
    }

    public void mo336a(View view, int i, int i2) {
    }

    public void mo337a(View view, int i, int i2, int i3, int i4) {
        view.setPadding(i, i2, i3, i4);
    }

    public void mo338a(View view, int i, Paint paint) {
    }

    public void mo339a(View view, ColorStateList colorStateList) {
        cj.m2246a(view, colorStateList);
    }

    public void mo340a(View view, Mode mode) {
        cj.m2247a(view, mode);
    }

    public void mo341a(View view, C0209a c0209a) {
    }

    public void mo342a(View view, bm bmVar) {
    }

    public void mo343a(View view, Runnable runnable) {
        view.postDelayed(runnable, mo381a());
    }

    public void mo344a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, mo381a() + j);
    }

    public void mo345a(View view, boolean z) {
    }

    public boolean mo346a(View view, int i) {
        return (view instanceof bo) && m2106a((bo) view, i);
    }

    public es mo347b(View view, es esVar) {
        return esVar;
    }

    public void mo348b(View view, float f) {
    }

    public void mo349b(View view, boolean z) {
    }

    public boolean mo350b(View view) {
        return false;
    }

    public boolean mo351b(View view, int i) {
        return (view instanceof bo) && m2107b((bo) view, i);
    }

    public void mo352c(View view, float f) {
    }

    public void mo353c(View view, int i) {
    }

    public void mo354c(View view, boolean z) {
    }

    public boolean mo355c(View view) {
        return false;
    }

    public void mo356d(View view) {
        view.invalidate();
    }

    public void mo357d(View view, float f) {
    }

    public void mo358d(View view, int i) {
    }

    public int mo359e(View view) {
        return 0;
    }

    public void mo360e(View view, int i) {
        cj.m2249b(view, i);
    }

    public float mo361f(View view) {
        return 1.0f;
    }

    public void mo362f(View view, int i) {
        cj.m2245a(view, i);
    }

    public int mo363g(View view) {
        return 0;
    }

    public int mo364h(View view) {
        return 0;
    }

    public int mo365i(View view) {
        return view.getMeasuredWidth();
    }

    public int mo366j(View view) {
        return 0;
    }

    public int mo367k(View view) {
        return view.getPaddingLeft();
    }

    public int mo368l(View view) {
        return view.getPaddingRight();
    }

    public boolean mo369m(View view) {
        return true;
    }

    public float mo370n(View view) {
        return 0.0f;
    }

    public float mo371o(View view) {
        return 0.0f;
    }

    public int mo372p(View view) {
        return cj.m2251d(view);
    }

    public int mo373q(View view) {
        return cj.m2252e(view);
    }

    public dy mo374r(View view) {
        return new dy(view);
    }

    public int mo375s(View view) {
        return 0;
    }

    public void mo376t(View view) {
    }

    public float mo389u(View view) {
        return 0.0f;
    }

    public float mo390v(View view) {
        return 0.0f;
    }

    public boolean mo377w(View view) {
        return false;
    }

    public void mo378x(View view) {
    }

    public boolean mo379y(View view) {
        return false;
    }

    public ColorStateList mo380z(View view) {
        return cj.m2244a(view);
    }
}
