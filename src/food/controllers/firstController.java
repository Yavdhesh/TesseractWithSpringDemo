package food.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import food.dto.ResponseDTO;
import food.services.TesseractService;

@Controller
public class firstController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		ModelAndView mnv = new ModelAndView("app");
		mnv.addObject("variable", "Finally,It worked.");
		Logger.getLogger("this").info("I came inside");
		return mnv;
	}

	@RequestMapping("/form")
	public ModelAndView dataMapping() {

		return new ModelAndView();

	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody
	ResponseDTO uploadFileHandler(@RequestParam("name") MultipartFile name,
			@RequestParam("file") MultipartFile file) {
		System.out.println(file);
		System.out.println(file.getName());
		System.out.println(file.getContentType());
		System.out.println(name);
		System.out.println(name.getName());
		System.out.println(name.getContentType());
		try {
			System.out.println(name.getInputStream());
			System.out.println(file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file.getSize());
		System.out.println();
		
		TesseractService tess=new TesseractService();
		try {
			tess.doOCR(name.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new ResponseDTO();
	}

}
