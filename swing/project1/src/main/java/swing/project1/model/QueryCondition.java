package swing.project1.model;

public class QueryCondition {

	int kind; // 0: 貓; 1:狗; 2:其他; 3:不限
	int sex; // 0: 公; 1:母; 2:不限
	int shelterIdx; // 收容所清單索引
	String shelterName;

	public QueryCondition() {
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

	public String toWhereStatemant() {
		// TODO
		StringBuffer sb = new StringBuffer();
		boolean withCondition = false;
		if (kind < KindType.ALL.getValue()) {
			withCondition = true;
			switch (KindType.values()[kind]) {
			case CAT:
				sb.append("animal_kind = '貓'");
				break;
			case DOG:
				sb.append("animal_kind = '狗'");
				break;
			case OTHER:
				sb.append("animal_kind = '其他'");
				break;
			default:
				break;
			}
		}

		if (sex < SexType.ALL.getValue()) {
			if (withCondition) {
				sb.append(" AND ");
			} else {
				withCondition = true;
			}
			switch (SexType.values()[sex]) {
			case Male:
				sb.append("animal_sex = 'M'");
				break;
			case Female:
				sb.append("animal_sex = 'F'");
				break;
			default:
				break;
			}

		}

		if (shelterIdx > 0) { // Not 0(不限)
			if (withCondition) {
				sb.append(" AND ");
			} else {
				withCondition = true;
			}
			sb.append(String.format("shelter_name = '%s'", this.shelterName));
		}
		sb.append(";");
		String resultStr = withCondition ? (" WHERE " + sb.toString()) : sb.toString();
		return resultStr;
	}

}

enum KindType {
	CAT(0, "貓"), DOG(1, "狗"), OTHER(2, "其他"), ALL(3, "不限");

	private int value;
	private String name;

	KindType(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return this.value;
	}

	public String getName() {
		return this.name;
	}
}

enum SexType {
	// TODO
	Male(0,"M"), Female(1,"F"), ALL(2,"不限");

	private int value;
	private String sex;

	SexType(int value, String sex) {
		this.value = value;
		this.sex = sex;
	}

	public int getValue() {
		return this.value;
	}
	public String getSex() {
		return this.sex;
	}
}
