package vishnugt.spider2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.util.TypedValue;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent = getIntent();
        String value = intent.getStringExtra("key");
        String fonts = intent.getStringExtra("fontchosen");
        String font_color = intent.getStringExtra("colors");
        Integer font_size = Integer.parseInt(intent.getStringExtra("fontsize"));
        TextView tv = (TextView) findViewById(R.id.textView1);
     	tv.setText(Html.fromHtml(value));
     	tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, font_size);
     	tv.setTextColor(Color.parseColor(font_color));
     	String temp = "fonts/" + fonts + ".ttf";
     	Typeface tf = Typeface.createFromAsset(getAssets(),temp);
     	tv.setTypeface(tf);
    }


    
}
