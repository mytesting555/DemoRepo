package Excel_Utils;

public class Excel_Utils_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Excel_Utils_Read excel=new Excel_Utils_Read();
		
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);
	}
	
}
