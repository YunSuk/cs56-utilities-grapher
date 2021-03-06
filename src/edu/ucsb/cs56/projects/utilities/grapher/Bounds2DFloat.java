package edu.ucsb.cs56.projects.utilities.grapher;
import java.util.ArrayList;
import java.awt.event.*;

/**
   A class reprenting a rectangular boundary. This boundary is the boundary of the screen displayed by the GUI.
   @author Hanqing Wang
   @author Alexander Bauer
   @version CS56, F16
   @author Ryan Halbrook
   @version CS56, S13, Project
 */
public class Bounds2DFloat {
    private float xMin = 0.0f;
    private float xMax = 0.0f;
    private float yMin = 0.0f;
    private float yMax = 0.0f;
    
    private ArrayList<ActionListener> listeners;

    /**
       Start sending action events to an object.
       @param listener the object that will now recieve events.
     */
    public void addActionListener(ActionListener listener) {
	listeners.add(listener);
    }

    /**
       Constructs a new object with default bounds.
     */
    public Bounds2DFloat() {
	listeners = new ArrayList<ActionListener>();
    };

    /**
       Scale the bounds in both directions.
       @param factor the factor to scale the bounds.
     */
    public void scale(float factor) {
        float width=xMax-xMin;
        float height=yMax-yMin;
        float translationFactor=(1.0f/factor-1.0f)/2;
        xMin-=translationFactor*(width);
        xMax+=translationFactor*(width);
        yMin-=translationFactor*(height);
        yMax+=translationFactor*(height);
	sendEvents();
    }

    /**
       Translates the bounds
       @param x the number of units to translate the bounds in the x direction.
       @param y the number of untis to translate the bounds in the y direction.
    */
    public void translate(double x, double y) {
	xMin += x;
	xMax += x;
	yMin += y;
	yMax += y;
	sendEvents();
    }

    /**
       Constructs a new object with the given values.
       @param xMin the lower boundary on the x coordinate.
       @param yMin the lower boundary on the y coordinate.
       @param xMax the upper boundary on the x coordinate.
       @param yMax the upper boundary on the y coordinate.
     */
    public Bounds2DFloat(float xMin,float yMin,float xMax,float yMax) {
	listeners = new ArrayList<ActionListener>();
	this.xMin = xMin;
	this.xMax = xMax;
	this.yMin = yMin;
	this.yMax = yMax;
    }

    /**
       Sends events to all action listeners.
     */
    public void sendEvents() {
	for (ActionListener l : listeners) {
	    l.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_FIRST, "BoundsChanged"));
	}
    }

    /** Getter for xMin
	@return the lower boundary on the x coordinate. */
    public float getXMin() { return xMin; }
    /** Getter for yMin
	@return the lower boundary on the y coordinate. */
    public float getYMin() { return yMin; }
    /** Getter for xMax
	@return the upper boundary on the x coordinate. */
    public float getXMax() { return xMax; }
    /** Getter for yMax
	@return the upper boundary on the y coordinate. */
    public float getYMax() { return yMax; }

    /** Setter for xMin
	@param m the lower boundary on the x coordinate. */
    public void setXMin(float m) { xMin = m; sendEvents(); };
    /** Setter for xMin
        @param m  the lower boundary on the y coordinate. */
    public void setYMin(float m) { yMin = m; sendEvents(); };
    /** Setter for xMin
	@param m the upper boundary on the x coordinate. */
    public void setXMax(float m) { xMax = m; sendEvents(); };
    /** Setter for xMin
	@param m the upper boundary on the y coordinate. */
    public void setYMax(float m) { yMax = m; sendEvents(); };

}
