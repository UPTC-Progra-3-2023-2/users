package co.edu.uptc.users.model.dtos;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotNull;

@JsonNaming
public class RolesDto {
	@JsonAlias("role_name")
	@NotNull(message = "the field role_name must not be null")
	private String roleName;
	
	public RolesDto() {
		super();
	}

	public RolesDto(@NotNull(message = "the field role_name must not be null") String roleName) {
		super();
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolesDto other = (RolesDto) obj;
		return Objects.equals(roleName, other.roleName);
	}

	@Override
	public String toString() {
		return "RolesDto [roleName=" + roleName + "]";
	}
}
