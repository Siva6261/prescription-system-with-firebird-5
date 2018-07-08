package com.giumig.apps.bluetoothcontroller;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.giumig.apps.bluetoothcontroller.p025d.C0393a;
import com.giumig.apps.bluetoothserialmonitor.R;
import io.realm.C0483m;
import io.realm.ae;

public class ControllerProfileSettingsActivity extends C0373a {
    private Button f2479A;
    private TextView f2480B;
    private TextView f2481C;
    private EditText f2482D;
    private EditText f2483E;
    private ImageView f2484F;
    private ImageView f2485G;
    private ImageView f2486H;
    private ImageView f2487I;
    private TextView f2488J;
    private TextView f2489K;
    private TextView f2490L;
    private TextView f2491M;
    private EditText f2492N;
    private EditText f2493O;
    private EditText f2494P;
    private EditText f2495Q;
    private C0393a f2496R;
    private C0483m f2497S;
    private OnClickListener f2498T = new C0404k(this);
    private OnEditorActionListener f2499U = new C0405l(this);
    private OnFocusChangeListener f2500V = new C0406m(this);
    private TextView f2501m;
    private ImageView f2502n;
    private ImageView f2503o;
    private ImageView f2504p;
    private ImageView f2505q;
    private TextView f2506r;
    private TextView f2507s;
    private TextView f2508t;
    private TextView f2509u;
    private EditText f2510v;
    private EditText f2511w;
    private EditText f2512x;
    private EditText f2513y;
    private Button f2514z;

    private void m4963a(int i, boolean z) {
        int i2 = 0;
        EditText editText;
        if (i == this.f2510v.getId()) {
            this.f2506r.setVisibility(z ? 8 : 0);
            editText = this.f2510v;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2510v.requestFocus();
                m4971b(this.f2510v);
                if (!TextUtils.isEmpty(this.f2506r.getText().toString()) && !this.f2506r.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2510v.setText(this.f2506r.getText().toString());
                }
            }
        } else if (i == this.f2511w.getId()) {
            this.f2507s.setVisibility(z ? 8 : 0);
            editText = this.f2511w;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2511w.requestFocus();
                m4971b(this.f2511w);
                if (!TextUtils.isEmpty(this.f2507s.getText().toString()) && !this.f2507s.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2511w.setText(this.f2507s.getText().toString());
                }
            }
        } else if (i == this.f2512x.getId()) {
            this.f2508t.setVisibility(z ? 8 : 0);
            editText = this.f2512x;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2512x.requestFocus();
                m4971b(this.f2512x);
                if (!TextUtils.isEmpty(this.f2508t.getText().toString()) && !this.f2508t.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2512x.setText(this.f2508t.getText().toString());
                }
            }
        } else if (i == this.f2513y.getId()) {
            this.f2509u.setVisibility(z ? 8 : 0);
            editText = this.f2513y;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2513y.requestFocus();
                m4971b(this.f2513y);
                if (!TextUtils.isEmpty(this.f2509u.getText().toString()) && !this.f2509u.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2513y.setText(this.f2509u.getText().toString());
                }
            }
        } else if (i == this.f2482D.getId()) {
            this.f2480B.setVisibility(z ? 8 : 0);
            editText = this.f2482D;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2482D.requestFocus();
                m4971b(this.f2482D);
                if (!TextUtils.isEmpty(this.f2480B.getText().toString()) && !this.f2480B.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2482D.setText(this.f2480B.getText().toString());
                }
            }
        } else if (i == this.f2483E.getId()) {
            this.f2481C.setVisibility(z ? 8 : 0);
            editText = this.f2483E;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2483E.requestFocus();
                m4971b(this.f2483E);
                if (!TextUtils.isEmpty(this.f2481C.getText().toString()) && !this.f2481C.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2483E.setText(this.f2481C.getText().toString());
                }
            }
        } else if (i == this.f2495Q.getId()) {
            this.f2491M.setVisibility(z ? 8 : 0);
            editText = this.f2495Q;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2495Q.requestFocus();
                m4971b(this.f2495Q);
                if (!TextUtils.isEmpty(this.f2491M.getText().toString()) && !this.f2491M.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2495Q.setText(this.f2491M.getText().toString());
                }
            }
        } else if (i == this.f2493O.getId()) {
            this.f2489K.setVisibility(z ? 8 : 0);
            editText = this.f2493O;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2493O.requestFocus();
                m4971b(this.f2493O);
                if (!TextUtils.isEmpty(this.f2489K.getText().toString()) && !this.f2489K.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2493O.setText(this.f2489K.getText().toString());
                }
            }
        } else if (i == this.f2494P.getId()) {
            this.f2490L.setVisibility(z ? 8 : 0);
            editText = this.f2494P;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2494P.requestFocus();
                m4971b(this.f2494P);
                if (!TextUtils.isEmpty(this.f2490L.getText().toString()) && !this.f2490L.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2494P.setText(this.f2490L.getText().toString());
                }
            }
        } else if (i == this.f2492N.getId()) {
            this.f2488J.setVisibility(z ? 8 : 0);
            editText = this.f2492N;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2492N.requestFocus();
                m4971b(this.f2492N);
                if (!TextUtils.isEmpty(this.f2488J.getText().toString()) && !this.f2488J.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2492N.setText(this.f2488J.getText().toString());
                }
            }
        }
    }

    private void m4964a(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void m4965a(TextView textView, String str) {
        CharSequence string;
        if (TextUtils.isEmpty(str)) {
            string = getString(R.string.controller_command_not_set);
        } else {
            Object obj = str;
        }
        textView.setText(string);
        bl.m5214a(textView, TextUtils.isEmpty(str) ? "Roboto-Thin.ttf" : "Roboto-Bold.ttf");
        textView.setTextSize(TextUtils.isEmpty(str) ? 16.0f : 18.0f);
    }

    private void m4969a(String str) {
        m4965a(this.f2506r, str);
        this.f2497S.mo885b();
        this.f2496R.m5266c(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4971b(View view) {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(view, 0);
    }

    private void m4973b(String str) {
        m4965a(this.f2507s, str);
        this.f2497S.mo885b();
        this.f2496R.m5270e(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4976c(String str) {
        m4965a(this.f2508t, str);
        this.f2497S.mo885b();
        this.f2496R.m5268d(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4979d(String str) {
        m4965a(this.f2509u, str);
        this.f2497S.mo885b();
        this.f2496R.m5272f(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4982e(String str) {
        m4965a(this.f2488J, str);
        this.f2497S.mo885b();
        this.f2496R.m5278i(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4985f(String str) {
        m4965a(this.f2480B, str);
        this.f2497S.mo885b();
        this.f2496R.m5274g(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4988g(String str) {
        m4965a(this.f2481C, str);
        this.f2497S.mo885b();
        this.f2496R.m5276h(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4991h(String str) {
        m4965a(this.f2489K, str);
        this.f2497S.mo885b();
        this.f2496R.m5282k(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4994i(String str) {
        m4965a(this.f2490L, str);
        this.f2497S.mo885b();
        this.f2496R.m5280j(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4997j(String str) {
        m4965a(this.f2491M, str);
        this.f2497S.mo885b();
        this.f2496R.m5283l(str);
        this.f2497S.m5800b(this.f2496R);
        this.f2497S.mo886c();
    }

    private void m4998n() {
        ae a = this.f2497S.m5799b(C0393a.class).m5395a("currentlyUsed", Boolean.valueOf(true)).m5396a();
        if (a.size() > 0) {
            this.f2496R = (C0393a) a.m5403a(0);
            Log.d("ControllerSettings", "retrieved controller profile '" + this.f2496R.m5259a() + "'");
            return;
        }
        this.f2497S.mo885b();
        C0393a c0393a = (C0393a) this.f2497S.m5796a(C0393a.class);
        c0393a.m5260a("profile01");
        c0393a.m5263b("new profile");
        c0393a.m5261a(true);
        this.f2497S.mo886c();
        this.f2496R = c0393a;
        Log.d("ControllerSettings", "created new controller profile '" + this.f2496R.m5259a() + "'");
    }

    private void m4999o() {
        this.f2501m = (TextView) findViewById(R.id.config_joystick_header);
        bl.m5214a(this.f2501m, "Roboto-Light.ttf");
        m5000p();
        m5001q();
        m5002r();
        m5003s();
        m5004t();
    }

    private void m5000p() {
        this.f2502n = (ImageView) findViewById(R.id.config_leftArrow);
        this.f2502n.setColorFilter(getResources().getColor(R.color.black));
        this.f2503o = (ImageView) findViewById(R.id.config_upArrow);
        this.f2503o.setColorFilter(getResources().getColor(R.color.black));
        this.f2504p = (ImageView) findViewById(R.id.config_rightArrow);
        this.f2504p.setColorFilter(getResources().getColor(R.color.black));
        this.f2505q = (ImageView) findViewById(R.id.config_downArrow);
        this.f2505q.setColorFilter(getResources().getColor(R.color.black));
    }

    private void m5001q() {
        this.f2514z = (Button) findViewById(R.id.selectButton);
        this.f2479A = (Button) findViewById(R.id.startButton);
    }

    private void m5002r() {
        this.f2484F = (ImageView) findViewById(R.id.config_leftButton);
        this.f2484F.setColorFilter(getResources().getColor(R.color.arduinoOrange2));
        this.f2485G = (ImageView) findViewById(R.id.config_upButton);
        this.f2485G.setColorFilter(getResources().getColor(R.color.arduinoBrown1));
        this.f2486H = (ImageView) findViewById(R.id.config_rightButton);
        this.f2486H.setColorFilter(getResources().getColor(R.color.arduinoYellow1));
        this.f2487I = (ImageView) findViewById(R.id.config_downButton);
        this.f2487I.setColorFilter(getResources().getColor(R.color.arduinoGray1));
    }

    private void m5003s() {
        this.f2506r = (TextView) findViewById(R.id.config_leftArrow_command);
        this.f2507s = (TextView) findViewById(R.id.config_upArrow_command);
        this.f2508t = (TextView) findViewById(R.id.config_rightArrow_command);
        this.f2509u = (TextView) findViewById(R.id.config_downArrow_command);
        this.f2480B = (TextView) findViewById(R.id.config_selectButton_command);
        this.f2481C = (TextView) findViewById(R.id.config_startButton_command);
        this.f2488J = (TextView) findViewById(R.id.config_leftButton_command);
        this.f2489K = (TextView) findViewById(R.id.config_upButton_command);
        this.f2490L = (TextView) findViewById(R.id.config_rightButton_command);
        this.f2491M = (TextView) findViewById(R.id.config_downButton_command);
        bl.m5214a(this.f2506r, "Roboto-Thin.ttf");
        bl.m5214a(this.f2507s, "Roboto-Thin.ttf");
        bl.m5214a(this.f2508t, "Roboto-Thin.ttf");
        bl.m5214a(this.f2509u, "Roboto-Thin.ttf");
        bl.m5214a(this.f2480B, "Roboto-Thin.ttf");
        bl.m5214a(this.f2481C, "Roboto-Thin.ttf");
        bl.m5214a(this.f2488J, "Roboto-Thin.ttf");
        bl.m5214a(this.f2489K, "Roboto-Thin.ttf");
        bl.m5214a(this.f2490L, "Roboto-Thin.ttf");
        bl.m5214a(this.f2491M, "Roboto-Thin.ttf");
        this.f2510v = (EditText) findViewById(R.id.config_leftArrow_commandEditText);
        this.f2511w = (EditText) findViewById(R.id.config_upArrow_commandEditText);
        this.f2512x = (EditText) findViewById(R.id.config_rightArrow_commandEditText);
        this.f2513y = (EditText) findViewById(R.id.config_downArrow_commandEditText);
        this.f2482D = (EditText) findViewById(R.id.config_selectButton_commandEditText);
        this.f2483E = (EditText) findViewById(R.id.config_startButton_commandEditText);
        this.f2492N = (EditText) findViewById(R.id.config_leftButton_commandEditText);
        this.f2493O = (EditText) findViewById(R.id.config_upButton_commandEditText);
        this.f2494P = (EditText) findViewById(R.id.config_rightButton_commandEditText);
        this.f2495Q = (EditText) findViewById(R.id.config_downButton_commandEditText);
        this.f2510v.setOnEditorActionListener(this.f2499U);
        this.f2510v.setOnFocusChangeListener(this.f2500V);
        this.f2511w.setOnEditorActionListener(this.f2499U);
        this.f2511w.setOnFocusChangeListener(this.f2500V);
        this.f2512x.setOnEditorActionListener(this.f2499U);
        this.f2512x.setOnFocusChangeListener(this.f2500V);
        this.f2513y.setOnEditorActionListener(this.f2499U);
        this.f2513y.setOnFocusChangeListener(this.f2500V);
        this.f2482D.setOnEditorActionListener(this.f2499U);
        this.f2482D.setOnFocusChangeListener(this.f2500V);
        this.f2483E.setOnEditorActionListener(this.f2499U);
        this.f2483E.setOnFocusChangeListener(this.f2500V);
        this.f2492N.setOnEditorActionListener(this.f2499U);
        this.f2492N.setOnFocusChangeListener(this.f2500V);
        this.f2493O.setOnEditorActionListener(this.f2499U);
        this.f2493O.setOnFocusChangeListener(this.f2500V);
        this.f2494P.setOnEditorActionListener(this.f2499U);
        this.f2494P.setOnFocusChangeListener(this.f2500V);
        this.f2495Q.setOnEditorActionListener(this.f2499U);
        this.f2495Q.setOnFocusChangeListener(this.f2500V);
    }

    private void m5004t() {
        findViewById(R.id.leftArrowConfiguration).setOnClickListener(this.f2498T);
        findViewById(R.id.upArrowConfiguration).setOnClickListener(this.f2498T);
        findViewById(R.id.rightArrowConfiguration).setOnClickListener(this.f2498T);
        findViewById(R.id.downArrowConfiguration).setOnClickListener(this.f2498T);
        findViewById(R.id.selectButtonConfiguration).setOnClickListener(this.f2498T);
        findViewById(R.id.startButtonConfiguration).setOnClickListener(this.f2498T);
        findViewById(R.id.leftButtonConfiguration).setOnClickListener(this.f2498T);
        findViewById(R.id.upButtonConfiguration).setOnClickListener(this.f2498T);
        findViewById(R.id.rightButtonConfiguration).setOnClickListener(this.f2498T);
        findViewById(R.id.downButtonConfiguration).setOnClickListener(this.f2498T);
    }

    private void m5005u() {
        m4965a(this.f2506r, this.f2496R.m5262b());
        m4965a(this.f2507s, this.f2496R.m5267d());
        m4965a(this.f2508t, this.f2496R.m5265c());
        m4965a(this.f2509u, this.f2496R.m5269e());
        m4965a(this.f2480B, this.f2496R.m5271f());
        m4965a(this.f2481C, this.f2496R.m5273g());
        m4965a(this.f2488J, this.f2496R.m5275h());
        m4965a(this.f2489K, this.f2496R.m5279j());
        m4965a(this.f2490L, this.f2496R.m5277i());
        m4965a(this.f2491M, this.f2496R.m5281k());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_controller_profile_settings);
        if (!MyApplication.m5137a().m5142e()) {
            setRequestedOrientation(1);
        }
        m3225g().mo529a(true);
        m3225g().mo526a((int) R.drawable.ic_videogame_asset_white_24dp);
        m3225g().mo528a((CharSequence) "");
        m4999o();
        this.f2497S = C0483m.m5793l();
        m4998n();
        m5005u();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
