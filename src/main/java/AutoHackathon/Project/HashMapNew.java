package AutoHackathon.Project;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	
		public class HashMapNew extends HashMap<String,String>{
			static final long serialVersionUID = 1L;

			@Override
			public String get(Object key){
				String value = super.get(key);
				if (value==null){return "";}
				return value;
			}
		}
	

