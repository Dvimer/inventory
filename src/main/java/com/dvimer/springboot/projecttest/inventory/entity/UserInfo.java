package com.dvimer.springboot.projecttest.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	@Column(name = "enabled")
	private short enabled;

	public static long getSerialVersionUID()
	{
		return serialVersionUID;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public short getEnabled()
	{
		return enabled;
	}

	public void setEnabled(short enabled)
	{
		this.enabled = enabled;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("UserInfo{");
		sb.append("userName='").append(userName).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", role='").append(role).append('\'');
		sb.append(", enabled=").append(enabled);
		sb.append('}');
		return sb.toString();
	}
}
