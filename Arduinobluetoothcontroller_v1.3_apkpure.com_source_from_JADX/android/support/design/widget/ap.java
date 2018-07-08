package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.C0021b;
import android.support.v4.p010d.p011a.C0106a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

class ap extends ay {
    bg f342a;
    private int f343m;
    private cb f344n = new cb();
    private boolean f345o;

    ap(dh dhVar, bh bhVar) {
        super(dhVar, bhVar);
        this.f343m = dhVar.getResources().getInteger(17694720);
        this.f344n.m679a((View) dhVar);
        this.f344n.m681a(h, m570a(new at()));
        this.f344n.m681a(i, m570a(new at()));
        this.f344n.m681a(j, m570a(new au()));
    }

    private Animation m570a(Animation animation) {
        animation.setInterpolator(C0031a.f303b);
        animation.setDuration((long) this.f343m);
        return animation;
    }

    private static ColorStateList m572b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{i, i, h};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    float mo80a() {
        return this.f;
    }

    void mo81a(float f) {
        if (this.f342a != null) {
            this.f342a.m620a(f, this.g + f);
            m565g();
        }
    }

    void mo82a(int i) {
        if (this.c != null) {
            C0106a.m1336a(this.c, m572b(i));
        }
    }

    void mo83a(ColorStateList colorStateList) {
        if (this.b != null) {
            C0106a.m1336a(this.b, colorStateList);
        }
        if (this.d != null) {
            this.d.m911a(colorStateList);
        }
    }

    void mo84a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.b = C0106a.m1346f(m569k());
        C0106a.m1336a(this.b, colorStateList);
        if (mode != null) {
            C0106a.m1339a(this.b, mode);
        }
        this.c = C0106a.m1346f(m569k());
        C0106a.m1336a(this.c, m572b(i));
        if (i2 > 0) {
            this.d = m546a(i2, colorStateList);
            drawableArr = new Drawable[]{this.d, this.b, this.c};
        } else {
            this.d = null;
            drawableArr = new Drawable[]{this.b, this.c};
        }
        this.e = new LayerDrawable(drawableArr);
        this.f342a = new bg(this.k.getResources(), this.e, this.l.mo76a(), this.f, this.f + this.g);
        this.f342a.m621a(false);
        this.l.mo78a(this.f342a);
    }

    void mo85a(Mode mode) {
        if (this.b != null) {
            C0106a.m1339a(this.b, mode);
        }
    }

    void mo86a(Rect rect) {
        this.f342a.getPadding(rect);
    }

    void mo87a(ba baVar, boolean z) {
        if (!this.f345o && this.k.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), C0021b.design_fab_out);
            loadAnimation.setInterpolator(C0031a.f304c);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new aq(this, z, baVar));
            this.k.startAnimation(loadAnimation);
        } else if (baVar != null) {
            baVar.mo74b();
        }
    }

    void mo88a(int[] iArr) {
        this.f344n.m680a(iArr);
    }

    void mo89b() {
        this.f344n.m682b();
    }

    void mo90b(float f) {
        if (this.f342a != null) {
            this.f342a.m623c(this.f + f);
            m565g();
        }
    }

    void mo91b(ba baVar, boolean z) {
        if (this.k.getVisibility() != 0 || this.f345o) {
            this.k.clearAnimation();
            this.k.m436a(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), C0021b.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(C0031a.f305d);
            loadAnimation.setAnimationListener(new ar(this, baVar));
            this.k.startAnimation(loadAnimation);
        } else if (baVar != null) {
            baVar.mo73a();
        }
    }

    void mo92c() {
    }
}
