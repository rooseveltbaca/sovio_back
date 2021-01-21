package io.vimero.sovio.type;

public enum TestType {
    INSTRUCCION(1), TEST (2), PRACTICE(3);

    private final int value;

    TestType(int value) {
        this.value = value;
    }

    public static TestType findByValue(int value){
        for( TestType type : TestType.values() ){
            if(  type.value == value ){
                return type;
            }
        }
        return null;
    }

}
