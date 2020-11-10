package demo;

public class DTOStudent {
	private int number;
	private String name;
	private int kor;
	private int mat;
	private int eng;
	
	public DTOStudent() {
		
	}

	public DTOStudent(int number, String name, int kor, int mat, int eng) {
		super();
		this.number = number;
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
}
