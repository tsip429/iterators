package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Power {
	int base;
	int maxExp;

	public Iterator<Integer> iterator() {
		return new PowerIterator();
	}
	private class PowerIterator implements Iterator<Integer> {
		int numCalled = 0;

		public boolean hasNext() {
			return numCalled <= maxExp;
		}

		public Integer next() throws NoSuchElementException {
			int result = base;
			if (hasNext()) {
				numCalled++;
				for (int i = 2; i <= numCalled; i++) {
					result = result * base;
				}
			}
			else{
				throw new NoSuchElementException();
			}
			return result;
		}
	}

	public Power(int base, int maxExponent) {
		this.base = base;
		maxExp = maxExponent;
	}

	public String toString() {
		String powers = "";
		PowerIterator newPowerIterator = new PowerIterator();
		for (int i = 0; i < maxExp - 1; i++) {
			powers += newPowerIterator.next() + " ";
		}
		powers += newPowerIterator.next();
		return powers;
	}

	public static void main(String args[]) {
		Power f= new Power(10, 3);
		Power g= new Power(2, 5);
		Power h= new Power(3, 4);
		Iterator<Integer> iter= f.iterator();


		System.out.println(iter.next());  // should print 10^1
		System.out.println(iter.next());  // should print 10^2
		System.out.println(iter.next());  // should print 10^3
		 

		System.out.println("\n" + g);  // calls toString() on g
		System.out.println("\n" + h);  // calls toString() on h
	}

}
