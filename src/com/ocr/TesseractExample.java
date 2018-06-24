package com.ocr;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

import javax.imageio.ImageIO;

import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.RendererException;
import org.ghost4j.renderer.SimpleRenderer;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;
import net.sourceforge.lept4j.Pix;
import net.sourceforge.lept4j.Pixa;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.load("D:\\ImageMagick\\jmagick\\jmagick.dll");
		//File file=new File("C:\\Users\\hp\\Desktop\\portrait_practice\\simple.jpg");
		File file=new File("C:\\Users\\hp\\Desktop\\portrait_practice\\air.pdf");
		ITesseract it =new Tesseract();
		
		try {
			String extractedText=it.doOCR(file);
			System.out.println(extractedText);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		BufferedImage tif;
		try {
		 * using jai not done
			tif = ImageIO.read(new File("C:\\Users\\hp\\Desktop\\portrait_practice\\vodafonebill.pdf"));
			 ImageIO.write(tif, "png", new File("C:\\Users\\hp\\Desktop\\portrait_practice\\vodafone1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
		//imageio not working 32 bit dll not working with 64 bit dll
		
		 PDFDocument document = new PDFDocument();
		    try {
				document.load(new File("C:\\Users\\hp\\Desktop\\portrait_practice\\vodafonebill.pdf"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		    SimpleRenderer renderer = new SimpleRenderer();

		    // set resolution (in DPI)
		    renderer.setResolution(300);
		    List<Image> images =null;
		    try {
				images = renderer.render(document);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RendererException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		    for (int i = 0; i < images.size(); i++) {
                try {
					ImageIO.write((RenderedImage) images.get(i), "png", new File((i + 1) + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

		String s;
		try {
			
			s = it.doOCR(file);
			System.out.println(s);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/* Runtime rt = Runtime.getRuntime();
		 String command = "cmd /c start cmd.exe";
		  

		 try {
			 
			  
			//rt.exec("convert C:\\Users\\hp\\Desktop\\portrait_practice\\sanskrit.jpg C:\\Users\\hp\\Desktop\\portrait_practice\\sanskriti1.png");
			rt.exec("cmd.exe /c cd \""+"C:\\Users\\hp\\Desktop\\portrait_practice\\"+"\" & start cmd.exe /k \"convert sanskrit.jpg sanskriti1.png \"");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
		/*try {
		    // Execute command
		    String command = "cmd /c cd C:\\Users\\hp\\Desktop\\portrait_practice\\";
		    Process child = Runtime.getRuntime().exec(command);

		    // Get output stream to write from it
		    OutputStream out = child.getOutputStream();


		    out.write("convert sanskrit.jpg sanskriti156.png  /r/n".getBytes());
		    out.close();
		} catch (IOException e) {
		}*/
		
	}

}
