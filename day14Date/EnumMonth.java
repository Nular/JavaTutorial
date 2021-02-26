package day14Date;

public enum EnumMonth {
	JAN(MonthType.BIG),
	FEB(MonthType.SPECIAL),
	MAR(MonthType.BIG),
	APR(MonthType.LITTLE),
	MAY(MonthType.BIG),
	JUN(MonthType.LITTLE),
	JUL(MonthType.BIG),
	AUG(MonthType.BIG),
	SEP(MonthType.LITTLE),
	OCT(MonthType.BIG),
	NOV(MonthType.LITTLE),
	DEC(MonthType.BIG);
	
	private EnumMonth(MonthType type) {
		this.type = type;
	}
	private MonthType type;
	
	public MonthType getType() {
		return type;
	}
	
	private enum MonthType {
		BIG {
			@Override
			int dayOfYear(int year) {
				return 31;
			}
		},
		SPECIAL {
			@Override
			int dayOfYear(int year) {
				// 判断闰年
				return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
						? 29 : 28;
			}
		},
		LITTLE {
			@Override
			int dayOfYear(int year) {
				return 30;
			}
		};
		
		abstract int dayOfYear(int year);
	}
}
