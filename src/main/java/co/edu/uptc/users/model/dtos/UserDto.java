package co.edu.uptc.users.model.dtos;


import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@JsonNaming
@Validated
public class UserDto {
	
	@JsonAlias("first_name")
	@NotNull(message = "The field first_name must not be null")
	private String firstName;
	
	
	@JsonAlias("last_name")
	@NotNull(message = "The field last_name must not be null")
	private String lastName;
	
	@JsonAlias("user_name")
	@NotNull(message = "The field user_name must not be null")
	private String userName;
	
	@JsonAlias("password")
	@NotNull(message = "The field password must not be null")
	private String password;
	
	@JsonAlias("email")
	@NotNull(message = "The field email must not be null")
	@Email(message = "The field email must be a email format (name.firstname@domine.com)")
	private String email;
	
	@JsonAlias("role_name")
	@NotNull(message = "The field role_name must not be null")
	private String roleName;
	
	public UserDto() {
		super();
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, password, roleName, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(roleName, other.roleName) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", roleName=" + roleName + "]";
	}
}
