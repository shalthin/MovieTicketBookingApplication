package movieTicketBooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import movieTicketBooking.model.request.UserDetailsRequestModel;
import movieTicketBooking.model.response.UserDetailsRequestResponse;
import movieTicketBooking.service.UserService;
import movieTicketBooking.vo.UserVo;

/**
 * This class is used for user creation and also get the user details
 * 
 * @author Shalini
 *
 */
@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public UserDetailsRequestResponse createUSer(@RequestBody UserDetailsRequestModel userDetails) {

		UserDetailsRequestResponse returnValue = new UserDetailsRequestResponse();

		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(userDetails, userVo);

		UserVo createUser = userService.createUser(userVo);
		 BeanUtils.copyProperties(createUser, returnValue);
		 return returnValue;


	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<UserDetailsRequestResponse> getUsers() {

		List<UserDetailsRequestResponse> returnValueList = new ArrayList<>();
		UserDetailsRequestResponse returnValue = new UserDetailsRequestResponse();

		List<UserVo> users = userService.getUsers();

		for (UserVo userVo : users) {
			BeanUtils.copyProperties(userVo, returnValue);
			returnValueList.add(returnValue);
		}

		return returnValueList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
	public UserDetailsRequestResponse getUser(@PathVariable Long userId) {

		UserDetailsRequestResponse returnValue = new UserDetailsRequestResponse();

		UserVo userVo = userService.getUserByUserId(userId);
		BeanUtils.copyProperties(userVo, returnValue);

		return returnValue;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
	public UserDetailsRequestResponse updateUser(@PathVariable Long userId, @RequestBody UserDetailsRequestModel userDetails) {

		UserDetailsRequestResponse returnValue = new UserDetailsRequestResponse();

		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(userDetails, userVo);

		UserVo updateUser = userService.updateUser(userId, userVo);
		BeanUtils.copyProperties(updateUser, returnValue);

		return returnValue;
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
	public UserDetailsRequestResponse deleteUser(@PathVariable Long userId) {

		UserDetailsRequestResponse returnValue = new UserDetailsRequestResponse();

		userService.deleteUser(userId);
		return returnValue;
	}
}
