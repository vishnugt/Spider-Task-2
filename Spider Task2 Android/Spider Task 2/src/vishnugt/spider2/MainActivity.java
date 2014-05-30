package vishnugt.spider2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener{

    NumberPicker np;
    Spinner dropdown;
    String chosenfont;
    String[] items = new String[]{"Ala Carte", "All Caps", "Alpha Flight", "AlphaMack AOE", "Beyond Wonderland", "firstv2s", "HOGWARTS_OUTLINE", "Jellyka_Castle's_Queen", "nightsky", "Sasquatch"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        np = (NumberPicker) findViewById(R.id.numberPicker1);
        np.setMaxValue(99);
        np.setMinValue(10);
        np.setValue(50);
        dropdown = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
    }

    public int bold=0;
    public int ul=0;
    public int italic=0;
    public int size=22;
    
    public void btnclick(View v)
    {

    	bold=0;
    	italic=0;
    	ul=0;
    	CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox1);
    	CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
    	CheckBox checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        if(checkBox.isChecked())
        {
        	bold=1;
        }
        if(checkBox2.isChecked())
        {
        	italic=1;
        }
        if(checkBox3.isChecked())
        {
        	ul=1;
        }
        String setcolor="black";
        EditText etext = (EditText)findViewById(R.id.editText1);
        EditText etext2 = (EditText)findViewById(R.id.editText2);
        String text2 = etext2.getText().toString();
    	String text = etext.getText().toString();
    	etext2.setText("black");
    	String[] colors = new String[] {"red", "blue", "green", "black", "white", "gray", "cyan", "magenta", "yellow", "lightgray", "darkgray"};
    	setcolor="";

    	if(text.matches(""))
    	{
    		Toast.makeText(this, "Dude! Type Something!!", Toast.LENGTH_SHORT).show();
    	    return;
    	}
    	for(int i=0;i<11;i++)
    	{
    		if(text2.equalsIgnoreCase(colors[i]))
    		{
    			setcolor=colors[i];
    		}
    	}
    	if(setcolor=="")
    		{
    			setcolor="black";
    			if(!text2.matches(""))
    			Toast.makeText(this, "Sorry, but the available colors are Red, blue, green, black, white, gray, cyan, magenta, yellow, lightgray, darkgray.  ", Toast.LENGTH_LONG).show();
    			else
    			{
    				Toast.makeText(this, "By default it will be black in color  ", Toast.LENGTH_LONG).show();
            	    
    			}
    			
    		}
    	
    	if(ul==0)
    	{
    		if(bold==1 && italic==1)
    		{
    		text="<b><i>" + text + "</i></b>";
    		}
    		if(bold==1 && italic==0)
    		{
    			text="<b>" + text + "</b>";
    		}
    		if(bold==0 && italic==1)
    		{
    		text="<i>" + text + "</i>";
    		}
    	}
    	if(ul==1)
    	{

        	if(bold==1 && italic==1)
            {
            text="<b><i><u>" + text + "</u></i></b>";
            }
        	if(bold==1 && italic==0)
            {
            text="<b><u>" + text + "</u></b>";
            }
        	if(bold==0 && italic==1)
            {
            text="<i><u>" + text + "</u></i>";
            }	
    	}

    	//String.valueOf(np.getValue())
    	//text = "<p><font size ="80"></p>" + text + " <\font>";
    	Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
    	myIntent.putExtra("key", text); 
    	myIntent.putExtra("fontsize",String.valueOf(np.getValue()));
    	myIntent.putExtra("colors", setcolor);
    	myIntent.putExtra("fontchosen", chosenfont);
    	MainActivity.this.startActivity(myIntent);
    }
 
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) 
    {

    	chosenfont = items[position];

        }

    
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}