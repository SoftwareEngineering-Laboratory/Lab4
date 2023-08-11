package codeGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohammad hosein on 6/28/2015.
 */

public class Address {
    public int num;
    public TypeAddress Type;
    public varType varType;
    private Map<TypeAddress, String> typeToString;

    public Address(int num, varType varType, TypeAddress Type) {
        this.num = num;
        this.Type = Type;
        this.varType = varType;

        this.generateTypeToStringMap();
    }

    private void generateTypeToStringMap() {
        typeToString = new HashMap<>();
        typeToString.put(TypeAddress.Direct, String.valueOf(this.num));
        typeToString.put(TypeAddress.Indirect, "@" + this.num);
        typeToString.put(TypeAddress.Imidiate, "#" + this.num);
    }

    private Map<TypeAddress, String> getTypeToStringMap() {
        return this.typeToString;
    }

    public Address(int num, varType varType) {
        this.num = num;
        this.Type = TypeAddress.Direct;
        this.varType = varType;

        this.generateTypeToStringMap();
    }

    public String toString() {
        return this.getTypeToStringMap().get(this.Type);
    }
}
