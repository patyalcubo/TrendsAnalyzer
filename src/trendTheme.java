import java.util.Comparator;

public class trendTheme implements Comparable<trendTheme> {

	private String name = null;
	private int value = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int compareTo(trendTheme o) {
		// TODO Auto-generated method stub
		if (this.getValue() <= o.getValue()) {
			return 0;
		}

		return -1;
	}

	@Override
	public String toString() {
		return "\n" + name + " , " + value ;
		
	}

}
