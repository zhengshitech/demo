package tech.zhengshi.webapi.dto;

import java.io.Serializable;

/**
 * @author H
 */
public class Hello implements Serializable {
    private static final long serialVersionUID = -956715839422099871L;

    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Hello() {
    }

    public Hello(String word) {
        this.word = word;
    }
}
