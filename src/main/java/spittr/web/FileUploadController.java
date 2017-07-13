package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.FilterRegistration;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class FileUploadController {

	@RequestMapping(method = GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(method = POST)
	public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture, String firstName)
			throws IllegalStateException, IOException {
		System.out.println("fistName: " + firstName);
		System.out.println("profilePicture.isEmpty() " + profilePicture.isEmpty());
		System.out.println("profilePicture.getName(): " + profilePicture.getName());
		System.out.println("profilePicture.getOriginalFilename() " + profilePicture.getOriginalFilename());
		System.out.println("profilePicture.getContentType(): " + profilePicture.getContentType());
		System.out.println("profilePicture.getSize() " + profilePicture.getSize());
		System.out.println("profilePicture.getBytes(): " + profilePicture.getBytes());
		profilePicture.transferTo(new File("D:/d/data/temp/profile_picture/" + profilePicture.getOriginalFilename()));
		return "successfully_uploaded_check_terminal";
	}

}
