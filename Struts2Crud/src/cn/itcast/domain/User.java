package cn.itcast.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;





import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.util.WebUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport implements Serializable {
	
	private String id;//主键
	private String username;//登录名
	private String nick;//昵称
	private String password;//MD5加密
	private String sex;//0 女 1男
	private Date birthday;//出生日期2010-10-09
	private String education;//学历：研究生   本科 专科 高中 中专 幼儿园
	private String telephone;//电话
	private String[] hobbies;//特殊。   体育 游泳
	private String hobby;//体育,游泳
	private String path;//文件保存的路径
	private String filename;//存的文件名   UUID_老文件名
	private String remark;//简介
	
	//文件上传的东东
	private File image;
	private String imageFileName;
	private String imageContentType;
	
	//文件下载
	private InputStream inputStream;
	
	
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	
	@Override
	public String toString() {
		return "User [birthday=" + birthday + ", education=" + education
				+ ", filename=" + filename + ", hobbies="
				+ Arrays.toString(hobbies) + ", hobby=" + hobby + ", id=" + id
				+ ", image=" + image + ", imageContentType=" + imageContentType
				+ ", imageFileName=" + imageFileName + ", nick=" + nick
				+ ", password=" + password + ", path=" + path + ", remark="
				+ remark + ", s=" + s + ", sex=" + sex + ", telephone="
				+ telephone + ", username=" + username + "]";
	}

	private UserService s = new UserServiceImpl();
	public String listUsers(){
		List<User> users = s.findAllUsers();
		ActionContext.getContext().put("users", users);// #users
		return SUCCESS;
	}
	public String editUser(){
		//单独处理hobby
		if(hobbies!=null&&hobbies.length>0){
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<hobbies.length;i++){
				if(i>0)
					sb.append(",");
				sb.append(hobbies[i]);
			}
			hobby = sb.toString();
		}
		
		//单独处理path和filename
		filename = UUID.randomUUID().toString()+"_"+imageFileName;
		//得到files存放目录的真实路径
		String storePath = ServletActionContext.getServletContext().getRealPath("/files");
		//计算存放的子路径
		path = WebUtil.makeDirs(storePath,filename);
		
		
		//文件上传
		
		try {
			FileUtils.copyFile(image, new File(storePath+"\\"+path+"\\"+filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		s.updateUser(this);
		ActionContext.getContext().put("message", "修改成功！");
		return "editOk";
	}
	public String addUser(){
		System.out.println(this);
		//单独处理hobby
		if(hobbies!=null&&hobbies.length>0){
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<hobbies.length;i++){
				if(i>0)
					sb.append(",");
				sb.append(hobbies[i]);
			}
			hobby = sb.toString();
		}
		
		//单独处理path和filename
		filename = UUID.randomUUID().toString()+"_"+imageFileName;
		//得到files存放目录的真实路径
		String storePath = ServletActionContext.getServletContext().getRealPath("/files");
		//计算存放的子路径
		path = WebUtil.makeDirs(storePath,filename);
		
		
		//文件上传
		
		try {
			FileUtils.copyFile(image, new File(storePath+"\\"+path+"\\"+filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		s.addUser(this);
		ActionContext.getContext().put("message", "保存成功！");
		return "saveOk";
	}
	public String queryCondition(){
		List<User> users =s.findUserByCondition(this);
		ActionContext.getContext().put("users", users);// #users
		return SUCCESS;
	}
	public String delUser(){
		String userId = ServletActionContext.getRequest().getParameter("userId");
		s.delUser(userId);
		return "delOk";
	}
	public String editUserUI(){
		String userId = ServletActionContext.getRequest().getParameter("userId");
		User user = s.findUserById(userId);
		user.setHobbies(user.getHobby().split(","));
		System.out.println(user.getHobby());
		ActionContext.getContext().put("user", user);
		return "editUI";
	}
	public String showUser(){
		String userId = ServletActionContext.getRequest().getParameter("userId");
		User user = s.findUserById(userId);
		ActionContext.getContext().put("user", user);
		return "showUser";
	}
	public String download(){
		path = ServletActionContext.getRequest().getParameter("path");
		filename = ServletActionContext.getRequest().getParameter("filename");
		
		String storePath = ServletActionContext.getServletContext().getRealPath("/files");
		
		try {
			inputStream = new FileInputStream(storePath+"\\"+path+"\\"+filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	public String login(){
		User user = s.login(username,password);
		if(user==null){
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return SUCCESS;
		}
	}
}
