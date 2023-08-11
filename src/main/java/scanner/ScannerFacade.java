package scanner;

import scanner.token.Token;

import java.util.Scanner;

public class ScannerFacade {

    private LexicalAnalyzer lexicalAnalyzer;
    public void createLexicalAnalyzer(Scanner sc) {
        this.lexicalAnalyzer = new LexicalAnalyzer(sc);
    }

    public Token getNextTokenFromAnalyzer() {
        return this.lexicalAnalyzer.getNextToken();
    }

    public Token getNewToken(String col) {
        return new Token(Token.getTyepFormString(col), col);
    }
}
