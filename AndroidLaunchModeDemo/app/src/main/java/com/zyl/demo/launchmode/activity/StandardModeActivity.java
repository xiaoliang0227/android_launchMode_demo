package com.zyl.demo.launchmode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zyl.demo.launchmode.R;
import com.zyl.demo.launchmode.util.LogUtil;

/**
 * Created by JasonZhao on 16/5/17.
 */
public class StandardModeActivity extends AppCompatActivity implements View.OnClickListener {

  private static final String TAG = "StandardModeActivity";

  private Button btnStandard, btnSingleTop, btnSingleTask, btnSingleInstance;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_standard_mode);
    init();
  }

  private void init() {
    initView();
    initEvent();
  }

  private void initView() {
    btnStandard = (Button) findViewById(R.id.btn_standard_mode);
    btnSingleTop = (Button) findViewById(R.id.btn_singleTop_mode);
    btnSingleTask = (Button) findViewById(R.id.btn_singleTask_mode);
    btnSingleInstance = (Button) findViewById(R.id.btn_singleInstance_mode);
  }

  private void initEvent() {
    btnStandard.setOnClickListener(this);
    btnSingleTop.setOnClickListener(this);
    btnSingleTask.setOnClickListener(this);
    btnSingleInstance.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btn_standard_mode:
        startStandardModeActivity();
        break;
      case R.id.btn_singleTop_mode:
        startSingleTopModeActivity();
        break;
      case R.id.btn_singleTask_mode:
        startSingleTaskModeActivity();
        break;
      case R.id.btn_singleInstance_mode:
        startSingleInstanceModeActivity();
        break;
    }
  }

  private void startStandardModeActivity() {
    LogUtil.DEBUG(TAG, "startStandardModeActivity");
    Intent intent = new Intent(this, StandardModeActivity.class);
    startActivity(intent);
  }

  private void startSingleTopModeActivity() {
    LogUtil.DEBUG(TAG, "startSingleTopModeActivity");
    Intent intent = new Intent(this, SingleTopModeActivity.class);
    startActivity(intent);
  }

  private void startSingleTaskModeActivity() {
    LogUtil.DEBUG(TAG, "startSingleTaskModeActivity");
    Intent intent = new Intent(this, SingleTaskModeActivity.class);
    startActivity(intent);
  }

  private void startSingleInstanceModeActivity() {
    LogUtil.DEBUG(TAG, "startSingleInstanceModeActivity");
    Intent intent = new Intent(this, SingleInstanceModeActivity.class);
    startActivity(intent);
  }
}
