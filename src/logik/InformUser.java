package logik;

public class InformUser {
    private static String LOGIN_USER;
    private static String PASSWORD;
    private static String COUNT_FREE_TOKENS;

    public static String getLoginUser() {
        return LOGIN_USER;
    }

    public static void setLoginUser(String loginUser) {
        LOGIN_USER = loginUser;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        InformUser.PASSWORD = PASSWORD;
    }

    public static String getCountFreeTokens() {
        return COUNT_FREE_TOKENS;
    }

    public static void setCountFreeTokens(String countFreeTokens) {
        COUNT_FREE_TOKENS = countFreeTokens;
    }
}
