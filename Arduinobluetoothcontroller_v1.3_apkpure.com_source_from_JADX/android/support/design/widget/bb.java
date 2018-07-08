package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.p010d.p011a.C0106a;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
class bb extends av {
    private final Interpolator f365m;
    private InsetDrawable f366n;

    bb(dh dhVar, bh bhVar) {
        super(dhVar, bhVar);
        this.f365m = dhVar.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.k.getContext(), 17563661);
    }

    private Animator m595a(Animator animator) {
        animator.setInterpolator(this.f365m);
        return animator;
    }

    public float mo80a() {
        return this.k.getElevation();
    }

    public void mo81a(float f) {
        this.k.setElevation(f);
        if (this.l.mo79b()) {
            m565g();
        }
    }

    void mo82a(int i) {
        if (this.c instanceof RippleDrawable) {
            ((RippleDrawable) this.c).setColor(ColorStateList.valueOf(i));
        } else {
            super.mo82a(i);
        }
    }

    void mo84a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.b = C0106a.m1346f(m569k());
        C0106a.m1336a(this.b, colorStateList);
        if (mode != null) {
            C0106a.m1339a(this.b, mode);
        }
        if (i2 > 0) {
            this.d = m546a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.d, this.b});
        } else {
            this.d = null;
            layerDrawable = this.b;
        }
        this.c = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.e = this.c;
        this.l.mo78a(this.c);
    }

    void mo86a(Rect rect) {
        if (this.l.mo79b()) {
            float a = this.l.mo76a();
            float a2 = mo80a() + this.g;
            int ceil = (int) Math.ceil((double) bg.m615b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) bg.m612a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    void mo88a(int[] iArr) {
    }

    void mo89b() {
    }

    void mo90b(float f) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(h, m595a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{f})));
        stateListAnimator.addState(i, m595a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{f})));
        stateListAnimator.addState(j, m595a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{0.0f})));
        this.k.setStateListAnimator(stateListAnimator);
        if (this.l.mo79b()) {
            m565g();
        }
    }

    void mo98b(Rect rect) {
        if (this.l.mo79b()) {
            this.f366n = new InsetDrawable(this.c, rect.left, rect.top, rect.right, rect.bottom);
            this.l.mo78a(this.f366n);
            return;
        }
        this.l.mo78a(this.c);
    }

    void mo92c() {
        m565g();
    }

    boolean mo96d() {
        return false;
    }

    C0054s mo99j() {
        return new C0055t();
    }
}
