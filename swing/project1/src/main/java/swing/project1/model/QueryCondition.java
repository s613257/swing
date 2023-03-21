package swing.project1.model;

public class QueryCondition {
	int kind; // 0: 貓; 1:狗; 2:其他; 3:不限
	int sex; // 0: 公; 1:母; 2:不限
	int shelterIdx; // 收容所清單索引
	public QueryCondition(){
		
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getShelterIdx() {
		return shelterIdx;
	}
	public void setShelterIdx(int shelterIdx) {
		this.shelterIdx = shelterIdx;
	}
	
}
