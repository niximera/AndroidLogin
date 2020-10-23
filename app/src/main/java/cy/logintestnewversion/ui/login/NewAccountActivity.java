package cy.logintestnewversion.ui.login;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


import butterknife.BindView;
import butterknife.ButterKnife;
import cy.logintestnewversion.R;
import cy.logintestnewversion.animation.ViewAnimations;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class NewAccountActivity extends AppCompatActivity {
    @BindView(R.id.container_account)
    LinearLayout container_account;

    @BindView(R.id.img_newacc)
    ImageView img_newacc;

    @BindView(R.id.input_email_acc)
    EditText input_email_acc;

    @BindView(R.id.input_password_first)
    EditText input_password_first;

    @BindView(R.id.input_password_last)
    EditText input_password_last;

    @BindView(R.id.person_name)
    EditText person_name;

    @BindView(R.id.person_surname)
    EditText person_surname;

    @BindView(R.id.person_tel)
    EditText person_tel;

    @BindView(R.id.person_address)
    EditText person_address;

    @BindView(R.id.btn_next)
    AppCompatButton btn_next;

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
        setContentView(R.layout.new_acc);
        ButterKnife.bind(this);
        new ViewAnimations().openChildAnimation(container_account);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

}
