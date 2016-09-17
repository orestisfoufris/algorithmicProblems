package com.topcoder.div2.levelOne;

public class Initials {

    public String getInitials(String name) {
        String[] s = name.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length; ++i) {
            sb.append(s[i].charAt(0));
        }

        return sb.toString();
    }

}
