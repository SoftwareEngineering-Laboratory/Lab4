package codeGenerator;

import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference;
import scanner.token.Token;

import java.util.HashMap;
import java.util.Map;

public class CodeGeneratorFacade {

    private CodeGenerator cg;
    private Map<String, Address> keyWords;

    private Memory memory;
    public CodeGeneratorFacade(){
        this.keyWords = new HashMap<>();
        this.keyWords.put("true", new Address(1, varType.Bool, TypeAddress.Imidiate));
        this.keyWords.put("false", new Address(0, varType.Bool, TypeAddress.Imidiate));

    }

    public void createCodeGenerator(){
        this.cg = new CodeGenerator();
    };
    public void semanticFunction(int func, Token next) {
        this.cg.semanticFunction(func, next);
    }

    public void printMemory(){
        this.cg.printMemory();
    }


    public Address getFromKeyWords(String keywordName) {
        return this.keyWords.get(keywordName);
    }

    public void setMemory(Memory memory){
        this.memory = memory;
    }

    public int getDateAddressMemory() {
        return this.memory.getDateAddress();
    }
}
