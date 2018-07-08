package com.giumig.apps.bluetoothcontroller;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.giumig.apps.bluetoothcontroller.p025d.C0396c;
import com.giumig.apps.bluetoothserialmonitor.R;
import io.realm.C0483m;
import io.realm.ae;

public class SwitchProfileSettingsActivity extends C0373a {
    private ImageView f2607m;
    private ImageView f2608n;
    private TextView f2609o;
    private TextView f2610p;
    private TextView f2611q;
    private EditText f2612r;
    private EditText f2613s;
    private C0396c f2614t;
    private C0483m f2615u;
    private OnClickListener f2616v = new bi(this);
    private OnEditorActionListener f2617w = new bj(this);
    private OnFocusChangeListener f2618x = new bk(this);

    private void m5154a(int i, boolean z) {
        int i2 = 0;
        EditText editText;
        if (i == this.f2612r.getId()) {
            this.f2610p.setVisibility(z ? 8 : 0);
            editText = this.f2612r;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2612r.requestFocus();
                m5162b(this.f2612r);
                if (!TextUtils.isEmpty(this.f2610p.getText().toString()) && !this.f2610p.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2612r.setText(this.f2610p.getText().toString());
                }
            }
        } else if (i == this.f2613s.getId()) {
            this.f2611q.setVisibility(z ? 8 : 0);
            editText = this.f2613s;
            if (!z) {
                i2 = 8;
            }
            editText.setVisibility(i2);
            if (z) {
                this.f2613s.requestFocus();
                m5162b(this.f2613s);
                if (!TextUtils.isEmpty(this.f2611q.getText().toString()) && !this.f2611q.getText().toString().equals(getString(R.string.controller_command_not_set))) {
                    this.f2613s.setText(this.f2611q.getText().toString());
                }
            }
        }
    }

    private void m5155a(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void m5156a(TextView textView, String str) {
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

    private void m5160a(String str) {
        m5156a(this.f2610p, str);
        this.f2615u.mo885b();
        this.f2614t.m5324c(str);
        this.f2615u.m5800b(this.f2614t);
        this.f2615u.mo886c();
    }

    private void m5162b(View view) {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(view, 0);
    }

    private void m5164b(String str) {
        m5156a(this.f2611q, str);
        this.f2615u.mo885b();
        this.f2614t.m5326d(str);
        this.f2615u.m5800b(this.f2614t);
        this.f2615u.mo886c();
    }

    private void m5165n() {
        ae a = this.f2615u.m5799b(C0396c.class).m5396a();
        if (a.size() > 0) {
            this.f2614t = (C0396c) a.m5403a(0);
            Log.d("SwitchSettings", "retrieved switch profile '" + this.f2614t.m5319a() + "'");
            return;
        }
        this.f2615u.mo885b();
        C0396c c0396c = (C0396c) this.f2615u.m5796a(C0396c.class);
        c0396c.m5320a("profile01");
        c0396c.m5322b("new profile");
        this.f2615u.mo886c();
        this.f2614t = c0396c;
        Log.d("SwitchSettings", "created new switch profile '" + this.f2614t.m5319a() + "'");
    }

    private void m5166o() {
        this.f2609o = (TextView) findViewById(R.id.config_switch_header);
        bl.m5214a(this.f2609o, "Roboto-Light.ttf");
        this.f2607m = (ImageView) findViewById(R.id.config_on);
        this.f2608n = (ImageView) findViewById(R.id.config_off);
        this.f2607m.setColorFilter(getResources().getColor(R.color.switch_on));
        this.f2608n.setColorFilter(getResources().getColor(R.color.switch_off));
        this.f2610p = (TextView) findViewById(R.id.config_on_command);
        this.f2611q = (TextView) findViewById(R.id.config_off_command);
        bl.m5214a(this.f2610p, "Roboto-Thin.ttf");
        bl.m5214a(this.f2611q, "Roboto-Thin.ttf");
        this.f2612r = (EditText) findViewById(R.id.config_on_commandEditText);
        this.f2613s = (EditText) findViewById(R.id.config_off_commandEditText);
        this.f2612r.setOnEditorActionListener(this.f2617w);
        this.f2612r.setOnFocusChangeListener(this.f2618x);
        this.f2613s.setOnEditorActionListener(this.f2617w);
        this.f2613s.setOnFocusChangeListener(this.f2618x);
        findViewById(R.id.onConfiguration).setOnClickListener(this.f2616v);
        findViewById(R.id.offConfiguration).setOnClickListener(this.f2616v);
    }

    private void m5167p() {
        m5156a(this.f2610p, this.f2614t.m5321b());
        m5156a(this.f2611q, this.f2614t.m5323c());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_switch_profile_settings);
        m3225g().mo529a(true);
        m3225g().mo526a((int) R.drawable.ic_power_settings_new_white_24dp);
        m3225g().mo528a((CharSequence) "");
        m5166o();
        this.f2615u = C0483m.m5793l();
        m5165n();
        m5167p();
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
