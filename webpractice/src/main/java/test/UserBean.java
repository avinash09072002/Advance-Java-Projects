package test;
import java.io.*;

@SuppressWarnings("serial")
public class UserBean implements Serializable {
	
	private String uName,pWord,fName,lName,add;
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getpWord() {
		return pWord;
	}
	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public long getPhNO() {
		return phNO;
	}
	public void setPhNO(long phNO) {
		this.phNO = phNO;
	}
	private long phNO;

}
