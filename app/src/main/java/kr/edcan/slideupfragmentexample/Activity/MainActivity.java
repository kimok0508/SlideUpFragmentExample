package kr.edcan.slideupfragmentexample.Activity;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.edcan.slideupfragmentexample.Fragment.LoginFragment;
import kr.edcan.slideupfragmentexample.Fragment.RegisterFragment;
import kr.edcan.slideupfragmentexample.R;
import kr.edcan.slideupfragmentexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.login.setOnClickListener(e -> {
            final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.addSharedElement(binding.login, "login");
            transaction.setCustomAnimations(R.anim.anim_slide_up, 0);
            transaction.replace(binding.getRoot().getId(), new LoginFragment(), "Login");
            transaction.commit();
        });
        binding.register.setOnClickListener(e -> {
            final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.addSharedElement(binding.register, "register");
            transaction.setCustomAnimations(R.anim.anim_slide_up, 0);
            transaction.replace(binding.getRoot().getId(), new RegisterFragment(), "Register");
            transaction.commit();
        });
    }
}
