package ru.se_nata.SendEmailAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EmailController {
	@Autowired
	private EmailService service;
	
	
     @PostMapping(path="/sendmail",consumes = "application/x-www-form-urlencoded")
	public ResponseEntity <?> sendEmail(@RequestBody MultiValueMap frequest) {

		EmailRequest req = new EmailRequest();
		req.setFirstName((String)frequest.getFirst("firstName"));
		req.setLastName((String)frequest.getFirst("lastName"));
		req.setPhone((String)frequest.getFirst("tel"));
		req.setEmail((String)frequest.getFirst("email"));
		req.setMessage((String)frequest.getFirst("message"));
	
		boolean result=this.service.sendmail(req.getTo(), req.getSubject(), req.getMessage());
		if(result)
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
		    return	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email sending fail");
		}
	}
}
