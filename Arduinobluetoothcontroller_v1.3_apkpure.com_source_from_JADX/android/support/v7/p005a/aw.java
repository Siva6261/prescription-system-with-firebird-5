package android.support.v7.p005a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.support.v4.view.bv;
import android.support.v7.p018b.C0298b;
import android.support.v7.p018b.C0305i;
import android.support.v7.p018b.C0307k;
import android.support.v7.view.menu.C0329i;
import android.support.v7.view.menu.C0334g;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bw;
import android.support.v7.widget.gl;
import android.support.v7.widget.go;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

class aw extends C0266a {
    private bw f1249a;
    private boolean f1250b;
    private Callback f1251c;
    private boolean f1252d;
    private boolean f1253e;
    private ArrayList f1254f = new ArrayList();
    private C0334g f1255g;
    private final Runnable f1256h = new ax(this);
    private final gl f1257i = new ay(this);

    public aw(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f1249a = new go(toolbar, false);
        this.f1251c = new bc(this, callback);
        this.f1249a.mo782a(this.f1251c);
        toolbar.setOnMenuItemClickListener(this.f1257i);
        this.f1249a.mo783a(charSequence);
    }

    private View m3020a(Menu menu) {
        m3023b(menu);
        return (menu == null || this.f1255g == null || this.f1255g.m3436a().getCount() <= 0) ? null : (View) this.f1255g.m3435a(this.f1249a.mo776a());
    }

    private void m3023b(Menu menu) {
        if (this.f1255g == null && (menu instanceof C0329i)) {
            C0329i c0329i = (C0329i) menu;
            Context b = this.f1249a.mo785b();
            TypedValue typedValue = new TypedValue();
            Theme newTheme = b.getResources().newTheme();
            newTheme.setTo(b.getTheme());
            newTheme.resolveAttribute(C0298b.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0298b.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0307k.Theme_AppCompat_CompactMenu, true);
            }
            Context contextThemeWrapper = new ContextThemeWrapper(b, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f1255g = new C0334g(contextThemeWrapper, C0305i.abc_list_menu_item_layout);
            this.f1255g.m3439a(new bb());
            c0329i.m3351a(this.f1255g);
        }
    }

    private Menu m3026k() {
        if (!this.f1252d) {
            this.f1249a.mo779a(new az(), new ba());
            this.f1252d = true;
        }
        return this.f1249a.mo806r();
    }

    public int mo524a() {
        return this.f1249a.mo803o();
    }

    public void mo525a(float f) {
        bv.m2024d(this.f1249a.mo776a(), f);
    }

    public void mo526a(int i) {
        this.f1249a.mo792d(i);
    }

    public void m3030a(int i, int i2) {
        this.f1249a.mo789c((this.f1249a.mo803o() & (i2 ^ -1)) | (i & i2));
    }

    public void mo527a(Configuration configuration) {
        super.mo527a(configuration);
    }

    public void mo528a(CharSequence charSequence) {
        this.f1249a.mo787b(charSequence);
    }

    public void mo529a(boolean z) {
        m3030a(z ? 4 : 0, 4);
    }

    public boolean mo530a(int i, KeyEvent keyEvent) {
        Menu k = m3026k();
        if (k != null) {
            k.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            k.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    public void mo531b(CharSequence charSequence) {
        this.f1249a.mo783a(charSequence);
    }

    public void mo532b(boolean z) {
    }

    public boolean mo533b() {
        return this.f1249a.mo805q() == 0;
    }

    public Context mo534c() {
        return this.f1249a.mo785b();
    }

    public void mo535d(boolean z) {
    }

    public void mo536e(boolean z) {
    }

    public boolean mo537e() {
        this.f1249a.mo776a().removeCallbacks(this.f1256h);
        bv.m2010a(this.f1249a.mo776a(), this.f1256h);
        return true;
    }

    public void mo538f(boolean z) {
        if (z != this.f1253e) {
            this.f1253e = z;
            int size = this.f1254f.size();
            for (int i = 0; i < size; i++) {
                ((C0278c) this.f1254f.get(i)).m3155a(z);
            }
        }
    }

    public boolean mo539f() {
        if (!this.f1249a.mo790c()) {
            return false;
        }
        this.f1249a.mo791d();
        return true;
    }

    public boolean mo540g() {
        ViewGroup a = this.f1249a.mo776a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    void mo541h() {
        this.f1249a.mo776a().removeCallbacks(this.f1256h);
    }

    public Callback m3046i() {
        return this.f1251c;
    }

    void m3047j() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:12:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.m3026k();
        r2 = r1 instanceof android.support.v7.view.menu.C0329i;
        if (r2 == 0) goto L_0x0031;
    L_0x0009:
        r0 = r1;
        r0 = (android.support.v7.view.menu.C0329i) r0;
        r2 = r0;
    L_0x000d:
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r2.m3373g();
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x0033 }
        r0 = r5.f1251c;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onCreatePanelMenu(r3, r1);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x0033 }
    L_0x001e:
        r0 = r5.f1251c;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r4 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002b;	 Catch:{ all -> 0x0033 }
    L_0x0028:
        r1.clear();	 Catch:{ all -> 0x0033 }
    L_0x002b:
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.m3374h();
    L_0x0030:
        return;
    L_0x0031:
        r2 = r0;
        goto L_0x000d;
    L_0x0033:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.m3374h();
    L_0x0039:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.aw.j():void");
    }
}
