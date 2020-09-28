package movieTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import movieTicketBooking.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);

	/**
	 * @param email
	 * @return
	 */
	UserEntity findByEmail(String email);
	UserEntity findByID(Long userID);
}
