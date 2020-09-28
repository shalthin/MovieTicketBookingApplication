package movieTicketBooking.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import movieTicketBooking.entity.UserEntity;
import movieTicketBooking.entity.Utils;
import movieTicketBooking.repository.UserRepository;
import movieTicketBooking.vo.UserVo;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * Logger initialization
	 */
	org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * Create user method
	 */

	@Override
	public UserVo createUser(UserVo user) {
		
		logger.info("UserService -> createUser(user) method is called. Checking database for existing user details");

		if (userRepository.findByEmail(user.getEmail()) != null) {

			logger.error("Error! Record already exists.");

			throw new RuntimeException("Record already exists!");
		}

		logger.info("Creating new user");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		String publicUserId = utils.generateUserId(30);
		userEntity.setUserId(Integer.valueOf(publicUserId));

		logger.info("Saving the user to the database -> users");

		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserVo returnValue = new UserVo();
		BeanUtils.copyProperties(storedUserDetails, returnValue);

		logger.info("Returning the user details to the UserController via UserVo object");
		
		return returnValue;

	}

	
	@Override
	public UserVo getUserByUserId(Long userId) {
		logger.info("UserService -> getUserByUserId(userId) method is called. Finding the user");

		UserVo returnValue = new UserVo();
		UserEntity userEntity = userRepository.findByID(userId);

		if (userEntity == null) {

			logger.error("Can't find the user name from the database");

			throw new UsernameNotFoundException(userEntity.getUserName());
		}
		BeanUtils.copyProperties(userEntity, returnValue);

		logger.info("User details found. Returning the user to the UserController via UserVo object");

		return returnValue;
	}

	@Override
	public UserVo updateUser(Long userId, UserVo user) {
		logger.info("UserService -> updateUser(userId, user) method is called. Finding the user");

		UserVo returnValue = new UserVo();

		UserEntity userEntity = userRepository.findByID(userId);

		if (userEntity == null) {

			logger.error("Can't find the user name from the database");

			throw new UsernameNotFoundException(userEntity.getUserName());
		}

		logger.info("User details found. Updating user details");
		
		userEntity.setMobileNo(user.getMobileNo());

		logger.info("Saving updated details to the database -> users");
		
		UserEntity updatedUserDetails = userRepository.save(userEntity);
		BeanUtils.copyProperties(updatedUserDetails, returnValue);

		logger.info("Returning the user to the UserController via UserVo object");
		
		return returnValue;

	}

	@Override
	public void deleteUser(Long userId) {
		logger.info("UserService -> deleteUser(userId) method is called. Finding the user");

		UserEntity userEntity = userRepository.findByID(userId);

		if (userEntity == null) {
			
			logger.error("Can't find the user name from the database");
			
			throw new UsernameNotFoundException(userEntity.getUserName());
		}

		logger.info("User details found. Deleting the user from the database -> users");
		
		userRepository.delete(userEntity);

		
	}

	@Override
	public List<UserVo> getUsers() {
logger.info("UserService -> getUsers() method is called. Collection all users details");
		
		List<UserVo> returnValue = new ArrayList<>();

		Iterable<UserEntity> iterableObjects = userRepository.findAll();

		for (UserEntity userEntity : iterableObjects) {
			UserVo userVo = new UserVo();
			BeanUtils.copyProperties(userEntity, userVo);
			returnValue.add(userVo);
		}

		logger.info("Users' details found. Returning users to the UserController via List<UserVo>");
		
		return returnValue;
	}

}
