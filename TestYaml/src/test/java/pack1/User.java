package pack1;

import java.util.Map;

public class User {
	private String name;
	private int age;
	private Map<String, Object> address;
	//  private String[] rolls;
	private Map<String,Object> rolls;

	public Map<String, Object> getRolls() {
		return rolls;
	}
	public void setRolls(Map<String, Object> rolls) {
		this.rolls = rolls;
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
	public Map<String, Object> getAddress() {
		return address;
	}
	public void setAddress(Map<String, Object> address) {
		this.address = address;
	}
	//    public String[] getRolls() {
	//        return rolls;
	//    }
	//    public void setRolls(String[] rolls) {
	//        this.rolls = rolls;
	//}
}