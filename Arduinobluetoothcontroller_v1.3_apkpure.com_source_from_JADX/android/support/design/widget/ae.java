package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.C0028i;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class ae extends MarginLayoutParams {
    ab f309a;
    boolean f310b = false;
    public int f311c = 0;
    public int f312d = 0;
    public int f313e = -1;
    int f314f = -1;
    View f315g;
    View f316h;
    final Rect f317i = new Rect();
    Object f318j;
    private boolean f319k;
    private boolean f320l;
    private boolean f321m;

    public ae(int i, int i2) {
        super(i, i2);
    }

    ae(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0028i.CoordinatorLayout_LayoutParams);
        this.f311c = obtainStyledAttributes.getInteger(C0028i.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
        this.f314f = obtainStyledAttributes.getResourceId(C0028i.CoordinatorLayout_LayoutParams_layout_anchor, -1);
        this.f312d = obtainStyledAttributes.getInteger(C0028i.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
        this.f313e = obtainStyledAttributes.getInteger(C0028i.CoordinatorLayout_LayoutParams_layout_keyline, -1);
        this.f310b = obtainStyledAttributes.hasValue(C0028i.CoordinatorLayout_LayoutParams_layout_behavior);
        if (this.f310b) {
            this.f309a = CoordinatorLayout.m388a(context, attributeSet, obtainStyledAttributes.getString(C0028i.CoordinatorLayout_LayoutParams_layout_behavior));
        }
        obtainStyledAttributes.recycle();
    }

    public ae(ae aeVar) {
        super(aeVar);
    }

    public ae(LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ae(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    private void m500a(View view, CoordinatorLayout coordinatorLayout) {
        this.f315g = coordinatorLayout.findViewById(this.f314f);
        if (this.f315g != null) {
            if (this.f315g != coordinatorLayout) {
                View view2 = this.f315g;
                View parent = this.f315g.getParent();
                while (parent != coordinatorLayout && parent != null) {
                    if (parent != view) {
                        if (parent instanceof View) {
                            view2 = parent;
                        }
                        parent = parent.getParent();
                    } else if (coordinatorLayout.isInEditMode()) {
                        this.f316h = null;
                        this.f315g = null;
                        return;
                    } else {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                }
                this.f316h = view2;
            } else if (coordinatorLayout.isInEditMode()) {
                this.f316h = null;
                this.f315g = null;
            } else {
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
        } else if (coordinatorLayout.isInEditMode()) {
            this.f316h = null;
            this.f315g = null;
        } else {
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f314f) + " to anchor view " + view);
        }
    }

    private boolean m501b(View view, CoordinatorLayout coordinatorLayout) {
        if (this.f315g.getId() != this.f314f) {
            return false;
        }
        View view2 = this.f315g;
        View parent = this.f315g.getParent();
        while (parent != coordinatorLayout) {
            if (parent == null || parent == view) {
                this.f316h = null;
                this.f315g = null;
                return false;
            }
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        this.f316h = view2;
        return true;
    }

    public int m502a() {
        return this.f314f;
    }

    void m503a(Rect rect) {
        this.f317i.set(rect);
    }

    public void m504a(ab abVar) {
        if (this.f309a != abVar) {
            this.f309a = abVar;
            this.f318j = null;
            this.f310b = true;
        }
    }

    void m505a(boolean z) {
        this.f320l = z;
    }

    boolean m506a(CoordinatorLayout coordinatorLayout, View view) {
        if (this.f319k) {
            return true;
        }
        boolean e = (this.f309a != null ? this.f309a.m244e(coordinatorLayout, view) : 0) | this.f319k;
        this.f319k = e;
        return e;
    }

    boolean m507a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 == this.f316h || (this.f309a != null && this.f309a.mo58b(coordinatorLayout, view, view2));
    }

    public ab m508b() {
        return this.f309a;
    }

    View m509b(CoordinatorLayout coordinatorLayout, View view) {
        if (this.f314f == -1) {
            this.f316h = null;
            this.f315g = null;
            return null;
        }
        if (this.f315g == null || !m501b(view, coordinatorLayout)) {
            m500a(view, coordinatorLayout);
        }
        return this.f315g;
    }

    void m510b(boolean z) {
        this.f321m = z;
    }

    Rect m511c() {
        return this.f317i;
    }

    boolean m512d() {
        return this.f315g == null && this.f314f != -1;
    }

    boolean m513e() {
        if (this.f309a == null) {
            this.f319k = false;
        }
        return this.f319k;
    }

    void m514f() {
        this.f319k = false;
    }

    void m515g() {
        this.f320l = false;
    }

    boolean m516h() {
        return this.f320l;
    }

    boolean m517i() {
        return this.f321m;
    }

    void m518j() {
        this.f321m = false;
    }
}
