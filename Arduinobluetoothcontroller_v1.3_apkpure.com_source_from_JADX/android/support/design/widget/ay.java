package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.C0023d;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class ay {
    static final int[] f329h = new int[]{16842919, 16842910};
    static final int[] f330i = new int[]{16842908, 16842910};
    static final int[] f331j = new int[0];
    private final Rect f332a = new Rect();
    Drawable f333b;
    Drawable f334c;
    C0054s f335d;
    Drawable f336e;
    float f337f;
    float f338g;
    final dh f339k;
    final bh f340l;
    private OnPreDrawListener f341m;

    ay(dh dhVar, bh bhVar) {
        this.f339k = dhVar;
        this.f340l = bhVar;
    }

    private void m544l() {
        if (this.f341m == null) {
            this.f341m = new az(this);
        }
    }

    abstract float mo80a();

    C0054s m546a(int i, ColorStateList colorStateList) {
        Resources resources = this.f339k.getResources();
        C0054s j = mo99j();
        j.m910a(resources.getColor(C0023d.design_fab_stroke_top_outer_color), resources.getColor(C0023d.design_fab_stroke_top_inner_color), resources.getColor(C0023d.design_fab_stroke_end_inner_color), resources.getColor(C0023d.design_fab_stroke_end_outer_color));
        j.m909a((float) i);
        j.m911a(colorStateList);
        return j;
    }

    abstract void mo81a(float f);

    abstract void mo82a(int i);

    abstract void mo83a(ColorStateList colorStateList);

    abstract void mo84a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void mo85a(Mode mode);

    abstract void mo86a(Rect rect);

    abstract void mo87a(ba baVar, boolean z);

    abstract void mo88a(int[] iArr);

    abstract void mo89b();

    abstract void mo90b(float f);

    void mo98b(Rect rect) {
    }

    abstract void mo91b(ba baVar, boolean z);

    abstract void mo92c();

    final void m560c(float f) {
        if (this.f337f != f) {
            this.f337f = f;
            mo81a(f);
        }
    }

    final void m561d(float f) {
        if (this.f338g != f) {
            this.f338g = f;
            mo90b(f);
        }
    }

    boolean mo96d() {
        return false;
    }

    void mo97e() {
    }

    final Drawable m564f() {
        return this.f336e;
    }

    final void m565g() {
        Rect rect = this.f332a;
        mo86a(rect);
        mo98b(rect);
        this.f340l.mo77a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void m566h() {
        if (mo96d()) {
            m544l();
            this.f339k.getViewTreeObserver().addOnPreDrawListener(this.f341m);
        }
    }

    void m567i() {
        if (this.f341m != null) {
            this.f339k.getViewTreeObserver().removeOnPreDrawListener(this.f341m);
            this.f341m = null;
        }
    }

    C0054s mo99j() {
        return new C0054s();
    }

    GradientDrawable m569k() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
