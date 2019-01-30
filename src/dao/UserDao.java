package dao;

import pojo.User;

import java.util.Map;

public class UserDao extends AbstractDao{
	
	private static UserDao userDao;
	public static UserDao instance() {
		if (userDao == null)
			userDao = new UserDao();
		return userDao;
	}
	

	public Integer insertUser(User user){
		String sql = "insert into user(sno,password) values(?,?)";
		Object[] values = new Object[]{user.getSno(),user.getPassword()};
		return super.update(sql, values);
	}
	
	public User findUser(User user){
		Map<String,String> all = null;
		String sql = "select * from user where sno = ? and password = ?";
		Object[] values = new Object[]{user.getSno(),user.getPassword()};
		all = super.find(sql, values);
		if(all ==null){
			return null;
		}
		User newuser = new User();
		newuser.setSno(user.getSno());
		newuser.setPassword(user.getPassword());
		newuser.setParameters(all);
		return newuser;
	}
}
