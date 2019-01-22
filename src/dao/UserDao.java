package dao;

import pojo.User;

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
		Object[] all = null;
		String sql = "select * from user where sno = ? and password = ?";
		Object[] values = new Object[]{user.getSno(),user.getPassword()};
		all = super.find(sql, values);
		if(all ==null){
			return null;
		}
		User newuser = new User();
		newuser.setSno(user.getSno());
		newuser.setPassword(user.getPassword());
		if(all[0] != null)
			newuser.setSno(Integer.parseInt(String.valueOf(all[0])));
		if(all[2] != null)
			newuser.setName(String.valueOf(all[2]));
		if(all[3] != null)
			newuser.setSex(String.valueOf(all[3]));
		if(all[4] != null)
			newuser.setAge(Integer.parseInt(all[4].toString()));
		if(all[5] != null)
			newuser.setCollege(String.valueOf(all[5]));
		if(all[6] != null)
			newuser.setSenior(String.valueOf(all[6]));
		if(all[7] != null)
			newuser.setHobby(String.valueOf(all[7]));
		if(all[8] != null)
			newuser.setCharacter(String.valueOf(all[8]));
		if(all[9] != null)
			newuser.setBackground_url(String.valueOf(all[9]));
		if(all[10] != null)
			newuser.setPhoto_url(String.valueOf(all[10]));
		if(all[11] != null)
			newuser.setTsflag(Integer.parseInt(all[11].toString()));
		if(all[12] != null)
			newuser.setTel(String.valueOf(all[12]));
		return newuser;
	}
}
