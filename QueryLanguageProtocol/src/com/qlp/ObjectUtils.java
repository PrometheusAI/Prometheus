package com.qlp;

public final class ObjectUtils {

	public static boolean isByte(String in) {
		try {
			Byte.parseByte(in);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isShort(String in) {
		try {
			Short.parseShort(in);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isInteger(String in) {
		try {
			Integer.parseInt(in);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isLong(String in) {
		try {
			Long.parseLong(in);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isFloat(String in) {
		try {
			Float.parseFloat(in);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isDouble(String in) {
		try {
			Double.parseDouble(in);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isBoolean(String in) {
		return ("true".equalsIgnoreCase(in) || "false".equalsIgnoreCase(in));
	}

	public static boolean isChar(String in) {
		return in.length() == 1;
	}

}