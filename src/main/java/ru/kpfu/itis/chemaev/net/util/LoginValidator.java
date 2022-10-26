package ru.kpfu.itis.chemaev.net.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator {

    /**
     * ^(?=.{4,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$
     *  └─────┬────┘└───┬──┘└─────┬─────┘└─────┬─────┘ └───┬───┘
     *        │         │         │            │           no _ or . at the end
     *        │         │         │            │
     *        │         │         │            allowed characters
     *        │         │         │
     *        │         │         no __ or _. or ._ or .. inside
     *        │         │
     *        │         no _ or . at the beginning
     *        │
     *        username is 4-20 characters long
     */

    private static final String LOGIN_PATTERN =
            "^(?=.{4,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    private static final Pattern pattern = Pattern.compile(LOGIN_PATTERN);

    public static boolean isValid(final String login) {
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }
}
