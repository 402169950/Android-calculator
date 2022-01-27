package com.tongliu.calculator.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;

import com.tongliu.calculator.R;
import com.tongliu.calculator.data.observer.DataObs;
import com.tongliu.calculator.data.observer.inf.DataChangedInf;
import com.tongliu.calculator.databinding.ActivityCalculatorMainBinding;
import com.tongliu.calculator.logic.CalculatorImpl;
import com.tongliu.calculator.logic.inf.CalculatorInf;

public class CalculatorMainActivity extends AppCompatActivity implements View.OnClickListener, DataChangedInf {

    boolean showAdv = false;

    private AppBarConfiguration appBarConfiguration;
    private ActivityCalculatorMainBinding binding;
    private DataObs dataObserver;
    private TextView calResultTv;
    private Button digitPadAdvanceBtn;
    private LinearLayout scientificAdvContainerLv;
    private CalculatorInf calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculatorMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initData();
        setSupportActionBar(binding.toolbar);

    }

    private void initView() {
        ((Button) findViewById(R.id.digit_pad_one_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_two_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_three_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_four_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_five_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_six_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_seven_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_eight_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_nine_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_zero_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_clear_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_equal_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_plus_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_minus_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_multiply_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.digit_pad_divide_btn)).setOnClickListener(this);
        digitPadAdvanceBtn = findViewById(R.id.digit_pad_advance_btn);
        digitPadAdvanceBtn.setOnClickListener(this);
        ((Button) findViewById(R.id.advance_pad_rem_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.advance_pad_pow_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.advance_pad_max_btn)).setOnClickListener(this);
        ((Button) findViewById(R.id.advance_pad_min_btn)).setOnClickListener(this);
        scientificAdvContainerLv = findViewById(R.id.scientific_adv_container_lv);

        calResultTv = findViewById(R.id.cal_result_tv);
    }

    private void initData() {
        dataObserver = DataObs.getInstance();
        dataObserver.addObserver(this);
        calculator = CalculatorImpl.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.digit_pad_one_btn:
                appendString(getString(R.string.digit_pad_one), true);
                break;
            case R.id.digit_pad_two_btn:
                appendString(getString(R.string.digit_pad_two), true);
                break;
            case R.id.digit_pad_three_btn:
                appendString(getString(R.string.digit_pad_three), true);
                break;
            case R.id.digit_pad_four_btn:
                appendString(getString(R.string.digit_pad_four), true);
                break;
            case R.id.digit_pad_five_btn:
                appendString(getString(R.string.digit_pad_five), true);
                break;
            case R.id.digit_pad_six_btn:
                appendString(getString(R.string.digit_pad_six), true);
                break;
            case R.id.digit_pad_seven_btn:
                appendString(getString(R.string.digit_pad_seven), true);
                break;
            case R.id.digit_pad_eight_btn:
                appendString(getString(R.string.digit_pad_eight), true);
                break;
            case R.id.digit_pad_nine_btn:
                appendString(getString(R.string.digit_pad_nine), true);
                break;
            case R.id.digit_pad_zero_btn:
                appendString(getString(R.string.digit_pad_zero), true);
                break;
            case R.id.digit_pad_plus_btn:
                appendString(getString(R.string.digit_pad_plus), false);
                break;
            case R.id.digit_pad_minus_btn:
                appendString(getString(R.string.digit_pad_minus), false);
                break;
            case R.id.digit_pad_multiply_btn:
                appendString(getString(R.string.digit_pad_multiply), false);
                break;
            case R.id.digit_pad_divide_btn:
                appendString(getString(R.string.digit_pad_divide), false);
                break;
            case R.id.digit_pad_clear_btn:
                calculator.clear();
                break;
            case R.id.digit_pad_equal_btn:
                calculator.calculate();
                break;
            case R.id.advance_pad_rem_btn:
                appendString(getString(R.string.advance_rem_btn), false);
                break;
            case R.id.advance_pad_pow_btn:
                appendString(getString(R.string.advance_pow_btn), false);

                break;
            case R.id.advance_pad_max_btn:
                appendString(getString(R.string.advance_max_btn), false);
                break;
            case R.id.advance_pad_min_btn:
                appendString(getString(R.string.advance_min_btn), false);
                break;
            case R.id.digit_pad_advance_btn:
                scientificAdvContainerLv.setVisibility(showAdv ? View.INVISIBLE : View.VISIBLE);
                digitPadAdvanceBtn.setText(getString(showAdv ? R.string.digit_pad_advance : R.string.digit_pad_standard));
                showAdv = !showAdv;
                break;

        }
        dataObserver.notify(calculator.toString());
    }

    private void appendString(String appendix, boolean isNumber) {
        if (calculator.hasCalculated()) {
            if (!calculator.hasError()) {
                String lastResult = (String) calculator.getResult();
                calculator.clear();
                calculator.appendNumber(lastResult);
            }
            else
                calculator.clear();
            dataObserver.notify(calculator.toString());
        }
        if (isNumber) calculator.appendNumber(appendix);
        else calculator.appendOperator(appendix);

    }

    @Override
    public void onDataChanged(String newStr) {
        calResultTv.setText(newStr);
    }
}