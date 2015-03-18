package antoanne.bubblesort;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity
{
    private String[] arrayString;
    private List list;
    private ListAdapter adpter;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        list = new List();
        
        ListView listView = (ListView)findViewById(R.id.list);
        ListAdapter adpter = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, list.toArray());
        listView.setAdapter(adpter);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem menu)
    {
        
        switch(menu.getItemId())
        {
            case R.id.addList: addElementInList(); break;
            case R.id.bubbleList: bubbleInList(); break;
        }
        
        return super.onOptionsItemSelected(menu);
    }
    
    public void refresh()
    {
        ListView listView = (ListView)findViewById(R.id.list);
        ListAdapter adpter = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, list.toArray());
        listView.setAdapter(adpter);
    }
    
    public void bubbleInList()
    {
        for(int i = 0; i < list.getCount(); i++)
        {
            for(int j = 0; j < list.getCount(); j++)
            {
                Element a = list.get(i);
                Element b = list.get(j);
                if(a.getValue() < b.getValue())
                {
                    Element temp = a;
                    list.set(i, b.getValue());
                    list.set(j, temp.getValue());
                }
            }
        }
        refresh();
    }
    
    public void addElementInList()
    {
        list.add((int)(Math.random() * 100));
        refresh();
    }
    
}
