package food.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;

import food.dto.ResponseDTO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractService {
	static {
    	// System.setProperty("jna.library.path", "C:\\Users\\hp\\workspace\\BookMyFood\\lib\\win32-x86\\");
    	// System.setProperty("jna.library.path", "C:\\Users\\hp\\workspace\\BookMyFood\\lib\\win32-x86-64\\");
    	 
     }
	
	public ResponseDTO doOCR(InputStream is){
		/*JarClassLoader jcl = new JarClassLoader();
		//jcl.add("myjar.jar"); // Load jar file  
		//jcl.add(new URL("http://myserver.com/myjar.jar")); // Load jar from a URL
		//jcl.add(new FileInputStream("myotherjar.jar")); // Load jar file from stream
		//jcl.add("myclassfolder/"); // Load class folder  
		jcl.add("D:/jarFolder/"); // Recursively load all jar files in the folder/sub-folder(s)

		JclObjectFactory factory = JclObjectFactory.getInstance();*/
		// Create object of loaded class  
		//Object obj = factory.create(jcl, "com.sun.jna.Pointer");
		
		File temp=null;
		File directory=new File("D:/TempJava/");
		if(!directory.exists()){
			directory.mkdirs();
		}
        
		
	    try {
			//temp = File.createTempFile("temp", Long.toString(System.nanoTime()));
			temp=File.createTempFile("temp", ".pdf",directory );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    OutputStream ou=null;
	    try {
			ou= new FileOutputStream(temp);
			IOUtils.copy(is, ou);
			
			ou.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    Tesseract t=new Tesseract();
	    String reult=null;
	    try {
		 reult=t.doOCR(temp);
		 System.out.println(reult);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    String bill_Number_Regex="\\b[aA][iI][rR][tT][eE][lL][\\s]*?[nN][uU][mM][bB][eE][rR][\\s:]*?(\\w+)\\b";
		String bill_date_regex="\\b[bB][iI][lL][lL][\\s]*?[dD][aA][tT][eE][\\s:]*?(\\d+.+\\d+)\\b";
		String regex_GST="\\b[gG][sS][tT][\\s]*?[Nn][oO][\\s]*?[\\/]?[oO]?[rR]?[uU][iI][dD][\\s]*?[nN][oO][\\s:]*(\\w*)";
		String billAmountRegex= "\\b[aA][mM][oO][uU][nN][tT][\\s]*?[dD][uU][eE][\\s:](\\d{1,3}(,\\d{3})*(\\.\\d+)?)\\b";
		
		String regexArray[]=new String[]{bill_Number_Regex,bill_date_regex,regex_GST,billAmountRegex};
		
	
		HashMap<String, Object> outMap=new HashMap<>();
		
		for (int i = 0; i < regexArray.length; i++) {
			Pattern pattern = Pattern.compile(regexArray[i]);
			Matcher matcher = pattern.matcher(reult);

			while (matcher.find()) {
			    System.out.println("Full match: " + matcher.group(0));
			    String values=matcher.group(1);
			    System.out.println(values);
			    outMap.put(values, values);
			    break;
			}
			
				
		}

		ResponseDTO responseDTO = new ResponseDTO();
		
		return null;
		
	}

}
