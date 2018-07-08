package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.C0028i;
import android.support.v4.p014g.C0152i;
import android.support.v4.view.C0230q;
import android.support.v4.view.bv;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class C0056u {
    private static final boolean f537a = (VERSION.SDK_INT < 18);
    private static final Paint f538b = null;
    private boolean f539A;
    private Bitmap f540B;
    private Paint f541C;
    private float f542D;
    private float f543E;
    private float f544F;
    private float f545G;
    private boolean f546H;
    private final TextPaint f547I;
    private Interpolator f548J;
    private Interpolator f549K;
    private float f550L;
    private float f551M;
    private float f552N;
    private int f553O;
    private float f554P;
    private float f555Q;
    private float f556R;
    private int f557S;
    private final View f558c;
    private boolean f559d;
    private float f560e;
    private final Rect f561f;
    private final Rect f562g;
    private final RectF f563h;
    private int f564i = 16;
    private int f565j = 16;
    private float f566k = 15.0f;
    private float f567l = 15.0f;
    private int f568m;
    private int f569n;
    private float f570o;
    private float f571p;
    private float f572q;
    private float f573r;
    private float f574s;
    private float f575t;
    private Typeface f576u;
    private Typeface f577v;
    private Typeface f578w;
    private CharSequence f579x;
    private CharSequence f580y;
    private boolean f581z;

    static {
        if (f538b != null) {
            f538b.setAntiAlias(true);
            f538b.setColor(-65281);
        }
    }

    public C0056u(View view) {
        this.f558c = view;
        this.f547I = new TextPaint(129);
        this.f562g = new Rect();
        this.f561f = new Rect();
        this.f563h = new RectF();
    }

    private static float m913a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return C0031a.m495a(f, f2, f3);
    }

    private static int m914a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static boolean m915a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static boolean m916a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private void m917b(float f) {
        m919c(f);
        this.f574s = C0056u.m913a(this.f572q, this.f573r, f, this.f548J);
        this.f575t = C0056u.m913a(this.f570o, this.f571p, f, this.f548J);
        m920d(C0056u.m913a(this.f566k, this.f567l, f, this.f549K));
        if (this.f569n != this.f568m) {
            this.f547I.setColor(C0056u.m914a(this.f568m, this.f569n, f));
        } else {
            this.f547I.setColor(this.f569n);
        }
        this.f547I.setShadowLayer(C0056u.m913a(this.f554P, this.f550L, f, null), C0056u.m913a(this.f555Q, this.f551M, f, null), C0056u.m913a(this.f556R, this.f552N, f, null), C0056u.m914a(this.f557S, this.f553O, f));
        bv.m2023d(this.f558c);
    }

    private boolean m918b(CharSequence charSequence) {
        int i = 1;
        if (bv.m2031h(this.f558c) != 1) {
            i = 0;
        }
        return (i != 0 ? C0152i.f833d : C0152i.f832c).mo237a(charSequence, 0, charSequence.length());
    }

    private void m919c(float f) {
        this.f563h.left = C0056u.m913a((float) this.f561f.left, (float) this.f562g.left, f, this.f548J);
        this.f563h.top = C0056u.m913a(this.f570o, this.f571p, f, this.f548J);
        this.f563h.right = C0056u.m913a((float) this.f561f.right, (float) this.f562g.right, f, this.f548J);
        this.f563h.bottom = C0056u.m913a((float) this.f561f.bottom, (float) this.f562g.bottom, f, this.f548J);
    }

    private void m920d(float f) {
        m921e(f);
        boolean z = f537a && this.f544F != 1.0f;
        this.f539A = z;
        if (this.f539A) {
            m925j();
        }
        bv.m2023d(this.f558c);
    }

    private void m921e(float f) {
        boolean z = true;
        if (this.f579x != null) {
            float width;
            float f2;
            boolean z2;
            if (C0056u.m915a(f, this.f567l)) {
                width = (float) this.f562g.width();
                float f3 = this.f567l;
                this.f544F = 1.0f;
                if (this.f578w != this.f576u) {
                    this.f578w = this.f576u;
                    f2 = width;
                    width = f3;
                    z2 = true;
                } else {
                    f2 = width;
                    width = f3;
                    z2 = false;
                }
            } else {
                f2 = (float) this.f561f.width();
                width = this.f566k;
                if (this.f578w != this.f577v) {
                    this.f578w = this.f577v;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (C0056u.m915a(f, this.f566k)) {
                    this.f544F = 1.0f;
                } else {
                    this.f544F = f / this.f566k;
                }
            }
            if (f2 > 0.0f) {
                z2 = this.f545G != width || this.f546H || z2;
                this.f545G = width;
                this.f546H = false;
            }
            if (this.f580y == null || r0) {
                this.f547I.setTextSize(this.f545G);
                this.f547I.setTypeface(this.f578w);
                TextPaint textPaint = this.f547I;
                if (this.f544F == 1.0f) {
                    z = false;
                }
                textPaint.setLinearText(z);
                CharSequence ellipsize = TextUtils.ellipsize(this.f579x, this.f547I, f2, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.f580y)) {
                    this.f580y = ellipsize;
                    this.f581z = m918b(this.f580y);
                }
            }
        }
    }

    private Typeface m922g(int i) {
        TypedArray obtainStyledAttributes = this.f558c.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m923h() {
        m917b(this.f560e);
    }

    private void m924i() {
        int i = 1;
        float f = 0.0f;
        float f2 = this.f545G;
        m921e(this.f567l);
        float measureText = this.f580y != null ? this.f547I.measureText(this.f580y, 0, this.f580y.length()) : 0.0f;
        int a = C0230q.m2509a(this.f565j, this.f581z ? 1 : 0);
        switch (a & 112) {
            case 48:
                this.f571p = ((float) this.f562g.top) - this.f547I.ascent();
                break;
            case 80:
                this.f571p = (float) this.f562g.bottom;
                break;
            default:
                this.f571p = (((this.f547I.descent() - this.f547I.ascent()) / 2.0f) - this.f547I.descent()) + ((float) this.f562g.centerY());
                break;
        }
        switch (a & 7) {
            case 1:
                this.f573r = ((float) this.f562g.centerX()) - (measureText / 2.0f);
                break;
            case 5:
                this.f573r = ((float) this.f562g.right) - measureText;
                break;
            default:
                this.f573r = (float) this.f562g.left;
                break;
        }
        m921e(this.f566k);
        if (this.f580y != null) {
            f = this.f547I.measureText(this.f580y, 0, this.f580y.length());
        }
        int i2 = this.f564i;
        if (!this.f581z) {
            i = 0;
        }
        i2 = C0230q.m2509a(i2, i);
        switch (i2 & 112) {
            case 48:
                this.f570o = ((float) this.f561f.top) - this.f547I.ascent();
                break;
            case 80:
                this.f570o = (float) this.f561f.bottom;
                break;
            default:
                this.f570o = (((this.f547I.descent() - this.f547I.ascent()) / 2.0f) - this.f547I.descent()) + ((float) this.f561f.centerY());
                break;
        }
        switch (i2 & 7) {
            case 1:
                this.f572q = ((float) this.f561f.centerX()) - (f / 2.0f);
                break;
            case 5:
                this.f572q = ((float) this.f561f.right) - f;
                break;
            default:
                this.f572q = (float) this.f561f.left;
                break;
        }
        m926k();
        m920d(f2);
    }

    private void m925j() {
        if (this.f540B == null && !this.f561f.isEmpty() && !TextUtils.isEmpty(this.f580y)) {
            m917b(0.0f);
            this.f542D = this.f547I.ascent();
            this.f543E = this.f547I.descent();
            int round = Math.round(this.f547I.measureText(this.f580y, 0, this.f580y.length()));
            int round2 = Math.round(this.f543E - this.f542D);
            if (round > 0 && round2 > 0) {
                this.f540B = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.f540B).drawText(this.f580y, 0, this.f580y.length(), 0.0f, ((float) round2) - this.f547I.descent(), this.f547I);
                if (this.f541C == null) {
                    this.f541C = new Paint(3);
                }
            }
        }
    }

    private void m926k() {
        if (this.f540B != null) {
            this.f540B.recycle();
            this.f540B = null;
        }
    }

    void m927a() {
        boolean z = this.f562g.width() > 0 && this.f562g.height() > 0 && this.f561f.width() > 0 && this.f561f.height() > 0;
        this.f559d = z;
    }

    void m928a(float f) {
        float a = bf.m608a(f, 0.0f, 1.0f);
        if (a != this.f560e) {
            this.f560e = a;
            m923h();
        }
    }

    void m929a(int i) {
        if (this.f569n != i) {
            this.f569n = i;
            m945f();
        }
    }

    void m930a(int i, int i2, int i3, int i4) {
        if (!C0056u.m916a(this.f561f, i, i2, i3, i4)) {
            this.f561f.set(i, i2, i3, i4);
            this.f546H = true;
            m927a();
        }
    }

    public void m931a(Canvas canvas) {
        int save = canvas.save();
        if (this.f580y != null && this.f559d) {
            float f;
            float f2 = this.f574s;
            float f3 = this.f575t;
            int i = (!this.f539A || this.f540B == null) ? 0 : 1;
            float f4;
            if (i != 0) {
                f = this.f542D * this.f544F;
                f4 = this.f543E * this.f544F;
            } else {
                f = this.f547I.ascent() * this.f544F;
                f4 = this.f547I.descent() * this.f544F;
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.f544F != 1.0f) {
                canvas.scale(this.f544F, this.f544F, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.f540B, f2, f3, this.f541C);
            } else {
                canvas.drawText(this.f580y, 0, this.f580y.length(), f2, f3, this.f547I);
            }
        }
        canvas.restoreToCount(save);
    }

    void m932a(Typeface typeface) {
        if (this.f576u != typeface) {
            this.f576u = typeface;
            m945f();
        }
    }

    void m933a(Interpolator interpolator) {
        this.f549K = interpolator;
        m945f();
    }

    void m934a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f579x)) {
            this.f579x = charSequence;
            this.f580y = null;
            m926k();
            m945f();
        }
    }

    int m935b() {
        return this.f564i;
    }

    void m936b(int i) {
        if (this.f568m != i) {
            this.f568m = i;
            m945f();
        }
    }

    void m937b(int i, int i2, int i3, int i4) {
        if (!C0056u.m916a(this.f562g, i, i2, i3, i4)) {
            this.f562g.set(i, i2, i3, i4);
            this.f546H = true;
            m927a();
        }
    }

    void m938b(Typeface typeface) {
        if (this.f577v != typeface) {
            this.f577v = typeface;
            m945f();
        }
    }

    int m939c() {
        return this.f565j;
    }

    void m940c(int i) {
        if (this.f564i != i) {
            this.f564i = i;
            m945f();
        }
    }

    Typeface m941d() {
        return this.f576u != null ? this.f576u : Typeface.DEFAULT;
    }

    void m942d(int i) {
        if (this.f565j != i) {
            this.f565j = i;
            m945f();
        }
    }

    Typeface m943e() {
        return this.f577v != null ? this.f577v : Typeface.DEFAULT;
    }

    void m944e(int i) {
        TypedArray obtainStyledAttributes = this.f558c.getContext().obtainStyledAttributes(i, C0028i.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0028i.TextAppearance_android_textColor)) {
            this.f569n = obtainStyledAttributes.getColor(C0028i.TextAppearance_android_textColor, this.f569n);
        }
        if (obtainStyledAttributes.hasValue(C0028i.TextAppearance_android_textSize)) {
            this.f567l = (float) obtainStyledAttributes.getDimensionPixelSize(C0028i.TextAppearance_android_textSize, (int) this.f567l);
        }
        this.f553O = obtainStyledAttributes.getInt(C0028i.TextAppearance_android_shadowColor, 0);
        this.f551M = obtainStyledAttributes.getFloat(C0028i.TextAppearance_android_shadowDx, 0.0f);
        this.f552N = obtainStyledAttributes.getFloat(C0028i.TextAppearance_android_shadowDy, 0.0f);
        this.f550L = obtainStyledAttributes.getFloat(C0028i.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f576u = m922g(i);
        }
        m945f();
    }

    public void m945f() {
        if (this.f558c.getHeight() > 0 && this.f558c.getWidth() > 0) {
            m924i();
            m923h();
        }
    }

    void m946f(int i) {
        TypedArray obtainStyledAttributes = this.f558c.getContext().obtainStyledAttributes(i, C0028i.TextAppearance);
        if (obtainStyledAttributes.hasValue(C0028i.TextAppearance_android_textColor)) {
            this.f568m = obtainStyledAttributes.getColor(C0028i.TextAppearance_android_textColor, this.f568m);
        }
        if (obtainStyledAttributes.hasValue(C0028i.TextAppearance_android_textSize)) {
            this.f566k = (float) obtainStyledAttributes.getDimensionPixelSize(C0028i.TextAppearance_android_textSize, (int) this.f566k);
        }
        this.f557S = obtainStyledAttributes.getInt(C0028i.TextAppearance_android_shadowColor, 0);
        this.f555Q = obtainStyledAttributes.getFloat(C0028i.TextAppearance_android_shadowDx, 0.0f);
        this.f556R = obtainStyledAttributes.getFloat(C0028i.TextAppearance_android_shadowDy, 0.0f);
        this.f554P = obtainStyledAttributes.getFloat(C0028i.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f577v = m922g(i);
        }
        m945f();
    }

    CharSequence m947g() {
        return this.f579x;
    }
}
