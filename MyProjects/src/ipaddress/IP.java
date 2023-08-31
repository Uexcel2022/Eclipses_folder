package ipaddress;

//import java.util.Arrays;

//import java.util.Arrays;
//System.out.println("Mr Jide said \"Mir Udoka can't help/\\assist himself\"");

public class IP {
	public static void main(String[] args) {

		IP p = new IP();
		p.verifyIPAddress("1.0.12. ");
//		p.verifyIPAddress("121-234_1,2.1*2");
//		p.verifyIPAddress("23.45.12.56");
//		p.verifyIPAddress("00.12.123.123123.123");
//		p.verifyIPAddress("122.23");
//		p.verifyIPAddress("Hello.IP");

	}

	public void verifyIPAddress(String iP) {
		
		String[] validChars = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." };
		
		if (iP.length() > 15 || iP.startsWith(".") || iP.endsWith(".")) {
			System.out.println("false");
			return;
		} else {
			char[] iPCharArray = iP.toCharArray();
			String[] iPCharInValidiChars = new String[iPCharArray.length];
			String[] iPCharNotInValidChars = new String[iPCharArray.length];
			for (int i = 0; i < iPCharArray.length; i++) {
				for (int j = 0; j < validChars.length; j++) {
					if (String.valueOf(iPCharArray[i]).equalsIgnoreCase(String.valueOf(validChars[j]))) {
						iPCharInValidiChars[i] = String.valueOf(iP.charAt(i));
					} else {
						iPCharNotInValidChars[i] = String.valueOf(iP.charAt(i));
					}
				}
			}
//			System.out.println(Arrays.toString(iPCharInValidiChars));
//			System.out.println(Arrays.toString(iPCharNotInValidChars));
			String inValidIPChars = "";
			for (int i = 0; i < iPCharNotInValidChars.length; i++) {
				if (iPCharInValidiChars[i] == null) {
					inValidIPChars += iPCharNotInValidChars[i] + ' ';
				}
			}
			if (inValidIPChars.length() > 0) {
				System.out.println("false");
				System.err.println("Invalid IP address character(s): " + inValidIPChars);
				return;
			}

			boolean notInRange = false;
			String[] splitedIP = iP.split("\\.");
			if (splitedIP.length != 4) {
				System.out.println("false");
			} else {
				for (int i = 0; i < splitedIP.length; i++) {
					if (Integer.parseInt(splitedIP[i]) > 255 || splitedIP[i].length() > 3) {
						notInRange = true;
						break;
					}
				}
				if (notInRange) {
					System.out.println("false");
				} else
					System.out.println("true");
			}
		}

	}

}
