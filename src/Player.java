

public class Player implements Comparable<Player> {
	
    private int ranking;
    private String name;
    private int age;
	public Player(String nm, int ag, int rank) {
		ranking=rank;
		name=nm;
		age=ag;
	}

	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [ranking=" + ranking + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Player o) {
		if (this.ranking!=o.ranking)
			return this.ranking - o.ranking;
		else
			return this.age - o.age;
	}
}
