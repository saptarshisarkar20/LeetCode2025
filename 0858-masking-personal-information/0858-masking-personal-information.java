class Solution {

    private boolean isMail(String s) {
        return s.contains("@");
    }

    private String maskMail(String s) {
        int x = s.indexOf('@') - 1;
        return Character.toLowerCase(s.charAt(0))
                + "*****" + Character.toLowerCase(s.charAt(x))
                + s.substring(x + 1).toLowerCase();
    }

    private String maskPhoneNo(String s) {
        int digiCnt = 0;
        StringBuilder sb = new StringBuilder();
        String cc1 = "+*-", cc2 = "+**-", cc3 = "+***-";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
                digiCnt++;
            }
        }
        int ccCnt = digiCnt - 10;
        String ccMask = "";
        switch (ccCnt) {
            case 3:
                ccMask = cc3;
                break;
            case 2:
                ccMask = cc2;
                break;
            case 1:
                ccMask = cc1;
                break;
            default:
                break;
        }

        return ccMask + "***-***-" + sb.substring(sb.length()-4);

    }


    public String maskPII(String s) {
        if (isMail(s)) return maskMail(s);
        return maskPhoneNo(s);
    }
}