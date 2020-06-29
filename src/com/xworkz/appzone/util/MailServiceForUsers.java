package com.xworkz.appzone.util;

import jsvs.util;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.xworkz.appzone.dto.ManageGroupDTO;
import com.xworkz.appzone.entity.creategroup.GroupEntity;
import com.xworkz.appzone.entity.login.LoginEntity;

@Component
public class MailServiceForUsers {
	@Autowired
	JavaMailSender mail;

	@Autowired
	SimpleMailMessage message;

	public void registerUsersForGroup(List<LoginEntity> validEmails, GroupEntity group) {

		ListIterator<LoginEntity> itr = validEmails.listIterator();

		while (itr.hasNext()) {
			LoginEntity entity = itr.next();
			message.setTo(entity.getEmail());
			message.setSubject("Invitoation for a Group in AppZone");
			message.setText("Hi "+entity.getUserName()+", \n We are glad to inform you that you are the part of the group "+group.getGroupName());
			mail.send(message);
			System.out.println("Mail sent Succefully");
		}
	}
}
