package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Picture {

	public Shape[] shapes;
	private int numShapes;

	public Iterator<Shape> iterator() {
		return new ShapesIterator();
	}
	private class ShapesIterator implements Iterator<Shape> {
		int pos = 0; // keeps track of position
		boolean remove = false;

		public boolean hasNext() {
			boolean next = true;
			if (numShapes == 0 || pos >= numShapes) {
				next = false;
			}
			return next;
		}
		public Shape next() throws NoSuchElementException {
			if (pos > numShapes || !(hasNext())) {
				throw new NoSuchElementException();
			}
			remove = true;
			return shapes[pos++];
		}

		public void remove() throws IllegalStateException {
			int i = 0;
			if (!remove) {
				throw new IllegalStateException();
			}
			else{
				remove = false;
					for (i = pos - 1; i < numShapes - 1; i++) {
						shapes[i] = shapes[i + 1];
					}
					shapes[i] = null;
					numShapes--;
					pos--;
			}
		}
	}
	public Picture(int capacity) {
		shapes= new Shape[capacity];
		numShapes= 0;
	}

	// just do nothing if the picture is full (number of shapes == capacity)
	public void addShape(Shape newShape) {
		if (numShapes < shapes.length)
			shapes[numShapes++]= newShape;
	}

}
