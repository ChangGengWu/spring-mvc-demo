package com.springdemo.mvc;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.Base64Utils;
@Controller
public class ImgController {

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public String upload(@RequestParam CommonsMultipartFile file, HttpSession session, Model model) {
		String path = session.getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();

		System.out.println(path + " " + filename);
		try {
			byte barr[] = file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			System.out.println(bout);
			bout.write(barr);
			bout.flush();
			bout.close();
			System.out.println(barr);
			System.out.println(bout);
			String encodedText = Base64Utils.encodeToString(barr);
			System.out.println(encodedText);
			FileWriter fw = new FileWriter("D:\\gg.txt", true);
			fw.write(encodedText);
			model.addAttribute("filename",encodedText);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "upload-success";
	}
}
