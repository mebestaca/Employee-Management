package oldcode;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.regex.Pattern;


public class OldRules {
//	static Rule<String> isInt() {
//	return v -> {
//		try {
//			Integer.parseInt(v);
//			return true;
//		}
//		catch (Exception e) {
//			return false;
//		}
//	};
//}
//
//static Rule<String> isLong() {
//	return v -> {
//		try {
//			Long.parseLong(v);
//			return true;
//		}
//		catch (Exception e) {
//			return false;
//		}
//	};
//}
//
//static Rule<String> isDate(String pattern) {
//    return v -> {
//        SimpleDateFormat format = new SimpleDateFormat(pattern);
//        
//        format.setLenient(false); 
//        
//        try {
//            format.parse(v);
//            return true;
//        } catch (ParseException e) {
//            return false;
//        }
//    };
//}
//
//static Rule<String> isEmail() {
//    return v -> {
//        if (v == null) return false;
//        
//        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$";
//        Pattern pattern = Pattern.compile(emailRegex);
//        
//        return pattern.matcher(v).matches();
//    };
//}
}
