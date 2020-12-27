package domain;

import java.util.Comparator;

public class ScoresVanHoogNaarLaagComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer arg0, Integer arg1) {
		return -arg0.compareTo(arg1);
	}

}
