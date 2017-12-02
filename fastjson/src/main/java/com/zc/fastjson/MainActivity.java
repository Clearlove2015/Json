package com.zc.fastjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zc.fastjson.bean.JsonArrayBean;
import com.zc.fastjson.bean.JsonCommonBean;
import com.zc.fastjson.bean.JsonStrBean;
import com.zc.fastjson.util.ReadAssetsUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.alibaba.fastjson.JSON.parseObject;
import static com.zc.fastjson.util.ReadAssetsUtil.getJson;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.btn3)
    Button btn3;
    @Bind(R.id.btn4)
    Button btn4;
    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.btn5)
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,R.id.btn5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                jsonToJavaObjectByFastJson();
                break;
            case R.id.btn2:
                jsonToJavaListByFastJson();
                break;
            case R.id.btn3:
                javaToJsonObjectByFastJson();
                break;
            case R.id.btn4:
                javaToJsonArrayByFastJson();
                break;
            case R.id.btn5:
                useFastJson();
                break;
        }
    }

    /**
     * 将json对象转换为java对象
     */
    private void jsonToJavaObjectByFastJson() {
        String json = getJson(this, "JsonStr.json");
        JsonStrBean jsonStrBean = parseObject(json, JsonStrBean.class);
        tv1.setText(json);
        tv2.setText(jsonStrBean.toString());
    }

    /**
     * 将json数组转换为java集合
     */
    private void jsonToJavaListByFastJson() {
        String json = getJson(this, "JsonArray.json");
        List<JsonArrayBean> beans = JSON.parseArray(json, JsonArrayBean.class);
        tv1.setText(json);
        tv2.setText(beans.toString());
    }

    /**
     * 将java对象转换为json对象
     */
    private void javaToJsonObjectByFastJson() {
        JsonStrBean bean = new JsonStrBean(1, "大虾", 12.3, "http://192.168.10.165:8080/L05_Server/images/f1.jpg");
        String json = JSON.toJSONString(bean);
        tv1.setText(bean.toString());
        tv2.setText(json);
    }

    /**
     * 将java集合转换为json数组
     */
    private void javaToJsonArrayByFastJson() {
        JsonArrayBean bean1 = new JsonArrayBean(1, "http://192.168.10.165:8080/L05_Server/images/f1.jpg", "大虾1", 12.3);
        JsonArrayBean bean2 = new JsonArrayBean(2, "http://192.168.10.165:8080/L05_Server/images/f2.jpg", "大虾2", 12.5);
        List<JsonArrayBean> beans = new ArrayList<>();
        beans.add(bean1);
        beans.add(bean2);
        String json = JSON.toJSONString(beans);
        tv1.setText(beans.toString());
        tv2.setText(json);
    }

    private void useFastJson(){
        String json = ReadAssetsUtil.getJson(this,"JsonCommon.json");
        JsonCommonBean bean = JSON.parseObject(json, JsonCommonBean.class);
        tv1.setText(json);
        tv2.setText("retcode = " + bean.getRetcode());
    }

}
