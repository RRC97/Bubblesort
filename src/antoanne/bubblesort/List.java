/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antoanne.bubblesort;

import android.util.Log;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class List
{
    private Element first = null;
    private Element last = null;
    
    public void add(int value)
    {
        if(first == null)
        {
            first = new Element(value);
        }
        else if(last == null)
        {
            last = new Element(value, first);
            first.setNext(last);
        }
        else
        {
            Element lastNow = new Element(value, last);
            last.setNext(lastNow);
            last = lastNow;
        }
    }
    
    public Object[] toArray()
    {
        ArrayList<Element> elements = new ArrayList<Element>();
        Element element = first;
        while(element != null)
        {
            elements.add(element);
            element = element.getNext();
        }
        
        return elements.toArray();
    }
    public Element get(int index)
    {
        if(index < getCount() && index >= 0)
        {
            Element element = first;
            for(int i = 0; i < index; i++)
            {
                element = element.getNext();
            }
            return element;
        }
        
        return null;
    }
    
    public int getCount()
    {
        int count = 0;
        Element element = first;
        while(element != null)
        {
            count++;
            element = element.getNext();
        }
        return count;
    }
    
    public void set(int index, int value)
    {
        if(index < getCount() && index >= 0)
        {
            Element prev = get(index - 1);
            Element next = get(index + 1);

            if(prev != null && next != null)
            {
                Element result = new Element(value, prev, next);
                prev.setNext(result);
                next.setPrevious(result);
            }
            else if(prev == null)
            {
                Element result = new Element(value);
                result.setNext(next);
                next.setPrevious(result);
                first = result;
            }
            else if(next == null)
            {
                Element result = new Element(value, prev);
                prev.setNext(result);
                last = result;
            }
        }
    }
}
