package ru.se_nata.SendEmailAPI;


public class EmailRequest{
	
	private String  to= new String("example@mail.ru");
	private String subject="test email attachment";
	private String message;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return "  from: "+firstName+" "+lastName+ "\r\n  email: "+ email + "\r\n  phone: "+ phone + "\r\n\r\nmessage:\r\n  "+ message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EmailRequest [to=" + to + ", subject=" + subject + ", message=" + message + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + "]";
	}

	

	
	
	
	

}
