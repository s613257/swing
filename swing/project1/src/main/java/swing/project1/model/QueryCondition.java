package swing.project1.model;

public class QueryCondition {

	int kind; // 0: 貓; 1:狗; 2:其他; 3:不限
	int sex; // 0: 公; 1:母; 2:不限
	int shelterIdx; // 收容所清單索引
	String shelterName;
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

	public String getShelterName() {
		return shelterName;
	}
	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}

	public String toWhereStatemant(){
		// TODO
		StringBuffer sb = new StringBuffer();
		boolean withCondition = false;
		if(kind < KindType.ALL.getValue()){
			withCondition = true;

		}

		if(sex < SexType.ALL.getValue()){
			withCondition = true;

		}

		if(shelterIdx > 0){ // Not 0(不限)
			withCondition = true;

		}
		sb.append(";");
		String resultStr = withCondition? (" WHERE " + sb.toString()):sb.toString();
		return resultStr;
	}

}

enum KindType{
	CAT(0), DOG(1), OTHER(2), ALL(3);
	private int value;
	KindType(int value){
		this.value = value;
	}
	public int getValue(){
		return this.value;
	}
}


enum SexType{
	Male(0), Female(1), ALL(2);
	private int value;
	SexType(int value){
		this.value = value;
	}
	public int getValue(){
		return this.value;
	}
}