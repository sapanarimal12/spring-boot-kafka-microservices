package com.sapana.unitTesting;

import com.sapana.unitTesting.model.User;
import com.sapana.unitTesting.repo.UserRepository;
import com.sapana.unitTesting.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("User Service Test Suite")
class UnitTestingApplicationTests {


	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@BeforeEach
	void setUp() {
		// Create a mock instance of UserRepository
		MockitoAnnotations.openMocks(this);

		// Inject the mock into the service
//		userService = new UserService(userRepository);
	}

	@Test
	@DisplayName("Should return user when user ID exists")
	public void testGetUserById() {
		// Arrange: Create a mock User object
		User mockUser = new User(1L, "John Doe", "john.doe@example.com");

		// Define behavior: When findById is called with 1L, return the mockUser
		when(userRepository.findById(1L)).thenReturn(mockUser);

		// Act: Call the method to test
		User result = userService.getUserById(1L);

		// Assert: Verify the result
		assertEquals(1L, result.getId());
		assertEquals("John Doe", result.getName());
		assertEquals("john.doe@example.com", result.getEmail());
	}

}
