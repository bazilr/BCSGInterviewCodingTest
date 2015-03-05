package utility;

public class ConvertMonthToIntger {
	enum MonthEnum {
		JAN(1), FEB(2), MAR(3), APR(4), MAY(5), JUN(6), JUL(7), AUG(8), SEP(9), OCT(10), NOV(11), DEC(12);
		private int  id;

		  MonthEnum(int id) {
		    this.id = id;
		  }  
		  
		public int getId() {
			return id;
		}
	}
	
	
		  public static void main(String[] args) {
		      System.out.println(MonthEnum.valueOf("JAN").getId());
		      System.out.println(MonthEnum.valueOf("FEB").getId());
		  }
		
}


