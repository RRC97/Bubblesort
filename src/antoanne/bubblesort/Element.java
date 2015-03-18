/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antoanne.bubblesort;

/**
 *
 * @author root
 */
public class Element
{
    private final int value;
    private Element prev = null;
    private Element next = null;
    
    public Element(int v)
    {
        value = v;
    }
    public Element(int v, Element p)
    {
        value = v;
        prev = p;
    }
    public Element(int v, Element p, Element n)
    {
        value = v;
        prev = p;
        next = n;
    }
    
    public void setPrevious(Element p)
    {
        prev = p;
    }
    
    public void setNext(Element n)
    {
        next = n;
    }
    
    public Element getPrevious()
    {
        return prev;
    }
    
    public Element getNext()
    {
        return next;
    }
    
    public int getValue()
    {
        return value;
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(value);
    }
}
