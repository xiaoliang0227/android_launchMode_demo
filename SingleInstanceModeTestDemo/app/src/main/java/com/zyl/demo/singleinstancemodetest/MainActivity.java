package com.zyl.demo.singleinstancemodetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button btnTestSingleInstance;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
  }

  private void init() {
    initField();
    initEvent();
  }

  private void initField() {
    btnTestSingleInstance = (Button) findViewById(R.id.btn_test_singleinstance);
  }

  private void initEvent() {
    btnTestSingleInstance.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btn_test_singleinstance:
        testSingleInstanceMode();
        break;
    }
  }

  private void testSingleInstanceMode() {
    Intent intent = new Intent();
    intent.setAction("com.zyl.demo.launchmode.activity.SingleInstanceModeActivity_action");
    startActivity(intent);
  }
}
