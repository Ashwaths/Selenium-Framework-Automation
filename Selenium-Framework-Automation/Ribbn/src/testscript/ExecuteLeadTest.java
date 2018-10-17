package testscript;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExecuteLeadTest {
	
	static Keywords keyword;
	
	public static void main(String[] args) throws Exception {
		
			keyword = new Keywords();
			ArrayList data = new ArrayList();

			FileInputStream file = new FileInputStream(new File("/home/techl333t/eclipse-workspace/Ribbn/src/testcases/RibbnTC.xls"));
			org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(file);       //Create Workbook instance holding reference to .xlsx file
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);         //Get first/desired sheet from the workbook       
			Iterator<Row> rowIterator = sheet.iterator();      //Iterate through each rows one by one

			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();           //For each row, iterate through all the columns

				Iterator<Cell> cellIterator = row.cellIterator();   

				while (cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();

					switch (cell.getCellType())            //Check the cell type and format accordingly
					{
					case Cell.CELL_TYPE_NUMERIC:
						data.add(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						data.add(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						data.add(cell.getBooleanCellValue());
						break;
					}
					System.out.print("");
				}

			}
		
			for(int i=0;i<data.size();i++)
			{
				if(data.get(i).equals("openbrowser"))
				{
						
					String keywords = (String)data.get(i);
					String testdata = (String)data.get(i+1);
					String objectName = (String)data.get(i+2);
					System.out.println(keywords);
					System.out.println(testdata);
					System.out.println(objectName);
					keyword.openbrowser();
				}
			
		   if(data.get(i).equals("navigate"))
			{
			   
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);
				String objectName = (String)data.get(i+2);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				keyword.navigate(testdata);
				
			}
		   
			if(data.get(i).equals("input"))
			{
				
				
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);  
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.input(testdata, objectName, objectType);
			}	
			
			if(data.get(i).equals("ninput"))
			{
				
				
				String keywords = (String)data.get(i);
				Integer testdata = (Integer)data.get(i+1);  
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.print(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.ninput(testdata, objectName, objectType);
			}	
			
			if(data.get(i).equals("click"))
			{
				
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.click(objectName, objectType);
				}
		
			if(data.get(i).equals("select"))
			{
				
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.select(testdata, objectName, objectType);
		
		}
			
			if(data.get(i).equals("select1"))
			{
				
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.select1(testdata, objectName, objectType);
		
		}
			
			
			if(data.get(i).equals("select2"))
			{
				
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.select2(testdata, objectName, objectType);
		
		}
			
			
			if(data.get(i).equals("select3"))
			{
				
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.select3(testdata, objectName, objectType);
		
		}
			
			
			if(data.get(i).equals("check"))
			{
				
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.check(objectName, objectType);
		
		}
		
			if(data.get(i).equals("autosuggest"))
			{
				
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.autosuggest(testdata, objectName, objectType);
			
			}
			
			if(data.get(i).equals("upload"))
			{
				
				String keywords = (String)data.get(i);
				String testdata = (String)data.get(i+1);
				String objectName = (String)data.get(i+2);
				String objectType = (String)data.get(i+3);
				System.out.println(keywords);
				System.out.println(testdata);
				System.out.println(objectName);
				System.out.println(objectType);
				keyword.upload(testdata, objectName, objectType);
			
			}
			
			}}}