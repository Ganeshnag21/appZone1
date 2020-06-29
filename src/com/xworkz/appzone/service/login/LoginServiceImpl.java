package com.xworkz.appzone.service.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.appzone.dao.login.LoginDAO;
import com.xworkz.appzone.dto.LoginDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.login.LoginServiceException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO dao;

	//public static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	public LoginServiceImpl() {
		//logger.debug("created " + this.getClass().getSimpleName());
	}

	@Override
	public LoginDTO loginService(LoginDTO dto,HttpServletRequest req) throws LoginServiceException {

		try {
			
			//logger.info("Inside Login Service Method");
			LoginEntity entity = new LoginEntity();

			BeanUtils.copyProperties(dto, entity);
			System.out.println(dto);
			System.out.println(entity);
			LoginEntity entityFromDb = dao.loginDao(entity);
			System.out.println(entityFromDb);
			if (entityFromDb != null){
				BeanUtils.copyProperties(entityFromDb, dto);
				HttpSession session = req.getSession(false);
				session.setAttribute("userType", entityFromDb.getUserGroup());
			}
			else
				dto = null;
			return dto;
		} catch (Exception e) {
			throw new LoginServiceException(e.getMessage());
		}

	}

}
