package at.fh.valuvi.resifo.helpers;

import java.security.MessageDigest;

public class SecurityHelper {

    public static String md5(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        } catch (Exception e) { System.out.println(e); }

        return "";
    }

}
