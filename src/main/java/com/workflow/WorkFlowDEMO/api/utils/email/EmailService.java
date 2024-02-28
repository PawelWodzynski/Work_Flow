package com.workflow.WorkFlowDEMO.api.utils.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // this class has a task send mails to selected employees from with use smtp server whom will you find configure in application.properties

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        javaMailSender.send(message);
    }

    public String greetingSubjectForNewUsers(){
        return "Welcome to Work Flow! Discover a new dimension of efficiency and collaboration.";
    }

    public String resetPasswordRequestSubject(){
        return "Work Flow Reset Password Request: Your New Password Inside";
    }

    public String passwordBodyWarningMessage(){
        return "\n\n\n\nSecurity Alert: Immediate Action Required - Update Your Password Now Upon Login";
    }

    public String newUsernameSubject(){
        return "Work Flow : Your username has been updated successfully to -->";
    }
}
