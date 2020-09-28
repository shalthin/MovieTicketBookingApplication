package movieTicketBooking.service;

import java.util.List;


import movieTicketBooking.vo.UserVo;

public interface UserService {
	UserVo createUser(UserVo user);
	UserVo getUserByUserId(Long userId);
	UserVo updateUser(Long userId, UserVo user);
	void deleteUser(Long userId);
	List<UserVo> getUsers();
}
