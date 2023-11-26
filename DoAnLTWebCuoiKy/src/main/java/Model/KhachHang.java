package Model;

public class KhachHang {
		String userName;
		String password;
		String name;
		public KhachHang(String userName, String password, String name) {
			super();
			this.userName = userName;
			this.password = password;
			this.name = name;
		}
		
		public KhachHang() {
			super();
		}

		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return password;
		}
		public void setPassWord(String passwprd) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "KhachHang [userName=" + userName + ", pass=" + password + ", name=" + name + "]";
		}
		
}
