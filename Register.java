package hardware;

public class Register {
    private final byte REG_COUNT = 5;

    private byte registerGH;
    private byte registerDA;

    private byte[] registersMemory;

    public Register() {
        registersMemory = new byte[REG_COUNT];
    }

    public byte getRegisterValue(int index) {
        return registersMemory[index];
    }

    public void setRegisterValue(int index, byte value) {
        registersMemory[index] = value;
    }

    public void defaultIncGH() {
        registerGH += 3;
    }

    public void setGH(byte numberLine) {
        registerGH = numberLine;
    }

    public byte getRegisterGH() {
        return registerGH;
    }

    void setZF(byte value) {
        if (value == 1) {
            registerDA |= 1;
        } else {
            registerDA &= 0xFE;
        }
    }

    void setSF(byte value) {
        if (value == 1) {
            registerDA |= 2;
        } else {
            registerDA &= 0xFD;
        }
    }

    void setOF(byte value) {
        if (value == 1) {
            registerDA |= 4;
        } else {
            registerDA &= 0xFB;
        }
    }

    public byte getZF() {
        return (byte) (registerDA & 1);
    }

    public byte getSF() {
        return (byte) ((registerDA >> 1) & 1);
    }

    public byte getOF() {
        return (byte) ((registerDA >> 2) & 1);
    }

    public void dump_register() {
        for (byte b : registersMemory) {
            System.out.println(b);
        }
    }
}
