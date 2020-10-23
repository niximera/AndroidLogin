package cy.logintestnewversion.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cy.logintestnewversion.R;
import cy.logintestnewversion.animation.ViewAnimations;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.container_main)
    LinearLayout container_main;

    @BindView(R.id.img_biglogo)
    ImageView img_biglogo;

    @BindView(R.id.container_email)
    TextInputLayout container_email;

    @BindView(R.id.container_pass)
    TextInputLayout container_pass;

    @BindView(R.id.input_email)
    EditText input_email;

    @BindView(R.id.input_password)
    EditText input_password;

    @BindView(R.id.btn_login)
    AppCompatButton btn_login;

    @BindView(R.id.txt_new_user)
    TextView txt_new_user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("font/book.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        new ViewAnimations().openChildAnimation(container_main);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, NewAccountActivity.class);
                startActivity(i);
            }
        });

        txt_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, NewAccountActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
