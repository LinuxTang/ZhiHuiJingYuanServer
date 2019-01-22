package pojo;

public class User {
	private Integer sno;
	private String password;
	private String name;
	private String sex;
	private int age;
	private String college;
	private String senior;
	private String hobby;
	private String character;
	private String background_url;
	private String photo_url;
	private int tsflag;
	private String tel;

	public User() {
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getSenior() {
		return senior;
	}

	public void setSenior(String senior) {
		this.senior = senior;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getBackground_url() {
		return background_url;
	}

	public void setBackground_url(String background_url) {
		this.background_url = background_url;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public int getTsflag() {
		return tsflag;
	}

	public void setTsflag(int tsflag) {
		this.tsflag = tsflag;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User{" +
				"sno=" + sno +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", age=" + age +
				", college='" + college + '\'' +
				", senior='" + senior + '\'' +
				", hobby='" + hobby + '\'' +
				", character='" + character + '\'' +
				", background_url='" + background_url + '\'' +
				", photo_url='" + photo_url + '\'' +
				", tsflag=" + tsflag +
				", tel='" + tel + '\'' +
				'}';
	}
}
