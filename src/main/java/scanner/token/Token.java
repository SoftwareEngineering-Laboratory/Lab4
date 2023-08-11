package scanner.token;

import scanner.type.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token {
    public Type type;
    public String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", type.name(), value);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Token) {
            Token temp = (Token) o;
            if (temp.type == this.type) {
                return this.type != Type.KEYWORDS || this.value.equals(temp.value);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        if (type == Type.KEYWORDS) return prime * type.hashCode() + (value == null ? 0 : value.hashCode());
        return type.hashCode();
    }

    public static Type getTyepFormString(String s) {
        Pattern pattern;
        Matcher matcher;
        for (Type t : Type.values()) {
            if (t.toString().equals(s)) return t;
        }
        for (Type t : Type.values()) {
            pattern = Pattern.compile(t.pattern);
            matcher = pattern.matcher(s);
            if (matcher.matches()) return t;
        }
        throw new IllegalArgumentException();
    }
}
